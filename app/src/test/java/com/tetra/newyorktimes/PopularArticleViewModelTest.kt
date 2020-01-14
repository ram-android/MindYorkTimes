package com.tetra.newyorktimes

import com.google.gson.Gson
import com.tetra.newyorktimes.popularArticle.viewModel.PopularArticleViewModel
import com.tetra.newyorktimes.popularArticle.viewModel.helper.PopularArticleJson
import com.tetra.newyorktimes.popularArticle.viewModel.helper.Result
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.util.*

class PopularArticleViewModelTest {
    private var viewModel: PopularArticleViewModel? = null
    private val callback: PopularArticleViewModelTestCallback =
        PopularArticleViewModelTestCallback()
    private val json =
        Gson().fromJson(PopularArticleTestJson.json, PopularArticleJson::class.java)

    @Before
    fun setUp() {
        callback.reset()
        viewModel = PopularArticleViewModel(callback, json)
    }

    @Test
    fun onCreateTest() {
        viewModel?.onCreate()
    }

    @After
    fun tearDown() {
        viewModel = null
    }

    class PopularArticleViewModelTestCallback : PopularArticleViewModel.Callback {
        var loadedResult = false

        override fun loadPopularArticles(results: ArrayList<Result>?) {
            loadedResult = true
        }
    }
}

private fun PopularArticleViewModelTest.PopularArticleViewModelTestCallback.reset() {
    loadedResult = false
}
