package com.ronnyluo.databindingdemo.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * @desc : 简易封装的一个Mvvm的Activity base基类
 * @author : ronnyLuo
 * @date : 2020/6/6  10:28 AM
 */
abstract class BaseActivity<B : ViewDataBinding, VM : ViewModel> : AppCompatActivity() {

    lateinit var mBinding: B
    lateinit var mViewModel: VM
    abstract fun viewModelClazz(): Class<VM>

    @LayoutRes
    abstract fun layoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, layoutId())
        mBinding.lifecycleOwner = this
        mViewModel = ViewModelProvider.NewInstanceFactory().create(viewModelClazz())
        initView()
        initData()
    }
    abstract fun initView()
    abstract fun initData()

}