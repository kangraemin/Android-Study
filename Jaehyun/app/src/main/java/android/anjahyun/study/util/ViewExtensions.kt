package android.anjahyun.study.util

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext

fun View.visibleStatus(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}
fun Context.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}