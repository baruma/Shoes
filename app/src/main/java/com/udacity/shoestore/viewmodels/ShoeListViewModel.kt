package com.udacity.shoestore.viewmodels

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.BR
import com.udacity.shoestore.models.Shoe


// Used Observable because BaseObservable + ViewModel not allowed to be inherited at once - Diamond of Doom results.

class ShoeListViewModel: ViewModel(), Observable {

    val shoes = mutableListOf<Shoe>()
    val shoeLiveData = MutableLiveData<Shoe>()
    val propertyChangeRegistry = PropertyChangeRegistry()

    fun addShoe(shoe: Shoe) {
        shoes.add(shoe)
        shoeLiveData.value = shoe
    }

    @Bindable
    var shoe = Shoe("", "", " ")
        set(value) {
            if(value != field) {
                field = value
                propertyChangeRegistry.notifyChange(this, BR.shoe)
            }
        }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.add(callback)
        print("I mostly don't do anything")
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.remove(callback)
        print("I also mostly don't do anything.")
    }

}