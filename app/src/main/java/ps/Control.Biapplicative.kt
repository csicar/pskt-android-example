@file:Suppress("UNCHECKED_CAST")
package PS.Control.Biapplicative
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val Biapplicative = { Biapply0 : Any ->
     { bipure : Any ->
       mapOf(("Biapply0" to Biapply0),  ("bipure" to bipure))
    }
  };
  @JvmField
  val bipure = { dict : Any ->
     (dict as Map<String, Any>)["bipure"]!!
  };
}