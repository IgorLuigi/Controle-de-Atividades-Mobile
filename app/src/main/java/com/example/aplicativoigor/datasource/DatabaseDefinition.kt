package com.example.aplicativoigor.datasource

class DatabaseDefinition {

    object Atividade {
        const val TABLE_NAME = "Atividade"

        object Columns {
            const val ID = "id"
            const val DESCRICAO = "descricao"
            const val PRIORIDADE = "prioridade"
            const val TIPO_ATIVIDADE = "tipo_atividade"
            const val FEITO = "feito"
        }
    }

}