package net.taufik;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Config {
    // TODO EDIT
    public static String baseUrl = "https://3010-2001-448a-1082-b186-a066-9450-edac-4960.ngrok-free.app";
    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}