package com.example.myapp01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Media
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp01.MediaItem.*
import com.example.myapp01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Logger{//, Listener  {

    //override val tag: String = javaClass.simpleName
    private lateinit var message: TextView
    private lateinit var button: Button

    private val adapter by lazy { MediaAdapter(getItems()){ toast(it.title) } }


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

        logD( "I'm here")

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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        adapter.items = when (item.itemId) {
            R.id.filter_all -> getItems()
            R.id.filter_photos -> getItems().filter { it.type == Type.PHOTO }
            R.id.filter_videos -> getItems().filter { it.type == Type.VIDEO }
            else -> emptyList()

        }
        return super.onOptionsItemSelected(item)
    }


}