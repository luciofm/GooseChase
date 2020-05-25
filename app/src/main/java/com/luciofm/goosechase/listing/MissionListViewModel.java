package com.luciofm.goosechase.listing;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.luciofm.goosechase.data.Mission;
import com.luciofm.goosechase.data.MissionDao;

import java.util.List;

public class MissionListViewModel extends ViewModel {
    private final MissionDao missionDao;

    public MissionListViewModel(MissionDao missionDao) {
        this.missionDao = missionDao;
    }

    public LiveData<List<Mission>> listMissions() {
        return missionDao.missions();
    }
}