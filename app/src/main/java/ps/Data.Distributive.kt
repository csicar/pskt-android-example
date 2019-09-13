@file:Suppress("UNCHECKED_CAST")

package PS.Data.Distributive
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val Distributive = { Functor0 : Any ->
     { collect : Any ->
       { distribute : Any ->
         mapOf(("Functor0" to Functor0),  ("collect" to collect),  
          ("distribute" to distribute))
      }
    }
  };
  @JvmField
  val distributiveIdentity = PS.Data.Distributive.Module.Distributive
                               .app({ _ : Any ->
                                    PS.Data.Identity.Module.functorIdentity
                                 })
                               .app({ dictFunctor : Any ->
                                    { f : Any ->
                                      PS.Control.Semigroupoid.Module.compose
                                        .app(
                                          PS.Control.Semigroupoid.Module.semigroupoidFn
                                        )
                                        .app(PS.Data.Identity.Module.Identity)
                                        .app(PS.Data.Functor.Module.map
                                               .app(dictFunctor)
                                               .app(
                                         PS.Control.Semigroupoid.Module.compose
                                           .app(
                                             PS.Control.Semigroupoid.Module.semigroupoidFn
                                           )
                                           .app(PS.Data.Newtype.Module.unwrap
                                                  .app(
                                               PS.Data.Identity.Module.newtypeIdentity
                                             ))
                                           .app(f)))
                                   }
                                 })
                               .app({ dictFunctor : Any ->
       PS.Control.Semigroupoid.Module.compose
         .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
         .app(PS.Data.Identity.Module.Identity)
         .app(PS.Data.Functor.Module.map.app(dictFunctor)
                .app(PS.Data.Newtype.Module.unwrap
                       .app(PS.Data.Identity.Module.newtypeIdentity)))
    });
  @JvmField
  val distribute = { dict : Any ->
     (dict as Map<String, Any>)["distribute"]!!
  };
  @JvmField val distributiveFunction = (::__rec_distributiveFunction)();
  fun __rec_distributiveFunction(): Any = PS.Data.Distributive.Module.Distributive
                                            .app({ _ : Any ->
                                                 PS.Data.Functor.Module.functorFn
                                              })
                                            .app({ dictFunctor : Any ->
                                                 { f : Any ->
                                                   PS.Control.Semigroupoid.Module.compose
                                                     .app(
                                                       PS.Control.Semigroupoid.Module.semigroupoidFn
                                                     )
                                                     .app(
                                                       PS.Data.Distributive.Module.distribute
                                                         .app(
                                                           PS.Data.Distributive.Module.distributiveFunction
                                                         )
                                                         .app(dictFunctor))
                                                     .app(
                                                    PS.Data.Functor.Module.map
                                                      .app(dictFunctor)
                                                      .app(f))
                                                }
                                              })
                                            .app({ dictFunctor : Any ->
       { a : Any ->
         { e : Any ->
           PS.Data.Functor.Module.map.app(dictFunctor)
             .app({ v : Any ->
                  PS.Data.Function.Module.apply.app(v).app(e)
               })
             .app(a)
        }
      }
    });
  @JvmField
  val cotraverse = { dictDistributive : Any ->
     { dictFunctor : Any ->
       { f : Any ->
         PS.Control.Semigroupoid.Module.compose
           .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
           .app(PS.Data.Functor.Module.map
                  .app((dictDistributive as Map<String, Any>)["Functor0"]!!
                         .app(Unit))
                  .app(f))
           .app(PS.Data.Distributive.Module.distribute.app(dictDistributive)
                  .app(dictFunctor))
      }
    }
  };
  @JvmField
  val collectDefault = { dictDistributive : Any ->
     { dictFunctor : Any ->
       { f : Any ->
         PS.Control.Semigroupoid.Module.compose
           .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
           .app(PS.Data.Distributive.Module.distribute.app(dictDistributive)
                  .app(dictFunctor))
           .app(PS.Data.Functor.Module.map.app(dictFunctor).app(f))
      }
    }
  };
  @JvmField
  val collect = { dict : Any ->
     (dict as Map<String, Any>)["collect"]!!
  };
  @JvmField
  val distributeDefault = { dictDistributive : Any ->
     { dictFunctor : Any ->
       PS.Data.Distributive.Module.collect.app(dictDistributive)
         .app(dictFunctor)
         .app(PS.Control.Category.Module.identity
                .app(PS.Control.Category.Module.categoryFn))
    }
  };
}