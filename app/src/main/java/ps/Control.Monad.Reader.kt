@file:Suppress("UNCHECKED_CAST")

package PS.Control.Monad.Reader
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val withReader = PS.Control.Monad.Reader.Trans.Module.withReaderT;
  @JvmField
  val runReader = { v : Any ->
    val m = v;
      PS.Control.Semigroupoid.Module.compose
        .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
        .app(PS.Data.Newtype.Module.unwrap
               .app(PS.Data.Identity.Module.newtypeIdentity))
        .app(m);};
  @JvmField
  val mapReader = { f : Any ->
     PS.Data.Function.Module.apply
       .app(PS.Control.Monad.Reader.Trans.Module.mapReaderT)
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Data.Identity.Module.Identity)
              .app(PS.Control.Semigroupoid.Module.compose
                     .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                     .app(f)
                     .app(PS.Data.Newtype.Module.unwrap
                            .app(PS.Data.Identity.Module.newtypeIdentity))))
  };
}