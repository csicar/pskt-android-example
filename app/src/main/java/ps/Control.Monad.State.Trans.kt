@file:Suppress("UNCHECKED_CAST")
package PS.Control.Monad.State.Trans
import Foreign.PsRuntime.app
object Module  {
  @JvmField val StateT = { x : Any -> x};
  @JvmField
  val withStateT = { f : Any ->
     { v : Any ->
       when {
        else -> {
          val f1 = f;
          val s = v;
          PS.Control.Monad.State.Trans.Module.StateT
            .app(PS.Control.Semigroupoid.Module.compose
                   .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                   .app(s)
                   .app(f1));
        }
      }
    }
  };
  @JvmField val runStateT = { v : Any -> when { else -> { val s = v; s; } }};
  @JvmField
  val newtypeStateT = PS.Data.Newtype.Module.Newtype
                        .app({ n : Any ->
                             when {
                              else -> {
                                val a = n;
                                a;
                              }
                            }
                          })
                        .app(PS.Control.Monad.State.Trans.Module.StateT);
  @JvmField
  val monadTransStateT = PS.Control.Monad.Trans.Class.Module.MonadTrans
                           .app({ dictMonad : Any ->
       { m : Any ->
         PS.Control.Monad.State.Trans.Module.StateT
           .app({ s : Any ->
             PS.Control.Bind.Module.bind
               .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
               .app(m)
               .app({ v : Any ->
                 when {
                  else -> {
                    val x = v;
                    PS.Data.Function.Module.apply
                      .app(PS.Control.Applicative.Module.pure
                             .app(
                          (dictMonad as Map<String, Any>)["Applicative0"]!!
                            .app(Unit)))
                      .app(PS.Data.Tuple.Module.Tuple.app(x).app(s));
                  }
                }
              })
          })
      }
    });
  @JvmField
  val mapStateT = { f : Any ->
     { v : Any ->
       when {
        else -> {
          val f1 = f;
          val m = v;
          PS.Control.Monad.State.Trans.Module.StateT
            .app(PS.Control.Semigroupoid.Module.compose
                   .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                   .app(f1)
                   .app(m));
        }
      }
    }
  };
  @JvmField
  val lazyStateT = PS.Control.Lazy.Module.Lazy
                     .app({ f : Any ->
       PS.Control.Monad.State.Trans.Module.StateT
         .app({ s : Any ->
           object   {
               val v = f.app(PS.Data.Unit.Module.unit);
             }
             .run({
              val v = this.v;
              when { else -> { val f_tick = v; f_tick.app(s); } };
            })
        })
    });
  @JvmField
  val functorStateT = { dictFunctor : Any ->
     PS.Data.Functor.Module.Functor
       .app({ f : Any ->
         { v : Any ->
           when {
            else -> {
              val f1 = f;
              val a = v;
              PS.Control.Monad.State.Trans.Module.StateT
                .app({ s : Any ->
                   PS.Data.Functor.Module.map.app(dictFunctor)
                     .app({ v1 : Any ->
                          when {
                           (v1 is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                             val b = v1.value0;
                             val s_tick = v1.value1;
                             PS.Data.Tuple.Module.Tuple.app(f1.app(b))
                               .app(s_tick);
                           }
                           else -> (error("Error in Pattern Match") as Any)
                         }
                       })
                     .app(a.app(s))
                });
            }
          }
        }
      })
  };
  @JvmField
  val execStateT = { dictFunctor : Any ->
     { v : Any ->
       { s : Any ->
         when {
          else -> {
            val m = v;
            val s1 = s;
            PS.Data.Functor.Module.map.app(dictFunctor)
              .app(PS.Data.Tuple.Module.snd)
              .app(m.app(s1));
          }
        }
      }
    }
  };
  @JvmField
  val evalStateT = { dictFunctor : Any ->
     { v : Any ->
       { s : Any ->
         when {
          else -> {
            val m = v;
            val s1 = s;
            PS.Data.Functor.Module.map.app(dictFunctor)
              .app(PS.Data.Tuple.Module.fst)
              .app(m.app(s1));
          }
        }
      }
    }
  };
  @JvmField val monadStateT = (::__rec_monadStateT)();
  @JvmField val bindStateT = (::__rec_bindStateT)();
  @JvmField val applyStateT = (::__rec_applyStateT)();
  @JvmField val applicativeStateT = (::__rec_applicativeStateT)();
  fun __rec_monadStateT(): Any = { dictMonad : Any ->
     PS.Control.Monad.Module.Monad
       .app({ _ : Any ->
            PS.Control.Monad.State.Trans.Module.applicativeStateT.app(dictMonad)
         })
       .app({ _ : Any ->
         PS.Control.Monad.State.Trans.Module.bindStateT.app(dictMonad)
      })
  };
  fun __rec_bindStateT(): Any = { dictMonad : Any ->
     PS.Control.Bind.Module.Bind
       .app({ _ : Any ->
            PS.Control.Monad.State.Trans.Module.applyStateT.app(dictMonad)
         })
       .app({ v : Any ->
         { f : Any ->
           when {
            else -> {
              val x = v;
              val f1 = f;
              PS.Control.Monad.State.Trans.Module.StateT
                .app({ s : Any ->
                   PS.Control.Bind.Module.bind
                     .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
                     .app(x.app(s))
                     .app({ v1 : Any ->
                       when {
                        (v1 is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                          val v2 = v1.value0;
                          val s_tick = v1.value1;
                          object   {
                              val v3 = f1.app(v2);
                            }
                            .run({
                              val v3 = this.v3;
                              when { else -> { val st = v3; st.app(s_tick); } };
                            });
                        }
                        else -> (error("Error in Pattern Match") as Any)
                      }
                    })
                });
            }
          }
        }
      })
  };
  fun __rec_applyStateT(): Any = { dictMonad : Any ->
     PS.Control.Apply.Module.Apply
       .app({ _ : Any ->
            PS.Control.Monad.State.Trans.Module.functorStateT
              .app((((dictMonad as Map<String, Any>)["Bind1"]!!
                       .app(Unit) as Map<String, Any>)["Apply0"]!!
                      .app(Unit) as Map<String, Any>)["Functor0"]!!
                     .app(Unit))
         })
       .app(PS.Control.Monad.Module.ap
              .app(PS.Control.Monad.State.Trans.Module.monadStateT
                     .app(dictMonad)))
  };
  fun __rec_applicativeStateT(): Any = { dictMonad : Any ->
     PS.Control.Applicative.Module.Applicative
       .app({ _ : Any ->
            PS.Control.Monad.State.Trans.Module.applyStateT.app(dictMonad)
         })
       .app({ a : Any ->
         PS.Control.Monad.State.Trans.Module.StateT
           .app({ s : Any ->
             PS.Data.Function.Module.apply
               .app(PS.Control.Applicative.Module.pure
                      .app((dictMonad as Map<String, Any>)["Applicative0"]!!
                             .app(Unit)))
               .app(PS.Data.Tuple.Module.Tuple.app(a).app(s))
          })
      })
  };
  @JvmField
  val monadAskStateT = { dictMonadAsk : Any ->
     PS.Control.Monad.Reader.Class.Module.MonadAsk
       .app({ _ : Any ->
            PS.Control.Monad.State.Trans.Module.monadStateT
              .app((dictMonadAsk as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app(PS.Control.Monad.Trans.Class.Module.lift
              .app(PS.Control.Monad.State.Trans.Module.monadTransStateT)
              .app((dictMonadAsk as Map<String, Any>)["Monad0"]!!.app(Unit))
              .app(PS.Control.Monad.Reader.Class.Module.ask.app(dictMonadAsk)))
  };
  @JvmField
  val monadReaderStateT = { dictMonadReader : Any ->
     PS.Control.Monad.Reader.Class.Module.MonadReader
       .app({ _ : Any ->
            PS.Control.Monad.State.Trans.Module.monadAskStateT
              .app((dictMonadReader as Map<String, Any>)["MonadAsk0"]!!
                     .app(Unit))
         })
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Control.Monad.State.Trans.Module.mapStateT)
              .app(PS.Control.Monad.Reader.Class.Module.local
                     .app(dictMonadReader)))
  };
  @JvmField
  val monadContStateT = { dictMonadCont : Any ->
     PS.Control.Monad.Cont.Class.Module.MonadCont
       .app({ _ : Any ->
            PS.Control.Monad.State.Trans.Module.monadStateT
              .app((dictMonadCont as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app({ f : Any ->
         PS.Control.Monad.State.Trans.Module.StateT
           .app({ s : Any ->
             PS.Control.Monad.Cont.Class.Module.callCC.app(dictMonadCont)
               .app({ c : Any ->
                 object   {
                     val v = f
                               .app({ a : Any ->
                          PS.Control.Monad.State.Trans.Module.StateT
                            .app({ s_tick : Any ->
                              c
                                .app(PS.Data.Tuple.Module.Tuple.app(a)
                                       .app(s_tick))
                           })
                       });
                   }
                   .run({
                    val v = this.v;
                    when { else -> { val f_tick = v; f_tick.app(s); } };
                  })
              })
          })
      })
  };
  @JvmField
  val monadEffectState = { dictMonadEffect : Any ->
     PS.Effect.Class.Module.MonadEffect
       .app({ _ : Any ->
            PS.Control.Monad.State.Trans.Module.monadStateT
              .app((dictMonadEffect as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Control.Monad.Trans.Class.Module.lift
                     .app(PS.Control.Monad.State.Trans.Module.monadTransStateT)
                     .app((dictMonadEffect as Map<String, Any>)["Monad0"]!!
                            .app(Unit)))
              .app(PS.Effect.Class.Module.liftEffect.app(dictMonadEffect)))
  };
  @JvmField
  val monadRecStateT = { dictMonadRec : Any ->
     PS.Control.Monad.Rec.Class.Module.MonadRec
       .app({ _ : Any ->
            PS.Control.Monad.State.Trans.Module.monadStateT
              .app((dictMonadRec as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app({ f : Any ->
         { a : Any ->
           object   {
               val f_tick = { v : Any ->
                  when {
                   (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                     val a_tick = v.value0;
                     val s = v.value1;
                     object   {
                         val v1 = f.app(a_tick);
                       }
                       .run({
                         val v1 = this.v1;
                         when {
                           else -> {
                             val st = v1;
                             PS.Control.Bind.Module.bind
                               .app(
                                 ((dictMonadRec as Map<String, Any>)["Monad0"]!!
                                    .app(Unit) as Map<String, Any>)["Bind1"]!!
                                   .app(Unit))
                               .app(st.app(s))
                               .app({ v2 : Any ->
                                  when {
                                   (v2 is PS.Data.Tuple.Module._Type_Tuple
                                            .Tuple) -> {
                                     val m = v2.value0;
                                     val s1 = v2.value1;
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
                                                    .app(s1));
                                         }
                                         (m is PS.Control.Monad.Rec.Class.Module._Type_Step
                                                 .Done) -> {
                                           val y = m.value0;
                                           PS.Control.Monad.Rec.Class.Module.Done
                                             .app(PS.Data.Tuple.Module.Tuple
                                                    .app(y)
                                                    .app(s1));
                                         }
                                         else -> (error("Error in Pattern Match"
                                         ) as Any)
                                       });
                                   }
                                   else -> (error("Error in Pattern Match"
                                   ) as Any)
                                 }
                               });
                           }
                         };
                       });
                   }
                   else -> (error("Error in Pattern Match") as Any)
                 }
               };
             }
             .run({
              val f_tick = this.f_tick;
              PS.Control.Monad.State.Trans.Module.StateT
                .app({ s : Any ->
                   PS.Control.Monad.Rec.Class.Module.tailRecM.app(dictMonadRec)
                     .app(f_tick)
                     .app(PS.Data.Tuple.Module.Tuple.app(a).app(s))
                });
            })
        }
      })
  };
  @JvmField
  val monadStateStateT = { dictMonad : Any ->
     PS.Control.Monad.State.Class.Module.MonadState
       .app({ _ : Any ->
            PS.Control.Monad.State.Trans.Module.monadStateT.app(dictMonad)
         })
       .app({ f : Any ->
         PS.Data.Function.Module.apply
           .app(PS.Control.Monad.State.Trans.Module.StateT)
           .app(PS.Control.Semigroupoid.Module.compose
                  .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                  .app(PS.Control.Applicative.Module.pure
                         .app((dictMonad as Map<String, Any>)["Applicative0"]!!
                                .app(Unit)))
                  .app(f))
      })
  };
  @JvmField
  val monadTellStateT = { dictMonadTell : Any ->
     PS.Control.Monad.Writer.Class.Module.MonadTell
       .app({ _ : Any ->
            PS.Control.Monad.State.Trans.Module.monadStateT
              .app((dictMonadTell as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Control.Monad.Trans.Class.Module.lift
                     .app(PS.Control.Monad.State.Trans.Module.monadTransStateT)
                     .app((dictMonadTell as Map<String, Any>)["Monad0"]!!
                            .app(Unit)))
              .app(PS.Control.Monad.Writer.Class.Module.tell.app(dictMonadTell))
    )
  };
  @JvmField
  val monadWriterStateT = { dictMonadWriter : Any ->
     PS.Control.Monad.Writer.Class.Module.MonadWriter
       .app({ _ : Any ->
            PS.Control.Monad.State.Trans.Module.monadTellStateT
              .app((dictMonadWriter as Map<String, Any>)["MonadTell0"]!!
                     .app(Unit))
         })
       .app({ m : Any ->
            PS.Control.Monad.State.Trans.Module.StateT
              .app({ s : Any ->
                when {
                 else -> {
                   val m_tick = m;
                   PS.Control.Bind.Module.bind
                     .app(
                       (((dictMonadWriter as Map<String, Any>)["MonadTell0"]!!
                           .app(Unit) as Map<String, Any>)["Monad0"]!!
                          .app(Unit) as Map<String, Any>)["Bind1"]!!
                         .app(Unit))
                     .app(PS.Control.Monad.Writer.Class.Module.listen
                            .app(dictMonadWriter)
                            .app(m_tick.app(s)))
                     .app({ v : Any ->
                        when {
                         (v is PS.Data.Tuple.Module._Type_Tuple
                                 .Tuple)&& (v
                                              .value0 is PS.Data.Tuple.Module._Type_Tuple
                                                           .Tuple) -> {
                           val a = v.value0.value0;
                           val s_tick = v.value0.value1;
                           val w = v.value1;
                           PS.Data.Function.Module.apply
                             .app(PS.Control.Applicative.Module.pure
                                    .app(
                                 (((dictMonadWriter as Map<String, Any>)["MonadTell0"]!!
                                     .app(Unit) as Map<String, Any>)["Monad0"]!!
                                    .app(Unit
                                   ) as Map<String, Any>)["Applicative0"]!!
                                   .app(Unit)))
                             .app(PS.Data.Tuple.Module.Tuple
                                    .app(PS.Data.Tuple.Module.Tuple.app(a)
                                           .app(w))
                                    .app(s_tick));
                         }
                         else -> (error("Error in Pattern Match") as Any)
                       }
                     });
                 }
               }
             })
         })
       .app({ m : Any ->
         PS.Control.Monad.State.Trans.Module.StateT
           .app({ s : Any ->
             PS.Control.Monad.Writer.Class.Module.pass.app(dictMonadWriter)
               .app(when {
                else -> {
                  val m_tick = m;
                  PS.Control.Bind.Module.bind
                    .app((((dictMonadWriter as Map<String, Any>)["MonadTell0"]!!
                             .app(Unit) as Map<String, Any>)["Monad0"]!!
                            .app(Unit) as Map<String, Any>)["Bind1"]!!
                           .app(Unit))
                    .app(m_tick.app(s))
                    .app({ v : Any ->
                       when {
                        (v is PS.Data.Tuple.Module._Type_Tuple
                                .Tuple)&& (v
                                             .value0 is PS.Data.Tuple.Module._Type_Tuple
                                                          .Tuple) -> {
                          val a = v.value0.value0;
                          val f = v.value0.value1;
                          val s_tick = v.value1;
                          PS.Data.Function.Module.apply
                            .app(PS.Control.Applicative.Module.pure
                                   .app(
                                (((dictMonadWriter as Map<String, Any>)["MonadTell0"]!!
                                    .app(Unit) as Map<String, Any>)["Monad0"]!!
                                   .app(Unit
                                  ) as Map<String, Any>)["Applicative0"]!!
                                  .app(Unit)))
                            .app(PS.Data.Tuple.Module.Tuple
                                   .app(PS.Data.Tuple.Module.Tuple.app(a)
                                          .app(s_tick))
                                   .app(f));
                        }
                        else -> (error("Error in Pattern Match") as Any)
                      }
                    });
                }
              })
          })
      })
  };
  @JvmField
  val monadThrowStateT = { dictMonadThrow : Any ->
     PS.Control.Monad.Error.Class.Module.MonadThrow
       .app({ _ : Any ->
            PS.Control.Monad.State.Trans.Module.monadStateT
              .app((dictMonadThrow as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app({ e : Any ->
         PS.Control.Monad.Trans.Class.Module.lift
           .app(PS.Control.Monad.State.Trans.Module.monadTransStateT)
           .app((dictMonadThrow as Map<String, Any>)["Monad0"]!!.app(Unit))
           .app(PS.Control.Monad.Error.Class.Module.throwError
                  .app(dictMonadThrow)
                  .app(e))
      })
  };
  @JvmField
  val monadErrorStateT = { dictMonadError : Any ->
     PS.Control.Monad.Error.Class.Module.MonadError
       .app({ _ : Any ->
            PS.Control.Monad.State.Trans.Module.monadThrowStateT
              .app((dictMonadError as Map<String, Any>)["MonadThrow0"]!!
                     .app(Unit))
         })
       .app({ v : Any ->
         { h : Any ->
           when {
            else -> {
              val m = v;
              val h1 = h;
              PS.Control.Monad.State.Trans.Module.StateT
                .app({ s : Any ->
                   PS.Control.Monad.Error.Class.Module.catchError
                     .app(dictMonadError)
                     .app(m.app(s))
                     .app({ e : Any ->
                       object   {
                           val v1 = h1.app(e);
                         }
                         .run({
                          val v1 = this.v1;
                          when { else -> { val f = v1; f.app(s); } };
                        })
                    })
                });
            }
          }
        }
      })
  };
  @JvmField
  val altStateT = { dictMonad : Any ->
     { dictAlt : Any ->
       PS.Control.Alt.Module.Alt
         .app({ _ : Any ->
              PS.Control.Monad.State.Trans.Module.functorStateT
                .app((dictAlt as Map<String, Any>)["Functor0"]!!.app(Unit))
           })
         .app({ v : Any ->
           { v1 : Any ->
             when {
              else -> {
                val x = v;
                val y = v1;
                PS.Control.Monad.State.Trans.Module.StateT
                  .app({ s : Any ->
                     PS.Control.Alt.Module.alt.app(dictAlt).app(x.app(s))
                       .app(y.app(s))
                  });
              }
            }
          }
        })
    }
  };
  @JvmField
  val plusStateT = { dictMonad : Any ->
     { dictPlus : Any ->
       PS.Control.Plus.Module.Plus
         .app({ _ : Any ->
              PS.Control.Monad.State.Trans.Module.altStateT.app(dictMonad)
                .app((dictPlus as Map<String, Any>)["Alt0"]!!.app(Unit))
           })
         .app(PS.Control.Monad.State.Trans.Module.StateT
                .app({ v : Any ->
             PS.Control.Plus.Module.empty.app(dictPlus)
          }))
    }
  };
  @JvmField
  val alternativeStateT = { dictMonad : Any ->
     { dictAlternative : Any ->
       PS.Control.Alternative.Module.Alternative
         .app({ _ : Any ->
              PS.Control.Monad.State.Trans.Module.applicativeStateT
                .app(dictMonad)
           })
         .app({ _ : Any ->
           PS.Control.Monad.State.Trans.Module.plusStateT.app(dictMonad)
             .app((dictAlternative as Map<String, Any>)["Plus1"]!!.app(Unit))
        })
    }
  };
  @JvmField
  val monadZeroStateT = { dictMonadZero : Any ->
     PS.Control.MonadZero.Module.MonadZero
       .app({ _ : Any ->
            PS.Control.Monad.State.Trans.Module.alternativeStateT
              .app((dictMonadZero as Map<String, Any>)["Monad0"]!!.app(Unit))
              .app((dictMonadZero as Map<String, Any>)["Alternative1"]!!
                     .app(Unit))
         })
       .app({ _ : Any ->
         PS.Control.Monad.State.Trans.Module.monadStateT
           .app((dictMonadZero as Map<String, Any>)["Monad0"]!!.app(Unit))
      })
  };
  @JvmField
  val monadPlusStateT = { dictMonadPlus : Any ->
     PS.Control.MonadPlus.Module.MonadPlus
       .app({ _ : Any ->
         PS.Control.Monad.State.Trans.Module.monadZeroStateT
           .app((dictMonadPlus as Map<String, Any>)["MonadZero0"]!!.app(Unit))
      })
  };
}