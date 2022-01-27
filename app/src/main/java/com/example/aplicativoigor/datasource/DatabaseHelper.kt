package com.example.aplicativoigor.datasource

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper (context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_ATIVIDADE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    companion object {
        private const val DATABASE_NAME = "atividadebanco"
        private const val DATABASE_VERSION = 1

        private const val CREATE_TABLE_ATIVIDADE = "CREATE TABLE ${DatabaseDefinition.Atividade.TABLE_NAME} (" +
                "${DatabaseDefinition.Atividade.Columns.ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "${DatabaseDefinition.Atividade.Columns.DESCRICAO} TEXT, " +
                "${DatabaseDefinition.Atividade.Columns.PRIORIDADE} REAL, " +
                "${DatabaseDefinition.Atividade.Columns.TIPO_ATIVIDADE} TEXT, " +
                "${DatabaseDefinition.Atividade.Columns.FEITO} INTEGER);"

    }
}