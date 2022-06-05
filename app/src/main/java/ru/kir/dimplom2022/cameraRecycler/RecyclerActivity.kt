package ru.kir.dimplom2022.cameraRecycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import ru.kir.dimplom2022.R

class RecyclerActivity : AppCompatActivity() {

    private val adapter by lazy { CamerasAdapter() }

    private val recycler by lazy { findViewById<RecyclerView>(R.id.recycler) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.fragment_camera)
    }

    override fun onStart() {
        super.onStart()
        recycler.adapter = adapter
        adapter.submitList(Cameras.values())
    }
}