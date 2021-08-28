package com.blackbirds.shakil.kotlinrxjavawithretrofit2.Network

import com.blackbirds.shakil.kotlinrxjavawithretrofit2.Model.PostModel
import io.reactivex.Observable
import retrofit2.http.GET

interface APIService {
    @GET("posts")
    fun postsList(): Observable<List<PostModel>>
}