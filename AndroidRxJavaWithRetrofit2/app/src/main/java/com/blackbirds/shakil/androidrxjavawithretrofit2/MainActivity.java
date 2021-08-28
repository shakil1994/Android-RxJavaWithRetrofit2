package com.blackbirds.shakil.androidrxjavawithretrofit2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.blackbirds.shakil.androidrxjavawithretrofit2.Adapter.PostListAdapter;
import com.blackbirds.shakil.androidrxjavawithretrofit2.Common.Common;
import com.blackbirds.shakil.androidrxjavawithretrofit2.Model.PostModel;
import com.blackbirds.shakil.androidrxjavawithretrofit2.Network.APIService;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    APIService apiService;
    RecyclerView recyclerViewPost;
    PostListAdapter adapter;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiService = Common.getAPIService();

        recyclerViewPost = findViewById(R.id.recyclerViewPost);
        recyclerViewPost.setLayoutManager(new LinearLayoutManager(this));

        fetchData();
    }

    private void fetchData() {
        compositeDisposable.add(apiService.getPostsList()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(postModels -> {
            displayData(postModels);
        }));
    }

    private void displayData(List<PostModel> postModels) {
        adapter = new PostListAdapter(this, postModels);
        adapter.notifyDataSetChanged();
        recyclerViewPost.setAdapter(adapter);
    }

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }
}