@file:Suppress("UNCHECKED_CAST")

package PS.Data.Time.Component
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val Second = { x : Any -> x};
  @JvmField val Minute = { x : Any -> x};
  @JvmField val Millisecond = { x : Any -> x};
  @JvmField val Hour = { x : Any -> x};
  @JvmField
  val showSecond = PS.Data.Show.Module.Show
                     .app({ v : Any ->
      val m = v;
        (("(Second " as String) + (((PS.Data.Show.Module.show
                                       .app(PS.Data.Show.Module.showInt)
                                       .app(m
        ) as String) + (")" as String)) as String));});
  @JvmField
  val showMinute = PS.Data.Show.Module.Show
                     .app({ v : Any ->
      val m = v;
        (("(Minute " as String) + (((PS.Data.Show.Module.show
                                       .app(PS.Data.Show.Module.showInt)
                                       .app(m
        ) as String) + (")" as String)) as String));});
  @JvmField
  val showMillisecond = PS.Data.Show.Module.Show
                          .app({ v : Any ->
      val m = v;
        (("(Millisecond " as String) + (((PS.Data.Show.Module.show
                                            .app(PS.Data.Show.Module.showInt)
                                            .app(m
        ) as String) + (")" as String)) as String));});
  @JvmField
  val showHour = PS.Data.Show.Module.Show
                   .app({ v : Any ->
      val h = v;
        (("(Hour " as String) + (((PS.Data.Show.Module.show
                                     .app(PS.Data.Show.Module.showInt)
                                     .app(h
        ) as String) + (")" as String)) as String));});
  @JvmField val ordSecond = PS.Data.Ord.Module.ordInt;
  @JvmField val ordMinute = PS.Data.Ord.Module.ordInt;
  @JvmField val ordMillisecond = PS.Data.Ord.Module.ordInt;
  @JvmField val ordHour = PS.Data.Ord.Module.ordInt;
  @JvmField val eqSecond = PS.Data.Eq.Module.eqInt;
  @JvmField val eqMinute = PS.Data.Eq.Module.eqInt;
  @JvmField val eqMillisecond = PS.Data.Eq.Module.eqInt;
  @JvmField val eqHour = PS.Data.Eq.Module.eqInt;
  @JvmField
  val boundedSecond = PS.Data.Bounded.Module.Bounded
                        .app({ _ : Any ->
                             PS.Data.Time.Component.Module.ordSecond
                          })
                        .app(PS.Data.Time.Component.Module.Second.app(0))
                        .app(PS.Data.Time.Component.Module.Second.app(59));
  @JvmField
  val boundedMinute = PS.Data.Bounded.Module.Bounded
                        .app({ _ : Any ->
                             PS.Data.Time.Component.Module.ordMinute
                          })
                        .app(PS.Data.Time.Component.Module.Minute.app(0))
                        .app(PS.Data.Time.Component.Module.Minute.app(59));
  @JvmField
  val boundedMillisecond = PS.Data.Bounded.Module.Bounded
                             .app({ _ : Any ->
                                  PS.Data.Time.Component.Module.ordMillisecond
                               })
                             .app(PS.Data.Time.Component.Module.Millisecond
                                    .app(0))
                             .app(PS.Data.Time.Component.Module.Millisecond
                                    .app(999));
  @JvmField
  val boundedHour = PS.Data.Bounded.Module.Bounded
                      .app({ _ : Any ->
                           PS.Data.Time.Component.Module.ordHour
                        })
                      .app(PS.Data.Time.Component.Module.Hour.app(0))
                      .app(PS.Data.Time.Component.Module.Hour.app(23));
  @JvmField val boundedEnumSecond = (::__rec_boundedEnumSecond)();
  @JvmField val enumSecond = (::__rec_enumSecond)();
  fun __rec_boundedEnumSecond(): Any = PS.Data.Enum.Module.BoundedEnum
                                         .app({ _ : Any ->
                                              PS.Data.Time.Component.Module.boundedSecond
                                           })
                                         .app({ _ : Any ->
                                              PS.Data.Time.Component.Module.enumSecond
                                           })
                                         .app(PS.Data.Enum.Module.Cardinality
                                                .app(60))
                                         .app({ v : Any ->
                                             val n = v;
                                               n;})
                                         .app({ n : Any ->
       when {
        (PS.Data.HeytingAlgebra.Module.conj
           .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
           .app(PS.Data.Ord.Module.greaterThanOrEq
                  .app(PS.Data.Ord.Module.ordInt)
                  .app(n)
                  .app(0))
           .app(PS.Data.Ord.Module.lessThanOrEq.app(PS.Data.Ord.Module.ordInt)
                  .app(n)
                  .app(59)) as Boolean) -> {
          val n1 = n;
          PS.Data.Maybe.Module.Just
            .app(PS.Data.Time.Component.Module.Second.app(n1));
        }
        (PS.Data.Boolean.Module.otherwise as Boolean) -> {
          val n1 = n;
          PS.Data.Maybe.Module.Nothing;
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    });
  fun __rec_enumSecond(): Any = PS.Data.Enum.Module.Enum
                                  .app({ _ : Any ->
                                       PS.Data.Time.Component.Module.ordSecond
                                    })
                                  .app(PS.Control.Semigroupoid.Module.compose
                                         .app(
                                           PS.Control.Semigroupoid.Module.semigroupoidFn
                                         )
                                         .app(PS.Data.Enum.Module.toEnum
                                                .app(
                                             PS.Data.Time.Component.Module.boundedEnumSecond
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
                                          PS.Data.Time.Component.Module.boundedEnumSecond
                                        ))))
                                  .app(PS.Control.Semigroupoid.Module.compose
                                         .app(
                                           PS.Control.Semigroupoid.Module.semigroupoidFn
                                         )
                                         .app(PS.Data.Enum.Module.toEnum
                                                .app(
                                             PS.Data.Time.Component.Module.boundedEnumSecond
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
               .app(PS.Data.Time.Component.Module.boundedEnumSecond))));
  @JvmField val boundedEnumMinute = (::__rec_boundedEnumMinute)();
  @JvmField val enumMinute = (::__rec_enumMinute)();
  fun __rec_boundedEnumMinute(): Any = PS.Data.Enum.Module.BoundedEnum
                                         .app({ _ : Any ->
                                              PS.Data.Time.Component.Module.boundedMinute
                                           })
                                         .app({ _ : Any ->
                                              PS.Data.Time.Component.Module.enumMinute
                                           })
                                         .app(PS.Data.Enum.Module.Cardinality
                                                .app(60))
                                         .app({ v : Any ->
                                             val n = v;
                                               n;})
                                         .app({ n : Any ->
       when {
        (PS.Data.HeytingAlgebra.Module.conj
           .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
           .app(PS.Data.Ord.Module.greaterThanOrEq
                  .app(PS.Data.Ord.Module.ordInt)
                  .app(n)
                  .app(0))
           .app(PS.Data.Ord.Module.lessThanOrEq.app(PS.Data.Ord.Module.ordInt)
                  .app(n)
                  .app(59)) as Boolean) -> {
          val n1 = n;
          PS.Data.Maybe.Module.Just
            .app(PS.Data.Time.Component.Module.Minute.app(n1));
        }
        (PS.Data.Boolean.Module.otherwise as Boolean) -> {
          val n1 = n;
          PS.Data.Maybe.Module.Nothing;
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    });
  fun __rec_enumMinute(): Any = PS.Data.Enum.Module.Enum
                                  .app({ _ : Any ->
                                       PS.Data.Time.Component.Module.ordMinute
                                    })
                                  .app(PS.Control.Semigroupoid.Module.compose
                                         .app(
                                           PS.Control.Semigroupoid.Module.semigroupoidFn
                                         )
                                         .app(PS.Data.Enum.Module.toEnum
                                                .app(
                                             PS.Data.Time.Component.Module.boundedEnumMinute
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
                                          PS.Data.Time.Component.Module.boundedEnumMinute
                                        ))))
                                  .app(PS.Control.Semigroupoid.Module.compose
                                         .app(
                                           PS.Control.Semigroupoid.Module.semigroupoidFn
                                         )
                                         .app(PS.Data.Enum.Module.toEnum
                                                .app(
                                             PS.Data.Time.Component.Module.boundedEnumMinute
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
               .app(PS.Data.Time.Component.Module.boundedEnumMinute))));
  @JvmField val boundedEnumMillisecond = (::__rec_boundedEnumMillisecond)();
  @JvmField val enumMillisecond = (::__rec_enumMillisecond)();
  fun __rec_boundedEnumMillisecond(): Any = PS.Data.Enum.Module.BoundedEnum
                                              .app({ _ : Any ->
                                                   PS.Data.Time.Component.Module.boundedMillisecond
                                                })
                                              .app({ _ : Any ->
                                                   PS.Data.Time.Component.Module.enumMillisecond
                                                })
                                              .app(
                                                PS.Data.Enum.Module.Cardinality
                                                  .app(1000))
                                              .app({ v : Any ->
                                                  val n = v;
                                                    n;})
                                              .app({ n : Any ->
       when {
        (PS.Data.HeytingAlgebra.Module.conj
           .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
           .app(PS.Data.Ord.Module.greaterThanOrEq
                  .app(PS.Data.Ord.Module.ordInt)
                  .app(n)
                  .app(0))
           .app(PS.Data.Ord.Module.lessThanOrEq.app(PS.Data.Ord.Module.ordInt)
                  .app(n)
                  .app(999)) as Boolean) -> {
          val n1 = n;
          PS.Data.Maybe.Module.Just
            .app(PS.Data.Time.Component.Module.Millisecond.app(n1));
        }
        (PS.Data.Boolean.Module.otherwise as Boolean) -> {
          val n1 = n;
          PS.Data.Maybe.Module.Nothing;
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    });
  fun __rec_enumMillisecond(): Any = PS.Data.Enum.Module.Enum
                                       .app({ _ : Any ->
                                            PS.Data.Time.Component.Module.ordMillisecond
                                         })
                                       .app(
                                         PS.Control.Semigroupoid.Module.compose
                                           .app(
                                             PS.Control.Semigroupoid.Module.semigroupoidFn
                                           )
                                           .app(PS.Data.Enum.Module.toEnum
                                                  .app(
                                               PS.Data.Time.Component.Module.boundedEnumMillisecond
                                             ))
                                           .app(
                                           PS.Control.Semigroupoid.Module.compose
                                             .app(
                                               PS.Control.Semigroupoid.Module.semigroupoidFn
                                             )
                                             .app({ v : Any ->
                                                  PS.Data.Ring.Module.sub
                                                    .app(
                                                      PS.Data.Ring.Module.ringInt
                                                    )
                                                    .app(v)
                                                    .app(1)
                                               })
                                             .app(PS.Data.Enum.Module.fromEnum
                                                    .app(
                                               PS.Data.Time.Component.Module.boundedEnumMillisecond
                                             ))))
                                       .app(
    PS.Control.Semigroupoid.Module.compose
      .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
      .app(PS.Data.Enum.Module.toEnum
             .app(PS.Data.Time.Component.Module.boundedEnumMillisecond))
      .app(PS.Control.Semigroupoid.Module.compose
             .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
             .app({ v : Any ->
                  PS.Data.Semiring.Module.add
                    .app(PS.Data.Semiring.Module.semiringInt)
                    .app(v)
                    .app(1)
               })
             .app(PS.Data.Enum.Module.fromEnum
                    .app(PS.Data.Time.Component.Module.boundedEnumMillisecond)))
  );
  @JvmField val boundedEnumHour = (::__rec_boundedEnumHour)();
  @JvmField val enumHour = (::__rec_enumHour)();
  fun __rec_boundedEnumHour(): Any = PS.Data.Enum.Module.BoundedEnum
                                       .app({ _ : Any ->
                                            PS.Data.Time.Component.Module.boundedHour
                                         })
                                       .app({ _ : Any ->
                                            PS.Data.Time.Component.Module.enumHour
                                         })
                                       .app(PS.Data.Enum.Module.Cardinality
                                              .app(24))
                                       .app({ v : Any ->
                                           val n = v;
                                             n;})
                                       .app({ n : Any ->
       when {
        (PS.Data.HeytingAlgebra.Module.conj
           .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
           .app(PS.Data.Ord.Module.greaterThanOrEq
                  .app(PS.Data.Ord.Module.ordInt)
                  .app(n)
                  .app(0))
           .app(PS.Data.Ord.Module.lessThanOrEq.app(PS.Data.Ord.Module.ordInt)
                  .app(n)
                  .app(23)) as Boolean) -> {
          val n1 = n;
          PS.Data.Maybe.Module.Just
            .app(PS.Data.Time.Component.Module.Hour.app(n1));
        }
        (PS.Data.Boolean.Module.otherwise as Boolean) -> {
          val n1 = n;
          PS.Data.Maybe.Module.Nothing;
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    });
  fun __rec_enumHour(): Any = PS.Data.Enum.Module.Enum
                                .app({ _ : Any ->
                                     PS.Data.Time.Component.Module.ordHour
                                  })
                                .app(PS.Control.Semigroupoid.Module.compose
                                       .app(
                                         PS.Control.Semigroupoid.Module.semigroupoidFn
                                       )
                                       .app(PS.Data.Enum.Module.toEnum
                                              .app(
                                           PS.Data.Time.Component.Module.boundedEnumHour
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
                                        PS.Data.Time.Component.Module.boundedEnumHour
                                      ))))
                                .app(PS.Control.Semigroupoid.Module.compose
                                       .app(
                                         PS.Control.Semigroupoid.Module.semigroupoidFn
                                       )
                                       .app(PS.Data.Enum.Module.toEnum
                                              .app(
                                           PS.Data.Time.Component.Module.boundedEnumHour
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
               .app(PS.Data.Time.Component.Module.boundedEnumHour))));
}