package com.getstarted.heygoals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth

class Intermediario : AppCompatActivity() {

    //TODO el by lazy hace que solo inicialize esa variables cuando sea necesaria
    private val authUser: FirebaseAuth by lazy { FirebaseAuth.getInstance()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intermediario)

        gotTo()
    }

    //Definir si va a la pantalla principal o a loguearse
    fun gotTo() {
        //Si el usuario esta logueado
        if (authUser.currentUser!=null){
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }else{
            startActivity(Intent(this,Login::class.java))
            finish()
        }
    }
}
