@file:Suppress("UNCHECKED_CAST")
package PS.Record.Unsafe
import Foreign.PsRuntime.app
object Module  {
  val unsafeHas = Foreign.Record.Unsafe.unsafeHas;
  val unsafeGet = Foreign.Record.Unsafe.unsafeGet;
  val unsafeSet = Foreign.Record.Unsafe.unsafeSet;
  val unsafeDelete = Foreign.Record.Unsafe.unsafeDelete;
}