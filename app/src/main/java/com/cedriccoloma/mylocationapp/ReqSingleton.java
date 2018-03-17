package com.cedriccoloma.mylocationapp;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class ReqSingleton {
    private static ReqSingleton myInstance;
    private RequestQueue requestQueue;
    private static Context context;

    private ReqSingleton(Context context)
    {
        this.context = context;
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue(){

        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(context);

        }
        return requestQueue;
    }

    public static synchronized  ReqSingleton getInstance(Context context){
        if(myInstance == null){
            myInstance = new ReqSingleton(context);
        }
        return myInstance;
    }

    public<T> void addToRequestQueue(Request<T> request)
    {
        request.setShouldCache(false);
        requestQueue.add(request);
    }
}