package com.example.haitm.sqlitedemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtName;
    Button btnGetName, btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = (TextView) findViewById(R.id.textView);
        btnGetName = (Button) findViewById(R.id.button_getname);
        btnUpdate = (Button) findViewById(R.id.button_update);

        MyDBHelper mDB = new MyDBHelper(getApplicationContext());
        final SQLiteDatabase sqlDB = mDB.getWritableDatabase();
        SinhVien sv = new SinhVien(11,"Tran Minh Hai","20131271",1,21);
        ContentValues ct = new ContentValues();
        ct.put("full_name", sv.fullName);
        ct.put("student_id", sv.studentID);
        ct.put("gender", sv.gender);
        ct.put("year", sv.year);
        sqlDB.insert(MyDBHelper.TABLE_NAME, null, ct);

        btnGetName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = sqlDB.query(MyDBHelper.TABLE_NAME, null, "student_id = 20131271", null, null, null, null, "1");
                cursor.moveToFirst();
                txtName.setText(cursor.getString(1).toString());
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues ct = new ContentValues();
                ct.put("full_name", "Tran Minh Hai");
                ct.put("student_id", "20131271");
                ct.put("gender", 1);
                ct.put("year", 22);
                sqlDB.update(MyDBHelper.TABLE_NAME, ct, "_id = 11", null );
                Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
