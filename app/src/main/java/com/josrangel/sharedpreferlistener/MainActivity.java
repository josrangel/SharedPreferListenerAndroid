package com.josrangel.sharedpreferlistener;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    CheckBox checkBoxFacebook, checkBoxTwitter, checkBoxInstagram;
    SharedPreferences sp;
    ImageView imageFacebook, imageTwitter, imageInstagram;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageFacebook = findViewById(R.id.imageFacebook);
        imageTwitter = findViewById(R.id.imageTwitter);
        imageInstagram = findViewById(R.id.imageInstagram);

        sp = getSharedPreferences("appSharedPref",MODE_PRIVATE);

        sp.registerOnSharedPreferenceChangeListener(this);
        checkBoxFacebook = findViewById(R.id.cbFacebook);
        checkBoxTwitter = findViewById(R.id.cBTwitter);
        checkBoxInstagram = findViewById(R.id.cBInstagram);

        checkBoxFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBoxFacebook.isChecked()){
                    sp.edit().putBoolean("f",true).apply();
                }else{
                    sp.edit().putBoolean("f",false).apply();
                }
            }
        });

        checkBoxTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBoxTwitter.isChecked()){
                    sp.edit().putBoolean("t",true).apply();
                }else{
                    sp.edit().putBoolean("t",false).apply();
                }
            }
        });

        checkBoxInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBoxInstagram.isChecked()){
                    sp.edit().putBoolean("i",true).apply();
                }else{
                    sp.edit().putBoolean("i",false).apply();
                }
            }
        });
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        Log.i("spchange",s);
        if(s.equals("f")){
            if(sharedPreferences.getBoolean("f",false)){
                imageFacebook.setVisibility(View.VISIBLE);
            }else{
                imageFacebook.setVisibility(View.INVISIBLE);
            }

        }

        if(s.equals("t")){
            if(sharedPreferences.getBoolean("t",false)){
                imageTwitter.setVisibility(View.VISIBLE);

            }else{
                imageTwitter.setVisibility(View.INVISIBLE);
            }
        }

        if(s.equals("i")){
            if(sharedPreferences.getBoolean("i",false)){
                imageInstagram.setVisibility(View.VISIBLE);
            }else{
                imageInstagram.setVisibility(View.INVISIBLE);
            }
        }
    }
}