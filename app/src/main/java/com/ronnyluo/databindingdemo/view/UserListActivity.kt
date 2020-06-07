package com.ronnyluo.databindingdemo.view

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ronnyluo.databindingdemo.R
import com.ronnyluo.databindingdemo.adapter.UserListAdapter
import com.ronnyluo.databindingdemo.base.BaseActivity
import com.ronnyluo.databindingdemo.databinding.ActivityUserListBinding
import com.ronnyluo.databindingdemo.viewmodel.UserListViewModel

/**
 * @desc : 用户列表页
 * @author : ronnyLuo
 * @date : 2020/6/7  10:44 PM
 */
class UserListActivity : BaseActivity<ActivityUserListBinding, UserListViewModel>() {

    override fun viewModelClazz(): Class<UserListViewModel> = UserListViewModel::class.java

    override fun layoutId(): Int = R.layout.activity_user_list

    override fun initView() {
        //初始化RecyclerView
        with(mBinding.recyclerView) {
            layoutManager = LinearLayoutManager(this@UserListActivity)
            adapter = UserListAdapter(mViewModel.userItemViewModel)
        }
    }

    override fun initData() {
        //观察UserList数据
        mViewModel.userList.observe(this, Observer {
            (mBinding.recyclerView.adapter as UserListAdapter).submitList(it)
        })
        //获取数据
        mViewModel.getUserList()
    }
}