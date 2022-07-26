package com.example.msp_app.ui.login.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.msp_app.R;
import com.example.msp_app.databinding.FragmentForgotPasswordBinding;
import com.example.msp_app.ui.login.LoginFragmentManger;

public class ForgotPasswordFragment extends Fragment implements View.OnClickListener{

    FragmentForgotPasswordBinding fragmentForgotPasswordBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentForgotPasswordBinding=FragmentForgotPasswordBinding.inflate(inflater,container,false);
        fragmentForgotPasswordBinding.sendBtn.setOnClickListener(this);
        fragmentForgotPasswordBinding.loginText.setOnClickListener(this);
        return fragmentForgotPasswordBinding.getRoot();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.sendBtn:
                //ToDO
                // Function send Email contain the password to the user Email
                break;
            case R.id.loginText:
                LoginFragmentManger.getFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.fast_slide_from_bottom,R.anim.shrink)
                        .replace(R.id.LoginFragContainer,LoginFragment.class,null)
                        .commit();
        }
    }
    public boolean isValid()
    {
        if(fragmentForgotPasswordBinding.fUsername.length()==0)
        {
            fragmentForgotPasswordBinding.fUsername.setError("Please enter your Username");
            return false;
        }
        return true;
    }
}