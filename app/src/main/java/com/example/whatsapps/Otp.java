package com.example.whatsapps;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Otp extends AppCompatActivity {
    AppCompatEditText otp;
    String phonenumber;
    String otpid;
    AppCompatButton button;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        otp = findViewById(R.id.otp);
        button = findViewById(R.id.button);
        phonenumber = "+"+getIntent().getStringExtra("phone_no").replace(" ","");
        Log.d("phone_no_otp",phonenumber);
        mAuth = FirebaseAuth.getInstance();
        initiated();

        button.setOnClickListener(v -> {

            if (Objects.requireNonNull(otp.getText()).toString().isEmpty()) {
                Toast.makeText(this, "please Enter otp", Toast.LENGTH_SHORT).show();
            } else if (otp.getText().toString().length() != 6) {
                Toast.makeText(this, "Invalid otp", Toast.LENGTH_SHORT).show();

            } else {
                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(otpid, otp.getText().toString());
                signInWithPhoneAuthCredential(credential);
            }

        });


    }

    private void initiated() {
        PhoneAuthOptions options = PhoneAuthOptions.newBuilder(mAuth)
                .setPhoneNumber(phonenumber)
                .setTimeout(60L, TimeUnit.SECONDS)
                .setActivity(this)
                .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                        signInWithPhoneAuthCredential(phoneAuthCredential);
                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {

                    }

                    @Override
                    public void onCodeSent(@NonNull String verificationId,
                                           @NonNull PhoneAuthProvider.ForceResendingToken token) {

                        otpid = verificationId;
                        // Save verification ID and resending token so we can use them later

                    }
                })
                        .build();

        PhoneAuthProvider.verifyPhoneNumber(options);

    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        SharedPreferences preferences=getSharedPreferences("login",MODE_PRIVATE);
                        SharedPreferences.Editor editor=preferences.edit();
                        editor.putBoolean("flag",true);
                        editor.apply();
                        // Sign in success, update UI with the signed-in user's information

                        startActivity(new Intent(Otp.this, MainActivity.class));
                        finish();

                        FirebaseUser user = task.getResult().getUser();
                        // Update UI
                    } else {

                        // Sign in failed, display a message and update the UI
                        Toast.makeText(Otp.this, "Sign in Code Error", Toast.LENGTH_SHORT).show();
                        if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                            // The verification code entered was invalid
                        }
                    }
                });
    }


}