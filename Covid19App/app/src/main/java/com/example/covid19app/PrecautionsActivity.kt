package com.example.covid19app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_precautions.*

class PrecautionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_precautions)

        recycler_view.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val precautionsList = ArrayList<PrecautionsModel>()

        // soap
        precautionsList.add(
            PrecautionsModel(
                R.drawable.soap,
                "Hand Wash",
                "There are many variations of passages of Lorem Ipsum available"
            )
        )
        // home
        precautionsList.add(
            PrecautionsModel(
                R.drawable.home,
                "Stay Home",
                "There are many variations of passages of Lorem Ipsum available"
            )
        )
        // distance
        precautionsList.add(
            PrecautionsModel(
                R.drawable.distance,
                "Social Distance",
                "There are many variations of passages of Lorem Ipsum available"
            )
        )
        // clean
        precautionsList.add(
            PrecautionsModel(
                R.drawable.clean,
                "Clean Object & Surface",
                "There are many variations of passages of Lorem Ipsum available"
            )
        )
        // cover
        precautionsList.add(
            PrecautionsModel(
                R.drawable.cover,
                "Avoid Touching",
                "There are many variations of passages of Lorem Ipsum available"
            )
        )

        val precautionsAdapter = Precautions2Adapter(precautionsList)

        recycler_view.adapter = precautionsAdapter
    }
}
