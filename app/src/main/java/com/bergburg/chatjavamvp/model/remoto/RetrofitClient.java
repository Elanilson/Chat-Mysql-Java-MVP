package com.bergburg.chatjavamvp.model.remoto;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit INSTACE;
    private static Retrofit getRetrofitInstace(){
        if(INSTACE == null){
            synchronized (RetrofitClient.class){
                INSTACE = new  Retrofit.Builder()
                        .baseUrl("https://apkdoandroidonline.com/appChat/api/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }

        }
        return INSTACE;
    }
    public static <T> T classService(Class<T> classService){
        return getRetrofitInstace().create(classService);
    }

}
