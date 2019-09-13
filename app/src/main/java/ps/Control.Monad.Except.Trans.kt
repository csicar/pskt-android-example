@file:Suppress("UNCHECKED_CAST")

package PS.Control.Monad.Except.Trans
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val ExceptT = { x : Any -> x};
  @JvmField
  val withExceptT = { dictFunctor : Any ->
     { f : Any ->
       { v : Any ->
        val f1 = f;
          val t = v;
          object   {
              val mapLeft = { v1 : Any ->
                 { v2 : Any ->
                   when {
                    (v2 is PS.Data.Either.Module._Type_Either.Right) -> {
                      val x = v2.value0;
                      PS.Data.Either.Module.Right.app(x);
                    }
                    (v2 is PS.Data.Either.Module._Type_Either.Left) -> {
                      val f_tick = v1;
                      val x = v2.value0;
                      PS.Data.Either.Module.Left.app(f_tick.app(x));
                    }
                    else -> (error("Error in Pattern Match") as Any)
                  }
                }
              };
            }
            .run({
              val mapLeft = this.mapLeft;
              PS.Data.Function.Module.apply
                .app(PS.Control.Monad.Except.Trans.Module.ExceptT)
                .app(PS.Data.Functor.Module.map.app(dictFunctor)
                       .app(mapLeft.app(f1))
                       .app(t));
            });}
    }
  };
  @JvmField val runExceptT = { v : Any ->val x = v; x;};
  @JvmField
  val newtypeExceptT = PS.Data.Newtype.Module.Newtype
                         .app({ n : Any ->
                             val a = n;
                               a;})
                         .app(PS.Control.Monad.Except.Trans.Module.ExceptT);
  @JvmField
  val monadTransExceptT = PS.Control.Monad.Trans.Class.Module.MonadTrans
                            .app({ dictMonad : Any ->
       { m : Any ->
         PS.Control.Monad.Except.Trans.Module.ExceptT
           .app(PS.Control.Bind.Module.bind
                  .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
                  .app(m)
                  .app({ v : Any ->
              val a = v;
                PS.Data.Function.Module.apply
                  .app(PS.Control.Applicative.Module.pure
                         .app((dictMonad as Map<String, Any>)["Applicative0"]!!
                                .app(Unit)))
                  .app(PS.Data.Either.Module.Right.app(a));}))
      }
    });
  @JvmField
  val mapExceptT = { f : Any ->
     { v : Any ->
      val f1 = f;
        val m = v;
        PS.Control.Monad.Except.Trans.Module.ExceptT.app(f1.app(m));}
  };
  @JvmField
  val functorExceptT = { dictFunctor : Any ->
     PS.Data.Functor.Module.Functor
       .app({ f : Any ->
         PS.Control.Monad.Except.Trans.Module.mapExceptT
           .app(PS.Data.Functor.Module.map.app(dictFunctor)
                  .app(PS.Data.Functor.Module.map
                         .app(PS.Data.Either.Module.functorEither)
                         .app(f)))
      })
  };
  @JvmField
  val except = { dictApplicative : Any ->
     PS.Control.Semigroupoid.Module.compose
       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
       .app(PS.Control.Monad.Except.Trans.Module.ExceptT)
       .app(PS.Control.Applicative.Module.pure.app(dictApplicative))
  };
  @JvmField val monadExceptT = (::__rec_monadExceptT)();
  @JvmField val bindExceptT = (::__rec_bindExceptT)();
  @JvmField val applyExceptT = (::__rec_applyExceptT)();
  @JvmField val applicativeExceptT = (::__rec_applicativeExceptT)();
  fun __rec_monadExceptT(): Any = { dictMonad : Any ->
     PS.Control.Monad.Module.Monad
       .app({ _ : Any ->
            PS.Control.Monad.Except.Trans.Module.applicativeExceptT
              .app(dictMonad)
         })
       .app({ _ : Any ->
         PS.Control.Monad.Except.Trans.Module.bindExceptT.app(dictMonad)
      })
  };
  fun __rec_bindExceptT(): Any = { dictMonad : Any ->
     PS.Control.Bind.Module.Bind
       .app({ _ : Any ->
            PS.Control.Monad.Except.Trans.Module.applyExceptT.app(dictMonad)
         })
       .app({ v : Any ->
         { k : Any ->
          val m = v;
            val k1 = k;
            PS.Control.Monad.Except.Trans.Module.ExceptT
              .app(PS.Control.Bind.Module.bind
                     .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
                     .app(m)
                     .app(PS.Data.Either.Module.either
                            .app(PS.Control.Semigroupoid.Module.compose
                                   .app(
                                     PS.Control.Semigroupoid.Module.semigroupoidFn
                                   )
                                   .app(PS.Control.Applicative.Module.pure
                                          .app(
                                       (dictMonad as Map<String, Any>)["Applicative0"]!!
                                         .app(Unit)))
                                   .app(PS.Data.Either.Module.Left))
                            .app({ a : Any ->
                     object   {
                         val v1 = k1.app(a);
                       }
                       .run({
                        val v1 = this.v1;
                        val b = v1;
                        b;
                      })
                  })));}
      })
  };
  fun __rec_applyExceptT(): Any = { dictMonad : Any ->
     PS.Control.Apply.Module.Apply
       .app({ _ : Any ->
            PS.Control.Monad.Except.Trans.Module.functorExceptT
              .app((((dictMonad as Map<String, Any>)["Bind1"]!!
                       .app(Unit) as Map<String, Any>)["Apply0"]!!
                      .app(Unit) as Map<String, Any>)["Functor0"]!!
                     .app(Unit))
         })
       .app(PS.Control.Monad.Module.ap
              .app(PS.Control.Monad.Except.Trans.Module.monadExceptT
                     .app(dictMonad)))
  };
  fun __rec_applicativeExceptT(): Any = { dictMonad : Any ->
     PS.Control.Applicative.Module.Applicative
       .app({ _ : Any ->
            PS.Control.Monad.Except.Trans.Module.applyExceptT.app(dictMonad)
         })
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Control.Monad.Except.Trans.Module.ExceptT)
              .app(PS.Control.Semigroupoid.Module.compose
                     .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                     .app(PS.Control.Applicative.Module.pure
                            .app(
                         (dictMonad as Map<String, Any>)["Applicative0"]!!
                           .app(Unit)))
                     .app(PS.Data.Either.Module.Right)))
  };
  @JvmField
  val monadAskExceptT = { dictMonadAsk : Any ->
     PS.Control.Monad.Reader.Class.Module.MonadAsk
       .app({ _ : Any ->
            PS.Control.Monad.Except.Trans.Module.monadExceptT
              .app((dictMonadAsk as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app(PS.Control.Monad.Trans.Class.Module.lift
              .app(PS.Control.Monad.Except.Trans.Module.monadTransExceptT)
              .app((dictMonadAsk as Map<String, Any>)["Monad0"]!!.app(Unit))
              .app(PS.Control.Monad.Reader.Class.Module.ask.app(dictMonadAsk)))
  };
  @JvmField
  val monadReaderExceptT = { dictMonadReader : Any ->
     PS.Control.Monad.Reader.Class.Module.MonadReader
       .app({ _ : Any ->
            PS.Control.Monad.Except.Trans.Module.monadAskExceptT
              .app((dictMonadReader as Map<String, Any>)["MonadAsk0"]!!
                     .app(Unit))
         })
       .app({ f : Any ->
         PS.Control.Monad.Except.Trans.Module.mapExceptT
           .app(PS.Control.Monad.Reader.Class.Module.local.app(dictMonadReader)
                  .app(f))
      })
  };
  @JvmField
  val monadContExceptT = { dictMonadCont : Any ->
     PS.Control.Monad.Cont.Class.Module.MonadCont
       .app({ _ : Any ->
            PS.Control.Monad.Except.Trans.Module.monadExceptT
              .app((dictMonadCont as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app({ f : Any ->
         PS.Data.Function.Module.apply
           .app(PS.Control.Monad.Except.Trans.Module.ExceptT)
           .app(PS.Control.Monad.Cont.Class.Module.callCC.app(dictMonadCont)
                  .app({ c : Any ->
               object   {
                   val v = f
                             .app({ a : Any ->
                        PS.Data.Function.Module.apply
                          .app(PS.Control.Monad.Except.Trans.Module.ExceptT)
                          .app(c.app(PS.Data.Either.Module.Right.app(a)))
                     });
                 }
                 .run({
                  val v = this.v;
                  val b = v;
                  b;
                })
            }))
      })
  };
  @JvmField
  val monadEffectExceptT = { dictMonadEffect : Any ->
     PS.Effect.Class.Module.MonadEffect
       .app({ _ : Any ->
            PS.Control.Monad.Except.Trans.Module.monadExceptT
              .app((dictMonadEffect as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Control.Monad.Trans.Class.Module.lift
                     .app(PS.Control.Monad.Except.Trans.Module.monadTransExceptT
                     )
                     .app((dictMonadEffect as Map<String, Any>)["Monad0"]!!
                            .app(Unit)))
              .app(PS.Effect.Class.Module.liftEffect.app(dictMonadEffect)))
  };
  @JvmField
  val monadRecExceptT = { dictMonadRec : Any ->
     PS.Control.Monad.Rec.Class.Module.MonadRec
       .app({ _ : Any ->
            PS.Control.Monad.Except.Trans.Module.monadExceptT
              .app((dictMonadRec as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app({ f : Any ->
         PS.Control.Semigroupoid.Module.compose
           .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
           .app(PS.Control.Monad.Except.Trans.Module.ExceptT)
           .app(PS.Control.Monad.Rec.Class.Module.tailRecM.app(dictMonadRec)
                  .app({ a : Any ->
               object   {
                   val v = f.app(a);
                 }
                 .run({
                  val v = this.v;
                  val m = v;
                  PS.Control.Bind.Module.bind
                    .app(((dictMonadRec as Map<String, Any>)["Monad0"]!!
                            .app(Unit) as Map<String, Any>)["Bind1"]!!
                           .app(Unit))
                    .app(m)
                    .app({ m_tick : Any ->
                       PS.Control.Applicative.Module.pure
                         .app(((dictMonadRec as Map<String, Any>)["Monad0"]!!
                                 .app(Unit
                                ) as Map<String, Any>)["Applicative0"]!!
                                .app(Unit))
                         .app(when {
                          (m_tick is PS.Data.Either.Module._Type_Either
                                       .Left) -> {
                            val e = m_tick.value0;
                            PS.Control.Monad.Rec.Class.Module.Done
                              .app(PS.Data.Either.Module.Left.app(e));
                          }
                          (m_tick is PS.Data.Either.Module._Type_Either
                                       .Right)&& (m_tick
                                                    .value0 is PS.Control.Monad.Rec.Class.Module._Type_Step
                                                                 .Loop) -> {
                            val a1 = m_tick.value0.value0;
                            PS.Control.Monad.Rec.Class.Module.Loop.app(a1);
                          }
                          (m_tick is PS.Data.Either.Module._Type_Either
                                       .Right)&& (m_tick
                                                    .value0 is PS.Control.Monad.Rec.Class.Module._Type_Step
                                                                 .Done) -> {
                            val b = m_tick.value0.value0;
                            PS.Control.Monad.Rec.Class.Module.Done
                              .app(PS.Data.Either.Module.Right.app(b));
                          }
                          else -> (error("Error in Pattern Match") as Any)
                        })
                    });
                })
            }))
      })
  };
  @JvmField
  val monadStateExceptT = { dictMonadState : Any ->
     PS.Control.Monad.State.Class.Module.MonadState
       .app({ _ : Any ->
            PS.Control.Monad.Except.Trans.Module.monadExceptT
              .app((dictMonadState as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app({ f : Any ->
         PS.Control.Monad.Trans.Class.Module.lift
           .app(PS.Control.Monad.Except.Trans.Module.monadTransExceptT)
           .app((dictMonadState as Map<String, Any>)["Monad0"]!!.app(Unit))
           .app(PS.Control.Monad.State.Class.Module.state.app(dictMonadState)
                  .app(f))
      })
  };
  @JvmField
  val monadTellExceptT = { dictMonadTell : Any ->
     PS.Control.Monad.Writer.Class.Module.MonadTell
       .app({ _ : Any ->
            PS.Control.Monad.Except.Trans.Module.monadExceptT
              .app((dictMonadTell as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Control.Monad.Trans.Class.Module.lift
                     .app(PS.Control.Monad.Except.Trans.Module.monadTransExceptT
                     )
                     .app((dictMonadTell as Map<String, Any>)["Monad0"]!!
                            .app(Unit)))
              .app(PS.Control.Monad.Writer.Class.Module.tell.app(dictMonadTell))
    )
  };
  @JvmField
  val monadWriterExceptT = { dictMonadWriter : Any ->
     PS.Control.Monad.Writer.Class.Module.MonadWriter
       .app({ _ : Any ->
            PS.Control.Monad.Except.Trans.Module.monadTellExceptT
              .app((dictMonadWriter as Map<String, Any>)["MonadTell0"]!!
                     .app(Unit))
         })
       .app(PS.Control.Monad.Except.Trans.Module.mapExceptT
              .app({ m : Any ->
              PS.Control.Bind.Module.bind
                .app((((dictMonadWriter as Map<String, Any>)["MonadTell0"]!!
                         .app(Unit) as Map<String, Any>)["Monad0"]!!
                        .app(Unit) as Map<String, Any>)["Bind1"]!!
                       .app(Unit))
                .app(PS.Control.Monad.Writer.Class.Module.listen
                       .app(dictMonadWriter)
                       .app(m))
                .app({ v : Any ->
                  when {
                   (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                     val a = v.value0;
                     val w = v.value1;
                     PS.Data.Function.Module.apply
                       .app(PS.Control.Applicative.Module.pure
                              .app(
                           (((dictMonadWriter as Map<String, Any>)["MonadTell0"]!!
                               .app(Unit) as Map<String, Any>)["Monad0"]!!
                              .app(Unit) as Map<String, Any>)["Applicative0"]!!
                             .app(Unit)))
                       .app(PS.Data.Functor.Module.map
                              .app(PS.Data.Either.Module.functorEither)
                              .app({ r : Any ->
                                   PS.Data.Tuple.Module.Tuple.app(r).app(w)
                                })
                              .app(a));
                   }
                   else -> (error("Error in Pattern Match") as Any)
                 }
               })
           }))
       .app(PS.Control.Monad.Except.Trans.Module.mapExceptT
              .app({ m : Any ->
           PS.Control.Monad.Writer.Class.Module.pass.app(dictMonadWriter)
             .app(PS.Control.Bind.Module.bind
                    .app((((dictMonadWriter as Map<String, Any>)["MonadTell0"]!!
                             .app(Unit) as Map<String, Any>)["Monad0"]!!
                            .app(Unit) as Map<String, Any>)["Bind1"]!!
                           .app(Unit))
                    .app(m)
                    .app({ v : Any ->
                val a = v;
                  PS.Control.Applicative.Module.pure
                    .app((((dictMonadWriter as Map<String, Any>)["MonadTell0"]!!
                             .app(Unit) as Map<String, Any>)["Monad0"]!!
                            .app(Unit) as Map<String, Any>)["Applicative0"]!!
                           .app(Unit))
                    .app(when {
                      (a is PS.Data.Either.Module._Type_Either.Left) -> {
                        val e = a.value0;
                        PS.Data.Tuple.Module.Tuple
                          .app(PS.Data.Either.Module.Left.app(e))
                          .app(PS.Control.Category.Module.identity
                                 .app(PS.Control.Category.Module.categoryFn));
                      }
                      (a is PS.Data.Either.Module._Type_Either
                              .Right)&& (a
                                           .value0 is PS.Data.Tuple.Module._Type_Tuple
                                                        .Tuple) -> {
                        val r = a.value0.value0;
                        val f = a.value0.value1;
                        PS.Data.Tuple.Module.Tuple
                          .app(PS.Data.Either.Module.Right.app(r))
                          .app(f);
                      }
                      else -> (error("Error in Pattern Match") as Any)
                    });}))
        }))
  };
  @JvmField
  val monadThrowExceptT = { dictMonad : Any ->
     PS.Control.Monad.Error.Class.Module.MonadThrow
       .app({ _ : Any ->
            PS.Control.Monad.Except.Trans.Module.monadExceptT.app(dictMonad)
         })
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Control.Monad.Except.Trans.Module.ExceptT)
              .app(PS.Control.Semigroupoid.Module.compose
                     .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                     .app(PS.Control.Applicative.Module.pure
                            .app(
                         (dictMonad as Map<String, Any>)["Applicative0"]!!
                           .app(Unit)))
                     .app(PS.Data.Either.Module.Left)))
  };
  @JvmField
  val monadErrorExceptT = { dictMonad : Any ->
     PS.Control.Monad.Error.Class.Module.MonadError
       .app({ _ : Any ->
            PS.Control.Monad.Except.Trans.Module.monadThrowExceptT
              .app(dictMonad)
         })
       .app({ v : Any ->
         { k : Any ->
          val m = v;
            val k1 = k;
            PS.Control.Monad.Except.Trans.Module.ExceptT
              .app(PS.Control.Bind.Module.bind
                     .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
                     .app(m)
                     .app(PS.Data.Either.Module.either
                            .app({ a : Any ->
                                 object   {
                                     val v1 = k1.app(a);
                                   }
                                   .run({
                                    val v1 = this.v1;
                                    val b = v1;
                                    b;
                                  })
                              })
                            .app(PS.Control.Semigroupoid.Module.compose
                                   .app(
                                     PS.Control.Semigroupoid.Module.semigroupoidFn
                                   )
                                   .app(PS.Control.Applicative.Module.pure
                                          .app(
                                       (dictMonad as Map<String, Any>)["Applicative0"]!!
                                         .app(Unit)))
                                   .app(PS.Data.Either.Module.Right))));}
      })
  };
  @JvmField
  val altExceptT = { dictSemigroup : Any ->
     { dictMonad : Any ->
       PS.Control.Alt.Module.Alt
         .app({ _ : Any ->
              PS.Control.Monad.Except.Trans.Module.functorExceptT
                .app((((dictMonad as Map<String, Any>)["Bind1"]!!
                         .app(Unit) as Map<String, Any>)["Apply0"]!!
                        .app(Unit) as Map<String, Any>)["Functor0"]!!
                       .app(Unit))
           })
         .app({ v : Any ->
           { v1 : Any ->
            val m = v;
              val n = v1;
              PS.Control.Monad.Except.Trans.Module.ExceptT
                .app(PS.Control.Bind.Module.bind
                       .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit)
                       )
                       .app(m)
                       .app({ v2 : Any ->
                    val rm = v2;
                      when {
                        (rm is PS.Data.Either.Module._Type_Either.Right) -> {
                          val x = rm.value0;
                          PS.Control.Applicative.Module.pure
                            .app(
                              (dictMonad as Map<String, Any>)["Applicative0"]!!
                                .app(Unit))
                            .app(PS.Data.Either.Module.Right.app(x));
                        }
                        (rm is PS.Data.Either.Module._Type_Either.Left) -> {
                          val err = rm.value0;
                          PS.Control.Bind.Module.bind
                            .app((dictMonad as Map<String, Any>)["Bind1"]!!
                                   .app(Unit))
                            .app(n)
                            .app({ v3 : Any ->
                              val rn = v3;
                                when {
                                  (rn is PS.Data.Either.Module._Type_Either
                                           .Right) -> {
                                    val x = rn.value0;
                                    PS.Control.Applicative.Module.pure
                                      .app(
                                        (dictMonad as Map<String, Any>)["Applicative0"]!!
                                          .app(Unit))
                                      .app(PS.Data.Either.Module.Right.app(x));
                                  }
                                  (rn is PS.Data.Either.Module._Type_Either
                                           .Left) -> {
                                    val err_tick = rn.value0;
                                    PS.Control.Applicative.Module.pure
                                      .app(
                                        (dictMonad as Map<String, Any>)["Applicative0"]!!
                                          .app(Unit))
                                      .app(PS.Data.Either.Module.Left
                                             .app(
                                        PS.Data.Semigroup.Module.append
                                          .app(dictSemigroup)
                                          .app(err)
                                          .app(err_tick)));
                                  }
                                  else -> (error("Error in Pattern Match"
                                  ) as Any)
                                };});
                        }
                        else -> (error("Error in Pattern Match") as Any)
                      };}));}
        })
    }
  };
  @JvmField
  val plusExceptT = { dictMonoid : Any ->
     { dictMonad : Any ->
       PS.Control.Plus.Module.Plus
         .app({ _ : Any ->
              PS.Control.Monad.Except.Trans.Module.altExceptT
                .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!.app(Unit))
                .app(dictMonad)
           })
         .app(PS.Control.Monad.Error.Class.Module.throwError
                .app(PS.Control.Monad.Except.Trans.Module.monadThrowExceptT
                       .app(dictMonad))
                .app(PS.Data.Monoid.Module.mempty.app(dictMonoid)))
    }
  };
  @JvmField
  val alternativeExceptT = { dictMonoid : Any ->
     { dictMonad : Any ->
       PS.Control.Alternative.Module.Alternative
         .app({ _ : Any ->
              PS.Control.Monad.Except.Trans.Module.applicativeExceptT
                .app(dictMonad)
           })
         .app({ _ : Any ->
           PS.Control.Monad.Except.Trans.Module.plusExceptT.app(dictMonoid)
             .app(dictMonad)
        })
    }
  };
  @JvmField
  val monadZeroExceptT = { dictMonoid : Any ->
     { dictMonad : Any ->
       PS.Control.MonadZero.Module.MonadZero
         .app({ _ : Any ->
              PS.Control.Monad.Except.Trans.Module.alternativeExceptT
                .app(dictMonoid)
                .app(dictMonad)
           })
         .app({ _ : Any ->
           PS.Control.Monad.Except.Trans.Module.monadExceptT.app(dictMonad)
        })
    }
  };
  @JvmField
  val monadPlusExceptT = { dictMonoid : Any ->
     { dictMonad : Any ->
       PS.Control.MonadPlus.Module.MonadPlus
         .app({ _ : Any ->
           PS.Control.Monad.Except.Trans.Module.monadZeroExceptT.app(dictMonoid)
             .app(dictMonad)
        })
    }
  };
}