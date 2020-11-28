package aks.fatdevs.noteit.Repository;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import aks.fatdevs.noteit.BackEnd.SqliteDataBaseHelper;
import aks.fatdevs.noteit.DataAndModels.Model;
import aks.fatdevs.noteit.R;

public class Repository {
    private static ArrayList<Model> data = new ArrayList<>();
    private static String Title;
    private static String ImageUri;
    private static final String TAG = "Repository";
    private static StringBuffer Para;
     private static String Time;
     private static Context context;
     public Repository(Context cont) {
         context = cont;
     }
     private static SqliteDataBaseHelper sqliteDataBaseHelper;
     public static ArrayList<Model> getData(){
         fillData();
         return data;
     }
     public static void importData(String title, StringBuffer para, String time, @Nullable String ImUri) {
       Time = time;
       Para = para;
       Title = title;
         ImageUri = ImUri;
     }
     private static boolean connect() {
         sqliteDataBaseHelper = new SqliteDataBaseHelper(context);
         boolean r = sqliteDataBaseHelper.AddContentToTable(new Model(Title, Para, Time, ImageUri));
         return r;
     }

     private static void fillData(){
         if(!connect()){
             throw new RuntimeException("DataBase Not Connected!!!");
         }
         Cursor CurData = sqliteDataBaseHelper.getAll();
         while (CurData.moveToNext()){
            Model model = new Model(CurData.getString(1),new StringBuffer(CurData.getString(3)),CurData.getString(2) ,CurData.getString(4));
            data.add(model);
             Log.d(TAG,CurData.getString(1));
         }
     }
}
