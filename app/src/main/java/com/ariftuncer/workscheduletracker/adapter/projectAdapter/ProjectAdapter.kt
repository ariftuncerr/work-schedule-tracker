package com.ariftuncer.workscheduletracker.adapter.projectAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ariftuncer.workscheduletracker.R

class ProjectAdapter (val context: Context, val projectList : List<String>) : RecyclerView.Adapter<ProjectAdapter.ProjectCardHolder>(){


    class ProjectCardHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val projectName = itemView.findViewById<TextView>(R.id.cardProjectTxt)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProjectCardHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.project_card_layout,parent,false)

        return ProjectCardHolder(view)
    }

    override fun onBindViewHolder(
        holder: ProjectCardHolder,
        position: Int
    ) {
        holder.projectName.text = projectList[position].toString()
    }

    override fun getItemCount(): Int {
        return projectList.size
    }



}