package io.bloc.android.blocly.api.model;

import android.test.AndroidTestCase;

/**
 * Created by Zach on 7/15/2015.
 */
public class RssItemTest extends AndroidTestCase {

    public void testRssItem() {

            RssItem zachGrafton = null;
            assertNull(zachGrafton);

            zachGrafton = new RssItem(10000, "zach", "is", "the", "noho", "king", 100000, 1000000, true, true);

            assertNotNull(zachGrafton);
            assertEquals("is", zachGrafton.getTitle());
            assertTrue(zachGrafton.isFavorite());
            assertEquals("zach", zachGrafton.getGuid());
            assertEquals("Guid not set correctly by constructor", 1000, zachGrafton.getRowId());

    }

}
