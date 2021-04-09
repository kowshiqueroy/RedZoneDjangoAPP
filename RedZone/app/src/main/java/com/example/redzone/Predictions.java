package com.example.redzone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Predictions extends AppCompatActivity {
TextView tpm, tp;
Button pr, pg,ph,noti;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_predictions);


        noti=(Button) findViewById(R.id.noti);
        pr=(Button) findViewById(R.id.pr);
        pg=(Button) findViewById(R.id.pg);
        ph=(Button) findViewById(R.id.ph);
        tp= (TextView) findViewById(R.id.tp);
        tpm= (TextView) findViewById(R.id.tpm);
        tpm.setText("Predicting your status of risk for COVID19....\n");
Log.d("Pre", "Open");
        getpredict();


noti.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), "Not Allowed in this Beta App", Toast.LENGTH_SHORT).show();
    }
});
        pg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1= new Intent(Predictions.this,GoTo.class);
                startActivity(i1);
            }
        });

        pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1= new Intent(Predictions.this,Routine.class);
                startActivity(i1);
            }
        });

        ph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1= new Intent(Predictions.this,Home.class);
                startActivity(i1);
            }
        });



    }
        private void getpredict() {
            Log.d("Pre2", "Open");

            Call<HashMap<String,Object>> call = RetrofitClient.getInstance().getMyApi().getpredict(Login.tokenrec);
            call.enqueue(new Callback<HashMap<String,Object>>() {
                @Override
                public void onResponse(Call<HashMap<String,Object>> call, Response<HashMap<String,Object>> response) {

                    if (response.body() instanceof HashMap) {

                        Log.d("hash", "ok");
if(response.body().containsKey("affection_probability") ){
                        tp.setText(response.body().get("affection_probability").toString());

    Log.d("res", "ok");
                        Toast toast=Toast.makeText(getApplicationContext(),"Receiving Pre....",Toast.LENGTH_SHORT);
                        toast.show();}

                    }


                }

                @Override
                public void onFailure(Call<HashMap<String,Object>> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("fail", "lol");

                }
            });
        }



}