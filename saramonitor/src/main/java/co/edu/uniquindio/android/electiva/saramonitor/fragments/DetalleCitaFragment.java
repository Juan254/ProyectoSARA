package co.edu.uniquindio.android.electiva.saramonitor.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import co.edu.uniquindio.android.electiva.saramonitor.R;
import co.edu.uniquindio.android.electiva.saramonitor.vo.Citas;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleCitaFragment extends Fragment {


    private TextView cedula,nombre,semestre,linea,fecha_hora,estado;
    private Toolbar myToolbar;
    private int posicion;

    public DetalleCitaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_detalle_cita, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void mostrarCita(Citas cita){
        myToolbar = (Toolbar) getView().findViewById(R.id.tool_bar);
        myToolbar.setTitle("Detalle de la cita");
        cedula = (TextView) getView().findViewById(R.id.txt_cedula);
        cedula.setText(cita.getCedula());
        nombre = (TextView) getView().findViewById(R.id.txt_nombre);
        nombre.setText(cita.getNombre());
        semestre = (TextView) getView().findViewById(R.id.txt_semestre);
        semestre.setText(cita.getSemestre());
        linea = (TextView) getView().findViewById(R.id.txt_linea_monitoria);
        linea.setText(cita.getLinea());
        fecha_hora = (TextView) getView().findViewById(R.id.txt_fecha_asesoria);
        fecha_hora.setText(cita.getFecha_cita());
        estado = (TextView) getView().findViewById(R.id.estado_spinner);
        estado.setText(cita.getEstado());
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        setHasOptionsMenu(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_cancelar) {
            estado.setText("Cancelada");
        }
        if (id == R.id.menu_terminar_cita){
            estado.setText("Concretada");
        }
        if (id == R.id.menu_inasistencia){
            estado.setText("NO concretada");
        }
        return super.onOptionsItemSelected(item);
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
}
