@file:Suppress("UNCHECKED_CAST")

package PS.Control.Monad.Maybe.Trans
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val MaybeT = { x : Any -> x};
  @JvmField val runMaybeT = { v : Any ->val x = v; x;};
  @JvmField
  val newtypeMaybeT = PS.Data.Newtype.Module.Newtype
                        .app({ n : Any ->
                            val a = n;
                              a;})
                        .app(PS.Control.Monad.Maybe.Trans.Module.MaybeT);
  @JvmField
  val monadTransMaybeT = PS.Control.Monad.Trans.Class.Module.MonadTrans
                           .app({ dictMonad : Any ->
       PS.Control.Semigroupoid.Module.compose
         .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
         .app(PS.Control.Monad.Maybe.Trans.Module.MaybeT)
         .app(PS.Control.Monad.Module.liftM1.app(dictMonad)
                .app(PS.Data.Maybe.Module.Just))
    });
  @JvmField
  val mapMaybeT = { f : Any ->
     { v : Any ->
      val f1 = f;
        val m = v;
        PS.Control.Monad.Maybe.Trans.Module.MaybeT.app(f1.app(m));}
  };
  @JvmField
  val functorMaybeT = { dictFunctor : Any ->
     PS.Data.Functor.Module.Functor
       .app({ f : Any ->
         { v : Any ->
          val f1 = f;
            val ma = v;
            PS.Control.Monad.Maybe.Trans.Module.MaybeT
              .app(PS.Data.Functor.Module.map.app(dictFunctor)
                     .app(PS.Data.Functor.Module.map
                            .app(PS.Data.Maybe.Module.functorMaybe)
                            .app(f1))
                     .app(ma));}
      })
  };
  @JvmField val monadMaybeT = (::__rec_monadMaybeT)();
  @JvmField val bindMaybeT = (::__rec_bindMaybeT)();
  @JvmField val applyMaybeT = (::__rec_applyMaybeT)();
  @JvmField val applicativeMaybeT = (::__rec_applicativeMaybeT)();
  fun __rec_monadMaybeT(): Any = { dictMonad : Any ->
     PS.Control.Monad.Module.Monad
       .app({ _ : Any ->
            PS.Control.Monad.Maybe.Trans.Module.applicativeMaybeT.app(dictMonad)
         })
       .app({ _ : Any ->
         PS.Control.Monad.Maybe.Trans.Module.bindMaybeT.app(dictMonad)
      })
  };
  fun __rec_bindMaybeT(): Any = { dictMonad : Any ->
     PS.Control.Bind.Module.Bind
       .app({ _ : Any ->
            PS.Control.Monad.Maybe.Trans.Module.applyMaybeT.app(dictMonad)
         })
       .app({ v : Any ->
         { f : Any ->
          val x = v;
            val f1 = f;
            PS.Control.Monad.Maybe.Trans.Module.MaybeT
              .app(PS.Control.Bind.Module.bind
                     .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
                     .app(x)
                     .app({ v1 : Any ->
                   when {
                    (v1 is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                      PS.Control.Applicative.Module.pure
                        .app((dictMonad as Map<String, Any>)["Applicative0"]!!
                               .app(Unit))
                        .app(PS.Data.Maybe.Module.Nothing);
                    }
                    (v1 is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
                      val y = v1.value0;
                      object   {
                          val v2 = f1.app(y);
                        }
                        .run({
                          val v2 = this.v2;
                          val m = v2;
                          m;
                        });
                    }
                    else -> (error("Error in Pattern Match") as Any)
                  }
                }));}
      })
  };
  fun __rec_applyMaybeT(): Any = { dictMonad : Any ->
     PS.Control.Apply.Module.Apply
       .app({ _ : Any ->
            PS.Control.Monad.Maybe.Trans.Module.functorMaybeT
              .app((((dictMonad as Map<String, Any>)["Bind1"]!!
                       .app(Unit) as Map<String, Any>)["Apply0"]!!
                      .app(Unit) as Map<String, Any>)["Functor0"]!!
                     .app(Unit))
         })
       .app(PS.Control.Monad.Module.ap
              .app(PS.Control.Monad.Maybe.Trans.Module.monadMaybeT
                     .app(dictMonad)))
  };
  fun __rec_applicativeMaybeT(): Any = { dictMonad : Any ->
     PS.Control.Applicative.Module.Applicative
       .app({ _ : Any ->
            PS.Control.Monad.Maybe.Trans.Module.applyMaybeT.app(dictMonad)
         })
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Control.Monad.Maybe.Trans.Module.MaybeT)
              .app(PS.Control.Semigroupoid.Module.compose
                     .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                     .app(PS.Control.Applicative.Module.pure
                            .app(
                         (dictMonad as Map<String, Any>)["Applicative0"]!!
                           .app(Unit)))
                     .app(PS.Data.Maybe.Module.Just)))
  };
  @JvmField
  val monadAskMaybeT = { dictMonadAsk : Any ->
     PS.Control.Monad.Reader.Class.Module.MonadAsk
       .app({ _ : Any ->
            PS.Control.Monad.Maybe.Trans.Module.monadMaybeT
              .app((dictMonadAsk as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app(PS.Control.Monad.Trans.Class.Module.lift
              .app(PS.Control.Monad.Maybe.Trans.Module.monadTransMaybeT)
              .app((dictMonadAsk as Map<String, Any>)["Monad0"]!!.app(Unit))
              .app(PS.Control.Monad.Reader.Class.Module.ask.app(dictMonadAsk)))
  };
  @JvmField
  val monadReaderMaybeT = { dictMonadReader : Any ->
     PS.Control.Monad.Reader.Class.Module.MonadReader
       .app({ _ : Any ->
            PS.Control.Monad.Maybe.Trans.Module.monadAskMaybeT
              .app((dictMonadReader as Map<String, Any>)["MonadAsk0"]!!
                     .app(Unit))
         })
       .app({ f : Any ->
         PS.Control.Monad.Maybe.Trans.Module.mapMaybeT
           .app(PS.Control.Monad.Reader.Class.Module.local.app(dictMonadReader)
                  .app(f))
      })
  };
  @JvmField
  val monadContMaybeT = { dictMonadCont : Any ->
     PS.Control.Monad.Cont.Class.Module.MonadCont
       .app({ _ : Any ->
            PS.Control.Monad.Maybe.Trans.Module.monadMaybeT
              .app((dictMonadCont as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app({ f : Any ->
         PS.Data.Function.Module.apply
           .app(PS.Control.Monad.Maybe.Trans.Module.MaybeT)
           .app(PS.Control.Monad.Cont.Class.Module.callCC.app(dictMonadCont)
                  .app({ c : Any ->
               object   {
                   val v = f
                             .app({ a : Any ->
                        PS.Data.Function.Module.apply
                          .app(PS.Control.Monad.Maybe.Trans.Module.MaybeT)
                          .app(PS.Data.Function.Module.apply.app(c)
                                 .app(PS.Data.Maybe.Module.Just.app(a)))
                     });
                 }
                 .run({
                  val v = this.v;
                  val m = v;
                  m;
                })
            }))
      })
  };
  @JvmField
  val monadEffectMaybe = { dictMonadEffect : Any ->
     PS.Effect.Class.Module.MonadEffect
       .app({ _ : Any ->
            PS.Control.Monad.Maybe.Trans.Module.monadMaybeT
              .app((dictMonadEffect as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Control.Monad.Trans.Class.Module.lift
                     .app(PS.Control.Monad.Maybe.Trans.Module.monadTransMaybeT)
                     .app((dictMonadEffect as Map<String, Any>)["Monad0"]!!
                            .app(Unit)))
              .app(PS.Effect.Class.Module.liftEffect.app(dictMonadEffect)))
  };
  @JvmField
  val monadRecMaybeT = { dictMonadRec : Any ->
     PS.Control.Monad.Rec.Class.Module.MonadRec
       .app({ _ : Any ->
            PS.Control.Monad.Maybe.Trans.Module.monadMaybeT
              .app((dictMonadRec as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app({ f : Any ->
         PS.Control.Semigroupoid.Module.compose
           .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
           .app(PS.Control.Monad.Maybe.Trans.Module.MaybeT)
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
                          (m_tick is PS.Data.Maybe.Module._Type_Maybe
                                       .Nothing) -> {
                            PS.Control.Monad.Rec.Class.Module.Done
                              .app(PS.Data.Maybe.Module.Nothing);
                          }
                          (m_tick is PS.Data.Maybe.Module._Type_Maybe
                                       .Just)&& (m_tick
                                                   .value0 is PS.Control.Monad.Rec.Class.Module._Type_Step
                                                                .Loop) -> {
                            val a1 = m_tick.value0.value0;
                            PS.Control.Monad.Rec.Class.Module.Loop.app(a1);
                          }
                          (m_tick is PS.Data.Maybe.Module._Type_Maybe
                                       .Just)&& (m_tick
                                                   .value0 is PS.Control.Monad.Rec.Class.Module._Type_Step
                                                                .Done) -> {
                            val b = m_tick.value0.value0;
                            PS.Control.Monad.Rec.Class.Module.Done
                              .app(PS.Data.Maybe.Module.Just.app(b));
                          }
                          else -> (error("Error in Pattern Match") as Any)
                        })
                    });
                })
            }))
      })
  };
  @JvmField
  val monadStateMaybeT = { dictMonadState : Any ->
     PS.Control.Monad.State.Class.Module.MonadState
       .app({ _ : Any ->
            PS.Control.Monad.Maybe.Trans.Module.monadMaybeT
              .app((dictMonadState as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app({ f : Any ->
         PS.Control.Monad.Trans.Class.Module.lift
           .app(PS.Control.Monad.Maybe.Trans.Module.monadTransMaybeT)
           .app((dictMonadState as Map<String, Any>)["Monad0"]!!.app(Unit))
           .app(PS.Control.Monad.State.Class.Module.state.app(dictMonadState)
                  .app(f))
      })
  };
  @JvmField
  val monadTellMaybeT = { dictMonadTell : Any ->
     PS.Control.Monad.Writer.Class.Module.MonadTell
       .app({ _ : Any ->
            PS.Control.Monad.Maybe.Trans.Module.monadMaybeT
              .app((dictMonadTell as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Control.Monad.Trans.Class.Module.lift
                     .app(PS.Control.Monad.Maybe.Trans.Module.monadTransMaybeT)
                     .app((dictMonadTell as Map<String, Any>)["Monad0"]!!
                            .app(Unit)))
              .app(PS.Control.Monad.Writer.Class.Module.tell.app(dictMonadTell))
    )
  };
  @JvmField
  val monadWriterMaybeT = { dictMonadWriter : Any ->
     PS.Control.Monad.Writer.Class.Module.MonadWriter
       .app({ _ : Any ->
            PS.Control.Monad.Maybe.Trans.Module.monadTellMaybeT
              .app((dictMonadWriter as Map<String, Any>)["MonadTell0"]!!
                     .app(Unit))
         })
       .app(PS.Control.Monad.Maybe.Trans.Module.mapMaybeT
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
                              .app(PS.Data.Maybe.Module.functorMaybe)
                              .app({ r : Any ->
                                   PS.Data.Tuple.Module.Tuple.app(r).app(w)
                                })
                              .app(a));
                   }
                   else -> (error("Error in Pattern Match") as Any)
                 }
               })
           }))
       .app(PS.Control.Monad.Maybe.Trans.Module.mapMaybeT
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
                      (a is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                        PS.Data.Tuple.Module.Tuple
                          .app(PS.Data.Maybe.Module.Nothing)
                          .app(PS.Control.Category.Module.identity
                                 .app(PS.Control.Category.Module.categoryFn));
                      }
                      (a is PS.Data.Maybe.Module._Type_Maybe
                              .Just)&& (a
                                          .value0 is PS.Data.Tuple.Module._Type_Tuple
                                                       .Tuple) -> {
                        val v1 = a.value0.value0;
                        val f = a.value0.value1;
                        PS.Data.Tuple.Module.Tuple
                          .app(PS.Data.Maybe.Module.Just.app(v1))
                          .app(f);
                      }
                      else -> (error("Error in Pattern Match") as Any)
                    });}))
        }))
  };
  @JvmField
  val monadThrowMaybeT = { dictMonadThrow : Any ->
     PS.Control.Monad.Error.Class.Module.MonadThrow
       .app({ _ : Any ->
            PS.Control.Monad.Maybe.Trans.Module.monadMaybeT
              .app((dictMonadThrow as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app({ e : Any ->
         PS.Control.Monad.Trans.Class.Module.lift
           .app(PS.Control.Monad.Maybe.Trans.Module.monadTransMaybeT)
           .app((dictMonadThrow as Map<String, Any>)["Monad0"]!!.app(Unit))
           .app(PS.Control.Monad.Error.Class.Module.throwError
                  .app(dictMonadThrow)
                  .app(e))
      })
  };
  @JvmField
  val monadErrorMaybeT = { dictMonadError : Any ->
     PS.Control.Monad.Error.Class.Module.MonadError
       .app({ _ : Any ->
            PS.Control.Monad.Maybe.Trans.Module.monadThrowMaybeT
              .app((dictMonadError as Map<String, Any>)["MonadThrow0"]!!
                     .app(Unit))
         })
       .app({ v : Any ->
         { h : Any ->
          val m = v;
            val h1 = h;
            PS.Data.Function.Module.apply
              .app(PS.Control.Monad.Maybe.Trans.Module.MaybeT)
              .app(PS.Control.Monad.Error.Class.Module.catchError
                     .app(dictMonadError)
                     .app(m)
                     .app({ a : Any ->
                   object   {
                       val v1 = h1.app(a);
                     }
                     .run({
                      val v1 = this.v1;
                      val b = v1;
                      b;
                    })
                }));}
      })
  };
  @JvmField
  val altMaybeT = { dictMonad : Any ->
     PS.Control.Alt.Module.Alt
       .app({ _ : Any ->
            PS.Control.Monad.Maybe.Trans.Module.functorMaybeT
              .app((((dictMonad as Map<String, Any>)["Bind1"]!!
                       .app(Unit) as Map<String, Any>)["Apply0"]!!
                      .app(Unit) as Map<String, Any>)["Functor0"]!!
                     .app(Unit))
         })
       .app({ v : Any ->
         { v1 : Any ->
          val m1 = v;
            val m2 = v1;
            PS.Control.Monad.Maybe.Trans.Module.MaybeT
              .app(PS.Control.Bind.Module.bind
                     .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
                     .app(m1)
                     .app({ v2 : Any ->
                  val m = v2;
                    when {
                      (m is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                        m2;
                      }
                      else -> {
                        val ja = m;
                        PS.Control.Applicative.Module.pure
                          .app((dictMonad as Map<String, Any>)["Applicative0"]!!
                                 .app(Unit))
                          .app(ja);
                      }
                    };}));}
      })
  };
  @JvmField
  val plusMaybeT = { dictMonad : Any ->
     PS.Control.Plus.Module.Plus
       .app({ _ : Any ->
            PS.Control.Monad.Maybe.Trans.Module.altMaybeT.app(dictMonad)
         })
       .app(PS.Control.Monad.Maybe.Trans.Module.MaybeT
              .app(PS.Control.Applicative.Module.pure
                     .app((dictMonad as Map<String, Any>)["Applicative0"]!!
                            .app(Unit))
                     .app(PS.Data.Maybe.Module.Nothing)))
  };
  @JvmField
  val alternativeMaybeT = { dictMonad : Any ->
     PS.Control.Alternative.Module.Alternative
       .app({ _ : Any ->
            PS.Control.Monad.Maybe.Trans.Module.applicativeMaybeT.app(dictMonad)
         })
       .app({ _ : Any ->
         PS.Control.Monad.Maybe.Trans.Module.plusMaybeT.app(dictMonad)
      })
  };
  @JvmField
  val monadZeroMaybeT = { dictMonad : Any ->
     PS.Control.MonadZero.Module.MonadZero
       .app({ _ : Any ->
            PS.Control.Monad.Maybe.Trans.Module.alternativeMaybeT.app(dictMonad)
         })
       .app({ _ : Any ->
         PS.Control.Monad.Maybe.Trans.Module.monadMaybeT.app(dictMonad)
      })
  };
  @JvmField
  val monadPlusMaybeT = { dictMonad : Any ->
     PS.Control.MonadPlus.Module.MonadPlus
       .app({ _ : Any ->
         PS.Control.Monad.Maybe.Trans.Module.monadZeroMaybeT.app(dictMonad)
      })
  };
}