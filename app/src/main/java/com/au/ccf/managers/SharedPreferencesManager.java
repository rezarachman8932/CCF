package com.au.ccf.managers;

import android.content.Context;

import com.au.ccf.global.CCFApplication;

/**
 * Created by rezarachman8932 on 5/28/16.
 */
public class SharedPreferencesManager {

    private static SharedPreferencesManager sInstance;
    protected Context mContext;

    public static SharedPreferencesManager getInstance() {
        if (sInstance == null) {
            sInstance = new SharedPreferencesManager(CCFApplication.getInstance().getApplicationContext());
        }

        return sInstance;
    }

    private SharedPreferencesManager(Context context) {
        this.mContext = context;
    }

}
