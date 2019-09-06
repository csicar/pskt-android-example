@file:Suppress("UNCHECKED_CAST")
package PS.Data.DateTime.Instant
import Foreign.PsRuntime.app
object Module  {
  val fromDateTimeImpl = Foreign.Data.DateTime.Instant.fromDateTimeImpl;
  val toDateTimeImpl = Foreign.Data.DateTime.Instant.toDateTimeImpl;
  @JvmField val Instant = { x : Any -> x};
  @JvmField val unInstant = { v : Any -> when { else -> { val ms = v; ms; } }};
  @JvmField
  val toDateTime = object   {
                       val mkDateTime = PS.Partial.Unsafe.Module.unsafePartial
                                          .app({ dictPartial : Any ->
                            { y : Any ->
                              { mo : Any ->
                                { d : Any ->
                                  { h : Any ->
                                    { mi : Any ->
                                      { s : Any ->
                                        { ms : Any ->
                                          PS.Data.DateTime.Module.DateTime
                                            .app(
                                              PS.Data.Date.Module.canonicalDate
                                                .app(y)
                                                .app(
                                                  PS.Data.Maybe.Module.fromJust
                                                    .app(Unit)
                                                    .app(
                                                    PS.Data.Enum.Module.toEnum
                                                      .app(
                                                        PS.Data.Date.Component.Module.boundedEnumMonth
                                                      )
                                                      .app(mo)))
                                                .app(d))
                                            .app(PS.Data.Time.Module.Time.app(h)
                                                   .app(mi)
                                                   .app(s)
                                                   .app(ms))
                                       }
                                     }
                                   }
                                 }
                               }
                             }
                           }
                         });
                     }
                     .run({
      val mkDateTime = this.mkDateTime;
      PS.Data.DateTime.Instant.Module.toDateTimeImpl.app(mkDateTime);
    });
  @JvmField
  val showInstant = PS.Data.Show.Module.Show
                      .app({ v : Any ->
       when {
        else -> {
          val ms = v;
          (("(Instant " as String) + (((PS.Data.Show.Module.show
                                          .app(
                                            PS.Data.Time.Duration.Module.showMilliseconds
                                          )
                                          .app(ms
          ) as String) + (")" as String)) as String));
        }
      }
    });
  @JvmField val ordDateTime = PS.Data.Time.Duration.Module.ordMilliseconds;
  @JvmField
  val instant = { v : Any ->
     when {
      (PS.Data.HeytingAlgebra.Module.conj
         .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
         .app(PS.Data.Ord.Module.greaterThanOrEq
                .app(PS.Data.Ord.Module.ordNumber)
                .app(v)
                .app(PS.Data.Ring.Module.negate
                       .app(PS.Data.Ring.Module.ringNumber)
                       .app(8.6399778816e15)))
         .app(PS.Data.Ord.Module.lessThanOrEq.app(PS.Data.Ord.Module.ordNumber)
                .app(v)
                .app(8.639977881599999e15)) as Boolean) -> {
        val ms = v;
        val n = v;
        PS.Data.Maybe.Module.Just
          .app(PS.Data.DateTime.Instant.Module.Instant.app(ms));
      }
      (PS.Data.Boolean.Module.otherwise as Boolean) -> {
        val ms = v;
        val n = v;
        PS.Data.Maybe.Module.Nothing;
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val fromDateTime = { v : Any ->
     when {
      (v is PS.Data.DateTime.Module._Type_DateTime.DateTime) -> {
        val d = v.value0;
        val t = v.value1;
        PS.Data.Function.Uncurried.Module.runFn7
          .app(PS.Data.DateTime.Instant.Module.fromDateTimeImpl)
          .app(PS.Data.Date.Module.year.app(d))
          .app(PS.Data.Enum.Module.fromEnum
                 .app(PS.Data.Date.Component.Module.boundedEnumMonth)
                 .app(PS.Data.Date.Module.month.app(d)))
          .app(PS.Data.Date.Module.day.app(d))
          .app(PS.Data.Time.Module.hour.app(t))
          .app(PS.Data.Time.Module.minute.app(t))
          .app(PS.Data.Time.Module.second.app(t))
          .app(PS.Data.Time.Module.millisecond.app(t));
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val fromDate = { d : Any ->
     PS.Data.Function.Uncurried.Module.runFn7
       .app(PS.Data.DateTime.Instant.Module.fromDateTimeImpl)
       .app(PS.Data.Date.Module.year.app(d))
       .app(PS.Data.Enum.Module.fromEnum
              .app(PS.Data.Date.Component.Module.boundedEnumMonth)
              .app(PS.Data.Date.Module.month.app(d)))
       .app(PS.Data.Date.Module.day.app(d))
       .app(PS.Data.Bounded.Module.bottom
              .app(PS.Data.Time.Component.Module.boundedHour))
       .app(PS.Data.Bounded.Module.bottom
              .app(PS.Data.Time.Component.Module.boundedMinute))
       .app(PS.Data.Bounded.Module.bottom
              .app(PS.Data.Time.Component.Module.boundedSecond))
       .app(PS.Data.Bounded.Module.bottom
              .app(PS.Data.Time.Component.Module.boundedMillisecond))
  };
  @JvmField val eqDateTime = PS.Data.Time.Duration.Module.eqMilliseconds;
  @JvmField
  val boundedInstant = PS.Data.Bounded.Module.Bounded
                         .app({ _ : Any ->
                              PS.Data.DateTime.Instant.Module.ordDateTime
                           })
                         .app(PS.Data.DateTime.Instant.Module.Instant
                                .app(PS.Data.Time.Duration.Module.Milliseconds
                                       .app(PS.Data.Ring.Module.negate
                                              .app(
                                                PS.Data.Ring.Module.ringNumber)
                                              .app(8.6399778816e15))))
                         .app(PS.Data.DateTime.Instant.Module.Instant
                                .app(PS.Data.Time.Duration.Module.Milliseconds
                                       .app(8.639977881599999e15)));
}