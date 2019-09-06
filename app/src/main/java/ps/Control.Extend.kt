@file:Suppress("UNCHECKED_CAST")
package PS.Control.Extend
import Foreign.PsRuntime.app
object Module  {
  val arrayExtend = Foreign.Control.Extend.arrayExtend;
  @JvmField
  val Extend = { Functor0 : Any ->
     { extend : Any ->
       mapOf(("Functor0" to Functor0),  ("extend" to extend))
    }
  };
  @JvmField
  val extendFn = { dictSemigroup : Any ->
     PS.Control.Extend.Module.Extend
       .app({ _ : Any ->
            PS.Data.Functor.Module.functorFn
         })
       .app({ f : Any ->
         { g : Any ->
           { w : Any ->
             f
               .app({ w_tick : Any ->
                 g
                   .app(PS.Data.Semigroup.Module.append.app(dictSemigroup)
                          .app(w)
                          .app(w_tick))
              })
          }
        }
      })
  };
  @JvmField
  val extendArray = PS.Control.Extend.Module.Extend
                      .app({ _ : Any ->
                           PS.Data.Functor.Module.functorArray
                        })
                      .app(PS.Control.Extend.Module.arrayExtend);
  @JvmField
  val extend = { dict : Any ->
     (dict as Map<String, Any>)["extend"]!!
  };
  @JvmField
  val extendFlipped = { dictExtend : Any ->
     { w : Any ->
       { f : Any ->
         PS.Control.Extend.Module.extend.app(dictExtend).app(f).app(w)
      }
    }
  };
  @JvmField
  val duplicate = { dictExtend : Any ->
     PS.Control.Extend.Module.extend.app(dictExtend)
       .app(PS.Control.Category.Module.identity
              .app(PS.Control.Category.Module.categoryFn))
  };
  @JvmField
  val composeCoKleisliFlipped = { dictExtend : Any ->
     { f : Any ->
       { g : Any ->
         { w : Any ->
           f.app(PS.Control.Extend.Module.extend.app(dictExtend).app(g).app(w))
        }
      }
    }
  };
  @JvmField
  val composeCoKleisli = { dictExtend : Any ->
     { f : Any ->
       { g : Any ->
         { w : Any ->
           g.app(PS.Control.Extend.Module.extend.app(dictExtend).app(f).app(w))
        }
      }
    }
  };
}