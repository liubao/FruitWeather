package com.liubao.fruitweather.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.liubao.fruitweather.R
import com.liubao.fruitweather.model.Daily
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    val homeViewModel by viewModel<HomeViewModel>()
    val adapter by lazy {
        WAdapter(requireActivity(), ArrayList<Daily>())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
        }
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            it.daily?.let {
                adapter.items = it
            }
            adapter.notifyDataSetChanged()
        })
        homeViewModel.apply {
            refreshing.observe(viewLifecycleOwner, Observer {
                swipeRefreshLayout.isRefreshing = it
            })
        }
        swipeRefreshLayout.apply {
            setOnRefreshListener { refresh() }
        }
        refresh()
    }

    private fun refresh() {
        homeViewModel.refresh()
    }
}