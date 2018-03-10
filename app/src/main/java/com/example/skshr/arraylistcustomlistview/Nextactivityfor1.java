package com.example.skshr.arraylistcustomlistview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by skshr on 04-02-2018.
 */

public class Nextactivityfor1 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nextactivityfor1);
        String name = getIntent().getStringExtra("firstname");
    }
}
