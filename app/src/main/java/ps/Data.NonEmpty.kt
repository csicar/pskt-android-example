@file:Suppress("UNCHECKED_CAST")
package PS.Data.NonEmpty
import Foreign.PsRuntime.app
object Module  {
  sealed class _Type_NonEmpty ()  {
    data class NonEmpty (val value0 : Any,  val value1 : Any) : _Type_NonEmpty(
    ) {};
  };
  val NonEmpty = { value0 : Any ->
     { value1 : Any ->
       _Type_NonEmpty.NonEmpty(value0,  value1)
    }
  };
  @JvmField
  val unfoldable1NonEmpty = { dictUnfoldable : Any ->
     PS.Data.Unfoldable1.Module.Unfoldable1
       .app({ f : Any ->
         { b : Any ->
           PS.Data.Function.Module.apply
             .app(PS.Data.Tuple.Module.uncurry
                    .app(PS.Data.NonEmpty.Module.NonEmpty))
             .app(PS.Data.Functor.Module.map
                    .app(PS.Data.Tuple.Module.functorTuple)
                    .app(PS.Data.Unfoldable.Module.unfoldr.app(dictUnfoldable)
                           .app(PS.Data.Functor.Module.map
                                  .app(PS.Data.Maybe.Module.functorMaybe)
                                  .app(f)))
                    .app(f.app(b)))
        }
      })
  };
  @JvmField
  val tail = { v : Any ->
     when {
      (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
        val xs = v.value1;
        xs;
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val singleton = { dictPlus : Any ->
     { a : Any ->
       PS.Data.NonEmpty.Module.NonEmpty.app(a)
         .app(PS.Control.Plus.Module.empty.app(dictPlus))
    }
  };
  @JvmField
  val showNonEmpty = { dictShow : Any ->
     { dictShow1 : Any ->
       PS.Data.Show.Module.Show
         .app({ v : Any ->
           when {
            (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
              val a = v.value0;
              val fa = v.value1;
              (("(NonEmpty " as String) + (((PS.Data.Show.Module.show
                                               .app(dictShow)
                                               .app(a
              ) as String) + (((" " as String) + (((PS.Data.Show.Module.show
                                                      .app(dictShow1)
                                                      .app(fa
              ) as String) + (")" as String)) as String)) as String)) as String));
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        })
    }
  };
  @JvmField
  val oneOf = { dictAlternative : Any ->
     { v : Any ->
       when {
        (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
          val a = v.value0;
          val fa = v.value1;
          PS.Control.Alt.Module.alt
            .app(((dictAlternative as Map<String, Any>)["Plus1"]!!
                    .app(Unit) as Map<String, Any>)["Alt0"]!!
                   .app(Unit))
            .app(PS.Control.Applicative.Module.pure
                   .app((dictAlternative as Map<String, Any>)["Applicative0"]!!
                          .app(Unit))
                   .app(a))
            .app(fa);
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val head = { v : Any ->
     when {
      (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
        val x = v.value0;
        x;
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val functorNonEmpty = { dictFunctor : Any ->
     PS.Data.Functor.Module.Functor
       .app({ f : Any ->
         { m : Any ->
           when {
            (m is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
              val v = m.value0;
              val v1 = m.value1;
              PS.Data.NonEmpty.Module.NonEmpty.app(f.app(v))
                .app(PS.Data.Functor.Module.map.app(dictFunctor).app(f).app(v1)
              );
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      })
  };
  @JvmField
  val functorWithIndex = { dictFunctorWithIndex : Any ->
     PS.Data.FunctorWithIndex.Module.FunctorWithIndex
       .app({ _ : Any ->
            PS.Data.NonEmpty.Module.functorNonEmpty
              .app((dictFunctorWithIndex as Map<String, Any>)["Functor0"]!!
                     .app(Unit))
         })
       .app({ f : Any ->
         { v : Any ->
           when {
            (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
              val f1 = f;
              val a = v.value0;
              val fa = v.value1;
              PS.Data.NonEmpty.Module.NonEmpty
                .app(f1.app(PS.Data.Maybe.Module.Nothing).app(a))
                .app(PS.Data.FunctorWithIndex.Module.mapWithIndex
                       .app(dictFunctorWithIndex)
                       .app(PS.Control.Semigroupoid.Module.compose
                              .app(PS.Control.Semigroupoid.Module.semigroupoidFn
                              )
                              .app(f1)
                              .app(PS.Data.Maybe.Module.Just))
                       .app(fa));
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      })
  };
  @JvmField
  val fromNonEmpty = { f : Any ->
     { v : Any ->
       when {
        (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
          val f1 = f;
          val a = v.value0;
          val fa = v.value1;
          f1.app(a).app(fa);
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val foldl1 = { dictFoldable : Any ->
     { f : Any ->
       { v : Any ->
         when {
          (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
            val f1 = f;
            val a = v.value0;
            val fa = v.value1;
            PS.Data.Foldable.Module.foldl.app(dictFoldable).app(f1).app(a)
              .app(fa);
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    }
  };
  @JvmField
  val foldableNonEmpty = { dictFoldable : Any ->
     PS.Data.Foldable.Module.Foldable
       .app({ dictMonoid : Any ->
            { f : Any ->
              { v : Any ->
                when {
                 (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
                   val f1 = f;
                   val a = v.value0;
                   val fa = v.value1;
                   PS.Data.Semigroup.Module.append
                     .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!
                            .app(Unit))
                     .app(f1.app(a))
                     .app(PS.Data.Foldable.Module.foldMap.app(dictFoldable)
                            .app(dictMonoid)
                            .app(f1)
                            .app(fa));
                 }
                 else -> (error("Error in Pattern Match") as Any)
               }
             }
           }
         })
       .app({ f : Any ->
            { b : Any ->
              { v : Any ->
                when {
                 (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
                   val f1 = f;
                   val b1 = b;
                   val a = v.value0;
                   val fa = v.value1;
                   PS.Data.Foldable.Module.foldl.app(dictFoldable).app(f1)
                     .app(f1.app(b1).app(a))
                     .app(fa);
                 }
                 else -> (error("Error in Pattern Match") as Any)
               }
             }
           }
         })
       .app({ f : Any ->
         { b : Any ->
           { v : Any ->
             when {
              (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
                val f1 = f;
                val b1 = b;
                val a = v.value0;
                val fa = v.value1;
                f1.app(a)
                  .app(PS.Data.Foldable.Module.foldr.app(dictFoldable).app(f1)
                         .app(b1)
                         .app(fa));
              }
              else -> (error("Error in Pattern Match") as Any)
            }
          }
        }
      })
  };
  @JvmField
  val foldableWithIndexNonEmpty = { dictFoldableWithIndex : Any ->
     PS.Data.FoldableWithIndex.Module.FoldableWithIndex
       .app({ _ : Any ->
            PS.Data.NonEmpty.Module.foldableNonEmpty
              .app((dictFoldableWithIndex as Map<String, Any>)["Foldable0"]!!
                     .app(Unit))
         })
       .app({ dictMonoid : Any ->
            { f : Any ->
              { v : Any ->
                when {
                 (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
                   val f1 = f;
                   val a = v.value0;
                   val fa = v.value1;
                   PS.Data.Semigroup.Module.append
                     .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!
                            .app(Unit))
                     .app(f1.app(PS.Data.Maybe.Module.Nothing).app(a))
                     .app(PS.Data.FoldableWithIndex.Module.foldMapWithIndex
                            .app(dictFoldableWithIndex)
                            .app(dictMonoid)
                            .app(PS.Control.Semigroupoid.Module.compose
                                   .app(
                                     PS.Control.Semigroupoid.Module.semigroupoidFn
                                   )
                                   .app(f1)
                                   .app(PS.Data.Maybe.Module.Just))
                            .app(fa));
                 }
                 else -> (error("Error in Pattern Match") as Any)
               }
             }
           }
         })
       .app({ f : Any ->
            { b : Any ->
              { v : Any ->
                when {
                 (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
                   val f1 = f;
                   val b1 = b;
                   val a = v.value0;
                   val fa = v.value1;
                   PS.Data.FoldableWithIndex.Module.foldlWithIndex
                     .app(dictFoldableWithIndex)
                     .app(PS.Control.Semigroupoid.Module.compose
                            .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                            .app(f1)
                            .app(PS.Data.Maybe.Module.Just))
                     .app(f1.app(PS.Data.Maybe.Module.Nothing).app(b1).app(a))
                     .app(fa);
                 }
                 else -> (error("Error in Pattern Match") as Any)
               }
             }
           }
         })
       .app({ f : Any ->
         { b : Any ->
           { v : Any ->
             when {
              (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
                val f1 = f;
                val b1 = b;
                val a = v.value0;
                val fa = v.value1;
                f1.app(PS.Data.Maybe.Module.Nothing).app(a)
                  .app(PS.Data.FoldableWithIndex.Module.foldrWithIndex
                         .app(dictFoldableWithIndex)
                         .app(PS.Control.Semigroupoid.Module.compose
                                .app(
                                  PS.Control.Semigroupoid.Module.semigroupoidFn)
                                .app(f1)
                                .app(PS.Data.Maybe.Module.Just))
                         .app(b1)
                         .app(fa));
              }
              else -> (error("Error in Pattern Match") as Any)
            }
          }
        }
      })
  };
  @JvmField
  val traversableNonEmpty = { dictTraversable : Any ->
     PS.Data.Traversable.Module.Traversable
       .app({ _ : Any ->
            PS.Data.NonEmpty.Module.foldableNonEmpty
              .app((dictTraversable as Map<String, Any>)["Foldable1"]!!
                     .app(Unit))
         })
       .app({ _ : Any ->
            PS.Data.NonEmpty.Module.functorNonEmpty
              .app((dictTraversable as Map<String, Any>)["Functor0"]!!.app(Unit)
           )
         })
       .app({ dictApplicative : Any ->
            { v : Any ->
              when {
               (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
                 val a = v.value0;
                 val fa = v.value1;
                 PS.Control.Apply.Module.apply
                   .app((dictApplicative as Map<String, Any>)["Apply0"]!!
                          .app(Unit))
                   .app(PS.Data.Functor.Module.map
                          .app(
                            ((dictApplicative as Map<String, Any>)["Apply0"]!!
                               .app(Unit) as Map<String, Any>)["Functor0"]!!
                              .app(Unit))
                          .app(PS.Data.NonEmpty.Module.NonEmpty)
                          .app(a))
                   .app(PS.Data.Traversable.Module.sequence.app(dictTraversable)
                          .app(dictApplicative)
                          .app(fa));
               }
               else -> (error("Error in Pattern Match") as Any)
             }
           }
         })
       .app({ dictApplicative : Any ->
         { f : Any ->
           { v : Any ->
             when {
              (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
                val f1 = f;
                val a = v.value0;
                val fa = v.value1;
                PS.Control.Apply.Module.apply
                  .app((dictApplicative as Map<String, Any>)["Apply0"]!!
                         .app(Unit))
                  .app(PS.Data.Functor.Module.map
                         .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                                 .app(Unit) as Map<String, Any>)["Functor0"]!!
                                .app(Unit))
                         .app(PS.Data.NonEmpty.Module.NonEmpty)
                         .app(f1.app(a)))
                  .app(PS.Data.Traversable.Module.traverse.app(dictTraversable)
                         .app(dictApplicative)
                         .app(f1)
                         .app(fa));
              }
              else -> (error("Error in Pattern Match") as Any)
            }
          }
        }
      })
  };
  @JvmField
  val traversableWithIndexNonEmpty = { dictTraversableWithIndex : Any ->
     PS.Data.TraversableWithIndex.Module.TraversableWithIndex
       .app({ _ : Any ->
            PS.Data.NonEmpty.Module.foldableWithIndexNonEmpty
              .app(
             (dictTraversableWithIndex as Map<String, Any>)["FoldableWithIndex1"]!!
               .app(Unit))
         })
       .app({ _ : Any ->
            PS.Data.NonEmpty.Module.functorWithIndex
              .app(
             (dictTraversableWithIndex as Map<String, Any>)["FunctorWithIndex0"]!!
               .app(Unit))
         })
       .app({ _ : Any ->
            PS.Data.NonEmpty.Module.traversableNonEmpty
              .app(
             (dictTraversableWithIndex as Map<String, Any>)["Traversable2"]!!
               .app(Unit))
         })
       .app({ dictApplicative : Any ->
         { f : Any ->
           { v : Any ->
             when {
              (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
                val f1 = f;
                val a = v.value0;
                val fa = v.value1;
                PS.Control.Apply.Module.apply
                  .app((dictApplicative as Map<String, Any>)["Apply0"]!!
                         .app(Unit))
                  .app(PS.Data.Functor.Module.map
                         .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                                 .app(Unit) as Map<String, Any>)["Functor0"]!!
                                .app(Unit))
                         .app(PS.Data.NonEmpty.Module.NonEmpty)
                         .app(f1.app(PS.Data.Maybe.Module.Nothing).app(a)))
                  .app(PS.Data.TraversableWithIndex.Module.traverseWithIndex
                         .app(dictTraversableWithIndex)
                         .app(dictApplicative)
                         .app(PS.Control.Semigroupoid.Module.compose
                                .app(
                                  PS.Control.Semigroupoid.Module.semigroupoidFn)
                                .app(f1)
                                .app(PS.Data.Maybe.Module.Just))
                         .app(fa));
              }
              else -> (error("Error in Pattern Match") as Any)
            }
          }
        }
      })
  };
  @JvmField val foldable1NonEmpty = (::__rec_foldable1NonEmpty)();
  fun __rec_foldable1NonEmpty(): Any = { dictFoldable : Any ->
     PS.Data.Semigroup.Foldable.Module.Foldable1
       .app({ _ : Any ->
            PS.Data.NonEmpty.Module.foldableNonEmpty.app(dictFoldable)
         })
       .app({ dictSemigroup : Any ->
            PS.Data.Semigroup.Foldable.Module.foldMap1
              .app(PS.Data.NonEmpty.Module.foldable1NonEmpty.app(dictFoldable))
              .app(dictSemigroup)
              .app(PS.Control.Category.Module.identity
                     .app(PS.Control.Category.Module.categoryFn))
         })
       .app({ dictSemigroup : Any ->
         { f : Any ->
           { v : Any ->
             when {
              (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
                val f1 = f;
                val a = v.value0;
                val fa = v.value1;
                PS.Data.Foldable.Module.foldl.app(dictFoldable)
                  .app({ s : Any ->
                       { a1 : Any ->
                         PS.Data.Semigroup.Module.append.app(dictSemigroup)
                           .app(s)
                           .app(f1.app(a1))
                      }
                    })
                  .app(f1.app(a))
                  .app(fa);
              }
              else -> (error("Error in Pattern Match") as Any)
            }
          }
        }
      })
  };
  @JvmField
  val eqNonEmpty = { dictEq1 : Any ->
     { dictEq : Any ->
       PS.Data.Eq.Module.Eq
         .app({ x : Any ->
           { y : Any ->
             when {
              (x is PS.Data.NonEmpty.Module._Type_NonEmpty
                      .NonEmpty)&& (y is PS.Data.NonEmpty.Module._Type_NonEmpty
                                           .NonEmpty) -> {
                val l = x.value0;
                val l1 = x.value1;
                val r = y.value0;
                val r1 = y.value1;
                PS.Data.HeytingAlgebra.Module.conj
                  .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
                  .app(PS.Data.Eq.Module.eq.app(dictEq).app(l).app(r))
                  .app(PS.Data.Eq.Module.eq1.app(dictEq1).app(dictEq).app(l1)
                         .app(r1));
              }
              else -> (error("Error in Pattern Match") as Any)
            }
          }
        })
    }
  };
  @JvmField
  val ordNonEmpty = { dictOrd1 : Any ->
     { dictOrd : Any ->
       PS.Data.Ord.Module.Ord
         .app({ _ : Any ->
              PS.Data.NonEmpty.Module.eqNonEmpty
                .app((dictOrd1 as Map<String, Any>)["Eq10"]!!.app(Unit))
                .app((dictOrd as Map<String, Any>)["Eq0"]!!.app(Unit))
           })
         .app({ x : Any ->
           { y : Any ->
             when {
              (x is PS.Data.NonEmpty.Module._Type_NonEmpty
                      .NonEmpty)&& (y is PS.Data.NonEmpty.Module._Type_NonEmpty
                                           .NonEmpty) -> {
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
                        PS.Data.Ord.Module.compare1.app(dictOrd1).app(dictOrd)
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
  val eq1NonEmpty = { dictEq1 : Any ->
     PS.Data.Eq.Module.Eq1
       .app({ dictEq : Any ->
         PS.Data.Eq.Module.eq
           .app(PS.Data.NonEmpty.Module.eqNonEmpty.app(dictEq1).app(dictEq))
      })
  };
  @JvmField
  val ord1NonEmpty = { dictOrd1 : Any ->
     PS.Data.Ord.Module.Ord1
       .app({ _ : Any ->
            PS.Data.NonEmpty.Module.eq1NonEmpty
              .app((dictOrd1 as Map<String, Any>)["Eq10"]!!.app(Unit))
         })
       .app({ dictOrd : Any ->
         PS.Data.Ord.Module.compare
           .app(PS.Data.NonEmpty.Module.ordNonEmpty.app(dictOrd1).app(dictOrd))
      })
  };
}