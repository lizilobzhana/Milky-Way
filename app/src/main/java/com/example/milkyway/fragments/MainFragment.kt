package com.example.milkyway.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.milkyway.Planets
import com.example.milkyway.R
import com.example.milkyway.RecyclerViewAdapter

class MainFragment : Fragment(R.layout.fragment_main) {
    private lateinit var recyclerViewDayAdapter : RecyclerViewAdapter
    private lateinit var ma_recycler : RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ma_recycler = view.findViewById(R.id.ma_recycler)
        recyclerViewDayAdapter = RecyclerViewAdapter(getData())
        ma_recycler.layoutManager = LinearLayoutManager(activity)
        ma_recycler.adapter = recyclerViewDayAdapter

    }

    private fun getData(): List<Planets> {
        val planetList = ArrayList<Planets>()
        planetList.add(
            Planets(
                "მარსი",
                R.drawable.mars,
                "227.9 მლნ კმ",
                "3.721 მ/წ²"

        )
        )
        planetList.add(
            Planets(
                "მთვარე",
                R.drawable.moon,
                "150.0 მლნ კმ",
                "1.62 მ/წ²"

            )
        )
        planetList.add(
            Planets(
                "ნეპტუნი",
                R.drawable.neptune,
                "4497.1 მლნ კმ",
                "11.15 მ/წ²"
            )
        )
        planetList.add(
            Planets(
                "დედამიწა",
                R.drawable.earth,
                "149.6 მლნ კმ",
                "9.807 მ/წ²"

            )
        )
        planetList.add(
            Planets(
                "ვენერა",
                R.drawable.venus,
                "108.2 მლნ კმ",
                "8.87 მ/წ²",

            )
        )
        planetList.add(
            Planets(
                "ურანი",
                R.drawable.uranus,
                "2871.0 მლნ კმ",
                "8.87 მ/წ²"

            )
        )
        planetList.add(
            Planets(
                "მზე",
                R.drawable.sun,
                "0 მლნ კმ",
                "274.0 მ/წ²"

            )
        )
        planetList.add(
            Planets(
                "სატურნი",
                R.drawable.saturn,
                "1427.0 მლნ კმ",
                "10.44 მ/წ²"

            )
        )
        planetList.add(
            Planets(
                "იუპიტერი",
                R.drawable.jupiter,
                "778.3 მლნ კმ",
                "24.79 მ/წ²"

            )
        )
        planetList.add(
            Planets(
                "მერკური",
                R.drawable.mercury,
                "57.9 მლნ კმ",
                "3.7 მ/წ²",
            )
        )
        return planetList


    }


}