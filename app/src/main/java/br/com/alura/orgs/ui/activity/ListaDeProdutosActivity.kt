package br.com.alura.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.dao.ProdutosDao
import br.com.alura.orgs.databinding.ActivityListaProdutosBinding
import br.com.alura.orgs.ui.activity.recyclerview.adapter.ListaProdutosAdapter
import br.com.alura.orgs.ui.dialog.FormularioImagemDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaDeProdutosActivity: AppCompatActivity(){

    private val dao = ProdutosDao()
    private val adapter = ListaProdutosAdapter(
        context = this, produtos = dao.listarTodos()
    )
    private val binding by lazy {
        ActivityListaProdutosBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configuraRecyclerView()
        configuraFab()


    }

    override fun onResume() {
        super.onResume()

        adapter.atualiza(dao.listarTodos())

    }

    private fun configuraFab() {
        val fab = binding.floatingActionButton
        fab.setOnClickListener {
            vaiParaFormularioProduto()
        }
    }

    private fun vaiParaFormularioProduto() {
        val intent = Intent(this, FormularioProdutoActivity::class.java)
        startActivity(intent)
    }

    private fun configuraRecyclerView() {
        val recycleView = binding.recyclerview

        Log.i("MainActivity", "onCreate: ${dao.listarTodos()}")
        recycleView.adapter = adapter
    }
}