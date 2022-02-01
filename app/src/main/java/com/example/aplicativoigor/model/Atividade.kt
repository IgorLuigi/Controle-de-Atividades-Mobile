package com.example.aplicativoigor.model

import java.util.*

data class Atividade (
    var id: Int = 0,
    var descricao: String = "",
    var prioridade: Float = 0.0f,
    var tipoAtividade: String = "",
    var feito: Boolean = false
)

