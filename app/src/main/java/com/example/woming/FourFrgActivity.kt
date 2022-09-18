package com.example.woming

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.woming.databinding.FourfrgActivityMainBinding
import com.example.woming.databinding.TwofrgActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class FourFrgActivity:AppCompatActivity() {
    val binding by lazy{FourfrgActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //뒤로가기버튼
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val list=listOf(FourFrgA(), FourFrgB())
        val pagerAdapter_Four= FragmentPagerAdapter(list,this)

        binding.viewPager4.adapter=pagerAdapter_Four
        val titles=listOf("근로법","직장생활 Tip")
        TabLayoutMediator(binding.tabLayout4,binding.viewPager4){tab, position->
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

class FragmentPagerAdapter_Four(val fragmentList: List<Fragment>, fragmentActivity:FragmentActivity)
    :FragmentStateAdapter(fragmentActivity){
    override fun getItemCount()=fragmentList.size
    override fun createFragment(position: Int)=fragmentList.get(position)
    }
