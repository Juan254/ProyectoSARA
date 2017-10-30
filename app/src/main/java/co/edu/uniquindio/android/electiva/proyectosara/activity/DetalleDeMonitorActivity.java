package co.edu.uniquindio.android.electiva.proyectosara.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import co.edu.uniquindio.android.electiva.proyectosara.R;
import co.edu.uniquindio.android.electiva.proyectosara.fragments.DetalleDeMonitorFragment;
import co.edu.uniquindio.android.electiva.proyectosara.vo.Monitor;

public class DetalleDeMonitorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_de_monitor);

        Monitor monitor = (Monitor) getIntent().getExtras().getParcelable("monitor");
        Log.e("monitor: ", monitor.toString());

        DetalleDeMonitorFragment detalleDeMonitorFragment = (DetalleDeMonitorFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_monitor);
        detalleDeMonitorFragment.mostrarMonitor(monitor);
    }
}
