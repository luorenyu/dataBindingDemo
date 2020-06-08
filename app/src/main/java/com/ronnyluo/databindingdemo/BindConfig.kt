package com.ronnyluo.databindingdemo

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


/***************************************************
 * [ImageView]的绑定
 **************************************************/

@BindingAdapter("app:isSelected")
fun setSelected(view: View, isSelected: Boolean) {
    view.isSelected = isSelected
}


/***************************************************
 * [ImageView]的绑定
 **************************************************/
//1、加载圆形图片
@BindingAdapter("loadCircle")
fun loadCircle(view: ImageView, url: String?) {
    url?.let {
        Glide.with(view).load(url).apply(RequestOptions().circleCrop()).into(view)
    }
}

//2、正常加载图片
@BindingAdapter("loadImage")
fun loadImage(view: ImageView, url: String?) {
    url?.let {
        Glide.with(view).load(url).into(view)
    }
}


/***************************************************
 * [SwipeRefreshLayout.isRefreshing] 属性的双向绑定
 **************************************************/
@BindingAdapter("app:bind_swipeRefreshLayout_refreshing")
fun setSwipeRefreshLayoutRefreshing(
    swipeRefreshLayout: SwipeRefreshLayout,
    newValue: Boolean
) {
    if (swipeRefreshLayout.isRefreshing != newValue)
        swipeRefreshLayout.isRefreshing = newValue
}

@InverseBindingAdapter(
    attribute = "app:bind_swipeRefreshLayout_refreshing",
    event = "app:bind_swipeRefreshLayout_refreshingAttrChanged"
)
fun isSwipeRefreshLayoutRefreshing(swipeRefreshLayout: SwipeRefreshLayout): Boolean =
    swipeRefreshLayout.isRefreshing

@BindingAdapter(
    "app:bind_swipeRefreshLayout_refreshingAttrChanged",
    requireAll = false
)
fun setOnRefreshListener(
    swipeRefreshLayout: SwipeRefreshLayout,
    bindingListener: InverseBindingListener?
) {
    if (bindingListener != null)
        swipeRefreshLayout.setOnRefreshListener {
            bindingListener.onChange()
        }
}


