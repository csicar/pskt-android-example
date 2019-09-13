@file:Suppress("UNCHECKED_CAST")

package PS.Control.Bind
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  val arrayBind = Foreign.Control.Bind.arrayBind;
  @JvmField val Discard = { discard : Any -> mapOf(("discard" to discard))};
  @JvmField
  val Bind = { Apply0 : Any ->
     { bind : Any ->
       mapOf(("Apply0" to Apply0),  ("bind" to bind))
    }
  };
  @JvmField
  val discard = { dict : Any ->
     (dict as Map<String, Any>)["discard"]!!
  };
  @JvmField
  val bindFn = PS.Control.Bind.Module.Bind
                 .app({ _ : Any ->
                      PS.Control.Apply.Module.applyFn
                   })
                 .app({ m : Any ->
       { f : Any ->
         { x : Any ->
           f.app(m.app(x)).app(x)
        }
      }
    });
  @JvmField
  val bindArray = PS.Control.Bind.Module.Bind
                    .app({ _ : Any ->
                         PS.Control.Apply.Module.applyArray
                      })
                    .app(PS.Control.Bind.Module.arrayBind);
  @JvmField val bind = { dict : Any -> (dict as Map<String, Any>)["bind"]!!};
  @JvmField
  val bindFlipped = { dictBind : Any ->
     PS.Data.Function.Module.flip.app(PS.Control.Bind.Module.bind.app(dictBind))
  };
  @JvmField
  val composeKleisliFlipped = { dictBind : Any ->
     { f : Any ->
       { g : Any ->
         { a : Any ->
           PS.Control.Bind.Module.bindFlipped.app(dictBind).app(f).app(g.app(a))
        }
      }
    }
  };
  @JvmField
  val composeKleisli = { dictBind : Any ->
     { f : Any ->
       { g : Any ->
         { a : Any ->
           PS.Control.Bind.Module.bind.app(dictBind).app(f.app(a)).app(g)
        }
      }
    }
  };
  @JvmField
  val discardUnit = PS.Control.Bind.Module.Discard
                      .app({ dictBind : Any ->
       PS.Control.Bind.Module.bind.app(dictBind)
    });
  @JvmField
  val ifM = { dictBind : Any ->
     { cond : Any ->
       { t : Any ->
         { f : Any ->
           PS.Control.Bind.Module.bind.app(dictBind).app(cond)
             .app({ cond_tick : Any ->
               when {
                (cond_tick == true) -> {
                  t;
                }
                else -> {
                  f;
                }
              }
            })
        }
      }
    }
  };
  @JvmField
  val join = { dictBind : Any ->
     { m : Any ->
       PS.Control.Bind.Module.bind.app(dictBind).app(m)
         .app(PS.Control.Category.Module.identity
                .app(PS.Control.Category.Module.categoryFn))
    }
  };
}