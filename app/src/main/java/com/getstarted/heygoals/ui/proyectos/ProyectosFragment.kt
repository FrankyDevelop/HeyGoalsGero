package com.getstarted.heygoals.ui.proyectos

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.getstarted.heygoals.viewmodel.ProyectoViewModel

import com.getstarted.heygoals.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.alert_proyecto.view.*
import kotlinx.android.synthetic.main.fragment_proyectos.*

/**
 * A simple [Fragment] subclass.
 */
class ProyectosFragment : Fragment() {

    private lateinit var viewModel: ProyectoViewModel
    //Instancia FIrestore
    val db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_proyectos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel= ViewModelProvider(this).get(ProyectoViewModel::class.java)

        btnNuevoProyecto.setOnClickListener {
            crearProyecto()
        }

    }
/*
    private fun crearProyecto(){
        val name:String=edtName.text.toString().trim()
        val description:String =edtDescrip.text.toString().trim()

        if(name.isNotEmpty() && description.isNotEmpty()){
            viewModel.crearProyecto(name,description)
            Toast.makeText(activity,"Usuario guardado exitosamente", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(activity,"No se pudo guardar", Toast.LENGTH_SHORT).show()
        }
    }*/

    private fun crearProyecto(){
        val mDialogView= LayoutInflater.from(activity).inflate(R.layout.alert_proyecto,null)

        val mBuilder=AlertDialog.Builder(activity).setView(mDialogView).setTitle("Nuevo Proyecto")

        val mAlertDialog=mBuilder.show()

        //Guardar proyecto
        mDialogView.btnGuardarProyecto.setOnClickListener {
            mAlertDialog.dismiss()
            //Obtenemos la informacion de las cajas de texto
            val name:String=mDialogView.edtName.text.toString().trim()
            val description:String =mDialogView.edtDescrip.text.toString().trim()
             //Guardamos el proyecto firebase
            if(name.isNotEmpty() && description.isNotEmpty()){
                viewModel.crearProyecto(name,description)
                Toast.makeText(activity,"Usuario guardado exitosamente", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(activity,"No se pudo guardar", Toast.LENGTH_SHORT).show()
            }

        }

        //Cancelamos la operacion
        mDialogView.btnCancel.setOnClickListener {
            mAlertDialog.dismiss()
        }

    }

}
