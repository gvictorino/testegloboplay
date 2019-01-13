package com.globoplay.gvictorino.testegloboplay.ui.main

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.globoplay.gvictorino.testegloboplay.R

class ProgramViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var thumb : ImageView = itemView.findViewById(R.id.thumb)
    var programName : TextView = itemView.findViewById(R.id.programName)
    var favorites  : TextView = itemView.findViewById(R.id.favorite)
    var duration: TextView = itemView.findViewById(R.id.duration)
    var clickableView : View = itemView.findViewById(R.id.clickableView)
}