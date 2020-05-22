package com.example.covid19app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_deceased.*

class DeceasedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deceased)

        val url: String = "https://disease.sh/v2/countries?sort=deaths"

        val infectedList = ArrayList<InfectedModel>()

        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET, url, null,
            Response.Listener {

                progressBar.visibility = View.GONE

                for (i in 0 until it.length() step 1) {

                    val objet = it.getJSONObject(i)

                    var countryInfo = objet.getJSONObject("countryInfo")

                    val infectedModel = InfectedModel(
                        countryInfo.getString("flag"),
                        objet.getString("country"),
                        objet.getString("deaths")
                    )

                    infectedList.add(infectedModel)

                }

                val infectedAdapter = InfectedAdapter(this@DeceasedActivity, infectedList)

                recycler_view.adapter = infectedAdapter

            },
            Response.ErrorListener {
                progressBar.visibility = View.GONE
                Toast.makeText(this@DeceasedActivity, "Something went wrong", Toast.LENGTH_LONG)
                    .show()
            }
        )

        val requestQueue = Volley.newRequestQueue(this@DeceasedActivity)
        requestQueue.add(jsonArrayRequest)
    }
}
