package com.vandyapps.bootcamp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

public class Main extends RoboActivity {

    @InjectView(R.id.textView) TextView textView;
    @InjectView(R.id.button) Button button;

    @Override
    protected void onCreate(Bundle saved) {
        super.onCreate(saved);
        setContentView(R.layout.activity_main);

        textView.setText("Right");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView.getText().equals("Right")) {
                    textView.setText("Left");
                } else {
                    textView.setText("Right");
                }
            }
        });
    }

}
