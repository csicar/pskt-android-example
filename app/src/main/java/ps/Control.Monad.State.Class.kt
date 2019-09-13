@file:Suppress("UNCHECKED_CAST")

package PS.Control.Monad.State.Class
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val MonadState = { Monad0 : Any ->
     { state : Any ->
       mapOf(("Monad0" to Monad0),  ("state" to state))
    }
  };
  @JvmField val state = { dict : Any -> (dict as Map<String, Any>)["state"]!!};
  @JvmField
  val put = { dictMonadState : Any ->
     { s : Any ->
       PS.Control.Monad.State.Class.Module.state.app(dictMonadState)
         .app({ v : Any ->
           PS.Data.Tuple.Module.Tuple.app(PS.Data.Unit.Module.unit).app(s)
        })
    }
  };
  @JvmField
  val modify_ = { dictMonadState : Any ->
     { f : Any ->
       PS.Control.Monad.State.Class.Module.state.app(dictMonadState)
         .app({ s : Any ->
           PS.Data.Tuple.Module.Tuple.app(PS.Data.Unit.Module.unit)
             .app(f.app(s))
        })
    }
  };
  @JvmField
  val modify = { dictMonadState : Any ->
     { f : Any ->
       PS.Control.Monad.State.Class.Module.state.app(dictMonadState)
         .app({ s : Any ->
           object   {
               val s_tick = f.app(s);
             }
             .run({
              val s_tick = this.s_tick;
              PS.Data.Tuple.Module.Tuple.app(s_tick).app(s_tick);
            })
        })
    }
  };
  @JvmField
  val gets = { dictMonadState : Any ->
     { f : Any ->
       PS.Control.Monad.State.Class.Module.state.app(dictMonadState)
         .app({ s : Any ->
           PS.Data.Tuple.Module.Tuple.app(f.app(s)).app(s)
        })
    }
  };
  @JvmField
  val _get = { dictMonadState : Any ->
     PS.Control.Monad.State.Class.Module.state.app(dictMonadState)
       .app({ s : Any ->
         PS.Data.Tuple.Module.Tuple.app(s).app(s)
      })
  };
}