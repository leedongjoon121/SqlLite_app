package com.example.seoul_app;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.json.JSONObject;

public class MainActivity extends Activity {

  Button search_cul, DB, M_picture, M_weburl, M_daummap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search_cul = (Button)findViewById(R.id.M_search_cul);
         DB = (Button)findViewById(R.id.M_DB);
        M_picture = (Button)findViewById(R.id.M_picture);
        M_weburl = (Button)findViewById(R.id.M_weburl);
        M_daummap = (Button)findViewById(R.id.M_daummap);
    }

    public void onClick(View view){

        String url1 = "https://m.map.daum.net/actions/searchView?q=%EC%84%9C%EC%9A%B8+%EC%9C%A0%ED%98%95+%EB%AC%B8%ED%99%94%EC%9E%AC#!/all/map/place";

        if(view.equals(search_cul)){
            Intent intent = new Intent(MainActivity.this,search.class);
            startActivity(intent);
        }else if(view.equals(DB)){
            Intent intent = new Intent(MainActivity.this, db.class);
            startActivity(intent);
        }else if(view.equals(M_picture)){
            Intent intent = new Intent(MainActivity.this, picture.class);
            startActivity(intent);
        }else if(view.equals(M_weburl)){
            Intent intent = new Intent(MainActivity.this, web_url.class);
            startActivity(intent);
        }

        else if(view.equals(M_daummap)){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url1));
            startActivity(intent);
        }

    }
}
