package com.example.seoul_app;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ViewFlipper;

/**
 * Created by 동준 on 2016-10-15.
 */
public class search extends Activity {

    myDBHelper myHelper;
    EditText edtName, edtNumber,   edtNameResult, edtNumberResult;
    EditText edtDesc, edtSpot,  edtDescResult, edtSpotResult;
    Button btnInit, btnInert, btnSelect , btnPrev, btnNext;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        setTitle("문화재 관리 DB");

        final ViewFlipper vFlipper;

        edtName = (EditText)findViewById(R.id.edtName);
        edtNumber = (EditText)findViewById(R.id.edtNumber);
        edtDesc = (EditText)findViewById(R.id.edtDesc);
        edtSpot = (EditText)findViewById(R.id.edtSpot);

        edtDescResult = (EditText)findViewById(R.id.edtDescResult);
        edtSpotResult = (EditText)findViewById(R.id.edtSpotResult);
        edtNameResult = (EditText)findViewById(R.id.edtNameResult);
        edtNumberResult = (EditText)findViewById(R.id.edtNumberResult);

        btnInit = (Button)findViewById(R.id.btnInit);
        btnInert = (Button)findViewById(R.id.btnInsert);
        btnSelect = (Button)findViewById(R.id.btnSelect);

        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);
        vFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);

        myHelper = new myDBHelper(this);

        btnPrev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vFlipper.showPrevious();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vFlipper.showNext();
            }
        });


        btnInit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                sqlDB = myHelper.getWritableDatabase();
                myHelper.onUpgrade(sqlDB,1,2);
                sqlDB.close();
            }
        });

        btnInert.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                sqlDB = myHelper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO groupTBL VALUES ('"+edtName.getText().toString()+"',"+edtNumber.getText().toString()+",'"+edtDesc.getText().toString()+"','"+edtSpot.getText().toString()+"');");
                //sqlDB.execSQL("INSERT INTO groupTBL VALUES ('"+edtName.getText().toString()+"',"+edtNumber.getText().toString()+");");
                sqlDB.close();
                Toast.makeText(getApplicationContext(),"입력됨",0).show();
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // Toast.makeText(getApplicationContext(),"정보 출력",0).show();
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT * FROM groupTBL ;", null);

                String strNames = "분류번호" + "\r\n" + "-----" +"\r\n";
                String strNumbers = "문화재 이름" + "\r\n" + "-----" +"\r\n";
                String strDescription = "주소" + "\r\n" + "-----" +"\r\n";
                String strSpot = "상세주소" + "\r\n" + "-----" +"\r\n";

                while (cursor.moveToNext()){
                    strNames += cursor.getString(0)+ "\r\n";
                    strNumbers += cursor.getString(1) + "\r\n";
                    strDescription += cursor.getString(2) + "\r\n";
                    strSpot += cursor.getString(3) + "\r\n";
                }

                edtNameResult.setText(strNames);
                edtNumberResult.setText(strNumbers);
                edtDescResult.setText(strDescription);
                edtSpotResult.setText(strSpot);

                cursor.close();
                cursor.close();
                cursor.close();
                cursor.close();

            }
        });
    }

    public class myDBHelper extends SQLiteOpenHelper{
        public myDBHelper(Context context){
            super(context, "groupDB", null,1);
        }
        @Override
        public void onCreate(SQLiteDatabase db){
            db.execSQL("CREATE TABLE groupTBL (gName CHAR(20) PRIMARY KEY, gNumber INTEGER, descr CHAR(20), Spot CHAR(20) ); ");
            //   db.execSQL("CREATE TABLE groupTBL (gName CHAR(20) PRIMARY KEY, gNumber INTEGER); ");
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            db.execSQL("DROP TABLE IF EXISTS groupTBL");
            onCreate(db);
        }
    }


}
