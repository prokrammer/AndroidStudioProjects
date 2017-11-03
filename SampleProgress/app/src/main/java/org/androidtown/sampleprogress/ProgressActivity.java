package org.androidtown.sampleprogress;

import android.app.Activity;

        import android.app.*;
        import android.content.*;
        import android.os.*;
        import android.view.*;
        import android.widget.*;

public class ProgressActivity extends Activity {
    int mValue;
    TextView mText;
    ProgressDialog mProgress;//프로그래스 대화상자 선언
    boolean mQuit;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        mText=(TextView)findViewById(R.id.text);
    }

    public void mOnClick(View v) {
        mValue = 0;
        showDialog(0);//프로그래스 대화상자 보여주는 부분
        mQuit = false;
        mHandler.sendEmptyMessage(0);
    }

    //프로그래스 대화상자를 만드는 부분
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case 0:
                mProgress = new ProgressDialog(this);
                mProgress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);//프로그래스바 모양을 막대모양으로

                mProgress.setTitle("Updating");//타이틀
                mProgress.setMessage("Wait...");//메시지
                mProgress.setCancelable(false);//back버튼으로 닫을수 없게함

                //버튼이름과 리스너를 달아줌
                mProgress.setButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        mQuit = true;
                        dismissDialog(0);//대화상자를 없앤다
                    }
                });
                return mProgress;
        }
        return null;
    }

    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            mValue++;
            mText.setText(Integer.toString(mValue));
            try {
                Thread.sleep(30); //50ms 멈춤
            }
            catch (InterruptedException e) {;}

            if (mValue < 100 && mQuit == false) {
                mProgress.setProgress(mValue);//프로그래스값을 바꿈
                mHandler.sendEmptyMessage(0);//메시지를 보냄
            } else {
                dismissDialog(0);//다이얼로그를 없앰
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Toast.makeText(getApplicationContext(),String.valueOf(intent.getFlags()),Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }
        }
    };
}