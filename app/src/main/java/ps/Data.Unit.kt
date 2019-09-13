@file:Suppress("UNCHECKED_CAST")

package PS.Data.Unit
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  val unit = Foreign.Data.Unit.unit;
  @JvmField val showUnit = PS.Data.Show.Module.Show.app({ v : Any -> "unit"});
}