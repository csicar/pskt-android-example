@file:Suppress("UNCHECKED_CAST")
package PS.Control.Comonad.Traced
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val traced = PS.Control.Semigroupoid.Module.composeFlipped
                 .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                 .app(PS.Data.Identity.Module.Identity)
                 .app(PS.Control.Comonad.Traced.Trans.Module.TracedT);
  @JvmField
  val runTraced = { v : Any ->
     when {
      else -> {
        val t = v;
        PS.Data.Newtype.Module.unwrap
          .app(PS.Data.Identity.Module.newtypeIdentity)
          .app(t);
      }
    }
  };
}