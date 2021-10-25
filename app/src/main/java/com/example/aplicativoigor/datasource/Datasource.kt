package com.example.aplicativoigor.datasource

class Datasource {

    companion object{

        fun getAtividades(): ArrayList<Atividade> {
            var atividades = ArrayList<Atividade>()

            atividades.add(Atividades("Atividade Desenvolvimento Mobile", 25/10/2021, 5, "Atividade Faculdade"))
            atividades.add(Atividades("Limpar Casa", 27/10/2021, 5, "Atividade Doméstica"))

            return aatividades
        }
    }

}