package com.example.pilot;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;

public class FullImageActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_image);

        // get intent data
        Intent i = getIntent();

        // Selected image id
        int position = i.getExtras().getInt("id");
        ImageAdapter imageAdapter = new ImageAdapter(this);

        ImageView imageView = (ImageView) findViewById(R.id.full_image_view);

        //Following line of code was overwritten by line below...
        imageView.setImageResource(R.drawable.recipe_card);
        //imageView.setImageResource(imageAdapter.mThumbIds[position]);  //Commented this to override the automatic system to the manual override since there are'nt any data at the moment....

    }

}