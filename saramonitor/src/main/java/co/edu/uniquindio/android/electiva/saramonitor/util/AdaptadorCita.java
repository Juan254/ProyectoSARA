package co.edu.uniquindio.android.electiva.saramonitor.util;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.saramonitor.R;
import co.edu.uniquindio.android.electiva.saramonitor.fragments.ListaDeCitasFragment;
import co.edu.uniquindio.android.electiva.saramonitor.vo.Citas;

/**
 * Created by Juan on 21/10/2017.
 */

public class AdaptadorCita extends  RecyclerView.Adapter<AdaptadorCita.CitasViewHolder>{

    private ArrayList<Citas> misCitas;
    private OnClickAdaptadorDeCita listener;

    public AdaptadorCita(ArrayList<Citas> misCitas, ListaDeCitasFragment listaDeCitasFragment) {
        this.misCitas = misCitas;
        listener = (OnClickAdaptadorDeCita) listaDeCitasFragment;
    }

    @Override
    public CitasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.resumen_cita, parent, false);
        CitasViewHolder citasVH = new
                CitasViewHolder(itemView);
        return citasVH;
    }

    @Override
    public void onBindViewHolder(CitasViewHolder holder, int position) {
        Citas cita = misCitas.get(position);
        holder.binCita(cita);
    }

    @Override
    public int getItemCount() {
        return misCitas.size();
    }

    public class CitasViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView estado;
        private TextView fecha;

        public CitasViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            estado = (TextView) itemView.findViewById(R.id.estado_cita);
            fecha = (TextView) itemView.findViewById(R.id.fecha_hora_cita);
        }

        public  void binCita(Citas cita){
            estado.setText(cita.getEstado());
            fecha.setText(cita.getFecha_cita());
        }

        @Override
        public void onClick(View view) {
            listener.onClickPosicion(getAdapterPosition());
        }
    }

    public interface OnClickAdaptadorDeCita{
        void onClickPosicion(int pos);
    }
}
