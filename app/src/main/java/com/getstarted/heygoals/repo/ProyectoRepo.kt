package com.getstarted.heygoals.repo

import com.google.firebase.firestore.FirebaseFirestore

class ProyectoRepo {

    //todo pasos para guardar info  #1
    //Instancia FIrestore
    val db = FirebaseFirestore.getInstance()

    //Guardar
    fun AgregarProyecto(nombre: String, descripcion: String) {
        //Estructura de la coleccion
        val userHashMap = hashMapOf(
            "Nombre " to nombre,
            "Descripcion" to descripcion
        )

        //Coleccion con documento con nombre
        db.collection("Proyectos").add(userHashMap).addOnCompleteListener {
                if (it.isSuccessful) {
                    //algo
                } else {
                    //algo
                }
            }
    }
}