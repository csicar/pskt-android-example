@file:Suppress("UNCHECKED_CAST")
package PS.Data.Decide
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val Decide = { Divide0 : Any ->
     { choose : Any ->
       mapOf(("Divide0" to Divide0),  ("choose" to choose))
    }
  };
  @JvmField
  val choosePredicate = PS.Data.Decide.Module.Decide
                          .app({ _ : Any ->
                               PS.Data.Divide.Module.dividePredicate
                            })
                          .app({ f : Any ->
       { v : Any ->
         { v1 : Any ->
           when {
            else -> {
              val f1 = f;
              val g = v;
              val h = v1;
              PS.Data.Predicate.Module.Predicate
                .app(PS.Control.Semigroupoid.Module.compose
                       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                       .app(PS.Data.Either.Module.either.app(g).app(h))
                       .app(f1));
            }
          }
        }
      }
    });
  @JvmField
  val chooseOp = { dictSemigroup : Any ->
     PS.Data.Decide.Module.Decide
       .app({ _ : Any ->
            PS.Data.Divide.Module.divideOp.app(dictSemigroup)
         })
       .app({ f : Any ->
         { v : Any ->
           { v1 : Any ->
             when {
              else -> {
                val f1 = f;
                val g = v;
                val h = v1;
                PS.Data.Op.Module.Op
                  .app(PS.Control.Semigroupoid.Module.compose
                         .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                         .app(PS.Data.Either.Module.either.app(g).app(h))
                         .app(f1));
              }
            }
          }
        }
      })
  };
  @JvmField
  val chooseEquivalence = PS.Data.Decide.Module.Decide
                            .app({ _ : Any ->
                                 PS.Data.Divide.Module.divideEquivalence
                              })
                            .app({ f : Any ->
       { v : Any ->
         { v1 : Any ->
           when {
            else -> {
              val f1 = f;
              val g = v;
              val h = v1;
              PS.Data.Equivalence.Module.Equivalence
                .app({ a : Any ->
                   { b : Any ->
                     object   {
                         val v2 = f1.app(a);
                       }
                       .run({
                        val v2 = this.v2;
                        when {
                          (v2 is PS.Data.Either.Module._Type_Either.Left) -> {
                            val c = v2.value0;
                            object   {
                                val v3 = f1.app(b);
                              }
                              .run({
                                val v3 = this.v3;
                                when {
                                  (v3 is PS.Data.Either.Module._Type_Either
                                           .Left) -> {
                                    val d = v3.value0;
                                    g.app(c).app(d);
                                  }
                                  (v3 is PS.Data.Either.Module._Type_Either
                                           .Right) -> {
                                    false;
                                  }
                                  else -> (error("Error in Pattern Match"
                                  ) as Any)
                                };
                              });
                          }
                          (v2 is PS.Data.Either.Module._Type_Either.Right) -> {
                            val c = v2.value0;
                            object   {
                                val v3 = f1.app(b);
                              }
                              .run({
                                val v3 = this.v3;
                                when {
                                  (v3 is PS.Data.Either.Module._Type_Either
                                           .Left) -> {
                                    false;
                                  }
                                  (v3 is PS.Data.Either.Module._Type_Either
                                           .Right) -> {
                                    val d = v3.value0;
                                    h.app(c).app(d);
                                  }
                                  else -> (error("Error in Pattern Match"
                                  ) as Any)
                                };
                              });
                          }
                          else -> (error("Error in Pattern Match") as Any)
                        };
                      })
                  }
                });
            }
          }
        }
      }
    });
  @JvmField
  val chooseComparison = PS.Data.Decide.Module.Decide
                           .app({ _ : Any ->
                                PS.Data.Divide.Module.divideComparison
                             })
                           .app({ f : Any ->
       { v : Any ->
         { v1 : Any ->
           when {
            else -> {
              val f1 = f;
              val g = v;
              val h = v1;
              PS.Data.Comparison.Module.Comparison
                .app({ a : Any ->
                   { b : Any ->
                     object   {
                         val v2 = f1.app(a);
                       }
                       .run({
                        val v2 = this.v2;
                        when {
                          (v2 is PS.Data.Either.Module._Type_Either.Left) -> {
                            val c = v2.value0;
                            object   {
                                val v3 = f1.app(b);
                              }
                              .run({
                                val v3 = this.v3;
                                when {
                                  (v3 is PS.Data.Either.Module._Type_Either
                                           .Left) -> {
                                    val d = v3.value0;
                                    g.app(c).app(d);
                                  }
                                  (v3 is PS.Data.Either.Module._Type_Either
                                           .Right) -> {
                                    PS.Data.Ordering.Module.LT;
                                  }
                                  else -> (error("Error in Pattern Match"
                                  ) as Any)
                                };
                              });
                          }
                          (v2 is PS.Data.Either.Module._Type_Either.Right) -> {
                            val c = v2.value0;
                            object   {
                                val v3 = f1.app(b);
                              }
                              .run({
                                val v3 = this.v3;
                                when {
                                  (v3 is PS.Data.Either.Module._Type_Either
                                           .Left) -> {
                                    PS.Data.Ordering.Module.GT;
                                  }
                                  (v3 is PS.Data.Either.Module._Type_Either
                                           .Right) -> {
                                    val d = v3.value0;
                                    h.app(c).app(d);
                                  }
                                  else -> (error("Error in Pattern Match"
                                  ) as Any)
                                };
                              });
                          }
                          else -> (error("Error in Pattern Match") as Any)
                        };
                      })
                  }
                });
            }
          }
        }
      }
    });
  @JvmField
  val choose = { dict : Any ->
     (dict as Map<String, Any>)["choose"]!!
  };
  @JvmField
  val chosen = { dictDecide : Any ->
     PS.Data.Decide.Module.choose.app(dictDecide)
       .app(PS.Control.Category.Module.identity
              .app(PS.Control.Category.Module.categoryFn))
  };
}