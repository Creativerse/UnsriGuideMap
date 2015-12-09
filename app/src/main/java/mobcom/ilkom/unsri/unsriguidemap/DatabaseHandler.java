package mobcom.ilkom.unsri.unsriguidemap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Hasby on 05/12/2015.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "ugm";
    private static final String TABLE_NAME = "description";
    private static final String FIELD_ID = "id";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_DESCRIPTION = "description";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE "+ TABLE_NAME +" ("
                + FIELD_ID +" VARCHAR(50), "
                + FIELD_NAME +" VARCHAR(100), "
                + FIELD_DESCRIPTION +" VARCHAR(10) );";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop tabel lama jika sudah ada
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // Create tables again
        onCreate(db);
    }

    // Menambahkan data USER
    public void addData(String data) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FIELD_ID, "1");
        values.put(FIELD_NAME, "ini nama");
        values.put(FIELD_DESCRIPTION, "ini deskripsi");

        // memasukkan data
        db.insert(TABLE_NAME, null, values);
        db.close(); // Menutup koneksi database
    }

    public String getCompanyIdByToken(String token) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from "+ TABLE_NAME +" where "+ FIELD_ID +" = '" + token +"';", null);
        if (cursor != null) {
            cursor.moveToFirst();
            return cursor.getString(2);
        }
        else {
            return "no data";
        }
    }
}
