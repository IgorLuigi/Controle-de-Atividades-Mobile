package com.example.aplicativoigor.userInterface

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aplicativoigor.R
import com.example.aplicativoigor.adapter.AtividadesAdapter

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iniciarRecyclerView()
        
        buttonCadastrarAtividade.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.buttonCadastrarAtividade){
            val intent = Intent(this, CadastroAtividadeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun iniciarRecyclerView() {
        recyclerViewAtividades.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerViewAtividades.adapter = AtividadesAdapter(Datasource.getAtividades())
    }


}
