@file:Suppress("UNCHECKED_CAST")

package PS.Android.IO
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  val __httpGet = Foreign.Android.IO.__httpGet;
  @JvmField
  val httpGet = PS.Effect.Uncurried.Module.runEffectFn3
                  .app(PS.Android.IO.Module.__httpGet);
}