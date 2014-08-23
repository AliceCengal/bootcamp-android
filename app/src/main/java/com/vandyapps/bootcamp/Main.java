package com.vandyapps.bootcamp;

import android.os.Bundle;
import roboguice.activity.RoboActivity;

public class Main extends RoboActivity {

    @Override
    protected void onCreate(Bundle saved) {
        super.onCreate(saved);
        setContentView(R.layout.activity_main);
    }

}
