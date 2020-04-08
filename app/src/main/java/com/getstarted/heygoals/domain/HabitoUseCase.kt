package com.getstarted.heygoals.domain

import com.getstarted.heygoals.repo.HabitosRepo


class HabitoUseCase {

    //todo pasos para guardar #2
    val repo= HabitosRepo()
    //Agregando datos del repositorio
    fun agregarHabitoFirebase(nombreHabito:String,descripcionHabito:String){
        repo.AgregarHabito(nombreHabito, descripcionHabito)
    }

}