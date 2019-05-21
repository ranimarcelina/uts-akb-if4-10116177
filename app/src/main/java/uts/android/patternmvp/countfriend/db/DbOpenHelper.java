package uts.android.patternmvp.countfriend.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*
Tanggal Pengerjaan : 18 Mei 2019
NIM : 10116177
Nama : Rani Marcelina
Kelas : AKB-4
*/

public class DbOpenHelper extends SQLiteOpenHelper {
  private static final String DB_NAME = "ContactBook.db";
  private static final String TABLE_NAME = "contact";

  private static final String CREATE_TABLE = "create table contact(" +
          "_id integer primary key autoincrement, "+
          "name text, "+
          "phone text, "+
          "groupName text);";

  public DbOpenHelper(Context context) {
    super(context, DB_NAME, null, 1);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL(CREATE_TABLE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

  }
}
