package com.example.mysubscribers.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mysubscribers.data.db.dao.SubscriberDao
import com.example.mysubscribers.data.db.entity.SubscriberEntity

@Database(entities = [SubscriberEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun subscriberDao(): SubscriberDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance: AppDatabase? = INSTANCE
                if (instance == null) {
                    // inicio Doc
                    instance = Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        "app_database"
                    ).build()
                    // Fim Doc
                }
                return instance
            }
        }
    }
}