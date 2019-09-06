@file:Suppress("UNCHECKED_CAST")
package PS.Control.Monad.Error.Class
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val MonadThrow = { Monad0 : Any ->
     { throwError : Any ->
       mapOf(("Monad0" to Monad0),  ("throwError" to throwError))
    }
  };
  @JvmField
  val MonadError = { MonadThrow0 : Any ->
     { catchError : Any ->
       mapOf(("MonadThrow0" to MonadThrow0),  ("catchError" to catchError))
    }
  };
  @JvmField
  val throwError = { dict : Any ->
     (dict as Map<String, Any>)["throwError"]!!
  };
  @JvmField
  val monadThrowMaybe = PS.Control.Monad.Error.Class.Module.MonadThrow
                          .app({ _ : Any ->
                               PS.Data.Maybe.Module.monadMaybe
                            })
                          .app(PS.Data.Function.Module._const
                                 .app(PS.Data.Maybe.Module.Nothing));
  @JvmField
  val monadThrowEither = PS.Control.Monad.Error.Class.Module.MonadThrow
                           .app({ _ : Any ->
                                PS.Data.Either.Module.monadEither
                             })
                           .app(PS.Data.Either.Module.Left);
  @JvmField
  val monadThrowEffect = PS.Control.Monad.Error.Class.Module.MonadThrow
                           .app({ _ : Any ->
                                PS.Effect.Module.monadEffect
                             })
                           .app(PS.Effect.Exception.Module.throwException);
  @JvmField
  val monadErrorMaybe = PS.Control.Monad.Error.Class.Module.MonadError
                          .app({ _ : Any ->
                               PS.Control.Monad.Error.Class.Module.monadThrowMaybe
                            })
                          .app({ v : Any ->
       { v1 : Any ->
         when {
          (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
            val f = v1;
            f.app(PS.Data.Unit.Module.unit);
          }
          (v is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
            val a = v.value0;
            PS.Data.Maybe.Module.Just.app(a);
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val monadErrorEither = PS.Control.Monad.Error.Class.Module.MonadError
                           .app({ _ : Any ->
                                PS.Control.Monad.Error.Class.Module.monadThrowEither
                             })
                           .app({ v : Any ->
       { v1 : Any ->
         when {
          (v is PS.Data.Either.Module._Type_Either.Left) -> {
            val e = v.value0;
            val h = v1;
            h.app(e);
          }
          (v is PS.Data.Either.Module._Type_Either.Right) -> {
            val x = v.value0;
            PS.Data.Either.Module.Right.app(x);
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val monadErrorEffect = PS.Control.Monad.Error.Class.Module.MonadError
                           .app({ _ : Any ->
                                PS.Control.Monad.Error.Class.Module.monadThrowEffect
                             })
                           .app(PS.Data.Function.Module.flip
                                  .app(PS.Effect.Exception.Module.catchException
    ));
  @JvmField
  val catchError = { dict : Any ->
     (dict as Map<String, Any>)["catchError"]!!
  };
  @JvmField
  val catchJust = { dictMonadError : Any ->
     { p : Any ->
       { act : Any ->
         { handler : Any ->
           object   {
               val handle = { e : Any ->
                  object   {
                      val v = p.app(e);
                    }
                    .run({
                     val v = this.v;
                     when {
                       (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                         PS.Control.Monad.Error.Class.Module.throwError
                           .app(
                             (dictMonadError as Map<String, Any>)["MonadThrow0"]!!
                               .app(Unit))
                           .app(e);
                       }
                       (v is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
                         val b = v.value0;
                         handler.app(b);
                       }
                       else -> (error("Error in Pattern Match") as Any)
                     };
                   })
               };
             }
             .run({
              val handle = this.handle;
              PS.Control.Monad.Error.Class.Module.catchError.app(dictMonadError)
                .app(act)
                .app(handle);
            })
        }
      }
    }
  };
  @JvmField
  val _try = { dictMonadError : Any ->
     { a : Any ->
       PS.Control.Monad.Error.Class.Module.catchError.app(dictMonadError)
         .app(PS.Data.Functor.Module.map
                .app((((((dictMonadError as Map<String, Any>)["MonadThrow0"]!!
                           .app(Unit) as Map<String, Any>)["Monad0"]!!
                          .app(Unit) as Map<String, Any>)["Bind1"]!!
                         .app(Unit) as Map<String, Any>)["Apply0"]!!
                        .app(Unit) as Map<String, Any>)["Functor0"]!!
                       .app(Unit))
                .app(PS.Data.Either.Module.Right)
                .app(a))
         .app(PS.Control.Semigroupoid.Module.compose
                .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                .app(PS.Control.Applicative.Module.pure
                       .app(
                    (((dictMonadError as Map<String, Any>)["MonadThrow0"]!!
                        .app(Unit) as Map<String, Any>)["Monad0"]!!
                       .app(Unit) as Map<String, Any>)["Applicative0"]!!
                      .app(Unit)))
                .app(PS.Data.Either.Module.Left))
    }
  };
  @JvmField
  val withResource = { dictMonadError : Any ->
     { acquire : Any ->
       { release : Any ->
         { kleisli : Any ->
           PS.Control.Bind.Module.bind
             .app((((dictMonadError as Map<String, Any>)["MonadThrow0"]!!
                      .app(Unit) as Map<String, Any>)["Monad0"]!!
                     .app(Unit) as Map<String, Any>)["Bind1"]!!
                    .app(Unit))
             .app(acquire)
             .app({ v : Any ->
               when {
                else -> {
                  val resource = v;
                  PS.Control.Bind.Module.bind
                    .app((((dictMonadError as Map<String, Any>)["MonadThrow0"]!!
                             .app(Unit) as Map<String, Any>)["Monad0"]!!
                            .app(Unit) as Map<String, Any>)["Bind1"]!!
                           .app(Unit))
                    .app(PS.Data.Function.Module.apply
                           .app(PS.Control.Monad.Error.Class.Module._try
                                  .app(dictMonadError))
                           .app(kleisli.app(resource)))
                    .app({ v1 : Any ->
                       when {
                        else -> {
                          val result = v1;
                          PS.Control.Bind.Module.discard
                            .app(PS.Control.Bind.Module.discardUnit)
                            .app(
                              (((dictMonadError as Map<String, Any>)["MonadThrow0"]!!
                                  .app(Unit) as Map<String, Any>)["Monad0"]!!
                                 .app(Unit) as Map<String, Any>)["Bind1"]!!
                                .app(Unit))
                            .app(release.app(resource))
                            .app({ _ : Any ->
                               PS.Data.Either.Module.either
                                 .app(
                                   PS.Control.Monad.Error.Class.Module.throwError
                                     .app(
                                     (dictMonadError as Map<String, Any>)["MonadThrow0"]!!
                                       .app(Unit)))
                                 .app(PS.Control.Applicative.Module.pure
                                        .app(
                                     (((dictMonadError as Map<String, Any>)["MonadThrow0"]!!
                                         .app(Unit
                                        ) as Map<String, Any>)["Monad0"]!!
                                        .app(Unit
                                       ) as Map<String, Any>)["Applicative0"]!!
                                       .app(Unit)))
                                 .app(result)
                            });
                        }
                      }
                    });
                }
              }
            })
        }
      }
    }
  };
}