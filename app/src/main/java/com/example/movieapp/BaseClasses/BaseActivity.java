package com.example.movieapp.BaseClasses;

import androidx.appcompat.app.AppCompatActivity;

import com.example.movieapp.CustomApplication;
import com.example.movieapp.PureDI.ControllerCompositionRoot;

public abstract class BaseActivity extends AppCompatActivity {

    ControllerCompositionRoot controllerCompositionRoot;

    protected ControllerCompositionRoot getCompositionRoot(){

        if (controllerCompositionRoot == null){
            controllerCompositionRoot = new ControllerCompositionRoot(this,((CustomApplication) getApplication()).getCompositionRoot(),this);

        }

        return controllerCompositionRoot;
    }


}
