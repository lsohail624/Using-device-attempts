package com.example.usingdeviceattempts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAlarm = findViewById(R.id.btnAlarm);
        Button btnIntent2 = findViewById(R.id.btnIntent2);

        btnAlarm.setOnClickListener(v -> {
            Intent intent = new Intent(this, AlarmActivity.class);
            startActivity(intent);
        });

        btnIntent2.setOnClickListener(v -> {
            Intent intent = new Intent(this, Intent2Activity.class);
            startActivity(intent);
        });
    }
}


