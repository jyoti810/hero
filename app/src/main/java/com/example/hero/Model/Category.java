package com.example.hero.Model;

public class Category {
    //private String EmailId;
    private String Name;
    //public String Address;
    private String Phone_No;
    private String Latitude;
    private String Longitude;
    //public String Password;
    private String ICU_Beds;
    private String Timings;
    private String Types;
    private String Lab_Type;
    private String Lab_Time;


    public Category() {
    }

    public Category(String name, String phone_No, String ICU_Beds,String latitude,String longitude
            ,String timings, String types,String lab_Type,String lab_Time) {
        Name = name;
        Phone_No = phone_No;
        this.ICU_Beds = ICU_Beds;
        Latitude=latitude;
        Longitude=longitude;
        Timings=timings;
        Types=types;
        Lab_Type=lab_Type;
        Lab_Time=lab_Time;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone_No() {
        return Phone_No;
    }

    public void setPhone_No(String phone_No) {
        Phone_No = phone_No;
    }

    public String getICU_Beds() {
        return ICU_Beds;
    }

    public void setICU_Beds(String ICU_Beds) {
        this.ICU_Beds = ICU_Beds;
    }


    public String getLatitude() {
        return Latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public String getTimings() {
        return Timings;
    }

    public String getTypes() {
        return Types;
    }
    public String getLab_Type(){ return Lab_Type; }
    public String getLab_Time(){ return Lab_Time; }
}
