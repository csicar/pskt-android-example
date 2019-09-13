@file:Suppress("UNCHECKED_CAST")

package PS.Data.Interval.Duration
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  sealed class _Type_DurationComponent ()  {
    object Second : _Type_DurationComponent() {};
    object Minute : _Type_DurationComponent() {};
    object Hour : _Type_DurationComponent() {};
    object Day : _Type_DurationComponent() {};
    object Week : _Type_DurationComponent() {};
    object Month : _Type_DurationComponent() {};
    object Year : _Type_DurationComponent() {};
  };
  val Second = _Type_DurationComponent.Second;
  val Minute = _Type_DurationComponent.Minute;
  val Hour = _Type_DurationComponent.Hour;
  val Day = _Type_DurationComponent.Day;
  val Week = _Type_DurationComponent.Week;
  val Month = _Type_DurationComponent.Month;
  val Year = _Type_DurationComponent.Year;
  @JvmField val Duration = { x : Any -> x};
  @JvmField
  val showDurationComponent = PS.Data.Show.Module.Show
                                .app({ v : Any ->
       when {
        (v is PS.Data.Interval.Duration.Module._Type_DurationComponent
                .Minute) -> {
          "Minute";
        }
        (v is PS.Data.Interval.Duration.Module._Type_DurationComponent
                .Second) -> {
          "Second";
        }
        (v is PS.Data.Interval.Duration.Module._Type_DurationComponent
                .Hour) -> {
          "Hour";
        }
        (v is PS.Data.Interval.Duration.Module._Type_DurationComponent.Day) -> {
          "Day";
        }
        (v is PS.Data.Interval.Duration.Module._Type_DurationComponent
                .Week) -> {
          "Week";
        }
        (v is PS.Data.Interval.Duration.Module._Type_DurationComponent
                .Month) -> {
          "Month";
        }
        (v is PS.Data.Interval.Duration.Module._Type_DurationComponent
                .Year) -> {
          "Year";
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    });
  @JvmField
  val showDuration = PS.Data.Show.Module.Show
                       .app({ v : Any ->
      val d = v;
        (("(Duration " as String) + (((PS.Data.Show.Module.show
                                         .app(
                                           PS.Data.Map.Internal.Module.showMap
                                             .app(
                                               PS.Data.Interval.Duration.Module.showDurationComponent
                                             )
                                             .app(PS.Data.Show.Module.showNumber
                                           ))
                                         .app(d
        ) as String) + (")" as String)) as String));});
  @JvmField
  val newtypeDuration = PS.Data.Newtype.Module.Newtype
                          .app({ n : Any ->
                              val a = n;
                                a;})
                          .app(PS.Data.Interval.Duration.Module.Duration);
  @JvmField
  val eqDurationComponent = PS.Data.Eq.Module.Eq
                              .app({ x : Any ->
       { y : Any ->
         when {
          (x is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Second)&&
          (y is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Second) -> {
            true;
          }
          (x is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Minute)&&
          (y is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Minute) -> {
            true;
          }
          (x is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Hour)&&
          (y is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Hour) -> {
            true;
          }
          (x is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Day)&&
          (y is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Day) -> {
            true;
          }
          (x is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Week)&&
          (y is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Week) -> {
            true;
          }
          (x is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Month)&&
          (y is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Month) -> {
            true;
          }
          (x is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Year)&&
          (y is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Year) -> {
            true;
          }
          else -> {
            false;
          }
        }
      }
    });
  @JvmField
  val ordDurationComponent = PS.Data.Ord.Module.Ord
                               .app({ _ : Any ->
                                    PS.Data.Interval.Duration.Module.eqDurationComponent
                                 })
                               .app({ x : Any ->
       { y : Any ->
         when {
          (x is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Second)&&
          (y is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Second) -> {
            PS.Data.Ordering.Module.EQ;
          }
          (x is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Second) -> {
            PS.Data.Ordering.Module.LT;
          }
          (y is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Second) -> {
            PS.Data.Ordering.Module.GT;
          }
          (x is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Minute)&&
          (y is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Minute) -> {
            PS.Data.Ordering.Module.EQ;
          }
          (x is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Minute) -> {
            PS.Data.Ordering.Module.LT;
          }
          (y is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Minute) -> {
            PS.Data.Ordering.Module.GT;
          }
          (x is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Hour)&&
          (y is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Hour) -> {
            PS.Data.Ordering.Module.EQ;
          }
          (x is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Hour) -> {
            PS.Data.Ordering.Module.LT;
          }
          (y is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Hour) -> {
            PS.Data.Ordering.Module.GT;
          }
          (x is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Day)&&
          (y is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Day) -> {
            PS.Data.Ordering.Module.EQ;
          }
          (x is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Day) -> {
            PS.Data.Ordering.Module.LT;
          }
          (y is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Day) -> {
            PS.Data.Ordering.Module.GT;
          }
          (x is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Week)&&
          (y is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Week) -> {
            PS.Data.Ordering.Module.EQ;
          }
          (x is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Week) -> {
            PS.Data.Ordering.Module.LT;
          }
          (y is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Week) -> {
            PS.Data.Ordering.Module.GT;
          }
          (x is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Month)&&
          (y is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Month) -> {
            PS.Data.Ordering.Module.EQ;
          }
          (x is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Month) -> {
            PS.Data.Ordering.Module.LT;
          }
          (y is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Month) -> {
            PS.Data.Ordering.Module.GT;
          }
          (x is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Year)&&
          (y is PS.Data.Interval.Duration.Module._Type_DurationComponent
                  .Year) -> {
            PS.Data.Ordering.Module.EQ;
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val semigroupDuration = PS.Data.Semigroup.Module.Semigroup
                            .app({ v : Any ->
       { v1 : Any ->
        val a = v;
          val b = v1;
          PS.Data.Interval.Duration.Module.Duration
            .app(PS.Data.Map.Internal.Module.unionWith
                   .app(PS.Data.Interval.Duration.Module.ordDurationComponent)
                   .app(PS.Data.Semiring.Module.add
                          .app(PS.Data.Semiring.Module.semiringNumber))
                   .app(a)
                   .app(b));}
    });
  @JvmField
  val monoidDuration = PS.Data.Monoid.Module.Monoid
                         .app({ _ : Any ->
                              PS.Data.Interval.Duration.Module.semigroupDuration
                           })
                         .app(PS.Data.Interval.Duration.Module.Duration
                                .app(PS.Data.Monoid.Module.mempty
                                       .app(
        PS.Data.Map.Internal.Module.monoidMap
          .app(PS.Data.Interval.Duration.Module.ordDurationComponent))));
  @JvmField
  val eqDuration = PS.Data.Eq.Module.Eq
                     .app({ x : Any ->
       { y : Any ->
        val l = x;
          val r = y;
          PS.Data.Eq.Module.eq
            .app(PS.Data.Map.Internal.Module.eqMap
                   .app(PS.Data.Interval.Duration.Module.eqDurationComponent)
                   .app(PS.Data.Eq.Module.eqNumber))
            .app(l)
            .app(r);}
    });
  @JvmField
  val ordDuration = PS.Data.Ord.Module.Ord
                      .app({ _ : Any ->
                           PS.Data.Interval.Duration.Module.eqDuration
                        })
                      .app({ x : Any ->
       { y : Any ->
        val l = x;
          val r = y;
          PS.Data.Ord.Module.compare
            .app(PS.Data.Map.Internal.Module.ordMap
                   .app(PS.Data.Interval.Duration.Module.ordDurationComponent)
                   .app(PS.Data.Ord.Module.ordNumber))
            .app(l)
            .app(r);}
    });
  @JvmField
  val durationFromComponent = { k : Any ->
     { v : Any ->
       PS.Data.Interval.Duration.Module.Duration
         .app(PS.Data.Map.Internal.Module.singleton.app(k).app(v))
    }
  };
  @JvmField
  val hour = PS.Data.Interval.Duration.Module.durationFromComponent
               .app(PS.Data.Interval.Duration.Module.Hour);
  @JvmField
  val millisecond = PS.Control.Semigroupoid.Module.compose
                      .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                      .app(
                        PS.Data.Interval.Duration.Module.durationFromComponent
                          .app(PS.Data.Interval.Duration.Module.Second))
                      .app({ v : Any ->
       PS.Data.EuclideanRing.Module.div
         .app(PS.Data.EuclideanRing.Module.euclideanRingNumber)
         .app(v)
         .app(1000.0)
    });
  @JvmField
  val minute = PS.Data.Interval.Duration.Module.durationFromComponent
                 .app(PS.Data.Interval.Duration.Module.Minute);
  @JvmField
  val month = PS.Data.Interval.Duration.Module.durationFromComponent
                .app(PS.Data.Interval.Duration.Module.Month);
  @JvmField
  val second = PS.Data.Interval.Duration.Module.durationFromComponent
                 .app(PS.Data.Interval.Duration.Module.Second);
  @JvmField
  val week = PS.Data.Interval.Duration.Module.durationFromComponent
               .app(PS.Data.Interval.Duration.Module.Week);
  @JvmField
  val year = PS.Data.Interval.Duration.Module.durationFromComponent
               .app(PS.Data.Interval.Duration.Module.Year);
  @JvmField
  val day = PS.Data.Interval.Duration.Module.durationFromComponent
              .app(PS.Data.Interval.Duration.Module.Day);
}