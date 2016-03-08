package exame.exameparte2_a14albertoab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnContacto, btnPedidos;
    TextView tv,tvC;
    ImageView imaxe;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnContacto=(Button) findViewById(R.id.idContacto);
        btnPedidos=(Button) findViewById(R.id.idPedidos);
        imaxe=(ImageView) findViewById(R.id.idFotica);
        tvC=(TextView) findViewById(R.id.tvContacto);
        tv=(TextView) findViewById(R.id.idTv);

        btnContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvC.setVisibility(1);
            }
        });

        btnPedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),Pedidos.class));
            }
        });
    }
}
