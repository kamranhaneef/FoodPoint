package com.example.pilot;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.navigation_recipe:
                {
                    Intent intent = new Intent(MainActivity.this, recipe.class);
                    startActivity(intent);
                    //mTextMessage.setText(R.string.title_recipe);

                    return true;
                }

                case R.id.navigation_notifications:
                {
                    Intent intent = new Intent(MainActivity.this, notification.class);
                    startActivity(intent);
                    //mTextMessage.setText(R.string.title_notifications);
                    return true;
                }
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //GridView defined here...

        GridView gridView = findViewById(R.id.grid_view);

        // Instance of ImageAdapter Class
        gridView.setAdapter(new ImageAdapter(this));


        //This is full image activity
        gridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                // Sending image id to FullScreenActivity
                Intent i = new Intent(getApplicationContext(), FullImageActivity.class);
                // passing array index
                i.putExtra("id", position);
                startActivity(i);
            }
        });
        //Grid view stuff ends here

    }
}
