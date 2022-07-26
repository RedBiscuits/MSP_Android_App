package com.example.msp_app.ui.home

import android.content.Context
import android.util.Log
import android.widget.ArrayAdapter
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.msp_app.R
import com.etsy.android.grid.util.DynamicHeightImageView
import com.bumptech.glide.Glide
import android.util.SparseArray
import android.view.View
import java.util.*

class StaggeredAdapter(
    context: Context?, textViewResourceId: Int,
    objects: ArrayList<String>
) : ArrayAdapter<String?>(
    context!!, textViewResourceId, objects as List<String?>
) {
    private val mLayoutInflater: LayoutInflater
    private val mRandom: Random
    override fun getView(
        position: Int, convertView: View?,
        parent: ViewGroup
    ): View {
        var convertView = convertView
        val vh: ViewHolder
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(
                R.layout.staggered_recycler_row,
                parent, false
            )
            vh = ViewHolder()
            vh.imgView = convertView
                .findViewById(R.id.imgView)
            convertView.tag = vh
        } else {
            vh = convertView.tag as ViewHolder
        }
        val positionHeight = getPositionRatio(position)
        vh.imgView!!.heightRatio = positionHeight
        Glide.with(context)
            .load(getItem(position))
            .into(
                vh.imgView!!
            )
        return convertView!!
    }

    internal class ViewHolder {
        var imgView: DynamicHeightImageView? = null
    }

    private fun getPositionRatio(position: Int): Double {
        var ratio = sPositionHeightRatios[position, 0.0]
        if (ratio == 0.0) {
            ratio = randomHeightRatio
            sPositionHeightRatios.append(position, ratio)
            Log.d(TAG, "getPositionRatio:$position ratio:$ratio")
        }
        return ratio
    }


    private val randomHeightRatio: Double
        get() = mRandom.nextDouble() / 2.0 + 1.0

    companion object {
        private const val TAG = "SampleAdapter"
        private val sPositionHeightRatios = SparseArray<Double>()
    }

    init {
        mLayoutInflater = LayoutInflater.from(context)
        mRandom = Random()
    }
}