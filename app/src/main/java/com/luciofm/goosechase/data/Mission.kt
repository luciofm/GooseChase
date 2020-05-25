package com.luciofm.goosechase.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import java.security.InvalidParameterException

@Entity(tableName = "missions")
data class Mission(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val description: String,
    val points: Int,
    val type: MissionType
)

sealed class MissionType {
    object Photo : MissionType()
    object Text : MissionType()
    object Gps : MissionType()

    override fun toString() = MissionTypeConverter.fromMissionType(this)
}

object MissionTypeConverter {
    @TypeConverter
    @JvmStatic
    fun fromMissionType(value: MissionType): String {
        return when (value) {
            MissionType.Photo -> "photo"
            MissionType.Text -> "text"
            MissionType.Gps -> "gps"
        }
    }

    @TypeConverter
    @JvmStatic
    fun toMissionType(value: String?): MissionType {
        return when (value?.toLowerCase()) {
            "photo" -> MissionType.Photo
            "text" -> MissionType.Text
            "gps" -> MissionType.Gps
            else -> throw InvalidParameterException("Expected \"photo\", \"text\" or \"gps\", got: $value")
        }
    }
}