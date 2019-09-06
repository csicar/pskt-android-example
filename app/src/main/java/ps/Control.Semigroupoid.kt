@file:Suppress("UNCHECKED_CAST")
package PS.Control.Semigroupoid
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val Semigroupoid = { compose : Any ->
     mapOf(("compose" to compose))
  };
  @JvmField
  val semigroupoidFn = PS.Control.Semigroupoid.Module.Semigroupoid
                         .app({ f : Any ->
       { g : Any ->
         { x : Any ->
           f.app(g.app(x))
        }
      }
    });
  @JvmField
  val compose = { dict : Any ->
     (dict as Map<String, Any>)["compose"]!!
  };
  @JvmField
  val composeFlipped = { dictSemigroupoid : Any ->
     { f : Any ->
       { g : Any ->
         PS.Control.Semigroupoid.Module.compose.app(dictSemigroupoid).app(g)
           .app(f)
      }
    }
  };
}