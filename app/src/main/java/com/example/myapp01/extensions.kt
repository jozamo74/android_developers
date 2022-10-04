package com.example.myapp01

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

/****
 * Project: My app01
 * From: com.example.myapp01
 * Created by José Zambrano Moya on 3/10/22 at 10:34
 * More info: zambranomoya74@gmail.com
 ****/

fun Context.toast(text: String, duration: Int = Toast.LENGTH_SHORT) {

    Toast.makeText(this, text, duration).show()
}

fun RecyclerView.ViewHolder.toast(text: String, duration: Int = Toast.LENGTH_SHORT) {
    itemView.context.toast(text, duration)
}

fun ViewGroup.inflater(@LayoutRes layoutRes: Int): View {
    return LayoutInflater
        .from(context)
        .inflate(R.layout.view_media_item, this, false)
}

fun ImageView.loadUrl(url: String){
    Glide.with(this).load(url).into(this)
}

// inline en vez de hacer una llamada a la función
// se sustituye esa llamada por el código que hay dentro de esa función
inline fun <reified T: Activity> Context.startActivity(vararg pairs: Pair<String, Any?>) {
    //val bundle = bundleOf(*pairs)
    //val intent = Intent(this, T::class.java)
    //intent.putExtras(bundle)
    //startActivity(intent)

    //lo mismo que antes pero en una línea
    Intent(this, T::class.java)
        .apply {
            putExtras(bundleOf(*pairs))
        }
        .also(::startActivity)
}