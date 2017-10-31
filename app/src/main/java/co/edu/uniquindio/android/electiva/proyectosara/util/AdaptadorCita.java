package co.edu.uniquindio.android.electiva.proyectosara.util;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.proyectosara.R;
import co.edu.uniquindio.android.electiva.proyectosara.vo.Citas;


/**
 * Created by Juan on 30/10/2017.
 */

public class AdaptadorCita extends RecyclerView.Adapter<AdaptadorCita.CitaViewHolder>{

    private ArrayList<Citas> misCitas;


    public AdaptadorCita(ArrayList<Citas> misCitas) {
        this.misCitas = misCitas;
    }

    @Override
    public CitaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.resumen_cita, parent, false);
        CitaViewHolder citasVH = new
                CitaViewHolder(itemView);
        return citasVH;
    }

    @Override
    public void onBindViewHolder(CitaViewHolder holder, int position) {
        Citas cita = misCitas.get(position);
        holder.binCita(cita);
    }

    @Override
    public int getItemCount() {
        return misCitas.size();
    }

    public  class CitaViewHolder extends RecyclerView.ViewHolder{

        private TextView estado;
        private TextView fecha;

        public CitaViewHolder(View itemView) {
            super(itemView);
            estado = (TextView) itemView.findViewById(R.id.estado_cita);
            fecha = (TextView) itemView.findViewById(R.id.fecha_hora_cita);
        }

        public  void binCita(Citas cita){
            estado.setText(cita.getEstado());
            fecha.setText(cita.getFecha_cita());
        }
    }
}