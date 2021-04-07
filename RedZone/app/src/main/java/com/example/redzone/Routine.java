package com.example.redzone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Routine extends AppCompatActivity {
Button s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine);
        s=(Button) findViewById(R.id.sendtodatabase);

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a="{\n" +
                        "    \"covid_positive\": \"true\",\n" +
                        "    \"visited_outside\": \"false\",\n" +
                        "    \"other_interaction\": \"false\",\n" +
                        "    \"wore_mask\": \"true\",\n" +
                        "    \"wore_ppe\": \"false\",\n" +
                        "    \"location\": \"Rajabazar\"\n" +
                        "}";

                Call<HashMap<String, Object>> call = RetrofitClient.getInstance().getMyApi().routinenew(a,Login.tokenrec);
            call.enqueue(new Callback<HashMap<String, Object>>() {
                @Override
                public void onResponse(Call<HashMap<String, Object>> call, Response<HashMap<String, Object>> response) {
                    if (response.body() instanceof HashMap) {


                        if (response.body().containsKey("token")){

                            if( Login.tokenrec.equals(response.body().get("token").toString()))
                            {
                                Toast toast=Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT);
                                toast.show();
                            } else{


                                Toast toast=Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_SHORT);
                                toast.show();

                            }

                        }




                    }
                }

                @Override
                public void onFailure(Call<HashMap<String, Object>> call, Throwable t) {
                    Toast toast=Toast.makeText(getApplicationContext(),"Failed"+t,Toast.LENGTH_SHORT);
                    toast.show();

                }
            });



            }
        });


    }
}