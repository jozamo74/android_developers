package com.example.myapp01

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapp01.databinding.ViewMediaItemBinding

/****
 * Project: My app01
 * From: com.example.myapp01
 * Created by José Zambrano Moya on 29/9/22 at 17:36
 * More info: zambranomoya74@gmail.com
 ****/
class MediaAdapter(private val items: List<MediaItem>) :
    RecyclerView.Adapter<MediaAdapter.ViewHolder>() {


    // Inflamos la vista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.view_media_item, parent, false)
        val view = parent.inflater(R.layout.view_media_item)
        return ViewHolder(view)
    }

    // Reemplazamos el contenido de la vista (invocado por el layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Obtenemos el elemento desde el listado en el posición y reemplazamos
        // el contenido de la vista con el elemento

        val item = items[position]
        holder.bind(item)

    }


    override fun getItemCount() = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ViewMediaItemBinding.bind(view)

        fun bind(mediaItem: MediaItem) {
            binding.mediaTitle.text = mediaItem.title
            binding.mediaThumb.loadUrl(mediaItem.url)
//            Glide
//                .with(binding.mediaThumb)
//                .load(mediaItem.url)
//                .into(binding.mediaThumb)

            binding.item.setOnClickListener {
                toast("Pulsado: ${binding.mediaTitle.text}")

            }

        }


        //private val title: TextView = view.findViewById(R.id.mediaTitle)
        //private val image: ImageView = view.findViewById(R.id.mediaThumb)

        /* fun bind1(mediaItem: MediaItem){
             title.text = mediaItem.title
             Glide
                 .with(image)
                 .load(mediaItem.url)
                 .into(image)
         }*/
    }


}