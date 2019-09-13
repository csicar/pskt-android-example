@file:Suppress("UNCHECKED_CAST")

package PS.Data.CommutativeRing
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val CommutativeRingRecord = { RingRecord0 : Any ->
     mapOf(("RingRecord0" to RingRecord0))
  };
  @JvmField val CommutativeRing = { Ring0 : Any -> mapOf(("Ring0" to Ring0))};
  @JvmField
  val commutativeRingUnit = PS.Data.CommutativeRing.Module.CommutativeRing
                              .app({ _ : Any ->
       PS.Data.Ring.Module.ringUnit
    });
  @JvmField
  val commutativeRingRecordNil = PS.Data.CommutativeRing.Module.CommutativeRingRecord
                                   .app({ _ : Any ->
       PS.Data.Ring.Module.ringRecordNil
    });
  @JvmField
  val commutativeRingRecordCons = { dictIsSymbol : Any ->
     { dictCons : Any ->
       { dictCommutativeRingRecord : Any ->
         { dictCommutativeRing : Any ->
           PS.Data.CommutativeRing.Module.CommutativeRingRecord
             .app({ _ : Any ->
               PS.Data.Ring.Module.ringRecordCons.app(dictIsSymbol).app(Unit)
                 .app(
                   (dictCommutativeRingRecord as Map<String, Any>)["RingRecord0"]!!
                     .app(Unit))
                 .app((dictCommutativeRing as Map<String, Any>)["Ring0"]!!
                        .app(Unit))
            })
        }
      }
    }
  };
  @JvmField
  val commutativeRingRecord = { dictRowToList : Any ->
     { dictCommutativeRingRecord : Any ->
       PS.Data.CommutativeRing.Module.CommutativeRing
         .app({ _ : Any ->
           PS.Data.Ring.Module.ringRecord.app(Unit)
             .app(
            (dictCommutativeRingRecord as Map<String, Any>)["RingRecord0"]!!
              .app(Unit))
        })
    }
  };
  @JvmField
  val commutativeRingNumber = PS.Data.CommutativeRing.Module.CommutativeRing
                                .app({ _ : Any ->
       PS.Data.Ring.Module.ringNumber
    });
  @JvmField
  val commutativeRingInt = PS.Data.CommutativeRing.Module.CommutativeRing
                             .app({ _ : Any ->
       PS.Data.Ring.Module.ringInt
    });
  @JvmField
  val commutativeRingFn = { dictCommutativeRing : Any ->
     PS.Data.CommutativeRing.Module.CommutativeRing
       .app({ _ : Any ->
         PS.Data.Ring.Module.ringFn
           .app((dictCommutativeRing as Map<String, Any>)["Ring0"]!!.app(Unit))
      })
  };
}