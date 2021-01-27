package com.fandipres.rekam

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import java.util.ArrayList

val DATABASE_NAME = "REKAM.db"
val DATABASE_VERSION = 1

val TABLE_USER = "tbl_user"
val COL_ID_USER = "id_user"
val COL_NAMA_USER = "nama_user"
val COL_EMAIL = "email"
val COL_PASSWORD = "password"
val COL_HANDPHONE = "handphone"

val TABLE_KAMERA = "tbl_kamera"
val COL_ID_KAMERA = "id_kamera"
val COL_NAMA_KAMERA = "nama_kamera"
val COL_TIPE = "tipe_kamera"
val COL_BIAYA = "biaya"
val COL_DESKRIPSI = "deskripsi"
val COL_GAMBAR = "gambar"

val TABLE_TRANSAKSI = "tbl_transaksi"
val COL_ID_TRANSAKSI = "id_transaksi"
val COL_LAMA = "lama"
val COL_TOTALBIAYA = "total_biaya"
val COL_TGLMULAI = "tanggal_mulai"
val COL_TGLAKHIR = "tanggal_akhir"

val CREATE_TABLE_USER =
        "CREATE TABLE " + TABLE_USER + "(" + COL_ID_USER + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_NAMA_USER + " TEXT," + COL_EMAIL + " TEXT," + COL_PASSWORD + " TEXT," + COL_HANDPHONE + " TEXT)";
val CREATE_TABLE_KAMERA =
        "CREATE TABLE " + TABLE_KAMERA + "(" + COL_ID_KAMERA + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_NAMA_KAMERA + " TEXT," + COL_TIPE + " TEXT," + COL_BIAYA + " INTEGER," + COL_DESKRIPSI + " TEXT," + COL_GAMBAR + " BYTE)";
val CREATE_TABLE_TRANSAKSI =
        "CREATE TABLE " + TABLE_TRANSAKSI + "(" + COL_ID_TRANSAKSI + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_ID_USER + " INTEGER," + COL_ID_KAMERA + " INTEGER," + COL_LAMA + " INTEGER," + COL_TOTALBIAYA + " INTEGER," + COL_TGLMULAI + " TEXT," + COL_TGLAKHIR + " TEXT)";

class DataBaseHandler(var context: Context) :
        SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE_USER);
        db?.execSQL(CREATE_TABLE_KAMERA);
        db?.execSQL(CREATE_TABLE_TRANSAKSI);
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun addUser(classUser: ClassUser) {
        var db = this.writableDatabase;
        var cv = ContentValues();

        cv.put(COL_NAMA_USER, classUser.nama)
        cv.put(COL_EMAIL, classUser.email)
        cv.put(COL_PASSWORD, classUser.password)
        cv.put(COL_HANDPHONE, classUser.handphone)
        var result = db.insert(TABLE_USER, null, cv);
        if (result == -1.toLong())
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        db.close()
    }

    fun addKamera(classCamera: ClassCamera) {
        var db = this.writableDatabase;
        var cv = ContentValues();

        cv.put(COL_NAMA_KAMERA, classCamera.nama)
        cv.put(COL_TIPE, classCamera.tipe)
        cv.put(COL_BIAYA, classCamera.biaya)
        cv.put(COL_DESKRIPSI, classCamera.deskripsi)
        cv.put(COL_GAMBAR, classCamera.gambar)
        var result = db.insert(TABLE_KAMERA, null, cv);
        if (result == -1.toLong())
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
        db.close()
    }

    fun addTransaksi(classTransaction: ClassTransaction) {
        var db = this.writableDatabase;
        var cv = ContentValues();

        cv.put(COL_ID_USER, classTransaction.id_user)
        cv.put(COL_ID_KAMERA, classTransaction.id_kamera)
        cv.put(COL_LAMA, classTransaction.lama)
        cv.put(COL_TOTALBIAYA, classTransaction.totalbiaya)
        cv.put(COL_TGLMULAI, classTransaction.tglmulai)
        cv.put(COL_TGLAKHIR, classTransaction.tglakhir)
        var result = db.insert(TABLE_TRANSAKSI, null, cv)
        if (result == -1.toLong())
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
        db.close()
    }

    fun deleteDatabase() {
        context.deleteDatabase("REKAM.db")
        Toast.makeText(context, "DELETED", Toast.LENGTH_SHORT).show()
    }

    fun checkUserExist(email: String, password: String): Boolean {
        var db = this.writableDatabase
        var query = "select * from tbl_user where email = '$email' and password = '$password'"
        var cursor = db.rawQuery(query, null)
        if (cursor.getCount() <= 0) {
            cursor.close()
            db.close()
            return false
        }
        cursor.close()
        db.close()
        return true;
    }

    fun checkUserEmail(email: String): Boolean {
        var db = this.readableDatabase
        var query = "select * from tbl_user where email = '$email'"
        var cursor = db.rawQuery(query, null)
        if (cursor.getCount() <= 0) {
            cursor.close()
            db.close()
            return false
        }
        cursor.close()
        db.close()
        return true;
    }

    fun readAllCamera(): MutableList<ClassCamera> {
        var listClassCamera: MutableList<ClassCamera> = ArrayList()

        var db = this.readableDatabase
        var query = "select * from tbl_kamera"
        var cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                var camera = ClassCamera()
                camera.id = cursor.getString(cursor.getColumnIndex(COL_ID_KAMERA)).toInt()
                camera.nama = cursor.getString(cursor.getColumnIndex(COL_NAMA_KAMERA))
                camera.tipe = cursor.getString(cursor.getColumnIndex(COL_TIPE))
                camera.biaya = cursor.getString(cursor.getColumnIndex(COL_BIAYA)).toInt()
                camera.deskripsi = cursor.getString(cursor.getColumnIndex(COL_DESKRIPSI))
                listClassCamera.add(camera)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return listClassCamera
    }

    fun readAllTransaksi(): MutableList<ClassTransaction> {
        var listTransaksi: MutableList<ClassTransaction> = ArrayList()

        var db = this.readableDatabase
        var query = "select * from tbl_transaksi"
        var cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                var transaksi = ClassTransaction()
                transaksi.id = cursor.getString(cursor.getColumnIndex(COL_ID_TRANSAKSI)).toInt()
                transaksi.id_user = cursor.getString(cursor.getColumnIndex(COL_ID_USER)).toInt()
                transaksi.id_kamera = cursor.getString(cursor.getColumnIndex(COL_ID_KAMERA)).toInt()
                transaksi.totalbiaya = cursor.getString(cursor.getColumnIndex(COL_TOTALBIAYA)).toInt()
                transaksi.lama = cursor.getString(cursor.getColumnIndex(COL_LAMA)).toInt()
                transaksi.tglmulai = cursor.getString(cursor.getColumnIndex(COL_TGLMULAI))
                transaksi.tglakhir = cursor.getString(cursor.getColumnIndex(COL_TGLAKHIR))
                listTransaksi.add(transaksi)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return listTransaksi
    }
}