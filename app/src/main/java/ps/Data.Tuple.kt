@file:Suppress("UNCHECKED_CAST")
package PS.Data.Tuple
import Foreign.PsRuntime.app
object Module  {
  sealed class _Type_Tuple ()  {
    data class Tuple (val value0 : Any,  val value1 : Any) : _Type_Tuple() {};
  };
  val Tuple = { value0 : Any ->
     { value1 : Any ->
       _Type_Tuple.Tuple(value0,  value1)
    }
  };
  @JvmField
  val uncurry = { f : Any ->
     { v : Any ->
       when {
        (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
          val f1 = f;
          val a = v.value0;
          val b = v.value1;
          f1.app(a).app(b);
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val swap = { v : Any ->
     when {
      (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
        val a = v.value0;
        val b = v.value1;
        PS.Data.Tuple.Module.Tuple.app(b).app(a);
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val snd = { v : Any ->
     when {
      (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
        val b = v.value1;
        b;
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val showTuple = { dictShow : Any ->
     { dictShow1 : Any ->
       PS.Data.Show.Module.Show
         .app({ v : Any ->
           when {
            (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
              val a = v.value0;
              val b = v.value1;
              (("(Tuple " as String) + (((PS.Data.Show.Module.show.app(dictShow)
                                            .app(a
              ) as String) + (((" " as String) + (((PS.Data.Show.Module.show
                                                      .app(dictShow1)
                                                      .app(b
              ) as String) + (")" as String)) as String)) as String)) as String));
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        })
    }
  };
  @JvmField
  val semiringTuple = { dictSemiring : Any ->
     { dictSemiring1 : Any ->
       PS.Data.Semiring.Module.Semiring
         .app({ v : Any ->
              { v1 : Any ->
                when {
                 (v is PS.Data.Tuple.Module._Type_Tuple
                         .Tuple)&& (v1 is PS.Data.Tuple.Module._Type_Tuple
                                            .Tuple) -> {
                   val x1 = v.value0;
                   val y1 = v.value1;
                   val x2 = v1.value0;
                   val y2 = v1.value1;
                   PS.Data.Tuple.Module.Tuple
                     .app(PS.Data.Semiring.Module.add.app(dictSemiring).app(x1)
                            .app(x2))
                     .app(PS.Data.Semiring.Module.add.app(dictSemiring1).app(y1)
                            .app(y2));
                 }
                 else -> (error("Error in Pattern Match") as Any)
               }
             }
           })
         .app({ v : Any ->
              { v1 : Any ->
                when {
                 (v is PS.Data.Tuple.Module._Type_Tuple
                         .Tuple)&& (v1 is PS.Data.Tuple.Module._Type_Tuple
                                            .Tuple) -> {
                   val x1 = v.value0;
                   val y1 = v.value1;
                   val x2 = v1.value0;
                   val y2 = v1.value1;
                   PS.Data.Tuple.Module.Tuple
                     .app(PS.Data.Semiring.Module.mul.app(dictSemiring).app(x1)
                            .app(x2))
                     .app(PS.Data.Semiring.Module.mul.app(dictSemiring1).app(y1)
                            .app(y2));
                 }
                 else -> (error("Error in Pattern Match") as Any)
               }
             }
           })
         .app(PS.Data.Tuple.Module.Tuple
                .app(PS.Data.Semiring.Module.one.app(dictSemiring))
                .app(PS.Data.Semiring.Module.one.app(dictSemiring1)))
         .app(PS.Data.Tuple.Module.Tuple
                .app(PS.Data.Semiring.Module.zero.app(dictSemiring))
                .app(PS.Data.Semiring.Module.zero.app(dictSemiring1)))
    }
  };
  @JvmField
  val semigroupoidTuple = PS.Control.Semigroupoid.Module.Semigroupoid
                            .app({ v : Any ->
       { v1 : Any ->
         when {
          (v is PS.Data.Tuple.Module._Type_Tuple
                  .Tuple)&& (v1 is PS.Data.Tuple.Module._Type_Tuple
                                     .Tuple) -> {
            val c = v.value1;
            val a = v1.value0;
            PS.Data.Tuple.Module.Tuple.app(a).app(c);
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val semigroupTuple = { dictSemigroup : Any ->
     { dictSemigroup1 : Any ->
       PS.Data.Semigroup.Module.Semigroup
         .app({ v : Any ->
           { v1 : Any ->
             when {
              (v is PS.Data.Tuple.Module._Type_Tuple
                      .Tuple)&& (v1 is PS.Data.Tuple.Module._Type_Tuple
                                         .Tuple) -> {
                val a1 = v.value0;
                val b1 = v.value1;
                val a2 = v1.value0;
                val b2 = v1.value1;
                PS.Data.Tuple.Module.Tuple
                  .app(PS.Data.Semigroup.Module.append.app(dictSemigroup)
                         .app(a1)
                         .app(a2))
                  .app(PS.Data.Semigroup.Module.append.app(dictSemigroup1)
                         .app(b1)
                         .app(b2));
              }
              else -> (error("Error in Pattern Match") as Any)
            }
          }
        })
    }
  };
  @JvmField
  val ringTuple = { dictRing : Any ->
     { dictRing1 : Any ->
       PS.Data.Ring.Module.Ring
         .app({ _ : Any ->
              PS.Data.Tuple.Module.semiringTuple
                .app((dictRing as Map<String, Any>)["Semiring0"]!!.app(Unit))
                .app((dictRing1 as Map<String, Any>)["Semiring0"]!!.app(Unit))
           })
         .app({ v : Any ->
           { v1 : Any ->
             when {
              (v is PS.Data.Tuple.Module._Type_Tuple
                      .Tuple)&& (v1 is PS.Data.Tuple.Module._Type_Tuple
                                         .Tuple) -> {
                val x1 = v.value0;
                val y1 = v.value1;
                val x2 = v1.value0;
                val y2 = v1.value1;
                PS.Data.Tuple.Module.Tuple
                  .app(PS.Data.Ring.Module.sub.app(dictRing).app(x1).app(x2))
                  .app(PS.Data.Ring.Module.sub.app(dictRing1).app(y1).app(y2));
              }
              else -> (error("Error in Pattern Match") as Any)
            }
          }
        })
    }
  };
  @JvmField
  val monoidTuple = { dictMonoid : Any ->
     { dictMonoid1 : Any ->
       PS.Data.Monoid.Module.Monoid
         .app({ _ : Any ->
              PS.Data.Tuple.Module.semigroupTuple
                .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!.app(Unit))
                .app((dictMonoid1 as Map<String, Any>)["Semigroup0"]!!.app(Unit)
             )
           })
         .app(PS.Data.Tuple.Module.Tuple
                .app(PS.Data.Monoid.Module.mempty.app(dictMonoid))
                .app(PS.Data.Monoid.Module.mempty.app(dictMonoid1)))
    }
  };
  @JvmField
  val lookup = { dictFoldable : Any ->
     { dictEq : Any ->
       { a : Any ->
         PS.Control.Semigroupoid.Module.compose
           .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
           .app(PS.Data.Newtype.Module.unwrap
                  .app(PS.Data.Maybe.First.Module.newtypeFirst))
           .app(PS.Data.Foldable.Module.foldMap.app(dictFoldable)
                  .app(PS.Data.Maybe.First.Module.monoidFirst)
                  .app({ v : Any ->
               when {
                (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                  val a_tick = v.value0;
                  val b = v.value1;
                  PS.Data.Maybe.First.Module.First
                    .app(when {
                      (PS.Data.Eq.Module.eq.app(dictEq).app(a)
                         .app(a_tick) == true) -> {
                        PS.Data.Maybe.Module.Just.app(b);
                      }
                      else -> {
                        PS.Data.Maybe.Module.Nothing;
                      }
                    });
                }
                else -> (error("Error in Pattern Match") as Any)
              }
            }))
      }
    }
  };
  @JvmField
  val heytingAlgebraTuple = { dictHeytingAlgebra : Any ->
     { dictHeytingAlgebra1 : Any ->
       PS.Data.HeytingAlgebra.Module.HeytingAlgebra
         .app({ v : Any ->
              { v1 : Any ->
                when {
                 (v is PS.Data.Tuple.Module._Type_Tuple
                         .Tuple)&& (v1 is PS.Data.Tuple.Module._Type_Tuple
                                            .Tuple) -> {
                   val x1 = v.value0;
                   val y1 = v.value1;
                   val x2 = v1.value0;
                   val y2 = v1.value1;
                   PS.Data.Tuple.Module.Tuple
                     .app(PS.Data.HeytingAlgebra.Module.conj
                            .app(dictHeytingAlgebra)
                            .app(x1)
                            .app(x2))
                     .app(PS.Data.HeytingAlgebra.Module.conj
                            .app(dictHeytingAlgebra1)
                            .app(y1)
                            .app(y2));
                 }
                 else -> (error("Error in Pattern Match") as Any)
               }
             }
           })
         .app({ v : Any ->
              { v1 : Any ->
                when {
                 (v is PS.Data.Tuple.Module._Type_Tuple
                         .Tuple)&& (v1 is PS.Data.Tuple.Module._Type_Tuple
                                            .Tuple) -> {
                   val x1 = v.value0;
                   val y1 = v.value1;
                   val x2 = v1.value0;
                   val y2 = v1.value1;
                   PS.Data.Tuple.Module.Tuple
                     .app(PS.Data.HeytingAlgebra.Module.disj
                            .app(dictHeytingAlgebra)
                            .app(x1)
                            .app(x2))
                     .app(PS.Data.HeytingAlgebra.Module.disj
                            .app(dictHeytingAlgebra1)
                            .app(y1)
                            .app(y2));
                 }
                 else -> (error("Error in Pattern Match") as Any)
               }
             }
           })
         .app(PS.Data.Tuple.Module.Tuple
                .app(PS.Data.HeytingAlgebra.Module.ff.app(dictHeytingAlgebra))
                .app(PS.Data.HeytingAlgebra.Module.ff.app(dictHeytingAlgebra1)))
         .app({ v : Any ->
              { v1 : Any ->
                when {
                 (v is PS.Data.Tuple.Module._Type_Tuple
                         .Tuple)&& (v1 is PS.Data.Tuple.Module._Type_Tuple
                                            .Tuple) -> {
                   val x1 = v.value0;
                   val y1 = v.value1;
                   val x2 = v1.value0;
                   val y2 = v1.value1;
                   PS.Data.Tuple.Module.Tuple
                     .app(PS.Data.HeytingAlgebra.Module.implies
                            .app(dictHeytingAlgebra)
                            .app(x1)
                            .app(x2))
                     .app(PS.Data.HeytingAlgebra.Module.implies
                            .app(dictHeytingAlgebra1)
                            .app(y1)
                            .app(y2));
                 }
                 else -> (error("Error in Pattern Match") as Any)
               }
             }
           })
         .app({ v : Any ->
              when {
               (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                 val x = v.value0;
                 val y = v.value1;
                 PS.Data.Tuple.Module.Tuple
                   .app(PS.Data.HeytingAlgebra.Module.not
                          .app(dictHeytingAlgebra)
                          .app(x))
                   .app(PS.Data.HeytingAlgebra.Module.not
                          .app(dictHeytingAlgebra1)
                          .app(y));
               }
               else -> (error("Error in Pattern Match") as Any)
             }
           })
         .app(PS.Data.Tuple.Module.Tuple
                .app(PS.Data.HeytingAlgebra.Module.tt.app(dictHeytingAlgebra))
                .app(PS.Data.HeytingAlgebra.Module.tt.app(dictHeytingAlgebra1)))
    }
  };
  @JvmField
  val functorTuple = PS.Data.Functor.Module.Functor
                       .app({ f : Any ->
       { m : Any ->
         when {
          (m is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
            val v = m.value0;
            val v1 = m.value1;
            PS.Data.Tuple.Module.Tuple.app(v).app(f.app(v1));
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val functorWithIndexTuple = PS.Data.FunctorWithIndex.Module.FunctorWithIndex
                                .app({ _ : Any ->
                                     PS.Data.Tuple.Module.functorTuple
                                  })
                                .app({ f : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Functor.Module.map.app(PS.Data.Tuple.Module.functorTuple))
         .app(f.app(PS.Data.Unit.Module.unit))
    });
  @JvmField
  val invariantTuple = PS.Data.Functor.Invariant.Module.Invariant
                         .app(PS.Data.Functor.Invariant.Module.imapF
                                .app(PS.Data.Tuple.Module.functorTuple));
  @JvmField
  val fst = { v : Any ->
     when {
      (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
        val a = v.value0;
        a;
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val lazyTuple = { dictLazy : Any ->
     { dictLazy1 : Any ->
       PS.Control.Lazy.Module.Lazy
         .app({ f : Any ->
           PS.Data.Tuple.Module.Tuple
             .app(PS.Data.Function.Module.apply
                    .app(PS.Control.Lazy.Module.defer.app(dictLazy))
                    .app({ v : Any ->
                    PS.Data.Tuple.Module.fst
                      .app(f.app(PS.Data.Unit.Module.unit))
                 }))
             .app(PS.Data.Function.Module.apply
                    .app(PS.Control.Lazy.Module.defer.app(dictLazy1))
                    .app({ v : Any ->
                 PS.Data.Tuple.Module.snd.app(f.app(PS.Data.Unit.Module.unit))
              }))
        })
    }
  };
  @JvmField
  val foldableTuple = PS.Data.Foldable.Module.Foldable
                        .app({ dictMonoid : Any ->
                             { f : Any ->
                               { v : Any ->
                                 when {
                                  (v is PS.Data.Tuple.Module._Type_Tuple
                                          .Tuple) -> {
                                    val f1 = f;
                                    val x = v.value1;
                                    f1.app(x);
                                  }
                                  else -> (error("Error in Pattern Match"
                                  ) as Any)
                                }
                              }
                            }
                          })
                        .app({ f : Any ->
                             { z : Any ->
                               { v : Any ->
                                 when {
                                  (v is PS.Data.Tuple.Module._Type_Tuple
                                          .Tuple) -> {
                                    val f1 = f;
                                    val z1 = z;
                                    val x = v.value1;
                                    f1.app(z1).app(x);
                                  }
                                  else -> (error("Error in Pattern Match"
                                  ) as Any)
                                }
                              }
                            }
                          })
                        .app({ f : Any ->
       { z : Any ->
         { v : Any ->
           when {
            (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
              val f1 = f;
              val z1 = z;
              val x = v.value1;
              f1.app(x).app(z1);
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      }
    });
  @JvmField
  val foldableWithIndexTuple = PS.Data.FoldableWithIndex.Module.FoldableWithIndex
                                 .app({ _ : Any ->
                                      PS.Data.Tuple.Module.foldableTuple
                                   })
                                 .app({ dictMonoid : Any ->
                                      { f : Any ->
                                        { v : Any ->
                                          when {
                                           (v is PS.Data.Tuple.Module._Type_Tuple
                                                   .Tuple) -> {
                                             val f1 = f;
                                             val x = v.value1;
                                             f1.app(PS.Data.Unit.Module.unit)
                                               .app(x);
                                           }
                                           else -> (error(
                                             "Error in Pattern Match") as Any)
                                         }
                                       }
                                     }
                                   })
                                 .app({ f : Any ->
                                      { z : Any ->
                                        { v : Any ->
                                          when {
                                           (v is PS.Data.Tuple.Module._Type_Tuple
                                                   .Tuple) -> {
                                             val f1 = f;
                                             val z1 = z;
                                             val x = v.value1;
                                             f1.app(PS.Data.Unit.Module.unit)
                                               .app(z1)
                                               .app(x);
                                           }
                                           else -> (error(
                                             "Error in Pattern Match") as Any)
                                         }
                                       }
                                     }
                                   })
                                 .app({ f : Any ->
       { z : Any ->
         { v : Any ->
           when {
            (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
              val f1 = f;
              val z1 = z;
              val x = v.value1;
              f1.app(PS.Data.Unit.Module.unit).app(x).app(z1);
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      }
    });
  @JvmField
  val traversableTuple = PS.Data.Traversable.Module.Traversable
                           .app({ _ : Any ->
                                PS.Data.Tuple.Module.foldableTuple
                             })
                           .app({ _ : Any ->
                                PS.Data.Tuple.Module.functorTuple
                             })
                           .app({ dictApplicative : Any ->
                                { v : Any ->
                                  when {
                                   (v is PS.Data.Tuple.Module._Type_Tuple
                                           .Tuple) -> {
                                     val x = v.value0;
                                     val y = v.value1;
                                     PS.Data.Functor.Module.map
                                       .app(
                                         ((dictApplicative as Map<String, Any>)["Apply0"]!!
                                            .app(Unit
                                           ) as Map<String, Any>)["Functor0"]!!
                                           .app(Unit))
                                       .app(PS.Data.Tuple.Module.Tuple.app(x))
                                       .app(y);
                                   }
                                   else -> (error("Error in Pattern Match"
                                   ) as Any)
                                 }
                               }
                             })
                           .app({ dictApplicative : Any ->
       { f : Any ->
         { v : Any ->
           when {
            (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
              val f1 = f;
              val x = v.value0;
              val y = v.value1;
              PS.Data.Functor.Module.map
                .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                        .app(Unit) as Map<String, Any>)["Functor0"]!!
                       .app(Unit))
                .app(PS.Data.Tuple.Module.Tuple.app(x))
                .app(f1.app(y));
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      }
    });
  @JvmField
  val traversableWithIndexTuple = PS.Data.TraversableWithIndex.Module.TraversableWithIndex
                                    .app({ _ : Any ->
                                         PS.Data.Tuple.Module.foldableWithIndexTuple
                                      })
                                    .app({ _ : Any ->
                                         PS.Data.Tuple.Module.functorWithIndexTuple
                                      })
                                    .app({ _ : Any ->
                                         PS.Data.Tuple.Module.traversableTuple
                                      })
                                    .app({ dictApplicative : Any ->
       { f : Any ->
         { v : Any ->
           when {
            (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
              val f1 = f;
              val x = v.value0;
              val y = v.value1;
              PS.Data.Functor.Module.map
                .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                        .app(Unit) as Map<String, Any>)["Functor0"]!!
                       .app(Unit))
                .app(PS.Data.Tuple.Module.Tuple.app(x))
                .app(f1.app(PS.Data.Unit.Module.unit).app(y));
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      }
    });
  @JvmField
  val foldable1Tuple = PS.Data.Semigroup.Foldable.Module.Foldable1
                         .app({ _ : Any ->
                              PS.Data.Tuple.Module.foldableTuple
                           })
                         .app({ dictSemigroup : Any ->
                              { v : Any ->
                                when {
                                 (v is PS.Data.Tuple.Module._Type_Tuple
                                         .Tuple) -> {
                                   val x = v.value1;
                                   x;
                                 }
                                 else -> (error("Error in Pattern Match"
                                 ) as Any)
                               }
                             }
                           })
                         .app({ dictSemigroup : Any ->
       { f : Any ->
         { v : Any ->
           when {
            (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
              val f1 = f;
              val x = v.value1;
              f1.app(x);
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      }
    });
  @JvmField
  val traversable1Tuple = PS.Data.Semigroup.Traversable.Module.Traversable1
                            .app({ _ : Any ->
                                 PS.Data.Tuple.Module.foldable1Tuple
                              })
                            .app({ _ : Any ->
                                 PS.Data.Tuple.Module.traversableTuple
                              })
                            .app({ dictApply : Any ->
                                 { v : Any ->
                                   when {
                                    (v is PS.Data.Tuple.Module._Type_Tuple
                                            .Tuple) -> {
                                      val x = v.value0;
                                      val y = v.value1;
                                      PS.Data.Functor.Module.map
                                        .app(
                                          (dictApply as Map<String, Any>)["Functor0"]!!
                                            .app(Unit))
                                        .app(PS.Data.Tuple.Module.Tuple.app(x))
                                        .app(y);
                                    }
                                    else -> (error("Error in Pattern Match"
                                    ) as Any)
                                  }
                                }
                              })
                            .app({ dictApply : Any ->
       { f : Any ->
         { v : Any ->
           when {
            (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
              val f1 = f;
              val x = v.value0;
              val y = v.value1;
              PS.Data.Functor.Module.map
                .app((dictApply as Map<String, Any>)["Functor0"]!!.app(Unit))
                .app(PS.Data.Tuple.Module.Tuple.app(x))
                .app(f1.app(y));
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      }
    });
  @JvmField
  val extendTuple = PS.Control.Extend.Module.Extend
                      .app({ _ : Any ->
                           PS.Data.Tuple.Module.functorTuple
                        })
                      .app({ f : Any ->
       { v : Any ->
         when {
          (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
            val f1 = f;
            val t = v;
            val a = v.value0;
            val b = v.value1;
            PS.Data.Tuple.Module.Tuple.app(a).app(f1.app(t));
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val eqTuple = { dictEq : Any ->
     { dictEq1 : Any ->
       PS.Data.Eq.Module.Eq
         .app({ x : Any ->
           { y : Any ->
             when {
              (x is PS.Data.Tuple.Module._Type_Tuple
                      .Tuple)&& (y is PS.Data.Tuple.Module._Type_Tuple
                                        .Tuple) -> {
                val l = x.value0;
                val l1 = x.value1;
                val r = y.value0;
                val r1 = y.value1;
                PS.Data.HeytingAlgebra.Module.conj
                  .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
                  .app(PS.Data.Eq.Module.eq.app(dictEq).app(l).app(r))
                  .app(PS.Data.Eq.Module.eq.app(dictEq1).app(l1).app(r1));
              }
              else -> (error("Error in Pattern Match") as Any)
            }
          }
        })
    }
  };
  @JvmField
  val ordTuple = { dictOrd : Any ->
     { dictOrd1 : Any ->
       PS.Data.Ord.Module.Ord
         .app({ _ : Any ->
              PS.Data.Tuple.Module.eqTuple
                .app((dictOrd as Map<String, Any>)["Eq0"]!!.app(Unit))
                .app((dictOrd1 as Map<String, Any>)["Eq0"]!!.app(Unit))
           })
         .app({ x : Any ->
           { y : Any ->
             when {
              (x is PS.Data.Tuple.Module._Type_Tuple
                      .Tuple)&& (y is PS.Data.Tuple.Module._Type_Tuple
                                        .Tuple) -> {
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
              else -> (error("Error in Pattern Match") as Any)
            }
          }
        })
    }
  };
  @JvmField
  val eq1Tuple = { dictEq : Any ->
     PS.Data.Eq.Module.Eq1
       .app({ dictEq1 : Any ->
         PS.Data.Eq.Module.eq
           .app(PS.Data.Tuple.Module.eqTuple.app(dictEq).app(dictEq1))
      })
  };
  @JvmField
  val ord1Tuple = { dictOrd : Any ->
     PS.Data.Ord.Module.Ord1
       .app({ _ : Any ->
            PS.Data.Tuple.Module.eq1Tuple
              .app((dictOrd as Map<String, Any>)["Eq0"]!!.app(Unit))
         })
       .app({ dictOrd1 : Any ->
         PS.Data.Ord.Module.compare
           .app(PS.Data.Tuple.Module.ordTuple.app(dictOrd).app(dictOrd1))
      })
  };
  @JvmField val distributiveTuple = (::__rec_distributiveTuple)();
  fun __rec_distributiveTuple(): Any = { dictTypeEquals : Any ->
     PS.Data.Distributive.Module.Distributive
       .app({ _ : Any ->
            PS.Data.Tuple.Module.functorTuple
         })
       .app({ dictFunctor : Any ->
            PS.Data.Distributive.Module.collectDefault
              .app(PS.Data.Tuple.Module.distributiveTuple.app(dictTypeEquals))
              .app(dictFunctor)
         })
       .app({ dictFunctor : Any ->
         PS.Control.Semigroupoid.Module.compose
           .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
           .app(PS.Data.Tuple.Module.Tuple
                  .app(PS.Type.Equality.Module.from.app(dictTypeEquals)
                         .app(PS.Data.Unit.Module.unit)))
           .app(PS.Data.Functor.Module.map.app(dictFunctor)
                  .app(PS.Data.Tuple.Module.snd))
      })
  };
  @JvmField
  val curry = { f : Any ->
     { a : Any ->
       { b : Any ->
         f.app(PS.Data.Tuple.Module.Tuple.app(a).app(b))
      }
    }
  };
  @JvmField
  val comonadTuple = PS.Control.Comonad.Module.Comonad
                       .app({ _ : Any ->
                            PS.Data.Tuple.Module.extendTuple
                         })
                       .app(PS.Data.Tuple.Module.snd);
  @JvmField
  val commutativeRingTuple = { dictCommutativeRing : Any ->
     { dictCommutativeRing1 : Any ->
       PS.Data.CommutativeRing.Module.CommutativeRing
         .app({ _ : Any ->
           PS.Data.Tuple.Module.ringTuple
             .app((dictCommutativeRing as Map<String, Any>)["Ring0"]!!.app(Unit)
             )
             .app((dictCommutativeRing1 as Map<String, Any>)["Ring0"]!!
                    .app(Unit))
        })
    }
  };
  @JvmField
  val boundedTuple = { dictBounded : Any ->
     { dictBounded1 : Any ->
       PS.Data.Bounded.Module.Bounded
         .app({ _ : Any ->
              PS.Data.Tuple.Module.ordTuple
                .app((dictBounded as Map<String, Any>)["Ord0"]!!.app(Unit))
                .app((dictBounded1 as Map<String, Any>)["Ord0"]!!.app(Unit))
           })
         .app(PS.Data.Tuple.Module.Tuple
                .app(PS.Data.Bounded.Module.bottom.app(dictBounded))
                .app(PS.Data.Bounded.Module.bottom.app(dictBounded1)))
         .app(PS.Data.Tuple.Module.Tuple
                .app(PS.Data.Bounded.Module.top.app(dictBounded))
                .app(PS.Data.Bounded.Module.top.app(dictBounded1)))
    }
  };
  @JvmField
  val booleanAlgebraTuple = { dictBooleanAlgebra : Any ->
     { dictBooleanAlgebra1 : Any ->
       PS.Data.BooleanAlgebra.Module.BooleanAlgebra
         .app({ _ : Any ->
           PS.Data.Tuple.Module.heytingAlgebraTuple
             .app((dictBooleanAlgebra as Map<String, Any>)["HeytingAlgebra0"]!!
                    .app(Unit))
             .app((dictBooleanAlgebra1 as Map<String, Any>)["HeytingAlgebra0"]!!
                    .app(Unit))
        })
    }
  };
  @JvmField
  val bifunctorTuple = PS.Data.Bifunctor.Module.Bifunctor
                         .app({ f : Any ->
       { g : Any ->
         { v : Any ->
           when {
            (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
              val f1 = f;
              val g1 = g;
              val x = v.value0;
              val y = v.value1;
              PS.Data.Tuple.Module.Tuple.app(f1.app(x)).app(g1.app(y));
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      }
    });
  @JvmField
  val bifoldableTuple = PS.Data.Bifoldable.Module.Bifoldable
                          .app({ dictMonoid : Any ->
                               { f : Any ->
                                 { g : Any ->
                                   { v : Any ->
                                     when {
                                      (v is PS.Data.Tuple.Module._Type_Tuple
                                              .Tuple) -> {
                                        val f1 = f;
                                        val g1 = g;
                                        val a = v.value0;
                                        val b = v.value1;
                                        PS.Data.Semigroup.Module.append
                                          .app(
                                            (dictMonoid as Map<String, Any>)["Semigroup0"]!!
                                              .app(Unit))
                                          .app(f1.app(a))
                                          .app(g1.app(b));
                                      }
                                      else -> (error("Error in Pattern Match"
                                      ) as Any)
                                    }
                                  }
                                }
                              }
                            })
                          .app({ f : Any ->
                               { g : Any ->
                                 { z : Any ->
                                   { v : Any ->
                                     when {
                                      (v is PS.Data.Tuple.Module._Type_Tuple
                                              .Tuple) -> {
                                        val f1 = f;
                                        val g1 = g;
                                        val z1 = z;
                                        val a = v.value0;
                                        val b = v.value1;
                                        g1.app(f1.app(z1).app(a)).app(b);
                                      }
                                      else -> (error("Error in Pattern Match"
                                      ) as Any)
                                    }
                                  }
                                }
                              }
                            })
                          .app({ f : Any ->
       { g : Any ->
         { z : Any ->
           { v : Any ->
             when {
              (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                val f1 = f;
                val g1 = g;
                val z1 = z;
                val a = v.value0;
                val b = v.value1;
                f1.app(a).app(g1.app(b).app(z1));
              }
              else -> (error("Error in Pattern Match") as Any)
            }
          }
        }
      }
    });
  @JvmField
  val bitraversableTuple = PS.Data.Bitraversable.Module.Bitraversable
                             .app({ _ : Any ->
                                  PS.Data.Tuple.Module.bifoldableTuple
                               })
                             .app({ _ : Any ->
                                  PS.Data.Tuple.Module.bifunctorTuple
                               })
                             .app({ dictApplicative : Any ->
                                  { v : Any ->
                                    when {
                                     (v is PS.Data.Tuple.Module._Type_Tuple
                                             .Tuple) -> {
                                       val a = v.value0;
                                       val b = v.value1;
                                       PS.Control.Apply.Module.apply
                                         .app(
                                           (dictApplicative as Map<String, Any>)["Apply0"]!!
                                             .app(Unit))
                                         .app(PS.Data.Functor.Module.map
                                                .app(
                                                  ((dictApplicative as Map<String, Any>)["Apply0"]!!
                                                     .app(Unit
                                                    ) as Map<String, Any>)["Functor0"]!!
                                                    .app(Unit))
                                                .app(PS.Data.Tuple.Module.Tuple)
                                                .app(a))
                                         .app(b);
                                     }
                                     else -> (error("Error in Pattern Match"
                                     ) as Any)
                                   }
                                 }
                               })
                             .app({ dictApplicative : Any ->
       { f : Any ->
         { g : Any ->
           { v : Any ->
             when {
              (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                val f1 = f;
                val g1 = g;
                val a = v.value0;
                val b = v.value1;
                PS.Control.Apply.Module.apply
                  .app((dictApplicative as Map<String, Any>)["Apply0"]!!
                         .app(Unit))
                  .app(PS.Data.Functor.Module.map
                         .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                                 .app(Unit) as Map<String, Any>)["Functor0"]!!
                                .app(Unit))
                         .app(PS.Data.Tuple.Module.Tuple)
                         .app(f1.app(a)))
                  .app(g1.app(b));
              }
              else -> (error("Error in Pattern Match") as Any)
            }
          }
        }
      }
    });
  @JvmField
  val biapplyTuple = PS.Control.Biapply.Module.Biapply
                       .app({ _ : Any ->
                            PS.Data.Tuple.Module.bifunctorTuple
                         })
                       .app({ v : Any ->
       { v1 : Any ->
         when {
          (v is PS.Data.Tuple.Module._Type_Tuple
                  .Tuple)&& (v1 is PS.Data.Tuple.Module._Type_Tuple
                                     .Tuple) -> {
            val f = v.value0;
            val g = v.value1;
            val a = v1.value0;
            val b = v1.value1;
            PS.Data.Tuple.Module.Tuple.app(f.app(a)).app(g.app(b));
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val biapplicativeTuple = PS.Control.Biapplicative.Module.Biapplicative
                             .app({ _ : Any ->
                                  PS.Data.Tuple.Module.biapplyTuple
                               })
                             .app(PS.Data.Tuple.Module.Tuple);
  @JvmField
  val applyTuple = { dictSemigroup : Any ->
     PS.Control.Apply.Module.Apply
       .app({ _ : Any ->
            PS.Data.Tuple.Module.functorTuple
         })
       .app({ v : Any ->
         { v1 : Any ->
           when {
            (v is PS.Data.Tuple.Module._Type_Tuple
                    .Tuple)&& (v1 is PS.Data.Tuple.Module._Type_Tuple
                                       .Tuple) -> {
              val a1 = v.value0;
              val f = v.value1;
              val a2 = v1.value0;
              val x = v1.value1;
              PS.Data.Tuple.Module.Tuple
                .app(PS.Data.Semigroup.Module.append.app(dictSemigroup).app(a1)
                       .app(a2))
                .app(f.app(x));
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      })
  };
  @JvmField
  val bindTuple = { dictSemigroup : Any ->
     PS.Control.Bind.Module.Bind
       .app({ _ : Any ->
            PS.Data.Tuple.Module.applyTuple.app(dictSemigroup)
         })
       .app({ v : Any ->
         { f : Any ->
           when {
            (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
              val a1 = v.value0;
              val b = v.value1;
              val f1 = f;
              object   {
                  val v1 = f1.app(b);
                }
                .run({
                  val v1 = this.v1;
                  when {
                    (v1 is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                      val a2 = v1.value0;
                      val c = v1.value1;
                      PS.Data.Tuple.Module.Tuple
                        .app(PS.Data.Semigroup.Module.append.app(dictSemigroup)
                               .app(a1)
                               .app(a2))
                        .app(c);
                    }
                    else -> (error("Error in Pattern Match") as Any)
                  };
                });
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      })
  };
  @JvmField
  val applicativeTuple = { dictMonoid : Any ->
     PS.Control.Applicative.Module.Applicative
       .app({ _ : Any ->
            PS.Data.Tuple.Module.applyTuple
              .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!.app(Unit))
         })
       .app(PS.Data.Tuple.Module.Tuple
              .app(PS.Data.Monoid.Module.mempty.app(dictMonoid)))
  };
  @JvmField
  val monadTuple = { dictMonoid : Any ->
     PS.Control.Monad.Module.Monad
       .app({ _ : Any ->
            PS.Data.Tuple.Module.applicativeTuple.app(dictMonoid)
         })
       .app({ _ : Any ->
         PS.Data.Tuple.Module.bindTuple
           .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!.app(Unit))
      })
  };
}