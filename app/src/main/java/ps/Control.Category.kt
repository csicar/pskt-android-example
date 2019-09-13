@file:Suppress("UNCHECKED_CAST")

package PS.Control.Category
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val Category = { Semigroupoid0 : Any ->
     { identity : Any ->
       mapOf(("Semigroupoid0" to Semigroupoid0),  ("identity" to identity))
    }
  };
  @JvmField
  val identity = { dict : Any ->
     (dict as Map<String, Any>)["identity"]!!
  };
  @JvmField
  val categoryFn = PS.Control.Category.Module.Category
                     .app({ _ : Any ->
                          PS.Control.Semigroupoid.Module.semigroupoidFn
                       })
                     .app({ x : Any ->
       x
    });
}