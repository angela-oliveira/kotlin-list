package com.example.listadedesejos

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AbsListView
import android.widget.ArrayAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var btnAdd: FloatingActionButton
    private lateinit var listView: AbsListView
    private lateinit var lista: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.lista = ArrayList()
        this.btnAdd = findViewById(R.id.floating_button_add)
        this.listView = findViewById(R.id.list_item)

        //this.listView.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, this.lista)
        btnAdd.setOnClickListener {
            val intent = Intent(this, FormActivity::class.java)
            startActivity(intent)
        }
        this.listView.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, this.lista)

    }
    //private fun addNome(view: View) {
    //    val nome: String = this.
    //}
    var codigoResultado = 1
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode === Activity.RESULT_OK){
            if(requestCode === codigoResultado){
                val desejo = data?.getSerializableExtra("form") as Desejo
                (this.listView.adapter as ArrayAdapter<Desejo>).add(desejo)
            }
        }

    }
}