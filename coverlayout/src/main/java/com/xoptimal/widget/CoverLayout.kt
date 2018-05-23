package com.xoptimal.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout

/**
 * Created by Freddie on 2018/5/23 0023 .
 * Description:
 */
class CoverLayout : FrameLayout {

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    private var mOverlayIndex = -1

    fun setOverlayView(view: View) {
        if (mOverlayIndex == -1) {
            addView(view, layoutParams)
            mOverlayIndex = childCount - 1
        } else {
            removeViewAt(mOverlayIndex)
            mOverlayIndex = -1
            setOverlayView(view)
        }
    }

    private var covers: MutableList<Cover> = mutableListOf()

    fun setCovers(covers: List<Cover>) {
        this.covers.clear()
        this.covers.addAll(covers)
    }

    fun addCover(cover: Cover) {
        this.covers.add(cover)
    }

    fun setOverlayStatus(status: Int) {
        var item = covers.filter { it.status == status }
        if (item.isNotEmpty()) setOverlayView(item[0].view)
    }

}