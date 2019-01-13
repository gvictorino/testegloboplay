package com.globoplay.gvictorino.testegloboplay.ui.main

import android.content.Context
import android.os.Build
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.globoplay.gvictorino.testegloboplay.ImageLoader
import com.globoplay.gvictorino.testegloboplay.R
import java.util.ArrayList

class ProgramAdapter(private val context: Context,
                     private val mListener: ProgramClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: MutableList<ProgramViewModel> = ArrayList()

    fun add(items: List<ProgramViewModel>) {
        this.items.addAll(items)
        notifyItemRangeInserted(this.items.size - items.size, items.size)
    }

    fun update(items: MutableList<ProgramViewModel>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ProgramViewHolder(LayoutInflater.from(context).inflate(R.layout.item_program, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val position = holder.adapterPosition
        val viewModel = items[position]
        val viewHolder = holder as ProgramViewHolder

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            holder.itemView.transitionName = holder.thumb.context.getString(R.string.transitionImage)
        }

        if (!viewModel.thumb.isEmpty())
            ImageLoader.loadFitCenter(
                context,
                viewModel.thumb,
                R.drawable.mosaic_pattern,
                viewHolder.thumb)
        else
            viewHolder.thumb.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.mosaic_pattern))

        val duration = viewModel.duration
        val favorites = viewModel.favorites

        viewHolder.programName.text = viewModel.programName
        viewHolder.duration.text = "$duration mins"
        viewHolder.favorites.text = "$favorites likes"

        viewHolder.clickableView.setOnClickListener {
            mListener.onClickProgram(
                position,
                holder.clickableView)
        }
    }

    override fun getItemCount(): Int {
          return items.size
    }
}