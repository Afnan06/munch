
package com.wings.munchit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LOGIN extends AppCompatActivity {
    Button signup,Login,lg;
    DatabaseHelper dhelp;
    EditText name,password;
    String password1,username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signup=(Button)findViewById(R.id.signup);
        name=findViewById(R.id.editText);
        username=name.getText().toString();
        password=findViewById(R.id.editText2);
        password1=password.getText().toString();
        Login=(Button)findViewById(R.id.Login);
        //lg=(Button)findViewById(R.id.button);
        dhelp=new DatabaseHelper(this);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LOGIN.this,SIGNUP.class);
                startActivity(intent);
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass=dhelp.search(name.getText().toString());
                Toast.makeText(LOGIN.this,name.getText().toString() ,Toast.LENGTH_LONG).show();

                if (pass.equals(password.getText().toString())) {
                    startActivity(new Intent(LOGIN.this,Home.class));
                }
                else {

                    Toast.makeText(LOGIN.this, "UserName is not registered.",Toast.LENGTH_LONG).show();
                }

            }
        });
       // Viewdata();

    }
    public void Viewdata(){
        lg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor result= dhelp.getAllData();
                if( result.getCount()== 0){
                    //no sata available
                    Message("Error","No data found");
                    return;
                }
                else{
                    //SHOW ALL DATA
                    StringBuffer buffer=new StringBuffer();
                    while(result.moveToNext()){
                        buffer.append("ID :"+ result.getString(0)+"\n");
                        buffer.append("NAME :"+ result.getString(1)+"\n");
                        buffer.append("PHONE :"+ result.getString(2)+"\n");
                        buffer.append("PASSWORD :"+ result.getString(3)+"\n\n");

                    }
                    Message("Data is",buffer.toString());
                }
            }
        });
    }
    public  void Message(String title ,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }
}

