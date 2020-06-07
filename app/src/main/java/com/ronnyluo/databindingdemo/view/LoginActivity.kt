package com.ronnyluo.databindingdemo.view

import android.content.Intent
import androidx.lifecycle.Observer
import com.ronnyluo.databindingdemo.R
import com.ronnyluo.databindingdemo.base.BaseActivity
import com.ronnyluo.databindingdemo.databinding.ActivityLoginBinding
import com.ronnyluo.databindingdemo.model.UserModel
import com.ronnyluo.databindingdemo.viewmodel.LoginViewModel

/**
 * @desc : 登陆页面
 * @author : ronnyLuo
 * @date : 2020/6/6  10:29 AM
 */
class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {
    override fun viewModelClazz(): Class<LoginViewModel> = LoginViewModel::class.java

    override fun layoutId(): Int =
        R.layout.activity_login

    override fun initView() {
        mBinding.viewModel = mViewModel
        mViewModel.user.value = UserModel().apply {
            name = "jack"
            password = "123456"
            avatar="http://up.enterdesk.com/edpic/1b/93/f6/1b93f66f09f63a619f7f9f4146dedf84.jpg"
        }
    }

    override fun initData() {
        mViewModel.loginResult.observe(this, Observer {
            if (it) {
                startActivity(Intent(this, UserListActivity::class.java))
            }
        })
    }
}