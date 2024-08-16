package com.example.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CustomerDataUpdationActivity extends AppCompatActivity {

    private EditText phoneNumber, confirmPhoneNumber;
    private CheckBox checkboxVeg, checkboxNonVeg;
    private Button submitButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdaup);

        // Initialize UI components
        phoneNumber = findViewById(R.id.phoneNumber);
        confirmPhoneNumber = findViewById(R.id.confirmPhoneNumber);
        checkboxVeg = findViewById(R.id.checkboxVeg);
        checkboxNonVeg = findViewById(R.id.checkboxNonVeg);
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

        // Validate inputs
        if (phone.isEmpty() || confirmPhone.isEmpty()) {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!phone.equals(confirmPhone)) {
            Toast.makeText(this, "Phone numbers do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        // Retrieve checkbox values
        boolean isVeg = checkboxVeg.isChecked();
        boolean isNonVeg = checkboxNonVeg.isChecked();

        // Process the data (e.g., save it to a database, send to server, etc.)
        // Example toast message for submission
        String mealType = "";
        if (isVeg && isNonVeg) {
            mealType = "Veg and Non-Veg";
        } else if (isVeg) {
            mealType = "Veg";
        } else if (isNonVeg) {
            mealType = "Non-Veg";
        } else {
            mealType = "Not Specified";
        }

        String message = "Data updated successfully.\nMeal Type: " + mealType;
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
