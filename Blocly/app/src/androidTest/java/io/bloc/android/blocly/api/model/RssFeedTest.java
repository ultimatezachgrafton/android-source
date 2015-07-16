package io.bloc.android.blocly.api.model;

import android.test.AndroidTestCase;

/**
 * Created by Zach on 7/15/2015.
 */
public class RssFeedTest extends AndroidTestCase {

    public void testRssFeed() {

        RssFeed antonioCarella = null;
        assertNull(antonioCarella);

        antonioCarella = new RssFeed(10000, "antonio", "is the", "logan square", "king");

        assertNotNull(antonioCarella);
        assertEquals("antonio", antonioCarella.getTitle());

    }


}
