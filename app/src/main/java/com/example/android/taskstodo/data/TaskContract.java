package com.example.android.taskstodo.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public class TaskContract {
    private TaskContract(){}
    public static final String CONTENT_AUTHORITY = "com.example.android.taskstodo";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    /**
     +     * Possible path (appended to base content URI for possible URI's)
     +     * For instance, content://com.example.android.pets/pets/ is a valid path for
     +     * looking at pet data. content://com.example.android.pets/staff/ will fail,
     +     * as the ContentProvider hasn't been given any information on what to do with "staff".
     +     */
    public static final String PATH_TASK = "taskstodo";

    public static final class TaskEntry implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_TASK);
        public final static String TABLE_NAME = "taskstodo";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_TASK ="tasks";
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TASK;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single pet.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TASK;
    }
}
