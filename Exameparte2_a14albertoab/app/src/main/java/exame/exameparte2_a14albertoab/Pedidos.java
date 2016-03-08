package exame.exameparte2_a14albertoab;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Pedidos extends AppCompatActivity {
    RadioButton rb5,rb10,rb15,rbFrutas,rbCarnes;
    Button btnEngadir,btnCarrito;
    Spinner spinnerF,spinnerC;
    ArrayAdapter<String> adaptadorF, adaptadorC;
    static int numeroF,numeroC;
    static ArrayList<String> elementos=new ArrayList<>();
    static ArrayList<Integer> prezos=new ArrayList<>();
    static String[] frutas=new String[] {"Manzanas","Peras","Fresas","Tomates","Cebollas","Espinacas"};
    static String[] carnes=new String[] {"Lomo de cerdo", "Solomillo de cerdo", "Pechugas de Pollo", "Chuletas de aguja", "Solomillo de ternera", "Conejo"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);
        btnEngadir=(Button) findViewById(R.id.idEngadir);
        rb5=(RadioButton) findViewById(R.id.id5);
        rb10=(RadioButton) findViewById(R.id.id10);
        rb15=(RadioButton) findViewById(R.id.id15);
        rbFrutas=(RadioButton) findViewById(R.id.idFrutas);
        rbCarnes=(RadioButton) findViewById(R.id.idCarnes);

        spinnerF=(Spinner) findViewById(R.id.idSpinnerF);
        adaptadorF = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, frutas);
        spinnerF.setAdapter(adaptadorF);
        spinnerC=(Spinner) findViewById(R.id.idSpinnerC);
        adaptadorC = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, carnes);
        spinnerC.setAdapter(adaptadorC);
        btnCarrito=(Button) findViewById(R.id.idCarrito);

        spinnerC.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                numeroC = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerF.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                numeroF = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnEngadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbCarnes.isChecked()) {
                    elementos.add(carnes[numeroC]);
                    if (rb5.isChecked()) prezos.add(5);
                    if (rb10.isChecked()) prezos.add(10);
                    if (rb15.isChecked()) prezos.add(15);
                    Toast.makeText(getApplicationContext(), carnes[numeroC]+" engadido",Toast.LENGTH_SHORT).show();
                }
                if (rbFrutas.isChecked()) {
                    elementos.add(frutas[numeroF]);
                    if (rb5.isChecked()) prezos.add(5);
                    if (rb10.isChecked()) prezos.add(10);
                    if (rb15.isChecked()) prezos.add(15);
                    Toast.makeText(getApplicationContext(),frutas[numeroF]+" engadido",Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(elementos.isEmpty()) Toast.makeText(getApplicationContext(),"Introduce elementos antes de lanzar esta activity",Toast.LENGTH_SHORT).show();
                else{
                    Intent intent=new Intent(getBaseContext(),Main2Activity.class);
                    intent.putStringArrayListExtra("elementos",elementos);
                    intent.putIntegerArrayListExtra("prezos", prezos);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        elementos.clear();
        prezos.clear();
    }

}
