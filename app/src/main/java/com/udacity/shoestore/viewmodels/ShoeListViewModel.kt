package com.udacity.shoestore.viewmodels

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.BR
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel: ViewModel() {

    val shoes = mutableListOf<Shoe>()
    val shoeLiveData = MutableLiveData<Shoe>()
    val propertyChangeRegistry = PropertyChangeRegistry()

    fun addShoe(shoe: Shoe) {
        shoes.add(shoe)
        shoeLiveData.value = shoe
    }

}