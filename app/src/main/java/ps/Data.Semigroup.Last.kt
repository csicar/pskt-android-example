@file:Suppress("UNCHECKED_CAST")

package PS.Data.Semigroup.Last
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val Last = { x : Any -> x};
  @JvmField
  val showLast = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ v : Any ->
        val a = v;
          (("(Last " as String) + (((PS.Data.Show.Module.show.app(dictShow)
                                       .app(a
          ) as String) + (")" as String)) as String));})
  };
  @JvmField
  val semigroupLast = PS.Data.Semigroup.Module.Semigroup
                        .app({ v : Any ->
       { x : Any ->
         x
      }
    });
  @JvmField val ordLast = { dictOrd : Any -> dictOrd};
  @JvmField
  val functorLast = PS.Data.Functor.Module.Functor
                      .app({ f : Any ->
       { m : Any ->
        val v = m;
          PS.Data.Semigroup.Last.Module.Last.app(f.app(v));}
    });
  @JvmField val eqLast = { dictEq : Any -> dictEq};
  @JvmField
  val eq1Last = PS.Data.Eq.Module.Eq1
                  .app({ dictEq : Any ->
       PS.Data.Eq.Module.eq
         .app(PS.Data.Semigroup.Last.Module.eqLast.app(dictEq))
    });
  @JvmField
  val ord1Last = PS.Data.Ord.Module.Ord1
                   .app({ _ : Any ->
                        PS.Data.Semigroup.Last.Module.eq1Last
                     })
                   .app({ dictOrd : Any ->
       PS.Data.Ord.Module.compare
         .app(PS.Data.Semigroup.Last.Module.ordLast.app(dictOrd))
    });
  @JvmField val boundedLast = { dictBounded : Any -> dictBounded};
  @JvmField
  val applyLast = PS.Control.Apply.Module.Apply
                    .app({ _ : Any ->
                         PS.Data.Semigroup.Last.Module.functorLast
                      })
                    .app({ v : Any ->
       { v1 : Any ->
        val f = v;
          val x = v1;
          PS.Data.Semigroup.Last.Module.Last.app(f.app(x));}
    });
  @JvmField
  val bindLast = PS.Control.Bind.Module.Bind
                   .app({ _ : Any ->
                        PS.Data.Semigroup.Last.Module.applyLast
                     })
                   .app({ v : Any ->
       { f : Any ->
        val x = v;
          val f1 = f;
          f1.app(x);}
    });
  @JvmField
  val applicativeLast = PS.Control.Applicative.Module.Applicative
                          .app({ _ : Any ->
                               PS.Data.Semigroup.Last.Module.applyLast
                            })
                          .app(PS.Data.Semigroup.Last.Module.Last);
  @JvmField
  val monadLast = PS.Control.Monad.Module.Monad
                    .app({ _ : Any ->
                         PS.Data.Semigroup.Last.Module.applicativeLast
                      })
                    .app({ _ : Any ->
       PS.Data.Semigroup.Last.Module.bindLast
    });
}