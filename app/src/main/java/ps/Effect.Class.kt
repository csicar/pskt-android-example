@file:Suppress("UNCHECKED_CAST")

package PS.Effect.Class
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val MonadEffect = { Monad0 : Any ->
     { liftEffect : Any ->
       mapOf(("Monad0" to Monad0),  ("liftEffect" to liftEffect))
    }
  };
  @JvmField
  val monadEffectEffect = PS.Effect.Class.Module.MonadEffect
                            .app({ _ : Any ->
                                 PS.Effect.Module.monadEffect
                              })
                            .app(PS.Control.Category.Module.identity
                                   .app(PS.Control.Category.Module.categoryFn));
  @JvmField
  val liftEffect = { dict : Any ->
     (dict as Map<String, Any>)["liftEffect"]!!
  };
}