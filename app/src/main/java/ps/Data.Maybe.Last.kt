@file:Suppress("UNCHECKED_CAST")
package PS.Data.Maybe.Last
import Foreign.PsRuntime.app
object Module  {
  @JvmField val Last = { x : Any -> x};
  @JvmField
  val showLast = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ v : Any ->
         when {
          else -> {
            val a = v;
            (("(Last " as String) + (((PS.Data.Show.Module.show
                                         .app(PS.Data.Maybe.Module.showMaybe
                                                .app(dictShow))
                                         .app(a
            ) as String) + (")" as String)) as String));
          }
        }
      })
  };
  @JvmField
  val semigroupLast = PS.Data.Semigroup.Module.Semigroup
                        .app({ v : Any ->
       { v1 : Any ->
         when {
          (v1 is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
            val last = v1;
            last;
          }
          (v1 is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
            val last = v;
            last;
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val ordLast = { dictOrd : Any ->
     PS.Data.Maybe.Module.ordMaybe.app(dictOrd)
  };
  @JvmField val ord1Last = PS.Data.Maybe.Module.ord1Maybe;
  @JvmField
  val newtypeLast = PS.Data.Newtype.Module.Newtype
                      .app({ n : Any ->
                           when {
                            else -> {
                              val a = n;
                              a;
                            }
                          }
                        })
                      .app(PS.Data.Maybe.Last.Module.Last);
  @JvmField
  val monoidLast = PS.Data.Monoid.Module.Monoid
                     .app({ _ : Any ->
                          PS.Data.Maybe.Last.Module.semigroupLast
                       })
                     .app(PS.Data.Maybe.Last.Module.Last
                            .app(PS.Data.Maybe.Module.Nothing));
  @JvmField val monadLast = PS.Data.Maybe.Module.monadMaybe;
  @JvmField val invariantLast = PS.Data.Maybe.Module.invariantMaybe;
  @JvmField val functorLast = PS.Data.Maybe.Module.functorMaybe;
  @JvmField val extendLast = PS.Data.Maybe.Module.extendMaybe;
  @JvmField
  val eqLast = { dictEq : Any ->
     PS.Data.Maybe.Module.eqMaybe.app(dictEq)
  };
  @JvmField val eq1Last = PS.Data.Maybe.Module.eq1Maybe;
  @JvmField
  val boundedLast = { dictBounded : Any ->
     PS.Data.Maybe.Module.boundedMaybe.app(dictBounded)
  };
  @JvmField val bindLast = PS.Data.Maybe.Module.bindMaybe;
  @JvmField val applyLast = PS.Data.Maybe.Module.applyMaybe;
  @JvmField val applicativeLast = PS.Data.Maybe.Module.applicativeMaybe;
  @JvmField
  val altLast = PS.Control.Alt.Module.Alt
                  .app({ _ : Any ->
                       PS.Data.Maybe.Last.Module.functorLast
                    })
                  .app(PS.Data.Semigroup.Module.append
                         .app(PS.Data.Maybe.Last.Module.semigroupLast));
  @JvmField
  val plusLast = PS.Control.Plus.Module.Plus
                   .app({ _ : Any ->
                        PS.Data.Maybe.Last.Module.altLast
                     })
                   .app(PS.Data.Monoid.Module.mempty
                          .app(PS.Data.Maybe.Last.Module.monoidLast));
  @JvmField
  val alternativeLast = PS.Control.Alternative.Module.Alternative
                          .app({ _ : Any ->
                               PS.Data.Maybe.Last.Module.applicativeLast
                            })
                          .app({ _ : Any ->
       PS.Data.Maybe.Last.Module.plusLast
    });
  @JvmField
  val monadZeroLast = PS.Control.MonadZero.Module.MonadZero
                        .app({ _ : Any ->
                             PS.Data.Maybe.Last.Module.alternativeLast
                          })
                        .app({ _ : Any ->
       PS.Data.Maybe.Last.Module.monadLast
    });
}