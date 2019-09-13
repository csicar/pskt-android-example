@file:Suppress("UNCHECKED_CAST")

package PS.Data.Interval.Duration.Iso
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  sealed class _Type_Error ()  {
    object IsEmpty : _Type_Error() {};
    object InvalidWeekComponentUsage : _Type_Error() {};
    data class ContainsNegativeValue (val value0 : Any) : _Type_Error() {};
    data class InvalidFractionalUse (val value0 : Any) : _Type_Error() {};
  };
  val IsEmpty = _Type_Error.IsEmpty;
  val InvalidWeekComponentUsage = _Type_Error.InvalidWeekComponentUsage;
  val ContainsNegativeValue = { value0 : Any ->
     _Type_Error.ContainsNegativeValue(value0)
  };
  val InvalidFractionalUse = { value0 : Any ->
     _Type_Error.InvalidFractionalUse(value0)
  };
  @JvmField val IsoDuration = { x : Any -> x};
  @JvmField val unIsoDuration = { v : Any ->val a = v; a;};
  @JvmField
  val showIsoDuration = PS.Data.Show.Module.Show
                          .app({ v : Any ->
      val d = v;
        (("(IsoDuration " as String) + (((PS.Data.Show.Module.show
                                            .app(
                                              PS.Data.Interval.Duration.Module.showDuration
                                            )
                                            .app(d
        ) as String) + (")" as String)) as String));});
  @JvmField
  val showError = PS.Data.Show.Module.Show
                    .app({ v : Any ->
       when {
        (v is PS.Data.Interval.Duration.Iso.Module._Type_Error.IsEmpty) -> {
          "(IsEmpty)";
        }
        (v is PS.Data.Interval.Duration.Iso.Module._Type_Error
                .InvalidWeekComponentUsage) -> {
          "(InvalidWeekComponentUsage)";
        }
        (v is PS.Data.Interval.Duration.Iso.Module._Type_Error
                .ContainsNegativeValue) -> {
          val c = v.value0;
          (("(ContainsNegativeValue " as String) + (((PS.Data.Show.Module.show
                                                        .app(
                                                          PS.Data.Interval.Duration.Module.showDurationComponent
                                                        )
                                                        .app(c
          ) as String) + (")" as String)) as String));
        }
        (v is PS.Data.Interval.Duration.Iso.Module._Type_Error
                .InvalidFractionalUse) -> {
          val c = v.value0;
          (("(InvalidFractionalUse " as String) + (((PS.Data.Show.Module.show
                                                       .app(
                                                         PS.Data.Interval.Duration.Module.showDurationComponent
                                                       )
                                                       .app(c
          ) as String) + (")" as String)) as String));
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    });
  @JvmField
  val prettyError = { v : Any ->
     when {
      (v is PS.Data.Interval.Duration.Iso.Module._Type_Error.IsEmpty) -> {
        "Duration is empty (has no components)";
      }
      (v is PS.Data.Interval.Duration.Iso.Module._Type_Error
              .InvalidWeekComponentUsage) -> {
        "Week component of Duration is used with other components";
      }
      (v is PS.Data.Interval.Duration.Iso.Module._Type_Error
              .ContainsNegativeValue) -> {
        val c = v.value0;
        (("Component `" as String) + (((PS.Data.Show.Module.show
                                          .app(
                                            PS.Data.Interval.Duration.Module.showDurationComponent
                                          )
                                          .app(c
        ) as String) + ("` contains negative value" as String)) as String));
      }
      (v is PS.Data.Interval.Duration.Iso.Module._Type_Error
              .InvalidFractionalUse) -> {
        val c = v.value0;
        (("Invalid usage of Fractional value at component `" as String) + (((PS.Data.Show.Module.show
                                                                               .app(
                                                                                 PS.Data.Interval.Duration.Module.showDurationComponent
                                                                               )
                                                                               .app(
          c) as String) + ("`" as String)) as String));
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val eqIsoDuration = PS.Data.Eq.Module.Eq
                        .app({ x : Any ->
       { y : Any ->
        val l = x;
          val r = y;
          PS.Data.Eq.Module.eq.app(PS.Data.Interval.Duration.Module.eqDuration)
            .app(l)
            .app(r);}
    });
  @JvmField
  val ordIsoDuration = PS.Data.Ord.Module.Ord
                         .app({ _ : Any ->
                              PS.Data.Interval.Duration.Iso.Module.eqIsoDuration
                           })
                         .app({ x : Any ->
       { y : Any ->
        val l = x;
          val r = y;
          PS.Data.Ord.Module.compare
            .app(PS.Data.Interval.Duration.Module.ordDuration)
            .app(l)
            .app(r);}
    });
  @JvmField
  val eqError = PS.Data.Eq.Module.Eq
                  .app({ x : Any ->
       { y : Any ->
         when {
          (x is PS.Data.Interval.Duration.Iso.Module._Type_Error
                  .IsEmpty)&&
          (y is PS.Data.Interval.Duration.Iso.Module._Type_Error
                  .IsEmpty) -> {
            true;
          }
          (x is PS.Data.Interval.Duration.Iso.Module._Type_Error
                  .InvalidWeekComponentUsage)&&
          (y is PS.Data.Interval.Duration.Iso.Module._Type_Error
                  .InvalidWeekComponentUsage) -> {
            true;
          }
          (x is PS.Data.Interval.Duration.Iso.Module._Type_Error
                  .ContainsNegativeValue)&&
          (y is PS.Data.Interval.Duration.Iso.Module._Type_Error
                  .ContainsNegativeValue) -> {
            val l = x.value0;
            val r = y.value0;
            PS.Data.Eq.Module.eq
              .app(PS.Data.Interval.Duration.Module.eqDurationComponent)
              .app(l)
              .app(r);
          }
          (x is PS.Data.Interval.Duration.Iso.Module._Type_Error
                  .InvalidFractionalUse)&&
          (y is PS.Data.Interval.Duration.Iso.Module._Type_Error
                  .InvalidFractionalUse) -> {
            val l = x.value0;
            val r = y.value0;
            PS.Data.Eq.Module.eq
              .app(PS.Data.Interval.Duration.Module.eqDurationComponent)
              .app(l)
              .app(r);
          }
          else -> {
            false;
          }
        }
      }
    });
  @JvmField
  val ordError = PS.Data.Ord.Module.Ord
                   .app({ _ : Any ->
                        PS.Data.Interval.Duration.Iso.Module.eqError
                     })
                   .app({ x : Any ->
       { y : Any ->
         when {
          (x is PS.Data.Interval.Duration.Iso.Module._Type_Error
                  .IsEmpty)&&
          (y is PS.Data.Interval.Duration.Iso.Module._Type_Error
                  .IsEmpty) -> {
            PS.Data.Ordering.Module.EQ;
          }
          (x is PS.Data.Interval.Duration.Iso.Module._Type_Error.IsEmpty) -> {
            PS.Data.Ordering.Module.LT;
          }
          (y is PS.Data.Interval.Duration.Iso.Module._Type_Error.IsEmpty) -> {
            PS.Data.Ordering.Module.GT;
          }
          (x is PS.Data.Interval.Duration.Iso.Module._Type_Error
                  .InvalidWeekComponentUsage)&&
          (y is PS.Data.Interval.Duration.Iso.Module._Type_Error
                  .InvalidWeekComponentUsage) -> {
            PS.Data.Ordering.Module.EQ;
          }
          (x is PS.Data.Interval.Duration.Iso.Module._Type_Error
                  .InvalidWeekComponentUsage) -> {
            PS.Data.Ordering.Module.LT;
          }
          (y is PS.Data.Interval.Duration.Iso.Module._Type_Error
                  .InvalidWeekComponentUsage) -> {
            PS.Data.Ordering.Module.GT;
          }
          (x is PS.Data.Interval.Duration.Iso.Module._Type_Error
                  .ContainsNegativeValue)&&
          (y is PS.Data.Interval.Duration.Iso.Module._Type_Error
                  .ContainsNegativeValue) -> {
            val l = x.value0;
            val r = y.value0;
            PS.Data.Ord.Module.compare
              .app(PS.Data.Interval.Duration.Module.ordDurationComponent)
              .app(l)
              .app(r);
          }
          (x is PS.Data.Interval.Duration.Iso.Module._Type_Error
                  .ContainsNegativeValue) -> {
            PS.Data.Ordering.Module.LT;
          }
          (y is PS.Data.Interval.Duration.Iso.Module._Type_Error
                  .ContainsNegativeValue) -> {
            PS.Data.Ordering.Module.GT;
          }
          (x is PS.Data.Interval.Duration.Iso.Module._Type_Error
                  .InvalidFractionalUse)&&
          (y is PS.Data.Interval.Duration.Iso.Module._Type_Error
                  .InvalidFractionalUse) -> {
            val l = x.value0;
            val r = y.value0;
            PS.Data.Ord.Module.compare
              .app(PS.Data.Interval.Duration.Module.ordDurationComponent)
              .app(l)
              .app(r);
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val checkWeekUsage = { v : Any ->
     when {
      ((v as Map<String, Any>).size == 1) -> {
        val asMap = v["asMap"]!!;
        when {
          (PS.Data.HeytingAlgebra.Module.conj
             .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
             .app(PS.Data.Maybe.Module.isJust
                    .app(PS.Data.Map.Internal.Module.lookup
                           .app(
                             PS.Data.Interval.Duration.Module.ordDurationComponent
                           )
                           .app(PS.Data.Interval.Duration.Module.Week)
                           .app(asMap)))
             .app(PS.Data.Ord.Module.greaterThan.app(PS.Data.Ord.Module.ordInt)
                    .app(PS.Data.Map.Internal.Module.size.app(asMap))
                    .app(1)) == true) -> {
            PS.Control.Applicative.Module.pure
              .app(PS.Data.List.Types.Module.applicativeList)
              .app(
              PS.Data.Interval.Duration.Iso.Module.InvalidWeekComponentUsage);
          }
          else -> {
            PS.Control.Plus.Module.empty
              .app(PS.Data.List.Types.Module.plusList);
          }
        };
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val checkNegativeValues = { v : Any ->
     when {
      ((v as Map<String, Any>).size == 1) -> {
        val asList = v["asList"]!!;
        PS.Data.Function.Module.flip
          .app(PS.Data.Foldable.Module.foldMap
                 .app(PS.Data.List.Types.Module.foldableList)
                 .app(PS.Data.List.Types.Module.monoidList))
          .app(asList)
          .app({ v1 : Any ->
             when {
              (v1 is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                val c = v1.value0;
                val num = v1.value1;
                when {
                  (PS.Data.Ord.Module.greaterThanOrEq
                     .app(PS.Data.Ord.Module.ordNumber)
                     .app(num)
                     .app(0.0) == true) -> {
                    PS.Control.Plus.Module.empty
                      .app(PS.Data.List.Types.Module.plusList);
                  }
                  else -> {
                    PS.Control.Applicative.Module.pure
                      .app(PS.Data.List.Types.Module.applicativeList)
                      .app(
                      PS.Data.Interval.Duration.Iso.Module.ContainsNegativeValue
                        .app(c));
                  }
                };
              }
              else -> (error("Error in Pattern Match") as Any)
            }
          });
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val checkFractionalUse = { v : Any ->
     when {
      ((v as Map<String, Any>).size == 1) -> {
        val asList = v["asList"]!!;
        object   {
            val isFractional = { a : Any ->
               PS.Data.Eq.Module.notEq.app(PS.Data.Eq.Module.eqNumber)
                 .app(PS.Math.Module.floor.app(a))
                 .app(a)
            };
            val checkRest = { rest : Any ->
               PS.Data.Ord.Module.greaterThan.app(PS.Data.Ord.Module.ordNumber)
                 .app(PS.Data.Newtype.Module.unwrap
                        .app(PS.Data.Newtype.Module.newtypeAdditive)
                        .app(PS.Data.Foldable.Module.foldMap
                               .app(PS.Data.List.Types.Module.foldableList)
                               .app(
                                 PS.Data.Monoid.Additive.Module.monoidAdditive
                                   .app(PS.Data.Semiring.Module.semiringNumber))
                               .app(
                                 PS.Control.Semigroupoid.Module.composeFlipped
                                   .app(
                                     PS.Control.Semigroupoid.Module.semigroupoidFn
                                   )
                                   .app(PS.Data.Tuple.Module.snd)
                                   .app(
                                   PS.Control.Semigroupoid.Module.composeFlipped
                                     .app(
                                       PS.Control.Semigroupoid.Module.semigroupoidFn
                                     )
                                     .app(PS.Math.Module.abs)
                                     .app(
                                     PS.Data.Monoid.Additive.Module.Additive)))
                               .app(rest)))
                 .app(0.0)
            };
          }
          .run({
            val isFractional = this.isFractional;
            val checkRest = this.checkRest;
            object   {
                val v1 = { v2 : Any ->
                              (v2 as Map<String, Any>)["rest"]!!
                           }
                           .app(PS.Data.List.Module.span
                                  .app(
                                    PS.Control.Semigroupoid.Module.composeFlipped
                                      .app(
                                        PS.Control.Semigroupoid.Module.semigroupoidFn
                                      )
                                      .app(PS.Data.Tuple.Module.snd)
                                      .app(PS.Data.HeytingAlgebra.Module.not
                                             .app(
                                               PS.Data.HeytingAlgebra.Module.heytingAlgebraFunction
                                                 .app(
                                                 PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean
                                               ))
                                             .app(isFractional)))
                                  .app(asList));
              }
              .run({
                val v1 = this.v1;
                when {
                  (v1 is PS.Data.List.Types.Module._Type_List
                           .Cons)&& (v1
                                       .value0 is PS.Data.Tuple.Module._Type_Tuple
                                                    .Tuple)&& (checkRest
                                                                 .app(v1
                                                                        .value1
                  ) as Boolean) -> {
                    val c = v1.value0.value0;
                    val rest = v1.value1;
                    PS.Control.Applicative.Module.pure
                      .app(PS.Data.List.Types.Module.applicativeList)
                      .app(
                      PS.Data.Interval.Duration.Iso.Module.InvalidFractionalUse
                        .app(c));
                  }
                  else -> {
                    PS.Control.Plus.Module.empty
                      .app(PS.Data.List.Types.Module.plusList);
                  }
                };
              });
          });
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val checkEmptiness = { v : Any ->
     when {
      ((v as Map<String, Any>).size == 1) -> {
        val asList = v["asList"]!!;
        when {
          (PS.Data.List.Module._null.app(asList) == true) -> {
            PS.Control.Applicative.Module.pure
              .app(PS.Data.List.Types.Module.applicativeList)
              .app(PS.Data.Interval.Duration.Iso.Module.IsEmpty);
          }
          else -> {
            PS.Control.Plus.Module.empty
              .app(PS.Data.List.Types.Module.plusList);
          }
        };
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val checkValidIsoDuration = { v : Any ->
    val asMap = v;
      object   {
          val check = PS.Data.Foldable.Module.fold
                        .app(PS.Data.Foldable.Module.foldableArray)
                        .app(PS.Data.Monoid.Module.monoidFn
                               .app(PS.Data.List.Types.Module.monoidList))
                        .app(listOf(
              PS.Data.Interval.Duration.Iso.Module.checkWeekUsage,  
              PS.Data.Interval.Duration.Iso.Module.checkEmptiness,  
              PS.Data.Interval.Duration.Iso.Module.checkFractionalUse,  
              PS.Data.Interval.Duration.Iso.Module.checkNegativeValues));
          val asList = PS.Data.List.Module.reverse
                         .app(PS.Data.Map.Internal.Module.toUnfoldable
                                .app(PS.Data.List.Types.Module.unfoldableList)
                                .app(asMap));
        }
        .run({
          val check = this.check;
          val asList = this.asList;
          check.app(mapOf(("asList" to asList),  ("asMap" to asMap)));
        });};
  @JvmField
  val mkIsoDuration = { d : Any ->
     object   {
         val v = PS.Data.List.NonEmpty.Module.fromList
                   .app(
           PS.Data.Interval.Duration.Iso.Module.checkValidIsoDuration.app(d));
       }
       .run({
        val v = this.v;
        when {
          (v is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
            val errs = v.value0;
            PS.Data.Either.Module.Left.app(errs);
          }
          (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
            PS.Data.Either.Module.Right
              .app(PS.Data.Interval.Duration.Iso.Module.IsoDuration.app(d));
          }
          else -> (error("Error in Pattern Match") as Any)
        };
      })
  };
}