package com.ariftuncer.workscheduletracker.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.collection.emptyLongSet
import androidx.recyclerview.widget.RecyclerView
import com.ariftuncer.workscheduletracker.R
import com.ariftuncer.workscheduletracker.view.operations.NewSalaryActivity

class OperationAdapter (val context: Context,val operationCardList: List<OperationCard>) : RecyclerView.Adapter<OperationAdapter.OperationCardHolder>(){
    class OperationCardHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val operationCard = itemView.findViewById<CardView>(R.id.operationsCard)
        val operationImage = itemView.findViewById<ImageView>(R.id.cardImageBtn)
        val operationText = itemView.findViewById<TextView>(R.id.operationText)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OperationCardHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.operations_card_layout,parent,false)
        return OperationCardHolder(view)
    }

    override fun onBindViewHolder(
        holder: OperationCardHolder,
        position: Int
    ) {
        holder.operationImage.setImageResource(operationCardList[position].cardImage)
        holder.operationText.text = operationCardList[position].cardText.toString()
        val currentCard : String =  operationCardList[position].cardName.toString()

        holder.operationImage.setOnClickListener { view ->
            val intent = when(currentCard){
                 "newSalary"-> Intent(context, NewSalaryActivity :: class.java)
                  else -> Intent(context, NewSalaryActivity :: class.java)
            }
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return operationCardList.size
    }



}