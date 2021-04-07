package com.example.redzone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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
    public  EditText emi, passi;
    public static String tokenrec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emi=(EditText) findViewById(R.id.emailinput);
        passi=(EditText) findViewById(R.id.passwordinput);
        loginbtn= (Button) findViewById(R.id.loginbtn);
        signupbtn= (Button) findViewById(R.id.signupbtn);


        emi.setText(Signup.usernamein);
        passi.setText(Signup.passin);

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


                Call <HashMap<String, Object>> call = RetrofitClient.getInstance().getMyApi().login(emi.getText().toString(),passi.getText().toString());
                call.enqueue(new Callback<HashMap<String, Object> >() {
                    @Override



                    public void onResponse(Call<HashMap<String, Object> > call, Response<HashMap<String, Object> > response) {

                        if (response.body() instanceof HashMap){
                            tokenrec=response.body().get("token").toString();
                            Toast toast=Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT);
                            toast.show();
                            Intent i1= new Intent(Login.this,Home.class);
                            startActivity(i1);
                        } else{

                            Toast toast=Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT);
                            toast.show();


                        }


                    }

                    @Override
                    public void onFailure(Call<HashMap<String, Object> > call, Throwable t) {
                        Toast toast=Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
            }
        });
    }


}
