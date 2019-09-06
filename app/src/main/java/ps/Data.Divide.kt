@file:Suppress("UNCHECKED_CAST")
package PS.Data.Divide
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val Divide = { Contravariant0 : Any ->
     { divide : Any ->
       mapOf(("Contravariant0" to Contravariant0),  ("divide" to divide))
    }
  };
  @JvmField
  val dividePredicate = PS.Data.Divide.Module.Divide
                          .app({ _ : Any ->
                               PS.Data.Predicate.Module.contravariantPredicate
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
                .app({ a : Any ->
                   object   {
                       val v2 = f1.app(a);
                     }
                     .run({
                      val v2 = this.v2;
                      when {
                        (v2 is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                          val b = v2.value0;
                          val c = v2.value1;
                          PS.Data.HeytingAlgebra.Module.conj
                            .app(
                              PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean
                            )
                            .app(g.app(b))
                            .app(h.app(c));
                        }
                        else -> (error("Error in Pattern Match") as Any)
                      };
                    })
                });
            }
          }
        }
      }
    });
  @JvmField
  val divideOp = { dictSemigroup : Any ->
     PS.Data.Divide.Module.Divide
       .app({ _ : Any ->
            PS.Data.Op.Module.contravariantOp
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
                  .app({ a : Any ->
                     object   {
                         val v2 = f1.app(a);
                       }
                       .run({
                        val v2 = this.v2;
                        when {
                          (v2 is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                            val b = v2.value0;
                            val c = v2.value1;
                            PS.Data.Semigroup.Module.append.app(dictSemigroup)
                              .app(g.app(b))
                              .app(h.app(c));
                          }
                          else -> (error("Error in Pattern Match") as Any)
                        };
                      })
                  });
              }
            }
          }
        }
      })
  };
  @JvmField
  val divideEquivalence = PS.Data.Divide.Module.Divide
                            .app({ _ : Any ->
                                 PS.Data.Equivalence.Module.contravariantEquivalence
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
                          (v2 is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                            val a_tick = v2.value0;
                            val a_tick_tick = v2.value1;
                            object   {
                                val v3 = f1.app(b);
                              }
                              .run({
                                val v3 = this.v3;
                                when {
                                  (v3 is PS.Data.Tuple.Module._Type_Tuple
                                           .Tuple) -> {
                                    val b_tick = v3.value0;
                                    val b_tick_tick = v3.value1;
                                    PS.Data.HeytingAlgebra.Module.conj
                                      .app(
                                        PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean
                                      )
                                      .app(g.app(a_tick).app(b_tick))
                                      .app(h.app(a_tick_tick).app(b_tick_tick));
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
  val divideComparison = PS.Data.Divide.Module.Divide
                           .app({ _ : Any ->
                                PS.Data.Comparison.Module.contravariantComparison
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
                          (v2 is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                            val a_tick = v2.value0;
                            val a_tick_tick = v2.value1;
                            object   {
                                val v3 = f1.app(b);
                              }
                              .run({
                                val v3 = this.v3;
                                when {
                                  (v3 is PS.Data.Tuple.Module._Type_Tuple
                                           .Tuple) -> {
                                    val b_tick = v3.value0;
                                    val b_tick_tick = v3.value1;
                                    PS.Data.Semigroup.Module.append
                                      .app(
                                        PS.Data.Ordering.Module.semigroupOrdering
                                      )
                                      .app(g.app(a_tick).app(b_tick))
                                      .app(h.app(a_tick_tick).app(b_tick_tick));
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
  val divide = { dict : Any ->
     (dict as Map<String, Any>)["divide"]!!
  };
  @JvmField
  val divided = { dictDivide : Any ->
     PS.Data.Divide.Module.divide.app(dictDivide)
       .app(PS.Control.Category.Module.identity
              .app(PS.Control.Category.Module.categoryFn))
  };
}