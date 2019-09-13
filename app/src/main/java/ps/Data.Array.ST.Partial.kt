@file:Suppress("UNCHECKED_CAST")

package PS.Data.Array.ST.Partial
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  val peekImpl = Foreign.Data.Array.ST.Partial.peekImpl;
  val pokeImpl = Foreign.Data.Array.ST.Partial.pokeImpl;
  @JvmField
  val poke = { dictPartial : Any ->
     PS.Data.Array.ST.Partial.Module.pokeImpl
  };
  @JvmField
  val peek = { dictPartial : Any ->
     PS.Data.Array.ST.Partial.Module.peekImpl
  };
}