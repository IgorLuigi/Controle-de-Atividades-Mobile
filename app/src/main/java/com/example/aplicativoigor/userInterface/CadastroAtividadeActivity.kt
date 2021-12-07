package com.example.aplicativoigor.userInterface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aplicativoigor.R
import kotlinx.android.synthetic.main.toolbar.*

class CadastroAtividadeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_atividade)

        insertToolbar()
    }

    private fun insertToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Nova Atividade"
    }
}
