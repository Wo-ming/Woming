package com.example.woming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.example.woming.Server.Message
import com.example.woming.Server.MsgService
import com.example.woming.databinding.ActivityMainBinding
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private lateinit var binding: ActivityMainBinding;
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btn_msg = binding.btnSend
        var txt_msg = binding.editTxt

        var retrofit = Retrofit.Builder().baseUrl("http://192.168.137.1:8000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var msgservice = retrofit.create(MsgService::class.java)

        btn_msg.setOnClickListener {
            var message = txt_msg.text.toString()

            msgservice.requestMsg(message).enqueue(object : Callback<Message> {
                override fun onResponse(
                    call: retrofit2.Call<Message>,
                    response: Response<Message>
                ) {
                    var msgg = response.body()
                    var dialog = AlertDialog.Builder(this@MainActivity)
                    dialog.setTitle("성공").setMessage(msgg?.msgg).show()
                }

                override fun onFailure(call: retrofit2.Call<Message>, t: Throwable) {
                    t.message?.let { it1 -> Log.d("DEBUG", it1) }
                    var dialog = AlertDialog.Builder(this@MainActivity)
                    dialog.setTitle("실패!").show()
                }


            })
        }
    }
}