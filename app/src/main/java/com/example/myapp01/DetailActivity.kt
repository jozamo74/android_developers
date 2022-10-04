package com.example.myapp01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.myapp01.MediaItem.*
import com.example.myapp01.databinding.ActivityDetailBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "DetailActivity:id"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemId = intent.getIntExtra(EXTRA_ID, -1)

        lifecycleScope.launch{
            val items = withContext(Dispatchers.IO){MediaProvider.getItems()}
            val item = items.firstOrNull { it.id == itemId }
            item?.let {
                supportActionBar?.title = item.title
                binding.detailThumb.loadUrl(item.url)
                binding.detailVideoIndicator.visibility = when (item.type){
                    Type.PHOTO -> View.GONE
                    Type.VIDEO -> View.VISIBLE

                }
                binding.progress.visibility = View.GONE
            }
        }
    }
}