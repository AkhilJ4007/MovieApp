package com.example.movieapp.movieList;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Placeholder;

import com.bumptech.glide.Glide;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.DrawableCrossFadeTransition;
import com.example.movieapp.R;
import com.example.movieapp.RoomDB.MovieItemEntity;
import com.example.movieapp.views.BaseObservableViewMvc;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.github.ybq.android.spinkit.style.ThreeBounce;

public class MovieItemViewMVC extends BaseObservableViewMvc<MovieItemInterface.Listener> implements MovieItemInterface, RequestListener<Drawable> {

    private ImageView imageView;
    private TextView textView;
    private View rootView;
    private  ProgressBar progressBar;
    private Sprite doubleBounce;
    private CardView cardView;

    public MovieItemViewMVC(ViewGroup viewGroup, LayoutInflater layoutInflater) {

        rootView = layoutInflater.inflate(R.layout.movie_item_sample,viewGroup,false);
        setRootView(rootView);
        textView = findViewById(R.id.textview);
        imageView = findViewById(R.id.imageView);
        progressBar= findViewById(R.id.progress);
        cardView = findViewById(R.id.cardView);
         doubleBounce = new ThreeBounce();
    }




    @Override
    public void bindMovies(MovieItemEntity movieItemEntity) {

        textView.setText(movieItemEntity.getTitle());
        String url = "https://image.tmdb.org/t/p/w500/" + movieItemEntity.getBackdrop_path();


        progressBar.setIndeterminateDrawable(doubleBounce);

        Glide.with(getRootView()).load(url).transition(DrawableTransitionOptions.withCrossFade()).listener(this).into(imageView);


        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(Listener listener:getListeners()){
                    listener.onClick();
                }
            }
        });


    }


    @Override
    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
        return false;
    }

    @Override
    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
        Log.d("glide","in here");
        progressBar.setVisibility(View.GONE);
        cardView.setVisibility(View.VISIBLE);
        target.onResourceReady(resource,new DrawableCrossFadeTransition(500, isFirstResource));
        return true;
    }
}
