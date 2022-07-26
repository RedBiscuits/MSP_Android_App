package com.example.msp_app.ui.login;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.msp_app.R;
import com.example.msp_app.databinding.ActivityLoginBinding;
import com.example.msp_app.ui.login.fragments.LoginFragment;
import com.example.msp_app.ui.login.fragments.WelcomeFragment;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding activityLoginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginBinding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(activityLoginBinding.getRoot());
        getSupportActionBar().hide();

        LoginFragmentManger.setFragmentManager(getSupportFragmentManager());
        ScheduledExecutorService scheduledExecutorService= Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                if(getSupportFragmentManager().findFragmentById(R.id.LoginFragContainer) instanceof WelcomeFragment) {
                    getSupportFragmentManager().beginTransaction()
                            .setCustomAnimations(R.anim.fast_slide_from_bottom, R.anim.fail_down)
                            .replace(R.id.LoginFragContainer, LoginFragment.class, null)
                            .commit();
                    //make the text in Welcome fragment invisible
                    findViewById(R.id.welcomeText).setVisibility(View.INVISIBLE);
                    findViewById(R.id.enjoyText).setVisibility(View.INVISIBLE);
                }
            }
        }, 2, TimeUnit.SECONDS);

    }

}