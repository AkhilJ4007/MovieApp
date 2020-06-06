package com.example.movieapp.MovieSimilarList;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.MovieReviewListPkg.MovieReviewsAdapter;


public class SimilarMoviesAdapter extends RecyclerView.Adapter<SimilarMoviesAdapter.ViewHolder> implements SimilarItemInter.Listener {

    private MovieReviewsAdapter.Listener listener;
    private LayoutInflater layoutInflater;


// from similar item
    @Override
    public void onClick() {

    }

    public interface Listener{
        void OnClickSimilar();
    }

    public SimilarMoviesAdapter(MovieReviewsAdapter.Listener listener, LayoutInflater layoutInflater) {
        this.listener = listener;
        this.layoutInflater = layoutInflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SimilarItemInter similarItemView = new SimilarItemView(layoutInflater,parent);
        ViewHolder viewHolder = new ViewHolder(similarItemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.similarItemView.bindData();
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        SimilarItemInter similarItemView;
        public ViewHolder(SimilarItemInter similarItemView) {
            super(similarItemView.getRootView());
            this.similarItemView = similarItemView;
        }
    }
}
