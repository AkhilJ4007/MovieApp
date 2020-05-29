package com.example.movieapp.movieList;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.PureDI.MVCViewFactory;
import com.example.movieapp.RoomDB.MovieItem;
import com.example.movieapp.RoomDB.MovieItemEntity;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> implements MovieItemInterface.Listener{


    private LayoutInflater layoutInflater;
    private MVCViewFactory viewFactory;
    private RecyclerAdapter.Listener listener;
    private List<MovieItemEntity> movieItems = new ArrayList<>();

    public interface Listener{
        void onClick();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieItemInterface movieItemInterface = viewFactory.getMovieListItemView(parent);
        return new MyViewHolder(movieItemInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.movieItemInterface.registerListener(this);
        holder.movieItemInterface.bindMovies(movieItems.get(position));


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
    public void bindData(List <MovieItemEntity> movieItems) {
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
