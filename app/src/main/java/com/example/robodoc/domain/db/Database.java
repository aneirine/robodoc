package com.example.robodoc.domain.db;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.robodoc.domain.db.converters.Converters;
import com.example.robodoc.domain.db.dao.BloodDao;
import com.example.robodoc.models.Blood;


@androidx.room.Database(entities = {Blood.class}, version = 2)
@TypeConverters(Converters.class)
public abstract class Database extends RoomDatabase {
    private static final String DATABASE_NAME = "robodoc-database";

    public abstract BloodDao getBloodDao();

    private static Database instance;

    public static Database getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, Database.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }


}
