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




                Log.d("Signup", "btclick");
                String gen;
                if (editgender.getText().toString()=="male" ||editgender.getText().toString()=="Male"){

                    gen="1";
                } else{gen="0"; }


                String hm="{\"first_name\":\"" +
                        editfn.getText().toString() +
                        "\",\"last_name\":\"" +
                        editln.getText().toString()+
                        "\",\"gender\":" +
                        gen +
                        ",\"email\":\"" +
                        editemail.getText().toString() +
                        "\",\"profession\":\"" +
                        editprofession.getText().toString() +
                        "\",\"username\":\"" +
                        editemail.getText().toString() +
                        "\",\"password\":\"" +
                        editpass.getText().toString() +
                        "\",\"password2\":\"" +
                        editpass2.getText().toString() +
                        "\"}";
Log.d("Json",hm);

                Log.d("Signup", String.valueOf(hm));
Call <RedUser> call = RetrofitClient.getInstance().getMyApi().createUser(hm,editdob.getText().toString());
                Log.d("Signup", "afterbtclick");
call.enqueue(new Callback<RedUser>() {

    @Override
    public void onResponse(Call<RedUser> call, Response<RedUser> response) {
        Log.d("Res", "ok");
        if (response.body() instanceof RedUser){
            Log.d("Res", "ok");
            Log.d("Res", "ok");
            if(editemail.getText().toString()==response.body().getEmail()){
                Toast toast=Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT);
                toast.show();
                Intent i1= new Intent(Signup.this,Login.class);
                startActivity(i1);

            }
            Toast toast=Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT);
            toast.show();
            Log.d("Res", "if not");
        }
        Toast toast=Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT);
        toast.show();
        Log.d("Res", "if not");
    }

    @Override
    public void onFailure(Call<RedUser> call, Throwable t) {
        Toast toast=Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT);
        toast.show();
        Log.d("Res", "failed");

    }
});
            }
        });

    }
}