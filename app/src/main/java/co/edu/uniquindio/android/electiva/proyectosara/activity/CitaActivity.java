package co.edu.uniquindio.android.electiva.proyectosara.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.proyectosara.R;
import co.edu.uniquindio.android.electiva.proyectosara.fragments.ListaDeCitasFragment;
import co.edu.uniquindio.android.electiva.proyectosara.vo.Citas;

public class CitaActivity extends AppCompatActivity {


    private ArrayList<Citas> citas;
    private Toolbar myToolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cita);


        citas = getIntent().getExtras().getParcelableArrayList("citas");
        ListaDeCitasFragment listaDeCitasFragment = (ListaDeCitasFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_lista_citas);
        listaDeCitasFragment.setCitas(citas);

    }
}
