@file:Suppress("UNCHECKED_CAST")
package PS.Control.Comonad.Env.Class
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val ComonadAsk = { Comonad0 : Any ->
     { ask : Any ->
       mapOf(("Comonad0" to Comonad0),  ("ask" to ask))
    }
  };
  @JvmField
  val ComonadEnv = { ComonadAsk0 : Any ->
     { local : Any ->
       mapOf(("ComonadAsk0" to ComonadAsk0),  ("local" to local))
    }
  };
  @JvmField val local = { dict : Any -> (dict as Map<String, Any>)["local"]!!};
  @JvmField
  val comonadAskTuple = PS.Control.Comonad.Env.Class.Module.ComonadAsk
                          .app({ _ : Any ->
                               PS.Data.Tuple.Module.comonadTuple
                            })
                          .app(PS.Data.Tuple.Module.fst);
  @JvmField
  val comonadEnvTuple = PS.Control.Comonad.Env.Class.Module.ComonadEnv
                          .app({ _ : Any ->
                               PS.Control.Comonad.Env.Class.Module.comonadAskTuple
                            })
                          .app({ f : Any ->
       { v : Any ->
         when {
          (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
            val f1 = f;
            val x = v.value0;
            val y = v.value1;
            PS.Data.Tuple.Module.Tuple.app(f1.app(x)).app(y);
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val comonadAskEnvT = { dictComonad : Any ->
     PS.Control.Comonad.Env.Class.Module.ComonadAsk
       .app({ _ : Any ->
            PS.Control.Comonad.Env.Trans.Module.comonadEnvT.app(dictComonad)
         })
       .app({ v : Any ->
         when {
          else -> {
            val x = v;
            PS.Data.Tuple.Module.fst.app(x);
          }
        }
      })
  };
  @JvmField
  val comonadEnvEnvT = { dictComonad : Any ->
     PS.Control.Comonad.Env.Class.Module.ComonadEnv
       .app({ _ : Any ->
            PS.Control.Comonad.Env.Class.Module.comonadAskEnvT.app(dictComonad)
         })
       .app({ f : Any ->
         { v : Any ->
           when {
            else -> {
              val f1 = f;
              val x = v;
              PS.Control.Comonad.Env.Trans.Module.EnvT
                .app(when {
                  (x is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                    val y = x.value0;
                    val z = x.value1;
                    PS.Data.Tuple.Module.Tuple.app(f1.app(y)).app(z);
                  }
                  else -> (error("Error in Pattern Match") as Any)
                });
            }
          }
        }
      })
  };
  @JvmField val ask = { dict : Any -> (dict as Map<String, Any>)["ask"]!!};
  @JvmField
  val asks = { dictComonadEnv : Any ->
     { f : Any ->
       { x : Any ->
         f
           .app(PS.Control.Comonad.Env.Class.Module.ask
                  .app((dictComonadEnv as Map<String, Any>)["ComonadAsk0"]!!
                         .app(Unit))
                  .app(x))
      }
    }
  };
}