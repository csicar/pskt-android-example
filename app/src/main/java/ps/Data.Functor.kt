@file:Suppress("UNCHECKED_CAST")
package PS.Data.Functor
import Foreign.PsRuntime.app
object Module  {
  val arrayMap = Foreign.Data.Functor.arrayMap;
  @JvmField val Functor = { map : Any -> mapOf(("map" to map))};
  @JvmField val map = { dict : Any -> (dict as Map<String, Any>)["map"]!!};
  @JvmField
  val mapFlipped = { dictFunctor : Any ->
     { fa : Any ->
       { f : Any ->
         PS.Data.Functor.Module.map.app(dictFunctor).app(f).app(fa)
      }
    }
  };
  @JvmField
  val void = { dictFunctor : Any ->
     PS.Data.Functor.Module.map.app(dictFunctor)
       .app(PS.Data.Function.Module._const.app(PS.Data.Unit.Module.unit))
  };
  @JvmField
  val voidLeft = { dictFunctor : Any ->
     { f : Any ->
       { x : Any ->
         PS.Data.Functor.Module.map.app(dictFunctor)
           .app(PS.Data.Function.Module._const.app(x))
           .app(f)
      }
    }
  };
  @JvmField
  val voidRight = { dictFunctor : Any ->
     { x : Any ->
       PS.Data.Functor.Module.map.app(dictFunctor)
         .app(PS.Data.Function.Module._const.app(x))
    }
  };
  @JvmField
  val functorFn = PS.Data.Functor.Module.Functor
                    .app(PS.Control.Semigroupoid.Module.compose
                           .app(PS.Control.Semigroupoid.Module.semigroupoidFn));
  @JvmField
  val functorArray = PS.Data.Functor.Module.Functor
                       .app(PS.Data.Functor.Module.arrayMap);
  @JvmField
  val flap = { dictFunctor : Any ->
     { ff : Any ->
       { x : Any ->
         PS.Data.Functor.Module.map.app(dictFunctor).app({ f : Any -> f.app(x)})
           .app(ff)
      }
    }
  };
}