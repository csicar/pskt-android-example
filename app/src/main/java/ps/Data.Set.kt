@file:Suppress("UNCHECKED_CAST")
package PS.Data.Set
import Foreign.PsRuntime.app
object Module  {
  @JvmField val Set = { x : Any -> x};
  @JvmField
  val union = { dictOrd : Any ->
     { v : Any ->
       { v1 : Any ->
         when {
          else -> {
            val m1 = v;
            val m2 = v1;
            PS.Data.Set.Module.Set
              .app(PS.Data.Map.Internal.Module.union.app(dictOrd).app(m1)
                     .app(m2));
          }
        }
      }
    }
  };
  @JvmField
  val toList = { v : Any ->
     when {
      else -> {
        val m = v;
        PS.Data.Map.Internal.Module.keys.app(m);
      }
    }
  };
  @JvmField
  val toUnfoldable = { dictUnfoldable : Any ->
     PS.Control.Semigroupoid.Module.compose
       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
       .app(PS.Data.List.Module.toUnfoldable.app(dictUnfoldable))
       .app(PS.Data.Set.Module.toList)
  };
  @JvmField
  val size = { v : Any ->
     when {
      else -> {
        val m = v;
        PS.Data.Map.Internal.Module.size.app(m);
      }
    }
  };
  @JvmField
  val singleton = { a : Any ->
     PS.Data.Set.Module.Set
       .app(PS.Data.Map.Internal.Module.singleton.app(a)
              .app(PS.Data.Unit.Module.unit))
  };
  @JvmField
  val showSet = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ s : Any ->
         (("(fromFoldable " as String) + (((PS.Data.Show.Module.show
                                              .app(
                                                PS.Data.List.Types.Module.showList
                                                  .app(dictShow))
                                              .app(PS.Data.Set.Module.toList
                                                     .app(s)
        ) as String) + (")" as String)) as String))
      })
  };
  @JvmField
  val semigroupSet = { dictOrd : Any ->
     PS.Data.Semigroup.Module.Semigroup
       .app(PS.Data.Set.Module.union.app(dictOrd))
  };
  @JvmField
  val member = { dictOrd : Any ->
     { a : Any ->
       { v : Any ->
         when {
          else -> {
            val a1 = a;
            val m = v;
            PS.Data.Map.Internal.Module.member.app(dictOrd).app(a1).app(m);
          }
        }
      }
    }
  };
  @JvmField
  val isEmpty = { v : Any ->
     when {
      else -> {
        val m = v;
        PS.Data.Map.Internal.Module.isEmpty.app(m);
      }
    }
  };
  @JvmField
  val insert = { dictOrd : Any ->
     { a : Any ->
       { v : Any ->
         when {
          else -> {
            val a1 = a;
            val m = v;
            PS.Data.Set.Module.Set
              .app(PS.Data.Map.Internal.Module.insert.app(dictOrd).app(a1)
                     .app(PS.Data.Unit.Module.unit)
                     .app(m));
          }
        }
      }
    }
  };
  @JvmField
  val foldableSet = PS.Data.Foldable.Module.Foldable
                      .app({ dictMonoid : Any ->
                           { f : Any ->
                             PS.Control.Semigroupoid.Module.compose
                               .app(
                                 PS.Control.Semigroupoid.Module.semigroupoidFn)
                               .app(PS.Data.Foldable.Module.foldMap
                                      .app(
                                        PS.Data.List.Types.Module.foldableList)
                                      .app(dictMonoid)
                                      .app(f))
                               .app(PS.Data.Set.Module.toList)
                          }
                        })
                      .app({ f : Any ->
                           { x : Any ->
                             PS.Control.Semigroupoid.Module.compose
                               .app(
                                 PS.Control.Semigroupoid.Module.semigroupoidFn)
                               .app(PS.Data.Foldable.Module.foldl
                                      .app(
                                        PS.Data.List.Types.Module.foldableList)
                                      .app(f)
                                      .app(x))
                               .app(PS.Data.Set.Module.toList)
                          }
                        })
                      .app({ f : Any ->
       { x : Any ->
         PS.Control.Semigroupoid.Module.compose
           .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
           .app(PS.Data.Foldable.Module.foldr
                  .app(PS.Data.List.Types.Module.foldableList)
                  .app(f)
                  .app(x))
           .app(PS.Data.Set.Module.toList)
      }
    });
  @JvmField
  val findMin = { v : Any ->
     when {
      else -> {
        val m = v;
        PS.Data.Functor.Module.map.app(PS.Data.Maybe.Module.functorMaybe)
          .app({ v1 : Any ->
               (v1 as Map<String, Any>)["key"]!!
            })
          .app(PS.Data.Map.Internal.Module.findMin.app(m));
      }
    }
  };
  @JvmField
  val findMax = { v : Any ->
     when {
      else -> {
        val m = v;
        PS.Data.Functor.Module.map.app(PS.Data.Maybe.Module.functorMaybe)
          .app({ v1 : Any ->
               (v1 as Map<String, Any>)["key"]!!
            })
          .app(PS.Data.Map.Internal.Module.findMax.app(m));
      }
    }
  };
  @JvmField
  val filter = { dictOrd : Any ->
     { f : Any ->
       { v : Any ->
         when {
          else -> {
            val f1 = f;
            val s = v;
            PS.Data.Set.Module.Set
              .app(PS.Data.Map.Internal.Module.filterWithKey.app(dictOrd)
                     .app({ k : Any ->
                          { v1 : Any ->
                            f1.app(k)
                         }
                       })
                     .app(s));
          }
        }
      }
    }
  };
  @JvmField
  val eqSet = { dictEq : Any ->
     PS.Data.Eq.Module.Eq
       .app({ v : Any ->
         { v1 : Any ->
           when {
            else -> {
              val m1 = v;
              val m2 = v1;
              PS.Data.Eq.Module.eq
                .app(PS.Data.Map.Internal.Module.eqMap.app(dictEq)
                       .app(PS.Data.Eq.Module.eqUnit))
                .app(m1)
                .app(m2);
            }
          }
        }
      })
  };
  @JvmField
  val ordSet = { dictOrd : Any ->
     PS.Data.Ord.Module.Ord
       .app({ _ : Any ->
            PS.Data.Set.Module.eqSet
              .app((dictOrd as Map<String, Any>)["Eq0"]!!.app(Unit))
         })
       .app({ s1 : Any ->
         { s2 : Any ->
           PS.Data.Ord.Module.compare
             .app(PS.Data.List.Types.Module.ordList.app(dictOrd))
             .app(PS.Data.Set.Module.toList.app(s1))
             .app(PS.Data.Set.Module.toList.app(s2))
        }
      })
  };
  @JvmField
  val eq1Set = PS.Data.Eq.Module.Eq1
                 .app({ dictEq : Any ->
       PS.Data.Eq.Module.eq.app(PS.Data.Set.Module.eqSet.app(dictEq))
    });
  @JvmField
  val ord1Set = PS.Data.Ord.Module.Ord1
                  .app({ _ : Any ->
                       PS.Data.Set.Module.eq1Set
                    })
                  .app({ dictOrd : Any ->
       PS.Data.Ord.Module.compare.app(PS.Data.Set.Module.ordSet.app(dictOrd))
    });
  @JvmField
  val empty = PS.Data.Set.Module.Set.app(PS.Data.Map.Internal.Module.empty);
  @JvmField
  val fromFoldable = { dictFoldable : Any ->
     { dictOrd : Any ->
       PS.Data.Foldable.Module.foldl.app(dictFoldable)
         .app({ m : Any ->
              { a : Any ->
                PS.Data.Set.Module.insert.app(dictOrd).app(a).app(m)
             }
           })
         .app(PS.Data.Set.Module.empty)
    }
  };
  @JvmField
  val intersection = { dictOrd : Any ->
     { s1 : Any ->
       { s2 : Any ->
         object   {
             val toArray = PS.Control.Semigroupoid.Module.compose
                             .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                             .app(PS.Data.Array.Module.fromFoldable
                                    .app(PS.Data.List.Types.Module.foldableList)
                             )
                             .app(PS.Data.Set.Module.toList);
             val rs = toArray.app(s2);
             val rl = PS.Data.Array.Module.length.app(rs);
             val ls = toArray.app(s1);
             val ll = PS.Data.Array.Module.length.app(ls);
             val intersect = { acc : Any ->
                object   {
                    val go = PS.Partial.Unsafe.Module.unsafePartial
                               .app({ dictPartial : Any ->
                         { l : Any ->
                           { r : Any ->
                             when {
                              (PS.Data.HeytingAlgebra.Module.conj
                                 .app(
                                   PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean
                                 )
                                 .app(PS.Data.Ord.Module.lessThan
                                        .app(PS.Data.Ord.Module.ordInt)
                                        .app(l)
                                        .app(ll))
                                 .app(PS.Data.Ord.Module.lessThan
                                        .app(PS.Data.Ord.Module.ordInt)
                                        .app(r)
                                        .app(rl)) == true) -> {
                                object   {
                                    val v = PS.Data.Ord.Module.compare
                                              .app(dictOrd)
                                              .app(
                                                PS.Data.Array.Module.unsafeIndex
                                                  .app(Unit)
                                                  .app(ls)
                                                  .app(l))
                                              .app(
                                      PS.Data.Array.Module.unsafeIndex.app(Unit)
                                        .app(rs)
                                        .app(r));
                                  }
                                  .run({
                                    val v = this.v;
                                    when {
                                      (v is PS.Data.Ordering.Module._Type_Ordering
                                              .EQ) -> {
                                        PS.Control.Bind.Module.bind
                                          .app(
                                            PS.Control.Monad.ST.Internal.Module.bindST
                                          )
                                          .app(PS.Data.Array.ST.Module.push
                                                 .app(
                                                   PS.Data.Array.Module.unsafeIndex
                                                     .app(Unit)
                                                     .app(ls)
                                                     .app(l))
                                                 .app(acc))
                                          .app({ v1 : Any ->
                                             PS.Data.Function.Module.apply
                                               .app(
                                                 PS.Control.Applicative.Module.pure
                                                   .app(
                                                   PS.Control.Monad.ST.Internal.Module.applicativeST
                                                 ))
                                               .app(
                                              PS.Control.Monad.Rec.Class.Module.Loop
                                                .app(mapOf(
                                                  ("a" to PS.Data.Semiring.Module.add
                                                            .app(
                                                              PS.Data.Semiring.Module.semiringInt
                                                            )
                                                            .app(l)
                                                            .app(1)),  
                                                  ("b" to PS.Data.Semiring.Module.add
                                                            .app(
                                                              PS.Data.Semiring.Module.semiringInt
                                                            )
                                                            .app(r)
                                                            .app(1)))))
                                          });
                                      }
                                      (v is PS.Data.Ordering.Module._Type_Ordering
                                              .LT) -> {
                                        PS.Data.Function.Module.apply
                                          .app(
                                            PS.Control.Applicative.Module.pure
                                              .app(
                                              PS.Control.Monad.ST.Internal.Module.applicativeST
                                            ))
                                          .app(
                                          PS.Control.Monad.Rec.Class.Module.Loop
                                            .app(mapOf(
                                              ("a" to PS.Data.Semiring.Module.add
                                                        .app(
                                                          PS.Data.Semiring.Module.semiringInt
                                                        )
                                                        .app(l)
                                                        .app(1)),  ("b" to r)))
                                        );
                                      }
                                      (v is PS.Data.Ordering.Module._Type_Ordering
                                              .GT) -> {
                                        PS.Data.Function.Module.apply
                                          .app(
                                            PS.Control.Applicative.Module.pure
                                              .app(
                                              PS.Control.Monad.ST.Internal.Module.applicativeST
                                            ))
                                          .app(
                                          PS.Control.Monad.Rec.Class.Module.Loop
                                            .app(mapOf(("a" to l),  
                                              ("b" to PS.Data.Semiring.Module.add
                                                        .app(
                                                          PS.Data.Semiring.Module.semiringInt
                                                        )
                                                        .app(r)
                                                        .app(1)))));
                                      }
                                      else -> (error("Error in Pattern Match"
                                      ) as Any)
                                    };
                                  });
                              }
                              else -> {
                                PS.Data.Function.Module.apply
                                  .app(PS.Control.Applicative.Module.pure
                                         .app(
                                      PS.Control.Monad.ST.Internal.Module.applicativeST
                                    ))
                                  .app(PS.Control.Monad.Rec.Class.Module.Done
                                         .app(acc));
                              }
                            }
                          }
                        }
                      });
                  }
                  .run({
                   val go = this.go;
                   PS.Control.Monad.Rec.Class.Module.tailRecM2
                     .app(PS.Control.Monad.ST.Internal.Module.monadRecST)
                     .app(go)
                     .app(0)
                     .app(0);
                 })
             };
           }
           .run({
            val toArray = this.toArray;
            val rs = this.rs;
            val rl = this.rl;
            val ls = this.ls;
            val ll = this.ll;
            val intersect = this.intersect;
            PS.Data.Set.Module.fromFoldable
              .app(PS.Data.Foldable.Module.foldableArray)
              .app(dictOrd)
              .app(PS.Control.Monad.ST.Internal.Module.run
                     .app(PS.Control.Bind.Module.bind
                            .app(PS.Control.Monad.ST.Internal.Module.bindST)
                            .app(PS.Control.Bind.Module.bind
                                   .app(
                                     PS.Control.Monad.ST.Internal.Module.bindST)
                                   .app(PS.Data.Array.ST.Module.empty)
                                   .app(intersect))
                            .app(PS.Data.Array.ST.Module.unsafeFreeze)));
          })
      }
    }
  };
  @JvmField
  val map = { dictOrd : Any ->
     { f : Any ->
       PS.Data.Foldable.Module.foldl.app(PS.Data.Set.Module.foldableSet)
         .app({ m : Any ->
              { a : Any ->
                PS.Data.Set.Module.insert.app(dictOrd).app(f.app(a)).app(m)
             }
           })
         .app(PS.Data.Set.Module.empty)
    }
  };
  @JvmField
  val mapMaybe = { dictOrd : Any ->
     { f : Any ->
       PS.Data.Foldable.Module.foldr.app(PS.Data.Set.Module.foldableSet)
         .app({ a : Any ->
              { acc : Any ->
                PS.Data.Maybe.Module.maybe.app(acc)
                  .app({ b : Any ->
                       PS.Data.Set.Module.insert.app(dictOrd).app(b).app(acc)
                    })
                  .app(f.app(a))
             }
           })
         .app(PS.Data.Set.Module.empty)
    }
  };
  @JvmField
  val monoidSet = { dictOrd : Any ->
     PS.Data.Monoid.Module.Monoid
       .app({ _ : Any ->
            PS.Data.Set.Module.semigroupSet.app(dictOrd)
         })
       .app(PS.Data.Set.Module.empty)
  };
  @JvmField
  val unions = { dictFoldable : Any ->
     { dictOrd : Any ->
       PS.Data.Foldable.Module.foldl.app(dictFoldable)
         .app(PS.Data.Set.Module.union.app(dictOrd))
         .app(PS.Data.Set.Module.empty)
    }
  };
  @JvmField
  val delete = { dictOrd : Any ->
     { a : Any ->
       { v : Any ->
         when {
          else -> {
            val a1 = a;
            val m = v;
            PS.Data.Set.Module.Set
              .app(PS.Data.Map.Internal.Module.delete.app(dictOrd).app(a1)
                     .app(m));
          }
        }
      }
    }
  };
  @JvmField
  val difference = { dictOrd : Any ->
     { s1 : Any ->
       { s2 : Any ->
         PS.Data.Foldable.Module.foldl
           .app(PS.Data.List.Types.Module.foldableList)
           .app(PS.Data.Function.Module.flip
                  .app(PS.Data.Set.Module.delete.app(dictOrd)))
           .app(s1)
           .app(PS.Data.Set.Module.toList.app(s2))
      }
    }
  };
  @JvmField
  val subset = { dictOrd : Any ->
     { s1 : Any ->
       { s2 : Any ->
         PS.Data.Function.Module.apply.app(PS.Data.Set.Module.isEmpty)
           .app(PS.Data.Set.Module.difference.app(dictOrd).app(s1).app(s2))
      }
    }
  };
  @JvmField
  val properSubset = { dictOrd : Any ->
     { s1 : Any ->
       { s2 : Any ->
         PS.Data.HeytingAlgebra.Module.conj
           .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
           .app(PS.Data.Set.Module.subset.app(dictOrd).app(s1).app(s2))
           .app(PS.Data.Eq.Module.notEq
                  .app(PS.Data.Set.Module.eqSet
                         .app((dictOrd as Map<String, Any>)["Eq0"]!!.app(Unit)))
                  .app(s1)
                  .app(s2))
      }
    }
  };
  @JvmField
  val checkValid = { v : Any ->
     when {
      else -> {
        val m = v;
        PS.Data.Map.Internal.Module.checkValid.app(m);
      }
    }
  };
}