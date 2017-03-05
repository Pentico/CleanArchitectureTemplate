package com.pencorp.cleanarchitecture.navigation;

/**
 * Created by Tuane on 5/03/17.
 */


import android.content.Context;
import android.content.Intent;

import com.pencorp.cleanarchitecture.view.activity.InfoActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Class used to navigate through the application.
 */
@Singleton
public class Navigator {

    @Inject
    public Navigator() {
        //empty
    }

    public void  navigateToInfo(Context context){
        if(context != null) {
            Intent intentToLaunch = InfoActivity.getCallingIntent(context);
            context.startActivity(intentToLaunch);
        }
    }
}
