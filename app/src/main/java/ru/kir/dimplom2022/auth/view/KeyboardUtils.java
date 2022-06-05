package ru.kir.dimplom2022.auth.view;

import android.content.Context;
import androidx.annotation.Nullable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public final class KeyboardUtils {

    private KeyboardUtils() {
        throw new AssertionError("no KeyboardUtils instances");
    }

    public static void showSoftInput(@Nullable View view) {
        if (view != null) {
            InputMethodManager imm = ((InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE));
            if (imm != null) {
                imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
            }
        }
    }

    public static void hideSoftInput(@Nullable View view) {
        if (view != null) {
            InputMethodManager imm = ((InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE));
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }
}

