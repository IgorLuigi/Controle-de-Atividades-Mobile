import com.example.aplicativoigor.model.Atividade

class Datasource {

    companion object {

        fun getAtividades(): ArrayList<Atividade> {
            var atividades = ArrayList<Atividade>()

            atividades.add(Atividade(1,"Desenvolvimento Mobile", 3.0f,"Atividade Faculdade"))


            return atividades
        }
    }

}