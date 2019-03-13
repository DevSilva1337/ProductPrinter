package com.example.tasc_casestudy

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import kotlinx.android.synthetic.main.fragment_product.view.*

class ProductAdapter(var products: ArrayList<Product>, val context: Context) : Adapter<ProductAdapter.ProductHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ProductHolder {
        return ProductHolder(LayoutInflater.from(context).inflate(R.layout.fragment_product, parent, false))
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductAdapter.ProductHolder, position: Int) {
        var displayedProduct = products[position].productDisplay + ": " + products[position].price.toString()
        holder.tvProduct?.text = displayedProduct
    }

    fun update(updatedList: ArrayList<Product>){
        products = updatedList
        notifyDataSetChanged()
    }

    class ProductHolder(v: View) : RecyclerView.ViewHolder(v){
        val tvProduct = v.tv_ProductDescriptionFragment
    }
}