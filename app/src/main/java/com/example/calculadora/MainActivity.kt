package com.example.calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var operacion: Int = 0
    var numero1: Double = 0.0
    lateinit var tv_input: TextView
    lateinit var tv_output: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        tv_input = findViewById(R.id.tv_input)
        tv_output = findViewById(R.id.tv_output)

        val btn_borrar: Button = findViewById(R.id.btn_borrar)
        val btn_igual: Button = findViewById(R.id.btn_igual)
        val btn_salir: Button = findViewById(R.id.btn_salir)

        btn_igual.setOnClickListener{
            try {
                var numero2: Double = tv_input.text.toString().toDouble()
                var respuesta: Double = 0.0
                when(operacion){
                    1 -> respuesta = numero1 + numero2
                    2 -> respuesta = numero1 - numero2
                    3 -> respuesta = numero1 * numero2
                    4 -> respuesta = numero1 / numero2
                }
                tv_output.setText(respuesta.toString())
                tv_input.setText("")
            } catch (e: Exception){
                println(e.message)
            }

        }

        btn_borrar.setOnClickListener{
            tv_input.setText("")
            tv_output.setText("")
            numero1 = 0.0
            operacion = 0
        }

        btn_salir.setOnClickListener{
            finishAffinity()
        }


    }
    fun presionarDigito(view: View){
        var num2: String = tv_input.text.toString()

        when(view.id){
            R.id.btn_0 -> tv_input.setText(num2 + "0")
            R.id.btn_1 -> tv_input.setText(num2 + "1")
            R.id.btn_2 -> tv_input.setText(num2 + "2")
            R.id.btn_3 -> tv_input.setText(num2 + "3")
            R.id.btn_4 -> tv_input.setText(num2 + "4")
            R.id.btn_5 -> tv_input.setText(num2 + "5")
            R.id.btn_6 -> tv_input.setText(num2 + "6")
            R.id.btn_7 -> tv_input.setText(num2 + "7")
            R.id.btn_8 -> tv_input.setText(num2 + "8")
            R.id.btn_9 -> tv_input.setText(num2 + "9")
            R.id.btn_punto -> tv_input.setText(num2 + ".")
        }
    }

    fun clickOperacion(view: View){
        try {
            numero1 = tv_input.text.toString().toDouble()
            var num2_text: String = tv_input.text.toString()
            tv_input.setText("")
            when(view.id){
                R.id.btn_suma ->{
                    tv_output.setText(num2_text + "+")
                    operacion = 1
                }
                R.id.btn_resta ->{
                    tv_output.setText(num2_text + "-")
                    operacion = 2
                }
                R.id.btn_multiplicacion ->{
                    tv_output.setText(num2_text + "*")
                    operacion = 3
                }
                R.id.btn_division ->{
                    tv_output.setText(num2_text + "/")
                    operacion = 4
                }
            }
        }catch (e: Exception){
            println(e.message)
        }
    }
}