// SetpassActivity.java
package com.example.app;

import android.annotation.SuppressLint;
import android.content.Intent; // Import the Intent class
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar; // Import Toolbar class

import com.example.app.databinding.ActivitySetpassBinding;

public class SetpassActivity extends AppCompatActivity {

    private ActivitySetpassBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySetpassBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Ensure you have a Toolbar in your layout and it's correctly referenced
        @SuppressLint("WrongViewCast") Toolbar toolbar = findViewById(R.id.header);
        setSupportActionBar(toolbar);

        binding.submitButton.setOnClickListener(v -> {
            String userId = binding.confirmUserId.getText().toString().trim();
            String password = binding.enterPassword.getText().toString().trim();
            String confirmPassword = binding.confirmPassword.getText().toString().trim();

            if (userId.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else if (!password.equals(confirmPassword)) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Password Set Successfully!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SetpassActivity.this, DeviceregActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
