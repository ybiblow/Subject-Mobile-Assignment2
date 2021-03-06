package com.example.subject_mobile_assignement_2.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.subject_mobile_assignement_2.Model.Leaderboard;
import com.example.subject_mobile_assignement_2.R;
import com.example.subject_mobile_assignement_2.Model.Record;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {

    private MaterialButton button_Play;
    private MaterialButton button_Leaderboard;
    private SwitchMaterial switch_Sensor;
    private int sensorEnabled = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setOnClickListeners();
        loadRecords();
        //getValuesFromActivities();
    }

    private void getValuesFromActivities() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("BUNDLE");
        if (bundle != null) {
            //add record
            Record record = (Record) bundle.getSerializable("RECORD");
            Leaderboard.getInstance().addRecordToRecordsArray(getApplicationContext(), record);
        }
    }

    private void loadRecords() {
        if (Leaderboard.getInstance().getRecordsArray() == null) {
            Leaderboard.getInstance().loadRecordsArrayFromSharedPreferences(getApplicationContext());
        }
    }

    private void setOnClickListeners() {
        button_Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("info", "play button pressed");
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                intent.putExtra("SENSOR_ENABLED", sensorEnabled);
                startActivity(intent);
                finish();
            }
        });

        button_Leaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("info", "button pressed");
                Intent intent = new Intent(getApplicationContext(), LeaderboardActivity.class);
                startActivity(intent);
                finish();
            }
        });

        switch_Sensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("info", "switch pressed, the sensor is enabled: " + switch_Sensor.isChecked());
                SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
                if (switch_Sensor.isChecked()) {
                    if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
                        switch_Sensor.setChecked(true);
                        sensorEnabled = 1;
                    } else {
                        switch_Sensor.setChecked(false);
                        Toast.makeText(getApplicationContext(), "You don't has Accelerometer sensor!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    sensorEnabled = 0;
                }
            }
        });
    }

    private void findViews() {
        button_Play = findViewById(R.id.button_Play);
        button_Leaderboard = findViewById(R.id.button_Leaderboard);
        switch_Sensor = findViewById(R.id.switch_Sensor);
    }

}