package com.example.myservices;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.Nullable;

public class ServiceClass extends Service {

    private static final String TAG = "ServiceClass";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        String currentThead = Thread.currentThread().getName();

        Log.d(TAG, "onBind: " + currentThead);
        return null;
    }

    // activity lifecycle methods
    @Override
    public void onCreate() {
        String currentThead = Thread.currentThread().getName();
        Log.d(TAG, "onCreate: " + currentThead);
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        String currentThead = Thread.currentThread().getName();

        Log.d(TAG, "onDestroy: " + currentThead);
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String currentThead = Thread.currentThread().getName();

        Log.d(TAG, "onStartCommand: " + currentThead);
/*
        try {
             Thread.sleep(10000);

        }catch (InterruptedException e) {
                e.printStackTrace();
        }*/

        // async integration test 1000 miliseconds
        AsyncTaskingClass asyncTaskingClass = new AsyncTaskingClass();
        asyncTaskingClass.execute(10000);
        return super.onStartCommand(intent, flags, startId);
    }


    // others class async  task functionality
    class AsyncTaskingClass extends AsyncTask<Integer,Void,Void> {

        private static final String TAG = "AsyncTaskingClass";
        

        //async task function
        @Override
        protected Void doInBackground(Integer... integers) {
            String currentThead = Thread.currentThread().getName();
            Log.d(TAG, "doInBackground: " + currentThead);

            int sleepTime = integers[0];
            
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            String currentThead = Thread.currentThread().getName();
            Log.d(TAG, "onPostExecute: " + currentThead);
            super.onPostExecute(unused);
        }

        @Override
        protected void onPreExecute() {
            String currentThead = Thread.currentThread().getName();
            Log.d(TAG, "onPreExecute: " + currentThead);
            
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            String currentThead = Thread.currentThread().getName();
            Log.d(TAG, "onProgressUpdate: " + currentThead);
            super.onProgressUpdate(values);
        }

    }


}
