@file:Suppress("UNCHECKED_CAST")

package PS.Data.Ord
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  val ordBooleanImpl = Foreign.Data.Ord.ordBooleanImpl;
  val ordIntImpl = Foreign.Data.Ord.ordIntImpl;
  val ordNumberImpl = Foreign.Data.Ord.ordNumberImpl;
  val ordStringImpl = Foreign.Data.Ord.ordStringImpl;
  val ordCharImpl = Foreign.Data.Ord.ordCharImpl;
  val ordArrayImpl = Foreign.Data.Ord.ordArrayImpl;
  @JvmField
  val OrdRecord = { EqRecord0 : Any ->
     { compareRecord : Any ->
       mapOf(("EqRecord0" to EqRecord0),  ("compareRecord" to compareRecord))
    }
  };
  @JvmField
  val Ord1 = { Eq10 : Any ->
     { compare1 : Any ->
       mapOf(("Eq10" to Eq10),  ("compare1" to compare1))
    }
  };
  @JvmField
  val Ord = { Eq0 : Any ->
     { compare : Any ->
       mapOf(("Eq0" to Eq0),  ("compare" to compare))
    }
  };
  @JvmField
  val ordVoid = PS.Data.Ord.Module.Ord
                  .app({ _ : Any ->
                       PS.Data.Eq.Module.eqVoid
                    })
                  .app({ v : Any ->
       { v1 : Any ->
         PS.Data.Ordering.Module.EQ
      }
    });
  @JvmField
  val ordUnit = PS.Data.Ord.Module.Ord
                  .app({ _ : Any ->
                       PS.Data.Eq.Module.eqUnit
                    })
                  .app({ v : Any ->
       { v1 : Any ->
         PS.Data.Ordering.Module.EQ
      }
    });
  @JvmField
  val ordString = PS.Data.Ord.Module.Ord
                    .app({ _ : Any ->
                         PS.Data.Eq.Module.eqString
                      })
                    .app(PS.Data.Ord.Module.ordStringImpl
                           .app(PS.Data.Ordering.Module.LT)
                           .app(PS.Data.Ordering.Module.EQ)
                           .app(PS.Data.Ordering.Module.GT));
  @JvmField
  val ordRecordNil = PS.Data.Ord.Module.OrdRecord
                       .app({ _ : Any ->
                            PS.Data.Eq.Module.eqRowNil
                         })
                       .app({ v : Any ->
       { v1 : Any ->
         { v2 : Any ->
           PS.Data.Ordering.Module.EQ
        }
      }
    });
  @JvmField
  val ordOrdering = PS.Data.Ord.Module.Ord
                      .app({ _ : Any ->
                           PS.Data.Ordering.Module.eqOrdering
                        })
                      .app({ v : Any ->
       { v1 : Any ->
         when {
          (v is PS.Data.Ordering.Module._Type_Ordering
                  .LT)&& (v1 is PS.Data.Ordering.Module._Type_Ordering
                                  .LT) -> {
            PS.Data.Ordering.Module.EQ;
          }
          (v is PS.Data.Ordering.Module._Type_Ordering
                  .EQ)&& (v1 is PS.Data.Ordering.Module._Type_Ordering
                                  .EQ) -> {
            PS.Data.Ordering.Module.EQ;
          }
          (v is PS.Data.Ordering.Module._Type_Ordering
                  .GT)&& (v1 is PS.Data.Ordering.Module._Type_Ordering
                                  .GT) -> {
            PS.Data.Ordering.Module.EQ;
          }
          (v is PS.Data.Ordering.Module._Type_Ordering.LT) -> {
            PS.Data.Ordering.Module.LT;
          }
          (v is PS.Data.Ordering.Module._Type_Ordering
                  .EQ)&& (v1 is PS.Data.Ordering.Module._Type_Ordering
                                  .LT) -> {
            PS.Data.Ordering.Module.GT;
          }
          (v is PS.Data.Ordering.Module._Type_Ordering
                  .EQ)&& (v1 is PS.Data.Ordering.Module._Type_Ordering
                                  .GT) -> {
            PS.Data.Ordering.Module.LT;
          }
          (v is PS.Data.Ordering.Module._Type_Ordering.GT) -> {
            PS.Data.Ordering.Module.GT;
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val ordNumber = PS.Data.Ord.Module.Ord
                    .app({ _ : Any ->
                         PS.Data.Eq.Module.eqNumber
                      })
                    .app(PS.Data.Ord.Module.ordNumberImpl
                           .app(PS.Data.Ordering.Module.LT)
                           .app(PS.Data.Ordering.Module.EQ)
                           .app(PS.Data.Ordering.Module.GT));
  @JvmField
  val ordInt = PS.Data.Ord.Module.Ord.app({ _ : Any -> PS.Data.Eq.Module.eqInt})
                 .app(PS.Data.Ord.Module.ordIntImpl
                        .app(PS.Data.Ordering.Module.LT)
                        .app(PS.Data.Ordering.Module.EQ)
                        .app(PS.Data.Ordering.Module.GT));
  @JvmField
  val ordChar = PS.Data.Ord.Module.Ord
                  .app({ _ : Any ->
                       PS.Data.Eq.Module.eqChar
                    })
                  .app(PS.Data.Ord.Module.ordCharImpl
                         .app(PS.Data.Ordering.Module.LT)
                         .app(PS.Data.Ordering.Module.EQ)
                         .app(PS.Data.Ordering.Module.GT));
  @JvmField
  val ordBoolean = PS.Data.Ord.Module.Ord
                     .app({ _ : Any ->
                          PS.Data.Eq.Module.eqBoolean
                       })
                     .app(PS.Data.Ord.Module.ordBooleanImpl
                            .app(PS.Data.Ordering.Module.LT)
                            .app(PS.Data.Ordering.Module.EQ)
                            .app(PS.Data.Ordering.Module.GT));
  @JvmField
  val compareRecord = { dict : Any ->
     (dict as Map<String, Any>)["compareRecord"]!!
  };
  @JvmField
  val ordRecord = { dictRowToList : Any ->
     { dictOrdRecord : Any ->
       PS.Data.Ord.Module.Ord
         .app({ _ : Any ->
              PS.Data.Eq.Module.eqRec.app(Unit)
                .app((dictOrdRecord as Map<String, Any>)["EqRecord0"]!!
                       .app(Unit))
           })
         .app(PS.Data.Ord.Module.compareRecord.app(dictOrdRecord)
                .app(PS.Type.Data.RowList.Module.RLProxy))
    }
  };
  @JvmField
  val compare1 = { dict : Any ->
     (dict as Map<String, Any>)["compare1"]!!
  };
  @JvmField
  val compare = { dict : Any ->
     (dict as Map<String, Any>)["compare"]!!
  };
  @JvmField
  val comparing = { dictOrd : Any ->
     { f : Any ->
       { x : Any ->
         { y : Any ->
           PS.Data.Ord.Module.compare.app(dictOrd).app(f.app(x)).app(f.app(y))
        }
      }
    }
  };
  @JvmField
  val greaterThan = { dictOrd : Any ->
     { a1 : Any ->
       { a2 : Any ->
         object   {
             val v = PS.Data.Ord.Module.compare.app(dictOrd).app(a1).app(a2);
           }
           .run({
            val v = this.v;
            when {
              (v is PS.Data.Ordering.Module._Type_Ordering.GT) -> {
                true;
              }
              else -> {
                false;
              }
            };
          })
      }
    }
  };
  @JvmField
  val greaterThanOrEq = { dictOrd : Any ->
     { a1 : Any ->
       { a2 : Any ->
         object   {
             val v = PS.Data.Ord.Module.compare.app(dictOrd).app(a1).app(a2);
           }
           .run({
            val v = this.v;
            when {
              (v is PS.Data.Ordering.Module._Type_Ordering.LT) -> {
                false;
              }
              else -> {
                true;
              }
            };
          })
      }
    }
  };
  @JvmField
  val signum = { dictOrd : Any ->
     { dictRing : Any ->
       { x : Any ->
         when {
          (PS.Data.Ord.Module.greaterThanOrEq.app(dictOrd).app(x)
             .app(PS.Data.Semiring.Module.zero
                    .app((dictRing as Map<String, Any>)["Semiring0"]!!.app(Unit)
            )) == true) -> {
            PS.Data.Semiring.Module.one
              .app((dictRing as Map<String, Any>)["Semiring0"]!!.app(Unit));
          }
          else -> {
            PS.Data.Ring.Module.negate.app(dictRing)
              .app(PS.Data.Semiring.Module.one
                     .app((dictRing as Map<String, Any>)["Semiring0"]!!
                            .app(Unit)));
          }
        }
      }
    }
  };
  @JvmField
  val lessThan = { dictOrd : Any ->
     { a1 : Any ->
       { a2 : Any ->
         object   {
             val v = PS.Data.Ord.Module.compare.app(dictOrd).app(a1).app(a2);
           }
           .run({
            val v = this.v;
            when {
              (v is PS.Data.Ordering.Module._Type_Ordering.LT) -> {
                true;
              }
              else -> {
                false;
              }
            };
          })
      }
    }
  };
  @JvmField
  val lessThanOrEq = { dictOrd : Any ->
     { a1 : Any ->
       { a2 : Any ->
         object   {
             val v = PS.Data.Ord.Module.compare.app(dictOrd).app(a1).app(a2);
           }
           .run({
            val v = this.v;
            when {
              (v is PS.Data.Ordering.Module._Type_Ordering.GT) -> {
                false;
              }
              else -> {
                true;
              }
            };
          })
      }
    }
  };
  @JvmField
  val max = { dictOrd : Any ->
     { x : Any ->
       { y : Any ->
         object   {
             val v = PS.Data.Ord.Module.compare.app(dictOrd).app(x).app(y);
           }
           .run({
            val v = this.v;
            when {
              (v is PS.Data.Ordering.Module._Type_Ordering.LT) -> {
                y;
              }
              (v is PS.Data.Ordering.Module._Type_Ordering.EQ) -> {
                x;
              }
              (v is PS.Data.Ordering.Module._Type_Ordering.GT) -> {
                x;
              }
              else -> (error("Error in Pattern Match") as Any)
            };
          })
      }
    }
  };
  @JvmField
  val min = { dictOrd : Any ->
     { x : Any ->
       { y : Any ->
         object   {
             val v = PS.Data.Ord.Module.compare.app(dictOrd).app(x).app(y);
           }
           .run({
            val v = this.v;
            when {
              (v is PS.Data.Ordering.Module._Type_Ordering.LT) -> {
                x;
              }
              (v is PS.Data.Ordering.Module._Type_Ordering.EQ) -> {
                x;
              }
              (v is PS.Data.Ordering.Module._Type_Ordering.GT) -> {
                y;
              }
              else -> (error("Error in Pattern Match") as Any)
            };
          })
      }
    }
  };
  @JvmField
  val ordArray = { dictOrd : Any ->
     PS.Data.Ord.Module.Ord
       .app({ _ : Any ->
            PS.Data.Eq.Module.eqArray
              .app((dictOrd as Map<String, Any>)["Eq0"]!!.app(Unit))
         })
       .app(object   {
                val toDelta = { x : Any ->
                   { y : Any ->
                     object   {
                         val v = PS.Data.Ord.Module.compare.app(dictOrd).app(x)
                                   .app(y);
                       }
                       .run({
                        val v = this.v;
                        when {
                          (v is PS.Data.Ordering.Module._Type_Ordering.EQ) -> {
                            0;
                          }
                          (v is PS.Data.Ordering.Module._Type_Ordering.LT) -> {
                            1;
                          }
                          (v is PS.Data.Ordering.Module._Type_Ordering.GT) -> {
                            PS.Data.Ring.Module.negate
                              .app(PS.Data.Ring.Module.ringInt)
                              .app(1);
                          }
                          else -> (error("Error in Pattern Match") as Any)
                        };
                      })
                  }
                };
              }
              .run({
          val toDelta = this.toDelta;
          { xs : Any ->
             { ys : Any ->
               PS.Data.Ord.Module.compare.app(PS.Data.Ord.Module.ordInt).app(0)
                 .app(PS.Data.Ord.Module.ordArrayImpl.app(toDelta).app(xs)
                        .app(ys))
            }
          };
        }))
  };
  @JvmField
  val ord1Array = PS.Data.Ord.Module.Ord1
                    .app({ _ : Any ->
                         PS.Data.Eq.Module.eq1Array
                      })
                    .app({ dictOrd : Any ->
       PS.Data.Ord.Module.compare.app(PS.Data.Ord.Module.ordArray.app(dictOrd))
    });
  @JvmField
  val ordRecordCons = { dictOrdRecord : Any ->
     { dictCons : Any ->
       { dictIsSymbol : Any ->
         { dictOrd : Any ->
           PS.Data.Ord.Module.OrdRecord
             .app({ _ : Any ->
                  PS.Data.Eq.Module.eqRowCons
                    .app((dictOrdRecord as Map<String, Any>)["EqRecord0"]!!
                           .app(Unit))
                    .app(Unit)
                    .app(dictIsSymbol)
                    .app((dictOrd as Map<String, Any>)["Eq0"]!!.app(Unit))
               })
             .app({ v : Any ->
               { ra : Any ->
                 { rb : Any ->
                   object   {
                       val unsafeGet_tick = PS.Record.Unsafe.Module.unsafeGet;
                       val key = PS.Data.Symbol.Module.reflectSymbol
                                   .app(dictIsSymbol)
                                   .app(PS.Data.Symbol.Module.SProxy);
                       val left = PS.Data.Ord.Module.compare.app(dictOrd)
                                    .app(unsafeGet_tick.app(key).app(ra))
                                    .app(unsafeGet_tick.app(key).app(rb));
                     }
                     .run({
                      val unsafeGet_tick = this.unsafeGet_tick;
                      val key = this.key;
                      val left = this.left;
                      when {
                        (PS.Data.Eq.Module.notEq
                           .app(PS.Data.Ordering.Module.eqOrdering)
                           .app(left)
                           .app(PS.Data.Ordering.Module.EQ) == true) -> {
                          left;
                        }
                        else -> {
                          PS.Data.Ord.Module.compareRecord.app(dictOrdRecord)
                            .app(PS.Type.Data.RowList.Module.RLProxy)
                            .app(ra)
                            .app(rb);
                        }
                      };
                    })
                }
              }
            })
        }
      }
    }
  };
  @JvmField
  val clamp = { dictOrd : Any ->
     { low : Any ->
       { hi : Any ->
         { x : Any ->
           PS.Data.Ord.Module.min.app(dictOrd).app(hi)
             .app(PS.Data.Ord.Module.max.app(dictOrd).app(low).app(x))
        }
      }
    }
  };
  @JvmField
  val between = { dictOrd : Any ->
     { low : Any ->
       { hi : Any ->
         { x : Any ->
           when {
            (PS.Data.Ord.Module.lessThan.app(dictOrd).app(x)
               .app(low) as Boolean) -> {
              val low1 = low;
              val hi1 = hi;
              val x1 = x;
              false;
            }
            (PS.Data.Ord.Module.greaterThan.app(dictOrd).app(x)
               .app(hi) as Boolean) -> {
              val low1 = low;
              val hi1 = hi;
              val x1 = x;
              false;
            }
            (true as Boolean) -> {
              val low1 = low;
              val hi1 = hi;
              val x1 = x;
              true;
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      }
    }
  };
  @JvmField
  val abs = { dictOrd : Any ->
     { dictRing : Any ->
       { x : Any ->
         when {
          (PS.Data.Ord.Module.greaterThanOrEq.app(dictOrd).app(x)
             .app(PS.Data.Semiring.Module.zero
                    .app((dictRing as Map<String, Any>)["Semiring0"]!!.app(Unit)
            )) == true) -> {
            x;
          }
          else -> {
            PS.Data.Ring.Module.negate.app(dictRing).app(x);
          }
        }
      }
    }
  };
}