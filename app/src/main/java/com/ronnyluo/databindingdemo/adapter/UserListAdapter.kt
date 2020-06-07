package com.ronnyluo.databindingdemo.adapter

import com.ronnyluo.databindingdemo.R
import com.ronnyluo.databindingdemo.base.DataBindingAdapter
import com.ronnyluo.databindingdemo.databinding.ActivityItemUserListBinding
import com.ronnyluo.databindingdemo.model.UserModel
import com.ronnyluo.databindingdemo.viewmodel.UserItemViewModel

class UserListAdapter(private val userItemViewModel: UserItemViewModel) :
    DataBindingAdapter<UserModel, ActivityItemUserListBinding>() {
    override fun getItemViewId(position: Int): Int = R.layout.activity_item_user_list

    override fun UserModel.bind(binding: ActivityItemUserListBinding, position: Int) {
        binding.viewModel = userItemViewModel
    }
}