package com.getstarted.heygoals.ui.habitos

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

import com.getstarted.heygoals.R
import com.getstarted.heygoals.viewmodel.HabitoViewModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.alert_habito.view.*
import kotlinx.android.synthetic.main.fragment_habitos.*

/**
 * A simple [Fragment] subclass.
 */
class HabitosFragment : Fragment() {

    private lateinit var viewModel: HabitoViewModel
    //Instancia FIrestore
    val db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_habitos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel= ViewModelProvider(this).get(HabitoViewModel::class.java)

        btnNuevoHabito.setOnClickListener {
            crearHabito()
        }

    }

    fun crearHabito(){
        val mDialogView= LayoutInflater.from(activity).inflate(R.layout.alert_habito,null)

        val mBuilder= AlertDialog.Builder(activity).setView(mDialogView).setTitle("Nuevo Habito")

        val mAlertDialog=mBuilder.show()

        mDialogView.btnGuardarHabito.setOnClickListener {
            mAlertDialog.dismiss()

            //Obtenemos la informacion de las cajas de texto
            val nombreHabito:String=mDialogView.edtNombreHabito.text.toString().trim()
            val descripcionHabito:String =mDialogView.edtDescripcionHabito.text.toString().trim()

            //Guardamos el proyecto firebase
            if(nombreHabito.isNotEmpty() && descripcionHabito.isNotEmpty()){
                viewModel.crearHabito(nombreHabito, descripcionHabito)
                Toast.makeText(activity,"Se agrego un nuevo habito!!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(activity,"No se pudo guardar el habito", Toast.LENGTH_SHORT).show()
            }

        }

        mDialogView.btnCancelHabito.setOnClickListener {
            mAlertDialog.dismiss()
        }
    }



}
