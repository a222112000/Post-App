package com.example.apiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apiapp.model.Chapter
import com.example.apiapp.model.ChaptersItem
import com.example.apiapp.ui.ChapterAdapter
import com.example.apiapp.ui.ChaptersViewModel
import com.example.apiapp.ui.MainStateEvent
import com.example.apiapp.util.DataState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<ChaptersViewModel>()
    private lateinit var progressBar: ProgressBar
    private lateinit var chapterList: ArrayList<Chapter>
    private lateinit var recyclerView: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapters: ChapterAdapter
    private lateinit var txt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler)
        chapterList = ArrayList()
        txt = findViewById(R.id.txt)
        progressBar = findViewById(R.id.progress_bar)
        adapters = ChapterAdapter(chapterList,this)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = adapters
            hasFixedSize()
        }
        suscribeOb()
        viewModel.setStateEvent(MainStateEvent.GetChapters)
    }

    private fun suscribeOb(){

        viewModel.dataState.observe(this, Observer {
            when(it){
                is DataState.Success<List<Chapter>> -> {
                    displayprogressbar(false)
                    appendChapaters(it.data)
                }
                is DataState.Error -> {
                    displayprogressbar(false)
                    tosatMessage(it.exception.message.toString())
                }
                is DataState.Loading -> {
                    displayprogressbar(true)
                }
            }
        })
    }

    private fun tosatMessage(message: String){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }
    private fun displayprogressbar(isVisible: Boolean){
        progressBar.visibility = if(isVisible) View.VISIBLE else View.GONE
    }
    private fun appendChapaters(chapters: List<Chapter>){
        chapterList.addAll(chapters)
        adapters = ChapterAdapter(chapters,this)
        recyclerView.adapter = adapters
        adapters.setAdapterData(chapters)
    }
}