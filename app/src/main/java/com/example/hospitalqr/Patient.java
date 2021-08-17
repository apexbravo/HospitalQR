package com.example.hospitalqr;

public class Patient {
    String Pat_Address;
    String Pat_Diagnosed;
    int Pat_ID;
    String Pat_Name;
    String Pat_Surname;
    String Pat_PhoneNumber;

    public Patient() {
    }

    public Patient(String pat_Address, String pat_Diagnosed, String pat_Name, String pat_Surname, String pat_PhoneNumber) {
        Pat_Address = pat_Address;
        Pat_Diagnosed = pat_Diagnosed;
        Pat_ID = 1;
        Pat_Name = pat_Name;
        Pat_Surname = pat_Surname;
        Pat_PhoneNumber = pat_PhoneNumber;
    }

    public String getPat_Address() {
        return Pat_Address;
    }

    public void setPat_Address(String pat_Address) {
        Pat_Address = pat_Address;
    }

    public String getPat_Diagnosed() {
        return Pat_Diagnosed;
    }

    public void setPat_Diagnosed(String pat_Diagnosed) {
        Pat_Diagnosed = pat_Diagnosed;
    }

    public int getPat_ID() {
        return Pat_ID;
    }

    public void setPat_ID(int pat_ID) {
        Pat_ID = pat_ID;
    }

    public String getPat_Name() {
        return Pat_Name;
    }

    public void setPat_Name(String pat_Name) {
        Pat_Name = pat_Name;
    }

    public String getPat_Surname() {
        return Pat_Surname;
    }

    public void setPat_Surname(String pat_Surname) {
        Pat_Surname = pat_Surname;
    }

    public String getPat_PhoneNumber() {
        return Pat_PhoneNumber;
    }

    public void setPat_PhoneNumber(String pat_PhoneNumber) {
        Pat_PhoneNumber = pat_PhoneNumber;
    }
}
