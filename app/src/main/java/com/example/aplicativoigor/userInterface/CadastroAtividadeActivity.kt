package com.example.aplicativoigor.userInterface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
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
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_atividade, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.menu_cancelar -> {
                Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
            }
            R.id.menu_salvar -> {
                Toast.makeText(this, "SALVAR", Toast.LENGTH_SHORT).show()
            }
            else -> {
                onBackPressed()
            }
        }

        return true
    }
}
