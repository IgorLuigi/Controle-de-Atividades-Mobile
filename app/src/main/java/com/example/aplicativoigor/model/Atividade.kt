package com.example.aplicativoigor.model

import java.util.*

data class Atividade (
    var id: Int = 0,
    var descricao: String = "",
    var prioridade: Float = 0.0f,
    var tipoAtividade: String = "",
    var feito: Boolean = false) {

        fun id(id: Int) = apply {this.id = id}
        fun descricao(descricao: String) = apply {this.descricao = descricao}
        fun prioridade(prioridade: Float) = apply {this.prioridade = prioridade}
        fun tipoAtividade(tipoAtividade: String) = apply {this.tipoAtividade = tipoAtividade}
        fun feito(feito: Boolean) = apply {this.feito = feito}
    }


