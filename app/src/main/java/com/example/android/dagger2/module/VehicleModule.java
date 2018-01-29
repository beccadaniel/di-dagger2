package com.example.android.dagger2.module;

import com.example.android.dagger2.model.Motor;
import com.example.android.dagger2.model.Vehicle;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by becca on 1/26/18.
 */

@Module
public class VehicleModule {

    @Provides @Singleton
    Motor provideMotor() {
        return new Motor();
    }

    @Provides @Singleton
    Vehicle provideVehicle() {
        return new Vehicle(new Motor());
    }

}
