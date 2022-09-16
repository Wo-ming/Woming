package com.example.woming

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.woming.databinding.TwofrgActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class TwoFrgActivity:AppCompatActivity() {
    val binding by lazy{TwofrgActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //뒤로가기버튼
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val list=listOf(TwoFrgA(), TwoFrgB(), TwoFrgC(), TwoFrgD(), TwoFrgE(), TwoFrgF(),
        TwoFrgG(),TwoFrgH(),TwoFrgI(),TwoFrgJ())
        val pagerAdapter_Two= FragmentPagerAdapter(list,this)

        binding.viewPager2.adapter=pagerAdapter_Two
        val titles=listOf("경영·회계·사무","금융·보혐·부동산","정보기술","디자인","이용·미용","사회","요양·보건","언어","음식·서비스","기타")
        TabLayoutMediator(binding.tabLayout2,binding.viewPager2){tab, position->
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

class FragmentPagerAdapter_Two(val fragmentList: List<Fragment>, fragmentActivity:FragmentActivity)
    :FragmentStateAdapter(fragmentActivity){
    override fun getItemCount()=fragmentList.size
    override fun createFragment(position: Int)=fragmentList.get(position)
    }
