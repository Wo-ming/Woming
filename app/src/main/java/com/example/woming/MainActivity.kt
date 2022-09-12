package com.example.woming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.woming.Server.Message
import com.example.woming.Server.MsgService
import com.example.woming.databinding.ActivityMainBinding
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;
    private val data:MutableList<Member> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var txt_msg = binding.editTxt
        val img_send = binding.imgSend

    //    var retrofit = Retrofit.Builder().baseUrl("IP주소")
     //       .addConverterFactory(GsonConverterFactory.create())
     //       .build()

     //   var msgservice = retrofit.create(MsgService::class.java)

        initialize() //초기화
        refreshRecyclerView()


        img_send.setOnClickListener {
            var message = txt_msg.text.toString()

            data.add(Member(message))
            refreshRecyclerView()
            txt_msg.setText("") //입력창 공백


        }
    }
    private fun initialize() { //recycleview 초기화

    }

    private fun refreshRecyclerView(){
        val adapter=MyAdapter()
        adapter.listData=data
        binding.recyclerView.adapter=adapter
        binding.recyclerView.layoutManager=LinearLayoutManager(this)
    }

    }




