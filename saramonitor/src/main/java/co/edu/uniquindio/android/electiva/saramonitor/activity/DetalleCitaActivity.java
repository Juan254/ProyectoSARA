package co.edu.uniquindio.android.electiva.saramonitor.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import co.edu.uniquindio.android.electiva.saramonitor.R;
import co.edu.uniquindio.android.electiva.saramonitor.fragments.DetalleCitaFragment;
import co.edu.uniquindio.android.electiva.saramonitor.vo.Citas;

public class DetalleCitaActivity extends AppCompatActivity {

    private int posicion_cita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_cita);
        DetalleCitaFragment citaFragment = (DetalleCitaFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_detalle_cita);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.tool_bar);
        myToolbar.setTitle("Detalle de la cita");
        setSupportActionBar(myToolbar);
        myToolbar.setNavigationIcon(R.drawable.back_arrow);
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Citas cita = (Citas) getIntent().getExtras().get("citas");
        citaFragment.setPosicion(posicion_cita);
        citaFragment.mostrarCita(cita);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
