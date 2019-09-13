@file:Suppress("UNCHECKED_CAST")

package PS.Data.Symbol
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  val unsafeCoerce = Foreign.Data.Symbol.unsafeCoerce;
  sealed class _Type_SProxy ()  { object SProxy : _Type_SProxy() {}; };
  val SProxy = _Type_SProxy.SProxy;
  @JvmField
  val IsSymbol = { reflectSymbol : Any ->
     mapOf(("reflectSymbol" to reflectSymbol))
  };
  @JvmField
  val reifySymbol = { s : Any ->
     { f : Any ->
       object   {
           val coerce = PS.Data.Symbol.Module.unsafeCoerce;
         }
         .run({
          val coerce = this.coerce;
          coerce.app({ dictIsSymbol : Any -> f.app(dictIsSymbol)})
            .app(mapOf(("reflectSymbol" to { v : Any -> s})))
            .app(PS.Data.Symbol.Module.SProxy);
        })
    }
  };
  @JvmField
  val reflectSymbol = { dict : Any ->
     (dict as Map<String, Any>)["reflectSymbol"]!!
  };
}