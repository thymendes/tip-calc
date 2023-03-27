package com.thyago.viladospets.calculadoradegorjetas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tipTotalTextView;
    TextView totalTextView;
    Button calcTip;
    EditText inputBill;
    EditText inputTip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tipTotalTextView = (TextView) findViewById(R.id.tiptextview);
        totalTextView = (TextView) findViewById(R.id.totaltextview);
        calcTip = (Button)findViewById(R.id.calcular);
        inputBill = (EditText) findViewById(R.id.inputtextview);
        inputTip = (EditText) findViewById(R.id.percentage);

        calcTip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcTheTip();
            }
        });
    }

    void calcTheTip(){
        // get the start number for the bill
        Double billTotal = Double.valueOf(inputBill.getText().toString());
        //Determine the porcentage
        Double calcPorcent = Double.valueOf(inputTip.getEditableText().toString());
        // Determine the tip
        Double tipTotal = (billTotal * calcPorcent)/100;
        // Display the tip
        tipTotalTextView.setText("Tip Total - $" + String.format("%.2f", tipTotal));
        //Determine the total
        Double total = billTotal + tipTotal;
        //Display the Total
        totalTextView.setText("Total - $" + String.format("%.2f", total));
    }
}