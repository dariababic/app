package org.unizd.rma.babic.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView  // Import the CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.unizd.rma.babic.DetailsActivity
import org.unizd.rma.babic.Drink
import org.unizd.rma.babic.R

class DrinkAdapter(private val context: Context, private val drinks: List<Drink>) :
    RecyclerView.Adapter<DrinkAdapter.DrinkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_drink, parent, false)
        return DrinkViewHolder(view)
    }

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        val drink = drinks[position]
        holder.bind(drink)
    }

    override fun getItemCount(): Int = drinks.size

    inner class DrinkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val cardView: CardView = itemView.findViewById(R.id.cardview)  // Add this line
        private val nameTextView: TextView = itemView.findViewById(R.id.drinkNameTextView)
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)

        fun bind(drink: Drink) {
            nameTextView.text = drink.strDrink

            // Use a library like Picasso or Glide for image loading
            // For simplicity, I'm assuming the image URL is valid
            Glide.with(context).load(drink.strDrinkThumb).into(imageView)

            // Set click listener to open details activity
            cardView.setOnClickListener {
                val intent = Intent(context, DetailsActivity::class.java)
                intent.putExtra("drink", drink)
                context.startActivity(intent)
            }
        }
    }
}
