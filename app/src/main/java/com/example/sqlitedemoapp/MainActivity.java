package com.example.sqlitedemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button) findViewById(R.id.clkme);
        b.setOnClickListener(new View.OnClickListener()  {

            @Override
            public void onClick (View v)

            {

                Toast.makeText(getApplicationContext(),"",Toast.LENGTH_LONG).show();
                Intent i =new Intent(MainActivity.this, InsertData.class);
                startActivity(i);
                // startActivities(i);

            }

        });
    }
}
