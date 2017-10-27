package co.edu.uniquindio.android.electiva.proyectosara.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import co.edu.uniquindio.android.electiva.proyectosara.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pasarAMonitores(View view){
        Intent intent =  new Intent(this, MonitorActivity.class);
        startActivity(intent);
    }
}
