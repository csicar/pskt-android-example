@file:Suppress("UNCHECKED_CAST")

package PS.Control.MonadPlus
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val MonadPlus = { MonadZero0 : Any ->
     mapOf(("MonadZero0" to MonadZero0))
  };
  @JvmField
  val monadPlusArray = PS.Control.MonadPlus.Module.MonadPlus
                         .app({ _ : Any ->
       PS.Control.MonadZero.Module.monadZeroArray
    });
}