package com.indialone.indieapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import com.indialone.indieapp.R
import com.indialone.indieapp.databinding.ActivityWebViewBinding
import com.indialone.indieapp.utils.Constants

class WebViewActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityWebViewBinding
    private var link: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        if (intent.hasExtra(Constants.EXTRA_LINK)) {
            link = intent.getStringExtra(Constants.EXTRA_LINK)!!
        }

        mBinding.webview.loadUrl(link)
        mBinding.webview.settings.javaScriptEnabled = true
        mBinding.webview.settings.loadsImagesAutomatically = true
        mBinding.webview.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
        mBinding.webview.webViewClient = WebViewClient()

    }
}