package com.example.listadedesejos

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class FormActivity : AppCompatActivity() {
    private lateinit var textDesejo: EditText
    private lateinit var textValor: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnCancelar: Button
    private lateinit var desejos: Desejo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        this.textDesejo = findViewById(R.id.textDescricao)
        this.textValor = findViewById(R.id.textValor)
        this.btnAdd = findViewById(R.id.btnAdd)
        this.btnCancelar = findViewById(R.id.btnCancelar)

        btnAdd.setOnClickListener({ btnAddDesejo(it)})

        btnCancelar.setOnClickListener {
            finish()
        }

    }

    fun btnAddDesejo(view: View){
        val desejo = textDesejo.toString()
        val valor = textValor.toString().toFloat()

        this.desejos = Desejo(desejo, valor)

        val intent = Intent()

        intent.putExtra("form", desejos)
        setResult(Activity.RESULT_OK, intent)
        startActivity(intent)
        finish()

    }
}