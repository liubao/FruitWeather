package com.liubao.fruitweather.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<DATA, BINDING : ViewDataBinding>(
    open var context: Context,
    open var items: List<DATA> = ArrayList()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val db = DataBindingUtil.inflate<BINDING>(
            LayoutInflater.from(this.context), getLayoutId(), parent, false
        )
        return MViewHolder(db.root)
    }

    abstract fun getLayoutId(): Int

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        DataBindingUtil.getBinding<BINDING>(holder.itemView)?.apply {
            bindApply(this, items[position])
            executePendingBindings()
        }
    }

    abstract fun bindApply(binding: BINDING, data: DATA)
    inner class MViewHolder(v: View) : RecyclerView.ViewHolder(v)

}