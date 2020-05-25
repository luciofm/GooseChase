package com.luciofm.goosechase.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MissionDetailViewModelFactory(
    private val application: Application,
    private val missionId: Long
) : ViewModelProvider.AndroidViewModelFactory(application) {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MissionDetailViewModel(application, missionId) as T
    }

}