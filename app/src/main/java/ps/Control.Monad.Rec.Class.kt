@file:Suppress("UNCHECKED_CAST")
package PS.Control.Monad.Rec.Class
import Foreign.PsRuntime.app
object Module  {
  sealed class _Type_Step ()  {
    data class Loop (val value0 : Any) : _Type_Step() {};
    data class Done (val value0 : Any) : _Type_Step() {};
  };
  val Loop = { value0 : Any -> _Type_Step.Loop(value0)};
  val Done = { value0 : Any -> _Type_Step.Done(value0)};
  @JvmField
  val MonadRec = { Monad0 : Any ->
     { tailRecM : Any ->
       mapOf(("Monad0" to Monad0),  ("tailRecM" to tailRecM))
    }
  };
  @JvmField
  val tailRecM = { dict : Any ->
     (dict as Map<String, Any>)["tailRecM"]!!
  };
  @JvmField
  val tailRecM2 = { dictMonadRec : Any ->
     { f : Any ->
       { a : Any ->
         { b : Any ->
           PS.Control.Monad.Rec.Class.Module.tailRecM.app(dictMonadRec)
             .app({ o : Any ->
                  f.app((o as Map<String, Any>)["a"]!!)
                    .app((o as Map<String, Any>)["b"]!!)
               })
             .app(mapOf(("a" to a),  ("b" to b)))
        }
      }
    }
  };
  @JvmField
  val tailRecM3 = { dictMonadRec : Any ->
     { f : Any ->
       { a : Any ->
         { b : Any ->
           { c : Any ->
             PS.Control.Monad.Rec.Class.Module.tailRecM.app(dictMonadRec)
               .app({ o : Any ->
                    f.app((o as Map<String, Any>)["a"]!!)
                      .app((o as Map<String, Any>)["b"]!!)
                      .app((o as Map<String, Any>)["c"]!!)
                 })
               .app(mapOf(("a" to a),  ("b" to b),  ("c" to c)))
          }
        }
      }
    }
  };
  @JvmField
  val tailRec = { f : Any ->
     object   {
         val go = (::__rec_go)();
         fun __rec_go(): Any = { v : Any ->
            when {
             (v is PS.Control.Monad.Rec.Class.Module._Type_Step.Loop) -> {
               val a = v.value0;
               __rec_go().app(f.app(a));
             }
             (v is PS.Control.Monad.Rec.Class.Module._Type_Step.Done) -> {
               val b = v.value0;
               b;
             }
             else -> (error("Error in Pattern Match") as Any)
           }
         };
       }
       .run({
        val go = this.go;
        PS.Control.Semigroupoid.Module.compose
          .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
          .app(go)
          .app(f);
      })
  };
  @JvmField
  val monadRecMaybe = PS.Control.Monad.Rec.Class.Module.MonadRec
                        .app({ _ : Any ->
                             PS.Data.Maybe.Module.monadMaybe
                          })
                        .app({ f : Any ->
       { a0 : Any ->
         object   {
             val g = { v : Any ->
                when {
                 (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                   PS.Control.Monad.Rec.Class.Module.Done
                     .app(PS.Data.Maybe.Module.Nothing);
                 }
                 (v is PS.Data.Maybe.Module._Type_Maybe
                         .Just)&& (v
                                     .value0 is PS.Control.Monad.Rec.Class.Module._Type_Step
                                                  .Loop) -> {
                   val a = v.value0.value0;
                   PS.Control.Monad.Rec.Class.Module.Loop.app(f.app(a));
                 }
                 (v is PS.Data.Maybe.Module._Type_Maybe
                         .Just)&& (v
                                     .value0 is PS.Control.Monad.Rec.Class.Module._Type_Step
                                                  .Done) -> {
                   val b = v.value0.value0;
                   PS.Control.Monad.Rec.Class.Module.Done
                     .app(PS.Data.Maybe.Module.Just.app(b));
                 }
                 else -> (error("Error in Pattern Match") as Any)
               }
             };
           }
           .run({
            val g = this.g;
            PS.Control.Monad.Rec.Class.Module.tailRec.app(g).app(f.app(a0));
          })
      }
    });
  @JvmField
  val monadRecIdentity = PS.Control.Monad.Rec.Class.Module.MonadRec
                           .app({ _ : Any ->
                                PS.Data.Identity.Module.monadIdentity
                             })
                           .app({ f : Any ->
       object   {
           val runIdentity = { v : Any -> when { else -> { val x = v; x; } }};
         }
         .run({
          val runIdentity = this.runIdentity;
          PS.Control.Semigroupoid.Module.compose
            .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
            .app(PS.Data.Identity.Module.Identity)
            .app(PS.Control.Monad.Rec.Class.Module.tailRec
                   .app(PS.Control.Semigroupoid.Module.compose
                          .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                          .app(runIdentity)
                          .app(f)));
        })
    });
  @JvmField
  val monadRecFunction = PS.Control.Monad.Rec.Class.Module.MonadRec
                           .app({ _ : Any ->
                                PS.Control.Monad.Module.monadFn
                             })
                           .app({ f : Any ->
       { a0 : Any ->
         { e : Any ->
           PS.Control.Monad.Rec.Class.Module.tailRec
             .app({ a : Any ->
                  f.app(a).app(e)
               })
             .app(a0)
        }
      }
    });
  @JvmField
  val monadRecEither = PS.Control.Monad.Rec.Class.Module.MonadRec
                         .app({ _ : Any ->
                              PS.Data.Either.Module.monadEither
                           })
                         .app({ f : Any ->
       { a0 : Any ->
         object   {
             val g = { v : Any ->
                when {
                 (v is PS.Data.Either.Module._Type_Either.Left) -> {
                   val e = v.value0;
                   PS.Control.Monad.Rec.Class.Module.Done
                     .app(PS.Data.Either.Module.Left.app(e));
                 }
                 (v is PS.Data.Either.Module._Type_Either
                         .Right)&& (v
                                      .value0 is PS.Control.Monad.Rec.Class.Module._Type_Step
                                                   .Loop) -> {
                   val a = v.value0.value0;
                   PS.Control.Monad.Rec.Class.Module.Loop.app(f.app(a));
                 }
                 (v is PS.Data.Either.Module._Type_Either
                         .Right)&& (v
                                      .value0 is PS.Control.Monad.Rec.Class.Module._Type_Step
                                                   .Done) -> {
                   val b = v.value0.value0;
                   PS.Control.Monad.Rec.Class.Module.Done
                     .app(PS.Data.Either.Module.Right.app(b));
                 }
                 else -> (error("Error in Pattern Match") as Any)
               }
             };
           }
           .run({
            val g = this.g;
            PS.Control.Monad.Rec.Class.Module.tailRec.app(g).app(f.app(a0));
          })
      }
    });
  @JvmField
  val monadRecEffect = PS.Control.Monad.Rec.Class.Module.MonadRec
                         .app({ _ : Any ->
                              PS.Effect.Module.monadEffect
                           })
                         .app({ f : Any ->
       { a : Any ->
         object   {
             val fromDone = PS.Partial.Unsafe.Module.unsafePartial
                              .app({ dictPartial : Any ->
                  { v : Any ->
                    when {
                     (v is PS.Control.Monad.Rec.Class.Module._Type_Step
                             .Done) -> {
                       val b = v.value0;
                       b;
                     }
                     else -> (error("Error in Pattern Match") as Any)
                   }
                 }
               });
           }
           .run({
            val fromDone = this.fromDone;
            PS.Control.Bind.Module.bind.app(PS.Effect.Module.bindEffect)
              .app(PS.Control.Bind.Module.bindFlipped
                     .app(PS.Effect.Module.bindEffect)
                     .app(PS.Effect.Ref.Module.new)
                     .app(f.app(a)))
              .app({ v : Any ->
                 when {
                  else -> {
                    val r = v;
                    { _ : Any ->
                      PS.Effect.Module.untilE
                        .app(PS.Control.Bind.Module.bind
                               .app(PS.Effect.Module.bindEffect)
                               .app(PS.Effect.Ref.Module.read.app(r))
                               .app({ v1 : Any ->
                                 when {
                                  (v1 is PS.Control.Monad.Rec.Class.Module._Type_Step
                                           .Loop) -> {
                                    val a_tick = v1.value0;
                                    PS.Control.Bind.Module.bind
                                      .app(PS.Effect.Module.bindEffect)
                                      .app(f.app(a_tick))
                                      .app({ v2 : Any ->
                                         when {
                                          else -> {
                                            val e = v2;
                                            PS.Control.Bind.Module.bind
                                              .app(PS.Effect.Module.bindEffect)
                                              .app(PS.Effect.Ref.Module.write
                                                     .app(e)
                                                     .app(r))
                                              .app({ v3 : Any ->
                                                 false
                                              });
                                          }
                                        }
                                      });
                                  }
                                  (v1 is PS.Control.Monad.Rec.Class.Module._Type_Step
                                           .Done) -> {
                                    val b = v1.value0;
                                    true;
                                  }
                                  else -> (error("Error in Pattern Match"
                                  ) as Any)
                                }
                              }))()
                        PS.Data.Functor.Module.map
                          .app(PS.Effect.Module.functorEffect)
                          .app(fromDone)
                          .app(PS.Effect.Ref.Module.read.app(r))};
                  }
                }
              });
          })
      }
    });
  @JvmField
  val functorStep = PS.Data.Functor.Module.Functor
                      .app({ f : Any ->
       { m : Any ->
         when {
          (m is PS.Control.Monad.Rec.Class.Module._Type_Step.Loop) -> {
            val v = m.value0;
            PS.Control.Monad.Rec.Class.Module.Loop.app(v);
          }
          (m is PS.Control.Monad.Rec.Class.Module._Type_Step.Done) -> {
            val v = m.value0;
            PS.Control.Monad.Rec.Class.Module.Done.app(f.app(v));
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val forever = { dictMonadRec : Any ->
     { ma : Any ->
       PS.Control.Monad.Rec.Class.Module.tailRecM.app(dictMonadRec)
         .app({ u : Any ->
              PS.Data.Functor.Module.voidRight
                .app(((((dictMonadRec as Map<String, Any>)["Monad0"]!!
                          .app(Unit) as Map<String, Any>)["Bind1"]!!
                         .app(Unit) as Map<String, Any>)["Apply0"]!!
                        .app(Unit) as Map<String, Any>)["Functor0"]!!
                       .app(Unit))
                .app(PS.Control.Monad.Rec.Class.Module.Loop.app(u))
                .app(ma)
           })
         .app(PS.Data.Unit.Module.unit)
    }
  };
  @JvmField
  val bifunctorStep = PS.Data.Bifunctor.Module.Bifunctor
                        .app({ v : Any ->
       { v1 : Any ->
         { v2 : Any ->
           when {
            (v2 is PS.Control.Monad.Rec.Class.Module._Type_Step.Loop) -> {
              val f = v;
              val a = v2.value0;
              PS.Control.Monad.Rec.Class.Module.Loop.app(f.app(a));
            }
            (v2 is PS.Control.Monad.Rec.Class.Module._Type_Step.Done) -> {
              val g = v1;
              val b = v2.value0;
              PS.Control.Monad.Rec.Class.Module.Done.app(g.app(b));
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      }
    });
}