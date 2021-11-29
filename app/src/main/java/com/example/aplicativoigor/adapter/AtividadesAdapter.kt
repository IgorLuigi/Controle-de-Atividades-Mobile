package com.example.aplicativoigor.adapter
import android.view.View
import android.view.ViewGroup
import com.example.aplicativoigor.model.Atividade
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_lista_atividades.view.*

class AtividadesAdapter(var listaAtividades: ArrayList<Atividade>) : RecyclerView.Adapter<AtividadesAdapter.AtividadeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AtividadeViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: AtividadeViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


    class AtividadeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(atividade: Atividade) {
            itemView.textNomeDaAtividade.text = atividade.descricao
            itemView.textTipoDaAtividade.text = atividade.tipoAtividade
            itemView.valorPrioridade.rating = atividade.prioridade
        }
    }
}