package com.tetra.newyorktimes.volley

import android.text.TextUtils
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.tetra.newyorktimes.Session


class VolleySingleton {
    private var mRequestQueue: RequestQueue? = null

    private val requestQueue: RequestQueue?
        get() {
            if (mRequestQueue == null) {
                mRequestQueue = Volley.newRequestQueue(Session.getInstance())
            }
            return mRequestQueue
        }

    fun <T> addToRequestQueue(req: Request<T>, tag: String) {
        // set the default tag if tag is empty
        req.tag = if (TextUtils.isEmpty(tag)) TAG else tag
        requestQueue!!.add(req)
    }

    fun <T> addToRequestQueue(req: Request<T>) {
        req.tag = TAG
        requestQueue!!.add(req)
    }

    fun cancelPendingRequests(tag: Any) {
        if (mRequestQueue != null) {
            mRequestQueue!!.cancelAll(tag)
        }
    }

    companion object {

        private val TAG = VolleySingleton::class.java.simpleName
        private var sVolleySingleton: VolleySingleton? = null

        val instance: VolleySingleton
            get() {
                if (sVolleySingleton == null) {
                    sVolleySingleton = VolleySingleton()
                }
                return sVolleySingleton as VolleySingleton
            }
    }

}