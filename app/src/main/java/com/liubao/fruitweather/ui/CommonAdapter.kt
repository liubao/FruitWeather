package com.liubao.fruitweather.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView


abstract class CommonAdapter<DB : ViewDataBinding, T>(
    val context: Context,
    var dataList: List<T>
) :
    RecyclerView.Adapter<CommonAdapter<DB, T>.CommonViewHolder<DB>>() {

    // 抽象函数  获取布局资源id
    abstract val layoutId: Int

    // 抽象函数  通过databinding为布局设置数据
    abstract fun bindView(viewHolder: CommonViewHolder<DB>?, position: Int)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonViewHolder<DB> {
        // 生成DB对象 (这个方法是不是和View.inflate()很像？)
        val bindView: DB =
            DataBindingUtil.inflate(LayoutInflater.from(context), layoutId, parent, false)
        return CommonViewHolder(bindView)
    }

    override fun onBindViewHolder(
        holder: CommonAdapter<DB, T>.CommonViewHolder<DB>,
        position: Int
    ) {
        bindView(holder as CommonViewHolder<DB>?, position)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    inner class CommonViewHolder<DB : ViewDataBinding>// 每一个item都必须持有的一个ViewDataBinding子类对象
        (var bindView: DB) :
        RecyclerView.ViewHolder(bindView!!.getRoot())

}