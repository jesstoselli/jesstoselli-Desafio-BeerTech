package com.androidstudies.beertechchallenge.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.androidstudies.beertechchallenge.R
import com.androidstudies.beertechchallenge.entities.ProductItem
import com.bumptech.glide.Glide

class ProductItemsAdapter: RecyclerView.Adapter<ProductItemsAdapter.ProductsListViewHolder>() {
    var data = listOf<ProductItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductItemsAdapter.ProductsListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.product_item, parent, false) as View
        return ProductsListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductsListViewHolder,
        position: Int
    ) {
        val item = data[position]
        holder.bind(item.product, item.quantity, item.price, item.discount, item.imageUrl)
    }

    override fun getItemCount(): Int = data.size


    inner class ProductsListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val itemTitle = itemView.findViewById<TextView>(R.id.tv_productName)
        private val itemQuantity = itemView.findViewById<TextView>(R.id.tv_productQuantity)
        private val itemPrice = itemView.findViewById<TextView>(R.id.tv_productPrice)
        private val itemImage = itemView.findViewById<ImageView>(R.id.iv_productImage)

        fun bind(product: String, quantity: String, price: Int, discount: Boolean, imageUrl: String) {
            itemTitle.text = product
            itemQuantity.text = quantity
            itemPrice.text = "R$ $price"

            val url = imageUrl

            if(url.isNotEmpty()) {
                Glide.with(itemView.context)
                    .load(url)
                    .placeholder(R.drawable.ic_beer_pint)
                    .error(R.drawable.ic_beer_pint)
                    .into(itemImage)
            } else {
                Glide.with(itemView.context).clear(itemView)
                itemImage.setImageResource(R.drawable.ic_beer_pint)
            }


        }
    }

}