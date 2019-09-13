@file:Suppress("UNCHECKED_CAST")

package PS.Effect.Unsafe
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  val unsafePerformEffect = Foreign.Effect.Unsafe.unsafePerformEffect;
}