package com.example.msp_app.ui.login.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.transition.TransitionInflater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.msp_app.R;
import com.example.msp_app.databinding.FragmentLoginBinding;
import com.example.msp_app.ui.home.HomeActivity;
import com.example.msp_app.ui.login.LoginFragmentManger;

public class LoginFragment extends Fragment  implements View.OnClickListener{

    FragmentLoginBinding fragmentLoginBinding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentLoginBinding=FragmentLoginBinding.inflate(inflater,container,false);
        fragmentLoginBinding.loginBtn.setOnClickListener(this);
        fragmentLoginBinding.forgotPass.setOnClickListener(this);
        return fragmentLoginBinding.getRoot();

    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.loginBtn:
                //ToDo validate username and password
                if(isValid()) {
                    signUser();
                    getActivity().startActivity(new Intent(getActivity(), HomeActivity.class));
                    getActivity().finish();
                }
                break;
            case R.id.forgotPass:
                LoginFragmentManger.getFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.fast_slide_from_bottom,R.anim.shrink)
                        .replace(R.id.LoginFragContainer,ForgotPasswordFragment.class,null)
                        .commit();
        }
    }

    public void signUser()
    {
        SharedPreferences sharedPreferences= getActivity().getSharedPreferences("appData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putInt("loggedUesr",-1);
        editor.commit();
    }
    public boolean isValid()
    {
        if(fragmentLoginBinding.userName.length()==0)
        {
            fragmentLoginBinding.userName.setError("Please enter your Username");
            return false;
        }
        if(fragmentLoginBinding.password.length()==0)
        {
            fragmentLoginBinding.password.setError("Please enter your Password");
            return false;
        }
        return true;
    }
}