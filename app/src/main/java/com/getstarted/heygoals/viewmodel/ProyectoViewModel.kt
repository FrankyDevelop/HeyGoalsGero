package com.getstarted.heygoals.viewmodel

import androidx.lifecycle.ViewModel
import com.getstarted.heygoals.domain.ProyectoUseCase

class ProyectoViewModel:ViewModel() {
    //todo pasos para guardar #3
    val FirestoreUseCase= ProyectoUseCase()
    //Enviar datos al activity
    fun crearProyecto(nombre:String,descripcion:String){
        FirestoreUseCase.agregarProyectoFirebase(nombre,descripcion)
    }
}