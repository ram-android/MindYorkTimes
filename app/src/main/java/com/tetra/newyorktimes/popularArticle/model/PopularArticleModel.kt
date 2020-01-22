package com.tetra.newyorktimes.popularArticle.model

import com.tetra.newyorktimes.popularArticle.viewModel.helper.PopularArticleJson

class PopularArticleModel() {

    var results: ArrayList<ResultData> = ArrayList()
    private var json: PopularArticleJson? = null

    constructor(json: PopularArticleJson) : this() {
        this.json = json
        setData()
    }

    private fun setData() {
        with(json) {
            this!!.results?.let {
                if (it.size <= 0)
                    return@let
                for (result in it) {
                    this@PopularArticleModel.results.add(ResultData(result.title!!, result.abstract!!, result.byline!!, result.published_date!!, result.url!!))
                }
            }
        }
    }
}

data class ResultData (val title: String, val abstract: String, val byLine:String, val publishedDate: String, val url:String)