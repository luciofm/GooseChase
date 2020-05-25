package com.luciofm.goosechase.listing;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.luciofm.goosechase.data.GooseChaseDb;
import com.luciofm.goosechase.data.Mission;

import java.util.List;

public class MissionListViewModel extends AndroidViewModel {

    public MissionListViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Mission>> listMissions() {
        return GooseChaseDb.getInstance(getApplication()).missionDao().missions();
    }
}