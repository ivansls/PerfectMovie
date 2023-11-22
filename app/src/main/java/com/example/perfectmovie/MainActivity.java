package com.example.perfectmovie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {



    BottomNavigationView bottomNav;

    DrawerLayout cont;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SetFragment(new Expected());
        bottomNav = findViewById(R.id.botomNavigView);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.animation);



        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.first) {
                    SetFragment(new Expected());
                    return true;

                }
                else if (id == R.id.second){
                    SetFragment(new TopFilmsFragment());
                    return true;
                }
                return false;
            }
        });




    }




    private void SetFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame, fragment)
                .commit();
    }
}