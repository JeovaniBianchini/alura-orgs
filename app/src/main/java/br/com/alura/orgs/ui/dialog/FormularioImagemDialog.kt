package br.com.alura.orgs.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import br.com.alura.orgs.databinding.FormularioIamgemBinding
import br.com.alura.orgs.extenssions.tentarCarregarImagem

class FormularioImagemDialog(private val context: Context) {

    fun mostra(urlPadrao: String? = null, quandoImagemCarrega: (imagem: String) -> Unit) {
        FormularioIamgemBinding.inflate(LayoutInflater.from(context)).apply {

            urlPadrao?.let {
                formularioImagemView.tentarCarregarImagem(it)
                formularioUrl.setText(it)
            }
            formularioBotaoImagemView.setOnClickListener {
                val url = formularioUrl.text.toString()
                formularioImagemView.tentarCarregarImagem(url)
            }

            AlertDialog.Builder(context)
                .setView(root)
                .setPositiveButton("confirmar") { _, _ ->
                    val url = formularioUrl.text.toString()
                    quandoImagemCarrega(url)

                }
                .setNegativeButton("cancelar") { _, _ ->

                }
                .show()
        }
    }
}
