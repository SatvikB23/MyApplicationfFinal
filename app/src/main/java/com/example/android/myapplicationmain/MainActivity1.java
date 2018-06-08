package com.example.android.myapplicationmain;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.EasyEditSpan;
import android.view.View;
import android.widget.EditText;

import java.io.File;

public class MainActivity1 extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);


    }

    public void onClick(View view) {
        // Create a new intent to open the {@link MainActivity2}
        EditText userName=(EditText)findViewById(R.id.user_name);
        String theName=userName.getText().toString();
        theName = theName.replace(" ", "");
        theName+=".txt";
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("MESSAGE", theName);
        finish();
        startActivity(intent);
        // Start the new activity
            }
}


