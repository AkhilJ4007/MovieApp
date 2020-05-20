package com.example.movieapp.movieList;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.PureDI.MVCViewFactory;
import com.example.movieapp.model.MovieItem;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> implements MovieItemInterface.Listener{


    LayoutInflater layoutInflater;
    MVCViewFactory viewFactory;
    RecyclerAdapter.Listener listener;
    List<MovieItem> movieItems = new ArrayList<>();

    public interface Listener{
        void onClick();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieItemInterface movieItemInterface = viewFactory.getMovieListItemView(parent);
        Log.d("onCreate","sdfdsfsdf");
        return new MyViewHolder(movieItemInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.movieItemInterface.registerListener(this);
        holder.movieItemInterface.bindQuestions(movieItems.get(position).getTitle());


    }

    @Override
    public int getItemCount() {
        if(movieItems != null) {
            return movieItems.size();
        }
        else {
            return 0;
        }
    }

    public RecyclerAdapter(LayoutInflater layoutInflater, MVCViewFactory viewFactory,RecyclerAdapter.Listener listener) {
        this.layoutInflater = layoutInflater;
        this.viewFactory = viewFactory;
        this.listener = listener;

    }

    //from movielist
    public void bindData(List <MovieItem> movieItems) {
        this.movieItems = movieItems;
        notifyDataSetChanged();
    }

    // movie item click
    @Override
    public void onClick() {

        listener.onClick();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        MovieItemInterface movieItemInterface;
        public MyViewHolder(MovieItemInterface movieItemInterface) {
            super(movieItemInterface.getRootView());
            this.movieItemInterface = movieItemInterface;

        }
    }


}
