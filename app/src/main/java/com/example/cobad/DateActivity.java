package com.example.cobad;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateActivity extends AppCompatActivity {
    TextView editText1;
    Button btn1;

    DatePickerDialog.OnDateSetListener onDateSetListener;

    public static final String EXTRA_NAME= "extra_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        editText1 = (AutoCompleteTextView) findViewById(R.id.Editdate);
        final Calendar c = Calendar.getInstance();
        int Year = c.get(Calendar.YEAR);
        int Month = c.get(Calendar.MONTH);
        int Day = c.get(Calendar.DAY_OF_MONTH);

        btn1 = (Button) findViewById(R.id.btn1);

        editText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        DateActivity.this, android.R.style.Theme_Holo_Dialog_MinWidth,
                        onDateSetListener,Year,Month,Day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        onDateSetListener =  new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int Year, int  Month, int DayOfMonth) {
                Month = Month+1;
                String date =  DayOfMonth+"/"+Month+"/"+Year;
                editText1.setText(date);

            }
        };


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date=editText1.getText().toString().trim();
                String name = getIntent().getStringExtra(EXTRA_NAME);
                Intent moveWithDataIntent = new Intent(DateActivity.this, IMTcheckActivity.class);
                moveWithDataIntent.putExtra(IMTcheckActivity.EXTRA_DATE, date );
                moveWithDataIntent.putExtra(IMTcheckActivity.EXTRA_NAME, name );
                startActivity(moveWithDataIntent);

            }
        });
    }


}