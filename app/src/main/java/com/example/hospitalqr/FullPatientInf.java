package com.example.hospitalqr;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(getApplicationContext());
// ...
        String patient1 = getIntent().getStringExtra(Patient_INFO);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        DatabaseReference mwritefarmref = mDatabase.child(patient1);
        Query pat1 = mDatabase.equalTo("Patient");


           // binding.PName.setText(patient1);

        mwritefarmref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {

                        Patient patient = snapshot.getValue(Patient.class);
                        String PAdress = patient.getPat_Address();
                        binding.Patadd.setText(PAdress);
                        String Diagnosed = patient.getPat_Diagnosed();
                        binding.PatDiagnosis.setText(Diagnosed);
                        int PID = patient.getPat_ID();
                   mPatientName = patient.getPat_Name();
                    binding.PatName.setText(mPatientName);
                        String PPhoneNumber = patient.getPat_PhoneNumber();
                        binding.PatNumber.setText(PPhoneNumber);
                        String PSurname = patient.getPat_Surname();
                        binding.PatSurname.setText(PSurname);

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
                mBuilder.setMessage("ApexBravo Developers \napxbravone@gmail.com \n \nTsumoApp \n \nThis application , the developers and contributors  assume no responsibility  whatsoever for its usage by other parties \n \nThis app is still a work in progress therefore please share your reviews , we want to know if you like the product and what improvements can be made.").setTitle("TsumoApp Licences").setPositiveButton("Ok ,I Understand", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = mBuilder.create();

                mBuilder.show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        return true;
    }
}