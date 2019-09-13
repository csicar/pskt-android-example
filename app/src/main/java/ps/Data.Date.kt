@file:Suppress("UNCHECKED_CAST")

package PS.Data.Date
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  val canonicalDateImpl = Foreign.Data.Date.canonicalDateImpl;
  val calcWeekday = Foreign.Data.Date.calcWeekday;
  val calcDiff = Foreign.Data.Date.calcDiff;
  sealed class _Type_Date ()  {
    data class Date (val value0 : Any,  val value1 : Any, 
    val value2 : Any) : _Type_Date() {};
  };
  val Date = { value0 : Any ->
     { value1 : Any ->
       { value2 : Any ->
         _Type_Date.Date(value0,  value1,  value2)
      }
    }
  };
  @JvmField
  val year = { v : Any ->
     when {
      (v is PS.Data.Date.Module._Type_Date.Date) -> {
        val y = v.value0;
        y;
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val weekday = PS.Partial.Unsafe.Module.unsafePartial
                  .app({ dictPartial : Any ->
       { v : Any ->
         when {
          (v is PS.Data.Date.Module._Type_Date.Date) -> {
            val y = v.value0;
            val m = v.value1;
            val d = v.value2;
            object   {
                val n = PS.Data.Function.Uncurried.Module.runFn3
                          .app(PS.Data.Date.Module.calcWeekday)
                          .app(y)
                          .app(PS.Data.Enum.Module.fromEnum
                                 .app(
                                   PS.Data.Date.Component.Module.boundedEnumMonth
                                 )
                                 .app(m))
                          .app(d);
              }
              .run({
                val n = this.n;
                when {
                  (PS.Data.Eq.Module.eq.app(PS.Data.Eq.Module.eqInt).app(n)
                     .app(0) == true) -> {
                    PS.Data.Maybe.Module.fromJust.app(Unit)
                      .app(PS.Data.Enum.Module.toEnum
                             .app(
                               PS.Data.Date.Component.Module.boundedEnumWeekday)
                             .app(7));
                  }
                  else -> {
                    PS.Data.Maybe.Module.fromJust.app(Unit)
                      .app(PS.Data.Enum.Module.toEnum
                             .app(
                               PS.Data.Date.Component.Module.boundedEnumWeekday)
                             .app(n));
                  }
                };
              });
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val showDate = PS.Data.Show.Module.Show
                   .app({ v : Any ->
       when {
        (v is PS.Data.Date.Module._Type_Date.Date) -> {
          val y = v.value0;
          val m = v.value1;
          val d = v.value2;
          (("(Date " as String) + (((PS.Data.Show.Module.show
                                       .app(
                                         PS.Data.Date.Component.Module.showYear)
                                       .app(y
          ) as String) + (((" " as String) + (((PS.Data.Show.Module.show
                                                  .app(
                                                    PS.Data.Date.Component.Module.showMonth
                                                  )
                                                  .app(m
          ) as String) + (((" " as String) + (((PS.Data.Show.Module.show
                                                  .app(
                                                    PS.Data.Date.Component.Module.showDay
                                                  )
                                                  .app(d
          ) as String) + (")" as String)) as String)) as String)) as String)) as String)) as String));
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    });
  @JvmField
  val month = { v : Any ->
     when {
      (v is PS.Data.Date.Module._Type_Date.Date) -> {
        val m = v.value1;
        m;
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val isLeapYear = { y : Any ->
     object   {
         val y_tick = PS.Data.Enum.Module.fromEnum
                        .app(PS.Data.Date.Component.Module.boundedEnumYear)
                        .app(y);
       }
       .run({
        val y_tick = this.y_tick;
        PS.Data.HeytingAlgebra.Module.conj
          .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
          .app(PS.Data.Eq.Module.eq.app(PS.Data.Eq.Module.eqInt)
                 .app(PS.Data.EuclideanRing.Module.mod
                        .app(PS.Data.EuclideanRing.Module.euclideanRingInt)
                        .app(y_tick)
                        .app(4))
                 .app(0))
          .app(PS.Data.HeytingAlgebra.Module.disj
                 .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
                 .app(PS.Data.Eq.Module.eq.app(PS.Data.Eq.Module.eqInt)
                        .app(PS.Data.EuclideanRing.Module.mod
                               .app(
                                 PS.Data.EuclideanRing.Module.euclideanRingInt)
                               .app(y_tick)
                               .app(400))
                        .app(0))
                 .app(PS.Data.HeytingAlgebra.Module.not
                        .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean
                        )
                        .app(PS.Data.Eq.Module.eq.app(PS.Data.Eq.Module.eqInt)
                               .app(PS.Data.EuclideanRing.Module.mod
                                      .app(
                                        PS.Data.EuclideanRing.Module.euclideanRingInt
                                      )
                                      .app(y_tick)
                                      .app(100))
                               .app(0))));
      })
  };
  @JvmField
  val lastDayOfMonth = { y : Any ->
     { m : Any ->
       object   {
           val unsafeDay = PS.Control.Semigroupoid.Module.compose
                             .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                             .app(PS.Partial.Unsafe.Module.unsafePartial
                                    .app({ dictPartial : Any ->
                                    PS.Data.Maybe.Module.fromJust.app(Unit)
                                 }))
                             .app(PS.Data.Enum.Module.toEnum
                                    .app(
               PS.Data.Date.Component.Module.boundedEnumDay));
         }
         .run({
          val unsafeDay = this.unsafeDay;
          when {
            (m is PS.Data.Date.Component.Module._Type_Month.January) -> {
              unsafeDay.app(31);
            }
            (m is PS.Data.Date.Component.Module._Type_Month
                    .February)&& (PS.Data.Date.Module.isLeapYear
                                    .app(y) as Boolean) -> {
              unsafeDay.app(29);
            }
            (m is PS.Data.Date.Component.Module._Type_Month
                    .February)&&
            (PS.Data.Boolean.Module.otherwise as Boolean) -> {
              unsafeDay.app(28);
            }
            (m is PS.Data.Date.Component.Module._Type_Month.March) -> {
              unsafeDay.app(31);
            }
            (m is PS.Data.Date.Component.Module._Type_Month.April) -> {
              unsafeDay.app(30);
            }
            (m is PS.Data.Date.Component.Module._Type_Month.May) -> {
              unsafeDay.app(31);
            }
            (m is PS.Data.Date.Component.Module._Type_Month.June) -> {
              unsafeDay.app(30);
            }
            (m is PS.Data.Date.Component.Module._Type_Month.July) -> {
              unsafeDay.app(31);
            }
            (m is PS.Data.Date.Component.Module._Type_Month.August) -> {
              unsafeDay.app(31);
            }
            (m is PS.Data.Date.Component.Module._Type_Month.September) -> {
              unsafeDay.app(30);
            }
            (m is PS.Data.Date.Component.Module._Type_Month.October) -> {
              unsafeDay.app(31);
            }
            (m is PS.Data.Date.Component.Module._Type_Month.November) -> {
              unsafeDay.app(30);
            }
            (m is PS.Data.Date.Component.Module._Type_Month.December) -> {
              unsafeDay.app(31);
            }
            else -> (error("Error in Pattern Match") as Any)
          };
        })
    }
  };
  @JvmField
  val eqDate = PS.Data.Eq.Module.Eq
                 .app({ x : Any ->
       { y : Any ->
         when {
          (x is PS.Data.Date.Module._Type_Date
                  .Date)&& (y is PS.Data.Date.Module._Type_Date
                                   .Date) -> {
            val l = x.value0;
            val l1 = x.value1;
            val l2 = x.value2;
            val r = y.value0;
            val r1 = y.value1;
            val r2 = y.value2;
            PS.Data.HeytingAlgebra.Module.conj
              .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
              .app(PS.Data.HeytingAlgebra.Module.conj
                     .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
                     .app(PS.Data.Eq.Module.eq
                            .app(PS.Data.Date.Component.Module.eqYear)
                            .app(l)
                            .app(r))
                     .app(PS.Data.Eq.Module.eq
                            .app(PS.Data.Date.Component.Module.eqMonth)
                            .app(l1)
                            .app(r1)))
              .app(PS.Data.Eq.Module.eq.app(PS.Data.Date.Component.Module.eqDay)
                     .app(l2)
                     .app(r2));
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val ordDate = PS.Data.Ord.Module.Ord
                  .app({ _ : Any ->
                       PS.Data.Date.Module.eqDate
                    })
                  .app({ x : Any ->
       { y : Any ->
         when {
          (x is PS.Data.Date.Module._Type_Date
                  .Date)&& (y is PS.Data.Date.Module._Type_Date
                                   .Date) -> {
            val l = x.value0;
            val l1 = x.value1;
            val l2 = x.value2;
            val r = y.value0;
            val r1 = y.value1;
            val r2 = y.value2;
            object   {
                val v = PS.Data.Ord.Module.compare
                          .app(PS.Data.Date.Component.Module.ordYear)
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
                                   .app(PS.Data.Date.Component.Module.ordMonth)
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
                            PS.Data.Ord.Module.compare
                              .app(PS.Data.Date.Component.Module.ordDay)
                              .app(l2)
                              .app(r2);
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
  val enumDate = PS.Data.Enum.Module.Enum
                   .app({ _ : Any ->
                        PS.Data.Date.Module.ordDate
                     })
                   .app({ v : Any ->
                        when {
                         (v is PS.Data.Date.Module._Type_Date.Date) -> {
                           val y = v.value0;
                           val m = v.value1;
                           val d = v.value2;
                           object   {
                               val pm = PS.Data.Enum.Module.pred
                                          .app(
                                            PS.Data.Date.Component.Module.enumMonth
                                          )
                                          .app(m);
                               val pd = PS.Data.Enum.Module.pred
                                          .app(
                                            PS.Data.Date.Component.Module.enumDay
                                          )
                                          .app(d);
                               val y_tick = when {
                                 (PS.Data.HeytingAlgebra.Module.conj
                                    .app(
                                      PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean
                                    )
                                    .app(PS.Data.Maybe.Module.isNothing.app(pd))
                                    .app(PS.Data.Maybe.Module.isNothing.app(pm)
                                 ) == true) -> {
                                   PS.Data.Enum.Module.pred
                                     .app(PS.Data.Date.Component.Module.enumYear
                                     )
                                     .app(y);
                                 }
                                 else -> {
                                   PS.Data.Maybe.Module.Just.app(y);
                                 }
                               };
                               val m_tick = when {
                                 (PS.Data.Maybe.Module.isNothing
                                    .app(pd) == true) -> {
                                   PS.Data.Maybe.Module.fromMaybe
                                     .app(PS.Data.Date.Component.Module.December
                                     )
                                     .app(pm);
                                 }
                                 else -> {
                                   m;
                                 }
                               };
                               val l = PS.Data.Date.Module.lastDayOfMonth.app(y)
                                         .app(m_tick);
                               val d_tick = when {
                                 (PS.Data.Maybe.Module.isNothing
                                    .app(pd) == true) -> {
                                   PS.Data.Maybe.Module.Just.app(l);
                                 }
                                 else -> {
                                   pd;
                                 }
                               };
                             }
                             .run({
                               val pm = this.pm;
                               val pd = this.pd;
                               val y_tick = this.y_tick;
                               val m_tick = this.m_tick;
                               val l = this.l;
                               val d_tick = this.d_tick;
                               PS.Control.Apply.Module.apply
                                 .app(PS.Data.Maybe.Module.applyMaybe)
                                 .app(PS.Control.Apply.Module.apply
                                        .app(PS.Data.Maybe.Module.applyMaybe)
                                        .app(PS.Data.Functor.Module.map
                                               .app(
                                                 PS.Data.Maybe.Module.functorMaybe
                                               )
                                               .app(PS.Data.Date.Module.Date)
                                               .app(y_tick))
                                        .app(PS.Control.Applicative.Module.pure
                                               .app(
                                                 PS.Data.Maybe.Module.applicativeMaybe
                                               )
                                               .app(m_tick)))
                                 .app(d_tick);
                             });
                         }
                         else -> (error("Error in Pattern Match") as Any)
                       }
                     })
                   .app({ v : Any ->
       when {
        (v is PS.Data.Date.Module._Type_Date.Date) -> {
          val y = v.value0;
          val m = v.value1;
          val d = v.value2;
          object   {
              val sm = PS.Data.Enum.Module.succ
                         .app(PS.Data.Date.Component.Module.enumMonth)
                         .app(m);
              val l = PS.Data.Date.Module.lastDayOfMonth.app(y).app(m);
              val sd = object   {
                           val v1 = PS.Data.Enum.Module.succ
                                      .app(PS.Data.Date.Component.Module.enumDay
                                      )
                                      .app(d);
                         }
                         .run({
                  val v1 = this.v1;
                  when {
                    (PS.Data.Ord.Module.greaterThan
                       .app(PS.Data.Maybe.Module.ordMaybe
                              .app(PS.Data.Date.Component.Module.ordDay))
                       .app(v1)
                       .app(PS.Data.Maybe.Module.Just.app(l)) == true) -> {
                      PS.Data.Maybe.Module.Nothing;
                    }
                    else -> {
                      v1;
                    }
                  };
                });
              val m_tick = when {
                (PS.Data.Maybe.Module.isNothing.app(sd) == true) -> {
                  PS.Data.Maybe.Module.fromMaybe
                    .app(PS.Data.Date.Component.Module.January)
                    .app(sm);
                }
                else -> {
                  m;
                }
              };
              val y_tick = when {
                (PS.Data.HeytingAlgebra.Module.conj
                   .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
                   .app(PS.Data.Maybe.Module.isNothing.app(sd))
                   .app(PS.Data.Maybe.Module.isNothing.app(sm)) == true) -> {
                  PS.Data.Enum.Module.succ
                    .app(PS.Data.Date.Component.Module.enumYear)
                    .app(y);
                }
                else -> {
                  PS.Data.Maybe.Module.Just.app(y);
                }
              };
              val d_tick = when {
                (PS.Data.Maybe.Module.isNothing.app(sd) == true) -> {
                  PS.Data.Enum.Module.toEnum
                    .app(PS.Data.Date.Component.Module.boundedEnumDay)
                    .app(1);
                }
                else -> {
                  sd;
                }
              };
            }
            .run({
              val sm = this.sm;
              val l = this.l;
              val sd = this.sd;
              val m_tick = this.m_tick;
              val y_tick = this.y_tick;
              val d_tick = this.d_tick;
              PS.Control.Apply.Module.apply.app(PS.Data.Maybe.Module.applyMaybe)
                .app(PS.Control.Apply.Module.apply
                       .app(PS.Data.Maybe.Module.applyMaybe)
                       .app(PS.Data.Functor.Module.map
                              .app(PS.Data.Maybe.Module.functorMaybe)
                              .app(PS.Data.Date.Module.Date)
                              .app(y_tick))
                       .app(PS.Control.Applicative.Module.pure
                              .app(PS.Data.Maybe.Module.applicativeMaybe)
                              .app(m_tick)))
                .app(d_tick);
            });
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    });
  @JvmField
  val diff = { dictDuration : Any ->
     { v : Any ->
       { v1 : Any ->
         when {
          (v is PS.Data.Date.Module._Type_Date
                  .Date)&& (v1 is PS.Data.Date.Module._Type_Date
                                    .Date) -> {
            val y1 = v.value0;
            val m1 = v.value1;
            val d1 = v.value2;
            val y2 = v1.value0;
            val m2 = v1.value1;
            val d2 = v1.value2;
            PS.Data.Function.Module.apply
              .app(PS.Data.Time.Duration.Module.toDuration.app(dictDuration))
              .app(PS.Data.Function.Uncurried.Module.runFn6
                     .app(PS.Data.Date.Module.calcDiff)
                     .app(y1)
                     .app(PS.Data.Enum.Module.fromEnum
                            .app(PS.Data.Date.Component.Module.boundedEnumMonth)
                            .app(m1))
                     .app(d1)
                     .app(y2)
                     .app(PS.Data.Enum.Module.fromEnum
                            .app(PS.Data.Date.Component.Module.boundedEnumMonth)
                            .app(m2))
                     .app(d2));
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    }
  };
  @JvmField
  val day = { v : Any ->
     when {
      (v is PS.Data.Date.Module._Type_Date.Date) -> {
        val d = v.value2;
        d;
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val canonicalDate = { y : Any ->
     { m : Any ->
       { d : Any ->
         object   {
             val mkDate = PS.Partial.Unsafe.Module.unsafePartial
                            .app({ dictPartial : Any ->
                  { y_tick : Any ->
                    { m_tick : Any ->
                      { d_tick : Any ->
                        PS.Data.Date.Module.Date.app(y_tick)
                          .app(PS.Data.Maybe.Module.fromJust.app(Unit)
                                 .app(PS.Data.Enum.Module.toEnum
                                        .app(
                                          PS.Data.Date.Component.Module.boundedEnumMonth
                                        )
                                        .app(m_tick)))
                          .app(d_tick)
                     }
                   }
                 }
               });
           }
           .run({
            val mkDate = this.mkDate;
            PS.Data.Function.Uncurried.Module.runFn4
              .app(PS.Data.Date.Module.canonicalDateImpl)
              .app(mkDate)
              .app(y)
              .app(PS.Data.Enum.Module.fromEnum
                     .app(PS.Data.Date.Component.Module.boundedEnumMonth)
                     .app(m))
              .app(d);
          })
      }
    }
  };
  @JvmField
  val exactDate = { y : Any ->
     { m : Any ->
       { d : Any ->
         object   {
             val dt = PS.Data.Date.Module.Date.app(y).app(m).app(d);
           }
           .run({
            val dt = this.dt;
            when {
              (PS.Data.Eq.Module.eq.app(PS.Data.Date.Module.eqDate)
                 .app(PS.Data.Date.Module.canonicalDate.app(y).app(m).app(d))
                 .app(dt) == true) -> {
                PS.Data.Maybe.Module.Just.app(dt);
              }
              else -> {
                PS.Data.Maybe.Module.Nothing;
              }
            };
          })
      }
    }
  };
  @JvmField
  val boundedDate = PS.Data.Bounded.Module.Bounded
                      .app({ _ : Any ->
                           PS.Data.Date.Module.ordDate
                        })
                      .app(PS.Data.Date.Module.Date
                             .app(PS.Data.Bounded.Module.bottom
                                    .app(
                                 PS.Data.Date.Component.Module.boundedYear))
                             .app(PS.Data.Bounded.Module.bottom
                                    .app(
                                 PS.Data.Date.Component.Module.boundedMonth))
                             .app(PS.Data.Bounded.Module.bottom
                                    .app(
                            PS.Data.Date.Component.Module.boundedDay)))
                      .app(PS.Data.Date.Module.Date
                             .app(PS.Data.Bounded.Module.top
                                    .app(
                                 PS.Data.Date.Component.Module.boundedYear))
                             .app(PS.Data.Bounded.Module.top
                                    .app(
                                 PS.Data.Date.Component.Module.boundedMonth))
                             .app(PS.Data.Bounded.Module.top
                                    .app(
        PS.Data.Date.Component.Module.boundedDay)));
  @JvmField
  val adjust = { v : Any ->
     { date : Any ->
      val n = v;
        val date1 = date;
        object   {
            val adj = (::__rec_adj)();
            fun __rec_adj(): Any = { v1 : Any ->
               { v2 : Any ->
                 when {
                  (v1 == 0) -> {
                    val dt = v2;
                    PS.Data.Maybe.Module.Just.app(dt);
                  }
                  (v2 is PS.Data.Date.Module._Type_Date.Date) -> {
                    val i = v1;
                    val y = v2.value0;
                    val m = v2.value1;
                    val d = v2.value2;
                    object   {
                        val j = PS.Data.Semiring.Module.add
                                  .app(PS.Data.Semiring.Module.semiringInt)
                                  .app(i)
                                  .app(PS.Data.Enum.Module.fromEnum
                                         .app(
                                           PS.Data.Date.Component.Module.boundedEnumDay
                                         )
                                         .app(d));
                        val low = PS.Data.Ord.Module.lessThan
                                    .app(PS.Data.Ord.Module.ordInt)
                                    .app(j)
                                    .app(1);
                        val l = PS.Data.Date.Module.lastDayOfMonth.app(y)
                                  .app(when {
                            (low == true) -> {
                              PS.Data.Maybe.Module.fromMaybe
                                .app(PS.Data.Date.Component.Module.December)
                                .app(PS.Data.Enum.Module.pred
                                       .app(
                                         PS.Data.Date.Component.Module.enumMonth
                                       )
                                       .app(m));
                            }
                            else -> {
                              m;
                            }
                          });
                        val hi = PS.Data.Ord.Module.greaterThan
                                   .app(PS.Data.Ord.Module.ordInt)
                                   .app(j)
                                   .app(PS.Data.Enum.Module.fromEnum
                                          .app(
                                            PS.Data.Date.Component.Module.boundedEnumDay
                                          )
                                          .app(l));
                        val i_tick = when {
                          (low as Boolean) -> {
                            j;
                          }
                          (hi as Boolean) -> {
                            PS.Data.Ring.Module.sub
                              .app(PS.Data.Ring.Module.ringInt)
                              .app(PS.Data.Ring.Module.sub
                                     .app(PS.Data.Ring.Module.ringInt)
                                     .app(j)
                                     .app(PS.Data.Enum.Module.fromEnum
                                            .app(
                                              PS.Data.Date.Component.Module.boundedEnumDay
                                            )
                                            .app(l)))
                              .app(1);
                          }
                          (PS.Data.Boolean.Module.otherwise as Boolean) -> {
                            0;
                          }
                          else -> (error("Error in Pattern Match") as Any)
                        };
                        val dt_tick = when {
                          (low as Boolean) -> {
                            PS.Control.Bind.Module.bindFlipped
                              .app(PS.Data.Maybe.Module.bindMaybe)
                              .app(PS.Data.Enum.Module.pred
                                     .app(PS.Data.Date.Module.enumDate))
                              .app(PS.Data.Functor.Module.map
                                     .app(PS.Data.Maybe.Module.functorMaybe)
                                     .app(PS.Data.Date.Module.Date.app(y).app(m)
                                     )
                                     .app(PS.Data.Enum.Module.toEnum
                                            .app(
                                              PS.Data.Date.Component.Module.boundedEnumDay
                                            )
                                            .app(1)));
                          }
                          (hi as Boolean) -> {
                            PS.Data.Enum.Module.succ
                              .app(PS.Data.Date.Module.enumDate)
                              .app(PS.Data.Date.Module.Date.app(y).app(m).app(l)
                            );
                          }
                          (PS.Data.Boolean.Module.otherwise as Boolean) -> {
                            PS.Data.Functor.Module.map
                              .app(PS.Data.Maybe.Module.functorMaybe)
                              .app(PS.Data.Date.Module.Date.app(y).app(m))
                              .app(PS.Data.Enum.Module.toEnum
                                     .app(
                                       PS.Data.Date.Component.Module.boundedEnumDay
                                     )
                                     .app(j));
                          }
                          else -> (error("Error in Pattern Match") as Any)
                        };
                      }
                      .run({
                        val j = this.j;
                        val low = this.low;
                        val l = this.l;
                        val hi = this.hi;
                        val i_tick = this.i_tick;
                        val dt_tick = this.dt_tick;
                        PS.Control.Bind.Module.bindFlipped
                          .app(PS.Data.Maybe.Module.bindMaybe)
                          .app(__rec_adj().app(i_tick))
                          .app(dt_tick);
                      });
                  }
                  else -> (error("Error in Pattern Match") as Any)
                }
              }
            };
          }
          .run({
            val adj = this.adj;
            PS.Control.Bind.Module.bind.app(PS.Data.Maybe.Module.bindMaybe)
              .app(PS.Data.Int.Module.fromNumber.app(n))
              .app(PS.Data.Function.Module.flip.app(adj).app(date1));
          });}
  };
}