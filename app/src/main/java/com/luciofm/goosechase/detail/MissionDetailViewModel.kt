package com.luciofm.goosechase.detail

import androidx.lifecycle.ViewModel
import com.luciofm.goosechase.data.MissionDao

class MissionDetailViewModel(
    missionDao: MissionDao,
    missionId: Long
) : ViewModel() {
    val mission = missionDao.mission(missionId)
}