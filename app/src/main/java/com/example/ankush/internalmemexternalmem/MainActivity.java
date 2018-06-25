package com.example.ankush.internalmemexternalmem;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    Button btnSE,btnSI,btnRE,btnRI;
    EditText etData;
    TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRE = (Button)findViewById(R.id.btnRE);
        btnRI = (Button)findViewById(R.id.btnRI);
        btnSE = (Button)findViewById(R.id.btnSE);
        btnSI = (Button)findViewById(R.id.btnSI);
        etData = (EditText)findViewById(R.id.etData);
        tvData = (TextView)findViewById(R.id.tvData);

        btnSI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = etData.getText().toString();
                try{
                    FileOutputStream fos= openFileOutput("f1.txt",MODE_PRIVATE);
                    fos.write(data.getBytes());
                    fos.close();
                    Toast.makeText(MainActivity.this, "Data saved!", Toast.LENGTH_SHORT).show();
                    etData.setText("");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnRI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String line;
                StringBuffer sb = new StringBuffer();
                try{
                    FileInputStream fis = openFileInput("f1.txt");
                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader br = new BufferedReader(isr);
                    while((line = br.readLine())!=null){
                        sb.append(line+"\n");
                    }
                    tvData.setText(sb.toString());
                    br.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        btnSE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = etData.getText().toString();
                try{
                    FileOutputStream fos= new FileOutputStream("/sdcard/"+"f1.txt");
                    fos.write(data.getBytes());
                    fos.close();
                    Toast.makeText(MainActivity.this, "Data saved!", Toast.LENGTH_SHORT).show();
                    etData.setText("");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnRE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String line;
                StringBuffer sb = new StringBuffer();
                try{
                    FileInputStream fis = new FileInputStream("/sdcard/"+"f1.txt");
                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader br = new BufferedReader(isr);
                    while((line = br.readLine())!=null){
                        sb.append(line+"\n");
                    }
                    tvData.setText(sb.toString());
                    br.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
