package com.example.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CustomerIdDeactivationActivity extends AppCompatActivity {

    private EditText customerName, customerMobileNumber, customerId;
    private Button deactivateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custoiddere);

        // Initialize UI components
        customerName = findViewById(R.id.customerName);
        customerMobileNumber = findViewById(R.id.customerMobileNumber);
        customerId = findViewById(R.id.customerId);
        deactivateButton = findViewById(R.id.deactivateButton);

        // Set up the deactivate button click listener
        deactivateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleDeactivate();
            }
        });
    }

    private void handleDeactivate() {
        // Retrieve user inputs
        String name = customerName.getText().toString().trim();
        String mobileNumber = customerMobileNumber.getText().toString().trim();
        String id = customerId.getText().toString().trim();

        // Validate inputs
        if (name.isEmpty() || mobileNumber.isEmpty() || id.isEmpty()) {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Process the deactivation request (e.g., save it to a database, send to server, etc.)
        // Example toast message for submission
        Toast.makeText(this, "Deactivation request submitted successfully.", Toast.LENGTH_SHORT).show();
    }
}
