package com.example.woming

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.woming.databinding.ThreefrgActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class ThreeFrgActivity:AppCompatActivity() {
    val binding by lazy{ ThreefrgActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //뒤로가기버튼
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val list=listOf(ThreeFrgA(), ThreeFrgB())
        val pagerAdapter_Three= FragmentPagerAdapter(list,this)

        binding.viewPager3.adapter=pagerAdapter_Three
        val titles=listOf("행사","교육")
        TabLayoutMediator(binding.tabLayout3,binding.viewPager3){tab, position->
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

class FragmentPagerAdapter_Three(val fragmentList: List<Fragment>, fragmentActivity:FragmentActivity)
    :FragmentStateAdapter(fragmentActivity){
    override fun getItemCount()=fragmentList.size
    override fun createFragment(position: Int)=fragmentList.get(position)
    }
