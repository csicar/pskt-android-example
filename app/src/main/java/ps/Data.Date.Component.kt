@file:Suppress("UNCHECKED_CAST")
package PS.Data.Date.Component
import Foreign.PsRuntime.app
object Module  {
  sealed class _Type_Weekday ()  {
    object Monday : _Type_Weekday() {};
    object Tuesday : _Type_Weekday() {};
    object Wednesday : _Type_Weekday() {};
    object Thursday : _Type_Weekday() {};
    object Friday : _Type_Weekday() {};
    object Saturday : _Type_Weekday() {};
    object Sunday : _Type_Weekday() {};
  };
  val Monday = _Type_Weekday.Monday;
  val Tuesday = _Type_Weekday.Tuesday;
  val Wednesday = _Type_Weekday.Wednesday;
  val Thursday = _Type_Weekday.Thursday;
  val Friday = _Type_Weekday.Friday;
  val Saturday = _Type_Weekday.Saturday;
  val Sunday = _Type_Weekday.Sunday;
  sealed class _Type_Month ()  {
    object January : _Type_Month() {};
    object February : _Type_Month() {};
    object March : _Type_Month() {};
    object April : _Type_Month() {};
    object May : _Type_Month() {};
    object June : _Type_Month() {};
    object July : _Type_Month() {};
    object August : _Type_Month() {};
    object September : _Type_Month() {};
    object October : _Type_Month() {};
    object November : _Type_Month() {};
    object December : _Type_Month() {};
  };
  val January = _Type_Month.January;
  val February = _Type_Month.February;
  val March = _Type_Month.March;
  val April = _Type_Month.April;
  val May = _Type_Month.May;
  val June = _Type_Month.June;
  val July = _Type_Month.July;
  val August = _Type_Month.August;
  val September = _Type_Month.September;
  val October = _Type_Month.October;
  val November = _Type_Month.November;
  val December = _Type_Month.December;
  @JvmField val Year = { x : Any -> x};
  @JvmField val Day = { x : Any -> x};
  @JvmField
  val showYear = PS.Data.Show.Module.Show
                   .app({ v : Any ->
       when {
        else -> {
          val y = v;
          (("(Year " as String) + (((PS.Data.Show.Module.show
                                       .app(PS.Data.Show.Module.showInt)
                                       .app(y
          ) as String) + (")" as String)) as String));
        }
      }
    });
  @JvmField
  val showWeekday = PS.Data.Show.Module.Show
                      .app({ v : Any ->
       when {
        (v is PS.Data.Date.Component.Module._Type_Weekday.Monday) -> {
          "Monday";
        }
        (v is PS.Data.Date.Component.Module._Type_Weekday.Tuesday) -> {
          "Tuesday";
        }
        (v is PS.Data.Date.Component.Module._Type_Weekday.Wednesday) -> {
          "Wednesday";
        }
        (v is PS.Data.Date.Component.Module._Type_Weekday.Thursday) -> {
          "Thursday";
        }
        (v is PS.Data.Date.Component.Module._Type_Weekday.Friday) -> {
          "Friday";
        }
        (v is PS.Data.Date.Component.Module._Type_Weekday.Saturday) -> {
          "Saturday";
        }
        (v is PS.Data.Date.Component.Module._Type_Weekday.Sunday) -> {
          "Sunday";
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    });
  @JvmField
  val showMonth = PS.Data.Show.Module.Show
                    .app({ v : Any ->
       when {
        (v is PS.Data.Date.Component.Module._Type_Month.January) -> {
          "January";
        }
        (v is PS.Data.Date.Component.Module._Type_Month.February) -> {
          "February";
        }
        (v is PS.Data.Date.Component.Module._Type_Month.March) -> {
          "March";
        }
        (v is PS.Data.Date.Component.Module._Type_Month.April) -> {
          "April";
        }
        (v is PS.Data.Date.Component.Module._Type_Month.May) -> {
          "May";
        }
        (v is PS.Data.Date.Component.Module._Type_Month.June) -> {
          "June";
        }
        (v is PS.Data.Date.Component.Module._Type_Month.July) -> {
          "July";
        }
        (v is PS.Data.Date.Component.Module._Type_Month.August) -> {
          "August";
        }
        (v is PS.Data.Date.Component.Module._Type_Month.September) -> {
          "September";
        }
        (v is PS.Data.Date.Component.Module._Type_Month.October) -> {
          "October";
        }
        (v is PS.Data.Date.Component.Module._Type_Month.November) -> {
          "November";
        }
        (v is PS.Data.Date.Component.Module._Type_Month.December) -> {
          "December";
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    });
  @JvmField
  val showDay = PS.Data.Show.Module.Show
                  .app({ v : Any ->
       when {
        else -> {
          val d = v;
          (("(Day " as String) + (((PS.Data.Show.Module.show
                                      .app(PS.Data.Show.Module.showInt)
                                      .app(d
          ) as String) + (")" as String)) as String));
        }
      }
    });
  @JvmField val ordYear = PS.Data.Ord.Module.ordInt;
  @JvmField val ordDay = PS.Data.Ord.Module.ordInt;
  @JvmField val eqYear = PS.Data.Eq.Module.eqInt;
  @JvmField
  val eqWeekday = PS.Data.Eq.Module.Eq
                    .app({ x : Any ->
       { y : Any ->
         when {
          (x is PS.Data.Date.Component.Module._Type_Weekday
                  .Monday)&& (y is PS.Data.Date.Component.Module._Type_Weekday
                                     .Monday) -> {
            true;
          }
          (x is PS.Data.Date.Component.Module._Type_Weekday
                  .Tuesday)&& (y is PS.Data.Date.Component.Module._Type_Weekday
                                      .Tuesday) -> {
            true;
          }
          (x is PS.Data.Date.Component.Module._Type_Weekday
                  .Wednesday)&&
          (y is PS.Data.Date.Component.Module._Type_Weekday
                  .Wednesday) -> {
            true;
          }
          (x is PS.Data.Date.Component.Module._Type_Weekday
                  .Thursday)&& (y is PS.Data.Date.Component.Module._Type_Weekday
                                       .Thursday) -> {
            true;
          }
          (x is PS.Data.Date.Component.Module._Type_Weekday
                  .Friday)&& (y is PS.Data.Date.Component.Module._Type_Weekday
                                     .Friday) -> {
            true;
          }
          (x is PS.Data.Date.Component.Module._Type_Weekday
                  .Saturday)&& (y is PS.Data.Date.Component.Module._Type_Weekday
                                       .Saturday) -> {
            true;
          }
          (x is PS.Data.Date.Component.Module._Type_Weekday
                  .Sunday)&& (y is PS.Data.Date.Component.Module._Type_Weekday
                                     .Sunday) -> {
            true;
          }
          else -> {
            false;
          }
        }
      }
    });
  @JvmField
  val ordWeekday = PS.Data.Ord.Module.Ord
                     .app({ _ : Any ->
                          PS.Data.Date.Component.Module.eqWeekday
                       })
                     .app({ x : Any ->
       { y : Any ->
         when {
          (x is PS.Data.Date.Component.Module._Type_Weekday
                  .Monday)&& (y is PS.Data.Date.Component.Module._Type_Weekday
                                     .Monday) -> {
            PS.Data.Ordering.Module.EQ;
          }
          (x is PS.Data.Date.Component.Module._Type_Weekday.Monday) -> {
            PS.Data.Ordering.Module.LT;
          }
          (y is PS.Data.Date.Component.Module._Type_Weekday.Monday) -> {
            PS.Data.Ordering.Module.GT;
          }
          (x is PS.Data.Date.Component.Module._Type_Weekday
                  .Tuesday)&& (y is PS.Data.Date.Component.Module._Type_Weekday
                                      .Tuesday) -> {
            PS.Data.Ordering.Module.EQ;
          }
          (x is PS.Data.Date.Component.Module._Type_Weekday.Tuesday) -> {
            PS.Data.Ordering.Module.LT;
          }
          (y is PS.Data.Date.Component.Module._Type_Weekday.Tuesday) -> {
            PS.Data.Ordering.Module.GT;
          }
          (x is PS.Data.Date.Component.Module._Type_Weekday
                  .Wednesday)&&
          (y is PS.Data.Date.Component.Module._Type_Weekday
                  .Wednesday) -> {
            PS.Data.Ordering.Module.EQ;
          }
          (x is PS.Data.Date.Component.Module._Type_Weekday.Wednesday) -> {
            PS.Data.Ordering.Module.LT;
          }
          (y is PS.Data.Date.Component.Module._Type_Weekday.Wednesday) -> {
            PS.Data.Ordering.Module.GT;
          }
          (x is PS.Data.Date.Component.Module._Type_Weekday
                  .Thursday)&& (y is PS.Data.Date.Component.Module._Type_Weekday
                                       .Thursday) -> {
            PS.Data.Ordering.Module.EQ;
          }
          (x is PS.Data.Date.Component.Module._Type_Weekday.Thursday) -> {
            PS.Data.Ordering.Module.LT;
          }
          (y is PS.Data.Date.Component.Module._Type_Weekday.Thursday) -> {
            PS.Data.Ordering.Module.GT;
          }
          (x is PS.Data.Date.Component.Module._Type_Weekday
                  .Friday)&& (y is PS.Data.Date.Component.Module._Type_Weekday
                                     .Friday) -> {
            PS.Data.Ordering.Module.EQ;
          }
          (x is PS.Data.Date.Component.Module._Type_Weekday.Friday) -> {
            PS.Data.Ordering.Module.LT;
          }
          (y is PS.Data.Date.Component.Module._Type_Weekday.Friday) -> {
            PS.Data.Ordering.Module.GT;
          }
          (x is PS.Data.Date.Component.Module._Type_Weekday
                  .Saturday)&& (y is PS.Data.Date.Component.Module._Type_Weekday
                                       .Saturday) -> {
            PS.Data.Ordering.Module.EQ;
          }
          (x is PS.Data.Date.Component.Module._Type_Weekday.Saturday) -> {
            PS.Data.Ordering.Module.LT;
          }
          (y is PS.Data.Date.Component.Module._Type_Weekday.Saturday) -> {
            PS.Data.Ordering.Module.GT;
          }
          (x is PS.Data.Date.Component.Module._Type_Weekday
                  .Sunday)&& (y is PS.Data.Date.Component.Module._Type_Weekday
                                     .Sunday) -> {
            PS.Data.Ordering.Module.EQ;
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val eqMonth = PS.Data.Eq.Module.Eq
                  .app({ x : Any ->
       { y : Any ->
         when {
          (x is PS.Data.Date.Component.Module._Type_Month
                  .January)&& (y is PS.Data.Date.Component.Module._Type_Month
                                      .January) -> {
            true;
          }
          (x is PS.Data.Date.Component.Module._Type_Month
                  .February)&& (y is PS.Data.Date.Component.Module._Type_Month
                                       .February) -> {
            true;
          }
          (x is PS.Data.Date.Component.Module._Type_Month
                  .March)&& (y is PS.Data.Date.Component.Module._Type_Month
                                    .March) -> {
            true;
          }
          (x is PS.Data.Date.Component.Module._Type_Month
                  .April)&& (y is PS.Data.Date.Component.Module._Type_Month
                                    .April) -> {
            true;
          }
          (x is PS.Data.Date.Component.Module._Type_Month
                  .May)&& (y is PS.Data.Date.Component.Module._Type_Month
                                  .May) -> {
            true;
          }
          (x is PS.Data.Date.Component.Module._Type_Month
                  .June)&& (y is PS.Data.Date.Component.Module._Type_Month
                                   .June) -> {
            true;
          }
          (x is PS.Data.Date.Component.Module._Type_Month
                  .July)&& (y is PS.Data.Date.Component.Module._Type_Month
                                   .July) -> {
            true;
          }
          (x is PS.Data.Date.Component.Module._Type_Month
                  .August)&& (y is PS.Data.Date.Component.Module._Type_Month
                                     .August) -> {
            true;
          }
          (x is PS.Data.Date.Component.Module._Type_Month
                  .September)&& (y is PS.Data.Date.Component.Module._Type_Month
                                        .September) -> {
            true;
          }
          (x is PS.Data.Date.Component.Module._Type_Month
                  .October)&& (y is PS.Data.Date.Component.Module._Type_Month
                                      .October) -> {
            true;
          }
          (x is PS.Data.Date.Component.Module._Type_Month
                  .November)&& (y is PS.Data.Date.Component.Module._Type_Month
                                       .November) -> {
            true;
          }
          (x is PS.Data.Date.Component.Module._Type_Month
                  .December)&& (y is PS.Data.Date.Component.Module._Type_Month
                                       .December) -> {
            true;
          }
          else -> {
            false;
          }
        }
      }
    });
  @JvmField
  val ordMonth = PS.Data.Ord.Module.Ord
                   .app({ _ : Any ->
                        PS.Data.Date.Component.Module.eqMonth
                     })
                   .app({ x : Any ->
       { y : Any ->
         when {
          (x is PS.Data.Date.Component.Module._Type_Month
                  .January)&& (y is PS.Data.Date.Component.Module._Type_Month
                                      .January) -> {
            PS.Data.Ordering.Module.EQ;
          }
          (x is PS.Data.Date.Component.Module._Type_Month.January) -> {
            PS.Data.Ordering.Module.LT;
          }
          (y is PS.Data.Date.Component.Module._Type_Month.January) -> {
            PS.Data.Ordering.Module.GT;
          }
          (x is PS.Data.Date.Component.Module._Type_Month
                  .February)&& (y is PS.Data.Date.Component.Module._Type_Month
                                       .February) -> {
            PS.Data.Ordering.Module.EQ;
          }
          (x is PS.Data.Date.Component.Module._Type_Month.February) -> {
            PS.Data.Ordering.Module.LT;
          }
          (y is PS.Data.Date.Component.Module._Type_Month.February) -> {
            PS.Data.Ordering.Module.GT;
          }
          (x is PS.Data.Date.Component.Module._Type_Month
                  .March)&& (y is PS.Data.Date.Component.Module._Type_Month
                                    .March) -> {
            PS.Data.Ordering.Module.EQ;
          }
          (x is PS.Data.Date.Component.Module._Type_Month.March) -> {
            PS.Data.Ordering.Module.LT;
          }
          (y is PS.Data.Date.Component.Module._Type_Month.March) -> {
            PS.Data.Ordering.Module.GT;
          }
          (x is PS.Data.Date.Component.Module._Type_Month
                  .April)&& (y is PS.Data.Date.Component.Module._Type_Month
                                    .April) -> {
            PS.Data.Ordering.Module.EQ;
          }
          (x is PS.Data.Date.Component.Module._Type_Month.April) -> {
            PS.Data.Ordering.Module.LT;
          }
          (y is PS.Data.Date.Component.Module._Type_Month.April) -> {
            PS.Data.Ordering.Module.GT;
          }
          (x is PS.Data.Date.Component.Module._Type_Month
                  .May)&& (y is PS.Data.Date.Component.Module._Type_Month
                                  .May) -> {
            PS.Data.Ordering.Module.EQ;
          }
          (x is PS.Data.Date.Component.Module._Type_Month.May) -> {
            PS.Data.Ordering.Module.LT;
          }
          (y is PS.Data.Date.Component.Module._Type_Month.May) -> {
            PS.Data.Ordering.Module.GT;
          }
          (x is PS.Data.Date.Component.Module._Type_Month
                  .June)&& (y is PS.Data.Date.Component.Module._Type_Month
                                   .June) -> {
            PS.Data.Ordering.Module.EQ;
          }
          (x is PS.Data.Date.Component.Module._Type_Month.June) -> {
            PS.Data.Ordering.Module.LT;
          }
          (y is PS.Data.Date.Component.Module._Type_Month.June) -> {
            PS.Data.Ordering.Module.GT;
          }
          (x is PS.Data.Date.Component.Module._Type_Month
                  .July)&& (y is PS.Data.Date.Component.Module._Type_Month
                                   .July) -> {
            PS.Data.Ordering.Module.EQ;
          }
          (x is PS.Data.Date.Component.Module._Type_Month.July) -> {
            PS.Data.Ordering.Module.LT;
          }
          (y is PS.Data.Date.Component.Module._Type_Month.July) -> {
            PS.Data.Ordering.Module.GT;
          }
          (x is PS.Data.Date.Component.Module._Type_Month
                  .August)&& (y is PS.Data.Date.Component.Module._Type_Month
                                     .August) -> {
            PS.Data.Ordering.Module.EQ;
          }
          (x is PS.Data.Date.Component.Module._Type_Month.August) -> {
            PS.Data.Ordering.Module.LT;
          }
          (y is PS.Data.Date.Component.Module._Type_Month.August) -> {
            PS.Data.Ordering.Module.GT;
          }
          (x is PS.Data.Date.Component.Module._Type_Month
                  .September)&& (y is PS.Data.Date.Component.Module._Type_Month
                                        .September) -> {
            PS.Data.Ordering.Module.EQ;
          }
          (x is PS.Data.Date.Component.Module._Type_Month.September) -> {
            PS.Data.Ordering.Module.LT;
          }
          (y is PS.Data.Date.Component.Module._Type_Month.September) -> {
            PS.Data.Ordering.Module.GT;
          }
          (x is PS.Data.Date.Component.Module._Type_Month
                  .October)&& (y is PS.Data.Date.Component.Module._Type_Month
                                      .October) -> {
            PS.Data.Ordering.Module.EQ;
          }
          (x is PS.Data.Date.Component.Module._Type_Month.October) -> {
            PS.Data.Ordering.Module.LT;
          }
          (y is PS.Data.Date.Component.Module._Type_Month.October) -> {
            PS.Data.Ordering.Module.GT;
          }
          (x is PS.Data.Date.Component.Module._Type_Month
                  .November)&& (y is PS.Data.Date.Component.Module._Type_Month
                                       .November) -> {
            PS.Data.Ordering.Module.EQ;
          }
          (x is PS.Data.Date.Component.Module._Type_Month.November) -> {
            PS.Data.Ordering.Module.LT;
          }
          (y is PS.Data.Date.Component.Module._Type_Month.November) -> {
            PS.Data.Ordering.Module.GT;
          }
          (x is PS.Data.Date.Component.Module._Type_Month
                  .December)&& (y is PS.Data.Date.Component.Module._Type_Month
                                       .December) -> {
            PS.Data.Ordering.Module.EQ;
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField val eqDay = PS.Data.Eq.Module.eqInt;
  @JvmField
  val boundedYear = PS.Data.Bounded.Module.Bounded
                      .app({ _ : Any ->
                           PS.Data.Date.Component.Module.ordYear
                        })
                      .app(PS.Data.Date.Component.Module.Year
                             .app(PS.Data.Ring.Module.negate
                                    .app(PS.Data.Ring.Module.ringInt)
                                    .app(271820)))
                      .app(PS.Data.Date.Component.Module.Year.app(275759));
  @JvmField
  val boundedWeekday = PS.Data.Bounded.Module.Bounded
                         .app({ _ : Any ->
                              PS.Data.Date.Component.Module.ordWeekday
                           })
                         .app(PS.Data.Date.Component.Module.Monday)
                         .app(PS.Data.Date.Component.Module.Sunday);
  @JvmField
  val boundedMonth = PS.Data.Bounded.Module.Bounded
                       .app({ _ : Any ->
                            PS.Data.Date.Component.Module.ordMonth
                         })
                       .app(PS.Data.Date.Component.Module.January)
                       .app(PS.Data.Date.Component.Module.December);
  @JvmField val boundedEnumYear = (::__rec_boundedEnumYear)();
  @JvmField val enumYear = (::__rec_enumYear)();
  fun __rec_boundedEnumYear(): Any = PS.Data.Enum.Module.BoundedEnum
                                       .app({ _ : Any ->
                                            PS.Data.Date.Component.Module.boundedYear
                                         })
                                       .app({ _ : Any ->
                                            PS.Data.Date.Component.Module.enumYear
                                         })
                                       .app(PS.Data.Enum.Module.Cardinality
                                              .app(547580))
                                       .app({ v : Any ->
                                            when {
                                             else -> {
                                               val n = v;
                                               n;
                                             }
                                           }
                                         })
                                       .app({ n : Any ->
       when {
        (PS.Data.HeytingAlgebra.Module.conj
           .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
           .app(PS.Data.Ord.Module.greaterThanOrEq
                  .app(PS.Data.Ord.Module.ordInt)
                  .app(n)
                  .app(PS.Data.Ring.Module.negate
                         .app(PS.Data.Ring.Module.ringInt)
                         .app(271820)))
           .app(PS.Data.Ord.Module.lessThanOrEq.app(PS.Data.Ord.Module.ordInt)
                  .app(n)
                  .app(275759)) as Boolean) -> {
          val n1 = n;
          PS.Data.Maybe.Module.Just
            .app(PS.Data.Date.Component.Module.Year.app(n1));
        }
        (PS.Data.Boolean.Module.otherwise as Boolean) -> {
          val n1 = n;
          PS.Data.Maybe.Module.Nothing;
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    });
  fun __rec_enumYear(): Any = PS.Data.Enum.Module.Enum
                                .app({ _ : Any ->
                                     PS.Data.Date.Component.Module.ordYear
                                  })
                                .app(PS.Control.Semigroupoid.Module.compose
                                       .app(
                                         PS.Control.Semigroupoid.Module.semigroupoidFn
                                       )
                                       .app(PS.Data.Enum.Module.toEnum
                                              .app(
                                           PS.Data.Date.Component.Module.boundedEnumYear
                                         ))
                                       .app(
                                    PS.Control.Semigroupoid.Module.compose
                                      .app(
                                        PS.Control.Semigroupoid.Module.semigroupoidFn
                                      )
                                      .app({ v : Any ->
                                           PS.Data.Ring.Module.sub
                                             .app(PS.Data.Ring.Module.ringInt)
                                             .app(v)
                                             .app(1)
                                        })
                                      .app(PS.Data.Enum.Module.fromEnum
                                             .app(
                                        PS.Data.Date.Component.Module.boundedEnumYear
                                      ))))
                                .app(PS.Control.Semigroupoid.Module.compose
                                       .app(
                                         PS.Control.Semigroupoid.Module.semigroupoidFn
                                       )
                                       .app(PS.Data.Enum.Module.toEnum
                                              .app(
                                           PS.Data.Date.Component.Module.boundedEnumYear
                                         ))
                                       .app(
      PS.Control.Semigroupoid.Module.compose
        .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
        .app({ v : Any ->
             PS.Data.Semiring.Module.add
               .app(PS.Data.Semiring.Module.semiringInt)
               .app(v)
               .app(1)
          })
        .app(PS.Data.Enum.Module.fromEnum
               .app(PS.Data.Date.Component.Module.boundedEnumYear))));
  @JvmField val boundedEnumWeekday = (::__rec_boundedEnumWeekday)();
  @JvmField val enumWeekday = (::__rec_enumWeekday)();
  fun __rec_boundedEnumWeekday(): Any = PS.Data.Enum.Module.BoundedEnum
                                          .app({ _ : Any ->
                                               PS.Data.Date.Component.Module.boundedWeekday
                                            })
                                          .app({ _ : Any ->
                                               PS.Data.Date.Component.Module.enumWeekday
                                            })
                                          .app(PS.Data.Enum.Module.Cardinality
                                                 .app(7))
                                          .app({ v : Any ->
                                               when {
                                                (v is PS.Data.Date.Component.Module._Type_Weekday
                                                        .Monday) -> {
                                                  1;
                                                }
                                                (v is PS.Data.Date.Component.Module._Type_Weekday
                                                        .Tuesday) -> {
                                                  2;
                                                }
                                                (v is PS.Data.Date.Component.Module._Type_Weekday
                                                        .Wednesday) -> {
                                                  3;
                                                }
                                                (v is PS.Data.Date.Component.Module._Type_Weekday
                                                        .Thursday) -> {
                                                  4;
                                                }
                                                (v is PS.Data.Date.Component.Module._Type_Weekday
                                                        .Friday) -> {
                                                  5;
                                                }
                                                (v is PS.Data.Date.Component.Module._Type_Weekday
                                                        .Saturday) -> {
                                                  6;
                                                }
                                                (v is PS.Data.Date.Component.Module._Type_Weekday
                                                        .Sunday) -> {
                                                  7;
                                                }
                                                else -> (error(
                                                  "Error in Pattern Match"
                                                ) as Any)
                                              }
                                            })
                                          .app({ v : Any ->
       when {
        (v == 1) -> {
          PS.Data.Maybe.Module.Just.app(PS.Data.Date.Component.Module.Monday);
        }
        (v == 2) -> {
          PS.Data.Maybe.Module.Just.app(PS.Data.Date.Component.Module.Tuesday);
        }
        (v == 3) -> {
          PS.Data.Maybe.Module.Just
            .app(PS.Data.Date.Component.Module.Wednesday);
        }
        (v == 4) -> {
          PS.Data.Maybe.Module.Just.app(PS.Data.Date.Component.Module.Thursday);
        }
        (v == 5) -> {
          PS.Data.Maybe.Module.Just.app(PS.Data.Date.Component.Module.Friday);
        }
        (v == 6) -> {
          PS.Data.Maybe.Module.Just.app(PS.Data.Date.Component.Module.Saturday);
        }
        (v == 7) -> {
          PS.Data.Maybe.Module.Just.app(PS.Data.Date.Component.Module.Sunday);
        }
        else -> {
          PS.Data.Maybe.Module.Nothing;
        }
      }
    });
  fun __rec_enumWeekday(): Any = PS.Data.Enum.Module.Enum
                                   .app({ _ : Any ->
                                        PS.Data.Date.Component.Module.ordWeekday
                                     })
                                   .app(PS.Control.Semigroupoid.Module.compose
                                          .app(
                                            PS.Control.Semigroupoid.Module.semigroupoidFn
                                          )
                                          .app(PS.Data.Enum.Module.toEnum
                                                 .app(
                                              PS.Data.Date.Component.Module.boundedEnumWeekday
                                            ))
                                          .app(
                                       PS.Control.Semigroupoid.Module.compose
                                         .app(
                                           PS.Control.Semigroupoid.Module.semigroupoidFn
                                         )
                                         .app({ v : Any ->
                                              PS.Data.Ring.Module.sub
                                                .app(PS.Data.Ring.Module.ringInt
                                                )
                                                .app(v)
                                                .app(1)
                                           })
                                         .app(PS.Data.Enum.Module.fromEnum
                                                .app(
                                           PS.Data.Date.Component.Module.boundedEnumWeekday
                                         ))))
                                   .app(PS.Control.Semigroupoid.Module.compose
                                          .app(
                                            PS.Control.Semigroupoid.Module.semigroupoidFn
                                          )
                                          .app(PS.Data.Enum.Module.toEnum
                                                 .app(
                                              PS.Data.Date.Component.Module.boundedEnumWeekday
                                            ))
                                          .app(
      PS.Control.Semigroupoid.Module.compose
        .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
        .app({ v : Any ->
             PS.Data.Semiring.Module.add
               .app(PS.Data.Semiring.Module.semiringInt)
               .app(v)
               .app(1)
          })
        .app(PS.Data.Enum.Module.fromEnum
               .app(PS.Data.Date.Component.Module.boundedEnumWeekday))));
  @JvmField val boundedEnumMonth = (::__rec_boundedEnumMonth)();
  @JvmField val enumMonth = (::__rec_enumMonth)();
  fun __rec_boundedEnumMonth(): Any = PS.Data.Enum.Module.BoundedEnum
                                        .app({ _ : Any ->
                                             PS.Data.Date.Component.Module.boundedMonth
                                          })
                                        .app({ _ : Any ->
                                             PS.Data.Date.Component.Module.enumMonth
                                          })
                                        .app(PS.Data.Enum.Module.Cardinality
                                               .app(12))
                                        .app({ v : Any ->
                                             when {
                                              (v is PS.Data.Date.Component.Module._Type_Month
                                                      .January) -> {
                                                1;
                                              }
                                              (v is PS.Data.Date.Component.Module._Type_Month
                                                      .February) -> {
                                                2;
                                              }
                                              (v is PS.Data.Date.Component.Module._Type_Month
                                                      .March) -> {
                                                3;
                                              }
                                              (v is PS.Data.Date.Component.Module._Type_Month
                                                      .April) -> {
                                                4;
                                              }
                                              (v is PS.Data.Date.Component.Module._Type_Month
                                                      .May) -> {
                                                5;
                                              }
                                              (v is PS.Data.Date.Component.Module._Type_Month
                                                      .June) -> {
                                                6;
                                              }
                                              (v is PS.Data.Date.Component.Module._Type_Month
                                                      .July) -> {
                                                7;
                                              }
                                              (v is PS.Data.Date.Component.Module._Type_Month
                                                      .August) -> {
                                                8;
                                              }
                                              (v is PS.Data.Date.Component.Module._Type_Month
                                                      .September) -> {
                                                9;
                                              }
                                              (v is PS.Data.Date.Component.Module._Type_Month
                                                      .October) -> {
                                                10;
                                              }
                                              (v is PS.Data.Date.Component.Module._Type_Month
                                                      .November) -> {
                                                11;
                                              }
                                              (v is PS.Data.Date.Component.Module._Type_Month
                                                      .December) -> {
                                                12;
                                              }
                                              else -> (error(
                                                "Error in Pattern Match"
                                              ) as Any)
                                            }
                                          })
                                        .app({ v : Any ->
       when {
        (v == 1) -> {
          PS.Data.Maybe.Module.Just.app(PS.Data.Date.Component.Module.January);
        }
        (v == 2) -> {
          PS.Data.Maybe.Module.Just.app(PS.Data.Date.Component.Module.February);
        }
        (v == 3) -> {
          PS.Data.Maybe.Module.Just.app(PS.Data.Date.Component.Module.March);
        }
        (v == 4) -> {
          PS.Data.Maybe.Module.Just.app(PS.Data.Date.Component.Module.April);
        }
        (v == 5) -> {
          PS.Data.Maybe.Module.Just.app(PS.Data.Date.Component.Module.May);
        }
        (v == 6) -> {
          PS.Data.Maybe.Module.Just.app(PS.Data.Date.Component.Module.June);
        }
        (v == 7) -> {
          PS.Data.Maybe.Module.Just.app(PS.Data.Date.Component.Module.July);
        }
        (v == 8) -> {
          PS.Data.Maybe.Module.Just.app(PS.Data.Date.Component.Module.August);
        }
        (v == 9) -> {
          PS.Data.Maybe.Module.Just
            .app(PS.Data.Date.Component.Module.September);
        }
        (v == 10) -> {
          PS.Data.Maybe.Module.Just.app(PS.Data.Date.Component.Module.October);
        }
        (v == 11) -> {
          PS.Data.Maybe.Module.Just.app(PS.Data.Date.Component.Module.November);
        }
        (v == 12) -> {
          PS.Data.Maybe.Module.Just.app(PS.Data.Date.Component.Module.December);
        }
        else -> {
          PS.Data.Maybe.Module.Nothing;
        }
      }
    });
  fun __rec_enumMonth(): Any = PS.Data.Enum.Module.Enum
                                 .app({ _ : Any ->
                                      PS.Data.Date.Component.Module.ordMonth
                                   })
                                 .app(PS.Control.Semigroupoid.Module.compose
                                        .app(
                                          PS.Control.Semigroupoid.Module.semigroupoidFn
                                        )
                                        .app(PS.Data.Enum.Module.toEnum
                                               .app(
                                            PS.Data.Date.Component.Module.boundedEnumMonth
                                          ))
                                        .app(
                                     PS.Control.Semigroupoid.Module.compose
                                       .app(
                                         PS.Control.Semigroupoid.Module.semigroupoidFn
                                       )
                                       .app({ v : Any ->
                                            PS.Data.Ring.Module.sub
                                              .app(PS.Data.Ring.Module.ringInt)
                                              .app(v)
                                              .app(1)
                                         })
                                       .app(PS.Data.Enum.Module.fromEnum
                                              .app(
                                         PS.Data.Date.Component.Module.boundedEnumMonth
                                       ))))
                                 .app(PS.Control.Semigroupoid.Module.compose
                                        .app(
                                          PS.Control.Semigroupoid.Module.semigroupoidFn
                                        )
                                        .app(PS.Data.Enum.Module.toEnum
                                               .app(
                                            PS.Data.Date.Component.Module.boundedEnumMonth
                                          ))
                                        .app(
      PS.Control.Semigroupoid.Module.compose
        .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
        .app({ v : Any ->
             PS.Data.Semiring.Module.add
               .app(PS.Data.Semiring.Module.semiringInt)
               .app(v)
               .app(1)
          })
        .app(PS.Data.Enum.Module.fromEnum
               .app(PS.Data.Date.Component.Module.boundedEnumMonth))));
  @JvmField
  val boundedDay = PS.Data.Bounded.Module.Bounded
                     .app({ _ : Any ->
                          PS.Data.Date.Component.Module.ordDay
                       })
                     .app(PS.Data.Date.Component.Module.Day.app(1))
                     .app(PS.Data.Date.Component.Module.Day.app(31));
  @JvmField val boundedEnumDay = (::__rec_boundedEnumDay)();
  @JvmField val enumDay = (::__rec_enumDay)();
  fun __rec_boundedEnumDay(): Any = PS.Data.Enum.Module.BoundedEnum
                                      .app({ _ : Any ->
                                           PS.Data.Date.Component.Module.boundedDay
                                        })
                                      .app({ _ : Any ->
                                           PS.Data.Date.Component.Module.enumDay
                                        })
                                      .app(PS.Data.Enum.Module.Cardinality
                                             .app(31))
                                      .app({ v : Any ->
                                           when {
                                            else -> {
                                              val n = v;
                                              n;
                                            }
                                          }
                                        })
                                      .app({ n : Any ->
       when {
        (PS.Data.HeytingAlgebra.Module.conj
           .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
           .app(PS.Data.Ord.Module.greaterThanOrEq
                  .app(PS.Data.Ord.Module.ordInt)
                  .app(n)
                  .app(1))
           .app(PS.Data.Ord.Module.lessThanOrEq.app(PS.Data.Ord.Module.ordInt)
                  .app(n)
                  .app(31)) as Boolean) -> {
          val n1 = n;
          PS.Data.Maybe.Module.Just
            .app(PS.Data.Date.Component.Module.Day.app(n1));
        }
        (PS.Data.Boolean.Module.otherwise as Boolean) -> {
          val n1 = n;
          PS.Data.Maybe.Module.Nothing;
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    });
  fun __rec_enumDay(): Any = PS.Data.Enum.Module.Enum
                               .app({ _ : Any ->
                                    PS.Data.Date.Component.Module.ordDay
                                 })
                               .app(PS.Control.Semigroupoid.Module.compose
                                      .app(
                                        PS.Control.Semigroupoid.Module.semigroupoidFn
                                      )
                                      .app(PS.Data.Enum.Module.toEnum
                                             .app(
                                          PS.Data.Date.Component.Module.boundedEnumDay
                                        ))
                                      .app(
                                   PS.Control.Semigroupoid.Module.compose
                                     .app(
                                       PS.Control.Semigroupoid.Module.semigroupoidFn
                                     )
                                     .app({ v : Any ->
                                          PS.Data.Ring.Module.sub
                                            .app(PS.Data.Ring.Module.ringInt)
                                            .app(v)
                                            .app(1)
                                       })
                                     .app(PS.Data.Enum.Module.fromEnum
                                            .app(
                                       PS.Data.Date.Component.Module.boundedEnumDay
                                     ))))
                               .app(PS.Control.Semigroupoid.Module.compose
                                      .app(
                                        PS.Control.Semigroupoid.Module.semigroupoidFn
                                      )
                                      .app(PS.Data.Enum.Module.toEnum
                                             .app(
                                          PS.Data.Date.Component.Module.boundedEnumDay
                                        ))
                                      .app(
      PS.Control.Semigroupoid.Module.compose
        .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
        .app({ v : Any ->
             PS.Data.Semiring.Module.add
               .app(PS.Data.Semiring.Module.semiringInt)
               .app(v)
               .app(1)
          })
        .app(PS.Data.Enum.Module.fromEnum
               .app(PS.Data.Date.Component.Module.boundedEnumDay))));
}