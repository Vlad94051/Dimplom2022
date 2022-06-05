package ru.kir.dimplom2022.auth.view

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes


const val SHOW_KEYBOARD_DELAY: Long = 200

abstract class AuthInputView @JvmOverloads constructor(
    @LayoutRes layoutId: Int,
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    abstract fun getData(): String

    abstract fun getFocusView(): TextView

    abstract fun performIfValid(action: () -> Unit)

    abstract fun getActionButton(): Button

    init {
        inflate(context, layoutId, this)
    }

    @CallSuper
    open fun render(state: LoginState) {
        postDelayed(
            { getFocusView().makeFocusableAndShowKeyboard() },
            SHOW_KEYBOARD_DELAY
        )
    }

    fun setOnNextListener(onNextClicked: (String) -> Unit) {
        getActionButton().setOnClickListener {
            performIfValid {
                onNextClicked(getData())
            }
        }
    }
}

fun TextView.makeFocusableAndShowKeyboard() {
    isFocusable = true
    isFocusableInTouchMode = true
    requestFocus()
    KeyboardUtils.showSoftInput(this)
}
