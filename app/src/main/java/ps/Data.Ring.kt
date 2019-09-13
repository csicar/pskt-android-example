@file:Suppress("UNCHECKED_CAST")

package PS.Data.Ring
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  val intSub = Foreign.Data.Ring.intSub;
  val numSub = Foreign.Data.Ring.numSub;
  @JvmField
  val RingRecord = { SemiringRecord0 : Any ->
     { subRecord : Any ->
       mapOf(("SemiringRecord0" to SemiringRecord0),  ("subRecord" to subRecord)
      )
    }
  };
  @JvmField
  val Ring = { Semiring0 : Any ->
     { sub : Any ->
       mapOf(("Semiring0" to Semiring0),  ("sub" to sub))
    }
  };
  @JvmField
  val subRecord = { dict : Any ->
     (dict as Map<String, Any>)["subRecord"]!!
  };
  @JvmField val sub = { dict : Any -> (dict as Map<String, Any>)["sub"]!!};
  @JvmField
  val ringUnit = PS.Data.Ring.Module.Ring
                   .app({ _ : Any ->
                        PS.Data.Semiring.Module.semiringUnit
                     })
                   .app({ v : Any ->
       { v1 : Any ->
         PS.Data.Unit.Module.unit
      }
    });
  @JvmField
  val ringRecordNil = PS.Data.Ring.Module.RingRecord
                        .app({ _ : Any ->
                             PS.Data.Semiring.Module.semiringRecordNil
                          })
                        .app({ v : Any ->
       { v1 : Any ->
         { v2 : Any ->
           emptyMap<String, Any>()
        }
      }
    });
  @JvmField
  val ringRecordCons = { dictIsSymbol : Any ->
     { dictCons : Any ->
       { dictRingRecord : Any ->
         { dictRing : Any ->
           PS.Data.Ring.Module.RingRecord
             .app({ _ : Any ->
                  PS.Data.Semiring.Module.semiringRecordCons.app(dictIsSymbol)
                    .app(Unit)
                    .app(
                      (dictRingRecord as Map<String, Any>)["SemiringRecord0"]!!
                        .app(Unit))
                    .app((dictRing as Map<String, Any>)["Semiring0"]!!.app(Unit)
                 )
               })
             .app({ v : Any ->
               { ra : Any ->
                 { rb : Any ->
                   object   {
                       val tail = PS.Data.Ring.Module.subRecord
                                    .app(dictRingRecord)
                                    .app(PS.Type.Data.RowList.Module.RLProxy)
                                    .app(ra)
                                    .app(rb);
                       val key = PS.Data.Symbol.Module.reflectSymbol
                                   .app(dictIsSymbol)
                                   .app(PS.Data.Symbol.Module.SProxy);
                       val insert = PS.Record.Unsafe.Module.unsafeSet.app(key);
                       val _get = PS.Record.Unsafe.Module.unsafeGet.app(key);
                     }
                     .run({
                      val tail = this.tail;
                      val key = this.key;
                      val insert = this.insert;
                      val _get = this._get;
                      insert
                        .app(PS.Data.Ring.Module.sub.app(dictRing)
                               .app(_get.app(ra))
                               .app(_get.app(rb)))
                        .app(tail);
                    })
                }
              }
            })
        }
      }
    }
  };
  @JvmField
  val ringRecord = { dictRowToList : Any ->
     { dictRingRecord : Any ->
       PS.Data.Ring.Module.Ring
         .app({ _ : Any ->
              PS.Data.Semiring.Module.semiringRecord.app(Unit)
                .app((dictRingRecord as Map<String, Any>)["SemiringRecord0"]!!
                       .app(Unit))
           })
         .app(PS.Data.Ring.Module.subRecord.app(dictRingRecord)
                .app(PS.Type.Data.RowList.Module.RLProxy))
    }
  };
  @JvmField
  val ringNumber = PS.Data.Ring.Module.Ring
                     .app({ _ : Any ->
                          PS.Data.Semiring.Module.semiringNumber
                       })
                     .app(PS.Data.Ring.Module.numSub);
  @JvmField
  val ringInt = PS.Data.Ring.Module.Ring
                  .app({ _ : Any ->
                       PS.Data.Semiring.Module.semiringInt
                    })
                  .app(PS.Data.Ring.Module.intSub);
  @JvmField
  val ringFn = { dictRing : Any ->
     PS.Data.Ring.Module.Ring
       .app({ _ : Any ->
            PS.Data.Semiring.Module.semiringFn
              .app((dictRing as Map<String, Any>)["Semiring0"]!!.app(Unit))
         })
       .app({ f : Any ->
         { g : Any ->
           { x : Any ->
             PS.Data.Ring.Module.sub.app(dictRing).app(f.app(x)).app(g.app(x))
          }
        }
      })
  };
  @JvmField
  val negate = { dictRing : Any ->
     { a : Any ->
       PS.Data.Ring.Module.sub.app(dictRing)
         .app(PS.Data.Semiring.Module.zero
                .app((dictRing as Map<String, Any>)["Semiring0"]!!.app(Unit)))
         .app(a)
    }
  };
}