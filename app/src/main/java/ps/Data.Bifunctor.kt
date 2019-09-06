@file:Suppress("UNCHECKED_CAST")
package PS.Data.Bifunctor
import Foreign.PsRuntime.app
object Module  {
  @JvmField val Bifunctor = { bimap : Any -> mapOf(("bimap" to bimap))};
  @JvmField val bimap = { dict : Any -> (dict as Map<String, Any>)["bimap"]!!};
  @JvmField
  val lmap = { dictBifunctor : Any ->
     { f : Any ->
       PS.Data.Bifunctor.Module.bimap.app(dictBifunctor).app(f)
         .app(PS.Control.Category.Module.identity
                .app(PS.Control.Category.Module.categoryFn))
    }
  };
  @JvmField
  val rmap = { dictBifunctor : Any ->
     PS.Data.Bifunctor.Module.bimap.app(dictBifunctor)
       .app(PS.Control.Category.Module.identity
              .app(PS.Control.Category.Module.categoryFn))
  };
}