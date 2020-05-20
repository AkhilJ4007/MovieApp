package com.example.movieapp.BaseClasses;

public interface ObservableInterface<ListenerType> {

    void registerListener(ListenerType listener);

    void unregisterListener(ListenerType listener);

}
