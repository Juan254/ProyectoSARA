package co.edu.uniquindio.android.electiva.proyectosara.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.proyectosara.R;
import co.edu.uniquindio.android.electiva.proyectosara.util.AdaptadorCita;
import co.edu.uniquindio.android.electiva.proyectosara.vo.Citas;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaDeCitasFragment extends Fragment {

    private RecyclerView listaCitas;
    private ArrayList<Citas> citas;


    public ListaDeCitasFragment() {
        // Required empty public constructor
    }

    public static ListaDeCitasFragment newInstance(ArrayList<Citas> citas){
        ListaDeCitasFragment nuevo = new ListaDeCitasFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("citas",citas);
        nuevo.setArguments(bundle);
        nuevo.setRetainInstance(true);
        return  nuevo;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if (getArguments().getParcelableArrayList("citas") != null){
            this.citas = getArguments().getParcelableArrayList("citas");
        }else{
           // this.citas = new ArrayList<Citas>();
            Toast.makeText(getActivity(), "Citas nulos", Toast.LENGTH_LONG).show();
        }
        super.onCreate(savedInstanceState);
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

        listaCitas = (RecyclerView) getView().findViewById(R.id.lista_citas);
        AdaptadorCita adC = new AdaptadorCita(citas);
        listaCitas.setAdapter(adC);
        listaCitas.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }



    public void setCitas(ArrayList<Citas> citas) {
        this.citas = citas;
    }


}