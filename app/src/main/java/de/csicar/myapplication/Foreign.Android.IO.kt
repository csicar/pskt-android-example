package Foreign.Android.IO

import Foreign.PsRuntime.appRun
import android.app.Activity
import android.content.Context
import android.os.AsyncTask
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import org.jetbrains.anko.sdk27.coroutines.onClick
import java.net.HttpURLConnection
import java.net.URL
import java.io.*



class HttpGetTask(val onSuccess: (String) -> (() -> Unit)) : AsyncTask<URL, Void, String>() {
    override fun doInBackground(vararg url: URL): String {
        val urlConnection = url.first().openConnection() as HttpURLConnection
        try {
            return getStringFromInputStream(urlConnection.inputStream)
            return urlConnection.responseMessage
        } finally {
            urlConnection.disconnect()
        }
    }

    override fun onPostExecute(result: String) {
        onSuccess(result).appRun()
    }

    fun getStringFromInputStream(stream: InputStream): String {
        val sb = StringBuilder()
        var line: String?
        val br = BufferedReader(InputStreamReader(stream))
        line = br.readLine()
        while (line != null) {
            sb.append(line)
            line = br.readLine()
        }
        br.close()
        return sb.toString()
    }
}

val __httpGet = { ctx: Any, urlStr: Any, onSucc: Any ->
    ctx as Context; urlStr as String; onSucc as (String) -> (() -> Unit)
    val url = URL(urlStr)
    HttpGetTask(onSucc).execute(url)
    Unit
}