package com.example.redzone;

public class RedUser {




private  String first_name;
    private  String last_name;
    private  int gender;
    private  String email;
    private  String username;
    private  String profession;
private  String date_of_birth;






    public RedUser ( String date_of_birth, String first_name, String last_name, String username, int gender, String email, String profession){
this.date_of_birth=date_of_birth;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender=gender;
        this.email=email;
        this.profession=profession;
        this.username = username;

    }


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
}
