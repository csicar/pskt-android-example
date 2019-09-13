@file:Suppress("UNCHECKED_CAST")

package PS.Type.Data.RowList
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  sealed class _Type_RLProxy ()  { object RLProxy : _Type_RLProxy() {}; };
  val RLProxy = _Type_RLProxy.RLProxy;
}