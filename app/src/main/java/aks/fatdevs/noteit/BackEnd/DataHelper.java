package aks.fatdevs.noteit.BackEnd;

import android.provider.BaseColumns;

public class DataHelper {

    private DataHelper() {}
    public static class TableContents implements BaseColumns {
        public static final String note_content = "table_name";
        public static final String note_title_col= "NoteTitle";
        public static final String image_uri_col= "ImageUri";
        public static final String note_para_col = "NotePara";
        public static final String time_col = "Time";

    }

    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + TableContents.note_content + "("
            + TableContents._ID + " INTEGER PRIMARY KEY,"                   // 0
            + TableContents.note_title_col + " VARCHAR,"//1
            + TableContents.note_para_col + " VARCHAR,"//2
            + TableContents.time_col + " VARCHAR,"//3
            + TableContents.image_uri_col + " VARCHAR" + ")";//4
      public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TableContents.note_content;
}
