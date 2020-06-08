package com.ronnyluo.databindingdemo.viewmodel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ronnyluo.databindingdemo.BindApp
import com.ronnyluo.databindingdemo.model.UserModel

class UserListViewModel : AndroidViewModel(BindApp.context) {
    val userList: MutableLiveData<MutableList<UserModel>> = MutableLiveData()
    val userItemViewModel = UserItemViewModel()

    //    val isRefreshing = MutableLiveData<Boolean>().apply { value = false }
    val isRefreshing: MutableLiveData<Boolean> = MutableLiveData()

    init {
        userList.value = mutableListOf()
//        userItemViewModel.setOnLikeClickListener(View.OnClickListener {
//        })
    }


    fun getUserList() {
        val mutableListOf = mutableListOf<UserModel>()
        for (i in 1..30) {
            mutableListOf.add(UserModel().apply {
                name = "Ronny$i"
                avatar = "http://img0.imgtn.bdimg.com/it/u=1388647394,240988450&fm=11&gp=0.jpg"
            })
        }
        userList.value = mutableListOf
        isRefreshing.value = false
    }
}