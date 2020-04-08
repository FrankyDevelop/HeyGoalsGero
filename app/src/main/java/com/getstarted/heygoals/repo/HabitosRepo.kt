package com.getstarted.heygoals.repo

import com.google.firebase.firestore.FirebaseFirestore

class HabitosRepo {

    //todo pasos para guardar info  #1
    //Instancia FIrestore
    val db = FirebaseFirestore.getInstance()

    //Guardar
    fun AgregarHabito(nombreHabito: String, descripcionHabito: String) {
        //Estructura de la coleccion
        val userHashMap = hashMapOf(
            "NombreHabito " to nombreHabito,
            "DescripcionHabito" to descripcionHabito
        )

        //Coleccion con documento con nombre
        db.collection("Habitos").add(userHashMap).addOnCompleteListener {
            if (it.isSuccessful) {
                //algo
            } else {
                //algo
            }
        }
    }
}