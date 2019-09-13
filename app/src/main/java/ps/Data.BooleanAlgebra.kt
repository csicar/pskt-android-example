@file:Suppress("UNCHECKED_CAST")

package PS.Data.BooleanAlgebra
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val BooleanAlgebraRecord = { HeytingAlgebraRecord0 : Any ->
     mapOf(("HeytingAlgebraRecord0" to HeytingAlgebraRecord0))
  };
  @JvmField
  val BooleanAlgebra = { HeytingAlgebra0 : Any ->
     mapOf(("HeytingAlgebra0" to HeytingAlgebra0))
  };
  @JvmField
  val booleanAlgebraUnit = PS.Data.BooleanAlgebra.Module.BooleanAlgebra
                             .app({ _ : Any ->
       PS.Data.HeytingAlgebra.Module.heytingAlgebraUnit
    });
  @JvmField
  val booleanAlgebraRecordNil = PS.Data.BooleanAlgebra.Module.BooleanAlgebraRecord
                                  .app({ _ : Any ->
       PS.Data.HeytingAlgebra.Module.heytingAlgebraRecordNil
    });
  @JvmField
  val booleanAlgebraRecordCons = { dictIsSymbol : Any ->
     { dictCons : Any ->
       { dictBooleanAlgebraRecord : Any ->
         { dictBooleanAlgebra : Any ->
           PS.Data.BooleanAlgebra.Module.BooleanAlgebraRecord
             .app({ _ : Any ->
               PS.Data.HeytingAlgebra.Module.heytingAlgebraRecordCons
                 .app(dictIsSymbol)
                 .app(Unit)
                 .app(
                   (dictBooleanAlgebraRecord as Map<String, Any>)["HeytingAlgebraRecord0"]!!
                     .app(Unit))
                 .app(
                (dictBooleanAlgebra as Map<String, Any>)["HeytingAlgebra0"]!!
                  .app(Unit))
            })
        }
      }
    }
  };
  @JvmField
  val booleanAlgebraRecord = { dictRowToList : Any ->
     { dictBooleanAlgebraRecord : Any ->
       PS.Data.BooleanAlgebra.Module.BooleanAlgebra
         .app({ _ : Any ->
           PS.Data.HeytingAlgebra.Module.heytingAlgebraRecord.app(Unit)
             .app(
            (dictBooleanAlgebraRecord as Map<String, Any>)["HeytingAlgebraRecord0"]!!
              .app(Unit))
        })
    }
  };
  @JvmField
  val booleanAlgebraFn = { dictBooleanAlgebra : Any ->
     PS.Data.BooleanAlgebra.Module.BooleanAlgebra
       .app({ _ : Any ->
         PS.Data.HeytingAlgebra.Module.heytingAlgebraFunction
           .app((dictBooleanAlgebra as Map<String, Any>)["HeytingAlgebra0"]!!
                  .app(Unit))
      })
  };
  @JvmField
  val booleanAlgebraBoolean = PS.Data.BooleanAlgebra.Module.BooleanAlgebra
                                .app({ _ : Any ->
       PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean
    });
}