package com.example.retotecnico.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.*
import com.example.retotecnico.R
import com.example.retotecnico.data.model.NoticiasModel
import kotlinx.android.synthetic.main.noticias_item.view.*

class NoticiaAdapter(private val context: Context, private val onNoticiasItemClicked: OnNoticiasItemClicked): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var noticias: MutableList<NoticiasModel> = mutableListOf()

    inner class NoticiaDiffCallBack(
        val oldNoticiaList: List<NoticiasModel>,
        val newNoticiaList: List<NoticiasModel>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldNoticiaList.size
        }

        override fun getNewListSize(): Int {
            return newNoticiaList.size
        }


        override fun areItemsTheSame(oldNoticiasPosition: Int, newNoticiasPosition: Int): Boolean {
            return oldNoticiaList[oldNoticiasPosition].story_id == newNoticiaList[newNoticiasPosition].story_id
        }

        override fun areContentsTheSame(oldNoticiasPosition: Int, newNoticiasPosition: Int): Boolean {
            return oldNoticiaList[oldNoticiasPosition] == newNoticiaList[newNoticiasPosition]
        }

        override fun getChangePayload(oldNoticiasPosition: Int, newNoticiasPosition: Int): Any? {
            return super.getChangePayload(oldNoticiasPosition, newNoticiasPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NoticiasViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.noticias_item, parent, false)
        )
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = noticias[position]
        Log.d("TAG", "onBindViewHolder: $item")

        holder.itemView.tvAutor.setText(item.author)
        holder.itemView.tvFecha.setText(item.created_at)


        holder.itemView.setOnClickListener { onNoticiasItemClicked.onItemClick(noticias[position]) }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return noticias.size
    }

    fun submitList(list: List<NoticiasModel>) {
        val diffCallBack = NoticiaDiffCallBack(noticias, list)
        val diffResult = DiffUtil.calculateDiff(diffCallBack)

        noticias.clear()
        noticias.addAll(list)
        diffResult.dispatchUpdatesTo(this)
        /*
        this.notifyDataSetChanged()
        this.notifyItemRemoved(0)
        this.notifyItemRangeChanged(0, itemCount)

         */



    }

    /*
    fun updateAdapterView(noticiaList: MutableList<NoticiasModel>) {
        this.noticiaList = noticiaList
    }
     */



    class NoticiasViewHolder(view: View) : RecyclerView.ViewHolder(view)

    interface OnNoticiasItemClicked {
        fun onItemClick(noticias: NoticiasModel)
    }




}