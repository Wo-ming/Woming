package com.example.woming

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.woming.R
import kotlinx.android.synthetic.main.activity_main.*

class ThreeFrgA : Fragment() {
    val DataList = arrayListOf(
        Data(R.drawable.event_image1,"고용 평등과 성평등", "게시일자 : 2022-5-17"),
        Data(R.drawable.event_image1,"행사명2", "게시일자2"),
        Data(R.drawable.event_image1,"행사명3", "게시일자3"),
        Data(R.drawable.event_image1,"행사명4", "게시일자4"),
        Data(R.drawable.event_image1,"행사명5", "게시일자5"),
        Data(R.drawable.event_image1,"행사명6", "게시일자6"),
        Data(R.drawable.event_image1,"행사명7", "게시일자7"),
        Data(R.drawable.event_image1,"행사명8", "게시일자8"),
        Data(R.drawable.event_image1,"행사명9", "게시일자9"),
        Data(R.drawable.event_image1,"행사명10", "게시일자10"),
        Data(R.drawable.event_image1,"행사명11", "게시일자11"),
        Data(R.drawable.event_image1,"행사명12", "게시일자12"),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = CustomAdapter(DataList)

        return inflater.inflate(R.layout.fragment_threefrg_a, container, false)

    }


}