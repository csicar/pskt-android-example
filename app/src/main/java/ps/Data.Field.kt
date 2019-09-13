@file:Suppress("UNCHECKED_CAST")

package PS.Data.Field
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val Field = { DivisionRing1 : Any ->
     { EuclideanRing0 : Any ->
       mapOf(("DivisionRing1" to DivisionRing1),  
        ("EuclideanRing0" to EuclideanRing0))
    }
  };
  @JvmField
  val _field = { dictEuclideanRing : Any ->
     { dictDivisionRing : Any ->
       PS.Data.Field.Module.Field.app({ _ : Any -> dictDivisionRing})
         .app({ _ : Any ->
           dictEuclideanRing
        })
    }
  };
}