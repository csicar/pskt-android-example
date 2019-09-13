@file:Suppress("UNCHECKED_CAST")

package PS.Control.Monad.Cont
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val withCont = { f : Any ->
     PS.Control.Monad.Cont.Trans.Module.withContT
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Control.Semigroupoid.Module.compose
                     .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                     .app(PS.Data.Identity.Module.Identity))
              .app(PS.Control.Semigroupoid.Module.compose
                     .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                     .app(f)
                     .app(PS.Control.Semigroupoid.Module.compose
                            .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                            .app(PS.Data.Newtype.Module.unwrap
                                   .app(PS.Data.Identity.Module.newtypeIdentity)
          ))))
  };
  @JvmField
  val runCont = { cc : Any ->
     { k : Any ->
       PS.Data.Newtype.Module.unwrap
         .app(PS.Data.Identity.Module.newtypeIdentity)
         .app(PS.Control.Monad.Cont.Trans.Module.runContT.app(cc)
                .app(PS.Control.Semigroupoid.Module.compose
                       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                       .app(PS.Data.Identity.Module.Identity)
                       .app(k)))
    }
  };
  @JvmField
  val mapCont = { f : Any ->
     PS.Control.Monad.Cont.Trans.Module.mapContT
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Data.Identity.Module.Identity)
              .app(PS.Control.Semigroupoid.Module.compose
                     .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                     .app(f)
                     .app(PS.Data.Newtype.Module.unwrap
                            .app(PS.Data.Identity.Module.newtypeIdentity))))
  };
  @JvmField
  val cont = { f : Any ->
     PS.Control.Monad.Cont.Trans.Module.ContT
       .app({ c : Any ->
         PS.Data.Identity.Module.Identity
           .app(f
                  .app(PS.Control.Semigroupoid.Module.compose
                         .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                         .app(PS.Data.Newtype.Module.unwrap
                                .app(PS.Data.Identity.Module.newtypeIdentity))
                         .app(c)))
      })
  };
}