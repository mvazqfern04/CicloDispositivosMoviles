package com.example.ejerciciosettings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class AjustesActivity extends AppCompatActivity {

    Ajustes aju;
    EditText eNom,eCorr,eEda;
    CheckBox ePubli;

    @Override
    protected void onCreate(Bundle instaGuardada){
        super.onCreate(instaGuardada);
        setContentView(R.layout.activity_main);

        //Encontramos por id
        eNom = findViewById(R.id.idNombre);
        eCorr = findViewById(R.id.idCorreo);
        eEda = findViewById(R.id.idEdad);
        ePubli = findViewById(R.id.publicidad);
        findViewById(R.id.guardar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Guardar();
            }
        });

        aju = Ajustes.getInstance(this);
        eNom.setText(aju.getNombre());
        eCorr.setText(aju.getCorreo());
        int edad = aju.getEdad(-1);
        eEda.setText(edad==-1?"":edad+"");
        ePubli.setChecked(aju.isPubli());
    }

    public void Guardar(){
        String gnombre= eNom.getText().toString();
        String gcorreo= eCorr.getText().toString();
        String gedad= eEda.getText().toString();
        boolean gpubli= ePubli.isChecked();
        if (aju.set(gnombre, gcorreo, gedad, gpubli)) {
            finish();
        }else{
            Toast.makeText(this,"Error al guardar ajustes",Toast.LENGTH_LONG).show();
        }
    }
}
