package com.example.movieapp.movieList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.movieapp.R;
import com.example.movieapp.views.BaseObservableViewMvc;

public class MovieItemViewMVC extends BaseObservableViewMvc<MovieItemInterface.Listener> implements MovieItemInterface  {

    private TextView chummatextView;
    private TextView textView;
    private View rootView;

    public MovieItemViewMVC(ViewGroup viewGroup, LayoutInflater layoutInflater) {

        rootView = layoutInflater.inflate(R.layout.movie_item,viewGroup,false);
        setRootView(rootView);
        textView = findViewById(R.id.textview);
        chummatextView = findViewById(R.id.chummaText);
    }




    @Override
    public void bindQuestions(String s) {

        textView.setText(s);
        chummatextView.setText(s);
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(Listener listener:getListeners()){
                    listener.onClick();
                }
            }
        });


    }






}
