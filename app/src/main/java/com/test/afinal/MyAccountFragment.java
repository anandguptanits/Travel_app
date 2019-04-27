package com.test.afinal;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class MyAccountFragment extends Fragment {
    LoginButton loginButton;
    CallbackManager callbackManager;
    View v;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FacebookSdk.sdkInitialize(getActivity());
     //   loginButton.setReadPermissions("email","public_profile");
        callbackManager= CallbackManager.Factory.create();
        v= inflater.inflate(R.layout.fragment_myaccount, null);
        loginButton=v.findViewById(R.id.login_button);

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                String userid=loginResult.getAccessToken().getUserId();
                GraphRequest graphRequest =GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                          displayUserInfo(object);

                    }
                });
                Bundle parameters=new Bundle();
                parameters.putString("fields","first_name,last_name,email,id");
                graphRequest.setParameters(parameters);
                graphRequest.executeAsync();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

        return v;
    }

    public void displayUserInfo(JSONObject object){
        String first_name,last_name,email,id;
        first_name="";
        last_name="";
        email="";
        id="";
        try {
            first_name=object.getString("first_name");
            last_name=object.getString("last_name");
            email=object.getString("email");
            id=object.getString("id");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}