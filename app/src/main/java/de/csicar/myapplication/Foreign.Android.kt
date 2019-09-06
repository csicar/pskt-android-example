package Foreign.Main

import android.content.Context
import android.view.View
import android.view.ViewManager
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.button
import org.jetbrains.anko.editText
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

val __textView = { ctx: Any, str: Any ->
    ctx as ViewManager; str as String
    ctx.textView { text = str }
}

val __button = { ctx: Any, str: Any ->
    ctx as ViewManager; str as String
    ctx.button { text = str }
}

val __editText = { ctx: Any, str: Any ->
    ctx as ViewManager; str as String
    ctx.editText { hint = str }
}

val __verticalLayout = { ctx: Any, f: Any ->
    ctx as AppCompatActivity; f as  (ViewManager) -> (() -> Unit)
    ctx.verticalLayout {
        f(this)()
    }
}

val __onClick = { view: Any, f: Any ->
    view as View; f as ((View) -> (() -> Unit))
    view.onClick {
        f(view)()
    }
}

val __setTextViewText = {view: Any, str: Any ->
    view as TextView; str as String
    view.text = str
}

val __getTextEditText = {view: Any ->
    view as EditText
    view.text.toString()
}