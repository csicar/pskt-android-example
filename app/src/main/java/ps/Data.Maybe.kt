@file:Suppress("UNCHECKED_CAST")
package PS.Data.Maybe
import Foreign.PsRuntime.app
object Module  {
  sealed class _Type_Maybe ()  {
    object Nothing : _Type_Maybe() {};
    data class Just (val value0 : Any) : _Type_Maybe() {};
  };
  val Nothing = _Type_Maybe.Nothing;
  val Just = { value0 : Any -> _Type_Maybe.Just(value0)};
  @JvmField
  val showMaybe = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ v : Any ->
         when {
          (v is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
            val x = v.value0;
            (("(Just " as String) + (((PS.Data.Show.Module.show.app(dictShow)
                                         .app(x
            ) as String) + (")" as String)) as String));
          }
          (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
            "Nothing";
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      })
  };
  @JvmField
  val semigroupMaybe = { dictSemigroup : Any ->
     PS.Data.Semigroup.Module.Semigroup
       .app({ v : Any ->
         { v1 : Any ->
           when {
            (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
              val y = v1;
              y;
            }
            (v1 is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
              val x = v;
              x;
            }
            (v is PS.Data.Maybe.Module._Type_Maybe
                    .Just)&& (v1 is PS.Data.Maybe.Module._Type_Maybe
                                      .Just) -> {
              val x = v.value0;
              val y = v1.value0;
              PS.Data.Maybe.Module.Just
                .app(PS.Data.Semigroup.Module.append.app(dictSemigroup).app(x)
                       .app(y));
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      })
  };
  @JvmField
  val optional = { dictAlternative : Any ->
     { a : Any ->
       PS.Control.Alt.Module.alt
         .app(((dictAlternative as Map<String, Any>)["Plus1"]!!
                 .app(Unit) as Map<String, Any>)["Alt0"]!!
                .app(Unit))
         .app(PS.Data.Functor.Module.map
                .app((((dictAlternative as Map<String, Any>)["Plus1"]!!
                         .app(Unit) as Map<String, Any>)["Alt0"]!!
                        .app(Unit) as Map<String, Any>)["Functor0"]!!
                       .app(Unit))
                .app(PS.Data.Maybe.Module.Just)
                .app(a))
         .app(PS.Control.Applicative.Module.pure
                .app((dictAlternative as Map<String, Any>)["Applicative0"]!!
                       .app(Unit))
                .app(PS.Data.Maybe.Module.Nothing))
    }
  };
  @JvmField
  val monoidMaybe = { dictSemigroup : Any ->
     PS.Data.Monoid.Module.Monoid
       .app({ _ : Any ->
            PS.Data.Maybe.Module.semigroupMaybe.app(dictSemigroup)
         })
       .app(PS.Data.Maybe.Module.Nothing)
  };
  @JvmField
  val maybe_tick = { v : Any ->
     { v1 : Any ->
       { v2 : Any ->
         when {
          (v2 is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
            val g = v;
            g.app(PS.Data.Unit.Module.unit);
          }
          (v2 is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
            val f = v1;
            val a = v2.value0;
            f.app(a);
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    }
  };
  @JvmField
  val maybe = { v : Any ->
     { v1 : Any ->
       { v2 : Any ->
         when {
          (v2 is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
            val b = v;
            b;
          }
          (v2 is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
            val f = v1;
            val a = v2.value0;
            f.app(a);
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    }
  };
  @JvmField
  val isNothing = PS.Data.Maybe.Module.maybe.app(true)
                    .app(PS.Data.Function.Module._const.app(false));
  @JvmField
  val isJust = PS.Data.Maybe.Module.maybe.app(false)
                 .app(PS.Data.Function.Module._const.app(true));
  @JvmField
  val functorMaybe = PS.Data.Functor.Module.Functor
                       .app({ v : Any ->
       { v1 : Any ->
         when {
          (v1 is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
            val fn = v;
            val x = v1.value0;
            PS.Data.Maybe.Module.Just.app(fn.app(x));
          }
          else -> {
            PS.Data.Maybe.Module.Nothing;
          }
        }
      }
    });
  @JvmField
  val invariantMaybe = PS.Data.Functor.Invariant.Module.Invariant
                         .app(PS.Data.Functor.Invariant.Module.imapF
                                .app(PS.Data.Maybe.Module.functorMaybe));
  @JvmField
  val fromMaybe_tick = { a : Any ->
     PS.Data.Maybe.Module.maybe_tick.app(a)
       .app(PS.Control.Category.Module.identity
              .app(PS.Control.Category.Module.categoryFn))
  };
  @JvmField
  val fromMaybe = { a : Any ->
     PS.Data.Maybe.Module.maybe.app(a)
       .app(PS.Control.Category.Module.identity
              .app(PS.Control.Category.Module.categoryFn))
  };
  @JvmField
  val fromJust = { dictPartial : Any ->
     { v : Any ->
       when {
        (v is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
          val x = v.value0;
          x;
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val extendMaybe = PS.Control.Extend.Module.Extend
                      .app({ _ : Any ->
                           PS.Data.Maybe.Module.functorMaybe
                        })
                      .app({ v : Any ->
       { v1 : Any ->
         when {
          (v1 is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
            PS.Data.Maybe.Module.Nothing;
          }
          else -> {
            val f = v;
            val x = v1;
            PS.Data.Maybe.Module.Just.app(f.app(x));
          }
        }
      }
    });
  @JvmField
  val eqMaybe = { dictEq : Any ->
     PS.Data.Eq.Module.Eq
       .app({ x : Any ->
         { y : Any ->
           when {
            (x is PS.Data.Maybe.Module._Type_Maybe
                    .Nothing)&& (y is PS.Data.Maybe.Module._Type_Maybe
                                        .Nothing) -> {
              true;
            }
            (x is PS.Data.Maybe.Module._Type_Maybe
                    .Just)&& (y is PS.Data.Maybe.Module._Type_Maybe
                                     .Just) -> {
              val l = x.value0;
              val r = y.value0;
              PS.Data.Eq.Module.eq.app(dictEq).app(l).app(r);
            }
            else -> {
              false;
            }
          }
        }
      })
  };
  @JvmField
  val ordMaybe = { dictOrd : Any ->
     PS.Data.Ord.Module.Ord
       .app({ _ : Any ->
            PS.Data.Maybe.Module.eqMaybe
              .app((dictOrd as Map<String, Any>)["Eq0"]!!.app(Unit))
         })
       .app({ x : Any ->
         { y : Any ->
           when {
            (x is PS.Data.Maybe.Module._Type_Maybe
                    .Nothing)&& (y is PS.Data.Maybe.Module._Type_Maybe
                                        .Nothing) -> {
              PS.Data.Ordering.Module.EQ;
            }
            (x is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
              PS.Data.Ordering.Module.LT;
            }
            (y is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
              PS.Data.Ordering.Module.GT;
            }
            (x is PS.Data.Maybe.Module._Type_Maybe
                    .Just)&& (y is PS.Data.Maybe.Module._Type_Maybe
                                     .Just) -> {
              val l = x.value0;
              val r = y.value0;
              PS.Data.Ord.Module.compare.app(dictOrd).app(l).app(r);
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      })
  };
  @JvmField
  val eq1Maybe = PS.Data.Eq.Module.Eq1
                   .app({ dictEq : Any ->
       PS.Data.Eq.Module.eq.app(PS.Data.Maybe.Module.eqMaybe.app(dictEq))
    });
  @JvmField
  val ord1Maybe = PS.Data.Ord.Module.Ord1
                    .app({ _ : Any ->
                         PS.Data.Maybe.Module.eq1Maybe
                      })
                    .app({ dictOrd : Any ->
       PS.Data.Ord.Module.compare
         .app(PS.Data.Maybe.Module.ordMaybe.app(dictOrd))
    });
  @JvmField
  val boundedMaybe = { dictBounded : Any ->
     PS.Data.Bounded.Module.Bounded
       .app({ _ : Any ->
            PS.Data.Maybe.Module.ordMaybe
              .app((dictBounded as Map<String, Any>)["Ord0"]!!.app(Unit))
         })
       .app(PS.Data.Maybe.Module.Nothing)
       .app(PS.Data.Maybe.Module.Just
              .app(PS.Data.Bounded.Module.top.app(dictBounded)))
  };
  @JvmField
  val applyMaybe = PS.Control.Apply.Module.Apply
                     .app({ _ : Any ->
                          PS.Data.Maybe.Module.functorMaybe
                       })
                     .app({ v : Any ->
       { v1 : Any ->
         when {
          (v is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
            val fn = v.value0;
            val x = v1;
            PS.Data.Functor.Module.map.app(PS.Data.Maybe.Module.functorMaybe)
              .app(fn)
              .app(x);
          }
          (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
            PS.Data.Maybe.Module.Nothing;
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val bindMaybe = PS.Control.Bind.Module.Bind
                    .app({ _ : Any ->
                         PS.Data.Maybe.Module.applyMaybe
                      })
                    .app({ v : Any ->
       { v1 : Any ->
         when {
          (v is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
            val x = v.value0;
            val k = v1;
            k.app(x);
          }
          (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
            PS.Data.Maybe.Module.Nothing;
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val applicativeMaybe = PS.Control.Applicative.Module.Applicative
                           .app({ _ : Any ->
                                PS.Data.Maybe.Module.applyMaybe
                             })
                           .app(PS.Data.Maybe.Module.Just);
  @JvmField
  val monadMaybe = PS.Control.Monad.Module.Monad
                     .app({ _ : Any ->
                          PS.Data.Maybe.Module.applicativeMaybe
                       })
                     .app({ _ : Any ->
       PS.Data.Maybe.Module.bindMaybe
    });
  @JvmField
  val altMaybe = PS.Control.Alt.Module.Alt
                   .app({ _ : Any ->
                        PS.Data.Maybe.Module.functorMaybe
                     })
                   .app({ v : Any ->
       { v1 : Any ->
         when {
          (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
            val r = v1;
            r;
          }
          else -> {
            val l = v;
            l;
          }
        }
      }
    });
  @JvmField
  val plusMaybe = PS.Control.Plus.Module.Plus
                    .app({ _ : Any ->
                         PS.Data.Maybe.Module.altMaybe
                      })
                    .app(PS.Data.Maybe.Module.Nothing);
  @JvmField
  val alternativeMaybe = PS.Control.Alternative.Module.Alternative
                           .app({ _ : Any ->
                                PS.Data.Maybe.Module.applicativeMaybe
                             })
                           .app({ _ : Any ->
       PS.Data.Maybe.Module.plusMaybe
    });
  @JvmField
  val monadZeroMaybe = PS.Control.MonadZero.Module.MonadZero
                         .app({ _ : Any ->
                              PS.Data.Maybe.Module.alternativeMaybe
                           })
                         .app({ _ : Any ->
       PS.Data.Maybe.Module.monadMaybe
    });
}