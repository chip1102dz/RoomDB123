package com.example.roomdb.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.roomdb.User;

import java.util.ArrayList;
import java.util.List;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "bangSQLite.db";
    public static final int VERSION = 1;

    public static final String TABLE_NAME = "users";
    public static final String KEY_ID = "user_id";
    public static final String NAME = "user_name";
    public static final String NGAYSINH = "user_ngaysinh";
    public static final String PHONE = "user_phone";
    public static final String CHUCVU = "user_chucvu";
    public static final String TINHNGUYEN = "user_tinhnguyen";

    public static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    KEY_ID + "INTERGER PRIMARY KEY AUTOINCREMENT," +
                    NAME + "TEXT," +
                    PHONE + "TEXT," +
                    NGAYSINH + "TEXT," +
                    CHUCVU + "TEXT," +
                    TINHNGUYEN + "TEXT" +
                    ");";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public List<User> getAllUser() {
        List<User> list = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(TABLE_NAME, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(cursor.getInt(cursor.getColumnIndexOrThrow(KEY_ID)));
                user.setName(cursor.getString(cursor.getColumnIndexOrThrow(NAME)));
                user.setPhone(cursor.getString(cursor.getColumnIndexOrThrow(PHONE)));
                user.setNgaysinh(cursor.getString(cursor.getColumnIndexOrThrow(NGAYSINH)));
                user.setChucvu(cursor.getString(cursor.getColumnIndexOrThrow(CHUCVU)));
                user.setTinhnguyen(cursor.getString(cursor.getColumnIndexOrThrow(TINHNGUYEN)));

                list.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        sqLiteDatabase.close();
        return list;
    }
    public void addUser(User user){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NAME, user.getName());
        values.put(PHONE, user.getPhone());
        values.put(NGAYSINH, user.getNgaysinh());
        values.put(CHUCVU, user.getChucvu());
        values.put(TINHNGUYEN, user.getTinhnguyen());

        sqLiteDatabase.insert(TABLE_NAME, null, values);
        sqLiteDatabase.close();
    }
}

