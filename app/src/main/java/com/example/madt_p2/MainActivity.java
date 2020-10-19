package com.example.madt_p2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Resources resources;
    private Spinner spinnerMethod;
    private EditText etInput;
    private TextView tvOutput;
    private Button btnCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get Input by Id
        etInput = (EditText) findViewById(R.id.etInput);
        etInput.setHint(R.string.etInput_hint);

        // Get Spinner by Id and Filling it
        spinnerMethod = (Spinner) findViewById(R.id.spinnerMethod);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.method_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMethod.setAdapter(adapter);

        // Get Output by Id
        tvOutput = (TextView) findViewById(R.id.tvOutput);

        // Get Button
        btnCount = (Button) findViewById(R.id.btnCount);
        btnCount.setText(R.string.btnCount_value);

        // Resources
        resources = getResources();
    }

    public void onBtnCountClick(View view) {

        if(etInput.getText().toString().isEmpty()) {
            tvOutput.setText("");
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, resources.getStringArray(R.array.errors)[0], Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            String spinnerValue = spinnerMethod.getSelectedItem().toString();
            String output;

            switch (spinnerValue) {
                case "Words":
                    output = StringHelper.numWords(
                            etInput.getText().toString()) + " " + resources.getStringArray(R.array.method_options)[0];
                    break;
                case "Characters":
                    output = StringHelper.numChars(
                            etInput.getText().toString()) + " " + resources.getStringArray(R.array.method_options)[1];
                    break;
                default:
                    throw new IllegalStateException(resources.getStringArray(R.array.errors)[1] + spinnerValue);
            }

            tvOutput.setText(output);
        }

    }

}