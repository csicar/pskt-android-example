@file:Suppress("UNCHECKED_CAST")

package PS.Effect.Aff.Class
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val MonadAff = { MonadEffect0 : Any ->
     { liftAff : Any ->
       mapOf(("MonadEffect0" to MonadEffect0),  ("liftAff" to liftAff))
    }
  };
  @JvmField
  val monadAffAff = PS.Effect.Aff.Class.Module.MonadAff
                      .app({ _ : Any ->
                           PS.Effect.Aff.Module.monadEffectAff
                        })
                      .app(PS.Control.Category.Module.identity
                             .app(PS.Control.Category.Module.categoryFn));
  @JvmField
  val liftAff = { dict : Any ->
     (dict as Map<String, Any>)["liftAff"]!!
  };
  @JvmField
  val monadAffContT = { dictMonadAff : Any ->
     PS.Effect.Aff.Class.Module.MonadAff
       .app({ _ : Any ->
            PS.Control.Monad.Cont.Trans.Module.monadEffectContT
              .app((dictMonadAff as Map<String, Any>)["MonadEffect0"]!!
                     .app(Unit))
         })
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Control.Monad.Trans.Class.Module.lift
                     .app(PS.Control.Monad.Cont.Trans.Module.monadTransContT)
                     .app(((dictMonadAff as Map<String, Any>)["MonadEffect0"]!!
                             .app(Unit) as Map<String, Any>)["Monad0"]!!
                            .app(Unit)))
              .app(PS.Effect.Aff.Class.Module.liftAff.app(dictMonadAff)))
  };
  @JvmField
  val monadAffExceptT = { dictMonadAff : Any ->
     PS.Effect.Aff.Class.Module.MonadAff
       .app({ _ : Any ->
            PS.Control.Monad.Except.Trans.Module.monadEffectExceptT
              .app((dictMonadAff as Map<String, Any>)["MonadEffect0"]!!
                     .app(Unit))
         })
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Control.Monad.Trans.Class.Module.lift
                     .app(PS.Control.Monad.Except.Trans.Module.monadTransExceptT
                     )
                     .app(((dictMonadAff as Map<String, Any>)["MonadEffect0"]!!
                             .app(Unit) as Map<String, Any>)["Monad0"]!!
                            .app(Unit)))
              .app(PS.Effect.Aff.Class.Module.liftAff.app(dictMonadAff)))
  };
  @JvmField
  val monadAffListT = { dictMonadAff : Any ->
     PS.Effect.Aff.Class.Module.MonadAff
       .app({ _ : Any ->
            PS.Control.Monad.List.Trans.Module.monadEffectListT
              .app((dictMonadAff as Map<String, Any>)["MonadEffect0"]!!
                     .app(Unit))
         })
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Control.Monad.Trans.Class.Module.lift
                     .app(PS.Control.Monad.List.Trans.Module.monadTransListT)
                     .app(((dictMonadAff as Map<String, Any>)["MonadEffect0"]!!
                             .app(Unit) as Map<String, Any>)["Monad0"]!!
                            .app(Unit)))
              .app(PS.Effect.Aff.Class.Module.liftAff.app(dictMonadAff)))
  };
  @JvmField
  val monadAffMaybe = { dictMonadAff : Any ->
     PS.Effect.Aff.Class.Module.MonadAff
       .app({ _ : Any ->
            PS.Control.Monad.Maybe.Trans.Module.monadEffectMaybe
              .app((dictMonadAff as Map<String, Any>)["MonadEffect0"]!!
                     .app(Unit))
         })
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Control.Monad.Trans.Class.Module.lift
                     .app(PS.Control.Monad.Maybe.Trans.Module.monadTransMaybeT)
                     .app(((dictMonadAff as Map<String, Any>)["MonadEffect0"]!!
                             .app(Unit) as Map<String, Any>)["Monad0"]!!
                            .app(Unit)))
              .app(PS.Effect.Aff.Class.Module.liftAff.app(dictMonadAff)))
  };
  @JvmField
  val monadAffRWS = { dictMonadAff : Any ->
     { dictMonoid : Any ->
       PS.Effect.Aff.Class.Module.MonadAff
         .app({ _ : Any ->
              PS.Control.Monad.RWS.Trans.Module.monadEffectRWS.app(dictMonoid)
                .app((dictMonadAff as Map<String, Any>)["MonadEffect0"]!!
                       .app(Unit))
           })
         .app(PS.Control.Semigroupoid.Module.compose
                .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                .app(PS.Control.Monad.Trans.Class.Module.lift
                       .app(PS.Control.Monad.RWS.Trans.Module.monadTransRWST
                              .app(dictMonoid))
                       .app(
                    ((dictMonadAff as Map<String, Any>)["MonadEffect0"]!!
                       .app(Unit) as Map<String, Any>)["Monad0"]!!
                      .app(Unit)))
                .app(PS.Effect.Aff.Class.Module.liftAff.app(dictMonadAff)))
    }
  };
  @JvmField
  val monadAffReader = { dictMonadAff : Any ->
     PS.Effect.Aff.Class.Module.MonadAff
       .app({ _ : Any ->
            PS.Control.Monad.Reader.Trans.Module.monadEffectReader
              .app((dictMonadAff as Map<String, Any>)["MonadEffect0"]!!
                     .app(Unit))
         })
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Control.Monad.Trans.Class.Module.lift
                     .app(PS.Control.Monad.Reader.Trans.Module.monadTransReaderT
                     )
                     .app(((dictMonadAff as Map<String, Any>)["MonadEffect0"]!!
                             .app(Unit) as Map<String, Any>)["Monad0"]!!
                            .app(Unit)))
              .app(PS.Effect.Aff.Class.Module.liftAff.app(dictMonadAff)))
  };
  @JvmField
  val monadAffState = { dictMonadAff : Any ->
     PS.Effect.Aff.Class.Module.MonadAff
       .app({ _ : Any ->
            PS.Control.Monad.State.Trans.Module.monadEffectState
              .app((dictMonadAff as Map<String, Any>)["MonadEffect0"]!!
                     .app(Unit))
         })
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Control.Monad.Trans.Class.Module.lift
                     .app(PS.Control.Monad.State.Trans.Module.monadTransStateT)
                     .app(((dictMonadAff as Map<String, Any>)["MonadEffect0"]!!
                             .app(Unit) as Map<String, Any>)["Monad0"]!!
                            .app(Unit)))
              .app(PS.Effect.Aff.Class.Module.liftAff.app(dictMonadAff)))
  };
  @JvmField
  val monadAffWriter = { dictMonadAff : Any ->
     { dictMonoid : Any ->
       PS.Effect.Aff.Class.Module.MonadAff
         .app({ _ : Any ->
              PS.Control.Monad.Writer.Trans.Module.monadEffectWriter
                .app(dictMonoid)
                .app((dictMonadAff as Map<String, Any>)["MonadEffect0"]!!
                       .app(Unit))
           })
         .app(PS.Control.Semigroupoid.Module.compose
                .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                .app(PS.Control.Monad.Trans.Class.Module.lift
                       .app(
                         PS.Control.Monad.Writer.Trans.Module.monadTransWriterT
                           .app(dictMonoid))
                       .app(
                    ((dictMonadAff as Map<String, Any>)["MonadEffect0"]!!
                       .app(Unit) as Map<String, Any>)["Monad0"]!!
                      .app(Unit)))
                .app(PS.Effect.Aff.Class.Module.liftAff.app(dictMonadAff)))
    }
  };
}