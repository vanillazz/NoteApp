package com.ikuzo.project.mynotesapp.db;

import android.provider.BaseColumns;

/**
 * Created by Vanillazz on 08/02/2018.
 */

public class DatabaseContract {

    static String TABLE_NOTE = "note";

    static final class NoteColumns implements BaseColumns {

        //Note title
        static String TITLE = "title";
        //Note description
        static String DESCRIPTION = "description";
        //Note date
        static String DATE = "date";
    }
}
