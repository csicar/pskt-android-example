@file:Suppress("UNCHECKED_CAST")

package PS.Data.List.Lazy
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val Pattern = { x : Any -> x};
  @JvmField val zipWith = (::__rec_zipWith)();
  fun __rec_zipWith(): Any = { f : Any ->
     { xs : Any ->
       { ys : Any ->
         object   {
             val go = { v : Any ->
                { v1 : Any ->
                  when {
                   (v is PS.Data.List.Lazy.Types.Module._Type_Step.Nil) -> {
                     PS.Data.List.Lazy.Types.Module.Nil;
                   }
                   (v1 is PS.Data.List.Lazy.Types.Module._Type_Step.Nil) -> {
                     PS.Data.List.Lazy.Types.Module.Nil;
                   }
                   (v is PS.Data.List.Lazy.Types.Module._Type_Step
                           .Cons)&&
                   (v1 is PS.Data.List.Lazy.Types.Module._Type_Step
                            .Cons) -> {
                     val a = v.value0;
                     val _as = v.value1;
                     val b = v1.value0;
                     val bs = v1.value1;
                     PS.Data.List.Lazy.Types.Module.Cons.app(f.app(a).app(b))
                       .app(PS.Data.List.Lazy.Module.zipWith.app(f).app(_as)
                              .app(bs));
                   }
                   else -> (error("Error in Pattern Match") as Any)
                 }
               }
             };
           }
           .run({
            val go = this.go;
            PS.Data.List.Lazy.Types.Module.List
              .app(PS.Control.Apply.Module.apply
                     .app(PS.Data.Lazy.Module.applyLazy)
                     .app(PS.Data.Functor.Module.map
                            .app(PS.Data.Lazy.Module.functorLazy)
                            .app(go)
                            .app(PS.Data.Newtype.Module.unwrap
                                   .app(
                                     PS.Data.List.Lazy.Types.Module.newtypeList)
                                   .app(xs)))
                     .app(PS.Data.Newtype.Module.unwrap
                            .app(PS.Data.List.Lazy.Types.Module.newtypeList)
                            .app(ys)));
          })
      }
    }
  };
  @JvmField
  val zipWithA = { dictApplicative : Any ->
     { f : Any ->
       { xs : Any ->
         { ys : Any ->
           PS.Data.Traversable.Module.sequence
             .app(PS.Data.List.Lazy.Types.Module.traversableList)
             .app(dictApplicative)
             .app(PS.Data.List.Lazy.Module.zipWith.app(f).app(xs).app(ys))
        }
      }
    }
  };
  @JvmField
  val zip = PS.Data.List.Lazy.Module.zipWith.app(PS.Data.Tuple.Module.Tuple);
  @JvmField val updateAt = (::__rec_updateAt)();
  fun __rec_updateAt(): Any = { n : Any ->
     { x : Any ->
       { xs : Any ->
         object   {
             val go = { v : Any ->
                { v1 : Any ->
                  when {
                   (v1 is PS.Data.List.Lazy.Types.Module._Type_Step.Nil) -> {
                     PS.Data.List.Lazy.Types.Module.Nil;
                   }
                   (v == 0)&& (v1 is PS.Data.List.Lazy.Types.Module._Type_Step
                                       .Cons) -> {
                     val ys = v1.value1;
                     PS.Data.List.Lazy.Types.Module.Cons.app(x).app(ys);
                   }
                   (v1 is PS.Data.List.Lazy.Types.Module._Type_Step.Cons) -> {
                     val n_tick = v;
                     val y = v1.value0;
                     val ys = v1.value1;
                     PS.Data.List.Lazy.Types.Module.Cons.app(y)
                       .app(PS.Data.List.Lazy.Module.updateAt
                              .app(PS.Data.Ring.Module.sub
                                     .app(PS.Data.Ring.Module.ringInt)
                                     .app(n_tick)
                                     .app(1))
                              .app(x)
                              .app(ys));
                   }
                   else -> (error("Error in Pattern Match") as Any)
                 }
               }
             };
           }
           .run({
            val go = this.go;
            PS.Data.List.Lazy.Types.Module.List
              .app(PS.Data.Functor.Module.map
                     .app(PS.Data.Lazy.Module.functorLazy)
                     .app(go.app(n))
                     .app(PS.Data.Newtype.Module.unwrap
                            .app(PS.Data.List.Lazy.Types.Module.newtypeList)
                            .app(xs)));
          })
      }
    }
  };
  @JvmField
  val unzip = PS.Data.Foldable.Module.foldr
                .app(PS.Data.List.Lazy.Types.Module.foldableList)
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
                                .app(PS.Data.List.Lazy.Types.Module.cons.app(a)
                                       .app(_as))
                                .app(PS.Data.List.Lazy.Types.Module.cons.app(b)
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
                       .app(PS.Data.List.Lazy.Types.Module.nil)
                       .app(PS.Data.List.Lazy.Types.Module.nil));
  @JvmField
  val uncons = { xs : Any ->
     object   {
         val v = PS.Data.List.Lazy.Types.Module.step.app(xs);
       }
       .run({
        val v = this.v;
        when {
          (v is PS.Data.List.Lazy.Types.Module._Type_Step.Nil) -> {
            PS.Data.Maybe.Module.Nothing;
          }
          (v is PS.Data.List.Lazy.Types.Module._Type_Step.Cons) -> {
            val x = v.value0;
            val xs_tick = v.value1;
            PS.Data.Maybe.Module.Just
              .app(mapOf(("head" to x),  ("tail" to xs_tick)));
          }
          else -> (error("Error in Pattern Match") as Any)
        };
      })
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
           .app(PS.Data.List.Lazy.Module.uncons.app(xs))
      })
  };
  @JvmField val takeWhile = (::__rec_takeWhile)();
  fun __rec_takeWhile(): Any = { p : Any ->
     object   {
         val go = { v : Any ->
            when {
             (v is PS.Data.List.Lazy.Types.Module._Type_Step
                     .Cons)&& (p.app(v.value0) as Boolean) -> {
               val x = v.value0;
               val xs = v.value1;
               PS.Data.List.Lazy.Types.Module.Cons.app(x)
                 .app(PS.Data.List.Lazy.Module.takeWhile.app(p).app(xs));
             }
             else -> {
               PS.Data.List.Lazy.Types.Module.Nil;
             }
           }
         };
       }
       .run({
        val go = this.go;
        PS.Control.Semigroupoid.Module.compose
          .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
          .app(PS.Data.List.Lazy.Types.Module.List)
          .app(PS.Control.Semigroupoid.Module.compose
                 .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                 .app(PS.Data.Functor.Module.map
                        .app(PS.Data.Lazy.Module.functorLazy)
                        .app(go))
                 .app(PS.Data.Newtype.Module.unwrap
                        .app(PS.Data.List.Lazy.Types.Module.newtypeList)));
      })
  };
  @JvmField val take = (::__rec_take)();
  fun __rec_take(): Any = { n : Any ->
     object   {
         val go = { v : Any ->
            { v1 : Any ->
              when {
               (v1 is PS.Data.List.Lazy.Types.Module._Type_Step.Nil) -> {
                 PS.Data.List.Lazy.Types.Module.Nil;
               }
               (v1 is PS.Data.List.Lazy.Types.Module._Type_Step.Cons) -> {
                 val n_tick = v;
                 val x = v1.value0;
                 val xs = v1.value1;
                 PS.Data.List.Lazy.Types.Module.Cons.app(x)
                   .app(PS.Data.List.Lazy.Module.take
                          .app(PS.Data.Ring.Module.sub
                                 .app(PS.Data.Ring.Module.ringInt)
                                 .app(n_tick)
                                 .app(1))
                          .app(xs));
               }
               else -> (error("Error in Pattern Match") as Any)
             }
           }
         };
       }
       .run({
        val go = this.go;
        when {
          (PS.Data.Ord.Module.lessThanOrEq.app(PS.Data.Ord.Module.ordInt).app(n)
             .app(0) == true) -> {
            PS.Data.Function.Module._const
              .app(PS.Data.List.Lazy.Types.Module.nil);
          }
          else -> {
            PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Data.List.Lazy.Types.Module.List)
              .app(PS.Control.Semigroupoid.Module.compose
                     .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                     .app(PS.Data.Functor.Module.map
                            .app(PS.Data.Lazy.Module.functorLazy)
                            .app(go.app(n)))
                     .app(PS.Data.Newtype.Module.unwrap
                            .app(PS.Data.List.Lazy.Types.Module.newtypeList)));
          }
        };
      })
  };
  @JvmField
  val tail = { xs : Any ->
     PS.Data.Functor.Module.map.app(PS.Data.Maybe.Module.functorMaybe)
       .app({ v : Any ->
            (v as Map<String, Any>)["tail"]!!
         })
       .app(PS.Data.List.Lazy.Module.uncons.app(xs))
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
                   object   {
                       val v1 = PS.Data.List.Lazy.Types.Module.step.app(prefix);
                     }
                     .run({
                      val v1 = this.v1;
                      when {
                        (v1 is PS.Data.List.Lazy.Types.Module._Type_Step
                                 .Nil) -> {
                          PS.Data.Function.Module.apply
                            .app(PS.Data.Maybe.Module.Just)
                            .app(PS.Control.Monad.Rec.Class.Module.Done
                                   .app(input));
                        }
                        (v1 is PS.Data.List.Lazy.Types.Module._Type_Step
                                 .Cons) -> {
                          val p = v1.value0;
                          val ps = v1.value1;
                          object   {
                              val v2 = PS.Data.List.Lazy.Types.Module.step
                                         .app(input);
                            }
                            .run({
                              val v2 = this.v2;
                              when {
                                (v2 is PS.Data.List.Lazy.Types.Module._Type_Step
                                         .Cons)&& (PS.Data.Eq.Module.eq
                                                     .app(dictEq)
                                                     .app(p)
                                                     .app(v2
                                                            .value0
                                ) as Boolean) -> {
                                  val i = v2.value0;
                                  val _is = v2.value1;
                                  PS.Data.Function.Module.apply
                                    .app(PS.Data.Maybe.Module.Just)
                                    .app(PS.Control.Monad.Rec.Class.Module.Loop
                                           .app(mapOf(("a" to ps),  ("b" to _is)
                                      )));
                                }
                                else -> {
                                  PS.Data.Maybe.Module.Nothing;
                                }
                              };
                            });
                        }
                        else -> (error("Error in Pattern Match") as Any)
                      };
                    })
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
  fun __rec_span(): Any = { p : Any ->
     { xs : Any ->
       object   {
           val v = PS.Data.List.Lazy.Module.uncons.app(xs);
         }
         .run({
          val v = this.v;
          when {
            (v is PS.Data.Maybe.Module._Type_Maybe
                    .Just)&& ((v
                                 .value0 as Map<String, Any>)
                                .size == 2)&& (p
                                                 .app(v
                                                        .value0["head"]!!
            ) as Boolean) -> {
              val x = v.value0["head"]!!;
              val xs_tick = v.value0["tail"]!!;
              object   {
                  val v1 = PS.Data.List.Lazy.Module.span.app(p).app(xs_tick);
                }
                .run({
                  val v1 = this.v1;
                  when {
                    ((v1 as Map<String, Any>).size == 2) -> {
                      val ys = v1["init"]!!;
                      val zs = v1["rest"]!!;
                      mapOf(("init" to PS.Data.List.Lazy.Types.Module.cons
                                         .app(x)
                                         .app(ys)),  ("rest" to zs));
                    }
                    else -> (error("Error in Pattern Match") as Any)
                  };
                });
            }
            else -> {
              mapOf(("init" to PS.Data.List.Lazy.Types.Module.nil),  
                ("rest" to xs));
            }
          };
        })
    }
  };
  @JvmField
  val snoc = { xs : Any ->
     { x : Any ->
       PS.Data.Foldable.Module.foldr
         .app(PS.Data.List.Lazy.Types.Module.foldableList)
         .app(PS.Data.List.Lazy.Types.Module.cons)
         .app(PS.Data.List.Lazy.Types.Module.cons.app(x)
                .app(PS.Data.List.Lazy.Types.Module.nil))
         .app(xs)
    }
  };
  @JvmField
  val singleton = { a : Any ->
     PS.Data.List.Lazy.Types.Module.cons.app(a)
       .app(PS.Data.List.Lazy.Types.Module.nil)
  };
  @JvmField
  val showPattern = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ v : Any ->
        val s = v;
          (("(Pattern " as String) + (((PS.Data.Show.Module.show
                                          .app(
                                            PS.Data.List.Lazy.Types.Module.showList
                                              .app(dictShow))
                                          .app(s
          ) as String) + (")" as String)) as String));})
  };
  @JvmField val scanrLazy = (::__rec_scanrLazy)();
  fun __rec_scanrLazy(): Any = { f : Any ->
     { acc : Any ->
       { xs : Any ->
         object   {
             val go = { v : Any ->
                when {
                 (v is PS.Data.List.Lazy.Types.Module._Type_Step.Nil) -> {
                   PS.Data.List.Lazy.Types.Module.Nil;
                 }
                 (v is PS.Data.List.Lazy.Types.Module._Type_Step.Cons) -> {
                   val x = v.value0;
                   val xs_tick = v.value1;
                   object   {
                       val acc_tick = f.app(x).app(acc);
                     }
                     .run({
                       val acc_tick = this.acc_tick;
                       PS.Data.Function.Module.apply
                         .app(PS.Data.List.Lazy.Types.Module.Cons.app(acc_tick))
                         .app(PS.Data.List.Lazy.Module.scanrLazy.app(f)
                                .app(acc_tick)
                                .app(xs_tick));
                     });
                 }
                 else -> (error("Error in Pattern Match") as Any)
               }
             };
           }
           .run({
            val go = this.go;
            PS.Data.List.Lazy.Types.Module.List
              .app(PS.Data.Functor.Module.map
                     .app(PS.Data.Lazy.Module.functorLazy)
                     .app(go)
                     .app(PS.Data.Newtype.Module.unwrap
                            .app(PS.Data.List.Lazy.Types.Module.newtypeList)
                            .app(xs)));
          })
      }
    }
  };
  @JvmField
  val reverse = { xs : Any ->
     PS.Control.Lazy.Module.defer.app(PS.Data.List.Lazy.Types.Module.lazyList)
       .app({ v : Any ->
         PS.Data.Foldable.Module.foldl
           .app(PS.Data.List.Lazy.Types.Module.foldableList)
           .app(PS.Data.Function.Module.flip
                  .app(PS.Data.List.Lazy.Types.Module.cons))
           .app(PS.Data.List.Lazy.Types.Module.nil)
           .app(xs)
      })
  };
  @JvmField val replicateM = (::__rec_replicateM)();
  fun __rec_replicateM(): Any = { dictMonad : Any ->
     { n : Any ->
       { m : Any ->
         when {
          (PS.Data.Ord.Module.lessThan.app(PS.Data.Ord.Module.ordInt).app(n)
             .app(PS.Data.Semiring.Module.one
                    .app(PS.Data.Semiring.Module.semiringInt)) as Boolean) -> {
            val n1 = n;
            val m1 = m;
            PS.Control.Applicative.Module.pure
              .app((dictMonad as Map<String, Any>)["Applicative0"]!!.app(Unit))
              .app(PS.Data.List.Lazy.Types.Module.nil);
          }
          (PS.Data.Boolean.Module.otherwise as Boolean) -> {
            val n1 = n;
            val m1 = m;
            PS.Control.Bind.Module.bind
              .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
              .app(m1)
              .app({ v : Any ->
                val a = v;
                  PS.Control.Bind.Module.bind
                    .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
                    .app(PS.Data.List.Lazy.Module.replicateM.app(dictMonad)
                           .app(PS.Data.Ring.Module.sub
                                  .app(PS.Data.Ring.Module.ringInt)
                                  .app(n1)
                                  .app(PS.Data.Semiring.Module.one
                                         .app(
                                 PS.Data.Semiring.Module.semiringInt)))
                           .app(m1))
                    .app({ v1 : Any ->
                      val _as = v1;
                        PS.Control.Applicative.Module.pure
                          .app((dictMonad as Map<String, Any>)["Applicative0"]!!
                                 .app(Unit))
                          .app(PS.Data.List.Lazy.Types.Module.cons.app(a)
                                 .app(_as));});});
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    }
  };
  @JvmField
  val repeat = { x : Any ->
     PS.Control.Lazy.Module.fix.app(PS.Data.List.Lazy.Types.Module.lazyList)
       .app({ xs : Any ->
         PS.Data.List.Lazy.Types.Module.cons.app(x).app(xs)
      })
  };
  @JvmField
  val replicate = { i : Any ->
     { xs : Any ->
       PS.Data.List.Lazy.Module.take.app(i)
         .app(PS.Data.List.Lazy.Module.repeat.app(xs))
    }
  };
  @JvmField
  val range = { start : Any ->
     { end : Any ->
       when {
        (PS.Data.Ord.Module.greaterThan.app(PS.Data.Ord.Module.ordInt)
           .app(start)
           .app(end) as Boolean) -> {
          val start1 = start;
          val end1 = end;
          object   {
              val g = { x : Any ->
                 when {
                  (PS.Data.Ord.Module.greaterThanOrEq
                     .app(PS.Data.Ord.Module.ordInt)
                     .app(x)
                     .app(end1) as Boolean) -> {
                    val x1 = x;
                    PS.Data.Maybe.Module.Just
                      .app(PS.Data.Tuple.Module.Tuple.app(x1)
                             .app(PS.Data.Ring.Module.sub
                                    .app(PS.Data.Ring.Module.ringInt)
                                    .app(x1)
                                    .app(1)));
                  }
                  (PS.Data.Boolean.Module.otherwise as Boolean) -> {
                    val x1 = x;
                    PS.Data.Maybe.Module.Nothing;
                  }
                  else -> (error("Error in Pattern Match") as Any)
                }
              };
            }
            .run({
              val g = this.g;
              PS.Data.Unfoldable.Module.unfoldr
                .app(PS.Data.List.Lazy.Types.Module.unfoldableList)
                .app(g)
                .app(start1);
            });
        }
        (PS.Data.Boolean.Module.otherwise as Boolean) -> {
          val start1 = start;
          val end1 = end;
          object   {
              val f = { x : Any ->
                 when {
                  (PS.Data.Ord.Module.lessThanOrEq
                     .app(PS.Data.Ord.Module.ordInt)
                     .app(x)
                     .app(end1) as Boolean) -> {
                    val x1 = x;
                    PS.Data.Maybe.Module.Just
                      .app(PS.Data.Tuple.Module.Tuple.app(x1)
                             .app(PS.Data.Semiring.Module.add
                                    .app(PS.Data.Semiring.Module.semiringInt)
                                    .app(x1)
                                    .app(1)));
                  }
                  (PS.Data.Boolean.Module.otherwise as Boolean) -> {
                    val x1 = x;
                    PS.Data.Maybe.Module.Nothing;
                  }
                  else -> (error("Error in Pattern Match") as Any)
                }
              };
            }
            .run({
              val f = this.f;
              PS.Data.Unfoldable.Module.unfoldr
                .app(PS.Data.List.Lazy.Types.Module.unfoldableList)
                .app(f)
                .app(start1);
            });
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val partition = { f : Any ->
     object   {
         val go = { x : Any ->
            { v : Any ->
              when {
               ((v as Map<String, Any>).size == 2) -> {
                 val x1 = x;
                 val ys = v["yes"]!!;
                 val ns = v["no"]!!;
                 when {
                   (f.app(x1) == true) -> {
                     mapOf(("yes" to PS.Data.List.Lazy.Types.Module.cons.app(x1)
                                       .app(ys)),  ("no" to ns));
                   }
                   else -> {
                     mapOf(("yes" to ys),  
                       ("no" to PS.Data.List.Lazy.Types.Module.cons.app(x1)
                                  .app(ns)));
                   }
                 };
               }
               else -> (error("Error in Pattern Match") as Any)
             }
           }
         };
       }
       .run({
        val go = this.go;
        PS.Data.Foldable.Module.foldr
          .app(PS.Data.List.Lazy.Types.Module.foldableList)
          .app(go)
          .app(mapOf(("yes" to PS.Data.List.Lazy.Types.Module.nil),  
            ("no" to PS.Data.List.Lazy.Types.Module.nil)));
      })
  };
  @JvmField
  val _null = PS.Control.Semigroupoid.Module.compose
                .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                .app(PS.Data.Maybe.Module.isNothing)
                .app(PS.Data.List.Lazy.Module.uncons);
  @JvmField
  val newtypePattern = PS.Data.Newtype.Module.Newtype
                         .app({ n : Any ->
                             val a = n;
                               a;})
                         .app(PS.Data.List.Lazy.Module.Pattern);
  @JvmField val mapMaybe = (::__rec_mapMaybe)();
  fun __rec_mapMaybe(): Any = { f : Any ->
     object   {
         val go = (::__rec_go)();
         fun __rec_go(): Any = { v : Any ->
            when {
             (v is PS.Data.List.Lazy.Types.Module._Type_Step.Nil) -> {
               PS.Data.List.Lazy.Types.Module.Nil;
             }
             (v is PS.Data.List.Lazy.Types.Module._Type_Step.Cons) -> {
               val x = v.value0;
               val xs = v.value1;
               object   {
                   val v1 = f.app(x);
                 }
                 .run({
                   val v1 = this.v1;
                   when {
                     (v1 is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                       __rec_go()
                         .app(PS.Data.List.Lazy.Types.Module.step.app(xs));
                     }
                     (v1 is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
                       val y = v1.value0;
                       PS.Data.List.Lazy.Types.Module.Cons.app(y)
                         .app(PS.Data.List.Lazy.Module.mapMaybe.app(f).app(xs));
                     }
                     else -> (error("Error in Pattern Match") as Any)
                   };
                 });
             }
             else -> (error("Error in Pattern Match") as Any)
           }
         };
       }
       .run({
        val go = this.go;
        PS.Control.Semigroupoid.Module.compose
          .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
          .app(PS.Data.List.Lazy.Types.Module.List)
          .app(PS.Control.Semigroupoid.Module.compose
                 .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                 .app(PS.Data.Functor.Module.map
                        .app(PS.Data.Lazy.Module.functorLazy)
                        .app(go))
                 .app(PS.Data.Newtype.Module.unwrap
                        .app(PS.Data.List.Lazy.Types.Module.newtypeList)));
      })
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
                  .app(PS.Data.List.Lazy.Types.Module.cons)
                  .app(v))
           .app(PS.Control.Lazy.Module.defer.app(dictLazy)
                  .app({ v1 : Any ->
               PS.Data.List.Lazy.Module.many.app(dictAlternative).app(dictLazy)
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
           .app(PS.Data.List.Lazy.Module.some.app(dictAlternative).app(dictLazy)
                  .app(v))
           .app(PS.Control.Applicative.Module.pure
                  .app((dictAlternative as Map<String, Any>)["Applicative0"]!!
                         .app(Unit))
                  .app(PS.Data.List.Lazy.Types.Module.nil))
      }
    }
  };
  @JvmField
  val length = PS.Data.Foldable.Module.foldl
                 .app(PS.Data.List.Lazy.Types.Module.foldableList)
                 .app({ l : Any ->
                      { v : Any ->
                        PS.Data.Semiring.Module.add
                          .app(PS.Data.Semiring.Module.semiringInt)
                          .app(l)
                          .app(1)
                     }
                   })
                 .app(0);
  @JvmField
  val last = object   {
                 val go = (::__rec_go)();
                 fun __rec_go(): Any = { v : Any ->
                    when {
                     (v is PS.Data.List.Lazy.Types.Module._Type_Step
                             .Cons)&& (PS.Data.List.Lazy.Module._null
                                         .app(v
                                                .value1) as Boolean) -> {
                       val x = v.value0;
                       val xs = v.value1;
                       PS.Data.Maybe.Module.Just.app(x);
                     }
                     (v is PS.Data.List.Lazy.Types.Module._Type_Step
                             .Cons)&&
                     (PS.Data.Boolean.Module.otherwise as Boolean) -> {
                       val x = v.value0;
                       val xs = v.value1;
                       __rec_go()
                         .app(PS.Data.List.Lazy.Types.Module.step.app(xs));
                     }
                     else -> {
                       PS.Data.Maybe.Module.Nothing;
                     }
                   }
                 };
               }
               .run({
      val go = this.go;
      PS.Control.Semigroupoid.Module.compose
        .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
        .app(go)
        .app(PS.Data.List.Lazy.Types.Module.step);
    });
  @JvmField
  val iterate = { f : Any ->
     { x : Any ->
       PS.Control.Lazy.Module.fix.app(PS.Data.List.Lazy.Types.Module.lazyList)
         .app({ xs : Any ->
           PS.Data.List.Lazy.Types.Module.cons.app(x)
             .app(PS.Data.Functor.Module.map
                    .app(PS.Data.List.Lazy.Types.Module.functorList)
                    .app(f)
                    .app(xs))
        })
    }
  };
  @JvmField val insertAt = (::__rec_insertAt)();
  fun __rec_insertAt(): Any = { v : Any ->
     { x : Any ->
       { xs : Any ->
         when {
          (v == 0) -> {
            val x1 = x;
            val xs1 = xs;
            PS.Data.List.Lazy.Types.Module.cons.app(x1).app(xs1);
          }
          else -> {
            val n = v;
            val x1 = x;
            val xs1 = xs;
            object   {
                val go = { v1 : Any ->
                   when {
                    (v1 is PS.Data.List.Lazy.Types.Module._Type_Step.Nil) -> {
                      PS.Data.List.Lazy.Types.Module.Cons.app(x1)
                        .app(PS.Data.List.Lazy.Types.Module.nil);
                    }
                    (v1 is PS.Data.List.Lazy.Types.Module._Type_Step.Cons) -> {
                      val y = v1.value0;
                      val ys = v1.value1;
                      PS.Data.List.Lazy.Types.Module.Cons.app(y)
                        .app(PS.Data.List.Lazy.Module.insertAt
                               .app(PS.Data.Ring.Module.sub
                                      .app(PS.Data.Ring.Module.ringInt)
                                      .app(n)
                                      .app(1))
                               .app(x1)
                               .app(ys));
                    }
                    else -> (error("Error in Pattern Match") as Any)
                  }
                };
              }
              .run({
                val go = this.go;
                PS.Data.List.Lazy.Types.Module.List
                  .app(PS.Data.Functor.Module.map
                         .app(PS.Data.Lazy.Module.functorLazy)
                         .app(go)
                         .app(PS.Data.Newtype.Module.unwrap
                                .app(PS.Data.List.Lazy.Types.Module.newtypeList)
                                .app(xs1)));
              });
          }
        }
      }
    }
  };
  @JvmField
  val _init = object   {
                  val go = (::__rec_go)();
                  fun __rec_go(): Any = { v : Any ->
                     when {
                      (v is PS.Data.List.Lazy.Types.Module._Type_Step
                              .Cons)&& (PS.Data.List.Lazy.Module._null
                                          .app(v
                                                 .value1) as Boolean) -> {
                        val x = v.value0;
                        val xs = v.value1;
                        PS.Data.Maybe.Module.Just
                          .app(PS.Data.List.Lazy.Types.Module.nil);
                      }
                      (v is PS.Data.List.Lazy.Types.Module._Type_Step
                              .Cons)&&
                      (PS.Data.Boolean.Module.otherwise as Boolean) -> {
                        val x = v.value0;
                        val xs = v.value1;
                        PS.Data.Functor.Module.map
                          .app(PS.Data.Maybe.Module.functorMaybe)
                          .app(PS.Data.List.Lazy.Types.Module.cons.app(x))
                          .app(__rec_go()
                                 .app(PS.Data.List.Lazy.Types.Module.step
                                        .app(xs)));
                      }
                      else -> {
                        PS.Data.Maybe.Module.Nothing;
                      }
                    }
                  };
                }
                .run({
      val go = this.go;
      PS.Control.Semigroupoid.Module.compose
        .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
        .app(go)
        .app(PS.Data.List.Lazy.Types.Module.step);
    });
  @JvmField
  val index = { xs : Any ->
     object   {
         val go = (::__rec_go)();
         fun __rec_go(): Any = { v : Any ->
            { v1 : Any ->
              when {
               (v is PS.Data.List.Lazy.Types.Module._Type_Step.Nil) -> {
                 PS.Data.Maybe.Module.Nothing;
               }
               (v is PS.Data.List.Lazy.Types.Module._Type_Step
                       .Cons)&& (v1 == 0) -> {
                 val a = v.value0;
                 PS.Data.Maybe.Module.Just.app(a);
               }
               (v is PS.Data.List.Lazy.Types.Module._Type_Step.Cons) -> {
                 val _as = v.value1;
                 val i = v1;
                 __rec_go().app(PS.Data.List.Lazy.Types.Module.step.app(_as))
                   .app(PS.Data.Ring.Module.sub.app(PS.Data.Ring.Module.ringInt)
                          .app(i)
                          .app(1));
               }
               else -> (error("Error in Pattern Match") as Any)
             }
           }
         };
       }
       .run({
        val go = this.go;
        go.app(PS.Data.List.Lazy.Types.Module.step.app(xs));
      })
  };
  @JvmField
  val head = { xs : Any ->
     PS.Data.Functor.Module.map.app(PS.Data.Maybe.Module.functorMaybe)
       .app({ v : Any ->
            (v as Map<String, Any>)["head"]!!
         })
       .app(PS.Data.List.Lazy.Module.uncons.app(xs))
  };
  @JvmField val transpose = (::__rec_transpose)();
  fun __rec_transpose(): Any = { xs : Any ->
     object   {
         val v = PS.Data.List.Lazy.Module.uncons.app(xs);
       }
       .run({
        val v = this.v;
        when {
          (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
            xs;
          }
          (v is PS.Data.Maybe.Module._Type_Maybe
                  .Just)&& ((v
                               .value0 as Map<String, Any>)
                              .size == 2) -> {
            val h = v.value0["head"]!!;
            val xss = v.value0["tail"]!!;
            object   {
                val v1 = PS.Data.List.Lazy.Module.uncons.app(h);
              }
              .run({
                val v1 = this.v1;
                when {
                  (v1 is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                    PS.Data.List.Lazy.Module.transpose.app(xss);
                  }
                  (v1 is PS.Data.Maybe.Module._Type_Maybe
                           .Just)&& ((v1
                                        .value0 as Map<String, Any>)
                                       .size == 2) -> {
                    val x = v1.value0["head"]!!;
                    val xs_tick = v1.value0["tail"]!!;
                    PS.Data.List.Lazy.Types.Module.cons
                      .app(PS.Data.List.Lazy.Types.Module.cons.app(x)
                             .app(PS.Data.List.Lazy.Module.mapMaybe
                                    .app(PS.Data.List.Lazy.Module.head)
                                    .app(xss)))
                      .app(PS.Data.List.Lazy.Module.transpose
                             .app(PS.Data.List.Lazy.Types.Module.cons
                                    .app(xs_tick)
                                    .app(PS.Data.List.Lazy.Module.mapMaybe
                                           .app(PS.Data.List.Lazy.Module.tail)
                                           .app(xss))));
                  }
                  else -> (error("Error in Pattern Match") as Any)
                };
              });
          }
          else -> (error("Error in Pattern Match") as Any)
        };
      })
  };
  @JvmField val groupBy = (::__rec_groupBy)();
  fun __rec_groupBy(): Any = { eq : Any ->
     object   {
         val go = { v : Any ->
            when {
             (v is PS.Data.List.Lazy.Types.Module._Type_Step.Nil) -> {
               PS.Data.List.Lazy.Types.Module.Nil;
             }
             (v is PS.Data.List.Lazy.Types.Module._Type_Step.Cons) -> {
               val x = v.value0;
               val xs = v.value1;
               object   {
                   val v1 = PS.Data.List.Lazy.Module.span.app(eq.app(x))
                              .app(xs);
                 }
                 .run({
                   val v1 = this.v1;
                   when {
                     ((v1 as Map<String, Any>).size == 2) -> {
                       val ys = v1["init"]!!;
                       val zs = v1["rest"]!!;
                       PS.Data.List.Lazy.Types.Module.Cons
                         .app(PS.Data.List.Lazy.Types.Module.NonEmptyList
                                .app(PS.Data.Lazy.Module.defer
                                       .app({ v2 : Any ->
                                  PS.Data.NonEmpty.Module.NonEmpty.app(x)
                                    .app(ys)
                               })))
                         .app(PS.Data.List.Lazy.Module.groupBy.app(eq).app(zs));
                     }
                     else -> (error("Error in Pattern Match") as Any)
                   };
                 });
             }
             else -> (error("Error in Pattern Match") as Any)
           }
         };
       }
       .run({
        val go = this.go;
        PS.Control.Semigroupoid.Module.compose
          .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
          .app(PS.Data.List.Lazy.Types.Module.List)
          .app(PS.Control.Semigroupoid.Module.compose
                 .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                 .app(PS.Data.Functor.Module.map
                        .app(PS.Data.Lazy.Module.functorLazy)
                        .app(go))
                 .app(PS.Data.Newtype.Module.unwrap
                        .app(PS.Data.List.Lazy.Types.Module.newtypeList)));
      })
  };
  @JvmField
  val group = { dictEq : Any ->
     PS.Data.List.Lazy.Module.groupBy.app(PS.Data.Eq.Module.eq.app(dictEq))
  };
  @JvmField
  val fromStep = PS.Control.Semigroupoid.Module.compose
                   .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                   .app(PS.Data.List.Lazy.Types.Module.List)
                   .app(PS.Control.Applicative.Module.pure
                          .app(PS.Data.Lazy.Module.applicativeLazy));
  @JvmField val insertBy = (::__rec_insertBy)();
  fun __rec_insertBy(): Any = { cmp : Any ->
     { x : Any ->
       { xs : Any ->
         object   {
             val go = { v : Any ->
                when {
                 (v is PS.Data.List.Lazy.Types.Module._Type_Step.Nil) -> {
                   PS.Data.List.Lazy.Types.Module.Cons.app(x)
                     .app(PS.Data.List.Lazy.Types.Module.nil);
                 }
                 (v is PS.Data.List.Lazy.Types.Module._Type_Step.Cons) -> {
                   val ys = v;
                   val y = v.value0;
                   val ys_tick = v.value1;
                   object   {
                       val v1 = cmp.app(x).app(y);
                     }
                     .run({
                       val v1 = this.v1;
                       when {
                         (v1 is PS.Data.Ordering.Module._Type_Ordering.GT) -> {
                           PS.Data.List.Lazy.Types.Module.Cons.app(y)
                             .app(PS.Data.List.Lazy.Module.insertBy.app(cmp)
                                    .app(x)
                                    .app(ys_tick));
                         }
                         else -> {
                           PS.Data.List.Lazy.Types.Module.Cons.app(x)
                             .app(PS.Data.List.Lazy.Module.fromStep.app(ys));
                         }
                       };
                     });
                 }
                 else -> (error("Error in Pattern Match") as Any)
               }
             };
           }
           .run({
            val go = this.go;
            PS.Data.List.Lazy.Types.Module.List
              .app(PS.Data.Functor.Module.map
                     .app(PS.Data.Lazy.Module.functorLazy)
                     .app(go)
                     .app(PS.Data.Newtype.Module.unwrap
                            .app(PS.Data.List.Lazy.Types.Module.newtypeList)
                            .app(xs)));
          })
      }
    }
  };
  @JvmField
  val insert = { dictOrd : Any ->
     PS.Data.List.Lazy.Module.insertBy
       .app(PS.Data.Ord.Module.compare.app(dictOrd))
  };
  @JvmField
  val fromFoldable = { dictFoldable : Any ->
     PS.Data.Foldable.Module.foldr.app(dictFoldable)
       .app(PS.Data.List.Lazy.Types.Module.cons)
       .app(PS.Data.List.Lazy.Types.Module.nil)
  };
  @JvmField
  val foldrLazy = { dictLazy : Any ->
     { op : Any ->
       { z : Any ->
         object   {
             val go = (::__rec_go)();
             fun __rec_go(): Any = { xs : Any ->
                object   {
                    val v = PS.Data.List.Lazy.Types.Module.step.app(xs);
                  }
                  .run({
                   val v = this.v;
                   when {
                     (v is PS.Data.List.Lazy.Types.Module._Type_Step.Cons) -> {
                       val x = v.value0;
                       val xs_tick = v.value1;
                       PS.Control.Lazy.Module.defer.app(dictLazy)
                         .app({ v1 : Any ->
                            op.app(x).app(__rec_go().app(xs_tick))
                         });
                     }
                     (v is PS.Data.List.Lazy.Types.Module._Type_Step.Nil) -> {
                       z;
                     }
                     else -> (error("Error in Pattern Match") as Any)
                   };
                 })
             };
           }
           .run({
            val go = this.go;
            go;
          })
      }
    }
  };
  @JvmField val foldM = (::__rec_foldM)();
  fun __rec_foldM(): Any = { dictMonad : Any ->
     { f : Any ->
       { a : Any ->
         { xs : Any ->
           object   {
               val v = PS.Data.List.Lazy.Module.uncons.app(xs);
             }
             .run({
              val v = this.v;
              when {
                (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                  PS.Control.Applicative.Module.pure
                    .app((dictMonad as Map<String, Any>)["Applicative0"]!!
                           .app(Unit))
                    .app(a);
                }
                (v is PS.Data.Maybe.Module._Type_Maybe
                        .Just)&& ((v
                                     .value0 as Map<String, Any>)
                                    .size == 2) -> {
                  val b = v.value0["head"]!!;
                  val bs = v.value0["tail"]!!;
                  PS.Control.Bind.Module.bind
                    .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
                    .app(f.app(a).app(b))
                    .app({ a_tick : Any ->
                       PS.Data.List.Lazy.Module.foldM.app(dictMonad).app(f)
                         .app(a_tick)
                         .app(bs)
                    });
                }
                else -> (error("Error in Pattern Match") as Any)
              };
            })
        }
      }
    }
  };
  @JvmField
  val findIndex = { fn : Any ->
     object   {
         val go = (::__rec_go)();
         fun __rec_go(): Any = { n : Any ->
            { list : Any ->
              PS.Control.Bind.Module.bind.app(PS.Data.Maybe.Module.bindMaybe)
                .app(PS.Data.List.Lazy.Module.uncons.app(list))
                .app({ v : Any ->
                 val o = v;
                   when {
                     (fn.app((o as Map<String, Any>)["head"]!!) == true) -> {
                       PS.Control.Applicative.Module.pure
                         .app(PS.Data.Maybe.Module.applicativeMaybe)
                         .app(n);
                     }
                     else -> {
                       __rec_go()
                         .app(PS.Data.Semiring.Module.add
                                .app(PS.Data.Semiring.Module.semiringInt)
                                .app(n)
                                .app(1))
                         .app((o as Map<String, Any>)["tail"]!!);
                     }
                   };})
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
                       .app(PS.Data.List.Lazy.Module.length.app(xs))
                       .app(1))
                .app(v)
           })
         .app(PS.Data.List.Lazy.Module.findIndex.app(fn)
                .app(PS.Data.List.Lazy.Module.reverse.app(xs)))
    }
  };
  @JvmField val filterM = (::__rec_filterM)();
  fun __rec_filterM(): Any = { dictMonad : Any ->
     { p : Any ->
       { list : Any ->
         object   {
             val v = PS.Data.List.Lazy.Module.uncons.app(list);
           }
           .run({
            val v = this.v;
            when {
              (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                PS.Control.Applicative.Module.pure
                  .app((dictMonad as Map<String, Any>)["Applicative0"]!!
                         .app(Unit))
                  .app(PS.Data.List.Lazy.Types.Module.nil);
              }
              (v is PS.Data.Maybe.Module._Type_Maybe
                      .Just)&& ((v
                                   .value0 as Map<String, Any>)
                                  .size == 2) -> {
                val x = v.value0["head"]!!;
                val xs = v.value0["tail"]!!;
                PS.Control.Bind.Module.bind
                  .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
                  .app(p.app(x))
                  .app({ v1 : Any ->
                    val b = v1;
                      PS.Control.Bind.Module.bind
                        .app((dictMonad as Map<String, Any>)["Bind1"]!!
                               .app(Unit))
                        .app(PS.Data.List.Lazy.Module.filterM.app(dictMonad)
                               .app(p)
                               .app(xs))
                        .app({ v2 : Any ->
                          val xs_tick = v2;
                            PS.Control.Applicative.Module.pure
                              .app(
                                (dictMonad as Map<String, Any>)["Applicative0"]!!
                                  .app(Unit))
                              .app(when {
                                (b == true) -> {
                                  PS.Data.List.Lazy.Types.Module.cons.app(x)
                                    .app(xs_tick);
                                }
                                else -> {
                                  xs_tick;
                                }
                              });});});
              }
              else -> (error("Error in Pattern Match") as Any)
            };
          })
      }
    }
  };
  @JvmField val filter = (::__rec_filter)();
  fun __rec_filter(): Any = { p : Any ->
     object   {
         val go = (::__rec_go)();
         fun __rec_go(): Any = { v : Any ->
            when {
             (v is PS.Data.List.Lazy.Types.Module._Type_Step.Nil) -> {
               PS.Data.List.Lazy.Types.Module.Nil;
             }
             (v is PS.Data.List.Lazy.Types.Module._Type_Step
                     .Cons)&& (p.app(v.value0) as Boolean) -> {
               val x = v.value0;
               val xs = v.value1;
               PS.Data.List.Lazy.Types.Module.Cons.app(x)
                 .app(PS.Data.List.Lazy.Module.filter.app(p).app(xs));
             }
             (v is PS.Data.List.Lazy.Types.Module._Type_Step
                     .Cons)&& (PS.Data.Boolean.Module.otherwise as Boolean) -> {
               val x = v.value0;
               val xs = v.value1;
               __rec_go().app(PS.Data.List.Lazy.Types.Module.step.app(xs));
             }
             else -> (error("Error in Pattern Match") as Any)
           }
         };
       }
       .run({
        val go = this.go;
        PS.Control.Semigroupoid.Module.compose
          .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
          .app(PS.Data.List.Lazy.Types.Module.List)
          .app(PS.Control.Semigroupoid.Module.compose
                 .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                 .app(PS.Data.Functor.Module.map
                        .app(PS.Data.Lazy.Module.functorLazy)
                        .app(go))
                 .app(PS.Data.Newtype.Module.unwrap
                        .app(PS.Data.List.Lazy.Types.Module.newtypeList)));
      })
  };
  @JvmField
  val intersectBy = { eq : Any ->
     { xs : Any ->
       { ys : Any ->
         PS.Data.List.Lazy.Module.filter
           .app({ x : Any ->
                PS.Data.Foldable.Module.any
                  .app(PS.Data.List.Lazy.Types.Module.foldableList)
                  .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
                  .app(eq.app(x))
                  .app(ys)
             })
           .app(xs)
      }
    }
  };
  @JvmField
  val intersect = { dictEq : Any ->
     PS.Data.List.Lazy.Module.intersectBy.app(PS.Data.Eq.Module.eq.app(dictEq))
  };
  @JvmField val nubBy = (::__rec_nubBy)();
  fun __rec_nubBy(): Any = { eq : Any ->
     object   {
         val go = { v : Any ->
            when {
             (v is PS.Data.List.Lazy.Types.Module._Type_Step.Nil) -> {
               PS.Data.List.Lazy.Types.Module.Nil;
             }
             (v is PS.Data.List.Lazy.Types.Module._Type_Step.Cons) -> {
               val x = v.value0;
               val xs = v.value1;
               PS.Data.List.Lazy.Types.Module.Cons.app(x)
                 .app(PS.Data.List.Lazy.Module.nubBy.app(eq)
                        .app(PS.Data.List.Lazy.Module.filter
                               .app({ y : Any ->
                                    PS.Data.HeytingAlgebra.Module.not
                                      .app(
                                        PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean
                                      )
                                      .app(eq.app(x).app(y))
                                 })
                               .app(xs)));
             }
             else -> (error("Error in Pattern Match") as Any)
           }
         };
       }
       .run({
        val go = this.go;
        PS.Control.Semigroupoid.Module.compose
          .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
          .app(PS.Data.List.Lazy.Types.Module.List)
          .app(PS.Control.Semigroupoid.Module.compose
                 .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                 .app(PS.Data.Functor.Module.map
                        .app(PS.Data.Lazy.Module.functorLazy)
                        .app(go))
                 .app(PS.Data.Newtype.Module.unwrap
                        .app(PS.Data.List.Lazy.Types.Module.newtypeList)));
      })
  };
  @JvmField
  val nub = { dictEq : Any ->
     PS.Data.List.Lazy.Module.nubBy.app(PS.Data.Eq.Module.eq.app(dictEq))
  };
  @JvmField
  val eqPattern = { dictEq : Any ->
     PS.Data.Eq.Module.Eq
       .app({ x : Any ->
         { y : Any ->
          val l = x;
            val r = y;
            PS.Data.Eq.Module.eq
              .app(PS.Data.List.Lazy.Types.Module.eqList.app(dictEq))
              .app(l)
              .app(r);}
      })
  };
  @JvmField
  val ordPattern = { dictOrd : Any ->
     PS.Data.Ord.Module.Ord
       .app({ _ : Any ->
            PS.Data.List.Lazy.Module.eqPattern
              .app((dictOrd as Map<String, Any>)["Eq0"]!!.app(Unit))
         })
       .app({ x : Any ->
         { y : Any ->
          val l = x;
            val r = y;
            PS.Data.Ord.Module.compare
              .app(PS.Data.List.Lazy.Types.Module.ordList.app(dictOrd))
              .app(l)
              .app(r);}
      })
  };
  @JvmField
  val elemLastIndex = { dictEq : Any ->
     { x : Any ->
       PS.Data.List.Lazy.Module.findLastIndex
         .app({ v : Any ->
           PS.Data.Eq.Module.eq.app(dictEq).app(v).app(x)
        })
    }
  };
  @JvmField
  val elemIndex = { dictEq : Any ->
     { x : Any ->
       PS.Data.List.Lazy.Module.findIndex
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
             (v is PS.Data.List.Lazy.Types.Module._Type_Step
                     .Cons)&& (p.app(v.value0) as Boolean) -> {
               val x = v.value0;
               val xs = v.value1;
               __rec_go().app(PS.Data.List.Lazy.Types.Module.step.app(xs));
             }
             else -> {
               val xs = v;
               PS.Data.List.Lazy.Module.fromStep.app(xs);
             }
           }
         };
       }
       .run({
        val go = this.go;
        PS.Control.Semigroupoid.Module.compose
          .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
          .app(go)
          .app(PS.Data.List.Lazy.Types.Module.step);
      })
  };
  @JvmField
  val drop = { n : Any ->
     object   {
         val go = (::__rec_go)();
         fun __rec_go(): Any = { v : Any ->
            { v1 : Any ->
              when {
               (v == 0) -> {
                 val xs = v1;
                 xs;
               }
               (v1 is PS.Data.List.Lazy.Types.Module._Type_Step.Nil) -> {
                 PS.Data.List.Lazy.Types.Module.Nil;
               }
               (v1 is PS.Data.List.Lazy.Types.Module._Type_Step.Cons) -> {
                 val n_tick = v;
                 val x = v1.value0;
                 val xs = v1.value1;
                 __rec_go()
                   .app(PS.Data.Ring.Module.sub.app(PS.Data.Ring.Module.ringInt)
                          .app(n_tick)
                          .app(1))
                   .app(PS.Data.List.Lazy.Types.Module.step.app(xs));
               }
               else -> (error("Error in Pattern Match") as Any)
             }
           }
         };
       }
       .run({
        val go = this.go;
        PS.Control.Semigroupoid.Module.compose
          .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
          .app(PS.Data.List.Lazy.Types.Module.List)
          .app(PS.Control.Semigroupoid.Module.compose
                 .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                 .app(PS.Data.Functor.Module.map
                        .app(PS.Data.Lazy.Module.functorLazy)
                        .app(go.app(n)))
                 .app(PS.Data.Newtype.Module.unwrap
                        .app(PS.Data.List.Lazy.Types.Module.newtypeList)));
      })
  };
  @JvmField
  val slice = { start : Any ->
     { end : Any ->
       { xs : Any ->
         PS.Data.List.Lazy.Module.take
           .app(PS.Data.Ring.Module.sub.app(PS.Data.Ring.Module.ringInt)
                  .app(end)
                  .app(start))
           .app(PS.Data.List.Lazy.Module.drop.app(start).app(xs))
      }
    }
  };
  @JvmField val deleteBy = (::__rec_deleteBy)();
  fun __rec_deleteBy(): Any = { eq : Any ->
     { x : Any ->
       { xs : Any ->
         object   {
             val go = { v : Any ->
                when {
                 (v is PS.Data.List.Lazy.Types.Module._Type_Step.Nil) -> {
                   PS.Data.List.Lazy.Types.Module.Nil;
                 }
                 (v is PS.Data.List.Lazy.Types.Module._Type_Step
                         .Cons)&& (eq.app(x).app(v.value0) as Boolean) -> {
                   val y = v.value0;
                   val ys = v.value1;
                   PS.Data.List.Lazy.Types.Module.step.app(ys);
                 }
                 (v is PS.Data.List.Lazy.Types.Module._Type_Step
                         .Cons)&&
                 (PS.Data.Boolean.Module.otherwise as Boolean) -> {
                   val y = v.value0;
                   val ys = v.value1;
                   PS.Data.List.Lazy.Types.Module.Cons.app(y)
                     .app(PS.Data.List.Lazy.Module.deleteBy.app(eq).app(x)
                            .app(ys));
                 }
                 else -> (error("Error in Pattern Match") as Any)
               }
             };
           }
           .run({
            val go = this.go;
            PS.Data.List.Lazy.Types.Module.List
              .app(PS.Data.Functor.Module.map
                     .app(PS.Data.Lazy.Module.functorLazy)
                     .app(go)
                     .app(PS.Data.Newtype.Module.unwrap
                            .app(PS.Data.List.Lazy.Types.Module.newtypeList)
                            .app(xs)));
          })
      }
    }
  };
  @JvmField
  val unionBy = { eq : Any ->
     { xs : Any ->
       { ys : Any ->
         PS.Data.Semigroup.Module.append
           .app(PS.Data.List.Lazy.Types.Module.semigroupList)
           .app(xs)
           .app(PS.Data.Foldable.Module.foldl
                  .app(PS.Data.List.Lazy.Types.Module.foldableList)
                  .app(PS.Data.Function.Module.flip
                         .app(PS.Data.List.Lazy.Module.deleteBy.app(eq)))
                  .app(PS.Data.List.Lazy.Module.nubBy.app(eq).app(ys))
                  .app(xs))
      }
    }
  };
  @JvmField
  val union = { dictEq : Any ->
     PS.Data.List.Lazy.Module.unionBy.app(PS.Data.Eq.Module.eq.app(dictEq))
  };
  @JvmField val deleteAt = (::__rec_deleteAt)();
  fun __rec_deleteAt(): Any = { n : Any ->
     { xs : Any ->
       object   {
           val go = { v : Any ->
              { v1 : Any ->
                when {
                 (v1 is PS.Data.List.Lazy.Types.Module._Type_Step.Nil) -> {
                   PS.Data.List.Lazy.Types.Module.Nil;
                 }
                 (v == 0)&& (v1 is PS.Data.List.Lazy.Types.Module._Type_Step
                                     .Cons) -> {
                   val y = v1.value0;
                   val ys = v1.value1;
                   PS.Data.List.Lazy.Types.Module.step.app(ys);
                 }
                 (v1 is PS.Data.List.Lazy.Types.Module._Type_Step.Cons) -> {
                   val n_tick = v;
                   val y = v1.value0;
                   val ys = v1.value1;
                   PS.Data.List.Lazy.Types.Module.Cons.app(y)
                     .app(PS.Data.List.Lazy.Module.deleteAt
                            .app(PS.Data.Ring.Module.sub
                                   .app(PS.Data.Ring.Module.ringInt)
                                   .app(n_tick)
                                   .app(1))
                            .app(ys));
                 }
                 else -> (error("Error in Pattern Match") as Any)
               }
             }
           };
         }
         .run({
          val go = this.go;
          PS.Data.List.Lazy.Types.Module.List
            .app(PS.Data.Functor.Module.map.app(PS.Data.Lazy.Module.functorLazy)
                   .app(go.app(n))
                   .app(PS.Data.Newtype.Module.unwrap
                          .app(PS.Data.List.Lazy.Types.Module.newtypeList)
                          .app(xs)));
        })
    }
  };
  @JvmField
  val delete = { dictEq : Any ->
     PS.Data.List.Lazy.Module.deleteBy.app(PS.Data.Eq.Module.eq.app(dictEq))
  };
  @JvmField
  val difference = { dictEq : Any ->
     PS.Data.Foldable.Module.foldl
       .app(PS.Data.List.Lazy.Types.Module.foldableList)
       .app(PS.Data.Function.Module.flip
              .app(PS.Data.List.Lazy.Module.delete.app(dictEq)))
  };
  @JvmField
  val cycle = { xs : Any ->
     PS.Control.Lazy.Module.fix.app(PS.Data.List.Lazy.Types.Module.lazyList)
       .app({ ys : Any ->
         PS.Data.Semigroup.Module.append
           .app(PS.Data.List.Lazy.Types.Module.semigroupList)
           .app(xs)
           .app(ys)
      })
  };
  @JvmField
  val concatMap = PS.Data.Function.Module.flip
                    .app(PS.Control.Bind.Module.bind
                           .app(PS.Data.List.Lazy.Types.Module.bindList));
  @JvmField
  val concat = { v : Any ->
     PS.Control.Bind.Module.bind.app(PS.Data.List.Lazy.Types.Module.bindList)
       .app(v)
       .app(PS.Control.Category.Module.identity
              .app(PS.Control.Category.Module.categoryFn))
  };
  @JvmField
  val catMaybes = PS.Data.List.Lazy.Module.mapMaybe
                    .app(PS.Control.Category.Module.identity
                           .app(PS.Control.Category.Module.categoryFn));
  @JvmField val alterAt = (::__rec_alterAt)();
  fun __rec_alterAt(): Any = { n : Any ->
     { f : Any ->
       { xs : Any ->
         object   {
             val go = { v : Any ->
                { v1 : Any ->
                  when {
                   (v1 is PS.Data.List.Lazy.Types.Module._Type_Step.Nil) -> {
                     PS.Data.List.Lazy.Types.Module.Nil;
                   }
                   (v == 0)&& (v1 is PS.Data.List.Lazy.Types.Module._Type_Step
                                       .Cons) -> {
                     val y = v1.value0;
                     val ys = v1.value1;
                     object   {
                         val v2 = f.app(y);
                       }
                       .run({
                         val v2 = this.v2;
                         when {
                           (v2 is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                             PS.Data.List.Lazy.Types.Module.step.app(ys);
                           }
                           (v2 is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
                             val y_tick = v2.value0;
                             PS.Data.List.Lazy.Types.Module.Cons.app(y_tick)
                               .app(ys);
                           }
                           else -> (error("Error in Pattern Match") as Any)
                         };
                       });
                   }
                   (v1 is PS.Data.List.Lazy.Types.Module._Type_Step.Cons) -> {
                     val n_tick = v;
                     val y = v1.value0;
                     val ys = v1.value1;
                     PS.Data.List.Lazy.Types.Module.Cons.app(y)
                       .app(PS.Data.List.Lazy.Module.alterAt
                              .app(PS.Data.Ring.Module.sub
                                     .app(PS.Data.Ring.Module.ringInt)
                                     .app(n_tick)
                                     .app(1))
                              .app(f)
                              .app(ys));
                   }
                   else -> (error("Error in Pattern Match") as Any)
                 }
               }
             };
           }
           .run({
            val go = this.go;
            PS.Data.List.Lazy.Types.Module.List
              .app(PS.Data.Functor.Module.map
                     .app(PS.Data.Lazy.Module.functorLazy)
                     .app(go.app(n))
                     .app(PS.Data.Newtype.Module.unwrap
                            .app(PS.Data.List.Lazy.Types.Module.newtypeList)
                            .app(xs)));
          })
      }
    }
  };
  @JvmField
  val modifyAt = { n : Any ->
     { f : Any ->
       PS.Data.List.Lazy.Module.alterAt.app(n)
         .app(PS.Control.Semigroupoid.Module.compose
                .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                .app(PS.Data.Maybe.Module.Just)
                .app(f))
    }
  };
}