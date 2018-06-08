package com.example.android.myapplicationmain;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class MainActivity2 extends AppCompatActivity {
    String theName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle extras = getIntent().getExtras();
        theName = extras.getString("MESSAGE");

    }

    public void onClick(View v) {
        EditText content = (EditText) findViewById(R.id.text_entered);
        String fileContents = content.getText().toString();
        Intent thirdIntent = new Intent(MainActivity2.this, MainActivity3.class);
        thirdIntent.putExtra("NAME", theName);
        thirdIntent.putExtra("CONTENT", fileContents);
        finish();
        startActivity(thirdIntent);

    }
}
