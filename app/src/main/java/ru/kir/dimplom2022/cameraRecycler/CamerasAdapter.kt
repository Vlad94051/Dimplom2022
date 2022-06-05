package ru.kir.dimplom2022.cameraRecycler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import ru.kir.dimplom2022.R

class CamerasAdapter : RecyclerView.Adapter<CamerasAdapter.ViewHolder>() {

    private var cameras = listOf<Camera>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(cameras[position], itemCount)
    }

    override fun getItemCount() = cameras.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<Camera>) {
        cameras = list
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        companion object {

            fun newInstance(parent: ViewGroup) = ViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_camera, parent, false)
            )
        }

        private val numberTextView by lazy { view.findViewById<TextView>(R.id.number) }
        private val ipTextView by lazy { view.findViewById<TextView>(R.id.ip) }
        private val separator by lazy { view.findViewById<View>(R.id.separator) }


        fun bindItem(item: Camera, size: Int) {
            separator.isVisible = adapterPosition != size - 1
            numberTextView.text = item.location
            ipTextView.text = item.cameraNumber

        }
    }
}

data class Camera(
    val location: String,
    private val number: Int
) {

    val cameraNumber get() = "Камера №$number"
}
