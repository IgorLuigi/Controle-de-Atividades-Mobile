package com.example.aplicativoigor.repository

import android.content.ContentValues
import android.content.Context
import com.example.aplicativoigor.datasource.DatabaseDefinition
import com.example.aplicativoigor.datasource.DatabaseHelper
import com.example.aplicativoigor.model.Atividade

class AtividadeRepository(context: Context) {

    private val dbHelper = DatabaseHelper(context)

    fun save(atividade: Atividade) : Int{
        val db = dbHelper.writableDatabase

        val valores = ContentValues()
        valores.put(DatabaseDefinition.Atividade.Columns.DESCRICAO, atividade.descricao)
        valores.put(DatabaseDefinition.Atividade.Columns.PRIORIDADE, atividade.prioridade)
        valores.put(DatabaseDefinition.Atividade.Columns.TIPO_ATIVIDADE, atividade.tipoAtividade)
        valores.put(DatabaseDefinition.Atividade.Columns.FEITO, atividade.feito)

        val id = db.insert(DatabaseDefinition.Atividade.TABLE_NAME, null, valores)

        return id.toInt()
    }

    fun update(atividade: Atividade){

    }

    fun delete(id: Int){

    }

    fun getAtividades() : ArrayList<Atividade>{

        val db = dbHelper.readableDatabase
        
        val projection = arrayOf(
            DatabaseDefinition.Atividade.Columns.ID,
            DatabaseDefinition.Atividade.Columns.DESCRICAO,
            DatabaseDefinition.Atividade.Columns.PRIORIDADE,
            DatabaseDefinition.Atividade.Columns.TIPO_ATIVIDADE
        )

        val sortOrder = "${DatabaseDefinition.Atividade.Columns.DESCRICAO} ASC"

        val cursor = db.query(DatabaseDefinition.Atividade.TABLE_NAME,
        projection, null, null, null, null, sortOrder)



        var atividades = ArrayList<Atividade>()
        if(cursor != null){
            while(cursor.moveToNext()){
                var atividade = Atividade(
                    id = cursor.getInt(cursor.getColumnIndex(DatabaseDefinition.Atividade.Columns.ID)),
                    descricao = cursor.getString(cursor.getColumnIndex(DatabaseDefinition.Atividade.Columns.DESCRICAO)),
                    prioridade = cursor.getFloat(cursor.getColumnIndex(DatabaseDefinition.Atividade.Columns.PRIORIDADE)),
                    tipoAtividade = cursor.getString(cursor.getColumnIndex(DatabaseDefinition.Atividade.Columns.TIPO_ATIVIDADE))
                )
                atividades.add(atividade)
            }
        }
        return atividades
    }

    fun getAtividade(id: Int){

    }

}