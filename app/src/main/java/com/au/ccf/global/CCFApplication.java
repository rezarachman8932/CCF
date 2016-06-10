package com.au.ccf.global;

import android.app.Application;

import com.au.ccf.R;
import com.au.ccf.managers.SharedPreferencesManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rezarachman8932 on 5/28/16.
 */
public class CCFApplication extends Application {

    private static CCFApplication sInstance;
    private SharedPreferencesManager mSharedPreferencesManager;
    private List<String> mRoleList;

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

    public List<String> getRoleList() {
        if (mRoleList == null) {
            mRoleList = new ArrayList<>();
        }

        mRoleList.add(getResources().getString(R.string.item_role_provider));
        mRoleList.add(getResources().getString(R.string.item_role_member));

        return mRoleList;
    }

}
