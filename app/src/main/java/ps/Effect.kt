@file:Suppress("UNCHECKED_CAST")

package PS.Effect
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  val pureE = Foreign.Effect.pureE;
  val bindE = Foreign.Effect.bindE;
  val untilE = Foreign.Effect.untilE;
  val whileE = Foreign.Effect.whileE;
  val forE = Foreign.Effect.forE;
  val foreachE = Foreign.Effect.foreachE;
  @JvmField val monadEffect = (::__rec_monadEffect)();
  @JvmField val bindEffect = (::__rec_bindEffect)();
  @JvmField val applyEffect = (::__rec_applyEffect)();
  @JvmField val applicativeEffect = (::__rec_applicativeEffect)();
  @JvmField val functorEffect = (::__rec_functorEffect)();
  fun __rec_monadEffect(): Any = PS.Control.Monad.Module.Monad
                                   .app({ _ : Any ->
                                        PS.Effect.Module.applicativeEffect
                                     })
                                   .app({ _ : Any ->
       PS.Effect.Module.bindEffect
    });
  fun __rec_bindEffect(): Any = PS.Control.Bind.Module.Bind
                                  .app({ _ : Any ->
                                       PS.Effect.Module.applyEffect
                                    })
                                  .app(PS.Effect.Module.bindE);
  fun __rec_applyEffect(): Any = PS.Control.Apply.Module.Apply
                                   .app({ _ : Any ->
                                        PS.Effect.Module.functorEffect
                                     })
                                   .app(PS.Control.Monad.Module.ap
                                          .app(PS.Effect.Module.monadEffect));
  fun __rec_applicativeEffect(): Any = PS.Control.Applicative.Module.Applicative
                                         .app({ _ : Any ->
                                              PS.Effect.Module.applyEffect
                                           })
                                         .app(PS.Effect.Module.pureE);
  fun __rec_functorEffect(): Any = PS.Data.Functor.Module.Functor
                                     .app(PS.Control.Applicative.Module.liftA1
                                            .app(
      PS.Effect.Module.applicativeEffect));
  @JvmField
  val semigroupEffect = { dictSemigroup : Any ->
     PS.Data.Semigroup.Module.Semigroup
       .app(PS.Control.Apply.Module.lift2.app(PS.Effect.Module.applyEffect)
              .app(PS.Data.Semigroup.Module.append.app(dictSemigroup)))
  };
  @JvmField
  val monoidEffect = { dictMonoid : Any ->
     PS.Data.Monoid.Module.Monoid
       .app({ _ : Any ->
            PS.Effect.Module.semigroupEffect
              .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!.app(Unit))
         })
       .app(PS.Effect.Module.pureE
              .app(PS.Data.Monoid.Module.mempty.app(dictMonoid)))
  };
}