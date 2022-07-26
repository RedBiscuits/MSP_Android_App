package com.example.msp_app.ui.login.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.msp_app.R;
import com.example.msp_app.databinding.FragmentWelcomeBinding;
import com.example.msp_app.ui.login.LoginFragmentManger;

public class WelcomeFragment extends Fragment {

    public FragmentWelcomeBinding fragmentWelcomeBinding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentWelcomeBinding=FragmentWelcomeBinding.inflate(inflater,container,false);
        LoginFragmentManger.setSavedFragemnt(this);
        return fragmentWelcomeBinding.getRoot();
    }
}