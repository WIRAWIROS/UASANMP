package com.ubaya.hobbyuas_anmp.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ubaya.hobbyuas_anmp.util.DB_NAME
import com.ubaya.hobbyuas_anmp.util.MIGRATION_1_2

@Database(entities = arrayOf(Hobby::class), version =  4)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile private var instance: UserDatabase ?= null
        private val LOCK = Any()

        fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                UserDatabase::class.java,
                DB_NAME)
                .addMigrations(MIGRATION_1_2)
                .build()
        operator fun invoke(context:Context) {
            if(instance!=null) {
                synchronized(LOCK) {
                    instance ?: buildDatabase(context).also {
                        instance = it
                    }
                }
            }
        }
    }

}