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
                "227.9",
                "3.721"

        )
        )
        planetList.add(
            Planets(
                "მთვარე",
                R.drawable.moon,
                "150.0",
                "1.62"

            )
        )
        planetList.add(
            Planets(
                "ნეპტუნი",
                R.drawable.neptune,
                "4497.1",
                "11.15"
            )
        )
        planetList.add(
            Planets(
                "დედამიწა",
                R.drawable.earth,
                "149.6",
                "9.807"

            )
        )
        planetList.add(
            Planets(
                "ვენერა",
                R.drawable.venus,
                "108.2",
                "8.87",

            )
        )
        planetList.add(
            Planets(
                "ურანი",
                R.drawable.uranus,
                "2871.0",
                "8.87"

            )
        )
        planetList.add(
            Planets(
                "მზე",
                R.drawable.sun,
                "0",
                "274.0"

            )
        )
        planetList.add(
            Planets(
                "სატურნი",
                R.drawable.saturn,
                "1427.0",
                "10.44"

            )
        )
        planetList.add(
            Planets(
                "იუპიტერი",
                R.drawable.jupiter,
                "778.3",
                "24.79"

            )
        )
        planetList.add(
            Planets(
                "მერკური",
                R.drawable.mercury,
                "57.9",
                "3.7",
            )
        )
        return planetList


    }


}