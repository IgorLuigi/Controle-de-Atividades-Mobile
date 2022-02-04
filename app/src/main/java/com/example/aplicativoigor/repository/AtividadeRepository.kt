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

    fun update(atividade: Atividade): Int {
        val db = dbHelper.writableDatabase

        val valores = ContentValues().apply{
            put(DatabaseDefinition.Atividade.Columns.DESCRICAO, atividade.descricao)
            put(DatabaseDefinition.Atividade.Columns.PRIORIDADE, atividade.prioridade)
            put(DatabaseDefinition.Atividade.Columns.TIPO_ATIVIDADE, atividade.tipoAtividade)
            put(DatabaseDefinition.Atividade.Columns.FEITO, atividade.feito)
        }

        val selection = "${DatabaseDefinition.Atividade.Columns.ID} = ?"

        val selectionArgs = arrayOf(atividade.id.toString())

        val count = db.update(
            DatabaseDefinition.Atividade.TABLE_NAME,
            valores,
            selection,
            selectionArgs
        )

        return count
    }

    fun delete(id: Int) : Int{
        val db = dbHelper.writableDatabase

        val selection = "${DatabaseDefinition.Atividade.Columns.ID} = ?"

        val selectionArgs = arrayOf(id.toString())

        val deletedRows = db.delete(
            DatabaseDefinition.Atividade.TABLE_NAME, selection, selectionArgs)

        return deletedRows
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

    fun getAtividade(id: Int) : Atividade{

        val db = dbHelper.readableDatabase

        val projection = arrayOf(
            DatabaseDefinition.Atividade.Columns.ID,
            DatabaseDefinition.Atividade.Columns.DESCRICAO,
            DatabaseDefinition.Atividade.Columns.PRIORIDADE,
            DatabaseDefinition.Atividade.Columns.TIPO_ATIVIDADE,
            DatabaseDefinition.Atividade.Columns.FEITO
        )

        val selection = "${DatabaseDefinition.Atividade.Columns.ID} = ?"

        val selectionArgs = arrayOf(id.toString())

        val cursor = db.query(DatabaseDefinition.Atividade.TABLE_NAME,
            projection, selection, selectionArgs, null, null, null)

        var atividade = Atividade()

        if(cursor != null){
            cursor.moveToNext()
            atividade.id = cursor.getInt(cursor.getColumnIndex(DatabaseDefinition.Atividade.Columns.ID))
            atividade.descricao = cursor.getString(cursor.getColumnIndex(DatabaseDefinition.Atividade.Columns.DESCRICAO))
            atividade.prioridade = cursor.getFloat(cursor.getColumnIndex(DatabaseDefinition.Atividade.Columns.PRIORIDADE))
            atividade.tipoAtividade = cursor.getString(cursor.getColumnIndex(DatabaseDefinition.Atividade.Columns.TIPO_ATIVIDADE))
            atividade.feito = cursor.getInt(cursor.getColumnIndex(DatabaseDefinition.Atividade.Columns.FEITO)) == 1
        }
        return atividade
    }

}