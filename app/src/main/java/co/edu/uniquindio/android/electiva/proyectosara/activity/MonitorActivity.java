package co.edu.uniquindio.android.electiva.proyectosara.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import co.edu.uniquindio.android.electiva.proyectosara.R;
import co.edu.uniquindio.android.electiva.proyectosara.fragments.AgregarMonitorFragment;
import co.edu.uniquindio.android.electiva.proyectosara.fragments.DetalleDeMonitorFragment;
import co.edu.uniquindio.android.electiva.proyectosara.fragments.ListaDeMonitoresFragment;
import co.edu.uniquindio.android.electiva.proyectosara.util.AdaptadorMonitor;
import co.edu.uniquindio.android.electiva.proyectosara.vo.Citas;
import co.edu.uniquindio.android.electiva.proyectosara.vo.Monitor;

public class MonitorActivity extends AppCompatActivity implements ListaDeMonitoresFragment.onMonitorSeleccionadoListener {

    private ArrayList<Monitor> monitores;
    private ArrayList<Citas> citas;
    private DetalleDeMonitorFragment fragmentoDetalle;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);

        toolbar = (Toolbar) findViewById(R.id.toolbarp);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Lista de monitores");
        citas = new ArrayList<>();
        citas.add(new Citas(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()),
                "Juanito","4","Cálculo","101010101","En espera"));
        citas.add(new Citas(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()),
                "Juanito","4","Programación","101010101","Cancelada"));
        citas.add(new Citas(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()),
                "Juanito","4","Software","101010101","No concretada"));
        citas.add(new Citas(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()),
                "Juanito","4","Software","101010101","Concretada"));
        citas.add(new Citas(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()),
                "Juanito","4","Software","101010101","Concretada"));
        citas.add(new Citas(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()),
                "Juanito","4","Software","101010101","Concretada"));
        citas.add(new Citas(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()),
                "Juanito","4","Cálculo","101010101","Concretada"));
        citas.add(new Citas(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()),
                "Juanito","4","Bases de datos","101010101","Concretada"));
        citas.add(new Citas(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()),
                "Juanito","4","Cálculo","101010101","Concretada"));
        citas.add(new Citas(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()),
                "Juanito","4","Bases de datos","101010101","Concretada"));
        citas.add(new Citas(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()),
                "Juanito","4","Cálculo","101010101","En espera"));
        citas.add(new Citas(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()),
                "Juanito","4","Software","101010101","Concretada"));
        citas.add(new Citas(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()),
                "Juanito","4","Software","101010101","Concretada"));
        citas.add(new Citas(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()),
                "Juanito","4","Cálculo","101010101","En espera"));

        monitores = new ArrayList<>();
        monitores.add(new Monitor(1,123,6,1,2,"monitor 1", "monitor",
                "sasf", "no", "Inglés", citas, false));

        fragmentoDetalle = (DetalleDeMonitorFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_personaje);

        ListaDeMonitoresFragment listaDeMonitoresFragment = (ListaDeMonitoresFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_lista_monitores);
        listaDeMonitoresFragment.setMonitores(monitores);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void mostrarDialogoAgregarPersonaje(String nombreClase, AdaptadorMonitor adaptador){

        AgregarMonitorFragment dialogoAgregarMonitor = new AgregarMonitorFragment();
        dialogoAgregarMonitor.setStyle(dialogoAgregarMonitor.STYLE_NORMAL, R.style.DialogoTitulo);
        dialogoAgregarMonitor.setLista(monitores);
        dialogoAgregarMonitor.setAdaptador(adaptador);
        dialogoAgregarMonitor.show(getSupportFragmentManager(), nombreClase);

    }


    @Override
    public void onMonitorSeleccionadoListener(int posision) {
        if(fragmentoDetalle==null){
            Intent intent = new Intent(this, MonitorViewPagerActivity.class);
            intent.putExtra("monitor", monitores.get(posision));
            startActivity(intent);
        }else {
            fragmentoDetalle.mostrarMonitor(monitores.get(posision));
        }
    }
}
