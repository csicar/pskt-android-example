@file:Suppress("UNCHECKED_CAST")

package PS.Data.Monoid.Dual
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val Dual = { x : Any -> x};
  @JvmField
  val showDual = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ v : Any ->
        val a = v;
          (("(Dual " as String) + (((PS.Data.Show.Module.show.app(dictShow)
                                       .app(a
          ) as String) + (")" as String)) as String));})
  };
  @JvmField
  val semigroupDual = { dictSemigroup : Any ->
     PS.Data.Semigroup.Module.Semigroup
       .app({ v : Any ->
         { v1 : Any ->
          val x = v;
            val y = v1;
            PS.Data.Monoid.Dual.Module.Dual
              .app(PS.Data.Semigroup.Module.append.app(dictSemigroup).app(y)
                     .app(x));}
      })
  };
  @JvmField val ordDual = { dictOrd : Any -> dictOrd};
  @JvmField
  val monoidDual = { dictMonoid : Any ->
     PS.Data.Monoid.Module.Monoid
       .app({ _ : Any ->
            PS.Data.Monoid.Dual.Module.semigroupDual
              .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!.app(Unit))
         })
       .app(PS.Data.Monoid.Dual.Module.Dual
              .app(PS.Data.Monoid.Module.mempty.app(dictMonoid)))
  };
  @JvmField
  val functorDual = PS.Data.Functor.Module.Functor
                      .app({ f : Any ->
       { m : Any ->
        val v = m;
          PS.Data.Monoid.Dual.Module.Dual.app(f.app(v));}
    });
  @JvmField val eqDual = { dictEq : Any -> dictEq};
  @JvmField
  val eq1Dual = PS.Data.Eq.Module.Eq1
                  .app({ dictEq : Any ->
       PS.Data.Eq.Module.eq.app(PS.Data.Monoid.Dual.Module.eqDual.app(dictEq))
    });
  @JvmField
  val ord1Dual = PS.Data.Ord.Module.Ord1
                   .app({ _ : Any ->
                        PS.Data.Monoid.Dual.Module.eq1Dual
                     })
                   .app({ dictOrd : Any ->
       PS.Data.Ord.Module.compare
         .app(PS.Data.Monoid.Dual.Module.ordDual.app(dictOrd))
    });
  @JvmField val boundedDual = { dictBounded : Any -> dictBounded};
  @JvmField
  val applyDual = PS.Control.Apply.Module.Apply
                    .app({ _ : Any ->
                         PS.Data.Monoid.Dual.Module.functorDual
                      })
                    .app({ v : Any ->
       { v1 : Any ->
        val f = v;
          val x = v1;
          PS.Data.Monoid.Dual.Module.Dual.app(f.app(x));}
    });
  @JvmField
  val bindDual = PS.Control.Bind.Module.Bind
                   .app({ _ : Any ->
                        PS.Data.Monoid.Dual.Module.applyDual
                     })
                   .app({ v : Any ->
       { f : Any ->
        val x = v;
          val f1 = f;
          f1.app(x);}
    });
  @JvmField
  val applicativeDual = PS.Control.Applicative.Module.Applicative
                          .app({ _ : Any ->
                               PS.Data.Monoid.Dual.Module.applyDual
                            })
                          .app(PS.Data.Monoid.Dual.Module.Dual);
  @JvmField
  val monadDual = PS.Control.Monad.Module.Monad
                    .app({ _ : Any ->
                         PS.Data.Monoid.Dual.Module.applicativeDual
                      })
                    .app({ _ : Any ->
       PS.Data.Monoid.Dual.Module.bindDual
    });
}