package com.example.myapp01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Media
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Logger  {

    //override val tag: String = javaClass.simpleName
    private lateinit var message: TextView
    private lateinit var button: Button

    //private lateinit var mRecyclerView: RecyclerView
    //val mAdapter: MediaAdapter = MediaAdapter(getItems())

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)

        //val recycler: RecyclerView = findViewById(R.id.recycler)
        binding.recycler.adapter = MediaAdapter(getItems())
        //setUpRecyclerView()


        logD( "I'm here")

    }

   /* private fun setUpRecyclerView() {
        mRecyclerView = findViewById(R.id.recycler)
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = GridLayoutManager(this, 2)
        mRecyclerView.adapter = mAdapter
    }*/


}