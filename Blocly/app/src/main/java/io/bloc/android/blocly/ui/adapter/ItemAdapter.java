package io.bloc.android.blocly.ui.adapter;

        import android.animation.ValueAnimator;
        import android.graphics.Bitmap;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.view.animation.AccelerateDecelerateInterpolator;
        import android.widget.CheckBox;
        import android.widget.CompoundButton;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.nostra13.universalimageloader.core.ImageLoader;
        import com.nostra13.universalimageloader.core.assist.FailReason;
        import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

        import java.lang.ref.WeakReference;

        import io.bloc.android.blocly.BloclyApplication;
        import io.bloc.android.blocly.R;
        import io.bloc.android.blocly.api.DataSource;
        import io.bloc.android.blocly.api.model.RssFeed;
        import io.bloc.android.blocly.api.model.RssItem;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemAdapterViewHolder> {

    private static String TAG = ItemAdapter.class.getSimpleName();

    public static interface ItemAdapterDelegate {
        public void didAnimateRssItem(ItemAdapter adapter, RssItem rssItem, boolean animateItem);
        public void didVisitSite(ItemAdapter adapter, RssItem rssItem);
        public void didFavoriteItem(ItemAdapter adapter, CheckBox checkbox);
        public void didArchiveItem(ItemAdapter adapter, CheckBox checkbox);
    }

    WeakReference<ItemAdapterDelegate> delegate;


    @Override
    public ItemAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int index) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rss_item, viewGroup, false);
        return new ItemAdapterViewHolder(inflate);
    }


    @Override
    public void onBindViewHolder(ItemAdapterViewHolder itemAdapterViewHolder, int index) {
        DataSource sharedDataSource = BloclyApplication.getSharedDataSource();
        itemAdapterViewHolder.update(sharedDataSource.getFeeds().get(0), sharedDataSource.getItems().get(index));
    }


    @Override
    public int getItemCount() {
        return BloclyApplication.getSharedDataSource().getItems().size();
    }

    public ItemAdapterDelegate getDelegate() {
        if (delegate == null) {
            return null;
        }
        return delegate.get();
    }

    public void setDelegate(ItemAdapterDelegate delegate) {
        this.delegate = new WeakReference<ItemAdapterDelegate>(delegate);
    }


    public class ItemAdapterViewHolder extends RecyclerView.ViewHolder implements ImageLoadingListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
        boolean contentExpanded;
        TextView title;
        TextView feed;
        TextView content;
        View headerWrapper;
        ImageView headerImage;
        CheckBox archiveCheckbox;
        CheckBox favoriteCheckbox;
        View expandedContentWrapper;
        TextView expandedContent;
        TextView visitSite;

        RssItem rssItem;

        public ItemAdapterViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.tv_rss_item_title);
            feed = (TextView) itemView.findViewById(R.id.tv_rss_item_feed_title);
            content = (TextView) itemView.findViewById(R.id.tv_rss_item_content);
            // #7
            headerWrapper = itemView.findViewById(R.id.fl_rss_item_image_header);
            headerImage = (ImageView) headerWrapper.findViewById(R.id.iv_rss_item_image);
            archiveCheckbox = (CheckBox) itemView.findViewById(R.id.cb_rss_item_check_mark);
            favoriteCheckbox = (CheckBox) itemView.findViewById(R.id.cb_rss_item_favorite_star);

            expandedContentWrapper = itemView.findViewById(R.id.ll_rss_item_expanded_content_wrapper);
            expandedContent = (TextView) expandedContentWrapper.findViewById(R.id.tv_rss_item_content_full);
            visitSite = (TextView) expandedContentWrapper.findViewById(R.id.tv_rss_item_visit_site);

            itemView.setOnClickListener(this);
            visitSite.setOnClickListener(this);

            archiveCheckbox.setOnCheckedChangeListener(this);
            favoriteCheckbox.setOnCheckedChangeListener(this);


        }

        void update(RssFeed rssFeed, RssItem rssItem) {
            this.rssItem = rssItem;
            feed.setText(rssFeed.getTitle());
            title.setText(rssItem.getTitle());
            content.setText(rssItem.getDescription());
            expandedContent.setText(rssItem.getDescription());


            if (rssItem.getImageUrl() != null) {

                headerWrapper.setVisibility(View.VISIBLE);
                headerImage.setVisibility(View.INVISIBLE);
                //ImageLoader.getInstance().loadImage(imageURL, this);
                ImageLoader.getInstance().loadImage(rssItem.getImageUrl(), this);
            } else {

                headerWrapper.setVisibility(View.GONE);
            }
        }



        @Override
        public void onLoadingStarted(String imageUri, View view) {

        }

        @Override
        public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
            Log.e(TAG, "onLoadingFailed: " + failReason.toString() + " for URL: " + imageUri);
        }

        @Override
        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {



            if (imageUri.equals(rssItem.getImageUrl())) {
                headerImage.setImageBitmap(loadedImage);
                headerImage.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onLoadingCancelled(String imageUri, View view) {

            ImageLoader.getInstance().loadImage(imageUri, this);
        }


        @Override
        public void onClick(View view) {
            if (view == itemView) {
                animateContent(!contentExpanded);
            } else {
                getDelegate().didVisitSite(ItemAdapter.this, rssItem);
            }



        }



        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            if (getDelegate() == null) {
                return;
            } else {
                getDelegate().didFavoriteItem(ItemAdapter.this, favoriteCheckbox);
                getDelegate().didArchiveItem(ItemAdapter.this, archiveCheckbox);
            }

        }


        public void animateContent(final boolean expand) {
            if (getDelegate() == null) {
                return;
            } else {
                getDelegate().didAnimateRssItem(ItemAdapter.this, rssItem, contentExpanded );
            }
            if((expand && contentExpanded) || (!expand && !contentExpanded)) {
                return;
            }


            int startingHeight = expandedContentWrapper.getMeasuredHeight();
            int finalHeight = content.getMeasuredHeight();
            if (expand) {

                startingHeight = finalHeight;
                expandedContentWrapper.setAlpha(0f);
                expandedContentWrapper.setVisibility(View.VISIBLE);

                expandedContentWrapper.measure(
                        View.MeasureSpec.makeMeasureSpec(content.getWidth(), View.MeasureSpec.EXACTLY),
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                finalHeight = expandedContentWrapper.getMeasuredHeight();
            } else {
                content.setVisibility(View.VISIBLE);
            }
            startAnimator(startingHeight, finalHeight, new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {

                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    float wrapperAlpha = expand ? animatedFraction : 1f - animatedFraction;
                    float contentAlpha = 1f - wrapperAlpha;

                    expandedContentWrapper.setAlpha(wrapperAlpha);
                    content.setAlpha(contentAlpha);

                    expandedContentWrapper.getLayoutParams().height = animatedFraction == 1f ?
                            ViewGroup.LayoutParams.WRAP_CONTENT :
                            (Integer) valueAnimator.getAnimatedValue();


                    expandedContentWrapper.requestLayout();
                    if (animatedFraction == 1f) {
                        if (expand) {
                            content.setVisibility(View.GONE);
                        } else {
                            expandedContentWrapper.setVisibility(View.GONE);
                        }
                    }
                }
            });
            contentExpanded = expand;
        }


        private void startAnimator(int start, int end, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            ValueAnimator valueAnimator = ValueAnimator.ofInt(start, end);
            valueAnimator.addUpdateListener(animatorUpdateListener);

            valueAnimator.setDuration(itemView.getResources().getInteger(android.R.integer.config_mediumAnimTime));

            valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
            valueAnimator.start();
        }

    }
}
