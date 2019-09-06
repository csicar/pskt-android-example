@file:Suppress("UNCHECKED_CAST")
package PS.Control.Parallel.Class
import Foreign.PsRuntime.app
object Module  {
  @JvmField val ParCont = { x : Any -> x};
  @JvmField
  val Parallel = { Applicative1 : Any ->
     { Monad0 : Any ->
       { parallel : Any ->
         { sequential : Any ->
           mapOf(("Applicative1" to Applicative1),  ("Monad0" to Monad0),  
            ("parallel" to parallel),  ("sequential" to sequential))
        }
      }
    }
  };
  @JvmField
  val sequential = { dict : Any ->
     (dict as Map<String, Any>)["sequential"]!!
  };
  @JvmField
  val parallel = { dict : Any ->
     (dict as Map<String, Any>)["parallel"]!!
  };
  @JvmField
  val newtypeParCont = PS.Data.Newtype.Module.Newtype
                         .app({ n : Any ->
                              when {
                               else -> {
                                 val a = n;
                                 a;
                               }
                             }
                           })
                         .app(PS.Control.Parallel.Class.Module.ParCont);
  @JvmField
  val monadParWriterT = { dictMonoid : Any ->
     { dictParallel : Any ->
       PS.Control.Parallel.Class.Module.Parallel
         .app({ _ : Any ->
              PS.Control.Monad.Writer.Trans.Module.applicativeWriterT
                .app(dictMonoid)
                .app((dictParallel as Map<String, Any>)["Applicative1"]!!
                       .app(Unit))
           })
         .app({ _ : Any ->
              PS.Control.Monad.Writer.Trans.Module.monadWriterT.app(dictMonoid)
                .app((dictParallel as Map<String, Any>)["Monad0"]!!.app(Unit))
           })
         .app(PS.Control.Monad.Writer.Trans.Module.mapWriterT
                .app(PS.Control.Parallel.Class.Module.parallel.app(dictParallel)
           ))
         .app(PS.Control.Monad.Writer.Trans.Module.mapWriterT
                .app(PS.Control.Parallel.Class.Module.sequential
                       .app(dictParallel)))
    }
  };
  @JvmField
  val monadParReaderT = { dictParallel : Any ->
     PS.Control.Parallel.Class.Module.Parallel
       .app({ _ : Any ->
            PS.Control.Monad.Reader.Trans.Module.applicativeReaderT
              .app((dictParallel as Map<String, Any>)["Applicative1"]!!
                     .app(Unit))
         })
       .app({ _ : Any ->
            PS.Control.Monad.Reader.Trans.Module.monadReaderT
              .app((dictParallel as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app(PS.Control.Monad.Reader.Trans.Module.mapReaderT
              .app(PS.Control.Parallel.Class.Module.parallel.app(dictParallel)))
       .app(PS.Control.Monad.Reader.Trans.Module.mapReaderT
              .app(PS.Control.Parallel.Class.Module.sequential.app(dictParallel)
      ))
  };
  @JvmField
  val monadParMaybeT = { dictParallel : Any ->
     PS.Control.Parallel.Class.Module.Parallel
       .app({ _ : Any ->
            PS.Data.Functor.Compose.Module.applicativeCompose
              .app((dictParallel as Map<String, Any>)["Applicative1"]!!
                     .app(Unit))
              .app(PS.Data.Maybe.Module.applicativeMaybe)
         })
       .app({ _ : Any ->
            PS.Control.Monad.Maybe.Trans.Module.monadMaybeT
              .app((dictParallel as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app({ v : Any ->
            when {
             else -> {
               val ma = v;
               PS.Data.Functor.Compose.Module.Compose
                 .app(PS.Control.Parallel.Class.Module.parallel
                        .app(dictParallel)
                        .app(ma));
             }
           }
         })
       .app({ v : Any ->
         when {
          else -> {
            val fa = v;
            PS.Control.Monad.Maybe.Trans.Module.MaybeT
              .app(PS.Control.Parallel.Class.Module.sequential.app(dictParallel)
                     .app(fa));
          }
        }
      })
  };
  @JvmField
  val monadParExceptT = { dictParallel : Any ->
     PS.Control.Parallel.Class.Module.Parallel
       .app({ _ : Any ->
            PS.Data.Functor.Compose.Module.applicativeCompose
              .app((dictParallel as Map<String, Any>)["Applicative1"]!!
                     .app(Unit))
              .app(PS.Data.Either.Module.applicativeEither)
         })
       .app({ _ : Any ->
            PS.Control.Monad.Except.Trans.Module.monadExceptT
              .app((dictParallel as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app({ v : Any ->
            when {
             else -> {
               val ma = v;
               PS.Data.Functor.Compose.Module.Compose
                 .app(PS.Control.Parallel.Class.Module.parallel
                        .app(dictParallel)
                        .app(ma));
             }
           }
         })
       .app({ v : Any ->
         when {
          else -> {
            val fa = v;
            PS.Control.Monad.Except.Trans.Module.ExceptT
              .app(PS.Control.Parallel.Class.Module.sequential.app(dictParallel)
                     .app(fa));
          }
        }
      })
  };
  @JvmField val monadParParCont = (::__rec_monadParParCont)();
  @JvmField val functorParCont = (::__rec_functorParCont)();
  @JvmField val applyParCont = (::__rec_applyParCont)();
  @JvmField val applicativeParCont = (::__rec_applicativeParCont)();
  fun __rec_monadParParCont(): Any = { dictMonadEffect : Any ->
     PS.Control.Parallel.Class.Module.Parallel
       .app({ _ : Any ->
            PS.Control.Parallel.Class.Module.applicativeParCont
              .app(dictMonadEffect)
         })
       .app({ _ : Any ->
            PS.Control.Monad.Cont.Trans.Module.monadContT
              .app((dictMonadEffect as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app(PS.Control.Parallel.Class.Module.ParCont)
       .app({ v : Any ->
         when {
          else -> {
            val ma = v;
            ma;
          }
        }
      })
  };
  fun __rec_functorParCont(): Any = { dictMonadEffect : Any ->
     PS.Data.Functor.Module.Functor
       .app({ f : Any ->
         PS.Control.Semigroupoid.Module.compose
           .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
           .app(PS.Control.Parallel.Class.Module.parallel
                  .app(PS.Control.Parallel.Class.Module.monadParParCont
                         .app(dictMonadEffect)))
           .app(PS.Control.Semigroupoid.Module.compose
                  .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                  .app(PS.Data.Functor.Module.map
                         .app(PS.Control.Monad.Cont.Trans.Module.functorContT
                                .app(
                             ((((dictMonadEffect as Map<String, Any>)["Monad0"]!!
                                  .app(Unit) as Map<String, Any>)["Bind1"]!!
                                 .app(Unit) as Map<String, Any>)["Apply0"]!!
                                .app(Unit) as Map<String, Any>)["Functor0"]!!
                               .app(Unit)))
                         .app(f))
                  .app(PS.Control.Parallel.Class.Module.sequential
                         .app(PS.Control.Parallel.Class.Module.monadParParCont
                                .app(dictMonadEffect))))
      })
  };
  fun __rec_applyParCont(): Any = { dictMonadEffect : Any ->
     PS.Control.Apply.Module.Apply
       .app({ _ : Any ->
            PS.Control.Parallel.Class.Module.functorParCont.app(dictMonadEffect)
         })
       .app({ v : Any ->
         { v1 : Any ->
           when {
            else -> {
              val ca = v;
              val cb = v1;
              PS.Data.Function.Module.apply
                .app(PS.Control.Parallel.Class.Module.ParCont)
                .app(PS.Control.Monad.Cont.Trans.Module.ContT
                       .app({ k : Any ->
                     PS.Control.Bind.Module.bind
                       .app(((dictMonadEffect as Map<String, Any>)["Monad0"]!!
                               .app(Unit) as Map<String, Any>)["Bind1"]!!
                              .app(Unit))
                       .app(PS.Effect.Class.Module.liftEffect
                              .app(dictMonadEffect)
                              .app(PS.Effect.Ref.Module.new
                                     .app(PS.Data.Maybe.Module.Nothing)))
                       .app({ v2 : Any ->
                         when {
                          else -> {
                            val ra = v2;
                            PS.Control.Bind.Module.bind
                              .app(
                                ((dictMonadEffect as Map<String, Any>)["Monad0"]!!
                                   .app(Unit) as Map<String, Any>)["Bind1"]!!
                                  .app(Unit))
                              .app(PS.Effect.Class.Module.liftEffect
                                     .app(dictMonadEffect)
                                     .app(PS.Effect.Ref.Module.new
                                            .app(PS.Data.Maybe.Module.Nothing)))
                              .app({ v3 : Any ->
                                 when {
                                  else -> {
                                    val rb = v3;
                                    PS.Control.Bind.Module.discard
                                      .app(PS.Control.Bind.Module.discardUnit)
                                      .app(
                                        ((dictMonadEffect as Map<String, Any>)["Monad0"]!!
                                           .app(Unit
                                          ) as Map<String, Any>)["Bind1"]!!
                                          .app(Unit))
                                      .app(
                                        PS.Control.Monad.Cont.Trans.Module.runContT
                                          .app(ca)
                                          .app({ a : Any ->
                                             PS.Control.Bind.Module.bind
                                               .app(
                                                 ((dictMonadEffect as Map<String, Any>)["Monad0"]!!
                                                    .app(Unit
                                                   ) as Map<String, Any>)["Bind1"]!!
                                                   .app(Unit))
                                               .app(
                                                 PS.Effect.Class.Module.liftEffect
                                                   .app(dictMonadEffect)
                                                   .app(
                                                   PS.Effect.Ref.Module.read
                                                     .app(rb)))
                                               .app({ v4 : Any ->
                                                 when {
                                                  else -> {
                                                    val mb = v4;
                                                    when {
                                                      (mb is PS.Data.Maybe.Module._Type_Maybe
                                                               .Nothing) -> {
                                                        PS.Effect.Class.Module.liftEffect
                                                          .app(dictMonadEffect)
                                                          .app(
                                                          PS.Effect.Ref.Module.write
                                                            .app(
                                                              PS.Data.Maybe.Module.Just
                                                                .app(a))
                                                            .app(ra));
                                                      }
                                                      (mb is PS.Data.Maybe.Module._Type_Maybe
                                                               .Just) -> {
                                                        val b = mb.value0;
                                                        k.app(a.app(b));
                                                      }
                                                      else -> (error(
                                                        "Error in Pattern Match"
                                                      ) as Any)
                                                    };
                                                  }
                                                }
                                              })
                                          }))
                                      .app({ _ : Any ->
                                         PS.Control.Monad.Cont.Trans.Module.runContT
                                           .app(cb)
                                           .app({ b : Any ->
                                             PS.Control.Bind.Module.bind
                                               .app(
                                                 ((dictMonadEffect as Map<String, Any>)["Monad0"]!!
                                                    .app(Unit
                                                   ) as Map<String, Any>)["Bind1"]!!
                                                   .app(Unit))
                                               .app(
                                                 PS.Effect.Class.Module.liftEffect
                                                   .app(dictMonadEffect)
                                                   .app(
                                                   PS.Effect.Ref.Module.read
                                                     .app(ra)))
                                               .app({ v4 : Any ->
                                                 when {
                                                  else -> {
                                                    val ma = v4;
                                                    when {
                                                      (ma is PS.Data.Maybe.Module._Type_Maybe
                                                               .Nothing) -> {
                                                        PS.Effect.Class.Module.liftEffect
                                                          .app(dictMonadEffect)
                                                          .app(
                                                          PS.Effect.Ref.Module.write
                                                            .app(
                                                              PS.Data.Maybe.Module.Just
                                                                .app(b))
                                                            .app(rb));
                                                      }
                                                      (ma is PS.Data.Maybe.Module._Type_Maybe
                                                               .Just) -> {
                                                        val a = ma.value0;
                                                        k.app(a.app(b));
                                                      }
                                                      else -> (error(
                                                        "Error in Pattern Match"
                                                      ) as Any)
                                                    };
                                                  }
                                                }
                                              })
                                          })
                                      });
                                  }
                                }
                              });
                          }
                        }
                      })
                  }));
            }
          }
        }
      })
  };
  fun __rec_applicativeParCont(): Any = { dictMonadEffect : Any ->
     PS.Control.Applicative.Module.Applicative
       .app({ _ : Any ->
            PS.Control.Parallel.Class.Module.applyParCont.app(dictMonadEffect)
         })
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Control.Parallel.Class.Module.parallel
                     .app(PS.Control.Parallel.Class.Module.monadParParCont
                            .app(dictMonadEffect)))
              .app(PS.Control.Applicative.Module.pure
                     .app(PS.Control.Monad.Cont.Trans.Module.applicativeContT
                            .app(
            ((dictMonadEffect as Map<String, Any>)["Monad0"]!!
               .app(Unit) as Map<String, Any>)["Applicative0"]!!
              .app(Unit)))))
  };
  @JvmField
  val altParCont = { dictMonadEffect : Any ->
     PS.Control.Alt.Module.Alt
       .app({ _ : Any ->
            PS.Control.Parallel.Class.Module.functorParCont.app(dictMonadEffect)
         })
       .app({ v : Any ->
         { v1 : Any ->
           when {
            else -> {
              val c1 = v;
              val c2 = v1;
              PS.Data.Function.Module.apply
                .app(PS.Control.Parallel.Class.Module.ParCont)
                .app(PS.Control.Monad.Cont.Trans.Module.ContT
                       .app({ k : Any ->
                     PS.Control.Bind.Module.bind
                       .app(((dictMonadEffect as Map<String, Any>)["Monad0"]!!
                               .app(Unit) as Map<String, Any>)["Bind1"]!!
                              .app(Unit))
                       .app(PS.Effect.Class.Module.liftEffect
                              .app(dictMonadEffect)
                              .app(PS.Effect.Ref.Module.new.app(false)))
                       .app({ v2 : Any ->
                         when {
                          else -> {
                            val done = v2;
                            PS.Control.Bind.Module.discard
                              .app(PS.Control.Bind.Module.discardUnit)
                              .app(
                                ((dictMonadEffect as Map<String, Any>)["Monad0"]!!
                                   .app(Unit) as Map<String, Any>)["Bind1"]!!
                                  .app(Unit))
                              .app(PS.Control.Monad.Cont.Trans.Module.runContT
                                     .app(c1)
                                     .app({ a : Any ->
                                     PS.Control.Bind.Module.bind
                                       .app(
                                         ((dictMonadEffect as Map<String, Any>)["Monad0"]!!
                                            .app(Unit
                                           ) as Map<String, Any>)["Bind1"]!!
                                           .app(Unit))
                                       .app(PS.Effect.Class.Module.liftEffect
                                              .app(dictMonadEffect)
                                              .app(PS.Effect.Ref.Module.read
                                                     .app(done)))
                                       .app({ v3 : Any ->
                                         when {
                                          else -> {
                                            val b = v3;
                                            when {
                                              (b == true) -> {
                                                PS.Control.Applicative.Module.pure
                                                  .app(
                                                    ((dictMonadEffect as Map<String, Any>)["Monad0"]!!
                                                       .app(Unit
                                                      ) as Map<String, Any>)["Applicative0"]!!
                                                      .app(Unit))
                                                  .app(PS.Data.Unit.Module.unit
                                                );
                                              }
                                              else -> {
                                                PS.Control.Bind.Module.discard
                                                  .app(
                                                    PS.Control.Bind.Module.discardUnit
                                                  )
                                                  .app(
                                                    ((dictMonadEffect as Map<String, Any>)["Monad0"]!!
                                                       .app(Unit
                                                      ) as Map<String, Any>)["Bind1"]!!
                                                      .app(Unit))
                                                  .app(
                                                    PS.Effect.Class.Module.liftEffect
                                                      .app(dictMonadEffect)
                                                      .app(
                                                      PS.Effect.Ref.Module.write
                                                        .app(true)
                                                        .app(done)))
                                                  .app({ _ : Any ->
                                                     k.app(a)
                                                  });
                                              }
                                            };
                                          }
                                        }
                                      })
                                  }))
                              .app({ _ : Any ->
                                 PS.Control.Monad.Cont.Trans.Module.runContT
                                   .app(c2)
                                   .app({ a : Any ->
                                     PS.Control.Bind.Module.bind
                                       .app(
                                         ((dictMonadEffect as Map<String, Any>)["Monad0"]!!
                                            .app(Unit
                                           ) as Map<String, Any>)["Bind1"]!!
                                           .app(Unit))
                                       .app(PS.Effect.Class.Module.liftEffect
                                              .app(dictMonadEffect)
                                              .app(PS.Effect.Ref.Module.read
                                                     .app(done)))
                                       .app({ v3 : Any ->
                                         when {
                                          else -> {
                                            val b = v3;
                                            when {
                                              (b == true) -> {
                                                PS.Control.Applicative.Module.pure
                                                  .app(
                                                    ((dictMonadEffect as Map<String, Any>)["Monad0"]!!
                                                       .app(Unit
                                                      ) as Map<String, Any>)["Applicative0"]!!
                                                      .app(Unit))
                                                  .app(PS.Data.Unit.Module.unit
                                                );
                                              }
                                              else -> {
                                                PS.Control.Bind.Module.discard
                                                  .app(
                                                    PS.Control.Bind.Module.discardUnit
                                                  )
                                                  .app(
                                                    ((dictMonadEffect as Map<String, Any>)["Monad0"]!!
                                                       .app(Unit
                                                      ) as Map<String, Any>)["Bind1"]!!
                                                      .app(Unit))
                                                  .app(
                                                    PS.Effect.Class.Module.liftEffect
                                                      .app(dictMonadEffect)
                                                      .app(
                                                      PS.Effect.Ref.Module.write
                                                        .app(true)
                                                        .app(done)))
                                                  .app({ _ : Any ->
                                                     k.app(a)
                                                  });
                                              }
                                            };
                                          }
                                        }
                                      })
                                  })
                              });
                          }
                        }
                      })
                  }));
            }
          }
        }
      })
  };
  @JvmField
  val plusParCont = { dictMonadEffect : Any ->
     PS.Control.Plus.Module.Plus
       .app({ _ : Any ->
            PS.Control.Parallel.Class.Module.altParCont.app(dictMonadEffect)
         })
       .app(PS.Data.Function.Module.apply
              .app(PS.Control.Parallel.Class.Module.ParCont)
              .app(PS.Control.Monad.Cont.Trans.Module.ContT
                     .app({ v : Any ->
             PS.Control.Applicative.Module.pure
               .app(((dictMonadEffect as Map<String, Any>)["Monad0"]!!
                       .app(Unit) as Map<String, Any>)["Applicative0"]!!
                      .app(Unit))
               .app(PS.Data.Unit.Module.unit)
          })))
  };
  @JvmField
  val alternativeParCont = { dictMonadEffect : Any ->
     PS.Control.Alternative.Module.Alternative
       .app({ _ : Any ->
            PS.Control.Parallel.Class.Module.applicativeParCont
              .app(dictMonadEffect)
         })
       .app({ _ : Any ->
         PS.Control.Parallel.Class.Module.plusParCont.app(dictMonadEffect)
      })
  };
}