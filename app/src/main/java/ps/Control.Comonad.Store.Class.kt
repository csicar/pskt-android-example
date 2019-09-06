@file:Suppress("UNCHECKED_CAST")
package PS.Control.Comonad.Store.Class
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val ComonadStore = { Comonad0 : Any ->
     { peek : Any ->
       { pos : Any ->
         mapOf(("Comonad0" to Comonad0),  ("peek" to peek),  ("pos" to pos))
      }
    }
  };
  @JvmField val pos = { dict : Any -> (dict as Map<String, Any>)["pos"]!!};
  @JvmField val peek = { dict : Any -> (dict as Map<String, Any>)["peek"]!!};
  @JvmField
  val peeks = { dictComonadStore : Any ->
     { f : Any ->
       { x : Any ->
         PS.Control.Comonad.Store.Class.Module.peek.app(dictComonadStore)
           .app(PS.Data.Function.Module.apply.app(f)
                  .app(PS.Control.Comonad.Store.Class.Module.pos
                         .app(dictComonadStore)
                         .app(x)))
           .app(x)
      }
    }
  };
  @JvmField
  val seeks = { dictComonadStore : Any ->
     { f : Any ->
       PS.Control.Semigroupoid.Module.compose
         .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
         .app(PS.Control.Comonad.Store.Class.Module.peeks.app(dictComonadStore)
                .app(f))
         .app(PS.Control.Extend.Module.duplicate
                .app(((dictComonadStore as Map<String, Any>)["Comonad0"]!!
                        .app(Unit) as Map<String, Any>)["Extend0"]!!
                       .app(Unit)))
    }
  };
  @JvmField
  val seek = { dictComonadStore : Any ->
     { s : Any ->
       PS.Control.Semigroupoid.Module.compose
         .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
         .app(PS.Control.Comonad.Store.Class.Module.peek.app(dictComonadStore)
                .app(s))
         .app(PS.Control.Extend.Module.duplicate
                .app(((dictComonadStore as Map<String, Any>)["Comonad0"]!!
                        .app(Unit) as Map<String, Any>)["Extend0"]!!
                       .app(Unit)))
    }
  };
  @JvmField
  val experiment = { dictComonadStore : Any ->
     { dictFunctor : Any ->
       { f : Any ->
         { x : Any ->
           PS.Data.Functor.Module.map.app(dictFunctor)
             .app(PS.Data.Function.Module.flip
                    .app(PS.Control.Comonad.Store.Class.Module.peek
                           .app(dictComonadStore))
                    .app(x))
             .app(f
                    .app(PS.Control.Comonad.Store.Class.Module.pos
                           .app(dictComonadStore)
                           .app(x)))
        }
      }
    }
  };
  @JvmField
  val comonadStoreTracedT = { dictComonadStore : Any ->
     { dictMonoid : Any ->
       PS.Control.Comonad.Store.Class.Module.ComonadStore
         .app({ _ : Any ->
              PS.Control.Comonad.Traced.Trans.Module.comonadTracedT
                .app((dictComonadStore as Map<String, Any>)["Comonad0"]!!
                       .app(Unit))
                .app(dictMonoid)
           })
         .app({ s : Any ->
              PS.Control.Semigroupoid.Module.compose
                .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                .app(PS.Control.Comonad.Store.Class.Module.peek
                       .app(dictComonadStore)
                       .app(s))
                .app(PS.Control.Comonad.Trans.Class.Module.lower
                       .app(
                         PS.Control.Comonad.Traced.Trans.Module.comonadTransTracedT
                           .app(dictMonoid))
                       .app((dictComonadStore as Map<String, Any>)["Comonad0"]!!
                              .app(Unit)))
           })
         .app(PS.Control.Semigroupoid.Module.compose
                .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                .app(PS.Control.Comonad.Store.Class.Module.pos
                       .app(dictComonadStore))
                .app(PS.Control.Comonad.Trans.Class.Module.lower
                       .app(
                         PS.Control.Comonad.Traced.Trans.Module.comonadTransTracedT
                           .app(dictMonoid))
                       .app((dictComonadStore as Map<String, Any>)["Comonad0"]!!
                              .app(Unit))))
    }
  };
  @JvmField
  val comonadStoreStoreT = { dictComonad : Any ->
     PS.Control.Comonad.Store.Class.Module.ComonadStore
       .app({ _ : Any ->
            PS.Control.Comonad.Store.Trans.Module.comonadStoreT.app(dictComonad)
         })
       .app({ s : Any ->
            { v : Any ->
              when {
               (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                 val s1 = s;
                 val f = v.value0;
                 PS.Control.Comonad.Module.extract.app(dictComonad).app(f)
                   .app(s1);
               }
               else -> (error("Error in Pattern Match") as Any)
             }
           }
         })
       .app({ v : Any ->
         when {
          (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
            val f = v.value0;
            val s = v.value1;
            s;
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      })
  };
  @JvmField
  val comonadStoreEnvT = { dictComonadStore : Any ->
     PS.Control.Comonad.Store.Class.Module.ComonadStore
       .app({ _ : Any ->
            PS.Control.Comonad.Env.Trans.Module.comonadEnvT
              .app((dictComonadStore as Map<String, Any>)["Comonad0"]!!
                     .app(Unit))
         })
       .app({ s : Any ->
            PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Control.Comonad.Store.Class.Module.peek
                     .app(dictComonadStore)
                     .app(s))
              .app(PS.Control.Comonad.Trans.Class.Module.lower
                     .app(PS.Control.Comonad.Env.Trans.Module.comonadTransEnvT)
                     .app((dictComonadStore as Map<String, Any>)["Comonad0"]!!
                            .app(Unit)))
         })
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Control.Comonad.Store.Class.Module.pos
                     .app(dictComonadStore))
              .app(PS.Control.Comonad.Trans.Class.Module.lower
                     .app(PS.Control.Comonad.Env.Trans.Module.comonadTransEnvT)
                     .app((dictComonadStore as Map<String, Any>)["Comonad0"]!!
                            .app(Unit))))
  };
}