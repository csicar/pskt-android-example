@file:Suppress("UNCHECKED_CAST")

package PS.Data.Semigroup.First
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val First = { x : Any -> x};
  @JvmField
  val showFirst = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ v : Any ->
        val a = v;
          (("(First " as String) + (((PS.Data.Show.Module.show.app(dictShow)
                                        .app(a
          ) as String) + (")" as String)) as String));})
  };
  @JvmField
  val semigroupFirst = PS.Data.Semigroup.Module.Semigroup
                         .app({ x : Any ->
       { v : Any ->
         x
      }
    });
  @JvmField val ordFirst = { dictOrd : Any -> dictOrd};
  @JvmField
  val functorFirst = PS.Data.Functor.Module.Functor
                       .app({ f : Any ->
       { m : Any ->
        val v = m;
          PS.Data.Semigroup.First.Module.First.app(f.app(v));}
    });
  @JvmField val eqFirst = { dictEq : Any -> dictEq};
  @JvmField
  val eq1First = PS.Data.Eq.Module.Eq1
                   .app({ dictEq : Any ->
       PS.Data.Eq.Module.eq
         .app(PS.Data.Semigroup.First.Module.eqFirst.app(dictEq))
    });
  @JvmField
  val ord1First = PS.Data.Ord.Module.Ord1
                    .app({ _ : Any ->
                         PS.Data.Semigroup.First.Module.eq1First
                      })
                    .app({ dictOrd : Any ->
       PS.Data.Ord.Module.compare
         .app(PS.Data.Semigroup.First.Module.ordFirst.app(dictOrd))
    });
  @JvmField val boundedFirst = { dictBounded : Any -> dictBounded};
  @JvmField
  val applyFirst = PS.Control.Apply.Module.Apply
                     .app({ _ : Any ->
                          PS.Data.Semigroup.First.Module.functorFirst
                       })
                     .app({ v : Any ->
       { v1 : Any ->
        val f = v;
          val x = v1;
          PS.Data.Semigroup.First.Module.First.app(f.app(x));}
    });
  @JvmField
  val bindFirst = PS.Control.Bind.Module.Bind
                    .app({ _ : Any ->
                         PS.Data.Semigroup.First.Module.applyFirst
                      })
                    .app({ v : Any ->
       { f : Any ->
        val x = v;
          val f1 = f;
          f1.app(x);}
    });
  @JvmField
  val applicativeFirst = PS.Control.Applicative.Module.Applicative
                           .app({ _ : Any ->
                                PS.Data.Semigroup.First.Module.applyFirst
                             })
                           .app(PS.Data.Semigroup.First.Module.First);
  @JvmField
  val monadFirst = PS.Control.Monad.Module.Monad
                     .app({ _ : Any ->
                          PS.Data.Semigroup.First.Module.applicativeFirst
                       })
                     .app({ _ : Any ->
       PS.Data.Semigroup.First.Module.bindFirst
    });
}