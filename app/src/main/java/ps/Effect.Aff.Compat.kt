@file:Suppress("UNCHECKED_CAST")

package PS.Effect.Aff.Compat
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val EffectFnCanceler = { x : Any -> x};
  @JvmField val EffectFnAff = { x : Any -> x};
  @JvmField
  val fromEffectFnAff = { v : Any ->
    val eff = v;
      PS.Effect.Aff.Module.makeAff
        .app({ k : Any ->
           /* defer **/{
            val v1 = PS.Effect.Uncurried.Module.runEffectFn2.app(eff)
                       .app(PS.Effect.Uncurried.Module.mkEffectFn1
                              .app(PS.Control.Semigroupoid.Module.compose
                                     .app(
                                       PS.Control.Semigroupoid.Module.semigroupoidFn
                                     )
                                     .app(k)
                                     .app(PS.Data.Either.Module.Left)))
                       .app(PS.Effect.Uncurried.Module.mkEffectFn1
                              .app(PS.Control.Semigroupoid.Module.compose
                                     .app(
                                       PS.Control.Semigroupoid.Module.semigroupoidFn
                                     )
                                     .app(k)
                                     .app(PS.Data.Either.Module.Right)))
                       .appRun();
            val canceler = v1;
            PS.Data.Function.Module.apply
              .app(PS.Control.Applicative.Module.pure
                     .app(PS.Effect.Module.applicativeEffect))
              .app(PS.Effect.Aff.Module.Canceler
                     .app({ e : Any ->
                     PS.Effect.Aff.Module.makeAff
                       .app({ k2 : Any ->
                         /* defer **/{
                          PS.Effect.Uncurried.Module.runEffectFn3.app(canceler)
                            .app(e)
                            .app(PS.Effect.Uncurried.Module.mkEffectFn1
                                   .app(PS.Control.Semigroupoid.Module.compose
                                          .app(
                                            PS.Control.Semigroupoid.Module.semigroupoidFn
                                          )
                                          .app(k2)
                                          .app(PS.Data.Either.Module.Left)))
                            .app(PS.Effect.Uncurried.Module.mkEffectFn1
                                   .app(PS.Control.Semigroupoid.Module.compose
                                          .app(
                                            PS.Control.Semigroupoid.Module.semigroupoidFn
                                          )
                                          .app(k2)
                                          .app(PS.Data.Either.Module.Right)))
                            .appRun();
                          PS.Effect.Aff.Module.nonCanceler;
                        }
                      })
                  }))
              .appRun();
          }
        });};
}