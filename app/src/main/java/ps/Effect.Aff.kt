@file:Suppress("UNCHECKED_CAST")

package PS.Effect.Aff
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  val __pure = Foreign.Effect.Aff.__pure;
  val __throwError = Foreign.Effect.Aff.__throwError;
  val __catchError = Foreign.Effect.Aff.__catchError;
  val __fork = Foreign.Effect.Aff.__fork;
  val __map = Foreign.Effect.Aff.__map;
  val __bind = Foreign.Effect.Aff.__bind;
  val __delay = Foreign.Effect.Aff.__delay;
  val __liftEffect = Foreign.Effect.Aff.__liftEffect;
  val __parAffMap = Foreign.Effect.Aff.__parAffMap;
  val __parAffApply = Foreign.Effect.Aff.__parAffApply;
  val __parAffAlt = Foreign.Effect.Aff.__parAffAlt;
  val __makeFiber = Foreign.Effect.Aff.__makeFiber;
  val __makeSupervisedFiber = Foreign.Effect.Aff.__makeSupervisedFiber;
  val __killAll = Foreign.Effect.Aff.__killAll;
  val __sequential = Foreign.Effect.Aff.__sequential;
  val generalBracket = Foreign.Effect.Aff.generalBracket;
  val makeAff = Foreign.Effect.Aff.makeAff;
  @JvmField val Fiber = { x : Any -> x};
  @JvmField val FFIUtil = { x : Any -> x};
  @JvmField val Canceler = { x : Any -> x};
  @JvmField val suspendAff = PS.Effect.Aff.Module.__fork.app(false);
  @JvmField
  val newtypeCanceler = PS.Data.Newtype.Module.Newtype
                          .app({ n : Any ->
                              val a = n;
                                a;})
                          .app(PS.Effect.Aff.Module.Canceler);
  @JvmField
  val functorParAff = PS.Data.Functor.Module.Functor
                        .app(PS.Effect.Aff.Module.__parAffMap);
  @JvmField
  val functorAff = PS.Data.Functor.Module.Functor
                     .app(PS.Effect.Aff.Module.__map);
  @JvmField val forkAff = PS.Effect.Aff.Module.__fork.app(true);
  @JvmField
  val ffiUtil = object   {
                    val unsafeFromRight = { v : Any ->
                       when {
                        (v is PS.Data.Either.Module._Type_Either.Right) -> {
                          val a = v.value0;
                          a;
                        }
                        (v is PS.Data.Either.Module._Type_Either.Left) -> {
                          PS.Partial.Unsafe.Module.unsafeCrashWith
                            .app("unsafeFromRight: Left");
                        }
                        else -> (error("Error in Pattern Match") as Any)
                      }
                    };
                    val unsafeFromLeft = { v : Any ->
                       when {
                        (v is PS.Data.Either.Module._Type_Either.Left) -> {
                          val a = v.value0;
                          a;
                        }
                        (v is PS.Data.Either.Module._Type_Either.Right) -> {
                          PS.Partial.Unsafe.Module.unsafeCrashWith
                            .app("unsafeFromLeft: Right");
                        }
                        else -> (error("Error in Pattern Match") as Any)
                      }
                    };
                    val isLeft = { v : Any ->
                       when {
                        (v is PS.Data.Either.Module._Type_Either.Left) -> {
                          true;
                        }
                        (v is PS.Data.Either.Module._Type_Either.Right) -> {
                          false;
                        }
                        else -> (error("Error in Pattern Match") as Any)
                      }
                    };
                  }
                  .run({
      val unsafeFromRight = this.unsafeFromRight;
      val unsafeFromLeft = this.unsafeFromLeft;
      val isLeft = this.isLeft;
      PS.Effect.Aff.Module.FFIUtil
        .app(mapOf(("isLeft" to isLeft),  ("fromLeft" to unsafeFromLeft),  
          ("fromRight" to unsafeFromRight),  
          ("left" to PS.Data.Either.Module.Left),  
          ("right" to PS.Data.Either.Module.Right)));
    });
  @JvmField
  val makeFiber = { aff : Any ->
     PS.Data.Function.Uncurried.Module.runFn2
       .app(PS.Effect.Aff.Module.__makeFiber)
       .app(PS.Effect.Aff.Module.ffiUtil)
       .app(aff)
  };
  @JvmField
  val launchAff = { aff : Any ->
     /* defer **/{
      val v = PS.Effect.Aff.Module.makeFiber.app(aff).appRun();
      val fiber = v;
      val f = fiber;
      (f as Map<String, Any>)["run"]!!.appRun();
      fiber;
    }
  };
  @JvmField
  val launchAff_ = PS.Control.Semigroupoid.Module.compose
                     .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                     .app(PS.Data.Functor.Module.void
                            .app(PS.Effect.Module.functorEffect))
                     .app(PS.Effect.Aff.Module.launchAff);
  @JvmField val launchSuspendedAff = PS.Effect.Aff.Module.makeFiber;
  @JvmField
  val delay = { v : Any ->
    val n = v;
      PS.Data.Function.Uncurried.Module.runFn2.app(PS.Effect.Aff.Module.__delay)
        .app(PS.Data.Either.Module.Right)
        .app(n);};
  @JvmField
  val bracket = { acquire : Any ->
     { completed : Any ->
       PS.Effect.Aff.Module.generalBracket.app(acquire)
         .app(mapOf(("killed" to PS.Data.Function.Module._const
                                   .app(completed)),  
          ("failed" to PS.Data.Function.Module._const.app(completed)),  
          ("completed" to PS.Data.Function.Module._const.app(completed))))
    }
  };
  @JvmField
  val applyParAff = PS.Control.Apply.Module.Apply
                      .app({ _ : Any ->
                           PS.Effect.Aff.Module.functorParAff
                        })
                      .app(PS.Effect.Aff.Module.__parAffApply);
  @JvmField
  val semigroupParAff = { dictSemigroup : Any ->
     PS.Data.Semigroup.Module.Semigroup
       .app(PS.Control.Apply.Module.lift2.app(PS.Effect.Aff.Module.applyParAff)
              .app(PS.Data.Semigroup.Module.append.app(dictSemigroup)))
  };
  @JvmField val monadAff = (::__rec_monadAff)();
  @JvmField val bindAff = (::__rec_bindAff)();
  @JvmField val applyAff = (::__rec_applyAff)();
  @JvmField val applicativeAff = (::__rec_applicativeAff)();
  fun __rec_monadAff(): Any = PS.Control.Monad.Module.Monad
                                .app({ _ : Any ->
                                     PS.Effect.Aff.Module.applicativeAff
                                  })
                                .app({ _ : Any ->
       PS.Effect.Aff.Module.bindAff
    });
  fun __rec_bindAff(): Any = PS.Control.Bind.Module.Bind
                               .app({ _ : Any ->
                                    PS.Effect.Aff.Module.applyAff
                                 })
                               .app(PS.Effect.Aff.Module.__bind);
  fun __rec_applyAff(): Any = PS.Control.Apply.Module.Apply
                                .app({ _ : Any ->
                                     PS.Effect.Aff.Module.functorAff
                                  })
                                .app(PS.Control.Monad.Module.ap
                                       .app(PS.Effect.Aff.Module.monadAff));
  fun __rec_applicativeAff(): Any = PS.Control.Applicative.Module.Applicative
                                      .app({ _ : Any ->
                                           PS.Effect.Aff.Module.applyAff
                                        })
                                      .app(PS.Effect.Aff.Module.__pure);
  @JvmField
  val cancelWith = { aff : Any ->
     { v : Any ->
      val aff1 = aff;
        val cancel = v;
        PS.Effect.Aff.Module.generalBracket
          .app(PS.Control.Applicative.Module.pure
                 .app(PS.Effect.Aff.Module.applicativeAff)
                 .app(PS.Data.Unit.Module.unit))
          .app(mapOf(("killed" to { e : Any ->
                 { v1 : Any ->
                   cancel.app(e)
                }
              }),  ("failed" to PS.Data.Function.Module._const
                                  .app(PS.Control.Applicative.Module.pure
                                         .app(
                  PS.Effect.Aff.Module.applicativeAff))),  
              ("completed" to PS.Data.Function.Module._const
                                .app(PS.Control.Applicative.Module.pure
                                       .app(PS.Effect.Aff.Module.applicativeAff)
              ))))
          .app(PS.Data.Function.Module._const.app(aff1));}
  };
  @JvmField
  val _finally = { fin : Any ->
     { a : Any ->
       PS.Effect.Aff.Module.bracket
         .app(PS.Control.Applicative.Module.pure
                .app(PS.Effect.Aff.Module.applicativeAff)
                .app(PS.Data.Unit.Module.unit))
         .app(PS.Data.Function.Module._const.app(fin))
         .app(PS.Data.Function.Module._const.app(a))
    }
  };
  @JvmField
  val invincible = { a : Any ->
     PS.Effect.Aff.Module.bracket.app(a)
       .app(PS.Data.Function.Module._const
              .app(PS.Control.Applicative.Module.pure
                     .app(PS.Effect.Aff.Module.applicativeAff)
                     .app(PS.Data.Unit.Module.unit)))
       .app(PS.Control.Applicative.Module.pure
              .app(PS.Effect.Aff.Module.applicativeAff))
  };
  @JvmField
  val lazyAff = PS.Control.Lazy.Module.Lazy
                  .app({ f : Any ->
       PS.Control.Bind.Module.bind.app(PS.Effect.Aff.Module.bindAff)
         .app(PS.Control.Applicative.Module.pure
                .app(PS.Effect.Aff.Module.applicativeAff)
                .app(PS.Data.Unit.Module.unit))
         .app(f)
    });
  @JvmField
  val semigroupAff = { dictSemigroup : Any ->
     PS.Data.Semigroup.Module.Semigroup
       .app(PS.Control.Apply.Module.lift2.app(PS.Effect.Aff.Module.applyAff)
              .app(PS.Data.Semigroup.Module.append.app(dictSemigroup)))
  };
  @JvmField
  val monadEffectAff = PS.Effect.Class.Module.MonadEffect
                         .app({ _ : Any ->
                              PS.Effect.Aff.Module.monadAff
                           })
                         .app(PS.Effect.Aff.Module.__liftEffect);
  @JvmField
  val effectCanceler = PS.Control.Semigroupoid.Module.compose
                         .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                         .app(PS.Effect.Aff.Module.Canceler)
                         .app(PS.Control.Semigroupoid.Module.compose
                                .app(
                                  PS.Control.Semigroupoid.Module.semigroupoidFn)
                                .app(PS.Data.Function.Module._const)
                                .app(PS.Effect.Class.Module.liftEffect
                                       .app(PS.Effect.Aff.Module.monadEffectAff)
    ));
  @JvmField
  val joinFiber = { v : Any ->
    val t = v;
      PS.Effect.Aff.Module.makeAff
        .app({ k : Any ->
           PS.Data.Functor.Module.map.app(PS.Effect.Module.functorEffect)
             .app(PS.Effect.Aff.Module.effectCanceler)
             .app((t as Map<String, Any>)["join"]!!.app(k))
        });};
  @JvmField
  val functorFiber = PS.Data.Functor.Module.Functor
                       .app({ f : Any ->
       { t : Any ->
         PS.Effect.Unsafe.Module.unsafePerformEffect
           .app(PS.Effect.Aff.Module.makeFiber
                  .app(PS.Data.Functor.Module.map
                         .app(PS.Effect.Aff.Module.functorAff)
                         .app(f)
                         .app(PS.Effect.Aff.Module.joinFiber.app(t))))
      }
    });
  @JvmField
  val applyFiber = PS.Control.Apply.Module.Apply
                     .app({ _ : Any ->
                          PS.Effect.Aff.Module.functorFiber
                       })
                     .app({ t1 : Any ->
       { t2 : Any ->
         PS.Effect.Unsafe.Module.unsafePerformEffect
           .app(PS.Effect.Aff.Module.makeFiber
                  .app(PS.Control.Apply.Module.apply
                         .app(PS.Effect.Aff.Module.applyAff)
                         .app(PS.Effect.Aff.Module.joinFiber.app(t1))
                         .app(PS.Effect.Aff.Module.joinFiber.app(t2))))
      }
    });
  @JvmField
  val applicativeFiber = PS.Control.Applicative.Module.Applicative
                           .app({ _ : Any ->
                                PS.Effect.Aff.Module.applyFiber
                             })
                           .app({ a : Any ->
       PS.Effect.Unsafe.Module.unsafePerformEffect
         .app(PS.Effect.Aff.Module.makeFiber
                .app(PS.Control.Applicative.Module.pure
                       .app(PS.Effect.Aff.Module.applicativeAff)
                       .app(a)))
    });
  @JvmField
  val killFiber = { e : Any ->
     { v : Any ->
      val e1 = e;
        val t = v;
        PS.Control.Bind.Module.bind.app(PS.Effect.Aff.Module.bindAff)
          .app(PS.Effect.Class.Module.liftEffect
                 .app(PS.Effect.Aff.Module.monadEffectAff)
                 .app((t as Map<String, Any>)["isSuspended"]!!))
          .app({ v1 : Any ->
             when {
              (v1 == true) -> {
                PS.Data.Function.Module.apply
                  .app(PS.Effect.Class.Module.liftEffect
                         .app(PS.Effect.Aff.Module.monadEffectAff))
                  .app(PS.Data.Function.Module.apply
                         .app(PS.Data.Functor.Module.void
                                .app(PS.Effect.Module.functorEffect))
                         .app(PS.Data.Function.Uncurried.Module.runFn2
                                .app((t as Map<String, Any>)["kill"]!!)
                                .app(e1)
                                .app(PS.Data.Function.Module._const
                                       .app(PS.Control.Applicative.Module.pure
                                              .app(
                                                PS.Effect.Module.applicativeEffect
                                              )
                                              .app(PS.Data.Unit.Module.unit))))
                );
              }
              else -> {
                PS.Effect.Aff.Module.makeAff
                  .app({ k : Any ->
                     PS.Data.Functor.Module.map
                       .app(PS.Effect.Module.functorEffect)
                       .app(PS.Effect.Aff.Module.effectCanceler)
                       .app(PS.Data.Function.Uncurried.Module.runFn2
                              .app((t as Map<String, Any>)["kill"]!!)
                              .app(e1)
                              .app(k))
                  });
              }
            }
          });}
  };
  @JvmField
  val fiberCanceler = PS.Control.Semigroupoid.Module.compose
                        .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                        .app(PS.Effect.Aff.Module.Canceler)
                        .app(PS.Data.Function.Module.flip
                               .app(PS.Effect.Aff.Module.killFiber));
  @JvmField
  val monadThrowAff = PS.Control.Monad.Error.Class.Module.MonadThrow
                        .app({ _ : Any ->
                             PS.Effect.Aff.Module.monadAff
                          })
                        .app(PS.Effect.Aff.Module.__throwError);
  @JvmField
  val monadErrorAff = PS.Control.Monad.Error.Class.Module.MonadError
                        .app({ _ : Any ->
                             PS.Effect.Aff.Module.monadThrowAff
                          })
                        .app(PS.Effect.Aff.Module.__catchError);
  @JvmField
  val attempt = PS.Control.Monad.Error.Class.Module._try
                  .app(PS.Effect.Aff.Module.monadErrorAff);
  @JvmField
  val runAff = { k : Any ->
     { aff : Any ->
       PS.Data.Function.Module.apply.app(PS.Effect.Aff.Module.launchAff)
         .app(PS.Control.Bind.Module.bindFlipped
                .app(PS.Effect.Aff.Module.bindAff)
                .app(PS.Control.Semigroupoid.Module.compose
                       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                       .app(PS.Effect.Class.Module.liftEffect
                              .app(PS.Effect.Aff.Module.monadEffectAff))
                       .app(k))
                .app(PS.Control.Monad.Error.Class.Module._try
                       .app(PS.Effect.Aff.Module.monadErrorAff)
                       .app(aff)))
    }
  };
  @JvmField
  val runAff_ = { k : Any ->
     { aff : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Functor.Module.void.app(PS.Effect.Module.functorEffect))
         .app(PS.Effect.Aff.Module.runAff.app(k).app(aff))
    }
  };
  @JvmField
  val runSuspendedAff = { k : Any ->
     { aff : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Effect.Aff.Module.launchSuspendedAff)
         .app(PS.Control.Bind.Module.bindFlipped
                .app(PS.Effect.Aff.Module.bindAff)
                .app(PS.Control.Semigroupoid.Module.compose
                       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                       .app(PS.Effect.Class.Module.liftEffect
                              .app(PS.Effect.Aff.Module.monadEffectAff))
                       .app(k))
                .app(PS.Control.Monad.Error.Class.Module._try
                       .app(PS.Effect.Aff.Module.monadErrorAff)
                       .app(aff)))
    }
  };
  @JvmField val parallelAff = (::__rec_parallelAff)();
  @JvmField val applicativeParAff = (::__rec_applicativeParAff)();
  fun __rec_parallelAff(): Any = PS.Control.Parallel.Class.Module.Parallel
                                   .app({ _ : Any ->
                                        PS.Effect.Aff.Module.applicativeParAff
                                     })
                                   .app({ _ : Any ->
                                        PS.Effect.Aff.Module.monadAff
                                     })
                                   .app(PS.Unsafe.Coerce.Module.unsafeCoerce)
                                   .app(PS.Effect.Aff.Module.__sequential);
  fun __rec_applicativeParAff(): Any = PS.Control.Applicative.Module.Applicative
                                         .app({ _ : Any ->
                                              PS.Effect.Aff.Module.applyParAff
                                           })
                                         .app(
    PS.Control.Semigroupoid.Module.compose
      .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
      .app(PS.Control.Parallel.Class.Module.parallel
             .app(PS.Effect.Aff.Module.parallelAff))
      .app(PS.Control.Applicative.Module.pure
             .app(PS.Effect.Aff.Module.applicativeAff)));
  @JvmField
  val monoidParAff = { dictMonoid : Any ->
     PS.Data.Monoid.Module.Monoid
       .app({ _ : Any ->
            PS.Effect.Aff.Module.semigroupParAff
              .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!.app(Unit))
         })
       .app(PS.Control.Applicative.Module.pure
              .app(PS.Effect.Aff.Module.applicativeParAff)
              .app(PS.Data.Monoid.Module.mempty.app(dictMonoid)))
  };
  @JvmField
  val semigroupCanceler = PS.Data.Semigroup.Module.Semigroup
                            .app({ v : Any ->
       { v1 : Any ->
        val c1 = v;
          val c2 = v1;
          PS.Effect.Aff.Module.Canceler
            .app({ err : Any ->
               PS.Control.Parallel.Module.parSequence_
                 .app(PS.Effect.Aff.Module.parallelAff)
                 .app(PS.Data.Foldable.Module.foldableArray)
                 .app(listOf(c1.app(err),  c2.app(err)))
            });}
    });
  @JvmField
  val supervise = { aff : Any ->
     object   {
         val killError = PS.Effect.Exception.Module.error
                           .app("[Aff] Child fiber outlived parent");
         val killAll = { err : Any ->
            { sup : Any ->
              PS.Effect.Aff.Module.makeAff
                .app({ k : Any ->
                  PS.Data.Function.Uncurried.Module.runFn3
                    .app(PS.Effect.Aff.Module.__killAll)
                    .app(err)
                    .app((sup as Map<String, Any>)["supervisor"]!!)
                    .app(k
                           .app(PS.Control.Applicative.Module.pure
                                  .app(PS.Data.Either.Module.applicativeEither)
                                  .app(PS.Data.Unit.Module.unit)))
               })
           }
         };
         val acquire = /* defer **/{
           val v = PS.Data.Function.Uncurried.Module.runFn2
                     .app(PS.Effect.Aff.Module.__makeSupervisedFiber)
                     .app(PS.Effect.Aff.Module.ffiUtil)
                     .app(aff)
                     .appRun();
           val sup = v;
           val f = (sup as Map<String, Any>)["fiber"]!!;
           (f as Map<String, Any>)["run"]!!.appRun();
           sup;
         };
       }
       .run({
        val killError = this.killError;
        val killAll = this.killAll;
        val acquire = this.acquire;
        PS.Effect.Aff.Module.generalBracket
          .app(PS.Effect.Class.Module.liftEffect
                 .app(PS.Effect.Aff.Module.monadEffectAff)
                 .app(acquire))
          .app(mapOf(("killed" to { err : Any ->
                 { sup : Any ->
                   PS.Control.Parallel.Module.parSequence_
                     .app(PS.Effect.Aff.Module.parallelAff)
                     .app(PS.Data.Foldable.Module.foldableArray)
                     .app(listOf(PS.Effect.Aff.Module.killFiber.app(err)
                                   .app((sup as Map<String, Any>)["fiber"]!!),  
                      killAll.app(err).app(sup)))
                }
              }),  ("failed" to PS.Data.Function.Module._const
                                  .app(killAll.app(killError))),  
              ("completed" to PS.Data.Function.Module._const
                                .app(killAll.app(killError)))))
          .app(PS.Control.Semigroupoid.Module.compose
                 .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                 .app(PS.Effect.Aff.Module.joinFiber)
                 .app({ v : Any ->
               (v as Map<String, Any>)["fiber"]!!
            }));
      })
  };
  @JvmField
  val monadRecAff = PS.Control.Monad.Rec.Class.Module.MonadRec
                      .app({ _ : Any ->
                           PS.Effect.Aff.Module.monadAff
                        })
                      .app({ k : Any ->
       object   {
           val go = (::__rec_go)();
           fun __rec_go(): Any = { a : Any ->
              PS.Control.Bind.Module.bind.app(PS.Effect.Aff.Module.bindAff)
                .app(k.app(a))
                .app({ v : Any ->
                 val res = v;
                   when {
                     (res is PS.Control.Monad.Rec.Class.Module._Type_Step
                               .Done) -> {
                       val r = res.value0;
                       PS.Control.Applicative.Module.pure
                         .app(PS.Effect.Aff.Module.applicativeAff)
                         .app(r);
                     }
                     (res is PS.Control.Monad.Rec.Class.Module._Type_Step
                               .Loop) -> {
                       val b = res.value0;
                       __rec_go().app(b);
                     }
                     else -> (error("Error in Pattern Match") as Any)
                   };})
           };
         }
         .run({
          val go = this.go;
          go;
        })
    });
  @JvmField
  val monoidAff = { dictMonoid : Any ->
     PS.Data.Monoid.Module.Monoid
       .app({ _ : Any ->
            PS.Effect.Aff.Module.semigroupAff
              .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!.app(Unit))
         })
       .app(PS.Control.Applicative.Module.pure
              .app(PS.Effect.Aff.Module.applicativeAff)
              .app(PS.Data.Monoid.Module.mempty.app(dictMonoid)))
  };
  @JvmField
  val nonCanceler = PS.Effect.Aff.Module.Canceler
                      .app(PS.Data.Function.Module._const
                             .app(PS.Control.Applicative.Module.pure
                                    .app(PS.Effect.Aff.Module.applicativeAff)
                                    .app(PS.Data.Unit.Module.unit)));
  @JvmField
  val monoidCanceler = PS.Data.Monoid.Module.Monoid
                         .app({ _ : Any ->
                              PS.Effect.Aff.Module.semigroupCanceler
                           })
                         .app(PS.Effect.Aff.Module.nonCanceler);
  @JvmField
  val never = PS.Effect.Aff.Module.makeAff
                .app({ v : Any ->
       PS.Control.Applicative.Module.pure
         .app(PS.Effect.Module.applicativeEffect)
         .app(PS.Data.Monoid.Module.mempty
                .app(PS.Effect.Aff.Module.monoidCanceler))
    });
  @JvmField
  val apathize = PS.Control.Semigroupoid.Module.composeFlipped
                   .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                   .app(PS.Effect.Aff.Module.attempt)
                   .app(PS.Data.Functor.Module.map
                          .app(PS.Effect.Aff.Module.functorAff)
                          .app(PS.Data.Function.Module._const
                                 .app(PS.Data.Unit.Module.unit)));
  @JvmField
  val altParAff = PS.Control.Alt.Module.Alt
                    .app({ _ : Any ->
                         PS.Effect.Aff.Module.functorParAff
                      })
                    .app(PS.Effect.Aff.Module.__parAffAlt);
  @JvmField
  val altAff = PS.Control.Alt.Module.Alt
                 .app({ _ : Any ->
                      PS.Effect.Aff.Module.functorAff
                   })
                 .app({ a1 : Any ->
       { a2 : Any ->
         PS.Control.Monad.Error.Class.Module.catchError
           .app(PS.Effect.Aff.Module.monadErrorAff)
           .app(a1)
           .app(PS.Data.Function.Module._const.app(a2))
      }
    });
  @JvmField
  val plusAff = PS.Control.Plus.Module.Plus
                  .app({ _ : Any ->
                       PS.Effect.Aff.Module.altAff
                    })
                  .app(PS.Control.Monad.Error.Class.Module.throwError
                         .app(PS.Effect.Aff.Module.monadThrowAff)
                         .app(PS.Effect.Exception.Module.error
                                .app("Always fails")));
  @JvmField
  val plusParAff = PS.Control.Plus.Module.Plus
                     .app({ _ : Any ->
                          PS.Effect.Aff.Module.altParAff
                       })
                     .app(PS.Control.Parallel.Class.Module.parallel
                            .app(PS.Effect.Aff.Module.parallelAff)
                            .app(PS.Control.Plus.Module.empty
                                   .app(PS.Effect.Aff.Module.plusAff)));
  @JvmField
  val alternativeParAff = PS.Control.Alternative.Module.Alternative
                            .app({ _ : Any ->
                                 PS.Effect.Aff.Module.applicativeParAff
                              })
                            .app({ _ : Any ->
       PS.Effect.Aff.Module.plusParAff
    });
}