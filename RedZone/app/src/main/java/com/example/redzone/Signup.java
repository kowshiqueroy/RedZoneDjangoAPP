package com.example.redzone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Signup extends AppCompatActivity {
Button loginbtn,signupbtn2;
EditText editfn, editln, editdob, editemail, editgender, editprofession, editpass, editpass2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Log.d("Signup", "enter");

        loginbtn= (Button) findViewById(R.id.loginbtn2);
        signupbtn2= (Button) findViewById(R.id.signupbtnsave);

        editfn= (EditText) findViewById(R.id.editfn);
        editln= (EditText) findViewById(R.id.editln);
        editdob= (EditText) findViewById(R.id.editdob);
        editemail= (EditText) findViewById(R.id.editemail);
        editgender= (EditText) findViewById(R.id.editgender);
        editprofession= (EditText) findViewById(R.id.editprofession);
        editpass= (EditText) findViewById(R.id.editpass);
        editpass2= (EditText) findViewById(R.id.editpass2);



        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1= new Intent(Signup.this,Login.class);
                startActivity(i1);

            }
        });

        signupbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i1= new Intent(Signup.this,Login.class);
                startActivity(i1);

                Log.d("Signup", "btclick");


                String hm="{\"first_name\":\"Kowshique\",\"last_name\":\"Roy\",\"gender\":1,\"email\":\"Niger@gmail.com\",\"profession\":\"Student\",\"username\":\"Meher\",\"password\":\"k12345678M\",\"password2\":\"k12345678M\"}";


                Log.d("Signup", String.valueOf(hm));
Call <RedUser> call = RetrofitClient.getInstance().getMyApi().createUser(hm,"1997-11-01");
                Log.d("Signup", "afterbtclick");
call.enqueue(new Callback<RedUser>() {
    @Override
    public void onResponse(Call<RedUser> call, Response<RedUser> response) {
        Log.d("Signup", response.body().getEmail());
    }

    @Override
    public void onFailure(Call<RedUser> call, Throwable t) {
        Log.d("Signup", "Json failed");
    }
});
                //Intent i1= new Intent(Signup.this,Login.class);
                //startActivity(i1);

            }
        });






    }






}