package com.ronnyluo.databindingdemo.viewmodel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ronnyluo.databindingdemo.BindApp
import com.ronnyluo.databindingdemo.model.UserModel

/**
 * @desc : 登陆的业务类
 * @author : ronnyLuo
 * @date : 2020/6/6  10:29 AM
 */
class LoginViewModel : ViewModel() {
    val user = MutableLiveData<UserModel>()
    val loginResult = MutableLiveData<Boolean>()

    fun login() {
        user.value?.let {
            if (it.name.isEmpty() || it.password.isEmpty()) {
                Toast.makeText(BindApp.context, "登陆账号或密码不能为空", Toast.LENGTH_SHORT).show()
                loginResult.value = false
            } else {
                Toast.makeText(BindApp.context, "登陆账号:${it.name}-密码：${it.password}", Toast.LENGTH_SHORT).show()
                loginResult.value = true
            }
        }
    }

}