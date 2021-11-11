package com.udacity.shoestore.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.databinding.BindingAdapter
import com.udacity.shoestore.databinding.ShoeCardBinding
import com.udacity.shoestore.models.Shoe

class ShoeCard @JvmOverloads constructor(

    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : FrameLayout (context, attrs, defStyleAttr) {

    val binding: ShoeCardBinding = ShoeCardBinding.inflate(LayoutInflater.from(context), this, true)

    @BindingAdapter("isVisible")
    fun updateVisibility(view: View, isVisible: Boolean) {
        view.visibility = if(isVisible) View.VISIBLE else View.GONE
    }

    fun configure(shoe: Shoe) {
        binding.shoe = shoe
    }
}
