@file:Suppress("UNCHECKED_CAST")
package PS.Data.Comparison
import Foreign.PsRuntime.app
object Module  {
  @JvmField val Comparison = { x : Any -> x};
  @JvmField
  val semigroupComparison = PS.Data.Semigroup.Module.Semigroup
                              .app({ v : Any ->
       { v1 : Any ->
         when {
          else -> {
            val p = v;
            val q = v1;
            PS.Data.Comparison.Module.Comparison
              .app(PS.Data.Semigroup.Module.append
                     .app(PS.Data.Semigroup.Module.semigroupFn
                            .app(PS.Data.Semigroup.Module.semigroupFn
                                   .app(
                           PS.Data.Ordering.Module.semigroupOrdering)))
                     .app(p)
                     .app(q));
          }
        }
      }
    });
  @JvmField
  val newtypeComparison = PS.Data.Newtype.Module.Newtype
                            .app({ n : Any ->
                                 when {
                                  else -> {
                                    val a = n;
                                    a;
                                  }
                                }
                              })
                            .app(PS.Data.Comparison.Module.Comparison);
  @JvmField
  val monoidComparison = PS.Data.Monoid.Module.Monoid
                           .app({ _ : Any ->
                                PS.Data.Comparison.Module.semigroupComparison
                             })
                           .app(PS.Data.Comparison.Module.Comparison
                                  .app({ v : Any ->
         { v1 : Any ->
           PS.Data.Ordering.Module.EQ
        }
      }));
  @JvmField
  val defaultComparison = { dictOrd : Any ->
     PS.Data.Comparison.Module.Comparison
       .app(PS.Data.Ord.Module.compare.app(dictOrd))
  };
  @JvmField
  val contravariantComparison = PS.Data.Functor.Contravariant.Module.Contravariant
                                  .app({ f : Any ->
       { v : Any ->
         when {
          else -> {
            val f1 = f;
            val g = v;
            PS.Data.Comparison.Module.Comparison
              .app(PS.Data.Function.Module.on.app(g).app(f1));
          }
        }
      }
    });
}