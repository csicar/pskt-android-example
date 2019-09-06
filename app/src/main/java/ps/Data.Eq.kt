@file:Suppress("UNCHECKED_CAST")
package PS.Data.Eq
import Foreign.PsRuntime.app
object Module  {
  val eqBooleanImpl = Foreign.Data.Eq.eqBooleanImpl;
  val eqIntImpl = Foreign.Data.Eq.eqIntImpl;
  val eqNumberImpl = Foreign.Data.Eq.eqNumberImpl;
  val eqCharImpl = Foreign.Data.Eq.eqCharImpl;
  val eqStringImpl = Foreign.Data.Eq.eqStringImpl;
  val eqArrayImpl = Foreign.Data.Eq.eqArrayImpl;
  @JvmField val EqRecord = { eqRecord : Any -> mapOf(("eqRecord" to eqRecord))};
  @JvmField val Eq1 = { eq1 : Any -> mapOf(("eq1" to eq1))};
  @JvmField val Eq = { eq : Any -> mapOf(("eq" to eq))};
  @JvmField
  val eqVoid = PS.Data.Eq.Module.Eq.app({ v : Any -> { v1 : Any -> true}});
  @JvmField
  val eqUnit = PS.Data.Eq.Module.Eq.app({ v : Any -> { v1 : Any -> true}});
  @JvmField
  val eqString = PS.Data.Eq.Module.Eq.app(PS.Data.Eq.Module.eqStringImpl);
  @JvmField
  val eqRowNil = PS.Data.Eq.Module.EqRecord
                   .app({ v : Any ->
       { v1 : Any ->
         { v2 : Any ->
           true
        }
      }
    });
  @JvmField
  val eqRecord = { dict : Any ->
     (dict as Map<String, Any>)["eqRecord"]!!
  };
  @JvmField
  val eqRec = { dictRowToList : Any ->
     { dictEqRecord : Any ->
       PS.Data.Eq.Module.Eq
         .app(PS.Data.Eq.Module.eqRecord.app(dictEqRecord)
                .app(PS.Type.Data.RowList.Module.RLProxy))
    }
  };
  @JvmField
  val eqNumber = PS.Data.Eq.Module.Eq.app(PS.Data.Eq.Module.eqNumberImpl);
  @JvmField val eqInt = PS.Data.Eq.Module.Eq.app(PS.Data.Eq.Module.eqIntImpl);
  @JvmField val eqChar = PS.Data.Eq.Module.Eq.app(PS.Data.Eq.Module.eqCharImpl);
  @JvmField
  val eqBoolean = PS.Data.Eq.Module.Eq.app(PS.Data.Eq.Module.eqBooleanImpl);
  @JvmField val eq1 = { dict : Any -> (dict as Map<String, Any>)["eq1"]!!};
  @JvmField val eq = { dict : Any -> (dict as Map<String, Any>)["eq"]!!};
  @JvmField
  val eqArray = { dictEq : Any ->
     PS.Data.Eq.Module.Eq
       .app(PS.Data.Eq.Module.eqArrayImpl.app(PS.Data.Eq.Module.eq.app(dictEq)))
  };
  @JvmField
  val eq1Array = PS.Data.Eq.Module.Eq1
                   .app({ dictEq : Any ->
       PS.Data.Eq.Module.eq.app(PS.Data.Eq.Module.eqArray.app(dictEq))
    });
  @JvmField
  val eqRowCons = { dictEqRecord : Any ->
     { dictCons : Any ->
       { dictIsSymbol : Any ->
         { dictEq : Any ->
           PS.Data.Eq.Module.EqRecord
             .app({ v : Any ->
               { ra : Any ->
                 { rb : Any ->
                   object   {
                       val tail = PS.Data.Eq.Module.eqRecord.app(dictEqRecord)
                                    .app(PS.Type.Data.RowList.Module.RLProxy)
                                    .app(ra)
                                    .app(rb);
                       val key = PS.Data.Symbol.Module.reflectSymbol
                                   .app(dictIsSymbol)
                                   .app(PS.Data.Symbol.Module.SProxy);
                       val _get = PS.Record.Unsafe.Module.unsafeGet.app(key);
                     }
                     .run({
                      val tail = this.tail;
                      val key = this.key;
                      val _get = this._get;
                      PS.Data.HeytingAlgebra.Module.conj
                        .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean
                        )
                        .app(PS.Data.Eq.Module.eq.app(dictEq).app(_get.app(ra))
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
  val notEq = { dictEq : Any ->
     { x : Any ->
       { y : Any ->
         PS.Data.Eq.Module.eq.app(PS.Data.Eq.Module.eqBoolean)
           .app(PS.Data.Eq.Module.eq.app(dictEq).app(x).app(y))
           .app(false)
      }
    }
  };
  @JvmField
  val notEq1 = { dictEq1 : Any ->
     { dictEq : Any ->
       { x : Any ->
         { y : Any ->
           PS.Data.Eq.Module.eq.app(PS.Data.Eq.Module.eqBoolean)
             .app(PS.Data.Eq.Module.eq1.app(dictEq1).app(dictEq).app(x).app(y))
             .app(false)
        }
      }
    }
  };
}