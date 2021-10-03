package net.simplifiedcoding

import android.widget.ImageView
import coil.load
import coil.transform.CircleCropTransformation

fun ImageView.loadImageFromUrl(url: String) = load(url) {
  crossfade(true)
  transformations(CircleCropTransformation())
}