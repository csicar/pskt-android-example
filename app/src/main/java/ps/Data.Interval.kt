@file:Suppress("UNCHECKED_CAST")
package PS.Data.Interval
import Foreign.PsRuntime.app
object Module  {
  sealed class _Type_Interval ()  {
    data class StartEnd (val value0 : Any,  val value1 : Any) : _Type_Interval(
    ) {};
    data class DurationEnd (val value0 : Any, 
    val value1 : Any) : _Type_Interval() {};
    data class StartDuration (val value0 : Any, 
    val value1 : Any) : _Type_Interval() {};
    data class DurationOnly (val value0 : Any) : _Type_Interval() {};
  };
  val StartEnd = { value0 : Any ->
     { value1 : Any ->
       _Type_Interval.StartEnd(value0,  value1)
    }
  };
  val DurationEnd = { value0 : Any ->
     { value1 : Any ->
       _Type_Interval.DurationEnd(value0,  value1)
    }
  };
  val StartDuration = { value0 : Any ->
     { value1 : Any ->
       _Type_Interval.StartDuration(value0,  value1)
    }
  };
  val DurationOnly = { value0 : Any -> _Type_Interval.DurationOnly(value0)};
  sealed class _Type_RecurringInterval ()  {
    data class RecurringInterval (val value0 : Any, 
    val value1 : Any) : _Type_RecurringInterval() {};
  };
  val RecurringInterval = { value0 : Any ->
     { value1 : Any ->
       _Type_RecurringInterval.RecurringInterval(value0,  value1)
    }
  };
  @JvmField
  val showInterval = { dictShow : Any ->
     { dictShow1 : Any ->
       PS.Data.Show.Module.Show
         .app({ v : Any ->
           when {
            (v is PS.Data.Interval.Module._Type_Interval.StartEnd) -> {
              val x = v.value0;
              val y = v.value1;
              (("(StartEnd " as String) + (((PS.Data.Show.Module.show
                                               .app(dictShow1)
                                               .app(x
              ) as String) + (((" " as String) + (((PS.Data.Show.Module.show
                                                      .app(dictShow1)
                                                      .app(y
              ) as String) + (")" as String)) as String)) as String)) as String));
            }
            (v is PS.Data.Interval.Module._Type_Interval.DurationEnd) -> {
              val d = v.value0;
              val x = v.value1;
              (("(DurationEnd " as String) + (((PS.Data.Show.Module.show
                                                  .app(dictShow)
                                                  .app(d
              ) as String) + (((" " as String) + (((PS.Data.Show.Module.show
                                                      .app(dictShow1)
                                                      .app(x
              ) as String) + (")" as String)) as String)) as String)) as String));
            }
            (v is PS.Data.Interval.Module._Type_Interval.StartDuration) -> {
              val x = v.value0;
              val d = v.value1;
              (("(StartDuration " as String) + (((PS.Data.Show.Module.show
                                                    .app(dictShow1)
                                                    .app(x
              ) as String) + (((" " as String) + (((PS.Data.Show.Module.show
                                                      .app(dictShow)
                                                      .app(d
              ) as String) + (")" as String)) as String)) as String)) as String));
            }
            (v is PS.Data.Interval.Module._Type_Interval.DurationOnly) -> {
              val d = v.value0;
              (("(DurationOnly " as String) + (((PS.Data.Show.Module.show
                                                   .app(dictShow)
                                                   .app(d
              ) as String) + (")" as String)) as String));
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        })
    }
  };
  @JvmField
  val showRecurringInterval = { dictShow : Any ->
     { dictShow1 : Any ->
       PS.Data.Show.Module.Show
         .app({ v : Any ->
           when {
            (v is PS.Data.Interval.Module._Type_RecurringInterval
                    .RecurringInterval) -> {
              val x = v.value0;
              val y = v.value1;
              (("(RecurringInterval " as String) + (((PS.Data.Show.Module.show
                                                        .app(
                                                          PS.Data.Maybe.Module.showMaybe
                                                            .app(
                                                            PS.Data.Show.Module.showInt
                                                          ))
                                                        .app(x
              ) as String) + (((" " as String) + (((PS.Data.Show.Module.show
                                                      .app(
                                                        PS.Data.Interval.Module.showInterval
                                                          .app(dictShow)
                                                          .app(dictShow1))
                                                      .app(y
              ) as String) + (")" as String)) as String)) as String)) as String));
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        })
    }
  };
  @JvmField
  val over = { dictFunctor : Any ->
     { f : Any ->
       { v : Any ->
         when {
          (v is PS.Data.Interval.Module._Type_RecurringInterval
                  .RecurringInterval) -> {
            val f1 = f;
            val n = v.value0;
            val i = v.value1;
            PS.Data.Functor.Module.map.app(dictFunctor)
              .app(PS.Data.Interval.Module.RecurringInterval.app(n))
              .app(f1.app(i));
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    }
  };
  @JvmField
  val interval = { v : Any ->
     when {
      (v is PS.Data.Interval.Module._Type_RecurringInterval
              .RecurringInterval) -> {
        val i = v.value1;
        i;
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField val foldableInterval = (::__rec_foldableInterval)();
  fun __rec_foldableInterval(): Any = PS.Data.Foldable.Module.Foldable
                                        .app({ dictMonoid : Any ->
                                             PS.Data.Foldable.Module.foldMapDefaultL
                                               .app(
                                                 PS.Data.Interval.Module.foldableInterval
                                               )
                                               .app(dictMonoid)
                                          })
                                        .app({ v : Any ->
                                             { z : Any ->
                                               { v1 : Any ->
                                                 when {
                                                  (v1 is PS.Data.Interval.Module._Type_Interval
                                                           .StartEnd) -> {
                                                    val f = v;
                                                    val z1 = z;
                                                    val x = v1.value0;
                                                    val y = v1.value1;
                                                    f.app(f.app(z1).app(x))
                                                      .app(y);
                                                  }
                                                  (v1 is PS.Data.Interval.Module._Type_Interval
                                                           .DurationEnd) -> {
                                                    val f = v;
                                                    val z1 = z;
                                                    val d = v1.value0;
                                                    val x = v1.value1;
                                                    f.app(z1).app(x);
                                                  }
                                                  (v1 is PS.Data.Interval.Module._Type_Interval
                                                           .StartDuration) -> {
                                                    val f = v;
                                                    val z1 = z;
                                                    val x = v1.value0;
                                                    val d = v1.value1;
                                                    f.app(z1).app(x);
                                                  }
                                                  else -> {
                                                    val z1 = z;
                                                    z1;
                                                  }
                                                }
                                              }
                                            }
                                          })
                                        .app({ x : Any ->
       PS.Data.Foldable.Module.foldrDefault
         .app(PS.Data.Interval.Module.foldableInterval)
         .app(x)
    });
  @JvmField
  val foldableRecurringInterval = (::__rec_foldableRecurringInterval)();
  fun __rec_foldableRecurringInterval(): Any = PS.Data.Foldable.Module.Foldable
                                                 .app({ dictMonoid : Any ->
                                                      PS.Data.Foldable.Module.foldMapDefaultL
                                                        .app(
                                                          PS.Data.Interval.Module.foldableRecurringInterval
                                                        )
                                                        .app(dictMonoid)
                                                   })
                                                 .app({ f : Any ->
                                                      { i : Any ->
                                                        PS.Control.Semigroupoid.Module.compose
                                                          .app(
                                                            PS.Control.Semigroupoid.Module.semigroupoidFn
                                                          )
                                                          .app(
                                                            PS.Data.Foldable.Module.foldl
                                                              .app(
                                                                PS.Data.Interval.Module.foldableInterval
                                                              )
                                                              .app(f)
                                                              .app(i))
                                                          .app(
                                                         PS.Data.Interval.Module.interval
                                                       )
                                                     }
                                                   })
                                                 .app({ f : Any ->
       { i : Any ->
         PS.Control.Semigroupoid.Module.compose
           .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
           .app(PS.Data.Foldable.Module.foldr
                  .app(PS.Data.Interval.Module.foldableInterval)
                  .app(f)
                  .app(i))
           .app(PS.Data.Interval.Module.interval)
      }
    });
  @JvmField
  val eqInterval = { dictEq : Any ->
     { dictEq1 : Any ->
       PS.Data.Eq.Module.Eq
         .app({ x : Any ->
           { y : Any ->
             when {
              (x is PS.Data.Interval.Module._Type_Interval
                      .StartEnd)&& (y is PS.Data.Interval.Module._Type_Interval
                                           .StartEnd) -> {
                val l = x.value0;
                val l1 = x.value1;
                val r = y.value0;
                val r1 = y.value1;
                PS.Data.HeytingAlgebra.Module.conj
                  .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
                  .app(PS.Data.Eq.Module.eq.app(dictEq1).app(l).app(r))
                  .app(PS.Data.Eq.Module.eq.app(dictEq1).app(l1).app(r1));
              }
              (x is PS.Data.Interval.Module._Type_Interval
                      .DurationEnd)&&
              (y is PS.Data.Interval.Module._Type_Interval
                      .DurationEnd) -> {
                val l = x.value0;
                val l1 = x.value1;
                val r = y.value0;
                val r1 = y.value1;
                PS.Data.HeytingAlgebra.Module.conj
                  .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
                  .app(PS.Data.Eq.Module.eq.app(dictEq).app(l).app(r))
                  .app(PS.Data.Eq.Module.eq.app(dictEq1).app(l1).app(r1));
              }
              (x is PS.Data.Interval.Module._Type_Interval
                      .StartDuration)&&
              (y is PS.Data.Interval.Module._Type_Interval
                      .StartDuration) -> {
                val l = x.value0;
                val l1 = x.value1;
                val r = y.value0;
                val r1 = y.value1;
                PS.Data.HeytingAlgebra.Module.conj
                  .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
                  .app(PS.Data.Eq.Module.eq.app(dictEq1).app(l).app(r))
                  .app(PS.Data.Eq.Module.eq.app(dictEq).app(l1).app(r1));
              }
              (x is PS.Data.Interval.Module._Type_Interval
                      .DurationOnly)&&
              (y is PS.Data.Interval.Module._Type_Interval
                      .DurationOnly) -> {
                val l = x.value0;
                val r = y.value0;
                PS.Data.Eq.Module.eq.app(dictEq).app(l).app(r);
              }
              else -> {
                false;
              }
            }
          }
        })
    }
  };
  @JvmField
  val eqRecurringInterval = { dictEq : Any ->
     { dictEq1 : Any ->
       PS.Data.Eq.Module.Eq
         .app({ x : Any ->
           { y : Any ->
             when {
              (x is PS.Data.Interval.Module._Type_RecurringInterval
                      .RecurringInterval)&&
              (y is PS.Data.Interval.Module._Type_RecurringInterval
                      .RecurringInterval) -> {
                val l = x.value0;
                val l1 = x.value1;
                val r = y.value0;
                val r1 = y.value1;
                PS.Data.HeytingAlgebra.Module.conj
                  .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
                  .app(PS.Data.Eq.Module.eq
                         .app(PS.Data.Maybe.Module.eqMaybe
                                .app(PS.Data.Eq.Module.eqInt))
                         .app(l)
                         .app(r))
                  .app(PS.Data.Eq.Module.eq
                         .app(PS.Data.Interval.Module.eqInterval.app(dictEq)
                                .app(dictEq1))
                         .app(l1)
                         .app(r1));
              }
              else -> (error("Error in Pattern Match") as Any)
            }
          }
        })
    }
  };
  @JvmField
  val ordInterval = { dictOrd : Any ->
     { dictOrd1 : Any ->
       PS.Data.Ord.Module.Ord
         .app({ _ : Any ->
              PS.Data.Interval.Module.eqInterval
                .app((dictOrd as Map<String, Any>)["Eq0"]!!.app(Unit))
                .app((dictOrd1 as Map<String, Any>)["Eq0"]!!.app(Unit))
           })
         .app({ x : Any ->
           { y : Any ->
             when {
              (x is PS.Data.Interval.Module._Type_Interval
                      .StartEnd)&& (y is PS.Data.Interval.Module._Type_Interval
                                           .StartEnd) -> {
                val l = x.value0;
                val l1 = x.value1;
                val r = y.value0;
                val r1 = y.value1;
                object   {
                    val v = PS.Data.Ord.Module.compare.app(dictOrd1).app(l)
                              .app(r);
                  }
                  .run({
                    val v = this.v;
                    when {
                      (v is PS.Data.Ordering.Module._Type_Ordering.LT) -> {
                        PS.Data.Ordering.Module.LT;
                      }
                      (v is PS.Data.Ordering.Module._Type_Ordering.GT) -> {
                        PS.Data.Ordering.Module.GT;
                      }
                      else -> {
                        PS.Data.Ord.Module.compare.app(dictOrd1).app(l1)
                          .app(r1);
                      }
                    };
                  });
              }
              (x is PS.Data.Interval.Module._Type_Interval.StartEnd) -> {
                PS.Data.Ordering.Module.LT;
              }
              (y is PS.Data.Interval.Module._Type_Interval.StartEnd) -> {
                PS.Data.Ordering.Module.GT;
              }
              (x is PS.Data.Interval.Module._Type_Interval
                      .DurationEnd)&&
              (y is PS.Data.Interval.Module._Type_Interval
                      .DurationEnd) -> {
                val l = x.value0;
                val l1 = x.value1;
                val r = y.value0;
                val r1 = y.value1;
                object   {
                    val v = PS.Data.Ord.Module.compare.app(dictOrd).app(l)
                              .app(r);
                  }
                  .run({
                    val v = this.v;
                    when {
                      (v is PS.Data.Ordering.Module._Type_Ordering.LT) -> {
                        PS.Data.Ordering.Module.LT;
                      }
                      (v is PS.Data.Ordering.Module._Type_Ordering.GT) -> {
                        PS.Data.Ordering.Module.GT;
                      }
                      else -> {
                        PS.Data.Ord.Module.compare.app(dictOrd1).app(l1)
                          .app(r1);
                      }
                    };
                  });
              }
              (x is PS.Data.Interval.Module._Type_Interval.DurationEnd) -> {
                PS.Data.Ordering.Module.LT;
              }
              (y is PS.Data.Interval.Module._Type_Interval.DurationEnd) -> {
                PS.Data.Ordering.Module.GT;
              }
              (x is PS.Data.Interval.Module._Type_Interval
                      .StartDuration)&&
              (y is PS.Data.Interval.Module._Type_Interval
                      .StartDuration) -> {
                val l = x.value0;
                val l1 = x.value1;
                val r = y.value0;
                val r1 = y.value1;
                object   {
                    val v = PS.Data.Ord.Module.compare.app(dictOrd1).app(l)
                              .app(r);
                  }
                  .run({
                    val v = this.v;
                    when {
                      (v is PS.Data.Ordering.Module._Type_Ordering.LT) -> {
                        PS.Data.Ordering.Module.LT;
                      }
                      (v is PS.Data.Ordering.Module._Type_Ordering.GT) -> {
                        PS.Data.Ordering.Module.GT;
                      }
                      else -> {
                        PS.Data.Ord.Module.compare.app(dictOrd).app(l1).app(r1);
                      }
                    };
                  });
              }
              (x is PS.Data.Interval.Module._Type_Interval.StartDuration) -> {
                PS.Data.Ordering.Module.LT;
              }
              (y is PS.Data.Interval.Module._Type_Interval.StartDuration) -> {
                PS.Data.Ordering.Module.GT;
              }
              (x is PS.Data.Interval.Module._Type_Interval
                      .DurationOnly)&&
              (y is PS.Data.Interval.Module._Type_Interval
                      .DurationOnly) -> {
                val l = x.value0;
                val r = y.value0;
                PS.Data.Ord.Module.compare.app(dictOrd).app(l).app(r);
              }
              else -> (error("Error in Pattern Match") as Any)
            }
          }
        })
    }
  };
  @JvmField
  val ordRecurringInterval = { dictOrd : Any ->
     { dictOrd1 : Any ->
       PS.Data.Ord.Module.Ord
         .app({ _ : Any ->
              PS.Data.Interval.Module.eqRecurringInterval
                .app((dictOrd as Map<String, Any>)["Eq0"]!!.app(Unit))
                .app((dictOrd1 as Map<String, Any>)["Eq0"]!!.app(Unit))
           })
         .app({ x : Any ->
           { y : Any ->
             when {
              (x is PS.Data.Interval.Module._Type_RecurringInterval
                      .RecurringInterval)&&
              (y is PS.Data.Interval.Module._Type_RecurringInterval
                      .RecurringInterval) -> {
                val l = x.value0;
                val l1 = x.value1;
                val r = y.value0;
                val r1 = y.value1;
                object   {
                    val v = PS.Data.Ord.Module.compare
                              .app(PS.Data.Maybe.Module.ordMaybe
                                     .app(PS.Data.Ord.Module.ordInt))
                              .app(l)
                              .app(r);
                  }
                  .run({
                    val v = this.v;
                    when {
                      (v is PS.Data.Ordering.Module._Type_Ordering.LT) -> {
                        PS.Data.Ordering.Module.LT;
                      }
                      (v is PS.Data.Ordering.Module._Type_Ordering.GT) -> {
                        PS.Data.Ordering.Module.GT;
                      }
                      else -> {
                        PS.Data.Ord.Module.compare
                          .app(PS.Data.Interval.Module.ordInterval.app(dictOrd)
                                 .app(dictOrd1))
                          .app(l1)
                          .app(r1);
                      }
                    };
                  });
              }
              else -> (error("Error in Pattern Match") as Any)
            }
          }
        })
    }
  };
  @JvmField
  val bifunctorInterval = PS.Data.Bifunctor.Module.Bifunctor
                            .app({ v : Any ->
       { v1 : Any ->
         { v2 : Any ->
           when {
            (v2 is PS.Data.Interval.Module._Type_Interval.StartEnd) -> {
              val f = v1;
              val x = v2.value0;
              val y = v2.value1;
              PS.Data.Interval.Module.StartEnd.app(f.app(x)).app(f.app(y));
            }
            (v2 is PS.Data.Interval.Module._Type_Interval.DurationEnd) -> {
              val g = v;
              val f = v1;
              val d = v2.value0;
              val x = v2.value1;
              PS.Data.Interval.Module.DurationEnd.app(g.app(d)).app(f.app(x));
            }
            (v2 is PS.Data.Interval.Module._Type_Interval.StartDuration) -> {
              val g = v;
              val f = v1;
              val x = v2.value0;
              val d = v2.value1;
              PS.Data.Interval.Module.StartDuration.app(f.app(x)).app(g.app(d));
            }
            (v2 is PS.Data.Interval.Module._Type_Interval.DurationOnly) -> {
              val g = v;
              val d = v2.value0;
              PS.Data.Interval.Module.DurationOnly.app(g.app(d));
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      }
    });
  @JvmField
  val bifunctorRecurringInterval = PS.Data.Bifunctor.Module.Bifunctor
                                     .app({ f : Any ->
       { g : Any ->
         { v : Any ->
           when {
            (v is PS.Data.Interval.Module._Type_RecurringInterval
                    .RecurringInterval) -> {
              val f1 = f;
              val g1 = g;
              val n = v.value0;
              val i = v.value1;
              PS.Data.Interval.Module.RecurringInterval.app(n)
                .app(PS.Data.Bifunctor.Module.bimap
                       .app(PS.Data.Interval.Module.bifunctorInterval)
                       .app(f1)
                       .app(g1)
                       .app(i));
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      }
    });
  @JvmField
  val functorInterval = PS.Data.Functor.Module.Functor
                          .app(PS.Data.Bifunctor.Module.bimap
                                 .app(PS.Data.Interval.Module.bifunctorInterval)
                                 .app(PS.Control.Category.Module.identity
                                        .app(
        PS.Control.Category.Module.categoryFn)));
  @JvmField
  val extendInterval = PS.Control.Extend.Module.Extend
                         .app({ _ : Any ->
                              PS.Data.Interval.Module.functorInterval
                           })
                         .app({ f : Any ->
       { v : Any ->
         when {
          (v is PS.Data.Interval.Module._Type_Interval.StartEnd) -> {
            val f1 = f;
            val a = v;
            val x = v.value0;
            val y = v.value1;
            PS.Data.Interval.Module.StartEnd.app(f1.app(a)).app(f1.app(a));
          }
          (v is PS.Data.Interval.Module._Type_Interval.DurationEnd) -> {
            val f1 = f;
            val a = v;
            val d = v.value0;
            val x = v.value1;
            PS.Data.Interval.Module.DurationEnd.app(d).app(f1.app(a));
          }
          (v is PS.Data.Interval.Module._Type_Interval.StartDuration) -> {
            val f1 = f;
            val a = v;
            val x = v.value0;
            val d = v.value1;
            PS.Data.Interval.Module.StartDuration.app(f1.app(a)).app(d);
          }
          (v is PS.Data.Interval.Module._Type_Interval.DurationOnly) -> {
            val f1 = f;
            val d = v.value0;
            PS.Data.Interval.Module.DurationOnly.app(d);
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val functorRecurringInterval = PS.Data.Functor.Module.Functor
                                   .app({ f : Any ->
       { v : Any ->
         when {
          (v is PS.Data.Interval.Module._Type_RecurringInterval
                  .RecurringInterval) -> {
            val f1 = f;
            val n = v.value0;
            val i = v.value1;
            PS.Data.Interval.Module.RecurringInterval.app(n)
              .app(PS.Data.Functor.Module.map
                     .app(PS.Data.Interval.Module.functorInterval)
                     .app(f1)
                     .app(i));
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val extendRecurringInterval = PS.Control.Extend.Module.Extend
                                  .app({ _ : Any ->
                                       PS.Data.Interval.Module.functorRecurringInterval
                                    })
                                  .app({ f : Any ->
       { v : Any ->
         when {
          (v is PS.Data.Interval.Module._Type_RecurringInterval
                  .RecurringInterval) -> {
            val f1 = f;
            val a = v;
            val n = v.value0;
            val i = v.value1;
            PS.Data.Interval.Module.RecurringInterval.app(n)
              .app(PS.Control.Extend.Module.extend
                     .app(PS.Data.Interval.Module.extendInterval)
                     .app(PS.Data.Function.Module._const.app(f1.app(a)))
                     .app(i));
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField val traversableInterval = (::__rec_traversableInterval)();
  fun __rec_traversableInterval(): Any = PS.Data.Traversable.Module.Traversable
                                           .app({ _ : Any ->
                                                PS.Data.Interval.Module.foldableInterval
                                             })
                                           .app({ _ : Any ->
                                                PS.Data.Interval.Module.functorInterval
                                             })
                                           .app({ dictApplicative : Any ->
                                                PS.Data.Traversable.Module.sequenceDefault
                                                  .app(
                                                    PS.Data.Interval.Module.traversableInterval
                                                  )
                                                  .app(dictApplicative)
                                             })
                                           .app({ dictApplicative : Any ->
       { v : Any ->
         { v1 : Any ->
           when {
            (v1 is PS.Data.Interval.Module._Type_Interval.StartEnd) -> {
              val f = v;
              val x = v1.value0;
              val y = v1.value1;
              PS.Control.Apply.Module.apply
                .app((dictApplicative as Map<String, Any>)["Apply0"]!!.app(Unit)
                )
                .app(PS.Data.Functor.Module.map
                       .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                               .app(Unit) as Map<String, Any>)["Functor0"]!!
                              .app(Unit))
                       .app(PS.Data.Interval.Module.StartEnd)
                       .app(f.app(x)))
                .app(f.app(y));
            }
            (v1 is PS.Data.Interval.Module._Type_Interval.DurationEnd) -> {
              val f = v;
              val d = v1.value0;
              val x = v1.value1;
              PS.Data.Functor.Module.mapFlipped
                .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                        .app(Unit) as Map<String, Any>)["Functor0"]!!
                       .app(Unit))
                .app(f.app(x))
                .app(PS.Data.Interval.Module.DurationEnd.app(d));
            }
            (v1 is PS.Data.Interval.Module._Type_Interval.StartDuration) -> {
              val f = v;
              val x = v1.value0;
              val d = v1.value1;
              PS.Data.Functor.Module.mapFlipped
                .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                        .app(Unit) as Map<String, Any>)["Functor0"]!!
                       .app(Unit))
                .app(f.app(x))
                .app({ v2 : Any ->
                   PS.Data.Interval.Module.StartDuration.app(v2).app(d)
                });
            }
            (v1 is PS.Data.Interval.Module._Type_Interval.DurationOnly) -> {
              val d = v1.value0;
              PS.Control.Applicative.Module.pure.app(dictApplicative)
                .app(PS.Data.Interval.Module.DurationOnly.app(d));
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      }
    });
  @JvmField
  val traversableRecurringInterval = (::__rec_traversableRecurringInterval)();
  fun __rec_traversableRecurringInterval(): Any = PS.Data.Traversable.Module.Traversable
                                                    .app({ _ : Any ->
                                                         PS.Data.Interval.Module.foldableRecurringInterval
                                                      })
                                                    .app({ _ : Any ->
                                                         PS.Data.Interval.Module.functorRecurringInterval
                                                      })
                                                    .app(
                                                      { dictApplicative : Any ->
                                                         PS.Data.Traversable.Module.sequenceDefault
                                                           .app(
                                                             PS.Data.Interval.Module.traversableRecurringInterval
                                                           )
                                                           .app(dictApplicative)
                                                      })
                                                    .app(
    { dictApplicative : Any ->
       { f : Any ->
         { i : Any ->
           PS.Data.Interval.Module.over
             .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                     .app(Unit) as Map<String, Any>)["Functor0"]!!
                    .app(Unit))
             .app(PS.Data.Traversable.Module.traverse
                    .app(PS.Data.Interval.Module.traversableInterval)
                    .app(dictApplicative)
                    .app(f))
             .app(i)
        }
      }
    });
  @JvmField val bifoldableInterval = (::__rec_bifoldableInterval)();
  fun __rec_bifoldableInterval(): Any = PS.Data.Bifoldable.Module.Bifoldable
                                          .app({ dictMonoid : Any ->
                                               PS.Data.Bifoldable.Module.bifoldMapDefaultL
                                                 .app(
                                                   PS.Data.Interval.Module.bifoldableInterval
                                                 )
                                                 .app(dictMonoid)
                                            })
                                          .app({ v : Any ->
                                               { v1 : Any ->
                                                 { z : Any ->
                                                   { v2 : Any ->
                                                     when {
                                                      (v2 is PS.Data.Interval.Module._Type_Interval
                                                               .StartEnd) -> {
                                                        val f = v1;
                                                        val z1 = z;
                                                        val x = v2.value0;
                                                        val y = v2.value1;
                                                        f.app(f.app(z1).app(x))
                                                          .app(y);
                                                      }
                                                      (v2 is PS.Data.Interval.Module._Type_Interval
                                                               .DurationEnd) -> {
                                                        val g = v;
                                                        val f = v1;
                                                        val z1 = z;
                                                        val d = v2.value0;
                                                        val x = v2.value1;
                                                        f.app(g.app(z1).app(d))
                                                          .app(x);
                                                      }
                                                      (v2 is PS.Data.Interval.Module._Type_Interval
                                                               .StartDuration) -> {
                                                        val g = v;
                                                        val f = v1;
                                                        val z1 = z;
                                                        val x = v2.value0;
                                                        val d = v2.value1;
                                                        f.app(g.app(z1).app(d))
                                                          .app(x);
                                                      }
                                                      (v2 is PS.Data.Interval.Module._Type_Interval
                                                               .DurationOnly) -> {
                                                        val g = v;
                                                        val z1 = z;
                                                        val d = v2.value0;
                                                        g.app(z1).app(d);
                                                      }
                                                      else -> (error(
                                                        "Error in Pattern Match"
                                                      ) as Any)
                                                    }
                                                  }
                                                }
                                              }
                                            })
                                          .app({ x : Any ->
       PS.Data.Bifoldable.Module.bifoldrDefault
         .app(PS.Data.Interval.Module.bifoldableInterval)
         .app(x)
    });
  @JvmField
  val bifoldableRecurringInterval = (::__rec_bifoldableRecurringInterval)();
  fun __rec_bifoldableRecurringInterval(): Any = PS.Data.Bifoldable.Module.Bifoldable
                                                   .app({ dictMonoid : Any ->
                                                        PS.Data.Bifoldable.Module.bifoldMapDefaultL
                                                          .app(
                                                            PS.Data.Interval.Module.bifoldableRecurringInterval
                                                          )
                                                          .app(dictMonoid)
                                                     })
                                                   .app({ f : Any ->
                                                        { g : Any ->
                                                          { i : Any ->
                                                            PS.Control.Semigroupoid.Module.compose
                                                              .app(
                                                                PS.Control.Semigroupoid.Module.semigroupoidFn
                                                              )
                                                              .app(
                                                                PS.Data.Bifoldable.Module.bifoldl
                                                                  .app(
                                                                    PS.Data.Interval.Module.bifoldableInterval
                                                                  )
                                                                  .app(f)
                                                                  .app(g)
                                                                  .app(i))
                                                              .app(
                                                             PS.Data.Interval.Module.interval
                                                           )
                                                         }
                                                       }
                                                     })
                                                   .app({ f : Any ->
       { g : Any ->
         { i : Any ->
           PS.Control.Semigroupoid.Module.compose
             .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
             .app(PS.Data.Bifoldable.Module.bifoldr
                    .app(PS.Data.Interval.Module.bifoldableInterval)
                    .app(f)
                    .app(g)
                    .app(i))
             .app(PS.Data.Interval.Module.interval)
        }
      }
    });
  @JvmField val bitraversableInterval = (::__rec_bitraversableInterval)();
  fun __rec_bitraversableInterval(): Any = PS.Data.Bitraversable.Module.Bitraversable
                                             .app({ _ : Any ->
                                                  PS.Data.Interval.Module.bifoldableInterval
                                               })
                                             .app({ _ : Any ->
                                                  PS.Data.Interval.Module.bifunctorInterval
                                               })
                                             .app({ dictApplicative : Any ->
                                                  PS.Data.Bitraversable.Module.bisequenceDefault
                                                    .app(
                                                      PS.Data.Interval.Module.bitraversableInterval
                                                    )
                                                    .app(dictApplicative)
                                               })
                                             .app({ dictApplicative : Any ->
       { v : Any ->
         { v1 : Any ->
           { v2 : Any ->
             when {
              (v2 is PS.Data.Interval.Module._Type_Interval.StartEnd) -> {
                val r = v1;
                val x = v2.value0;
                val y = v2.value1;
                PS.Control.Apply.Module.apply
                  .app((dictApplicative as Map<String, Any>)["Apply0"]!!
                         .app(Unit))
                  .app(PS.Data.Functor.Module.map
                         .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                                 .app(Unit) as Map<String, Any>)["Functor0"]!!
                                .app(Unit))
                         .app(PS.Data.Interval.Module.StartEnd)
                         .app(r.app(x)))
                  .app(r.app(y));
              }
              (v2 is PS.Data.Interval.Module._Type_Interval.DurationEnd) -> {
                val l = v;
                val r = v1;
                val d = v2.value0;
                val x = v2.value1;
                PS.Control.Apply.Module.apply
                  .app((dictApplicative as Map<String, Any>)["Apply0"]!!
                         .app(Unit))
                  .app(PS.Data.Functor.Module.map
                         .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                                 .app(Unit) as Map<String, Any>)["Functor0"]!!
                                .app(Unit))
                         .app(PS.Data.Interval.Module.DurationEnd)
                         .app(l.app(d)))
                  .app(r.app(x));
              }
              (v2 is PS.Data.Interval.Module._Type_Interval.StartDuration) -> {
                val l = v;
                val r = v1;
                val x = v2.value0;
                val d = v2.value1;
                PS.Control.Apply.Module.apply
                  .app((dictApplicative as Map<String, Any>)["Apply0"]!!
                         .app(Unit))
                  .app(PS.Data.Functor.Module.map
                         .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                                 .app(Unit) as Map<String, Any>)["Functor0"]!!
                                .app(Unit))
                         .app(PS.Data.Interval.Module.StartDuration)
                         .app(r.app(x)))
                  .app(l.app(d));
              }
              (v2 is PS.Data.Interval.Module._Type_Interval.DurationOnly) -> {
                val l = v;
                val d = v2.value0;
                PS.Data.Functor.Module.map
                  .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                          .app(Unit) as Map<String, Any>)["Functor0"]!!
                         .app(Unit))
                  .app(PS.Data.Interval.Module.DurationOnly)
                  .app(l.app(d));
              }
              else -> (error("Error in Pattern Match") as Any)
            }
          }
        }
      }
    });
  @JvmField
  val bitraversableRecurringInterval = (::__rec_bitraversableRecurringInterval)(
  );
  fun __rec_bitraversableRecurringInterval(): Any = PS.Data.Bitraversable.Module.Bitraversable
                                                      .app({ _ : Any ->
                                                           PS.Data.Interval.Module.bifoldableRecurringInterval
                                                        })
                                                      .app({ _ : Any ->
                                                           PS.Data.Interval.Module.bifunctorRecurringInterval
                                                        })
                                                      .app(
                                                        { dictApplicative : Any ->
                                                           PS.Data.Bitraversable.Module.bisequenceDefault
                                                             .app(
                                                               PS.Data.Interval.Module.bitraversableRecurringInterval
                                                             )
                                                             .app(
                                                            dictApplicative)
                                                        })
                                                      .app(
    { dictApplicative : Any ->
       { l : Any ->
         { r : Any ->
           { i : Any ->
             PS.Data.Interval.Module.over
               .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                       .app(Unit) as Map<String, Any>)["Functor0"]!!
                      .app(Unit))
               .app(PS.Data.Bitraversable.Module.bitraverse
                      .app(PS.Data.Interval.Module.bitraversableInterval)
                      .app(dictApplicative)
                      .app(l)
                      .app(r))
               .app(i)
          }
        }
      }
    });
}