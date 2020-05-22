package com.example.covid19app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

        val symptomsList = ArrayList<SymptomsModel>()

        // cough
        symptomsList.add(
            SymptomsModel(
                R.drawable.cough,
                "Dry Cough",
                "There are many variations of passages of Lorem Ipsum available"
            )
        )
        // fever
        symptomsList.add(
            SymptomsModel(
                R.drawable.fever,
                "Fever",
                "There are many variations of passages of Lorem Ipsum available"
            )
        )

        // nose
        symptomsList.add(
            SymptomsModel(
                R.drawable.nose,
                "Nose",
                "There are many variations of passages of Lorem Ipsum available"
            )
        )

        val symptomsAdapter = SymptomsAdapter(symptomsList)

        recycler_view.adapter = symptomsAdapter

        //

        recycler_view_precautions.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

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

        val precautionsAdapter = PrecautionsAdapter(precautionsList)

        recycler_view_precautions.adapter = precautionsAdapter

        //

        cardInfected.setOnClickListener{
            val intent = Intent(this@MainActivity, InfectedActivity::class.java)
            startActivity(intent)
        }

        cardRecovered.setOnClickListener{
            val intent = Intent(this@MainActivity, RecoveredActivity::class.java)
            startActivity(intent)
        }

        cardDeceased.setOnClickListener{
            val intent = Intent(this@MainActivity, DeceasedActivity::class.java)
            startActivity(intent)
        }

        btnKnowMore.setOnClickListener{
            val intent = Intent(this@MainActivity, KnowMoreActivity::class.java)
            startActivity(intent)
        }

        txtViewSymptoms.setOnClickListener{
            val intent = Intent(this@MainActivity, SymptomsActivity::class.java)
            startActivity(intent)
        }

        txtViewPrecautions.setOnClickListener{
            val intent = Intent(this@MainActivity, PrecautionsActivity::class.java)
            startActivity(intent)
        }

        getGlobalData()
    }

    fun getGlobalData() {

        val url: String = "https://corona.lmao.ninja/v2/all"

        val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener {

                var jsonObject = JSONObject(it.toString())

                // now set values in views
                txtInfected.text = jsonObject.getString("cases")
                txtRecovered.text = jsonObject.getString("recovered")
                txtDeceased.text = jsonObject.getString("deaths")
            },
            Response.ErrorListener {

                Toast.makeText(this@MainActivity, "Something went wrong", Toast.LENGTH_LONG).show()
                txtInfected.text = "-"
                txtRecovered.text = "-"
                txtDeceased.text = "-"
            }
        )

        val requestQueue = Volley.newRequestQueue(this@MainActivity)
        requestQueue.add(stringRequest)
    }

}
