package it.saimao.tainueaconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    RadioGroup rgMethod;
    RadioButton rbS2T, rbT2S;
    TextInputEditText etIn, etOut;
    Button btConvert;
    private final String TDD = "ᥖᥭᥰ";
    private final String SHN = "တႆး";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etIn = findViewById(R.id.etIn);
        etOut = findViewById(R.id.etOut);
        btConvert = findViewById(R.id.btConvert);
        rbS2T = findViewById(R.id.rbS2T);
        rbT2S = findViewById(R.id.rbT2S);
        rgMethod = findViewById(R.id.rgMethod);
        btConvert.setOnClickListener(this);
        rgMethod.setOnCheckedChangeListener(this);
        rgMethod.check(R.id.rbS2T);
    }

    @Override
    public void onClick(View view) {

        if (etIn.getText().length() <= 0) return;

        if (rbS2T.isChecked())
            etOut.setText(TaiNueaConverter.shn2tdd(etIn.getText().toString()));
        else
            etOut.setText(TaiNueaConverter.tdd2shn(etIn.getText().toString()));

    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int rb) {

        if (rb == R.id.rbS2T) {

            etIn.setHint(SHN);
            etOut.setHint(TDD);


        } else {

            etIn.setHint(TDD);
            etOut.setHint(SHN);
        }

    }
}