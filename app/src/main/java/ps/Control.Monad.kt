@file:Suppress("UNCHECKED_CAST")

package PS.Control.Monad
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val Monad = { Applicative0 : Any ->
     { Bind1 : Any ->
       mapOf(("Applicative0" to Applicative0),  ("Bind1" to Bind1))
    }
  };
  @JvmField
  val whenM = { dictMonad : Any ->
     { mb : Any ->
       { m : Any ->
         PS.Control.Bind.Module.bind
           .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
           .app(mb)
           .app({ v : Any ->
            val b = v;
              PS.Control.Applicative.Module._when
                .app((dictMonad as Map<String, Any>)["Applicative0"]!!.app(Unit)
                )
                .app(b)
                .app(m);})
      }
    }
  };
  @JvmField
  val unlessM = { dictMonad : Any ->
     { mb : Any ->
       { m : Any ->
         PS.Control.Bind.Module.bind
           .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
           .app(mb)
           .app({ v : Any ->
            val b = v;
              PS.Control.Applicative.Module.unless
                .app((dictMonad as Map<String, Any>)["Applicative0"]!!.app(Unit)
                )
                .app(b)
                .app(m);})
      }
    }
  };
  @JvmField
  val monadFn = PS.Control.Monad.Module.Monad
                  .app({ _ : Any ->
                       PS.Control.Applicative.Module.applicativeFn
                    })
                  .app({ _ : Any ->
       PS.Control.Bind.Module.bindFn
    });
  @JvmField
  val monadArray = PS.Control.Monad.Module.Monad
                     .app({ _ : Any ->
                          PS.Control.Applicative.Module.applicativeArray
                       })
                     .app({ _ : Any ->
       PS.Control.Bind.Module.bindArray
    });
  @JvmField
  val liftM1 = { dictMonad : Any ->
     { f : Any ->
       { a : Any ->
         PS.Control.Bind.Module.bind
           .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
           .app(a)
           .app({ v : Any ->
            val a_tick = v;
              PS.Control.Applicative.Module.pure
                .app((dictMonad as Map<String, Any>)["Applicative0"]!!.app(Unit)
                )
                .app(f.app(a_tick));})
      }
    }
  };
  @JvmField
  val ap = { dictMonad : Any ->
     { f : Any ->
       { a : Any ->
         PS.Control.Bind.Module.bind
           .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
           .app(f)
           .app({ v : Any ->
            val f_tick = v;
              PS.Control.Bind.Module.bind
                .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
                .app(a)
                .app({ v1 : Any ->
                  val a_tick = v1;
                    PS.Control.Applicative.Module.pure
                      .app((dictMonad as Map<String, Any>)["Applicative0"]!!
                             .app(Unit))
                      .app(f_tick.app(a_tick));});})
      }
    }
  };
}