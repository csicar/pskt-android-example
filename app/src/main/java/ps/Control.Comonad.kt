@file:Suppress("UNCHECKED_CAST")
package PS.Control.Comonad
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val Comonad = { Extend0 : Any ->
     { extract : Any ->
       mapOf(("Extend0" to Extend0),  ("extract" to extract))
    }
  };
  @JvmField
  val extract = { dict : Any ->
     (dict as Map<String, Any>)["extract"]!!
  };
}