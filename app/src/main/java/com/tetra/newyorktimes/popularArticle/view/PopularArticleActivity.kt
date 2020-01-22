package com.tetra.newyorktimes.popularArticle.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.google.gson.Gson
import com.tetra.newyorktimes.R
import com.tetra.newyorktimes.constants.Constant
import com.tetra.newyorktimes.popularArticle.adapter.ArticlesAdapter
import com.tetra.newyorktimes.popularArticle.model.ResultData
import com.tetra.newyorktimes.popularArticle.viewModel.PopularArticleViewModel
import com.tetra.newyorktimes.popularArticle.viewModel.helper.PopularArticleJson
import com.tetra.newyorktimes.volley.VolleySingleton
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class PopularArticleActivity : AppCompatActivity(), PopularArticleViewModel.Callback,
    ArticlesAdapter.Callback {
    private val tag = PopularArticleActivity::class.java.simpleName
    private var viewModel: PopularArticleViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        *  Fetch the popular articles list using the Popular articles API
        */
        getPopularArticleList({
            //Completion callback
            val json = Gson().fromJson(it, PopularArticleJson::class.java)
            viewModel = PopularArticleViewModel(this, json)
            viewModel!!.onCreate()
        }, {
            //Error callback
            Log.e(tag, "Something went wrong. Try again")
        })
    }

    /*
    *  Backend call @GET Popular articles using API key
    */
    private fun getPopularArticleList(
        completion: (response: String) -> Unit,
        errorCallback: (error: String) -> Unit
    ) {
        val stringRequest = StringRequest(
            Request.Method.GET, Constant.URL + Constant.API_KEY,
            Response.Listener<String> { response ->
                if (response != null && response.contains("404")) {
                    Toast.makeText(
                        this,
                        "There is no content to display for this given url",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@Listener
                }
                completion(response)
                Log.e(tag, "URL Response is: $response")
            },
            Response.ErrorListener { error ->
                errorCallback(error.toString())
                Toast.makeText(this, "JSON URL error fetching data", Toast.LENGTH_SHORT)
                    .show()
                Log.e(tag, "Volley Error ${error.message}")
            })
        VolleySingleton.instance.addToRequestQueue(stringRequest)
    }

    /*
    * Callback received once data separated
    */
    override fun loadPopularArticles(results: ArrayList<ResultData>?) {
        if (results.isNullOrEmpty())
            return
        val articlesAdapter = ArticlesAdapter(this, this, results)
        articleList.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        articleList.adapter = articlesAdapter
    }

    /*
    *  Perform the click action once the article selected by the user
    */
    override fun itemClicked(url: String) {
        val details = Intent(this, DetailsActivity::class.java)
        details.putExtra("url", url)
        startActivity(details)
    }
}
