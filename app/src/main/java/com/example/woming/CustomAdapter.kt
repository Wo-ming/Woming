package com.example.woming

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_recycler_event.view.*

class Data(val eventImage:Int, val eventName: String, val eventDate : String)

class CustomViewHoler(v:View):RecyclerView.ViewHolder(v){
    val image = v.eventImage
    val name = v.eventName
    val date = v.eventDate
}

class CustomAdapter(val DataList:ArrayList<Data>) : RecyclerView.Adapter<CustomViewHoler>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHoler {
        val cellForRow = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_event,
        parent, false)
        return CustomViewHoler(cellForRow)
    }

    override fun getItemCount(): Int = DataList.size

    override fun onBindViewHolder(holder: CustomViewHoler, position: Int) {
        val curData = DataList[position]
        holder.image.setImageResource(curData.eventImage)
        holder.name.text = curData.eventName
        holder.date.text = curData.eventDate
    }
}