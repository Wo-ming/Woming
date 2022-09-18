package com.example.woming

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.woming.databinding.OnefrgActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator


class OneFrgActivity: AppCompatActivity() {

    val binding by lazy{ OnefrgActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        //뒤로가기버튼
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val list=listOf(OneFrgA(), OneFrgB(), OneFrgC(), OneFrgD(), OneFrgE(), OneFrgF())
        val pagerAdapter= FragmentPagerAdapter(list,this)

        binding.viewPager1.adapter=pagerAdapter
        val titles=listOf("사무·회계·IT","영업·상담·서비스직","유통·운전","요양·보건·의료","방송미디어","미용·여행·음식·청소")
        TabLayoutMediator(binding.tabLayout1,binding.viewPager1){tab, position->
            tab.text=titles.get(position)
        }.attach()

    }

    //뒤로가기동작
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}

class FragmentPagerAdapter(val fragmentList: List<Fragment>, fragmentActivity: FragmentActivity)
    : FragmentStateAdapter(fragmentActivity){
    override fun getItemCount()=fragmentList.size
    override fun createFragment(position: Int)=fragmentList.get(position)
    }
