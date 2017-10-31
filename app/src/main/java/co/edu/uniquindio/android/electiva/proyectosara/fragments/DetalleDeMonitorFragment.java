package co.edu.uniquindio.android.electiva.proyectosara.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

    public static DetalleDeMonitorFragment newInstance(Monitor monitor){
        DetalleDeMonitorFragment nuevo = new DetalleDeMonitorFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("monitor", monitor);
        nuevo.setArguments(bundle);
        nuevo.setRetainInstance(true);
        return  nuevo;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().getParcelable("monitor") != null){
            this.monitor = getArguments().getParcelable("monitor");

        }else{
            Toast.makeText(getActivity(), "monitor nulo", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalle_de_monitor, container, false);
        txtNombre = (TextView) view.findViewById(R.id.txtNombreMonitor);
        txtNombre.setText(monitor.getNombre());
        txtNombreUsuario = (TextView) view.findViewById(R.id.txtNombreUsuario);
        txtNombreUsuario.setText(monitor.getNombreUsuario());
        txtNumTel = (TextView) view.findViewById(R.id.txtTelefono);
        txtNumTel.setText(String.valueOf(monitor.getNumTelefono()));
        txtLineaMonitoria = (TextView) view.findViewById(R.id.txtLineaMonitoria);
        txtLineaMonitoria.setText(monitor.getLineaMonitoria());
        txtSemestre = (TextView) view.findViewById(R.id.txtSemestre);
        txtSemestre.setText(String.valueOf(monitor.getSemestre()));
        txtLugarAtencion = (TextView) view.findViewById(R.id.txtLugarAtencion);
        txtHorasAtencion = (TextView) view.findViewById(R.id.txthoraAtencion);

        imgFotoMonitor = (ImageView) view.findViewById(R.id.imgViewFotoMonitor);
        imgFotoMonitor.setImageResource(R.drawable.user_icon);
        imgFotoMonitor.setBackgroundResource(R.color.colorU);
        return view;
    }

    public void mostrarMonitor(Monitor monitor){

        this.monitor = monitor;
        txtNombre = (TextView) getView().findViewById(R.id.txtNombreMonitor);
        txtNombre.setText(monitor.getNombre());
        txtNombreUsuario = (TextView) getView().findViewById(R.id.txtNombreUsuario);
        txtNumTel = (TextView) getView().findViewById(R.id.txtTelefono);
        txtLineaMonitoria = (TextView) getView().findViewById(R.id.txtLineaMonitoria);
        txtSemestre = (TextView) getView().findViewById(R.id.txtSemestre);
        txtLugarAtencion = (TextView) getView().findViewById(R.id.txtLugarAtencion);
        txtHorasAtencion = (TextView) getView().findViewById(R.id.txthoraAtencion);

        imgFotoMonitor = (ImageView) getView().findViewById(R.id.imgViewFotoMonitor);

    }

}
