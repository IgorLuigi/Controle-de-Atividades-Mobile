package com.example.aplicativoigor.repository

import android.content.ContentValues
import android.content.Context
import com.example.aplicativoigor.datasource.DatabaseDefinition
import com.example.aplicativoigor.datasource.DatabaseHelper
import com.example.aplicativoigor.model.Atividade

class AtividadeRepository(context: Context) {

    private val dbHelper = DatabaseHelper(context)

    fun save(atividade: Atividade){
        val db = dbHelper.writableDatabase

        val valores = ContentValues()
        valores.put(DatabaseDefinition.Atividade.Columns.DESCRICAO, atividade.descricao)
        valores.put(DatabaseDefinition.Atividade.Columns.DATA, atividade.data)
        valores.put(DatabaseDefinition.Atividade.Columns.PRIORIDADE, atividade.prioridade)
        valores.put(DatabaseDefinition.Atividade.Columns.TIPO_ATIVIDADE, atividade.tipoAtividade)
        valores.put(DatabaseDefinition.Atividade.Columns.ZERADO, atividade.zerado)

        db.insert(DatabaseDefinition.Atividade.TABLE_NAME, null, valores)
    }

    fun update(atividade: Atividade){

    }

    fun delete(id: Int){

    }

    fun getAtividades(){

    }

    fun getAtividade(id: Int){

    }

}