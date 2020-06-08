package com.ronnyluo.databindingdemo.viewmodel

import android.view.View
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import com.ronnyluo.databindingdemo.BindApp

import com.ronnyluo.databindingdemo.model.UserModel

/**
 * @desc : 用户Item的业务逻辑层
 * @author : ronnyLuo
 * @date : 2020/6/7  11:19 PM
 */
class UserItemViewModel : AndroidViewModel(BindApp.context) {

    fun clickItem(user: UserModel) {
        Toast.makeText(BindApp.context, "查看用户${user.name}的详情", Toast.LENGTH_SHORT).show()
    }

    fun onLike(v: View, user: UserModel) {
        if (user.isPraise) {
            user.praise = (user.praise.dec())
        } else {
            user.praise = (user.praise.inc())
        }
        user.isPraise = !user.isPraise

    }

}