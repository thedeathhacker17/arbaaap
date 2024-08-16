// RegistrationActivity.java
package com.example.app;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    private EditText fullNameEditText;
    private EditText emailEditText;
    private EditText businessAddressEditText;
    private EditText phoneNumberEditText;
    private CheckBox termsCheckBox;
    private Button signUpButton;
    private TextView alreadyMemberTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        fullNameEditText = findViewById(R.id.full_name);
        emailEditText = findViewById(R.id.email_id);
        businessAddressEditText = findViewById(R.id.business_address);
        phoneNumberEditText = findViewById(R.id.phone_number);
        termsCheckBox = findViewById(R.id.terms_conditions);
        signUpButton = findViewById(R.id.signup_button);
        alreadyMemberTextView = findViewById(R.id.already_member);

        alreadyMemberTextView.setPaintFlags(alreadyMemberTextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        signUpButton.setOnClickListener(v -> attemptRegistration());

        alreadyMemberTextView.setOnClickListener(v -> {
            Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void attemptRegistration() {
        fullNameEditText.setError(null);
        emailEditText.setError(null);
        businessAddressEditText.setError(null);
        phoneNumberEditText.setError(null);

        String fullName = fullNameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String businessAddress = businessAddressEditText.getText().toString().trim();
        String phoneNumber = phoneNumberEditText.getText().toString().trim();

        boolean cancel = false;
        View focusView = null;

        if (TextUtils.isEmpty(phoneNumber)) {
            phoneNumberEditText.setError("This field is required");
            focusView = phoneNumberEditText;
            cancel = true;
        } else if (!isPhoneNumberValid(phoneNumber)) {
            phoneNumberEditText.setError("This phone number is invalid");
            focusView = phoneNumberEditText;
            cancel = true;
        }

        if (TextUtils.isEmpty(businessAddress)) {
            businessAddressEditText.setError("This field is required");
            focusView = businessAddressEditText;
            cancel = true;
        }

        if (TextUtils.isEmpty(email)) {
            emailEditText.setError("This field is required");
            focusView = emailEditText;
            cancel = true;
        } else if (!isEmailValid(email)) {
            emailEditText.setError("This email address is invalid");
            focusView = emailEditText;
            cancel = true;
        }

        if (TextUtils.isEmpty(fullName)) {
            fullNameEditText.setError("This field is required");
            focusView = fullNameEditText;
            cancel = true;
        }

        if (!termsCheckBox.isChecked()) {
            Toast.makeText(this, "You must agree to the Terms & Conditions", Toast.LENGTH_LONG).show();
            cancel = true;
        }

        if (cancel) {
            if (focusView != null) {
                focusView.requestFocus();
            }
        } else {
            Toast.makeText(this, "Registration Successful!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(RegistrationActivity.this, OTPActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private boolean isEmailValid(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isPhoneNumberValid(String phone) {
        return android.util.Patterns.PHONE.matcher(phone).matches();
    }
}
