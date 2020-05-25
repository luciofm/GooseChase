package com.luciofm.goosechase.listing;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.luciofm.goosechase.data.GooseChaseDb;

public class MissionListViewModelFactory implements ViewModelProvider.Factory {
    private final Application application;

    public MissionListViewModelFactory(Application application) {
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MissionListViewModel(GooseChaseDb.getInstance(application).missionDao());
    }
}
