package co.edu.uniquindio.android.electiva.proyectosara.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import co.edu.uniquindio.android.electiva.proyectosara.R;
import co.edu.uniquindio.android.electiva.proyectosara.fragments.DetalleDeMonitorFragment;
import co.edu.uniquindio.android.electiva.proyectosara.vo.Monitor;

public class DetalleDeMonitorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_de_monitor);

        Monitor monitor = getIntent().getExtras().getParcelable("monitor");

        DetalleDeMonitorFragment detalleDeMonitorFragment = (DetalleDeMonitorFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_personaje);
        detalleDeMonitorFragment.mostrarMonitor(monitor);
    }
}
