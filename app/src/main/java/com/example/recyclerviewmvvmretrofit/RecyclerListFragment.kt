package com.example.recyclerviewmvvmretrofit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewmvvmretrofit.adapter.RecyclerViewAdapter
import com.example.recyclerviewmvvmretrofit.models.RecyclerList
import com.example.recyclerviewmvvmretrofit.viewmodel.MainActivityViewModel

class RecyclerListFragment : Fragment() {

    private lateinit var recyclerAdapter : RecyclerViewAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_recycler_list, container, false)
        initViewModel(view)
        initViewModel()
            return view
    }
    private fun initViewModel(view: View){
    val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val decoration = DividerItemDecoration(activity,DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(decoration)

        recyclerAdapter = RecyclerViewAdapter()
        recyclerView.adapter= recyclerAdapter
    }

    private fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getRecyclerList0bserver().observe(this, Observer <RecyclerList>{
            if (it !=null){
                recyclerAdapter.setUpdatedData(it.items)
            }else{
                Toast.makeText(activity,"Error in getting data", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeApiCall()
    }

    companion object {

        @JvmStatic
        fun newInstance() =
                RecyclerListFragment()
    }
}