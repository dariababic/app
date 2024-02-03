package org.unizd.rma.babic

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val drink = intent.getSerializableExtra("drink") as Drink

        val imageView: ImageView = findViewById(R.id.imageView)
        val nameTextView: TextView = findViewById(R.id.drinkNameTextView)
        val back: Button = findViewById(R.id.backButton)

        // Load image using Glide
        Glide.with(this).load(drink.strDrinkThumb).into(imageView)

        nameTextView.text = drink.strDrink
       // idTextView.text = "ID: ${drink.idDrink}"

        // Add more TextViews and set their text using other details from the 'drink' object
        // For example:
        // val categoryTextView: TextView = findViewById(R.id.detailsCategoryTextView)
        // categoryTextView.text = "Category: ${drink.strCategory}"


        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }



}
