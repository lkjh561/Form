package com.example.user.form;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class insert extends AppCompatActivity {
    public static String www=" ";
    public static String ww;
    MainActivity array=new MainActivity();
    EditText et1,et2 ,set_user_user;
    TextView tv1;
    Spinner spinner;
    Button bt1,bt2;
    JSONObject jsonObject = new JSONObject();
    HttpURLConnection urlConnection = null; //可以跟網站做溝通的物件
    URL url = null;
    StringBuilder sb;
     int a=0;
  //  final ArrayList<String> temp = new ArrayList<String>();
    int set_userPosition=0;
    boolean secondTel=false;
    // String M=A.www ;

    Message msg;
    Handler mHandler;

    TextView tv;
    //  SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        et1 = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
       // set_user_user=(EditText)findViewById(R.id.editText3);
        spinner=(Spinner)findViewById(R.id.spinner);
        tv = (TextView)findViewById(R.id.textView);
        bt1=(Button)findViewById(R.id.button) ;
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i  = new Intent();
                i.setClass(insert.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        //mmmmmm tv1=(TextView)findViewById(R.id.textView3) ;
      /*  mHandler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Bundle b = msg.getData();
                ww = b.getString("Awww");
                Log.e("Awww",ww);
                //        Log.e("wwwA",www);
            }
        };*/


        // String ss = tv.getText().toString();
        // Log.e("A",ss);
        // A = ss.split(";");
        //     Log.e("Awww2",ww);
        //
        // Log.e("A",A[1]);
        // Log.e("A",A[1]);
Log.e("ARRAY", String.valueOf(array.temp));
            setSpinner();
            // set_secondTelSpinner = (Spinner) findViewById(R.id.set_secondTelSpinner);
            //  ArrayList<String> Switch = new ArrayList<String>();




           /* spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                    // TODO Auto-generated method stub
                    TextView sptv = (TextView) arg1;
                    sptv.setGravity(Gravity.CENTER);
                    set_userPosition = arg2;

                    /*if (set_userPosition != 0) {
                        user_id = Integer.parseInt(sqlite.all_user
                                .get(set_userPosition - 1)[0]);
                        user_name = sqlite.all_user.get(set_userPosition - 1)[1];
                        set_userw.setText(user_name + "");
                        set_user_user.setText(sqlite.all_user
                                .get(set_userPosition - 1)[2]);
                        set_user_tel.setText(sqlite.all_user
                                .get(set_userPosition - 1)[3]);
                        set_user_mail.setText(sqlite.all_user
                                .get(set_userPosition - 1)[4]);

                        String[] get_temp = sqlite.all_user
                                .get(set_userPosition - 1)[5].split("~");

                        if (sqlite.all_user.get(set_userPosition - 1)[8].equals("C")) {
                            tempIsF = false;
                            set_cfchangePosition = 0;
                            set_cfchange.setSelection(set_cfchangePosition);
                            set_temp1.setAdapter(set_temp1adc);
                            set_temp2.setAdapter(set_temp2adc);

                            set_temp1Position_c = Integer.parseInt(get_temp[0]) - 30;
                            set_temp1.setSelection(set_temp1Position_c);

                            if (get_temp[1].equals("37.0")) {
                                set_temp2Position_c = 0;
                                set_temp2.setSelection(set_temp2Position_c);
                            } else if (get_temp[1].equals("38.0")) {
                                set_temp2Position_c = 1;
                                set_temp2.setSelection(set_temp2Position_c);
                            } else if (get_temp[1].equals("38.5")) {
                                set_temp2Position_c = 2;
                                set_temp2.setSelection(set_temp2Position_c);
                            } else if (get_temp[1].equals("39.0")) {
                                set_temp2Position_c = 3;
                                set_temp2.setSelection(set_temp2Position_c);
                            } else if (get_temp[1].equals("39.5")) {
                                set_temp2Position_c = 4;
                                set_temp2.setSelection(set_temp2Position_c);
                            } else {
                                set_temp2Position_c = (int) (Float
                                        .parseFloat(get_temp[1]) - 37 + 2);
                                set_temp2.setSelection(set_temp2Position_c);
                            }

                        } else {
                            tempIsF = true;
                            set_cfchangePosition = 1;
                            set_cfchange.setSelection(set_cfchangePosition);
                            set_temp1.setAdapter(set_temp1adf);
                            set_temp2.setAdapter(set_temp2adf);

                            set_temp1Position_f = (int) (Float
                                    .parseFloat(get_temp[0]) - 86);

                            set_temp1.setSelection(set_temp1Position_f);
                            set_temp2Position_f = (int) (Float
                                    .parseFloat(get_temp[1]) - 98);
                            set_temp2.setSelection(set_temp2Position_f);
                        }

                        if (sqlite.all_user.get(set_userPosition - 1)[7]
                                .equals("0")) {
                            set_EcontactwayPosition = 0;
                            set_Econtactway.setSelection(set_EcontactwayPosition);
                        } else {
                            set_EcontactwayPosition = 1;
                            set_Econtactway.setSelection(set_EcontactwayPosition);
                        }
                        int setMin = Integer.parseInt(sqlite.all_user
                                .get(set_userPosition - 1)[6]) / 60;
                        set_minPosition = setMin;
                        set_minw.setSelection(set_minPosition);
                        int setSec = Integer.parseInt(sqlite.all_user
                                .get(set_userPosition - 1)[6]) - (setMin * 60);
                        set_secPosition = setSec;
                        set_secw.setSelection(set_secPosition);
                    } else {
                        set_userPosition = 0;
                        set_userspinner.setSelection(set_userPosition);
                        user_id = 0;
                        user_name = null;
                        set_userw.setText("");
                        set_user_user.setText("");
                        set_user_tel.setText("");
                        set_user_mail.setText("");

                        set_minPosition = 0;
                        set_secPosition = 10;
                        set_temp1Position_c = 2;
                        set_temp2Position_c = 1;
                        set_EcontactwayPosition = 0;
                        set_cfchangePosition = 0;

                        set_Econtactway.setSelection(set_EcontactwayPosition);
                        set_temp1.setSelection(set_temp1Position_c);
                        set_temp2.setSelection(set_temp2Position_c);
                        set_cfchange.setSelection(set_cfchangePosition);
                        set_minw.setSelection(set_minPosition);
                        set_secw.setSelection(set_secPosition);
                    }
                    if (set_userw.getText().toString() == null) {
                        set_userw.setText("");
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                    // TODO Auto-generated method stub

                }

            });*/

        //     }
      /*  mhandler = new Handler() {
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case 0:
                        Bundle bundle=msg.getData();
                        String showtext=bundle.getString("showtext","錯誤");
                        tv.setText(tv.getText()+"\n"+showtext);
                        break;
                }

            }



        };*/

        bt2 = (Button) findViewById(R.id.button2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            url = new URL("http://192.168.43.180/test/readin.php");
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
                        String name=String.valueOf(spinner.getSelectedItem());
                        String ingredient= String.valueOf(et1.getText());
                        String quantity=String.valueOf(et2.getText());
                        try {
                            jsonObject.put("name",name);
                            jsonObject.put("ingredient",ingredient);
                            jsonObject.put("quantity",quantity);

                            Log.e("555",name+ingredient+quantity);
                            a++;
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
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
                                String line=null;
                                while ((line=br.readLine())!=null){
                                    Log.e("Line",line);
                                    sb.append(line);
                                }
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }


                }.start();

                if(a==0){  Toast.makeText(view.getContext(), "新增失敗", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(view.getContext(), "新增成功!!", Toast.LENGTH_SHORT).show();
                }
            }

        });


    }
    public void setSpinner(){
        Log.e("Awww2", String.valueOf(array.temp));
//for (int i=1;i<temp.size();i++){
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, array.temp);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //  Switch.add(switchOption[phonestate.language][1]);
        // Switch.add(switchOption[phonestate.language][0]);
        // ArrayAdapter<String> SwitchAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Switch); //QWE
        // SwitchAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        if (secondTel) {
            spinner.setSelection(1);
            set_user_user.setEnabled(true);
        }

       /* spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    secondTel = false;
                    set_user_user.setEnabled(false);
                    SharedPreferences sharedPreferences = getSharedPreferences("SecondTel", 0);
                    sharedPreferences.edit().putBoolean("switch", false).commit();
                } else {
                    secondTel = true;
                    set_user_user.setText(array.temp.get(position-1));
                    set_user_user.setEnabled(true);
                    SharedPreferences sharedPreferences = getSharedPreferences("SecondTel", 0);
                    sharedPreferences.edit().putBoolean("switch", true).commit();
                    Log.e("Temp",array.temp.get(position-1));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });*/
    }


}