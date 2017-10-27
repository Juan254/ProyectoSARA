package co.edu.uniquindio.android.electiva.proyectosara.fragments;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

import co.edu.uniquindio.android.electiva.proyectosara.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectorFechaFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    private FechaSeleccionadaListener listener;

    /**
     * Constructor obligatorio
     */
    public SelectorFechaFragment() {
        // Required empty public constructor
    }

    /**
     * Permite inicializar el DialogFragment por medio de un objeto DatePickerDialog
     * @param savedInstanceState
     * @return DatePickerDialog
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    /**
     * Método que se ejecuta cuando se da click en el botón aceptar del calendario
     * una vez se haya seleccionado una fecha
     * @param datePicker Objeto
     * @param i Año
     * @param i1 Mes
     * @param i2 Día
     */
    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        listener.onFechaSeleccionada(i, i1, i2);
    }

    /**
     * Interface que permite enviar eventos a otras clases
     */
    public interface FechaSeleccionadaListener{
        void onFechaSeleccionada(int anio, int mes, int dia);
    }

    public void setListener(FechaSeleccionadaListener  listener){
        this.listener = listener;
    }

}
