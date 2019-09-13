package Foreign.Data.Enum

val toCharCode = {c: Any ->
  c as String
  Character.codePointAt(c, 0)
}

val fromCharCode = {c: Any ->
  c as Int
  Character(c.toChar()).toString()
}