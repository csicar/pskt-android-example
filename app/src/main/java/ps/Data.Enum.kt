@file:Suppress("UNCHECKED_CAST")
package PS.Data.Enum
import Foreign.PsRuntime.app
object Module  {
  val toCharCode = Foreign.Data.Enum.toCharCode;
  val fromCharCode = Foreign.Data.Enum.fromCharCode;
  @JvmField val Cardinality = { x : Any -> x};
  @JvmField
  val Enum = { Ord0 : Any ->
     { pred : Any ->
       { succ : Any ->
         mapOf(("Ord0" to Ord0),  ("pred" to pred),  ("succ" to succ))
      }
    }
  };
  @JvmField
  val BoundedEnum = { Bounded0 : Any ->
     { Enum1 : Any ->
       { cardinality : Any ->
         { fromEnum : Any ->
           { toEnum : Any ->
             mapOf(("Bounded0" to Bounded0),  ("Enum1" to Enum1),  
              ("cardinality" to cardinality),  ("fromEnum" to fromEnum),  
              ("toEnum" to toEnum))
          }
        }
      }
    }
  };
  @JvmField
  val toEnum = { dict : Any ->
     (dict as Map<String, Any>)["toEnum"]!!
  };
  @JvmField val succ = { dict : Any -> (dict as Map<String, Any>)["succ"]!!};
  @JvmField
  val upFromIncluding = { dictEnum : Any ->
     { dictUnfoldable1 : Any ->
       PS.Data.Unfoldable1.Module.unfoldr1.app(dictUnfoldable1)
         .app(PS.Control.Apply.Module.apply.app(PS.Control.Apply.Module.applyFn)
                .app(PS.Data.Tuple.Module.Tuple)
                .app(PS.Data.Enum.Module.succ.app(dictEnum)))
    }
  };
  @JvmField
  val showCardinality = PS.Data.Show.Module.Show
                          .app({ v : Any ->
       when {
        else -> {
          val n = v;
          (("(Cardinality " as String) + (((PS.Data.Show.Module.show
                                              .app(PS.Data.Show.Module.showInt)
                                              .app(n
          ) as String) + (")" as String)) as String));
        }
      }
    });
  @JvmField val pred = { dict : Any -> (dict as Map<String, Any>)["pred"]!!};
  @JvmField val ordCardinality = PS.Data.Ord.Module.ordInt;
  @JvmField
  val newtypeCardinality = PS.Data.Newtype.Module.Newtype
                             .app({ n : Any ->
                                  when {
                                   else -> {
                                     val a = n;
                                     a;
                                   }
                                 }
                               })
                             .app(PS.Data.Enum.Module.Cardinality);
  @JvmField
  val fromEnum = { dict : Any ->
     (dict as Map<String, Any>)["fromEnum"]!!
  };
  @JvmField
  val toEnumWithDefaults = { dictBoundedEnum : Any ->
     { low : Any ->
       { high : Any ->
         { x : Any ->
           object   {
               val v = PS.Data.Enum.Module.toEnum.app(dictBoundedEnum).app(x);
             }
             .run({
              val v = this.v;
              when {
                (v is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
                  val _enum = v.value0;
                  _enum;
                }
                (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                  when {
                    (PS.Data.Ord.Module.lessThan.app(PS.Data.Ord.Module.ordInt)
                       .app(x)
                       .app(PS.Data.Enum.Module.fromEnum.app(dictBoundedEnum)
                              .app(PS.Data.Bounded.Module.bottom
                                     .app(
                          (dictBoundedEnum as Map<String, Any>)["Bounded0"]!!
                            .app(Unit)))) == true) -> {
                      low;
                    }
                    else -> {
                      high;
                    }
                  };
                }
                else -> (error("Error in Pattern Match") as Any)
              };
            })
        }
      }
    }
  };
  @JvmField val eqCardinality = PS.Data.Eq.Module.eqInt;
  @JvmField
  val enumUnit = PS.Data.Enum.Module.Enum
                   .app({ _ : Any ->
                        PS.Data.Ord.Module.ordUnit
                     })
                   .app(PS.Data.Function.Module._const
                          .app(PS.Data.Maybe.Module.Nothing))
                   .app(PS.Data.Function.Module._const
                          .app(PS.Data.Maybe.Module.Nothing));
  @JvmField
  val enumTuple = { dictEnum : Any ->
     { dictBoundedEnum : Any ->
       PS.Data.Enum.Module.Enum
         .app({ _ : Any ->
              PS.Data.Tuple.Module.ordTuple
                .app((dictEnum as Map<String, Any>)["Ord0"]!!.app(Unit))
                .app(((dictBoundedEnum as Map<String, Any>)["Enum1"]!!
                        .app(Unit) as Map<String, Any>)["Ord0"]!!
                       .app(Unit))
           })
         .app({ v : Any ->
              when {
               (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                 val a = v.value0;
                 val b = v.value1;
                 PS.Data.Maybe.Module.maybe
                   .app(PS.Data.Functor.Module.map
                          .app(PS.Data.Maybe.Module.functorMaybe)
                          .app(PS.Data.Function.Module.flip
                                 .app(PS.Data.Tuple.Module.Tuple)
                                 .app(PS.Data.Bounded.Module.top
                                        .app(
                                (dictBoundedEnum as Map<String, Any>)["Bounded0"]!!
                                  .app(Unit))))
                          .app(PS.Data.Enum.Module.pred.app(dictEnum).app(a)))
                   .app(PS.Control.Semigroupoid.Module.compose
                          .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                          .app(PS.Data.Maybe.Module.Just)
                          .app(PS.Data.Tuple.Module.Tuple.app(a)))
                   .app(PS.Data.Enum.Module.pred
                          .app((dictBoundedEnum as Map<String, Any>)["Enum1"]!!
                                 .app(Unit))
                          .app(b));
               }
               else -> (error("Error in Pattern Match") as Any)
             }
           })
         .app({ v : Any ->
           when {
            (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
              val a = v.value0;
              val b = v.value1;
              PS.Data.Maybe.Module.maybe
                .app(PS.Data.Functor.Module.map
                       .app(PS.Data.Maybe.Module.functorMaybe)
                       .app(PS.Data.Function.Module.flip
                              .app(PS.Data.Tuple.Module.Tuple)
                              .app(PS.Data.Bounded.Module.bottom
                                     .app(
                             (dictBoundedEnum as Map<String, Any>)["Bounded0"]!!
                               .app(Unit))))
                       .app(PS.Data.Enum.Module.succ.app(dictEnum).app(a)))
                .app(PS.Control.Semigroupoid.Module.compose
                       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                       .app(PS.Data.Maybe.Module.Just)
                       .app(PS.Data.Tuple.Module.Tuple.app(a)))
                .app(PS.Data.Enum.Module.succ
                       .app((dictBoundedEnum as Map<String, Any>)["Enum1"]!!
                              .app(Unit))
                       .app(b));
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        })
    }
  };
  @JvmField
  val enumOrdering = PS.Data.Enum.Module.Enum
                       .app({ _ : Any ->
                            PS.Data.Ord.Module.ordOrdering
                         })
                       .app({ v : Any ->
                            when {
                             (v is PS.Data.Ordering.Module._Type_Ordering
                                     .LT) -> {
                               PS.Data.Maybe.Module.Nothing;
                             }
                             (v is PS.Data.Ordering.Module._Type_Ordering
                                     .EQ) -> {
                               PS.Data.Maybe.Module.Just
                                 .app(PS.Data.Ordering.Module.LT);
                             }
                             (v is PS.Data.Ordering.Module._Type_Ordering
                                     .GT) -> {
                               PS.Data.Maybe.Module.Just
                                 .app(PS.Data.Ordering.Module.EQ);
                             }
                             else -> (error("Error in Pattern Match") as Any)
                           }
                         })
                       .app({ v : Any ->
       when {
        (v is PS.Data.Ordering.Module._Type_Ordering.LT) -> {
          PS.Data.Maybe.Module.Just.app(PS.Data.Ordering.Module.EQ);
        }
        (v is PS.Data.Ordering.Module._Type_Ordering.EQ) -> {
          PS.Data.Maybe.Module.Just.app(PS.Data.Ordering.Module.GT);
        }
        (v is PS.Data.Ordering.Module._Type_Ordering.GT) -> {
          PS.Data.Maybe.Module.Nothing;
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    });
  @JvmField
  val enumMaybe = { dictBoundedEnum : Any ->
     PS.Data.Enum.Module.Enum
       .app({ _ : Any ->
            PS.Data.Maybe.Module.ordMaybe
              .app(((dictBoundedEnum as Map<String, Any>)["Enum1"]!!
                      .app(Unit) as Map<String, Any>)["Ord0"]!!
                     .app(Unit))
         })
       .app({ v : Any ->
            when {
             (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
               PS.Data.Maybe.Module.Nothing;
             }
             (v is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
               val a = v.value0;
               PS.Data.Maybe.Module.Just
                 .app(PS.Data.Enum.Module.pred
                        .app((dictBoundedEnum as Map<String, Any>)["Enum1"]!!
                               .app(Unit))
                        .app(a));
             }
             else -> (error("Error in Pattern Match") as Any)
           }
         })
       .app({ v : Any ->
         when {
          (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
            PS.Data.Maybe.Module.Just
              .app(PS.Data.Maybe.Module.Just
                     .app(PS.Data.Bounded.Module.bottom
                            .app(
                  (dictBoundedEnum as Map<String, Any>)["Bounded0"]!!.app(Unit))
              ));
          }
          (v is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
            val a = v.value0;
            PS.Data.Functor.Module.map.app(PS.Data.Maybe.Module.functorMaybe)
              .app(PS.Data.Maybe.Module.Just)
              .app(PS.Data.Enum.Module.succ
                     .app((dictBoundedEnum as Map<String, Any>)["Enum1"]!!
                            .app(Unit))
                     .app(a));
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      })
  };
  @JvmField
  val enumInt = PS.Data.Enum.Module.Enum
                  .app({ _ : Any ->
                       PS.Data.Ord.Module.ordInt
                    })
                  .app({ n : Any ->
                       when {
                        (PS.Data.Ord.Module.greaterThan
                           .app(PS.Data.Ord.Module.ordInt)
                           .app(n)
                           .app(PS.Data.Bounded.Module.bottom
                                  .app(PS.Data.Bounded.Module.boundedInt)
                        ) == true) -> {
                          PS.Data.Maybe.Module.Just
                            .app(PS.Data.Ring.Module.sub
                                   .app(PS.Data.Ring.Module.ringInt)
                                   .app(n)
                                   .app(1));
                        }
                        else -> {
                          PS.Data.Maybe.Module.Nothing;
                        }
                      }
                    })
                  .app({ n : Any ->
       when {
        (PS.Data.Ord.Module.lessThan.app(PS.Data.Ord.Module.ordInt).app(n)
           .app(PS.Data.Bounded.Module.top
                  .app(PS.Data.Bounded.Module.boundedInt)) == true) -> {
          PS.Data.Maybe.Module.Just
            .app(PS.Data.Semiring.Module.add
                   .app(PS.Data.Semiring.Module.semiringInt)
                   .app(n)
                   .app(1));
        }
        else -> {
          PS.Data.Maybe.Module.Nothing;
        }
      }
    });
  @JvmField
  val enumFromTo = { dictEnum : Any ->
     { dictUnfoldable1 : Any ->
       object   {
           val go = { step : Any ->
              { op : Any ->
                { to : Any ->
                  { a : Any ->
                    PS.Data.Tuple.Module.Tuple.app(a)
                      .app(PS.Control.Bind.Module.bind
                             .app(PS.Data.Maybe.Module.bindMaybe)
                             .app(step.app(a))
                             .app({ a_tick : Any ->
                          PS.Data.Functor.Module.voidLeft
                            .app(PS.Data.Maybe.Module.functorMaybe)
                            .app(PS.Control.MonadZero.Module.guard
                                   .app(PS.Data.Maybe.Module.monadZeroMaybe)
                                   .app(op.app(a_tick).app(to)))
                            .app(a_tick)
                       }))
                 }
               }
             }
           };
         }
         .run({
          val go = this.go;
          { v : Any ->
             { v1 : Any ->
               when {
                (PS.Data.Eq.Module.eq
                   .app(((dictEnum as Map<String, Any>)["Ord0"]!!
                           .app(Unit) as Map<String, Any>)["Eq0"]!!
                          .app(Unit))
                   .app(v)
                   .app(v1) as Boolean) -> {
                  val from = v;
                  val to = v1;
                  PS.Data.Unfoldable1.Module.singleton.app(dictUnfoldable1)
                    .app(from);
                }
                (PS.Data.Ord.Module.lessThan
                   .app((dictEnum as Map<String, Any>)["Ord0"]!!.app(Unit))
                   .app(v)
                   .app(v1) as Boolean) -> {
                  val from = v;
                  val to = v1;
                  PS.Data.Unfoldable1.Module.unfoldr1.app(dictUnfoldable1)
                    .app(go.app(PS.Data.Enum.Module.succ.app(dictEnum))
                           .app(PS.Data.Ord.Module.lessThanOrEq
                                  .app((dictEnum as Map<String, Any>)["Ord0"]!!
                                         .app(Unit)))
                           .app(to))
                    .app(from);
                }
                (PS.Data.Boolean.Module.otherwise as Boolean) -> {
                  val from = v;
                  val to = v1;
                  PS.Data.Unfoldable1.Module.unfoldr1.app(dictUnfoldable1)
                    .app(go.app(PS.Data.Enum.Module.pred.app(dictEnum))
                           .app(PS.Data.Ord.Module.greaterThanOrEq
                                  .app((dictEnum as Map<String, Any>)["Ord0"]!!
                                         .app(Unit)))
                           .app(to))
                    .app(from);
                }
                else -> (error("Error in Pattern Match") as Any)
              }
            }
          };
        })
    }
  };
  @JvmField
  val enumFromThenTo = { dictUnfoldable : Any ->
     { dictFunctor : Any ->
       { dictBoundedEnum : Any ->
         object   {
             val go = { step : Any ->
                { to : Any ->
                  { e : Any ->
                    when {
                     (PS.Data.Ord.Module.lessThanOrEq
                        .app(PS.Data.Ord.Module.ordInt)
                        .app(e)
                        .app(to) as Boolean) -> {
                       val step1 = step;
                       val to1 = to;
                       val e1 = e;
                       PS.Data.Maybe.Module.Just
                         .app(PS.Data.Tuple.Module.Tuple.app(e1)
                                .app(PS.Data.Semiring.Module.add
                                       .app(PS.Data.Semiring.Module.semiringInt)
                                       .app(e1)
                                       .app(step1)));
                     }
                     (PS.Data.Boolean.Module.otherwise as Boolean) -> {
                       val step1 = step;
                       val to1 = to;
                       val e1 = e;
                       PS.Data.Maybe.Module.Nothing;
                     }
                     else -> (error("Error in Pattern Match") as Any)
                   }
                 }
               }
             };
           }
           .run({
            val go = this.go;
            PS.Partial.Unsafe.Module.unsafePartial
              .app({ dictPartial : Any ->
                 { a : Any ->
                   { b : Any ->
                     { c : Any ->
                       object   {
                           val c_tick = PS.Data.Enum.Module.fromEnum
                                          .app(dictBoundedEnum)
                                          .app(c);
                           val b_tick = PS.Data.Enum.Module.fromEnum
                                          .app(dictBoundedEnum)
                                          .app(b);
                           val a_tick = PS.Data.Enum.Module.fromEnum
                                          .app(dictBoundedEnum)
                                          .app(a);
                         }
                         .run({
                          val c_tick = this.c_tick;
                          val b_tick = this.b_tick;
                          val a_tick = this.a_tick;
                          PS.Data.Functor.Module.map.app(dictFunctor)
                            .app(PS.Control.Semigroupoid.Module.composeFlipped
                                   .app(
                                     PS.Control.Semigroupoid.Module.semigroupoidFn
                                   )
                                   .app(PS.Data.Enum.Module.toEnum
                                          .app(dictBoundedEnum))
                                   .app(PS.Data.Maybe.Module.fromJust.app(Unit))
                            )
                            .app(PS.Data.Unfoldable.Module.unfoldr
                                   .app(dictUnfoldable)
                                   .app(go
                                          .app(PS.Data.Ring.Module.sub
                                                 .app(
                                                   PS.Data.Ring.Module.ringInt)
                                                 .app(b_tick)
                                                 .app(a_tick))
                                          .app(c_tick))
                                   .app(a_tick));
                        })
                    }
                  }
                }
              });
          })
      }
    }
  };
  @JvmField
  val enumEither = { dictBoundedEnum : Any ->
     { dictBoundedEnum1 : Any ->
       PS.Data.Enum.Module.Enum
         .app({ _ : Any ->
              PS.Data.Either.Module.ordEither
                .app(((dictBoundedEnum as Map<String, Any>)["Enum1"]!!
                        .app(Unit) as Map<String, Any>)["Ord0"]!!
                       .app(Unit))
                .app(((dictBoundedEnum1 as Map<String, Any>)["Enum1"]!!
                        .app(Unit) as Map<String, Any>)["Ord0"]!!
                       .app(Unit))
           })
         .app({ v : Any ->
              when {
               (v is PS.Data.Either.Module._Type_Either.Left) -> {
                 val a = v.value0;
                 PS.Data.Maybe.Module.maybe.app(PS.Data.Maybe.Module.Nothing)
                   .app(PS.Control.Semigroupoid.Module.compose
                          .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                          .app(PS.Data.Maybe.Module.Just)
                          .app(PS.Data.Either.Module.Left))
                   .app(PS.Data.Enum.Module.pred
                          .app((dictBoundedEnum as Map<String, Any>)["Enum1"]!!
                                 .app(Unit))
                          .app(a));
               }
               (v is PS.Data.Either.Module._Type_Either.Right) -> {
                 val b = v.value0;
                 PS.Data.Maybe.Module.maybe
                   .app(PS.Data.Maybe.Module.Just
                          .app(PS.Data.Either.Module.Left
                                 .app(PS.Data.Bounded.Module.top
                                        .app(
                           (dictBoundedEnum as Map<String, Any>)["Bounded0"]!!
                             .app(Unit)))))
                   .app(PS.Control.Semigroupoid.Module.compose
                          .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                          .app(PS.Data.Maybe.Module.Just)
                          .app(PS.Data.Either.Module.Right))
                   .app(PS.Data.Enum.Module.pred
                          .app((dictBoundedEnum1 as Map<String, Any>)["Enum1"]!!
                                 .app(Unit))
                          .app(b));
               }
               else -> (error("Error in Pattern Match") as Any)
             }
           })
         .app({ v : Any ->
           when {
            (v is PS.Data.Either.Module._Type_Either.Left) -> {
              val a = v.value0;
              PS.Data.Maybe.Module.maybe
                .app(PS.Data.Maybe.Module.Just
                       .app(PS.Data.Either.Module.Right
                              .app(PS.Data.Bounded.Module.bottom
                                     .app(
                        (dictBoundedEnum1 as Map<String, Any>)["Bounded0"]!!
                          .app(Unit)))))
                .app(PS.Control.Semigroupoid.Module.compose
                       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                       .app(PS.Data.Maybe.Module.Just)
                       .app(PS.Data.Either.Module.Left))
                .app(PS.Data.Enum.Module.succ
                       .app((dictBoundedEnum as Map<String, Any>)["Enum1"]!!
                              .app(Unit))
                       .app(a));
            }
            (v is PS.Data.Either.Module._Type_Either.Right) -> {
              val b = v.value0;
              PS.Data.Maybe.Module.maybe.app(PS.Data.Maybe.Module.Nothing)
                .app(PS.Control.Semigroupoid.Module.compose
                       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                       .app(PS.Data.Maybe.Module.Just)
                       .app(PS.Data.Either.Module.Right))
                .app(PS.Data.Enum.Module.succ
                       .app((dictBoundedEnum1 as Map<String, Any>)["Enum1"]!!
                              .app(Unit))
                       .app(b));
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        })
    }
  };
  @JvmField
  val enumBoolean = PS.Data.Enum.Module.Enum
                      .app({ _ : Any ->
                           PS.Data.Ord.Module.ordBoolean
                        })
                      .app({ v : Any ->
                           when {
                            (v == true) -> {
                              PS.Data.Maybe.Module.Just.app(false);
                            }
                            else -> {
                              PS.Data.Maybe.Module.Nothing;
                            }
                          }
                        })
                      .app({ v : Any ->
       when {
        (v == false) -> {
          PS.Data.Maybe.Module.Just.app(true);
        }
        else -> {
          PS.Data.Maybe.Module.Nothing;
        }
      }
    });
  @JvmField
  val downFromIncluding = { dictEnum : Any ->
     { dictUnfoldable1 : Any ->
       PS.Data.Unfoldable1.Module.unfoldr1.app(dictUnfoldable1)
         .app(PS.Control.Apply.Module.apply.app(PS.Control.Apply.Module.applyFn)
                .app(PS.Data.Tuple.Module.Tuple)
                .app(PS.Data.Enum.Module.pred.app(dictEnum)))
    }
  };
  @JvmField val diag = { a : Any -> PS.Data.Tuple.Module.Tuple.app(a).app(a)};
  @JvmField
  val downFrom = { dictEnum : Any ->
     { dictUnfoldable : Any ->
       PS.Data.Unfoldable.Module.unfoldr.app(dictUnfoldable)
         .app(PS.Control.Semigroupoid.Module.compose
                .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                .app(PS.Data.Functor.Module.map
                       .app(PS.Data.Maybe.Module.functorMaybe)
                       .app(PS.Data.Enum.Module.diag))
                .app(PS.Data.Enum.Module.pred.app(dictEnum)))
    }
  };
  @JvmField
  val upFrom = { dictEnum : Any ->
     { dictUnfoldable : Any ->
       PS.Data.Unfoldable.Module.unfoldr.app(dictUnfoldable)
         .app(PS.Control.Semigroupoid.Module.compose
                .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                .app(PS.Data.Functor.Module.map
                       .app(PS.Data.Maybe.Module.functorMaybe)
                       .app(PS.Data.Enum.Module.diag))
                .app(PS.Data.Enum.Module.succ.app(dictEnum)))
    }
  };
  @JvmField
  val defaultToEnum = { dictBounded : Any ->
     { dictEnum : Any ->
       { i_tick : Any ->
         object   {
             val go = (::__rec_go)();
             fun __rec_go(): Any = { i : Any ->
                { x : Any ->
                  when {
                   (PS.Data.Eq.Module.eq.app(PS.Data.Eq.Module.eqInt).app(i)
                      .app(0) == true) -> {
                     PS.Data.Maybe.Module.Just.app(x);
                   }
                   else -> {
                     object   {
                         val v = PS.Data.Enum.Module.succ.app(dictEnum).app(x);
                       }
                       .run({
                         val v = this.v;
                         when {
                           (v is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
                             val x_tick = v.value0;
                             __rec_go()
                               .app(PS.Data.Ring.Module.sub
                                      .app(PS.Data.Ring.Module.ringInt)
                                      .app(i)
                                      .app(1))
                               .app(x_tick);
                           }
                           (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                             PS.Data.Maybe.Module.Nothing;
                           }
                           else -> (error("Error in Pattern Match") as Any)
                         };
                       });
                   }
                 }
               }
             };
           }
           .run({
            val go = this.go;
            when {
              (PS.Data.Ord.Module.lessThan.app(PS.Data.Ord.Module.ordInt)
                 .app(i_tick)
                 .app(0) == true) -> {
                PS.Data.Maybe.Module.Nothing;
              }
              else -> {
                go.app(i_tick)
                  .app(PS.Data.Bounded.Module.bottom.app(dictBounded));
              }
            };
          })
      }
    }
  };
  @JvmField
  val defaultSucc = { toEnum_tick : Any ->
     { fromEnum_tick : Any ->
       { a : Any ->
         toEnum_tick
           .app(PS.Data.Semiring.Module.add
                  .app(PS.Data.Semiring.Module.semiringInt)
                  .app(fromEnum_tick.app(a))
                  .app(1))
      }
    }
  };
  @JvmField
  val defaultPred = { toEnum_tick : Any ->
     { fromEnum_tick : Any ->
       { a : Any ->
         toEnum_tick
           .app(PS.Data.Ring.Module.sub.app(PS.Data.Ring.Module.ringInt)
                  .app(fromEnum_tick.app(a))
                  .app(1))
      }
    }
  };
  @JvmField
  val defaultFromEnum = { dictEnum : Any ->
     object   {
         val go = (::__rec_go)();
         fun __rec_go(): Any = { i : Any ->
            { x : Any ->
              object   {
                  val v = PS.Data.Enum.Module.pred.app(dictEnum).app(x);
                }
                .run({
                 val v = this.v;
                 when {
                   (v is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
                     val x_tick = v.value0;
                     __rec_go()
                       .app(PS.Data.Semiring.Module.add
                              .app(PS.Data.Semiring.Module.semiringInt)
                              .app(i)
                              .app(1))
                       .app(x_tick);
                   }
                   (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                     i;
                   }
                   else -> (error("Error in Pattern Match") as Any)
                 };
               })
           }
         };
       }
       .run({
        val go = this.go;
        go.app(0);
      })
  };
  @JvmField
  val defaultCardinality = { dictBounded : Any ->
     { dictEnum : Any ->
       object   {
           val go = (::__rec_go)();
           fun __rec_go(): Any = { i : Any ->
              { x : Any ->
                object   {
                    val v = PS.Data.Enum.Module.succ.app(dictEnum).app(x);
                  }
                  .run({
                   val v = this.v;
                   when {
                     (v is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
                       val x_tick = v.value0;
                       __rec_go()
                         .app(PS.Data.Semiring.Module.add
                                .app(PS.Data.Semiring.Module.semiringInt)
                                .app(i)
                                .app(1))
                         .app(x_tick);
                     }
                     (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                       i;
                     }
                     else -> (error("Error in Pattern Match") as Any)
                   };
                 })
             }
           };
         }
         .run({
          val go = this.go;
          PS.Data.Function.Module.apply.app(PS.Data.Enum.Module.Cardinality)
            .app(go.app(1).app(PS.Data.Bounded.Module.bottom.app(dictBounded)));
        })
    }
  };
  @JvmField
  val charToEnum = { v : Any ->
     when {
      (PS.Data.HeytingAlgebra.Module.conj
         .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
         .app(PS.Data.Ord.Module.greaterThanOrEq.app(PS.Data.Ord.Module.ordInt)
                .app(v)
                .app(PS.Data.Bounded.Module.bottom
                       .app(PS.Data.Bounded.Module.boundedInt)))
         .app(PS.Data.Ord.Module.lessThanOrEq.app(PS.Data.Ord.Module.ordInt)
                .app(v)
                .app(PS.Data.Bounded.Module.top
                       .app(PS.Data.Bounded.Module.boundedInt))
      ) as Boolean) -> {
        val n = v;
        PS.Data.Maybe.Module.Just.app(PS.Data.Enum.Module.fromCharCode.app(n));
      }
      else -> {
        PS.Data.Maybe.Module.Nothing;
      }
    }
  };
  @JvmField
  val enumChar = PS.Data.Enum.Module.Enum
                   .app({ _ : Any ->
                        PS.Data.Ord.Module.ordChar
                     })
                   .app(PS.Data.Enum.Module.defaultPred
                          .app(PS.Data.Enum.Module.charToEnum)
                          .app(PS.Data.Enum.Module.toCharCode))
                   .app(PS.Data.Enum.Module.defaultSucc
                          .app(PS.Data.Enum.Module.charToEnum)
                          .app(PS.Data.Enum.Module.toCharCode));
  @JvmField
  val cardinality = { dict : Any ->
     (dict as Map<String, Any>)["cardinality"]!!
  };
  @JvmField
  val boundedEnumUnit = PS.Data.Enum.Module.BoundedEnum
                          .app({ _ : Any ->
                               PS.Data.Bounded.Module.boundedUnit
                            })
                          .app({ _ : Any ->
                               PS.Data.Enum.Module.enumUnit
                            })
                          .app(PS.Data.Enum.Module.Cardinality.app(1))
                          .app(PS.Data.Function.Module._const.app(0))
                          .app({ v : Any ->
       when {
        (v == 0) -> {
          PS.Data.Maybe.Module.Just.app(PS.Data.Unit.Module.unit);
        }
        else -> {
          PS.Data.Maybe.Module.Nothing;
        }
      }
    });
  @JvmField
  val boundedEnumOrdering = PS.Data.Enum.Module.BoundedEnum
                              .app({ _ : Any ->
                                   PS.Data.Bounded.Module.boundedOrdering
                                })
                              .app({ _ : Any ->
                                   PS.Data.Enum.Module.enumOrdering
                                })
                              .app(PS.Data.Enum.Module.Cardinality.app(3))
                              .app({ v : Any ->
                                   when {
                                    (v is PS.Data.Ordering.Module._Type_Ordering
                                            .LT) -> {
                                      0;
                                    }
                                    (v is PS.Data.Ordering.Module._Type_Ordering
                                            .EQ) -> {
                                      1;
                                    }
                                    (v is PS.Data.Ordering.Module._Type_Ordering
                                            .GT) -> {
                                      2;
                                    }
                                    else -> (error("Error in Pattern Match"
                                    ) as Any)
                                  }
                                })
                              .app({ v : Any ->
       when {
        (v == 0) -> {
          PS.Data.Maybe.Module.Just.app(PS.Data.Ordering.Module.LT);
        }
        (v == 1) -> {
          PS.Data.Maybe.Module.Just.app(PS.Data.Ordering.Module.EQ);
        }
        (v == 2) -> {
          PS.Data.Maybe.Module.Just.app(PS.Data.Ordering.Module.GT);
        }
        else -> {
          PS.Data.Maybe.Module.Nothing;
        }
      }
    });
  @JvmField
  val boundedEnumChar = PS.Data.Enum.Module.BoundedEnum
                          .app({ _ : Any ->
                               PS.Data.Bounded.Module.boundedChar
                            })
                          .app({ _ : Any ->
                               PS.Data.Enum.Module.enumChar
                            })
                          .app(PS.Data.Enum.Module.Cardinality
                                 .app(PS.Data.Ring.Module.sub
                                        .app(PS.Data.Ring.Module.ringInt)
                                        .app(PS.Data.Enum.Module.toCharCode
                                               .app(PS.Data.Bounded.Module.top
                                                      .app(
                                              PS.Data.Bounded.Module.boundedChar
                                            )))
                                        .app(PS.Data.Enum.Module.toCharCode
                                               .app(
                                  PS.Data.Bounded.Module.bottom
                                    .app(PS.Data.Bounded.Module.boundedChar)))))
                          .app(PS.Data.Enum.Module.toCharCode)
                          .app(PS.Data.Enum.Module.charToEnum);
  @JvmField
  val boundedEnumBoolean = PS.Data.Enum.Module.BoundedEnum
                             .app({ _ : Any ->
                                  PS.Data.Bounded.Module.boundedBoolean
                               })
                             .app({ _ : Any ->
                                  PS.Data.Enum.Module.enumBoolean
                               })
                             .app(PS.Data.Enum.Module.Cardinality.app(2))
                             .app({ v : Any ->
                                  when {
                                   (v == false) -> {
                                     0;
                                   }
                                   (v == true) -> {
                                     1;
                                   }
                                   else -> (error("Error in Pattern Match"
                                   ) as Any)
                                 }
                               })
                             .app({ v : Any ->
       when {
        (v == 0) -> {
          PS.Data.Maybe.Module.Just.app(false);
        }
        (v == 1) -> {
          PS.Data.Maybe.Module.Just.app(true);
        }
        else -> {
          PS.Data.Maybe.Module.Nothing;
        }
      }
    });
}