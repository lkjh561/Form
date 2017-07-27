package com.example.user.form;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button bt1,bt2;
    public static String www=" ";
    public static String ww;
    JSONObject jsonObject = new JSONObject();
    HttpURLConnection urlConnection = null; //可以跟網站做溝通的物件
    URL url = null;
    StringBuilder sb;
    int b=0;
    String[] B = new String[20];
    static final ArrayList<String> temp = new ArrayList<String>();
    Thread th;
    //  SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1=(Button)findViewById(R.id.Excel);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                th= new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            url = new URL("http://192.168.43.180/test/readExcel.php");
                            urlConnection = (HttpURLConnection) url.openConnection();
                            urlConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                            urlConnection.setRequestProperty("Accept", "application/json");
                            urlConnection.setRequestMethod("POST");
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (ProtocolException e) {
                            e.printStackTrace();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }
                        urlConnection.setDoOutput(true);
                        urlConnection.setDoInput(true);
                        try {
                            OutputStreamWriter out = null;


                            out=new OutputStreamWriter(urlConnection.getOutputStream());
                            Log.e("HTTP",jsonObject.toString());
                            out.write(jsonObject.toString());
                            out.close();

                            int  HttpResult=urlConnection.getResponseCode();
                            sb=new StringBuilder();
                            Log.e("HTTP",HttpResult+"-------");
                            if(HttpResult==HttpURLConnection.HTTP_OK){
                                BufferedReader br=new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"utf-8"));

                                while ((www=br.readLine())!=null){


                                    //tv.setText(www);
                                    B= www.split(";");
                                    Log.e("B", B[1]);
                                    for (int i = 1; i < B.length; i++){
                                        temp.add(B[i]);

                                    } //temp.add(0, "-----ChooseUser-----");
                                    Log.e("Line",www);
                                    //sb.append(line);
                                    //  A=www.split(";");

                                    // AA.add(A[1],A[2]);
                                    //   Message msg  =

                                    //  Log.e("AA", AA[1]);


                           /* msg = mHandler.obtainMessage();
                            //  mHandler.sendMessage(msg);

                            Bundle b = new Bundle();
                            b.putString("Awww", www);
                            Log.e("AWWW",www);
                       msg.setData(b);
                        msg.sendToTarget();
                        */}

                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }



                    }

                };
                th.start();
                b++;

            }
        });
        bt2=(Button)findViewById(R.id.button4);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i  = new Intent();
                i.setClass(MainActivity.this,insert.class);
                startActivity(i);
                finish();
            }
        });

    }


}