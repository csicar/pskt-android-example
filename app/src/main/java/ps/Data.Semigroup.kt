@file:Suppress("UNCHECKED_CAST")

package PS.Data.Semigroup
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  val concatString = Foreign.Data.Semigroup.concatString;
  val concatArray = Foreign.Data.Semigroup.concatArray;
  @JvmField
  val SemigroupRecord = { appendRecord : Any ->
     mapOf(("appendRecord" to appendRecord))
  };
  @JvmField val Semigroup = { append : Any -> mapOf(("append" to append))};
  @JvmField
  val semigroupVoid = PS.Data.Semigroup.Module.Semigroup
                        .app({ v : Any ->
       PS.Data.Void.Module.absurd
    });
  @JvmField
  val semigroupUnit = PS.Data.Semigroup.Module.Semigroup
                        .app({ v : Any ->
       { v1 : Any ->
         PS.Data.Unit.Module.unit
      }
    });
  @JvmField
  val semigroupString = PS.Data.Semigroup.Module.Semigroup
                          .app(PS.Data.Semigroup.Module.concatString);
  @JvmField
  val semigroupRecordNil = PS.Data.Semigroup.Module.SemigroupRecord
                             .app({ v : Any ->
       { v1 : Any ->
         { v2 : Any ->
           emptyMap<String, Any>()
        }
      }
    });
  @JvmField
  val semigroupArray = PS.Data.Semigroup.Module.Semigroup
                         .app(PS.Data.Semigroup.Module.concatArray);
  @JvmField
  val appendRecord = { dict : Any ->
     (dict as Map<String, Any>)["appendRecord"]!!
  };
  @JvmField
  val semigroupRecord = { dictRowToList : Any ->
     { dictSemigroupRecord : Any ->
       PS.Data.Semigroup.Module.Semigroup
         .app(PS.Data.Semigroup.Module.appendRecord.app(dictSemigroupRecord)
                .app(PS.Type.Data.RowList.Module.RLProxy))
    }
  };
  @JvmField
  val append = { dict : Any ->
     (dict as Map<String, Any>)["append"]!!
  };
  @JvmField
  val semigroupFn = { dictSemigroup : Any ->
     PS.Data.Semigroup.Module.Semigroup
       .app({ f : Any ->
         { g : Any ->
           { x : Any ->
             PS.Data.Semigroup.Module.append.app(dictSemigroup).app(f.app(x))
               .app(g.app(x))
          }
        }
      })
  };
  @JvmField
  val semigroupRecordCons = { dictIsSymbol : Any ->
     { dictCons : Any ->
       { dictSemigroupRecord : Any ->
         { dictSemigroup : Any ->
           PS.Data.Semigroup.Module.SemigroupRecord
             .app({ v : Any ->
               { ra : Any ->
                 { rb : Any ->
                   object   {
                       val tail = PS.Data.Semigroup.Module.appendRecord
                                    .app(dictSemigroupRecord)
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
                        .app(PS.Data.Semigroup.Module.append.app(dictSemigroup)
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
}