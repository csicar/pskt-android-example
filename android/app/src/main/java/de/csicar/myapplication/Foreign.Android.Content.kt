package Foreign.Android.Content

import android.content.Context
import android.content.Intent
import android.net.Uri

val __intentUrl = {url: Any ->
    url as String
    Intent(Intent.ACTION_VIEW, Uri.parse(url))
}

val __startIntent = {ctx: Any, intent: Any ->
    ctx as Context; intent as Intent
    ctx.startActivity(intent)
}