package com.wings.munchit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SIGNUP extends AppCompatActivity {
    Button submit;
    EditText name,password,phone;
    TextView condition;
    DatabaseHelper databaseinsertion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name=(EditText)findViewById(R.id.fname);

        password=(EditText)findViewById(R.id.setpassword);
        phone=(EditText)findViewById(R.id.phone);
        condition=(TextView)findViewById(R.id.condition);

        submit=(Button)findViewById(R.id.submit);
        databaseinsertion=new DatabaseHelper(this);
        AddData();

    }
    public  void AddData(){
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((name.getText().toString().equals("")) || (password.getText().toString().equals("")) || (phone.getText().toString().equals(""))) {
                    condition.setText("please enter all information.");
                } else {


                    boolean rate = databaseinsertion.insertData(name.getText().toString(), phone.getText().toString(), password.getText().toString());
                    if (rate == true) {


                        Toast.makeText(SIGNUP.this, "YOU ARE SUCSSFULLY SIGNED IN", Toast.LENGTH_LONG).show();
                        condition.setText("");
                    }



                    else
                        Toast.makeText(SIGNUP.this, "data is not  inserted", Toast.LENGTH_LONG).show();
                }}


        });

    }
}
