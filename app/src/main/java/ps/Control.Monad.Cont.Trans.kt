@file:Suppress("UNCHECKED_CAST")
package PS.Control.Monad.Cont.Trans
import Foreign.PsRuntime.app
object Module  {
  @JvmField val ContT = { x : Any -> x};
  @JvmField
  val withContT = { f : Any ->
     { v : Any ->
       when {
        else -> {
          val f1 = f;
          val m = v;
          PS.Control.Monad.Cont.Trans.Module.ContT
            .app({ k : Any ->
               m.app(f1.app(k))
            });
        }
      }
    }
  };
  @JvmField
  val runContT = { v : Any ->
     { k : Any ->
       when {
        else -> {
          val f = v;
          val k1 = k;
          f.app(k1);
        }
      }
    }
  };
  @JvmField
  val newtypeContT = PS.Data.Newtype.Module.Newtype
                       .app({ n : Any ->
                            when {
                             else -> {
                               val a = n;
                               a;
                             }
                           }
                         })
                       .app(PS.Control.Monad.Cont.Trans.Module.ContT);
  @JvmField
  val monadTransContT = PS.Control.Monad.Trans.Class.Module.MonadTrans
                          .app({ dictMonad : Any ->
       { m : Any ->
         PS.Control.Monad.Cont.Trans.Module.ContT
           .app({ k : Any ->
             PS.Control.Bind.Module.bind
               .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
               .app(m)
               .app(k)
          })
      }
    });
  @JvmField
  val mapContT = { f : Any ->
     { v : Any ->
       when {
        else -> {
          val f1 = f;
          val m = v;
          PS.Control.Monad.Cont.Trans.Module.ContT
            .app({ k : Any ->
               f1.app(m.app(k))
            });
        }
      }
    }
  };
  @JvmField
  val functorContT = { dictFunctor : Any ->
     PS.Data.Functor.Module.Functor
       .app({ f : Any ->
         { v : Any ->
           when {
            else -> {
              val f1 = f;
              val m = v;
              PS.Control.Monad.Cont.Trans.Module.ContT
                .app({ k : Any ->
                   m
                     .app({ a : Any ->
                       PS.Data.Function.Module.apply.app(k).app(f1.app(a))
                    })
                });
            }
          }
        }
      })
  };
  @JvmField
  val applyContT = { dictApply : Any ->
     PS.Control.Apply.Module.Apply
       .app({ _ : Any ->
            PS.Control.Monad.Cont.Trans.Module.functorContT
              .app((dictApply as Map<String, Any>)["Functor0"]!!.app(Unit))
         })
       .app({ v : Any ->
         { v1 : Any ->
           when {
            else -> {
              val f = v;
              val v2 = v1;
              PS.Control.Monad.Cont.Trans.Module.ContT
                .app({ k : Any ->
                   f.app({ g : Any -> v2.app({ a : Any -> k.app(g.app(a))})})
                });
            }
          }
        }
      })
  };
  @JvmField
  val bindContT = { dictBind : Any ->
     PS.Control.Bind.Module.Bind
       .app({ _ : Any ->
            PS.Control.Monad.Cont.Trans.Module.applyContT
              .app((dictBind as Map<String, Any>)["Apply0"]!!.app(Unit))
         })
       .app({ v : Any ->
         { k : Any ->
           when {
            else -> {
              val m = v;
              val k1 = k;
              PS.Control.Monad.Cont.Trans.Module.ContT
                .app({ k_tick : Any ->
                   m
                     .app({ a : Any ->
                       object   {
                           val v1 = k1.app(a);
                         }
                         .run({
                          val v1 = this.v1;
                          when {
                            else -> {
                              val m_tick = v1;
                              m_tick.app(k_tick);
                            }
                          };
                        })
                    })
                });
            }
          }
        }
      })
  };
  @JvmField
  val applicativeContT = { dictApplicative : Any ->
     PS.Control.Applicative.Module.Applicative
       .app({ _ : Any ->
            PS.Control.Monad.Cont.Trans.Module.applyContT
              .app((dictApplicative as Map<String, Any>)["Apply0"]!!.app(Unit))
         })
       .app({ a : Any ->
         PS.Control.Monad.Cont.Trans.Module.ContT.app({ k : Any -> k.app(a)})
      })
  };
  @JvmField
  val monadContT = { dictMonad : Any ->
     PS.Control.Monad.Module.Monad
       .app({ _ : Any ->
            PS.Control.Monad.Cont.Trans.Module.applicativeContT
              .app((dictMonad as Map<String, Any>)["Applicative0"]!!.app(Unit))
         })
       .app({ _ : Any ->
         PS.Control.Monad.Cont.Trans.Module.bindContT
           .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
      })
  };
  @JvmField
  val monadAskContT = { dictMonadAsk : Any ->
     PS.Control.Monad.Reader.Class.Module.MonadAsk
       .app({ _ : Any ->
            PS.Control.Monad.Cont.Trans.Module.monadContT
              .app((dictMonadAsk as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app(PS.Control.Monad.Trans.Class.Module.lift
              .app(PS.Control.Monad.Cont.Trans.Module.monadTransContT)
              .app((dictMonadAsk as Map<String, Any>)["Monad0"]!!.app(Unit))
              .app(PS.Control.Monad.Reader.Class.Module.ask.app(dictMonadAsk)))
  };
  @JvmField
  val monadReaderContT = { dictMonadReader : Any ->
     PS.Control.Monad.Reader.Class.Module.MonadReader
       .app({ _ : Any ->
            PS.Control.Monad.Cont.Trans.Module.monadAskContT
              .app((dictMonadReader as Map<String, Any>)["MonadAsk0"]!!
                     .app(Unit))
         })
       .app({ f : Any ->
         { v : Any ->
           when {
            else -> {
              val f1 = f;
              val c = v;
              PS.Control.Monad.Cont.Trans.Module.ContT
                .app({ k : Any ->
                   PS.Control.Bind.Module.bind
                     .app((((dictMonadReader as Map<String, Any>)["MonadAsk0"]!!
                              .app(Unit) as Map<String, Any>)["Monad0"]!!
                             .app(Unit) as Map<String, Any>)["Bind1"]!!
                            .app(Unit))
                     .app(PS.Control.Monad.Reader.Class.Module.ask
                            .app(
                         (dictMonadReader as Map<String, Any>)["MonadAsk0"]!!
                           .app(Unit)))
                     .app({ v1 : Any ->
                       when {
                        else -> {
                          val r = v1;
                          PS.Control.Monad.Reader.Class.Module.local
                            .app(dictMonadReader)
                            .app(f1)
                            .app(c
                                   .app(PS.Control.Semigroupoid.Module.compose
                                          .app(
                                            PS.Control.Semigroupoid.Module.semigroupoidFn
                                          )
                                          .app(
                                            PS.Control.Monad.Reader.Class.Module.local
                                              .app(dictMonadReader)
                                              .app(
                                              PS.Data.Function.Module._const
                                                .app(r)))
                                          .app(k)));
                        }
                      }
                    })
                });
            }
          }
        }
      })
  };
  @JvmField
  val monadContContT = { dictMonad : Any ->
     PS.Control.Monad.Cont.Class.Module.MonadCont
       .app({ _ : Any ->
            PS.Control.Monad.Cont.Trans.Module.monadContT.app(dictMonad)
         })
       .app({ f : Any ->
         PS.Control.Monad.Cont.Trans.Module.ContT
           .app({ k : Any ->
             object   {
                 val v = f
                           .app({ a : Any ->
                      PS.Control.Monad.Cont.Trans.Module.ContT
                        .app({ v1 : Any ->
                          k.app(a)
                       })
                   });
               }
               .run({
                val v = this.v;
                when { else -> { val f_tick = v; f_tick.app(k); } };
              })
          })
      })
  };
  @JvmField
  val monadEffectContT = { dictMonadEffect : Any ->
     PS.Effect.Class.Module.MonadEffect
       .app({ _ : Any ->
            PS.Control.Monad.Cont.Trans.Module.monadContT
              .app((dictMonadEffect as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Control.Monad.Trans.Class.Module.lift
                     .app(PS.Control.Monad.Cont.Trans.Module.monadTransContT)
                     .app((dictMonadEffect as Map<String, Any>)["Monad0"]!!
                            .app(Unit)))
              .app(PS.Effect.Class.Module.liftEffect.app(dictMonadEffect)))
  };
  @JvmField
  val monadStateContT = { dictMonadState : Any ->
     PS.Control.Monad.State.Class.Module.MonadState
       .app({ _ : Any ->
            PS.Control.Monad.Cont.Trans.Module.monadContT
              .app((dictMonadState as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Control.Monad.Trans.Class.Module.lift
                     .app(PS.Control.Monad.Cont.Trans.Module.monadTransContT)
                     .app((dictMonadState as Map<String, Any>)["Monad0"]!!
                            .app(Unit)))
              .app(PS.Control.Monad.State.Class.Module.state.app(dictMonadState)
      ))
  };
}