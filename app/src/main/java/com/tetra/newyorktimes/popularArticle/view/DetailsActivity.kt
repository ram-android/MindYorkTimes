package com.tetra.newyorktimes.popularArticle.view

import android.app.Activity
import android.graphics.Bitmap
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tetra.newyorktimes.R
import kotlinx.android.synthetic.main.details.*

class DetailsActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details)

        progressBar.visibility = View.VISIBLE
        val detailsPage = intent.getStringExtra("url")
        webView.webViewClient = MyWebViewClient(this, webView, progressBar)
        webView.loadUrl(detailsPage)
    }

    class MyWebViewClient internal constructor(
        private val activity: Activity,
        private val webView: WebView,
        private val progressBar: ProgressBar
    ) : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            val url: String = request?.url.toString();
            view?.loadUrl(url)
            return true
        }

        override fun shouldOverrideUrlLoading(webView: WebView, url: String): Boolean {
            webView.loadUrl(url)
            return true
        }

        override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceError) {
            Toast.makeText(activity, "Got Error! $error", Toast.LENGTH_SHORT).show()
        }

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            progressBar.visibility = View.GONE
        }
        
        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            Handler().postDelayed({
                webView.visibility = View.VISIBLE
            }, 1000)
        }
    }
}