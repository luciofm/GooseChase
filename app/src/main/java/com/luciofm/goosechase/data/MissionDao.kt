package com.luciofm.goosechase.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MissionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(mission: Mission)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(missions: List<Mission>)

    @Query("SELECT * FROM missions")
    fun missions(): LiveData<List<Mission>>

    @Query("SELECT * FROM missions WHERE id == :id")
    fun mission(id: Long): LiveData<Mission>
}