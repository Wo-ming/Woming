package com.example.woming

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
//import com.example.woming.OneFrg.OneFrgActivity
import com.example.woming.databinding.ActivityMenuBinding

class MenuActivity: AppCompatActivity() {
    val binding by lazy{ActivityMenuBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //뒤로가기 버튼생성
       supportActionBar?.setDisplayHomeAsUpEnabled(true)


        //업종소개가기
        binding.btn1.setOnClickListener {
            startActivity(Intent(this@MenuActivity, OneFrgActivity::class.java))
        }
        //자격증가기
        binding.btn2.setOnClickListener {
            startActivity(Intent(this@MenuActivity, TwoFrgActivity::class.java))
        }
        //행사교육가기
        binding.btn3.setOnClickListener {
            startActivity(Intent(this@MenuActivity, ThreeFrgActivity::class.java))
        }
        //행사교육가기
        binding.btn4.setOnClickListener {
            startActivity(Intent(this@MenuActivity, FourFrgActivity::class.java))
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