@file:Suppress("UNCHECKED_CAST")

package PS.Data.List
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val Pattern = { x : Any -> x};
  @JvmField val updateAt = (::__rec_updateAt)();
  fun __rec_updateAt(): Any = { v : Any ->
     { v1 : Any ->
       { v2 : Any ->
         when {
          (v == 0)&& (v2 is PS.Data.List.Types.Module._Type_List.Cons) -> {
            val x = v1;
            val xs = v2.value1;
            PS.Data.Maybe.Module.Just
              .app(PS.Data.List.Types.Module.Cons.app(x).app(xs));
          }
          (v2 is PS.Data.List.Types.Module._Type_List.Cons) -> {
            val n = v;
            val x = v1;
            val x1 = v2.value0;
            val xs = v2.value1;
            PS.Data.Functor.Module.map.app(PS.Data.Maybe.Module.functorMaybe)
              .app({ v3 : Any ->
                   PS.Data.List.Types.Module.Cons.app(x1).app(v3)
                })
              .app(PS.Data.List.Module.updateAt
                     .app(PS.Data.Ring.Module.sub
                            .app(PS.Data.Ring.Module.ringInt)
                            .app(n)
                            .app(1))
                     .app(x)
                     .app(xs));
          }
          else -> {
            PS.Data.Maybe.Module.Nothing;
          }
        }
      }
    }
  };
  @JvmField
  val unzip = PS.Data.Foldable.Module.foldr
                .app(PS.Data.List.Types.Module.foldableList)
                .app({ v : Any ->
                     when {
                      (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                        val a = v.value0;
                        val b = v.value1;
                        { v1 : Any ->
                           when {
                            (v1 is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                              val _as = v1.value0;
                              val bs = v1.value1;
                              PS.Data.Tuple.Module.Tuple
                                .app(PS.Data.List.Types.Module.Cons.app(a)
                                       .app(_as))
                                .app(PS.Data.List.Types.Module.Cons.app(b)
                                       .app(bs));
                            }
                            else -> (error("Error in Pattern Match") as Any)
                          }
                        };
                      }
                      else -> (error("Error in Pattern Match") as Any)
                    }
                  })
                .app(PS.Data.Tuple.Module.Tuple
                       .app(PS.Data.List.Types.Module.Nil)
                       .app(PS.Data.List.Types.Module.Nil));
  @JvmField
  val uncons = { v : Any ->
     when {
      (v is PS.Data.List.Types.Module._Type_List.Nil) -> {
        PS.Data.Maybe.Module.Nothing;
      }
      (v is PS.Data.List.Types.Module._Type_List.Cons) -> {
        val x = v.value0;
        val xs = v.value1;
        PS.Data.Maybe.Module.Just.app(mapOf(("head" to x),  ("tail" to xs)));
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val toUnfoldable = { dictUnfoldable : Any ->
     PS.Data.Unfoldable.Module.unfoldr.app(dictUnfoldable)
       .app({ xs : Any ->
         PS.Data.Functor.Module.map.app(PS.Data.Maybe.Module.functorMaybe)
           .app({ rec : Any ->
                PS.Data.Tuple.Module.Tuple
                  .app((rec as Map<String, Any>)["head"]!!)
                  .app((rec as Map<String, Any>)["tail"]!!)
             })
           .app(PS.Data.List.Module.uncons.app(xs))
      })
  };
  @JvmField
  val tail = { v : Any ->
     when {
      (v is PS.Data.List.Types.Module._Type_List.Nil) -> {
        PS.Data.Maybe.Module.Nothing;
      }
      (v is PS.Data.List.Types.Module._Type_List.Cons) -> {
        val xs = v.value1;
        PS.Data.Maybe.Module.Just.app(xs);
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val stripPrefix = { dictEq : Any ->
     { v : Any ->
       { s : Any ->
        val p_tick = v;
          val s1 = s;
          object   {
              val go = { prefix : Any ->
                 { input : Any ->
                   when {
                    (prefix is PS.Data.List.Types.Module._Type_List
                                 .Cons)&&
                    (input is PS.Data.List.Types.Module._Type_List
                                .Cons)&& (PS.Data.Eq.Module.eq.app(dictEq)
                                            .app(prefix
                                                   .value0)
                                            .app(input
                                                   .value0) as Boolean) -> {
                      val p = prefix.value0;
                      val ps = prefix.value1;
                      val i = input.value0;
                      val _is = input.value1;
                      PS.Data.Function.Module.apply
                        .app(PS.Data.Maybe.Module.Just)
                        .app(PS.Control.Monad.Rec.Class.Module.Loop
                               .app(mapOf(("a" to ps),  ("b" to _is))));
                    }
                    (prefix is PS.Data.List.Types.Module._Type_List.Nil) -> {
                      val _is = input;
                      PS.Data.Function.Module.apply
                        .app(PS.Data.Maybe.Module.Just)
                        .app(PS.Control.Monad.Rec.Class.Module.Done.app(_is));
                    }
                    else -> {
                      PS.Data.Maybe.Module.Nothing;
                    }
                  }
                }
              };
            }
            .run({
              val go = this.go;
              PS.Control.Monad.Rec.Class.Module.tailRecM2
                .app(PS.Control.Monad.Rec.Class.Module.monadRecMaybe)
                .app(go)
                .app(p_tick)
                .app(s1);
            });}
    }
  };
  @JvmField val span = (::__rec_span)();
  fun __rec_span(): Any = { v : Any ->
     { v1 : Any ->
       when {
        (v1 is PS.Data.List.Types.Module._Type_List
                 .Cons)&& (v.app(v1.value0) as Boolean) -> {
          val p = v;
          val x = v1.value0;
          val xs_tick = v1.value1;
          object   {
              val v2 = PS.Data.List.Module.span.app(p).app(xs_tick);
            }
            .run({
              val v2 = this.v2;
              when {
                ((v2 as Map<String, Any>).size == 2) -> {
                  val ys = v2["init"]!!;
                  val zs = v2["rest"]!!;
                  mapOf(("init" to PS.Data.List.Types.Module.Cons.app(x)
                                     .app(ys)),  ("rest" to zs));
                }
                else -> (error("Error in Pattern Match") as Any)
              };
            });
        }
        else -> {
          val xs = v1;
          mapOf(("init" to PS.Data.List.Types.Module.Nil),  ("rest" to xs));
        }
      }
    }
  };
  @JvmField
  val snoc = { xs : Any ->
     { x : Any ->
       PS.Data.Foldable.Module.foldr.app(PS.Data.List.Types.Module.foldableList)
         .app(PS.Data.List.Types.Module.Cons)
         .app(PS.Data.List.Types.Module.Cons.app(x)
                .app(PS.Data.List.Types.Module.Nil))
         .app(xs)
    }
  };
  @JvmField
  val singleton = { a : Any ->
     PS.Data.List.Types.Module.Cons.app(a).app(PS.Data.List.Types.Module.Nil)
  };
  @JvmField
  val sortBy = { cmp : Any ->
     object   {
         val merge = (::__rec_merge)();
         val mergePairs = (::__rec_mergePairs)();
         val mergeAll = (::__rec_mergeAll)();
         val sequences = (::__rec_sequences)();
         val descending = (::__rec_descending)();
         val ascending = (::__rec_ascending)();
         fun __rec_merge(): Any = { v : Any ->
            { v1 : Any ->
              when {
               (v is PS.Data.List.Types.Module._Type_List
                       .Cons)&& (v1 is PS.Data.List.Types.Module._Type_List
                                         .Cons)&& (PS.Data.Eq.Module.eq
                                                     .app(
                                                       PS.Data.Ordering.Module.eqOrdering
                                                     )
                                                     .app(cmp.app(v.value0)
                                                            .app(v1
                                                                   .value0))
                                                     .app(
                 PS.Data.Ordering.Module.GT) as Boolean) -> {
                 val _as = v;
                 val a = v.value0;
                 val as_tick = v.value1;
                 val bs = v1;
                 val b = v1.value0;
                 val bs_tick = v1.value1;
                 PS.Data.List.Types.Module.Cons.app(b)
                   .app(__rec_merge().app(_as).app(bs_tick));
               }
               (v is PS.Data.List.Types.Module._Type_List
                       .Cons)&& (v1 is PS.Data.List.Types.Module._Type_List
                                         .Cons)&&
               (PS.Data.Boolean.Module.otherwise as Boolean) -> {
                 val _as = v;
                 val a = v.value0;
                 val as_tick = v.value1;
                 val bs = v1;
                 val b = v1.value0;
                 val bs_tick = v1.value1;
                 PS.Data.List.Types.Module.Cons.app(a)
                   .app(__rec_merge().app(as_tick).app(bs));
               }
               (v is PS.Data.List.Types.Module._Type_List.Nil) -> {
                 val bs = v1;
                 bs;
               }
               (v1 is PS.Data.List.Types.Module._Type_List.Nil) -> {
                 val _as = v;
                 _as;
               }
               else -> (error("Error in Pattern Match") as Any)
             }
           }
         };
         fun __rec_mergePairs(): Any = { v : Any ->
            when {
             (v is PS.Data.List.Types.Module._Type_List
                     .Cons)&& (v
                                 .value1 is PS.Data.List.Types.Module._Type_List
                                              .Cons) -> {
               val a = v.value0;
               val b = v.value1.value0;
               val xs = v.value1.value1;
               PS.Data.List.Types.Module.Cons.app(merge.app(a).app(b))
                 .app(__rec_mergePairs().app(xs));
             }
             else -> {
               val xs = v;
               xs;
             }
           }
         };
         fun __rec_mergeAll(): Any = { v : Any ->
            when {
             (v is PS.Data.List.Types.Module._Type_List
                     .Cons)&& (v
                                 .value1 is PS.Data.List.Types.Module._Type_List
                                              .Nil) -> {
               val x = v.value0;
               x;
             }
             else -> {
               val xs = v;
               __rec_mergeAll().app(mergePairs.app(xs));
             }
           }
         };
         fun __rec_sequences(): Any = { v : Any ->
            when {
             (v is PS.Data.List.Types.Module._Type_List
                     .Cons)&& (v
                                 .value1 is PS.Data.List.Types.Module._Type_List
                                              .Cons)&& (PS.Data.Eq.Module.eq
                                                          .app(
                                                            PS.Data.Ordering.Module.eqOrdering
                                                          )
                                                          .app(cmp.app(v.value0)
                                                                 .app(v
                                                                        .value1
                                                                        .value0)
                                                          )
                                                          .app(
               PS.Data.Ordering.Module.GT) as Boolean) -> {
               val a = v.value0;
               val b = v.value1.value0;
               val xs = v.value1.value1;
               __rec_descending().app(b)
                 .app(PS.Data.List.Module.singleton.app(a))
                 .app(xs);
             }
             (v is PS.Data.List.Types.Module._Type_List
                     .Cons)&& (v
                                 .value1 is PS.Data.List.Types.Module._Type_List
                                              .Cons)&&
             (PS.Data.Boolean.Module.otherwise as Boolean) -> {
               val a = v.value0;
               val b = v.value1.value0;
               val xs = v.value1.value1;
               __rec_ascending().app(b)
                 .app({ v1 : Any ->
                      PS.Data.List.Types.Module.Cons.app(a).app(v1)
                   })
                 .app(xs);
             }
             else -> {
               val xs = v;
               PS.Data.List.Module.singleton.app(xs);
             }
           }
         };
         fun __rec_descending(): Any = { a : Any ->
            { _as : Any ->
              { v : Any ->
                when {
                 (v is PS.Data.List.Types.Module._Type_List
                         .Cons)&& (PS.Data.Eq.Module.eq
                                     .app(PS.Data.Ordering.Module.eqOrdering)
                                     .app(cmp.app(a).app(v.value0))
                                     .app(PS.Data.Ordering.Module.GT
                 ) as Boolean) -> {
                   val a1 = a;
                   val as1 = _as;
                   val b = v.value0;
                   val bs = v.value1;
                   __rec_descending().app(b)
                     .app(PS.Data.List.Types.Module.Cons.app(a1).app(as1))
                     .app(bs);
                 }
                 else -> {
                   val a1 = a;
                   val as1 = _as;
                   val bs = v;
                   PS.Data.List.Types.Module.Cons
                     .app(PS.Data.List.Types.Module.Cons.app(a1).app(as1))
                     .app(__rec_sequences().app(bs));
                 }
               }
             }
           }
         };
         fun __rec_ascending(): Any = { a : Any ->
            { _as : Any ->
              { v : Any ->
                when {
                 (v is PS.Data.List.Types.Module._Type_List
                         .Cons)&& (PS.Data.Eq.Module.notEq
                                     .app(PS.Data.Ordering.Module.eqOrdering)
                                     .app(cmp.app(a).app(v.value0))
                                     .app(PS.Data.Ordering.Module.GT
                 ) as Boolean) -> {
                   val a1 = a;
                   val as1 = _as;
                   val b = v.value0;
                   val bs = v.value1;
                   __rec_ascending().app(b)
                     .app({ ys : Any ->
                          as1
                            .app(PS.Data.List.Types.Module.Cons.app(a1).app(ys))
                       })
                     .app(bs);
                 }
                 else -> {
                   val a1 = a;
                   val as1 = _as;
                   val bs = v;
                   PS.Data.List.Types.Module.Cons
                     .app(PS.Data.Function.Module.apply.app(as1)
                            .app(PS.Data.List.Module.singleton.app(a1)))
                     .app(__rec_sequences().app(bs));
                 }
               }
             }
           }
         };
       }
       .run({
        val merge = this.merge;
        val mergePairs = this.mergePairs;
        val mergeAll = this.mergeAll;
        val sequences = this.sequences;
        val descending = this.descending;
        val ascending = this.ascending;
        PS.Control.Semigroupoid.Module.compose
          .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
          .app(mergeAll)
          .app(sequences);
      })
  };
  @JvmField
  val sort = { dictOrd : Any ->
     { xs : Any ->
       PS.Data.List.Module.sortBy.app(PS.Data.Ord.Module.compare.app(dictOrd))
         .app(xs)
    }
  };
  @JvmField val tails = (::__rec_tails)();
  fun __rec_tails(): Any = { v : Any ->
     when {
      (v is PS.Data.List.Types.Module._Type_List.Nil) -> {
        PS.Data.List.Module.singleton.app(PS.Data.List.Types.Module.Nil);
      }
      (v is PS.Data.List.Types.Module._Type_List.Cons) -> {
        val list = v;
        val tl = v.value1;
        PS.Data.List.Types.Module.Cons.app(list)
          .app(PS.Data.List.Module.tails.app(tl));
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val showPattern = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ v : Any ->
        val s = v;
          (("(Pattern " as String) + (((PS.Data.Show.Module.show
                                          .app(
                                            PS.Data.List.Types.Module.showList
                                              .app(dictShow))
                                          .app(s
          ) as String) + (")" as String)) as String));})
  };
  @JvmField
  val reverse = object   {
                    val go = (::__rec_go)();
                    fun __rec_go(): Any = { acc : Any ->
                       { v : Any ->
                         when {
                          (v is PS.Data.List.Types.Module._Type_List.Nil) -> {
                            val acc1 = acc;
                            acc1;
                          }
                          (v is PS.Data.List.Types.Module._Type_List.Cons) -> {
                            val acc1 = acc;
                            val x = v.value0;
                            val xs = v.value1;
                            __rec_go()
                              .app(PS.Data.List.Types.Module.Cons.app(x)
                                     .app(acc1))
                              .app(xs);
                          }
                          else -> (error("Error in Pattern Match") as Any)
                        }
                      }
                    };
                  }
                  .run({
      val go = this.go;
      go.app(PS.Data.List.Types.Module.Nil);
    });
  @JvmField
  val take = object   {
                 val go = (::__rec_go)();
                 fun __rec_go(): Any = { acc : Any ->
                    { v : Any ->
                      { v1 : Any ->
                        when {
                         (PS.Data.Ord.Module.lessThan
                            .app(PS.Data.Ord.Module.ordInt)
                            .app(v)
                            .app(1) as Boolean) -> {
                           val acc1 = acc;
                           val n = v;
                           PS.Data.List.Module.reverse.app(acc1);
                         }
                         (v1 is PS.Data.List.Types.Module._Type_List.Nil) -> {
                           val acc1 = acc;
                           PS.Data.List.Module.reverse.app(acc1);
                         }
                         (v1 is PS.Data.List.Types.Module._Type_List.Cons) -> {
                           val acc1 = acc;
                           val n = v;
                           val x = v1.value0;
                           val xs = v1.value1;
                           __rec_go()
                             .app(PS.Data.List.Types.Module.Cons.app(x)
                                    .app(acc1))
                             .app(PS.Data.Ring.Module.sub
                                    .app(PS.Data.Ring.Module.ringInt)
                                    .app(n)
                                    .app(1))
                             .app(xs);
                         }
                         else -> (error("Error in Pattern Match") as Any)
                       }
                     }
                   }
                 };
               }
               .run({
      val go = this.go;
      go.app(PS.Data.List.Types.Module.Nil);
    });
  @JvmField
  val takeWhile = { p : Any ->
     object   {
         val go = (::__rec_go)();
         fun __rec_go(): Any = { acc : Any ->
            { v : Any ->
              when {
               (v is PS.Data.List.Types.Module._Type_List
                       .Cons)&& (p.app(v.value0) as Boolean) -> {
                 val acc1 = acc;
                 val x = v.value0;
                 val xs = v.value1;
                 __rec_go().app(PS.Data.List.Types.Module.Cons.app(x).app(acc1))
                   .app(xs);
               }
               else -> {
                 val acc1 = acc;
                 PS.Data.List.Module.reverse.app(acc1);
               }
             }
           }
         };
       }
       .run({
        val go = this.go;
        go.app(PS.Data.List.Types.Module.Nil);
      })
  };
  @JvmField
  val unsnoc = { lst : Any ->
     object   {
         val go = (::__rec_go)();
         fun __rec_go(): Any = { v : Any ->
            { acc : Any ->
              when {
               (v is PS.Data.List.Types.Module._Type_List.Nil) -> {
                 val acc1 = acc;
                 PS.Data.Maybe.Module.Nothing;
               }
               (v is PS.Data.List.Types.Module._Type_List
                       .Cons)&& (v
                                   .value1 is PS.Data.List.Types.Module._Type_List
                                                .Nil) -> {
                 val x = v.value0;
                 val acc1 = acc;
                 PS.Data.Maybe.Module.Just
                   .app(mapOf(("revInit" to acc1),  ("last" to x)));
               }
               (v is PS.Data.List.Types.Module._Type_List.Cons) -> {
                 val x = v.value0;
                 val xs = v.value1;
                 val acc1 = acc;
                 __rec_go().app(xs)
                   .app(PS.Data.List.Types.Module.Cons.app(x).app(acc1));
               }
               else -> (error("Error in Pattern Match") as Any)
             }
           }
         };
       }
       .run({
        val go = this.go;
        PS.Data.Functor.Module.map.app(PS.Data.Maybe.Module.functorMaybe)
          .app({ h : Any ->
               mapOf(("init" to PS.Data.List.Module.reverse
                                  .app((h as Map<String, Any>)["revInit"]!!)),  
                ("last" to (h as Map<String, Any>)["last"]!!))
            })
          .app(go.app(lst).app(PS.Data.List.Types.Module.Nil));
      })
  };
  @JvmField
  val zipWith = { f : Any ->
     { xs : Any ->
       { ys : Any ->
         object   {
             val go = (::__rec_go)();
             fun __rec_go(): Any = { v : Any ->
                { v1 : Any ->
                  { acc : Any ->
                    when {
                     (v is PS.Data.List.Types.Module._Type_List.Nil) -> {
                       val acc1 = acc;
                       acc1;
                     }
                     (v1 is PS.Data.List.Types.Module._Type_List.Nil) -> {
                       val acc1 = acc;
                       acc1;
                     }
                     (v is PS.Data.List.Types.Module._Type_List
                             .Cons)&&
                     (v1 is PS.Data.List.Types.Module._Type_List
                              .Cons) -> {
                       val a = v.value0;
                       val _as = v.value1;
                       val b = v1.value0;
                       val bs = v1.value1;
                       val acc1 = acc;
                       PS.Data.Function.Module.apply
                         .app(__rec_go().app(_as).app(bs))
                         .app(PS.Data.List.Types.Module.Cons
                                .app(f.app(a).app(b))
                                .app(acc1));
                     }
                     else -> (error("Error in Pattern Match") as Any)
                   }
                 }
               }
             };
           }
           .run({
            val go = this.go;
            PS.Data.Function.Module.apply.app(PS.Data.List.Module.reverse)
              .app(go.app(xs).app(ys).app(PS.Data.List.Types.Module.Nil));
          })
      }
    }
  };
  @JvmField
  val zip = PS.Data.List.Module.zipWith.app(PS.Data.Tuple.Module.Tuple);
  @JvmField
  val zipWithA = { dictApplicative : Any ->
     { f : Any ->
       { xs : Any ->
         { ys : Any ->
           PS.Data.Traversable.Module.sequence
             .app(PS.Data.List.Types.Module.traversableList)
             .app(dictApplicative)
             .app(PS.Data.List.Module.zipWith.app(f).app(xs).app(ys))
        }
      }
    }
  };
  @JvmField
  val range = { start : Any ->
     { end : Any ->
       when {
        (PS.Data.Eq.Module.eq.app(PS.Data.Eq.Module.eqInt).app(start)
           .app(end) as Boolean) -> {
          val start1 = start;
          val end1 = end;
          PS.Data.List.Module.singleton.app(start1);
        }
        (PS.Data.Boolean.Module.otherwise as Boolean) -> {
          val start1 = start;
          val end1 = end;
          object   {
              val go = (::__rec_go)();
              fun __rec_go(): Any = { s : Any ->
                 { e : Any ->
                   { step : Any ->
                     { rest : Any ->
                       when {
                        (PS.Data.Eq.Module.eq.app(PS.Data.Eq.Module.eqInt)
                           .app(s)
                           .app(e) as Boolean) -> {
                          val s1 = s;
                          val e1 = e;
                          val step1 = step;
                          val rest1 = rest;
                          PS.Data.List.Types.Module.Cons.app(s1).app(rest1);
                        }
                        (PS.Data.Boolean.Module.otherwise as Boolean) -> {
                          val s1 = s;
                          val e1 = e;
                          val step1 = step;
                          val rest1 = rest;
                          __rec_go()
                            .app(PS.Data.Semiring.Module.add
                                   .app(PS.Data.Semiring.Module.semiringInt)
                                   .app(s1)
                                   .app(step1))
                            .app(e1)
                            .app(step1)
                            .app(PS.Data.List.Types.Module.Cons.app(s1)
                                   .app(rest1));
                        }
                        else -> (error("Error in Pattern Match") as Any)
                      }
                    }
                  }
                }
              };
            }
            .run({
              val go = this.go;
              go.app(end1).app(start1)
                .app(when {
                    (PS.Data.Ord.Module.greaterThan
                       .app(PS.Data.Ord.Module.ordInt)
                       .app(start1)
                       .app(end1) == true) -> {
                      1;
                    }
                    else -> {
                      PS.Data.Ring.Module.negate
                        .app(PS.Data.Ring.Module.ringInt)
                        .app(1);
                    }
                  })
                .app(PS.Data.List.Types.Module.Nil);
            });
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val partition = { p : Any ->
     { xs : Any ->
       object   {
           val select = { x : Any ->
              { v : Any ->
                when {
                 ((v as Map<String, Any>).size == 2) -> {
                   val x1 = x;
                   val no = v["no"]!!;
                   val yes = v["yes"]!!;
                   when {
                     (p.app(x1) == true) -> {
                       mapOf(("no" to no),  
                         ("yes" to PS.Data.List.Types.Module.Cons.app(x1)
                                     .app(yes)));
                     }
                     else -> {
                       mapOf(("no" to PS.Data.List.Types.Module.Cons.app(x1)
                                        .app(no)),  ("yes" to yes));
                     }
                   };
                 }
                 else -> (error("Error in Pattern Match") as Any)
               }
             }
           };
         }
         .run({
          val select = this.select;
          PS.Data.Foldable.Module.foldr
            .app(PS.Data.List.Types.Module.foldableList)
            .app(select)
            .app(mapOf(("no" to PS.Data.List.Types.Module.Nil),  
                ("yes" to PS.Data.List.Types.Module.Nil)))
            .app(xs);
        })
    }
  };
  @JvmField
  val _null = { v : Any ->
     when {
      (v is PS.Data.List.Types.Module._Type_List.Nil) -> {
        true;
      }
      else -> {
        false;
      }
    }
  };
  @JvmField
  val newtypePattern = PS.Data.Newtype.Module.Newtype
                         .app({ n : Any ->
                             val a = n;
                               a;})
                         .app(PS.Data.List.Module.Pattern);
  @JvmField
  val mapWithIndex = PS.Data.FunctorWithIndex.Module.mapWithIndex
                       .app(PS.Data.List.Types.Module.functorWithIndexList);
  @JvmField
  val mapMaybe = { f : Any ->
     object   {
         val go = (::__rec_go)();
         fun __rec_go(): Any = { acc : Any ->
            { v : Any ->
              when {
               (v is PS.Data.List.Types.Module._Type_List.Nil) -> {
                 val acc1 = acc;
                 PS.Data.List.Module.reverse.app(acc1);
               }
               (v is PS.Data.List.Types.Module._Type_List.Cons) -> {
                 val acc1 = acc;
                 val x = v.value0;
                 val xs = v.value1;
                 object   {
                     val v1 = f.app(x);
                   }
                   .run({
                     val v1 = this.v1;
                     when {
                       (v1 is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                         __rec_go().app(acc1).app(xs);
                       }
                       (v1 is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
                         val y = v1.value0;
                         __rec_go()
                           .app(PS.Data.List.Types.Module.Cons.app(y).app(acc1))
                           .app(xs);
                       }
                       else -> (error("Error in Pattern Match") as Any)
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
        go.app(PS.Data.List.Types.Module.Nil);
      })
  };
  @JvmField
  val manyRec = { dictMonadRec : Any ->
     { dictAlternative : Any ->
       { p : Any ->
         object   {
             val go = { acc : Any ->
                PS.Control.Bind.Module.bind
                  .app(((dictMonadRec as Map<String, Any>)["Monad0"]!!
                          .app(Unit) as Map<String, Any>)["Bind1"]!!
                         .app(Unit))
                  .app(PS.Control.Alt.Module.alt
                         .app(((dictAlternative as Map<String, Any>)["Plus1"]!!
                                 .app(Unit) as Map<String, Any>)["Alt0"]!!
                                .app(Unit))
                         .app(PS.Data.Functor.Module.map
                                .app(
                                  (((dictAlternative as Map<String, Any>)["Plus1"]!!
                                      .app(Unit) as Map<String, Any>)["Alt0"]!!
                                     .app(Unit
                                    ) as Map<String, Any>)["Functor0"]!!
                                    .app(Unit))
                                .app(PS.Control.Monad.Rec.Class.Module.Loop)
                                .app(p))
                         .app(PS.Control.Applicative.Module.pure
                                .app(
                                  (dictAlternative as Map<String, Any>)["Applicative0"]!!
                                    .app(Unit))
                                .app(PS.Control.Monad.Rec.Class.Module.Done
                                       .app(PS.Data.Unit.Module.unit))))
                  .app({ v : Any ->
                   val aa = v;
                     PS.Data.Function.Module.apply
                       .app(PS.Control.Applicative.Module.pure
                              .app(
                           (dictAlternative as Map<String, Any>)["Applicative0"]!!
                             .app(Unit)))
                       .app(PS.Data.Bifunctor.Module.bimap
                              .app(
                                PS.Control.Monad.Rec.Class.Module.bifunctorStep)
                              .app({ v1 : Any ->
                                   PS.Data.List.Types.Module.Cons.app(v1)
                                     .app(acc)
                                })
                              .app({ v1 : Any ->
                                   PS.Data.List.Module.reverse.app(acc)
                                })
                              .app(aa));})
             };
           }
           .run({
            val go = this.go;
            PS.Control.Monad.Rec.Class.Module.tailRecM.app(dictMonadRec).app(go)
              .app(PS.Data.List.Types.Module.Nil);
          })
      }
    }
  };
  @JvmField
  val someRec = { dictMonadRec : Any ->
     { dictAlternative : Any ->
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
                  .app(PS.Data.List.Types.Module.Cons)
                  .app(v))
           .app(PS.Data.List.Module.manyRec.app(dictMonadRec)
                  .app(dictAlternative)
                  .app(v))
      }
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
                  .app(PS.Data.List.Types.Module.Cons)
                  .app(v))
           .app(PS.Control.Lazy.Module.defer.app(dictLazy)
                  .app({ v1 : Any ->
               PS.Data.List.Module.many.app(dictAlternative).app(dictLazy)
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
           .app(PS.Data.List.Module.some.app(dictAlternative).app(dictLazy)
                  .app(v))
           .app(PS.Control.Applicative.Module.pure
                  .app((dictAlternative as Map<String, Any>)["Applicative0"]!!
                         .app(Unit))
                  .app(PS.Data.List.Types.Module.Nil))
      }
    }
  };
  @JvmField
  val length = PS.Data.Foldable.Module.foldl
                 .app(PS.Data.List.Types.Module.foldableList)
                 .app({ acc : Any ->
                      { v : Any ->
                        PS.Data.Semiring.Module.add
                          .app(PS.Data.Semiring.Module.semiringInt)
                          .app(acc)
                          .app(1)
                     }
                   })
                 .app(0);
  @JvmField val last = (::__rec_last)();
  fun __rec_last(): Any = { v : Any ->
     when {
      (v is PS.Data.List.Types.Module._Type_List
              .Cons)&& (v
                          .value1 is PS.Data.List.Types.Module._Type_List
                                       .Nil) -> {
        val x = v.value0;
        PS.Data.Maybe.Module.Just.app(x);
      }
      (v is PS.Data.List.Types.Module._Type_List.Cons) -> {
        val xs = v.value1;
        PS.Data.List.Module.last.app(xs);
      }
      else -> {
        PS.Data.Maybe.Module.Nothing;
      }
    }
  };
  @JvmField val insertBy = (::__rec_insertBy)();
  fun __rec_insertBy(): Any = { v : Any ->
     { x : Any ->
       { v1 : Any ->
         when {
          (v1 is PS.Data.List.Types.Module._Type_List.Nil) -> {
            val x1 = x;
            PS.Data.List.Module.singleton.app(x1);
          }
          (v1 is PS.Data.List.Types.Module._Type_List.Cons) -> {
            val cmp = v;
            val x1 = x;
            val ys = v1;
            val y = v1.value0;
            val ys_tick = v1.value1;
            object   {
                val v2 = cmp.app(x1).app(y);
              }
              .run({
                val v2 = this.v2;
                when {
                  (v2 is PS.Data.Ordering.Module._Type_Ordering.GT) -> {
                    PS.Data.List.Types.Module.Cons.app(y)
                      .app(PS.Data.List.Module.insertBy.app(cmp).app(x1)
                             .app(ys_tick));
                  }
                  else -> {
                    PS.Data.List.Types.Module.Cons.app(x1).app(ys);
                  }
                };
              });
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    }
  };
  @JvmField val insertAt = (::__rec_insertAt)();
  fun __rec_insertAt(): Any = { v : Any ->
     { v1 : Any ->
       { v2 : Any ->
         when {
          (v == 0) -> {
            val x = v1;
            val xs = v2;
            PS.Data.Maybe.Module.Just
              .app(PS.Data.List.Types.Module.Cons.app(x).app(xs));
          }
          (v2 is PS.Data.List.Types.Module._Type_List.Cons) -> {
            val n = v;
            val x = v1;
            val y = v2.value0;
            val ys = v2.value1;
            PS.Data.Functor.Module.map.app(PS.Data.Maybe.Module.functorMaybe)
              .app({ v3 : Any ->
                   PS.Data.List.Types.Module.Cons.app(y).app(v3)
                })
              .app(PS.Data.List.Module.insertAt
                     .app(PS.Data.Ring.Module.sub
                            .app(PS.Data.Ring.Module.ringInt)
                            .app(n)
                            .app(1))
                     .app(x)
                     .app(ys));
          }
          else -> {
            PS.Data.Maybe.Module.Nothing;
          }
        }
      }
    }
  };
  @JvmField
  val insert = { dictOrd : Any ->
     PS.Data.List.Module.insertBy.app(PS.Data.Ord.Module.compare.app(dictOrd))
  };
  @JvmField
  val _init = { lst : Any ->
     PS.Data.Functor.Module.map.app(PS.Data.Maybe.Module.functorMaybe)
       .app({ v : Any ->
            (v as Map<String, Any>)["init"]!!
         })
       .app(PS.Data.List.Module.unsnoc.app(lst))
  };
  @JvmField val index = (::__rec_index)();
  fun __rec_index(): Any = { v : Any ->
     { v1 : Any ->
       when {
        (v is PS.Data.List.Types.Module._Type_List.Nil) -> {
          PS.Data.Maybe.Module.Nothing;
        }
        (v is PS.Data.List.Types.Module._Type_List.Cons)&& (v1 == 0) -> {
          val a = v.value0;
          PS.Data.Maybe.Module.Just.app(a);
        }
        (v is PS.Data.List.Types.Module._Type_List.Cons) -> {
          val _as = v.value1;
          val i = v1;
          PS.Data.List.Module.index.app(_as)
            .app(PS.Data.Ring.Module.sub.app(PS.Data.Ring.Module.ringInt).app(i)
                   .app(1));
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val head = { v : Any ->
     when {
      (v is PS.Data.List.Types.Module._Type_List.Nil) -> {
        PS.Data.Maybe.Module.Nothing;
      }
      (v is PS.Data.List.Types.Module._Type_List.Cons) -> {
        val x = v.value0;
        PS.Data.Maybe.Module.Just.app(x);
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField val transpose = (::__rec_transpose)();
  fun __rec_transpose(): Any = { v : Any ->
     when {
      (v is PS.Data.List.Types.Module._Type_List.Nil) -> {
        PS.Data.List.Types.Module.Nil;
      }
      (v is PS.Data.List.Types.Module._Type_List
              .Cons)&& (v
                          .value0 is PS.Data.List.Types.Module._Type_List
                                       .Nil) -> {
        val xss = v.value1;
        PS.Data.List.Module.transpose.app(xss);
      }
      (v is PS.Data.List.Types.Module._Type_List
              .Cons)&& (v
                          .value0 is PS.Data.List.Types.Module._Type_List
                                       .Cons) -> {
        val x = v.value0.value0;
        val xs = v.value0.value1;
        val xss = v.value1;
        PS.Data.List.Types.Module.Cons
          .app(PS.Data.List.Types.Module.Cons.app(x)
                 .app(PS.Data.List.Module.mapMaybe.app(PS.Data.List.Module.head)
                        .app(xss)))
          .app(PS.Data.List.Module.transpose
                 .app(PS.Data.List.Types.Module.Cons.app(xs)
                        .app(PS.Data.List.Module.mapMaybe
                               .app(PS.Data.List.Module.tail)
                               .app(xss))));
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField val groupBy = (::__rec_groupBy)();
  fun __rec_groupBy(): Any = { v : Any ->
     { v1 : Any ->
       when {
        (v1 is PS.Data.List.Types.Module._Type_List.Nil) -> {
          PS.Data.List.Types.Module.Nil;
        }
        (v1 is PS.Data.List.Types.Module._Type_List.Cons) -> {
          val eq = v;
          val x = v1.value0;
          val xs = v1.value1;
          object   {
              val v2 = PS.Data.List.Module.span.app(eq.app(x)).app(xs);
            }
            .run({
              val v2 = this.v2;
              when {
                ((v2 as Map<String, Any>).size == 2) -> {
                  val ys = v2["init"]!!;
                  val zs = v2["rest"]!!;
                  PS.Data.List.Types.Module.Cons
                    .app(PS.Data.List.Types.Module.NonEmptyList
                           .app(PS.Data.NonEmpty.Module.NonEmpty.app(x).app(ys))
                    )
                    .app(PS.Data.List.Module.groupBy.app(eq).app(zs));
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
  val group = { dictEq : Any ->
     PS.Data.List.Module.groupBy.app(PS.Data.Eq.Module.eq.app(dictEq))
  };
  @JvmField
  val group_tick = { dictOrd : Any ->
     PS.Control.Semigroupoid.Module.compose
       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
       .app(PS.Data.List.Module.group
              .app((dictOrd as Map<String, Any>)["Eq0"]!!.app(Unit)))
       .app(PS.Data.List.Module.sort.app(dictOrd))
  };
  @JvmField
  val fromFoldable = { dictFoldable : Any ->
     PS.Data.Foldable.Module.foldr.app(dictFoldable)
       .app(PS.Data.List.Types.Module.Cons)
       .app(PS.Data.List.Types.Module.Nil)
  };
  @JvmField val foldM = (::__rec_foldM)();
  fun __rec_foldM(): Any = { dictMonad : Any ->
     { v : Any ->
       { a : Any ->
         { v1 : Any ->
           when {
            (v1 is PS.Data.List.Types.Module._Type_List.Nil) -> {
              val a1 = a;
              PS.Control.Applicative.Module.pure
                .app((dictMonad as Map<String, Any>)["Applicative0"]!!.app(Unit)
                )
                .app(a1);
            }
            (v1 is PS.Data.List.Types.Module._Type_List.Cons) -> {
              val f = v;
              val a1 = a;
              val b = v1.value0;
              val bs = v1.value1;
              PS.Control.Bind.Module.bind
                .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
                .app(f.app(a1).app(b))
                .app({ a_tick : Any ->
                   PS.Data.List.Module.foldM.app(dictMonad).app(f).app(a_tick)
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
  val findIndex = { fn : Any ->
     object   {
         val go = (::__rec_go)();
         fun __rec_go(): Any = { v : Any ->
            { v1 : Any ->
              when {
               (v1 is PS.Data.List.Types.Module._Type_List
                        .Cons)&& (fn.app(v1.value0) as Boolean) -> {
                 val n = v;
                 val x = v1.value0;
                 val xs = v1.value1;
                 PS.Data.Maybe.Module.Just.app(n);
               }
               (v1 is PS.Data.List.Types.Module._Type_List
                        .Cons)&&
               (PS.Data.Boolean.Module.otherwise as Boolean) -> {
                 val n = v;
                 val x = v1.value0;
                 val xs = v1.value1;
                 __rec_go()
                   .app(PS.Data.Semiring.Module.add
                          .app(PS.Data.Semiring.Module.semiringInt)
                          .app(n)
                          .app(1))
                   .app(xs);
               }
               (v1 is PS.Data.List.Types.Module._Type_List.Nil) -> {
                 PS.Data.Maybe.Module.Nothing;
               }
               else -> (error("Error in Pattern Match") as Any)
             }
           }
         };
       }
       .run({
        val go = this.go;
        go.app(0);
      })
  };
  @JvmField
  val findLastIndex = { fn : Any ->
     { xs : Any ->
       PS.Data.Functor.Module.map.app(PS.Data.Maybe.Module.functorMaybe)
         .app({ v : Any ->
              PS.Data.Ring.Module.sub.app(PS.Data.Ring.Module.ringInt)
                .app(PS.Data.Ring.Module.sub.app(PS.Data.Ring.Module.ringInt)
                       .app(PS.Data.List.Module.length.app(xs))
                       .app(1))
                .app(v)
           })
         .app(PS.Data.List.Module.findIndex.app(fn)
                .app(PS.Data.List.Module.reverse.app(xs)))
    }
  };
  @JvmField val filterM = (::__rec_filterM)();
  fun __rec_filterM(): Any = { dictMonad : Any ->
     { v : Any ->
       { v1 : Any ->
         when {
          (v1 is PS.Data.List.Types.Module._Type_List.Nil) -> {
            PS.Control.Applicative.Module.pure
              .app((dictMonad as Map<String, Any>)["Applicative0"]!!.app(Unit))
              .app(PS.Data.List.Types.Module.Nil);
          }
          (v1 is PS.Data.List.Types.Module._Type_List.Cons) -> {
            val p = v;
            val x = v1.value0;
            val xs = v1.value1;
            PS.Control.Bind.Module.bind
              .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
              .app(p.app(x))
              .app({ v2 : Any ->
                val b = v2;
                  PS.Control.Bind.Module.bind
                    .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
                    .app(PS.Data.List.Module.filterM.app(dictMonad).app(p)
                           .app(xs))
                    .app({ v3 : Any ->
                      val xs_tick = v3;
                        PS.Control.Applicative.Module.pure
                          .app((dictMonad as Map<String, Any>)["Applicative0"]!!
                                 .app(Unit))
                          .app(when {
                            (b == true) -> {
                              PS.Data.List.Types.Module.Cons.app(x)
                                .app(xs_tick);
                            }
                            else -> {
                              xs_tick;
                            }
                          });});});
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    }
  };
  @JvmField
  val filter = { p : Any ->
     object   {
         val go = (::__rec_go)();
         fun __rec_go(): Any = { acc : Any ->
            { v : Any ->
              when {
               (v is PS.Data.List.Types.Module._Type_List.Nil) -> {
                 val acc1 = acc;
                 PS.Data.List.Module.reverse.app(acc1);
               }
               (v is PS.Data.List.Types.Module._Type_List
                       .Cons)&& (p.app(v.value0) as Boolean) -> {
                 val acc1 = acc;
                 val x = v.value0;
                 val xs = v.value1;
                 __rec_go().app(PS.Data.List.Types.Module.Cons.app(x).app(acc1))
                   .app(xs);
               }
               (v is PS.Data.List.Types.Module._Type_List
                       .Cons)&&
               (PS.Data.Boolean.Module.otherwise as Boolean) -> {
                 val acc1 = acc;
                 val x = v.value0;
                 val xs = v.value1;
                 __rec_go().app(acc1).app(xs);
               }
               else -> (error("Error in Pattern Match") as Any)
             }
           }
         };
       }
       .run({
        val go = this.go;
        go.app(PS.Data.List.Types.Module.Nil);
      })
  };
  @JvmField
  val intersectBy = { v : Any ->
     { v1 : Any ->
       { v2 : Any ->
         when {
          (v1 is PS.Data.List.Types.Module._Type_List.Nil) -> {
            PS.Data.List.Types.Module.Nil;
          }
          (v2 is PS.Data.List.Types.Module._Type_List.Nil) -> {
            PS.Data.List.Types.Module.Nil;
          }
          else -> {
            val eq = v;
            val xs = v1;
            val ys = v2;
            PS.Data.List.Module.filter
              .app({ x : Any ->
                   PS.Data.Foldable.Module.any
                     .app(PS.Data.List.Types.Module.foldableList)
                     .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
                     .app(eq.app(x))
                     .app(ys)
                })
              .app(xs);
          }
        }
      }
    }
  };
  @JvmField
  val intersect = { dictEq : Any ->
     PS.Data.List.Module.intersectBy.app(PS.Data.Eq.Module.eq.app(dictEq))
  };
  @JvmField val nubBy = (::__rec_nubBy)();
  fun __rec_nubBy(): Any = { v : Any ->
     { v1 : Any ->
       when {
        (v1 is PS.Data.List.Types.Module._Type_List.Nil) -> {
          PS.Data.List.Types.Module.Nil;
        }
        (v1 is PS.Data.List.Types.Module._Type_List.Cons) -> {
          val eq_tick = v;
          val x = v1.value0;
          val xs = v1.value1;
          PS.Data.List.Types.Module.Cons.app(x)
            .app(PS.Data.List.Module.nubBy.app(eq_tick)
                   .app(PS.Data.List.Module.filter
                          .app({ y : Any ->
                               PS.Data.HeytingAlgebra.Module.not
                                 .app(
                                   PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean
                                 )
                                 .app(eq_tick.app(x).app(y))
                            })
                          .app(xs)));
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val nub = { dictEq : Any ->
     PS.Data.List.Module.nubBy.app(PS.Data.Eq.Module.eq.app(dictEq))
  };
  @JvmField
  val eqPattern = { dictEq : Any ->
     PS.Data.Eq.Module.Eq
       .app({ x : Any ->
         { y : Any ->
          val l = x;
            val r = y;
            PS.Data.Eq.Module.eq
              .app(PS.Data.List.Types.Module.eqList.app(dictEq))
              .app(l)
              .app(r);}
      })
  };
  @JvmField
  val ordPattern = { dictOrd : Any ->
     PS.Data.Ord.Module.Ord
       .app({ _ : Any ->
            PS.Data.List.Module.eqPattern
              .app((dictOrd as Map<String, Any>)["Eq0"]!!.app(Unit))
         })
       .app({ x : Any ->
         { y : Any ->
          val l = x;
            val r = y;
            PS.Data.Ord.Module.compare
              .app(PS.Data.List.Types.Module.ordList.app(dictOrd))
              .app(l)
              .app(r);}
      })
  };
  @JvmField
  val elemLastIndex = { dictEq : Any ->
     { x : Any ->
       PS.Data.List.Module.findLastIndex
         .app({ v : Any ->
           PS.Data.Eq.Module.eq.app(dictEq).app(v).app(x)
        })
    }
  };
  @JvmField
  val elemIndex = { dictEq : Any ->
     { x : Any ->
       PS.Data.List.Module.findIndex
         .app({ v : Any ->
           PS.Data.Eq.Module.eq.app(dictEq).app(v).app(x)
        })
    }
  };
  @JvmField
  val dropWhile = { p : Any ->
     object   {
         val go = (::__rec_go)();
         fun __rec_go(): Any = { v : Any ->
            when {
             (v is PS.Data.List.Types.Module._Type_List
                     .Cons)&& (p.app(v.value0) as Boolean) -> {
               val x = v.value0;
               val xs = v.value1;
               __rec_go().app(xs);
             }
             else -> {
               val xs = v;
               xs;
             }
           }
         };
       }
       .run({
        val go = this.go;
        go;
      })
  };
  @JvmField
  val dropEnd = { n : Any ->
     { xs : Any ->
       PS.Data.List.Module.take
         .app(PS.Data.Ring.Module.sub.app(PS.Data.Ring.Module.ringInt)
                .app(PS.Data.List.Module.length.app(xs))
                .app(n))
         .app(xs)
    }
  };
  @JvmField val drop = (::__rec_drop)();
  fun __rec_drop(): Any = { v : Any ->
     { v1 : Any ->
       when {
        (PS.Data.Ord.Module.lessThan.app(PS.Data.Ord.Module.ordInt).app(v)
           .app(1) as Boolean) -> {
          val n = v;
          val xs = v1;
          xs;
        }
        (v1 is PS.Data.List.Types.Module._Type_List.Nil) -> {
          PS.Data.List.Types.Module.Nil;
        }
        (v1 is PS.Data.List.Types.Module._Type_List.Cons) -> {
          val n = v;
          val x = v1.value0;
          val xs = v1.value1;
          PS.Data.List.Module.drop
            .app(PS.Data.Ring.Module.sub.app(PS.Data.Ring.Module.ringInt).app(n)
                   .app(1))
            .app(xs);
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val slice = { start : Any ->
     { end : Any ->
       { xs : Any ->
         PS.Data.List.Module.take
           .app(PS.Data.Ring.Module.sub.app(PS.Data.Ring.Module.ringInt)
                  .app(end)
                  .app(start))
           .app(PS.Data.List.Module.drop.app(start).app(xs))
      }
    }
  };
  @JvmField
  val takeEnd = { n : Any ->
     { xs : Any ->
       PS.Data.List.Module.drop
         .app(PS.Data.Ring.Module.sub.app(PS.Data.Ring.Module.ringInt)
                .app(PS.Data.List.Module.length.app(xs))
                .app(n))
         .app(xs)
    }
  };
  @JvmField val deleteBy = (::__rec_deleteBy)();
  fun __rec_deleteBy(): Any = { v : Any ->
     { v1 : Any ->
       { v2 : Any ->
         when {
          (v2 is PS.Data.List.Types.Module._Type_List.Nil) -> {
            PS.Data.List.Types.Module.Nil;
          }
          (v2 is PS.Data.List.Types.Module._Type_List
                   .Cons)&& (v.app(v1).app(v2.value0) as Boolean) -> {
            val eq_tick = v;
            val x = v1;
            val y = v2.value0;
            val ys = v2.value1;
            ys;
          }
          (v2 is PS.Data.List.Types.Module._Type_List.Cons) -> {
            val eq_tick = v;
            val x = v1;
            val y = v2.value0;
            val ys = v2.value1;
            PS.Data.List.Types.Module.Cons.app(y)
              .app(PS.Data.List.Module.deleteBy.app(eq_tick).app(x).app(ys));
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    }
  };
  @JvmField
  val unionBy = { eq : Any ->
     { xs : Any ->
       { ys : Any ->
         PS.Data.Semigroup.Module.append
           .app(PS.Data.List.Types.Module.semigroupList)
           .app(xs)
           .app(PS.Data.Foldable.Module.foldl
                  .app(PS.Data.List.Types.Module.foldableList)
                  .app(PS.Data.Function.Module.flip
                         .app(PS.Data.List.Module.deleteBy.app(eq)))
                  .app(PS.Data.List.Module.nubBy.app(eq).app(ys))
                  .app(xs))
      }
    }
  };
  @JvmField
  val union = { dictEq : Any ->
     PS.Data.List.Module.unionBy.app(PS.Data.Eq.Module.eq.app(dictEq))
  };
  @JvmField val deleteAt = (::__rec_deleteAt)();
  fun __rec_deleteAt(): Any = { v : Any ->
     { v1 : Any ->
       when {
        (v == 0)&& (v1 is PS.Data.List.Types.Module._Type_List.Cons) -> {
          val y = v1.value0;
          val ys = v1.value1;
          PS.Data.Maybe.Module.Just.app(ys);
        }
        (v1 is PS.Data.List.Types.Module._Type_List.Cons) -> {
          val n = v;
          val y = v1.value0;
          val ys = v1.value1;
          PS.Data.Functor.Module.map.app(PS.Data.Maybe.Module.functorMaybe)
            .app({ v2 : Any ->
                 PS.Data.List.Types.Module.Cons.app(y).app(v2)
              })
            .app(PS.Data.List.Module.deleteAt
                   .app(PS.Data.Ring.Module.sub.app(PS.Data.Ring.Module.ringInt)
                          .app(n)
                          .app(1))
                   .app(ys));
        }
        else -> {
          PS.Data.Maybe.Module.Nothing;
        }
      }
    }
  };
  @JvmField
  val delete = { dictEq : Any ->
     PS.Data.List.Module.deleteBy.app(PS.Data.Eq.Module.eq.app(dictEq))
  };
  @JvmField
  val difference = { dictEq : Any ->
     PS.Data.Foldable.Module.foldl.app(PS.Data.List.Types.Module.foldableList)
       .app(PS.Data.Function.Module.flip
              .app(PS.Data.List.Module.delete.app(dictEq)))
  };
  @JvmField
  val concatMap = PS.Data.Function.Module.flip
                    .app(PS.Control.Bind.Module.bind
                           .app(PS.Data.List.Types.Module.bindList));
  @JvmField
  val concat = { v : Any ->
     PS.Control.Bind.Module.bind.app(PS.Data.List.Types.Module.bindList).app(v)
       .app(PS.Control.Category.Module.identity
              .app(PS.Control.Category.Module.categoryFn))
  };
  @JvmField
  val catMaybes = PS.Data.List.Module.mapMaybe
                    .app(PS.Control.Category.Module.identity
                           .app(PS.Control.Category.Module.categoryFn));
  @JvmField val alterAt = (::__rec_alterAt)();
  fun __rec_alterAt(): Any = { v : Any ->
     { v1 : Any ->
       { v2 : Any ->
         when {
          (v == 0)&& (v2 is PS.Data.List.Types.Module._Type_List.Cons) -> {
            val f = v1;
            val y = v2.value0;
            val ys = v2.value1;
            PS.Data.Function.Module.apply.app(PS.Data.Maybe.Module.Just)
              .app(object   {
                       val v3 = f.app(y);
                     }
                     .run({
                  val v3 = this.v3;
                  when {
                    (v3 is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                      ys;
                    }
                    (v3 is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
                      val y_tick = v3.value0;
                      PS.Data.List.Types.Module.Cons.app(y_tick).app(ys);
                    }
                    else -> (error("Error in Pattern Match") as Any)
                  };
                }));
          }
          (v2 is PS.Data.List.Types.Module._Type_List.Cons) -> {
            val n = v;
            val f = v1;
            val y = v2.value0;
            val ys = v2.value1;
            PS.Data.Functor.Module.map.app(PS.Data.Maybe.Module.functorMaybe)
              .app({ v3 : Any ->
                   PS.Data.List.Types.Module.Cons.app(y).app(v3)
                })
              .app(PS.Data.List.Module.alterAt
                     .app(PS.Data.Ring.Module.sub
                            .app(PS.Data.Ring.Module.ringInt)
                            .app(n)
                            .app(1))
                     .app(f)
                     .app(ys));
          }
          else -> {
            PS.Data.Maybe.Module.Nothing;
          }
        }
      }
    }
  };
  @JvmField
  val modifyAt = { n : Any ->
     { f : Any ->
       PS.Data.List.Module.alterAt.app(n)
         .app(PS.Control.Semigroupoid.Module.compose
                .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                .app(PS.Data.Maybe.Module.Just)
                .app(f))
    }
  };
}