package aks.fatdevs.noteit.BackEnd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import aks.fatdevs.noteit.DataAndModels.Model;

public class SqliteDataBaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "demo.db";
    private static final int DATABASE_VERSION = 1;
    public SqliteDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) { // called when db is created
        db.execSQL(DataHelper.SQL_CREATE_ENTRIES);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DataHelper.SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
    public boolean AddContentToTable(Model model) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataHelper.TableContents.note_title_col, model.getNote_title());
        contentValues.put(DataHelper.TableContents.note_para_col, model.getNote_para());
        contentValues.put(DataHelper.TableContents.image_uri_col, model.getImage_uri());
        contentValues.put(DataHelper.TableContents.time_col, model.getTime());
        long statusCode = database.insert(DataHelper.TableContents.note_content, null, contentValues);
        return statusCode!=-1?true:false;
    }

    public Cursor getAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        String Query = "SELECT * FROM "+ DataHelper.TableContents.note_content;
        Cursor td = db.rawQuery(Query, null);
        return td;
    }


    //("SELECT * FROM DataHelper.TableContents.note_content ORDER BY para_num ASC")
    public Cursor getASCOrderedDataByParaNum() {
        SQLiteDatabase db = this.getWritableDatabase();
        String Query = "SELECT * FROM " + DataHelper.TableContents.note_content + "ORDER BY" + DataHelper.TableContents._ID +"ASC";
        Cursor td = db.rawQuery(Query, null);
        return td;
    }

    //("SELECT * FROM DataHelper.TableContents.note_content ORDER BY time ASC")
    public Cursor getASCOrderedDataByTime(){    SQLiteDatabase db = this.getWritableDatabase();
        String Query ="SELECT * FROM " + DataHelper.TableContents.note_content + "ORDER BY"+ DataHelper.TableContents.time_col +"ASC";
        Cursor td = db.rawQuery(Query, null);
        return td;}
    //("SELECT * FROM DataHelper.TableContents.note_content ORDER BY note_title ASC")
    public Cursor getASCOrderedDataByTitle(){    SQLiteDatabase db = this.getWritableDatabase();
        String Query = "SELECT * FROM "+ DataHelper.TableContents.note_content +"ORDER BY"+ DataHelper.TableContents.note_title_col + "ASC";
        Cursor td = db.rawQuery(Query, null);
        return td;}

    //("SELECT * FROM DataHelper.TableContents.note_content ORDER BY para_num DESC")
    public Cursor getDESCOrderedDataByParaNum(){    SQLiteDatabase db = this.getWritableDatabase();
        String Query = "SELECT * FROM " + DataHelper.TableContents.note_content +"ORDER BY" + DataHelper.TableContents._ID +"DESC";
        Cursor td = db.rawQuery(Query, null);
        return td;}

    //("SELECT * FROM DataHelper.TableContents.note_content ORDER BY time DESC")
    public Cursor getDESCOrderedDataByTime(){    SQLiteDatabase db = this.getWritableDatabase();
        String Query = "SELECT * FROM " + DataHelper.TableContents.note_content + "ORDER BY" + DataHelper.TableContents.time_col + "DESC";
        Cursor td = db.rawQuery(Query, null);
        return td;}

    //("SELECT * FROM DataHelper.TableContents.note_content ORDER BY note_title DESC")
    public Cursor getDESCOrderedDataByTitle(){    SQLiteDatabase db = this.getWritableDatabase();
        String Query = "SELECT * FROM " + DataHelper.TableContents.note_content + "ORDER BY" + DataHelper.TableContents.note_title_col + "DESC";
        Cursor td = db.rawQuery(Query, null);
        return td;}

    //("SELECT * FROM DataHelper.TableContents.note_content WHERE note_title = (:CustomTitle)")
    public Cursor getThisTitle(String CustomTitle){    SQLiteDatabase db = this.getWritableDatabase();
        String Query = "SELECT * FROM " + DataHelper.TableContents.note_content + "WHERE " + DataHelper.TableContents.note_title_col + "=" + CustomTitle;
        Cursor td = db.rawQuery(Query, null);
        return td;}

    //("SELECT * FROM DataHelper.TableContents.note_content WHERE time = (:CustomTime)")
    public Cursor getThisTime(int CustomTime){    SQLiteDatabase db = this.getWritableDatabase();
        String Query = "SELECT * FROM " + DataHelper.TableContents.note_content + "WHERE " + DataHelper.TableContents.time_col + "=" + CustomTime;
        Cursor td = db.rawQuery(Query, null);
        return td;}


    //("DELETE FROM DataHelper.TableContents.note_content")
    void clearTable(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + DataHelper.TableContents.note_content);

    }
    //("DELETE FROM DataHelper.TableContents.note_content WHERE note_title = (:thisTitle)")
    void deleteFromThisTitle(String thisTitle){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + DataHelper.TableContents.note_content + "WHERE" + DataHelper.TableContents.note_title_col +"=" + thisTitle);
    }
    //("DELETE FROM DataHelper.TableContents.note_content WHERE time = (:thisTime)")
    void deleteFromThisTime(int thisTime){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + DataHelper.TableContents.note_content + "WHERE" + DataHelper.TableContents.time_col +"=" + thisTime);

    }
}