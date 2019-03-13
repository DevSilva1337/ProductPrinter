package com.example.tasc_casestudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var totalProducts = ArrayList<Product>()
    private var exceptProducts = arrayOf("Snickers", "Skittles", "Popcorn", "Coffee")
    private val productAdapter = ProductAdapter(totalProducts, this)
    private val totalTax = 0.0
    private var total = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_Products.layoutManager = LinearLayoutManager(this)
        rv_Products.adapter = productAdapter

        btn_Total.setOnClickListener {
            var currentProduct = productDisplayDescription(et_ProductInput.text.toString())
            productSalesTax(currentProduct)
            totalProducts.add(currentProduct)
            productAdapter.update(totalProducts)
            tv_Tax.text = ((currentProduct.salesTax * currentProduct.price)+ totalTax).toString()
            total = calculateTotal(total, currentProduct.price)
            tv_Total.text = total.toString()
            et_ProductInput.text.clear()
        }

        btn_Complete.setOnClickListener {
            totalProducts = ArrayList<Product>()
            productAdapter.update(totalProducts)
            total = 0.0
            tv_Tax.text = ""
            tv_Total.text = ""
        }
    }



    private fun productDisplayDescription(productString: String): Product{
        var product = Product("", false, 0, 0.0, 0.0)
        var productStringSeparator = productString.split("at")
        product.amount = Character.getNumericValue(productStringSeparator[0].first())
        if(productString.contains("import") || productString.contains("Import")){
            product.importedProduct = true
        }
        //var spaceRemover = productStringSeparator[1].replace(" ", "")
        product.price = productStringSeparator[1].replace(" ", "").replace(",", "").toDouble()
        product.productDisplay = productStringSeparator[0]
        return product
    }

    private fun productSalesTax(product: Product){
        var totalTax= 0.10
        if(product.importedProduct){
            totalTax += .05
        }
        for(exceptProd in exceptProducts){
            if(product.productDisplay.contains(exceptProd)){
                totalTax -= .10
            }
        }
        product.salesTax = totalTax
    }

    private fun calculateTotal(total: Double, price: Double): Double{
        return total + price
    }

    fun roundUp(totalWithTax: Double): Double{
        return ((totalWithTax + 4) / 5 * 5)
    }
}
