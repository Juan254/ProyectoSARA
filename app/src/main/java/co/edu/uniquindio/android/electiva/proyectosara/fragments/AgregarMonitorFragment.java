package co.edu.uniquindio.android.electiva.proyectosara.fragments;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.proyectosara.R;
import co.edu.uniquindio.android.electiva.proyectosara.vo.Monitor;

/**
 * A simple {@link Fragment} subclass.
 */
public class AgregarMonitorFragment extends DialogFragment implements View.OnClickListener, SelectorFechaFragment.FechaSeleccionadaListener {

    private ArrayList<Monitor> monitores;
    private Button btnAgregar, btnFecha;




    public AgregarMonitorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_agregar_monitor, container, false);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onFechaSeleccionada(int anio, int mes, int dia) {

    }
}
