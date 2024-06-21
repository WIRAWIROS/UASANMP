package com.ubaya.hobbyuas_anmp.util

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ubaya.hobbyuas_anmp.model.HobbyDatabase

val DB_NAME = "newtododb"

fun buildDb(context: Context): HobbyDatabase {
    val db = Room.databaseBuilder(context,
        HobbyDatabase::class.java, DB_NAME)
        .addMigrations(MIGRATION_1_2) // Added new migration
        .build()

    return db
}

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "ALTER TABLE todo ADD COLUMN priority INTEGER DEFAULT 3 not null")
    }
}