@file:Suppress("UNCHECKED_CAST")

package PS.Data.Functor.Contravariant
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val Contravariant = { cmap : Any -> mapOf(("cmap" to cmap))};
  @JvmField val cmap = { dict : Any -> (dict as Map<String, Any>)["cmap"]!!};
  @JvmField
  val cmapFlipped = { dictContravariant : Any ->
     { x : Any ->
       { f : Any ->
         PS.Data.Functor.Contravariant.Module.cmap.app(dictContravariant).app(f)
           .app(x)
      }
    }
  };
  @JvmField
  val coerce = { dictContravariant : Any ->
     { dictFunctor : Any ->
       { a : Any ->
         PS.Data.Functor.Module.map.app(dictFunctor)
           .app(PS.Data.Void.Module.absurd)
           .app(PS.Data.Functor.Contravariant.Module.cmap.app(dictContravariant)
                  .app(PS.Data.Void.Module.absurd)
                  .app(a))
      }
    }
  };
  @JvmField
  val imapC = { dictContravariant : Any ->
     { v : Any ->
       { f : Any ->
         PS.Data.Functor.Contravariant.Module.cmap.app(dictContravariant).app(f)
      }
    }
  };
}