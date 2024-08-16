// OTPActivity.java
package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OTPActivity extends AppCompatActivity {

    private EditText otpInput;
    private Button submitOtpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        otpInput = findViewById(R.id.otp_input);
        submitOtpButton = findViewById(R.id.submit_otp_button);

        submitOtpButton.setOnClickListener(v -> attemptSubmitOTP());
    }

    private void attemptSubmitOTP() {
        otpInput.setError(null);
        String otp = otpInput.getText().toString().trim();

        if (TextUtils.isEmpty(otp)) {
            otpInput.setError("This field is required");
            otpInput.requestFocus();
        } else if (!isOtpValid(otp)) {
            otpInput.setError("Invalid OTP. Please try again.");
            otpInput.requestFocus();
        } else {
            Toast.makeText(this, "OTP Verified Successfully!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(OTPActivity.this, SetpassActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private boolean isOtpValid(String otp) {
        return otp.length() == 6 && TextUtils.isDigitsOnly(otp);
    }
}
