package com.example.tasc_casestudy

import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import javax.inject.Inject

class NewProductTest {
    private var product = Product("", false, 0, 0.0, 0.0)

    @Test
    fun testProductDisplay(){
        val testProductDisplay = "1 16lb bag of Skittles at 16.00"
        product.productDisplay = testProductDisplay
        assertEquals(product.productDisplay, testProductDisplay)
    }

    @Test
    fun testImportedProduct(){
        val isImported = true
        product.importedProduct = isImported
        assertEquals(product.importedProduct, isImported)
    }

    @Test
    fun testAmount(){
        val testAmountValue = 100
        product.amount = testAmountValue
        assertEquals(product.amount, testAmountValue)
    }

    @Test
    fun testPrice() {
        val testPriceValue = 1400.00
        product.price = testPriceValue
        assertEquals(product.price, testPriceValue)
    }

    @Test
    fun testTaxPrice(){
        val testSalesPriceValue = 0.25
        product.salesTax = testSalesPriceValue
        assertEquals(product.salesTax, testSalesPriceValue)
    }
}