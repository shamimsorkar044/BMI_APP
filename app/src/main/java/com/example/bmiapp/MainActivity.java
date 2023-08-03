package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mcalculatebmi;

    TextView mcurrentheight, mcurrentweight, mcurrentage;

    ImageView mincrementage, mincrementweight, mdecrementage, mdecrementweight;

    SeekBar mseekbarforheight;

    RelativeLayout mmale, mfemale;


    int intweight = 55, intage = 22, currentprogress;

    String mintprogress = "170";
    String typeofuser = "0";
    String weight2 = "55";
    String age2 = "22";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mcalculatebmi = (Button) findViewById(R.id.calculatebmi);
        mcurrentage = (TextView) findViewById(R.id.currentage);
        mcurrentweight = (TextView) findViewById(R.id.currentweight);
        mcurrentheight = (TextView) findViewById(R.id.currentheight);

        mincrementage = (ImageView) findViewById(R.id.incrementage);
        mdecrementage = (ImageView) findViewById(R.id.decrementage);
        mincrementweight = (ImageView) findViewById(R.id.incrementweight);
        mdecrementweight = (ImageView) findViewById(R.id.decrementweight);

        mseekbarforheight = (SeekBar) findViewById(R.id.seekbarforheight);

        mmale = (RelativeLayout) findViewById(R.id.male);
        mfemale = (RelativeLayout) findViewById(R.id.female);




        mmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalefocus));
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalenotfocus));
                typeofuser = "Male";
            }
        });



        mfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalefocus));
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalenotfocus));
                typeofuser = "Female";
            }
        });



        mseekbarforheight.setMax(300);
        mseekbarforheight.setProgress(170);
        mseekbarforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentprogress = progress;
                mintprogress = String.valueOf(currentprogress);
                mcurrentheight.setText(mintprogress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




        mincrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage = intage + 1;
                age2 = String.valueOf(intage);
                mcurrentage.setText(age2);
            }
        });



        mdecrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage = intage - 1;
                age2 = String.valueOf(intage);
                mcurrentage.setText(age2);
            }
        });



        mincrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight = intweight + 1;
                weight2 = String.valueOf(intweight);
                mcurrentweight.setText(weight2);
            }
        });


        mdecrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight = intweight - 1;
                weight2 = String.valueOf(intweight);
                mcurrentweight.setText(weight2);
            }
        });



        mcalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (typeofuser.equals("0")){
                    Toast.makeText(getApplicationContext(), "Select your gender first", Toast.LENGTH_SHORT).show();
                }

                else if (mintprogress.equals("0")) {
                    Toast.makeText(getApplicationContext(), "Select your height first", Toast.LENGTH_SHORT).show();
                }

                else if (intage <= 0) {
                    Toast.makeText(getApplicationContext(), "Age Is Incorrect", Toast.LENGTH_SHORT).show();
                }

                else if (intweight <= 0) {
                    Toast.makeText(getApplicationContext(), "Weight Is Incorrect", Toast.LENGTH_SHORT).show();
                }

                else {
                    Intent intent = new Intent(MainActivity.this, bmiactivity.class);
                    intent.putExtra("gender", typeofuser);
                    intent.putExtra("height", mintprogress);
                    intent.putExtra("weight", weight2);
                    intent.putExtra("age", age2);




                    startActivity(intent);
                }


            }
        });
    }
}