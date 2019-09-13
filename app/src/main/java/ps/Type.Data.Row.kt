@file:Suppress("UNCHECKED_CAST")

package PS.Type.Data.Row
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  sealed class _Type_RProxy ()  { object RProxy : _Type_RProxy() {}; };
  val RProxy = _Type_RProxy.RProxy;
}