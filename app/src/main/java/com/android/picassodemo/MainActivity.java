package com.android.picassodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ImageView myImage,sameImage,scaleImage,fitImage,stateImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myImage=(ImageView)findViewById(R.id.myImage_iv);
        sameImage=(ImageView)findViewById(R.id.sameImage_iv);
       scaleImage=(ImageView)findViewById(R.id.scaleImage_iv);
        fitImage=(ImageView)findViewById(R.id.fitImage_iv);
        stateImage=(ImageView)findViewById(R.id.stateImage_iv);
        LoadImage();
        LoadSameImage();
        //LoadScaleDownImage();
        LoadFitImage();
        LoadStateImage();
    }
    // centerCrop
    public void LoadImage(){
        Picasso.with(this)
                .load(R.drawable.header)
                .into(myImage);
    }

    //centerInside
    public void LoadSameImage(){
        Picasso.with(this)
                .load(R.drawable.header)
                .into(sameImage);
    }

    //ScaleDown
    public void LoadScaleDownImage(){
        Picasso.with(this)
                .load(R.drawable.header)
                .resize(2000,2000)
                .onlyScaleDown()
                .into(scaleImage);
    }

    //fit
    public void LoadFitImage(){
        Picasso.with(this)
                .load(R.drawable.header)
                .fit()
                .into(fitImage);
    }

    //setIndicatorsEnabled
    public void LoadStateImage(){
        Picasso.with(this)
                .setIndicatorsEnabled(true);
        LoadImageFrom();
    }

    public void LoadImageFrom(){
        Picasso.with(this)
        .load(R.drawable.header)
        .fetch(new Callback() {
            @Override
            public void onSuccess() {
                Picasso.with(getApplicationContext())
                        .load(R.drawable.header)
                        .into(stateImage);
            }

            @Override
            public void onError() {

            }
        });
    }
}
