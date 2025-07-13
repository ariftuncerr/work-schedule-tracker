package com.ariftuncer.workscheduletracker.adapter.companyAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ariftuncer.workscheduletracker.R
import com.ariftuncer.workscheduletracker.adapter.projectAdapter.ProjectAdapter
import com.ariftuncer.workscheduletracker.data.local.entity.CompanyEntity
import com.ariftuncer.workscheduletracker.data.local.entity.ProjectEntity

class CompanyAdapter (val context: Context, var companyList : List<CompanyEntity>?) : RecyclerView.Adapter<CompanyAdapter.CompanyCardHolder>() {

    class CompanyCardHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val expandBtn = itemView.findViewById<ImageButton>(R.id.expandBtn)
        val companyText = itemView.findViewById<TextView>(R.id.companyName)
        val expandableProjectList : ConstraintLayout = itemView.findViewById(R.id.expandableProjectListLayout)
        val projectRecyclerView : RecyclerView = itemView.findViewById(R.id.projectsRecyclerView)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CompanyCardHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.companies_card_layout,parent,false)
        return CompanyCardHolder(view)
    }

    override fun onBindViewHolder(
        holder: CompanyCardHolder,
        position: Int
    ) {
        holder.companyText.text = companyList?.get(position)?.name.toString()

        val projectList = listOf<String>("ABCDE","FGEH","KLMNO")
        val projectAdapter = ProjectAdapter(context,projectList)

        holder.projectRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        holder.projectRecyclerView.adapter = projectAdapter

        var isExpanded = when (holder.expandableProjectList.visibility){
            View.VISIBLE ->  true
            else -> false
        }

        holder.expandBtn.setOnClickListener {
            if (isExpanded) {
                holder.expandBtn.setImageResource(R.drawable.expand_24)
                holder.expandableProjectList.visibility = View.GONE
                isExpanded = false
            }
            else {
                holder.expandableProjectList.visibility = View.VISIBLE
                holder.expandBtn.setImageResource(R.drawable.narrow_24)
                isExpanded = true
            }

        }

    }

    override fun getItemCount(): Int {
        return companyList?.size ?: 0
    }
    fun updateList(newCompanyList : List<CompanyEntity>, newProjectList : List<ProjectEntity> = emptyList()){
        companyList = newCompanyList
        notifyDataSetChanged()

    }



}