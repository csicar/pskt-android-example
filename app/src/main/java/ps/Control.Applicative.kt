@file:Suppress("UNCHECKED_CAST")

package PS.Control.Applicative
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val Applicative = { Apply0 : Any ->
     { pure : Any ->
       mapOf(("Apply0" to Apply0),  ("pure" to pure))
    }
  };
  @JvmField val pure = { dict : Any -> (dict as Map<String, Any>)["pure"]!!};
  @JvmField
  val unless = { dictApplicative : Any ->
     { v : Any ->
       { v1 : Any ->
         when {
          (v == false) -> {
            val m = v1;
            m;
          }
          (v == true) -> {
            PS.Control.Applicative.Module.pure.app(dictApplicative)
              .app(PS.Data.Unit.Module.unit);
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    }
  };
  @JvmField
  val _when = { dictApplicative : Any ->
     { v : Any ->
       { v1 : Any ->
         when {
          (v == true) -> {
            val m = v1;
            m;
          }
          (v == false) -> {
            PS.Control.Applicative.Module.pure.app(dictApplicative)
              .app(PS.Data.Unit.Module.unit);
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    }
  };
  @JvmField
  val liftA1 = { dictApplicative : Any ->
     { f : Any ->
       { a : Any ->
         PS.Control.Apply.Module.apply
           .app((dictApplicative as Map<String, Any>)["Apply0"]!!.app(Unit))
           .app(PS.Control.Applicative.Module.pure.app(dictApplicative).app(f))
           .app(a)
      }
    }
  };
  @JvmField
  val applicativeFn = PS.Control.Applicative.Module.Applicative
                        .app({ _ : Any ->
                             PS.Control.Apply.Module.applyFn
                          })
                        .app({ x : Any ->
       { v : Any ->
         x
      }
    });
  @JvmField
  val applicativeArray = PS.Control.Applicative.Module.Applicative
                           .app({ _ : Any ->
                                PS.Control.Apply.Module.applyArray
                             })
                           .app({ x : Any ->
       listOf(x)
    });
}