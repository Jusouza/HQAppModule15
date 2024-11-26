package com.example.hqapp_module15

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hqapp_module15.placeholder.PlaceholderContent
import com.example.hqapp_module15.placeholder.PlaceholderContent.PlaceholderItem

class HQViewModel : ViewModel() {

    val hqDetailsLiveData : LiveData<HQDetails>
        get() = _hqDetailsLiveData

    private val _hqDetailsLiveData = MutableLiveData<HQDetails>()

    val hqListLiveData: LiveData<MutableList<PlaceholderItem>>
        get() = _hqListLiveData

    private val _hqListLiveData = MutableLiveData<MutableList<PlaceholderItem>>()

    val navigationToDetailLiveData
        get() = _navigationToDetailLiveData

    private val _navigationToDetailLiveData = MutableLiveData<Unit>()


    init {
        _hqListLiveData.postValue(PlaceholderContent.ITEMS)
    }

   fun onHqSelected(position: Int) {
       val hqDetails = HQDetails("Minha HQ", "Este é apenas um conteúdo de texto maior")
       _hqDetailsLiveData.postValue(hqDetails)
       _navigationToDetailLiveData.postValue(Unit)
   }

}