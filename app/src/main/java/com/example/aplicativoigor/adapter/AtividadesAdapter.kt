package com.example.aplicativoigor.adapter
import android.app.AlertDialog
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.aplicativoigor.model.Atividade
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicativoigor.R
import com.example.aplicativoigor.constants.Constants
import com.example.aplicativoigor.repository.AtividadeRepository
import com.example.aplicativoigor.userInterface.CadastroAtividadeActivity
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
        holder.bind(atividade, position)
    }


    inner class AtividadeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(atividade: Atividade, position: Int) {
            itemView.textNomeDaAtividade.text = atividade.descricao
            itemView.textTipoDaAtividade.text = atividade.tipoAtividade
            itemView.valorPrioridade.rating = atividade.prioridade

            itemView.buttonDetalhes.setOnClickListener{
                val intent = Intent(itemView.context, CadastroAtividadeActivity::class.java)
                intent.putExtra("opercao", Constants.OPERACAO_CONSULTAR)
                intent.putExtra("id", atividade.id)
                itemView.context.startActivity(intent)
            }

            itemView.setOnLongClickListener{

                AlertDialog.Builder(itemView.context)
                    .setTitle("Exclus??o")
                    .setMessage("Deseja excluir a atividade ${atividade.descricao}?")
                    .setPositiveButton("SIM"){dialog, which ->
                        val repo = AtividadeRepository(itemView.context)
                        repo.delete(atividade.id)
                        listaAtividades.removeAt(position)
                        notifyDataSetChanged()
                        Toast.makeText(itemView.context, "Atividade esclu??da com sucesso!", Toast.LENGTH_SHORT).show()
                    }
                    .setNegativeButton("N??O"){dialog, which ->

                    }
                    .show()

                true
            }
        }
    }
}