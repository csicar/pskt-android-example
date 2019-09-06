@file:Suppress("UNCHECKED_CAST")
package PS.Data.Array
import Foreign.PsRuntime.app
object Module  {
  val fromFoldableImpl = Foreign.Data.Array.fromFoldableImpl;
  val range = Foreign.Data.Array.range;
  val replicate = Foreign.Data.Array.replicate;
  val length = Foreign.Data.Array.length;
  val cons = Foreign.Data.Array.cons;
  val snoc = Foreign.Data.Array.snoc;
  val uncons_tick = Foreign.Data.Array.uncons_tick;
  val indexImpl = Foreign.Data.Array.indexImpl;
  val findIndexImpl = Foreign.Data.Array.findIndexImpl;
  val findLastIndexImpl = Foreign.Data.Array.findLastIndexImpl;
  val __insertAt = Foreign.Data.Array.__insertAt;
  val __deleteAt = Foreign.Data.Array.__deleteAt;
  val __updateAt = Foreign.Data.Array.__updateAt;
  val reverse = Foreign.Data.Array.reverse;
  val concat = Foreign.Data.Array.concat;
  val filter = Foreign.Data.Array.filter;
  val partition = Foreign.Data.Array.partition;
  val sortImpl = Foreign.Data.Array.sortImpl;
  val slice = Foreign.Data.Array.slice;
  val take = Foreign.Data.Array.take;
  val drop = Foreign.Data.Array.drop;
  val zipWith = Foreign.Data.Array.zipWith;
  val unsafeIndexImpl = Foreign.Data.Array.unsafeIndexImpl;
  @JvmField
  val zipWithA = { dictApplicative : Any ->
     { f : Any ->
       { xs : Any ->
         { ys : Any ->
           PS.Data.Traversable.Module.sequence
             .app(PS.Data.Traversable.Module.traversableArray)
             .app(dictApplicative)
             .app(PS.Data.Array.Module.zipWith.app(f).app(xs).app(ys))
        }
      }
    }
  };
  @JvmField
  val zip = PS.Data.Array.Module.zipWith.app(PS.Data.Tuple.Module.Tuple);
  @JvmField
  val updateAtIndices = { dictFoldable : Any ->
     { us : Any ->
       { xs : Any ->
         PS.Control.Monad.ST.Internal.Module.run
           .app(PS.Data.Array.ST.Module.withArray
                  .app({ res : Any ->
                       PS.Data.Foldable.Module.traverse_
                         .app(PS.Control.Monad.ST.Internal.Module.applicativeST)
                         .app(dictFoldable)
                         .app({ v : Any ->
                              when {
                               (v is PS.Data.Tuple.Module._Type_Tuple
                                       .Tuple) -> {
                                 val i = v.value0;
                                 val a = v.value1;
                                 PS.Data.Array.ST.Module.poke.app(i).app(a)
                                   .app(res);
                               }
                               else -> (error("Error in Pattern Match") as Any)
                             }
                           })
                         .app(us)
                    })
                  .app(xs))
      }
    }
  };
  @JvmField
  val updateAt = PS.Data.Array.Module.__updateAt.app(PS.Data.Maybe.Module.Just)
                   .app(PS.Data.Maybe.Module.Nothing);
  @JvmField
  val unsafeIndex = { dictPartial : Any ->
     PS.Data.Array.Module.unsafeIndexImpl
  };
  @JvmField
  val uncons = PS.Data.Array.Module.uncons_tick
                 .app(PS.Data.Function.Module._const
                        .app(PS.Data.Maybe.Module.Nothing))
                 .app({ x : Any ->
       { xs : Any ->
         PS.Data.Maybe.Module.Just.app(mapOf(("head" to x),  ("tail" to xs)))
      }
    });
  @JvmField
  val toUnfoldable = { dictUnfoldable : Any ->
     { xs : Any ->
       object   {
           val len = PS.Data.Array.Module.length.app(xs);
           val f = { i : Any ->
              when {
               (PS.Data.Ord.Module.lessThan.app(PS.Data.Ord.Module.ordInt)
                  .app(i)
                  .app(len) as Boolean) -> {
                 val i1 = i;
                 PS.Data.Maybe.Module.Just
                   .app(PS.Data.Tuple.Module.Tuple
                          .app(PS.Partial.Unsafe.Module.unsafePartial
                                 .app({ dictPartial : Any ->
                                 PS.Data.Array.Module.unsafeIndex.app(Unit)
                                   .app(xs)
                                   .app(i1)
                              }))
                          .app(PS.Data.Semiring.Module.add
                                 .app(PS.Data.Semiring.Module.semiringInt)
                                 .app(i1)
                                 .app(1)));
               }
               (PS.Data.Boolean.Module.otherwise as Boolean) -> {
                 val i1 = i;
                 PS.Data.Maybe.Module.Nothing;
               }
               else -> (error("Error in Pattern Match") as Any)
             }
           };
         }
         .run({
          val len = this.len;
          val f = this.f;
          PS.Data.Unfoldable.Module.unfoldr.app(dictUnfoldable).app(f).app(0);
        })
    }
  };
  @JvmField
  val takeEnd = { n : Any ->
     { xs : Any ->
       PS.Data.Array.Module.drop
         .app(PS.Data.Ring.Module.sub.app(PS.Data.Ring.Module.ringInt)
                .app(PS.Data.Array.Module.length.app(xs))
                .app(n))
         .app(xs)
    }
  };
  @JvmField
  val tail = PS.Data.Array.Module.uncons_tick
               .app(PS.Data.Function.Module._const
                      .app(PS.Data.Maybe.Module.Nothing))
               .app({ v : Any ->
       { xs : Any ->
         PS.Data.Maybe.Module.Just.app(xs)
      }
    });
  @JvmField
  val sortBy = { comp : Any ->
     { xs : Any ->
       object   {
           val comp_tick = { x : Any ->
              { y : Any ->
                object   {
                    val v = comp.app(x).app(y);
                  }
                  .run({
                   val v = this.v;
                   when {
                     (v is PS.Data.Ordering.Module._Type_Ordering.GT) -> {
                       1;
                     }
                     (v is PS.Data.Ordering.Module._Type_Ordering.EQ) -> {
                       0;
                     }
                     (v is PS.Data.Ordering.Module._Type_Ordering.LT) -> {
                       PS.Data.Ring.Module.negate
                         .app(PS.Data.Ring.Module.ringInt)
                         .app(1);
                     }
                     else -> (error("Error in Pattern Match") as Any)
                   };
                 })
             }
           };
         }
         .run({
          val comp_tick = this.comp_tick;
          PS.Data.Array.Module.sortImpl.app(comp_tick).app(xs);
        })
    }
  };
  @JvmField
  val sortWith = { dictOrd : Any ->
     { f : Any ->
       PS.Data.Array.Module.sortBy
         .app(PS.Data.Ord.Module.comparing.app(dictOrd).app(f))
    }
  };
  @JvmField
  val sort = { dictOrd : Any ->
     { xs : Any ->
       PS.Data.Array.Module.sortBy.app(PS.Data.Ord.Module.compare.app(dictOrd))
         .app(xs)
    }
  };
  @JvmField val singleton = { a : Any -> listOf(a)};
  @JvmField
  val _null = { xs : Any ->
     PS.Data.Eq.Module.eq.app(PS.Data.Eq.Module.eqInt)
       .app(PS.Data.Array.Module.length.app(xs))
       .app(0)
  };
  @JvmField
  val nubByEq = { eq : Any ->
     { xs : Any ->
       PS.Control.Monad.ST.Internal.Module.run
         .app(PS.Control.Bind.Module.bind
                .app(PS.Control.Monad.ST.Internal.Module.bindST)
                .app(PS.Data.Array.ST.Module.empty)
                .app({ v : Any ->
             when {
              else -> {
                val arr = v;
                PS.Control.Bind.Module.discard
                  .app(PS.Control.Bind.Module.discardUnit)
                  .app(PS.Control.Monad.ST.Internal.Module.bindST)
                  .app(PS.Control.Monad.ST.Internal.Module.foreach.app(xs)
                         .app({ x : Any ->
                         PS.Control.Bind.Module.bind
                           .app(PS.Control.Monad.ST.Internal.Module.bindST)
                           .app(PS.Data.Functor.Module.map
                                  .app(
                                    PS.Control.Monad.ST.Internal.Module.functorST
                                  )
                                  .app(PS.Control.Semigroupoid.Module.compose
                                         .app(
                                           PS.Control.Semigroupoid.Module.semigroupoidFn
                                         )
                                         .app(PS.Data.HeytingAlgebra.Module.not
                                                .app(
                                             PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean
                                           ))
                                         .app(PS.Data.Foldable.Module.any
                                                .app(
                                                  PS.Data.Foldable.Module.foldableArray
                                                )
                                                .app(
                                                  PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean
                                                )
                                                .app({ v1 : Any ->
                                           eq.app(v1).app(x)
                                        })))
                                  .app(PS.Data.Array.ST.Module.unsafeFreeze
                                         .app(arr)))
                           .app({ v1 : Any ->
                             when {
                              else -> {
                                val e = v1;
                                PS.Data.Function.Module.apply
                                  .app(PS.Control.Applicative.Module._when
                                         .app(
                                           PS.Control.Monad.ST.Internal.Module.applicativeST
                                         )
                                         .app(e))
                                  .app(PS.Data.Function.Module.apply
                                         .app(PS.Data.Functor.Module.void
                                                .app(
                                             PS.Control.Monad.ST.Internal.Module.functorST
                                           ))
                                         .app(PS.Data.Array.ST.Module.push
                                                .app(x)
                                                .app(arr)));
                              }
                            }
                          })
                      }))
                  .app({ _ : Any ->
                     PS.Data.Array.ST.Module.unsafeFreeze.app(arr)
                  });
              }
            }
          }))
    }
  };
  @JvmField
  val nubEq = { dictEq : Any ->
     PS.Data.Array.Module.nubByEq.app(PS.Data.Eq.Module.eq.app(dictEq))
  };
  @JvmField
  val modifyAtIndices = { dictFoldable : Any ->
     { _is : Any ->
       { f : Any ->
         { xs : Any ->
           PS.Control.Monad.ST.Internal.Module.run
             .app(PS.Data.Array.ST.Module.withArray
                    .app({ res : Any ->
                         PS.Data.Foldable.Module.traverse_
                           .app(
                             PS.Control.Monad.ST.Internal.Module.applicativeST)
                           .app(dictFoldable)
                           .app({ i : Any ->
                                PS.Data.Array.ST.Module.modify.app(i).app(f)
                                  .app(res)
                             })
                           .app(_is)
                      })
                    .app(xs))
        }
      }
    }
  };
  @JvmField
  val mapWithIndex = { f : Any ->
     { xs : Any ->
       PS.Data.Array.Module.zipWith.app(f)
         .app(PS.Data.Array.Module.range.app(0)
                .app(PS.Data.Ring.Module.sub.app(PS.Data.Ring.Module.ringInt)
                       .app(PS.Data.Array.Module.length.app(xs))
                       .app(1)))
         .app(xs)
    }
  };
  @JvmField val some = (::__rec_some)();
  @JvmField val many = (::__rec_many)();
  fun __rec_some(): Any = { dictAlternative : Any ->
     { dictLazy : Any ->
       { v : Any ->
         PS.Control.Apply.Module.apply
           .app(((dictAlternative as Map<String, Any>)["Applicative0"]!!
                   .app(Unit) as Map<String, Any>)["Apply0"]!!
                  .app(Unit))
           .app(PS.Data.Functor.Module.map
                  .app((((dictAlternative as Map<String, Any>)["Plus1"]!!
                           .app(Unit) as Map<String, Any>)["Alt0"]!!
                          .app(Unit) as Map<String, Any>)["Functor0"]!!
                         .app(Unit))
                  .app(PS.Data.Array.Module.cons)
                  .app(v))
           .app(PS.Control.Lazy.Module.defer.app(dictLazy)
                  .app({ v1 : Any ->
               PS.Data.Array.Module.many.app(dictAlternative).app(dictLazy)
                 .app(v)
            }))
      }
    }
  };
  fun __rec_many(): Any = { dictAlternative : Any ->
     { dictLazy : Any ->
       { v : Any ->
         PS.Control.Alt.Module.alt
           .app(((dictAlternative as Map<String, Any>)["Plus1"]!!
                   .app(Unit) as Map<String, Any>)["Alt0"]!!
                  .app(Unit))
           .app(PS.Data.Array.Module.some.app(dictAlternative).app(dictLazy)
                  .app(v))
           .app(PS.Control.Applicative.Module.pure
                  .app((dictAlternative as Map<String, Any>)["Applicative0"]!!
                         .app(Unit))
                  .app(emptyList<Any>()))
      }
    }
  };
  @JvmField
  val insertAt = PS.Data.Array.Module.__insertAt.app(PS.Data.Maybe.Module.Just)
                   .app(PS.Data.Maybe.Module.Nothing);
  @JvmField
  val _init = { xs : Any ->
     when {
      (PS.Data.Array.Module._null.app(xs) as Boolean) -> {
        val xs1 = xs;
        PS.Data.Maybe.Module.Nothing;
      }
      (PS.Data.Boolean.Module.otherwise as Boolean) -> {
        val xs1 = xs;
        PS.Data.Maybe.Module.Just
          .app(PS.Data.Array.Module.slice
                 .app(PS.Data.Semiring.Module.zero
                        .app(PS.Data.Semiring.Module.semiringInt))
                 .app(PS.Data.Ring.Module.sub.app(PS.Data.Ring.Module.ringInt)
                        .app(PS.Data.Array.Module.length.app(xs1))
                        .app(PS.Data.Semiring.Module.one
                               .app(PS.Data.Semiring.Module.semiringInt)))
                 .app(xs1));
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val index = PS.Data.Array.Module.indexImpl.app(PS.Data.Maybe.Module.Just)
                .app(PS.Data.Maybe.Module.Nothing);
  @JvmField
  val last = { xs : Any ->
     PS.Data.Array.Module.index.app(xs)
       .app(PS.Data.Ring.Module.sub.app(PS.Data.Ring.Module.ringInt)
              .app(PS.Data.Array.Module.length.app(xs))
              .app(1))
  };
  @JvmField
  val unsnoc = { xs : Any ->
     PS.Control.Apply.Module.apply.app(PS.Data.Maybe.Module.applyMaybe)
       .app(PS.Data.Functor.Module.map.app(PS.Data.Maybe.Module.functorMaybe)
              .app({ v : Any ->
                   { v1 : Any ->
                     mapOf(("init" to v),  ("last" to v1))
                  }
                })
              .app(PS.Data.Array.Module._init.app(xs)))
       .app(PS.Data.Array.Module.last.app(xs))
  };
  @JvmField
  val modifyAt = { i : Any ->
     { f : Any ->
       { xs : Any ->
         object   {
             val go = { x : Any ->
                PS.Data.Array.Module.updateAt.app(i).app(f.app(x)).app(xs)
             };
           }
           .run({
            val go = this.go;
            PS.Data.Maybe.Module.maybe.app(PS.Data.Maybe.Module.Nothing).app(go)
              .app(PS.Data.Array.Module.index.app(xs).app(i));
          })
      }
    }
  };
  @JvmField
  val span = { p : Any ->
     { arr : Any ->
       object   {
           val go = (::__rec_go)();
           val breakIndex = go.app(0);
           fun __rec_go(): Any = { i : Any ->
              object   {
                  val v = PS.Data.Array.Module.index.app(arr).app(i);
                }
                .run({
                 val v = this.v;
                 when {
                   (v is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
                     val x = v.value0;
                     when {
                       (p.app(x) == true) -> {
                         __rec_go()
                           .app(PS.Data.Semiring.Module.add
                                  .app(PS.Data.Semiring.Module.semiringInt)
                                  .app(i)
                                  .app(1));
                       }
                       else -> {
                         PS.Data.Maybe.Module.Just.app(i);
                       }
                     };
                   }
                   (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                     PS.Data.Maybe.Module.Nothing;
                   }
                   else -> (error("Error in Pattern Match") as Any)
                 };
               })
           };
         }
         .run({
          val go = this.go;
          val breakIndex = this.breakIndex;
          when {
            (breakIndex is PS.Data.Maybe.Module._Type_Maybe
                             .Just)&& (breakIndex
                                         .value0 == 0) -> {
              mapOf(("init" to emptyList<Any>()),  ("rest" to arr));
            }
            (breakIndex is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
              val i = breakIndex.value0;
              mapOf(("init" to PS.Data.Array.Module.slice.app(0).app(i)
                                 .app(arr)),  
                ("rest" to PS.Data.Array.Module.slice.app(i)
                             .app(PS.Data.Array.Module.length.app(arr))
                             .app(arr)));
            }
            (breakIndex is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
              mapOf(("init" to arr),  ("rest" to emptyList<Any>()));
            }
            else -> (error("Error in Pattern Match") as Any)
          };
        })
    }
  };
  @JvmField
  val takeWhile = { p : Any ->
     { xs : Any ->
       (PS.Data.Array.Module.span.app(p).app(xs) as Map<String, Any>)["init"]!!
    }
  };
  @JvmField
  val unzip = { xs : Any ->
     PS.Control.Monad.ST.Internal.Module.run
       .app(PS.Control.Bind.Module.bind
              .app(PS.Control.Monad.ST.Internal.Module.bindST)
              .app(PS.Data.Array.ST.Module.empty)
              .app({ v : Any ->
           when {
            else -> {
              val fsts = v;
              PS.Control.Bind.Module.bind
                .app(PS.Control.Monad.ST.Internal.Module.bindST)
                .app(PS.Data.Array.ST.Module.empty)
                .app({ v1 : Any ->
                   when {
                    else -> {
                      val snds = v1;
                      PS.Control.Bind.Module.bind
                        .app(PS.Control.Monad.ST.Internal.Module.bindST)
                        .app(PS.Data.Array.ST.Iterator.Module.iterator
                               .app({ v2 : Any ->
                               PS.Data.Array.Module.index.app(xs).app(v2)
                            }))
                        .app({ v2 : Any ->
                           when {
                            else -> {
                              val iter = v2;
                              PS.Control.Bind.Module.discard
                                .app(PS.Control.Bind.Module.discardUnit)
                                .app(PS.Control.Monad.ST.Internal.Module.bindST)
                                .app(PS.Data.Array.ST.Iterator.Module.iterate
                                       .app(iter)
                                       .app({ v3 : Any ->
                                       when {
                                        (v3 is PS.Data.Tuple.Module._Type_Tuple
                                                 .Tuple) -> {
                                          val fst = v3.value0;
                                          val snd = v3.value1;
                                          PS.Control.Bind.Module.discard
                                            .app(
                                              PS.Control.Bind.Module.discardUnit
                                            )
                                            .app(
                                              PS.Control.Monad.ST.Internal.Module.bindST
                                            )
                                            .app(PS.Data.Function.Module.apply
                                                   .app(
                                                     PS.Data.Functor.Module.void
                                                       .app(
                                                       PS.Control.Monad.ST.Internal.Module.functorST
                                                     ))
                                                   .app(
                                                PS.Data.Array.ST.Module.push
                                                  .app(fst)
                                                  .app(fsts)))
                                            .app({ _ : Any ->
                                               PS.Data.Function.Module.apply
                                                 .app(
                                                   PS.Data.Functor.Module.void
                                                     .app(
                                                     PS.Control.Monad.ST.Internal.Module.functorST
                                                   ))
                                                 .app(
                                                PS.Data.Array.ST.Module.push
                                                  .app(snd)
                                                  .app(snds))
                                            });
                                        }
                                        else -> (error("Error in Pattern Match"
                                        ) as Any)
                                      }
                                    }))
                                .app({ _ : Any ->
                                   PS.Control.Bind.Module.bind
                                     .app(
                                       PS.Control.Monad.ST.Internal.Module.bindST
                                     )
                                     .app(PS.Data.Array.ST.Module.unsafeFreeze
                                            .app(fsts))
                                     .app({ v3 : Any ->
                                       when {
                                        else -> {
                                          val fsts_tick = v3;
                                          PS.Control.Bind.Module.bind
                                            .app(
                                              PS.Control.Monad.ST.Internal.Module.bindST
                                            )
                                            .app(
                                              PS.Data.Array.ST.Module.unsafeFreeze
                                                .app(snds))
                                            .app({ v4 : Any ->
                                               when {
                                                else -> {
                                                  val snds_tick = v4;
                                                  PS.Data.Function.Module.apply
                                                    .app(
                                                      PS.Control.Applicative.Module.pure
                                                        .app(
                                                        PS.Control.Monad.ST.Internal.Module.applicativeST
                                                      ))
                                                    .app(
                                                    PS.Data.Tuple.Module.Tuple
                                                      .app(fsts_tick)
                                                      .app(snds_tick));
                                                }
                                              }
                                            });
                                        }
                                      }
                                    })
                                });
                            }
                          }
                        });
                    }
                  }
                });
            }
          }
        }))
  };
  @JvmField val head = { xs : Any -> PS.Data.Array.Module.index.app(xs).app(0)};
  @JvmField
  val nubBy = { comp : Any ->
     { xs : Any ->
       object   {
           val indexedAndSorted = PS.Data.Array.Module.sortBy
                                    .app({ x : Any ->
                                         { y : Any ->
                                           comp
                                             .app(PS.Data.Tuple.Module.snd
                                                    .app(x))
                                             .app(PS.Data.Tuple.Module.snd
                                                    .app(y))
                                        }
                                      })
                                    .app(PS.Data.Array.Module.mapWithIndex
                                           .app(PS.Data.Tuple.Module.Tuple)
                                           .app(xs));
         }
         .run({
          val indexedAndSorted = this.indexedAndSorted;
          object   {
              val v = PS.Data.Array.Module.head.app(indexedAndSorted);
            }
            .run({
              val v = this.v;
              when {
                (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                  emptyList<Any>();
                }
                (v is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
                  val x = v.value0;
                  PS.Data.Function.Module.apply
                    .app(PS.Data.Functor.Module.map
                           .app(PS.Data.Functor.Module.functorArray)
                           .app(PS.Data.Tuple.Module.snd))
                    .app(PS.Data.Function.Module.apply
                           .app(PS.Data.Array.Module.sortWith
                                  .app(PS.Data.Ord.Module.ordInt)
                                  .app(PS.Data.Tuple.Module.fst))
                           .app(PS.Control.Monad.ST.Internal.Module.run
                                  .app(PS.Control.Bind.Module.bind
                                         .app(
                                           PS.Control.Monad.ST.Internal.Module.bindST
                                         )
                                         .app(PS.Data.Function.Module.apply
                                                .app(
                                                  PS.Data.Array.ST.Module.unsafeThaw
                                                )
                                                .app(
                                             PS.Data.Array.Module.singleton
                                               .app(x)))
                                         .app({ v1 : Any ->
                             when {
                              else -> {
                                val result = v1;
                                PS.Control.Bind.Module.discard
                                  .app(PS.Control.Bind.Module.discardUnit)
                                  .app(
                                    PS.Control.Monad.ST.Internal.Module.bindST)
                                  .app(
                                    PS.Control.Monad.ST.Internal.Module.foreach
                                      .app(indexedAndSorted)
                                      .app({ v2 : Any ->
                                         when {
                                          (v2 is PS.Data.Tuple.Module._Type_Tuple
                                                   .Tuple) -> {
                                            val pair = v2;
                                            val i = v2.value0;
                                            val x_tick = v2.value1;
                                            PS.Control.Bind.Module.bind
                                              .app(
                                                PS.Control.Monad.ST.Internal.Module.bindST
                                              )
                                              .app(PS.Data.Functor.Module.map
                                                     .app(
                                                       PS.Control.Monad.ST.Internal.Module.functorST
                                                     )
                                                     .app(
                                                       PS.Control.Semigroupoid.Module.compose
                                                         .app(
                                                           PS.Control.Semigroupoid.Module.semigroupoidFn
                                                         )
                                                         .app(
                                                           PS.Data.Tuple.Module.snd
                                                         )
                                                         .app(
                                                         PS.Partial.Unsafe.Module.unsafePartial
                                                           .app(
                                                           { dictPartial : Any ->
                                                              PS.Control.Semigroupoid.Module.compose
                                                                .app(
                                                                  PS.Control.Semigroupoid.Module.semigroupoidFn
                                                                )
                                                                .app(
                                                                  PS.Data.Maybe.Module.fromJust
                                                                    .app(Unit))
                                                                .app(
                                                               PS.Data.Array.Module.last
                                                             )
                                                           })))
                                                     .app(
                                                  PS.Data.Array.ST.Module.unsafeFreeze
                                                    .app(result)))
                                              .app({ v3 : Any ->
                                                 when {
                                                  else -> {
                                                    val lst = v3;
                                                    PS.Data.Function.Module.apply
                                                      .app(
                                                        PS.Control.Applicative.Module._when
                                                          .app(
                                                            PS.Control.Monad.ST.Internal.Module.applicativeST
                                                          )
                                                          .app(
                                                          PS.Data.Eq.Module.notEq
                                                            .app(
                                                              PS.Data.Ordering.Module.eqOrdering
                                                            )
                                                            .app(comp.app(lst)
                                                                   .app(x_tick))
                                                            .app(
                                                            PS.Data.Ordering.Module.EQ
                                                          )))
                                                      .app(
                                                      PS.Data.Function.Module.apply
                                                        .app(
                                                          PS.Data.Functor.Module.void
                                                            .app(
                                                            PS.Control.Monad.ST.Internal.Module.functorST
                                                          ))
                                                        .app(
                                                        PS.Data.Array.ST.Module.push
                                                          .app(pair)
                                                          .app(result)));
                                                  }
                                                }
                                              });
                                          }
                                          else -> (error(
                                            "Error in Pattern Match") as Any)
                                        }
                                      }))
                                  .app({ _ : Any ->
                                     PS.Data.Array.ST.Module.unsafeFreeze
                                       .app(result)
                                  });
                              }
                            }
                          }))));
                }
                else -> (error("Error in Pattern Match") as Any)
              };
            });
        })
    }
  };
  @JvmField
  val nub = { dictOrd : Any ->
     PS.Data.Array.Module.nubBy.app(PS.Data.Ord.Module.compare.app(dictOrd))
  };
  @JvmField
  val groupBy = { op : Any ->
     { xs : Any ->
       PS.Control.Monad.ST.Internal.Module.run
         .app(PS.Control.Bind.Module.bind
                .app(PS.Control.Monad.ST.Internal.Module.bindST)
                .app(PS.Data.Array.ST.Module.empty)
                .app({ v : Any ->
             when {
              else -> {
                val result = v;
                PS.Control.Bind.Module.bind
                  .app(PS.Control.Monad.ST.Internal.Module.bindST)
                  .app(PS.Data.Array.ST.Iterator.Module.iterator
                         .app({ v1 : Any ->
                         PS.Data.Array.Module.index.app(xs).app(v1)
                      }))
                  .app({ v1 : Any ->
                     when {
                      else -> {
                        val iter = v1;
                        PS.Control.Bind.Module.discard
                          .app(PS.Control.Bind.Module.discardUnit)
                          .app(PS.Control.Monad.ST.Internal.Module.bindST)
                          .app(PS.Data.Array.ST.Iterator.Module.iterate
                                 .app(iter)
                                 .app({ x : Any ->
                                 PS.Data.Functor.Module.void
                                   .app(
                                     PS.Control.Monad.ST.Internal.Module.functorST
                                   )
                                   .app(PS.Control.Bind.Module.bind
                                          .app(
                                            PS.Control.Monad.ST.Internal.Module.bindST
                                          )
                                          .app(PS.Data.Array.ST.Module.empty)
                                          .app({ v2 : Any ->
                                       when {
                                        else -> {
                                          val sub = v2;
                                          PS.Control.Bind.Module.bind
                                            .app(
                                              PS.Control.Monad.ST.Internal.Module.bindST
                                            )
                                            .app(PS.Data.Array.ST.Module.push
                                                   .app(x)
                                                   .app(sub))
                                            .app({ v3 : Any ->
                                               PS.Control.Bind.Module.discard
                                                 .app(
                                                   PS.Control.Bind.Module.discardUnit
                                                 )
                                                 .app(
                                                   PS.Control.Monad.ST.Internal.Module.bindST
                                                 )
                                                 .app(
                                                   PS.Data.Array.ST.Iterator.Module.pushWhile
                                                     .app(op.app(x))
                                                     .app(iter)
                                                     .app(sub))
                                                 .app({ _ : Any ->
                                                   PS.Control.Bind.Module.bind
                                                     .app(
                                                       PS.Control.Monad.ST.Internal.Module.bindST
                                                     )
                                                     .app(
                                                       PS.Data.Array.ST.Module.unsafeFreeze
                                                         .app(sub))
                                                     .app({ v4 : Any ->
                                                       when {
                                                        else -> {
                                                          val grp = v4;
                                                          PS.Data.Array.ST.Module.push
                                                            .app(
                                                              PS.Unsafe.Coerce.Module.unsafeCoerce
                                                                .app(grp))
                                                            .app(result);
                                                        }
                                                      }
                                                    })
                                                })
                                            });
                                        }
                                      }
                                    }))
                              }))
                          .app({ _ : Any ->
                             PS.Data.Array.ST.Module.unsafeFreeze.app(result)
                          });
                      }
                    }
                  });
              }
            }
          }))
    }
  };
  @JvmField
  val group = { dictEq : Any ->
     { xs : Any ->
       PS.Data.Array.Module.groupBy.app(PS.Data.Eq.Module.eq.app(dictEq))
         .app(xs)
    }
  };
  @JvmField
  val group_tick = { dictOrd : Any ->
     PS.Control.Semigroupoid.Module.compose
       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
       .app(PS.Data.Array.Module.group
              .app((dictOrd as Map<String, Any>)["Eq0"]!!.app(Unit)))
       .app(PS.Data.Array.Module.sort.app(dictOrd))
  };
  @JvmField
  val fromFoldable = { dictFoldable : Any ->
     PS.Data.Array.Module.fromFoldableImpl
       .app(PS.Data.Foldable.Module.foldr.app(dictFoldable))
  };
  @JvmField
  val foldRecM = { dictMonadRec : Any ->
     { f : Any ->
       { a : Any ->
         { array : Any ->
           object   {
               val go = { res : Any ->
                  { i : Any ->
                    when {
                     (PS.Data.Ord.Module.greaterThanOrEq
                        .app(PS.Data.Ord.Module.ordInt)
                        .app(i)
                        .app(PS.Data.Array.Module.length.app(array)
                     ) as Boolean) -> {
                       val res1 = res;
                       val i1 = i;
                       PS.Control.Applicative.Module.pure
                         .app(((dictMonadRec as Map<String, Any>)["Monad0"]!!
                                 .app(Unit
                                ) as Map<String, Any>)["Applicative0"]!!
                                .app(Unit))
                         .app(PS.Control.Monad.Rec.Class.Module.Done.app(res1));
                     }
                     (PS.Data.Boolean.Module.otherwise as Boolean) -> {
                       val res1 = res;
                       val i1 = i;
                       PS.Control.Bind.Module.bind
                         .app(((dictMonadRec as Map<String, Any>)["Monad0"]!!
                                 .app(Unit) as Map<String, Any>)["Bind1"]!!
                                .app(Unit))
                         .app(f.app(res1)
                                .app(PS.Partial.Unsafe.Module.unsafePartial
                                       .app({ dictPartial : Any ->
                                  PS.Data.Array.Module.unsafeIndex.app(Unit)
                                    .app(array)
                                    .app(i1)
                               })))
                         .app({ v : Any ->
                            when {
                             else -> {
                               val res_tick = v;
                               PS.Control.Applicative.Module.pure
                                 .app(
                                   ((dictMonadRec as Map<String, Any>)["Monad0"]!!
                                      .app(Unit
                                     ) as Map<String, Any>)["Applicative0"]!!
                                     .app(Unit))
                                 .app(PS.Control.Monad.Rec.Class.Module.Loop
                                        .app(mapOf(("a" to res_tick),  
                                     ("b" to PS.Data.Semiring.Module.add
                                               .app(
                                                 PS.Data.Semiring.Module.semiringInt
                                               )
                                               .app(i1)
                                               .app(1)))));
                             }
                           }
                         });
                     }
                     else -> (error("Error in Pattern Match") as Any)
                   }
                 }
               };
             }
             .run({
              val go = this.go;
              PS.Control.Monad.Rec.Class.Module.tailRecM2.app(dictMonadRec)
                .app(go)
                .app(a)
                .app(0);
            })
        }
      }
    }
  };
  @JvmField val foldM = (::__rec_foldM)();
  fun __rec_foldM(): Any = { dictMonad : Any ->
     { f : Any ->
       { a : Any ->
         PS.Data.Array.Module.uncons_tick
           .app({ v : Any ->
                PS.Control.Applicative.Module.pure
                  .app((dictMonad as Map<String, Any>)["Applicative0"]!!
                         .app(Unit))
                  .app(a)
             })
           .app({ b : Any ->
             { bs : Any ->
               PS.Control.Bind.Module.bind
                 .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
                 .app(f.app(a).app(b))
                 .app({ a_tick : Any ->
                   PS.Data.Array.Module.foldM.app(dictMonad).app(f).app(a_tick)
                     .app(bs)
                })
            }
          })
      }
    }
  };
  @JvmField
  val findLastIndex = PS.Data.Array.Module.findLastIndexImpl
                        .app(PS.Data.Maybe.Module.Just)
                        .app(PS.Data.Maybe.Module.Nothing);
  @JvmField
  val insertBy = { cmp : Any ->
     { x : Any ->
       { ys : Any ->
         object   {
             val i = PS.Data.Maybe.Module.maybe.app(0)
                       .app({ v : Any ->
                            PS.Data.Semiring.Module.add
                              .app(PS.Data.Semiring.Module.semiringInt)
                              .app(v)
                              .app(1)
                         })
                       .app(PS.Data.Array.Module.findLastIndex
                              .app({ y : Any ->
                                   PS.Data.Eq.Module.eq
                                     .app(PS.Data.Ordering.Module.eqOrdering)
                                     .app(cmp.app(x).app(y))
                                     .app(PS.Data.Ordering.Module.GT)
                                })
                              .app(ys));
           }
           .run({
            val i = this.i;
            PS.Partial.Unsafe.Module.unsafePartial
              .app({ dictPartial : Any ->
                 PS.Data.Maybe.Module.fromJust.app(Unit)
                   .app(PS.Data.Array.Module.insertAt.app(i).app(x).app(ys))
              });
          })
      }
    }
  };
  @JvmField
  val insert = { dictOrd : Any ->
     PS.Data.Array.Module.insertBy.app(PS.Data.Ord.Module.compare.app(dictOrd))
  };
  @JvmField
  val findIndex = PS.Data.Array.Module.findIndexImpl
                    .app(PS.Data.Maybe.Module.Just)
                    .app(PS.Data.Maybe.Module.Nothing);
  @JvmField
  val intersectBy = { eq : Any ->
     { xs : Any ->
       { ys : Any ->
         PS.Data.Array.Module.filter
           .app({ x : Any ->
                PS.Data.Maybe.Module.isJust
                  .app(PS.Data.Array.Module.findIndex.app(eq.app(x)).app(ys))
             })
           .app(xs)
      }
    }
  };
  @JvmField
  val intersect = { dictEq : Any ->
     PS.Data.Array.Module.intersectBy.app(PS.Data.Eq.Module.eq.app(dictEq))
  };
  @JvmField
  val elemLastIndex = { dictEq : Any ->
     { x : Any ->
       PS.Data.Array.Module.findLastIndex
         .app({ v : Any ->
           PS.Data.Eq.Module.eq.app(dictEq).app(v).app(x)
        })
    }
  };
  @JvmField
  val elemIndex = { dictEq : Any ->
     { x : Any ->
       PS.Data.Array.Module.findIndex
         .app({ v : Any ->
           PS.Data.Eq.Module.eq.app(dictEq).app(v).app(x)
        })
    }
  };
  @JvmField
  val dropWhile = { p : Any ->
     { xs : Any ->
       (PS.Data.Array.Module.span.app(p).app(xs) as Map<String, Any>)["rest"]!!
    }
  };
  @JvmField
  val dropEnd = { n : Any ->
     { xs : Any ->
       PS.Data.Array.Module.take
         .app(PS.Data.Ring.Module.sub.app(PS.Data.Ring.Module.ringInt)
                .app(PS.Data.Array.Module.length.app(xs))
                .app(n))
         .app(xs)
    }
  };
  @JvmField
  val deleteAt = PS.Data.Array.Module.__deleteAt.app(PS.Data.Maybe.Module.Just)
                   .app(PS.Data.Maybe.Module.Nothing);
  @JvmField
  val deleteBy = { v : Any ->
     { v1 : Any ->
       { v2 : Any ->
         when {
          ((v2 as List<Any>).size == 0) -> {
            emptyList<Any>();
          }
          else -> {
            val eq = v;
            val x = v1;
            val ys = v2;
            PS.Data.Maybe.Module.maybe.app(ys)
              .app({ i : Any ->
                   PS.Data.Function.Module.apply
                     .app(PS.Partial.Unsafe.Module.unsafePartial)
                     .app({ dictPartial : Any ->
                       PS.Data.Maybe.Module.fromJust.app(Unit)
                         .app(PS.Data.Array.Module.deleteAt.app(i).app(ys))
                    })
                })
              .app(PS.Data.Array.Module.findIndex.app(eq.app(x)).app(ys));
          }
        }
      }
    }
  };
  @JvmField
  val unionBy = { eq : Any ->
     { xs : Any ->
       { ys : Any ->
         ((xs as List<Any>) + (PS.Data.Foldable.Module.foldl
                                 .app(PS.Data.Foldable.Module.foldableArray)
                                 .app(PS.Data.Function.Module.flip
                                        .app(PS.Data.Array.Module.deleteBy
                                               .app(eq)))
                                 .app(PS.Data.Array.Module.nubByEq.app(eq)
                                        .app(ys))
                                 .app(xs) as List<Any>))
      }
    }
  };
  @JvmField
  val union = { dictEq : Any ->
     PS.Data.Array.Module.unionBy.app(PS.Data.Eq.Module.eq.app(dictEq))
  };
  @JvmField
  val delete = { dictEq : Any ->
     PS.Data.Array.Module.deleteBy.app(PS.Data.Eq.Module.eq.app(dictEq))
  };
  @JvmField
  val difference = { dictEq : Any ->
     PS.Data.Foldable.Module.foldr.app(PS.Data.Foldable.Module.foldableArray)
       .app(PS.Data.Array.Module.delete.app(dictEq))
  };
  @JvmField
  val concatMap = PS.Data.Function.Module.flip
                    .app(PS.Control.Bind.Module.bind
                           .app(PS.Control.Bind.Module.bindArray));
  @JvmField
  val mapMaybe = { f : Any ->
     PS.Data.Array.Module.concatMap
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Data.Maybe.Module.maybe.app(emptyList<Any>())
                     .app(PS.Data.Array.Module.singleton))
              .app(f))
  };
  @JvmField
  val filterA = { dictApplicative : Any ->
     { p : Any ->
       PS.Control.Semigroupoid.Module.composeFlipped
         .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
         .app(PS.Data.Traversable.Module.traverse
                .app(PS.Data.Traversable.Module.traversableArray)
                .app(dictApplicative)
                .app({ x : Any ->
                PS.Data.Functor.Module.map
                  .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                          .app(Unit) as Map<String, Any>)["Functor0"]!!
                         .app(Unit))
                  .app(PS.Data.Tuple.Module.Tuple.app(x))
                  .app(p.app(x))
             }))
         .app(PS.Data.Functor.Module.map
                .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                        .app(Unit) as Map<String, Any>)["Functor0"]!!
                       .app(Unit))
                .app(PS.Data.Array.Module.mapMaybe
                       .app({ v : Any ->
               when {
                (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                  val x = v.value0;
                  val b = v.value1;
                  when {
                    (b == true) -> {
                      PS.Data.Maybe.Module.Just.app(x);
                    }
                    else -> {
                      PS.Data.Maybe.Module.Nothing;
                    }
                  };
                }
                else -> (error("Error in Pattern Match") as Any)
              }
            })))
    }
  };
  @JvmField
  val catMaybes = PS.Data.Array.Module.mapMaybe
                    .app(PS.Control.Category.Module.identity
                           .app(PS.Control.Category.Module.categoryFn));
  @JvmField
  val alterAt = { i : Any ->
     { f : Any ->
       { xs : Any ->
         object   {
             val go = { x : Any ->
                object   {
                    val v = f.app(x);
                  }
                  .run({
                   val v = this.v;
                   when {
                     (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                       PS.Data.Array.Module.deleteAt.app(i).app(xs);
                     }
                     (v is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
                       val x_tick = v.value0;
                       PS.Data.Array.Module.updateAt.app(i).app(x_tick).app(xs);
                     }
                     else -> (error("Error in Pattern Match") as Any)
                   };
                 })
             };
           }
           .run({
            val go = this.go;
            PS.Data.Maybe.Module.maybe.app(PS.Data.Maybe.Module.Nothing).app(go)
              .app(PS.Data.Array.Module.index.app(xs).app(i));
          })
      }
    }
  };
}