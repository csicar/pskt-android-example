@file:Suppress("UNCHECKED_CAST")

package PS.Data.Monoid.Disj
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val Disj = { x : Any -> x};
  @JvmField
  val showDisj = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ v : Any ->
        val a = v;
          (("(Disj " as String) + (((PS.Data.Show.Module.show.app(dictShow)
                                       .app(a
          ) as String) + (")" as String)) as String));})
  };
  @JvmField
  val semiringDisj = { dictHeytingAlgebra : Any ->
     PS.Data.Semiring.Module.Semiring
       .app({ v : Any ->
            { v1 : Any ->
             val a = v;
               val b = v1;
               PS.Data.Monoid.Disj.Module.Disj
                 .app(PS.Data.HeytingAlgebra.Module.disj.app(dictHeytingAlgebra)
                        .app(a)
                        .app(b));}
         })
       .app({ v : Any ->
            { v1 : Any ->
             val a = v;
               val b = v1;
               PS.Data.Monoid.Disj.Module.Disj
                 .app(PS.Data.HeytingAlgebra.Module.conj.app(dictHeytingAlgebra)
                        .app(a)
                        .app(b));}
         })
       .app(PS.Data.Monoid.Disj.Module.Disj
              .app(PS.Data.HeytingAlgebra.Module.tt.app(dictHeytingAlgebra)))
       .app(PS.Data.Monoid.Disj.Module.Disj
              .app(PS.Data.HeytingAlgebra.Module.ff.app(dictHeytingAlgebra)))
  };
  @JvmField
  val semigroupDisj = { dictHeytingAlgebra : Any ->
     PS.Data.Semigroup.Module.Semigroup
       .app({ v : Any ->
         { v1 : Any ->
          val a = v;
            val b = v1;
            PS.Data.Monoid.Disj.Module.Disj
              .app(PS.Data.HeytingAlgebra.Module.disj.app(dictHeytingAlgebra)
                     .app(a)
                     .app(b));}
      })
  };
  @JvmField val ordDisj = { dictOrd : Any -> dictOrd};
  @JvmField
  val monoidDisj = { dictHeytingAlgebra : Any ->
     PS.Data.Monoid.Module.Monoid
       .app({ _ : Any ->
            PS.Data.Monoid.Disj.Module.semigroupDisj.app(dictHeytingAlgebra)
         })
       .app(PS.Data.Monoid.Disj.Module.Disj
              .app(PS.Data.HeytingAlgebra.Module.ff.app(dictHeytingAlgebra)))
  };
  @JvmField
  val functorDisj = PS.Data.Functor.Module.Functor
                      .app({ f : Any ->
       { m : Any ->
        val v = m;
          PS.Data.Monoid.Disj.Module.Disj.app(f.app(v));}
    });
  @JvmField val eqDisj = { dictEq : Any -> dictEq};
  @JvmField
  val eq1Disj = PS.Data.Eq.Module.Eq1
                  .app({ dictEq : Any ->
       PS.Data.Eq.Module.eq.app(PS.Data.Monoid.Disj.Module.eqDisj.app(dictEq))
    });
  @JvmField
  val ord1Disj = PS.Data.Ord.Module.Ord1
                   .app({ _ : Any ->
                        PS.Data.Monoid.Disj.Module.eq1Disj
                     })
                   .app({ dictOrd : Any ->
       PS.Data.Ord.Module.compare
         .app(PS.Data.Monoid.Disj.Module.ordDisj.app(dictOrd))
    });
  @JvmField val boundedDisj = { dictBounded : Any -> dictBounded};
  @JvmField
  val applyDisj = PS.Control.Apply.Module.Apply
                    .app({ _ : Any ->
                         PS.Data.Monoid.Disj.Module.functorDisj
                      })
                    .app({ v : Any ->
       { v1 : Any ->
        val f = v;
          val x = v1;
          PS.Data.Monoid.Disj.Module.Disj.app(f.app(x));}
    });
  @JvmField
  val bindDisj = PS.Control.Bind.Module.Bind
                   .app({ _ : Any ->
                        PS.Data.Monoid.Disj.Module.applyDisj
                     })
                   .app({ v : Any ->
       { f : Any ->
        val x = v;
          val f1 = f;
          f1.app(x);}
    });
  @JvmField
  val applicativeDisj = PS.Control.Applicative.Module.Applicative
                          .app({ _ : Any ->
                               PS.Data.Monoid.Disj.Module.applyDisj
                            })
                          .app(PS.Data.Monoid.Disj.Module.Disj);
  @JvmField
  val monadDisj = PS.Control.Monad.Module.Monad
                    .app({ _ : Any ->
                         PS.Data.Monoid.Disj.Module.applicativeDisj
                      })
                    .app({ _ : Any ->
       PS.Data.Monoid.Disj.Module.bindDisj
    });
}