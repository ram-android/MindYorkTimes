package com.tetra.newyorktimes.popularArticle.model

import com.tetra.newyorktimes.popularArticle.viewModel.helper.PopularArticleJson
import com.tetra.newyorktimes.popularArticle.viewModel.helper.Result
import java.util.*

class PopularArticleModel() {

    var results: ArrayList<Result>? = null
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
                this@PopularArticleModel.results = it
            }
        }
    }
}