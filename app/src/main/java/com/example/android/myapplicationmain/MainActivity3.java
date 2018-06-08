package com.example.android.myapplicationmain;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class MainActivity3 extends AppCompatActivity {
    String theName;
    String fileContents;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Bundle extras = getIntent().getExtras();
        theName = extras.getString("NAME");
        fileContents = extras.getString("CONTENT");
        createFile(theName,fileContents);
    }

    public void onClick(View view) {
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setClickable(true);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        try {
            FileInputStream fileInputStream= openFileInput(theName);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            String lines;
            while ((lines=bufferedReader.readLine())!=null) {
                stringBuffer.append(lines+"\n");
            }
            textView2.setText(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            textView2.setText("filenotfound");
        } catch (UnsupportedEncodingException e) {
            textView2.setText("UEE");}
            catch (IOException e) {
                textView2.setText("IOEx");
        }

    }
    public void createFile(String name,String contents){
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText("The file has been saved with name " + name +" at\n " +getFilesDir()+"/"+name+"\n For viewing contents of the file please click the button below");
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(name, Context.MODE_PRIVATE);
            outputStream.write(contents.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void onClick2(View v){
        deleteFile(theName);
        EditText userName=(EditText)findViewById(R.id.new_name);
        String newName=userName.getText().toString();
        newName = newName.replace(" ", "");
        newName+=".txt";
        theName=newName;
        createFile(theName,fileContents);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(" ");
    }
    public void openFile(String name){

    }
}




