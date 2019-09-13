@file:Suppress("UNCHECKED_CAST")

package PS.Data.Int
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  val fromNumberImpl = Foreign.Data.Int.fromNumberImpl;
  val toNumber = Foreign.Data.Int.toNumber;
  val quot = Foreign.Data.Int.quot;
  val rem = Foreign.Data.Int.rem;
  val pow = Foreign.Data.Int.pow;
  val fromStringAsImpl = Foreign.Data.Int.fromStringAsImpl;
  val toStringAs = Foreign.Data.Int.toStringAs;
  sealed class _Type_Parity ()  {
    object Even : _Type_Parity() {};
    object Odd : _Type_Parity() {};
  };
  val Even = _Type_Parity.Even;
  val Odd = _Type_Parity.Odd;
  @JvmField val Radix = { x : Any -> x};
  @JvmField
  val showParity = PS.Data.Show.Module.Show
                     .app({ v : Any ->
       when {
        (v is PS.Data.Int.Module._Type_Parity.Even) -> {
          "Even";
        }
        (v is PS.Data.Int.Module._Type_Parity.Odd) -> {
          "Odd";
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    });
  @JvmField
  val radix = { n : Any ->
     when {
      (PS.Data.HeytingAlgebra.Module.conj
         .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
         .app(PS.Data.Ord.Module.greaterThanOrEq.app(PS.Data.Ord.Module.ordInt)
                .app(n)
                .app(2))
         .app(PS.Data.Ord.Module.lessThanOrEq.app(PS.Data.Ord.Module.ordInt)
                .app(n)
                .app(36)) as Boolean) -> {
        val n1 = n;
        PS.Data.Maybe.Module.Just.app(PS.Data.Int.Module.Radix.app(n1));
      }
      (PS.Data.Boolean.Module.otherwise as Boolean) -> {
        val n1 = n;
        PS.Data.Maybe.Module.Nothing;
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val odd = { x : Any ->
     PS.Data.Eq.Module.notEq.app(PS.Data.Eq.Module.eqInt)
       .app(PS.Data.Int.Bits.Module.and.app(x).app(1))
       .app(0)
  };
  @JvmField val octal = PS.Data.Int.Module.Radix.app(8);
  @JvmField val hexadecimal = PS.Data.Int.Module.Radix.app(16);
  @JvmField
  val fromStringAs = PS.Data.Int.Module.fromStringAsImpl
                       .app(PS.Data.Maybe.Module.Just)
                       .app(PS.Data.Maybe.Module.Nothing);
  @JvmField
  val fromString = PS.Data.Int.Module.fromStringAs
                     .app(PS.Data.Int.Module.Radix.app(10));
  @JvmField
  val fromNumber = PS.Data.Int.Module.fromNumberImpl
                     .app(PS.Data.Maybe.Module.Just)
                     .app(PS.Data.Maybe.Module.Nothing);
  @JvmField
  val unsafeClamp = { x : Any ->
     when {
      (PS.Data.Eq.Module.eq.app(PS.Data.Eq.Module.eqNumber).app(x)
         .app(PS.Global.Module.infinity) as Boolean) -> {
        val x1 = x;
        0;
      }
      (PS.Data.Eq.Module.eq.app(PS.Data.Eq.Module.eqNumber).app(x)
         .app(PS.Data.Ring.Module.negate.app(PS.Data.Ring.Module.ringNumber)
                .app(PS.Global.Module.infinity)) as Boolean) -> {
        val x1 = x;
        0;
      }
      (PS.Data.Ord.Module.greaterThanOrEq.app(PS.Data.Ord.Module.ordNumber)
         .app(x)
         .app(PS.Data.Int.Module.toNumber
                .app(PS.Data.Bounded.Module.top
                       .app(PS.Data.Bounded.Module.boundedInt))
      ) as Boolean) -> {
        val x1 = x;
        PS.Data.Bounded.Module.top.app(PS.Data.Bounded.Module.boundedInt);
      }
      (PS.Data.Ord.Module.lessThanOrEq.app(PS.Data.Ord.Module.ordNumber).app(x)
         .app(PS.Data.Int.Module.toNumber
                .app(PS.Data.Bounded.Module.bottom
                       .app(PS.Data.Bounded.Module.boundedInt))
      ) as Boolean) -> {
        val x1 = x;
        PS.Data.Bounded.Module.bottom.app(PS.Data.Bounded.Module.boundedInt);
      }
      (PS.Data.Boolean.Module.otherwise as Boolean) -> {
        val x1 = x;
        PS.Data.Maybe.Module.fromMaybe.app(0)
          .app(PS.Data.Int.Module.fromNumber.app(x1));
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val round = PS.Control.Semigroupoid.Module.compose
                .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                .app(PS.Data.Int.Module.unsafeClamp)
                .app(PS.Math.Module.round);
  @JvmField
  val floor = PS.Control.Semigroupoid.Module.compose
                .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                .app(PS.Data.Int.Module.unsafeClamp)
                .app(PS.Math.Module.floor);
  @JvmField
  val even = { x : Any ->
     PS.Data.Eq.Module.eq.app(PS.Data.Eq.Module.eqInt)
       .app(PS.Data.Int.Bits.Module.and.app(x).app(1))
       .app(0)
  };
  @JvmField
  val parity = { n : Any ->
     when {
      (PS.Data.Int.Module.even.app(n) == true) -> {
        PS.Data.Int.Module.Even;
      }
      else -> {
        PS.Data.Int.Module.Odd;
      }
    }
  };
  @JvmField
  val eqParity = PS.Data.Eq.Module.Eq
                   .app({ x : Any ->
       { y : Any ->
         when {
          (x is PS.Data.Int.Module._Type_Parity
                  .Even)&& (y is PS.Data.Int.Module._Type_Parity
                                   .Even) -> {
            true;
          }
          (x is PS.Data.Int.Module._Type_Parity
                  .Odd)&& (y is PS.Data.Int.Module._Type_Parity
                                  .Odd) -> {
            true;
          }
          else -> {
            false;
          }
        }
      }
    });
  @JvmField
  val ordParity = PS.Data.Ord.Module.Ord
                    .app({ _ : Any ->
                         PS.Data.Int.Module.eqParity
                      })
                    .app({ x : Any ->
       { y : Any ->
         when {
          (x is PS.Data.Int.Module._Type_Parity
                  .Even)&& (y is PS.Data.Int.Module._Type_Parity
                                   .Even) -> {
            PS.Data.Ordering.Module.EQ;
          }
          (x is PS.Data.Int.Module._Type_Parity.Even) -> {
            PS.Data.Ordering.Module.LT;
          }
          (y is PS.Data.Int.Module._Type_Parity.Even) -> {
            PS.Data.Ordering.Module.GT;
          }
          (x is PS.Data.Int.Module._Type_Parity
                  .Odd)&& (y is PS.Data.Int.Module._Type_Parity
                                  .Odd) -> {
            PS.Data.Ordering.Module.EQ;
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val semiringParity = PS.Data.Semiring.Module.Semiring
                         .app({ x : Any ->
                              { y : Any ->
                                when {
                                 (PS.Data.Eq.Module.eq
                                    .app(PS.Data.Int.Module.eqParity)
                                    .app(x)
                                    .app(y) == true) -> {
                                   PS.Data.Int.Module.Even;
                                 }
                                 else -> {
                                   PS.Data.Int.Module.Odd;
                                 }
                               }
                             }
                           })
                         .app({ v : Any ->
                              { v1 : Any ->
                                when {
                                 (v is PS.Data.Int.Module._Type_Parity
                                         .Odd)&&
                                 (v1 is PS.Data.Int.Module._Type_Parity
                                          .Odd) -> {
                                   PS.Data.Int.Module.Odd;
                                 }
                                 else -> {
                                   PS.Data.Int.Module.Even;
                                 }
                               }
                             }
                           })
                         .app(PS.Data.Int.Module.Odd)
                         .app(PS.Data.Int.Module.Even);
  @JvmField
  val ringParity = PS.Data.Ring.Module.Ring
                     .app({ _ : Any ->
                          PS.Data.Int.Module.semiringParity
                       })
                     .app(PS.Data.Semiring.Module.add
                            .app(PS.Data.Int.Module.semiringParity));
  @JvmField
  val divisionRingParity = PS.Data.DivisionRing.Module.DivisionRing
                             .app({ _ : Any ->
                                  PS.Data.Int.Module.ringParity
                               })
                             .app(PS.Control.Category.Module.identity
                                    .app(PS.Control.Category.Module.categoryFn)
  );
  @JvmField val decimal = PS.Data.Int.Module.Radix.app(10);
  @JvmField
  val commutativeRingParity = PS.Data.CommutativeRing.Module.CommutativeRing
                                .app({ _ : Any ->
       PS.Data.Int.Module.ringParity
    });
  @JvmField
  val euclideanRingParity = PS.Data.EuclideanRing.Module.EuclideanRing
                              .app({ _ : Any ->
                                   PS.Data.Int.Module.commutativeRingParity
                                })
                              .app({ v : Any ->
                                   when {
                                    (v is PS.Data.Int.Module._Type_Parity
                                            .Even) -> {
                                      0;
                                    }
                                    (v is PS.Data.Int.Module._Type_Parity
                                            .Odd) -> {
                                      1;
                                    }
                                    else -> (error("Error in Pattern Match"
                                    ) as Any)
                                  }
                                })
                              .app({ x : Any ->
                                   { v : Any ->
                                     x
                                  }
                                })
                              .app({ v : Any ->
       { v1 : Any ->
         PS.Data.Int.Module.Even
      }
    });
  @JvmField
  val ceil = PS.Control.Semigroupoid.Module.compose
               .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
               .app(PS.Data.Int.Module.unsafeClamp)
               .app(PS.Math.Module.ceil);
  @JvmField
  val boundedParity = PS.Data.Bounded.Module.Bounded
                        .app({ _ : Any ->
                             PS.Data.Int.Module.ordParity
                          })
                        .app(PS.Data.Int.Module.Even)
                        .app(PS.Data.Int.Module.Odd);
  @JvmField val binary = PS.Data.Int.Module.Radix.app(2);
  @JvmField val base36 = PS.Data.Int.Module.Radix.app(36);
}