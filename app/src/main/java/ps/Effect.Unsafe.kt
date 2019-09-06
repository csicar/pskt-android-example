@file:Suppress("UNCHECKED_CAST")
package PS.Effect.Unsafe
import Foreign.PsRuntime.app
object Module  {
  val unsafePerformEffect = Foreign.Effect.Unsafe.unsafePerformEffect;
}