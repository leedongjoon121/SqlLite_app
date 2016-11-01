package com.example.seoul_app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by 동준 on 2016-10-29.
 */
public class web_url extends Activity {

    Button munhwajechong, seoulasa, seoulmhpt, sdmha, mhjd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_url);

        munhwajechong = (Button) findViewById(R.id.munhwajechong);
        seoulasa = (Button) findViewById(R.id.seoulasa);
        seoulmhpt = (Button) findViewById(R.id.seoulmhpt);
        sdmha = (Button)findViewById(R.id.sdmha);
        mhjd = (Button)findViewById(R.id.mhjd);
    }

    public void onClick(View view) {

        String url1 = "http://www.cha.go.kr/cha/idx/Index.do?mn=NS_01";
        String url2 = "http://www.museum.seoul.kr/www/NR_index.do?sso=ok";
        String url3 = "http://culture.seoul.go.kr/";
        String url4 = "http://www.sdmcc.co.kr/";
        String url5 = "http://www.chf.or.kr/";

        if (view.equals(munhwajechong)) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url1));
            startActivity(intent);
        }
        else if (view.equals(seoulasa)) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url2));
            startActivity(intent);
        } else if (view.equals(seoulmhpt)) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url3));
            startActivity(intent);
        }else if (view.equals(sdmha)) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url4));
            startActivity(intent);
        }else if (view.equals(mhjd)) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url5));
            startActivity(intent);
        }
    }
}