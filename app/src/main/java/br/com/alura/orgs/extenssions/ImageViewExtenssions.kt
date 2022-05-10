package br.com.alura.orgs.extenssions

import android.widget.ImageView
import br.com.alura.orgs.R
import coil.load

fun ImageView.tentarCarregarImagem(url: String? = null){
    load(url){
        fallback(R.drawable.erro)
        error(R.drawable.erro)
        placeholder(R.drawable.placeholder)
    }
}