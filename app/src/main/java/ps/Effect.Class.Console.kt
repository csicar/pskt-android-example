@file:Suppress("UNCHECKED_CAST")
package PS.Effect.Class.Console
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val warnShow = { dictMonadEffect : Any ->
     { dictShow : Any ->
       PS.Control.Semigroupoid.Module.compose
         .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
         .app(PS.Effect.Class.Module.liftEffect.app(dictMonadEffect))
         .app(PS.Effect.Console.Module.warnShow.app(dictShow))
    }
  };
  @JvmField
  val warn = { dictMonadEffect : Any ->
     PS.Control.Semigroupoid.Module.compose
       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
       .app(PS.Effect.Class.Module.liftEffect.app(dictMonadEffect))
       .app(PS.Effect.Console.Module.warn)
  };
  @JvmField
  val timeEnd = { dictMonadEffect : Any ->
     PS.Control.Semigroupoid.Module.compose
       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
       .app(PS.Effect.Class.Module.liftEffect.app(dictMonadEffect))
       .app(PS.Effect.Console.Module.timeEnd)
  };
  @JvmField
  val time = { dictMonadEffect : Any ->
     PS.Control.Semigroupoid.Module.compose
       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
       .app(PS.Effect.Class.Module.liftEffect.app(dictMonadEffect))
       .app(PS.Effect.Console.Module.time)
  };
  @JvmField
  val logShow = { dictMonadEffect : Any ->
     { dictShow : Any ->
       PS.Control.Semigroupoid.Module.compose
         .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
         .app(PS.Effect.Class.Module.liftEffect.app(dictMonadEffect))
         .app(PS.Effect.Console.Module.logShow.app(dictShow))
    }
  };
  @JvmField
  val log = { dictMonadEffect : Any ->
     PS.Control.Semigroupoid.Module.compose
       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
       .app(PS.Effect.Class.Module.liftEffect.app(dictMonadEffect))
       .app(PS.Effect.Console.Module.log)
  };
  @JvmField
  val infoShow = { dictMonadEffect : Any ->
     { dictShow : Any ->
       PS.Control.Semigroupoid.Module.compose
         .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
         .app(PS.Effect.Class.Module.liftEffect.app(dictMonadEffect))
         .app(PS.Effect.Console.Module.infoShow.app(dictShow))
    }
  };
  @JvmField
  val info = { dictMonadEffect : Any ->
     PS.Control.Semigroupoid.Module.compose
       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
       .app(PS.Effect.Class.Module.liftEffect.app(dictMonadEffect))
       .app(PS.Effect.Console.Module.info)
  };
  @JvmField
  val errorShow = { dictMonadEffect : Any ->
     { dictShow : Any ->
       PS.Control.Semigroupoid.Module.compose
         .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
         .app(PS.Effect.Class.Module.liftEffect.app(dictMonadEffect))
         .app(PS.Effect.Console.Module.errorShow.app(dictShow))
    }
  };
  @JvmField
  val error = { dictMonadEffect : Any ->
     PS.Control.Semigroupoid.Module.compose
       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
       .app(PS.Effect.Class.Module.liftEffect.app(dictMonadEffect))
       .app(PS.Effect.Console.Module.error)
  };
}