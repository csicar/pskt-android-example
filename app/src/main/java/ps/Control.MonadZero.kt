@file:Suppress("UNCHECKED_CAST")
package PS.Control.MonadZero
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val MonadZero = { Alternative1 : Any ->
     { Monad0 : Any ->
       mapOf(("Alternative1" to Alternative1),  ("Monad0" to Monad0))
    }
  };
  @JvmField
  val monadZeroArray = PS.Control.MonadZero.Module.MonadZero
                         .app({ _ : Any ->
                              PS.Control.Alternative.Module.alternativeArray
                           })
                         .app({ _ : Any ->
       PS.Control.Monad.Module.monadArray
    });
  @JvmField
  val guard = { dictMonadZero : Any ->
     { v : Any ->
       when {
        (v == true) -> {
          PS.Control.Applicative.Module.pure
            .app(((dictMonadZero as Map<String, Any>)["Alternative1"]!!
                    .app(Unit) as Map<String, Any>)["Applicative0"]!!
                   .app(Unit))
            .app(PS.Data.Unit.Module.unit);
        }
        (v == false) -> {
          PS.Control.Plus.Module.empty
            .app(((dictMonadZero as Map<String, Any>)["Alternative1"]!!
                    .app(Unit) as Map<String, Any>)["Plus1"]!!
                   .app(Unit));
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
}