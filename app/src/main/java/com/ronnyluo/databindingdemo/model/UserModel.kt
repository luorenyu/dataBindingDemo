package com.ronnyluo.databindingdemo.model

import android.os.Build
import android.os.SystemClock
import androidx.databinding.BaseObservable
import com.ronnyluo.databindingdemo.base.DataCompare

/**
 * @desc : 用户类
 * @author : ronnyLuo
 * @date : 2020/6/6  10:28 AM
 */
class UserModel : BaseObservable(), DataCompare<UserModel> {
    var id: Long = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
        SystemClock.elapsedRealtimeNanos()
    } else {
        System.currentTimeMillis()
    }
    var name: String = ""
    var password: String = ""
    var avatar: String = ""
    override fun areItemsTheSame(newItem: UserModel): Boolean {
        return this.id == newItem.id
    }

    override fun areContentsTheSame(newItem: UserModel): Boolean {
        return this == newItem
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is UserModel) return false

        if (id != other.id) return false
        if (name != other.name) return false
        if (password != other.password) return false
        if (avatar != other.avatar) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + password.hashCode()
        result = 31 * result + avatar.hashCode()
        return result
    }


}