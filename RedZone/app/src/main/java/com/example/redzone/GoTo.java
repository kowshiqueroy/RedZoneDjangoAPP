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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GoTo extends AppCompatActivity {
Button pb,gh,gp;
EditText gotolocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_to);
pb= (Button) findViewById(R.id.pb);
        gh= (Button) findViewById(R.id.gh);
        gp= (Button) findViewById(R.id.gp);
gotolocation= (EditText) findViewById(R.id.gotolocation);

gh.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i1= new Intent(GoTo.this,Home.class);
        startActivity(i1);
    }
});

        gp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1= new Intent(GoTo.this,Predictions.class);
                startActivity(i1);
            }
        });


pb.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Log.d("input", gotolocation.getText().toString());
        Call<HashMap<String, Object>> call = RetrofitClient.getInstance().getMyApi().gotonew(gotolocation.getText().toString());
        call.enqueue(new Callback<HashMap<String, Object>>() {
            @Override
            public void onResponse(Call<HashMap<String, Object>> call, Response<HashMap<String, Object>> response) {
                if (response.body() instanceof HashMap) {

                    Log.d("risk", "res");
                    if (response.body().containsKey("affected_rate")){

                        Log.d("risk",""+response.body().get("affected_rate"));
                            Toast toast=Toast.makeText(getApplicationContext(),"Risk...."+(response.body().get("affected_rate")+"%"),Toast.LENGTH_SHORT);
                            toast.show();

                    }
                    else {
                        Toast toast=Toast.makeText(getApplicationContext(),"No data",Toast.LENGTH_SHORT);
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