package ru.kir.dimplom2022

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.kir.dimplom2022.cameraRecycler.Cameras
import ru.kir.dimplom2022.cameraRecycler.CamerasAdapter

class CameraFragment : Fragment(R.layout.fragment_camera) {

    companion object {
        const val TAG = "CameraFragment"
        fun newInstance() = CameraFragment()
    }

    private val adapter by lazy { CamerasAdapter() }

    override fun onStart() {
        super.onStart()
        adapter.submitList(Cameras.values())
    }
}