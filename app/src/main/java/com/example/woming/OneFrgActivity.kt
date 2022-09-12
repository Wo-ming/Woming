package com.example.woming

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.woming.databinding.ActivityMainBinding
import com.example.woming.databinding.OnefrgActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class OneFrgActivity:AppCompatActivity() {
    val binding by lazy{OnefrgActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val list=listOf(OneFrgA(),OneFrgB(),OneFrgC(),OneFrgD(),OneFrgE(),OneFrgF())
        val pagerAdapter=FragmentPagerAdapter(list,this)

        binding.viewPager.adapter=pagerAdapter
        val titles=listOf("A","B","C","D","E","F")
        TabLayoutMediator(binding.tabLayout,binding.viewPager){tab, position->
            tab.text=titles.get(position)
        }.attach()

    }
}

class FragmentPagerAdapter(val fragmentList: List<Fragment>, fragmentActivity:FragmentActivity)
    :FragmentStateAdapter(fragmentActivity){
    override fun getItemCount()=fragmentList.size
    override fun createFragment(position: Int)=fragmentList.get(position)
    }
