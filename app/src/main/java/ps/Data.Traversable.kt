@file:Suppress("UNCHECKED_CAST")

package PS.Data.Traversable
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  val traverseArrayImpl = Foreign.Data.Traversable.traverseArrayImpl;
  @JvmField
  val Traversable = { Foldable1 : Any ->
     { Functor0 : Any ->
       { sequence : Any ->
         { traverse : Any ->
           mapOf(("Foldable1" to Foldable1),  ("Functor0" to Functor0),  
            ("sequence" to sequence),  ("traverse" to traverse))
        }
      }
    }
  };
  @JvmField
  val traverse = { dict : Any ->
     (dict as Map<String, Any>)["traverse"]!!
  };
  @JvmField
  val traversableMultiplicative = PS.Data.Traversable.Module.Traversable
                                    .app({ _ : Any ->
                                         PS.Data.Foldable.Module.foldableMultiplicative
                                      })
                                    .app({ _ : Any ->
                                         PS.Data.Monoid.Multiplicative.Module.functorMultiplicative
                                      })
                                    .app({ dictApplicative : Any ->
                                         { v : Any ->
                                          val x = v;
                                            PS.Data.Functor.Module.map
                                              .app(
                                                ((dictApplicative as Map<String, Any>)["Apply0"]!!
                                                   .app(Unit
                                                  ) as Map<String, Any>)["Functor0"]!!
                                                  .app(Unit))
                                              .app(
                                                PS.Data.Monoid.Multiplicative.Module.Multiplicative
                                              )
                                              .app(x);}
                                      })
                                    .app({ dictApplicative : Any ->
       { f : Any ->
         { v : Any ->
          val f1 = f;
            val x = v;
            PS.Data.Functor.Module.map
              .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                      .app(Unit) as Map<String, Any>)["Functor0"]!!
                     .app(Unit))
              .app(PS.Data.Monoid.Multiplicative.Module.Multiplicative)
              .app(f1.app(x));}
      }
    });
  @JvmField
  val traversableMaybe = PS.Data.Traversable.Module.Traversable
                           .app({ _ : Any ->
                                PS.Data.Foldable.Module.foldableMaybe
                             })
                           .app({ _ : Any ->
                                PS.Data.Maybe.Module.functorMaybe
                             })
                           .app({ dictApplicative : Any ->
                                { v : Any ->
                                  when {
                                   (v is PS.Data.Maybe.Module._Type_Maybe
                                           .Nothing) -> {
                                     PS.Control.Applicative.Module.pure
                                       .app(dictApplicative)
                                       .app(PS.Data.Maybe.Module.Nothing);
                                   }
                                   (v is PS.Data.Maybe.Module._Type_Maybe
                                           .Just) -> {
                                     val x = v.value0;
                                     PS.Data.Functor.Module.map
                                       .app(
                                         ((dictApplicative as Map<String, Any>)["Apply0"]!!
                                            .app(Unit
                                           ) as Map<String, Any>)["Functor0"]!!
                                           .app(Unit))
                                       .app(PS.Data.Maybe.Module.Just)
                                       .app(x);
                                   }
                                   else -> (error("Error in Pattern Match"
                                   ) as Any)
                                 }
                               }
                             })
                           .app({ dictApplicative : Any ->
       { v : Any ->
         { v1 : Any ->
           when {
            (v1 is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
              PS.Control.Applicative.Module.pure.app(dictApplicative)
                .app(PS.Data.Maybe.Module.Nothing);
            }
            (v1 is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
              val f = v;
              val x = v1.value0;
              PS.Data.Functor.Module.map
                .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                        .app(Unit) as Map<String, Any>)["Functor0"]!!
                       .app(Unit))
                .app(PS.Data.Maybe.Module.Just)
                .app(f.app(x));
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      }
    });
  @JvmField
  val traversableDual = PS.Data.Traversable.Module.Traversable
                          .app({ _ : Any ->
                               PS.Data.Foldable.Module.foldableDual
                            })
                          .app({ _ : Any ->
                               PS.Data.Monoid.Dual.Module.functorDual
                            })
                          .app({ dictApplicative : Any ->
                               { v : Any ->
                                val x = v;
                                  PS.Data.Functor.Module.map
                                    .app(
                                      ((dictApplicative as Map<String, Any>)["Apply0"]!!
                                         .app(Unit
                                        ) as Map<String, Any>)["Functor0"]!!
                                        .app(Unit))
                                    .app(PS.Data.Monoid.Dual.Module.Dual)
                                    .app(x);}
                            })
                          .app({ dictApplicative : Any ->
       { f : Any ->
         { v : Any ->
          val f1 = f;
            val x = v;
            PS.Data.Functor.Module.map
              .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                      .app(Unit) as Map<String, Any>)["Functor0"]!!
                     .app(Unit))
              .app(PS.Data.Monoid.Dual.Module.Dual)
              .app(f1.app(x));}
      }
    });
  @JvmField
  val traversableDisj = PS.Data.Traversable.Module.Traversable
                          .app({ _ : Any ->
                               PS.Data.Foldable.Module.foldableDisj
                            })
                          .app({ _ : Any ->
                               PS.Data.Monoid.Disj.Module.functorDisj
                            })
                          .app({ dictApplicative : Any ->
                               { v : Any ->
                                val x = v;
                                  PS.Data.Functor.Module.map
                                    .app(
                                      ((dictApplicative as Map<String, Any>)["Apply0"]!!
                                         .app(Unit
                                        ) as Map<String, Any>)["Functor0"]!!
                                        .app(Unit))
                                    .app(PS.Data.Monoid.Disj.Module.Disj)
                                    .app(x);}
                            })
                          .app({ dictApplicative : Any ->
       { f : Any ->
         { v : Any ->
          val f1 = f;
            val x = v;
            PS.Data.Functor.Module.map
              .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                      .app(Unit) as Map<String, Any>)["Functor0"]!!
                     .app(Unit))
              .app(PS.Data.Monoid.Disj.Module.Disj)
              .app(f1.app(x));}
      }
    });
  @JvmField
  val traversableConj = PS.Data.Traversable.Module.Traversable
                          .app({ _ : Any ->
                               PS.Data.Foldable.Module.foldableConj
                            })
                          .app({ _ : Any ->
                               PS.Data.Monoid.Conj.Module.functorConj
                            })
                          .app({ dictApplicative : Any ->
                               { v : Any ->
                                val x = v;
                                  PS.Data.Functor.Module.map
                                    .app(
                                      ((dictApplicative as Map<String, Any>)["Apply0"]!!
                                         .app(Unit
                                        ) as Map<String, Any>)["Functor0"]!!
                                        .app(Unit))
                                    .app(PS.Data.Monoid.Conj.Module.Conj)
                                    .app(x);}
                            })
                          .app({ dictApplicative : Any ->
       { f : Any ->
         { v : Any ->
          val f1 = f;
            val x = v;
            PS.Data.Functor.Module.map
              .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                      .app(Unit) as Map<String, Any>)["Functor0"]!!
                     .app(Unit))
              .app(PS.Data.Monoid.Conj.Module.Conj)
              .app(f1.app(x));}
      }
    });
  @JvmField
  val traversableAdditive = PS.Data.Traversable.Module.Traversable
                              .app({ _ : Any ->
                                   PS.Data.Foldable.Module.foldableAdditive
                                })
                              .app({ _ : Any ->
                                   PS.Data.Monoid.Additive.Module.functorAdditive
                                })
                              .app({ dictApplicative : Any ->
                                   { v : Any ->
                                    val x = v;
                                      PS.Data.Functor.Module.map
                                        .app(
                                          ((dictApplicative as Map<String, Any>)["Apply0"]!!
                                             .app(Unit
                                            ) as Map<String, Any>)["Functor0"]!!
                                            .app(Unit))
                                        .app(
                                          PS.Data.Monoid.Additive.Module.Additive
                                        )
                                        .app(x);}
                                })
                              .app({ dictApplicative : Any ->
       { f : Any ->
         { v : Any ->
          val f1 = f;
            val x = v;
            PS.Data.Functor.Module.map
              .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                      .app(Unit) as Map<String, Any>)["Functor0"]!!
                     .app(Unit))
              .app(PS.Data.Monoid.Additive.Module.Additive)
              .app(f1.app(x));}
      }
    });
  @JvmField
  val sequenceDefault = { dictTraversable : Any ->
     { dictApplicative : Any ->
       PS.Data.Traversable.Module.traverse.app(dictTraversable)
         .app(dictApplicative)
         .app(PS.Control.Category.Module.identity
                .app(PS.Control.Category.Module.categoryFn))
    }
  };
  @JvmField val traversableArray = (::__rec_traversableArray)();
  fun __rec_traversableArray(): Any = PS.Data.Traversable.Module.Traversable
                                        .app({ _ : Any ->
                                             PS.Data.Foldable.Module.foldableArray
                                          })
                                        .app({ _ : Any ->
                                             PS.Data.Functor.Module.functorArray
                                          })
                                        .app({ dictApplicative : Any ->
                                             PS.Data.Traversable.Module.sequenceDefault
                                               .app(
                                                 PS.Data.Traversable.Module.traversableArray
                                               )
                                               .app(dictApplicative)
                                          })
                                        .app({ dictApplicative : Any ->
       PS.Data.Traversable.Module.traverseArrayImpl
         .app(PS.Control.Apply.Module.apply
                .app((dictApplicative as Map<String, Any>)["Apply0"]!!.app(Unit)
           ))
         .app(PS.Data.Functor.Module.map
                .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                        .app(Unit) as Map<String, Any>)["Functor0"]!!
                       .app(Unit)))
         .app(PS.Control.Applicative.Module.pure.app(dictApplicative))
    });
  @JvmField
  val sequence = { dict : Any ->
     (dict as Map<String, Any>)["sequence"]!!
  };
  @JvmField
  val traversableFirst = PS.Data.Traversable.Module.Traversable
                           .app({ _ : Any ->
                                PS.Data.Foldable.Module.foldableFirst
                             })
                           .app({ _ : Any ->
                                PS.Data.Maybe.First.Module.functorFirst
                             })
                           .app({ dictApplicative : Any ->
                                { v : Any ->
                                 val x = v;
                                   PS.Data.Functor.Module.map
                                     .app(
                                       ((dictApplicative as Map<String, Any>)["Apply0"]!!
                                          .app(Unit
                                         ) as Map<String, Any>)["Functor0"]!!
                                         .app(Unit))
                                     .app(PS.Data.Maybe.First.Module.First)
                                     .app(PS.Data.Traversable.Module.sequence
                                            .app(
                                              PS.Data.Traversable.Module.traversableMaybe
                                            )
                                            .app(dictApplicative)
                                            .app(x));}
                             })
                           .app({ dictApplicative : Any ->
       { f : Any ->
         { v : Any ->
          val f1 = f;
            val x = v;
            PS.Data.Functor.Module.map
              .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                      .app(Unit) as Map<String, Any>)["Functor0"]!!
                     .app(Unit))
              .app(PS.Data.Maybe.First.Module.First)
              .app(PS.Data.Traversable.Module.traverse
                     .app(PS.Data.Traversable.Module.traversableMaybe)
                     .app(dictApplicative)
                     .app(f1)
                     .app(x));}
      }
    });
  @JvmField
  val traversableLast = PS.Data.Traversable.Module.Traversable
                          .app({ _ : Any ->
                               PS.Data.Foldable.Module.foldableLast
                            })
                          .app({ _ : Any ->
                               PS.Data.Maybe.Last.Module.functorLast
                            })
                          .app({ dictApplicative : Any ->
                               { v : Any ->
                                val x = v;
                                  PS.Data.Functor.Module.map
                                    .app(
                                      ((dictApplicative as Map<String, Any>)["Apply0"]!!
                                         .app(Unit
                                        ) as Map<String, Any>)["Functor0"]!!
                                        .app(Unit))
                                    .app(PS.Data.Maybe.Last.Module.Last)
                                    .app(PS.Data.Traversable.Module.sequence
                                           .app(
                                             PS.Data.Traversable.Module.traversableMaybe
                                           )
                                           .app(dictApplicative)
                                           .app(x));}
                            })
                          .app({ dictApplicative : Any ->
       { f : Any ->
         { v : Any ->
          val f1 = f;
            val x = v;
            PS.Data.Functor.Module.map
              .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                      .app(Unit) as Map<String, Any>)["Functor0"]!!
                     .app(Unit))
              .app(PS.Data.Maybe.Last.Module.Last)
              .app(PS.Data.Traversable.Module.traverse
                     .app(PS.Data.Traversable.Module.traversableMaybe)
                     .app(dictApplicative)
                     .app(f1)
                     .app(x));}
      }
    });
  @JvmField
  val traverseDefault = { dictTraversable : Any ->
     { dictApplicative : Any ->
       { f : Any ->
         { ta : Any ->
           PS.Data.Traversable.Module.sequence.app(dictTraversable)
             .app(dictApplicative)
             .app(PS.Data.Functor.Module.map
                    .app((dictTraversable as Map<String, Any>)["Functor0"]!!
                           .app(Unit))
                    .app(f)
                    .app(ta))
        }
      }
    }
  };
  @JvmField
  val mapAccumR = { dictTraversable : Any ->
     { f : Any ->
       { s0 : Any ->
         { xs : Any ->
           PS.Data.Traversable.Accum.Internal.Module.stateR
             .app(PS.Data.Traversable.Module.traverse.app(dictTraversable)
                    .app(
                      PS.Data.Traversable.Accum.Internal.Module.applicativeStateR
                    )
                    .app({ a : Any ->
                         PS.Data.Traversable.Accum.Internal.Module.StateR
                           .app({ s : Any ->
                             f.app(s).app(a)
                          })
                      })
                    .app(xs))
             .app(s0)
        }
      }
    }
  };
  @JvmField
  val scanr = { dictTraversable : Any ->
     { f : Any ->
       { b0 : Any ->
         { xs : Any ->
           (PS.Data.Traversable.Module.mapAccumR.app(dictTraversable)
              .app({ b : Any ->
                   { a : Any ->
                     object   {
                         val b_tick = f.app(a).app(b);
                       }
                       .run({
                        val b_tick = this.b_tick;
                        mapOf(("accum" to b_tick),  ("value" to b_tick));
                      })
                  }
                })
              .app(b0)
              .app(xs) as Map<String, Any>)["value"]!!
        }
      }
    }
  };
  @JvmField
  val mapAccumL = { dictTraversable : Any ->
     { f : Any ->
       { s0 : Any ->
         { xs : Any ->
           PS.Data.Traversable.Accum.Internal.Module.stateL
             .app(PS.Data.Traversable.Module.traverse.app(dictTraversable)
                    .app(
                      PS.Data.Traversable.Accum.Internal.Module.applicativeStateL
                    )
                    .app({ a : Any ->
                         PS.Data.Traversable.Accum.Internal.Module.StateL
                           .app({ s : Any ->
                             f.app(s).app(a)
                          })
                      })
                    .app(xs))
             .app(s0)
        }
      }
    }
  };
  @JvmField
  val scanl = { dictTraversable : Any ->
     { f : Any ->
       { b0 : Any ->
         { xs : Any ->
           (PS.Data.Traversable.Module.mapAccumL.app(dictTraversable)
              .app({ b : Any ->
                   { a : Any ->
                     object   {
                         val b_tick = f.app(b).app(a);
                       }
                       .run({
                        val b_tick = this.b_tick;
                        mapOf(("accum" to b_tick),  ("value" to b_tick));
                      })
                  }
                })
              .app(b0)
              .app(xs) as Map<String, Any>)["value"]!!
        }
      }
    }
  };
  @JvmField
  val _for = { dictApplicative : Any ->
     { dictTraversable : Any ->
       { x : Any ->
         { f : Any ->
           PS.Data.Traversable.Module.traverse.app(dictTraversable)
             .app(dictApplicative)
             .app(f)
             .app(x)
        }
      }
    }
  };
}