@file:Suppress("UNCHECKED_CAST")

package PS.Control.Alt
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val Alt = { Functor0 : Any ->
     { alt : Any ->
       mapOf(("Functor0" to Functor0),  ("alt" to alt))
    }
  };
  @JvmField
  val altArray = PS.Control.Alt.Module.Alt
                   .app({ _ : Any ->
                        PS.Data.Functor.Module.functorArray
                     })
                   .app(PS.Data.Semigroup.Module.append
                          .app(PS.Data.Semigroup.Module.semigroupArray));
  @JvmField val alt = { dict : Any -> (dict as Map<String, Any>)["alt"]!!};
}