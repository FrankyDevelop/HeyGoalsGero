package com.getstarted.heygoals.viewmodel

import androidx.lifecycle.ViewModel
import com.getstarted.heygoals.domain.HabitoUseCase

class HabitoViewModel:ViewModel() {
    //todo pasos para guardar #3
    val FirestoreUseCase= HabitoUseCase()
    //Enviar datos al activity
    fun crearHabito(nombreHabito:String,descripcionHabito:String){
        FirestoreUseCase.agregarHabitoFirebase(nombreHabito, descripcionHabito)
    }

}