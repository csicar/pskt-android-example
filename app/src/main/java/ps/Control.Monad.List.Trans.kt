@file:Suppress("UNCHECKED_CAST")
package PS.Control.Monad.List.Trans
import Foreign.PsRuntime.app
object Module  {
  sealed class _Type_Step ()  {
    data class Yield (val value0 : Any,  val value1 : Any) : _Type_Step() {};
    data class Skip (val value0 : Any) : _Type_Step() {};
    object Done : _Type_Step() {};
  };
  val Yield = { value0 : Any ->
     { value1 : Any ->
       _Type_Step.Yield(value0,  value1)
    }
  };
  val Skip = { value0 : Any -> _Type_Step.Skip(value0)};
  val Done = _Type_Step.Done;
  @JvmField val ListT = { x : Any -> x};
  @JvmField
  val wrapLazy = { dictApplicative : Any ->
     { v : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Control.Monad.List.Trans.Module.ListT)
         .app(PS.Control.Applicative.Module.pure.app(dictApplicative)
                .app(PS.Control.Monad.List.Trans.Module.Skip.app(v)))
    }
  };
  @JvmField
  val wrapEffect = { dictFunctor : Any ->
     { v : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Control.Monad.List.Trans.Module.ListT)
         .app(PS.Data.Functor.Module.map.app(dictFunctor)
                .app(PS.Control.Semigroupoid.Module.compose
                       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                       .app(PS.Control.Monad.List.Trans.Module.Skip)
                       .app(PS.Control.Semigroupoid.Module.compose
                              .app(PS.Control.Semigroupoid.Module.semigroupoidFn
                              )
                              .app(PS.Data.Lazy.Module.defer)
                              .app(PS.Data.Function.Module._const)))
                .app(v))
    }
  };
  @JvmField val unfold = (::__rec_unfold)();
  fun __rec_unfold(): Any = { dictMonad : Any ->
     { f : Any ->
       { z : Any ->
         object   {
             val g = { v : Any ->
                when {
                 (v is PS.Data.Maybe.Module._Type_Maybe
                         .Just)&& (v
                                     .value0 is PS.Data.Tuple.Module._Type_Tuple
                                                  .Tuple) -> {
                   val z_tick = v.value0.value0;
                   val a = v.value0.value1;
                   PS.Control.Monad.List.Trans.Module.Yield.app(a)
                     .app(PS.Data.Lazy.Module.defer
                            .app({ v1 : Any ->
                          PS.Control.Monad.List.Trans.Module.unfold
                            .app(dictMonad)
                            .app(f)
                            .app(z_tick)
                       }));
                 }
                 (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                   PS.Control.Monad.List.Trans.Module.Done;
                 }
                 else -> (error("Error in Pattern Match") as Any)
               }
             };
           }
           .run({
            val g = this.g;
            PS.Data.Function.Module.apply
              .app(PS.Control.Monad.List.Trans.Module.ListT)
              .app(PS.Data.Functor.Module.map
                     .app((((dictMonad as Map<String, Any>)["Bind1"]!!
                              .app(Unit) as Map<String, Any>)["Apply0"]!!
                             .app(Unit) as Map<String, Any>)["Functor0"]!!
                            .app(Unit))
                     .app(g)
                     .app(f.app(z)));
          })
      }
    }
  };
  @JvmField val uncons = (::__rec_uncons)();
  fun __rec_uncons(): Any = { dictMonad : Any ->
     { v : Any ->
       when {
        else -> {
          val l = v;
          object   {
              val g = { v1 : Any ->
                 when {
                  (v1 is PS.Control.Monad.List.Trans.Module._Type_Step
                           .Yield) -> {
                    val a = v1.value0;
                    val s = v1.value1;
                    PS.Data.Function.Module.apply
                      .app(PS.Control.Applicative.Module.pure
                             .app(
                          (dictMonad as Map<String, Any>)["Applicative0"]!!
                            .app(Unit)))
                      .app(PS.Data.Function.Module.apply
                             .app(PS.Data.Maybe.Module.Just)
                             .app(PS.Data.Tuple.Module.Tuple.app(a)
                                    .app(PS.Data.Lazy.Module.force.app(s))));
                  }
                  (v1 is PS.Control.Monad.List.Trans.Module._Type_Step
                           .Skip) -> {
                    val s = v1.value0;
                    PS.Control.Monad.List.Trans.Module.uncons.app(dictMonad)
                      .app(PS.Data.Lazy.Module.force.app(s));
                  }
                  (v1 is PS.Control.Monad.List.Trans.Module._Type_Step
                           .Done) -> {
                    PS.Control.Applicative.Module.pure
                      .app((dictMonad as Map<String, Any>)["Applicative0"]!!
                             .app(Unit))
                      .app(PS.Data.Maybe.Module.Nothing);
                  }
                  else -> (error("Error in Pattern Match") as Any)
                }
              };
            }
            .run({
              val g = this.g;
              PS.Control.Bind.Module.bind
                .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
                .app(l)
                .app(g);
            });
        }
      }
    }
  };
  @JvmField
  val tail = { dictMonad : Any ->
     { l : Any ->
       PS.Data.Functor.Module.map
         .app((((dictMonad as Map<String, Any>)["Bind1"]!!
                  .app(Unit) as Map<String, Any>)["Apply0"]!!
                 .app(Unit) as Map<String, Any>)["Functor0"]!!
                .app(Unit))
         .app(PS.Data.Functor.Module.map.app(PS.Data.Maybe.Module.functorMaybe)
                .app(PS.Data.Tuple.Module.snd))
         .app(PS.Control.Monad.List.Trans.Module.uncons.app(dictMonad).app(l))
    }
  };
  @JvmField
  val stepMap = { dictFunctor : Any ->
     { f : Any ->
       { v : Any ->
         when {
          else -> {
            val f1 = f;
            val l = v;
            PS.Data.Function.Module.apply
              .app(PS.Control.Monad.List.Trans.Module.ListT)
              .app(PS.Data.Functor.Module.map.app(dictFunctor).app(f1).app(l));
          }
        }
      }
    }
  };
  @JvmField val takeWhile = (::__rec_takeWhile)();
  fun __rec_takeWhile(): Any = { dictApplicative : Any ->
     { f : Any ->
       object   {
           val g = { v : Any ->
              when {
               (v is PS.Control.Monad.List.Trans.Module._Type_Step.Yield) -> {
                 val a = v.value0;
                 val s = v.value1;
                 when {
                   (f.app(a) == true) -> {
                     PS.Control.Monad.List.Trans.Module.Yield.app(a)
                       .app(PS.Data.Functor.Module.map
                              .app(PS.Data.Lazy.Module.functorLazy)
                              .app(PS.Control.Monad.List.Trans.Module.takeWhile
                                     .app(dictApplicative)
                                     .app(f))
                              .app(s));
                   }
                   else -> {
                     PS.Control.Monad.List.Trans.Module.Done;
                   }
                 };
               }
               (v is PS.Control.Monad.List.Trans.Module._Type_Step.Skip) -> {
                 val s = v.value0;
                 PS.Data.Function.Module.apply
                   .app(PS.Control.Monad.List.Trans.Module.Skip)
                   .app(PS.Data.Functor.Module.map
                          .app(PS.Data.Lazy.Module.functorLazy)
                          .app(PS.Control.Monad.List.Trans.Module.takeWhile
                                 .app(dictApplicative)
                                 .app(f))
                          .app(s));
               }
               (v is PS.Control.Monad.List.Trans.Module._Type_Step.Done) -> {
                 PS.Control.Monad.List.Trans.Module.Done;
               }
               else -> (error("Error in Pattern Match") as Any)
             }
           };
         }
         .run({
          val g = this.g;
          PS.Control.Monad.List.Trans.Module.stepMap
            .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                    .app(Unit) as Map<String, Any>)["Functor0"]!!
                   .app(Unit))
            .app(g);
        })
    }
  };
  @JvmField
  val scanl = { dictMonad : Any ->
     { f : Any ->
       { b : Any ->
         { l : Any ->
           object   {
               val g = { v : Any ->
                  when {
                   (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                     val b_tick = v.value0;
                     val l_tick = v.value1;
                     object   {
                         val h = { v1 : Any ->
                            when {
                             (v1 is PS.Control.Monad.List.Trans.Module._Type_Step
                                      .Yield) -> {
                               val a = v1.value0;
                               val s = v1.value1;
                               object   {
                                   val b_tick_tick = f.app(b_tick).app(a);
                                 }
                                 .run({
                                   val b_tick_tick = this.b_tick_tick;
                                   PS.Data.Function.Module.apply
                                     .app(PS.Data.Maybe.Module.Just)
                                     .app(PS.Data.Tuple.Module.Tuple
                                            .app(PS.Data.Tuple.Module.Tuple
                                                   .app(b_tick_tick)
                                                   .app(
                                                PS.Data.Lazy.Module.force.app(s)
                                              ))
                                            .app(b_tick));
                                 });
                             }
                             (v1 is PS.Control.Monad.List.Trans.Module._Type_Step
                                      .Skip) -> {
                               val s = v1.value0;
                               PS.Data.Function.Module.apply
                                 .app(PS.Data.Maybe.Module.Just)
                                 .app(PS.Data.Tuple.Module.Tuple
                                        .app(PS.Data.Tuple.Module.Tuple
                                               .app(b_tick)
                                               .app(PS.Data.Lazy.Module.force
                                                      .app(s)))
                                        .app(b_tick));
                             }
                             (v1 is PS.Control.Monad.List.Trans.Module._Type_Step
                                      .Done) -> {
                               PS.Data.Maybe.Module.Nothing;
                             }
                             else -> (error("Error in Pattern Match") as Any)
                           }
                         };
                       }
                       .run({
                         val h = this.h;
                         PS.Data.Functor.Module.map
                           .app((((dictMonad as Map<String, Any>)["Bind1"]!!
                                    .app(Unit) as Map<String, Any>)["Apply0"]!!
                                   .app(Unit) as Map<String, Any>)["Functor0"]!!
                                  .app(Unit))
                           .app(h)
                           .app(l_tick);
                       });
                   }
                   else -> (error("Error in Pattern Match") as Any)
                 }
               };
             }
             .run({
              val g = this.g;
              PS.Control.Monad.List.Trans.Module.unfold.app(dictMonad).app(g)
                .app(PS.Data.Tuple.Module.Tuple.app(b).app(l));
            })
        }
      }
    }
  };
  @JvmField
  val prepend_tick = { dictApplicative : Any ->
     { h : Any ->
       { t : Any ->
         PS.Data.Function.Module.apply
           .app(PS.Control.Monad.List.Trans.Module.ListT)
           .app(PS.Control.Applicative.Module.pure.app(dictApplicative)
                  .app(PS.Control.Monad.List.Trans.Module.Yield.app(h).app(t)))
      }
    }
  };
  @JvmField
  val prepend = { dictApplicative : Any ->
     { h : Any ->
       { t : Any ->
         PS.Control.Monad.List.Trans.Module.prepend_tick.app(dictApplicative)
           .app(h)
           .app(PS.Data.Function.Module.apply.app(PS.Data.Lazy.Module.defer)
                  .app(PS.Data.Function.Module._const.app(t)))
      }
    }
  };
  @JvmField
  val nil = { dictApplicative : Any ->
     PS.Data.Function.Module.apply.app(PS.Control.Monad.List.Trans.Module.ListT)
       .app(PS.Control.Applicative.Module.pure.app(dictApplicative)
              .app(PS.Control.Monad.List.Trans.Module.Done))
  };
  @JvmField
  val singleton = { dictApplicative : Any ->
     { a : Any ->
       PS.Control.Monad.List.Trans.Module.prepend.app(dictApplicative).app(a)
         .app(PS.Control.Monad.List.Trans.Module.nil.app(dictApplicative))
    }
  };
  @JvmField val take = (::__rec_take)();
  fun __rec_take(): Any = { dictApplicative : Any ->
     { v : Any ->
       { fa : Any ->
         when {
          (v == 0) -> {
            val fa1 = fa;
            PS.Control.Monad.List.Trans.Module.nil.app(dictApplicative);
          }
          else -> {
            val n = v;
            val fa1 = fa;
            object   {
                val f = { v1 : Any ->
                   when {
                    (v1 is PS.Control.Monad.List.Trans.Module._Type_Step
                             .Yield) -> {
                      val a = v1.value0;
                      val s = v1.value1;
                      PS.Control.Monad.List.Trans.Module.Yield.app(a)
                        .app(PS.Data.Functor.Module.map
                               .app(PS.Data.Lazy.Module.functorLazy)
                               .app(PS.Control.Monad.List.Trans.Module.take
                                      .app(dictApplicative)
                                      .app(PS.Data.Ring.Module.sub
                                             .app(PS.Data.Ring.Module.ringInt)
                                             .app(n)
                                             .app(1)))
                               .app(s));
                    }
                    (v1 is PS.Control.Monad.List.Trans.Module._Type_Step
                             .Skip) -> {
                      val s = v1.value0;
                      PS.Control.Monad.List.Trans.Module.Skip
                        .app(PS.Data.Functor.Module.map
                               .app(PS.Data.Lazy.Module.functorLazy)
                               .app(PS.Control.Monad.List.Trans.Module.take
                                      .app(dictApplicative)
                                      .app(n))
                               .app(s));
                    }
                    (v1 is PS.Control.Monad.List.Trans.Module._Type_Step
                             .Done) -> {
                      PS.Control.Monad.List.Trans.Module.Done;
                    }
                    else -> (error("Error in Pattern Match") as Any)
                  }
                };
              }
              .run({
                val f = this.f;
                PS.Control.Monad.List.Trans.Module.stepMap
                  .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                          .app(Unit) as Map<String, Any>)["Functor0"]!!
                         .app(Unit))
                  .app(f)
                  .app(fa1);
              });
          }
        }
      }
    }
  };
  @JvmField val zipWith_tick = (::__rec_zipWith_tick)();
  fun __rec_zipWith_tick(): Any = { dictMonad : Any ->
     { f : Any ->
       object   {
           val g = { v : Any ->
              { v1 : Any ->
                when {
                 (v1 is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                   PS.Control.Applicative.Module.pure
                     .app((dictMonad as Map<String, Any>)["Applicative0"]!!
                            .app(Unit))
                     .app(PS.Control.Monad.List.Trans.Module.nil
                            .app(
                       (dictMonad as Map<String, Any>)["Applicative0"]!!
                         .app(Unit)));
                 }
                 (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                   PS.Control.Applicative.Module.pure
                     .app((dictMonad as Map<String, Any>)["Applicative0"]!!
                            .app(Unit))
                     .app(PS.Control.Monad.List.Trans.Module.nil
                            .app(
                       (dictMonad as Map<String, Any>)["Applicative0"]!!
                         .app(Unit)));
                 }
                 (v is PS.Data.Maybe.Module._Type_Maybe
                         .Just)&& (v
                                     .value0 is PS.Data.Tuple.Module._Type_Tuple
                                                  .Tuple)&&
                 (v1 is PS.Data.Maybe.Module._Type_Maybe
                          .Just)&& (v1
                                      .value0 is PS.Data.Tuple.Module._Type_Tuple
                                                   .Tuple) -> {
                   val ha = v.value0.value0;
                   val ta = v.value0.value1;
                   val hb = v1.value0.value0;
                   val tb = v1.value0.value1;
                   PS.Data.Functor.Module.map
                     .app((((dictMonad as Map<String, Any>)["Bind1"]!!
                              .app(Unit) as Map<String, Any>)["Apply0"]!!
                             .app(Unit) as Map<String, Any>)["Functor0"]!!
                            .app(Unit))
                     .app(PS.Data.Function.Module.flip
                            .app(PS.Control.Monad.List.Trans.Module.prepend_tick
                                   .app(
                                (dictMonad as Map<String, Any>)["Applicative0"]!!
                                  .app(Unit)))
                            .app(PS.Data.Lazy.Module.defer
                                   .app({ v2 : Any ->
                              PS.Control.Monad.List.Trans.Module.zipWith_tick
                                .app(dictMonad)
                                .app(f)
                                .app(ta)
                                .app(tb)
                           })))
                     .app(f.app(ha).app(hb));
                 }
                 else -> (error("Error in Pattern Match") as Any)
               }
             }
           };
           val loop = { fa : Any ->
              { fb : Any ->
                PS.Control.Monad.List.Trans.Module.wrapEffect
                  .app((((dictMonad as Map<String, Any>)["Bind1"]!!
                           .app(Unit) as Map<String, Any>)["Apply0"]!!
                          .app(Unit) as Map<String, Any>)["Functor0"]!!
                         .app(Unit))
                  .app(PS.Control.Bind.Module.bind
                         .app((dictMonad as Map<String, Any>)["Bind1"]!!
                                .app(Unit))
                         .app(PS.Control.Monad.List.Trans.Module.uncons
                                .app(dictMonad)
                                .app(fa))
                         .app({ v : Any ->
                      when {
                       else -> {
                         val ua = v;
                         PS.Control.Bind.Module.bind
                           .app((dictMonad as Map<String, Any>)["Bind1"]!!
                                  .app(Unit))
                           .app(PS.Control.Monad.List.Trans.Module.uncons
                                  .app(dictMonad)
                                  .app(fb))
                           .app({ v1 : Any ->
                              when {
                               else -> {
                                 val ub = v1;
                                 g.app(ua).app(ub);
                               }
                             }
                           });
                       }
                     }
                   }))
             }
           };
         }
         .run({
          val g = this.g;
          val loop = this.loop;
          loop;
        })
    }
  };
  @JvmField
  val zipWith = { dictMonad : Any ->
     { f : Any ->
       object   {
           val g = { a : Any ->
              { b : Any ->
                PS.Data.Function.Module.apply
                  .app(PS.Control.Applicative.Module.pure
                         .app((dictMonad as Map<String, Any>)["Applicative0"]!!
                                .app(Unit)))
                  .app(f.app(a).app(b))
             }
           };
         }
         .run({
          val g = this.g;
          PS.Control.Monad.List.Trans.Module.zipWith_tick.app(dictMonad).app(g);
        })
    }
  };
  @JvmField
  val newtypeListT = PS.Data.Newtype.Module.Newtype
                       .app({ n : Any ->
                            when {
                             else -> {
                               val a = n;
                               a;
                             }
                           }
                         })
                       .app(PS.Control.Monad.List.Trans.Module.ListT);
  @JvmField val mapMaybe = (::__rec_mapMaybe)();
  fun __rec_mapMaybe(): Any = { dictFunctor : Any ->
     { f : Any ->
       object   {
           val g = { v : Any ->
              when {
               (v is PS.Control.Monad.List.Trans.Module._Type_Step.Yield) -> {
                 val a = v.value0;
                 val s = v.value1;
                 PS.Data.Maybe.Module.fromMaybe
                   .app(PS.Control.Monad.List.Trans.Module.Skip)
                   .app(PS.Data.Functor.Module.map
                          .app(PS.Data.Maybe.Module.functorMaybe)
                          .app(PS.Control.Monad.List.Trans.Module.Yield)
                          .app(f.app(a)))
                   .app(PS.Data.Functor.Module.map
                          .app(PS.Data.Lazy.Module.functorLazy)
                          .app(PS.Control.Monad.List.Trans.Module.mapMaybe
                                 .app(dictFunctor)
                                 .app(f))
                          .app(s));
               }
               (v is PS.Control.Monad.List.Trans.Module._Type_Step.Skip) -> {
                 val s = v.value0;
                 PS.Data.Function.Module.apply
                   .app(PS.Control.Monad.List.Trans.Module.Skip)
                   .app(PS.Data.Functor.Module.map
                          .app(PS.Data.Lazy.Module.functorLazy)
                          .app(PS.Control.Monad.List.Trans.Module.mapMaybe
                                 .app(dictFunctor)
                                 .app(f))
                          .app(s));
               }
               (v is PS.Control.Monad.List.Trans.Module._Type_Step.Done) -> {
                 PS.Control.Monad.List.Trans.Module.Done;
               }
               else -> (error("Error in Pattern Match") as Any)
             }
           };
         }
         .run({
          val g = this.g;
          PS.Control.Monad.List.Trans.Module.stepMap.app(dictFunctor).app(g);
        })
    }
  };
  @JvmField
  val iterate = { dictMonad : Any ->
     { f : Any ->
       { a : Any ->
         object   {
             val g = { x : Any ->
                PS.Data.Function.Module.apply
                  .app(PS.Control.Applicative.Module.pure
                         .app((dictMonad as Map<String, Any>)["Applicative0"]!!
                                .app(Unit)))
                  .app(PS.Data.Maybe.Module.Just
                         .app(PS.Data.Tuple.Module.Tuple.app(f.app(x)).app(x)))
             };
           }
           .run({
            val g = this.g;
            PS.Control.Monad.List.Trans.Module.unfold.app(dictMonad).app(g)
              .app(a);
          })
      }
    }
  };
  @JvmField
  val repeat = { dictMonad : Any ->
     PS.Control.Monad.List.Trans.Module.iterate.app(dictMonad)
       .app(PS.Control.Category.Module.identity
              .app(PS.Control.Category.Module.categoryFn))
  };
  @JvmField
  val head = { dictMonad : Any ->
     { l : Any ->
       PS.Data.Functor.Module.map
         .app((((dictMonad as Map<String, Any>)["Bind1"]!!
                  .app(Unit) as Map<String, Any>)["Apply0"]!!
                 .app(Unit) as Map<String, Any>)["Functor0"]!!
                .app(Unit))
         .app(PS.Data.Functor.Module.map.app(PS.Data.Maybe.Module.functorMaybe)
                .app(PS.Data.Tuple.Module.fst))
         .app(PS.Control.Monad.List.Trans.Module.uncons.app(dictMonad).app(l))
    }
  };
  @JvmField val functorListT = (::__rec_functorListT)();
  fun __rec_functorListT(): Any = { dictFunctor : Any ->
     PS.Data.Functor.Module.Functor
       .app({ f : Any ->
         object   {
             val g = { v : Any ->
                when {
                 (v is PS.Control.Monad.List.Trans.Module._Type_Step.Yield) -> {
                   val a = v.value0;
                   val s = v.value1;
                   PS.Control.Monad.List.Trans.Module.Yield.app(f.app(a))
                     .app(PS.Data.Functor.Module.map
                            .app(PS.Data.Lazy.Module.functorLazy)
                            .app(PS.Data.Functor.Module.map
                                   .app(
                                     PS.Control.Monad.List.Trans.Module.functorListT
                                       .app(dictFunctor))
                                   .app(f))
                            .app(s));
                 }
                 (v is PS.Control.Monad.List.Trans.Module._Type_Step.Skip) -> {
                   val s = v.value0;
                   PS.Control.Monad.List.Trans.Module.Skip
                     .app(PS.Data.Functor.Module.map
                            .app(PS.Data.Lazy.Module.functorLazy)
                            .app(PS.Data.Functor.Module.map
                                   .app(
                                     PS.Control.Monad.List.Trans.Module.functorListT
                                       .app(dictFunctor))
                                   .app(f))
                            .app(s));
                 }
                 (v is PS.Control.Monad.List.Trans.Module._Type_Step.Done) -> {
                   PS.Control.Monad.List.Trans.Module.Done;
                 }
                 else -> (error("Error in Pattern Match") as Any)
               }
             };
           }
           .run({
            val g = this.g;
            PS.Control.Monad.List.Trans.Module.stepMap.app(dictFunctor).app(g);
          })
      })
  };
  @JvmField
  val fromEffect = { dictApplicative : Any ->
     { fa : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Control.Monad.List.Trans.Module.ListT)
         .app(PS.Data.Functor.Module.map
                .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                        .app(Unit) as Map<String, Any>)["Functor0"]!!
                       .app(Unit))
                .app(PS.Data.Function.Module.flip
                       .app(PS.Control.Monad.List.Trans.Module.Yield)
                       .app(PS.Data.Function.Module.apply
                              .app(PS.Data.Lazy.Module.defer)
                              .app({ v : Any ->
                         PS.Control.Monad.List.Trans.Module.nil
                           .app(dictApplicative)
                      })))
                .app(fa))
    }
  };
  @JvmField
  val monadTransListT = PS.Control.Monad.Trans.Class.Module.MonadTrans
                          .app({ dictMonad : Any ->
       PS.Control.Monad.List.Trans.Module.fromEffect
         .app((dictMonad as Map<String, Any>)["Applicative0"]!!.app(Unit))
    });
  @JvmField
  val foldlRec_tick = { dictMonadRec : Any ->
     { f : Any ->
       object   {
           val loop = { b : Any ->
              { l : Any ->
                object   {
                    val g = { v : Any ->
                       when {
                        (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                          PS.Control.Applicative.Module.pure
                            .app(((dictMonadRec as Map<String, Any>)["Monad0"]!!
                                    .app(Unit
                                   ) as Map<String, Any>)["Applicative0"]!!
                                   .app(Unit))
                            .app(PS.Control.Monad.Rec.Class.Module.Done.app(b));
                        }
                        (v is PS.Data.Maybe.Module._Type_Maybe
                                .Just)&& (v
                                            .value0 is PS.Data.Tuple.Module._Type_Tuple
                                                         .Tuple) -> {
                          val a = v.value0.value0;
                          val _as = v.value0.value1;
                          PS.Control.Bind.Module.bind
                            .app(((dictMonadRec as Map<String, Any>)["Monad0"]!!
                                    .app(Unit) as Map<String, Any>)["Bind1"]!!
                                   .app(Unit))
                            .app(f.app(b).app(a))
                            .app({ b_tick : Any ->
                               PS.Control.Applicative.Module.pure
                                 .app(
                                   ((dictMonadRec as Map<String, Any>)["Monad0"]!!
                                      .app(Unit
                                     ) as Map<String, Any>)["Applicative0"]!!
                                     .app(Unit))
                                 .app(PS.Control.Monad.Rec.Class.Module.Loop
                                        .app(mapOf(("a" to b_tick),  
                                    ("b" to _as))))
                            });
                        }
                        else -> (error("Error in Pattern Match") as Any)
                      }
                    };
                  }
                  .run({
                   val g = this.g;
                   PS.Control.Bind.Module.bind
                     .app(((dictMonadRec as Map<String, Any>)["Monad0"]!!
                             .app(Unit) as Map<String, Any>)["Bind1"]!!
                            .app(Unit))
                     .app(PS.Control.Monad.List.Trans.Module.uncons
                            .app((dictMonadRec as Map<String, Any>)["Monad0"]!!
                                   .app(Unit))
                            .app(l))
                     .app(g);
                 })
             }
           };
         }
         .run({
          val loop = this.loop;
          PS.Control.Monad.Rec.Class.Module.tailRecM2.app(dictMonadRec)
            .app(loop);
        })
    }
  };
  @JvmField
  val runListTRec = { dictMonadRec : Any ->
     PS.Control.Monad.List.Trans.Module.foldlRec_tick.app(dictMonadRec)
       .app({ v : Any ->
            { v1 : Any ->
              PS.Control.Applicative.Module.pure
                .app(((dictMonadRec as Map<String, Any>)["Monad0"]!!
                        .app(Unit) as Map<String, Any>)["Applicative0"]!!
                       .app(Unit))
                .app(PS.Data.Unit.Module.unit)
           }
         })
       .app(PS.Data.Unit.Module.unit)
  };
  @JvmField
  val foldlRec = { dictMonadRec : Any ->
     { f : Any ->
       object   {
           val loop = { b : Any ->
              { l : Any ->
                object   {
                    val g = { v : Any ->
                       when {
                        (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                          PS.Control.Applicative.Module.pure
                            .app(((dictMonadRec as Map<String, Any>)["Monad0"]!!
                                    .app(Unit
                                   ) as Map<String, Any>)["Applicative0"]!!
                                   .app(Unit))
                            .app(PS.Control.Monad.Rec.Class.Module.Done.app(b));
                        }
                        (v is PS.Data.Maybe.Module._Type_Maybe
                                .Just)&& (v
                                            .value0 is PS.Data.Tuple.Module._Type_Tuple
                                                         .Tuple) -> {
                          val a = v.value0.value0;
                          val _as = v.value0.value1;
                          PS.Control.Applicative.Module.pure
                            .app(((dictMonadRec as Map<String, Any>)["Monad0"]!!
                                    .app(Unit
                                   ) as Map<String, Any>)["Applicative0"]!!
                                   .app(Unit))
                            .app(PS.Control.Monad.Rec.Class.Module.Loop
                                   .app(mapOf(("a" to f.app(b).app(a)),  
                                ("b" to _as))));
                        }
                        else -> (error("Error in Pattern Match") as Any)
                      }
                    };
                  }
                  .run({
                   val g = this.g;
                   PS.Control.Bind.Module.bind
                     .app(((dictMonadRec as Map<String, Any>)["Monad0"]!!
                             .app(Unit) as Map<String, Any>)["Bind1"]!!
                            .app(Unit))
                     .app(PS.Control.Monad.List.Trans.Module.uncons
                            .app((dictMonadRec as Map<String, Any>)["Monad0"]!!
                                   .app(Unit))
                            .app(l))
                     .app(g);
                 })
             }
           };
         }
         .run({
          val loop = this.loop;
          PS.Control.Monad.Rec.Class.Module.tailRecM2.app(dictMonadRec)
            .app(loop);
        })
    }
  };
  @JvmField
  val foldl_tick = { dictMonad : Any ->
     { f : Any ->
       object   {
           val loop = (::__rec_loop)();
           fun __rec_loop(): Any = { b : Any ->
              { l : Any ->
                object   {
                    val g = { v : Any ->
                       when {
                        (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                          PS.Control.Applicative.Module.pure
                            .app(
                              (dictMonad as Map<String, Any>)["Applicative0"]!!
                                .app(Unit))
                            .app(b);
                        }
                        (v is PS.Data.Maybe.Module._Type_Maybe
                                .Just)&& (v
                                            .value0 is PS.Data.Tuple.Module._Type_Tuple
                                                         .Tuple) -> {
                          val a = v.value0.value0;
                          val _as = v.value0.value1;
                          PS.Control.Bind.Module.bind
                            .app((dictMonad as Map<String, Any>)["Bind1"]!!
                                   .app(Unit))
                            .app(f.app(b).app(a))
                            .app(PS.Data.Function.Module.flip.app(__rec_loop())
                                   .app(_as));
                        }
                        else -> (error("Error in Pattern Match") as Any)
                      }
                    };
                  }
                  .run({
                   val g = this.g;
                   PS.Control.Bind.Module.bind
                     .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
                     .app(PS.Control.Monad.List.Trans.Module.uncons
                            .app(dictMonad)
                            .app(l))
                     .app(g);
                 })
             }
           };
         }
         .run({
          val loop = this.loop;
          loop;
        })
    }
  };
  @JvmField
  val runListT = { dictMonad : Any ->
     PS.Control.Monad.List.Trans.Module.foldl_tick.app(dictMonad)
       .app({ v : Any ->
            { v1 : Any ->
              PS.Control.Applicative.Module.pure
                .app((dictMonad as Map<String, Any>)["Applicative0"]!!.app(Unit)
                )
                .app(PS.Data.Unit.Module.unit)
           }
         })
       .app(PS.Data.Unit.Module.unit)
  };
  @JvmField
  val foldl = { dictMonad : Any ->
     { f : Any ->
       object   {
           val loop = (::__rec_loop)();
           fun __rec_loop(): Any = { b : Any ->
              { l : Any ->
                object   {
                    val g = { v : Any ->
                       when {
                        (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                          PS.Control.Applicative.Module.pure
                            .app(
                              (dictMonad as Map<String, Any>)["Applicative0"]!!
                                .app(Unit))
                            .app(b);
                        }
                        (v is PS.Data.Maybe.Module._Type_Maybe
                                .Just)&& (v
                                            .value0 is PS.Data.Tuple.Module._Type_Tuple
                                                         .Tuple) -> {
                          val a = v.value0.value0;
                          val _as = v.value0.value1;
                          __rec_loop().app(f.app(b).app(a)).app(_as);
                        }
                        else -> (error("Error in Pattern Match") as Any)
                      }
                    };
                  }
                  .run({
                   val g = this.g;
                   PS.Control.Bind.Module.bind
                     .app((dictMonad as Map<String, Any>)["Bind1"]!!.app(Unit))
                     .app(PS.Control.Monad.List.Trans.Module.uncons
                            .app(dictMonad)
                            .app(l))
                     .app(g);
                 })
             }
           };
         }
         .run({
          val loop = this.loop;
          loop;
        })
    }
  };
  @JvmField val filter = (::__rec_filter)();
  fun __rec_filter(): Any = { dictFunctor : Any ->
     { f : Any ->
       object   {
           val g = { v : Any ->
              when {
               (v is PS.Control.Monad.List.Trans.Module._Type_Step.Yield) -> {
                 val a = v.value0;
                 val s = v.value1;
                 object   {
                     val s_tick = PS.Data.Functor.Module.map
                                    .app(PS.Data.Lazy.Module.functorLazy)
                                    .app(
                                      PS.Control.Monad.List.Trans.Module.filter
                                        .app(dictFunctor)
                                        .app(f))
                                    .app(s);
                   }
                   .run({
                     val s_tick = this.s_tick;
                     when {
                       (f.app(a) == true) -> {
                         PS.Control.Monad.List.Trans.Module.Yield.app(a)
                           .app(s_tick);
                       }
                       else -> {
                         PS.Control.Monad.List.Trans.Module.Skip.app(s_tick);
                       }
                     };
                   });
               }
               (v is PS.Control.Monad.List.Trans.Module._Type_Step.Skip) -> {
                 val s = v.value0;
                 object   {
                     val s_tick = PS.Data.Functor.Module.map
                                    .app(PS.Data.Lazy.Module.functorLazy)
                                    .app(
                                      PS.Control.Monad.List.Trans.Module.filter
                                        .app(dictFunctor)
                                        .app(f))
                                    .app(s);
                   }
                   .run({
                     val s_tick = this.s_tick;
                     PS.Control.Monad.List.Trans.Module.Skip.app(s_tick);
                   });
               }
               (v is PS.Control.Monad.List.Trans.Module._Type_Step.Done) -> {
                 PS.Control.Monad.List.Trans.Module.Done;
               }
               else -> (error("Error in Pattern Match") as Any)
             }
           };
         }
         .run({
          val g = this.g;
          PS.Control.Monad.List.Trans.Module.stepMap.app(dictFunctor).app(g);
        })
    }
  };
  @JvmField val dropWhile = (::__rec_dropWhile)();
  fun __rec_dropWhile(): Any = { dictApplicative : Any ->
     { f : Any ->
       object   {
           val g = { v : Any ->
              when {
               (v is PS.Control.Monad.List.Trans.Module._Type_Step.Yield) -> {
                 val a = v.value0;
                 val s = v.value1;
                 when {
                   (f.app(a) == true) -> {
                     PS.Control.Monad.List.Trans.Module.Skip
                       .app(PS.Data.Functor.Module.map
                              .app(PS.Data.Lazy.Module.functorLazy)
                              .app(PS.Control.Monad.List.Trans.Module.dropWhile
                                     .app(dictApplicative)
                                     .app(f))
                              .app(s));
                   }
                   else -> {
                     PS.Control.Monad.List.Trans.Module.Yield.app(a).app(s);
                   }
                 };
               }
               (v is PS.Control.Monad.List.Trans.Module._Type_Step.Skip) -> {
                 val s = v.value0;
                 PS.Data.Function.Module.apply
                   .app(PS.Control.Monad.List.Trans.Module.Skip)
                   .app(PS.Data.Functor.Module.map
                          .app(PS.Data.Lazy.Module.functorLazy)
                          .app(PS.Control.Monad.List.Trans.Module.dropWhile
                                 .app(dictApplicative)
                                 .app(f))
                          .app(s));
               }
               (v is PS.Control.Monad.List.Trans.Module._Type_Step.Done) -> {
                 PS.Control.Monad.List.Trans.Module.Done;
               }
               else -> (error("Error in Pattern Match") as Any)
             }
           };
         }
         .run({
          val g = this.g;
          PS.Control.Monad.List.Trans.Module.stepMap
            .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                    .app(Unit) as Map<String, Any>)["Functor0"]!!
                   .app(Unit))
            .app(g);
        })
    }
  };
  @JvmField val drop = (::__rec_drop)();
  fun __rec_drop(): Any = { dictApplicative : Any ->
     { v : Any ->
       { fa : Any ->
         when {
          (v == 0) -> {
            val fa1 = fa;
            fa1;
          }
          else -> {
            val n = v;
            val fa1 = fa;
            object   {
                val f = { v1 : Any ->
                   when {
                    (v1 is PS.Control.Monad.List.Trans.Module._Type_Step
                             .Yield) -> {
                      val a = v1.value0;
                      val s = v1.value1;
                      PS.Control.Monad.List.Trans.Module.Skip
                        .app(PS.Data.Functor.Module.map
                               .app(PS.Data.Lazy.Module.functorLazy)
                               .app(PS.Control.Monad.List.Trans.Module.drop
                                      .app(dictApplicative)
                                      .app(PS.Data.Ring.Module.sub
                                             .app(PS.Data.Ring.Module.ringInt)
                                             .app(n)
                                             .app(1)))
                               .app(s));
                    }
                    (v1 is PS.Control.Monad.List.Trans.Module._Type_Step
                             .Skip) -> {
                      val s = v1.value0;
                      PS.Control.Monad.List.Trans.Module.Skip
                        .app(PS.Data.Functor.Module.map
                               .app(PS.Data.Lazy.Module.functorLazy)
                               .app(PS.Control.Monad.List.Trans.Module.drop
                                      .app(dictApplicative)
                                      .app(n))
                               .app(s));
                    }
                    (v1 is PS.Control.Monad.List.Trans.Module._Type_Step
                             .Done) -> {
                      PS.Control.Monad.List.Trans.Module.Done;
                    }
                    else -> (error("Error in Pattern Match") as Any)
                  }
                };
              }
              .run({
                val f = this.f;
                PS.Control.Monad.List.Trans.Module.stepMap
                  .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                          .app(Unit) as Map<String, Any>)["Functor0"]!!
                         .app(Unit))
                  .app(f)
                  .app(fa1);
              });
          }
        }
      }
    }
  };
  @JvmField
  val cons = { dictApplicative : Any ->
     { lh : Any ->
       { t : Any ->
         PS.Data.Function.Module.apply
           .app(PS.Control.Monad.List.Trans.Module.ListT)
           .app(PS.Data.Function.Module.apply
                  .app(PS.Control.Applicative.Module.pure.app(dictApplicative))
                  .app(PS.Control.Monad.List.Trans.Module.Yield
                         .app(PS.Data.Lazy.Module.force.app(lh))
                         .app(t)))
      }
    }
  };
  @JvmField
  val unfoldable1ListT = { dictMonad : Any ->
     PS.Data.Unfoldable1.Module.Unfoldable1
       .app({ f : Any ->
         { b : Any ->
           object   {
               val go = (::__rec_go)();
               fun __rec_go(): Any = { v : Any ->
                  when {
                   (v is PS.Data.Tuple.Module._Type_Tuple
                           .Tuple)&& (v
                                        .value1 is PS.Data.Maybe.Module._Type_Maybe
                                                     .Nothing) -> {
                     val x = v.value0;
                     PS.Control.Monad.List.Trans.Module.singleton
                       .app((dictMonad as Map<String, Any>)["Applicative0"]!!
                              .app(Unit))
                       .app(x);
                   }
                   (v is PS.Data.Tuple.Module._Type_Tuple
                           .Tuple)&& (v
                                        .value1 is PS.Data.Maybe.Module._Type_Maybe
                                                     .Just) -> {
                     val x = v.value0;
                     val y = v.value1.value0;
                     PS.Control.Monad.List.Trans.Module.cons
                       .app((dictMonad as Map<String, Any>)["Applicative0"]!!
                              .app(Unit))
                       .app(PS.Control.Applicative.Module.pure
                              .app(PS.Data.Lazy.Module.applicativeLazy)
                              .app(x))
                       .app(PS.Data.Lazy.Module.defer
                              .app({ v1 : Any ->
                            __rec_go().app(f.app(y))
                         }));
                   }
                   else -> (error("Error in Pattern Match") as Any)
                 }
               };
             }
             .run({
              val go = this.go;
              go.app(f.app(b));
            })
        }
      })
  };
  @JvmField
  val unfoldableListT = { dictMonad : Any ->
     PS.Data.Unfoldable.Module.Unfoldable
       .app({ _ : Any ->
            PS.Control.Monad.List.Trans.Module.unfoldable1ListT.app(dictMonad)
         })
       .app({ f : Any ->
         { b : Any ->
           object   {
               val go = (::__rec_go)();
               fun __rec_go(): Any = { v : Any ->
                  when {
                   (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                     PS.Control.Monad.List.Trans.Module.nil
                       .app((dictMonad as Map<String, Any>)["Applicative0"]!!
                              .app(Unit));
                   }
                   (v is PS.Data.Maybe.Module._Type_Maybe
                           .Just)&& (v
                                       .value0 is PS.Data.Tuple.Module._Type_Tuple
                                                    .Tuple) -> {
                     val x = v.value0.value0;
                     val y = v.value0.value1;
                     PS.Control.Monad.List.Trans.Module.cons
                       .app((dictMonad as Map<String, Any>)["Applicative0"]!!
                              .app(Unit))
                       .app(PS.Control.Applicative.Module.pure
                              .app(PS.Data.Lazy.Module.applicativeLazy)
                              .app(x))
                       .app(PS.Data.Lazy.Module.defer
                              .app({ v1 : Any ->
                            __rec_go().app(f.app(y))
                         }));
                   }
                   else -> (error("Error in Pattern Match") as Any)
                 }
               };
             }
             .run({
              val go = this.go;
              go.app(f.app(b));
            })
        }
      })
  };
  @JvmField val semigroupListT = (::__rec_semigroupListT)();
  @JvmField val concat = (::__rec_concat)();
  fun __rec_semigroupListT(): Any = { dictApplicative : Any ->
     PS.Data.Semigroup.Module.Semigroup
       .app(PS.Control.Monad.List.Trans.Module.concat.app(dictApplicative))
  };
  fun __rec_concat(): Any = { dictApplicative : Any ->
     { x : Any ->
       { y : Any ->
         object   {
             val f = { v : Any ->
                when {
                 (v is PS.Control.Monad.List.Trans.Module._Type_Step.Yield) -> {
                   val a = v.value0;
                   val s = v.value1;
                   PS.Control.Monad.List.Trans.Module.Yield.app(a)
                     .app(PS.Data.Functor.Module.map
                            .app(PS.Data.Lazy.Module.functorLazy)
                            .app({ v1 : Any ->
                                 PS.Data.Semigroup.Module.append
                                   .app(
                                     PS.Control.Monad.List.Trans.Module.semigroupListT
                                       .app(dictApplicative))
                                   .app(v1)
                                   .app(y)
                              })
                            .app(s));
                 }
                 (v is PS.Control.Monad.List.Trans.Module._Type_Step.Skip) -> {
                   val s = v.value0;
                   PS.Control.Monad.List.Trans.Module.Skip
                     .app(PS.Data.Functor.Module.map
                            .app(PS.Data.Lazy.Module.functorLazy)
                            .app({ v1 : Any ->
                                 PS.Data.Semigroup.Module.append
                                   .app(
                                     PS.Control.Monad.List.Trans.Module.semigroupListT
                                       .app(dictApplicative))
                                   .app(v1)
                                   .app(y)
                              })
                            .app(s));
                 }
                 (v is PS.Control.Monad.List.Trans.Module._Type_Step.Done) -> {
                   PS.Control.Monad.List.Trans.Module.Skip
                     .app(PS.Data.Function.Module.apply
                            .app(PS.Data.Lazy.Module.defer)
                            .app(PS.Data.Function.Module._const.app(y)));
                 }
                 else -> (error("Error in Pattern Match") as Any)
               }
             };
           }
           .run({
            val f = this.f;
            PS.Control.Monad.List.Trans.Module.stepMap
              .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                      .app(Unit) as Map<String, Any>)["Functor0"]!!
                     .app(Unit))
              .app(f)
              .app(x);
          })
      }
    }
  };
  @JvmField
  val monoidListT = { dictApplicative : Any ->
     PS.Data.Monoid.Module.Monoid
       .app({ _ : Any ->
            PS.Control.Monad.List.Trans.Module.semigroupListT
              .app(dictApplicative)
         })
       .app(PS.Control.Monad.List.Trans.Module.nil.app(dictApplicative))
  };
  @JvmField
  val catMaybes = { dictFunctor : Any ->
     PS.Control.Monad.List.Trans.Module.mapMaybe.app(dictFunctor)
       .app(PS.Control.Category.Module.identity
              .app(PS.Control.Category.Module.categoryFn))
  };
  @JvmField val monadListT = (::__rec_monadListT)();
  @JvmField val bindListT = (::__rec_bindListT)();
  @JvmField val applyListT = (::__rec_applyListT)();
  @JvmField val applicativeListT = (::__rec_applicativeListT)();
  fun __rec_monadListT(): Any = { dictMonad : Any ->
     PS.Control.Monad.Module.Monad
       .app({ _ : Any ->
            PS.Control.Monad.List.Trans.Module.applicativeListT.app(dictMonad)
         })
       .app({ _ : Any ->
         PS.Control.Monad.List.Trans.Module.bindListT.app(dictMonad)
      })
  };
  fun __rec_bindListT(): Any = { dictMonad : Any ->
     PS.Control.Bind.Module.Bind
       .app({ _ : Any ->
            PS.Control.Monad.List.Trans.Module.applyListT.app(dictMonad)
         })
       .app({ fa : Any ->
         { f : Any ->
           object   {
               val g = { v : Any ->
                  when {
                   (v is PS.Control.Monad.List.Trans.Module._Type_Step
                           .Yield) -> {
                     val a = v.value0;
                     val s = v.value1;
                     object   {
                         val h = { s_tick : Any ->
                            PS.Data.Semigroup.Module.append
                              .app(
                                PS.Control.Monad.List.Trans.Module.semigroupListT
                                  .app(
                                  (dictMonad as Map<String, Any>)["Applicative0"]!!
                                    .app(Unit)))
                              .app(f.app(a))
                              .app(PS.Control.Bind.Module.bind
                                     .app(
                                       PS.Control.Monad.List.Trans.Module.bindListT
                                         .app(dictMonad))
                                     .app(s_tick)
                                     .app(f))
                         };
                       }
                       .run({
                         val h = this.h;
                         PS.Control.Monad.List.Trans.Module.Skip
                           .app(PS.Data.Functor.Module.map
                                  .app(PS.Data.Lazy.Module.functorLazy)
                                  .app(h)
                                  .app(s));
                       });
                   }
                   (v is PS.Control.Monad.List.Trans.Module._Type_Step
                           .Skip) -> {
                     val s = v.value0;
                     PS.Control.Monad.List.Trans.Module.Skip
                       .app(PS.Data.Functor.Module.map
                              .app(PS.Data.Lazy.Module.functorLazy)
                              .app({ v1 : Any ->
                                   PS.Control.Bind.Module.bind
                                     .app(
                                       PS.Control.Monad.List.Trans.Module.bindListT
                                         .app(dictMonad))
                                     .app(v1)
                                     .app(f)
                                })
                              .app(s));
                   }
                   (v is PS.Control.Monad.List.Trans.Module._Type_Step
                           .Done) -> {
                     PS.Control.Monad.List.Trans.Module.Done;
                   }
                   else -> (error("Error in Pattern Match") as Any)
                 }
               };
             }
             .run({
              val g = this.g;
              PS.Control.Monad.List.Trans.Module.stepMap
                .app((((dictMonad as Map<String, Any>)["Bind1"]!!
                         .app(Unit) as Map<String, Any>)["Apply0"]!!
                        .app(Unit) as Map<String, Any>)["Functor0"]!!
                       .app(Unit))
                .app(g)
                .app(fa);
            })
        }
      })
  };
  fun __rec_applyListT(): Any = { dictMonad : Any ->
     PS.Control.Apply.Module.Apply
       .app({ _ : Any ->
            PS.Control.Monad.List.Trans.Module.functorListT
              .app((((dictMonad as Map<String, Any>)["Bind1"]!!
                       .app(Unit) as Map<String, Any>)["Apply0"]!!
                      .app(Unit) as Map<String, Any>)["Functor0"]!!
                     .app(Unit))
         })
       .app(PS.Control.Monad.Module.ap
              .app(PS.Control.Monad.List.Trans.Module.monadListT.app(dictMonad))
    )
  };
  fun __rec_applicativeListT(): Any = { dictMonad : Any ->
     PS.Control.Applicative.Module.Applicative
       .app({ _ : Any ->
            PS.Control.Monad.List.Trans.Module.applyListT.app(dictMonad)
         })
       .app(PS.Control.Monad.List.Trans.Module.singleton
              .app((dictMonad as Map<String, Any>)["Applicative0"]!!.app(Unit)))
  };
  @JvmField
  val monadEffectListT = { dictMonadEffect : Any ->
     PS.Effect.Class.Module.MonadEffect
       .app({ _ : Any ->
            PS.Control.Monad.List.Trans.Module.monadListT
              .app((dictMonadEffect as Map<String, Any>)["Monad0"]!!.app(Unit))
         })
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Control.Monad.Trans.Class.Module.lift
                     .app(PS.Control.Monad.List.Trans.Module.monadTransListT)
                     .app((dictMonadEffect as Map<String, Any>)["Monad0"]!!
                            .app(Unit)))
              .app(PS.Effect.Class.Module.liftEffect.app(dictMonadEffect)))
  };
  @JvmField
  val altListT = { dictApplicative : Any ->
     PS.Control.Alt.Module.Alt
       .app({ _ : Any ->
            PS.Control.Monad.List.Trans.Module.functorListT
              .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                      .app(Unit) as Map<String, Any>)["Functor0"]!!
                     .app(Unit))
         })
       .app(PS.Control.Monad.List.Trans.Module.concat.app(dictApplicative))
  };
  @JvmField
  val plusListT = { dictMonad : Any ->
     PS.Control.Plus.Module.Plus
       .app({ _ : Any ->
            PS.Control.Monad.List.Trans.Module.altListT
              .app((dictMonad as Map<String, Any>)["Applicative0"]!!.app(Unit))
         })
       .app(PS.Control.Monad.List.Trans.Module.nil
              .app((dictMonad as Map<String, Any>)["Applicative0"]!!.app(Unit)))
  };
  @JvmField
  val alternativeListT = { dictMonad : Any ->
     PS.Control.Alternative.Module.Alternative
       .app({ _ : Any ->
            PS.Control.Monad.List.Trans.Module.applicativeListT.app(dictMonad)
         })
       .app({ _ : Any ->
         PS.Control.Monad.List.Trans.Module.plusListT.app(dictMonad)
      })
  };
  @JvmField
  val monadZeroListT = { dictMonad : Any ->
     PS.Control.MonadZero.Module.MonadZero
       .app({ _ : Any ->
            PS.Control.Monad.List.Trans.Module.alternativeListT.app(dictMonad)
         })
       .app({ _ : Any ->
         PS.Control.Monad.List.Trans.Module.monadListT.app(dictMonad)
      })
  };
  @JvmField
  val monadPlusListT = { dictMonad : Any ->
     PS.Control.MonadPlus.Module.MonadPlus
       .app({ _ : Any ->
         PS.Control.Monad.List.Trans.Module.monadZeroListT.app(dictMonad)
      })
  };
}