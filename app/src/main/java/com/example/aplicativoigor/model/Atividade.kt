package com.example.aplicativoigor.model

import java.util.*

data class Atividade (
    var id: Int = 0,
    var descricao: String,
    var data: String,
    var prioridade: Float,
    var tipoAtividade: String,
    var zerado: Boolean = false
)

