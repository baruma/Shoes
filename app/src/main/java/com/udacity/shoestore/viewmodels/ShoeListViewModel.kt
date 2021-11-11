package com.udacity.shoestore.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe


class ShoeListViewModel: ViewModel() {

    val shoes = mutableListOf<Shoe>()
    val shoeLiveData = MutableLiveData<Shoe>()

    fun addShoe(shoe: Shoe) {
        shoes.add(shoe)
        shoeLiveData.value = shoe

    }

}