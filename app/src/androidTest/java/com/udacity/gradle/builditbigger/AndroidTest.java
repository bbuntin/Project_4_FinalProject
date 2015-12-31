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
        signal = new CountDownLatch(1);
        context = new MockContext();
        new com.udacity.gradle.builditbigger.EndpointsAsyncTask(this).execute(new Pair<Context, String>(context, "Nothing"));

        try{
            signal.await();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onTaskCompleted(String returnValue) {
        if (returnValue == "" ){
            throw new AssertionError();
        }else{
            Log.e("buntin", returnValue);
            Log.e("buntin", "no errors");
        }
    }
}
