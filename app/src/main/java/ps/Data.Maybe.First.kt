@file:Suppress("UNCHECKED_CAST")

package PS.Data.Maybe.First
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val First = { x : Any -> x};
  @JvmField
  val showFirst = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ v : Any ->
        val a = v;
          (("First (" as String) + (((PS.Data.Show.Module.show
                                        .app(PS.Data.Maybe.Module.showMaybe
                                               .app(dictShow))
                                        .app(a
          ) as String) + (")" as String)) as String));})
  };
  @JvmField
  val semigroupFirst = PS.Data.Semigroup.Module.Semigroup
                         .app({ v : Any ->
       { v1 : Any ->
         when {
          (v is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
            val first = v;
            first;
          }
          else -> {
            val second = v1;
            second;
          }
        }
      }
    });
  @JvmField
  val ordFirst = { dictOrd : Any ->
     PS.Data.Maybe.Module.ordMaybe.app(dictOrd)
  };
  @JvmField val ord1First = PS.Data.Maybe.Module.ord1Maybe;
  @JvmField
  val newtypeFirst = PS.Data.Newtype.Module.Newtype
                       .app({ n : Any ->
                           val a = n;
                             a;})
                       .app(PS.Data.Maybe.First.Module.First);
  @JvmField
  val monoidFirst = PS.Data.Monoid.Module.Monoid
                      .app({ _ : Any ->
                           PS.Data.Maybe.First.Module.semigroupFirst
                        })
                      .app(PS.Data.Maybe.First.Module.First
                             .app(PS.Data.Maybe.Module.Nothing));
  @JvmField val monadFirst = PS.Data.Maybe.Module.monadMaybe;
  @JvmField val invariantFirst = PS.Data.Maybe.Module.invariantMaybe;
  @JvmField val functorFirst = PS.Data.Maybe.Module.functorMaybe;
  @JvmField val extendFirst = PS.Data.Maybe.Module.extendMaybe;
  @JvmField
  val eqFirst = { dictEq : Any ->
     PS.Data.Maybe.Module.eqMaybe.app(dictEq)
  };
  @JvmField val eq1First = PS.Data.Maybe.Module.eq1Maybe;
  @JvmField
  val boundedFirst = { dictBounded : Any ->
     PS.Data.Maybe.Module.boundedMaybe.app(dictBounded)
  };
  @JvmField val bindFirst = PS.Data.Maybe.Module.bindMaybe;
  @JvmField val applyFirst = PS.Data.Maybe.Module.applyMaybe;
  @JvmField val applicativeFirst = PS.Data.Maybe.Module.applicativeMaybe;
  @JvmField
  val altFirst = PS.Control.Alt.Module.Alt
                   .app({ _ : Any ->
                        PS.Data.Maybe.First.Module.functorFirst
                     })
                   .app(PS.Data.Semigroup.Module.append
                          .app(PS.Data.Maybe.First.Module.semigroupFirst));
  @JvmField
  val plusFirst = PS.Control.Plus.Module.Plus
                    .app({ _ : Any ->
                         PS.Data.Maybe.First.Module.altFirst
                      })
                    .app(PS.Data.Monoid.Module.mempty
                           .app(PS.Data.Maybe.First.Module.monoidFirst));
  @JvmField
  val alternativeFirst = PS.Control.Alternative.Module.Alternative
                           .app({ _ : Any ->
                                PS.Data.Maybe.First.Module.applicativeFirst
                             })
                           .app({ _ : Any ->
       PS.Data.Maybe.First.Module.plusFirst
    });
  @JvmField
  val monadZeroFirst = PS.Control.MonadZero.Module.MonadZero
                         .app({ _ : Any ->
                              PS.Data.Maybe.First.Module.alternativeFirst
                           })
                         .app({ _ : Any ->
       PS.Data.Maybe.First.Module.monadFirst
    });
}