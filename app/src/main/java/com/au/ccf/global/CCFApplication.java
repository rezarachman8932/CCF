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
    private List<String> mJobTypeList;
    private List<String> mEquipmentTypeList;

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

        if (mRoleList.size() > 0) {
            mRoleList.clear();
        }

        mRoleList.add(getResources().getString(R.string.item_role_provider));
        mRoleList.add(getResources().getString(R.string.item_role_member));

        return mRoleList;
    }

    public List<String> getJobTypeList() {
        if (mJobTypeList == null) {
            mJobTypeList = new ArrayList<>();
        }

        if (mJobTypeList.size() > 0) {
            mJobTypeList.clear();
        }

        mJobTypeList.add(getResources().getString(R.string.list_job_type_plant_hire));
        mJobTypeList.add(getResources().getString(R.string.list_job_type_civil_sub_contracting));
        mJobTypeList.add(getResources().getString(R.string.list_job_type_civil_material));
        mJobTypeList.add(getResources().getString(R.string.list_job_type_civil_employ));
        mJobTypeList.add(getResources().getString(R.string.list_job_type_fill_exchange));

        return mJobTypeList;
    }

    public List<String> getEquipmentTypeList() {
        if (mEquipmentTypeList == null) {
            mEquipmentTypeList = new ArrayList<>();
        }

        if (mEquipmentTypeList.size() > 0) {
            mEquipmentTypeList.clear();
        }

        mEquipmentTypeList.add(getResources().getString(R.string.list_equipment_type_excavators));
        mEquipmentTypeList.add(getResources().getString(R.string.list_equipment_type_backhoe_loaders));
        mEquipmentTypeList.add(getResources().getString(R.string.list_job_type_skid_steer_loaders));
        mEquipmentTypeList.add(getResources().getString(R.string.list_job_type_graders));
        mEquipmentTypeList.add(getResources().getString(R.string.list_job_type_bulldozers));

        return mEquipmentTypeList;
    }

}
