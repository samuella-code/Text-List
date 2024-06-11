package com.hfad.text_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.hfad.text_list.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DataAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database =
            Room.databaseBuilder(applicationContext, AppDatabase::class.java, "app_database")
                .build()
        val repository = DataRepository(database.dataItemDao())
        val factory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        // Use binding to access recyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = DataAdapter()
        binding.recyclerView.adapter = adapter

        viewModel.dataItems.observe(this) { items ->
            adapter.submitList(items)
        }
    }
}