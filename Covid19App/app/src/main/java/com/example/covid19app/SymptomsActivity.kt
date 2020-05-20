package com.example.covid19app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_symptoms.*

class SymptomsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_symptoms)

        recycler_view.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val symptomsList = ArrayList<SymptomsModel>()

        // cough
        symptomsList.add(
            SymptomsModel(
                R.drawable.ic_launcher_foreground,
                "Dry Cough",
                "There are many variations of passages of Lorem Ipsum available"
            )
        )
        // fever
        symptomsList.add(
            SymptomsModel(
                R.drawable.ic_launcher_foreground,
                "Fever",
                "There are many variations of passages of Lorem Ipsum available"
            )
        )
        // pain
        symptomsList.add(
            SymptomsModel(
                R.drawable.ic_launcher_foreground,
                "Pain",
                "There are many variations of passages of Lorem Ipsum available"
            )
        )
        // sore throat
        symptomsList.add(
            SymptomsModel(
                R.drawable.ic_launcher_foreground,
                "Sore Throat",
                "There are many variations of passages of Lorem Ipsum available"
            )
        )

        val symptomsAdapter = SymptomsAdapter(symptomsList)

        recycler_view.adapter = symptomsAdapter
    }
}
