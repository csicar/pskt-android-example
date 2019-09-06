@file:Suppress("UNCHECKED_CAST")
package PS.Control.Monad.Gen.Common
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val genTuple = { dictApply : Any ->
     PS.Control.Apply.Module.lift2.app(dictApply)
       .app(PS.Data.Tuple.Module.Tuple)
  };
  @JvmField
  val genNonEmpty = { dictMonadRec : Any ->
     { dictMonadGen : Any ->
       { dictUnfoldable : Any ->
         { gen : Any ->
           PS.Control.Apply.Module.apply
             .app((((dictMonadGen as Map<String, Any>)["Monad0"]!!
                      .app(Unit) as Map<String, Any>)["Bind1"]!!
                     .app(Unit) as Map<String, Any>)["Apply0"]!!
                    .app(Unit))
             .app(PS.Data.Functor.Module.map
                    .app(((((dictMonadGen as Map<String, Any>)["Monad0"]!!
                              .app(Unit) as Map<String, Any>)["Bind1"]!!
                             .app(Unit) as Map<String, Any>)["Apply0"]!!
                            .app(Unit) as Map<String, Any>)["Functor0"]!!
                           .app(Unit))
                    .app(PS.Data.NonEmpty.Module.NonEmpty)
                    .app(gen))
             .app(PS.Control.Monad.Gen.Class.Module.resize.app(dictMonadGen)
                    .app(PS.Control.Semigroupoid.Module.compose
                           .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                           .app(PS.Data.Ord.Module.max
                                  .app(PS.Data.Ord.Module.ordInt)
                                  .app(0))
                           .app({ v : Any ->
                           PS.Data.Ring.Module.sub
                             .app(PS.Data.Ring.Module.ringInt)
                             .app(v)
                             .app(1)
                        }))
                    .app(PS.Control.Monad.Gen.Module.unfoldable
                           .app(dictMonadRec)
                           .app(dictMonadGen)
                           .app(dictUnfoldable)
                           .app(gen)))
        }
      }
    }
  };
  @JvmField
  val genMaybe_tick = { dictMonadGen : Any ->
     { bias : Any ->
       { gen : Any ->
         PS.Control.Bind.Module.bind
           .app(((dictMonadGen as Map<String, Any>)["Monad0"]!!
                   .app(Unit) as Map<String, Any>)["Bind1"]!!
                  .app(Unit))
           .app(PS.Control.Monad.Gen.Class.Module.chooseFloat.app(dictMonadGen)
                  .app(0.0)
                  .app(1.0))
           .app({ v : Any ->
             when {
              else -> {
                val n = v;
                when {
                  (PS.Data.Ord.Module.lessThan.app(PS.Data.Ord.Module.ordNumber)
                     .app(n)
                     .app(bias) == true) -> {
                    PS.Data.Functor.Module.map
                      .app(((((dictMonadGen as Map<String, Any>)["Monad0"]!!
                                .app(Unit) as Map<String, Any>)["Bind1"]!!
                               .app(Unit) as Map<String, Any>)["Apply0"]!!
                              .app(Unit) as Map<String, Any>)["Functor0"]!!
                             .app(Unit))
                      .app(PS.Data.Maybe.Module.Just)
                      .app(gen);
                  }
                  else -> {
                    PS.Control.Applicative.Module.pure
                      .app(((dictMonadGen as Map<String, Any>)["Monad0"]!!
                              .app(Unit) as Map<String, Any>)["Applicative0"]!!
                             .app(Unit))
                      .app(PS.Data.Maybe.Module.Nothing);
                  }
                };
              }
            }
          })
      }
    }
  };
  @JvmField
  val genMaybe = { dictMonadGen : Any ->
     PS.Control.Monad.Gen.Common.Module.genMaybe_tick.app(dictMonadGen)
       .app(0.75)
  };
  @JvmField
  val genIdentity = { dictFunctor : Any ->
     PS.Data.Functor.Module.map.app(dictFunctor)
       .app(PS.Data.Identity.Module.Identity)
  };
  @JvmField
  val genEither_tick = { dictMonadGen : Any ->
     { bias : Any ->
       { genA : Any ->
         { genB : Any ->
           PS.Control.Bind.Module.bind
             .app(((dictMonadGen as Map<String, Any>)["Monad0"]!!
                     .app(Unit) as Map<String, Any>)["Bind1"]!!
                    .app(Unit))
             .app(PS.Control.Monad.Gen.Class.Module.chooseFloat
                    .app(dictMonadGen)
                    .app(0.0)
                    .app(1.0))
             .app({ v : Any ->
               when {
                else -> {
                  val n = v;
                  when {
                    (PS.Data.Ord.Module.lessThan
                       .app(PS.Data.Ord.Module.ordNumber)
                       .app(n)
                       .app(bias) == true) -> {
                      PS.Data.Functor.Module.map
                        .app(((((dictMonadGen as Map<String, Any>)["Monad0"]!!
                                  .app(Unit) as Map<String, Any>)["Bind1"]!!
                                 .app(Unit) as Map<String, Any>)["Apply0"]!!
                                .app(Unit) as Map<String, Any>)["Functor0"]!!
                               .app(Unit))
                        .app(PS.Data.Either.Module.Left)
                        .app(genA);
                    }
                    else -> {
                      PS.Data.Functor.Module.map
                        .app(((((dictMonadGen as Map<String, Any>)["Monad0"]!!
                                  .app(Unit) as Map<String, Any>)["Bind1"]!!
                                 .app(Unit) as Map<String, Any>)["Apply0"]!!
                                .app(Unit) as Map<String, Any>)["Functor0"]!!
                               .app(Unit))
                        .app(PS.Data.Either.Module.Right)
                        .app(genB);
                    }
                  };
                }
              }
            })
        }
      }
    }
  };
  @JvmField
  val genEither = { dictMonadGen : Any ->
     PS.Control.Monad.Gen.Common.Module.genEither_tick.app(dictMonadGen)
       .app(0.5)
  };
}