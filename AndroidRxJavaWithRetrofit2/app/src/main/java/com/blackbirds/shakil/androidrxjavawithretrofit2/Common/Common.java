package com.blackbirds.shakil.androidrxjavawithretrofit2.Common;

import com.blackbirds.shakil.androidrxjavawithretrofit2.Network.APIService;
import com.blackbirds.shakil.androidrxjavawithretrofit2.Network.RetrofitClient;

public class Common {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    public static APIService getAPIService(){
        return RetrofitClient.getRetrofitClient(BASE_URL).create(APIService.class);
    }
}
