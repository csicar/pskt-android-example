@file:Suppress("UNCHECKED_CAST")

package PS.Data.List.Lazy.Types
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  sealed class _Type_Step ()  {
    object Nil : _Type_Step() {};
    data class Cons (val value0 : Any,  val value1 : Any) : _Type_Step() {};
  };
  val Nil = _Type_Step.Nil;
  val Cons = { value0 : Any ->
     { value1 : Any ->
       _Type_Step.Cons(value0,  value1)
    }
  };
  @JvmField val List = { x : Any -> x};
  @JvmField val NonEmptyList = { x : Any -> x};
  @JvmField
  val nil = PS.Data.Function.Module.apply
              .app(PS.Data.List.Lazy.Types.Module.List)
              .app(PS.Data.Lazy.Module.defer
                     .app({ v : Any ->
         PS.Data.List.Lazy.Types.Module.Nil
      }));
  @JvmField
  val newtypeNonEmptyList = PS.Data.Newtype.Module.Newtype
                              .app({ n : Any ->
                                  val a = n;
                                    a;})
                              .app(PS.Data.List.Lazy.Types.Module.NonEmptyList);
  @JvmField
  val newtypeList = PS.Data.Newtype.Module.Newtype
                      .app({ n : Any ->
                          val a = n;
                            a;})
                      .app(PS.Data.List.Lazy.Types.Module.List);
  @JvmField
  val step = PS.Control.Semigroupoid.Module.compose
               .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
               .app(PS.Data.Lazy.Module.force)
               .app(PS.Data.Newtype.Module.unwrap
                      .app(PS.Data.List.Lazy.Types.Module.newtypeList));
  @JvmField val semigroupList = (::__rec_semigroupList)();
  fun __rec_semigroupList(): Any = PS.Data.Semigroup.Module.Semigroup
                                     .app({ xs : Any ->
       { ys : Any ->
         object   {
             val go = { v : Any ->
                when {
                 (v is PS.Data.List.Lazy.Types.Module._Type_Step.Nil) -> {
                   PS.Data.List.Lazy.Types.Module.step.app(ys);
                 }
                 (v is PS.Data.List.Lazy.Types.Module._Type_Step.Cons) -> {
                   val x = v.value0;
                   val xs_tick = v.value1;
                   PS.Data.List.Lazy.Types.Module.Cons.app(x)
                     .app(PS.Data.Semigroup.Module.append
                            .app(PS.Data.List.Lazy.Types.Module.semigroupList)
                            .app(xs_tick)
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
    });
  @JvmField
  val showList = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ xs : Any ->
         object   {
             val go = (::__rec_go)();
             fun __rec_go(): Any = { v : Any ->
                when {
                 (v is PS.Data.List.Lazy.Types.Module._Type_Step.Nil) -> {
                   "Nil";
                 }
                 (v is PS.Data.List.Lazy.Types.Module._Type_Step.Cons) -> {
                   val x = v.value0;
                   val xs_tick = v.value1;
                   (("(Cons " as String) + (((PS.Data.Show.Module.show
                                                .app(dictShow)
                                                .app(x
                   ) as String) + (((" " as String) + (((__rec_go()
                                                           .app(
                     PS.Data.List.Lazy.Types.Module.step.app(xs_tick)
                   ) as String) + (")" as String)) as String)) as String)) as String));
                 }
                 else -> (error("Error in Pattern Match") as Any)
               }
             };
           }
           .run({
            val go = this.go;
            (("fromStrict (" as String) + (((go
                                               .app(
              PS.Data.List.Lazy.Types.Module.step.app(xs)
            ) as String) + (")" as String)) as String));
          })
      })
  };
  @JvmField
  val showNonEmptyList = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ v : Any ->
        val nel = v;
          (("(NonEmptyList " as String) + (((PS.Data.Show.Module.show
                                               .app(PS.Data.Lazy.Module.showLazy
                                                      .app(
                                                   PS.Data.NonEmpty.Module.showNonEmpty
                                                     .app(dictShow)
                                                     .app(
                                                     PS.Data.List.Lazy.Types.Module.showList
                                                       .app(dictShow))))
                                               .app(nel
          ) as String) + (")" as String)) as String));})
  };
  @JvmField
  val monoidList = PS.Data.Monoid.Module.Monoid
                     .app({ _ : Any ->
                          PS.Data.List.Lazy.Types.Module.semigroupList
                       })
                     .app(PS.Data.List.Lazy.Types.Module.nil);
  @JvmField
  val lazyList = PS.Control.Lazy.Module.Lazy
                   .app({ f : Any ->
       PS.Data.Function.Module.apply.app(PS.Data.List.Lazy.Types.Module.List)
         .app(PS.Data.Lazy.Module.defer
                .app(PS.Control.Semigroupoid.Module.compose
                       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                       .app(PS.Data.List.Lazy.Types.Module.step)
                       .app(f)))
    });
  @JvmField val functorList = (::__rec_functorList)();
  fun __rec_functorList(): Any = PS.Data.Functor.Module.Functor
                                   .app({ f : Any ->
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
                   PS.Data.List.Lazy.Types.Module.Cons.app(f.app(x))
                     .app(PS.Data.Functor.Module.map
                            .app(PS.Data.List.Lazy.Types.Module.functorList)
                            .app(f)
                            .app(xs_tick));
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
    });
  @JvmField
  val functorNonEmptyList = PS.Data.Functor.Module.Functor
                              .app({ f : Any ->
       { v : Any ->
        val f1 = f;
          val nel = v;
          PS.Data.List.Lazy.Types.Module.NonEmptyList
            .app(PS.Data.Functor.Module.map.app(PS.Data.Lazy.Module.functorLazy)
                   .app(PS.Data.Functor.Module.map
                          .app(PS.Data.NonEmpty.Module.functorNonEmpty
                                 .app(PS.Data.List.Lazy.Types.Module.functorList
                            ))
                          .app(f1))
                   .app(nel));}
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
                    when {
                     (v is PS.Data.List.Lazy.Types.Module._Type_Step
                             .Nil)&&
                     (v1 is PS.Data.List.Lazy.Types.Module._Type_Step
                              .Nil) -> {
                       true;
                     }
                     (v is PS.Data.List.Lazy.Types.Module._Type_Step
                             .Cons)&&
                     (v1 is PS.Data.List.Lazy.Types.Module._Type_Step
                              .Cons)&& (PS.Data.Eq.Module.eq.app(dictEq)
                                          .app(v
                                                 .value0)
                                          .app(v1
                                                 .value0) as Boolean) -> {
                       val x = v.value0;
                       val xs_tick = v.value1;
                       val y = v1.value0;
                       val ys_tick = v1.value1;
                       __rec_go()
                         .app(PS.Data.List.Lazy.Types.Module.step.app(xs_tick))
                         .app(PS.Data.List.Lazy.Types.Module.step.app(ys_tick));
                     }
                     else -> {
                       false;
                     }
                   }
                 }
               };
             }
             .run({
              val go = this.go;
              go.app(PS.Data.List.Lazy.Types.Module.step.app(xs))
                .app(PS.Data.List.Lazy.Types.Module.step.app(ys));
            })
        }
      }
    });
  @JvmField
  val eqList = { dictEq : Any ->
     PS.Data.Eq.Module.Eq
       .app(PS.Data.Eq.Module.eq1.app(PS.Data.List.Lazy.Types.Module.eq1List)
              .app(dictEq))
  };
  @JvmField
  val eqNonEmptyList = { dictEq : Any ->
     PS.Data.Lazy.Module.eqLazy
       .app(PS.Data.NonEmpty.Module.eqNonEmpty
              .app(PS.Data.List.Lazy.Types.Module.eq1List)
              .app(dictEq))
  };
  @JvmField
  val ord1List = PS.Data.Ord.Module.Ord1
                   .app({ _ : Any ->
                        PS.Data.List.Lazy.Types.Module.eq1List
                     })
                   .app({ dictOrd : Any ->
       { xs : Any ->
         { ys : Any ->
           object   {
               val go = (::__rec_go)();
               fun __rec_go(): Any = { v : Any ->
                  { v1 : Any ->
                    when {
                     (v is PS.Data.List.Lazy.Types.Module._Type_Step
                             .Nil)&&
                     (v1 is PS.Data.List.Lazy.Types.Module._Type_Step
                              .Nil) -> {
                       PS.Data.Ordering.Module.EQ;
                     }
                     (v is PS.Data.List.Lazy.Types.Module._Type_Step.Nil) -> {
                       PS.Data.Ordering.Module.LT;
                     }
                     (v1 is PS.Data.List.Lazy.Types.Module._Type_Step.Nil) -> {
                       PS.Data.Ordering.Module.GT;
                     }
                     (v is PS.Data.List.Lazy.Types.Module._Type_Step
                             .Cons)&&
                     (v1 is PS.Data.List.Lazy.Types.Module._Type_Step
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
                               __rec_go()
                                 .app(PS.Data.List.Lazy.Types.Module.step
                                        .app(xs_tick))
                                 .app(PS.Data.List.Lazy.Types.Module.step
                                        .app(ys_tick));
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
              go.app(PS.Data.List.Lazy.Types.Module.step.app(xs))
                .app(PS.Data.List.Lazy.Types.Module.step.app(ys));
            })
        }
      }
    });
  @JvmField
  val ordList = { dictOrd : Any ->
     PS.Data.Ord.Module.Ord
       .app({ _ : Any ->
            PS.Data.List.Lazy.Types.Module.eqList
              .app((dictOrd as Map<String, Any>)["Eq0"]!!.app(Unit))
         })
       .app(PS.Data.Ord.Module.compare1
              .app(PS.Data.List.Lazy.Types.Module.ord1List)
              .app(dictOrd))
  };
  @JvmField
  val ordNonEmptyList = { dictOrd : Any ->
     PS.Data.Lazy.Module.ordLazy
       .app(PS.Data.NonEmpty.Module.ordNonEmpty
              .app(PS.Data.List.Lazy.Types.Module.ord1List)
              .app(dictOrd))
  };
  @JvmField
  val cons = { x : Any ->
     { xs : Any ->
       PS.Data.Function.Module.apply.app(PS.Data.List.Lazy.Types.Module.List)
         .app(PS.Data.Lazy.Module.defer
                .app({ v : Any ->
             PS.Data.List.Lazy.Types.Module.Cons.app(x).app(xs)
          }))
    }
  };
  @JvmField val foldableList = (::__rec_foldableList)();
  fun __rec_foldableList(): Any = PS.Data.Foldable.Module.Foldable
                                    .app({ dictMonoid : Any ->
                                         { f : Any ->
                                           PS.Data.Foldable.Module.foldl
                                             .app(
                                               PS.Data.List.Lazy.Types.Module.foldableList
                                             )
                                             .app({ b : Any ->
                                                  { a : Any ->
                                                    PS.Data.Semigroup.Module.append
                                                      .app(
                                                        (dictMonoid as Map<String, Any>)["Semigroup0"]!!
                                                          .app(Unit))
                                                      .app(b)
                                                      .app(f.app(a))
                                                 }
                                               })
                                             .app(PS.Data.Monoid.Module.mempty
                                                    .app(dictMonoid))
                                        }
                                      })
                                    .app({ op : Any ->
                                         object   {
                                             val go = (::__rec_go)();
                                             fun __rec_go(): Any = { b : Any ->
                                                { xs : Any ->
                                                  object   {
                                                      val v = PS.Data.List.Lazy.Types.Module.step
                                                                .app(xs);
                                                    }
                                                    .run({
                                                     val v = this.v;
                                                     when {
                                                       (v is PS.Data.List.Lazy.Types.Module._Type_Step
                                                               .Nil) -> {
                                                         b;
                                                       }
                                                       (v is PS.Data.List.Lazy.Types.Module._Type_Step
                                                               .Cons) -> {
                                                         val hd = v.value0;
                                                         val tl = v.value1;
                                                         __rec_go()
                                                           .app(op.app(b)
                                                                  .app(hd))
                                                           .app(tl);
                                                       }
                                                       else -> (error(
                                                         "Error in Pattern Match"
                                                       ) as Any)
                                                     };
                                                   })
                                               }
                                             };
                                           }
                                           .run({
                                            val go = this.go;
                                            go;
                                          })
                                      })
                                    .app({ op : Any ->
       { z : Any ->
         { xs : Any ->
           object   {
               val rev = PS.Data.Foldable.Module.foldl
                           .app(PS.Data.List.Lazy.Types.Module.foldableList)
                           .app(PS.Data.Function.Module.flip
                                  .app(PS.Data.List.Lazy.Types.Module.cons))
                           .app(PS.Data.List.Lazy.Types.Module.nil);
             }
             .run({
              val rev = this.rev;
              PS.Data.Foldable.Module.foldl
                .app(PS.Data.List.Lazy.Types.Module.foldableList)
                .app(PS.Data.Function.Module.flip.app(op))
                .app(z)
                .app(rev.app(xs));
            })
        }
      }
    });
  @JvmField
  val extendList = PS.Control.Extend.Module.Extend
                     .app({ _ : Any ->
                          PS.Data.List.Lazy.Types.Module.functorList
                       })
                     .app({ f : Any ->
       { l : Any ->
         object   {
             val go = { a : Any ->
                { v : Any ->
                  when {
                   ((v as Map<String, Any>).size == 2) -> {
                     val a1 = a;
                     val _val = v["val"]!!;
                     val acc = v["acc"]!!;
                     object   {
                         val acc_tick = PS.Data.List.Lazy.Types.Module.cons
                                          .app(a1)
                                          .app(acc);
                       }
                       .run({
                         val acc_tick = this.acc_tick;
                         mapOf(("val" to PS.Data.List.Lazy.Types.Module.cons
                                           .app(f.app(acc_tick))
                                           .app(_val)),  ("acc" to acc_tick));
                       });
                   }
                   else -> (error("Error in Pattern Match") as Any)
                 }
               }
             };
           }
           .run({
            val go = this.go;
            object   {
                val v = PS.Data.List.Lazy.Types.Module.step.app(l);
              }
              .run({
                val v = this.v;
                when {
                  (v is PS.Data.List.Lazy.Types.Module._Type_Step.Nil) -> {
                    PS.Data.List.Lazy.Types.Module.nil;
                  }
                  (v is PS.Data.List.Lazy.Types.Module._Type_Step.Cons) -> {
                    val a = v.value0;
                    val _as = v.value1;
                    PS.Data.List.Lazy.Types.Module.cons.app(f.app(l))
                      .app((PS.Data.Foldable.Module.foldr
                              .app(PS.Data.List.Lazy.Types.Module.foldableList)
                              .app(go)
                              .app(mapOf(
                                  ("val" to PS.Data.List.Lazy.Types.Module.nil), 
                                  ("acc" to PS.Data.List.Lazy.Types.Module.nil))
                              )
                              .app(_as) as Map<String, Any>)["val"]!!);
                  }
                  else -> (error("Error in Pattern Match") as Any)
                };
              });
          })
      }
    });
  @JvmField
  val extendNonEmptyList = PS.Control.Extend.Module.Extend
                             .app({ _ : Any ->
                                  PS.Data.List.Lazy.Types.Module.functorNonEmptyList
                               })
                             .app({ f : Any ->
       { v : Any ->
        val f1 = f;
          val w = v;
          val nel = v;
          object   {
              val go = { a : Any ->
                 { v1 : Any ->
                   when {
                    ((v1 as Map<String, Any>).size == 2) -> {
                      val a1 = a;
                      val _val = v1["val"]!!;
                      val acc = v1["acc"]!!;
                      mapOf(("val" to PS.Data.List.Lazy.Types.Module.cons
                                        .app(f1
                                               .app(
                                            PS.Data.List.Lazy.Types.Module.NonEmptyList
                                              .app(PS.Data.Lazy.Module.defer
                                                     .app({ v2 : Any ->
                                                   PS.Data.NonEmpty.Module.NonEmpty
                                                     .app(a1)
                                                     .app(acc)
                                                }))))
                                        .app(_val)),  
                        ("acc" to PS.Data.List.Lazy.Types.Module.cons.app(a1)
                                    .app(acc)));
                    }
                    else -> (error("Error in Pattern Match") as Any)
                  }
                }
              };
            }
            .run({
              val go = this.go;
              object   {
                  val v1 = PS.Data.Lazy.Module.force.app(nel);
                }
                .run({
                  val v1 = this.v1;
                  when {
                    (v1 is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
                      val _as = v1.value1;
                      PS.Data.Function.Module.apply
                        .app(PS.Data.List.Lazy.Types.Module.NonEmptyList)
                        .app(PS.Data.Lazy.Module.defer
                               .app({ v2 : Any ->
                             PS.Data.NonEmpty.Module.NonEmpty.app(f1.app(w))
                               .app((PS.Data.Foldable.Module.foldr
                                       .app(
                                         PS.Data.List.Lazy.Types.Module.foldableList
                                       )
                                       .app(go)
                                       .app(mapOf(
                                           ("val" to PS.Data.List.Lazy.Types.Module.nil), 
                                           
                                           ("acc" to PS.Data.List.Lazy.Types.Module.nil)
                                         ))
                                       .app(_as) as Map<String, Any>)["val"]!!)
                          }));
                    }
                    else -> (error("Error in Pattern Match") as Any)
                  };
                });
            });}
    });
  @JvmField
  val foldableNonEmptyList = PS.Data.Foldable.Module.Foldable
                               .app({ dictMonoid : Any ->
                                    { f : Any ->
                                      { v : Any ->
                                       val f1 = f;
                                         val nel = v;
                                         PS.Data.Foldable.Module.foldMap
                                           .app(
                                             PS.Data.NonEmpty.Module.foldableNonEmpty
                                               .app(
                                               PS.Data.List.Lazy.Types.Module.foldableList
                                             ))
                                           .app(dictMonoid)
                                           .app(f1)
                                           .app(PS.Data.Lazy.Module.force
                                                  .app(nel));}
                                   }
                                 })
                               .app({ f : Any ->
                                    { b : Any ->
                                      { v : Any ->
                                       val f1 = f;
                                         val b1 = b;
                                         val nel = v;
                                         PS.Data.Foldable.Module.foldl
                                           .app(
                                             PS.Data.NonEmpty.Module.foldableNonEmpty
                                               .app(
                                               PS.Data.List.Lazy.Types.Module.foldableList
                                             ))
                                           .app(f1)
                                           .app(b1)
                                           .app(PS.Data.Lazy.Module.force
                                                  .app(nel));}
                                   }
                                 })
                               .app({ f : Any ->
       { b : Any ->
         { v : Any ->
          val f1 = f;
            val b1 = b;
            val nel = v;
            PS.Data.Foldable.Module.foldr
              .app(PS.Data.NonEmpty.Module.foldableNonEmpty
                     .app(PS.Data.List.Lazy.Types.Module.foldableList))
              .app(f1)
              .app(b1)
              .app(PS.Data.Lazy.Module.force.app(nel));}
      }
    });
  @JvmField val foldableWithIndexList = (::__rec_foldableWithIndexList)();
  fun __rec_foldableWithIndexList(): Any = PS.Data.FoldableWithIndex.Module.FoldableWithIndex
                                             .app({ _ : Any ->
                                                  PS.Data.List.Lazy.Types.Module.foldableList
                                               })
                                             .app({ dictMonoid : Any ->
                                                  { f : Any ->
                                                    PS.Data.FoldableWithIndex.Module.foldlWithIndex
                                                      .app(
                                                        PS.Data.List.Lazy.Types.Module.foldableWithIndexList
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
                                                         PS.Data.List.Lazy.Types.Module.foldableList
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
                                         PS.Data.List.Lazy.Types.Module.foldableList
                                       )
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
                                        .app(PS.Data.List.Lazy.Types.Module.cons
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
                            .app(PS.Data.List.Lazy.Types.Module.nil))
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
                           .app(PS.Data.List.Lazy.Types.Module.foldableList)
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
                                             PS.Data.List.Lazy.Types.Module.foldableNonEmptyList
                                          })
                                        .app({ dictMonoid : Any ->
                                             { f : Any ->
                                               { v : Any ->
                                                val f1 = f;
                                                  val ne = v;
                                                  PS.Data.Function.Module.apply
                                                    .app(
                                                      PS.Data.FoldableWithIndex.Module.foldMapWithIndex
                                                        .app(
                                                          PS.Data.NonEmpty.Module.foldableWithIndexNonEmpty
                                                            .app(
                                                            PS.Data.List.Lazy.Types.Module.foldableWithIndexList
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
                                                              .app(1)))))
                                                    .app(
                                                    PS.Data.Lazy.Module.force
                                                      .app(ne));}
                                            }
                                          })
                                        .app({ f : Any ->
                                             { b : Any ->
                                               { v : Any ->
                                                val f1 = f;
                                                  val b1 = b;
                                                  val ne = v;
                                                  PS.Data.Function.Module.apply
                                                    .app(
                                                      PS.Data.FoldableWithIndex.Module.foldlWithIndex
                                                        .app(
                                                          PS.Data.NonEmpty.Module.foldableWithIndexNonEmpty
                                                            .app(
                                                            PS.Data.List.Lazy.Types.Module.foldableWithIndexList
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
                                                        .app(b1))
                                                    .app(
                                                    PS.Data.Lazy.Module.force
                                                      .app(ne));}
                                            }
                                          })
                                        .app({ f : Any ->
       { b : Any ->
         { v : Any ->
          val f1 = f;
            val b1 = b;
            val ne = v;
            PS.Data.Function.Module.apply
              .app(PS.Data.FoldableWithIndex.Module.foldrWithIndex
                     .app(PS.Data.NonEmpty.Module.foldableWithIndexNonEmpty
                            .app(
                         PS.Data.List.Lazy.Types.Module.foldableWithIndexList))
                     .app(PS.Control.Semigroupoid.Module.compose
                            .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                            .app(f1)
                            .app(PS.Data.Maybe.Module.maybe.app(0)
                                   .app(PS.Data.Semiring.Module.add
                                          .app(
                                            PS.Data.Semiring.Module.semiringInt)
                                          .app(1))))
                     .app(b1))
              .app(PS.Data.Lazy.Module.force.app(ne));}
      }
    });
  @JvmField
  val functorWithIndexList = PS.Data.FunctorWithIndex.Module.FunctorWithIndex
                               .app({ _ : Any ->
                                    PS.Data.List.Lazy.Types.Module.functorList
                                 })
                               .app({ f : Any ->
       PS.Data.FoldableWithIndex.Module.foldrWithIndex
         .app(PS.Data.List.Lazy.Types.Module.foldableWithIndexList)
         .app({ i : Any ->
              { x : Any ->
                { acc : Any ->
                  PS.Data.List.Lazy.Types.Module.cons.app(f.app(i).app(x))
                    .app(acc)
               }
             }
           })
         .app(PS.Data.List.Lazy.Types.Module.nil)
    });
  @JvmField
  val functorWithIndexNonEmptyList = PS.Data.FunctorWithIndex.Module.FunctorWithIndex
                                       .app({ _ : Any ->
                                            PS.Data.List.Lazy.Types.Module.functorNonEmptyList
                                         })
                                       .app({ f : Any ->
       { v : Any ->
        val f1 = f;
          val ne = v;
          PS.Data.Function.Module.apply
            .app(PS.Data.List.Lazy.Types.Module.NonEmptyList)
            .app(PS.Data.Lazy.Module.defer
                   .app({ v1 : Any ->
                 PS.Data.Function.Module.apply
                   .app(PS.Data.FunctorWithIndex.Module.mapWithIndex
                          .app(PS.Data.NonEmpty.Module.functorWithIndex
                                 .app(
                              PS.Data.List.Lazy.Types.Module.functorWithIndexList
                            ))
                          .app(PS.Control.Semigroupoid.Module.compose
                                 .app(
                                   PS.Control.Semigroupoid.Module.semigroupoidFn
                                 )
                                 .app(f1)
                                 .app(PS.Data.Maybe.Module.maybe.app(0)
                                        .app(PS.Data.Semiring.Module.add
                                               .app(
                                                 PS.Data.Semiring.Module.semiringInt
                                               )
                                               .app(1)))))
                   .app(PS.Data.Lazy.Module.force.app(ne))
              }));}
    });
  @JvmField
  val toList = { v : Any ->
    val nel = v;
      PS.Control.Lazy.Module.defer.app(PS.Data.List.Lazy.Types.Module.lazyList)
        .app({ v1 : Any ->
           object   {
               val v2 = PS.Data.Lazy.Module.force.app(nel);
             }
             .run({
              val v2 = this.v2;
              when {
                (v2 is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
                  val x = v2.value0;
                  val xs = v2.value1;
                  PS.Data.List.Lazy.Types.Module.cons.app(x).app(xs);
                }
                else -> (error("Error in Pattern Match") as Any)
              };
            })
        });};
  @JvmField
  val semigroupNonEmptyList = PS.Data.Semigroup.Module.Semigroup
                                .app({ v : Any ->
       { as_tick : Any ->
        val neas = v;
          val as_tick1 = as_tick;
          object   {
              val v1 = PS.Data.Lazy.Module.force.app(neas);
            }
            .run({
              val v1 = this.v1;
              when {
                (v1 is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
                  val a = v1.value0;
                  val _as = v1.value1;
                  PS.Data.List.Lazy.Types.Module.NonEmptyList
                    .app(PS.Data.Lazy.Module.defer
                           .app({ v2 : Any ->
                         PS.Data.NonEmpty.Module.NonEmpty.app(a)
                           .app(PS.Data.Semigroup.Module.append
                                  .app(
                                    PS.Data.List.Lazy.Types.Module.semigroupList
                                  )
                                  .app(_as)
                                  .app(PS.Data.List.Lazy.Types.Module.toList
                                         .app(as_tick1)))
                      }));
                }
                else -> (error("Error in Pattern Match") as Any)
              };
            });}
    });
  @JvmField val traversableList = (::__rec_traversableList)();
  fun __rec_traversableList(): Any = PS.Data.Traversable.Module.Traversable
                                       .app({ _ : Any ->
                                            PS.Data.List.Lazy.Types.Module.foldableList
                                         })
                                       .app({ _ : Any ->
                                            PS.Data.List.Lazy.Types.Module.functorList
                                         })
                                       .app({ dictApplicative : Any ->
                                            PS.Data.Traversable.Module.traverse
                                              .app(
                                                PS.Data.List.Lazy.Types.Module.traversableList
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
         PS.Data.Foldable.Module.foldr
           .app(PS.Data.List.Lazy.Types.Module.foldableList)
           .app({ a : Any ->
                { b : Any ->
                  PS.Control.Apply.Module.apply
                    .app((dictApplicative as Map<String, Any>)["Apply0"]!!
                           .app(Unit))
                    .app(PS.Data.Functor.Module.map
                           .app(
                             ((dictApplicative as Map<String, Any>)["Apply0"]!!
                                .app(Unit) as Map<String, Any>)["Functor0"]!!
                               .app(Unit))
                           .app(PS.Data.List.Lazy.Types.Module.cons)
                           .app(f.app(a)))
                    .app(b)
               }
             })
           .app(PS.Control.Applicative.Module.pure.app(dictApplicative)
                  .app(PS.Data.List.Lazy.Types.Module.nil))
      }
    });
  @JvmField
  val traversableNonEmptyList = PS.Data.Traversable.Module.Traversable
                                  .app({ _ : Any ->
                                       PS.Data.List.Lazy.Types.Module.foldableNonEmptyList
                                    })
                                  .app({ _ : Any ->
                                       PS.Data.List.Lazy.Types.Module.functorNonEmptyList
                                    })
                                  .app({ dictApplicative : Any ->
                                       { v : Any ->
                                        val nel = v;
                                          PS.Data.Function.Module.apply
                                            .app(PS.Data.Functor.Module.map
                                                   .app(
                                                     ((dictApplicative as Map<String, Any>)["Apply0"]!!
                                                        .app(Unit
                                                       ) as Map<String, Any>)["Functor0"]!!
                                                       .app(Unit))
                                                   .app({ xxs : Any ->
                                                   PS.Data.Function.Module.apply
                                                     .app(
                                                       PS.Data.List.Lazy.Types.Module.NonEmptyList
                                                     )
                                                     .app(
                                                    PS.Data.Lazy.Module.defer
                                                      .app({ v1 : Any ->
                                                         xxs
                                                      }))
                                                }))
                                            .app(
                                            PS.Data.Traversable.Module.sequence
                                              .app(
                                                PS.Data.NonEmpty.Module.traversableNonEmpty
                                                  .app(
                                                  PS.Data.List.Lazy.Types.Module.traversableList
                                                ))
                                              .app(dictApplicative)
                                              .app(PS.Data.Lazy.Module.force
                                                     .app(nel)));}
                                    })
                                  .app({ dictApplicative : Any ->
       { f : Any ->
         { v : Any ->
          val f1 = f;
            val nel = v;
            PS.Data.Function.Module.apply
              .app(PS.Data.Functor.Module.map
                     .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                             .app(Unit) as Map<String, Any>)["Functor0"]!!
                            .app(Unit))
                     .app({ xxs : Any ->
                     PS.Data.Function.Module.apply
                       .app(PS.Data.List.Lazy.Types.Module.NonEmptyList)
                       .app(PS.Data.Lazy.Module.defer.app({ v1 : Any -> xxs}))
                  }))
              .app(PS.Data.Traversable.Module.traverse
                     .app(PS.Data.NonEmpty.Module.traversableNonEmpty
                            .app(PS.Data.List.Lazy.Types.Module.traversableList)
                     )
                     .app(dictApplicative)
                     .app(f1)
                     .app(PS.Data.Lazy.Module.force.app(nel)));}
      }
    });
  @JvmField
  val traversableWithIndexList = PS.Data.TraversableWithIndex.Module.TraversableWithIndex
                                   .app({ _ : Any ->
                                        PS.Data.List.Lazy.Types.Module.foldableWithIndexList
                                     })
                                   .app({ _ : Any ->
                                        PS.Data.List.Lazy.Types.Module.functorWithIndexList
                                     })
                                   .app({ _ : Any ->
                                        PS.Data.List.Lazy.Types.Module.traversableList
                                     })
                                   .app({ dictApplicative : Any ->
       { f : Any ->
         PS.Data.FoldableWithIndex.Module.foldrWithIndex
           .app(PS.Data.List.Lazy.Types.Module.foldableWithIndexList)
           .app({ i : Any ->
                { a : Any ->
                  { b : Any ->
                    PS.Control.Apply.Module.apply
                      .app((dictApplicative as Map<String, Any>)["Apply0"]!!
                             .app(Unit))
                      .app(PS.Data.Functor.Module.map
                             .app(
                               ((dictApplicative as Map<String, Any>)["Apply0"]!!
                                  .app(Unit) as Map<String, Any>)["Functor0"]!!
                                 .app(Unit))
                             .app(PS.Data.List.Lazy.Types.Module.cons)
                             .app(f.app(i).app(a)))
                      .app(b)
                 }
               }
             })
           .app(PS.Control.Applicative.Module.pure.app(dictApplicative)
                  .app(PS.Data.List.Lazy.Types.Module.nil))
      }
    });
  @JvmField
  val traversableWithIndexNonEmptyList = PS.Data.TraversableWithIndex.Module.TraversableWithIndex
                                           .app({ _ : Any ->
                                                PS.Data.List.Lazy.Types.Module.foldableWithIndexNonEmptyList
                                             })
                                           .app({ _ : Any ->
                                                PS.Data.List.Lazy.Types.Module.functorWithIndexNonEmptyList
                                             })
                                           .app({ _ : Any ->
                                                PS.Data.List.Lazy.Types.Module.traversableNonEmptyList
                                             })
                                           .app({ dictApplicative : Any ->
       { f : Any ->
         { v : Any ->
          val f1 = f;
            val ne = v;
            PS.Data.Function.Module.apply
              .app(PS.Data.Functor.Module.map
                     .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                             .app(Unit) as Map<String, Any>)["Functor0"]!!
                            .app(Unit))
                     .app({ xxs : Any ->
                     PS.Data.Function.Module.apply
                       .app(PS.Data.List.Lazy.Types.Module.NonEmptyList)
                       .app(PS.Data.Lazy.Module.defer.app({ v1 : Any -> xxs}))
                  }))
              .app(PS.Data.Function.Module.apply
                     .app(PS.Data.TraversableWithIndex.Module.traverseWithIndex
                            .app(
                              PS.Data.NonEmpty.Module.traversableWithIndexNonEmpty
                                .app(
                                PS.Data.List.Lazy.Types.Module.traversableWithIndexList
                              ))
                            .app(dictApplicative)
                            .app(PS.Control.Semigroupoid.Module.compose
                                   .app(
                                     PS.Control.Semigroupoid.Module.semigroupoidFn
                                   )
                                   .app(f1)
                                   .app(PS.Data.Maybe.Module.maybe.app(0)
                                          .app(PS.Data.Semiring.Module.add
                                                 .app(
                                                   PS.Data.Semiring.Module.semiringInt
                                                 )
                                                 .app(1)))))
                     .app(PS.Data.Lazy.Module.force.app(ne)));}
      }
    });
  @JvmField
  val unfoldable1List = PS.Data.Unfoldable1.Module.Unfoldable1
                          .app(object   {
                                   val go = (::__rec_go)();
                                   fun __rec_go(): Any = { f : Any ->
                                      { b : Any ->
                                        PS.Control.Lazy.Module.defer
                                          .app(
                                            PS.Data.List.Lazy.Types.Module.lazyList
                                          )
                                          .app({ v : Any ->
                                            object   {
                                                val v1 = f.app(b);
                                              }
                                              .run({
                                               val v1 = this.v1;
                                               when {
                                                 (v1 is PS.Data.Tuple.Module._Type_Tuple
                                                          .Tuple)&& (v1
                                                                       .value1 is PS.Data.Maybe.Module._Type_Maybe
                                                                                    .Just) -> {
                                                   val a = v1.value0;
                                                   val b_tick = v1
                                                                  .value1
                                                                  .value0;
                                                   PS.Data.List.Lazy.Types.Module.cons
                                                     .app(a)
                                                     .app(__rec_go().app(f)
                                                            .app(b_tick));
                                                 }
                                                 (v1 is PS.Data.Tuple.Module._Type_Tuple
                                                          .Tuple)&& (v1
                                                                       .value1 is PS.Data.Maybe.Module._Type_Maybe
                                                                                    .Nothing) -> {
                                                   val a = v1.value0;
                                                   PS.Data.List.Lazy.Types.Module.cons
                                                     .app(a)
                                                     .app(
                                                     PS.Data.List.Lazy.Types.Module.nil
                                                   );
                                                 }
                                                 else -> (error(
                                                   "Error in Pattern Match"
                                                 ) as Any)
                                               };
                                             })
                                         })
                                     }
                                   };
                                 }
                                 .run({
        val go = this.go;
        go;
      }));
  @JvmField
  val unfoldableList = PS.Data.Unfoldable.Module.Unfoldable
                         .app({ _ : Any ->
                              PS.Data.List.Lazy.Types.Module.unfoldable1List
                           })
                         .app(object   {
                                  val go = (::__rec_go)();
                                  fun __rec_go(): Any = { f : Any ->
                                     { b : Any ->
                                       PS.Control.Lazy.Module.defer
                                         .app(
                                           PS.Data.List.Lazy.Types.Module.lazyList
                                         )
                                         .app({ v : Any ->
                                           object   {
                                               val v1 = f.app(b);
                                             }
                                             .run({
                                              val v1 = this.v1;
                                              when {
                                                (v1 is PS.Data.Maybe.Module._Type_Maybe
                                                         .Nothing) -> {
                                                  PS.Data.List.Lazy.Types.Module.nil;
                                                }
                                                (v1 is PS.Data.Maybe.Module._Type_Maybe
                                                         .Just)&& (v1
                                                                     .value0 is PS.Data.Tuple.Module._Type_Tuple
                                                                                  .Tuple) -> {
                                                  val a = v1.value0.value0;
                                                  val b_tick = v1.value0.value1;
                                                  PS.Data.List.Lazy.Types.Module.cons
                                                    .app(a)
                                                    .app(__rec_go().app(f)
                                                           .app(b_tick));
                                                }
                                                else -> (error(
                                                  "Error in Pattern Match"
                                                ) as Any)
                                              };
                                            })
                                        })
                                    }
                                  };
                                }
                                .run({
        val go = this.go;
        go;
      }));
  @JvmField
  val unfoldable1NonEmptyList = PS.Data.Unfoldable1.Module.Unfoldable1
                                  .app({ f : Any ->
       { b : Any ->
         PS.Data.Function.Module.apply
           .app(PS.Data.List.Lazy.Types.Module.NonEmptyList)
           .app(PS.Data.Lazy.Module.defer
                  .app({ v : Any ->
               PS.Data.Unfoldable1.Module.unfoldr1
                 .app(PS.Data.NonEmpty.Module.unfoldable1NonEmpty
                        .app(PS.Data.List.Lazy.Types.Module.unfoldableList))
                 .app(f)
                 .app(b)
            }))
      }
    });
  @JvmField
  val comonadNonEmptyList = PS.Control.Comonad.Module.Comonad
                              .app({ _ : Any ->
                                   PS.Data.List.Lazy.Types.Module.extendNonEmptyList
                                })
                              .app({ v : Any ->
      val nel = v;
        PS.Data.Function.Module.apply.app(PS.Data.NonEmpty.Module.head)
          .app(PS.Data.Lazy.Module.force.app(nel));});
  @JvmField val monadList = (::__rec_monadList)();
  @JvmField val bindList = (::__rec_bindList)();
  @JvmField val applyList = (::__rec_applyList)();
  @JvmField val applicativeList = (::__rec_applicativeList)();
  fun __rec_monadList(): Any = PS.Control.Monad.Module.Monad
                                 .app({ _ : Any ->
                                      PS.Data.List.Lazy.Types.Module.applicativeList
                                   })
                                 .app({ _ : Any ->
       PS.Data.List.Lazy.Types.Module.bindList
    });
  fun __rec_bindList(): Any = PS.Control.Bind.Module.Bind
                                .app({ _ : Any ->
                                     PS.Data.List.Lazy.Types.Module.applyList
                                  })
                                .app({ xs : Any ->
       { f : Any ->
         object   {
             val go = { v : Any ->
                when {
                 (v is PS.Data.List.Lazy.Types.Module._Type_Step.Nil) -> {
                   PS.Data.List.Lazy.Types.Module.Nil;
                 }
                 (v is PS.Data.List.Lazy.Types.Module._Type_Step.Cons) -> {
                   val x = v.value0;
                   val xs_tick = v.value1;
                   PS.Data.List.Lazy.Types.Module.step
                     .app(PS.Data.Semigroup.Module.append
                            .app(PS.Data.List.Lazy.Types.Module.semigroupList)
                            .app(f.app(x))
                            .app(PS.Control.Bind.Module.bind
                                   .app(PS.Data.List.Lazy.Types.Module.bindList)
                                   .app(xs_tick)
                                   .app(f)));
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
    });
  fun __rec_applyList(): Any = PS.Control.Apply.Module.Apply
                                 .app({ _ : Any ->
                                      PS.Data.List.Lazy.Types.Module.functorList
                                   })
                                 .app(PS.Control.Monad.Module.ap
                                        .app(
      PS.Data.List.Lazy.Types.Module.monadList));
  fun __rec_applicativeList(): Any = PS.Control.Applicative.Module.Applicative
                                       .app({ _ : Any ->
                                            PS.Data.List.Lazy.Types.Module.applyList
                                         })
                                       .app({ a : Any ->
       PS.Data.List.Lazy.Types.Module.cons.app(a)
         .app(PS.Data.List.Lazy.Types.Module.nil)
    });
  @JvmField
  val applyNonEmptyList = PS.Control.Apply.Module.Apply
                            .app({ _ : Any ->
                                 PS.Data.List.Lazy.Types.Module.functorNonEmptyList
                              })
                            .app({ v : Any ->
       { v1 : Any ->
        val nefs = v;
          val neas = v1;
          object   {
              val v2 = PS.Data.Lazy.Module.force.app(neas);
              val v3 = PS.Data.Lazy.Module.force.app(nefs);
            }
            .run({
              val v2 = this.v2;
              val v3 = this.v3;
              when {
                (v3 is PS.Data.NonEmpty.Module._Type_NonEmpty
                         .NonEmpty)&&
                (v2 is PS.Data.NonEmpty.Module._Type_NonEmpty
                         .NonEmpty) -> {
                  val f = v3.value0;
                  val fs = v3.value1;
                  val a = v2.value0;
                  val _as = v2.value1;
                  PS.Data.List.Lazy.Types.Module.NonEmptyList
                    .app(PS.Data.Lazy.Module.defer
                           .app({ v4 : Any ->
                         PS.Data.NonEmpty.Module.NonEmpty.app(f.app(a))
                           .app(PS.Data.Semigroup.Module.append
                                  .app(
                                    PS.Data.List.Lazy.Types.Module.semigroupList
                                  )
                                  .app(PS.Control.Apply.Module.apply
                                         .app(
                                           PS.Data.List.Lazy.Types.Module.applyList
                                         )
                                         .app(fs)
                                         .app(
                                      PS.Data.List.Lazy.Types.Module.cons.app(a)
                                        .app(PS.Data.List.Lazy.Types.Module.nil)
                                    ))
                                  .app(PS.Control.Apply.Module.apply
                                         .app(
                                           PS.Data.List.Lazy.Types.Module.applyList
                                         )
                                         .app(
                                           PS.Data.List.Lazy.Types.Module.cons
                                             .app(f)
                                             .app(fs))
                                         .app(_as)))
                      }));
                }
                else -> (error("Error in Pattern Match") as Any)
              };
            });}
    });
  @JvmField
  val bindNonEmptyList = PS.Control.Bind.Module.Bind
                           .app({ _ : Any ->
                                PS.Data.List.Lazy.Types.Module.applyNonEmptyList
                             })
                           .app({ v : Any ->
       { f : Any ->
        val nel = v;
          val f1 = f;
          object   {
              val v1 = PS.Data.Lazy.Module.force.app(nel);
            }
            .run({
              val v1 = this.v1;
              when {
                (v1 is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
                  val a = v1.value0;
                  val _as = v1.value1;
                  object   {
                      val v2 = PS.Data.Function.Module.apply
                                 .app(PS.Data.Lazy.Module.force)
                                 .app(PS.Data.Function.Module.apply
                                        .app(PS.Data.Newtype.Module.unwrap
                                               .app(
                                            PS.Data.List.Lazy.Types.Module.newtypeNonEmptyList
                                          ))
                                        .app(f1.app(a)));
                    }
                    .run({
                      val v2 = this.v2;
                      when {
                        (v2 is PS.Data.NonEmpty.Module._Type_NonEmpty
                                 .NonEmpty) -> {
                          val b = v2.value0;
                          val bs = v2.value1;
                          PS.Data.List.Lazy.Types.Module.NonEmptyList
                            .app(PS.Data.Lazy.Module.defer
                                   .app({ v3 : Any ->
                                 PS.Data.NonEmpty.Module.NonEmpty.app(b)
                                   .app(PS.Data.Semigroup.Module.append
                                          .app(
                                            PS.Data.List.Lazy.Types.Module.semigroupList
                                          )
                                          .app(bs)
                                          .app(PS.Control.Bind.Module.bind
                                                 .app(
                                                   PS.Data.List.Lazy.Types.Module.bindList
                                                 )
                                                 .app(_as)
                                                 .app(
                                      PS.Control.Semigroupoid.Module.compose
                                        .app(
                                          PS.Control.Semigroupoid.Module.semigroupoidFn
                                        )
                                        .app(
                                          PS.Data.List.Lazy.Types.Module.toList)
                                        .app(f1))))
                              }));
                        }
                        else -> (error("Error in Pattern Match") as Any)
                      };
                    });
                }
                else -> (error("Error in Pattern Match") as Any)
              };
            });}
    });
  @JvmField
  val altNonEmptyList = PS.Control.Alt.Module.Alt
                          .app({ _ : Any ->
                               PS.Data.List.Lazy.Types.Module.functorNonEmptyList
                            })
                          .app(PS.Data.Semigroup.Module.append
                                 .app(
      PS.Data.List.Lazy.Types.Module.semigroupNonEmptyList));
  @JvmField
  val altList = PS.Control.Alt.Module.Alt
                  .app({ _ : Any ->
                       PS.Data.List.Lazy.Types.Module.functorList
                    })
                  .app(PS.Data.Semigroup.Module.append
                         .app(PS.Data.List.Lazy.Types.Module.semigroupList));
  @JvmField
  val plusList = PS.Control.Plus.Module.Plus
                   .app({ _ : Any ->
                        PS.Data.List.Lazy.Types.Module.altList
                     })
                   .app(PS.Data.List.Lazy.Types.Module.nil);
  @JvmField
  val alternativeList = PS.Control.Alternative.Module.Alternative
                          .app({ _ : Any ->
                               PS.Data.List.Lazy.Types.Module.applicativeList
                            })
                          .app({ _ : Any ->
       PS.Data.List.Lazy.Types.Module.plusList
    });
  @JvmField
  val monadZeroList = PS.Control.MonadZero.Module.MonadZero
                        .app({ _ : Any ->
                             PS.Data.List.Lazy.Types.Module.alternativeList
                          })
                        .app({ _ : Any ->
       PS.Data.List.Lazy.Types.Module.monadList
    });
  @JvmField
  val monadPlusList = PS.Control.MonadPlus.Module.MonadPlus
                        .app({ _ : Any ->
       PS.Data.List.Lazy.Types.Module.monadZeroList
    });
  @JvmField
  val applicativeNonEmptyList = PS.Control.Applicative.Module.Applicative
                                  .app({ _ : Any ->
                                       PS.Data.List.Lazy.Types.Module.applyNonEmptyList
                                    })
                                  .app({ a : Any ->
       PS.Data.List.Lazy.Types.Module.NonEmptyList
         .app(PS.Data.Lazy.Module.defer
                .app({ v : Any ->
             PS.Data.NonEmpty.Module.singleton
               .app(PS.Data.List.Lazy.Types.Module.plusList)
               .app(a)
          }))
    });
  @JvmField
  val monadNonEmptyList = PS.Control.Monad.Module.Monad
                            .app({ _ : Any ->
                                 PS.Data.List.Lazy.Types.Module.applicativeNonEmptyList
                              })
                            .app({ _ : Any ->
       PS.Data.List.Lazy.Types.Module.bindNonEmptyList
    });
}