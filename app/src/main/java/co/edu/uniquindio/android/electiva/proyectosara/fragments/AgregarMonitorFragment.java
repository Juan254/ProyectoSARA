package co.edu.uniquindio.android.electiva.proyectosara.fragments;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import co.edu.uniquindio.android.electiva.proyectosara.R;
import co.edu.uniquindio.android.electiva.proyectosara.util.AdaptadorMonitor;
import co.edu.uniquindio.android.electiva.proyectosara.vo.Monitor;

/**
 * A simple {@link Fragment} subclass.
 */
public class AgregarMonitorFragment extends DialogFragment implements View.OnClickListener, SelectorFechaFragment.FechaSeleccionadaListener {


    private ArrayList<Monitor> lista;
    private AdaptadorMonitor adaptador;
    private Date horaSeleccionada;
    private Button btnAgregarMonitor, btnHoraAtencion;
    private EditText cedulaEdit, nombreEdit, nombreUsuarioEdit, contraseniaEdit,
                     telefonoEdit, semestreEdit, lineaMonitoriaEdit, lugarAtencionEdit;




    public AgregarMonitorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getDialog().setTitle("Agregar Monitor");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_agregar_monitor, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnAgregarMonitor = getView().findViewById(R.id.btnAgregarMonitor);
        btnAgregarMonitor.setOnClickListener(this);

        btnHoraAtencion = getView().findViewById(R.id.btnHoraAtencion);
        btnHoraAtencion.setOnClickListener(this);

        cedulaEdit = getView().findViewById(R.id.editTextCedula);
        nombreEdit = getView().findViewById(R.id.editTextNombreMonitor);
        nombreUsuarioEdit = getView().findViewById(R.id.editTextNombreUsuario);
        contraseniaEdit = getView().findViewById(R.id.editTextContrasenia);
        telefonoEdit = getView().findViewById(R.id.editTextTelefono);
        semestreEdit = getView().findViewById(R.id.editTextSemestre);
        lineaMonitoriaEdit = getView().findViewById(R.id.editTextLineaMonitoria);
        lugarAtencionEdit = getView().findViewById(R.id.editTextLugarAtencion);


    }

    @Override
    public void onClick(View view) {

        if(view.getId() == btnAgregarMonitor.getId()){
            if (cedulaEdit.getText().toString().isEmpty() ||nombreEdit.getText().toString().isEmpty()
                    || contraseniaEdit.getText().toString().isEmpty() ||
                    telefonoEdit.getText().toString().isEmpty()||
                    semestreEdit.getText().toString().isEmpty() ||
                    lineaMonitoriaEdit.getText().toString().isEmpty() ||
                    lugarAtencionEdit.getText().toString().isEmpty()){

                Toast.makeText(getActivity(), R.string.mensaje_agregar_error,
                        Toast.LENGTH_LONG).show();
            }else {
                int cedula = Integer.parseInt(cedulaEdit.getText().toString());
                String nombre = nombreEdit.getText().toString();
                String nombreUsuario = nombreUsuarioEdit.getText().toString();
                String contra = contraseniaEdit.getText().toString();
                int tel = Integer.parseInt(telefonoEdit.getText().toString());
                int semestre = Integer.parseInt(semestreEdit.getText().toString());
                String lineaMonitoria = lineaMonitoriaEdit.getText().toString();
                String lugarAtencion = lugarAtencionEdit.getText().toString();
                lista.add(0, new Monitor(cedula, tel, semestre, 0, 0, nombre,
                        nombreUsuario, contra, lugarAtencion,
                        lineaMonitoria, null, false));

                adaptador.notifyItemInserted(0);
                getDialog().dismiss();
            }
        }

        if(view.getId() == btnHoraAtencion.getId()){

            SelectorFechaFragment fecha = new SelectorFechaFragment();
            fecha.setListener(this);
            fecha.show(getActivity().getSupportFragmentManager(), "datePicker");

        }

    }

    @Override
    public void onFechaSeleccionada(int anio, int mes, int dia) {

        try {
            String fecha = String.format("%d/%d/%d", anio, mes+1, dia);
            DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            horaSeleccionada = sdf.parse(fecha);
        }catch(ParseException e){
            e.printStackTrace();
        }

    }




    public ArrayList<Monitor> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Monitor> lista) {
        this.lista = lista;
    }


    public AdaptadorMonitor getAdaptador() {
        return adaptador;
    }

    public void setAdaptador(AdaptadorMonitor adaptador) {
        this.adaptador = adaptador;
    }
}
