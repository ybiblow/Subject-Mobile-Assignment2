package com.example.subject_mobile_assignement_2.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;

import com.example.subject_mobile_assignement_2.Activities.MainActivity;
import com.example.subject_mobile_assignement_2.R;

public class SplashActivity extends AppCompatActivity {
    private ImageView imageViewSplashLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageViewSplashLogo = findViewById(R.id.imageViewSplashLogo);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        imageViewSplashLogo.setY(height / 2);
        imageViewSplashLogo.setScaleX(1.0f);
        imageViewSplashLogo.setScaleY(1.0f);
        imageViewSplashLogo.animate().scaleX(1.0f).scaleY(1.0f).translationY(-height / 2).setDuration(3000).setInterpolator(new AccelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}