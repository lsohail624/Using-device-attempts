package com.example.usingdeviceattempts;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Intent2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent2);

        EditText editUrl = findViewById(R.id.editUrl);
        Button btnOpenWeb = findViewById(R.id.btnOpenWeb);

        btnOpenWeb.setOnClickListener(v -> {
            String url = editUrl.getText().toString().trim();
            if (url.isEmpty()) {
                Toast.makeText(this, "Escriu una URL", Toast.LENGTH_SHORT).show();
                return;
            }

            // Add http if missing
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "http://" + url;
            }

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(this, "No hi ha navegador disponible", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
