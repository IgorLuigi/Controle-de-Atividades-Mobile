package com.example.aplicativoigor.userInterface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.aplicativoigor.R
import com.example.aplicativoigor.constants.Constants
import com.example.aplicativoigor.model.Atividade
import com.example.aplicativoigor.repository.AtividadeRepository
import kotlinx.android.synthetic.main.activity_cadastro_atividade.*
import kotlinx.android.synthetic.main.layout_lista_atividades.*
import kotlinx.android.synthetic.main.toolbar.*

class CadastroAtividadeActivity : AppCompatActivity() {

    private lateinit var operacao: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_atividade)

        insertToolbar()

        operacao = intent.getStringExtra("operacao")

        if (intent.getStringExtra("operacao") != Constants.OPERACAO_NOVO_CADASTRO){
            preencherFormulario()
        }
    }

    private fun preencherFormulario() {
        var atividade = Atividade()
        var id = intent.getIntExtra("id", 0)

        val repository = AtividadeRepository(this)

        atividade = repository.getAtividade(id)

        editTextDescricaoAtividade.setText(atividade.descricao)
        editTextTipoAtividade.setText(atividade.tipoAtividade)
        checkboxZero.isChecked = atividade.feito
        ratingBarPrioridadeAtividade.rating = atividade.prioridade
    }

    private fun insertToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar!!.title = intent.getStringExtra("operacao")
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
                if (validarFormulario() && operacao == Constants.OPERACAO_NOVO_CADASTRO ){
                    salvarAtividade()
                } else {
                    atualizarAtividade()
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

    private fun atualizarAtividade() {
        val atividade = Atividade(
            id = intent.getIntExtra("id", 0),
            descricao = editTextDescricaoAtividade.text.toString(),
            prioridade = ratingBarPrioridadeAtividade.rating,
            tipoAtividade = editTextTipoAtividade.text.toString(),
            feito = checkboxZero.isChecked
        )

        val repo = AtividadeRepository(this)
        val count = repo.save(atividade)

        if(count > 0){
            val builderDialog = AlertDialog.Builder(this)
            builderDialog.setTitle("Sucesso!")
            builderDialog.setMessage("Atividade alterada com sucesso!")
            builderDialog.setIcon(R.drawable.ic_done_green_24dp)

            builderDialog.setPositiveButton("Feito") { _, _ ->
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
