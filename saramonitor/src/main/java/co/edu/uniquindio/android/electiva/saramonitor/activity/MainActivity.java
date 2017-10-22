package co.edu.uniquindio.android.electiva.saramonitor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import co.edu.uniquindio.android.electiva.saramonitor.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pasarACitas(View view) {
        Intent intent =  new Intent(this, CitasActivity.class);
        startActivity(intent);
    }
}
