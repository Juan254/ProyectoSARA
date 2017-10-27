package co.edu.uniquindio.android.electiva.proyectosara.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.edu.uniquindio.android.electiva.proyectosara.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleDeMonitorFragment extends Fragment {


    public DetalleDeMonitorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_de_monitor, container, false);
    }

}
