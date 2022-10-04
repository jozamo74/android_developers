package com.example.myapp01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.myapp01.MediaItem.*
import com.example.myapp01.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity(), Logger{//, Listener  {

    //override val tag: String = javaClass.simpleName
    //private lateinit var message: TextView
    //private lateinit var button: Button

    private val adapter = MediaAdapter{ toast(it.title) }


    //private lateinit var mRecyclerView: RecyclerView
    //val mAdapter: MediaAdapter = MediaAdapter(getItems())

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)

        //val recycler: RecyclerView = findViewById(R.id.recycler)
        /*binding.recycler.adapter = MediaAdapter(getItems(), object : Listener {
            override fun onClick(mediaItem: MediaItem) {
                toast(mediaItem.title)
            }

        })*/
        //setUpRecyclerView()
        //binding.recycler.adapter = MediaAdapter(getItems(), this)
        /*binding.recycler.adapter = MediaAdapter(getItems()){
            toast(it.title)
        }*/
        binding.recycler.adapter = adapter
        updateItems()
        /*GlobalScope.launch(Dispatchers.Main) {
            binding.progress.visibility = View.VISIBLE
            adapter.items = withContext(Dispatchers.IO){
                MediaProvider.getItems()

            }
            binding.progress.visibility = View.GONE
        }*/


        //logD( "I'm here")

    }

   /* override fun onClick(mediaItem: MediaItem) {
        toast(mediaItem.title)
    }*/

    /* private fun setUpRecyclerView() {
         mRecyclerView = findViewById(R.id.recycler)
         mRecyclerView.setHasFixedSize(true)
         mRecyclerView.layoutManager = GridLayoutManager(this, 2)
         mRecyclerView.adapter = mAdapter
     }*/


    private fun updateItems(filter: Int = R.id.filter_all) {
        GlobalScope.launch(Dispatchers.Main){
            binding.progress.visibility = View.VISIBLE
            adapter.items = withContext(Dispatchers.IO) { getFilteredItem(filter) }
            binding.progress.visibility = View.GONE
        }
    }

    private fun getFilteredItem(filter: Int): List<MediaItem> {
        return MediaProvider.getItems().let { media ->
            when (filter) {
                R.id.filter_all -> MediaProvider.getItems()
                R.id.filter_photos -> media.filter { it.type == Type.PHOTO }
                R.id.filter_videos -> media.filter { it.type == Type.VIDEO }
                else -> emptyList()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        updateItems(item.itemId)
        return super.onOptionsItemSelected(item)
    }


}