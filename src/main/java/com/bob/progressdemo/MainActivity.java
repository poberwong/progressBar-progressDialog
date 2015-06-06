package com.bob.progressdemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  progressDialog= new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);//水平进度条对话框*/
        //ProgressDialog.STYLE_SPINNER表示没有具体指示的圆形进度条
       /* dialog.setMax(100);
        dialog.show();

        new Thread(){
            @Override
            public void run() {
                int i= 0;
                while(i< 100){
                    try {
                        Thread.sleep(100);
                        dialog.setProgress(i++);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                dialog.dismiss();
            }
        }.start();*/
        showProgressDialog();
        new Thread(){
            @Override
            public void run() {//阻塞任务绝对不可以交给主线程，要不然它可是会罢工的
                try {
                    Thread.sleep(3000);
                    progressDialog.dismiss();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    private void showProgressDialog()// 显示进度对话框
    {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("加载中···");
            progressDialog.setCanceledOnTouchOutside(false);
        }
        progressDialog.show();
    }

    public void onclick(View view){

        Intent intent =new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_left_in,R.anim.push_no);//设置活动切换的过渡动画
    }
}
