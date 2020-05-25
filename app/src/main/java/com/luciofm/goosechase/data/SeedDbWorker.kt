package com.luciofm.goosechase.data

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.coroutineScope

class SeedDbWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result = coroutineScope {
        try {
            val db = GooseChaseDb.getInstance(applicationContext)
            db.missionDao().insert(PREPOPULATE_DATA)
            Result.success()
        } catch (ex: Exception) {
            ex.printStackTrace()
            Result.failure()
        }
    }

    private val PREPOPULATE_DATA = listOf(
        Mission(
            name = "Let's Play! PS4 Booth",
            description = "Take a picture or a selfie of yourself playing one of the PS4 games!",
            points = 150,
            type = MissionType.Photo
        ),
        Mission(
            name = "Mash UP Movie Poster",
            description = "Name this new movie Mash UP poster",
            points = 250,
            type = MissionType.Text
        ),
        Mission(
            name = "Solve the travellers challenge!",
            description = "Solve the travellers challenge at the showcase booth and save the future",
            points = 100,
            type = MissionType.Photo
        ),
        Mission(
            name = "Star Wars droid selfie",
            description = "Find a droid from Star Wars and take a selfie with them!",
            points = 350,
            type = MissionType.Photo
        ),
        Mission(
            name = "Tower Check in",
            description = "Look up, waaaaay up.",
            points = 200,
            type = MissionType.Gps
        ),
        Mission(
            name = "Twinsies!",
            description = "Get thee to the toy storie and find your twin!",
            points = 450,
            type = MissionType.Photo
        ),
        Mission(
            name = "Let's Play! Xbox Booth",
            description = "Take a picture or a selfie of yourself playing one of the Xbox games!",
            points = 150,
            type = MissionType.Photo
        )
    )
}