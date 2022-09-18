package com.example.woming

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.woming.R
import com.example.woming.databinding.FragmentOnefrgABinding
import kotlinx.android.synthetic.main.fragment_onefrg_a.*
import kotlinx.android.synthetic.main.onefrg_activity_main.*


class OneFrgA : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onefrg_a, container, false)
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        var list: ArrayList<TestData> = requireActivity().intent!!.extras!!.get("DataList") as ArrayList<TestData>
//        Log.e("FirstFragment", "Data List: ${list}")
//
//        // Fragment에서 전달받은 list를 넘기면서 ListAdapter 생성
//        listadapter = listAdapter(list)
//        listView.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
//        // RecyclerView.adapter에 지정
//        listView.adapter = listadapter
//    }
}

