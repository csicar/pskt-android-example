@file:Suppress("UNCHECKED_CAST")
package PS.Effect.Exception.Unsafe
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val unsafeThrowException = PS.Control.Semigroupoid.Module.compose
                               .app(
                                 PS.Control.Semigroupoid.Module.semigroupoidFn)
                               .app(PS.Effect.Unsafe.Module.unsafePerformEffect)
                               .app(PS.Effect.Exception.Module.throwException);
  @JvmField
  val unsafeThrow = PS.Control.Semigroupoid.Module.compose
                      .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                      .app(
                        PS.Effect.Exception.Unsafe.Module.unsafeThrowException)
                      .app(PS.Effect.Exception.Module.error);
}