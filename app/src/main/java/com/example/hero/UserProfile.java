package com.example.hero;
//thisisa class
public class UserProfile {
    public String EmailId;
    public String Name;
    public String Address;
    public String Phone_No;
    public String Latitude;
    public String Longitude;
    public String Password;
    public String ICU_Beds;
    public String id;
    public String Timings;
    public String Types;
    public String Lab_Type;
    public String Lab_Time;

    public UserProfile(String uemail, String name, String uAddress, String uphone, String ulat, String ulong, String upass, String ubed, String utiming, String utype, String ulabtype, String ulabtime){

    }

    public UserProfile(String userEmail, String userName, String userAddress, String userPhone, String userLat,
                       String userLng, String userPassword, String userIcu,String  userTimings,String userTypes,
                       String id,String userlabtype,String userlabtime) {
        this.EmailId = userEmail;
        this.Name = userName;
        this.Address = userAddress;
        this.Phone_No = userPhone;
        this.Latitude = userLat;
        this.Longitude = userLng;
        this.Password = userPassword;
        this.ICU_Beds = userIcu;
        this.id=id;
        this.Timings=userTimings;
        this.Types=userTypes;
        this.Lab_Type=userlabtype;
        this.Lab_Time=userlabtime;
    }

    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String emailId) {
        EmailId = emailId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone_No() {
        return Phone_No;
    }

    public void setPhone_No(String phone_No) {
        Phone_No = phone_No;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getICU_Beds() {
        return ICU_Beds;
    }

    public void setICU_Beds(String ICU_Beds) {
        this.ICU_Beds = ICU_Beds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimings() {
        return Timings;
    }

    public void setTimings(String timings) {
        Timings = timings;
    }

    public String getTypes() {
        return Types;
    }

    public void setTypes(String types) {
        Types = types;
    }

    public String getLab_Type() {
        return Lab_Type;
    }

    public void setLab_Type(String lab_Type) {
        Lab_Type = lab_Type;
    }

    public String getLab_Time() {
        return Lab_Time;
    }

    public void setLab_Time(String lab_Time) {
        Lab_Time = lab_Time;
    }
}
