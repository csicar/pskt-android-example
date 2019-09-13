@file:Suppress("UNCHECKED_CAST")

package PS.Control.Comonad.Trans.Class
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val ComonadTrans = { lower : Any -> mapOf(("lower" to lower))};
  @JvmField val lower = { dict : Any -> (dict as Map<String, Any>)["lower"]!!};
}