@file:Suppress("UNCHECKED_CAST")
package PS.Data.Foldable
import Foreign.PsRuntime.app
object Module  {
  val foldrArray = Foreign.Data.Foldable.foldrArray;
  val foldlArray = Foreign.Data.Foldable.foldlArray;
  @JvmField
  val Foldable = { foldMap : Any ->
     { foldl : Any ->
       { foldr : Any ->
         mapOf(("foldMap" to foldMap),  ("foldl" to foldl),  ("foldr" to foldr))
      }
    }
  };
  @JvmField val foldr = { dict : Any -> (dict as Map<String, Any>)["foldr"]!!};
  @JvmField
  val indexr = { dictFoldable : Any ->
     { idx : Any ->
       object   {
           val go = { a : Any ->
              { cursor : Any ->
                when {
                 ((cursor as Map<String, Any>)["elem"]!! is PS.Data.Maybe.Module._Type_Maybe
                                                              .Just) -> {
                   cursor;
                 }
                 else -> {
                   when {
                     (PS.Data.Eq.Module.eq.app(PS.Data.Eq.Module.eqInt)
                        .app((cursor as Map<String, Any>)["pos"]!!)
                        .app(idx) == true) -> {
                       mapOf(("elem" to PS.Data.Maybe.Module.Just.app(a)),  
                         ("pos" to (cursor as Map<String, Any>)["pos"]!!));
                     }
                     else -> {
                       mapOf(("pos" to PS.Data.Semiring.Module.add
                                         .app(
                                           PS.Data.Semiring.Module.semiringInt)
                                         .app(
                                           (cursor as Map<String, Any>)["pos"]!!
                                         )
                                         .app(1)),  
                         ("elem" to (cursor as Map<String, Any>)["elem"]!!));
                     }
                   };
                 }
               }
             }
           };
         }
         .run({
          val go = this.go;
          PS.Control.Semigroupoid.Module.compose
            .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
            .app({ v : Any ->
                 (v as Map<String, Any>)["elem"]!!
              })
            .app(PS.Data.Foldable.Module.foldr.app(dictFoldable).app(go)
                   .app(mapOf(("elem" to PS.Data.Maybe.Module.Nothing),  
                ("pos" to 0))));
        })
    }
  };
  @JvmField
  val _null = { dictFoldable : Any ->
     PS.Data.Foldable.Module.foldr.app(dictFoldable)
       .app({ v : Any ->
            { v1 : Any ->
              false
           }
         })
       .app(true)
  };
  @JvmField
  val oneOf = { dictFoldable : Any ->
     { dictPlus : Any ->
       PS.Data.Foldable.Module.foldr.app(dictFoldable)
         .app(PS.Control.Alt.Module.alt
                .app((dictPlus as Map<String, Any>)["Alt0"]!!.app(Unit)))
         .app(PS.Control.Plus.Module.empty.app(dictPlus))
    }
  };
  @JvmField
  val oneOfMap = { dictFoldable : Any ->
     { dictPlus : Any ->
       { f : Any ->
         PS.Data.Foldable.Module.foldr.app(dictFoldable)
           .app(PS.Control.Semigroupoid.Module.compose
                  .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                  .app(PS.Control.Alt.Module.alt
                         .app((dictPlus as Map<String, Any>)["Alt0"]!!.app(Unit)
                    ))
                  .app(f))
           .app(PS.Control.Plus.Module.empty.app(dictPlus))
      }
    }
  };
  @JvmField
  val traverse_ = { dictApplicative : Any ->
     { dictFoldable : Any ->
       { f : Any ->
         PS.Data.Foldable.Module.foldr.app(dictFoldable)
           .app(PS.Control.Semigroupoid.Module.compose
                  .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                  .app(PS.Control.Apply.Module.applySecond
                         .app((dictApplicative as Map<String, Any>)["Apply0"]!!
                                .app(Unit)))
                  .app(f))
           .app(PS.Control.Applicative.Module.pure.app(dictApplicative)
                  .app(PS.Data.Unit.Module.unit))
      }
    }
  };
  @JvmField
  val for_ = { dictApplicative : Any ->
     { dictFoldable : Any ->
       PS.Data.Function.Module.flip
         .app(PS.Data.Foldable.Module.traverse_.app(dictApplicative)
                .app(dictFoldable))
    }
  };
  @JvmField
  val sequence_ = { dictApplicative : Any ->
     { dictFoldable : Any ->
       PS.Data.Foldable.Module.traverse_.app(dictApplicative).app(dictFoldable)
         .app(PS.Control.Category.Module.identity
                .app(PS.Control.Category.Module.categoryFn))
    }
  };
  @JvmField val foldl = { dict : Any -> (dict as Map<String, Any>)["foldl"]!!};
  @JvmField
  val indexl = { dictFoldable : Any ->
     { idx : Any ->
       object   {
           val go = { cursor : Any ->
              { a : Any ->
                when {
                 ((cursor as Map<String, Any>)["elem"]!! is PS.Data.Maybe.Module._Type_Maybe
                                                              .Just) -> {
                   cursor;
                 }
                 else -> {
                   when {
                     (PS.Data.Eq.Module.eq.app(PS.Data.Eq.Module.eqInt)
                        .app((cursor as Map<String, Any>)["pos"]!!)
                        .app(idx) == true) -> {
                       mapOf(("elem" to PS.Data.Maybe.Module.Just.app(a)),  
                         ("pos" to (cursor as Map<String, Any>)["pos"]!!));
                     }
                     else -> {
                       mapOf(("pos" to PS.Data.Semiring.Module.add
                                         .app(
                                           PS.Data.Semiring.Module.semiringInt)
                                         .app(
                                           (cursor as Map<String, Any>)["pos"]!!
                                         )
                                         .app(1)),  
                         ("elem" to (cursor as Map<String, Any>)["elem"]!!));
                     }
                   };
                 }
               }
             }
           };
         }
         .run({
          val go = this.go;
          PS.Control.Semigroupoid.Module.compose
            .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
            .app({ v : Any ->
                 (v as Map<String, Any>)["elem"]!!
              })
            .app(PS.Data.Foldable.Module.foldl.app(dictFoldable).app(go)
                   .app(mapOf(("elem" to PS.Data.Maybe.Module.Nothing),  
                ("pos" to 0))));
        })
    }
  };
  @JvmField
  val intercalate = { dictFoldable : Any ->
     { dictMonoid : Any ->
       { sep : Any ->
         { xs : Any ->
           object   {
               val go = { v : Any ->
                  { x : Any ->
                    when {
                     ((v as Map<String, Any>)
                        .size == 1)&& (v["init"]!! == true) -> {
                       val x1 = x;
                       mapOf(("init" to false),  ("acc" to x1));
                     }
                     ((v as Map<String, Any>).size == 1) -> {
                       val acc = v["acc"]!!;
                       val x1 = x;
                       mapOf(("init" to false),  
                         ("acc" to PS.Data.Semigroup.Module.append
                                     .app(
                                       (dictMonoid as Map<String, Any>)["Semigroup0"]!!
                                         .app(Unit))
                                     .app(acc)
                                     .app(PS.Data.Semigroup.Module.append
                                            .app(
                                              (dictMonoid as Map<String, Any>)["Semigroup0"]!!
                                                .app(Unit))
                                            .app(sep)
                                            .app(x1))));
                     }
                     else -> (error("Error in Pattern Match") as Any)
                   }
                 }
               };
             }
             .run({
              val go = this.go;
              (PS.Data.Foldable.Module.foldl.app(dictFoldable).app(go)
                 .app(mapOf(("init" to true),  
                     ("acc" to PS.Data.Monoid.Module.mempty.app(dictMonoid))))
                 .app(xs) as Map<String, Any>)["acc"]!!;
            })
        }
      }
    }
  };
  @JvmField
  val length = { dictFoldable : Any ->
     { dictSemiring : Any ->
       PS.Data.Foldable.Module.foldl.app(dictFoldable)
         .app({ c : Any ->
              { v : Any ->
                PS.Data.Semiring.Module.add.app(dictSemiring)
                  .app(PS.Data.Semiring.Module.one.app(dictSemiring))
                  .app(c)
             }
           })
         .app(PS.Data.Semiring.Module.zero.app(dictSemiring))
    }
  };
  @JvmField
  val maximumBy = { dictFoldable : Any ->
     { cmp : Any ->
       object   {
           val max_tick = { v : Any ->
              { v1 : Any ->
                when {
                 (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                   val x = v1;
                   PS.Data.Maybe.Module.Just.app(x);
                 }
                 (v is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
                   val x = v.value0;
                   val y = v1;
                   PS.Data.Maybe.Module.Just
                     .app(when {
                       (PS.Data.Eq.Module.eq
                          .app(PS.Data.Ordering.Module.eqOrdering)
                          .app(cmp.app(x).app(y))
                          .app(PS.Data.Ordering.Module.GT) == true) -> {
                         x;
                       }
                       else -> {
                         y;
                       }
                     });
                 }
                 else -> (error("Error in Pattern Match") as Any)
               }
             }
           };
         }
         .run({
          val max_tick = this.max_tick;
          PS.Data.Foldable.Module.foldl.app(dictFoldable).app(max_tick)
            .app(PS.Data.Maybe.Module.Nothing);
        })
    }
  };
  @JvmField
  val maximum = { dictOrd : Any ->
     { dictFoldable : Any ->
       PS.Data.Foldable.Module.maximumBy.app(dictFoldable)
         .app(PS.Data.Ord.Module.compare.app(dictOrd))
    }
  };
  @JvmField
  val minimumBy = { dictFoldable : Any ->
     { cmp : Any ->
       object   {
           val min_tick = { v : Any ->
              { v1 : Any ->
                when {
                 (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                   val x = v1;
                   PS.Data.Maybe.Module.Just.app(x);
                 }
                 (v is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
                   val x = v.value0;
                   val y = v1;
                   PS.Data.Maybe.Module.Just
                     .app(when {
                       (PS.Data.Eq.Module.eq
                          .app(PS.Data.Ordering.Module.eqOrdering)
                          .app(cmp.app(x).app(y))
                          .app(PS.Data.Ordering.Module.LT) == true) -> {
                         x;
                       }
                       else -> {
                         y;
                       }
                     });
                 }
                 else -> (error("Error in Pattern Match") as Any)
               }
             }
           };
         }
         .run({
          val min_tick = this.min_tick;
          PS.Data.Foldable.Module.foldl.app(dictFoldable).app(min_tick)
            .app(PS.Data.Maybe.Module.Nothing);
        })
    }
  };
  @JvmField
  val minimum = { dictOrd : Any ->
     { dictFoldable : Any ->
       PS.Data.Foldable.Module.minimumBy.app(dictFoldable)
         .app(PS.Data.Ord.Module.compare.app(dictOrd))
    }
  };
  @JvmField
  val product = { dictFoldable : Any ->
     { dictSemiring : Any ->
       PS.Data.Foldable.Module.foldl.app(dictFoldable)
         .app(PS.Data.Semiring.Module.mul.app(dictSemiring))
         .app(PS.Data.Semiring.Module.one.app(dictSemiring))
    }
  };
  @JvmField
  val sum = { dictFoldable : Any ->
     { dictSemiring : Any ->
       PS.Data.Foldable.Module.foldl.app(dictFoldable)
         .app(PS.Data.Semiring.Module.add.app(dictSemiring))
         .app(PS.Data.Semiring.Module.zero.app(dictSemiring))
    }
  };
  @JvmField
  val foldableMultiplicative = PS.Data.Foldable.Module.Foldable
                                 .app({ dictMonoid : Any ->
                                      { f : Any ->
                                        { v : Any ->
                                          when {
                                           else -> {
                                             val f1 = f;
                                             val x = v;
                                             f1.app(x);
                                           }
                                         }
                                       }
                                     }
                                   })
                                 .app({ f : Any ->
                                      { z : Any ->
                                        { v : Any ->
                                          when {
                                           else -> {
                                             val f1 = f;
                                             val z1 = z;
                                             val x = v;
                                             f1.app(z1).app(x);
                                           }
                                         }
                                       }
                                     }
                                   })
                                 .app({ f : Any ->
       { z : Any ->
         { v : Any ->
           when {
            else -> {
              val f1 = f;
              val z1 = z;
              val x = v;
              f1.app(x).app(z1);
            }
          }
        }
      }
    });
  @JvmField
  val foldableMaybe = PS.Data.Foldable.Module.Foldable
                        .app({ dictMonoid : Any ->
                             { f : Any ->
                               { v : Any ->
                                 when {
                                  (v is PS.Data.Maybe.Module._Type_Maybe
                                          .Nothing) -> {
                                    val f1 = f;
                                    PS.Data.Monoid.Module.mempty
                                      .app(dictMonoid);
                                  }
                                  (v is PS.Data.Maybe.Module._Type_Maybe
                                          .Just) -> {
                                    val f1 = f;
                                    val x = v.value0;
                                    f1.app(x);
                                  }
                                  else -> (error("Error in Pattern Match"
                                  ) as Any)
                                }
                              }
                            }
                          })
                        .app({ v : Any ->
                             { z : Any ->
                               { v1 : Any ->
                                 when {
                                  (v1 is PS.Data.Maybe.Module._Type_Maybe
                                           .Nothing) -> {
                                    val z1 = z;
                                    z1;
                                  }
                                  (v1 is PS.Data.Maybe.Module._Type_Maybe
                                           .Just) -> {
                                    val f = v;
                                    val z1 = z;
                                    val x = v1.value0;
                                    f.app(z1).app(x);
                                  }
                                  else -> (error("Error in Pattern Match"
                                  ) as Any)
                                }
                              }
                            }
                          })
                        .app({ v : Any ->
       { z : Any ->
         { v1 : Any ->
           when {
            (v1 is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
              val z1 = z;
              z1;
            }
            (v1 is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
              val f = v;
              val z1 = z;
              val x = v1.value0;
              f.app(x).app(z1);
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      }
    });
  @JvmField
  val foldableDual = PS.Data.Foldable.Module.Foldable
                       .app({ dictMonoid : Any ->
                            { f : Any ->
                              { v : Any ->
                                when {
                                 else -> {
                                   val f1 = f;
                                   val x = v;
                                   f1.app(x);
                                 }
                               }
                             }
                           }
                         })
                       .app({ f : Any ->
                            { z : Any ->
                              { v : Any ->
                                when {
                                 else -> {
                                   val f1 = f;
                                   val z1 = z;
                                   val x = v;
                                   f1.app(z1).app(x);
                                 }
                               }
                             }
                           }
                         })
                       .app({ f : Any ->
       { z : Any ->
         { v : Any ->
           when {
            else -> {
              val f1 = f;
              val z1 = z;
              val x = v;
              f1.app(x).app(z1);
            }
          }
        }
      }
    });
  @JvmField
  val foldableDisj = PS.Data.Foldable.Module.Foldable
                       .app({ dictMonoid : Any ->
                            { f : Any ->
                              { v : Any ->
                                when {
                                 else -> {
                                   val f1 = f;
                                   val x = v;
                                   f1.app(x);
                                 }
                               }
                             }
                           }
                         })
                       .app({ f : Any ->
                            { z : Any ->
                              { v : Any ->
                                when {
                                 else -> {
                                   val f1 = f;
                                   val z1 = z;
                                   val x = v;
                                   f1.app(z1).app(x);
                                 }
                               }
                             }
                           }
                         })
                       .app({ f : Any ->
       { z : Any ->
         { v : Any ->
           when {
            else -> {
              val f1 = f;
              val z1 = z;
              val x = v;
              f1.app(x).app(z1);
            }
          }
        }
      }
    });
  @JvmField
  val foldableConj = PS.Data.Foldable.Module.Foldable
                       .app({ dictMonoid : Any ->
                            { f : Any ->
                              { v : Any ->
                                when {
                                 else -> {
                                   val f1 = f;
                                   val x = v;
                                   f1.app(x);
                                 }
                               }
                             }
                           }
                         })
                       .app({ f : Any ->
                            { z : Any ->
                              { v : Any ->
                                when {
                                 else -> {
                                   val f1 = f;
                                   val z1 = z;
                                   val x = v;
                                   f1.app(z1).app(x);
                                 }
                               }
                             }
                           }
                         })
                       .app({ f : Any ->
       { z : Any ->
         { v : Any ->
           when {
            else -> {
              val f1 = f;
              val z1 = z;
              val x = v;
              f1.app(x).app(z1);
            }
          }
        }
      }
    });
  @JvmField
  val foldableAdditive = PS.Data.Foldable.Module.Foldable
                           .app({ dictMonoid : Any ->
                                { f : Any ->
                                  { v : Any ->
                                    when {
                                     else -> {
                                       val f1 = f;
                                       val x = v;
                                       f1.app(x);
                                     }
                                   }
                                 }
                               }
                             })
                           .app({ f : Any ->
                                { z : Any ->
                                  { v : Any ->
                                    when {
                                     else -> {
                                       val f1 = f;
                                       val z1 = z;
                                       val x = v;
                                       f1.app(z1).app(x);
                                     }
                                   }
                                 }
                               }
                             })
                           .app({ f : Any ->
       { z : Any ->
         { v : Any ->
           when {
            else -> {
              val f1 = f;
              val z1 = z;
              val x = v;
              f1.app(x).app(z1);
            }
          }
        }
      }
    });
  @JvmField
  val foldMapDefaultR = { dictFoldable : Any ->
     { dictMonoid : Any ->
       { f : Any ->
         PS.Data.Foldable.Module.foldr.app(dictFoldable)
           .app({ x : Any ->
                { acc : Any ->
                  PS.Data.Semigroup.Module.append
                    .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!
                           .app(Unit))
                    .app(f.app(x))
                    .app(acc)
               }
             })
           .app(PS.Data.Monoid.Module.mempty.app(dictMonoid))
      }
    }
  };
  @JvmField val foldableArray = (::__rec_foldableArray)();
  fun __rec_foldableArray(): Any = PS.Data.Foldable.Module.Foldable
                                     .app({ dictMonoid : Any ->
                                          PS.Data.Foldable.Module.foldMapDefaultR
                                            .app(
                                              PS.Data.Foldable.Module.foldableArray
                                            )
                                            .app(dictMonoid)
                                       })
                                     .app(PS.Data.Foldable.Module.foldlArray)
                                     .app(PS.Data.Foldable.Module.foldrArray);
  @JvmField
  val foldMapDefaultL = { dictFoldable : Any ->
     { dictMonoid : Any ->
       { f : Any ->
         PS.Data.Foldable.Module.foldl.app(dictFoldable)
           .app({ acc : Any ->
                { x : Any ->
                  PS.Data.Semigroup.Module.append
                    .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!
                           .app(Unit))
                    .app(acc)
                    .app(f.app(x))
               }
             })
           .app(PS.Data.Monoid.Module.mempty.app(dictMonoid))
      }
    }
  };
  @JvmField
  val foldMap = { dict : Any ->
     (dict as Map<String, Any>)["foldMap"]!!
  };
  @JvmField
  val foldableFirst = PS.Data.Foldable.Module.Foldable
                        .app({ dictMonoid : Any ->
                             { f : Any ->
                               { v : Any ->
                                 when {
                                  else -> {
                                    val f1 = f;
                                    val x = v;
                                    PS.Data.Foldable.Module.foldMap
                                      .app(PS.Data.Foldable.Module.foldableMaybe
                                      )
                                      .app(dictMonoid)
                                      .app(f1)
                                      .app(x);
                                  }
                                }
                              }
                            }
                          })
                        .app({ f : Any ->
                             { z : Any ->
                               { v : Any ->
                                 when {
                                  else -> {
                                    val f1 = f;
                                    val z1 = z;
                                    val x = v;
                                    PS.Data.Foldable.Module.foldl
                                      .app(PS.Data.Foldable.Module.foldableMaybe
                                      )
                                      .app(f1)
                                      .app(z1)
                                      .app(x);
                                  }
                                }
                              }
                            }
                          })
                        .app({ f : Any ->
       { z : Any ->
         { v : Any ->
           when {
            else -> {
              val f1 = f;
              val z1 = z;
              val x = v;
              PS.Data.Foldable.Module.foldr
                .app(PS.Data.Foldable.Module.foldableMaybe)
                .app(f1)
                .app(z1)
                .app(x);
            }
          }
        }
      }
    });
  @JvmField
  val foldableLast = PS.Data.Foldable.Module.Foldable
                       .app({ dictMonoid : Any ->
                            { f : Any ->
                              { v : Any ->
                                when {
                                 else -> {
                                   val f1 = f;
                                   val x = v;
                                   PS.Data.Foldable.Module.foldMap
                                     .app(PS.Data.Foldable.Module.foldableMaybe)
                                     .app(dictMonoid)
                                     .app(f1)
                                     .app(x);
                                 }
                               }
                             }
                           }
                         })
                       .app({ f : Any ->
                            { z : Any ->
                              { v : Any ->
                                when {
                                 else -> {
                                   val f1 = f;
                                   val z1 = z;
                                   val x = v;
                                   PS.Data.Foldable.Module.foldl
                                     .app(PS.Data.Foldable.Module.foldableMaybe)
                                     .app(f1)
                                     .app(z1)
                                     .app(x);
                                 }
                               }
                             }
                           }
                         })
                       .app({ f : Any ->
       { z : Any ->
         { v : Any ->
           when {
            else -> {
              val f1 = f;
              val z1 = z;
              val x = v;
              PS.Data.Foldable.Module.foldr
                .app(PS.Data.Foldable.Module.foldableMaybe)
                .app(f1)
                .app(z1)
                .app(x);
            }
          }
        }
      }
    });
  @JvmField
  val foldlDefault = { dictFoldable : Any ->
     { c : Any ->
       { u : Any ->
         { xs : Any ->
           PS.Data.Newtype.Module.unwrap.app(PS.Data.Newtype.Module.newtypeEndo)
             .app(PS.Data.Newtype.Module.unwrap
                    .app(PS.Data.Newtype.Module.newtypeDual)
                    .app(PS.Data.Foldable.Module.foldMap.app(dictFoldable)
                           .app(PS.Data.Monoid.Dual.Module.monoidDual
                                  .app(PS.Data.Monoid.Endo.Module.monoidEndo
                                         .app(
                                 PS.Control.Category.Module.categoryFn)))
                           .app(PS.Control.Semigroupoid.Module.compose
                                  .app(
                                    PS.Control.Semigroupoid.Module.semigroupoidFn
                                  )
                                  .app(PS.Data.Monoid.Dual.Module.Dual)
                                  .app(PS.Control.Semigroupoid.Module.compose
                                         .app(
                                           PS.Control.Semigroupoid.Module.semigroupoidFn
                                         )
                                         .app(PS.Data.Monoid.Endo.Module.Endo)
                                         .app(PS.Data.Function.Module.flip
                                                .app(c))))
                           .app(xs)))
             .app(u)
        }
      }
    }
  };
  @JvmField
  val foldrDefault = { dictFoldable : Any ->
     { c : Any ->
       { u : Any ->
         { xs : Any ->
           PS.Data.Newtype.Module.unwrap.app(PS.Data.Newtype.Module.newtypeEndo)
             .app(PS.Data.Foldable.Module.foldMap.app(dictFoldable)
                    .app(PS.Data.Monoid.Endo.Module.monoidEndo
                           .app(PS.Control.Category.Module.categoryFn))
                    .app(PS.Control.Semigroupoid.Module.compose
                           .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                           .app(PS.Data.Monoid.Endo.Module.Endo)
                           .app(c))
                    .app(xs))
             .app(u)
        }
      }
    }
  };
  @JvmField
  val surroundMap = { dictFoldable : Any ->
     { dictSemigroup : Any ->
       { d : Any ->
         { t : Any ->
           { f : Any ->
             object   {
                 val joined = { a : Any ->
                    PS.Data.Monoid.Endo.Module.Endo
                      .app({ m : Any ->
                        PS.Data.Semigroup.Module.append.app(dictSemigroup)
                          .app(d)
                          .app(PS.Data.Semigroup.Module.append
                                 .app(dictSemigroup)
                                 .app(t.app(a))
                                 .app(m))
                     })
                 };
               }
               .run({
                val joined = this.joined;
                PS.Data.Newtype.Module.unwrap
                  .app(PS.Data.Newtype.Module.newtypeEndo)
                  .app(PS.Data.Foldable.Module.foldMap.app(dictFoldable)
                         .app(PS.Data.Monoid.Endo.Module.monoidEndo
                                .app(PS.Control.Category.Module.categoryFn))
                         .app(joined)
                         .app(f))
                  .app(d);
              })
          }
        }
      }
    }
  };
  @JvmField
  val surround = { dictFoldable : Any ->
     { dictSemigroup : Any ->
       { d : Any ->
         PS.Data.Foldable.Module.surroundMap.app(dictFoldable)
           .app(dictSemigroup)
           .app(d)
           .app(PS.Control.Category.Module.identity
                  .app(PS.Control.Category.Module.categoryFn))
      }
    }
  };
  @JvmField
  val foldM = { dictFoldable : Any ->
     { dictMonad : Any ->
       { f : Any ->
         { a0 : Any ->
           PS.Data.Foldable.Module.foldl.app(dictFoldable)
             .app({ ma : Any ->
                  { b : Any ->
                    PS.Control.Bind.Module.bind
                      .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
                      .app(ma)
                      .app(PS.Data.Function.Module.flip.app(f).app(b))
                 }
               })
             .app(PS.Control.Applicative.Module.pure
                    .app((dictMonad as Map<String, Any>)["Applicative0"]!!
                           .app(Unit))
                    .app(a0))
        }
      }
    }
  };
  @JvmField
  val fold = { dictFoldable : Any ->
     { dictMonoid : Any ->
       PS.Data.Foldable.Module.foldMap.app(dictFoldable).app(dictMonoid)
         .app(PS.Control.Category.Module.identity
                .app(PS.Control.Category.Module.categoryFn))
    }
  };
  @JvmField
  val findMap = { dictFoldable : Any ->
     { p : Any ->
       object   {
           val go = { v : Any ->
              { v1 : Any ->
                when {
                 (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                   val x = v1;
                   p.app(x);
                 }
                 else -> {
                   val r = v;
                   r;
                 }
               }
             }
           };
         }
         .run({
          val go = this.go;
          PS.Data.Foldable.Module.foldl.app(dictFoldable).app(go)
            .app(PS.Data.Maybe.Module.Nothing);
        })
    }
  };
  @JvmField
  val find = { dictFoldable : Any ->
     { p : Any ->
       object   {
           val go = { v : Any ->
              { v1 : Any ->
                when {
                 (v is PS.Data.Maybe.Module._Type_Maybe
                         .Nothing)&& (p.app(v1) as Boolean) -> {
                   val x = v1;
                   PS.Data.Maybe.Module.Just.app(x);
                 }
                 else -> {
                   val r = v;
                   r;
                 }
               }
             }
           };
         }
         .run({
          val go = this.go;
          PS.Data.Foldable.Module.foldl.app(dictFoldable).app(go)
            .app(PS.Data.Maybe.Module.Nothing);
        })
    }
  };
  @JvmField
  val any = { dictFoldable : Any ->
     { dictHeytingAlgebra : Any ->
       PS.Data.Newtype.Module.alaF.app(PS.Data.Functor.Module.functorFn)
         .app(PS.Data.Functor.Module.functorFn)
         .app(PS.Data.Newtype.Module.newtypeDisj)
         .app(PS.Data.Newtype.Module.newtypeDisj)
         .app(PS.Data.Monoid.Disj.Module.Disj)
         .app(PS.Data.Foldable.Module.foldMap.app(dictFoldable)
                .app(PS.Data.Monoid.Disj.Module.monoidDisj
                       .app(dictHeytingAlgebra)))
    }
  };
  @JvmField
  val elem = { dictFoldable : Any ->
     { dictEq : Any ->
       PS.Control.Semigroupoid.Module.compose
         .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
         .app(PS.Data.Foldable.Module.any.app(dictFoldable)
                .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean))
         .app(PS.Data.Eq.Module.eq.app(dictEq))
    }
  };
  @JvmField
  val notElem = { dictFoldable : Any ->
     { dictEq : Any ->
       { x : Any ->
         PS.Control.Semigroupoid.Module.compose
           .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
           .app(PS.Data.HeytingAlgebra.Module.not
                  .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean))
           .app(PS.Data.Foldable.Module.elem.app(dictFoldable).app(dictEq)
                  .app(x))
      }
    }
  };
  @JvmField
  val or = { dictFoldable : Any ->
     { dictHeytingAlgebra : Any ->
       PS.Data.Foldable.Module.any.app(dictFoldable).app(dictHeytingAlgebra)
         .app(PS.Control.Category.Module.identity
                .app(PS.Control.Category.Module.categoryFn))
    }
  };
  @JvmField
  val all = { dictFoldable : Any ->
     { dictHeytingAlgebra : Any ->
       PS.Data.Newtype.Module.alaF.app(PS.Data.Functor.Module.functorFn)
         .app(PS.Data.Functor.Module.functorFn)
         .app(PS.Data.Newtype.Module.newtypeConj)
         .app(PS.Data.Newtype.Module.newtypeConj)
         .app(PS.Data.Monoid.Conj.Module.Conj)
         .app(PS.Data.Foldable.Module.foldMap.app(dictFoldable)
                .app(PS.Data.Monoid.Conj.Module.monoidConj
                       .app(dictHeytingAlgebra)))
    }
  };
  @JvmField
  val and = { dictFoldable : Any ->
     { dictHeytingAlgebra : Any ->
       PS.Data.Foldable.Module.all.app(dictFoldable).app(dictHeytingAlgebra)
         .app(PS.Control.Category.Module.identity
                .app(PS.Control.Category.Module.categoryFn))
    }
  };
}