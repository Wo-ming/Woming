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
    private lateinit var binding: ActivityMainBinding
    lateinit var myAdapter: MyAdapter
    private val data:MutableList<Member> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var txt_msg = binding.editTxt
        val img_send = binding.imgSend

        var retrofit = Retrofit.Builder().baseUrl("http://192.168.137.1:8000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var msgservice = retrofit.create(MsgService::class.java)

        initialize() //초기화




        img_send.setOnClickListener {
            var message = txt_msg.text.toString()

            msgservice.requestMsg(message).enqueue(object : Callback<Message> {
                override fun onResponse(call: retrofit2.Call<Message>, response: Response<Message>) {
                    var msgg = response.body()
                    data.add(Member(1,msgg.toString()))
                    var dialog = AlertDialog.Builder(this@MainActivity)
                    dialog.setTitle("성공").setMessage(msgg?.msgg).show()
                }

                override fun onFailure(call: retrofit2.Call<Message>, t: Throwable) {
                    t.message?.let { it1 -> Log.d("DEBUG", it1) }
                    var dialog = AlertDialog.Builder(this@MainActivity)
                    dialog.setTitle("실패!").show()
                }
            })

            data.add(Member(0,message))
            txt_msg.setText("") //입력창 공백
        }
        refreshRecyclerView()
    }
    private fun initialize() { //recycleview 초기화
        data.add(Member(1,"우밍에게 무엇이든 물어보세요"))

    }

    private fun refreshRecyclerView(){
        val adapter=MyAdapter()
        adapter.listData=data
        binding.recyclerView.adapter=adapter
        binding.recyclerView.layoutManager=LinearLayoutManager(this)
    }

    }




