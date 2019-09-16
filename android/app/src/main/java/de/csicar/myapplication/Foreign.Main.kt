package Foreign.Main

import org.jsoup.Jsoup
import org.jsoup.nodes.Element

val lines = { str: Any ->
    str as String
    str.split("<div class=\"multi-col__col\"><h3>").map { it.substring(0, 50) }
}


val parseHtml = { str: Any ->
    str as String
    Jsoup.parse(str).body()
}

val __htmlSelect = { element: Any, selector: Any ->
    element as Element; selector as String
    element.select(selector)
}

val textContent = { element: Any ->
    element as Element
    element.text()
}

val __nextSibling = { element: Any, just: Any, nothing: Any ->
    element as Element; just as (Any) -> Any
    val s = element.nextElementSibling()
    if (s == null) {
        nothing
    } else {
        just(s)
    }
}

val __attr = { attrName: Any, element: Any ->
    element as Element; attrName as String
    element.attr(attrName)
}