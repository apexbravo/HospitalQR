package com.example.hospitalqr;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.hospitalqr.databinding.ActivityFullPatientInfBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import static android.content.ContentValues.TAG;

public class FullPatientInf extends AppCompatActivity {
    public  static final  String Patient_INFO = "com.example.myapplication2.Patient_INFO";
    private AppBarConfiguration appBarConfiguration;
    private ActivityFullPatientInfBinding binding;
    private String mPatientName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseReference mDatabase;
// ...
        mDatabase = FirebaseDatabase.getInstance().getReference();
        DatabaseReference mwritefarmref = mDatabase.child("Patient1");
        Query pat1 = mDatabase.equalTo("Patient");

            String patient1 = getIntent().getStringExtra(Patient_INFO);
           // binding.PName.setText(patient1);

        mwritefarmref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {

                        Patient patient = snapshot.getValue(Patient.class);
                        String PAdress = patient.getPat_Address();
                        String Diagnosed = patient.Pat_Diagnosed;
                        int PID = patient.getPat_ID();
                   mPatientName = patient.getPat_Name();
                    binding.PName.setText(mPatientName);
                        String PPhoneNumber = patient.getPat_PhoneNumber();
                        String PSurname = patient.getPat_Surname();

                    Log.i(TAG, "onDataChange: " + PID);
                }


            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Log.i(TAG, "onCancelled: Error: " + error.getMessage());
            }
        });

        binding = ActivityFullPatientInfBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);




        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        return true;
    }
}