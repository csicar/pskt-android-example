@file:Suppress("UNCHECKED_CAST")
package PS.Data.Array.Partial
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val tail = { dictPartial : Any ->
     { xs : Any ->
       PS.Data.Array.Module.slice.app(1)
         .app(PS.Data.Array.Module.length.app(xs))
         .app(xs)
    }
  };
  @JvmField
  val last = { dictPartial : Any ->
     { xs : Any ->
       PS.Data.Array.Module.unsafeIndex.app(Unit).app(xs)
         .app(PS.Data.Ring.Module.sub.app(PS.Data.Ring.Module.ringInt)
                .app(PS.Data.Array.Module.length.app(xs))
                .app(1))
    }
  };
  @JvmField
  val _init = { dictPartial : Any ->
     { xs : Any ->
       PS.Data.Array.Module.slice.app(0)
         .app(PS.Data.Ring.Module.sub.app(PS.Data.Ring.Module.ringInt)
                .app(PS.Data.Array.Module.length.app(xs))
                .app(1))
         .app(xs)
    }
  };
  @JvmField
  val head = { dictPartial : Any ->
     { xs : Any ->
       PS.Data.Array.Module.unsafeIndex.app(Unit).app(xs).app(0)
    }
  };
}