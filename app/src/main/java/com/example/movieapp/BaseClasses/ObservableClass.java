package com.example.movieapp.BaseClasses;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class ObservableClass<ListenerType> implements  ObservableInterface<ListenerType>{

    private Set<ListenerType> mListeners = new HashSet<>();


    @Override
    public void registerListener(ListenerType listener) {
        mListeners.add(listener);
    }

    @Override
    public void unregisterListener(ListenerType listener) {
        mListeners.remove(listener);
    }

    protected final Set<ListenerType> getListeners() {
        return Collections.unmodifiableSet(mListeners);
    }


}
