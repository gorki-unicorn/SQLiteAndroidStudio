package com.example.sqlitedemoapp;
import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import android.database.Cursor;
import android.app.AlertDialog;

public class InsertData extends AppCompatActivity {

    Dbmanager myDB;
    EditText pin,name,dept;

    //EditText editName,editSurname,editMarks ,editTextId;
    Button btnAddData;
    Button btnviewAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);
        myDB = new Dbmanager(this);
        //SQLiteDatabase db=myDB.getWritableDatabase();
        pin=(EditText)findViewById(R.id.pin);
        name=(EditText)findViewById(R.id.name);
        dept=(EditText)findViewById(R.id.dept);
        btnAddData = (Button)findViewById(R.id.button_add);
        btnviewAll = (Button)findViewById(R.id.button_viewAll);

        AddData();
        viewAll();
    }

    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDB.insertData(name.getText().toString(),dept.getText().toString(),pin.getText().toString() );


                        if(isInserted == true)
                            Toast.makeText(InsertData.this,"Data  Inserted",Toast.LENGTH_LONG).show();

                        else
                            Toast.makeText(InsertData.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDB.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("PIN :"+ res.getString(1)+"\n");
                            buffer.append("NAME :"+ res.getString(2)+"\n");
                            buffer.append("DEPT :"+ res.getString(3)+"\n\n");
                        }

                        // Show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
