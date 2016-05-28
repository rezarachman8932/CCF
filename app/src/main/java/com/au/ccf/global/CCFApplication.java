package com.au.ccf.global;

import android.app.Application;

import com.au.ccf.managers.SharedPreferencesManager;

/**
 * Created by rezarachman8932 on 5/28/16.
 */
public class CCFApplication extends Application {

    private static CCFApplication sInstance;
    private SharedPreferencesManager mSharedPreferencesManager;

    public static CCFApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;
        mSharedPreferencesManager = SharedPreferencesManager.getInstance();
    }

    public SharedPreferencesManager getSharedPreferencesManager() {
        return mSharedPreferencesManager;
    }

}
