@file:Suppress("UNCHECKED_CAST")
package PS.Data.FoldableWithIndex
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
  val FoldableWithIndex = { Foldable0 : Any ->
     { foldMapWithIndex : Any ->
       { foldlWithIndex : Any ->
         { foldrWithIndex : Any ->
           mapOf(("Foldable0" to Foldable0),  
            ("foldMapWithIndex" to foldMapWithIndex),  
            ("foldlWithIndex" to foldlWithIndex),  
            ("foldrWithIndex" to foldrWithIndex))
        }
      }
    }
  };
  @JvmField
  val foldrWithIndex = { dict : Any ->
     (dict as Map<String, Any>)["foldrWithIndex"]!!
  };
  @JvmField
  val traverseWithIndex_ = { dictApplicative : Any ->
     { dictFoldableWithIndex : Any ->
       { f : Any ->
         PS.Data.FoldableWithIndex.Module.foldrWithIndex
           .app(dictFoldableWithIndex)
           .app({ i : Any ->
                PS.Control.Semigroupoid.Module.compose
                  .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                  .app(PS.Control.Apply.Module.applySecond
                         .app((dictApplicative as Map<String, Any>)["Apply0"]!!
                                .app(Unit)))
                  .app(f.app(i))
             })
           .app(PS.Control.Applicative.Module.pure.app(dictApplicative)
                  .app(PS.Data.Unit.Module.unit))
      }
    }
  };
  @JvmField
  val forWithIndex_ = { dictApplicative : Any ->
     { dictFoldableWithIndex : Any ->
       PS.Data.Function.Module.flip
         .app(PS.Data.FoldableWithIndex.Module.traverseWithIndex_
                .app(dictApplicative)
                .app(dictFoldableWithIndex))
    }
  };
  @JvmField
  val foldrDefault = { dictFoldableWithIndex : Any ->
     { f : Any ->
       PS.Data.FoldableWithIndex.Module.foldrWithIndex
         .app(dictFoldableWithIndex)
         .app(PS.Data.Function.Module._const.app(f))
    }
  };
  @JvmField
  val foldlWithIndex = { dict : Any ->
     (dict as Map<String, Any>)["foldlWithIndex"]!!
  };
  @JvmField
  val foldlDefault = { dictFoldableWithIndex : Any ->
     { f : Any ->
       PS.Data.FoldableWithIndex.Module.foldlWithIndex
         .app(dictFoldableWithIndex)
         .app(PS.Data.Function.Module._const.app(f))
    }
  };
  @JvmField
  val foldableWithIndexMultiplicative = PS.Data.FoldableWithIndex.Module.FoldableWithIndex
                                          .app({ _ : Any ->
                                               PS.Data.Foldable.Module.foldableMultiplicative
                                            })
                                          .app({ dictMonoid : Any ->
                                               { f : Any ->
                                                 PS.Data.Function.Module.apply
                                                   .app(
                                                     PS.Data.Foldable.Module.foldMap
                                                       .app(
                                                         PS.Data.Foldable.Module.foldableMultiplicative
                                                       )
                                                       .app(dictMonoid))
                                                   .app(f
                                                          .app(
                                                    PS.Data.Unit.Module.unit))
                                              }
                                            })
                                          .app({ f : Any ->
                                               PS.Data.Function.Module.apply
                                                 .app(
                                                   PS.Data.Foldable.Module.foldl
                                                     .app(
                                                     PS.Data.Foldable.Module.foldableMultiplicative
                                                   ))
                                                 .app(f
                                                        .app(
                                                  PS.Data.Unit.Module.unit))
                                            })
                                          .app({ f : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Foldable.Module.foldr
                .app(PS.Data.Foldable.Module.foldableMultiplicative))
         .app(f.app(PS.Data.Unit.Module.unit))
    });
  @JvmField
  val foldableWithIndexMaybe = PS.Data.FoldableWithIndex.Module.FoldableWithIndex
                                 .app({ _ : Any ->
                                      PS.Data.Foldable.Module.foldableMaybe
                                   })
                                 .app({ dictMonoid : Any ->
                                      { f : Any ->
                                        PS.Data.Function.Module.apply
                                          .app(PS.Data.Foldable.Module.foldMap
                                                 .app(
                                                   PS.Data.Foldable.Module.foldableMaybe
                                                 )
                                                 .app(dictMonoid))
                                          .app(f.app(PS.Data.Unit.Module.unit))
                                     }
                                   })
                                 .app({ f : Any ->
                                      PS.Data.Function.Module.apply
                                        .app(PS.Data.Foldable.Module.foldl
                                               .app(
                                            PS.Data.Foldable.Module.foldableMaybe
                                          ))
                                        .app(f.app(PS.Data.Unit.Module.unit))
                                   })
                                 .app({ f : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Foldable.Module.foldr
                .app(PS.Data.Foldable.Module.foldableMaybe))
         .app(f.app(PS.Data.Unit.Module.unit))
    });
  @JvmField
  val foldableWithIndexLast = PS.Data.FoldableWithIndex.Module.FoldableWithIndex
                                .app({ _ : Any ->
                                     PS.Data.Foldable.Module.foldableLast
                                  })
                                .app({ dictMonoid : Any ->
                                     { f : Any ->
                                       PS.Data.Function.Module.apply
                                         .app(PS.Data.Foldable.Module.foldMap
                                                .app(
                                                  PS.Data.Foldable.Module.foldableLast
                                                )
                                                .app(dictMonoid))
                                         .app(f.app(PS.Data.Unit.Module.unit))
                                    }
                                  })
                                .app({ f : Any ->
                                     PS.Data.Function.Module.apply
                                       .app(PS.Data.Foldable.Module.foldl
                                              .app(
                                           PS.Data.Foldable.Module.foldableLast)
                                       )
                                       .app(f.app(PS.Data.Unit.Module.unit))
                                  })
                                .app({ f : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Foldable.Module.foldr
                .app(PS.Data.Foldable.Module.foldableLast))
         .app(f.app(PS.Data.Unit.Module.unit))
    });
  @JvmField
  val foldableWithIndexFirst = PS.Data.FoldableWithIndex.Module.FoldableWithIndex
                                 .app({ _ : Any ->
                                      PS.Data.Foldable.Module.foldableFirst
                                   })
                                 .app({ dictMonoid : Any ->
                                      { f : Any ->
                                        PS.Data.Function.Module.apply
                                          .app(PS.Data.Foldable.Module.foldMap
                                                 .app(
                                                   PS.Data.Foldable.Module.foldableFirst
                                                 )
                                                 .app(dictMonoid))
                                          .app(f.app(PS.Data.Unit.Module.unit))
                                     }
                                   })
                                 .app({ f : Any ->
                                      PS.Data.Function.Module.apply
                                        .app(PS.Data.Foldable.Module.foldl
                                               .app(
                                            PS.Data.Foldable.Module.foldableFirst
                                          ))
                                        .app(f.app(PS.Data.Unit.Module.unit))
                                   })
                                 .app({ f : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Foldable.Module.foldr
                .app(PS.Data.Foldable.Module.foldableFirst))
         .app(f.app(PS.Data.Unit.Module.unit))
    });
  @JvmField
  val foldableWithIndexDual = PS.Data.FoldableWithIndex.Module.FoldableWithIndex
                                .app({ _ : Any ->
                                     PS.Data.Foldable.Module.foldableDual
                                  })
                                .app({ dictMonoid : Any ->
                                     { f : Any ->
                                       PS.Data.Function.Module.apply
                                         .app(PS.Data.Foldable.Module.foldMap
                                                .app(
                                                  PS.Data.Foldable.Module.foldableDual
                                                )
                                                .app(dictMonoid))
                                         .app(f.app(PS.Data.Unit.Module.unit))
                                    }
                                  })
                                .app({ f : Any ->
                                     PS.Data.Function.Module.apply
                                       .app(PS.Data.Foldable.Module.foldl
                                              .app(
                                           PS.Data.Foldable.Module.foldableDual)
                                       )
                                       .app(f.app(PS.Data.Unit.Module.unit))
                                  })
                                .app({ f : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Foldable.Module.foldr
                .app(PS.Data.Foldable.Module.foldableDual))
         .app(f.app(PS.Data.Unit.Module.unit))
    });
  @JvmField
  val foldableWithIndexDisj = PS.Data.FoldableWithIndex.Module.FoldableWithIndex
                                .app({ _ : Any ->
                                     PS.Data.Foldable.Module.foldableDisj
                                  })
                                .app({ dictMonoid : Any ->
                                     { f : Any ->
                                       PS.Data.Function.Module.apply
                                         .app(PS.Data.Foldable.Module.foldMap
                                                .app(
                                                  PS.Data.Foldable.Module.foldableDisj
                                                )
                                                .app(dictMonoid))
                                         .app(f.app(PS.Data.Unit.Module.unit))
                                    }
                                  })
                                .app({ f : Any ->
                                     PS.Data.Function.Module.apply
                                       .app(PS.Data.Foldable.Module.foldl
                                              .app(
                                           PS.Data.Foldable.Module.foldableDisj)
                                       )
                                       .app(f.app(PS.Data.Unit.Module.unit))
                                  })
                                .app({ f : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Foldable.Module.foldr
                .app(PS.Data.Foldable.Module.foldableDisj))
         .app(f.app(PS.Data.Unit.Module.unit))
    });
  @JvmField
  val foldableWithIndexConj = PS.Data.FoldableWithIndex.Module.FoldableWithIndex
                                .app({ _ : Any ->
                                     PS.Data.Foldable.Module.foldableConj
                                  })
                                .app({ dictMonoid : Any ->
                                     { f : Any ->
                                       PS.Data.Function.Module.apply
                                         .app(PS.Data.Foldable.Module.foldMap
                                                .app(
                                                  PS.Data.Foldable.Module.foldableConj
                                                )
                                                .app(dictMonoid))
                                         .app(f.app(PS.Data.Unit.Module.unit))
                                    }
                                  })
                                .app({ f : Any ->
                                     PS.Data.Function.Module.apply
                                       .app(PS.Data.Foldable.Module.foldl
                                              .app(
                                           PS.Data.Foldable.Module.foldableConj)
                                       )
                                       .app(f.app(PS.Data.Unit.Module.unit))
                                  })
                                .app({ f : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Foldable.Module.foldr
                .app(PS.Data.Foldable.Module.foldableConj))
         .app(f.app(PS.Data.Unit.Module.unit))
    });
  @JvmField
  val foldableWithIndexAdditive = PS.Data.FoldableWithIndex.Module.FoldableWithIndex
                                    .app({ _ : Any ->
                                         PS.Data.Foldable.Module.foldableAdditive
                                      })
                                    .app({ dictMonoid : Any ->
                                         { f : Any ->
                                           PS.Data.Function.Module.apply
                                             .app(
                                               PS.Data.Foldable.Module.foldMap
                                                 .app(
                                                   PS.Data.Foldable.Module.foldableAdditive
                                                 )
                                                 .app(dictMonoid))
                                             .app(f
                                                    .app(
                                              PS.Data.Unit.Module.unit))
                                        }
                                      })
                                    .app({ f : Any ->
                                         PS.Data.Function.Module.apply
                                           .app(PS.Data.Foldable.Module.foldl
                                                  .app(
                                               PS.Data.Foldable.Module.foldableAdditive
                                             ))
                                           .app(f.app(PS.Data.Unit.Module.unit))
                                      })
                                    .app({ f : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Foldable.Module.foldr
                .app(PS.Data.Foldable.Module.foldableAdditive))
         .app(f.app(PS.Data.Unit.Module.unit))
    });
  @JvmField
  val foldWithIndexM = { dictFoldableWithIndex : Any ->
     { dictMonad : Any ->
       { f : Any ->
         { a0 : Any ->
           PS.Data.FoldableWithIndex.Module.foldlWithIndex
             .app(dictFoldableWithIndex)
             .app({ i : Any ->
                  { ma : Any ->
                    { b : Any ->
                      PS.Control.Bind.Module.bind
                        .app((dictMonad as Map<String, Any>)["Bind1"]!!
                               .app(Unit))
                        .app(ma)
                        .app(PS.Data.Function.Module.flip.app(f.app(i)).app(b))
                   }
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
  val foldMapWithIndexDefaultR = { dictFoldableWithIndex : Any ->
     { dictMonoid : Any ->
       { f : Any ->
         PS.Data.FoldableWithIndex.Module.foldrWithIndex
           .app(dictFoldableWithIndex)
           .app({ i : Any ->
                { x : Any ->
                  { acc : Any ->
                    PS.Data.Semigroup.Module.append
                      .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!
                             .app(Unit))
                      .app(f.app(i).app(x))
                      .app(acc)
                 }
               }
             })
           .app(PS.Data.Monoid.Module.mempty.app(dictMonoid))
      }
    }
  };
  @JvmField val foldableWithIndexArray = (::__rec_foldableWithIndexArray)();
  fun __rec_foldableWithIndexArray(): Any = PS.Data.FoldableWithIndex.Module.FoldableWithIndex
                                              .app({ _ : Any ->
                                                   PS.Data.Foldable.Module.foldableArray
                                                })
                                              .app({ dictMonoid : Any ->
                                                   PS.Data.FoldableWithIndex.Module.foldMapWithIndexDefaultR
                                                     .app(
                                                       PS.Data.FoldableWithIndex.Module.foldableWithIndexArray
                                                     )
                                                     .app(dictMonoid)
                                                })
                                              .app({ f : Any ->
                                                   { z : Any ->
                                                     PS.Control.Semigroupoid.Module.compose
                                                       .app(
                                                         PS.Control.Semigroupoid.Module.semigroupoidFn
                                                       )
                                                       .app(
                                                         PS.Data.Foldable.Module.foldl
                                                           .app(
                                                             PS.Data.Foldable.Module.foldableArray
                                                           )
                                                           .app({ y : Any ->
                                                                { v : Any ->
                                                                  when {
                                                                   (v is PS.Data.FoldableWithIndex.Module._Type_Tuple
                                                                           .Tuple) -> {
                                                                     val i = v
                                                                               .value0;
                                                                     val x = v
                                                                               .value1;
                                                                     f.app(i)
                                                                       .app(y)
                                                                       .app(x);
                                                                   }
                                                                   else -> (error(
                                                                     "Error in Pattern Match"
                                                                   ) as Any)
                                                                 }
                                                               }
                                                             })
                                                           .app(z))
                                                       .app(
                                                      PS.Data.FunctorWithIndex.Module.mapWithIndex
                                                        .app(
                                                          PS.Data.FunctorWithIndex.Module.functorWithIndexArray
                                                        )
                                                        .app(
                                                        PS.Data.FoldableWithIndex.Module.Tuple
                                                      ))
                                                  }
                                                })
                                              .app({ f : Any ->
       { z : Any ->
         PS.Control.Semigroupoid.Module.compose
           .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
           .app(PS.Data.Foldable.Module.foldr
                  .app(PS.Data.Foldable.Module.foldableArray)
                  .app({ v : Any ->
                       when {
                        (v is PS.Data.FoldableWithIndex.Module._Type_Tuple
                                .Tuple) -> {
                          val i = v.value0;
                          val x = v.value1;
                          { y : Any -> f.app(i).app(x).app(y)};
                        }
                        else -> (error("Error in Pattern Match") as Any)
                      }
                    })
                  .app(z))
           .app(PS.Data.FunctorWithIndex.Module.mapWithIndex
                  .app(PS.Data.FunctorWithIndex.Module.functorWithIndexArray)
                  .app(PS.Data.FoldableWithIndex.Module.Tuple))
      }
    });
  @JvmField
  val foldMapWithIndexDefaultL = { dictFoldableWithIndex : Any ->
     { dictMonoid : Any ->
       { f : Any ->
         PS.Data.FoldableWithIndex.Module.foldlWithIndex
           .app(dictFoldableWithIndex)
           .app({ i : Any ->
                { acc : Any ->
                  { x : Any ->
                    PS.Data.Semigroup.Module.append
                      .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!
                             .app(Unit))
                      .app(acc)
                      .app(f.app(i).app(x))
                 }
               }
             })
           .app(PS.Data.Monoid.Module.mempty.app(dictMonoid))
      }
    }
  };
  @JvmField
  val foldMapWithIndex = { dict : Any ->
     (dict as Map<String, Any>)["foldMapWithIndex"]!!
  };
  @JvmField
  val foldlWithIndexDefault = { dictFoldableWithIndex : Any ->
     { c : Any ->
       { u : Any ->
         { xs : Any ->
           PS.Data.Newtype.Module.unwrap.app(PS.Data.Newtype.Module.newtypeEndo)
             .app(PS.Data.Newtype.Module.unwrap
                    .app(PS.Data.Newtype.Module.newtypeDual)
                    .app(PS.Data.FoldableWithIndex.Module.foldMapWithIndex
                           .app(dictFoldableWithIndex)
                           .app(PS.Data.Monoid.Dual.Module.monoidDual
                                  .app(PS.Data.Monoid.Endo.Module.monoidEndo
                                         .app(
                                 PS.Control.Category.Module.categoryFn)))
                           .app({ i : Any ->
                                PS.Control.Semigroupoid.Module.compose
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
                                                .app(c.app(i))))
                             })
                           .app(xs)))
             .app(u)
        }
      }
    }
  };
  @JvmField
  val foldrWithIndexDefault = { dictFoldableWithIndex : Any ->
     { c : Any ->
       { u : Any ->
         { xs : Any ->
           PS.Data.Newtype.Module.unwrap.app(PS.Data.Newtype.Module.newtypeEndo)
             .app(PS.Data.FoldableWithIndex.Module.foldMapWithIndex
                    .app(dictFoldableWithIndex)
                    .app(PS.Data.Monoid.Endo.Module.monoidEndo
                           .app(PS.Control.Category.Module.categoryFn))
                    .app({ i : Any ->
                         PS.Control.Semigroupoid.Module.compose
                           .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                           .app(PS.Data.Monoid.Endo.Module.Endo)
                           .app(c.app(i))
                      })
                    .app(xs))
             .app(u)
        }
      }
    }
  };
  @JvmField
  val surroundMapWithIndex = { dictFoldableWithIndex : Any ->
     { dictSemigroup : Any ->
       { d : Any ->
         { t : Any ->
           { f : Any ->
             object   {
                 val joined = { i : Any ->
                    { a : Any ->
                      PS.Data.Monoid.Endo.Module.Endo
                        .app({ m : Any ->
                          PS.Data.Semigroup.Module.append.app(dictSemigroup)
                            .app(d)
                            .app(PS.Data.Semigroup.Module.append
                                   .app(dictSemigroup)
                                   .app(t.app(i).app(a))
                                   .app(m))
                       })
                   }
                 };
               }
               .run({
                val joined = this.joined;
                PS.Data.Newtype.Module.unwrap
                  .app(PS.Data.Newtype.Module.newtypeEndo)
                  .app(PS.Data.FoldableWithIndex.Module.foldMapWithIndex
                         .app(dictFoldableWithIndex)
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
  val foldMapDefault = { dictFoldableWithIndex : Any ->
     { dictMonoid : Any ->
       { f : Any ->
         PS.Data.FoldableWithIndex.Module.foldMapWithIndex
           .app(dictFoldableWithIndex)
           .app(dictMonoid)
           .app(PS.Data.Function.Module._const.app(f))
      }
    }
  };
  @JvmField
  val findWithIndex = { dictFoldableWithIndex : Any ->
     { p : Any ->
       object   {
           val go = { v : Any ->
              { v1 : Any ->
                { v2 : Any ->
                  when {
                   (v1 is PS.Data.Maybe.Module._Type_Maybe
                            .Nothing)&& (p.app(v).app(v2) as Boolean) -> {
                     val i = v;
                     val x = v2;
                     PS.Data.Maybe.Module.Just
                       .app(mapOf(("index" to i),  ("value" to x)));
                   }
                   else -> {
                     val r = v1;
                     r;
                   }
                 }
               }
             }
           };
         }
         .run({
          val go = this.go;
          PS.Data.FoldableWithIndex.Module.foldlWithIndex
            .app(dictFoldableWithIndex)
            .app(go)
            .app(PS.Data.Maybe.Module.Nothing);
        })
    }
  };
  @JvmField
  val anyWithIndex = { dictFoldableWithIndex : Any ->
     { dictHeytingAlgebra : Any ->
       { t : Any ->
         PS.Control.Semigroupoid.Module.compose
           .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
           .app(PS.Data.Newtype.Module.unwrap
                  .app(PS.Data.Newtype.Module.newtypeDisj))
           .app(PS.Data.FoldableWithIndex.Module.foldMapWithIndex
                  .app(dictFoldableWithIndex)
                  .app(PS.Data.Monoid.Disj.Module.monoidDisj
                         .app(dictHeytingAlgebra))
                  .app({ i : Any ->
               PS.Control.Semigroupoid.Module.compose
                 .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                 .app(PS.Data.Monoid.Disj.Module.Disj)
                 .app(t.app(i))
            }))
      }
    }
  };
  @JvmField
  val allWithIndex = { dictFoldableWithIndex : Any ->
     { dictHeytingAlgebra : Any ->
       { t : Any ->
         PS.Control.Semigroupoid.Module.compose
           .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
           .app(PS.Data.Newtype.Module.unwrap
                  .app(PS.Data.Newtype.Module.newtypeConj))
           .app(PS.Data.FoldableWithIndex.Module.foldMapWithIndex
                  .app(dictFoldableWithIndex)
                  .app(PS.Data.Monoid.Conj.Module.monoidConj
                         .app(dictHeytingAlgebra))
                  .app({ i : Any ->
               PS.Control.Semigroupoid.Module.compose
                 .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                 .app(PS.Data.Monoid.Conj.Module.Conj)
                 .app(t.app(i))
            }))
      }
    }
  };
}