@file:Suppress("UNCHECKED_CAST")
package PS.Data.List.Types
import Foreign.PsRuntime.app
object Module  {
  sealed class _Type_List ()  {
    object Nil : _Type_List() {};
    data class Cons (val value0 : Any,  val value1 : Any) : _Type_List() {};
  };
  val Nil = _Type_List.Nil;
  val Cons = { value0 : Any ->
     { value1 : Any ->
       _Type_List.Cons(value0,  value1)
    }
  };
  @JvmField val NonEmptyList = { x : Any -> x};
  @JvmField
  val toList = { v : Any ->
     when {
      (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
        val x = v.value0;
        val xs = v.value1;
        PS.Data.List.Types.Module.Cons.app(x).app(xs);
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val newtypeNonEmptyList = PS.Data.Newtype.Module.Newtype
                              .app({ n : Any ->
                                   when {
                                    else -> {
                                      val a = n;
                                      a;
                                    }
                                  }
                                })
                              .app(PS.Data.List.Types.Module.NonEmptyList);
  @JvmField
  val nelCons = { a : Any ->
     { v : Any ->
       when {
        (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
          val a1 = a;
          val b = v.value0;
          val bs = v.value1;
          PS.Data.List.Types.Module.NonEmptyList
            .app(PS.Data.NonEmpty.Module.NonEmpty.app(a1)
                   .app(PS.Data.List.Types.Module.Cons.app(b).app(bs)));
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val listMap = { f : Any ->
     object   {
         val chunkedRevMap = (::__rec_chunkedRevMap)();
         fun __rec_chunkedRevMap(): Any = { chunksAcc : Any ->
            { v : Any ->
              when {
               (v is PS.Data.List.Types.Module._Type_List
                       .Cons)&& (v
                                   .value1 is PS.Data.List.Types.Module._Type_List
                                                .Cons)&& (v
                                                            .value1
                                                            .value1 is PS.Data.List.Types.Module._Type_List
                                                                         .Cons) -> {
                 val chunksAcc1 = chunksAcc;
                 val chunk = v;
                 val x1 = v.value0;
                 val x2 = v.value1.value0;
                 val x3 = v.value1.value1.value0;
                 val xs = v.value1.value1.value1;
                 __rec_chunkedRevMap()
                   .app(PS.Data.List.Types.Module.Cons.app(chunk)
                          .app(chunksAcc1))
                   .app(xs);
               }
               else -> {
                 val chunksAcc1 = chunksAcc;
                 val xs = v;
                 object   {
                     val unrolledMap = { v1 : Any ->
                        when {
                         (v1 is PS.Data.List.Types.Module._Type_List
                                  .Cons)&& (v1
                                              .value1 is PS.Data.List.Types.Module._Type_List
                                                           .Cons)&& (v1
                                                                       .value1
                                                                       .value1 is PS.Data.List.Types.Module._Type_List
                                                                                    .Nil) -> {
                           val x1 = v1.value0;
                           val x2 = v1.value1.value0;
                           PS.Data.List.Types.Module.Cons.app(f.app(x1))
                             .app(PS.Data.List.Types.Module.Cons.app(f.app(x2))
                                    .app(PS.Data.List.Types.Module.Nil));
                         }
                         (v1 is PS.Data.List.Types.Module._Type_List
                                  .Cons)&& (v1
                                              .value1 is PS.Data.List.Types.Module._Type_List
                                                           .Nil) -> {
                           val x1 = v1.value0;
                           PS.Data.List.Types.Module.Cons.app(f.app(x1))
                             .app(PS.Data.List.Types.Module.Nil);
                         }
                         else -> {
                           PS.Data.List.Types.Module.Nil;
                         }
                       }
                     };
                     val reverseUnrolledMap = (::__rec_reverseUnrolledMap)();
                     fun __rec_reverseUnrolledMap(): Any = { v1 : Any ->
                        { acc : Any ->
                          when {
                           (v1 is PS.Data.List.Types.Module._Type_List
                                    .Cons)&& (v1
                                                .value0 is PS.Data.List.Types.Module._Type_List
                                                             .Cons)&& (v1
                                                                         .value0
                                                                         .value1 is PS.Data.List.Types.Module._Type_List
                                                                                      .Cons)&&
                           (v1
                              .value0
                              .value1
                              .value1 is PS.Data.List.Types.Module._Type_List
                                           .Cons) -> {
                             val x1 = v1.value0.value0;
                             val x2 = v1.value0.value1.value0;
                             val x3 = v1.value0.value1.value1.value0;
                             val cs = v1.value1;
                             val acc1 = acc;
                             __rec_reverseUnrolledMap().app(cs)
                               .app(PS.Data.List.Types.Module.Cons
                                      .app(f.app(x1))
                                      .app(PS.Data.List.Types.Module.Cons
                                             .app(f.app(x2))
                                             .app(PS.Data.List.Types.Module.Cons
                                                    .app(f.app(x3))
                                                    .app(acc1))));
                           }
                           else -> {
                             val acc1 = acc;
                             acc1;
                           }
                         }
                       }
                     };
                   }
                   .run({
                     val unrolledMap = this.unrolledMap;
                     val reverseUnrolledMap = this.reverseUnrolledMap;
                     PS.Data.Function.Module.apply
                       .app(reverseUnrolledMap.app(chunksAcc1))
                       .app(unrolledMap.app(xs));
                   });
               }
             }
           }
         };
       }
       .run({
        val chunkedRevMap = this.chunkedRevMap;
        chunkedRevMap.app(PS.Data.List.Types.Module.Nil);
      })
  };
  @JvmField
  val functorList = PS.Data.Functor.Module.Functor
                      .app(PS.Data.List.Types.Module.listMap);
  @JvmField
  val functorNonEmptyList = PS.Data.NonEmpty.Module.functorNonEmpty
                              .app(PS.Data.List.Types.Module.functorList);
  @JvmField val foldableList = (::__rec_foldableList)();
  fun __rec_foldableList(): Any = PS.Data.Foldable.Module.Foldable
                                    .app({ dictMonoid : Any ->
                                         { f : Any ->
                                           PS.Data.Foldable.Module.foldl
                                             .app(
                                               PS.Data.List.Types.Module.foldableList
                                             )
                                             .app({ acc : Any ->
                                                  PS.Control.Semigroupoid.Module.compose
                                                    .app(
                                                      PS.Control.Semigroupoid.Module.semigroupoidFn
                                                    )
                                                    .app(
                                                      PS.Data.Semigroup.Module.append
                                                        .app(
                                                          (dictMonoid as Map<String, Any>)["Semigroup0"]!!
                                                            .app(Unit))
                                                        .app(acc))
                                                    .app(f)
                                               })
                                             .app(PS.Data.Monoid.Module.mempty
                                                    .app(dictMonoid))
                                        }
                                      })
                                    .app({ f : Any ->
                                         object   {
                                             val go = (::__rec_go)();
                                             fun __rec_go(): Any = { b : Any ->
                                                { v : Any ->
                                                  when {
                                                   (v is PS.Data.List.Types.Module._Type_List
                                                           .Nil) -> {
                                                     b;
                                                   }
                                                   (v is PS.Data.List.Types.Module._Type_List
                                                           .Cons) -> {
                                                     val a = v.value0;
                                                     val _as = v.value1;
                                                     __rec_go()
                                                       .app(f.app(b).app(a))
                                                       .app(_as);
                                                   }
                                                   else -> (error(
                                                     "Error in Pattern Match"
                                                   ) as Any)
                                                 }
                                               }
                                             };
                                           }
                                           .run({
                                            val go = this.go;
                                            go;
                                          })
                                      })
                                    .app({ f : Any ->
       { b : Any ->
         object   {
             val rev = PS.Data.Foldable.Module.foldl
                         .app(PS.Data.List.Types.Module.foldableList)
                         .app(PS.Data.Function.Module.flip
                                .app(PS.Data.List.Types.Module.Cons))
                         .app(PS.Data.List.Types.Module.Nil);
           }
           .run({
            val rev = this.rev;
            PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Data.Foldable.Module.foldl
                     .app(PS.Data.List.Types.Module.foldableList)
                     .app(PS.Data.Function.Module.flip.app(f))
                     .app(b))
              .app(rev);
          })
      }
    });
  @JvmField
  val foldableNonEmptyList = PS.Data.NonEmpty.Module.foldableNonEmpty
                               .app(PS.Data.List.Types.Module.foldableList);
  @JvmField val foldableWithIndexList = (::__rec_foldableWithIndexList)();
  fun __rec_foldableWithIndexList(): Any = PS.Data.FoldableWithIndex.Module.FoldableWithIndex
                                             .app({ _ : Any ->
                                                  PS.Data.List.Types.Module.foldableList
                                               })
                                             .app({ dictMonoid : Any ->
                                                  { f : Any ->
                                                    PS.Data.FoldableWithIndex.Module.foldlWithIndex
                                                      .app(
                                                        PS.Data.List.Types.Module.foldableWithIndexList
                                                      )
                                                      .app({ i : Any ->
                                                           { acc : Any ->
                                                             PS.Control.Semigroupoid.Module.compose
                                                               .app(
                                                                 PS.Control.Semigroupoid.Module.semigroupoidFn
                                                               )
                                                               .app(
                                                                 PS.Data.Semigroup.Module.append
                                                                   .app(
                                                                     (dictMonoid as Map<String, Any>)["Semigroup0"]!!
                                                                       .app(Unit
                                                                     ))
                                                                   .app(acc))
                                                               .app(f.app(i))
                                                          }
                                                        })
                                                      .app(
                                                     PS.Data.Monoid.Module.mempty
                                                       .app(dictMonoid))
                                                 }
                                               })
                                             .app({ f : Any ->
                                                  { acc : Any ->
                                                    PS.Control.Semigroupoid.Module.compose
                                                      .app(
                                                        PS.Control.Semigroupoid.Module.semigroupoidFn
                                                      )
                                                      .app(
                                                        PS.Data.Tuple.Module.snd
                                                      )
                                                      .app(
                                                     PS.Data.Foldable.Module.foldl
                                                       .app(
                                                         PS.Data.List.Types.Module.foldableList
                                                       )
                                                       .app({ v : Any ->
                                                            when {
                                                             (v is PS.Data.Tuple.Module._Type_Tuple
                                                                     .Tuple) -> {
                                                               val i = v.value0;
                                                               val b = v.value1;
                                                               { a : Any ->
                                                                  PS.Data.Tuple.Module.Tuple
                                                                    .app(
                                                                      PS.Data.Semiring.Module.add
                                                                        .app(
                                                                          PS.Data.Semiring.Module.semiringInt
                                                                        )
                                                                        .app(i)
                                                                        .app(1))
                                                                    .app(f
                                                                           .app(
                                                                             i)
                                                                           .app(
                                                                             b)
                                                                           .app(
                                                                     a))
                                                               };
                                                             }
                                                             else -> (error(
                                                               "Error in Pattern Match"
                                                             ) as Any)
                                                           }
                                                         })
                                                       .app(
                                                       PS.Data.Tuple.Module.Tuple
                                                         .app(0)
                                                         .app(acc)))
                                                 }
                                               })
                                             .app({ f : Any ->
       { b : Any ->
         { xs : Any ->
           object   {
               val v = object   {
                           val rev = PS.Data.Foldable.Module.foldl
                                       .app(
                                         PS.Data.List.Types.Module.foldableList)
                                       .app({ v1 : Any ->
                                when {
                                 (v1 is PS.Data.Tuple.Module._Type_Tuple
                                          .Tuple) -> {
                                   val i = v1.value0;
                                   val acc = v1.value1;
                                   { a : Any ->
                                      PS.Data.Tuple.Module.Tuple
                                        .app(PS.Data.Semiring.Module.add
                                               .app(
                                                 PS.Data.Semiring.Module.semiringInt
                                               )
                                               .app(i)
                                               .app(1))
                                        .app(PS.Data.List.Types.Module.Cons
                                               .app(a)
                                               .app(acc))
                                   };
                                 }
                                 else -> (error("Error in Pattern Match"
                                 ) as Any)
                               }
                             });
                         }
                         .run({
                   val rev = this.rev;
                   rev
                     .app(PS.Data.Tuple.Module.Tuple.app(0)
                            .app(PS.Data.List.Types.Module.Nil))
                     .app(xs);
                 });
             }
             .run({
              val v = this.v;
              when {
                (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                  val len = v.value0;
                  val revList = v.value1;
                  PS.Data.Function.Module.apply.app(PS.Data.Tuple.Module.snd)
                    .app(PS.Data.Foldable.Module.foldl
                           .app(PS.Data.List.Types.Module.foldableList)
                           .app({ v1 : Any ->
                                when {
                                 (v1 is PS.Data.Tuple.Module._Type_Tuple
                                          .Tuple) -> {
                                   val i = v1.value0;
                                   val b_tick = v1.value1;
                                   { a : Any ->
                                      PS.Data.Tuple.Module.Tuple
                                        .app(PS.Data.Ring.Module.sub
                                               .app(PS.Data.Ring.Module.ringInt)
                                               .app(i)
                                               .app(1))
                                        .app(f
                                               .app(PS.Data.Ring.Module.sub
                                                      .app(
                                                        PS.Data.Ring.Module.ringInt
                                                      )
                                                      .app(i)
                                                      .app(1))
                                               .app(a)
                                               .app(b_tick))
                                   };
                                 }
                                 else -> (error("Error in Pattern Match"
                                 ) as Any)
                               }
                             })
                           .app(PS.Data.Tuple.Module.Tuple.app(len).app(b))
                           .app(revList));
                }
                else -> (error("Error in Pattern Match") as Any)
              };
            })
        }
      }
    });
  @JvmField
  val foldableWithIndexNonEmptyList = PS.Data.FoldableWithIndex.Module.FoldableWithIndex
                                        .app({ _ : Any ->
                                             PS.Data.List.Types.Module.foldableNonEmptyList
                                          })
                                        .app({ dictMonoid : Any ->
                                             { f : Any ->
                                               { v : Any ->
                                                 when {
                                                  else -> {
                                                    val f1 = f;
                                                    val ne = v;
                                                    PS.Data.FoldableWithIndex.Module.foldMapWithIndex
                                                      .app(
                                                        PS.Data.NonEmpty.Module.foldableWithIndexNonEmpty
                                                          .app(
                                                          PS.Data.List.Types.Module.foldableWithIndexList
                                                        ))
                                                      .app(dictMonoid)
                                                      .app(
                                                        PS.Control.Semigroupoid.Module.compose
                                                          .app(
                                                            PS.Control.Semigroupoid.Module.semigroupoidFn
                                                          )
                                                          .app(f1)
                                                          .app(
                                                          PS.Data.Maybe.Module.maybe
                                                            .app(0)
                                                            .app(
                                                            PS.Data.Semiring.Module.add
                                                              .app(
                                                                PS.Data.Semiring.Module.semiringInt
                                                              )
                                                              .app(1))))
                                                      .app(ne);
                                                  }
                                                }
                                              }
                                            }
                                          })
                                        .app({ f : Any ->
                                             { b : Any ->
                                               { v : Any ->
                                                 when {
                                                  else -> {
                                                    val f1 = f;
                                                    val b1 = b;
                                                    val ne = v;
                                                    PS.Data.FoldableWithIndex.Module.foldlWithIndex
                                                      .app(
                                                        PS.Data.NonEmpty.Module.foldableWithIndexNonEmpty
                                                          .app(
                                                          PS.Data.List.Types.Module.foldableWithIndexList
                                                        ))
                                                      .app(
                                                        PS.Control.Semigroupoid.Module.compose
                                                          .app(
                                                            PS.Control.Semigroupoid.Module.semigroupoidFn
                                                          )
                                                          .app(f1)
                                                          .app(
                                                          PS.Data.Maybe.Module.maybe
                                                            .app(0)
                                                            .app(
                                                            PS.Data.Semiring.Module.add
                                                              .app(
                                                                PS.Data.Semiring.Module.semiringInt
                                                              )
                                                              .app(1))))
                                                      .app(b1)
                                                      .app(ne);
                                                  }
                                                }
                                              }
                                            }
                                          })
                                        .app({ f : Any ->
       { b : Any ->
         { v : Any ->
           when {
            else -> {
              val f1 = f;
              val b1 = b;
              val ne = v;
              PS.Data.FoldableWithIndex.Module.foldrWithIndex
                .app(PS.Data.NonEmpty.Module.foldableWithIndexNonEmpty
                       .app(PS.Data.List.Types.Module.foldableWithIndexList))
                .app(PS.Control.Semigroupoid.Module.compose
                       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                       .app(f1)
                       .app(PS.Data.Maybe.Module.maybe.app(0)
                              .app(PS.Data.Semiring.Module.add
                                     .app(PS.Data.Semiring.Module.semiringInt)
                                     .app(1))))
                .app(b1)
                .app(ne);
            }
          }
        }
      }
    });
  @JvmField
  val functorWithIndexList = PS.Data.FunctorWithIndex.Module.FunctorWithIndex
                               .app({ _ : Any ->
                                    PS.Data.List.Types.Module.functorList
                                 })
                               .app({ f : Any ->
       PS.Data.FoldableWithIndex.Module.foldrWithIndex
         .app(PS.Data.List.Types.Module.foldableWithIndexList)
         .app({ i : Any ->
              { x : Any ->
                { acc : Any ->
                  PS.Data.List.Types.Module.Cons.app(f.app(i).app(x)).app(acc)
               }
             }
           })
         .app(PS.Data.List.Types.Module.Nil)
    });
  @JvmField
  val functorWithIndexNonEmptyList = PS.Data.FunctorWithIndex.Module.FunctorWithIndex
                                       .app({ _ : Any ->
                                            PS.Data.List.Types.Module.functorNonEmptyList
                                         })
                                       .app({ fn : Any ->
       { v : Any ->
         when {
          else -> {
            val fn1 = fn;
            val ne = v;
            PS.Data.Function.Module.apply
              .app(PS.Data.List.Types.Module.NonEmptyList)
              .app(PS.Data.FunctorWithIndex.Module.mapWithIndex
                     .app(PS.Data.NonEmpty.Module.functorWithIndex
                            .app(PS.Data.List.Types.Module.functorWithIndexList)
                     )
                     .app(PS.Control.Semigroupoid.Module.compose
                            .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                            .app(fn1)
                            .app(PS.Data.Maybe.Module.maybe.app(0)
                                   .app(PS.Data.Semiring.Module.add
                                          .app(
                                            PS.Data.Semiring.Module.semiringInt)
                                          .app(1))))
                     .app(ne));
          }
        }
      }
    });
  @JvmField
  val semigroupList = PS.Data.Semigroup.Module.Semigroup
                        .app({ xs : Any ->
       { ys : Any ->
         PS.Data.Foldable.Module.foldr
           .app(PS.Data.List.Types.Module.foldableList)
           .app(PS.Data.List.Types.Module.Cons)
           .app(ys)
           .app(xs)
      }
    });
  @JvmField
  val monoidList = PS.Data.Monoid.Module.Monoid
                     .app({ _ : Any ->
                          PS.Data.List.Types.Module.semigroupList
                       })
                     .app(PS.Data.List.Types.Module.Nil);
  @JvmField
  val semigroupNonEmptyList = PS.Data.Semigroup.Module.Semigroup
                                .app({ v : Any ->
       { as_tick : Any ->
         when {
          (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
            val a = v.value0;
            val _as = v.value1;
            val as_tick1 = as_tick;
            PS.Data.List.Types.Module.NonEmptyList
              .app(PS.Data.NonEmpty.Module.NonEmpty.app(a)
                     .app(PS.Data.Semigroup.Module.append
                            .app(PS.Data.List.Types.Module.semigroupList)
                            .app(_as)
                            .app(PS.Data.List.Types.Module.toList.app(as_tick1))
              ));
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val showList = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ v : Any ->
         when {
          (v is PS.Data.List.Types.Module._Type_List.Nil) -> {
            "Nil";
          }
          else -> {
            val xs = v;
            (("(" as String) + (((PS.Data.Foldable.Module.intercalate
                                    .app(PS.Data.List.Types.Module.foldableList)
                                    .app(PS.Data.Monoid.Module.monoidString)
                                    .app(" : ")
                                    .app(PS.Data.Functor.Module.map
                                           .app(
                                             PS.Data.List.Types.Module.functorList
                                           )
                                           .app(PS.Data.Show.Module.show
                                                  .app(dictShow))
                                           .app(xs)
            ) as String) + (" : Nil)" as String)) as String));
          }
        }
      })
  };
  @JvmField
  val showNonEmptyList = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ v : Any ->
         when {
          else -> {
            val nel = v;
            (("(NonEmptyList " as String) + (((PS.Data.Show.Module.show
                                                 .app(
                                                   PS.Data.NonEmpty.Module.showNonEmpty
                                                     .app(dictShow)
                                                     .app(
                                                     PS.Data.List.Types.Module.showList
                                                       .app(dictShow)))
                                                 .app(nel
            ) as String) + (")" as String)) as String));
          }
        }
      })
  };
  @JvmField val traversableList = (::__rec_traversableList)();
  fun __rec_traversableList(): Any = PS.Data.Traversable.Module.Traversable
                                       .app({ _ : Any ->
                                            PS.Data.List.Types.Module.foldableList
                                         })
                                       .app({ _ : Any ->
                                            PS.Data.List.Types.Module.functorList
                                         })
                                       .app({ dictApplicative : Any ->
                                            PS.Data.Traversable.Module.traverse
                                              .app(
                                                PS.Data.List.Types.Module.traversableList
                                              )
                                              .app(dictApplicative)
                                              .app(
                                             PS.Control.Category.Module.identity
                                               .app(
                                               PS.Control.Category.Module.categoryFn
                                             ))
                                         })
                                       .app({ dictApplicative : Any ->
       { f : Any ->
         PS.Control.Semigroupoid.Module.compose
           .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
           .app(PS.Data.Functor.Module.map
                  .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                          .app(Unit) as Map<String, Any>)["Functor0"]!!
                         .app(Unit))
                  .app(PS.Data.Foldable.Module.foldl
                         .app(PS.Data.List.Types.Module.foldableList)
                         .app(PS.Data.Function.Module.flip
                                .app(PS.Data.List.Types.Module.Cons))
                         .app(PS.Data.List.Types.Module.Nil)))
           .app(PS.Data.Foldable.Module.foldl
                  .app(PS.Data.List.Types.Module.foldableList)
                  .app({ acc : Any ->
                       PS.Control.Semigroupoid.Module.compose
                         .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                         .app(PS.Control.Apply.Module.lift2
                                .app(
                                  (dictApplicative as Map<String, Any>)["Apply0"]!!
                                    .app(Unit))
                                .app(PS.Data.Function.Module.flip
                                       .app(PS.Data.List.Types.Module.Cons))
                                .app(acc))
                         .app(f)
                    })
                  .app(PS.Control.Applicative.Module.pure.app(dictApplicative)
                         .app(PS.Data.List.Types.Module.Nil)))
      }
    });
  @JvmField
  val traversableNonEmptyList = PS.Data.NonEmpty.Module.traversableNonEmpty
                                  .app(PS.Data.List.Types.Module.traversableList
  );
  @JvmField
  val traversableWithIndexList = PS.Data.TraversableWithIndex.Module.TraversableWithIndex
                                   .app({ _ : Any ->
                                        PS.Data.List.Types.Module.foldableWithIndexList
                                     })
                                   .app({ _ : Any ->
                                        PS.Data.List.Types.Module.functorWithIndexList
                                     })
                                   .app({ _ : Any ->
                                        PS.Data.List.Types.Module.traversableList
                                     })
                                   .app({ dictApplicative : Any ->
       { f : Any ->
         object   {
             val rev = PS.Data.Foldable.Module.foldl
                         .app(PS.Data.List.Types.Module.foldableList)
                         .app(PS.Data.Function.Module.flip
                                .app(PS.Data.List.Types.Module.Cons))
                         .app(PS.Data.List.Types.Module.Nil);
           }
           .run({
            val rev = this.rev;
            PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Data.Functor.Module.map
                     .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                             .app(Unit) as Map<String, Any>)["Functor0"]!!
                            .app(Unit))
                     .app(rev))
              .app(PS.Data.FoldableWithIndex.Module.foldlWithIndex
                     .app(PS.Data.List.Types.Module.foldableWithIndexList)
                     .app({ i : Any ->
                          { acc : Any ->
                            PS.Control.Semigroupoid.Module.compose
                              .app(PS.Control.Semigroupoid.Module.semigroupoidFn
                              )
                              .app(PS.Control.Apply.Module.lift2
                                     .app(
                                       (dictApplicative as Map<String, Any>)["Apply0"]!!
                                         .app(Unit))
                                     .app(PS.Data.Function.Module.flip
                                            .app(PS.Data.List.Types.Module.Cons)
                                     )
                                     .app(acc))
                              .app(f.app(i))
                         }
                       })
                     .app(PS.Control.Applicative.Module.pure
                            .app(dictApplicative)
                            .app(PS.Data.List.Types.Module.Nil)));
          })
      }
    });
  @JvmField
  val traversableWithIndexNonEmptyList = PS.Data.TraversableWithIndex.Module.TraversableWithIndex
                                           .app({ _ : Any ->
                                                PS.Data.List.Types.Module.foldableWithIndexNonEmptyList
                                             })
                                           .app({ _ : Any ->
                                                PS.Data.List.Types.Module.functorWithIndexNonEmptyList
                                             })
                                           .app({ _ : Any ->
                                                PS.Data.List.Types.Module.traversableNonEmptyList
                                             })
                                           .app({ dictApplicative : Any ->
       { f : Any ->
         { v : Any ->
           when {
            else -> {
              val f1 = f;
              val ne = v;
              PS.Data.Functor.Module.map
                .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                        .app(Unit) as Map<String, Any>)["Functor0"]!!
                       .app(Unit))
                .app(PS.Data.List.Types.Module.NonEmptyList)
                .app(PS.Data.TraversableWithIndex.Module.traverseWithIndex
                       .app(PS.Data.NonEmpty.Module.traversableWithIndexNonEmpty
                              .app(
                           PS.Data.List.Types.Module.traversableWithIndexList))
                       .app(dictApplicative)
                       .app(PS.Control.Semigroupoid.Module.compose
                              .app(PS.Control.Semigroupoid.Module.semigroupoidFn
                              )
                              .app(f1)
                              .app(PS.Data.Maybe.Module.maybe.app(0)
                                     .app(PS.Data.Semiring.Module.add
                                            .app(
                                              PS.Data.Semiring.Module.semiringInt
                                            )
                                            .app(1))))
                       .app(ne));
            }
          }
        }
      }
    });
  @JvmField
  val unfoldable1List = PS.Data.Unfoldable1.Module.Unfoldable1
                          .app({ f : Any ->
       { b : Any ->
         object   {
             val go = (::__rec_go)();
             fun __rec_go(): Any = { source : Any ->
                { memo : Any ->
                  object   {
                      val v = f.app(source);
                    }
                    .run({
                     val v = this.v;
                     when {
                       (v is PS.Data.Tuple.Module._Type_Tuple
                               .Tuple)&& (v
                                            .value1 is PS.Data.Maybe.Module._Type_Maybe
                                                         .Just) -> {
                         val one = v.value0;
                         val rest = v.value1.value0;
                         __rec_go().app(rest)
                           .app(PS.Data.List.Types.Module.Cons.app(one)
                                  .app(memo));
                       }
                       (v is PS.Data.Tuple.Module._Type_Tuple
                               .Tuple)&& (v
                                            .value1 is PS.Data.Maybe.Module._Type_Maybe
                                                         .Nothing) -> {
                         val one = v.value0;
                         PS.Data.Foldable.Module.foldl
                           .app(PS.Data.List.Types.Module.foldableList)
                           .app(PS.Data.Function.Module.flip
                                  .app(PS.Data.List.Types.Module.Cons))
                           .app(PS.Data.List.Types.Module.Nil)
                           .app(PS.Data.List.Types.Module.Cons.app(one)
                                  .app(memo));
                       }
                       else -> (error("Error in Pattern Match") as Any)
                     };
                   })
               }
             };
           }
           .run({
            val go = this.go;
            go.app(b).app(PS.Data.List.Types.Module.Nil);
          })
      }
    });
  @JvmField
  val unfoldableList = PS.Data.Unfoldable.Module.Unfoldable
                         .app({ _ : Any ->
                              PS.Data.List.Types.Module.unfoldable1List
                           })
                         .app({ f : Any ->
       { b : Any ->
         object   {
             val go = (::__rec_go)();
             fun __rec_go(): Any = { source : Any ->
                { memo : Any ->
                  object   {
                      val v = f.app(source);
                    }
                    .run({
                     val v = this.v;
                     when {
                       (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                         PS.Data.Foldable.Module.foldl
                           .app(PS.Data.List.Types.Module.foldableList)
                           .app(PS.Data.Function.Module.flip
                                  .app(PS.Data.List.Types.Module.Cons))
                           .app(PS.Data.List.Types.Module.Nil)
                           .app(memo);
                       }
                       (v is PS.Data.Maybe.Module._Type_Maybe
                               .Just)&& (v
                                           .value0 is PS.Data.Tuple.Module._Type_Tuple
                                                        .Tuple) -> {
                         val one = v.value0.value0;
                         val rest = v.value0.value1;
                         __rec_go().app(rest)
                           .app(PS.Data.List.Types.Module.Cons.app(one)
                                  .app(memo));
                       }
                       else -> (error("Error in Pattern Match") as Any)
                     };
                   })
               }
             };
           }
           .run({
            val go = this.go;
            go.app(b).app(PS.Data.List.Types.Module.Nil);
          })
      }
    });
  @JvmField
  val unfoldable1NonEmptyList = PS.Data.NonEmpty.Module.unfoldable1NonEmpty
                                  .app(PS.Data.List.Types.Module.unfoldableList
  );
  @JvmField
  val foldable1NonEmptyList = PS.Data.NonEmpty.Module.foldable1NonEmpty
                                .app(PS.Data.List.Types.Module.foldableList);
  @JvmField
  val extendNonEmptyList = PS.Control.Extend.Module.Extend
                             .app({ _ : Any ->
                                  PS.Data.List.Types.Module.functorNonEmptyList
                               })
                             .app({ f : Any ->
       { v : Any ->
         when {
          (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
            val f1 = f;
            val w = v;
            val _as = v.value1;
            object   {
                val go = { a : Any ->
                   { v1 : Any ->
                     when {
                      ((v1 as Map<String, Any>).size == 2) -> {
                        val a1 = a;
                        val _val = v1["val"]!!;
                        val acc = v1["acc"]!!;
                        mapOf(("val" to PS.Data.List.Types.Module.Cons
                                          .app(f1
                                                 .app(
                                              PS.Data.List.Types.Module.NonEmptyList
                                                .app(
                                                PS.Data.NonEmpty.Module.NonEmpty
                                                  .app(a1)
                                                  .app(acc))))
                                          .app(_val)),  
                          ("acc" to PS.Data.List.Types.Module.Cons.app(a1)
                                      .app(acc)));
                      }
                      else -> (error("Error in Pattern Match") as Any)
                    }
                  }
                };
              }
              .run({
                val go = this.go;
                PS.Data.List.Types.Module.NonEmptyList
                  .app(PS.Data.NonEmpty.Module.NonEmpty.app(f1.app(w))
                         .app((PS.Data.Foldable.Module.foldr
                                 .app(PS.Data.List.Types.Module.foldableList)
                                 .app(go)
                                 .app(mapOf(
                                     ("val" to PS.Data.List.Types.Module.Nil),  
                                     ("acc" to PS.Data.List.Types.Module.Nil)))
                                 .app(_as) as Map<String, Any>)["val"]!!));
              });
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val extendList = PS.Control.Extend.Module.Extend
                     .app({ _ : Any ->
                          PS.Data.List.Types.Module.functorList
                       })
                     .app({ f : Any ->
       { v : Any ->
         when {
          (v is PS.Data.List.Types.Module._Type_List.Nil) -> {
            val f1 = f;
            PS.Data.List.Types.Module.Nil;
          }
          (v is PS.Data.List.Types.Module._Type_List.Cons) -> {
            val f1 = f;
            val l = v;
            val a = v.value0;
            val _as = v.value1;
            object   {
                val go = { a_tick : Any ->
                   { v1 : Any ->
                     when {
                      ((v1 as Map<String, Any>).size == 2) -> {
                        val a_tick1 = a_tick;
                        val _val = v1["val"]!!;
                        val acc = v1["acc"]!!;
                        object   {
                            val acc_tick = PS.Data.List.Types.Module.Cons
                                             .app(a_tick1)
                                             .app(acc);
                          }
                          .run({
                            val acc_tick = this.acc_tick;
                            mapOf(("val" to PS.Data.List.Types.Module.Cons
                                              .app(f1.app(acc_tick))
                                              .app(_val)),  ("acc" to acc_tick)
                            );
                          });
                      }
                      else -> (error("Error in Pattern Match") as Any)
                    }
                  }
                };
              }
              .run({
                val go = this.go;
                PS.Data.List.Types.Module.Cons.app(f1.app(l))
                  .app((PS.Data.Foldable.Module.foldr
                          .app(PS.Data.List.Types.Module.foldableList)
                          .app(go)
                          .app(mapOf(("val" to PS.Data.List.Types.Module.Nil),  
                              ("acc" to PS.Data.List.Types.Module.Nil)))
                          .app(_as) as Map<String, Any>)["val"]!!);
              });
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val eq1List = PS.Data.Eq.Module.Eq1
                  .app({ dictEq : Any ->
       { xs : Any ->
         { ys : Any ->
           object   {
               val go = (::__rec_go)();
               fun __rec_go(): Any = { v : Any ->
                  { v1 : Any ->
                    { v2 : Any ->
                      when {
                       (v2 == false) -> {
                         false;
                       }
                       (v is PS.Data.List.Types.Module._Type_List
                               .Nil)&&
                       (v1 is PS.Data.List.Types.Module._Type_List
                                .Nil) -> {
                         val acc = v2;
                         acc;
                       }
                       (v is PS.Data.List.Types.Module._Type_List
                               .Cons)&&
                       (v1 is PS.Data.List.Types.Module._Type_List
                                .Cons) -> {
                         val x = v.value0;
                         val xs_tick = v.value1;
                         val y = v1.value0;
                         val ys_tick = v1.value1;
                         val acc = v2;
                         PS.Data.Function.Module.apply
                           .app(__rec_go().app(xs_tick).app(ys_tick))
                           .app(PS.Data.HeytingAlgebra.Module.conj
                                  .app(
                                    PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean
                                  )
                                  .app(acc)
                                  .app(PS.Data.Eq.Module.eq.app(dictEq).app(y)
                                         .app(x)));
                       }
                       else -> {
                         false;
                       }
                     }
                   }
                 }
               };
             }
             .run({
              val go = this.go;
              go.app(xs).app(ys).app(true);
            })
        }
      }
    });
  @JvmField
  val eqList = { dictEq : Any ->
     PS.Data.Eq.Module.Eq
       .app(PS.Data.Eq.Module.eq1.app(PS.Data.List.Types.Module.eq1List)
              .app(dictEq))
  };
  @JvmField
  val eqNonEmptyList = { dictEq : Any ->
     PS.Data.NonEmpty.Module.eqNonEmpty.app(PS.Data.List.Types.Module.eq1List)
       .app(dictEq)
  };
  @JvmField
  val ord1List = PS.Data.Ord.Module.Ord1
                   .app({ _ : Any ->
                        PS.Data.List.Types.Module.eq1List
                     })
                   .app({ dictOrd : Any ->
       { xs : Any ->
         { ys : Any ->
           object   {
               val go = (::__rec_go)();
               fun __rec_go(): Any = { v : Any ->
                  { v1 : Any ->
                    when {
                     (v is PS.Data.List.Types.Module._Type_List
                             .Nil)&& (v1 is PS.Data.List.Types.Module._Type_List
                                              .Nil) -> {
                       PS.Data.Ordering.Module.EQ;
                     }
                     (v is PS.Data.List.Types.Module._Type_List.Nil) -> {
                       PS.Data.Ordering.Module.LT;
                     }
                     (v1 is PS.Data.List.Types.Module._Type_List.Nil) -> {
                       PS.Data.Ordering.Module.GT;
                     }
                     (v is PS.Data.List.Types.Module._Type_List
                             .Cons)&&
                     (v1 is PS.Data.List.Types.Module._Type_List
                              .Cons) -> {
                       val x = v.value0;
                       val xs_tick = v.value1;
                       val y = v1.value0;
                       val ys_tick = v1.value1;
                       object   {
                           val v2 = PS.Data.Ord.Module.compare.app(dictOrd)
                                      .app(x)
                                      .app(y);
                         }
                         .run({
                           val v2 = this.v2;
                           when {
                             (v2 is PS.Data.Ordering.Module._Type_Ordering
                                      .EQ) -> {
                               __rec_go().app(xs_tick).app(ys_tick);
                             }
                             else -> {
                               val other = v2;
                               other;
                             }
                           };
                         });
                     }
                     else -> (error("Error in Pattern Match") as Any)
                   }
                 }
               };
             }
             .run({
              val go = this.go;
              go.app(xs).app(ys);
            })
        }
      }
    });
  @JvmField
  val ordList = { dictOrd : Any ->
     PS.Data.Ord.Module.Ord
       .app({ _ : Any ->
            PS.Data.List.Types.Module.eqList
              .app((dictOrd as Map<String, Any>)["Eq0"]!!.app(Unit))
         })
       .app(PS.Data.Ord.Module.compare1.app(PS.Data.List.Types.Module.ord1List)
              .app(dictOrd))
  };
  @JvmField
  val ordNonEmptyList = { dictOrd : Any ->
     PS.Data.NonEmpty.Module.ordNonEmpty.app(PS.Data.List.Types.Module.ord1List)
       .app(dictOrd)
  };
  @JvmField
  val comonadNonEmptyList = PS.Control.Comonad.Module.Comonad
                              .app({ _ : Any ->
                                   PS.Data.List.Types.Module.extendNonEmptyList
                                })
                              .app({ v : Any ->
       when {
        (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
          val a = v.value0;
          a;
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    });
  @JvmField val applyList = (::__rec_applyList)();
  fun __rec_applyList(): Any = PS.Control.Apply.Module.Apply
                                 .app({ _ : Any ->
                                      PS.Data.List.Types.Module.functorList
                                   })
                                 .app({ v : Any ->
       { v1 : Any ->
         when {
          (v is PS.Data.List.Types.Module._Type_List.Nil) -> {
            PS.Data.List.Types.Module.Nil;
          }
          (v is PS.Data.List.Types.Module._Type_List.Cons) -> {
            val f = v.value0;
            val fs = v.value1;
            val xs = v1;
            PS.Data.Semigroup.Module.append
              .app(PS.Data.List.Types.Module.semigroupList)
              .app(PS.Data.Functor.Module.map
                     .app(PS.Data.List.Types.Module.functorList)
                     .app(f)
                     .app(xs))
              .app(PS.Control.Apply.Module.apply
                     .app(PS.Data.List.Types.Module.applyList)
                     .app(fs)
                     .app(xs));
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val applyNonEmptyList = PS.Control.Apply.Module.Apply
                            .app({ _ : Any ->
                                 PS.Data.List.Types.Module.functorNonEmptyList
                              })
                            .app({ v : Any ->
       { v1 : Any ->
         when {
          (v is PS.Data.NonEmpty.Module._Type_NonEmpty
                  .NonEmpty)&& (v1 is PS.Data.NonEmpty.Module._Type_NonEmpty
                                        .NonEmpty) -> {
            val f = v.value0;
            val fs = v.value1;
            val a = v1.value0;
            val _as = v1.value1;
            PS.Data.List.Types.Module.NonEmptyList
              .app(PS.Data.NonEmpty.Module.NonEmpty.app(f.app(a))
                     .app(PS.Data.Semigroup.Module.append
                            .app(PS.Data.List.Types.Module.semigroupList)
                            .app(PS.Control.Apply.Module.apply
                                   .app(PS.Data.List.Types.Module.applyList)
                                   .app(fs)
                                   .app(PS.Data.List.Types.Module.Cons.app(a)
                                          .app(PS.Data.List.Types.Module.Nil)))
                            .app(PS.Control.Apply.Module.apply
                                   .app(PS.Data.List.Types.Module.applyList)
                                   .app(PS.Data.List.Types.Module.Cons.app(f)
                                          .app(fs))
                                   .app(_as))));
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField val bindList = (::__rec_bindList)();
  fun __rec_bindList(): Any = PS.Control.Bind.Module.Bind
                                .app({ _ : Any ->
                                     PS.Data.List.Types.Module.applyList
                                  })
                                .app({ v : Any ->
       { v1 : Any ->
         when {
          (v is PS.Data.List.Types.Module._Type_List.Nil) -> {
            PS.Data.List.Types.Module.Nil;
          }
          (v is PS.Data.List.Types.Module._Type_List.Cons) -> {
            val x = v.value0;
            val xs = v.value1;
            val f = v1;
            PS.Data.Semigroup.Module.append
              .app(PS.Data.List.Types.Module.semigroupList)
              .app(f.app(x))
              .app(PS.Control.Bind.Module.bind
                     .app(PS.Data.List.Types.Module.bindList)
                     .app(xs)
                     .app(f));
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val bindNonEmptyList = PS.Control.Bind.Module.Bind
                           .app({ _ : Any ->
                                PS.Data.List.Types.Module.applyNonEmptyList
                             })
                           .app({ v : Any ->
       { f : Any ->
         when {
          (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
            val a = v.value0;
            val _as = v.value1;
            val f1 = f;
            object   {
                val v1 = f1.app(a);
              }
              .run({
                val v1 = this.v1;
                when {
                  (v1 is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
                    val b = v1.value0;
                    val bs = v1.value1;
                    PS.Data.List.Types.Module.NonEmptyList
                      .app(PS.Data.NonEmpty.Module.NonEmpty.app(b)
                             .app(PS.Data.Semigroup.Module.append
                                    .app(PS.Data.List.Types.Module.semigroupList
                                    )
                                    .app(bs)
                                    .app(PS.Control.Bind.Module.bind
                                           .app(
                                             PS.Data.List.Types.Module.bindList)
                                           .app(_as)
                                           .app(
                            PS.Control.Semigroupoid.Module.compose
                              .app(PS.Control.Semigroupoid.Module.semigroupoidFn
                              )
                              .app(PS.Data.List.Types.Module.toList)
                              .app(f1)))));
                  }
                  else -> (error("Error in Pattern Match") as Any)
                };
              });
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val applicativeList = PS.Control.Applicative.Module.Applicative
                          .app({ _ : Any ->
                               PS.Data.List.Types.Module.applyList
                            })
                          .app({ a : Any ->
       PS.Data.List.Types.Module.Cons.app(a).app(PS.Data.List.Types.Module.Nil)
    });
  @JvmField
  val monadList = PS.Control.Monad.Module.Monad
                    .app({ _ : Any ->
                         PS.Data.List.Types.Module.applicativeList
                      })
                    .app({ _ : Any ->
       PS.Data.List.Types.Module.bindList
    });
  @JvmField
  val altNonEmptyList = PS.Control.Alt.Module.Alt
                          .app({ _ : Any ->
                               PS.Data.List.Types.Module.functorNonEmptyList
                            })
                          .app(PS.Data.Semigroup.Module.append
                                 .app(
      PS.Data.List.Types.Module.semigroupNonEmptyList));
  @JvmField
  val altList = PS.Control.Alt.Module.Alt
                  .app({ _ : Any ->
                       PS.Data.List.Types.Module.functorList
                    })
                  .app(PS.Data.Semigroup.Module.append
                         .app(PS.Data.List.Types.Module.semigroupList));
  @JvmField
  val plusList = PS.Control.Plus.Module.Plus
                   .app({ _ : Any ->
                        PS.Data.List.Types.Module.altList
                     })
                   .app(PS.Data.List.Types.Module.Nil);
  @JvmField
  val alternativeList = PS.Control.Alternative.Module.Alternative
                          .app({ _ : Any ->
                               PS.Data.List.Types.Module.applicativeList
                            })
                          .app({ _ : Any ->
       PS.Data.List.Types.Module.plusList
    });
  @JvmField
  val monadZeroList = PS.Control.MonadZero.Module.MonadZero
                        .app({ _ : Any ->
                             PS.Data.List.Types.Module.alternativeList
                          })
                        .app({ _ : Any ->
       PS.Data.List.Types.Module.monadList
    });
  @JvmField
  val monadPlusList = PS.Control.MonadPlus.Module.MonadPlus
                        .app({ _ : Any ->
       PS.Data.List.Types.Module.monadZeroList
    });
  @JvmField
  val applicativeNonEmptyList = PS.Control.Applicative.Module.Applicative
                                  .app({ _ : Any ->
                                       PS.Data.List.Types.Module.applyNonEmptyList
                                    })
                                  .app(PS.Control.Semigroupoid.Module.compose
                                         .app(
                                           PS.Control.Semigroupoid.Module.semigroupoidFn
                                         )
                                         .app(
                                           PS.Data.List.Types.Module.NonEmptyList
                                         )
                                         .app(PS.Data.NonEmpty.Module.singleton
                                                .app(
        PS.Data.List.Types.Module.plusList)));
  @JvmField
  val monadNonEmptyList = PS.Control.Monad.Module.Monad
                            .app({ _ : Any ->
                                 PS.Data.List.Types.Module.applicativeNonEmptyList
                              })
                            .app({ _ : Any ->
       PS.Data.List.Types.Module.bindNonEmptyList
    });
  @JvmField val traversable1NonEmptyList = (::__rec_traversable1NonEmptyList)();
  fun __rec_traversable1NonEmptyList(): Any = PS.Data.Semigroup.Traversable.Module.Traversable1
                                                .app({ _ : Any ->
                                                     PS.Data.List.Types.Module.foldable1NonEmptyList
                                                  })
                                                .app({ _ : Any ->
                                                     PS.Data.List.Types.Module.traversableNonEmptyList
                                                  })
                                                .app({ dictApply : Any ->
                                                     PS.Data.Semigroup.Traversable.Module.traverse1
                                                       .app(
                                                         PS.Data.List.Types.Module.traversable1NonEmptyList
                                                       )
                                                       .app(dictApply)
                                                       .app(
                                                      PS.Control.Category.Module.identity
                                                        .app(
                                                        PS.Control.Category.Module.categoryFn
                                                      ))
                                                  })
                                                .app({ dictApply : Any ->
       { f : Any ->
         { v : Any ->
           when {
            (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
              val f1 = f;
              val a = v.value0;
              val _as = v.value1;
              PS.Data.Functor.Module.mapFlipped
                .app((dictApply as Map<String, Any>)["Functor0"]!!.app(Unit))
                .app(PS.Data.Foldable.Module.foldl
                       .app(PS.Data.List.Types.Module.foldableList)
                       .app({ acc : Any ->
                            PS.Control.Semigroupoid.Module.compose
                              .app(PS.Control.Semigroupoid.Module.semigroupoidFn
                              )
                              .app(PS.Control.Apply.Module.lift2.app(dictApply)
                                     .app(PS.Data.Function.Module.flip
                                            .app(
                                         PS.Data.List.Types.Module.nelCons))
                                     .app(acc))
                              .app(f1)
                         })
                       .app(PS.Data.Functor.Module.map
                              .app((dictApply as Map<String, Any>)["Functor0"]!!
                                     .app(Unit))
                              .app(PS.Control.Applicative.Module.pure
                                     .app(
                                  PS.Data.List.Types.Module.applicativeNonEmptyList
                                ))
                              .app(f1.app(a)))
                       .app(_as))
                .app({ v1 : Any ->
                   when {
                    (v1 is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
                      val x = v1.value0;
                      val xs = v1.value1;
                      PS.Data.Foldable.Module.foldl
                        .app(PS.Data.List.Types.Module.foldableList)
                        .app(PS.Data.Function.Module.flip
                               .app(PS.Data.List.Types.Module.nelCons))
                        .app(PS.Control.Applicative.Module.pure
                               .app(
                                 PS.Data.List.Types.Module.applicativeNonEmptyList
                               )
                               .app(x))
                        .app(xs);
                    }
                    else -> (error("Error in Pattern Match") as Any)
                  }
                });
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      }
    });
}