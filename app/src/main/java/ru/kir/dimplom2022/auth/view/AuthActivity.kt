package ru.kir.dimplom2022.auth.view

import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import ru.kir.dimplom2022.R
import ru.kir.dimplom2022.showErrorAlert

class AuthActivity : AppCompatActivity() {

    private val buttonNext by lazy { findViewById<Button>(R.id.buttonNext) }
    private val fingerL by lazy { findViewById<FrameLayout>(R.id.fingerL) }
    private val finger by lazy { findViewById<ImageView>(R.id.finger) }
    private val passwordTitle by lazy { findViewById<TextView>(R.id.passwordTitle) }
    private val inputPassword by lazy { findViewById<TextView>(R.id.inputPassword) }

    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_auth)
    }

    override fun onStart() {
        super.onStart()
        updateTitles()
        buttonNext.setOnClickListener {
            resolveAlert()
            counter++
            updateTitles()
        }
    }

    private fun resolveAlert() {


        when (counter) {
            in 10..11 -> showErrorAlert(message = "Проверьте введенные данные")
            in 0..8 -> {
                AlertDialog.Builder(this)
                    .setMessage("Подключить вход по отпечатку пальца?")
                    .setTitle("Отпечаток пальца")
                    .setPositiveButton("Подключить") { _, _ -> }
                    .setNegativeButton("Не нужно") { _, _ -> }
                    .create()
                    .show()
            }
            else -> passwordTitle.setOnClickListener {
                listOf(finger, fingerL).forEach { item ->
                    item.isVisible = !item.isVisible
                }
            }
        }
    }

    private fun updateTitles() {
        passwordTitle.text = when (counter) {
            in 0..3 -> "Введите ключ, полученный у оператора"
//            in 4..5 -> "Введите пароль"
//            in 7..10 -> "Введите пароль"
            else -> "Повторите пароль"
        }

        inputPassword.hint = when (counter) {
            in 0..3 -> "Тут должен быть ключ"
            in 4..5 -> "Тут должен быть пароль"
            else -> "Повторите пароль"
        }
    }
}