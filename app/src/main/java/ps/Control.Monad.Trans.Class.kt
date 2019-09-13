@file:Suppress("UNCHECKED_CAST")

package PS.Control.Monad.Trans.Class
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val MonadTrans = { lift : Any -> mapOf(("lift" to lift))};
  @JvmField val lift = { dict : Any -> (dict as Map<String, Any>)["lift"]!!};
}