package com.shraddha.navi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Camera;
import android.os.Bundle;

import android.provider.MediaStore;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import static com.shraddha.navi.R.menu.test;




public class MainActivity extends AppCompatActivity {
    public static TextView textView;
    BottomNavigationView bottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // textView=findViewById(R.id.textview);
        bottom=findViewById(R.id.test11);
        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item1) {
                switch (item1.getItemId()) {
                    case R.id.action_settings:
                        //  Toast.makeText(this, "Hi I am Navigation", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.search:
                        // Toast.makeText(this, "hey", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, MainActivity.class));
                        return true;

                    case R.id.camera:
                        // Toast.makeText(this, "camera", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MediaStore.ACTION_IMAGE_CAPTURE));
                        return true;

                    default:
                        return false;
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        //inflater.inflate(R.menu.bottom_nav_menu, menu);
        inflater.inflate(test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
                startActivity(new Intent(Settings.ACTION_SETTINGS));
                Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.search:
                Toast.makeText(this, "gallery", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, MainActivity.class));
                //startActivity(new Intent(MediaStore.Ac));
                return true;


            case R.id.camera:
                Toast.makeText(this, "camera", Toast.LENGTH_SHORT).show();
                // public void onclick(int actionCode){
                //  Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //startActivityForResult(takePictureIntent ,actionCode);
                startActivity(new Intent(MediaStore.ACTION_IMAGE_CAPTURE));
                return true;
            //}
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}