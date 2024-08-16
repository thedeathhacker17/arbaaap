package com.example.app;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {

    private Spinner searchOptionSpinner;
    private EditText customerIdInput;
    private EditText mobileNumberInput;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scarchdata);

        // Initialize views
        searchOptionSpinner = findViewById(R.id.searchOptionSpinner);
        customerIdInput = findViewById(R.id.customerIdInput);
        mobileNumberInput = findViewById(R.id.mobileNumberInput);
        submitButton = findViewById(R.id.submitButton);



        // Handle Spinner selection
        searchOptionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedOption = parent.getItemAtPosition(position).toString();
                if (selectedOption.equals("Search by Customer ID")) {
                    customerIdInput.setVisibility(View.VISIBLE);
                    mobileNumberInput.setVisibility(View.GONE);
                } else if (selectedOption.equals("Search by Mobile Number")) {
                    customerIdInput.setVisibility(View.GONE);
                    mobileNumberInput.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                customerIdInput.setVisibility(View.GONE);
                mobileNumberInput.setVisibility(View.GONE);
            }
        });

        // Handle Submit Button click
        submitButton.setOnClickListener(v -> {
            // Handle the submit action based on user input
            if (customerIdInput.getVisibility() == View.VISIBLE) {
                String customerId = customerIdInput.getText().toString();
                // Handle search by Customer ID
            } else if (mobileNumberInput.getVisibility() == View.VISIBLE) {
                String mobileNumber = mobileNumberInput.getText().toString();
                // Handle search by Mobile Number
            }
        });
    }
}
