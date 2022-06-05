package ru.kir.dimplom2022

import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import ru.kir.dimplom2022.cameraRecycler.CamerasAdapter
import ru.kir.dimplom2022.cameraRecycler.RecyclerActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        findViewById<TextView>(R.id.first).setOnClickListener {
            //openCameraNumberAlert()
            openCameraFragment()
        }

        findViewById<TextView>(R.id.second).setOnClickListener {
            findViewById<LinearLayout>(R.id.progress).isVisible = true
        }

        findViewById<TextView>(R.id.third).setOnClickListener {
            showErrorAlert()
        }

        findViewById<TextView>(R.id.fourth).setOnClickListener {
            findViewById<TextView>(R.id.first).apply {
                setBackgroundResource(R.drawable.img)
                text = ""
            }
        }
    }

    private fun openCameraFragment() {
        val intent = Intent(this, RecyclerActivity::class.java)
        startActivity(intent)
    }

    private fun openCameraNumberAlert() {
        val input = EditText(this@MainActivity)
        val lp = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.MATCH_PARENT
        )
        input.layoutParams = lp

        AlertDialog.Builder(this)
            .setTitle("Ip-камера")
            .setMessage("Введите серийный номер Ip-камеры")
            .setPositiveButton("Ок") { r, r2 -> }
            .setView(input)
            .create()
            .show()
    }
}

fun AppCompatActivity.showErrorAlert(message: String = "Указанный серийный номер не найден") {
    AlertDialog.Builder(this)
        .setTitle("Ошибка")
        .setMessage(message)
        .setPositiveButton("ОК") { _, _ -> }
        .create()
        .show()
}