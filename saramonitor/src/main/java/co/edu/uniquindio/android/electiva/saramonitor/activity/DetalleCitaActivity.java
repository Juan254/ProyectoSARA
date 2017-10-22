package co.edu.uniquindio.android.electiva.saramonitor.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

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
        Citas cita = (Citas) getIntent().getExtras().get("citas");
        citaFragment.setPosicion(posicion_cita);
        citaFragment.mostrarCita(cita);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
