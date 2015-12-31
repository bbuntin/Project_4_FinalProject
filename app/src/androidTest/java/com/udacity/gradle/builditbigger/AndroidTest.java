package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.test.AndroidTestCase;
import android.test.mock.MockContext;
import android.util.Log;
import android.util.Pair;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Bradley on 12/20/15.
 */

public class AndroidTest extends AndroidTestCase implements OnTaskCompleted  {
    Context context;
    private CountDownLatch signal;

    public void testAsyncTask(){
        //assertEquals("hello", "hello");
        signal = new CountDownLatch(1);

        //Log.e("buntin", "really good");
        context = new MockContext();
        new com.udacity.gradle.builditbigger.EndpointsAsyncTask(this).execute(new Pair<Context, String>(context, "Nothing"));

        try{
            signal.await();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        //if (1 ==1 ) throw new AssertionError();
    }

    @Override
    public void onTaskCompleted(String returnValue) {
        Log.e("buntin", returnValue);
        if (returnValue == "" ){
            throw new AssertionError();
        }else{
            Log.e("buntin", "no errors");
        }
    }
}
