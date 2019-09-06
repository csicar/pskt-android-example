@file:Suppress("UNCHECKED_CAST")
package PS.Data.Monoid.Conj
import Foreign.PsRuntime.app
object Module  {
  @JvmField val Conj = { x : Any -> x};
  @JvmField
  val showConj = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ v : Any ->
         when {
          else -> {
            val a = v;
            (("(Conj " as String) + (((PS.Data.Show.Module.show.app(dictShow)
                                         .app(a
            ) as String) + (")" as String)) as String));
          }
        }
      })
  };
  @JvmField
  val semiringConj = { dictHeytingAlgebra : Any ->
     PS.Data.Semiring.Module.Semiring
       .app({ v : Any ->
            { v1 : Any ->
              when {
               else -> {
                 val a = v;
                 val b = v1;
                 PS.Data.Monoid.Conj.Module.Conj
                   .app(PS.Data.HeytingAlgebra.Module.conj
                          .app(dictHeytingAlgebra)
                          .app(a)
                          .app(b));
               }
             }
           }
         })
       .app({ v : Any ->
            { v1 : Any ->
              when {
               else -> {
                 val a = v;
                 val b = v1;
                 PS.Data.Monoid.Conj.Module.Conj
                   .app(PS.Data.HeytingAlgebra.Module.disj
                          .app(dictHeytingAlgebra)
                          .app(a)
                          .app(b));
               }
             }
           }
         })
       .app(PS.Data.Monoid.Conj.Module.Conj
              .app(PS.Data.HeytingAlgebra.Module.ff.app(dictHeytingAlgebra)))
       .app(PS.Data.Monoid.Conj.Module.Conj
              .app(PS.Data.HeytingAlgebra.Module.tt.app(dictHeytingAlgebra)))
  };
  @JvmField
  val semigroupConj = { dictHeytingAlgebra : Any ->
     PS.Data.Semigroup.Module.Semigroup
       .app({ v : Any ->
         { v1 : Any ->
           when {
            else -> {
              val a = v;
              val b = v1;
              PS.Data.Monoid.Conj.Module.Conj
                .app(PS.Data.HeytingAlgebra.Module.conj.app(dictHeytingAlgebra)
                       .app(a)
                       .app(b));
            }
          }
        }
      })
  };
  @JvmField val ordConj = { dictOrd : Any -> dictOrd};
  @JvmField
  val monoidConj = { dictHeytingAlgebra : Any ->
     PS.Data.Monoid.Module.Monoid
       .app({ _ : Any ->
            PS.Data.Monoid.Conj.Module.semigroupConj.app(dictHeytingAlgebra)
         })
       .app(PS.Data.Monoid.Conj.Module.Conj
              .app(PS.Data.HeytingAlgebra.Module.tt.app(dictHeytingAlgebra)))
  };
  @JvmField
  val functorConj = PS.Data.Functor.Module.Functor
                      .app({ f : Any ->
       { m : Any ->
         when {
          else -> {
            val v = m;
            PS.Data.Monoid.Conj.Module.Conj.app(f.app(v));
          }
        }
      }
    });
  @JvmField val eqConj = { dictEq : Any -> dictEq};
  @JvmField
  val eq1Conj = PS.Data.Eq.Module.Eq1
                  .app({ dictEq : Any ->
       PS.Data.Eq.Module.eq.app(PS.Data.Monoid.Conj.Module.eqConj.app(dictEq))
    });
  @JvmField
  val ord1Conj = PS.Data.Ord.Module.Ord1
                   .app({ _ : Any ->
                        PS.Data.Monoid.Conj.Module.eq1Conj
                     })
                   .app({ dictOrd : Any ->
       PS.Data.Ord.Module.compare
         .app(PS.Data.Monoid.Conj.Module.ordConj.app(dictOrd))
    });
  @JvmField val boundedConj = { dictBounded : Any -> dictBounded};
  @JvmField
  val applyConj = PS.Control.Apply.Module.Apply
                    .app({ _ : Any ->
                         PS.Data.Monoid.Conj.Module.functorConj
                      })
                    .app({ v : Any ->
       { v1 : Any ->
         when {
          else -> {
            val f = v;
            val x = v1;
            PS.Data.Monoid.Conj.Module.Conj.app(f.app(x));
          }
        }
      }
    });
  @JvmField
  val bindConj = PS.Control.Bind.Module.Bind
                   .app({ _ : Any ->
                        PS.Data.Monoid.Conj.Module.applyConj
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
  val applicativeConj = PS.Control.Applicative.Module.Applicative
                          .app({ _ : Any ->
                               PS.Data.Monoid.Conj.Module.applyConj
                            })
                          .app(PS.Data.Monoid.Conj.Module.Conj);
  @JvmField
  val monadConj = PS.Control.Monad.Module.Monad
                    .app({ _ : Any ->
                         PS.Data.Monoid.Conj.Module.applicativeConj
                      })
                    .app({ _ : Any ->
       PS.Data.Monoid.Conj.Module.bindConj
    });
}