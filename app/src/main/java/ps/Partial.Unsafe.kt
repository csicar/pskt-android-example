@file:Suppress("UNCHECKED_CAST")

package PS.Partial.Unsafe
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  val unsafePartial = Foreign.Partial.Unsafe.unsafePartial;
  @JvmField
  val unsafePartialBecause = { v : Any ->
     { x : Any ->
       PS.Partial.Unsafe.Module.unsafePartial
         .app({ dictPartial : Any ->
           x.app(Unit)
        })
    }
  };
  @JvmField
  val unsafeCrashWith = { msg : Any ->
     PS.Partial.Unsafe.Module.unsafePartial
       .app({ dictPartial : Any ->
         PS.Partial.Module.crashWith.app(Unit).app(msg)
      })
  };
}