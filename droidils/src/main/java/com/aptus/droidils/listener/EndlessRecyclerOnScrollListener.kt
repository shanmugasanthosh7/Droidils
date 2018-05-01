package com.aptus.droidils.listener

import android.support.v7.widget.RecyclerView


abstract class EndlessRecyclerOnScrollListener : RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        if (!recyclerView?.canScrollVertically(1)!!) {
            onLoadMore()
        }
    }

    abstract fun onLoadMore()
}