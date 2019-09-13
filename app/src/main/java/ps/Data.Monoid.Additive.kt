@file:Suppress("UNCHECKED_CAST")

package PS.Data.Monoid.Additive
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val Additive = { x : Any -> x};
  @JvmField
  val showAdditive = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ v : Any ->
        val a = v;
          (("(Additive " as String) + (((PS.Data.Show.Module.show.app(dictShow)
                                           .app(a
          ) as String) + (")" as String)) as String));})
  };
  @JvmField
  val semigroupAdditive = { dictSemiring : Any ->
     PS.Data.Semigroup.Module.Semigroup
       .app({ v : Any ->
         { v1 : Any ->
          val a = v;
            val b = v1;
            PS.Data.Monoid.Additive.Module.Additive
              .app(PS.Data.Semiring.Module.add.app(dictSemiring).app(a).app(b)
            );}
      })
  };
  @JvmField val ordAdditive = { dictOrd : Any -> dictOrd};
  @JvmField
  val monoidAdditive = { dictSemiring : Any ->
     PS.Data.Monoid.Module.Monoid
       .app({ _ : Any ->
            PS.Data.Monoid.Additive.Module.semigroupAdditive.app(dictSemiring)
         })
       .app(PS.Data.Monoid.Additive.Module.Additive
              .app(PS.Data.Semiring.Module.zero.app(dictSemiring)))
  };
  @JvmField
  val functorAdditive = PS.Data.Functor.Module.Functor
                          .app({ f : Any ->
       { m : Any ->
        val v = m;
          PS.Data.Monoid.Additive.Module.Additive.app(f.app(v));}
    });
  @JvmField val eqAdditive = { dictEq : Any -> dictEq};
  @JvmField
  val eq1Additive = PS.Data.Eq.Module.Eq1
                      .app({ dictEq : Any ->
       PS.Data.Eq.Module.eq
         .app(PS.Data.Monoid.Additive.Module.eqAdditive.app(dictEq))
    });
  @JvmField
  val ord1Additive = PS.Data.Ord.Module.Ord1
                       .app({ _ : Any ->
                            PS.Data.Monoid.Additive.Module.eq1Additive
                         })
                       .app({ dictOrd : Any ->
       PS.Data.Ord.Module.compare
         .app(PS.Data.Monoid.Additive.Module.ordAdditive.app(dictOrd))
    });
  @JvmField val boundedAdditive = { dictBounded : Any -> dictBounded};
  @JvmField
  val applyAdditive = PS.Control.Apply.Module.Apply
                        .app({ _ : Any ->
                             PS.Data.Monoid.Additive.Module.functorAdditive
                          })
                        .app({ v : Any ->
       { v1 : Any ->
        val f = v;
          val x = v1;
          PS.Data.Monoid.Additive.Module.Additive.app(f.app(x));}
    });
  @JvmField
  val bindAdditive = PS.Control.Bind.Module.Bind
                       .app({ _ : Any ->
                            PS.Data.Monoid.Additive.Module.applyAdditive
                         })
                       .app({ v : Any ->
       { f : Any ->
        val x = v;
          val f1 = f;
          f1.app(x);}
    });
  @JvmField
  val applicativeAdditive = PS.Control.Applicative.Module.Applicative
                              .app({ _ : Any ->
                                   PS.Data.Monoid.Additive.Module.applyAdditive
                                })
                              .app(PS.Data.Monoid.Additive.Module.Additive);
  @JvmField
  val monadAdditive = PS.Control.Monad.Module.Monad
                        .app({ _ : Any ->
                             PS.Data.Monoid.Additive.Module.applicativeAdditive
                          })
                        .app({ _ : Any ->
       PS.Data.Monoid.Additive.Module.bindAdditive
    });
}