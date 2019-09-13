@file:Suppress("UNCHECKED_CAST")

package PS.Control.Lazy
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val Lazy = { defer : Any -> mapOf(("defer" to defer))};
  @JvmField
  val lazyUnit = PS.Control.Lazy.Module.Lazy
                   .app({ v : Any ->
       PS.Data.Unit.Module.unit
    });
  @JvmField
  val lazyFn = PS.Control.Lazy.Module.Lazy
                 .app({ f : Any ->
       { x : Any ->
         f.app(PS.Data.Unit.Module.unit).app(x)
      }
    });
  @JvmField val defer = { dict : Any -> (dict as Map<String, Any>)["defer"]!!};
  @JvmField
  val fix = { dictLazy : Any ->
     { f : Any ->
       object   {
           val go = (::__rec_go)();
           fun __rec_go(): Any = PS.Control.Lazy.Module.defer.app(dictLazy)
                                   .app({ v : Any ->
                f.app(__rec_go())
             });
         }
         .run({
          val go = this.go;
          go;
        })
    }
  };
}