@file:Suppress("UNCHECKED_CAST")
package PS.Data.Bounded
import Foreign.PsRuntime.app
object Module  {
  val topInt = Foreign.Data.Bounded.topInt;
  val bottomInt = Foreign.Data.Bounded.bottomInt;
  val topChar = Foreign.Data.Bounded.topChar;
  val bottomChar = Foreign.Data.Bounded.bottomChar;
  val topNumber = Foreign.Data.Bounded.topNumber;
  val bottomNumber = Foreign.Data.Bounded.bottomNumber;
  @JvmField
  val Bounded = { Ord0 : Any ->
     { bottom : Any ->
       { top : Any ->
         mapOf(("Ord0" to Ord0),  ("bottom" to bottom),  ("top" to top))
      }
    }
  };
  @JvmField val top = { dict : Any -> (dict as Map<String, Any>)["top"]!!};
  @JvmField
  val boundedUnit = PS.Data.Bounded.Module.Bounded
                      .app({ _ : Any ->
                           PS.Data.Ord.Module.ordUnit
                        })
                      .app(PS.Data.Unit.Module.unit)
                      .app(PS.Data.Unit.Module.unit);
  @JvmField
  val boundedOrdering = PS.Data.Bounded.Module.Bounded
                          .app({ _ : Any ->
                               PS.Data.Ord.Module.ordOrdering
                            })
                          .app(PS.Data.Ordering.Module.LT)
                          .app(PS.Data.Ordering.Module.GT);
  @JvmField
  val boundedNumber = PS.Data.Bounded.Module.Bounded
                        .app({ _ : Any ->
                             PS.Data.Ord.Module.ordNumber
                          })
                        .app(PS.Data.Bounded.Module.bottomNumber)
                        .app(PS.Data.Bounded.Module.topNumber);
  @JvmField
  val boundedInt = PS.Data.Bounded.Module.Bounded
                     .app({ _ : Any ->
                          PS.Data.Ord.Module.ordInt
                       })
                     .app(PS.Data.Bounded.Module.bottomInt)
                     .app(PS.Data.Bounded.Module.topInt);
  @JvmField
  val boundedChar = PS.Data.Bounded.Module.Bounded
                      .app({ _ : Any ->
                           PS.Data.Ord.Module.ordChar
                        })
                      .app(PS.Data.Bounded.Module.bottomChar)
                      .app(PS.Data.Bounded.Module.topChar);
  @JvmField
  val boundedBoolean = PS.Data.Bounded.Module.Bounded
                         .app({ _ : Any ->
                              PS.Data.Ord.Module.ordBoolean
                           })
                         .app(false)
                         .app(true);
  @JvmField
  val bottom = { dict : Any ->
     (dict as Map<String, Any>)["bottom"]!!
  };
}