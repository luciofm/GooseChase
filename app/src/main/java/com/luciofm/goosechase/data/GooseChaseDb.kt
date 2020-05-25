package com.luciofm.goosechase.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

@Database(entities = [Mission::class], version = 1, exportSchema = true)
@TypeConverters(MissionTypeConverter::class)
abstract class GooseChaseDb : RoomDatabase() {
    abstract fun missionDao(): MissionDao

    companion object {

        @Volatile private var INSTANCE: GooseChaseDb? = null

        @JvmStatic
        fun getInstance(context: Context): GooseChaseDb =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                GooseChaseDb::class.java, "goose-chase.db")
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        val request = OneTimeWorkRequestBuilder<SeedDbWorker>().build()
                        WorkManager.getInstance(context).enqueue(request)
                    }
                })
                .build()
    }
}