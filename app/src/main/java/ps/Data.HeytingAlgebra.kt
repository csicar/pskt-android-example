@file:Suppress("UNCHECKED_CAST")
package PS.Data.HeytingAlgebra
import Foreign.PsRuntime.app
object Module  {
  val boolConj = Foreign.Data.HeytingAlgebra.boolConj;
  val boolDisj = Foreign.Data.HeytingAlgebra.boolDisj;
  val boolNot = Foreign.Data.HeytingAlgebra.boolNot;
  @JvmField
  val HeytingAlgebraRecord = { conjRecord : Any ->
     { disjRecord : Any ->
       { ffRecord : Any ->
         { impliesRecord : Any ->
           { notRecord : Any ->
             { ttRecord : Any ->
               mapOf(("conjRecord" to conjRecord),  
                ("disjRecord" to disjRecord),  ("ffRecord" to ffRecord),  
                ("impliesRecord" to impliesRecord),  
                ("notRecord" to notRecord),  ("ttRecord" to ttRecord))
            }
          }
        }
      }
    }
  };
  @JvmField
  val HeytingAlgebra = { conj : Any ->
     { disj : Any ->
       { ff : Any ->
         { implies : Any ->
           { not : Any ->
             { tt : Any ->
               mapOf(("conj" to conj),  ("disj" to disj),  ("ff" to ff),  
                ("implies" to implies),  ("not" to not),  ("tt" to tt))
            }
          }
        }
      }
    }
  };
  @JvmField
  val ttRecord = { dict : Any ->
     (dict as Map<String, Any>)["ttRecord"]!!
  };
  @JvmField val tt = { dict : Any -> (dict as Map<String, Any>)["tt"]!!};
  @JvmField
  val notRecord = { dict : Any ->
     (dict as Map<String, Any>)["notRecord"]!!
  };
  @JvmField val not = { dict : Any -> (dict as Map<String, Any>)["not"]!!};
  @JvmField
  val impliesRecord = { dict : Any ->
     (dict as Map<String, Any>)["impliesRecord"]!!
  };
  @JvmField
  val implies = { dict : Any ->
     (dict as Map<String, Any>)["implies"]!!
  };
  @JvmField
  val heytingAlgebraUnit = PS.Data.HeytingAlgebra.Module.HeytingAlgebra
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
                             .app({ v : Any ->
                                  { v1 : Any ->
                                    PS.Data.Unit.Module.unit
                                 }
                               })
                             .app({ v : Any ->
                                  PS.Data.Unit.Module.unit
                               })
                             .app(PS.Data.Unit.Module.unit);
  @JvmField
  val heytingAlgebraRecordNil = PS.Data.HeytingAlgebra.Module.HeytingAlgebraRecord
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
  val ffRecord = { dict : Any ->
     (dict as Map<String, Any>)["ffRecord"]!!
  };
  @JvmField val ff = { dict : Any -> (dict as Map<String, Any>)["ff"]!!};
  @JvmField
  val disjRecord = { dict : Any ->
     (dict as Map<String, Any>)["disjRecord"]!!
  };
  @JvmField val disj = { dict : Any -> (dict as Map<String, Any>)["disj"]!!};
  @JvmField val heytingAlgebraBoolean = (::__rec_heytingAlgebraBoolean)();
  fun __rec_heytingAlgebraBoolean(): Any = PS.Data.HeytingAlgebra.Module.HeytingAlgebra
                                             .app(
                                               PS.Data.HeytingAlgebra.Module.boolConj
                                             )
                                             .app(
                                               PS.Data.HeytingAlgebra.Module.boolDisj
                                             )
                                             .app(false)
                                             .app({ a : Any ->
                                                  { b : Any ->
                                                    PS.Data.HeytingAlgebra.Module.disj
                                                      .app(
                                                        PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean
                                                      )
                                                      .app(
                                                        PS.Data.HeytingAlgebra.Module.not
                                                          .app(
                                                            PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean
                                                          )
                                                          .app(a))
                                                      .app(b)
                                                 }
                                               })
                                             .app(
                                               PS.Data.HeytingAlgebra.Module.boolNot
                                             )
                                             .app(true);
  @JvmField
  val conjRecord = { dict : Any ->
     (dict as Map<String, Any>)["conjRecord"]!!
  };
  @JvmField
  val heytingAlgebraRecord = { dictRowToList : Any ->
     { dictHeytingAlgebraRecord : Any ->
       PS.Data.HeytingAlgebra.Module.HeytingAlgebra
         .app(PS.Data.HeytingAlgebra.Module.conjRecord
                .app(dictHeytingAlgebraRecord)
                .app(PS.Type.Data.RowList.Module.RLProxy))
         .app(PS.Data.HeytingAlgebra.Module.disjRecord
                .app(dictHeytingAlgebraRecord)
                .app(PS.Type.Data.RowList.Module.RLProxy))
         .app(PS.Data.HeytingAlgebra.Module.ffRecord
                .app(dictHeytingAlgebraRecord)
                .app(PS.Type.Data.RowList.Module.RLProxy)
                .app(PS.Type.Data.Row.Module.RProxy))
         .app(PS.Data.HeytingAlgebra.Module.impliesRecord
                .app(dictHeytingAlgebraRecord)
                .app(PS.Type.Data.RowList.Module.RLProxy))
         .app(PS.Data.HeytingAlgebra.Module.notRecord
                .app(dictHeytingAlgebraRecord)
                .app(PS.Type.Data.RowList.Module.RLProxy))
         .app(PS.Data.HeytingAlgebra.Module.ttRecord
                .app(dictHeytingAlgebraRecord)
                .app(PS.Type.Data.RowList.Module.RLProxy)
                .app(PS.Type.Data.Row.Module.RProxy))
    }
  };
  @JvmField val conj = { dict : Any -> (dict as Map<String, Any>)["conj"]!!};
  @JvmField
  val heytingAlgebraFunction = { dictHeytingAlgebra : Any ->
     PS.Data.HeytingAlgebra.Module.HeytingAlgebra
       .app({ f : Any ->
            { g : Any ->
              { a : Any ->
                PS.Data.HeytingAlgebra.Module.conj.app(dictHeytingAlgebra)
                  .app(f.app(a))
                  .app(g.app(a))
             }
           }
         })
       .app({ f : Any ->
            { g : Any ->
              { a : Any ->
                PS.Data.HeytingAlgebra.Module.disj.app(dictHeytingAlgebra)
                  .app(f.app(a))
                  .app(g.app(a))
             }
           }
         })
       .app({ v : Any ->
            PS.Data.HeytingAlgebra.Module.ff.app(dictHeytingAlgebra)
         })
       .app({ f : Any ->
            { g : Any ->
              { a : Any ->
                PS.Data.HeytingAlgebra.Module.implies.app(dictHeytingAlgebra)
                  .app(f.app(a))
                  .app(g.app(a))
             }
           }
         })
       .app({ f : Any ->
            { a : Any ->
              PS.Data.HeytingAlgebra.Module.not.app(dictHeytingAlgebra)
                .app(f.app(a))
           }
         })
       .app({ v : Any ->
         PS.Data.HeytingAlgebra.Module.tt.app(dictHeytingAlgebra)
      })
  };
  @JvmField
  val heytingAlgebraRecordCons = { dictIsSymbol : Any ->
     { dictCons : Any ->
       { dictHeytingAlgebraRecord : Any ->
         { dictHeytingAlgebra : Any ->
           PS.Data.HeytingAlgebra.Module.HeytingAlgebraRecord
             .app({ v : Any ->
                  { ra : Any ->
                    { rb : Any ->
                      object   {
                          val tail = PS.Data.HeytingAlgebra.Module.conjRecord
                                       .app(dictHeytingAlgebraRecord)
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
                           .app(PS.Data.HeytingAlgebra.Module.conj
                                  .app(dictHeytingAlgebra)
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
                          val tail = PS.Data.HeytingAlgebra.Module.disjRecord
                                       .app(dictHeytingAlgebraRecord)
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
                           .app(PS.Data.HeytingAlgebra.Module.disj
                                  .app(dictHeytingAlgebra)
                                  .app(_get.app(ra))
                                  .app(_get.app(rb)))
                           .app(tail);
                       })
                   }
                 }
               })
             .app({ v : Any ->
                  { row : Any ->
                    object   {
                        val tail = PS.Data.HeytingAlgebra.Module.ffRecord
                                     .app(dictHeytingAlgebraRecord)
                                     .app(PS.Type.Data.RowList.Module.RLProxy)
                                     .app(row);
                        val key = PS.Data.Symbol.Module.reflectSymbol
                                    .app(dictIsSymbol)
                                    .app(PS.Data.Symbol.Module.SProxy);
                        val insert = PS.Record.Unsafe.Module.unsafeSet.app(key);
                      }
                      .run({
                       val tail = this.tail;
                       val key = this.key;
                       val insert = this.insert;
                       insert
                         .app(PS.Data.HeytingAlgebra.Module.ff
                                .app(dictHeytingAlgebra))
                         .app(tail);
                     })
                 }
               })
             .app({ v : Any ->
                  { ra : Any ->
                    { rb : Any ->
                      object   {
                          val tail = PS.Data.HeytingAlgebra.Module.impliesRecord
                                       .app(dictHeytingAlgebraRecord)
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
                           .app(PS.Data.HeytingAlgebra.Module.implies
                                  .app(dictHeytingAlgebra)
                                  .app(_get.app(ra))
                                  .app(_get.app(rb)))
                           .app(tail);
                       })
                   }
                 }
               })
             .app({ v : Any ->
                  { row : Any ->
                    object   {
                        val tail = PS.Data.HeytingAlgebra.Module.notRecord
                                     .app(dictHeytingAlgebraRecord)
                                     .app(PS.Type.Data.RowList.Module.RLProxy)
                                     .app(row);
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
                         .app(PS.Data.HeytingAlgebra.Module.not
                                .app(dictHeytingAlgebra)
                                .app(_get.app(row)))
                         .app(tail);
                     })
                 }
               })
             .app({ v : Any ->
               { row : Any ->
                 object   {
                     val tail = PS.Data.HeytingAlgebra.Module.ttRecord
                                  .app(dictHeytingAlgebraRecord)
                                  .app(PS.Type.Data.RowList.Module.RLProxy)
                                  .app(row);
                     val key = PS.Data.Symbol.Module.reflectSymbol
                                 .app(dictIsSymbol)
                                 .app(PS.Data.Symbol.Module.SProxy);
                     val insert = PS.Record.Unsafe.Module.unsafeSet.app(key);
                   }
                   .run({
                    val tail = this.tail;
                    val key = this.key;
                    val insert = this.insert;
                    insert
                      .app(PS.Data.HeytingAlgebra.Module.tt
                             .app(dictHeytingAlgebra))
                      .app(tail);
                  })
              }
            })
        }
      }
    }
  };
}