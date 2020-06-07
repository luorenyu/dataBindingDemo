package com.ronnyluo.databindingdemo.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ronnyluo.databindingdemo.BR


/**
 * @desc : DataBinding的基类Adapter，对应的xml视图中需要顶一个item作为<T>数据的变量名
 * @author : ronnyLuo
 * @date : 2020/4/2  1:44 PM
 */
abstract class DataBindingAdapter<T : DataCompare<T>,B:ViewDataBinding> :
    ListAdapter<T, DataBindingAdapter.DataBindingViewHolder<T,B>>(DiffCallback<T>()) {

    class DiffCallback<M : DataCompare<M>> : DiffUtil.ItemCallback<M>() {
        override fun areItemsTheSame(oldItem: M, newItem: M): Boolean {
            return oldItem.areContentsTheSame(newItem)
        }

        override fun areContentsTheSame(oldItem: M, newItem: M): Boolean {
            return oldItem.areItemsTheSame(newItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewHolder<T,B> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, viewType, parent, false)
        return DataBindingViewHolder(binding as B)
    }

    override fun onBindViewHolder(holder: DataBindingViewHolder<T,B>, position: Int) {
        holder.binding.root.tag = position
        getItem(position).bind(holder.binding, position)
        holder.bind(getItem(position))
    }

    open fun T.bind(binding: B, position: Int) {}

    class DataBindingViewHolder<T,B:ViewDataBinding>(val binding: B) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: T) {
            binding.setVariable(BR.item, item)
            binding.executePendingBindings()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getItemViewId(position)
    }

    abstract fun getItemViewId(position: Int): Int
}