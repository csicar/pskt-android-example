@file:Suppress("UNCHECKED_CAST")

package PS.Data.Functor.Product
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val Product = { x : Any -> x};
  @JvmField
  val showProduct = { dictShow : Any ->
     { dictShow1 : Any ->
       PS.Data.Show.Module.Show
         .app({ v : Any ->
           when {
            (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
              val fa = v.value0;
              val ga = v.value1;
              (("(product " as String) + (((PS.Data.Show.Module.show
                                              .app(dictShow)
                                              .app(fa
              ) as String) + (((" " as String) + (((PS.Data.Show.Module.show
                                                      .app(dictShow1)
                                                      .app(ga
              ) as String) + (")" as String)) as String)) as String)) as String));
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        })
    }
  };
  @JvmField
  val product = { fa : Any ->
     { ga : Any ->
       PS.Data.Functor.Product.Module.Product
         .app(PS.Data.Tuple.Module.Tuple.app(fa).app(ga))
    }
  };
  @JvmField
  val newtypeProduct = PS.Data.Newtype.Module.Newtype
                         .app({ n : Any ->
                             val a = n;
                               a;})
                         .app(PS.Data.Functor.Product.Module.Product);
  @JvmField
  val functorProduct = { dictFunctor : Any ->
     { dictFunctor1 : Any ->
       PS.Data.Functor.Module.Functor
         .app({ f : Any ->
           { v : Any ->
            val f1 = f;
              val fga = v;
              PS.Data.Functor.Product.Module.Product
                .app(PS.Data.Bifunctor.Module.bimap
                       .app(PS.Data.Tuple.Module.bifunctorTuple)
                       .app(PS.Data.Functor.Module.map.app(dictFunctor).app(f1))
                       .app(PS.Data.Functor.Module.map.app(dictFunctor1).app(f1)
                       )
                       .app(fga));}
        })
    }
  };
  @JvmField
  val functorWithIndexProduct = { dictFunctorWithIndex : Any ->
     { dictFunctorWithIndex1 : Any ->
       PS.Data.FunctorWithIndex.Module.FunctorWithIndex
         .app({ _ : Any ->
              PS.Data.Functor.Product.Module.functorProduct
                .app((dictFunctorWithIndex as Map<String, Any>)["Functor0"]!!
                       .app(Unit))
                .app((dictFunctorWithIndex1 as Map<String, Any>)["Functor0"]!!
                       .app(Unit))
           })
         .app({ f : Any ->
           { v : Any ->
            val f1 = f;
              val fga = v;
              PS.Data.Functor.Product.Module.Product
                .app(PS.Data.Bifunctor.Module.bimap
                       .app(PS.Data.Tuple.Module.bifunctorTuple)
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
                       .app(fga));}
        })
    }
  };
  @JvmField
  val foldableProduct = { dictFoldable : Any ->
     { dictFoldable1 : Any ->
       PS.Data.Foldable.Module.Foldable
         .app({ dictMonoid : Any ->
              { f : Any ->
                { v : Any ->
                  when {
                   (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                     val f1 = f;
                     val fa = v.value0;
                     val ga = v.value1;
                     PS.Data.Semigroup.Module.append
                       .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!
                              .app(Unit))
                       .app(PS.Data.Foldable.Module.foldMap.app(dictFoldable)
                              .app(dictMonoid)
                              .app(f1)
                              .app(fa))
                       .app(PS.Data.Foldable.Module.foldMap.app(dictFoldable1)
                              .app(dictMonoid)
                              .app(f1)
                              .app(ga));
                   }
                   else -> (error("Error in Pattern Match") as Any)
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
                     val fa = v.value0;
                     val ga = v.value1;
                     PS.Data.Foldable.Module.foldl.app(dictFoldable1).app(f1)
                       .app(PS.Data.Foldable.Module.foldl.app(dictFoldable)
                              .app(f1)
                              .app(z1)
                              .app(fa))
                       .app(ga);
                   }
                   else -> (error("Error in Pattern Match") as Any)
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
                  val fa = v.value0;
                  val ga = v.value1;
                  PS.Data.Foldable.Module.foldr.app(dictFoldable).app(f1)
                    .app(PS.Data.Foldable.Module.foldr.app(dictFoldable1)
                           .app(f1)
                           .app(z1)
                           .app(ga))
                    .app(fa);
                }
                else -> (error("Error in Pattern Match") as Any)
              }
            }
          }
        })
    }
  };
  @JvmField
  val foldableWithIndexProduct = { dictFoldableWithIndex : Any ->
     { dictFoldableWithIndex1 : Any ->
       PS.Data.FoldableWithIndex.Module.FoldableWithIndex
         .app({ _ : Any ->
              PS.Data.Functor.Product.Module.foldableProduct
                .app((dictFoldableWithIndex as Map<String, Any>)["Foldable0"]!!
                       .app(Unit))
                .app((dictFoldableWithIndex1 as Map<String, Any>)["Foldable0"]!!
                       .app(Unit))
           })
         .app({ dictMonoid : Any ->
              { f : Any ->
                { v : Any ->
                  when {
                   (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                     val f1 = f;
                     val fa = v.value0;
                     val ga = v.value1;
                     PS.Data.Semigroup.Module.append
                       .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!
                              .app(Unit))
                       .app(PS.Data.FoldableWithIndex.Module.foldMapWithIndex
                              .app(dictFoldableWithIndex)
                              .app(dictMonoid)
                              .app(PS.Control.Semigroupoid.Module.compose
                                     .app(
                                       PS.Control.Semigroupoid.Module.semigroupoidFn
                                     )
                                     .app(f1)
                                     .app(PS.Data.Either.Module.Left))
                              .app(fa))
                       .app(PS.Data.FoldableWithIndex.Module.foldMapWithIndex
                              .app(dictFoldableWithIndex1)
                              .app(dictMonoid)
                              .app(PS.Control.Semigroupoid.Module.compose
                                     .app(
                                       PS.Control.Semigroupoid.Module.semigroupoidFn
                                     )
                                     .app(f1)
                                     .app(PS.Data.Either.Module.Right))
                              .app(ga));
                   }
                   else -> (error("Error in Pattern Match") as Any)
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
                     val fa = v.value0;
                     val ga = v.value1;
                     PS.Data.FoldableWithIndex.Module.foldlWithIndex
                       .app(dictFoldableWithIndex1)
                       .app(PS.Control.Semigroupoid.Module.compose
                              .app(PS.Control.Semigroupoid.Module.semigroupoidFn
                              )
                              .app(f1)
                              .app(PS.Data.Either.Module.Right))
                       .app(PS.Data.FoldableWithIndex.Module.foldlWithIndex
                              .app(dictFoldableWithIndex)
                              .app(PS.Control.Semigroupoid.Module.compose
                                     .app(
                                       PS.Control.Semigroupoid.Module.semigroupoidFn
                                     )
                                     .app(f1)
                                     .app(PS.Data.Either.Module.Left))
                              .app(z1)
                              .app(fa))
                       .app(ga);
                   }
                   else -> (error("Error in Pattern Match") as Any)
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
                  val fa = v.value0;
                  val ga = v.value1;
                  PS.Data.FoldableWithIndex.Module.foldrWithIndex
                    .app(dictFoldableWithIndex)
                    .app(PS.Control.Semigroupoid.Module.compose
                           .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                           .app(f1)
                           .app(PS.Data.Either.Module.Left))
                    .app(PS.Data.FoldableWithIndex.Module.foldrWithIndex
                           .app(dictFoldableWithIndex1)
                           .app(PS.Control.Semigroupoid.Module.compose
                                  .app(
                                    PS.Control.Semigroupoid.Module.semigroupoidFn
                                  )
                                  .app(f1)
                                  .app(PS.Data.Either.Module.Right))
                           .app(z1)
                           .app(ga))
                    .app(fa);
                }
                else -> (error("Error in Pattern Match") as Any)
              }
            }
          }
        })
    }
  };
  @JvmField
  val traversableProduct = { dictTraversable : Any ->
     { dictTraversable1 : Any ->
       PS.Data.Traversable.Module.Traversable
         .app({ _ : Any ->
              PS.Data.Functor.Product.Module.foldableProduct
                .app((dictTraversable as Map<String, Any>)["Foldable1"]!!
                       .app(Unit))
                .app((dictTraversable1 as Map<String, Any>)["Foldable1"]!!
                       .app(Unit))
           })
         .app({ _ : Any ->
              PS.Data.Functor.Product.Module.functorProduct
                .app((dictTraversable as Map<String, Any>)["Functor0"]!!
                       .app(Unit))
                .app((dictTraversable1 as Map<String, Any>)["Functor0"]!!
                       .app(Unit))
           })
         .app({ dictApplicative : Any ->
              { v : Any ->
                when {
                 (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                   val fa = v.value0;
                   val ga = v.value1;
                   PS.Control.Apply.Module.lift2
                     .app((dictApplicative as Map<String, Any>)["Apply0"]!!
                            .app(Unit))
                     .app(PS.Data.Functor.Product.Module.product)
                     .app(PS.Data.Traversable.Module.sequence
                            .app(dictTraversable)
                            .app(dictApplicative)
                            .app(fa))
                     .app(PS.Data.Traversable.Module.sequence
                            .app(dictTraversable1)
                            .app(dictApplicative)
                            .app(ga));
                 }
                 else -> (error("Error in Pattern Match") as Any)
               }
             }
           })
         .app({ dictApplicative : Any ->
           { f : Any ->
             { v : Any ->
               when {
                (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                  val f1 = f;
                  val fa = v.value0;
                  val ga = v.value1;
                  PS.Control.Apply.Module.lift2
                    .app((dictApplicative as Map<String, Any>)["Apply0"]!!
                           .app(Unit))
                    .app(PS.Data.Functor.Product.Module.product)
                    .app(PS.Data.Traversable.Module.traverse
                           .app(dictTraversable)
                           .app(dictApplicative)
                           .app(f1)
                           .app(fa))
                    .app(PS.Data.Traversable.Module.traverse
                           .app(dictTraversable1)
                           .app(dictApplicative)
                           .app(f1)
                           .app(ga));
                }
                else -> (error("Error in Pattern Match") as Any)
              }
            }
          }
        })
    }
  };
  @JvmField
  val traversableWithIndexProduct = { dictTraversableWithIndex : Any ->
     { dictTraversableWithIndex1 : Any ->
       PS.Data.TraversableWithIndex.Module.TraversableWithIndex
         .app({ _ : Any ->
              PS.Data.Functor.Product.Module.foldableWithIndexProduct
                .app(
                  (dictTraversableWithIndex as Map<String, Any>)["FoldableWithIndex1"]!!
                    .app(Unit))
                .app(
               (dictTraversableWithIndex1 as Map<String, Any>)["FoldableWithIndex1"]!!
                 .app(Unit))
           })
         .app({ _ : Any ->
              PS.Data.Functor.Product.Module.functorWithIndexProduct
                .app(
                  (dictTraversableWithIndex as Map<String, Any>)["FunctorWithIndex0"]!!
                    .app(Unit))
                .app(
               (dictTraversableWithIndex1 as Map<String, Any>)["FunctorWithIndex0"]!!
                 .app(Unit))
           })
         .app({ _ : Any ->
              PS.Data.Functor.Product.Module.traversableProduct
                .app(
                  (dictTraversableWithIndex as Map<String, Any>)["Traversable2"]!!
                    .app(Unit))
                .app(
               (dictTraversableWithIndex1 as Map<String, Any>)["Traversable2"]!!
                 .app(Unit))
           })
         .app({ dictApplicative : Any ->
           { f : Any ->
             { v : Any ->
               when {
                (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                  val f1 = f;
                  val fa = v.value0;
                  val ga = v.value1;
                  PS.Control.Apply.Module.lift2
                    .app((dictApplicative as Map<String, Any>)["Apply0"]!!
                           .app(Unit))
                    .app(PS.Data.Functor.Product.Module.product)
                    .app(PS.Data.TraversableWithIndex.Module.traverseWithIndex
                           .app(dictTraversableWithIndex)
                           .app(dictApplicative)
                           .app(PS.Control.Semigroupoid.Module.compose
                                  .app(
                                    PS.Control.Semigroupoid.Module.semigroupoidFn
                                  )
                                  .app(f1)
                                  .app(PS.Data.Either.Module.Left))
                           .app(fa))
                    .app(PS.Data.TraversableWithIndex.Module.traverseWithIndex
                           .app(dictTraversableWithIndex1)
                           .app(dictApplicative)
                           .app(PS.Control.Semigroupoid.Module.compose
                                  .app(
                                    PS.Control.Semigroupoid.Module.semigroupoidFn
                                  )
                                  .app(f1)
                                  .app(PS.Data.Either.Module.Right))
                           .app(ga));
                }
                else -> (error("Error in Pattern Match") as Any)
              }
            }
          }
        })
    }
  };
  @JvmField
  val eq1Product = { dictEq1 : Any ->
     { dictEq11 : Any ->
       PS.Data.Eq.Module.Eq1
         .app({ dictEq : Any ->
           { v : Any ->
             { v1 : Any ->
               when {
                (v is PS.Data.Tuple.Module._Type_Tuple
                        .Tuple)&& (v1 is PS.Data.Tuple.Module._Type_Tuple
                                           .Tuple) -> {
                  val l1 = v.value0;
                  val r1 = v.value1;
                  val l2 = v1.value0;
                  val r2 = v1.value1;
                  PS.Data.HeytingAlgebra.Module.conj
                    .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
                    .app(PS.Data.Eq.Module.eq1.app(dictEq1).app(dictEq).app(l1)
                           .app(l2))
                    .app(PS.Data.Eq.Module.eq1.app(dictEq11).app(dictEq).app(r1)
                           .app(r2));
                }
                else -> (error("Error in Pattern Match") as Any)
              }
            }
          }
        })
    }
  };
  @JvmField
  val eqProduct = { dictEq1 : Any ->
     { dictEq11 : Any ->
       { dictEq : Any ->
         PS.Data.Eq.Module.Eq
           .app(PS.Data.Eq.Module.eq1
                  .app(PS.Data.Functor.Product.Module.eq1Product.app(dictEq1)
                         .app(dictEq11))
                  .app(dictEq))
      }
    }
  };
  @JvmField
  val ord1Product = { dictOrd1 : Any ->
     { dictOrd11 : Any ->
       PS.Data.Ord.Module.Ord1
         .app({ _ : Any ->
              PS.Data.Functor.Product.Module.eq1Product
                .app((dictOrd1 as Map<String, Any>)["Eq10"]!!.app(Unit))
                .app((dictOrd11 as Map<String, Any>)["Eq10"]!!.app(Unit))
           })
         .app({ dictOrd : Any ->
           { v : Any ->
             { v1 : Any ->
               when {
                (v is PS.Data.Tuple.Module._Type_Tuple
                        .Tuple)&& (v1 is PS.Data.Tuple.Module._Type_Tuple
                                           .Tuple) -> {
                  val l1 = v.value0;
                  val r1 = v.value1;
                  val l2 = v1.value0;
                  val r2 = v1.value1;
                  object   {
                      val v2 = PS.Data.Ord.Module.compare1.app(dictOrd1)
                                 .app(dictOrd)
                                 .app(l1)
                                 .app(l2);
                    }
                    .run({
                      val v2 = this.v2;
                      when {
                        (v2 is PS.Data.Ordering.Module._Type_Ordering.EQ) -> {
                          PS.Data.Ord.Module.compare1.app(dictOrd11)
                            .app(dictOrd)
                            .app(r1)
                            .app(r2);
                        }
                        else -> {
                          val o = v2;
                          o;
                        }
                      };
                    });
                }
                else -> (error("Error in Pattern Match") as Any)
              }
            }
          }
        })
    }
  };
  @JvmField
  val ordProduct = { dictOrd1 : Any ->
     { dictOrd11 : Any ->
       { dictOrd : Any ->
         PS.Data.Ord.Module.Ord
           .app({ _ : Any ->
                PS.Data.Functor.Product.Module.eqProduct
                  .app((dictOrd1 as Map<String, Any>)["Eq10"]!!.app(Unit))
                  .app((dictOrd11 as Map<String, Any>)["Eq10"]!!.app(Unit))
                  .app((dictOrd as Map<String, Any>)["Eq0"]!!.app(Unit))
             })
           .app(PS.Data.Ord.Module.compare1
                  .app(PS.Data.Functor.Product.Module.ord1Product.app(dictOrd1)
                         .app(dictOrd11))
                  .app(dictOrd))
      }
    }
  };
  @JvmField
  val bihoistProduct = { natF : Any ->
     { natG : Any ->
       { v : Any ->
        val natF1 = natF;
          val natG1 = natG;
          val e = v;
          PS.Data.Functor.Product.Module.Product
            .app(PS.Data.Bifunctor.Module.bimap
                   .app(PS.Data.Tuple.Module.bifunctorTuple)
                   .app(natF1)
                   .app(natG1)
                   .app(e));}
    }
  };
  @JvmField
  val applyProduct = { dictApply : Any ->
     { dictApply1 : Any ->
       PS.Control.Apply.Module.Apply
         .app({ _ : Any ->
              PS.Data.Functor.Product.Module.functorProduct
                .app((dictApply as Map<String, Any>)["Functor0"]!!.app(Unit))
                .app((dictApply1 as Map<String, Any>)["Functor0"]!!.app(Unit))
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
                PS.Data.Functor.Product.Module.product
                  .app(PS.Control.Apply.Module.apply.app(dictApply).app(f)
                         .app(a))
                  .app(PS.Control.Apply.Module.apply.app(dictApply1).app(g)
                         .app(b));
              }
              else -> (error("Error in Pattern Match") as Any)
            }
          }
        })
    }
  };
  @JvmField
  val bindProduct = { dictBind : Any ->
     { dictBind1 : Any ->
       PS.Control.Bind.Module.Bind
         .app({ _ : Any ->
              PS.Data.Functor.Product.Module.applyProduct
                .app((dictBind as Map<String, Any>)["Apply0"]!!.app(Unit))
                .app((dictBind1 as Map<String, Any>)["Apply0"]!!.app(Unit))
           })
         .app({ v : Any ->
           { f : Any ->
             when {
              (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                val fa = v.value0;
                val ga = v.value1;
                val f1 = f;
                PS.Data.Functor.Product.Module.product
                  .app(PS.Control.Bind.Module.bind.app(dictBind).app(fa)
                         .app(PS.Control.Semigroupoid.Module.compose
                                .app(
                                  PS.Control.Semigroupoid.Module.semigroupoidFn)
                                .app(PS.Data.Tuple.Module.fst)
                                .app(PS.Control.Semigroupoid.Module.compose
                                       .app(
                                         PS.Control.Semigroupoid.Module.semigroupoidFn
                                       )
                                       .app(PS.Data.Newtype.Module.unwrap
                                              .app(
                                           PS.Data.Functor.Product.Module.newtypeProduct
                                         ))
                                       .app(f1))))
                  .app(PS.Control.Bind.Module.bind.app(dictBind1).app(ga)
                         .app(PS.Control.Semigroupoid.Module.compose
                                .app(
                                  PS.Control.Semigroupoid.Module.semigroupoidFn)
                                .app(PS.Data.Tuple.Module.snd)
                                .app(PS.Control.Semigroupoid.Module.compose
                                       .app(
                                         PS.Control.Semigroupoid.Module.semigroupoidFn
                                       )
                                       .app(PS.Data.Newtype.Module.unwrap
                                              .app(
                                           PS.Data.Functor.Product.Module.newtypeProduct
                                         ))
                                       .app(f1))));
              }
              else -> (error("Error in Pattern Match") as Any)
            }
          }
        })
    }
  };
  @JvmField
  val applicativeProduct = { dictApplicative : Any ->
     { dictApplicative1 : Any ->
       PS.Control.Applicative.Module.Applicative
         .app({ _ : Any ->
              PS.Data.Functor.Product.Module.applyProduct
                .app((dictApplicative as Map<String, Any>)["Apply0"]!!.app(Unit)
                )
                .app((dictApplicative1 as Map<String, Any>)["Apply0"]!!
                       .app(Unit))
           })
         .app({ a : Any ->
           PS.Data.Functor.Product.Module.product
             .app(PS.Control.Applicative.Module.pure.app(dictApplicative).app(a)
             )
             .app(PS.Control.Applicative.Module.pure.app(dictApplicative1)
                    .app(a))
        })
    }
  };
  @JvmField
  val monadProduct = { dictMonad : Any ->
     { dictMonad1 : Any ->
       PS.Control.Monad.Module.Monad
         .app({ _ : Any ->
              PS.Data.Functor.Product.Module.applicativeProduct
                .app((dictMonad as Map<String, Any>)["Applicative0"]!!.app(Unit)
                )
                .app((dictMonad1 as Map<String, Any>)["Applicative0"]!!
                       .app(Unit))
           })
         .app({ _ : Any ->
           PS.Data.Functor.Product.Module.bindProduct
             .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
             .app((dictMonad1 as Map<String, Any>)["Bind1"]!!.app(Unit))
        })
    }
  };
}