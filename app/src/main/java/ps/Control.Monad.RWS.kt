@file:Suppress("UNCHECKED_CAST")

package PS.Control.Monad.RWS
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val withRWS = PS.Control.Monad.RWS.Trans.Module.withRWST;
  @JvmField
  val rws = { f : Any ->
     PS.Control.Monad.RWS.Trans.Module.RWST
       .app({ r : Any ->
         { s : Any ->
           PS.Data.Function.Module.apply
             .app(PS.Control.Applicative.Module.pure
                    .app(PS.Data.Identity.Module.applicativeIdentity))
             .app(f.app(r).app(s))
        }
      })
  };
  @JvmField
  val runRWS = { m : Any ->
     { r : Any ->
       { s : Any ->
        val f = m;
          object   {
              val v = f.app(r).app(s);
            }
            .run({
              val v = this.v;
              val x = v;
              x;
            });}
    }
  };
  @JvmField
  val mapRWS = { f : Any ->
     PS.Control.Monad.RWS.Trans.Module.mapRWST
       .app(PS.Control.Semigroupoid.Module.composeFlipped
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Data.Newtype.Module.unwrap
                     .app(PS.Data.Identity.Module.newtypeIdentity))
              .app(PS.Control.Semigroupoid.Module.composeFlipped
                     .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                     .app(f)
                     .app(PS.Data.Identity.Module.Identity)))
  };
  @JvmField
  val execRWS = { m : Any ->
     { r : Any ->
       { s : Any ->
         PS.Data.Function.Module.apply
           .app(PS.Data.Newtype.Module.unwrap
                  .app(PS.Data.Identity.Module.newtypeIdentity))
           .app(PS.Control.Monad.RWS.Trans.Module.execRWST
                  .app(PS.Data.Identity.Module.monadIdentity)
                  .app(m)
                  .app(r)
                  .app(s))
      }
    }
  };
  @JvmField
  val evalRWS = { m : Any ->
     { r : Any ->
       { s : Any ->
         PS.Data.Function.Module.apply
           .app(PS.Data.Newtype.Module.unwrap
                  .app(PS.Data.Identity.Module.newtypeIdentity))
           .app(PS.Control.Monad.RWS.Trans.Module.evalRWST
                  .app(PS.Data.Identity.Module.monadIdentity)
                  .app(m)
                  .app(r)
                  .app(s))
      }
    }
  };
}