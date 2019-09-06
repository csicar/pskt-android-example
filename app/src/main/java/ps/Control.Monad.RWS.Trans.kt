@file:Suppress("UNCHECKED_CAST")
package PS.Control.Monad.RWS.Trans
import Foreign.PsRuntime.app
object Module  {
  sealed class _Type_RWSResult ()  {
    data class RWSResult (val value0 : Any,  val value1 : Any, 
    val value2 : Any) : _Type_RWSResult() {};
  };
  val RWSResult = { value0 : Any ->
     { value1 : Any ->
       { value2 : Any ->
         _Type_RWSResult.RWSResult(value0,  value1,  value2)
      }
    }
  };
  @JvmField val RWST = { x : Any -> x};
  @JvmField
  val withRWST = { f : Any ->
     { m : Any ->
       PS.Control.Monad.RWS.Trans.Module.RWST
         .app({ r : Any ->
           { s : Any ->
             PS.Data.Tuple.Module.uncurry
               .app(when {
                   else -> {
                     val m_tick = m;
                     m_tick;
                   }
                 })
               .app(f.app(r).app(s))
          }
        })
    }
  };
  @JvmField val runRWST = { v : Any -> when { else -> { val x = v; x; } }};
  @JvmField
  val newtypeRWST = PS.Data.Newtype.Module.Newtype
                      .app({ n : Any ->
                           when {
                            else -> {
                              val a = n;
                              a;
                            }
                          }
                        })
                      .app(PS.Control.Monad.RWS.Trans.Module.RWST);
  @JvmField
  val monadTransRWST = { dictMonoid : Any ->
     PS.Control.Monad.Trans.Class.Module.MonadTrans
       .app({ dictMonad : Any ->
         { m : Any ->
           PS.Control.Monad.RWS.Trans.Module.RWST
             .app({ v : Any ->
               { s : Any ->
                 PS.Control.Bind.Module.bind
                   .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
                   .app(m)
                   .app({ a : Any ->
                     PS.Data.Function.Module.apply
                       .app(PS.Control.Applicative.Module.pure
                              .app(
                           (dictMonad as Map<String, Any>)["Applicative0"]!!
                             .app(Unit)))
                       .app(PS.Control.Monad.RWS.Trans.Module.RWSResult.app(s)
                              .app(a)
                              .app(PS.Data.Monoid.Module.mempty.app(dictMonoid))
                    )
                  })
              }
            })
        }
      })
  };
  @JvmField
  val mapRWST = { f : Any ->
     { v : Any ->
       when {
        else -> {
          val f1 = f;
          val m = v;
          PS.Control.Monad.RWS.Trans.Module.RWST
            .app({ r : Any ->
               { s : Any ->
                 f1.app(m.app(r).app(s))
              }
            });
        }
      }
    }
  };
  @JvmField
  val lazyRWST = PS.Control.Lazy.Module.Lazy
                   .app({ f : Any ->
       PS.Control.Monad.RWS.Trans.Module.RWST
         .app({ r : Any ->
           { s : Any ->
             object   {
                 val v = f.app(PS.Data.Unit.Module.unit);
               }
               .run({
                val v = this.v;
                when { else -> { val f_tick = v; f_tick.app(r).app(s); } };
              })
          }
        })
    });
  @JvmField
  val functorRWST = { dictFunctor : Any ->
     PS.Data.Functor.Module.Functor
       .app({ f : Any ->
         { v : Any ->
           when {
            else -> {
              val f1 = f;
              val m = v;
              PS.Control.Monad.RWS.Trans.Module.RWST
                .app({ r : Any ->
                   { s : Any ->
                     PS.Data.Functor.Module.map.app(dictFunctor)
                       .app({ v1 : Any ->
                            when {
                             (v1 is PS.Control.Monad.RWS.Trans.Module._Type_RWSResult
                                      .RWSResult) -> {
                               val state = v1.value0;
                               val result = v1.value1;
                               val writer = v1.value2;
                               PS.Control.Monad.RWS.Trans.Module.RWSResult
                                 .app(state)
                                 .app(f1.app(result))
                                 .app(writer);
                             }
                             else -> (error("Error in Pattern Match") as Any)
                           }
                         })
                       .app(m.app(r).app(s))
                  }
                });
            }
          }
        }
      })
  };
  @JvmField
  val execRWST = { dictMonad : Any ->
     { v : Any ->
       { r : Any ->
         { s : Any ->
           when {
            else -> {
              val m = v;
              val r1 = r;
              val s1 = s;
              PS.Control.Bind.Module.bind
                .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
                .app(m.app(r1).app(s1))
                .app({ v1 : Any ->
                   when {
                    (v1 is PS.Control.Monad.RWS.Trans.Module._Type_RWSResult
                             .RWSResult) -> {
                      val state = v1.value0;
                      val writer = v1.value2;
                      PS.Control.Applicative.Module.pure
                        .app((dictMonad as Map<String, Any>)["Applicative0"]!!
                               .app(Unit))
                        .app(PS.Data.Tuple.Module.Tuple.app(state).app(writer));
                    }
                    else -> (error("Error in Pattern Match") as Any)
                  }
                });
            }
          }
        }
      }
    }
  };
  @JvmField
  val evalRWST = { dictMonad : Any ->
     { v : Any ->
       { r : Any ->
         { s : Any ->
           when {
            else -> {
              val m = v;
              val r1 = r;
              val s1 = s;
              PS.Control.Bind.Module.bind
                .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
                .app(m.app(r1).app(s1))
                .app({ v1 : Any ->
                   when {
                    (v1 is PS.Control.Monad.RWS.Trans.Module._Type_RWSResult
                             .RWSResult) -> {
                      val result = v1.value1;
                      val writer = v1.value2;
                      PS.Control.Applicative.Module.pure
                        .app((dictMonad as Map<String, Any>)["Applicative0"]!!
                               .app(Unit))
                        .app(PS.Data.Tuple.Module.Tuple.app(result).app(writer)
                      );
                    }
                    else -> (error("Error in Pattern Match") as Any)
                  }
                });
            }
          }
        }
      }
    }
  };
  @JvmField
  val applyRWST = { dictBind : Any ->
     { dictMonoid : Any ->
       PS.Control.Apply.Module.Apply
         .app({ _ : Any ->
              PS.Control.Monad.RWS.Trans.Module.functorRWST
                .app(((dictBind as Map<String, Any>)["Apply0"]!!
                        .app(Unit) as Map<String, Any>)["Functor0"]!!
                       .app(Unit))
           })
         .app({ v : Any ->
           { v1 : Any ->
             when {
              else -> {
                val f = v;
                val m = v1;
                PS.Control.Monad.RWS.Trans.Module.RWST
                  .app({ r : Any ->
                     { s : Any ->
                       PS.Control.Bind.Module.bind.app(dictBind)
                         .app(f.app(r).app(s))
                         .app({ v2 : Any ->
                           when {
                            (v2 is PS.Control.Monad.RWS.Trans.Module._Type_RWSResult
                                     .RWSResult) -> {
                              val s_tick = v2.value0;
                              val f_tick = v2.value1;
                              val w_tick = v2.value2;
                              PS.Data.Functor.Module.mapFlipped
                                .app(((dictBind as Map<String, Any>)["Apply0"]!!
                                        .app(Unit
                                       ) as Map<String, Any>)["Functor0"]!!
                                       .app(Unit))
                                .app(m.app(r).app(s_tick))
                                .app({ v3 : Any ->
                                   when {
                                    (v3 is PS.Control.Monad.RWS.Trans.Module._Type_RWSResult
                                             .RWSResult) -> {
                                      val s_tick_tick = v3.value0;
                                      val a_tick_tick = v3.value1;
                                      val w_tick_tick = v3.value2;
                                      PS.Control.Monad.RWS.Trans.Module.RWSResult
                                        .app(s_tick_tick)
                                        .app(f_tick.app(a_tick_tick))
                                        .app(PS.Data.Semigroup.Module.append
                                               .app(
                                                 (dictMonoid as Map<String, Any>)["Semigroup0"]!!
                                                   .app(Unit))
                                               .app(w_tick)
                                               .app(w_tick_tick));
                                    }
                                    else -> (error("Error in Pattern Match"
                                    ) as Any)
                                  }
                                });
                            }
                            else -> (error("Error in Pattern Match") as Any)
                          }
                        })
                    }
                  });
              }
            }
          }
        })
    }
  };
  @JvmField
  val bindRWST = { dictBind : Any ->
     { dictMonoid : Any ->
       PS.Control.Bind.Module.Bind
         .app({ _ : Any ->
              PS.Control.Monad.RWS.Trans.Module.applyRWST.app(dictBind)
                .app(dictMonoid)
           })
         .app({ v : Any ->
           { f : Any ->
             when {
              else -> {
                val m = v;
                val f1 = f;
                PS.Control.Monad.RWS.Trans.Module.RWST
                  .app({ r : Any ->
                     { s : Any ->
                       PS.Control.Bind.Module.bind.app(dictBind)
                         .app(m.app(r).app(s))
                         .app({ v1 : Any ->
                           when {
                            (v1 is PS.Control.Monad.RWS.Trans.Module._Type_RWSResult
                                     .RWSResult) -> {
                              val s_tick = v1.value0;
                              val a = v1.value1;
                              val w = v1.value2;
                              object   {
                                  val v2 = f1.app(a);
                                }
                                .run({
                                  val v2 = this.v2;
                                  when {
                                    else -> {
                                      val f_tick = v2;
                                      PS.Data.Functor.Module.mapFlipped
                                        .app(
                                          ((dictBind as Map<String, Any>)["Apply0"]!!
                                             .app(Unit
                                            ) as Map<String, Any>)["Functor0"]!!
                                            .app(Unit))
                                        .app(f_tick.app(r).app(s_tick))
                                        .app({ v3 : Any ->
                                           when {
                                            (v3 is PS.Control.Monad.RWS.Trans.Module._Type_RWSResult
                                                     .RWSResult) -> {
                                              val state = v3.value0;
                                              val result = v3.value1;
                                              val writer = v3.value2;
                                              PS.Control.Monad.RWS.Trans.Module.RWSResult
                                                .app(state)
                                                .app(result)
                                                .app(
                                                PS.Data.Semigroup.Module.append
                                                  .app(
                                                    (dictMonoid as Map<String, Any>)["Semigroup0"]!!
                                                      .app(Unit))
                                                  .app(w)
                                                  .app(writer));
                                            }
                                            else -> (error(
                                              "Error in Pattern Match") as Any)
                                          }
                                        });
                                    }
                                  };
                                });
                            }
                            else -> (error("Error in Pattern Match") as Any)
                          }
                        })
                    }
                  });
              }
            }
          }
        })
    }
  };
  @JvmField
  val applicativeRWST = { dictMonad : Any ->
     { dictMonoid : Any ->
       PS.Control.Applicative.Module.Applicative
         .app({ _ : Any ->
              PS.Control.Monad.RWS.Trans.Module.applyRWST
                .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
                .app(dictMonoid)
           })
         .app({ a : Any ->
           PS.Control.Monad.RWS.Trans.Module.RWST
             .app({ v : Any ->
               { s : Any ->
                 PS.Data.Function.Module.apply
                   .app(PS.Control.Applicative.Module.pure
                          .app((dictMonad as Map<String, Any>)["Applicative0"]!!
                                 .app(Unit)))
                   .app(PS.Control.Monad.RWS.Trans.Module.RWSResult.app(s)
                          .app(a)
                          .app(PS.Data.Monoid.Module.mempty.app(dictMonoid)))
              }
            })
        })
    }
  };
  @JvmField
  val monadRWST = { dictMonad : Any ->
     { dictMonoid : Any ->
       PS.Control.Monad.Module.Monad
         .app({ _ : Any ->
              PS.Control.Monad.RWS.Trans.Module.applicativeRWST.app(dictMonad)
                .app(dictMonoid)
           })
         .app({ _ : Any ->
           PS.Control.Monad.RWS.Trans.Module.bindRWST
             .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
             .app(dictMonoid)
        })
    }
  };
  @JvmField
  val monadAskRWST = { dictMonad : Any ->
     { dictMonoid : Any ->
       PS.Control.Monad.Reader.Class.Module.MonadAsk
         .app({ _ : Any ->
              PS.Control.Monad.RWS.Trans.Module.monadRWST.app(dictMonad)
                .app(dictMonoid)
           })
         .app(PS.Control.Monad.RWS.Trans.Module.RWST
                .app({ r : Any ->
             { s : Any ->
               PS.Data.Function.Module.apply
                 .app(PS.Control.Applicative.Module.pure
                        .app((dictMonad as Map<String, Any>)["Applicative0"]!!
                               .app(Unit)))
                 .app(PS.Control.Monad.RWS.Trans.Module.RWSResult.app(s).app(r)
                        .app(PS.Data.Monoid.Module.mempty.app(dictMonoid)))
            }
          }))
    }
  };
  @JvmField
  val monadReaderRWST = { dictMonad : Any ->
     { dictMonoid : Any ->
       PS.Control.Monad.Reader.Class.Module.MonadReader
         .app({ _ : Any ->
              PS.Control.Monad.RWS.Trans.Module.monadAskRWST.app(dictMonad)
                .app(dictMonoid)
           })
         .app({ f : Any ->
           { m : Any ->
             PS.Control.Monad.RWS.Trans.Module.RWST
               .app({ r : Any ->
                 { s : Any ->
                   when {
                    else -> {
                      val m_tick = m;
                      m_tick.app(f.app(r)).app(s);
                    }
                  }
                }
              })
          }
        })
    }
  };
  @JvmField
  val monadEffectRWS = { dictMonoid : Any ->
     { dictMonadEffect : Any ->
       PS.Effect.Class.Module.MonadEffect
         .app({ _ : Any ->
              PS.Control.Monad.RWS.Trans.Module.monadRWST
                .app((dictMonadEffect as Map<String, Any>)["Monad0"]!!.app(Unit)
                )
                .app(dictMonoid)
           })
         .app(PS.Control.Semigroupoid.Module.compose
                .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                .app(PS.Control.Monad.Trans.Class.Module.lift
                       .app(PS.Control.Monad.RWS.Trans.Module.monadTransRWST
                              .app(dictMonoid))
                       .app((dictMonadEffect as Map<String, Any>)["Monad0"]!!
                              .app(Unit)))
                .app(PS.Effect.Class.Module.liftEffect.app(dictMonadEffect)))
    }
  };
  @JvmField
  val monadRecRWST = { dictMonadRec : Any ->
     { dictMonoid : Any ->
       PS.Control.Monad.Rec.Class.Module.MonadRec
         .app({ _ : Any ->
              PS.Control.Monad.RWS.Trans.Module.monadRWST
                .app((dictMonadRec as Map<String, Any>)["Monad0"]!!.app(Unit))
                .app(dictMonoid)
           })
         .app({ k : Any ->
           { a : Any ->
             object   {
                 val k_tick = { r : Any ->
                    { v : Any ->
                      when {
                       (v is PS.Control.Monad.RWS.Trans.Module._Type_RWSResult
                               .RWSResult) -> {
                         val r1 = r;
                         val state = v.value0;
                         val result = v.value1;
                         val writer = v.value2;
                         object   {
                             val v1 = k.app(result);
                           }
                           .run({
                             val v1 = this.v1;
                             when {
                               else -> {
                                 val m = v1;
                                 PS.Control.Bind.Module.bind
                                   .app(
                                     ((dictMonadRec as Map<String, Any>)["Monad0"]!!
                                        .app(Unit
                                       ) as Map<String, Any>)["Bind1"]!!
                                       .app(Unit))
                                   .app(m.app(r1).app(state))
                                   .app({ v2 : Any ->
                                      when {
                                       (v2 is PS.Control.Monad.RWS.Trans.Module._Type_RWSResult
                                                .RWSResult) -> {
                                         val state_tick = v2.value0;
                                         val result_tick = v2.value1;
                                         val writer_tick = v2.value2;
                                         PS.Control.Applicative.Module.pure
                                           .app(
                                             ((dictMonadRec as Map<String, Any>)["Monad0"]!!
                                                .app(Unit
                                               ) as Map<String, Any>)["Applicative0"]!!
                                               .app(Unit))
                                           .app(when {
                                             (result_tick is PS.Control.Monad.Rec.Class.Module._Type_Step
                                                               .Loop) -> {
                                               val x = result_tick.value0;
                                               PS.Control.Monad.Rec.Class.Module.Loop
                                                 .app(
                                                 PS.Control.Monad.RWS.Trans.Module.RWSResult
                                                   .app(state_tick)
                                                   .app(x)
                                                   .app(
                                                   PS.Data.Semigroup.Module.append
                                                     .app(
                                                       (dictMonoid as Map<String, Any>)["Semigroup0"]!!
                                                         .app(Unit))
                                                     .app(writer)
                                                     .app(writer_tick)));
                                             }
                                             (result_tick is PS.Control.Monad.Rec.Class.Module._Type_Step
                                                               .Done) -> {
                                               val y = result_tick.value0;
                                               PS.Control.Monad.Rec.Class.Module.Done
                                                 .app(
                                                 PS.Control.Monad.RWS.Trans.Module.RWSResult
                                                   .app(state_tick)
                                                   .app(y)
                                                   .app(
                                                   PS.Data.Semigroup.Module.append
                                                     .app(
                                                       (dictMonoid as Map<String, Any>)["Semigroup0"]!!
                                                         .app(Unit))
                                                     .app(writer)
                                                     .app(writer_tick)));
                                             }
                                             else -> (error(
                                               "Error in Pattern Match") as Any)
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
                   }
                 };
               }
               .run({
                val k_tick = this.k_tick;
                PS.Control.Monad.RWS.Trans.Module.RWST
                  .app({ r : Any ->
                     { s : Any ->
                       PS.Control.Monad.Rec.Class.Module.tailRecM
                         .app(dictMonadRec)
                         .app(k_tick.app(r))
                         .app(PS.Control.Monad.RWS.Trans.Module.RWSResult.app(s)
                                .app(a)
                                .app(PS.Data.Monoid.Module.mempty
                                       .app(dictMonoid)))
                    }
                  });
              })
          }
        })
    }
  };
  @JvmField
  val monadStateRWST = { dictMonad : Any ->
     { dictMonoid : Any ->
       PS.Control.Monad.State.Class.Module.MonadState
         .app({ _ : Any ->
              PS.Control.Monad.RWS.Trans.Module.monadRWST.app(dictMonad)
                .app(dictMonoid)
           })
         .app({ f : Any ->
           PS.Control.Monad.RWS.Trans.Module.RWST
             .app({ v : Any ->
               { s : Any ->
                 object   {
                     val v1 = f.app(s);
                   }
                   .run({
                    val v1 = this.v1;
                    when {
                      (v1 is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                        val a = v1.value0;
                        val s_tick = v1.value1;
                        PS.Data.Function.Module.apply
                          .app(PS.Control.Applicative.Module.pure
                                 .app(
                              (dictMonad as Map<String, Any>)["Applicative0"]!!
                                .app(Unit)))
                          .app(PS.Control.Monad.RWS.Trans.Module.RWSResult
                                 .app(s_tick)
                                 .app(a)
                                 .app(PS.Data.Monoid.Module.mempty
                                        .app(dictMonoid)));
                      }
                      else -> (error("Error in Pattern Match") as Any)
                    };
                  })
              }
            })
        })
    }
  };
  @JvmField
  val monadTellRWST = { dictMonad : Any ->
     { dictMonoid : Any ->
       PS.Control.Monad.Writer.Class.Module.MonadTell
         .app({ _ : Any ->
              PS.Control.Monad.RWS.Trans.Module.monadRWST.app(dictMonad)
                .app(dictMonoid)
           })
         .app({ w : Any ->
           PS.Control.Monad.RWS.Trans.Module.RWST
             .app({ v : Any ->
               { s : Any ->
                 PS.Data.Function.Module.apply
                   .app(PS.Control.Applicative.Module.pure
                          .app((dictMonad as Map<String, Any>)["Applicative0"]!!
                                 .app(Unit)))
                   .app(PS.Control.Monad.RWS.Trans.Module.RWSResult.app(s)
                          .app(PS.Data.Unit.Module.unit)
                          .app(w))
              }
            })
        })
    }
  };
  @JvmField
  val monadWriterRWST = { dictMonad : Any ->
     { dictMonoid : Any ->
       PS.Control.Monad.Writer.Class.Module.MonadWriter
         .app({ _ : Any ->
              PS.Control.Monad.RWS.Trans.Module.monadTellRWST.app(dictMonad)
                .app(dictMonoid)
           })
         .app({ m : Any ->
              PS.Control.Monad.RWS.Trans.Module.RWST
                .app({ r : Any ->
                  { s : Any ->
                    when {
                     else -> {
                       val m_tick = m;
                       PS.Control.Bind.Module.bind
                         .app((dictMonad as Map<String, Any>)["Bind1"]!!
                                .app(Unit))
                         .app(m_tick.app(r).app(s))
                         .app({ v : Any ->
                            when {
                             (v is PS.Control.Monad.RWS.Trans.Module._Type_RWSResult
                                     .RWSResult) -> {
                               val s_tick = v.value0;
                               val a = v.value1;
                               val w = v.value2;
                               PS.Data.Function.Module.apply
                                 .app(PS.Control.Applicative.Module.pure
                                        .app(
                                     (dictMonad as Map<String, Any>)["Applicative0"]!!
                                       .app(Unit)))
                                 .app(
                                 PS.Control.Monad.RWS.Trans.Module.RWSResult
                                   .app(s_tick)
                                   .app(PS.Data.Tuple.Module.Tuple.app(a).app(w)
                                   )
                                   .app(w));
                             }
                             else -> (error("Error in Pattern Match") as Any)
                           }
                         });
                     }
                   }
                 }
               })
           })
         .app({ m : Any ->
           PS.Control.Monad.RWS.Trans.Module.RWST
             .app({ r : Any ->
               { s : Any ->
                 when {
                  else -> {
                    val m_tick = m;
                    PS.Control.Bind.Module.bind
                      .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
                      .app(m_tick.app(r).app(s))
                      .app({ v : Any ->
                         when {
                          (v is PS.Control.Monad.RWS.Trans.Module._Type_RWSResult
                                  .RWSResult)&& (v
                                                   .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                .Tuple) -> {
                            val s_tick = v.value0;
                            val a = v.value1.value0;
                            val f = v.value1.value1;
                            val w = v.value2;
                            PS.Data.Function.Module.apply
                              .app(PS.Control.Applicative.Module.pure
                                     .app(
                                  (dictMonad as Map<String, Any>)["Applicative0"]!!
                                    .app(Unit)))
                              .app(PS.Control.Monad.RWS.Trans.Module.RWSResult
                                     .app(s_tick)
                                     .app(a)
                                     .app(f.app(w)));
                          }
                          else -> (error("Error in Pattern Match") as Any)
                        }
                      });
                  }
                }
              }
            })
        })
    }
  };
  @JvmField
  val monadThrowRWST = { dictMonadThrow : Any ->
     { dictMonoid : Any ->
       PS.Control.Monad.Error.Class.Module.MonadThrow
         .app({ _ : Any ->
              PS.Control.Monad.RWS.Trans.Module.monadRWST
                .app((dictMonadThrow as Map<String, Any>)["Monad0"]!!.app(Unit))
                .app(dictMonoid)
           })
         .app({ e : Any ->
           PS.Control.Monad.Trans.Class.Module.lift
             .app(PS.Control.Monad.RWS.Trans.Module.monadTransRWST
                    .app(dictMonoid))
             .app((dictMonadThrow as Map<String, Any>)["Monad0"]!!.app(Unit))
             .app(PS.Control.Monad.Error.Class.Module.throwError
                    .app(dictMonadThrow)
                    .app(e))
        })
    }
  };
  @JvmField
  val monadErrorRWST = { dictMonadError : Any ->
     { dictMonoid : Any ->
       PS.Control.Monad.Error.Class.Module.MonadError
         .app({ _ : Any ->
              PS.Control.Monad.RWS.Trans.Module.monadThrowRWST
                .app((dictMonadError as Map<String, Any>)["MonadThrow0"]!!
                       .app(Unit))
                .app(dictMonoid)
           })
         .app({ m : Any ->
           { h : Any ->
             PS.Data.Function.Module.apply
               .app(PS.Control.Monad.RWS.Trans.Module.RWST)
               .app({ r : Any ->
                 { s : Any ->
                   PS.Control.Monad.Error.Class.Module.catchError
                     .app(dictMonadError)
                     .app(when {
                         else -> {
                           val m_tick = m;
                           m_tick.app(r).app(s);
                         }
                       })
                     .app({ e : Any ->
                       object   {
                           val v = h.app(e);
                         }
                         .run({
                          val v = this.v;
                          when {
                            else -> {
                              val m_tick = v;
                              m_tick.app(r).app(s);
                            }
                          };
                        })
                    })
                }
              })
          }
        })
    }
  };
  @JvmField
  val altRWST = { dictAlt : Any ->
     PS.Control.Alt.Module.Alt
       .app({ _ : Any ->
            PS.Control.Monad.RWS.Trans.Module.functorRWST
              .app((dictAlt as Map<String, Any>)["Functor0"]!!.app(Unit))
         })
       .app({ v : Any ->
         { v1 : Any ->
           when {
            else -> {
              val m = v;
              val n = v1;
              PS.Data.Function.Module.apply
                .app(PS.Control.Monad.RWS.Trans.Module.RWST)
                .app({ r : Any ->
                   { s : Any ->
                     PS.Control.Alt.Module.alt.app(dictAlt).app(m.app(r).app(s))
                       .app(n.app(r).app(s))
                  }
                });
            }
          }
        }
      })
  };
  @JvmField
  val plusRWST = { dictPlus : Any ->
     PS.Control.Plus.Module.Plus
       .app({ _ : Any ->
            PS.Control.Monad.RWS.Trans.Module.altRWST
              .app((dictPlus as Map<String, Any>)["Alt0"]!!.app(Unit))
         })
       .app(PS.Control.Monad.RWS.Trans.Module.RWST
              .app({ v : Any ->
           { v1 : Any ->
             PS.Control.Plus.Module.empty.app(dictPlus)
          }
        }))
  };
  @JvmField
  val alternativeRWST = { dictMonoid : Any ->
     { dictAlternative : Any ->
       { dictMonad : Any ->
         PS.Control.Alternative.Module.Alternative
           .app({ _ : Any ->
                PS.Control.Monad.RWS.Trans.Module.applicativeRWST.app(dictMonad)
                  .app(dictMonoid)
             })
           .app({ _ : Any ->
             PS.Control.Monad.RWS.Trans.Module.plusRWST
               .app((dictAlternative as Map<String, Any>)["Plus1"]!!.app(Unit))
          })
      }
    }
  };
}