using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class TestScript : MonoBehaviour
{
    private AndroidJavaObject _androidObj = null;

    Text tex; 
    void Start()
    {
        tex = GameObject.Find("Canvas/Text").GetComponent<Text>();
        tex.text = "";
#if UNITY_ANDROID && !UNITY_EDITOR
        AndroidJavaClass jc = new AndroidJavaClass("com.unity3d.player.UnityPlayer");
        _androidObj = jc.GetStatic<AndroidJavaObject>("currentActivity");
        if (null != _androidObj)
        {
            _androidObj.Call("Init", this.gameObject.name);
        }
#endif
    }

    void OnGUI()
    {
        if (GUI.Button(new Rect(500, 500, 200, 60), "Button"))
        {
            if (null != _androidObj)
            {
                Debug.LogError("Unity Call TestFunc1");
                _androidObj.Call("UnityCallAndroid");
            }
        }

       
    }

    public void OnMessage(string message)
    {
        Debug.LogError("The Message call form Andriod ! message : " + message);
        tex.text = message;
    }
}