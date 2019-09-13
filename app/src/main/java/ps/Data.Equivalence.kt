@file:Suppress("UNCHECKED_CAST")

package PS.Data.Equivalence
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val Equivalence = { x : Any -> x};
  @JvmField
  val semigroupEquivalence = PS.Data.Semigroup.Module.Semigroup
                               .app({ v : Any ->
       { v1 : Any ->
        val p = v;
          val q = v1;
          PS.Data.Equivalence.Module.Equivalence
            .app({ a : Any ->
               { b : Any ->
                 PS.Data.HeytingAlgebra.Module.conj
                   .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
                   .app(p.app(a).app(b))
                   .app(q.app(a).app(b))
              }
            });}
    });
  @JvmField
  val newtypeEquivalence = PS.Data.Newtype.Module.Newtype
                             .app({ n : Any ->
                                 val a = n;
                                   a;})
                             .app(PS.Data.Equivalence.Module.Equivalence);
  @JvmField
  val monoidEquivalence = PS.Data.Monoid.Module.Monoid
                            .app({ _ : Any ->
                                 PS.Data.Equivalence.Module.semigroupEquivalence
                              })
                            .app(PS.Data.Equivalence.Module.Equivalence
                                   .app({ v : Any ->
         { v1 : Any ->
           true
        }
      }));
  @JvmField
  val defaultEquivalence = { dictEq : Any ->
     PS.Data.Equivalence.Module.Equivalence
       .app(PS.Data.Eq.Module.eq.app(dictEq))
  };
  @JvmField
  val contravariantEquivalence = PS.Data.Functor.Contravariant.Module.Contravariant
                                   .app({ f : Any ->
       { v : Any ->
        val f1 = f;
          val g = v;
          PS.Data.Equivalence.Module.Equivalence
            .app(PS.Data.Function.Module.on.app(g).app(f1));}
    });
  @JvmField
  val comparisonEquivalence = { v : Any ->
    val p = v;
      PS.Data.Equivalence.Module.Equivalence
        .app({ a : Any ->
           { b : Any ->
             PS.Data.Eq.Module.eq.app(PS.Data.Ordering.Module.eqOrdering)
               .app(p.app(a).app(b))
               .app(PS.Data.Ordering.Module.EQ)
          }
        });};
}