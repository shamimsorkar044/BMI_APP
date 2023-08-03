package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import java.text.DecimalFormat;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class bmiactivity extends AppCompatActivity {

   Button mrecalculatebmi;

   TextView mbmidisplay, mbmicategory, mgender;

   Intent intent;

   ImageView mimageview;

   String mbmi;

   float intbmi;

   String height, weight;

   float intheight, intweight;

   RelativeLayout mbackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);




        intent = getIntent();
        mbmidisplay = (TextView) findViewById(R.id.bmidisplay);
        mbmicategory = (TextView) findViewById(R.id.bmicategory);
        mgender = (TextView) findViewById(R.id.genderdisplay);


        mbackground = (RelativeLayout) findViewById(R.id.contentlayout);

        mimageview = (ImageView) findViewById(R.id.imageview);


        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");

        intheight = Float.parseFloat(height);
        intweight = Float.parseFloat(weight);

        intheight = intheight / 100;


        intbmi = intweight / (intheight * intheight);

        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        mbmi = decimalFormat.format(intbmi);


        if (intbmi < 16) {
            mbmicategory.setText("Severe Thinness");
            mbackground.setBackgroundColor(Color.RED);
        }

        else  if (intbmi < 16.9 && intbmi > 16) {
            mbmicategory.setText("Moderate Thinness");
            mbackground.setBackgroundColor(Color.RED);
        }

        else  if (intbmi < 18.4 && intbmi > 17) {
            mbmicategory.setText("Mild Thinness");
            mbackground.setBackgroundColor(Color.RED);

        }

        else  if (intbmi < 25 && intbmi > 18.4) {
            mbmicategory.setText("Normal");


        }

        else  if (intbmi < 29.4 && intbmi > 25) {
            mbmicategory.setText("Overweight");
            mbackground.setBackgroundColor(Color.RED);

        }

        else {
            mbmicategory.setText("Obese class");
            mbackground.setBackgroundColor(Color.RED);
        }


        mgender.setText(intent.getStringExtra("gender"));

        mbmidisplay.setText(mbmi);



        mrecalculatebmi = (Button) findViewById(R.id.recalculatebmi);
        mrecalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bmiactivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}