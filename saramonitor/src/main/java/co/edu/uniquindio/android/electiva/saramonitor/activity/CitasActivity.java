package co.edu.uniquindio.android.electiva.saramonitor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import co.edu.uniquindio.android.electiva.saramonitor.R;
import co.edu.uniquindio.android.electiva.saramonitor.fragments.DetalleCitaFragment;
import co.edu.uniquindio.android.electiva.saramonitor.fragments.ListaDeCitasFragment;
import co.edu.uniquindio.android.electiva.saramonitor.vo.Citas;

public class CitasActivity extends AppCompatActivity implements ListaDeCitasFragment.OnCitaSeleccionadaListener{

    private ArrayList<Citas> citas;
    private Toolbar myToolbar;
    private DetalleCitaFragment citaFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas);

        myToolbar = (Toolbar) findViewById(R.id.tool_bar);
        myToolbar.setTitle("Mi lista de citas");

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


        ListaDeCitasFragment listaDeCitasFragment = (ListaDeCitasFragment)
                        getSupportFragmentManager().findFragmentById(R.id.fragment_lista_citas);
        listaDeCitasFragment.setCitas(citas);
    }



    @Override
    public void onCitaSeleccionadaListener(int posicion) {
        if (citaFragment == null){
            Intent intent = new Intent(this, DetalleCitaActivity.class);
            intent.putExtra("posicion_cita", posicion);
            intent.putExtra("citas", citas.get(posicion));
            startActivity(intent);
        }else{
            citaFragment.setPosicion(posicion);
            citaFragment.mostrarCita(citas.get(posicion));
        }
    }
}
