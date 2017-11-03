package org.androidtown.doitmission_03;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    ScrollView scrollView;
    BitmapDrawable bitmap;
    ScrollView scrollView2;
    BitmapDrawable bitmap2;
    ImageView imageView;
    ImageView imageView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = (ScrollView) findViewById(R.id.scrollView);
        imageView = (ImageView) findViewById(R.id.imageView);
        scrollView.setHorizontalScrollBarEnabled(true);

        Resources res = getResources();
        bitmap = (BitmapDrawable)res.getDrawable(R.drawable.image01);
        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();

        imageView.setImageDrawable(bitmap);
        imageView.getLayoutParams().width = bitmapWidth;
        imageView.getLayoutParams().height = bitmapHeight;


        scrollView2 = (ScrollView) findViewById(R.id.scrollView2);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        scrollView2.setHorizontalScrollBarEnabled(true);


        bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.image02);
        int bitmapWidth2 = bitmap2.getIntrinsicWidth();
        int bitmapHeight2 = bitmap2.getIntrinsicHeight();

        imageView2.setImageDrawable(bitmap2);
        imageView2.getLayoutParams().width = bitmapWidth2;
        imageView2.getLayoutParams().height = bitmapHeight2;

        imageView.setVisibility(View.INVISIBLE);
        imageView2.setVisibility(View.INVISIBLE);

    }

    public void onButton1Clicked(View v){

            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);



    }

    public void onButton2Clicked(View v){

            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);

    }

}