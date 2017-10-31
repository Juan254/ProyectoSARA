package co.edu.uniquindio.android.electiva.proyectosara.util;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.proyectosara.fragments.DetalleDeMonitorFragment;
import co.edu.uniquindio.android.electiva.proyectosara.fragments.ListaDeCitasFragment;
import co.edu.uniquindio.android.electiva.proyectosara.vo.Monitor;

/**
 * Created by Juan on 31/10/2017.
 */

public class AdaptadorDePager extends FragmentPagerAdapter {

    private ArrayList<String> listaDeTitulos;
    private Monitor monitor;

    public AdaptadorDePager(FragmentManager fm, Monitor monitor){
        super(fm);
        listaDeTitulos = new ArrayList<>();
        listaDeTitulos.add("Monitor");
        listaDeTitulos.add("Lista de citas");
        this.monitor = monitor;
    }

    @Override
    public Fragment getItem(int position) {

        DetalleDeMonitorFragment detalleDeMonitorFragment = null;
        ListaDeCitasFragment listaDeCitasFragment = null;

        switch (position){
            case 0:
                detalleDeMonitorFragment = DetalleDeMonitorFragment.newInstance(monitor);

                break;

            case 1:
                listaDeCitasFragment = ListaDeCitasFragment.newInstance(monitor.getListaCitas());

                break;

        }

        if (listaDeCitasFragment == null){
            return detalleDeMonitorFragment;
        }else{
            return listaDeCitasFragment;
        }

    }




    @Override
    public int getCount() {
        return listaDeTitulos.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listaDeTitulos.get(position);
    }
}
