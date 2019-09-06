@file:Suppress("UNCHECKED_CAST")
package PS.Control.Alternative
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val Alternative = { Applicative0 : Any ->
     { Plus1 : Any ->
       mapOf(("Applicative0" to Applicative0),  ("Plus1" to Plus1))
    }
  };
  @JvmField
  val alternativeArray = PS.Control.Alternative.Module.Alternative
                           .app({ _ : Any ->
                                PS.Control.Applicative.Module.applicativeArray
                             })
                           .app({ _ : Any ->
       PS.Control.Plus.Module.plusArray
    });
}