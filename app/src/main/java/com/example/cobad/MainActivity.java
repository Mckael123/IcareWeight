package com.example.cobad;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri; import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Toast;

import com.example.cobad.Database.DBHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button Next1Button = (Button) findViewById(R.id.btn1);



        Next1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText Name = (EditText) findViewById(R.id.name);
                String NameStr = Name.getText().toString();

                Intent FirstIntent = new Intent(MainActivity.this, DateActivity.class);
                FirstIntent.putExtra(DateActivity.EXTRA_NAME, NameStr);
                startActivity(FirstIntent);


            }
        });


    }
}