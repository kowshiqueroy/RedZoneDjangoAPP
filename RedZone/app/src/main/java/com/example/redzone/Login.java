package com.example.redzone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    Button loginbtn, signupbtn;

    public static  ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginbtn= (Button) findViewById(R.id.loginbtn);
        signupbtn= (Button) findViewById(R.id.signupbtn);

        Log.d("1", "ok1");




        Log.d("1", "ok2");




















        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1= new Intent(Login.this,Signup.class);
                startActivity(i1);

            }


        });


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

/*
                Intent i1= new Intent(Login.this,Home.class);
                startActivity(i1);*/
                Log.d("Token","before");
                Call <HashMap<String, Object>> call = RetrofitClient.getInstance().getMyApi().login("17201114@uap-bd.edu","ilovedjango");
                call.enqueue(new Callback<HashMap<String, Object> >() {
                    @Override
                    public void onResponse(Call<HashMap<String, Object> > call, Response<HashMap<String, Object> > response) {

                        Log.d("Token", response.body().get("token").toString());

                        //5b3eb583ce430bb8cb7bf700e559b33a96ac8375
                    }

                    @Override
                    public void onFailure(Call<HashMap<String, Object> > call, Throwable t) {
                        Log.d("Token","failed");
                    }
                });

                /*Intent i1= new Intent(Login.this,Home.class);
                startActivity(i1);*/

            }


        });


    }
















}