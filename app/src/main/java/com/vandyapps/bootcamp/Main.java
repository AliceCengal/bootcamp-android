package com.vandyapps.bootcamp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

public class Main extends RoboActivity {

    @InjectView(R.id.button) Button button;
    @InjectView(R.id.listView) ListView list;
    @InjectView(R.id.editText) EditText edit;

    List<String> names = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle saved) {
        super.onCreate(saved);
        setContentView(R.layout.activity_main);

        list.setAdapter(ArrayAdapterBuilder
                .fromCollection(names)
                .withContext(this)
                .withStringer(new ArrayAdapterBuilder.ToString<String>() {
                    @Override
                    public String apply(String object) {
                        return object + " (length = " + object.length() + ")";
                    }
                })
                .build());

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                names.remove(position);
                list.invalidateViews();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                names.add(edit.getText().toString());
                list.invalidateViews();
            }
        });
    }

}
