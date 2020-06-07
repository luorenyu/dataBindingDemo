package com.ronnyluo.databindingdemo.base

interface DataCompare<D> {
     fun areItemsTheSame(newItem: D): Boolean
     fun areContentsTheSame(newItem: D): Boolean
}