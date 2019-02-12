package com.example.jetpack.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpack.databinding.FragmentQiitaListBinding
import com.example.jetpack.utils.Injector
import com.example.jetpack.viewModel.QiitaListViewModel

class QiitaListFragment : Fragment() {

    private lateinit var binding: FragmentQiitaListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentQiitaListBinding.inflate(inflater, container, false)
        binding.setLifecycleOwner(this)
        val factory = Injector.provideQiitaListViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(QiitaListViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.getList().observe(this, Observer { result ->
            if (result != null && result.isNotEmpty()) {
                binding.recycler.adapter = QiitaListItemAdapter(result)
            } else {
                Toast.makeText(context, "include null oe empty", Toast.LENGTH_SHORT).show()
            }
        })
        binding.recycler.layoutManager = LinearLayoutManager(context)
        binding.recycler.setHasFixedSize(true)
        return binding.root
    }
}