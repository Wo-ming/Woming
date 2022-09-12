package com.example.woming

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.woming.databinding.ActivityMainBinding
import com.example.woming.databinding.ActivityMenuBinding

class MenuActivity: AppCompatActivity() {
    val binding by lazy{ActivityMenuBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //뒤로가기 버튼생성
       supportActionBar?.setDisplayHomeAsUpEnabled(true)

//        btn1.setOnClickListener{
//            startActivity(Intent(this@MenuActivity,TabLayoutTest::class.java))
//        }

        binding.btn1.setOnClickListener {
            startActivity(Intent(this@MenuActivity, OneFrgActivity::class.java))
        }
    }
    //뒤로가기동작
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}