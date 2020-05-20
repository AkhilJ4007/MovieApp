package com.example.movieapp.BaseClasses;

import androidx.appcompat.app.AppCompatActivity;

import com.example.movieapp.CustomApplication;
import com.example.movieapp.PureDI.CompositionRoot;
import com.example.movieapp.PureDI.ControlleCompositionRoot;

public abstract class BaseActivity extends AppCompatActivity {

    ControlleCompositionRoot controlleCompositionRoot;

    protected ControlleCompositionRoot getCompositionRoot(){

        if (controlleCompositionRoot == null){
            controlleCompositionRoot = new ControlleCompositionRoot(this,((CustomApplication) getApplication()).getCompositionRoot());

        }

        return  controlleCompositionRoot;
    }


}
