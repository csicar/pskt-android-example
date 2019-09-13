@file:Suppress("UNCHECKED_CAST")

package PS.Control.Monad.Writer.Trans
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val WriterT = { x : Any -> x};
  @JvmField val runWriterT = { v : Any ->val x = v; x;};
  @JvmField
  val newtypeWriterT = PS.Data.Newtype.Module.Newtype
                         .app({ n : Any ->
                             val a = n;
                               a;})
                         .app(PS.Control.Monad.Writer.Trans.Module.WriterT);
  @JvmField
  val monadTransWriterT = { dictMonoid : Any ->
     PS.Control.Monad.Trans.Class.Module.MonadTrans
       .app({ dictMonad : Any ->
         { m : Any ->
           PS.Control.Monad.Writer.Trans.Module.WriterT
             .app(PS.Control.Bind.Module.bind
                    .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
                    .app(m)
                    .app({ v : Any ->
                val a = v;
                  PS.Data.Function.Module.apply
                    .app(PS.Control.Applicative.Module.pure
                           .app(
                        (dictMonad as Map<String, Any>)["Applicative0"]!!
                          .app(Unit)))
                    .app(PS.Data.Tuple.Module.Tuple.app(a)
                           .app(PS.Data.Monoid.Module.mempty.app(dictMonoid)));}
            ))
        }
      })
  };
  @JvmField
  val mapWriterT = { f : Any ->
     { v : Any ->
      val f1 = f;
        val m = v;
        PS.Control.Monad.Writer.Trans.Module.WriterT.app(f1.app(m));}
  };
  @JvmField
  val functorWriterT = { dictFunctor : Any ->
     PS.Data.Functor.Module.Functor
       .app({ f : Any ->
         PS.Data.Function.Module.apply
           .app(PS.Control.Monad.Writer.Trans.Module.mapWriterT)
           .app(PS.Data.Functor.Module.map.app(dictFunctor)
                  .app({ v : Any ->
               when {
                (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                  val a = v.value0;
                  val w = v.value1;
                  PS.Data.Tuple.Module.Tuple.app(f.app(a)).app(w);
                }
                else -> (error("Error in Pattern Match") as Any)
              }
            }))
      })
  };
  @JvmField
  val execWriterT = { dictFunctor : Any ->
     { v : Any ->
      val m = v;
        PS.Data.Functor.Module.map.app(dictFunctor)
          .app(PS.Data.Tuple.Module.snd)
          .app(m);}
  };
  @JvmField
  val applyWriterT = { dictSemigroup : Any ->
     { dictApply : Any ->
       PS.Control.Apply.Module.Apply
         .app({ _ : Any ->
              PS.Control.Monad.Writer.Trans.Module.functorWriterT
                .app((dictApply as Map<String, Any>)["Functor0"]!!.app(Unit))
           })
         .app({ v : Any ->
           { v1 : Any ->
            val f = v;
              val v2 = v1;
              PS.Control.Monad.Writer.Trans.Module.WriterT
                .app(object   {
                         val k = { v3 : Any ->
                            { v4 : Any ->
                              when {
                               (v3 is PS.Data.Tuple.Module._Type_Tuple
                                        .Tuple)&&
                               (v4 is PS.Data.Tuple.Module._Type_Tuple
                                        .Tuple) -> {
                                 val a = v3.value0;
                                 val w = v3.value1;
                                 val b = v4.value0;
                                 val w_tick = v4.value1;
                                 PS.Data.Tuple.Module.Tuple.app(a.app(b))
                                   .app(PS.Data.Semigroup.Module.append
                                          .app(dictSemigroup)
                                          .app(w)
                                          .app(w_tick));
                               }
                               else -> (error("Error in Pattern Match") as Any)
                             }
                           }
                         };
                       }
                       .run({
                    val k = this.k;
                    PS.Control.Apply.Module.apply.app(dictApply)
                      .app(PS.Data.Functor.Module.map
                             .app((dictApply as Map<String, Any>)["Functor0"]!!
                                    .app(Unit))
                             .app(k)
                             .app(f))
                      .app(v2);
                  }));}
        })
    }
  };
  @JvmField
  val bindWriterT = { dictSemigroup : Any ->
     { dictBind : Any ->
       PS.Control.Bind.Module.Bind
         .app({ _ : Any ->
              PS.Control.Monad.Writer.Trans.Module.applyWriterT
                .app(dictSemigroup)
                .app((dictBind as Map<String, Any>)["Apply0"]!!.app(Unit))
           })
         .app({ v : Any ->
           { k : Any ->
            val m = v;
              val k1 = k;
              PS.Data.Function.Module.apply
                .app(PS.Control.Monad.Writer.Trans.Module.WriterT)
                .app(PS.Control.Bind.Module.bind.app(dictBind).app(m)
                       .app({ v1 : Any ->
                     when {
                      (v1 is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                        val a = v1.value0;
                        val w = v1.value1;
                        object   {
                            val v2 = k1.app(a);
                          }
                          .run({
                            val v2 = this.v2;
                            val wt = v2;
                            PS.Data.Functor.Module.map
                              .app(((dictBind as Map<String, Any>)["Apply0"]!!
                                      .app(Unit
                                     ) as Map<String, Any>)["Functor0"]!!
                                     .app(Unit))
                              .app({ v3 : Any ->
                                   when {
                                    (v3 is PS.Data.Tuple.Module._Type_Tuple
                                             .Tuple) -> {
                                      val b = v3.value0;
                                      val w_tick = v3.value1;
                                      PS.Data.Tuple.Module.Tuple.app(b)
                                        .app(PS.Data.Semigroup.Module.append
                                               .app(dictSemigroup)
                                               .app(w)
                                               .app(w_tick));
                                    }
                                    else -> (error("Error in Pattern Match"
                                    ) as Any)
                                  }
                                })
                              .app(wt);
                          });
                      }
                      else -> (error("Error in Pattern Match") as Any)
                    }
                  }));}
        })
    }
  };
  @JvmField
  val applicativeWriterT = { dictMonoid : Any ->
     { dictApplicative : Any ->
       PS.Control.Applicative.Module.Applicative
         .app({ _ : Any ->
              PS.Control.Monad.Writer.Trans.Module.applyWriterT
                .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!.app(Unit))
                .app((dictApplicative as Map<String, Any>)["Apply0"]!!.app(Unit)
             )
           })
         .app({ a : Any ->
           PS.Data.Function.Module.apply
             .app(PS.Control.Monad.Writer.Trans.Module.WriterT)
             .app(PS.Data.Function.Module.apply
                    .app(PS.Control.Applicative.Module.pure.app(dictApplicative)
                    )
                    .app(PS.Data.Tuple.Module.Tuple.app(a)
                           .app(PS.Data.Monoid.Module.mempty.app(dictMonoid))))
        })
    }
  };
  @JvmField
  val monadWriterT = { dictMonoid : Any ->
     { dictMonad : Any ->
       PS.Control.Monad.Module.Monad
         .app({ _ : Any ->
              PS.Control.Monad.Writer.Trans.Module.applicativeWriterT
                .app(dictMonoid)
                .app((dictMonad as Map<String, Any>)["Applicative0"]!!.app(Unit)
             )
           })
         .app({ _ : Any ->
           PS.Control.Monad.Writer.Trans.Module.bindWriterT
             .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!.app(Unit))
             .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
        })
    }
  };
  @JvmField
  val monadAskWriterT = { dictMonoid : Any ->
     { dictMonadAsk : Any ->
       PS.Control.Monad.Reader.Class.Module.MonadAsk
         .app({ _ : Any ->
              PS.Control.Monad.Writer.Trans.Module.monadWriterT.app(dictMonoid)
                .app((dictMonadAsk as Map<String, Any>)["Monad0"]!!.app(Unit))
           })
         .app(PS.Control.Monad.Trans.Class.Module.lift
                .app(PS.Control.Monad.Writer.Trans.Module.monadTransWriterT
                       .app(dictMonoid))
                .app((dictMonadAsk as Map<String, Any>)["Monad0"]!!.app(Unit))
                .app(PS.Control.Monad.Reader.Class.Module.ask.app(dictMonadAsk))
      )
    }
  };
  @JvmField
  val monadReaderWriterT = { dictMonoid : Any ->
     { dictMonadReader : Any ->
       PS.Control.Monad.Reader.Class.Module.MonadReader
         .app({ _ : Any ->
              PS.Control.Monad.Writer.Trans.Module.monadAskWriterT
                .app(dictMonoid)
                .app((dictMonadReader as Map<String, Any>)["MonadAsk0"]!!
                       .app(Unit))
           })
         .app({ f : Any ->
           PS.Control.Monad.Writer.Trans.Module.mapWriterT
             .app(PS.Control.Monad.Reader.Class.Module.local
                    .app(dictMonadReader)
                    .app(f))
        })
    }
  };
  @JvmField
  val monadContWriterT = { dictMonoid : Any ->
     { dictMonadCont : Any ->
       PS.Control.Monad.Cont.Class.Module.MonadCont
         .app({ _ : Any ->
              PS.Control.Monad.Writer.Trans.Module.monadWriterT.app(dictMonoid)
                .app((dictMonadCont as Map<String, Any>)["Monad0"]!!.app(Unit))
           })
         .app({ f : Any ->
           PS.Data.Function.Module.apply
             .app(PS.Control.Monad.Writer.Trans.Module.WriterT)
             .app(PS.Control.Monad.Cont.Class.Module.callCC.app(dictMonadCont)
                    .app({ c : Any ->
                 object   {
                     val v = f
                               .app({ a : Any ->
                          PS.Data.Function.Module.apply
                            .app(PS.Control.Monad.Writer.Trans.Module.WriterT)
                            .app(c
                                   .app(PS.Data.Tuple.Module.Tuple.app(a)
                                          .app(PS.Data.Monoid.Module.mempty
                                                 .app(dictMonoid))))
                       });
                   }
                   .run({
                    val v = this.v;
                    val b = v;
                    b;
                  })
              }))
        })
    }
  };
  @JvmField
  val monadEffectWriter = { dictMonoid : Any ->
     { dictMonadEffect : Any ->
       PS.Effect.Class.Module.MonadEffect
         .app({ _ : Any ->
              PS.Control.Monad.Writer.Trans.Module.monadWriterT.app(dictMonoid)
                .app((dictMonadEffect as Map<String, Any>)["Monad0"]!!.app(Unit)
             )
           })
         .app(PS.Control.Semigroupoid.Module.compose
                .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                .app(PS.Control.Monad.Trans.Class.Module.lift
                       .app(
                         PS.Control.Monad.Writer.Trans.Module.monadTransWriterT
                           .app(dictMonoid))
                       .app((dictMonadEffect as Map<String, Any>)["Monad0"]!!
                              .app(Unit)))
                .app(PS.Effect.Class.Module.liftEffect.app(dictMonadEffect)))
    }
  };
  @JvmField
  val monadRecWriterT = { dictMonoid : Any ->
     { dictMonadRec : Any ->
       PS.Control.Monad.Rec.Class.Module.MonadRec
         .app({ _ : Any ->
              PS.Control.Monad.Writer.Trans.Module.monadWriterT.app(dictMonoid)
                .app((dictMonadRec as Map<String, Any>)["Monad0"]!!.app(Unit))
           })
         .app({ f : Any ->
           { a : Any ->
             object   {
                 val f_tick = { v : Any ->
                    when {
                     (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                       val a_tick = v.value0;
                       val w = v.value1;
                       object   {
                           val v1 = f.app(a_tick);
                         }
                         .run({
                           val v1 = this.v1;
                           val wt = v1;
                           PS.Control.Bind.Module.bind
                             .app(
                               ((dictMonadRec as Map<String, Any>)["Monad0"]!!
                                  .app(Unit) as Map<String, Any>)["Bind1"]!!
                                 .app(Unit))
                             .app(wt)
                             .app({ v2 : Any ->
                                when {
                                 (v2 is PS.Data.Tuple.Module._Type_Tuple
                                          .Tuple) -> {
                                   val m = v2.value0;
                                   val w1 = v2.value1;
                                   PS.Control.Applicative.Module.pure
                                     .app(
                                       ((dictMonadRec as Map<String, Any>)["Monad0"]!!
                                          .app(Unit
                                         ) as Map<String, Any>)["Applicative0"]!!
                                         .app(Unit))
                                     .app(when {
                                       (m is PS.Control.Monad.Rec.Class.Module._Type_Step
                                               .Loop) -> {
                                         val x = m.value0;
                                         PS.Control.Monad.Rec.Class.Module.Loop
                                           .app(PS.Data.Tuple.Module.Tuple
                                                  .app(x)
                                                  .app(
                                             PS.Data.Semigroup.Module.append
                                               .app(
                                                 (dictMonoid as Map<String, Any>)["Semigroup0"]!!
                                                   .app(Unit))
                                               .app(w)
                                               .app(w1)));
                                       }
                                       (m is PS.Control.Monad.Rec.Class.Module._Type_Step
                                               .Done) -> {
                                         val y = m.value0;
                                         PS.Control.Monad.Rec.Class.Module.Done
                                           .app(PS.Data.Tuple.Module.Tuple
                                                  .app(y)
                                                  .app(
                                             PS.Data.Semigroup.Module.append
                                               .app(
                                                 (dictMonoid as Map<String, Any>)["Semigroup0"]!!
                                                   .app(Unit))
                                               .app(w)
                                               .app(w1)));
                                       }
                                       else -> (error("Error in Pattern Match"
                                       ) as Any)
                                     });
                                 }
                                 else -> (error("Error in Pattern Match"
                                 ) as Any)
                               }
                             });
                         });
                     }
                     else -> (error("Error in Pattern Match") as Any)
                   }
                 };
               }
               .run({
                val f_tick = this.f_tick;
                PS.Data.Function.Module.apply
                  .app(PS.Control.Monad.Writer.Trans.Module.WriterT)
                  .app(PS.Control.Monad.Rec.Class.Module.tailRecM
                         .app(dictMonadRec)
                         .app(f_tick)
                         .app(PS.Data.Tuple.Module.Tuple.app(a)
                                .app(PS.Data.Monoid.Module.mempty
                                       .app(dictMonoid))));
              })
          }
        })
    }
  };
  @JvmField
  val monadStateWriterT = { dictMonoid : Any ->
     { dictMonadState : Any ->
       PS.Control.Monad.State.Class.Module.MonadState
         .app({ _ : Any ->
              PS.Control.Monad.Writer.Trans.Module.monadWriterT.app(dictMonoid)
                .app((dictMonadState as Map<String, Any>)["Monad0"]!!.app(Unit))
           })
         .app({ f : Any ->
           PS.Control.Monad.Trans.Class.Module.lift
             .app(PS.Control.Monad.Writer.Trans.Module.monadTransWriterT
                    .app(dictMonoid))
             .app((dictMonadState as Map<String, Any>)["Monad0"]!!.app(Unit))
             .app(PS.Control.Monad.State.Class.Module.state.app(dictMonadState)
                    .app(f))
        })
    }
  };
  @JvmField
  val monadTellWriterT = { dictMonoid : Any ->
     { dictMonad : Any ->
       PS.Control.Monad.Writer.Class.Module.MonadTell
         .app({ _ : Any ->
              PS.Control.Monad.Writer.Trans.Module.monadWriterT.app(dictMonoid)
                .app(dictMonad)
           })
         .app(PS.Control.Semigroupoid.Module.compose
                .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                .app(PS.Control.Monad.Writer.Trans.Module.WriterT)
                .app(PS.Control.Semigroupoid.Module.compose
                       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                       .app(PS.Control.Applicative.Module.pure
                              .app(
                           (dictMonad as Map<String, Any>)["Applicative0"]!!
                             .app(Unit)))
                       .app(PS.Data.Tuple.Module.Tuple
                              .app(PS.Data.Unit.Module.unit))))
    }
  };
  @JvmField
  val monadWriterWriterT = { dictMonoid : Any ->
     { dictMonad : Any ->
       PS.Control.Monad.Writer.Class.Module.MonadWriter
         .app({ _ : Any ->
              PS.Control.Monad.Writer.Trans.Module.monadTellWriterT
                .app(dictMonoid)
                .app(dictMonad)
           })
         .app({ v : Any ->
             val m = v;
               PS.Control.Monad.Writer.Trans.Module.WriterT
                 .app(PS.Control.Bind.Module.bind
                        .app((dictMonad as Map<String, Any>)["Bind1"]!!
                               .app(Unit))
                        .app(m)
                        .app({ v1 : Any ->
                      when {
                       (v1 is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                         val a = v1.value0;
                         val w = v1.value1;
                         PS.Data.Function.Module.apply
                           .app(PS.Control.Applicative.Module.pure
                                  .app(
                               (dictMonad as Map<String, Any>)["Applicative0"]!!
                                 .app(Unit)))
                           .app(PS.Data.Tuple.Module.Tuple
                                  .app(PS.Data.Tuple.Module.Tuple.app(a).app(w))
                                  .app(w));
                       }
                       else -> (error("Error in Pattern Match") as Any)
                     }
                   }));})
         .app({ v : Any ->
          val m = v;
            PS.Control.Monad.Writer.Trans.Module.WriterT
              .app(PS.Control.Bind.Module.bind
                     .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
                     .app(m)
                     .app({ v1 : Any ->
                   when {
                    (v1 is PS.Data.Tuple.Module._Type_Tuple
                             .Tuple)&& (v1
                                          .value0 is PS.Data.Tuple.Module._Type_Tuple
                                                       .Tuple) -> {
                      val a = v1.value0.value0;
                      val f = v1.value0.value1;
                      val w = v1.value1;
                      PS.Data.Function.Module.apply
                        .app(PS.Control.Applicative.Module.pure
                               .app(
                            (dictMonad as Map<String, Any>)["Applicative0"]!!
                              .app(Unit)))
                        .app(PS.Data.Tuple.Module.Tuple.app(a).app(f.app(w)));
                    }
                    else -> (error("Error in Pattern Match") as Any)
                  }
                }));})
    }
  };
  @JvmField
  val monadThrowWriterT = { dictMonoid : Any ->
     { dictMonadThrow : Any ->
       PS.Control.Monad.Error.Class.Module.MonadThrow
         .app({ _ : Any ->
              PS.Control.Monad.Writer.Trans.Module.monadWriterT.app(dictMonoid)
                .app((dictMonadThrow as Map<String, Any>)["Monad0"]!!.app(Unit))
           })
         .app({ e : Any ->
           PS.Control.Monad.Trans.Class.Module.lift
             .app(PS.Control.Monad.Writer.Trans.Module.monadTransWriterT
                    .app(dictMonoid))
             .app((dictMonadThrow as Map<String, Any>)["Monad0"]!!.app(Unit))
             .app(PS.Control.Monad.Error.Class.Module.throwError
                    .app(dictMonadThrow)
                    .app(e))
        })
    }
  };
  @JvmField
  val monadErrorWriterT = { dictMonoid : Any ->
     { dictMonadError : Any ->
       PS.Control.Monad.Error.Class.Module.MonadError
         .app({ _ : Any ->
              PS.Control.Monad.Writer.Trans.Module.monadThrowWriterT
                .app(dictMonoid)
                .app((dictMonadError as Map<String, Any>)["MonadThrow0"]!!
                       .app(Unit))
           })
         .app({ v : Any ->
           { h : Any ->
            val m = v;
              val h1 = h;
              PS.Data.Function.Module.apply
                .app(PS.Control.Monad.Writer.Trans.Module.WriterT)
                .app(PS.Control.Monad.Error.Class.Module.catchError
                       .app(dictMonadError)
                       .app(m)
                       .app({ e : Any ->
                     object   {
                         val v1 = h1.app(e);
                       }
                       .run({
                        val v1 = this.v1;
                        val a = v1;
                        a;
                      })
                  }));}
        })
    }
  };
  @JvmField
  val altWriterT = { dictAlt : Any ->
     PS.Control.Alt.Module.Alt
       .app({ _ : Any ->
            PS.Control.Monad.Writer.Trans.Module.functorWriterT
              .app((dictAlt as Map<String, Any>)["Functor0"]!!.app(Unit))
         })
       .app({ v : Any ->
         { v1 : Any ->
          val m = v;
            val n = v1;
            PS.Control.Monad.Writer.Trans.Module.WriterT
              .app(PS.Control.Alt.Module.alt.app(dictAlt).app(m).app(n));}
      })
  };
  @JvmField
  val plusWriterT = { dictPlus : Any ->
     PS.Control.Plus.Module.Plus
       .app({ _ : Any ->
            PS.Control.Monad.Writer.Trans.Module.altWriterT
              .app((dictPlus as Map<String, Any>)["Alt0"]!!.app(Unit))
         })
       .app(PS.Control.Monad.Writer.Trans.Module.WriterT
              .app(PS.Control.Plus.Module.empty.app(dictPlus)))
  };
  @JvmField
  val alternativeWriterT = { dictMonoid : Any ->
     { dictAlternative : Any ->
       PS.Control.Alternative.Module.Alternative
         .app({ _ : Any ->
              PS.Control.Monad.Writer.Trans.Module.applicativeWriterT
                .app(dictMonoid)
                .app((dictAlternative as Map<String, Any>)["Applicative0"]!!
                       .app(Unit))
           })
         .app({ _ : Any ->
           PS.Control.Monad.Writer.Trans.Module.plusWriterT
             .app((dictAlternative as Map<String, Any>)["Plus1"]!!.app(Unit))
        })
    }
  };
  @JvmField
  val monadZeroWriterT = { dictMonoid : Any ->
     { dictMonadZero : Any ->
       PS.Control.MonadZero.Module.MonadZero
         .app({ _ : Any ->
              PS.Control.Monad.Writer.Trans.Module.alternativeWriterT
                .app(dictMonoid)
                .app((dictMonadZero as Map<String, Any>)["Alternative1"]!!
                       .app(Unit))
           })
         .app({ _ : Any ->
           PS.Control.Monad.Writer.Trans.Module.monadWriterT.app(dictMonoid)
             .app((dictMonadZero as Map<String, Any>)["Monad0"]!!.app(Unit))
        })
    }
  };
  @JvmField
  val monadPlusWriterT = { dictMonoid : Any ->
     { dictMonadPlus : Any ->
       PS.Control.MonadPlus.Module.MonadPlus
         .app({ _ : Any ->
           PS.Control.Monad.Writer.Trans.Module.monadZeroWriterT.app(dictMonoid)
             .app((dictMonadPlus as Map<String, Any>)["MonadZero0"]!!.app(Unit))
        })
    }
  };
}