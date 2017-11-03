package org.androidtown.samplereceiver;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int permissionCheck= ContextCompat.checkSelfPermission(this,
                Manifest.permission.RECEIVE_SMS);
        if(permissionCheck== PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this,"SMS 수신 권한 있음",Toast.LENGTH_LONG).show();
        }else{
            
        }
    }
}
