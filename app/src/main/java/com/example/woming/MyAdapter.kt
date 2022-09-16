package com.example.woming

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.woming.databinding.ActivityMainBinding
import com.example.woming.databinding.ItemMessageBinding
import com.example.woming.databinding.LeftChatBinding
import com.example.woming.databinding.RightChatBinding

class MyAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var listData= mutableListOf<Member>()
    val LEFT_TALK=1
    val RIGHT_TALK=0
    private lateinit var leftChatBinding: LeftChatBinding
    private lateinit var rightChatBinding: RightChatBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder { //어떤 목록 레이아웃을 만들 것인지
        return when (viewType){ //내 채팅
            RIGHT_TALK->{
                val binding = RightChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return RightViewHolder(binding)}
            LEFT_TALK->{ //우밍 채팅
                val binding = LeftChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return LeftViewHolder(binding)

            }
            else->{
                throw  RuntimeException("알 수 없는 viewtype error")
            }

        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) { //생성된 뷰에 무슨 데이터를 넣을 것인지
        if(holder is RightViewHolder){
            holder.binding.txtRightchat.text=listData[position].talk
        }
        else if (holder is LeftViewHolder){
            holder.binding.txtLeftchat.text=listData[position].talk
        }

    }

    override fun getItemViewType(position: Int): Int {
        return if(listData[position].num==0) RIGHT_TALK
        else LEFT_TALK
    }

    inner class RightViewHolder(val binding: RightChatBinding)
        :RecyclerView.ViewHolder(binding.root){}

    inner class LeftViewHolder(val binding: LeftChatBinding)
        :RecyclerView.ViewHolder(binding.root){

    }

    fun addItem(member:Member){
        listData.add(member)
    }

    override fun getItemCount(): Int {
        return listData.size
    }


}
