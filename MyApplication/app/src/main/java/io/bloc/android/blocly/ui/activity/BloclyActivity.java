package io.bloc.android.blocly.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import io.bloc.android.blocly.R;

/**
 * Created by Zach on 3/3/2015.
 */
public class BloclyActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blocly);
    }
}
