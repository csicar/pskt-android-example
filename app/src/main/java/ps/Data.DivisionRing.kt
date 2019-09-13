@file:Suppress("UNCHECKED_CAST")

package PS.Data.DivisionRing
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val DivisionRing = { Ring0 : Any ->
     { recip : Any ->
       mapOf(("Ring0" to Ring0),  ("recip" to recip))
    }
  };
  @JvmField val recip = { dict : Any -> (dict as Map<String, Any>)["recip"]!!};
  @JvmField
  val rightDiv = { dictDivisionRing : Any ->
     { a : Any ->
       { b : Any ->
         PS.Data.Semiring.Module.mul
           .app(((dictDivisionRing as Map<String, Any>)["Ring0"]!!
                   .app(Unit) as Map<String, Any>)["Semiring0"]!!
                  .app(Unit))
           .app(a)
           .app(PS.Data.DivisionRing.Module.recip.app(dictDivisionRing).app(b))
      }
    }
  };
  @JvmField
  val leftDiv = { dictDivisionRing : Any ->
     { a : Any ->
       { b : Any ->
         PS.Data.Semiring.Module.mul
           .app(((dictDivisionRing as Map<String, Any>)["Ring0"]!!
                   .app(Unit) as Map<String, Any>)["Semiring0"]!!
                  .app(Unit))
           .app(PS.Data.DivisionRing.Module.recip.app(dictDivisionRing).app(b))
           .app(a)
      }
    }
  };
  @JvmField
  val divisionringNumber = PS.Data.DivisionRing.Module.DivisionRing
                             .app({ _ : Any ->
                                  PS.Data.Ring.Module.ringNumber
                               })
                             .app({ x : Any ->
       PS.Data.EuclideanRing.Module.div
         .app(PS.Data.EuclideanRing.Module.euclideanRingNumber)
         .app(1.0)
         .app(x)
    });
}