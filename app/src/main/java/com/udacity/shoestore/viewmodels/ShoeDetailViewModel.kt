package com.udacity.shoestore.viewmodels

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.udacity.shoestore.BR
import com.udacity.shoestore.models.Shoe

class ShoeDetailViewModel: BaseObservable() {
    var shoe = Shoe("", "", "")  // This is going to be passed to the ShoeListVM.

    @Bindable
    fun getName(): String {
        return shoe.name
    }

    fun setName(shoeName: String) {

        if(shoe.name != shoeName) {
            shoe.name = shoeName

            notifyPropertyChanged(BR.name)
        }
    }

    @Bindable
    fun getBrand(): String {
        return shoe.brand
    }

    fun setBrand(shoeBrand: String) {
        if(shoe.brand != shoeBrand) {
            shoe.brand = shoeBrand
        }
        notifyPropertyChanged(BR.brand)
    }

    @Bindable
    fun getShoeSize(): String {
        return shoe.size
    }

    fun setShoeSize(shoeSize: String) {
        if(shoe.size != shoeSize) {
            shoe.size = shoeSize
        }
        notifyPropertyChanged(BR.shoeSize)
    }

}