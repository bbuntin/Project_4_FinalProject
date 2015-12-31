package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.test.AndroidTestCase;
import android.test.mock.MockContext;
import android.util.Log;
import android.util.Pair;

/**
 * Created by Bradley on 12/20/15.
 */

public class AndroidTest extends AndroidTestCase {
    Context context;
    public void testAsyncTask(){
        //assertEquals("hello", "hello");
        Log.e("buntin", "really good");
        context = new MockContext();
        new com.udacity.gradle.builditbigger.EndpointsAsyncTask().execute(new Pair<Context, String>(context, "Nothing"));
        if (1 ==1 ) throw new AssertionError();
    }
}
