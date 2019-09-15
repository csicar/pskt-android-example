package Foreign.Main

import org.jsoup.Jsoup
import org.jsoup.nodes.Element

val lines = { str: Any ->
    str as String
    str.split("<div class=\"multi-col__col\"><h3>").map { it.substring(0, 50) }
}


val parseHtml = { str: Any ->
    { ctor: Any ->
        str as String; ctor as ((String) -> ((String) -> ((String) -> Any)))
        val html = Jsoup.parse(str)
        val results = html.select(".result")
        results.map {
            ctor(
                it.select(".result__title").text())(
                (it.nextSibling().nextSibling() as Element).select("result__actions__item").text())(
                it.select(".result__link").attr("href"))
        }.toList()
    }
}