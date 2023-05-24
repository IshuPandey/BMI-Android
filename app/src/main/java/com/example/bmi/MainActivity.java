package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView txtResult;
        EditText edtWeight,edtHeight;
        Button btn;
        edtWeight=findViewById(R.id.edtWeight);
        edtHeight=findViewById(R.id.edtHeightFt);
        btn=findViewById(R.id.btnCalculate);
        txtResult=findViewById(R.id.txtResult);
        LinearLayout LlMain;
        LlMain=findViewById(R.id.LlMain);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //to accept weight and height we have to convert it in String format as the input is editable and then into integer
              int weight= Integer.parseInt(edtWeight.getText().toString());
              int height= Integer.parseInt(edtHeight.getText().toString());

              int totalIn=height*12;
              double totalCm=totalIn*2.53;
              double totalM=totalCm/100;
              double bmi=weight/(totalM*totalM);
              if(bmi>25)
              {
                  txtResult.setText("You are overweight");
                  LlMain.setBackgroundColor(getResources().getColor(R.color.overweight ));

              }
              else if(bmi<18)
              {
                  txtResult.setText("You are underweight");
                  LlMain.setBackgroundColor(getResources().getColor(R.color.underweight ));
              }
              else
              {
                  txtResult.setText("You are healthy");
                  LlMain.setBackgroundColor(getResources().getColor(R.color.healthy ));
              }

            }
        });
    }
}