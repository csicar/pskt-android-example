@file:Suppress("UNCHECKED_CAST")

package PS.Data.List.NonEmpty
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val zipWith = { f : Any ->
     { v : Any ->
       { v1 : Any ->
         when {
          (v is PS.Data.NonEmpty.Module._Type_NonEmpty
                  .NonEmpty)&& (v1 is PS.Data.NonEmpty.Module._Type_NonEmpty
                                        .NonEmpty) -> {
            val f1 = f;
            val x = v.value0;
            val xs = v.value1;
            val y = v1.value0;
            val ys = v1.value1;
            PS.Data.List.Types.Module.NonEmptyList
              .app(PS.Data.NonEmpty.Module.NonEmpty.app(f1.app(x).app(y))
                     .app(PS.Data.List.Module.zipWith.app(f1).app(xs).app(ys)));
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    }
  };
  @JvmField
  val zipWithA = { dictApplicative : Any ->
     { f : Any ->
       { xs : Any ->
         { ys : Any ->
           PS.Data.Semigroup.Traversable.Module.sequence1
             .app(PS.Data.List.Types.Module.traversable1NonEmptyList)
             .app((dictApplicative as Map<String, Any>)["Apply0"]!!.app(Unit))
             .app(PS.Data.List.NonEmpty.Module.zipWith.app(f).app(xs).app(ys))
        }
      }
    }
  };
  @JvmField
  val zip = PS.Data.List.NonEmpty.Module.zipWith
              .app(PS.Data.Tuple.Module.Tuple);
  @JvmField
  val wrappedOperation2 = { name : Any ->
     { f : Any ->
       { v : Any ->
         { v1 : Any ->
           when {
            (v is PS.Data.NonEmpty.Module._Type_NonEmpty
                    .NonEmpty)&& (v1 is PS.Data.NonEmpty.Module._Type_NonEmpty
                                          .NonEmpty) -> {
              val name1 = name;
              val f1 = f;
              val x = v.value0;
              val xs = v.value1;
              val y = v1.value0;
              val ys = v1.value1;
              object   {
                  val v2 = f1.app(PS.Data.List.Types.Module.Cons.app(x).app(xs))
                             .app(PS.Data.List.Types.Module.Cons.app(y).app(ys)
                  );
                }
                .run({
                  val v2 = this.v2;
                  when {
                    (v2 is PS.Data.List.Types.Module._Type_List.Cons) -> {
                      val x_tick = v2.value0;
                      val xs_tick = v2.value1;
                      PS.Data.List.Types.Module.NonEmptyList
                        .app(PS.Data.NonEmpty.Module.NonEmpty.app(x_tick)
                               .app(xs_tick));
                    }
                    (v2 is PS.Data.List.Types.Module._Type_List.Nil) -> {
                      PS.Partial.Unsafe.Module.unsafeCrashWith
                        .app(
                        (("Impossible: empty list in NonEmptyList " as String) + (name1 as String))
                      );
                    }
                    else -> (error("Error in Pattern Match") as Any)
                  };
                });
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      }
    }
  };
  @JvmField
  val wrappedOperation = { name : Any ->
     { f : Any ->
       { v : Any ->
         when {
          (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
            val name1 = name;
            val f1 = f;
            val x = v.value0;
            val xs = v.value1;
            object   {
                val v1 = f1.app(PS.Data.List.Types.Module.Cons.app(x).app(xs));
              }
              .run({
                val v1 = this.v1;
                when {
                  (v1 is PS.Data.List.Types.Module._Type_List.Cons) -> {
                    val x_tick = v1.value0;
                    val xs_tick = v1.value1;
                    PS.Data.List.Types.Module.NonEmptyList
                      .app(PS.Data.NonEmpty.Module.NonEmpty.app(x_tick)
                             .app(xs_tick));
                  }
                  (v1 is PS.Data.List.Types.Module._Type_List.Nil) -> {
                    PS.Partial.Unsafe.Module.unsafeCrashWith
                      .app(
                      (("Impossible: empty list in NonEmptyList " as String) + (name1 as String))
                    );
                  }
                  else -> (error("Error in Pattern Match") as Any)
                };
              });
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    }
  };
  @JvmField
  val updateAt = { i : Any ->
     { a : Any ->
       { v : Any ->
         when {
          (v is PS.Data.NonEmpty.Module._Type_NonEmpty
                  .NonEmpty)&& (PS.Data.Eq.Module.eq
                                  .app(PS.Data.Eq.Module.eqInt)
                                  .app(i)
                                  .app(0) as Boolean) -> {
            val i1 = i;
            val a1 = a;
            val x = v.value0;
            val xs = v.value1;
            PS.Data.Maybe.Module.Just
              .app(PS.Data.List.Types.Module.NonEmptyList
                     .app(PS.Data.NonEmpty.Module.NonEmpty.app(a1).app(xs)));
          }
          (v is PS.Data.NonEmpty.Module._Type_NonEmpty
                  .NonEmpty)&&
          (PS.Data.Boolean.Module.otherwise as Boolean) -> {
            val i1 = i;
            val a1 = a;
            val x = v.value0;
            val xs = v.value1;
            PS.Data.Functor.Module.map.app(PS.Data.Maybe.Module.functorMaybe)
              .app(PS.Control.Semigroupoid.Module.compose
                     .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                     .app(PS.Data.List.Types.Module.NonEmptyList)
                     .app({ v1 : Any ->
                     PS.Data.NonEmpty.Module.NonEmpty.app(x).app(v1)
                  }))
              .app(PS.Data.List.Module.updateAt
                     .app(PS.Data.Ring.Module.sub
                            .app(PS.Data.Ring.Module.ringInt)
                            .app(i1)
                            .app(1))
                     .app(a1)
                     .app(xs));
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    }
  };
  @JvmField
  val unzip = { ts : Any ->
     PS.Data.Tuple.Module.Tuple
       .app(PS.Data.Functor.Module.map
              .app(PS.Data.List.Types.Module.functorNonEmptyList)
              .app(PS.Data.Tuple.Module.fst)
              .app(ts))
       .app(PS.Data.Functor.Module.map
              .app(PS.Data.List.Types.Module.functorNonEmptyList)
              .app(PS.Data.Tuple.Module.snd)
              .app(ts))
  };
  @JvmField
  val unsnoc = { v : Any ->
     when {
      (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
        val x = v.value0;
        val xs = v.value1;
        object   {
            val v1 = PS.Data.List.Module.unsnoc.app(xs);
          }
          .run({
            val v1 = this.v1;
            when {
              (v1 is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                mapOf(("init" to PS.Data.List.Types.Module.Nil),  ("last" to x)
                );
              }
              (v1 is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
                val un = v1.value0;
                mapOf(("init" to PS.Data.List.Types.Module.Cons.app(x)
                                   .app((un as Map<String, Any>)["init"]!!)),  
                  ("last" to (un as Map<String, Any>)["last"]!!));
              }
              else -> (error("Error in Pattern Match") as Any)
            };
          });
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val unionBy = PS.Control.Semigroupoid.Module.compose
                  .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                  .app(PS.Data.List.NonEmpty.Module.wrappedOperation2
                         .app("unionBy"))
                  .app(PS.Data.List.Module.unionBy);
  @JvmField
  val union = { dictEq : Any ->
     PS.Data.List.NonEmpty.Module.wrappedOperation2.app("union")
       .app(PS.Data.List.Module.union.app(dictEq))
  };
  @JvmField
  val uncons = { v : Any ->
     when {
      (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
        val x = v.value0;
        val xs = v.value1;
        mapOf(("head" to x),  ("tail" to xs));
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
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
  val toUnfoldable = { dictUnfoldable : Any ->
     PS.Control.Semigroupoid.Module.compose
       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
       .app(PS.Data.Unfoldable.Module.unfoldr.app(dictUnfoldable)
              .app({ xs : Any ->
              PS.Data.Functor.Module.map.app(PS.Data.Maybe.Module.functorMaybe)
                .app({ rec : Any ->
                     PS.Data.Tuple.Module.Tuple
                       .app((rec as Map<String, Any>)["head"]!!)
                       .app((rec as Map<String, Any>)["tail"]!!)
                  })
                .app(PS.Data.List.Module.uncons.app(xs))
           }))
       .app(PS.Data.List.NonEmpty.Module.toList)
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
  val sortBy = PS.Control.Semigroupoid.Module.compose
                 .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                 .app(PS.Data.List.NonEmpty.Module.wrappedOperation
                        .app("sortBy"))
                 .app(PS.Data.List.Module.sortBy);
  @JvmField
  val sort = { dictOrd : Any ->
     { xs : Any ->
       PS.Data.List.NonEmpty.Module.sortBy
         .app(PS.Data.Ord.Module.compare.app(dictOrd))
         .app(xs)
    }
  };
  @JvmField
  val snoc = { v : Any ->
     { y : Any ->
       when {
        (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
          val x = v.value0;
          val xs = v.value1;
          val y1 = y;
          PS.Data.List.Types.Module.NonEmptyList
            .app(PS.Data.NonEmpty.Module.NonEmpty.app(x)
                   .app(PS.Data.List.Module.snoc.app(xs).app(y1)));
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val singleton = PS.Control.Semigroupoid.Module.compose
                    .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                    .app(PS.Data.List.Types.Module.NonEmptyList)
                    .app(PS.Data.NonEmpty.Module.singleton
                           .app(PS.Data.List.Types.Module.plusList));
  @JvmField
  val snoc_tick = { v : Any ->
     { y : Any ->
       when {
        (v is PS.Data.List.Types.Module._Type_List.Cons) -> {
          val x = v.value0;
          val xs = v.value1;
          val y1 = y;
          PS.Data.List.Types.Module.NonEmptyList
            .app(PS.Data.NonEmpty.Module.NonEmpty.app(x)
                   .app(PS.Data.List.Module.snoc.app(xs).app(y1)));
        }
        (v is PS.Data.List.Types.Module._Type_List.Nil) -> {
          val y1 = y;
          PS.Data.List.NonEmpty.Module.singleton.app(y1);
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val reverse = PS.Data.List.NonEmpty.Module.wrappedOperation.app("reverse")
                  .app(PS.Data.List.Module.reverse);
  @JvmField
  val nubBy = PS.Control.Semigroupoid.Module.compose
                .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                .app(PS.Data.List.NonEmpty.Module.wrappedOperation.app("nubBy"))
                .app(PS.Data.List.Module.nubBy);
  @JvmField
  val nub = { dictEq : Any ->
     PS.Data.List.NonEmpty.Module.wrappedOperation.app("nub")
       .app(PS.Data.List.Module.nub.app(dictEq))
  };
  @JvmField
  val modifyAt = { i : Any ->
     { f : Any ->
       { v : Any ->
         when {
          (v is PS.Data.NonEmpty.Module._Type_NonEmpty
                  .NonEmpty)&& (PS.Data.Eq.Module.eq
                                  .app(PS.Data.Eq.Module.eqInt)
                                  .app(i)
                                  .app(0) as Boolean) -> {
            val i1 = i;
            val f1 = f;
            val x = v.value0;
            val xs = v.value1;
            PS.Data.Maybe.Module.Just
              .app(PS.Data.List.Types.Module.NonEmptyList
                     .app(PS.Data.NonEmpty.Module.NonEmpty.app(f1.app(x))
                            .app(xs)));
          }
          (v is PS.Data.NonEmpty.Module._Type_NonEmpty
                  .NonEmpty)&&
          (PS.Data.Boolean.Module.otherwise as Boolean) -> {
            val i1 = i;
            val f1 = f;
            val x = v.value0;
            val xs = v.value1;
            PS.Data.Functor.Module.map.app(PS.Data.Maybe.Module.functorMaybe)
              .app(PS.Control.Semigroupoid.Module.compose
                     .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                     .app(PS.Data.List.Types.Module.NonEmptyList)
                     .app({ v1 : Any ->
                     PS.Data.NonEmpty.Module.NonEmpty.app(x).app(v1)
                  }))
              .app(PS.Data.List.Module.modifyAt
                     .app(PS.Data.Ring.Module.sub
                            .app(PS.Data.Ring.Module.ringInt)
                            .app(i1)
                            .app(1))
                     .app(f1)
                     .app(xs));
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    }
  };
  @JvmField
  val mapWithIndex = PS.Data.FunctorWithIndex.Module.mapWithIndex
                       .app(
    PS.Data.List.Types.Module.functorWithIndexNonEmptyList);
  @JvmField
  val lift = { f : Any ->
     { v : Any ->
       when {
        (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
          val f1 = f;
          val x = v.value0;
          val xs = v.value1;
          f1.app(PS.Data.List.Types.Module.Cons.app(x).app(xs));
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val mapMaybe = PS.Control.Semigroupoid.Module.compose
                   .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                   .app(PS.Data.List.NonEmpty.Module.lift)
                   .app(PS.Data.List.Module.mapMaybe);
  @JvmField
  val partition = PS.Control.Semigroupoid.Module.compose
                    .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                    .app(PS.Data.List.NonEmpty.Module.lift)
                    .app(PS.Data.List.Module.partition);
  @JvmField
  val span = PS.Control.Semigroupoid.Module.compose
               .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
               .app(PS.Data.List.NonEmpty.Module.lift)
               .app(PS.Data.List.Module.span);
  @JvmField
  val take = PS.Control.Semigroupoid.Module.compose
               .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
               .app(PS.Data.List.NonEmpty.Module.lift)
               .app(PS.Data.List.Module.take);
  @JvmField
  val takeWhile = PS.Control.Semigroupoid.Module.compose
                    .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                    .app(PS.Data.List.NonEmpty.Module.lift)
                    .app(PS.Data.List.Module.takeWhile);
  @JvmField
  val length = { v : Any ->
     when {
      (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
        val x = v.value0;
        val xs = v.value1;
        PS.Data.Semiring.Module.add.app(PS.Data.Semiring.Module.semiringInt)
          .app(1)
          .app(PS.Data.List.Module.length.app(xs));
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val last = { v : Any ->
     when {
      (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
        val x = v.value0;
        val xs = v.value1;
        PS.Data.Maybe.Module.fromMaybe.app(x)
          .app(PS.Data.List.Module.last.app(xs));
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val intersectBy = PS.Control.Semigroupoid.Module.compose
                      .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                      .app(PS.Data.List.NonEmpty.Module.wrappedOperation2
                             .app("intersectBy"))
                      .app(PS.Data.List.Module.intersectBy);
  @JvmField
  val intersect = { dictEq : Any ->
     PS.Data.List.NonEmpty.Module.wrappedOperation2.app("intersect")
       .app(PS.Data.List.Module.intersect.app(dictEq))
  };
  @JvmField
  val insertAt = { i : Any ->
     { a : Any ->
       { v : Any ->
         when {
          (v is PS.Data.NonEmpty.Module._Type_NonEmpty
                  .NonEmpty)&& (PS.Data.Eq.Module.eq
                                  .app(PS.Data.Eq.Module.eqInt)
                                  .app(i)
                                  .app(0) as Boolean) -> {
            val i1 = i;
            val a1 = a;
            val x = v.value0;
            val xs = v.value1;
            PS.Data.Maybe.Module.Just
              .app(PS.Data.List.Types.Module.NonEmptyList
                     .app(PS.Data.NonEmpty.Module.NonEmpty.app(a1)
                            .app(PS.Data.List.Types.Module.Cons.app(x).app(xs)))
            );
          }
          (v is PS.Data.NonEmpty.Module._Type_NonEmpty
                  .NonEmpty)&&
          (PS.Data.Boolean.Module.otherwise as Boolean) -> {
            val i1 = i;
            val a1 = a;
            val x = v.value0;
            val xs = v.value1;
            PS.Data.Functor.Module.map.app(PS.Data.Maybe.Module.functorMaybe)
              .app(PS.Control.Semigroupoid.Module.compose
                     .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                     .app(PS.Data.List.Types.Module.NonEmptyList)
                     .app({ v1 : Any ->
                     PS.Data.NonEmpty.Module.NonEmpty.app(x).app(v1)
                  }))
              .app(PS.Data.List.Module.insertAt
                     .app(PS.Data.Ring.Module.sub
                            .app(PS.Data.Ring.Module.ringInt)
                            .app(i1)
                            .app(1))
                     .app(a1)
                     .app(xs));
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    }
  };
  @JvmField
  val _init = { v : Any ->
     when {
      (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
        val x = v.value0;
        val xs = v.value1;
        PS.Data.Maybe.Module.maybe.app(PS.Data.List.Types.Module.Nil)
          .app({ v1 : Any ->
               PS.Data.List.Types.Module.Cons.app(x).app(v1)
            })
          .app(PS.Data.List.Module._init.app(xs));
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val index = { v : Any ->
     { i : Any ->
       when {
        (v is PS.Data.NonEmpty.Module._Type_NonEmpty
                .NonEmpty)&& (PS.Data.Eq.Module.eq.app(PS.Data.Eq.Module.eqInt)
                                .app(i)
                                .app(0) as Boolean) -> {
          val x = v.value0;
          val xs = v.value1;
          val i1 = i;
          PS.Data.Maybe.Module.Just.app(x);
        }
        (v is PS.Data.NonEmpty.Module._Type_NonEmpty
                .NonEmpty)&& (PS.Data.Boolean.Module.otherwise as Boolean) -> {
          val x = v.value0;
          val xs = v.value1;
          val i1 = i;
          PS.Data.List.Module.index.app(xs)
            .app(PS.Data.Ring.Module.sub.app(PS.Data.Ring.Module.ringInt)
                   .app(i1)
                   .app(1));
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
  val groupBy = PS.Control.Semigroupoid.Module.compose
                  .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                  .app(PS.Data.List.NonEmpty.Module.wrappedOperation
                         .app("groupBy"))
                  .app(PS.Data.List.Module.groupBy);
  @JvmField
  val group_tick = { dictOrd : Any ->
     PS.Data.List.NonEmpty.Module.wrappedOperation.app("group'")
       .app(PS.Data.List.Module.group_tick.app(dictOrd))
  };
  @JvmField
  val group = { dictEq : Any ->
     PS.Data.List.NonEmpty.Module.wrappedOperation.app("group")
       .app(PS.Data.List.Module.group.app(dictEq))
  };
  @JvmField
  val fromList = { v : Any ->
     when {
      (v is PS.Data.List.Types.Module._Type_List.Nil) -> {
        PS.Data.Maybe.Module.Nothing;
      }
      (v is PS.Data.List.Types.Module._Type_List.Cons) -> {
        val x = v.value0;
        val xs = v.value1;
        PS.Data.Maybe.Module.Just
          .app(PS.Data.List.Types.Module.NonEmptyList
                 .app(PS.Data.NonEmpty.Module.NonEmpty.app(x).app(xs)));
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val fromFoldable = { dictFoldable : Any ->
     PS.Control.Semigroupoid.Module.compose
       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
       .app(PS.Data.List.NonEmpty.Module.fromList)
       .app(PS.Data.List.Module.fromFoldable.app(dictFoldable))
  };
  @JvmField
  val foldM = { dictMonad : Any ->
     { f : Any ->
       { a : Any ->
         { v : Any ->
           when {
            (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
              val f1 = f;
              val a1 = a;
              val b = v.value0;
              val bs = v.value1;
              PS.Control.Bind.Module.bind
                .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
                .app(f1.app(a1).app(b))
                .app({ a_tick : Any ->
                   PS.Data.List.Module.foldM.app(dictMonad).app(f1).app(a_tick)
                     .app(bs)
                });
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      }
    }
  };
  @JvmField
  val findLastIndex = { f : Any ->
     { v : Any ->
       when {
        (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
          val f1 = f;
          val x = v.value0;
          val xs = v.value1;
          object   {
              val v1 = PS.Data.List.Module.findLastIndex.app(f1).app(xs);
            }
            .run({
              val v1 = this.v1;
              when {
                (v1 is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
                  val i = v1.value0;
                  PS.Data.Maybe.Module.Just
                    .app(PS.Data.Semiring.Module.add
                           .app(PS.Data.Semiring.Module.semiringInt)
                           .app(i)
                           .app(1));
                }
                (v1 is PS.Data.Maybe.Module._Type_Maybe
                         .Nothing)&& (f1.app(x) as Boolean) -> {
                  PS.Data.Maybe.Module.Just.app(0);
                }
                (v1 is PS.Data.Maybe.Module._Type_Maybe
                         .Nothing)&&
                (PS.Data.Boolean.Module.otherwise as Boolean) -> {
                  PS.Data.Maybe.Module.Nothing;
                }
                else -> (error("Error in Pattern Match") as Any)
              };
            });
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val findIndex = { f : Any ->
     { v : Any ->
       when {
        (v is PS.Data.NonEmpty.Module._Type_NonEmpty
                .NonEmpty)&& (f.app(v.value0) as Boolean) -> {
          val f1 = f;
          val x = v.value0;
          val xs = v.value1;
          PS.Data.Maybe.Module.Just.app(0);
        }
        (v is PS.Data.NonEmpty.Module._Type_NonEmpty
                .NonEmpty)&& (PS.Data.Boolean.Module.otherwise as Boolean) -> {
          val f1 = f;
          val x = v.value0;
          val xs = v.value1;
          PS.Data.Functor.Module.map.app(PS.Data.Maybe.Module.functorMaybe)
            .app({ v1 : Any ->
                 PS.Data.Semiring.Module.add
                   .app(PS.Data.Semiring.Module.semiringInt)
                   .app(v1)
                   .app(1)
              })
            .app(PS.Data.List.Module.findIndex.app(f1).app(xs));
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val filterM = { dictMonad : Any ->
     PS.Control.Semigroupoid.Module.compose
       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
       .app(PS.Data.List.NonEmpty.Module.lift)
       .app(PS.Data.List.Module.filterM.app(dictMonad))
  };
  @JvmField
  val filter = PS.Control.Semigroupoid.Module.compose
                 .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                 .app(PS.Data.List.NonEmpty.Module.lift)
                 .app(PS.Data.List.Module.filter);
  @JvmField
  val elemLastIndex = { dictEq : Any ->
     { x : Any ->
       PS.Data.List.NonEmpty.Module.findLastIndex
         .app({ v : Any ->
           PS.Data.Eq.Module.eq.app(dictEq).app(v).app(x)
        })
    }
  };
  @JvmField
  val elemIndex = { dictEq : Any ->
     { x : Any ->
       PS.Data.List.NonEmpty.Module.findIndex
         .app({ v : Any ->
           PS.Data.Eq.Module.eq.app(dictEq).app(v).app(x)
        })
    }
  };
  @JvmField
  val dropWhile = PS.Control.Semigroupoid.Module.compose
                    .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                    .app(PS.Data.List.NonEmpty.Module.lift)
                    .app(PS.Data.List.Module.dropWhile);
  @JvmField
  val drop = PS.Control.Semigroupoid.Module.compose
               .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
               .app(PS.Data.List.NonEmpty.Module.lift)
               .app(PS.Data.List.Module.drop);
  @JvmField
  val cons_tick = { x : Any ->
     { xs : Any ->
       PS.Data.List.Types.Module.NonEmptyList
         .app(PS.Data.NonEmpty.Module.NonEmpty.app(x).app(xs))
    }
  };
  @JvmField
  val cons = { y : Any ->
     { v : Any ->
       when {
        (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
          val y1 = y;
          val x = v.value0;
          val xs = v.value1;
          PS.Data.List.Types.Module.NonEmptyList
            .app(PS.Data.NonEmpty.Module.NonEmpty.app(y1)
                   .app(PS.Data.List.Types.Module.Cons.app(x).app(xs)));
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val concatMap = PS.Data.Function.Module.flip
                    .app(PS.Control.Bind.Module.bind
                           .app(PS.Data.List.Types.Module.bindNonEmptyList));
  @JvmField
  val concat = { v : Any ->
     PS.Control.Bind.Module.bind.app(PS.Data.List.Types.Module.bindNonEmptyList)
       .app(v)
       .app(PS.Control.Category.Module.identity
              .app(PS.Control.Category.Module.categoryFn))
  };
  @JvmField
  val catMaybes = PS.Data.List.NonEmpty.Module.lift
                    .app(PS.Data.List.Module.catMaybes);
  @JvmField
  val appendFoldable = { dictFoldable : Any ->
     { v : Any ->
       { ys : Any ->
         when {
          (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
            val x = v.value0;
            val xs = v.value1;
            val ys1 = ys;
            PS.Data.List.Types.Module.NonEmptyList
              .app(PS.Data.NonEmpty.Module.NonEmpty.app(x)
                     .app(PS.Data.Semigroup.Module.append
                            .app(PS.Data.List.Types.Module.semigroupList)
                            .app(xs)
                            .app(PS.Data.List.Module.fromFoldable
                                   .app(dictFoldable)
                                   .app(ys1))));
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    }
  };
}