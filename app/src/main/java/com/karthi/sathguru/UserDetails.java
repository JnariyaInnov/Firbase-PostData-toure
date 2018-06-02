package com.karthi.sathguru;

/**
 * Created by karthikeyansekar on 23/05/18.
 */
import com.google.firebase.database.Exclude;

public class UserDetails {
    private String uName;
    private String uEmail;
    private String uPhone;
    private String uCity;
    private String uKey;
    private String uState;

    public UserDetails(){
        //empty constructor
    }


    public UserDetails(String name, String email, String phone, String city, String state){
        uName=name;
        uEmail=email;
        uPhone=phone;
        uCity=city;
        uState=state;
    }


    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public String getuCity() {
        return uCity;
    }

    public void setuCity(String uCity) {
        this.uCity = uCity;
    }

    public String getuState() {
        return uState;
    }

    public void setuState(String uState) {
        this.uState = uState;
    }

    @Exclude
    public String getKey() {
        return uKey;
    }

    @Exclude
    public void setKey(String key) {
        uKey = key;
    }
}
