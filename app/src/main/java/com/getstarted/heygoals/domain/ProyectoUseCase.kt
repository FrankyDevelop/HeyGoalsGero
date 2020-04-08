package com.getstarted.heygoals.domain

import com.getstarted.heygoals.repo.ProyectoRepo

class ProyectoUseCase {

    //todo pasos para guardar #2
    val repo= ProyectoRepo()
    //Agregando datos del repositorio
    fun agregarProyectoFirebase(nombre:String,descripcion:String){
        repo.AgregarProyecto(nombre,descripcion)
    }
}