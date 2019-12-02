package com.example.sqlitedemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsertData extends AppCompatActivity {

    EditText pin,name,dept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);
        pin=(EditText)findViewById(R.id.pin);
        name=(EditText)findViewById(R.id.name);
        dept=(EditText)findViewById(R.id.dept);
    }

    public void addRecord (View view)
    {

     Dbmanager db=new Dbmanager(this);


     String res=db.addRecord(pin.getText().toString(),name.getText().toString(),dept.getText().toString());

        Toast.makeText(this,res,Toast.LENGTH_LONG).show();

        pin.setText("");
        name.setText("");
        dept.setText("");

    }
}
