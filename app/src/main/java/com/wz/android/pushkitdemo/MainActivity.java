package com.wz.android.pushkitdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.entity.AAIDResult;

public class MainActivity extends AppCompatActivity {

    String TAG = "PushKit";
    private Button btnToken;
    private String pushtoken;


    /**ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ**/
    /**      for Push: Add Push class   *********/
    PushPackFuns hwPushPackFuns; // add Push Class

    String appid = "101193529"; // Please Change here !!!!!!!!

    /**ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ**/


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToken = findViewById(R.id.btn_get_token);
        hwPushPackFuns = new PushPackFuns(this,  appid);


        btnToken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hwPushPackFuns.getToken();

            }
        });


    }










}
