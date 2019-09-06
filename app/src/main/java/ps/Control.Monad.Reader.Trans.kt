@file:Suppress("UNCHECKED_CAST")
package PS.Control.Monad.Reader.Trans
import Foreign.PsRuntime.app
object Module  {
  @JvmField val ReaderT = { x : Any -> x};
  @JvmField
  val withReaderT = { f : Any ->
     { v : Any ->
       when {
        else -> {
          val f1 = f;
          val m = v;
          PS.Control.Monad.Reader.Trans.Module.ReaderT
            .app(PS.Control.Semigroupoid.Module.compose
                   .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                   .app(m)
                   .app(f1));
        }
      }
    }
  };
  @JvmField val runReaderT = { v : Any -> when { else -> { val x = v; x; } }};
  @JvmField
  val newtypeReaderT = PS.Data.Newtype.Module.Newtype
                         .app({ n : Any ->
                              when {
                               else -> {
                                 val a = n;
                                 a;
                               }
                             }
                           })
                         .app(PS.Control.Monad.Reader.Trans.Module.ReaderT);
  @JvmField
  val monadTransReaderT = PS.Control.Monad.Trans.Class.Module.MonadTrans
                            .app({ dictMonad : Any ->
       PS.Control.Semigroupoid.Module.compose
         .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
         .app(PS.Control.Monad.Reader.Trans.Module.ReaderT)
         .app(PS.Data.Function.Module._const)
    });
  @JvmField
  val mapReaderT = { f : Any ->
     { v : Any ->
       when {
        else -> {
          val f1 = f;
          val m = v;
          PS.Control.Monad.Reader.Trans.Module.ReaderT
            .app(PS.Control.Semigroupoid.Module.compose
                   .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                   .app(f1)
                   .app(m));
        }
      }
    }
  };
  @JvmField
  val functorReaderT = { dictFunctor : Any ->
     PS.Data.Functor.Module.Functor
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Control.Monad.Reader.Trans.Module.mapReaderT)
              .app(PS.Data.Functor.Module.map.app(dictFunctor)))
  };
  @JvmField val distributiveReaderT = (::__rec_distributiveReaderT)();
  fun __rec_distributiveReaderT(): Any = { dictDistributive : Any ->
     PS.Data.Distributive.Module.Distributive
       .app({ _ : Any ->
            PS.Control.Monad.Reader.Trans.Module.functorReaderT
              .app((dictDistributive as Map<String, Any>)["Functor0"]!!
                     .app(Unit))
         })
       .app({ dictFunctor : Any ->
            { f : Any ->
              PS.Control.Semigroupoid.Module.compose
                .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                .app(PS.Data.Distributive.Module.distribute
                       .app(
                         PS.Control.Monad.Reader.Trans.Module.distributiveReaderT
                           .app(dictDistributive))
                       .app(dictFunctor))
                .app(PS.Data.Functor.Module.map.app(dictFunctor).app(f))
           }
         })
       .app({ dictFunctor : Any ->
         { a : Any ->
           PS.Control.Monad.Reader.Trans.Module.ReaderT
             .app({ e : Any ->
               PS.Data.Distributive.Module.collect.app(dictDistributive)
                 .app(dictFunctor)
                 .app({ r : Any ->
                      when {
                       else -> {
                         val r_tick = r;
                         r_tick.app(e);
                       }
                     }
                   })
                 .app(a)
            })
        }
      })
  };
  @JvmField
  val applyReaderT = { dictApply : Any ->
     PS.Control.Apply.Module.Apply
       .app({ _ : Any ->
            PS.Control.Monad.Reader.Trans.Module.functorReaderT
              .app((dictApply as Map<String, Any>)["Functor0"]!!.app(Unit))
         })
       .app({ v : Any ->
         { v1 : Any ->
           when {
            else -> {
              val f = v;
              val v2 = v1;
              PS.Control.Monad.Reader.Trans.Module.ReaderT
                .app({ r : Any ->
                   PS.Control.Apply.Module.apply.app(dictApply).app(f.app(r))
                     .app(v2.app(r))
                });
            }
          }
        }
      })
  };
  @JvmField
  val bindReaderT = { dictBind : Any ->
     PS.Control.Bind.Module.Bind
       .app({ _ : Any ->
            PS.Control.Monad.Reader.Trans.Module.applyReaderT
              .app((dictBind as Map<String, Any>)["Apply0"]!!.app(Unit))
         })
       .app({ v : Any ->
         { k : Any ->
           when {
            else -> {
              val m = v;
              val k1 = k;
              PS.Control.Monad.Reader.Trans.Module.ReaderT
                .app({ r : Any ->
                   PS.Control.Bind.Module.bind.app(dictBind).app(m.app(r))
                     .app({ a : Any ->
                       object   {
                           val v1 = k1.app(a);
                         }
                         .run({
                          val v1 = this.v1;
                          when { else -> { val f = v1; f.app(r); } };
                        })
                    })
                });
            }
          }
        }
      })
  };
  @JvmField
  val semigroupReaderT = { dictApply : Any ->
     { dictSemigroup : Any ->
       PS.Data.Semigroup.Module.Semigroup
         .app(PS.Control.Apply.Module.lift2
                .app(PS.Control.Monad.Reader.Trans.Module.applyReaderT
                       .app(dictApply))
                .app(PS.Data.Semigroup.Module.append.app(dictSemigroup)))
    }
  };
  @JvmField
  val applicativeReaderT = { dictApplicative : Any ->
     PS.Control.Applicative.Module.Applicative
       .app({ _ : Any ->
            PS.Control.Monad.Reader.Trans.Module.applyReaderT
              .app((dictApplicative as Map<String, Any>)["Apply0"]!!.app(Unit))
         })
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Control.Monad.Reader.Trans.Module.ReaderT)
              .app(PS.Control.Semigroupoid.Module.compose
                     .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                     .app(PS.Data.Function.Module._const)
                     .app(PS.Control.Applicative.Module.pure
                            .app(dictApplicative))))
  };
  @JvmField
  val monadReaderT = { dictMonad : Any ->
     PS.Control.Monad.Module.Monad
       .app({ _ : Any ->
            PS.Control.Monad.Reader.Trans.Module.applicativeReaderT
              .app((dictMonad as Map<String, Any>)["Applicative0"]!!.app(Unit))
         })
       .app({ _ : Any ->
         PS.Control.Monad.Reader.Trans.Module.bindReaderT
           .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
      })
  };
  @JvmField
  val monadAskReaderT = { dictMonad : Any ->
     PS.Control.Monad.Reader.Class.Module.MonadAsk
       .app({ _ : Any ->
            PS.Control.Monad.Reader.Trans.Module.monadReaderT.app(dictMonad)
         })
       .app(PS.Control.Monad.Reader.Trans.Module.ReaderT
              .app(PS.Control.Applicative.Module.pure
                     .app((dictMonad as Map<String, Any>)["Applicative0"]!!
                            .app(Unit))))
  };
  @JvmField
  val monadReaderReaderT = { dictMonad : Any ->
     PS.Control.Monad.Reader.Class.Module.MonadReader
       .app({ _ : Any ->
            PS.Control.Monad.Reader.Trans.Module.monadAskReaderT.app(dictMonad)
         })
       .app(PS.Control.Monad.Reader.Trans.Module.withReaderT)
  };
  @JvmField
  val monadContReaderT = { dictMonadCont : Any ->
     PS.Control.Monad.Cont.Class.Module.MonadCont
       .app({ _ : Any ->
            PS.Control.Monad.Reader.Trans.Module.monadReaderT
              .app((dictMonadCont as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app({ f : Any ->
         PS.Control.Monad.Reader.Trans.Module.ReaderT
           .app({ r : Any ->
             PS.Control.Monad.Cont.Class.Module.callCC.app(dictMonadCont)
               .app({ c : Any ->
                 object   {
                     val v = f
                               .app(PS.Control.Semigroupoid.Module.compose
                                      .app(
                                        PS.Control.Semigroupoid.Module.semigroupoidFn
                                      )
                                      .app(
                                        PS.Control.Monad.Reader.Trans.Module.ReaderT
                                      )
                                      .app(
                         PS.Control.Semigroupoid.Module.compose
                           .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                           .app(PS.Data.Function.Module._const)
                           .app(c)));
                   }
                   .run({
                    val v = this.v;
                    when { else -> { val f_tick = v; f_tick.app(r); } };
                  })
              })
          })
      })
  };
  @JvmField
  val monadEffectReader = { dictMonadEffect : Any ->
     PS.Effect.Class.Module.MonadEffect
       .app({ _ : Any ->
            PS.Control.Monad.Reader.Trans.Module.monadReaderT
              .app((dictMonadEffect as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Control.Monad.Trans.Class.Module.lift
                     .app(PS.Control.Monad.Reader.Trans.Module.monadTransReaderT
                     )
                     .app((dictMonadEffect as Map<String, Any>)["Monad0"]!!
                            .app(Unit)))
              .app(PS.Effect.Class.Module.liftEffect.app(dictMonadEffect)))
  };
  @JvmField
  val monadRecReaderT = { dictMonadRec : Any ->
     PS.Control.Monad.Rec.Class.Module.MonadRec
       .app({ _ : Any ->
            PS.Control.Monad.Reader.Trans.Module.monadReaderT
              .app((dictMonadRec as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app({ k : Any ->
         { a : Any ->
           object   {
               val k_tick = { r : Any ->
                  { a_tick : Any ->
                    object   {
                        val v = k.app(a_tick);
                      }
                      .run({
                       val v = this.v;
                       when {
                         else -> {
                           val f = v;
                           PS.Control.Bind.Module.bindFlipped
                             .app(
                               ((dictMonadRec as Map<String, Any>)["Monad0"]!!
                                  .app(Unit) as Map<String, Any>)["Bind1"]!!
                                 .app(Unit))
                             .app(PS.Control.Applicative.Module.pure
                                    .app(
                                 ((dictMonadRec as Map<String, Any>)["Monad0"]!!
                                    .app(Unit
                                   ) as Map<String, Any>)["Applicative0"]!!
                                   .app(Unit)))
                             .app(f.app(r));
                         }
                       };
                     })
                 }
               };
             }
             .run({
              val k_tick = this.k_tick;
              PS.Control.Monad.Reader.Trans.Module.ReaderT
                .app({ r : Any ->
                   PS.Control.Monad.Rec.Class.Module.tailRecM.app(dictMonadRec)
                     .app(k_tick.app(r))
                     .app(a)
                });
            })
        }
      })
  };
  @JvmField
  val monadStateReaderT = { dictMonadState : Any ->
     PS.Control.Monad.State.Class.Module.MonadState
       .app({ _ : Any ->
            PS.Control.Monad.Reader.Trans.Module.monadReaderT
              .app((dictMonadState as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Control.Monad.Trans.Class.Module.lift
                     .app(PS.Control.Monad.Reader.Trans.Module.monadTransReaderT
                     )
                     .app((dictMonadState as Map<String, Any>)["Monad0"]!!
                            .app(Unit)))
              .app(PS.Control.Monad.State.Class.Module.state.app(dictMonadState)
      ))
  };
  @JvmField
  val monadTellReaderT = { dictMonadTell : Any ->
     PS.Control.Monad.Writer.Class.Module.MonadTell
       .app({ _ : Any ->
            PS.Control.Monad.Reader.Trans.Module.monadReaderT
              .app((dictMonadTell as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Control.Monad.Trans.Class.Module.lift
                     .app(PS.Control.Monad.Reader.Trans.Module.monadTransReaderT
                     )
                     .app((dictMonadTell as Map<String, Any>)["Monad0"]!!
                            .app(Unit)))
              .app(PS.Control.Monad.Writer.Class.Module.tell.app(dictMonadTell))
    )
  };
  @JvmField
  val monadWriterReaderT = { dictMonadWriter : Any ->
     PS.Control.Monad.Writer.Class.Module.MonadWriter
       .app({ _ : Any ->
            PS.Control.Monad.Reader.Trans.Module.monadTellReaderT
              .app((dictMonadWriter as Map<String, Any>)["MonadTell0"]!!
                     .app(Unit))
         })
       .app(PS.Control.Monad.Reader.Trans.Module.mapReaderT
              .app(PS.Control.Monad.Writer.Class.Module.listen
                     .app(dictMonadWriter)))
       .app(PS.Control.Monad.Reader.Trans.Module.mapReaderT
              .app(PS.Control.Monad.Writer.Class.Module.pass
                     .app(dictMonadWriter)))
  };
  @JvmField
  val monadThrowReaderT = { dictMonadThrow : Any ->
     PS.Control.Monad.Error.Class.Module.MonadThrow
       .app({ _ : Any ->
            PS.Control.Monad.Reader.Trans.Module.monadReaderT
              .app((dictMonadThrow as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Control.Monad.Trans.Class.Module.lift
                     .app(PS.Control.Monad.Reader.Trans.Module.monadTransReaderT
                     )
                     .app((dictMonadThrow as Map<String, Any>)["Monad0"]!!
                            .app(Unit)))
              .app(PS.Control.Monad.Error.Class.Module.throwError
                     .app(dictMonadThrow)))
  };
  @JvmField
  val monadErrorReaderT = { dictMonadError : Any ->
     PS.Control.Monad.Error.Class.Module.MonadError
       .app({ _ : Any ->
            PS.Control.Monad.Reader.Trans.Module.monadThrowReaderT
              .app((dictMonadError as Map<String, Any>)["MonadThrow0"]!!
                     .app(Unit))
         })
       .app({ v : Any ->
         { h : Any ->
           when {
            else -> {
              val m = v;
              val h1 = h;
              PS.Control.Monad.Reader.Trans.Module.ReaderT
                .app({ r : Any ->
                   PS.Control.Monad.Error.Class.Module.catchError
                     .app(dictMonadError)
                     .app(m.app(r))
                     .app({ e : Any ->
                       object   {
                           val v1 = h1.app(e);
                         }
                         .run({
                          val v1 = this.v1;
                          when { else -> { val f = v1; f.app(r); } };
                        })
                    })
                });
            }
          }
        }
      })
  };
  @JvmField
  val monoidReaderT = { dictApplicative : Any ->
     { dictMonoid : Any ->
       PS.Data.Monoid.Module.Monoid
         .app({ _ : Any ->
              PS.Control.Monad.Reader.Trans.Module.semigroupReaderT
                .app((dictApplicative as Map<String, Any>)["Apply0"]!!.app(Unit)
                )
                .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!.app(Unit))
           })
         .app(PS.Control.Applicative.Module.pure
                .app(PS.Control.Monad.Reader.Trans.Module.applicativeReaderT
                       .app(dictApplicative))
                .app(PS.Data.Monoid.Module.mempty.app(dictMonoid)))
    }
  };
  @JvmField
  val altReaderT = { dictAlt : Any ->
     PS.Control.Alt.Module.Alt
       .app({ _ : Any ->
            PS.Control.Monad.Reader.Trans.Module.functorReaderT
              .app((dictAlt as Map<String, Any>)["Functor0"]!!.app(Unit))
         })
       .app({ v : Any ->
         { v1 : Any ->
           when {
            else -> {
              val m = v;
              val n = v1;
              PS.Control.Monad.Reader.Trans.Module.ReaderT
                .app({ r : Any ->
                   PS.Control.Alt.Module.alt.app(dictAlt).app(m.app(r))
                     .app(n.app(r))
                });
            }
          }
        }
      })
  };
  @JvmField
  val plusReaderT = { dictPlus : Any ->
     PS.Control.Plus.Module.Plus
       .app({ _ : Any ->
            PS.Control.Monad.Reader.Trans.Module.altReaderT
              .app((dictPlus as Map<String, Any>)["Alt0"]!!.app(Unit))
         })
       .app(PS.Control.Monad.Reader.Trans.Module.ReaderT
              .app(PS.Data.Function.Module._const
                     .app(PS.Control.Plus.Module.empty.app(dictPlus))))
  };
  @JvmField
  val alternativeReaderT = { dictAlternative : Any ->
     PS.Control.Alternative.Module.Alternative
       .app({ _ : Any ->
            PS.Control.Monad.Reader.Trans.Module.applicativeReaderT
              .app((dictAlternative as Map<String, Any>)["Applicative0"]!!
                     .app(Unit))
         })
       .app({ _ : Any ->
         PS.Control.Monad.Reader.Trans.Module.plusReaderT
           .app((dictAlternative as Map<String, Any>)["Plus1"]!!.app(Unit))
      })
  };
  @JvmField
  val monadZeroReaderT = { dictMonadZero : Any ->
     PS.Control.MonadZero.Module.MonadZero
       .app({ _ : Any ->
            PS.Control.Monad.Reader.Trans.Module.alternativeReaderT
              .app((dictMonadZero as Map<String, Any>)["Alternative1"]!!
                     .app(Unit))
         })
       .app({ _ : Any ->
         PS.Control.Monad.Reader.Trans.Module.monadReaderT
           .app((dictMonadZero as Map<String, Any>)["Monad0"]!!.app(Unit))
      })
  };
  @JvmField
  val monadPlusReaderT = { dictMonadPlus : Any ->
     PS.Control.MonadPlus.Module.MonadPlus
       .app({ _ : Any ->
         PS.Control.Monad.Reader.Trans.Module.monadZeroReaderT
           .app((dictMonadPlus as Map<String, Any>)["MonadZero0"]!!.app(Unit))
      })
  };
}