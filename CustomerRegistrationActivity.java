package com.example.app;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CustomerRegistrationActivity extends AppCompatActivity {

    private EditText firstName, middleName, lastName, motherTongue, dob, mobileNumber, emailAddress, residentialAddress, preferredReportLanguage;
    private RadioGroup genderGroup, dietaryPreferenceGroup;
    private RadioButton selectedGender, selectedDietaryPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cusromerreg);

        // Initialize the views
        firstName = findViewById(R.id.first_name);
        middleName = findViewById(R.id.middle_name);
        lastName = findViewById(R.id.last_name);
        motherTongue = findViewById(R.id.mother_tongue);
        dob = findViewById(R.id.dob);
        mobileNumber = findViewById(R.id.mobile_number);
        emailAddress = findViewById(R.id.email_address);
        residentialAddress = findViewById(R.id.residential_address);
        preferredReportLanguage = findViewById(R.id.preferred_report_language);

        genderGroup = findViewById(R.id.gender);
        dietaryPreferenceGroup = findViewById(R.id.dietary_preference);

        // Capture selected gender and dietary preference when the selection changes
        genderGroup.setOnCheckedChangeListener((group, checkedId) -> {
            selectedGender = findViewById(checkedId);
        });

        dietaryPreferenceGroup.setOnCheckedChangeListener((group, checkedId) -> {
            selectedDietaryPreference = findViewById(checkedId);
        });

        // Example of saving the data or performing an action
        saveData();
    }

    private void saveData() {
        // Example: Convert the input data to a string and show it as a toast (you can modify this to save the data)
        String customerData = "First Name: " + firstName.getText().toString() +
                "\nMiddle Name: " + middleName.getText().toString() +
                "\nLast Name: " + lastName.getText().toString() +
                "\nMother Tongue: " + motherTongue.getText().toString() +
                "\nDate of Birth: " + dob.getText().toString() +
                "\nMobile Number: " + mobileNumber.getText().toString() +
                "\nEmail Address: " + emailAddress.getText().toString() +
                "\nResidential Address: " + residentialAddress.getText().toString() +
                "\nGender: " + (selectedGender != null ? selectedGender.getText().toString() : "Not Selected") +
                "\nDietary Preference: " + (selectedDietaryPreference != null ? selectedDietaryPreference.getText().toString() : "Not Selected") +
                "\nPreferred Report Language: " + preferredReportLanguage.getText().toString();

        Toast.makeText(this, customerData, Toast.LENGTH_LONG).show();

        // Here you can add the code to save the data, send it to a server, or perform other actions.
    }
}
