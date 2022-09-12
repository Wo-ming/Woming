package com.example.woming

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.woming.databinding.ActivityMainBinding
import com.example.woming.databinding.ItemMessageBinding
import com.example.woming.databinding.LeftChatBinding
import com.example.woming.databinding.RightChatBinding

class MyAdapter: RecyclerView.Adapter<MyAdapter.Holder>() {

    var listData= mutableListOf<Member>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder { //어떤 목록 레이아웃을 만들 것인지
        val binding = RightChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)

    }

    override fun onBindViewHolder(holder: Holder, position: Int) { //생성된 뷰에 무슨 데이터를 넣을 것인지
        val member=listData[position]
        holder.setData(member)
    }

    override fun getItemCount():Int{
        return listData.size
    }


}

class Holder(val binding:RightChatBinding):RecyclerView.ViewHolder(binding.root) {
    fun setData(member:Member){
        if (member.num==0){
            binding.txtRightchat.text=member.name
        }
        else {
            binding.txtLeftchat.text=member.name
        }
    }

}
