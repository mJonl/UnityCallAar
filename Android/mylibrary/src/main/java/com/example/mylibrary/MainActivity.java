package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;
import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

public class MainActivity extends UnityPlayerActivity {
    private static final String TAG_UNITY = "Unity";
    //Unity 回调对象
    private String _strCallbackGameObjectName = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    //初始化回调对象
    public void Init(String callbackGoName){
        this._strCallbackGameObjectName = callbackGoName;
        //Log.i(TAG_UNITY, "Init " + callbackGoName);
        Toast.makeText(this,"Init" + callbackGoName, Toast.LENGTH_LONG).show();
    }

    //unity调用Android
    public void UnityCallAndroid(){
        //Log.i(TAG_UNITY, "TestFunc1");
        Toast.makeText(this,"unity调用android成功", Toast.LENGTH_LONG).show();
        AndoridCallUnity();
    }

    //Android调用Unity
    public void AndoridCallUnity(){
        //第1个参数为Unity场景中用于接收android消息的对象名称
        //第2个参数为对象上的脚本的一个成员方法名称（脚本名称不限制）
        //第3个参数为unity方法的参数
        UnityPlayer.UnitySendMessage("receiveObj", "OnMessage", "Android调用Unity成功");
    }
}
