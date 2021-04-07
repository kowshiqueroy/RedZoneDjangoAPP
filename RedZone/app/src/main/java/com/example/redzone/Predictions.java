package com.example.redzone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Predictions extends AppCompatActivity {
TextView tp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predictions);
        tp= (TextView) findViewById(R.id.tp);
        tp.setText("hello");
Log.d("Pre", "Open");
        getpredict();

    }
        private void getpredict() {
            Log.d("Pre2", "Open");
            Log.d("1", "ok3");
            Call<HashMap<String,Object>> call = RetrofitClient.getInstance().getMyApi().getpredict(Login.tokenrec);
            call.enqueue(new Callback<HashMap<String,Object>>() {
                @Override
                public void onResponse(Call<HashMap<String,Object>> call, Response<HashMap<String,Object>> response) {

                    if (response.body() instanceof HashMap) {


if(response.body().containsKey("affection_probability") ){
                        tp.setText( response.body().get("affection_probability").toString());


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