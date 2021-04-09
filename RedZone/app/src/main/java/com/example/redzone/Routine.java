package com.example.redzone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.HashMap;
import java.util.concurrent.Delayed;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Routine extends AppCompatActivity {
Button s;
    RadioButton r1,r2,r3,r4,r5;
    EditText loc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine);
        s=(Button) findViewById(R.id.sendtodatabase);

        r1= (RadioButton) findViewById(R.id.radioButton1);
        r2= (RadioButton) findViewById(R.id.radioButton2);
        r3= (RadioButton) findViewById(R.id.radioButton3);
        r4= (RadioButton) findViewById(R.id.radioButton4);
        r5= (RadioButton) findViewById(R.id.radioButton5);
        loc=(EditText) findViewById(R.id.locationroutine);


        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                boolean c= r1.isChecked();
                boolean vo= r2.isChecked();
                boolean oi= r3.isChecked();
                boolean wm= r4.isChecked();
                boolean wp= r5.isChecked();

                Log.d("RadioButton", ""+c);
                String a="{\n" +
                        "    \"covid_positive\": \"" +
                        c +
                        "\",\n" +
                        "    \"visited_outside\": \"" +
                        vo +
                        "\",\n" +
                        "    \"other_interaction\": \"" +
                        oi +
                        "\",\n" +
                        "    \"wore_mask\": \"" +
                        wm +
                        "\",\n" +
                        "    \"wore_ppe\": \"" +
                        wp +
                        "\",\n" +
                        "    \"location\": \"" +
                        loc.getText().toString() +
                        "\"\n" +
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

                Intent i1= new Intent(Routine.this,Home.class);
                startActivity(i1);

            }
        });


    }
}