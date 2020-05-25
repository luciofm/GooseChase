package com.luciofm.goosechase.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.luciofm.goosechase.data.GooseChaseDb

class MissionDetailViewModelFactory(
    private val application: Application,
    private val missionId: Long
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MissionDetailViewModel(GooseChaseDb.getInstance(application).missionDao(), missionId) as T
    }

}