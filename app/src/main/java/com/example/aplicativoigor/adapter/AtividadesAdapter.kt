package com.example.aplicativoigor.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aplicativoigor.model.Atividade
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicativoigor.R
import kotlinx.android.synthetic.main.layout_lista_atividades.view.*

class AtividadesAdapter(var listaAtividades: ArrayList<Atividade>) : RecyclerView.Adapter<AtividadesAdapter.AtividadeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AtividadeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_lista_atividades, parent, false)

        return AtividadeViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaAtividades.size
    }

    override fun onBindViewHolder(holder: AtividadeViewHolder, position: Int) {
        val atividade = listaAtividades[position]
        holder.bind(atividade)
    }


    class AtividadeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(atividade: Atividade) {
            itemView.textNomeDaAtividade.text = atividade.descricao
            itemView.textTipoDaAtividade.text = atividade.tipoAtividade
            itemView.valorPrioridade.rating = atividade.prioridade
        }
    }
}