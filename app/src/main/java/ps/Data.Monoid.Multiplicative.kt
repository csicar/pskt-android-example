@file:Suppress("UNCHECKED_CAST")
package PS.Data.Monoid.Multiplicative
import Foreign.PsRuntime.app
object Module  {
  @JvmField val Multiplicative = { x : Any -> x};
  @JvmField
  val showMultiplicative = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ v : Any ->
         when {
          else -> {
            val a = v;
            (("(Multiplicative " as String) + (((PS.Data.Show.Module.show
                                                   .app(dictShow)
                                                   .app(a
            ) as String) + (")" as String)) as String));
          }
        }
      })
  };
  @JvmField
  val semigroupMultiplicative = { dictSemiring : Any ->
     PS.Data.Semigroup.Module.Semigroup
       .app({ v : Any ->
         { v1 : Any ->
           when {
            else -> {
              val a = v;
              val b = v1;
              PS.Data.Monoid.Multiplicative.Module.Multiplicative
                .app(PS.Data.Semiring.Module.mul.app(dictSemiring).app(a).app(b)
              );
            }
          }
        }
      })
  };
  @JvmField val ordMultiplicative = { dictOrd : Any -> dictOrd};
  @JvmField
  val monoidMultiplicative = { dictSemiring : Any ->
     PS.Data.Monoid.Module.Monoid
       .app({ _ : Any ->
            PS.Data.Monoid.Multiplicative.Module.semigroupMultiplicative
              .app(dictSemiring)
         })
       .app(PS.Data.Monoid.Multiplicative.Module.Multiplicative
              .app(PS.Data.Semiring.Module.one.app(dictSemiring)))
  };
  @JvmField
  val functorMultiplicative = PS.Data.Functor.Module.Functor
                                .app({ f : Any ->
       { m : Any ->
         when {
          else -> {
            val v = m;
            PS.Data.Monoid.Multiplicative.Module.Multiplicative.app(f.app(v));
          }
        }
      }
    });
  @JvmField val eqMultiplicative = { dictEq : Any -> dictEq};
  @JvmField
  val eq1Multiplicative = PS.Data.Eq.Module.Eq1
                            .app({ dictEq : Any ->
       PS.Data.Eq.Module.eq
         .app(PS.Data.Monoid.Multiplicative.Module.eqMultiplicative.app(dictEq))
    });
  @JvmField
  val ord1Multiplicative = PS.Data.Ord.Module.Ord1
                             .app({ _ : Any ->
                                  PS.Data.Monoid.Multiplicative.Module.eq1Multiplicative
                               })
                             .app({ dictOrd : Any ->
       PS.Data.Ord.Module.compare
         .app(PS.Data.Monoid.Multiplicative.Module.ordMultiplicative
                .app(dictOrd))
    });
  @JvmField val boundedMultiplicative = { dictBounded : Any -> dictBounded};
  @JvmField
  val applyMultiplicative = PS.Control.Apply.Module.Apply
                              .app({ _ : Any ->
                                   PS.Data.Monoid.Multiplicative.Module.functorMultiplicative
                                })
                              .app({ v : Any ->
       { v1 : Any ->
         when {
          else -> {
            val f = v;
            val x = v1;
            PS.Data.Monoid.Multiplicative.Module.Multiplicative.app(f.app(x));
          }
        }
      }
    });
  @JvmField
  val bindMultiplicative = PS.Control.Bind.Module.Bind
                             .app({ _ : Any ->
                                  PS.Data.Monoid.Multiplicative.Module.applyMultiplicative
                               })
                             .app({ v : Any ->
       { f : Any ->
         when {
          else -> {
            val x = v;
            val f1 = f;
            f1.app(x);
          }
        }
      }
    });
  @JvmField
  val applicativeMultiplicative = PS.Control.Applicative.Module.Applicative
                                    .app({ _ : Any ->
                                         PS.Data.Monoid.Multiplicative.Module.applyMultiplicative
                                      })
                                    .app(
    PS.Data.Monoid.Multiplicative.Module.Multiplicative);
  @JvmField
  val monadMultiplicative = PS.Control.Monad.Module.Monad
                              .app({ _ : Any ->
                                   PS.Data.Monoid.Multiplicative.Module.applicativeMultiplicative
                                })
                              .app({ _ : Any ->
       PS.Data.Monoid.Multiplicative.Module.bindMultiplicative
    });
}