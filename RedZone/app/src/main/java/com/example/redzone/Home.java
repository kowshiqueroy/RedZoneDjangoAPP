package com.example.redzone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends AppCompatActivity {
TextView t, t2;
Button rb, gtb, pb,lo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        t2=(TextView) findViewById(R.id.tv2);
        getRedUsers();
        rb= (Button) findViewById(R.id.rb);
        gtb= (Button) findViewById(R.id.gtb);
        pb= (Button) findViewById(R.id.pb);
        lo= (Button) findViewById(R.id.logout);


        lo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home.this.finish();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
                System.exit(0);
            }
        });

t2.setText(Login.tokenrec);
        rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1= new Intent(Home.this,Routine.class);
                startActivity(i1);

            }
        });
        gtb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1= new Intent(Home.this,GoTo.class);
                startActivity(i1);

            }
        });
        pb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1= new Intent(Home.this,Predictions.class);
                startActivity(i1);

            }
        });





    }

    private void getRedUsers() {
        Log.d("1", "ok3");
        Call<RedUser> call = RetrofitClient.getInstance().getMyApi().getRedUsers(Login.tokenrec);
        call.enqueue(new Callback<RedUser>() {
            @Override
            public void onResponse(Call<RedUser> call, Response<RedUser> response) {

                if (response.body() instanceof RedUser) {



t2.setText( response.body().getFirst_name());
                        Log.d("risk", response.body().getFirst_name().toString());

                        Toast toast=Toast.makeText(getApplicationContext(),"Receiving Profile....",Toast.LENGTH_SHORT);
                        toast.show();

                }


            }

            @Override
            public void onFailure(Call<RedUser> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
           Log.d("fail", "lol");

            }
        });
    }


}