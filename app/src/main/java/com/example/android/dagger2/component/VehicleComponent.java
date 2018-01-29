package com.example.android.dagger2.component;

import com.example.android.dagger2.model.Vehicle;
import com.example.android.dagger2.module.VehicleModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by becca on 1/26/18.
 */

@Singleton
@Component(modules = {VehicleModule.class})
public interface VehicleComponent {
    Vehicle provideVehicle();
}
