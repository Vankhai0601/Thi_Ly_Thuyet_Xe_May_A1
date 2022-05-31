package sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.Cauhoi;

import android.content.Context;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/**
 * Created by ADMIN on 11/13/2016.
 */


public class KetNoiCauHoi {
    private DBHelper dbHelper;

    public KetNoiCauHoi(Context context) {
        dbHelper = new DBHelper(context);
    }

    //    //Lấy danh sách câu hỏi theo dạng mảng
    public ArrayList getQuestion(int num_exam, String subject) {
        ArrayList<Cauhoi> lsData = new ArrayList<Cauhoi>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Cauhoi WHERE num_exam='"+num_exam+"' AND subject='"+subject+"'", null);
        cursor.moveToFirst();
        do {
            Cauhoi item;
            item = new Cauhoi(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getInt(7),
                    cursor.getString(8),
                    cursor.getString(7),"");//tên ảnh

            lsData.add(item);
        } while (cursor.moveToNext());
        return lsData;
    }
}
