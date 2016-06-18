package com.au.ccf.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by rezarachman on 6/18/16.
 */
public class ActivityUtil {

    public static void startActivity(Activity activity, Class aClass, Bundle bundle, int flag) {
        Intent intent = new Intent(activity, aClass);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (flag != 0) {
            intent.setFlags(flag);
        }
        activity.startActivity(intent);
    }

}
