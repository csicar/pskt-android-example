@file:Suppress("UNCHECKED_CAST")
package PS.Data.Map
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val keys = PS.Control.Semigroupoid.Module.compose
               .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
               .app(PS.Unsafe.Coerce.Module.unsafeCoerce)
               .app(PS.Data.Functor.Module.void
                      .app(PS.Data.Map.Internal.Module.functorMap));
}