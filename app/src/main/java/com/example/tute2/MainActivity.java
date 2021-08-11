package com.example.tute2;

import static com.example.tute2.R.id.btn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_temp;
    RadioButton rd_btn_f;
    RadioButton rd_btn_c;
    Button btn;
    TextView txt;

    @Override
    protected void onResume() {
        super.onResume();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer();
            }
        });
    }
    private void calculateAnswer() {
        calculations cal = new calculations();
        String value = et_temp.getText().toString();

        if(TextUtils.isEmpty(value)){
            Toast.makeText(this, "Please add a value",
                    Toast.LENGTH_LONG).show();
        }
        else{
            Float temp = Float.parseFloat(value);
            if(rd_btn_f.isChecked()){
                temp = cal.convertFahrenheitToCelcius(temp);

        // convert it into Fahrenheit and display the answer
            }
            else if(rd_btn_c.isChecked()){
                temp = cal.convertCelciusToFahrenheit(temp);
            }else{
                Toast.makeText(this, "Select the radio button!", Toast.LENGTH_LONG).show();
                temp=0.0f;
            }
            txt.setText(new Float(temp).toString());
        }
    }
}