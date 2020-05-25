package com.luciofm.goosechase.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.luciofm.goosechase.data.GooseChaseDb

class MissionDetailViewModel(
    application: Application,
    missionId: Long
) : AndroidViewModel(application) {
    val mission = GooseChaseDb.getInstance(getApplication()).missionDao().mission(missionId)
}