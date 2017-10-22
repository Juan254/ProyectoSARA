package co.edu.uniquindio.android.electiva.saramonitor.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.saramonitor.R;
import co.edu.uniquindio.android.electiva.saramonitor.util.AdaptadorCita;
import co.edu.uniquindio.android.electiva.saramonitor.vo.Citas;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaDeCitasFragment extends Fragment implements AdaptadorCita.OnClickAdaptadorDeCita{


    private RecyclerView listaCitas;
    private ArrayList<Citas> citas;
    private OnCitaSeleccionadaListener listener;

    public ListaDeCitasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_de_citas, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listaCitas = (RecyclerView) getView().findViewById(R.id.listaCitas);
        AdaptadorCita adC = new AdaptadorCita(citas, this);
        listaCitas.setAdapter(adC);
        listaCitas.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Activity) {
            Activity activity = (Activity) context;

            try {
                listener = (OnCitaSeleccionadaListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString() + "debe de" +
                        "implementar la interfac OnCItaSeleccionadaListener");
            }
        }
    }


    @Override
    public void onClickPosicion(int pos) {
        listener.onCitaSeleccionadaListener(pos);
    }

    public void setCitas(ArrayList<Citas> citas) {
        this.citas = citas;
    }

    public interface OnCitaSeleccionadaListener{
        void onCitaSeleccionadaListener(int posicion);
    }
}
