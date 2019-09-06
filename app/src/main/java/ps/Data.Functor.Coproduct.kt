@file:Suppress("UNCHECKED_CAST")
package PS.Data.Functor.Coproduct
import Foreign.PsRuntime.app
object Module  {
  @JvmField val Coproduct = { x : Any -> x};
  @JvmField
  val showCoproduct = { dictShow : Any ->
     { dictShow1 : Any ->
       PS.Data.Show.Module.Show
         .app({ v : Any ->
           when {
            (v is PS.Data.Either.Module._Type_Either.Left) -> {
              val fa = v.value0;
              (("(left " as String) + (((PS.Data.Show.Module.show.app(dictShow)
                                           .app(fa
              ) as String) + (")" as String)) as String));
            }
            (v is PS.Data.Either.Module._Type_Either.Right) -> {
              val ga = v.value0;
              (("(right " as String) + (((PS.Data.Show.Module.show
                                            .app(dictShow1)
                                            .app(ga
              ) as String) + (")" as String)) as String));
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        })
    }
  };
  @JvmField
  val right = { ga : Any ->
     PS.Data.Functor.Coproduct.Module.Coproduct
       .app(PS.Data.Either.Module.Right.app(ga))
  };
  @JvmField
  val newtypeCoproduct = PS.Data.Newtype.Module.Newtype
                           .app({ n : Any ->
                                when {
                                 else -> {
                                   val a = n;
                                   a;
                                 }
                               }
                             })
                           .app(PS.Data.Functor.Coproduct.Module.Coproduct);
  @JvmField
  val left = { fa : Any ->
     PS.Data.Functor.Coproduct.Module.Coproduct
       .app(PS.Data.Either.Module.Left.app(fa))
  };
  @JvmField
  val functorCoproduct = { dictFunctor : Any ->
     { dictFunctor1 : Any ->
       PS.Data.Functor.Module.Functor
         .app({ f : Any ->
           { v : Any ->
             when {
              else -> {
                val f1 = f;
                val e = v;
                PS.Data.Functor.Coproduct.Module.Coproduct
                  .app(PS.Data.Bifunctor.Module.bimap
                         .app(PS.Data.Either.Module.bifunctorEither)
                         .app(PS.Data.Functor.Module.map.app(dictFunctor)
                                .app(f1))
                         .app(PS.Data.Functor.Module.map.app(dictFunctor1)
                                .app(f1))
                         .app(e));
              }
            }
          }
        })
    }
  };
  @JvmField
  val functorWithIndexCoproduct = { dictFunctorWithIndex : Any ->
     { dictFunctorWithIndex1 : Any ->
       PS.Data.FunctorWithIndex.Module.FunctorWithIndex
         .app({ _ : Any ->
              PS.Data.Functor.Coproduct.Module.functorCoproduct
                .app((dictFunctorWithIndex as Map<String, Any>)["Functor0"]!!
                       .app(Unit))
                .app((dictFunctorWithIndex1 as Map<String, Any>)["Functor0"]!!
                       .app(Unit))
           })
         .app({ f : Any ->
           { v : Any ->
             when {
              else -> {
                val f1 = f;
                val e = v;
                PS.Data.Functor.Coproduct.Module.Coproduct
                  .app(PS.Data.Bifunctor.Module.bimap
                         .app(PS.Data.Either.Module.bifunctorEither)
                         .app(PS.Data.FunctorWithIndex.Module.mapWithIndex
                                .app(dictFunctorWithIndex)
                                .app(PS.Control.Semigroupoid.Module.compose
                                       .app(
                                         PS.Control.Semigroupoid.Module.semigroupoidFn
                                       )
                                       .app(f1)
                                       .app(PS.Data.Either.Module.Left)))
                         .app(PS.Data.FunctorWithIndex.Module.mapWithIndex
                                .app(dictFunctorWithIndex1)
                                .app(PS.Control.Semigroupoid.Module.compose
                                       .app(
                                         PS.Control.Semigroupoid.Module.semigroupoidFn
                                       )
                                       .app(f1)
                                       .app(PS.Data.Either.Module.Right)))
                         .app(e));
              }
            }
          }
        })
    }
  };
  @JvmField
  val eq1Coproduct = { dictEq1 : Any ->
     { dictEq11 : Any ->
       PS.Data.Eq.Module.Eq1
         .app({ dictEq : Any ->
           { v : Any ->
             { v1 : Any ->
               when {
                else -> {
                  val x = v;
                  val y = v1;
                  when {
                    (x is PS.Data.Either.Module._Type_Either
                            .Left)&& (y is PS.Data.Either.Module._Type_Either
                                             .Left) -> {
                      val fa = x.value0;
                      val ga = y.value0;
                      PS.Data.Eq.Module.eq1.app(dictEq1).app(dictEq).app(fa)
                        .app(ga);
                    }
                    (x is PS.Data.Either.Module._Type_Either
                            .Right)&& (y is PS.Data.Either.Module._Type_Either
                                              .Right) -> {
                      val fa = x.value0;
                      val ga = y.value0;
                      PS.Data.Eq.Module.eq1.app(dictEq11).app(dictEq).app(fa)
                        .app(ga);
                    }
                    else -> {
                      false;
                    }
                  };
                }
              }
            }
          }
        })
    }
  };
  @JvmField
  val eqCoproduct = { dictEq1 : Any ->
     { dictEq11 : Any ->
       { dictEq : Any ->
         PS.Data.Eq.Module.Eq
           .app(PS.Data.Eq.Module.eq1
                  .app(PS.Data.Functor.Coproduct.Module.eq1Coproduct
                         .app(dictEq1)
                         .app(dictEq11))
                  .app(dictEq))
      }
    }
  };
  @JvmField
  val ord1Coproduct = { dictOrd1 : Any ->
     { dictOrd11 : Any ->
       PS.Data.Ord.Module.Ord1
         .app({ _ : Any ->
              PS.Data.Functor.Coproduct.Module.eq1Coproduct
                .app((dictOrd1 as Map<String, Any>)["Eq10"]!!.app(Unit))
                .app((dictOrd11 as Map<String, Any>)["Eq10"]!!.app(Unit))
           })
         .app({ dictOrd : Any ->
           { v : Any ->
             { v1 : Any ->
               when {
                else -> {
                  val x = v;
                  val y = v1;
                  when {
                    (x is PS.Data.Either.Module._Type_Either
                            .Left)&& (y is PS.Data.Either.Module._Type_Either
                                             .Left) -> {
                      val fa = x.value0;
                      val ga = y.value0;
                      PS.Data.Ord.Module.compare1.app(dictOrd1).app(dictOrd)
                        .app(fa)
                        .app(ga);
                    }
                    (x is PS.Data.Either.Module._Type_Either.Left) -> {
                      PS.Data.Ordering.Module.LT;
                    }
                    (y is PS.Data.Either.Module._Type_Either.Left) -> {
                      PS.Data.Ordering.Module.GT;
                    }
                    (x is PS.Data.Either.Module._Type_Either
                            .Right)&& (y is PS.Data.Either.Module._Type_Either
                                              .Right) -> {
                      val fa = x.value0;
                      val ga = y.value0;
                      PS.Data.Ord.Module.compare1.app(dictOrd11).app(dictOrd)
                        .app(fa)
                        .app(ga);
                    }
                    else -> (error("Error in Pattern Match") as Any)
                  };
                }
              }
            }
          }
        })
    }
  };
  @JvmField
  val ordCoproduct = { dictOrd1 : Any ->
     { dictOrd11 : Any ->
       { dictOrd : Any ->
         PS.Data.Ord.Module.Ord
           .app({ _ : Any ->
                PS.Data.Functor.Coproduct.Module.eqCoproduct
                  .app((dictOrd1 as Map<String, Any>)["Eq10"]!!.app(Unit))
                  .app((dictOrd11 as Map<String, Any>)["Eq10"]!!.app(Unit))
                  .app((dictOrd as Map<String, Any>)["Eq0"]!!.app(Unit))
             })
           .app(PS.Data.Ord.Module.compare1
                  .app(PS.Data.Functor.Coproduct.Module.ord1Coproduct
                         .app(dictOrd1)
                         .app(dictOrd11))
                  .app(dictOrd))
      }
    }
  };
  @JvmField
  val coproduct = { v : Any ->
     { v1 : Any ->
       { v2 : Any ->
         when {
          (v2 is PS.Data.Either.Module._Type_Either.Left) -> {
            val f = v;
            val a = v2.value0;
            f.app(a);
          }
          (v2 is PS.Data.Either.Module._Type_Either.Right) -> {
            val g = v1;
            val b = v2.value0;
            g.app(b);
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    }
  };
  @JvmField
  val extendCoproduct = { dictExtend : Any ->
     { dictExtend1 : Any ->
       PS.Control.Extend.Module.Extend
         .app({ _ : Any ->
              PS.Data.Functor.Coproduct.Module.functorCoproduct
                .app((dictExtend as Map<String, Any>)["Functor0"]!!.app(Unit))
                .app((dictExtend1 as Map<String, Any>)["Functor0"]!!.app(Unit))
           })
         .app({ f : Any ->
           PS.Control.Semigroupoid.Module.compose
             .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
             .app(PS.Data.Functor.Coproduct.Module.Coproduct)
             .app(PS.Data.Functor.Coproduct.Module.coproduct
                    .app(PS.Control.Semigroupoid.Module.compose
                           .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                           .app(PS.Data.Either.Module.Left)
                           .app(PS.Control.Extend.Module.extend.app(dictExtend)
                                  .app(PS.Control.Semigroupoid.Module.compose
                                         .app(
                                           PS.Control.Semigroupoid.Module.semigroupoidFn
                                         )
                                         .app(f)
                                         .app(
                            PS.Control.Semigroupoid.Module.compose
                              .app(PS.Control.Semigroupoid.Module.semigroupoidFn
                              )
                              .app(PS.Data.Functor.Coproduct.Module.Coproduct)
                              .app(PS.Data.Either.Module.Left)))))
                    .app(PS.Control.Semigroupoid.Module.compose
                           .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                           .app(PS.Data.Either.Module.Right)
                           .app(PS.Control.Extend.Module.extend.app(dictExtend1)
                                  .app(PS.Control.Semigroupoid.Module.compose
                                         .app(
                                           PS.Control.Semigroupoid.Module.semigroupoidFn
                                         )
                                         .app(f)
                                         .app(
                    PS.Control.Semigroupoid.Module.compose
                      .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                      .app(PS.Data.Functor.Coproduct.Module.Coproduct)
                      .app(PS.Data.Either.Module.Right))))))
        })
    }
  };
  @JvmField
  val foldableCoproduct = { dictFoldable : Any ->
     { dictFoldable1 : Any ->
       PS.Data.Foldable.Module.Foldable
         .app({ dictMonoid : Any ->
              { f : Any ->
                PS.Data.Functor.Coproduct.Module.coproduct
                  .app(PS.Data.Foldable.Module.foldMap.app(dictFoldable)
                         .app(dictMonoid)
                         .app(f))
                  .app(PS.Data.Foldable.Module.foldMap.app(dictFoldable1)
                         .app(dictMonoid)
                         .app(f))
             }
           })
         .app({ f : Any ->
              { z : Any ->
                PS.Data.Functor.Coproduct.Module.coproduct
                  .app(PS.Data.Foldable.Module.foldl.app(dictFoldable).app(f)
                         .app(z))
                  .app(PS.Data.Foldable.Module.foldl.app(dictFoldable1).app(f)
                         .app(z))
             }
           })
         .app({ f : Any ->
           { z : Any ->
             PS.Data.Functor.Coproduct.Module.coproduct
               .app(PS.Data.Foldable.Module.foldr.app(dictFoldable).app(f)
                      .app(z))
               .app(PS.Data.Foldable.Module.foldr.app(dictFoldable1).app(f)
                      .app(z))
          }
        })
    }
  };
  @JvmField
  val foldableWithIndexCoproduct = { dictFoldableWithIndex : Any ->
     { dictFoldableWithIndex1 : Any ->
       PS.Data.FoldableWithIndex.Module.FoldableWithIndex
         .app({ _ : Any ->
              PS.Data.Functor.Coproduct.Module.foldableCoproduct
                .app((dictFoldableWithIndex as Map<String, Any>)["Foldable0"]!!
                       .app(Unit))
                .app((dictFoldableWithIndex1 as Map<String, Any>)["Foldable0"]!!
                       .app(Unit))
           })
         .app({ dictMonoid : Any ->
              { f : Any ->
                PS.Data.Functor.Coproduct.Module.coproduct
                  .app(PS.Data.FoldableWithIndex.Module.foldMapWithIndex
                         .app(dictFoldableWithIndex)
                         .app(dictMonoid)
                         .app(PS.Control.Semigroupoid.Module.compose
                                .app(
                                  PS.Control.Semigroupoid.Module.semigroupoidFn)
                                .app(f)
                                .app(PS.Data.Either.Module.Left)))
                  .app(PS.Data.FoldableWithIndex.Module.foldMapWithIndex
                         .app(dictFoldableWithIndex1)
                         .app(dictMonoid)
                         .app(PS.Control.Semigroupoid.Module.compose
                                .app(
                                  PS.Control.Semigroupoid.Module.semigroupoidFn)
                                .app(f)
                                .app(PS.Data.Either.Module.Right)))
             }
           })
         .app({ f : Any ->
              { z : Any ->
                PS.Data.Functor.Coproduct.Module.coproduct
                  .app(PS.Data.FoldableWithIndex.Module.foldlWithIndex
                         .app(dictFoldableWithIndex)
                         .app(PS.Control.Semigroupoid.Module.compose
                                .app(
                                  PS.Control.Semigroupoid.Module.semigroupoidFn)
                                .app(f)
                                .app(PS.Data.Either.Module.Left))
                         .app(z))
                  .app(PS.Data.FoldableWithIndex.Module.foldlWithIndex
                         .app(dictFoldableWithIndex1)
                         .app(PS.Control.Semigroupoid.Module.compose
                                .app(
                                  PS.Control.Semigroupoid.Module.semigroupoidFn)
                                .app(f)
                                .app(PS.Data.Either.Module.Right))
                         .app(z))
             }
           })
         .app({ f : Any ->
           { z : Any ->
             PS.Data.Functor.Coproduct.Module.coproduct
               .app(PS.Data.FoldableWithIndex.Module.foldrWithIndex
                      .app(dictFoldableWithIndex)
                      .app(PS.Control.Semigroupoid.Module.compose
                             .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                             .app(f)
                             .app(PS.Data.Either.Module.Left))
                      .app(z))
               .app(PS.Data.FoldableWithIndex.Module.foldrWithIndex
                      .app(dictFoldableWithIndex1)
                      .app(PS.Control.Semigroupoid.Module.compose
                             .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                             .app(f)
                             .app(PS.Data.Either.Module.Right))
                      .app(z))
          }
        })
    }
  };
  @JvmField
  val traversableCoproduct = { dictTraversable : Any ->
     { dictTraversable1 : Any ->
       PS.Data.Traversable.Module.Traversable
         .app({ _ : Any ->
              PS.Data.Functor.Coproduct.Module.foldableCoproduct
                .app((dictTraversable as Map<String, Any>)["Foldable1"]!!
                       .app(Unit))
                .app((dictTraversable1 as Map<String, Any>)["Foldable1"]!!
                       .app(Unit))
           })
         .app({ _ : Any ->
              PS.Data.Functor.Coproduct.Module.functorCoproduct
                .app((dictTraversable as Map<String, Any>)["Functor0"]!!
                       .app(Unit))
                .app((dictTraversable1 as Map<String, Any>)["Functor0"]!!
                       .app(Unit))
           })
         .app({ dictApplicative : Any ->
              PS.Data.Functor.Coproduct.Module.coproduct
                .app(PS.Control.Semigroupoid.Module.compose
                       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                       .app(PS.Data.Functor.Module.map
                              .app(
                                ((dictApplicative as Map<String, Any>)["Apply0"]!!
                                   .app(Unit) as Map<String, Any>)["Functor0"]!!
                                  .app(Unit))
                              .app(PS.Control.Semigroupoid.Module.compose
                                     .app(
                                       PS.Control.Semigroupoid.Module.semigroupoidFn
                                     )
                                     .app(
                                       PS.Data.Functor.Coproduct.Module.Coproduct
                                     )
                                     .app(PS.Data.Either.Module.Left)))
                       .app(PS.Data.Traversable.Module.sequence
                              .app(dictTraversable)
                              .app(dictApplicative)))
                .app(PS.Control.Semigroupoid.Module.compose
                       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                       .app(PS.Data.Functor.Module.map
                              .app(
                                ((dictApplicative as Map<String, Any>)["Apply0"]!!
                                   .app(Unit) as Map<String, Any>)["Functor0"]!!
                                  .app(Unit))
                              .app(PS.Control.Semigroupoid.Module.compose
                                     .app(
                                       PS.Control.Semigroupoid.Module.semigroupoidFn
                                     )
                                     .app(
                                       PS.Data.Functor.Coproduct.Module.Coproduct
                                     )
                                     .app(PS.Data.Either.Module.Right)))
                       .app(PS.Data.Traversable.Module.sequence
                              .app(dictTraversable1)
                              .app(dictApplicative)))
           })
         .app({ dictApplicative : Any ->
           { f : Any ->
             PS.Data.Functor.Coproduct.Module.coproduct
               .app(PS.Control.Semigroupoid.Module.compose
                      .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                      .app(PS.Data.Functor.Module.map
                             .app(
                               ((dictApplicative as Map<String, Any>)["Apply0"]!!
                                  .app(Unit) as Map<String, Any>)["Functor0"]!!
                                 .app(Unit))
                             .app(PS.Control.Semigroupoid.Module.compose
                                    .app(
                                      PS.Control.Semigroupoid.Module.semigroupoidFn
                                    )
                                    .app(
                                      PS.Data.Functor.Coproduct.Module.Coproduct
                                    )
                                    .app(PS.Data.Either.Module.Left)))
                      .app(PS.Data.Traversable.Module.traverse
                             .app(dictTraversable)
                             .app(dictApplicative)
                             .app(f)))
               .app(PS.Control.Semigroupoid.Module.compose
                      .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                      .app(PS.Data.Functor.Module.map
                             .app(
                               ((dictApplicative as Map<String, Any>)["Apply0"]!!
                                  .app(Unit) as Map<String, Any>)["Functor0"]!!
                                 .app(Unit))
                             .app(PS.Control.Semigroupoid.Module.compose
                                    .app(
                                      PS.Control.Semigroupoid.Module.semigroupoidFn
                                    )
                                    .app(
                                      PS.Data.Functor.Coproduct.Module.Coproduct
                                    )
                                    .app(PS.Data.Either.Module.Right)))
                      .app(PS.Data.Traversable.Module.traverse
                             .app(dictTraversable1)
                             .app(dictApplicative)
                             .app(f)))
          }
        })
    }
  };
  @JvmField
  val traversableWithIndexCoproduct = { dictTraversableWithIndex : Any ->
     { dictTraversableWithIndex1 : Any ->
       PS.Data.TraversableWithIndex.Module.TraversableWithIndex
         .app({ _ : Any ->
              PS.Data.Functor.Coproduct.Module.foldableWithIndexCoproduct
                .app(
                  (dictTraversableWithIndex as Map<String, Any>)["FoldableWithIndex1"]!!
                    .app(Unit))
                .app(
               (dictTraversableWithIndex1 as Map<String, Any>)["FoldableWithIndex1"]!!
                 .app(Unit))
           })
         .app({ _ : Any ->
              PS.Data.Functor.Coproduct.Module.functorWithIndexCoproduct
                .app(
                  (dictTraversableWithIndex as Map<String, Any>)["FunctorWithIndex0"]!!
                    .app(Unit))
                .app(
               (dictTraversableWithIndex1 as Map<String, Any>)["FunctorWithIndex0"]!!
                 .app(Unit))
           })
         .app({ _ : Any ->
              PS.Data.Functor.Coproduct.Module.traversableCoproduct
                .app(
                  (dictTraversableWithIndex as Map<String, Any>)["Traversable2"]!!
                    .app(Unit))
                .app(
               (dictTraversableWithIndex1 as Map<String, Any>)["Traversable2"]!!
                 .app(Unit))
           })
         .app({ dictApplicative : Any ->
           { f : Any ->
             PS.Data.Functor.Coproduct.Module.coproduct
               .app(PS.Control.Semigroupoid.Module.compose
                      .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                      .app(PS.Data.Functor.Module.map
                             .app(
                               ((dictApplicative as Map<String, Any>)["Apply0"]!!
                                  .app(Unit) as Map<String, Any>)["Functor0"]!!
                                 .app(Unit))
                             .app(PS.Control.Semigroupoid.Module.compose
                                    .app(
                                      PS.Control.Semigroupoid.Module.semigroupoidFn
                                    )
                                    .app(
                                      PS.Data.Functor.Coproduct.Module.Coproduct
                                    )
                                    .app(PS.Data.Either.Module.Left)))
                      .app(PS.Data.TraversableWithIndex.Module.traverseWithIndex
                             .app(dictTraversableWithIndex)
                             .app(dictApplicative)
                             .app(PS.Control.Semigroupoid.Module.compose
                                    .app(
                                      PS.Control.Semigroupoid.Module.semigroupoidFn
                                    )
                                    .app(f)
                                    .app(PS.Data.Either.Module.Left))))
               .app(PS.Control.Semigroupoid.Module.compose
                      .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                      .app(PS.Data.Functor.Module.map
                             .app(
                               ((dictApplicative as Map<String, Any>)["Apply0"]!!
                                  .app(Unit) as Map<String, Any>)["Functor0"]!!
                                 .app(Unit))
                             .app(PS.Control.Semigroupoid.Module.compose
                                    .app(
                                      PS.Control.Semigroupoid.Module.semigroupoidFn
                                    )
                                    .app(
                                      PS.Data.Functor.Coproduct.Module.Coproduct
                                    )
                                    .app(PS.Data.Either.Module.Right)))
                      .app(PS.Data.TraversableWithIndex.Module.traverseWithIndex
                             .app(dictTraversableWithIndex1)
                             .app(dictApplicative)
                             .app(PS.Control.Semigroupoid.Module.compose
                                    .app(
                                      PS.Control.Semigroupoid.Module.semigroupoidFn
                                    )
                                    .app(f)
                                    .app(PS.Data.Either.Module.Right))))
          }
        })
    }
  };
  @JvmField
  val comonadCoproduct = { dictComonad : Any ->
     { dictComonad1 : Any ->
       PS.Control.Comonad.Module.Comonad
         .app({ _ : Any ->
              PS.Data.Functor.Coproduct.Module.extendCoproduct
                .app((dictComonad as Map<String, Any>)["Extend0"]!!.app(Unit))
                .app((dictComonad1 as Map<String, Any>)["Extend0"]!!.app(Unit))
           })
         .app(PS.Data.Functor.Coproduct.Module.coproduct
                .app(PS.Control.Comonad.Module.extract.app(dictComonad))
                .app(PS.Control.Comonad.Module.extract.app(dictComonad1)))
    }
  };
  @JvmField
  val bihoistCoproduct = { natF : Any ->
     { natG : Any ->
       { v : Any ->
         when {
          else -> {
            val natF1 = natF;
            val natG1 = natG;
            val e = v;
            PS.Data.Functor.Coproduct.Module.Coproduct
              .app(PS.Data.Bifunctor.Module.bimap
                     .app(PS.Data.Either.Module.bifunctorEither)
                     .app(natF1)
                     .app(natG1)
                     .app(e));
          }
        }
      }
    }
  };
}