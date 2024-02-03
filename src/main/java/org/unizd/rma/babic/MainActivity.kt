package org.unizd.rma.babic

import org.unizd.rma.babic.adapter.DrinkAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)







        // Make API call
        val url = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?g=Cocktail_glass"
        val request = Request.Builder().url(url).build()

        OkHttpClient().newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val responseBody = response.body?.string()
                val drinksResponse = Gson().fromJson(responseBody, DrinksResponse::class.java)

                runOnUiThread {
                    // Populate the RecyclerView with the drinks
                    val adapter = DrinkAdapter(this@MainActivity, drinksResponse.drinks)
                    recyclerView.adapter = adapter
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }
        })
    }
}
