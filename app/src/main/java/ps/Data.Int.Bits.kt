@file:Suppress("UNCHECKED_CAST")

package PS.Data.Int.Bits
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  val and = Foreign.Data.Int.Bits.and;
  val or = Foreign.Data.Int.Bits.or;
  val xor = Foreign.Data.Int.Bits.xor;
  val shl = Foreign.Data.Int.Bits.shl;
  val shr = Foreign.Data.Int.Bits.shr;
  val zshr = Foreign.Data.Int.Bits.zshr;
  val complement = Foreign.Data.Int.Bits.complement;
}