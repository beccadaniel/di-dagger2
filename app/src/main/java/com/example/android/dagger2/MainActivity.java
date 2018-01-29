package com.example.android.dagger2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.dagger2.component.DaggerVehicleComponent;
import com.example.android.dagger2.component.VehicleComponent;
import com.example.android.dagger2.model.Vehicle;
import com.example.android.dagger2.module.VehicleModule;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VehicleComponent component = DaggerVehicleComponent.builder().vehicleModule(new VehicleModule()).build();
        final Vehicle vehicle = component.provideVehicle();

        Button increaseButton = (Button) findViewById(R.id.increase);
        increaseButton.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                TextView speedTV = (TextView) findViewById(R.id.speed);
                vehicle.increaseSpeed(2);
                speedTV.setText(String.valueOf(vehicle.getSpeed()) + " mph");
            }
        });

        Button stopButton = (Button) findViewById(R.id.stop);
        stopButton.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                TextView speedTV = (TextView) findViewById(R.id.speed);
                vehicle.stop();
                speedTV.setText(String.valueOf(vehicle.getSpeed()) + " mph");
            }
        });
    }
}
