package Foreign.Android.IO

import Foreign.PsRuntime.appRun
import android.content.Context
import android.os.AsyncTask
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


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