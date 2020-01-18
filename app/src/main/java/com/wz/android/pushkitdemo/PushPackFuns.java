package com.wz.android.pushkitdemo;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.entity.AAIDResult;


public class PushPackFuns {

    private String TAG = "PushTAG";
    private Activity thisActivity;
    private String pushtoken;
    private String appID;

    public PushPackFuns(Activity thisActivity, String appid){
        this.thisActivity = thisActivity;
        this.appID = appid;
    }


    private void getAAID(){
        Task<AAIDResult> idResult = HmsInstanceId.getInstance(thisActivity).getAAID();
        idResult.addOnSuccessListener(new OnSuccessListener<AAIDResult>() {
            @Override
            public void onSuccess(AAIDResult aaidResult) {
                String aaid = aaidResult.getId();
                Log.i(TAG, "get aaId:" + aaid);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(Exception e) {
                Log.i(TAG, "getAAID failed");
            }
        });
    }
    /**
     * Get token
     */
    public void getToken() {
        Log.i(TAG, "get token: begin");

        //Step 1: get aaid
        getAAID();

        //Step 2: get token
        new Thread() {
            @Override
            public void run() {
                try {
                    String appId = appID;
                    pushtoken = HmsInstanceId.getInstance(thisActivity).getToken(appId, "HCM");
                    if(!TextUtils.isEmpty(pushtoken)) {
                        Log.i(TAG, "get token:" + pushtoken);
                        showLog(pushtoken);
                    }
                } catch (Exception e) {
                    Log.i(TAG,"getToken failed, " + e);

                }
            }
        }.start();
    }


    private void showLog(final String log) {
        thisActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(thisActivity, pushtoken, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
