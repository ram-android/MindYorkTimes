package com.tetra.newyorktimes.popularArticle.viewModel

import com.tetra.newyorktimes.popularArticle.model.PopularArticleModel
import com.tetra.newyorktimes.popularArticle.viewModel.helper.PopularArticleJson
import com.tetra.newyorktimes.popularArticle.viewModel.helper.Result
import java.util.ArrayList

class PopularArticleViewModel() {

    private var callback: Callback? = null
    private lateinit var model: PopularArticleModel

    constructor(callback: Callback, json: PopularArticleJson) : this() {
        this.callback = callback
        model = PopularArticleModel(json)
    }

    fun onCreate() {
        callback?.loadPopularArticles(model.results)
    }

    interface Callback {
        fun loadPopularArticles(results: ArrayList<Result>?)
    }
}