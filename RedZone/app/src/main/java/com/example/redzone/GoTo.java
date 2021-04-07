package com.example.redzone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GoTo extends AppCompatActivity {
Button pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_to);
pb= (Button) findViewById(R.id.pb);

pb.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Call<HashMap<String, Object>> call = RetrofitClient.getInstance().getMyApi().gotonew("Rajabazar");
        call.enqueue(new Callback<HashMap<String, Object>>() {
            @Override
            public void onResponse(Call<HashMap<String, Object>> call, Response<HashMap<String, Object>> response) {
                if (response.body() instanceof HashMap) {


                    if (response.body().containsKey("affected_rate")){

                        Log.d("risk",response.body().get("affected_rate").toString());
                            Toast toast=Toast.makeText(getApplicationContext(),"Risk...."+(response.body().get("affected_rate").toString()),Toast.LENGTH_SHORT);
                            toast.show();
                    }
                }
            }

            @Override
            public void onFailure(Call<HashMap<String, Object>> call, Throwable t) {
                Toast toast=Toast.makeText(getApplicationContext(),"failed"+t,Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }
});
    }
}