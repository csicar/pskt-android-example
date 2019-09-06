@file:Suppress("UNCHECKED_CAST")
package PS.Data.Monoid
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val MonoidRecord = { SemigroupRecord0 : Any ->
     { memptyRecord : Any ->
       mapOf(("SemigroupRecord0" to SemigroupRecord0),  
        ("memptyRecord" to memptyRecord))
    }
  };
  @JvmField
  val Monoid = { Semigroup0 : Any ->
     { mempty : Any ->
       mapOf(("Semigroup0" to Semigroup0),  ("mempty" to mempty))
    }
  };
  @JvmField
  val monoidUnit = PS.Data.Monoid.Module.Monoid
                     .app({ _ : Any ->
                          PS.Data.Semigroup.Module.semigroupUnit
                       })
                     .app(PS.Data.Unit.Module.unit);
  @JvmField
  val monoidString = PS.Data.Monoid.Module.Monoid
                       .app({ _ : Any ->
                            PS.Data.Semigroup.Module.semigroupString
                         })
                       .app("");
  @JvmField
  val monoidRecordNil = PS.Data.Monoid.Module.MonoidRecord
                          .app({ _ : Any ->
                               PS.Data.Semigroup.Module.semigroupRecordNil
                            })
                          .app({ v : Any ->
       emptyMap<String, Any>()
    });
  @JvmField
  val monoidOrdering = PS.Data.Monoid.Module.Monoid
                         .app({ _ : Any ->
                              PS.Data.Ordering.Module.semigroupOrdering
                           })
                         .app(PS.Data.Ordering.Module.EQ);
  @JvmField
  val monoidArray = PS.Data.Monoid.Module.Monoid
                      .app({ _ : Any ->
                           PS.Data.Semigroup.Module.semigroupArray
                        })
                      .app(emptyList<Any>());
  @JvmField
  val memptyRecord = { dict : Any ->
     (dict as Map<String, Any>)["memptyRecord"]!!
  };
  @JvmField
  val monoidRecord = { dictRowToList : Any ->
     { dictMonoidRecord : Any ->
       PS.Data.Monoid.Module.Monoid
         .app({ _ : Any ->
              PS.Data.Semigroup.Module.semigroupRecord.app(Unit)
                .app(
               (dictMonoidRecord as Map<String, Any>)["SemigroupRecord0"]!!
                 .app(Unit))
           })
         .app(PS.Data.Monoid.Module.memptyRecord.app(dictMonoidRecord)
                .app(PS.Type.Data.RowList.Module.RLProxy))
    }
  };
  @JvmField
  val mempty = { dict : Any ->
     (dict as Map<String, Any>)["mempty"]!!
  };
  @JvmField
  val monoidFn = { dictMonoid : Any ->
     PS.Data.Monoid.Module.Monoid
       .app({ _ : Any ->
            PS.Data.Semigroup.Module.semigroupFn
              .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!.app(Unit))
         })
       .app({ v : Any ->
         PS.Data.Monoid.Module.mempty.app(dictMonoid)
      })
  };
  @JvmField
  val monoidRecordCons = { dictIsSymbol : Any ->
     { dictMonoid : Any ->
       { dictCons : Any ->
         { dictMonoidRecord : Any ->
           PS.Data.Monoid.Module.MonoidRecord
             .app({ _ : Any ->
                  PS.Data.Semigroup.Module.semigroupRecordCons.app(dictIsSymbol)
                    .app(Unit)
                    .app(
                      (dictMonoidRecord as Map<String, Any>)["SemigroupRecord0"]!!
                        .app(Unit))
                    .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!
                           .app(Unit))
               })
             .app({ v : Any ->
               object   {
                   val tail = PS.Data.Monoid.Module.memptyRecord
                                .app(dictMonoidRecord)
                                .app(PS.Type.Data.RowList.Module.RLProxy);
                   val key = PS.Data.Symbol.Module.reflectSymbol
                               .app(dictIsSymbol)
                               .app(PS.Data.Symbol.Module.SProxy);
                   val insert = PS.Record.Unsafe.Module.unsafeSet.app(key);
                 }
                 .run({
                  val tail = this.tail;
                  val key = this.key;
                  val insert = this.insert;
                  insert.app(PS.Data.Monoid.Module.mempty.app(dictMonoid))
                    .app(tail);
                })
            })
        }
      }
    }
  };
  @JvmField
  val power = { dictMonoid : Any ->
     { x : Any ->
       object   {
           val go = (::__rec_go)();
           fun __rec_go(): Any = { p : Any ->
              when {
               (PS.Data.Ord.Module.lessThanOrEq.app(PS.Data.Ord.Module.ordInt)
                  .app(p)
                  .app(0) as Boolean) -> {
                 val p1 = p;
                 PS.Data.Monoid.Module.mempty.app(dictMonoid);
               }
               (PS.Data.Eq.Module.eq.app(PS.Data.Eq.Module.eqInt).app(p)
                  .app(1) as Boolean) -> {
                 val p1 = p;
                 x;
               }
               (PS.Data.Eq.Module.eq.app(PS.Data.Eq.Module.eqInt)
                  .app(PS.Data.EuclideanRing.Module.mod
                         .app(PS.Data.EuclideanRing.Module.euclideanRingInt)
                         .app(p)
                         .app(2))
                  .app(0) as Boolean) -> {
                 val p1 = p;
                 object   {
                     val x_tick = __rec_go()
                                    .app(PS.Data.EuclideanRing.Module.div
                                           .app(
                                             PS.Data.EuclideanRing.Module.euclideanRingInt
                                           )
                                           .app(p1)
                                           .app(2));
                   }
                   .run({
                     val x_tick = this.x_tick;
                     PS.Data.Semigroup.Module.append
                       .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!
                              .app(Unit))
                       .app(x_tick)
                       .app(x_tick);
                   });
               }
               (PS.Data.Boolean.Module.otherwise as Boolean) -> {
                 val p1 = p;
                 object   {
                     val x_tick = __rec_go()
                                    .app(PS.Data.EuclideanRing.Module.div
                                           .app(
                                             PS.Data.EuclideanRing.Module.euclideanRingInt
                                           )
                                           .app(p1)
                                           .app(2));
                   }
                   .run({
                     val x_tick = this.x_tick;
                     PS.Data.Semigroup.Module.append
                       .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!
                              .app(Unit))
                       .app(x_tick)
                       .app(PS.Data.Semigroup.Module.append
                              .app(
                                (dictMonoid as Map<String, Any>)["Semigroup0"]!!
                                  .app(Unit))
                              .app(x_tick)
                              .app(x));
                   });
               }
               else -> (error("Error in Pattern Match") as Any)
             }
           };
         }
         .run({
          val go = this.go;
          go;
        })
    }
  };
  @JvmField
  val guard = { dictMonoid : Any ->
     { v : Any ->
       { v1 : Any ->
         when {
          (v == true) -> {
            val a = v1;
            a;
          }
          (v == false) -> {
            PS.Data.Monoid.Module.mempty.app(dictMonoid);
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    }
  };
}