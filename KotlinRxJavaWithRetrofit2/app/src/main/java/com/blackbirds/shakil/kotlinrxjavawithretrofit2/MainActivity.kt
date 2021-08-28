package com.blackbirds.shakil.kotlinrxjavawithretrofit2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blackbirds.shakil.kotlinrxjavawithretrofit2.Adapter.PostListAdapter
import com.blackbirds.shakil.kotlinrxjavawithretrofit2.Common.Common
import com.blackbirds.shakil.kotlinrxjavawithretrofit2.Model.PostModel
import com.blackbirds.shakil.kotlinrxjavawithretrofit2.Network.APIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    var apiService: APIService? = null
    var recyclerViewPost: RecyclerView? = null
    var adapter: PostListAdapter? = null
    var compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiService = Common.aPIService

        recyclerViewPost = findViewById(R.id.recyclerViewPost)
        recyclerViewPost!!.setLayoutManager(LinearLayoutManager(this))

        fetchData()
    }

    private fun fetchData() {
        compositeDisposable.add(apiService!!.postsList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { postModels -> displayData(postModels) })
    }

    private fun displayData(postModels: List<PostModel>) {
        adapter = PostListAdapter(this, postModels)
        adapter!!.notifyDataSetChanged()
        recyclerViewPost!!.adapter = adapter
    }

    override fun onStop() {
        compositeDisposable.clear()
        super.onStop()
    }
}