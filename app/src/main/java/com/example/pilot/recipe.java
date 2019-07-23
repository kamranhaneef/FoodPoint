package com.example.pilot;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;


public class recipe extends AppCompatActivity
{

    SwipeRefreshLayout pullToRefresh;
    ArrayList<String> menu;
    ArrayAdapter adapter;
    ImageView imageView;

    private TextView mTextMessage;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item)
        {
            switch (item.getItemId())
            {
                case R.id.navigation_home:
                {
                    Intent intent = new Intent(recipe.this, MainActivity.class);
                    startActivity(intent);
                    mTextMessage.setText(R.string.title_home);
                    return true;
                }

                case R.id.navigation_notifications:
                {
                    Intent intent = new Intent(recipe.this, notification.class);
                    startActivity(intent);
                    mTextMessage.setText(R.string.title_recipe);
                    return true;
                }
            }
            return false;
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //Swipe to refresh taking Id form layout to perform an action...
        pullToRefresh = findViewById(R.id.navigation_recipe);

        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh()
            {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run()
                    {
                        if(pullToRefresh.isRefreshing())
                        {
                            AlertDialog.Builder builder = new AlertDialog.Builder(recipe.this);
                            builder.setTitle("Warning!");
                            builder.setMessage("All unsaved data will be lost. Continue?");
                            builder.setCancelable(false);
                            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(getApplicationContext(), "Recipes updated successfully.", Toast.LENGTH_SHORT).show();
                                }
                            });

                            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(getApplicationContext(), "Recipes not updated.", Toast.LENGTH_SHORT).show();
                                }
                            });

                            builder.show();
                            pullToRefresh.setRefreshing(false);
                        }
                    }
                },1000);
            }
        });

    }



    //On image click listener to redirect to the detail page

        public void ImageClicked (View view)
        {
            switch (view.getId()) {
                case R.id.imageView:
                    {
                    Intent intent = new Intent(recipe.this, FullImageActivity.class);
                    intent.putExtra("id", 1);
                    startActivity(intent);
                    }
             case R.id.imageView1:
                 {
                    Intent intent = new Intent(recipe.this, FullImageActivity.class);
                    intent.putExtra("id", 1);
                    startActivity(intent);
                 }
                case R.id.imageView2:
                    {
                    Intent intent = new Intent(recipe.this, FullImageActivity.class);
                    intent.putExtra("id", 1);
                    startActivity(intent);
                    }
            }

        }

}
