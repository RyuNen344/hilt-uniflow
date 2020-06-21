package com.ryunen344.hilt.uniflow.core.ext

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("goneUnless")
fun View.goneUnless(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("invisibleUnless")
fun View.invisibleUnless(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.INVISIBLE
}
