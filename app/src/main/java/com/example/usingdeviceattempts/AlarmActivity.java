package com.example.usingdeviceattempts;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AlarmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        EditText editMessage = findViewById(R.id.editMessage);
        EditText editHour = findViewById(R.id.editHour);
        EditText editMinute = findViewById(R.id.editMinute);
        Button btnSetAlarm = findViewById(R.id.btnSetAlarm);

        btnSetAlarm.setOnClickListener(v -> {
            String message = editMessage.getText().toString();
            String hourText = editHour.getText().toString();
            String minuteText = editMinute.getText().toString();

            if (message.isEmpty() || hourText.isEmpty() || minuteText.isEmpty()) {
                Toast.makeText(this, "Completa tots els camps", Toast.LENGTH_SHORT).show();
                return;
            }

            int hour = Integer.parseInt(hourText);
            int minute = Integer.parseInt(minuteText);

            if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
                Toast.makeText(this, "Hora o minuts invàlids", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                    .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                    .putExtra(AlarmClock.EXTRA_HOUR, hour)
                    .putExtra(AlarmClock.EXTRA_MINUTES, minute);

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(this, "No hi ha cap aplicació d'alarma disponible", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
