@file:Suppress("UNCHECKED_CAST")
package PS.Data.DateTime
import Foreign.PsRuntime.app
object Module  {
  val calcDiff = Foreign.Data.DateTime.calcDiff;
  val adjustImpl = Foreign.Data.DateTime.adjustImpl;
  sealed class _Type_DateTime ()  {
    data class DateTime (val value0 : Any,  val value1 : Any) : _Type_DateTime(
    ) {};
  };
  val DateTime = { value0 : Any ->
     { value1 : Any ->
       _Type_DateTime.DateTime(value0,  value1)
    }
  };
  @JvmField
  val toRecord = { v : Any ->
     when {
      (v is PS.Data.DateTime.Module._Type_DateTime.DateTime) -> {
        val d = v.value0;
        val t = v.value1;
        mapOf(("year" to PS.Data.Enum.Module.fromEnum
                           .app(PS.Data.Date.Component.Module.boundedEnumYear)
                           .app(PS.Data.Date.Module.year.app(d))),  
          ("month" to PS.Data.Enum.Module.fromEnum
                        .app(PS.Data.Date.Component.Module.boundedEnumMonth)
                        .app(PS.Data.Date.Module.month.app(d))),  
          ("day" to PS.Data.Enum.Module.fromEnum
                      .app(PS.Data.Date.Component.Module.boundedEnumDay)
                      .app(PS.Data.Date.Module.day.app(d))),  
          ("hour" to PS.Data.Enum.Module.fromEnum
                       .app(PS.Data.Time.Component.Module.boundedEnumHour)
                       .app(PS.Data.Time.Module.hour.app(t))),  
          ("minute" to PS.Data.Enum.Module.fromEnum
                         .app(PS.Data.Time.Component.Module.boundedEnumMinute)
                         .app(PS.Data.Time.Module.minute.app(t))),  
          ("second" to PS.Data.Enum.Module.fromEnum
                         .app(PS.Data.Time.Component.Module.boundedEnumSecond)
                         .app(PS.Data.Time.Module.second.app(t))),  
          ("millisecond" to PS.Data.Enum.Module.fromEnum
                              .app(
                                PS.Data.Time.Component.Module.boundedEnumMillisecond
                              )
                              .app(PS.Data.Time.Module.millisecond.app(t))));
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val time = { v : Any ->
     when {
      (v is PS.Data.DateTime.Module._Type_DateTime.DateTime) -> {
        val t = v.value1;
        t;
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val showDateTime = PS.Data.Show.Module.Show
                       .app({ v : Any ->
       when {
        (v is PS.Data.DateTime.Module._Type_DateTime.DateTime) -> {
          val d = v.value0;
          val t = v.value1;
          (("(DateTime " as String) + (((PS.Data.Show.Module.show
                                           .app(PS.Data.Date.Module.showDate)
                                           .app(d
          ) as String) + (((" " as String) + (((PS.Data.Show.Module.show
                                                  .app(
                                                    PS.Data.Time.Module.showTime
                                                  )
                                                  .app(t
          ) as String) + (")" as String)) as String)) as String)) as String));
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    });
  @JvmField
  val modifyTimeF = { dictFunctor : Any ->
     { f : Any ->
       { v : Any ->
         when {
          (v is PS.Data.DateTime.Module._Type_DateTime.DateTime) -> {
            val f1 = f;
            val d = v.value0;
            val t = v.value1;
            PS.Data.Functor.Module.map.app(dictFunctor)
              .app(PS.Data.DateTime.Module.DateTime.app(d))
              .app(f1.app(t));
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    }
  };
  @JvmField
  val modifyTime = { f : Any ->
     { v : Any ->
       when {
        (v is PS.Data.DateTime.Module._Type_DateTime.DateTime) -> {
          val f1 = f;
          val d = v.value0;
          val t = v.value1;
          PS.Data.DateTime.Module.DateTime.app(d).app(f1.app(t));
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val modifyDateF = { dictFunctor : Any ->
     { f : Any ->
       { v : Any ->
         when {
          (v is PS.Data.DateTime.Module._Type_DateTime.DateTime) -> {
            val f1 = f;
            val d = v.value0;
            val t = v.value1;
            PS.Data.Functor.Module.map.app(dictFunctor)
              .app(PS.Data.Function.Module.flip
                     .app(PS.Data.DateTime.Module.DateTime)
                     .app(t))
              .app(f1.app(d));
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    }
  };
  @JvmField
  val modifyDate = { f : Any ->
     { v : Any ->
       when {
        (v is PS.Data.DateTime.Module._Type_DateTime.DateTime) -> {
          val f1 = f;
          val d = v.value0;
          val t = v.value1;
          PS.Data.DateTime.Module.DateTime.app(f1.app(d)).app(t);
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val eqDateTime = PS.Data.Eq.Module.Eq
                     .app({ x : Any ->
       { y : Any ->
         when {
          (x is PS.Data.DateTime.Module._Type_DateTime
                  .DateTime)&& (y is PS.Data.DateTime.Module._Type_DateTime
                                       .DateTime) -> {
            val l = x.value0;
            val l1 = x.value1;
            val r = y.value0;
            val r1 = y.value1;
            PS.Data.HeytingAlgebra.Module.conj
              .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
              .app(PS.Data.Eq.Module.eq.app(PS.Data.Date.Module.eqDate).app(l)
                     .app(r))
              .app(PS.Data.Eq.Module.eq.app(PS.Data.Time.Module.eqTime).app(l1)
                     .app(r1));
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val ordDateTime = PS.Data.Ord.Module.Ord
                      .app({ _ : Any ->
                           PS.Data.DateTime.Module.eqDateTime
                        })
                      .app({ x : Any ->
       { y : Any ->
         when {
          (x is PS.Data.DateTime.Module._Type_DateTime
                  .DateTime)&& (y is PS.Data.DateTime.Module._Type_DateTime
                                       .DateTime) -> {
            val l = x.value0;
            val l1 = x.value1;
            val r = y.value0;
            val r1 = y.value1;
            object   {
                val v = PS.Data.Ord.Module.compare
                          .app(PS.Data.Date.Module.ordDate)
                          .app(l)
                          .app(r);
              }
              .run({
                val v = this.v;
                when {
                  (v is PS.Data.Ordering.Module._Type_Ordering.LT) -> {
                    PS.Data.Ordering.Module.LT;
                  }
                  (v is PS.Data.Ordering.Module._Type_Ordering.GT) -> {
                    PS.Data.Ordering.Module.GT;
                  }
                  else -> {
                    PS.Data.Ord.Module.compare.app(PS.Data.Time.Module.ordTime)
                      .app(l1)
                      .app(r1);
                  }
                };
              });
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val diff = { dictDuration : Any ->
     { dt1 : Any ->
       { dt2 : Any ->
         PS.Data.Function.Module.apply
           .app(PS.Data.Time.Duration.Module.toDuration.app(dictDuration))
           .app(PS.Data.Function.Uncurried.Module.runFn2
                  .app(PS.Data.DateTime.Module.calcDiff)
                  .app(PS.Data.DateTime.Module.toRecord.app(dt1))
                  .app(PS.Data.DateTime.Module.toRecord.app(dt2)))
      }
    }
  };
  @JvmField
  val date = { v : Any ->
     when {
      (v is PS.Data.DateTime.Module._Type_DateTime.DateTime) -> {
        val d = v.value0;
        d;
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val boundedDateTime = PS.Data.Bounded.Module.Bounded
                          .app({ _ : Any ->
                               PS.Data.DateTime.Module.ordDateTime
                            })
                          .app(PS.Data.DateTime.Module.DateTime
                                 .app(PS.Data.Bounded.Module.bottom
                                        .app(PS.Data.Date.Module.boundedDate))
                                 .app(PS.Data.Bounded.Module.bottom
                                        .app(PS.Data.Time.Module.boundedTime)))
                          .app(PS.Data.DateTime.Module.DateTime
                                 .app(PS.Data.Bounded.Module.top
                                        .app(PS.Data.Date.Module.boundedDate))
                                 .app(PS.Data.Bounded.Module.top
                                        .app(PS.Data.Time.Module.boundedTime)));
  @JvmField
  val adjust = { dictDuration : Any ->
     { d : Any ->
       { dt : Any ->
         PS.Control.Bind.Module.bind.app(PS.Data.Maybe.Module.bindMaybe)
           .app(PS.Data.DateTime.Module.adjustImpl
                  .app(PS.Data.Maybe.Module.Just)
                  .app(PS.Data.Maybe.Module.Nothing)
                  .app(PS.Data.Time.Duration.Module.fromDuration
                         .app(dictDuration)
                         .app(d))
                  .app(PS.Data.DateTime.Module.toRecord.app(dt)))
           .app({ rec : Any ->
             PS.Control.Apply.Module.apply.app(PS.Data.Maybe.Module.applyMaybe)
               .app(PS.Data.Functor.Module.map
                      .app(PS.Data.Maybe.Module.functorMaybe)
                      .app(PS.Data.DateTime.Module.DateTime)
                      .app(PS.Control.Bind.Module.join
                             .app(PS.Data.Maybe.Module.bindMaybe)
                             .app(PS.Control.Apply.Module.apply
                                    .app(PS.Data.Maybe.Module.applyMaybe)
                                    .app(PS.Control.Apply.Module.apply
                                           .app(PS.Data.Maybe.Module.applyMaybe)
                                           .app(PS.Data.Functor.Module.map
                                                  .app(
                                                    PS.Data.Maybe.Module.functorMaybe
                                                  )
                                                  .app(
                                                    PS.Data.Date.Module.exactDate
                                                  )
                                                  .app(
                                               PS.Data.Enum.Module.toEnum
                                                 .app(
                                                   PS.Data.Date.Component.Module.boundedEnumYear
                                                 )
                                                 .app(
                                                 (rec as Map<String, Any>)["year"]!!
                                               )))
                                           .app(PS.Data.Enum.Module.toEnum
                                                  .app(
                                                    PS.Data.Date.Component.Module.boundedEnumMonth
                                                  )
                                                  .app(
                                          (rec as Map<String, Any>)["month"]!!))
                                    )
                                    .app(PS.Data.Enum.Module.toEnum
                                           .app(
                                             PS.Data.Date.Component.Module.boundedEnumDay
                                           )
                                           .app(
                         (rec as Map<String, Any>)["day"]!!)))))
               .app(PS.Control.Apply.Module.apply
                      .app(PS.Data.Maybe.Module.applyMaybe)
                      .app(PS.Control.Apply.Module.apply
                             .app(PS.Data.Maybe.Module.applyMaybe)
                             .app(PS.Control.Apply.Module.apply
                                    .app(PS.Data.Maybe.Module.applyMaybe)
                                    .app(PS.Data.Functor.Module.map
                                           .app(
                                             PS.Data.Maybe.Module.functorMaybe)
                                           .app(PS.Data.Time.Module.Time)
                                           .app(PS.Data.Enum.Module.toEnum
                                                  .app(
                                                    PS.Data.Time.Component.Module.boundedEnumHour
                                                  )
                                                  .app(
                                          (rec as Map<String, Any>)["hour"]!!)))
                                    .app(PS.Data.Enum.Module.toEnum
                                           .app(
                                             PS.Data.Time.Component.Module.boundedEnumMinute
                                           )
                                           .app(
                                   (rec as Map<String, Any>)["minute"]!!)))
                             .app(PS.Data.Enum.Module.toEnum
                                    .app(
                                      PS.Data.Time.Component.Module.boundedEnumSecond
                                    )
                                    .app((rec as Map<String, Any>)["second"]!!))
                      )
                      .app(PS.Data.Enum.Module.toEnum
                             .app(
                               PS.Data.Time.Component.Module.boundedEnumMillisecond
                             )
                             .app((rec as Map<String, Any>)["millisecond"]!!)))
          })
      }
    }
  };
}