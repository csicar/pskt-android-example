@file:Suppress("UNCHECKED_CAST")
package PS.Control.Monad.Except
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val withExcept = PS.Control.Monad.Except.Trans.Module.withExceptT
                     .app(PS.Data.Identity.Module.functorIdentity);
  @JvmField
  val runExcept = PS.Control.Semigroupoid.Module.compose
                    .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                    .app(PS.Data.Newtype.Module.unwrap
                           .app(PS.Data.Identity.Module.newtypeIdentity))
                    .app(PS.Control.Monad.Except.Trans.Module.runExceptT);
  @JvmField
  val mapExcept = { f : Any ->
     PS.Control.Monad.Except.Trans.Module.mapExceptT
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