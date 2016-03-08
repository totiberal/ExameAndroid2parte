package exame.exameparte2_a14albertoab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    ArrayList<String> elementos=new ArrayList<>();
    ArrayList<Integer> prezos=new ArrayList<>();
    Intent intent;
    ListView lista;
    RadioButton rbEstandar, rbUrxente;
    Button btnTransporte;
    TextView tv;
    static int total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        rbUrxente=(RadioButton) findViewById(R.id.idUrxente);
        rbEstandar=(RadioButton) findViewById(R.id.idEstandar);
        btnTransporte=(Button) findViewById(R.id.idTransporte);
        total=0;
        tv=(TextView) findViewById(R.id.idTexto);
        intent=getIntent();
        elementos=intent.getExtras().getStringArrayList("elementos");
        prezos=intent.getExtras().getIntegerArrayList("prezos");
        lista=(ListView) findViewById(R.id.idlista);
        String[] myArray = elementos.toArray(new String[elementos.size()]);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myArray );
        lista.setAdapter(adaptador);
        for(Integer p: prezos) total=total+p;
        tv.setText("O total sen transporte e: "+total);
        btnTransporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rbEstandar.isChecked()) total=total+5;
                if(rbUrxente.isChecked()) total=total+10;
                tv.setText("O total con transporte incluido e: "+total);
                btnTransporte.setEnabled(false);
            }
        });

    }
}
