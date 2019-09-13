@file:Suppress("UNCHECKED_CAST")

package PS.Control.Monad.Gen
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  sealed class _Type_LL ()  {
    data class Cons (val value0 : Any,  val value1 : Any) : _Type_LL() {};
    object Nil : _Type_LL() {};
  };
  val Cons = { value0 : Any ->
     { value1 : Any ->
       _Type_LL.Cons(value0,  value1)
    }
  };
  val Nil = _Type_LL.Nil;
  @JvmField val FreqSemigroup = { x : Any -> x};
  @JvmField val AtIndex = { x : Any -> x};
  @JvmField
  val unfoldable = { dictMonadRec : Any ->
     { dictMonadGen : Any ->
       { dictUnfoldable : Any ->
         { gen : Any ->
           object   {
               val unfold = { v : Any ->
                  when {
                   (v is PS.Control.Monad.Gen.Module._Type_LL.Nil) -> {
                     PS.Data.Maybe.Module.Nothing;
                   }
                   (v is PS.Control.Monad.Gen.Module._Type_LL.Cons) -> {
                     val x = v.value0;
                     val xs = v.value1;
                     PS.Data.Maybe.Module.Just
                       .app(PS.Data.Tuple.Module.Tuple.app(x).app(xs));
                   }
                   else -> (error("Error in Pattern Match") as Any)
                 }
               };
               val loopGen = { v : Any ->
                  when {
                   (v is PS.Data.Tuple.Module._Type_Tuple
                           .Tuple)&& (PS.Data.Ord.Module.lessThanOrEq
                                        .app(PS.Data.Ord.Module.ordInt)
                                        .app(v
                                               .value1)
                                        .app(0) as Boolean) -> {
                     val acc = v.value0;
                     val n = v.value1;
                     PS.Data.Function.Module.apply
                       .app(PS.Control.Applicative.Module.pure
                              .app(
                           ((dictMonadGen as Map<String, Any>)["Monad0"]!!
                              .app(Unit) as Map<String, Any>)["Applicative0"]!!
                             .app(Unit)))
                       .app(PS.Control.Monad.Rec.Class.Module.Done.app(acc));
                   }
                   (v is PS.Data.Tuple.Module._Type_Tuple
                           .Tuple)&&
                   (PS.Data.Boolean.Module.otherwise as Boolean) -> {
                     val acc = v.value0;
                     val n = v.value1;
                     PS.Control.Bind.Module.bind
                       .app(((dictMonadGen as Map<String, Any>)["Monad0"]!!
                               .app(Unit) as Map<String, Any>)["Bind1"]!!
                              .app(Unit))
                       .app(gen)
                       .app({ v1 : Any ->
                         val x = v1;
                           PS.Data.Function.Module.apply
                             .app(PS.Control.Applicative.Module.pure
                                    .app(
                                 ((dictMonadGen as Map<String, Any>)["Monad0"]!!
                                    .app(Unit
                                   ) as Map<String, Any>)["Applicative0"]!!
                                   .app(Unit)))
                             .app(PS.Control.Monad.Rec.Class.Module.Loop
                                    .app(PS.Data.Tuple.Module.Tuple
                                           .app(PS.Control.Monad.Gen.Module.Cons
                                                  .app(x)
                                                  .app(acc))
                                           .app(PS.Data.Ring.Module.sub
                                                  .app(
                                                    PS.Data.Ring.Module.ringInt)
                                                  .app(n)
                                                  .app(1))));});
                   }
                   else -> (error("Error in Pattern Match") as Any)
                 }
               };
             }
             .run({
              val unfold = this.unfold;
              val loopGen = this.loopGen;
              PS.Data.Functor.Module.map
                .app(((((dictMonadGen as Map<String, Any>)["Monad0"]!!
                          .app(Unit) as Map<String, Any>)["Bind1"]!!
                         .app(Unit) as Map<String, Any>)["Apply0"]!!
                        .app(Unit) as Map<String, Any>)["Functor0"]!!
                       .app(Unit))
                .app(PS.Data.Unfoldable.Module.unfoldr.app(dictUnfoldable)
                       .app(unfold))
                .app(PS.Control.Monad.Gen.Class.Module.sized.app(dictMonadGen)
                       .app(PS.Control.Semigroupoid.Module.compose
                              .app(PS.Control.Semigroupoid.Module.semigroupoidFn
                              )
                              .app(PS.Control.Monad.Rec.Class.Module.tailRecM
                                     .app(dictMonadRec)
                                     .app(loopGen))
                              .app(PS.Data.Tuple.Module.Tuple
                                     .app(PS.Control.Monad.Gen.Module.Nil))));
            })
        }
      }
    }
  };
  @JvmField
  val semigroupFreqSemigroup = PS.Data.Semigroup.Module.Semigroup
                                 .app({ v : Any ->
       { v1 : Any ->
        val f = v;
          val g = v1;
          PS.Control.Monad.Gen.Module.FreqSemigroup
            .app({ pos : Any ->
               object   {
                   val v2 = f.app(pos);
                 }
                 .run({
                  val v2 = this.v2;
                  when {
                    (v2 is PS.Data.Tuple.Module._Type_Tuple
                             .Tuple)&& (v2
                                          .value0 is PS.Data.Maybe.Module._Type_Maybe
                                                       .Just) -> {
                      val pos_tick = v2.value0.value0;
                      g.app(pos_tick);
                    }
                    else -> {
                      val result = v2;
                      result;
                    }
                  };
                })
            });}
    });
  @JvmField
  val semigroupAtIndex = PS.Data.Semigroup.Module.Semigroup
                           .app({ v : Any ->
       { v1 : Any ->
        val f = v;
          val g = v1;
          PS.Control.Monad.Gen.Module.AtIndex
            .app({ i : Any ->
               when {
                (PS.Data.Ord.Module.lessThanOrEq.app(PS.Data.Ord.Module.ordInt)
                   .app(i)
                   .app(0) == true) -> {
                  f.app(i);
                }
                else -> {
                  g
                    .app(PS.Data.Ring.Module.sub
                           .app(PS.Data.Ring.Module.ringInt)
                           .app(i)
                           .app(1));
                }
              }
            });}
    });
  @JvmField
  val getFreqVal = { v : Any ->
    val f = v;
      PS.Control.Semigroupoid.Module.compose
        .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
        .app(PS.Data.Tuple.Module.snd)
        .app(f);};
  @JvmField val getAtIndex = { v : Any ->val f = v; f;};
  @JvmField
  val freqSemigroup = { v : Any ->
     when {
      (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
        val weight = v.value0;
        val x = v.value1;
        PS.Control.Monad.Gen.Module.FreqSemigroup
          .app({ pos : Any ->
             when {
              (PS.Data.Ord.Module.greaterThanOrEq
                 .app(PS.Data.Ord.Module.ordNumber)
                 .app(pos)
                 .app(weight) == true) -> {
                PS.Data.Tuple.Module.Tuple
                  .app(PS.Data.Maybe.Module.Just
                         .app(PS.Data.Ring.Module.sub
                                .app(PS.Data.Ring.Module.ringNumber)
                                .app(pos)
                                .app(weight)))
                  .app(x);
              }
              else -> {
                PS.Data.Tuple.Module.Tuple.app(PS.Data.Maybe.Module.Nothing)
                  .app(x);
              }
            }
          });
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val frequency = { dictMonadGen : Any ->
     { dictFoldable1 : Any ->
       { xs : Any ->
         object   {
             val total = PS.Data.Newtype.Module.alaF
                           .app(PS.Data.Functor.Module.functorFn)
                           .app(PS.Data.Functor.Module.functorFn)
                           .app(PS.Data.Newtype.Module.newtypeAdditive)
                           .app(PS.Data.Newtype.Module.newtypeAdditive)
                           .app(PS.Data.Monoid.Additive.Module.Additive)
                           .app(PS.Data.Foldable.Module.foldMap
                                  .app(
                                    (dictFoldable1 as Map<String, Any>)["Foldable0"]!!
                                      .app(Unit))
                                  .app(
                               PS.Data.Monoid.Additive.Module.monoidAdditive
                                 .app(PS.Data.Semiring.Module.semiringNumber)))
                           .app(PS.Data.Tuple.Module.fst)
                           .app(xs);
           }
           .run({
            val total = this.total;
            PS.Control.Bind.Module.bind
              .app(((dictMonadGen as Map<String, Any>)["Monad0"]!!
                      .app(Unit) as Map<String, Any>)["Bind1"]!!
                     .app(Unit))
              .app(PS.Control.Monad.Gen.Class.Module.chooseFloat
                     .app(dictMonadGen)
                     .app(0.0)
                     .app(total))
              .app(PS.Control.Monad.Gen.Module.getFreqVal
                     .app(PS.Data.Semigroup.Foldable.Module.foldMap1
                            .app(dictFoldable1)
                            .app(
                              PS.Control.Monad.Gen.Module.semigroupFreqSemigroup
                            )
                            .app(PS.Control.Monad.Gen.Module.freqSemigroup)
                            .app(xs)));
          })
      }
    }
  };
  @JvmField
  val filtered = { dictMonadRec : Any ->
     { dictMonadGen : Any ->
       { gen : Any ->
         object   {
             val go = { v : Any ->
                PS.Data.Functor.Module.mapFlipped
                  .app(((((dictMonadGen as Map<String, Any>)["Monad0"]!!
                            .app(Unit) as Map<String, Any>)["Bind1"]!!
                           .app(Unit) as Map<String, Any>)["Apply0"]!!
                          .app(Unit) as Map<String, Any>)["Functor0"]!!
                         .app(Unit))
                  .app(gen)
                  .app({ a : Any ->
                    when {
                     (a is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                       PS.Control.Monad.Rec.Class.Module.Loop
                         .app(PS.Data.Unit.Module.unit);
                     }
                     (a is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
                       val a_tick = a.value0;
                       PS.Control.Monad.Rec.Class.Module.Done.app(a_tick);
                     }
                     else -> (error("Error in Pattern Match") as Any)
                   }
                 })
             };
           }
           .run({
            val go = this.go;
            PS.Control.Monad.Rec.Class.Module.tailRecM.app(dictMonadRec).app(go)
              .app(PS.Data.Unit.Module.unit);
          })
      }
    }
  };
  @JvmField
  val suchThat = { dictMonadRec : Any ->
     { dictMonadGen : Any ->
       { gen : Any ->
         { pred : Any ->
           PS.Data.Function.Module.apply
             .app(PS.Control.Monad.Gen.Module.filtered.app(dictMonadRec)
                    .app(dictMonadGen))
             .app(PS.Data.Functor.Module.mapFlipped
                    .app(((((dictMonadGen as Map<String, Any>)["Monad0"]!!
                              .app(Unit) as Map<String, Any>)["Bind1"]!!
                             .app(Unit) as Map<String, Any>)["Apply0"]!!
                            .app(Unit) as Map<String, Any>)["Functor0"]!!
                           .app(Unit))
                    .app(gen)
                    .app({ a : Any ->
                 when {
                  (pred.app(a) == true) -> {
                    PS.Data.Maybe.Module.Just.app(a);
                  }
                  else -> {
                    PS.Data.Maybe.Module.Nothing;
                  }
                }
              }))
        }
      }
    }
  };
  @JvmField
  val choose = { dictMonadGen : Any ->
     { genA : Any ->
       { genB : Any ->
         PS.Control.Bind.Module.bind
           .app(((dictMonadGen as Map<String, Any>)["Monad0"]!!
                   .app(Unit) as Map<String, Any>)["Bind1"]!!
                  .app(Unit))
           .app(PS.Control.Monad.Gen.Class.Module.chooseBool.app(dictMonadGen))
           .app({ v : Any ->
             when {
              (v == true) -> {
                genA;
              }
              else -> {
                genB;
              }
            }
          })
      }
    }
  };
  @JvmField
  val atIndex = PS.Control.Semigroupoid.Module.compose
                  .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                  .app(PS.Control.Monad.Gen.Module.AtIndex)
                  .app(PS.Data.Function.Module._const);
  @JvmField
  val fromIndex = { dictFoldable1 : Any ->
     { i : Any ->
       { xs : Any ->
         PS.Control.Monad.Gen.Module.getAtIndex
           .app(PS.Data.Semigroup.Foldable.Module.foldMap1.app(dictFoldable1)
                  .app(PS.Control.Monad.Gen.Module.semigroupAtIndex)
                  .app(PS.Control.Monad.Gen.Module.atIndex)
                  .app(xs))
           .app(i)
      }
    }
  };
  @JvmField
  val elements = { dictMonadGen : Any ->
     { dictFoldable1 : Any ->
       { xs : Any ->
         PS.Control.Bind.Module.bind
           .app(((dictMonadGen as Map<String, Any>)["Monad0"]!!
                   .app(Unit) as Map<String, Any>)["Bind1"]!!
                  .app(Unit))
           .app(PS.Control.Monad.Gen.Class.Module.chooseInt.app(dictMonadGen)
                  .app(0)
                  .app(PS.Data.Ring.Module.sub.app(PS.Data.Ring.Module.ringInt)
                         .app(PS.Data.Foldable.Module.length
                                .app(
                                  (dictFoldable1 as Map<String, Any>)["Foldable0"]!!
                                    .app(Unit))
                                .app(PS.Data.Semiring.Module.semiringInt)
                                .app(xs))
                         .app(1)))
           .app({ v : Any ->
            val n = v;
              PS.Data.Function.Module.apply
                .app(PS.Control.Applicative.Module.pure
                       .app(((dictMonadGen as Map<String, Any>)["Monad0"]!!
                               .app(Unit) as Map<String, Any>)["Applicative0"]!!
                              .app(Unit)))
                .app(PS.Control.Monad.Gen.Module.fromIndex.app(dictFoldable1)
                       .app(n)
                       .app(xs));})
      }
    }
  };
  @JvmField
  val oneOf = { dictMonadGen : Any ->
     { dictFoldable1 : Any ->
       { xs : Any ->
         PS.Control.Bind.Module.bind
           .app(((dictMonadGen as Map<String, Any>)["Monad0"]!!
                   .app(Unit) as Map<String, Any>)["Bind1"]!!
                  .app(Unit))
           .app(PS.Control.Monad.Gen.Class.Module.chooseInt.app(dictMonadGen)
                  .app(0)
                  .app(PS.Data.Ring.Module.sub.app(PS.Data.Ring.Module.ringInt)
                         .app(PS.Data.Foldable.Module.length
                                .app(
                                  (dictFoldable1 as Map<String, Any>)["Foldable0"]!!
                                    .app(Unit))
                                .app(PS.Data.Semiring.Module.semiringInt)
                                .app(xs))
                         .app(1)))
           .app({ v : Any ->
            val n = v;
              PS.Control.Monad.Gen.Module.fromIndex.app(dictFoldable1).app(n)
                .app(xs);})
      }
    }
  };
}