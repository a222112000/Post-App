package com.example.apiapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apiapp.R
import com.example.apiapp.model.Chapter
import com.example.apiapp.model.ChaptersItem

class ChapterAdapter(private var chapterList: List<Chapter>, private val context: Context): RecyclerView.Adapter<ChapterAdapter.MyviewHolder>() {

    class MyviewHolder(var itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.title)
        var user_id: TextView = itemView.findViewById(R.id.user_id)
        var poset_id: TextView = itemView.findViewById(R.id.id_post)
        var body: TextView = itemView.findViewById(R.id.body)
    }
    fun setAdapterData(items:List<Chapter>){
        chapterList = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_chapter,parent,false)
        return MyviewHolder(view)
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        holder.title.text = chapterList[position].title
        holder.user_id.text = chapterList[position].userId.toString()
        holder.poset_id.text = chapterList[position].id.toString()
        holder.body.text = chapterList[position].body
    }

    override fun getItemCount(): Int {
        return chapterList.size
    }

}