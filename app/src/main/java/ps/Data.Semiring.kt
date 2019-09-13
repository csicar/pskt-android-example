@file:Suppress("UNCHECKED_CAST")

package PS.Data.Semiring
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  val intAdd = Foreign.Data.Semiring.intAdd;
  val intMul = Foreign.Data.Semiring.intMul;
  val numAdd = Foreign.Data.Semiring.numAdd;
  val numMul = Foreign.Data.Semiring.numMul;
  @JvmField
  val SemiringRecord = { addRecord : Any ->
     { mulRecord : Any ->
       { oneRecord : Any ->
         { zeroRecord : Any ->
           mapOf(("addRecord" to addRecord),  ("mulRecord" to mulRecord),  
            ("oneRecord" to oneRecord),  ("zeroRecord" to zeroRecord))
        }
      }
    }
  };
  @JvmField
  val Semiring = { add : Any ->
     { mul : Any ->
       { one : Any ->
         { zero : Any ->
           mapOf(("add" to add),  ("mul" to mul),  ("one" to one),  
            ("zero" to zero))
        }
      }
    }
  };
  @JvmField
  val zeroRecord = { dict : Any ->
     (dict as Map<String, Any>)["zeroRecord"]!!
  };
  @JvmField val zero = { dict : Any -> (dict as Map<String, Any>)["zero"]!!};
  @JvmField
  val semiringUnit = PS.Data.Semiring.Module.Semiring
                       .app({ v : Any ->
                            { v1 : Any ->
                              PS.Data.Unit.Module.unit
                           }
                         })
                       .app({ v : Any ->
                            { v1 : Any ->
                              PS.Data.Unit.Module.unit
                           }
                         })
                       .app(PS.Data.Unit.Module.unit)
                       .app(PS.Data.Unit.Module.unit);
  @JvmField
  val semiringRecordNil = PS.Data.Semiring.Module.SemiringRecord
                            .app({ v : Any ->
                                 { v1 : Any ->
                                   { v2 : Any ->
                                     emptyMap<String, Any>()
                                  }
                                }
                              })
                            .app({ v : Any ->
                                 { v1 : Any ->
                                   { v2 : Any ->
                                     emptyMap<String, Any>()
                                  }
                                }
                              })
                            .app({ v : Any ->
                                 { v1 : Any ->
                                   emptyMap<String, Any>()
                                }
                              })
                            .app({ v : Any ->
       { v1 : Any ->
         emptyMap<String, Any>()
      }
    });
  @JvmField
  val semiringNumber = PS.Data.Semiring.Module.Semiring
                         .app(PS.Data.Semiring.Module.numAdd)
                         .app(PS.Data.Semiring.Module.numMul)
                         .app(1.0)
                         .app(0.0);
  @JvmField
  val semiringInt = PS.Data.Semiring.Module.Semiring
                      .app(PS.Data.Semiring.Module.intAdd)
                      .app(PS.Data.Semiring.Module.intMul)
                      .app(1)
                      .app(0);
  @JvmField
  val oneRecord = { dict : Any ->
     (dict as Map<String, Any>)["oneRecord"]!!
  };
  @JvmField val one = { dict : Any -> (dict as Map<String, Any>)["one"]!!};
  @JvmField
  val mulRecord = { dict : Any ->
     (dict as Map<String, Any>)["mulRecord"]!!
  };
  @JvmField val mul = { dict : Any -> (dict as Map<String, Any>)["mul"]!!};
  @JvmField
  val addRecord = { dict : Any ->
     (dict as Map<String, Any>)["addRecord"]!!
  };
  @JvmField
  val semiringRecord = { dictRowToList : Any ->
     { dictSemiringRecord : Any ->
       PS.Data.Semiring.Module.Semiring
         .app(PS.Data.Semiring.Module.addRecord.app(dictSemiringRecord)
                .app(PS.Type.Data.RowList.Module.RLProxy))
         .app(PS.Data.Semiring.Module.mulRecord.app(dictSemiringRecord)
                .app(PS.Type.Data.RowList.Module.RLProxy))
         .app(PS.Data.Semiring.Module.oneRecord.app(dictSemiringRecord)
                .app(PS.Type.Data.RowList.Module.RLProxy)
                .app(PS.Type.Data.Row.Module.RProxy))
         .app(PS.Data.Semiring.Module.zeroRecord.app(dictSemiringRecord)
                .app(PS.Type.Data.RowList.Module.RLProxy)
                .app(PS.Type.Data.Row.Module.RProxy))
    }
  };
  @JvmField val add = { dict : Any -> (dict as Map<String, Any>)["add"]!!};
  @JvmField
  val semiringFn = { dictSemiring : Any ->
     PS.Data.Semiring.Module.Semiring
       .app({ f : Any ->
            { g : Any ->
              { x : Any ->
                PS.Data.Semiring.Module.add.app(dictSemiring).app(f.app(x))
                  .app(g.app(x))
             }
           }
         })
       .app({ f : Any ->
            { g : Any ->
              { x : Any ->
                PS.Data.Semiring.Module.mul.app(dictSemiring).app(f.app(x))
                  .app(g.app(x))
             }
           }
         })
       .app({ v : Any ->
            PS.Data.Semiring.Module.one.app(dictSemiring)
         })
       .app({ v : Any ->
         PS.Data.Semiring.Module.zero.app(dictSemiring)
      })
  };
  @JvmField
  val semiringRecordCons = { dictIsSymbol : Any ->
     { dictCons : Any ->
       { dictSemiringRecord : Any ->
         { dictSemiring : Any ->
           PS.Data.Semiring.Module.SemiringRecord
             .app({ v : Any ->
                  { ra : Any ->
                    { rb : Any ->
                      object   {
                          val tail = PS.Data.Semiring.Module.addRecord
                                       .app(dictSemiringRecord)
                                       .app(PS.Type.Data.RowList.Module.RLProxy)
                                       .app(ra)
                                       .app(rb);
                          val key = PS.Data.Symbol.Module.reflectSymbol
                                      .app(dictIsSymbol)
                                      .app(PS.Data.Symbol.Module.SProxy);
                          val insert = PS.Record.Unsafe.Module.unsafeSet
                                         .app(key);
                          val _get = PS.Record.Unsafe.Module.unsafeGet.app(key);
                        }
                        .run({
                         val tail = this.tail;
                         val key = this.key;
                         val insert = this.insert;
                         val _get = this._get;
                         insert
                           .app(PS.Data.Semiring.Module.add.app(dictSemiring)
                                  .app(_get.app(ra))
                                  .app(_get.app(rb)))
                           .app(tail);
                       })
                   }
                 }
               })
             .app({ v : Any ->
                  { ra : Any ->
                    { rb : Any ->
                      object   {
                          val tail = PS.Data.Semiring.Module.mulRecord
                                       .app(dictSemiringRecord)
                                       .app(PS.Type.Data.RowList.Module.RLProxy)
                                       .app(ra)
                                       .app(rb);
                          val key = PS.Data.Symbol.Module.reflectSymbol
                                      .app(dictIsSymbol)
                                      .app(PS.Data.Symbol.Module.SProxy);
                          val insert = PS.Record.Unsafe.Module.unsafeSet
                                         .app(key);
                          val _get = PS.Record.Unsafe.Module.unsafeGet.app(key);
                        }
                        .run({
                         val tail = this.tail;
                         val key = this.key;
                         val insert = this.insert;
                         val _get = this._get;
                         insert
                           .app(PS.Data.Semiring.Module.mul.app(dictSemiring)
                                  .app(_get.app(ra))
                                  .app(_get.app(rb)))
                           .app(tail);
                       })
                   }
                 }
               })
             .app({ v : Any ->
                  { v1 : Any ->
                    object   {
                        val tail = PS.Data.Semiring.Module.oneRecord
                                     .app(dictSemiringRecord)
                                     .app(PS.Type.Data.RowList.Module.RLProxy)
                                     .app(PS.Type.Data.Row.Module.RProxy);
                        val key = PS.Data.Symbol.Module.reflectSymbol
                                    .app(dictIsSymbol)
                                    .app(PS.Data.Symbol.Module.SProxy);
                        val insert = PS.Record.Unsafe.Module.unsafeSet.app(key);
                      }
                      .run({
                       val tail = this.tail;
                       val key = this.key;
                       val insert = this.insert;
                       insert.app(PS.Data.Semiring.Module.one.app(dictSemiring))
                         .app(tail);
                     })
                 }
               })
             .app({ v : Any ->
               { v1 : Any ->
                 object   {
                     val tail = PS.Data.Semiring.Module.zeroRecord
                                  .app(dictSemiringRecord)
                                  .app(PS.Type.Data.RowList.Module.RLProxy)
                                  .app(PS.Type.Data.Row.Module.RProxy);
                     val key = PS.Data.Symbol.Module.reflectSymbol
                                 .app(dictIsSymbol)
                                 .app(PS.Data.Symbol.Module.SProxy);
                     val insert = PS.Record.Unsafe.Module.unsafeSet.app(key);
                   }
                   .run({
                    val tail = this.tail;
                    val key = this.key;
                    val insert = this.insert;
                    insert.app(PS.Data.Semiring.Module.zero.app(dictSemiring))
                      .app(tail);
                  })
              }
            })
        }
      }
    }
  };
}