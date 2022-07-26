package com.example.msp_app.ui.login;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class LoginFragmentManger {
    static private FragmentManager fragmentManager;
    static private Fragment savedFragemnt;

    public static Fragment getSavedFragemnt() {
        return savedFragemnt;
    }

    public static void setSavedFragemnt(Fragment savedFragemnt) {
        LoginFragmentManger.savedFragemnt = savedFragemnt;
    }

    public static void setFragmentManager(FragmentManager fragmentManager) {
        LoginFragmentManger.fragmentManager = fragmentManager;
    }
    public static FragmentManager getFragmentManager() {
        return fragmentManager;
    }
}
