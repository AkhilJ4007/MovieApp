package com.example.movieapp.MovieReviewListPkg;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieReviewsAdapter extends RecyclerView.Adapter<MovieReviewsAdapter.MoveViewHolder> {

    private Listener listener;
    private LayoutInflater layoutInflater;

    public interface Listener{
        void OnClick();
    }

    public MovieReviewsAdapter(Listener listener, LayoutInflater layoutInflater) {
        this.listener = listener;
        this.layoutInflater = layoutInflater;
    }

    @NonNull
    @Override
    public MoveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieReviewItem movieReviewItem = new MovieReviewItem(layoutInflater,parent);
        return new MoveViewHolder(movieReviewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MoveViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MoveViewHolder extends RecyclerView.ViewHolder {
        MovieReviewItem movieReviewItem;

        public MoveViewHolder(MovieReviewItem movieReviewItem) {
            super(movieReviewItem.getRootView());
            this.movieReviewItem = movieReviewItem;
        }
    }
}
