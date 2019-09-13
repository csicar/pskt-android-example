@file:Suppress("UNCHECKED_CAST")

package PS.Data.Ord.Unsafe
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  val unsafeCompareImpl = Foreign.Data.Ord.Unsafe.unsafeCompareImpl;
  @JvmField
  val unsafeCompare = { dictWarn : Any ->
     PS.Data.Ord.Unsafe.Module.unsafeCompareImpl.app(PS.Data.Ordering.Module.LT)
       .app(PS.Data.Ordering.Module.EQ)
       .app(PS.Data.Ordering.Module.GT)
  };
}