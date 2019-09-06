@file:Suppress("UNCHECKED_CAST")
package PS.Global.Unsafe
import Foreign.PsRuntime.app
object Module  {
  val unsafeStringify = Foreign.Global.Unsafe.unsafeStringify;
  val unsafeToFixed = Foreign.Global.Unsafe.unsafeToFixed;
  val unsafeToExponential = Foreign.Global.Unsafe.unsafeToExponential;
  val unsafeToPrecision = Foreign.Global.Unsafe.unsafeToPrecision;
  val unsafeDecodeURI = Foreign.Global.Unsafe.unsafeDecodeURI;
  val unsafeEncodeURI = Foreign.Global.Unsafe.unsafeEncodeURI;
  val unsafeDecodeURIComponent = Foreign.Global.Unsafe.unsafeDecodeURIComponent;
  val unsafeEncodeURIComponent = Foreign.Global.Unsafe.unsafeEncodeURIComponent;
}