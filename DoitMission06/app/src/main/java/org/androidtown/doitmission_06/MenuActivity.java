package org.androidtown.doitmission_06;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void onClick2(View v){
        Intent intent = new Intent(this,CustomerActivity.class);
        startActivity(intent);
    }
    public void onClick3(View v){
        Intent intent = new Intent(this,SaleActivity.class);
        startActivity(intent);
    }
    public void onClick4(View v){
        Intent intent = new Intent(this,ProductActivity.class);
        startActivity(intent);
    }
}
