package com.cerezaconsulting.tasktimerexample;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by junior on 23/06/17.
 */

public class TimerService extends Service {


    @Subscribe
    public void onMessageEvent(EventMessage eventMessage) {

    }


    Handler mHandler = new Handler();
    ;
    Runnable runnable = new Runnable() {
        @Override
        public void run() {

            EventBus.getDefault().post(new EventMessage(1));
            mHandler.postDelayed(this, 1000);
        }
    };


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        EventBus.getDefault().register(this);


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        runnable.run();

        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(this);
        mHandler.removeCallbacks(runnable);

    }
}
