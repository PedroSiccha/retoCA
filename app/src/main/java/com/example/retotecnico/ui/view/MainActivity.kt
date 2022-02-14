package com.example.retotecnico.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retotecnico.data.model.NoticiasModel
import com.example.retotecnico.databinding.ActivityMainBinding
import com.example.retotecnico.ui.adapter.NoticiaAdapter
import com.example.retotecnico.ui.viewmodel.NoticiaViewModel
import com.example.retotecnico.util.Resource

class MainActivity : AppCompatActivity(), NoticiaAdapter.OnNoticiasItemClicked {

    private lateinit var binding:ActivityMainBinding

    private val noticiaViewModel: NoticiaViewModel by viewModels()

    private var items: MutableList<NoticiasModel> = mutableListOf()

    private lateinit var adapter: NoticiaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        noticiaViewModel.onCreate()

        adapter = NoticiaAdapter(this, this)
        binding.noticiasRv.layoutManager = LinearLayoutManager(this)
        binding.noticiasRv.itemAnimator = DefaultItemAnimator()
        binding.noticiasRv.adapter = adapter
        adapter.submitList(items)



        noticiaViewModel.noticiaModel.observe(this, Observer { response ->

                    response.let {
                        noticiasResponse->
                        items = noticiasResponse?.hits!!.toMutableList()
                        adapter.submitList(items)

                        //observeNoticias()
                    }




        })

        binding.viewContainer.setOnClickListener { noticiaViewModel.randomNoticia() }

        noticiaViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })
    }

    override fun onItemClick(position: Int, noticias: MutableList<NoticiasModel>) {

    }
}