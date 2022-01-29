package com.example.aplicativoigor.userInterface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.aplicativoigor.R
import com.example.aplicativoigor.model.Atividade
import com.example.aplicativoigor.repository.AtividadeRepository
import kotlinx.android.synthetic.main.activity_cadastro_atividade.*
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
                alert()
            }
            R.id.menu_salvar -> {
                if (validarFormulario()){
                    salvarAtividade()

                }
            }
            else -> {
                onBackPressed()
            }
        }

        return true
    }

    private fun salvarAtividade() {
         val atividade = Atividade(
             descricao = editTextDescricaoAtividade.text.toString(),
             prioridade = ratingBarPrioridadeAtividade.rating,
             tipoAtividade = editTextTipoAtividade.text.toString(),
             feito = checkboxZero.isChecked
         )

        val repo = AtividadeRepository(this)
        val id = repo.save(atividade)

        if(id > 0){
            val builderDialog = AlertDialog.Builder(this)
            builderDialog.setTitle("Sucesso!")
            builderDialog.setMessage("Atividade cadastrada com sucesso!\n\n Deseja cadastrar uma nova atividade?")
            builderDialog.setIcon(R.drawable.ic_done_green_24dp)

            builderDialog.setPositiveButton("Sim") { _, _ ->
                limparFormulario()
            }
            builderDialog.setNegativeButton("Não") { _, _ ->
                onBackPressed()
            }
            builderDialog.show()
        }

    }

    private fun limparFormulario() {
        editTextDescricaoAtividade.setText("")
        editTextTipoAtividade.setText("")
        checkboxZero.isChecked = false
        editTextDescricaoAtividade.requestFocus()
    }

    private fun validarFormulario() : Boolean {

        var valida = true

        if (editTextDescricaoAtividade.length() < 1){
            tilDescricaoAtividade.isErrorEnabled = true
            tilDescricaoAtividade.error = "Descrição da atividade é obrigatória"
            valida = false
        } else {
            tilDescricaoAtividade.isErrorEnabled = false
            tilDescricaoAtividade.error = null
        }


        if (editTextTipoAtividade.length() < 1){
            tilTipoAtividade.isErrorEnabled = true
            tilTipoAtividade.error = "Descrição da atividade é obrigatória"
            valida = false
        } else {
            tilTipoAtividade.isErrorEnabled = false
            tilTipoAtividade.error = null
        }

        return valida
    }

    private fun alert(){
        var builderDialog = AlertDialog.Builder(this)
        builderDialog.setTitle("Cancelar Cadastro")
        builderDialog.setMessage("Deseja cancelar o cadastro da atividade?")
        builderDialog.setIcon(R.drawable.ic_help_outline_red_24dp)

        builderDialog.setPositiveButton("Sim") {_, _ ->
            onBackPressed()
        }

        builderDialog.setNegativeButton("Não") {_, _ ->
            editTextDescricaoAtividade.requestFocus()
        }

        builderDialog.show()
    }


}
