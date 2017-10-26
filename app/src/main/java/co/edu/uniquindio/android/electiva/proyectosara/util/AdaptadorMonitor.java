package co.edu.uniquindio.android.electiva.proyectosara.util;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.proyectosara.R;
import co.edu.uniquindio.android.electiva.proyectosara.fragments.ListaDeMonitoresFragment;
import co.edu.uniquindio.android.electiva.proyectosara.vo.Monitor;

/**
 * Created by andre on 26/10/2017.
 */

public class AdaptadorMonitor extends RecyclerView.Adapter<AdaptadorMonitor.MonitorViewHolder> {

    private ArrayList<Monitor> monitores;
    private onClickAdaptadorMonitor listener;


    public AdaptadorMonitor(ArrayList<Monitor> monitores, ListaDeMonitoresFragment listaDeMonitoresFragment){

        this.monitores = monitores;
        listener = (onClickAdaptadorMonitor) listaDeMonitoresFragment;

    }

    @Override
    public MonitorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.resumen_monitor, parent, false);
        MonitorViewHolder monitorViewHolder = new MonitorViewHolder(view);

        return monitorViewHolder;
    }

    @Override
    public void onBindViewHolder(MonitorViewHolder holder, int position) {
        holder.bindMonitor(monitores.get(position));

    }

    @Override
    public int getItemCount() {
        return monitores.size();
    }

    public class MonitorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtNombre;
        private TextView txtLineaMonitoria;

        public MonitorViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            txtNombre = (TextView) itemView.findViewById(R.id.nombreMonitor);
            txtLineaMonitoria = (TextView) itemView.findViewById(R.id.lineaMonitoria);

        }

        @Override
        public void onClick(View view) {

            listener.onClickPosicion(getAdapterPosition());
        }

        public void bindMonitor(Monitor monitor){


            txtNombre.setText(monitor.getNombre());
            txtLineaMonitoria.setText(monitor.getLineaMonitoria());

        }
    }

    public interface onClickAdaptadorMonitor {
        void onClickPosicion(int posicion);
    }
}
