package com.ardy;

import androidx.fragment.app.Fragment;

public class MainModel {
    Fragment fragment;
    int icon;
    String title;
    String api;
    String description;

    public MainModel(Fragment fragment, int icon, String title, String api, String description) {
        this.fragment = fragment;
        this.icon = icon;
        this.title = title;
        this.api = api;
        this.description = description;
    }
}
