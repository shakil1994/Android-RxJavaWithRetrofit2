package com.blackbirds.shakil.kotlinrxjavawithretrofit2.Common

import com.blackbirds.shakil.kotlinrxjavawithretrofit2.Network.APIService
import com.blackbirds.shakil.kotlinrxjavawithretrofit2.Network.RetrofitClient

object Common {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    val aPIService: APIService
        get() = RetrofitClient.getRetrofitClient(BASE_URL).create(APIService::class.java)
}