@file:Suppress("UNCHECKED_CAST")
package PS.Data.Time.Duration
import Foreign.PsRuntime.app
object Module  {
  @JvmField val Seconds = { x : Any -> x};
  @JvmField val Minutes = { x : Any -> x};
  @JvmField val Milliseconds = { x : Any -> x};
  @JvmField val Hours = { x : Any -> x};
  @JvmField val Days = { x : Any -> x};
  @JvmField
  val Duration = { fromDuration : Any ->
     { toDuration : Any ->
       mapOf(("fromDuration" to fromDuration),  ("toDuration" to toDuration))
    }
  };
  @JvmField
  val toDuration = { dict : Any ->
     (dict as Map<String, Any>)["toDuration"]!!
  };
  @JvmField
  val showSeconds = PS.Data.Show.Module.Show
                      .app({ v : Any ->
       when {
        else -> {
          val n = v;
          (("(Seconds " as String) + (((PS.Data.Show.Module.show
                                          .app(PS.Data.Show.Module.showNumber)
                                          .app(n
          ) as String) + (")" as String)) as String));
        }
      }
    });
  @JvmField
  val showMinutes = PS.Data.Show.Module.Show
                      .app({ v : Any ->
       when {
        else -> {
          val n = v;
          (("(Minutes " as String) + (((PS.Data.Show.Module.show
                                          .app(PS.Data.Show.Module.showNumber)
                                          .app(n
          ) as String) + (")" as String)) as String));
        }
      }
    });
  @JvmField
  val showMilliseconds = PS.Data.Show.Module.Show
                           .app({ v : Any ->
       when {
        else -> {
          val n = v;
          (("(Milliseconds " as String) + (((PS.Data.Show.Module.show
                                               .app(
                                                 PS.Data.Show.Module.showNumber)
                                               .app(n
          ) as String) + (")" as String)) as String));
        }
      }
    });
  @JvmField
  val showHours = PS.Data.Show.Module.Show
                    .app({ v : Any ->
       when {
        else -> {
          val n = v;
          (("(Hours " as String) + (((PS.Data.Show.Module.show
                                        .app(PS.Data.Show.Module.showNumber)
                                        .app(n
          ) as String) + (")" as String)) as String));
        }
      }
    });
  @JvmField
  val showDays = PS.Data.Show.Module.Show
                   .app({ v : Any ->
       when {
        else -> {
          val n = v;
          (("(Days " as String) + (((PS.Data.Show.Module.show
                                       .app(PS.Data.Show.Module.showNumber)
                                       .app(n
          ) as String) + (")" as String)) as String));
        }
      }
    });
  @JvmField
  val semigroupSeconds = PS.Data.Semigroup.Module.Semigroup
                           .app({ v : Any ->
       { v1 : Any ->
         when {
          else -> {
            val x = v;
            val y = v1;
            PS.Data.Time.Duration.Module.Seconds
              .app(PS.Data.Semiring.Module.add
                     .app(PS.Data.Semiring.Module.semiringNumber)
                     .app(x)
                     .app(y));
          }
        }
      }
    });
  @JvmField
  val semigroupMinutes = PS.Data.Semigroup.Module.Semigroup
                           .app({ v : Any ->
       { v1 : Any ->
         when {
          else -> {
            val x = v;
            val y = v1;
            PS.Data.Time.Duration.Module.Minutes
              .app(PS.Data.Semiring.Module.add
                     .app(PS.Data.Semiring.Module.semiringNumber)
                     .app(x)
                     .app(y));
          }
        }
      }
    });
  @JvmField
  val semigroupMilliseconds = PS.Data.Semigroup.Module.Semigroup
                                .app({ v : Any ->
       { v1 : Any ->
         when {
          else -> {
            val x = v;
            val y = v1;
            PS.Data.Time.Duration.Module.Milliseconds
              .app(PS.Data.Semiring.Module.add
                     .app(PS.Data.Semiring.Module.semiringNumber)
                     .app(x)
                     .app(y));
          }
        }
      }
    });
  @JvmField
  val semigroupHours = PS.Data.Semigroup.Module.Semigroup
                         .app({ v : Any ->
       { v1 : Any ->
         when {
          else -> {
            val x = v;
            val y = v1;
            PS.Data.Time.Duration.Module.Hours
              .app(PS.Data.Semiring.Module.add
                     .app(PS.Data.Semiring.Module.semiringNumber)
                     .app(x)
                     .app(y));
          }
        }
      }
    });
  @JvmField
  val semigroupDays = PS.Data.Semigroup.Module.Semigroup
                        .app({ v : Any ->
       { v1 : Any ->
         when {
          else -> {
            val x = v;
            val y = v1;
            PS.Data.Time.Duration.Module.Days
              .app(PS.Data.Semiring.Module.add
                     .app(PS.Data.Semiring.Module.semiringNumber)
                     .app(x)
                     .app(y));
          }
        }
      }
    });
  @JvmField val ordSeconds = PS.Data.Ord.Module.ordNumber;
  @JvmField val ordMinutes = PS.Data.Ord.Module.ordNumber;
  @JvmField val ordMilliseconds = PS.Data.Ord.Module.ordNumber;
  @JvmField val ordHours = PS.Data.Ord.Module.ordNumber;
  @JvmField val ordDays = PS.Data.Ord.Module.ordNumber;
  @JvmField
  val newtypeSeconds = PS.Data.Newtype.Module.Newtype
                         .app({ n : Any ->
                              when {
                               else -> {
                                 val a = n;
                                 a;
                               }
                             }
                           })
                         .app(PS.Data.Time.Duration.Module.Seconds);
  @JvmField
  val newtypeMinutes = PS.Data.Newtype.Module.Newtype
                         .app({ n : Any ->
                              when {
                               else -> {
                                 val a = n;
                                 a;
                               }
                             }
                           })
                         .app(PS.Data.Time.Duration.Module.Minutes);
  @JvmField
  val newtypeMilliseconds = PS.Data.Newtype.Module.Newtype
                              .app({ n : Any ->
                                   when {
                                    else -> {
                                      val a = n;
                                      a;
                                    }
                                  }
                                })
                              .app(PS.Data.Time.Duration.Module.Milliseconds);
  @JvmField
  val newtypeHours = PS.Data.Newtype.Module.Newtype
                       .app({ n : Any ->
                            when {
                             else -> {
                               val a = n;
                               a;
                             }
                           }
                         })
                       .app(PS.Data.Time.Duration.Module.Hours);
  @JvmField
  val newtypeDays = PS.Data.Newtype.Module.Newtype
                      .app({ n : Any ->
                           when {
                            else -> {
                              val a = n;
                              a;
                            }
                          }
                        })
                      .app(PS.Data.Time.Duration.Module.Days);
  @JvmField
  val monoidSeconds = PS.Data.Monoid.Module.Monoid
                        .app({ _ : Any ->
                             PS.Data.Time.Duration.Module.semigroupSeconds
                          })
                        .app(PS.Data.Time.Duration.Module.Seconds.app(0.0));
  @JvmField
  val monoidMinutes = PS.Data.Monoid.Module.Monoid
                        .app({ _ : Any ->
                             PS.Data.Time.Duration.Module.semigroupMinutes
                          })
                        .app(PS.Data.Time.Duration.Module.Minutes.app(0.0));
  @JvmField
  val monoidMilliseconds = PS.Data.Monoid.Module.Monoid
                             .app({ _ : Any ->
                                  PS.Data.Time.Duration.Module.semigroupMilliseconds
                               })
                             .app(PS.Data.Time.Duration.Module.Milliseconds
                                    .app(0.0));
  @JvmField
  val monoidHours = PS.Data.Monoid.Module.Monoid
                      .app({ _ : Any ->
                           PS.Data.Time.Duration.Module.semigroupHours
                        })
                      .app(PS.Data.Time.Duration.Module.Hours.app(0.0));
  @JvmField
  val monoidDays = PS.Data.Monoid.Module.Monoid
                     .app({ _ : Any ->
                          PS.Data.Time.Duration.Module.semigroupDays
                       })
                     .app(PS.Data.Time.Duration.Module.Days.app(0.0));
  @JvmField
  val fromDuration = { dict : Any ->
     (dict as Map<String, Any>)["fromDuration"]!!
  };
  @JvmField
  val negateDuration = { dictDuration : Any ->
     PS.Control.Semigroupoid.Module.compose
       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
       .app(PS.Data.Time.Duration.Module.toDuration.app(dictDuration))
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Data.Newtype.Module.over
                     .app(PS.Data.Time.Duration.Module.newtypeMilliseconds)
                     .app(PS.Data.Time.Duration.Module.newtypeMilliseconds)
                     .app(PS.Data.Time.Duration.Module.Milliseconds)
                     .app(PS.Data.Ring.Module.negate
                            .app(PS.Data.Ring.Module.ringNumber)))
              .app(PS.Data.Time.Duration.Module.fromDuration.app(dictDuration)))
  };
  @JvmField val eqSeconds = PS.Data.Eq.Module.eqNumber;
  @JvmField val eqMinutes = PS.Data.Eq.Module.eqNumber;
  @JvmField val eqMilliseconds = PS.Data.Eq.Module.eqNumber;
  @JvmField val eqHours = PS.Data.Eq.Module.eqNumber;
  @JvmField val eqDays = PS.Data.Eq.Module.eqNumber;
  @JvmField
  val durationSeconds = PS.Data.Time.Duration.Module.Duration
                          .app(PS.Data.Newtype.Module.over
                                 .app(
                                   PS.Data.Time.Duration.Module.newtypeSeconds)
                                 .app(
                                   PS.Data.Time.Duration.Module.newtypeMilliseconds
                                 )
                                 .app(PS.Data.Time.Duration.Module.Seconds)
                                 .app({ v : Any ->
                                 PS.Data.Semiring.Module.mul
                                   .app(PS.Data.Semiring.Module.semiringNumber)
                                   .app(v)
                                   .app(1000.0)
                              }))
                          .app(PS.Data.Newtype.Module.over
                                 .app(
                                   PS.Data.Time.Duration.Module.newtypeMilliseconds
                                 )
                                 .app(
                                   PS.Data.Time.Duration.Module.newtypeSeconds)
                                 .app(PS.Data.Time.Duration.Module.Milliseconds)
                                 .app({ v : Any ->
         PS.Data.EuclideanRing.Module.div
           .app(PS.Data.EuclideanRing.Module.euclideanRingNumber)
           .app(v)
           .app(1000.0)
      }));
  @JvmField
  val durationMinutes = PS.Data.Time.Duration.Module.Duration
                          .app(PS.Data.Newtype.Module.over
                                 .app(
                                   PS.Data.Time.Duration.Module.newtypeMinutes)
                                 .app(
                                   PS.Data.Time.Duration.Module.newtypeMilliseconds
                                 )
                                 .app(PS.Data.Time.Duration.Module.Minutes)
                                 .app({ v : Any ->
                                 PS.Data.Semiring.Module.mul
                                   .app(PS.Data.Semiring.Module.semiringNumber)
                                   .app(v)
                                   .app(60000.0)
                              }))
                          .app(PS.Data.Newtype.Module.over
                                 .app(
                                   PS.Data.Time.Duration.Module.newtypeMilliseconds
                                 )
                                 .app(
                                   PS.Data.Time.Duration.Module.newtypeMinutes)
                                 .app(PS.Data.Time.Duration.Module.Milliseconds)
                                 .app({ v : Any ->
         PS.Data.EuclideanRing.Module.div
           .app(PS.Data.EuclideanRing.Module.euclideanRingNumber)
           .app(v)
           .app(60000.0)
      }));
  @JvmField
  val durationMilliseconds = PS.Data.Time.Duration.Module.Duration
                               .app(PS.Control.Category.Module.identity
                                      .app(PS.Control.Category.Module.categoryFn
                                 ))
                               .app(PS.Control.Category.Module.identity
                                      .app(PS.Control.Category.Module.categoryFn
    ));
  @JvmField
  val durationHours = PS.Data.Time.Duration.Module.Duration
                        .app(PS.Data.Newtype.Module.over
                               .app(PS.Data.Time.Duration.Module.newtypeHours)
                               .app(
                                 PS.Data.Time.Duration.Module.newtypeMilliseconds
                               )
                               .app(PS.Data.Time.Duration.Module.Hours)
                               .app({ v : Any ->
                               PS.Data.Semiring.Module.mul
                                 .app(PS.Data.Semiring.Module.semiringNumber)
                                 .app(v)
                                 .app(3600000.0)
                            }))
                        .app(PS.Data.Newtype.Module.over
                               .app(
                                 PS.Data.Time.Duration.Module.newtypeMilliseconds
                               )
                               .app(PS.Data.Time.Duration.Module.newtypeHours)
                               .app(PS.Data.Time.Duration.Module.Milliseconds)
                               .app({ v : Any ->
         PS.Data.EuclideanRing.Module.div
           .app(PS.Data.EuclideanRing.Module.euclideanRingNumber)
           .app(v)
           .app(3600000.0)
      }));
  @JvmField
  val durationDays = PS.Data.Time.Duration.Module.Duration
                       .app(PS.Data.Newtype.Module.over
                              .app(PS.Data.Time.Duration.Module.newtypeDays)
                              .app(
                                PS.Data.Time.Duration.Module.newtypeMilliseconds
                              )
                              .app(PS.Data.Time.Duration.Module.Days)
                              .app({ v : Any ->
                              PS.Data.Semiring.Module.mul
                                .app(PS.Data.Semiring.Module.semiringNumber)
                                .app(v)
                                .app(8.64e7)
                           }))
                       .app(PS.Data.Newtype.Module.over
                              .app(
                                PS.Data.Time.Duration.Module.newtypeMilliseconds
                              )
                              .app(PS.Data.Time.Duration.Module.newtypeDays)
                              .app(PS.Data.Time.Duration.Module.Milliseconds)
                              .app({ v : Any ->
         PS.Data.EuclideanRing.Module.div
           .app(PS.Data.EuclideanRing.Module.euclideanRingNumber)
           .app(v)
           .app(8.64e7)
      }));
  @JvmField
  val convertDuration = { dictDuration : Any ->
     { dictDuration1 : Any ->
       PS.Control.Semigroupoid.Module.compose
         .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
         .app(PS.Data.Time.Duration.Module.toDuration.app(dictDuration1))
         .app(PS.Data.Time.Duration.Module.fromDuration.app(dictDuration))
    }
  };
}