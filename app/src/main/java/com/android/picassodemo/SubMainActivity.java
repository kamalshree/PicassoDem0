package com.android.picassodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class SubMainActivity extends AppCompatActivity {

    ImageView myImage,sameImage,scaleImage,fitImage,stateImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_main);
        myImage=(ImageView)findViewById(R.id.myImage_iv);

        LoadImage();

    }
    // centerCrop
    public void LoadImage(){
        Picasso.with(this)
                .load("https://www.google.com/images/branding/googlelogo/2x/googlelogo_272x92dp.png")
               // .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(myImage);
    }

}
