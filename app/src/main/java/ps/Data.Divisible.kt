@file:Suppress("UNCHECKED_CAST")
package PS.Data.Divisible
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val Divisible = { Divide0 : Any ->
     { conquer : Any ->
       mapOf(("Divide0" to Divide0),  ("conquer" to conquer))
    }
  };
  @JvmField
  val divisiblePredicate = PS.Data.Divisible.Module.Divisible
                             .app({ _ : Any ->
                                  PS.Data.Divide.Module.dividePredicate
                               })
                             .app(PS.Data.Predicate.Module.Predicate
                                    .app(PS.Data.Function.Module._const
                                           .app(true)));
  @JvmField
  val divisibleOp = { dictMonoid : Any ->
     PS.Data.Divisible.Module.Divisible
       .app({ _ : Any ->
            PS.Data.Divide.Module.divideOp
              .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!.app(Unit))
         })
       .app(PS.Data.Function.Module.apply.app(PS.Data.Op.Module.Op)
              .app(PS.Data.Function.Module._const
                     .app(PS.Data.Monoid.Module.mempty.app(dictMonoid))))
  };
  @JvmField
  val divisibleEquivalence = PS.Data.Divisible.Module.Divisible
                               .app({ _ : Any ->
                                    PS.Data.Divide.Module.divideEquivalence
                                 })
                               .app(PS.Data.Function.Module.apply
                                      .app(
                                        PS.Data.Equivalence.Module.Equivalence)
                                      .app({ v : Any ->
         { v1 : Any ->
           true
        }
      }));
  @JvmField
  val divisibleComparison = PS.Data.Divisible.Module.Divisible
                              .app({ _ : Any ->
                                   PS.Data.Divide.Module.divideComparison
                                })
                              .app(PS.Data.Function.Module.apply
                                     .app(PS.Data.Comparison.Module.Comparison)
                                     .app({ v : Any ->
         { v1 : Any ->
           PS.Data.Ordering.Module.EQ
        }
      }));
  @JvmField
  val conquer = { dict : Any ->
     (dict as Map<String, Any>)["conquer"]!!
  };
}