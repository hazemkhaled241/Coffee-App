package com.example.coffeeshop.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.coffeeshop.R


class PreferencesFragment : Fragment(R.layout.fragment_preferences) {
    private lateinit var totalPrice: TextView
    private lateinit var count: TextView
    private lateinit var smallCoffe: ImageView
    private lateinit var midCoffe: ImageView
    private lateinit var largeCoffe: ImageView
    private lateinit var price: TextView
    private lateinit var prefOne: ImageView
    private lateinit var prefTwo: ImageView
    private lateinit var oneSuger: ImageView
    private lateinit var add: ImageView
    private lateinit var remove: ImageView
    private lateinit var image: ImageView
    private lateinit var name: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val prefBtn = view.findViewById<Button>(R.id.btn_add_to_cart)
        smallCoffe = view.findViewById(R.id.iv_coffee_small)
        midCoffe = view.findViewById(R.id.iv_coffee_med)
        largeCoffe = view.findViewById(R.id.iv_coffe_large)
        val noSuger = view.findViewById<ImageView>(R.id.iv_no_sugar)
        oneSuger = view.findViewById(R.id.iv_sugar1)
        val twoSuger = view.findViewById<ImageView>(R.id.iv_sugar2)
        val threeSuger = view.findViewById<ImageView>(R.id.iv_sugar3)
        prefOne = view.findViewById(R.id.iv_pref1)
        prefTwo = view.findViewById(R.id.iv_pref2)
        count = view.findViewById(R.id.counter)
        totalPrice = view.findViewById(R.id.tv_total_Price)
        price = view.findViewById(R.id.price)
        add = view.findViewById(R.id.add)
        remove = view.findViewById(R.id.remove)
        image = view.findViewById(R.id.image)
        name = view.findViewById(R.id.category)
        prefBtn.setOnClickListener {
            findNavController().navigate(PreferencesFragmentDirections.actionPreferencesFragmentToCartFragment())
        }
        smallCoffe.setOnClickListener {
            smallCoffe.setColorFilter(R.color.black)
            largeCoffe.clearColorFilter()
            midCoffe.clearColorFilter()
            smallCoffe.tag = R.color.black
            midCoffe.tag = R.color.gray
            largeCoffe.tag = R.color.gray
            calculateTotal()
        }
        midCoffe.setOnClickListener {
            midCoffe.setColorFilter(R.color.black)
            largeCoffe.clearColorFilter()
            smallCoffe.clearColorFilter()
            midCoffe.tag = R.color.black
            smallCoffe.tag = R.color.gray
            largeCoffe.tag = R.color.gray
            calculateTotal()
        }
        largeCoffe.setOnClickListener {
            largeCoffe.setColorFilter(R.color.black)
            largeCoffe.tag = R.color.black
            midCoffe.clearColorFilter()
            smallCoffe.clearColorFilter()
            midCoffe.tag = R.color.gray
            smallCoffe.tag = R.color.gray
            calculateTotal()
        }
        noSuger.setOnClickListener {
            noSuger.setColorFilter(R.color.black)
            oneSuger.clearColorFilter()
            twoSuger.clearColorFilter()
            threeSuger.clearColorFilter()
            noSuger.tag = R.color.black
            oneSuger.tag = R.color.gray
            twoSuger.tag = R.color.gray
            threeSuger.tag = R.color.black
        }
        oneSuger.setOnClickListener {
            oneSuger.setColorFilter(R.color.black)
            noSuger.clearColorFilter()
            twoSuger.clearColorFilter()
            threeSuger.clearColorFilter()
            oneSuger.tag = R.color.black
            noSuger.tag = R.color.gray
            twoSuger.tag = R.color.gray
            threeSuger.tag = R.color.gray
            //calculateTotal()
        }
        twoSuger.setOnClickListener {
            twoSuger.setColorFilter(R.color.black)
            oneSuger.clearColorFilter()
            noSuger.clearColorFilter()
            threeSuger.clearColorFilter()
            oneSuger.tag = R.color.gray
            noSuger.tag = R.color.gray
            twoSuger.tag = R.color.black
            threeSuger.tag = R.color.gray
        }
        threeSuger.setOnClickListener {
            threeSuger.setColorFilter(R.color.black)
            oneSuger.clearColorFilter()
            twoSuger.clearColorFilter()
            noSuger.clearColorFilter()
            oneSuger.tag = R.color.gray
            noSuger.tag = R.color.gray
            twoSuger.tag = R.color.gray
            threeSuger.tag = R.color.black
        }
        prefOne.setOnClickListener {
            prefOne.setColorFilter(R.color.black)
            prefTwo.clearColorFilter()
            prefOne.tag = R.color.black
            prefTwo.tag = R.color.gray
            calculateTotal()
        }
        prefTwo.setOnClickListener {
            prefTwo.setColorFilter(R.color.black)
            prefOne.clearColorFilter()
            prefOne.tag = R.color.gray
            prefTwo.tag = R.color.black

        }
        add.setOnClickListener {
            count.text = (count.text.toString().toInt() + 1).toString()
            calculateTotal()
        }

        remove.setOnClickListener {
            if (count.text.toString().toInt() > 0) {
                count.text = (count.text.toString().toInt() - 1).toString()
            }
            calculateTotal()
        }
        defaultSelect()
        calculateTotal()

    }

    private fun defaultSelect() {
        midCoffe.setColorFilter(R.color.black)
        midCoffe.tag = R.color.black
        oneSuger.setColorFilter(R.color.black)
        oneSuger.tag = R.color.black
    }

    fun calculateTotal() {
        val num = count.text.toString().toInt()
        var total = 0.0
        val smPrice = price.text.toString().toDouble()
        if (midCoffe.tag.equals(R.color.black)) {
            total = smPrice * num * 1.5
        } else if (smallCoffe.tag.equals(R.color.black)) {
            total = smPrice * num
        } else if (largeCoffe.tag.equals(R.color.black)) {
            total = smPrice * 2 * num
        }
        totalPrice.text = ("${total.toString()} EGP")
    }
}