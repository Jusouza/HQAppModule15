package com.example.hqapp_module15

import androidx.lifecycle.ViewModel

class HQViewModel : ViewModel() {
     fun loadHQDetails(): HQDetails{
         return HQDetails("Minha HQ", "Este é apenas um conteúdo de texto maior")
     }

}