@file:Suppress("UNCHECKED_CAST")

package PS.Control.Plus
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val Plus = { Alt0 : Any ->
     { empty : Any ->
       mapOf(("Alt0" to Alt0),  ("empty" to empty))
    }
  };
  @JvmField
  val plusArray = PS.Control.Plus.Module.Plus
                    .app({ _ : Any ->
                         PS.Control.Alt.Module.altArray
                      })
                    .app(emptyList<Any>());
  @JvmField val empty = { dict : Any -> (dict as Map<String, Any>)["empty"]!!};
}