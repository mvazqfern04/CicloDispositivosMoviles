package com.example.aprendiendoaplicacin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle saveInstaceStat){
        super.onCreate(saveInstaceStat);
        setContentView(R.layout.activity_main);
        Toast msg = new Toast(this);
        msg.makeText(this,"Hola on create",Toast.LENGTH_SHORT).show();

        Button plus = (Button) this.findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                suma();
            }
        });

        Button minus = (Button) this.findViewById(R.id.minus);
        minus.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resta();
            }

        }));

        Button multi = (Button) this.findViewById(R.id.product);
        multi.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multiplicacion();
            }
        }));
    }
        public void suma(){
            EditText n1 = this.findViewById((R.id.numbre1));
            EditText n2 = this.findViewById((R.id.numbre2));
            int numbe1 = Integer.parseInt(n1.getText().toString());
            int numbe2 = Integer.parseInt(n2.getText().toString());
            TextView tv = this.findViewById(R.id.result);
            if(esVacio(numbe2,numbe1)) {
                tv.setText(Integer.toString(numbe1 + numbe2));
            }
        };
    public void resta(){
        EditText n1 = this.findViewById((R.id.numbre1));
        EditText n2 = this.findViewById((R.id.numbre2));
        int numbe1 = Integer.parseInt(n1.getText().toString());
        int numbe2 = Integer.parseInt(n2.getText().toString());
        TextView tv = this.findViewById(R.id.result);
        if(esVacio(numbe2,numbe1)) {
            tv.setText(Integer.toString(numbe1 - numbe2));
        }
    }

    public void multiplicacion(){
        EditText n1 = this.findViewById((R.id.numbre1));
        EditText n2 = this.findViewById((R.id.numbre2));
        int numbe1 = Integer.parseInt(n1.getText().toString());
        int numbe2 = Integer.parseInt(n2.getText().toString());
        TextView tv = this.findViewById(R.id.result);
        if(esVacio(numbe2,numbe1)) {
            tv.setText(Integer.toString(numbe1 * numbe2));
        }
    }

    public boolean esVacio(int numero,int numero2){
        boolean salida = numero==numero2&&numero==0;
        if(!salida){
            Toast msg = new Toast(this);
            msg.makeText(this,"No es posible, rellena los campos vacios",Toast.LENGTH_SHORT).show();
        }
        return salida;
    }

}