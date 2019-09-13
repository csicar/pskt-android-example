@file:Suppress("UNCHECKED_CAST")

package PS.Type.Equality
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val TypeEquals = { from : Any ->
     { to : Any ->
       mapOf(("from" to from),  ("to" to to))
    }
  };
  @JvmField val to = { dict : Any -> (dict as Map<String, Any>)["to"]!!};
  @JvmField
  val refl = PS.Type.Equality.Module.TypeEquals.app({ a : Any -> a})
               .app({ a : Any ->
       a
    });
  @JvmField val from = { dict : Any -> (dict as Map<String, Any>)["from"]!!};
}