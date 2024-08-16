package com.example.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UserPageActivity extends AppCompatActivity {

    private TextView userNameTextView;
    private TextView machineIdTextView;
    private TextView customerIdTextView;
    private TextView customerNameTextView;
    private Button reportButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userpage);

        // Initialize views
        userNameTextView = findViewById(R.id.full_name);
        machineIdTextView = findViewById(R.id.email_id);
        customerIdTextView = findViewById(R.id.confirmUserId);
        customerNameTextView = findViewById(R.id.full_name);
        reportButton = findViewById(R.id.submit_button);

        // Set user information (you can fetch this information from your database or API)
        String userName = "John Doe";
        String machineId = "123456";
        String customerId = "CUST001";
        String customerName = "Acme Corp";

        // Set text in views
        userNameTextView.setText("User Name: " + userName);
        machineIdTextView.setText("Machine ID: " + machineId);
        customerIdTextView.setText("Customer ID: " + customerId);
        customerNameTextView.setText("Name: " + customerName);

        // Set up the report button click listener
        reportButton.setOnClickListener(v -> {
            // Handle report button click
            Toast.makeText(UserPageActivity.this, "Report Button Clicked", Toast.LENGTH_SHORT).show();

            // You can navigate to another activity or perform other actions here
            // Intent intent = new Intent(UserPageActivity.this, ReportActivity.class);
            // startActivity(intent);
        });
    }
}
