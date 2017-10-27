package co.edu.uniquindio.android.electiva.proyectosara.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.proyectosara.R;
import co.edu.uniquindio.android.electiva.proyectosara.activity.MonitorActivity;
import co.edu.uniquindio.android.electiva.proyectosara.util.AdaptadorMonitor;
import co.edu.uniquindio.android.electiva.proyectosara.vo.Monitor;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaDeMonitoresFragment extends Fragment implements AdaptadorMonitor.onClickAdaptadorMonitor {

    private RecyclerView recyclerView;
    private ArrayList<Monitor> monitores;
    private AdaptadorMonitor adaptadorMonitor;
    private onMonitorSeleccionadoListener listener;

    public ListaDeMonitoresFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof Activity){
            Activity activity = (Activity) context;
            listener = (onMonitorSeleccionadoListener) activity;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView = (RecyclerView) getView().findViewById(R.id.listaMonitores);

        adaptadorMonitor = new AdaptadorMonitor(monitores, this);
        recyclerView.setAdapter(adaptadorMonitor);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.VERTICAL, false));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_de_monitores, container, false);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.menu_agregar){

            ((MonitorActivity) getActivity()).mostrarDialogoAgregarPersonaje(ListaDeMonitoresFragment.class.getName(), adaptadorMonitor);
        }



        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClickPosicion(int posicion) {

        listener.onMonitorSeleccionado(posicion);

    }

    public interface onMonitorSeleccionadoListener{
        void onMonitorSeleccionado(int posision);
    }

    public ArrayList<Monitor> getMonitores() {
        return monitores;
    }

    public void setMonitores(ArrayList<Monitor> monitores) {
        this.monitores = monitores;
    }
}
