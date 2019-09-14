package Foreign.Main

val lines = {str : Any ->
    str as String
    str.split("<div class=\"multi-col__col\"><h3>").map {it.substring(0, 50)}
}

