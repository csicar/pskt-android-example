@file:Suppress("UNCHECKED_CAST")
package PS.Data.Time
import Foreign.PsRuntime.app
object Module  {
  sealed class _Type_Time ()  {
    data class Time (val value0 : Any,  val value1 : Any,  val value2 : Any, 
    val value3 : Any) : _Type_Time() {};
  };
  val Time = { value0 : Any ->
     { value1 : Any ->
       { value2 : Any ->
         { value3 : Any ->
           _Type_Time.Time(value0,  value1,  value2,  value3)
        }
      }
    }
  };
  @JvmField
  val showTime = PS.Data.Show.Module.Show
                   .app({ v : Any ->
       when {
        (v is PS.Data.Time.Module._Type_Time.Time) -> {
          val h = v.value0;
          val m = v.value1;
          val s = v.value2;
          val ms = v.value3;
          (("(Time " as String) + (((PS.Data.Show.Module.show
                                       .app(
                                         PS.Data.Time.Component.Module.showHour)
                                       .app(h
          ) as String) + (((" " as String) + (((PS.Data.Show.Module.show
                                                  .app(
                                                    PS.Data.Time.Component.Module.showMinute
                                                  )
                                                  .app(m
          ) as String) + (((" " as String) + (((PS.Data.Show.Module.show
                                                  .app(
                                                    PS.Data.Time.Component.Module.showSecond
                                                  )
                                                  .app(s
          ) as String) + (((" " as String) + (((PS.Data.Show.Module.show
                                                  .app(
                                                    PS.Data.Time.Component.Module.showMillisecond
                                                  )
                                                  .app(ms
          ) as String) + (")" as String)) as String)) as String)) as String)) as String)) as String)) as String)) as String));
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    });
  @JvmField
  val setSecond = { s : Any ->
     { v : Any ->
       when {
        (v is PS.Data.Time.Module._Type_Time.Time) -> {
          val s1 = s;
          val h = v.value0;
          val m = v.value1;
          val ms = v.value3;
          PS.Data.Time.Module.Time.app(h).app(m).app(s1).app(ms);
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val setMinute = { m : Any ->
     { v : Any ->
       when {
        (v is PS.Data.Time.Module._Type_Time.Time) -> {
          val m1 = m;
          val h = v.value0;
          val s = v.value2;
          val ms = v.value3;
          PS.Data.Time.Module.Time.app(h).app(m1).app(s).app(ms);
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val setMillisecond = { ms : Any ->
     { v : Any ->
       when {
        (v is PS.Data.Time.Module._Type_Time.Time) -> {
          val ms1 = ms;
          val h = v.value0;
          val m = v.value1;
          val s = v.value2;
          PS.Data.Time.Module.Time.app(h).app(m).app(s).app(ms1);
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val setHour = { h : Any ->
     { v : Any ->
       when {
        (v is PS.Data.Time.Module._Type_Time.Time) -> {
          val h1 = h;
          val m = v.value1;
          val s = v.value2;
          val ms = v.value3;
          PS.Data.Time.Module.Time.app(h1).app(m).app(s).app(ms);
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val second = { v : Any ->
     when {
      (v is PS.Data.Time.Module._Type_Time.Time) -> {
        val s = v.value2;
        s;
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val minute = { v : Any ->
     when {
      (v is PS.Data.Time.Module._Type_Time.Time) -> {
        val m = v.value1;
        m;
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val millisecond = { v : Any ->
     when {
      (v is PS.Data.Time.Module._Type_Time.Time) -> {
        val ms = v.value3;
        ms;
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val millisToTime = { v : Any ->
     when {
      else -> {
        val ms = v;
        val ms_tick = v;
        object   {
            val secondLength = 1000.0;
            val minuteLength = 60000.0;
            val hourLength = 3600000.0;
            val hours = PS.Math.Module.floor
                          .app(PS.Data.EuclideanRing.Module.div
                                 .app(
                                   PS.Data.EuclideanRing.Module.euclideanRingNumber
                                 )
                                 .app(ms_tick)
                                 .app(hourLength));
            val minutes = PS.Math.Module.floor
                            .app(PS.Data.EuclideanRing.Module.div
                                   .app(
                                     PS.Data.EuclideanRing.Module.euclideanRingNumber
                                   )
                                   .app(PS.Data.Ring.Module.sub
                                          .app(PS.Data.Ring.Module.ringNumber)
                                          .app(ms_tick)
                                          .app(PS.Data.Semiring.Module.mul
                                                 .app(
                                                   PS.Data.Semiring.Module.semiringNumber
                                                 )
                                                 .app(hours)
                                                 .app(hourLength)))
                                   .app(minuteLength));
            val seconds = PS.Math.Module.floor
                            .app(PS.Data.EuclideanRing.Module.div
                                   .app(
                                     PS.Data.EuclideanRing.Module.euclideanRingNumber
                                   )
                                   .app(PS.Data.Ring.Module.sub
                                          .app(PS.Data.Ring.Module.ringNumber)
                                          .app(ms_tick)
                                          .app(PS.Data.Semiring.Module.add
                                                 .app(
                                                   PS.Data.Semiring.Module.semiringNumber
                                                 )
                                                 .app(
                                                   PS.Data.Semiring.Module.mul
                                                     .app(
                                                       PS.Data.Semiring.Module.semiringNumber
                                                     )
                                                     .app(hours)
                                                     .app(hourLength))
                                                 .app(
                                         PS.Data.Semiring.Module.mul
                                           .app(
                                             PS.Data.Semiring.Module.semiringNumber
                                           )
                                           .app(minutes)
                                           .app(minuteLength))))
                                   .app(secondLength));
            val milliseconds = PS.Data.Ring.Module.sub
                                 .app(PS.Data.Ring.Module.ringNumber)
                                 .app(ms_tick)
                                 .app(PS.Data.Semiring.Module.add
                                        .app(
                                          PS.Data.Semiring.Module.semiringNumber
                                        )
                                        .app(PS.Data.Semiring.Module.add
                                               .app(
                                                 PS.Data.Semiring.Module.semiringNumber
                                               )
                                               .app(PS.Data.Semiring.Module.mul
                                                      .app(
                                                        PS.Data.Semiring.Module.semiringNumber
                                                      )
                                                      .app(hours)
                                                      .app(hourLength))
                                               .app(PS.Data.Semiring.Module.mul
                                                      .app(
                                                        PS.Data.Semiring.Module.semiringNumber
                                                      )
                                                      .app(minutes)
                                                      .app(minuteLength)))
                                        .app(PS.Data.Semiring.Module.mul
                                               .app(
                                                 PS.Data.Semiring.Module.semiringNumber
                                               )
                                               .app(seconds)
                                               .app(secondLength)));
          }
          .run({
            val secondLength = this.secondLength;
            val minuteLength = this.minuteLength;
            val hourLength = this.hourLength;
            val hours = this.hours;
            val minutes = this.minutes;
            val seconds = this.seconds;
            val milliseconds = this.milliseconds;
            PS.Data.Function.Module.apply
              .app(PS.Partial.Unsafe.Module.unsafePartial
                     .app({ dictPartial : Any ->
                     PS.Data.Maybe.Module.fromJust.app(Unit)
                  }))
              .app(PS.Control.Apply.Module.apply
                     .app(PS.Data.Maybe.Module.applyMaybe)
                     .app(PS.Control.Apply.Module.apply
                            .app(PS.Data.Maybe.Module.applyMaybe)
                            .app(PS.Control.Apply.Module.apply
                                   .app(PS.Data.Maybe.Module.applyMaybe)
                                   .app(PS.Data.Functor.Module.map
                                          .app(PS.Data.Maybe.Module.functorMaybe
                                          )
                                          .app(PS.Data.Time.Module.Time)
                                          .app(PS.Data.Enum.Module.toEnum
                                                 .app(
                                                   PS.Data.Time.Component.Module.boundedEnumHour
                                                 )
                                                 .app(PS.Data.Int.Module.floor
                                                        .app(hours))))
                                   .app(PS.Data.Enum.Module.toEnum
                                          .app(
                                            PS.Data.Time.Component.Module.boundedEnumMinute
                                          )
                                          .app(PS.Data.Int.Module.floor
                                                 .app(minutes))))
                            .app(PS.Data.Enum.Module.toEnum
                                   .app(
                                     PS.Data.Time.Component.Module.boundedEnumSecond
                                   )
                                   .app(PS.Data.Int.Module.floor.app(seconds))))
                     .app(PS.Data.Enum.Module.toEnum
                            .app(
                              PS.Data.Time.Component.Module.boundedEnumMillisecond
                            )
                            .app(PS.Data.Int.Module.floor.app(milliseconds))));
          });
      }
    }
  };
  @JvmField
  val hour = { v : Any ->
     when {
      (v is PS.Data.Time.Module._Type_Time.Time) -> {
        val h = v.value0;
        h;
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val timeToMillis = { t : Any ->
     PS.Data.Function.Module.apply
       .app(PS.Data.Time.Duration.Module.Milliseconds)
       .app(PS.Data.Semiring.Module.add
              .app(PS.Data.Semiring.Module.semiringNumber)
              .app(PS.Data.Semiring.Module.add
                     .app(PS.Data.Semiring.Module.semiringNumber)
                     .app(PS.Data.Semiring.Module.add
                            .app(PS.Data.Semiring.Module.semiringNumber)
                            .app(PS.Data.Semiring.Module.mul
                                   .app(PS.Data.Semiring.Module.semiringNumber)
                                   .app(3600000.0)
                                   .app(PS.Data.Int.Module.toNumber
                                          .app(PS.Data.Enum.Module.fromEnum
                                                 .app(
                                                   PS.Data.Time.Component.Module.boundedEnumHour
                                                 )
                                                 .app(PS.Data.Time.Module.hour
                                                        .app(t)))))
                            .app(PS.Data.Semiring.Module.mul
                                   .app(PS.Data.Semiring.Module.semiringNumber)
                                   .app(60000.0)
                                   .app(PS.Data.Int.Module.toNumber
                                          .app(PS.Data.Enum.Module.fromEnum
                                                 .app(
                                                   PS.Data.Time.Component.Module.boundedEnumMinute
                                                 )
                                                 .app(PS.Data.Time.Module.minute
                                                        .app(t))))))
                     .app(PS.Data.Semiring.Module.mul
                            .app(PS.Data.Semiring.Module.semiringNumber)
                            .app(1000.0)
                            .app(PS.Data.Int.Module.toNumber
                                   .app(PS.Data.Enum.Module.fromEnum
                                          .app(
                                            PS.Data.Time.Component.Module.boundedEnumSecond
                                          )
                                          .app(PS.Data.Time.Module.second.app(t)
                      )))))
              .app(PS.Data.Int.Module.toNumber
                     .app(PS.Data.Enum.Module.fromEnum
                            .app(
                              PS.Data.Time.Component.Module.boundedEnumMillisecond
                            )
                            .app(PS.Data.Time.Module.millisecond.app(t)))))
  };
  @JvmField
  val eqTime = PS.Data.Eq.Module.Eq
                 .app({ x : Any ->
       { y : Any ->
         when {
          (x is PS.Data.Time.Module._Type_Time
                  .Time)&& (y is PS.Data.Time.Module._Type_Time
                                   .Time) -> {
            val l = x.value0;
            val l1 = x.value1;
            val l2 = x.value2;
            val l3 = x.value3;
            val r = y.value0;
            val r1 = y.value1;
            val r2 = y.value2;
            val r3 = y.value3;
            PS.Data.HeytingAlgebra.Module.conj
              .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
              .app(PS.Data.HeytingAlgebra.Module.conj
                     .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
                     .app(PS.Data.HeytingAlgebra.Module.conj
                            .app(
                              PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean
                            )
                            .app(PS.Data.Eq.Module.eq
                                   .app(PS.Data.Time.Component.Module.eqHour)
                                   .app(l)
                                   .app(r))
                            .app(PS.Data.Eq.Module.eq
                                   .app(PS.Data.Time.Component.Module.eqMinute)
                                   .app(l1)
                                   .app(r1)))
                     .app(PS.Data.Eq.Module.eq
                            .app(PS.Data.Time.Component.Module.eqSecond)
                            .app(l2)
                            .app(r2)))
              .app(PS.Data.Eq.Module.eq
                     .app(PS.Data.Time.Component.Module.eqMillisecond)
                     .app(l3)
                     .app(r3));
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val ordTime = PS.Data.Ord.Module.Ord
                  .app({ _ : Any ->
                       PS.Data.Time.Module.eqTime
                    })
                  .app({ x : Any ->
       { y : Any ->
         when {
          (x is PS.Data.Time.Module._Type_Time
                  .Time)&& (y is PS.Data.Time.Module._Type_Time
                                   .Time) -> {
            val l = x.value0;
            val l1 = x.value1;
            val l2 = x.value2;
            val l3 = x.value3;
            val r = y.value0;
            val r1 = y.value1;
            val r2 = y.value2;
            val r3 = y.value3;
            object   {
                val v = PS.Data.Ord.Module.compare
                          .app(PS.Data.Time.Component.Module.ordHour)
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
                    object   {
                        val v1 = PS.Data.Ord.Module.compare
                                   .app(PS.Data.Time.Component.Module.ordMinute)
                                   .app(l1)
                                   .app(r1);
                      }
                      .run({
                        val v1 = this.v1;
                        when {
                          (v1 is PS.Data.Ordering.Module._Type_Ordering.LT) -> {
                            PS.Data.Ordering.Module.LT;
                          }
                          (v1 is PS.Data.Ordering.Module._Type_Ordering.GT) -> {
                            PS.Data.Ordering.Module.GT;
                          }
                          else -> {
                            object   {
                                val v2 = PS.Data.Ord.Module.compare
                                           .app(
                                             PS.Data.Time.Component.Module.ordSecond
                                           )
                                           .app(l2)
                                           .app(r2);
                              }
                              .run({
                                val v2 = this.v2;
                                when {
                                  (v2 is PS.Data.Ordering.Module._Type_Ordering
                                           .LT) -> {
                                    PS.Data.Ordering.Module.LT;
                                  }
                                  (v2 is PS.Data.Ordering.Module._Type_Ordering
                                           .GT) -> {
                                    PS.Data.Ordering.Module.GT;
                                  }
                                  else -> {
                                    PS.Data.Ord.Module.compare
                                      .app(
                                        PS.Data.Time.Component.Module.ordMillisecond
                                      )
                                      .app(l3)
                                      .app(r3);
                                  }
                                };
                              });
                          }
                        };
                      });
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
     { t1 : Any ->
       { t2 : Any ->
         PS.Data.Time.Duration.Module.toDuration.app(dictDuration)
           .app(PS.Data.Semigroup.Module.append
                  .app(PS.Data.Time.Duration.Module.semigroupMilliseconds)
                  .app(PS.Data.Time.Module.timeToMillis.app(t1))
                  .app(PS.Data.Time.Duration.Module.negateDuration
                         .app(PS.Data.Time.Duration.Module.durationMilliseconds)
                         .app(PS.Data.Time.Module.timeToMillis.app(t2))))
      }
    }
  };
  @JvmField
  val boundedTime = PS.Data.Bounded.Module.Bounded
                      .app({ _ : Any ->
                           PS.Data.Time.Module.ordTime
                        })
                      .app(PS.Data.Time.Module.Time
                             .app(PS.Data.Bounded.Module.bottom
                                    .app(
                                 PS.Data.Time.Component.Module.boundedHour))
                             .app(PS.Data.Bounded.Module.bottom
                                    .app(
                                 PS.Data.Time.Component.Module.boundedMinute))
                             .app(PS.Data.Bounded.Module.bottom
                                    .app(
                                 PS.Data.Time.Component.Module.boundedSecond))
                             .app(PS.Data.Bounded.Module.bottom
                                    .app(
                            PS.Data.Time.Component.Module.boundedMillisecond)))
                      .app(PS.Data.Time.Module.Time
                             .app(PS.Data.Bounded.Module.top
                                    .app(
                                 PS.Data.Time.Component.Module.boundedHour))
                             .app(PS.Data.Bounded.Module.top
                                    .app(
                                 PS.Data.Time.Component.Module.boundedMinute))
                             .app(PS.Data.Bounded.Module.top
                                    .app(
                                 PS.Data.Time.Component.Module.boundedSecond))
                             .app(PS.Data.Bounded.Module.top
                                    .app(
        PS.Data.Time.Component.Module.boundedMillisecond)));
  @JvmField
  val maxTime = PS.Data.Time.Module.timeToMillis
                  .app(PS.Data.Bounded.Module.top
                         .app(PS.Data.Time.Module.boundedTime));
  @JvmField
  val minTime = PS.Data.Time.Module.timeToMillis
                  .app(PS.Data.Bounded.Module.bottom
                         .app(PS.Data.Time.Module.boundedTime));
  @JvmField
  val adjust = { dictDuration : Any ->
     { d : Any ->
       { t : Any ->
         object   {
             val tLength = PS.Data.Time.Module.timeToMillis.app(t);
             val dayLength = 8.64e7;
             val d_tick = PS.Data.Time.Duration.Module.fromDuration
                            .app(dictDuration)
                            .app(d);
             val wholeDays = PS.Data.Function.Module.apply
                               .app(PS.Data.Time.Duration.Module.Days)
                               .app(PS.Math.Module.floor
                                      .app(PS.Data.EuclideanRing.Module.div
                                             .app(
                                               PS.Data.EuclideanRing.Module.euclideanRingNumber
                                             )
                                             .app(PS.Data.Newtype.Module.unwrap
                                                    .app(
                                                      PS.Data.Time.Duration.Module.newtypeMilliseconds
                                                    )
                                                    .app(d_tick))
                                             .app(dayLength)));
             val msAdjust = PS.Data.Semigroup.Module.append
                              .app(
                                PS.Data.Time.Duration.Module.semigroupMilliseconds
                              )
                              .app(d_tick)
                              .app(PS.Data.Time.Duration.Module.negateDuration
                                     .app(
                                       PS.Data.Time.Duration.Module.durationMilliseconds
                                     )
                                     .app(
                 PS.Data.Time.Duration.Module.fromDuration
                   .app(PS.Data.Time.Duration.Module.durationDays)
                   .app(wholeDays)));
             val msAdjusted = PS.Data.Semigroup.Module.append
                                .app(
                                  PS.Data.Time.Duration.Module.semigroupMilliseconds
                                )
                                .app(tLength)
                                .app(msAdjust);
             val wrap = when {
               (PS.Data.Ord.Module.greaterThan
                  .app(PS.Data.Time.Duration.Module.ordMilliseconds)
                  .app(msAdjusted)
                  .app(PS.Data.Time.Module.maxTime) == true) -> {
                 1.0;
               }
               else -> {
                 when {
                   (PS.Data.Ord.Module.lessThan
                      .app(PS.Data.Time.Duration.Module.ordMilliseconds)
                      .app(msAdjusted)
                      .app(PS.Data.Time.Module.minTime) == true) -> {
                     PS.Data.Ring.Module.negate
                       .app(PS.Data.Ring.Module.ringNumber)
                       .app(1.0);
                   }
                   else -> {
                     0.0;
                   }
                 };
               }
             };
           }
           .run({
            val tLength = this.tLength;
            val dayLength = this.dayLength;
            val d_tick = this.d_tick;
            val wholeDays = this.wholeDays;
            val msAdjust = this.msAdjust;
            val msAdjusted = this.msAdjusted;
            val wrap = this.wrap;
            PS.Data.Tuple.Module.Tuple
              .app(PS.Data.Semigroup.Module.append
                     .app(PS.Data.Time.Duration.Module.semigroupDays)
                     .app(wholeDays)
                     .app(PS.Data.Time.Duration.Module.Days.app(wrap)))
              .app(PS.Data.Time.Module.millisToTime
                     .app(PS.Data.Semigroup.Module.append
                            .app(
                              PS.Data.Time.Duration.Module.semigroupMilliseconds
                            )
                            .app(msAdjusted)
                            .app(PS.Data.Time.Duration.Module.Milliseconds
                                   .app(PS.Data.Semiring.Module.mul
                                          .app(
                                            PS.Data.Semiring.Module.semiringNumber
                                          )
                                          .app(dayLength)
                                          .app(PS.Data.Ring.Module.negate
                                                 .app(
                                                   PS.Data.Ring.Module.ringNumber
                                                 )
                                                 .app(wrap))))));
          })
      }
    }
  };
}