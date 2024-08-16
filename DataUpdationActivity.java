package com.example.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DataUpdationActivity extends AppCompatActivity {

    private EditText phoneNumber, confirmPhoneNumber, machineId, password, confirmPassword, businessAddress, emailAddress, confirmEmailAddress;
    private Button submitButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scarchdata);

        // Initialize UI components
        phoneNumber = findViewById(R.id.phoneNumber);
        confirmPhoneNumber = findViewById(R.id.confirmPhoneNumber);
        machineId = findViewById(R.id.machineId);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);
        businessAddress = findViewById(R.id.businessAddress);
        emailAddress = findViewById(R.id.emailAddress);
        confirmEmailAddress = findViewById(R.id.confirmEmailAddress);
        submitButton = findViewById(R.id.submitButton);

        // Set up the submit button click listener
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSubmit();
            }
        });
    }

    private void handleSubmit() {
        // Retrieve user inputs
        String phone = phoneNumber.getText().toString().trim();
        String confirmPhone = confirmPhoneNumber.getText().toString().trim();
        String machine = machineId.getText().toString().trim();
        String pass = password.getText().toString().trim();
        String confirmPass = confirmPassword.getText().toString().trim();
        String businessAddr = businessAddress.getText().toString().trim();
        String email = emailAddress.getText().toString().trim();
        String confirmEmail = confirmEmailAddress.getText().toString().trim();

        // Validate inputs (example validation)
        if (phone.isEmpty() || confirmPhone.isEmpty() || machine.isEmpty() ||
                pass.isEmpty() || confirmPass.isEmpty() || businessAddr.isEmpty() ||
                email.isEmpty() || confirmEmail.isEmpty()) {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!phone.equals(confirmPhone)) {
            Toast.makeText(this, "Phone numbers do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!pass.equals(confirmPass)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!email.equals(confirmEmail)) {
            Toast.makeText(this, "Email addresses do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        // Process the data (e.g., save it to a database, send to server, etc.)
        // Example toast message for submission
        Toast.makeText(this, "Data updated successfully", Toast.LENGTH_SHORT).show();
    }
}
