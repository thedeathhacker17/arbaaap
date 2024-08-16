// DeviceregActivity.java
package com.example.app;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.databinding.ActivityDeviceregBinding;

public class DeviceregActivity extends AppCompatActivity {

    private ActivityDeviceregBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDeviceregBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       

        binding.confirmUserId.setOnClickListener(v -> {
            String userId = binding.confirmUserId.getText().toString().trim();
            String mobileNumber = binding.confirmUserId.getText().toString().trim();
            String machineId = binding.enterMachineId.getText().toString().trim();

            if (userId.isEmpty() || mobileNumber.isEmpty() || machineId.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Device Registered Successfully!", Toast.LENGTH_LONG).show();
                // Optionally, navigate to another activity
                // Intent intent = new Intent(DeviceregActivity.this, NextActivity.class);
                // startActivity(intent);
                // finish();
            }
        });
    }
}
