package co.edu.uniquindio.android.electiva.proyectosara.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import co.edu.uniquindio.android.electiva.proyectosara.R;
import co.edu.uniquindio.android.electiva.proyectosara.vo.Monitor;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleDeMonitorFragment extends Fragment {

    private ImageView imgFotoMonitor;
    private TextView txtNombre, txtNombreUsuario, txtNumTel, txtLineaMonitoria,
            txtSemestre, txtLugarAtencion, txtHorasAtencion;
    private Monitor monitor;

    public DetalleDeMonitorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalle_de_monitor, container, false);
        return view;
    }

    public void mostrarMonitor(Monitor monitor){

        this.monitor = monitor;
        txtNombre = (TextView) getView().findViewById(R.id.txtNombreMonitor);
        txtNombreUsuario = (TextView) getView().findViewById(R.id.txtNombreUsuario);
        txtNumTel = (TextView) getView().findViewById(R.id.txtTelefono);
        txtLineaMonitoria = (TextView) getView().findViewById(R.id.txtLineaMonitoria);
        txtSemestre = (TextView) getView().findViewById(R.id.txtSemestre);
        txtLugarAtencion = (TextView) getView().findViewById(R.id.txtLugarAtencion);
        txtHorasAtencion = (TextView) getView().findViewById(R.id.txthoraAtencion);

        imgFotoMonitor = (ImageView) getView().findViewById(R.id.imgViewFotoMonitor);

    }

}
