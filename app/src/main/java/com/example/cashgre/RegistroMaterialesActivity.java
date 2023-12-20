package com.example.cashgre;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.cashgre.commons.CostoElementos;
import androidx.appcompat.app.AppCompatActivity;

public class RegistroMaterialesActivity extends AppCompatActivity {

    private EditText[] editTexts;
    private EditText totalEditText;
    private EditText totalCostEditText;

    private final CostoElementos[] listadoCostos = CostoElementos.values();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingreso_materiales);

        int totalEdit = 7;
        editTexts = new EditText[totalEdit];
        editTexts[0]= findViewById(R.id.editText1);
        editTexts[1]= findViewById(R.id.editText2);
        editTexts[2]= findViewById(R.id.editText3);
        editTexts[3]= findViewById(R.id.editText4);
        editTexts[4]= findViewById(R.id.editText5);
        editTexts[5]= findViewById(R.id.editText6);
        editTexts[6]= findViewById(R.id.editText7);

        totalEditText = findViewById(R.id.totalEditText);
        totalCostEditText = findViewById(R.id.totalCostEditText);

        for (EditText editText : editTexts) {
            setEditTextWatcher(editText);
        }
    }

    private void calculateTotal() {
        double total = 0;
        double totalCost = 0;
        for (int i = 0; i < editTexts.length; i++)  {
            if (!editTexts[i].getText().toString().isEmpty()) {
                double amount = Double.parseDouble(editTexts[i].getText().toString());
                total += amount;
                totalCost += amount * listadoCostos[i].getCosto();
            }
        }

        totalEditText.setText(String.valueOf(total));
        totalCostEditText.setText(String.valueOf(totalCost));
    }

    private void setEditTextWatcher(final EditText editText) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                calculateTotal();
            }
        });
    }

    private void createOrder(){
        Intent intent = new Intent(RegistroMaterialesActivity.this, GestionOrdenesActivity.class);
        startActivity(intent);
    }

    public void calculateTotal(View view) {
        calculateTotal();
        Toast.makeText(this, "Orden realizada!!\n Recibes $" +
                totalCostEditText.getText().toString(), Toast.LENGTH_SHORT).show();
        createOrder();
    }

}
