@file:Suppress("UNCHECKED_CAST")

package PS.Data.Decidable
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val Decidable = { Decide0 : Any ->
     { Divisible1 : Any ->
       { lose : Any ->
         mapOf(("Decide0" to Decide0),  ("Divisible1" to Divisible1),  
          ("lose" to lose))
      }
    }
  };
  @JvmField val lose = { dict : Any -> (dict as Map<String, Any>)["lose"]!!};
  @JvmField
  val lost = { dictDecidable : Any ->
     PS.Data.Decidable.Module.lose.app(dictDecidable)
       .app(PS.Control.Category.Module.identity
              .app(PS.Control.Category.Module.categoryFn))
  };
  @JvmField
  val decidablePredicate = PS.Data.Decidable.Module.Decidable
                             .app({ _ : Any ->
                                  PS.Data.Decide.Module.choosePredicate
                               })
                             .app({ _ : Any ->
                                  PS.Data.Divisible.Module.divisiblePredicate
                               })
                             .app({ f : Any ->
       PS.Data.Predicate.Module.Predicate
         .app({ a : Any ->
           PS.Data.Void.Module.absurd.app(f.app(a))
        })
    });
  @JvmField
  val decidableOp = { dictMonoid : Any ->
     PS.Data.Decidable.Module.Decidable
       .app({ _ : Any ->
            PS.Data.Decide.Module.chooseOp
              .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!.app(Unit))
         })
       .app({ _ : Any ->
            PS.Data.Divisible.Module.divisibleOp.app(dictMonoid)
         })
       .app({ f : Any ->
         PS.Data.Op.Module.Op
           .app({ a : Any ->
             PS.Data.Void.Module.absurd.app(f.app(a))
          })
      })
  };
  @JvmField
  val decidableEquivalence = PS.Data.Decidable.Module.Decidable
                               .app({ _ : Any ->
                                    PS.Data.Decide.Module.chooseEquivalence
                                 })
                               .app({ _ : Any ->
                                    PS.Data.Divisible.Module.divisibleEquivalence
                                 })
                               .app({ f : Any ->
       PS.Data.Equivalence.Module.Equivalence
         .app({ a : Any ->
           PS.Data.Void.Module.absurd.app(f.app(a))
        })
    });
  @JvmField
  val decidableComparison = PS.Data.Decidable.Module.Decidable
                              .app({ _ : Any ->
                                   PS.Data.Decide.Module.chooseComparison
                                })
                              .app({ _ : Any ->
                                   PS.Data.Divisible.Module.divisibleComparison
                                })
                              .app({ f : Any ->
       PS.Data.Comparison.Module.Comparison
         .app({ a : Any ->
           { v : Any ->
             PS.Data.Void.Module.absurd.app(f.app(a))
          }
        })
    });
}