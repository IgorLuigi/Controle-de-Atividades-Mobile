import com.example.aplicativoigor.model.Atividade

class Datasource {

    companion object {

        fun getAtividades(): ArrayList<Atividade> {
            var atividades = ArrayList<Atividade>()

            atividades.add(Atividade("Atividade Desenvolvimento Mobile", "25/10/2021", 5.0f, "Atividade Faculdade"))
            atividades.add(Atividade("Limpar Casa", "27/10/2021", 5.0f, "Atividade Doméstica"))

            return atividades
        }
    }

}