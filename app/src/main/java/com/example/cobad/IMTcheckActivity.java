package com.example.cobad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.cobad.Database.DBHelper;

import java.text.DecimalFormat;

public class IMTcheckActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    Button cekButton;
    public static final String EXTRA_DATE = "extra_date";
    public static final String EXTRA_NAME= "extra_name";
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imt_check);
        cekButton = (Button) findViewById(R.id.cek);
        radioGroup = findViewById(R.id.RadioGroup);
        EditText Tinggi = (EditText) findViewById(R.id.tgi);
        EditText Berat = (EditText) findViewById(R.id.brt);
        String NameValue= getIntent().getStringExtra(EXTRA_NAME);
        String DateValue = getIntent().getStringExtra(EXTRA_DATE);

        //inisialisasi database
        DB = new DBHelper(this);

        cekButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();

               cekButton = findViewById(radioId);
               String valueGender =cekButton.getText().toString();

                Integer TgDbl = Integer.parseInt(Tinggi.getText().toString());
                Integer BrDbl = Integer.parseInt(Berat.getText().toString());
                Integer IMT   = (BrDbl/((TgDbl/100)*(TgDbl/100)));


                if (IMT<18){
                    String StatusType ="Kurus";
                    Boolean checkinsertdata= DB.insertuserdata(NameValue,DateValue, IMT,StatusType,valueGender);
                    if (checkinsertdata == true){
                        Toast.makeText(IMTcheckActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();}
                    else{
                        Toast.makeText(IMTcheckActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
                    }

                    Intent ThrIntent = new Intent(IMTcheckActivity.this, Dashboard.class);
                    startActivity(ThrIntent);
                }

                if (IMT>18 && IMT<25){
                    String StatusType ="normal";
                    Boolean checkinsertdata= DB.insertuserdata(NameValue,DateValue,IMT,StatusType,valueGender);
                    if (checkinsertdata == true){
                        Toast.makeText(IMTcheckActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();}
                    else{
                        Toast.makeText(IMTcheckActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
                    }

                    Intent ThrIntent = new Intent(IMTcheckActivity.this, Dashboard.class);
                    startActivity(ThrIntent);
                }

                if (IMT>=25 && IMT<30){
                    String StatusType ="Gendut";
                    Boolean checkinsertdata= DB.insertuserdata(NameValue,DateValue,IMT,StatusType,valueGender);
                    if (checkinsertdata == true){
                        Toast.makeText(IMTcheckActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();}
                    else{
                        Toast.makeText(IMTcheckActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
                    }

                    Intent ThrIntent = new Intent(IMTcheckActivity.this, Dashboard.class);
                    startActivity(ThrIntent);
                }

                else{
                    String StatusType ="Obesitas";
                    Boolean checkinsertdata= DB.insertuserdata(NameValue,DateValue,IMT,StatusType,valueGender);
                    if (checkinsertdata == true){
                        Toast.makeText(IMTcheckActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();}
                    else{
                        Toast.makeText(IMTcheckActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
                    }

                    Intent ThrIntent = new Intent(IMTcheckActivity.this, Dashboard.class);
                    startActivity(ThrIntent);
                }


            }
        });
    }

    public void checkButton(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();
        cekButton =  findViewById(radioId);
    }
}