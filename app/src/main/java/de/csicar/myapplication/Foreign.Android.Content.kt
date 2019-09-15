package Foreign.Android.Content

import PS.Data.Tuple.Module
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import org.jetbrains.anko.sdk27.coroutines.onClick

val __intentUrl = {url: Any ->
    url as String
    Intent(Intent.ACTION_VIEW, Uri.parse(url))
}

val __startIntent = {ctx: Any, intent: Any ->
    ctx as Context; intent as Intent
    ctx.startActivity(intent)
}