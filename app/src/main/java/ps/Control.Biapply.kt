@file:Suppress("UNCHECKED_CAST")
package PS.Control.Biapply
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val Biapply = { Bifunctor0 : Any ->
     { biapply : Any ->
       mapOf(("Bifunctor0" to Bifunctor0),  ("biapply" to biapply))
    }
  };
  @JvmField
  val biapply = { dict : Any ->
     (dict as Map<String, Any>)["biapply"]!!
  };
  @JvmField
  val biapplyFirst = { dictBiapply : Any ->
     { a : Any ->
       { b : Any ->
         PS.Control.Biapply.Module.biapply.app(dictBiapply)
           .app(PS.Control.Category.Module.identity
                  .app(PS.Control.Category.Module.categoryFn)
                  .app(PS.Data.Bifunctor.Module.bimap
                         .app((dictBiapply as Map<String, Any>)["Bifunctor0"]!!
                                .app(Unit))
                         .app(PS.Data.Function.Module._const
                                .app(PS.Control.Category.Module.identity
                                       .app(
                               PS.Control.Category.Module.categoryFn)))
                         .app(PS.Data.Function.Module._const
                                .app(PS.Control.Category.Module.identity
                                       .app(
                          PS.Control.Category.Module.categoryFn))))
                  .app(a))
           .app(b)
      }
    }
  };
  @JvmField
  val biapplySecond = { dictBiapply : Any ->
     { a : Any ->
       { b : Any ->
         PS.Control.Biapply.Module.biapply.app(dictBiapply)
           .app(PS.Control.Category.Module.identity
                  .app(PS.Control.Category.Module.categoryFn)
                  .app(PS.Data.Bifunctor.Module.bimap
                         .app((dictBiapply as Map<String, Any>)["Bifunctor0"]!!
                                .app(Unit))
                         .app(PS.Data.Function.Module._const)
                         .app(PS.Data.Function.Module._const))
                  .app(a))
           .app(b)
      }
    }
  };
  @JvmField
  val bilift2 = { dictBiapply : Any ->
     { f : Any ->
       { g : Any ->
         { a : Any ->
           { b : Any ->
             PS.Control.Biapply.Module.biapply.app(dictBiapply)
               .app(PS.Control.Category.Module.identity
                      .app(PS.Control.Category.Module.categoryFn)
                      .app(PS.Data.Bifunctor.Module.bimap
                             .app(
                               (dictBiapply as Map<String, Any>)["Bifunctor0"]!!
                                 .app(Unit))
                             .app(f)
                             .app(g))
                      .app(a))
               .app(b)
          }
        }
      }
    }
  };
  @JvmField
  val bilift3 = { dictBiapply : Any ->
     { f : Any ->
       { g : Any ->
         { a : Any ->
           { b : Any ->
             { c : Any ->
               PS.Control.Biapply.Module.biapply.app(dictBiapply)
                 .app(PS.Control.Biapply.Module.biapply.app(dictBiapply)
                        .app(PS.Control.Category.Module.identity
                               .app(PS.Control.Category.Module.categoryFn)
                               .app(PS.Data.Bifunctor.Module.bimap
                                      .app(
                                        (dictBiapply as Map<String, Any>)["Bifunctor0"]!!
                                          .app(Unit))
                                      .app(f)
                                      .app(g))
                               .app(a))
                        .app(b))
                 .app(c)
            }
          }
        }
      }
    }
  };
}