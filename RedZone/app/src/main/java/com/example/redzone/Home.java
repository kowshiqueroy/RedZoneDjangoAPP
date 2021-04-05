package com.example.redzone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends AppCompatActivity {
TextView t;
Button rb, gtb, pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
t=(TextView) findViewById(R.id.textView2);
        getRedUsers();
rb= (Button) findViewById(R.id.rb);
        gtb= (Button) findViewById(R.id.gtb);
        pb= (Button) findViewById(R.id.pb);


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
        Call<List<RedUser>> call = RetrofitClient.getInstance().getMyApi().getRedUsers();
        call.enqueue(new Callback<List<RedUser>>() {
            @Override
            public void onResponse(Call<List<RedUser>> call, Response<List<RedUser>> response) {
                List<RedUser> heroList = response.body();
                if (heroList!=null) {

                    t.setText(heroList.get(0).getFirst_name());
                    Log.d("1", heroList.toString());
                }
            }

            @Override
            public void onFailure(Call<List<RedUser>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}