package com.blackbirds.shakil.androidrxjavawithretrofit2.Network;

import com.blackbirds.shakil.androidrxjavawithretrofit2.Model.PostModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface APIService {
    @GET("posts")
    Observable<List<PostModel>> getPostsList();
}
