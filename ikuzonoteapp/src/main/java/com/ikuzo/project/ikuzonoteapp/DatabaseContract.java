package com.ikuzo.project.ikuzonoteapp;

import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Vanillazz on 08/02/2018.
 */

public class DatabaseContract {

    public static String TABLE_NOTE = "note";

    public static final class NoteColumns implements BaseColumns {

        //Note title
        public static String TITLE = "title";
        //Note description
        public static String DESCRIPTION = "description";
        //Note date
        public static String DATE = "date";
    }


    public static final String AUTHORITY = "com.ikuzo.project.mynotesapp";

    public static final Uri CONTENT_URI = new Uri.Builder().scheme("content")
            .authority(AUTHORITY)
            .appendPath(TABLE_NOTE)
            .build();

    public static String getColumnString(Cursor cursor, String columnName){
        return cursor.getString(cursor.getColumnIndexOrThrow(columnName));
    }
    public static int getColumnInt(Cursor cursor, String columnName){
        return cursor.getInt(cursor.getColumnIndexOrThrow(columnName));
    }
    public static long getColumnLong(Cursor cursor, String columnName){
        return cursor.getLong(cursor.getColumnIndexOrThrow(columnName));
    }
}
