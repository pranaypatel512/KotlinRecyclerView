package com.kotlinrecyclerview.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.kotlinrecyclerview.R
import com.kotlinrecyclerview.model.ItemModel

/**
 * Created by ln-023 on 19/9/17.
 */
class EmployeeAdapter(private val employeeList: ArrayList<ItemModel>, private val listener: (ItemModel) -> Unit) : RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): EmployeeViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.list_item_recyclerview,
                parent, false)
        return EmployeeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder?, position: Int) {
        holder?.bindValue(employeeList[position], listener,position)
    }


    class EmployeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindValue(itemModel: ItemModel, listener: (ItemModel) -> Unit,position: Int) {
            val textViewName = itemView.findViewById<TextView>(R.id.textViewListItem) as TextView
            val textViewOccs = itemView.findViewById<TextView>(R.id.textViewListItemOccu) as TextView
            val userimage=itemView.findViewById<ImageView>(R.id.imageViewListItem) as ImageView
            textViewName.text = itemModel.name
            textViewOccs.text = itemModel.occupation
            if(position%2==0)
            {
                userimage.setImageDrawable(ContextCompat.getDrawable(itemView.context,R.mipmap.ic_launcher_round))
            }else{
                userimage.setImageDrawable(ContextCompat.getDrawable(itemView.context,R.mipmap.ic_launcher))
            }
            itemView.setOnClickListener { listener(itemModel) }
        }

    }


}