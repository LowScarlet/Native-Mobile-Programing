package com.ardy;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Config {
    // TODO EDIT
    public static String baseUrl = "https://c2b0-114-125-5-171.ngrok-free.app";
    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}