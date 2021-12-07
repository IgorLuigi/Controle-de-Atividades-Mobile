import com.example.aplicativoigor.model.Atividade

class Datasource {

    companion object {

        fun getAtividades(): ArrayList<Atividade> {
            var atividades = ArrayList<Atividade>()

            atividades.add(Atividade("Atividade Desenvolvimento Mobile", "25/10/2021", 3.0f, "Atividade Faculdade"))
            atividades.add(Atividade("Limpar Casa"                     , "27/10/2021", 4.0f, "Atividade Doméstica"))
            atividades.add(Atividade("Lavar Louça"                     , "27/10/2021", 2.0f, "Atividade Doméstica"))

            return atividades
        }
    }

}