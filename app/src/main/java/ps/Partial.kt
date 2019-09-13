@file:Suppress("UNCHECKED_CAST")

package PS.Partial
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  val crashWith = Foreign.Partial.crashWith;
  @JvmField
  val crash = { dictPartial : Any ->
     PS.Partial.Module.crashWith.app(Unit)
       .app("Partial.crash: partial function")
  };
}