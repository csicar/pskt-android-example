@file:Suppress("UNCHECKED_CAST")
package PS.Data.Either
import Foreign.PsRuntime.app
object Module  {
  sealed class _Type_Either ()  {
    data class Left (val value0 : Any) : _Type_Either() {};
    data class Right (val value0 : Any) : _Type_Either() {};
  };
  val Left = { value0 : Any -> _Type_Either.Left(value0)};
  val Right = { value0 : Any -> _Type_Either.Right(value0)};
  @JvmField
  val showEither = { dictShow : Any ->
     { dictShow1 : Any ->
       PS.Data.Show.Module.Show
         .app({ v : Any ->
           when {
            (v is PS.Data.Either.Module._Type_Either.Left) -> {
              val x = v.value0;
              (("(Left " as String) + (((PS.Data.Show.Module.show.app(dictShow)
                                           .app(x
              ) as String) + (")" as String)) as String));
            }
            (v is PS.Data.Either.Module._Type_Either.Right) -> {
              val y = v.value0;
              (("(Right " as String) + (((PS.Data.Show.Module.show
                                            .app(dictShow1)
                                            .app(y
              ) as String) + (")" as String)) as String));
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        })
    }
  };
  @JvmField
  val note_tick = { f : Any ->
     PS.Data.Maybe.Module.maybe_tick
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Data.Either.Module.Left)
              .app(f))
       .app(PS.Data.Either.Module.Right)
  };
  @JvmField
  val note = { a : Any ->
     PS.Data.Maybe.Module.maybe.app(PS.Data.Either.Module.Left.app(a))
       .app(PS.Data.Either.Module.Right)
  };
  @JvmField
  val functorEither = PS.Data.Functor.Module.Functor
                        .app({ f : Any ->
       { m : Any ->
         when {
          (m is PS.Data.Either.Module._Type_Either.Left) -> {
            val v = m.value0;
            PS.Data.Either.Module.Left.app(v);
          }
          (m is PS.Data.Either.Module._Type_Either.Right) -> {
            val v = m.value0;
            PS.Data.Either.Module.Right.app(f.app(v));
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val functorWithIndexEither = PS.Data.FunctorWithIndex.Module.FunctorWithIndex
                                 .app({ _ : Any ->
                                      PS.Data.Either.Module.functorEither
                                   })
                                 .app({ f : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Functor.Module.map
                .app(PS.Data.Either.Module.functorEither))
         .app(f.app(PS.Data.Unit.Module.unit))
    });
  @JvmField
  val invariantEither = PS.Data.Functor.Invariant.Module.Invariant
                          .app(PS.Data.Functor.Invariant.Module.imapF
                                 .app(PS.Data.Either.Module.functorEither));
  @JvmField
  val fromRight = { dictPartial : Any ->
     { v : Any ->
       when {
        (v is PS.Data.Either.Module._Type_Either.Right) -> {
          val a = v.value0;
          a;
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val fromLeft = { dictPartial : Any ->
     { v : Any ->
       when {
        (v is PS.Data.Either.Module._Type_Either.Left) -> {
          val a = v.value0;
          a;
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val foldableEither = PS.Data.Foldable.Module.Foldable
                         .app({ dictMonoid : Any ->
                              { f : Any ->
                                { v : Any ->
                                  when {
                                   (v is PS.Data.Either.Module._Type_Either
                                           .Left) -> {
                                     val f1 = f;
                                     PS.Data.Monoid.Module.mempty
                                       .app(dictMonoid);
                                   }
                                   (v is PS.Data.Either.Module._Type_Either
                                           .Right) -> {
                                     val f1 = f;
                                     val x = v.value0;
                                     f1.app(x);
                                   }
                                   else -> (error("Error in Pattern Match"
                                   ) as Any)
                                 }
                               }
                             }
                           })
                         .app({ v : Any ->
                              { z : Any ->
                                { v1 : Any ->
                                  when {
                                   (v1 is PS.Data.Either.Module._Type_Either
                                            .Left) -> {
                                     val z1 = z;
                                     z1;
                                   }
                                   (v1 is PS.Data.Either.Module._Type_Either
                                            .Right) -> {
                                     val f = v;
                                     val z1 = z;
                                     val x = v1.value0;
                                     f.app(z1).app(x);
                                   }
                                   else -> (error("Error in Pattern Match"
                                   ) as Any)
                                 }
                               }
                             }
                           })
                         .app({ v : Any ->
       { z : Any ->
         { v1 : Any ->
           when {
            (v1 is PS.Data.Either.Module._Type_Either.Left) -> {
              val z1 = z;
              z1;
            }
            (v1 is PS.Data.Either.Module._Type_Either.Right) -> {
              val f = v;
              val z1 = z;
              val x = v1.value0;
              f.app(x).app(z1);
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      }
    });
  @JvmField
  val foldableWithIndexEither = PS.Data.FoldableWithIndex.Module.FoldableWithIndex
                                  .app({ _ : Any ->
                                       PS.Data.Either.Module.foldableEither
                                    })
                                  .app({ dictMonoid : Any ->
                                       { f : Any ->
                                         { v : Any ->
                                           when {
                                            (v is PS.Data.Either.Module._Type_Either
                                                    .Left) -> {
                                              val f1 = f;
                                              PS.Data.Monoid.Module.mempty
                                                .app(dictMonoid);
                                            }
                                            (v is PS.Data.Either.Module._Type_Either
                                                    .Right) -> {
                                              val f1 = f;
                                              val x = v.value0;
                                              f1.app(PS.Data.Unit.Module.unit)
                                                .app(x);
                                            }
                                            else -> (error(
                                              "Error in Pattern Match") as Any)
                                          }
                                        }
                                      }
                                    })
                                  .app({ v : Any ->
                                       { z : Any ->
                                         { v1 : Any ->
                                           when {
                                            (v1 is PS.Data.Either.Module._Type_Either
                                                     .Left) -> {
                                              val z1 = z;
                                              z1;
                                            }
                                            (v1 is PS.Data.Either.Module._Type_Either
                                                     .Right) -> {
                                              val f = v;
                                              val z1 = z;
                                              val x = v1.value0;
                                              f.app(PS.Data.Unit.Module.unit)
                                                .app(z1)
                                                .app(x);
                                            }
                                            else -> (error(
                                              "Error in Pattern Match") as Any)
                                          }
                                        }
                                      }
                                    })
                                  .app({ v : Any ->
       { z : Any ->
         { v1 : Any ->
           when {
            (v1 is PS.Data.Either.Module._Type_Either.Left) -> {
              val z1 = z;
              z1;
            }
            (v1 is PS.Data.Either.Module._Type_Either.Right) -> {
              val f = v;
              val z1 = z;
              val x = v1.value0;
              f.app(PS.Data.Unit.Module.unit).app(x).app(z1);
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      }
    });
  @JvmField
  val traversableEither = PS.Data.Traversable.Module.Traversable
                            .app({ _ : Any ->
                                 PS.Data.Either.Module.foldableEither
                              })
                            .app({ _ : Any ->
                                 PS.Data.Either.Module.functorEither
                              })
                            .app({ dictApplicative : Any ->
                                 { v : Any ->
                                   when {
                                    (v is PS.Data.Either.Module._Type_Either
                                            .Left) -> {
                                      val x = v.value0;
                                      PS.Control.Applicative.Module.pure
                                        .app(dictApplicative)
                                        .app(PS.Data.Either.Module.Left.app(x));
                                    }
                                    (v is PS.Data.Either.Module._Type_Either
                                            .Right) -> {
                                      val x = v.value0;
                                      PS.Data.Functor.Module.map
                                        .app(
                                          ((dictApplicative as Map<String, Any>)["Apply0"]!!
                                             .app(Unit
                                            ) as Map<String, Any>)["Functor0"]!!
                                            .app(Unit))
                                        .app(PS.Data.Either.Module.Right)
                                        .app(x);
                                    }
                                    else -> (error("Error in Pattern Match"
                                    ) as Any)
                                  }
                                }
                              })
                            .app({ dictApplicative : Any ->
       { v : Any ->
         { v1 : Any ->
           when {
            (v1 is PS.Data.Either.Module._Type_Either.Left) -> {
              val x = v1.value0;
              PS.Control.Applicative.Module.pure.app(dictApplicative)
                .app(PS.Data.Either.Module.Left.app(x));
            }
            (v1 is PS.Data.Either.Module._Type_Either.Right) -> {
              val f = v;
              val x = v1.value0;
              PS.Data.Functor.Module.map
                .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                        .app(Unit) as Map<String, Any>)["Functor0"]!!
                       .app(Unit))
                .app(PS.Data.Either.Module.Right)
                .app(f.app(x));
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      }
    });
  @JvmField
  val traversableWithIndexEither = PS.Data.TraversableWithIndex.Module.TraversableWithIndex
                                     .app({ _ : Any ->
                                          PS.Data.Either.Module.foldableWithIndexEither
                                       })
                                     .app({ _ : Any ->
                                          PS.Data.Either.Module.functorWithIndexEither
                                       })
                                     .app({ _ : Any ->
                                          PS.Data.Either.Module.traversableEither
                                       })
                                     .app({ dictApplicative : Any ->
       { v : Any ->
         { v1 : Any ->
           when {
            (v1 is PS.Data.Either.Module._Type_Either.Left) -> {
              val x = v1.value0;
              PS.Control.Applicative.Module.pure.app(dictApplicative)
                .app(PS.Data.Either.Module.Left.app(x));
            }
            (v1 is PS.Data.Either.Module._Type_Either.Right) -> {
              val f = v;
              val x = v1.value0;
              PS.Data.Functor.Module.map
                .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                        .app(Unit) as Map<String, Any>)["Functor0"]!!
                       .app(Unit))
                .app(PS.Data.Either.Module.Right)
                .app(f.app(PS.Data.Unit.Module.unit).app(x));
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      }
    });
  @JvmField
  val extendEither = PS.Control.Extend.Module.Extend
                       .app({ _ : Any ->
                            PS.Data.Either.Module.functorEither
                         })
                       .app({ v : Any ->
       { v1 : Any ->
         when {
          (v1 is PS.Data.Either.Module._Type_Either.Left) -> {
            val y = v1.value0;
            PS.Data.Either.Module.Left.app(y);
          }
          else -> {
            val f = v;
            val x = v1;
            PS.Data.Either.Module.Right.app(f.app(x));
          }
        }
      }
    });
  @JvmField
  val eqEither = { dictEq : Any ->
     { dictEq1 : Any ->
       PS.Data.Eq.Module.Eq
         .app({ x : Any ->
           { y : Any ->
             when {
              (x is PS.Data.Either.Module._Type_Either
                      .Left)&& (y is PS.Data.Either.Module._Type_Either
                                       .Left) -> {
                val l = x.value0;
                val r = y.value0;
                PS.Data.Eq.Module.eq.app(dictEq).app(l).app(r);
              }
              (x is PS.Data.Either.Module._Type_Either
                      .Right)&& (y is PS.Data.Either.Module._Type_Either
                                        .Right) -> {
                val l = x.value0;
                val r = y.value0;
                PS.Data.Eq.Module.eq.app(dictEq1).app(l).app(r);
              }
              else -> {
                false;
              }
            }
          }
        })
    }
  };
  @JvmField
  val ordEither = { dictOrd : Any ->
     { dictOrd1 : Any ->
       PS.Data.Ord.Module.Ord
         .app({ _ : Any ->
              PS.Data.Either.Module.eqEither
                .app((dictOrd as Map<String, Any>)["Eq0"]!!.app(Unit))
                .app((dictOrd1 as Map<String, Any>)["Eq0"]!!.app(Unit))
           })
         .app({ x : Any ->
           { y : Any ->
             when {
              (x is PS.Data.Either.Module._Type_Either
                      .Left)&& (y is PS.Data.Either.Module._Type_Either
                                       .Left) -> {
                val l = x.value0;
                val r = y.value0;
                PS.Data.Ord.Module.compare.app(dictOrd).app(l).app(r);
              }
              (x is PS.Data.Either.Module._Type_Either.Left) -> {
                PS.Data.Ordering.Module.LT;
              }
              (y is PS.Data.Either.Module._Type_Either.Left) -> {
                PS.Data.Ordering.Module.GT;
              }
              (x is PS.Data.Either.Module._Type_Either
                      .Right)&& (y is PS.Data.Either.Module._Type_Either
                                        .Right) -> {
                val l = x.value0;
                val r = y.value0;
                PS.Data.Ord.Module.compare.app(dictOrd1).app(l).app(r);
              }
              else -> (error("Error in Pattern Match") as Any)
            }
          }
        })
    }
  };
  @JvmField
  val eq1Either = { dictEq : Any ->
     PS.Data.Eq.Module.Eq1
       .app({ dictEq1 : Any ->
         PS.Data.Eq.Module.eq
           .app(PS.Data.Either.Module.eqEither.app(dictEq).app(dictEq1))
      })
  };
  @JvmField
  val ord1Either = { dictOrd : Any ->
     PS.Data.Ord.Module.Ord1
       .app({ _ : Any ->
            PS.Data.Either.Module.eq1Either
              .app((dictOrd as Map<String, Any>)["Eq0"]!!.app(Unit))
         })
       .app({ dictOrd1 : Any ->
         PS.Data.Ord.Module.compare
           .app(PS.Data.Either.Module.ordEither.app(dictOrd).app(dictOrd1))
      })
  };
  @JvmField
  val either = { v : Any ->
     { v1 : Any ->
       { v2 : Any ->
         when {
          (v2 is PS.Data.Either.Module._Type_Either.Left) -> {
            val f = v;
            val a = v2.value0;
            f.app(a);
          }
          (v2 is PS.Data.Either.Module._Type_Either.Right) -> {
            val g = v1;
            val b = v2.value0;
            g.app(b);
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    }
  };
  @JvmField
  val hush = PS.Data.Either.Module.either
               .app(PS.Data.Function.Module._const
                      .app(PS.Data.Maybe.Module.Nothing))
               .app(PS.Data.Maybe.Module.Just);
  @JvmField
  val isLeft = PS.Data.Either.Module.either
                 .app(PS.Data.Function.Module._const.app(true))
                 .app(PS.Data.Function.Module._const.app(false));
  @JvmField
  val isRight = PS.Data.Either.Module.either
                  .app(PS.Data.Function.Module._const.app(false))
                  .app(PS.Data.Function.Module._const.app(true));
  @JvmField
  val choose = { dictAlt : Any ->
     { a : Any ->
       { b : Any ->
         PS.Control.Alt.Module.alt.app(dictAlt)
           .app(PS.Data.Functor.Module.map
                  .app((dictAlt as Map<String, Any>)["Functor0"]!!.app(Unit))
                  .app(PS.Data.Either.Module.Left)
                  .app(a))
           .app(PS.Data.Functor.Module.map
                  .app((dictAlt as Map<String, Any>)["Functor0"]!!.app(Unit))
                  .app(PS.Data.Either.Module.Right)
                  .app(b))
      }
    }
  };
  @JvmField
  val boundedEither = { dictBounded : Any ->
     { dictBounded1 : Any ->
       PS.Data.Bounded.Module.Bounded
         .app({ _ : Any ->
              PS.Data.Either.Module.ordEither
                .app((dictBounded as Map<String, Any>)["Ord0"]!!.app(Unit))
                .app((dictBounded1 as Map<String, Any>)["Ord0"]!!.app(Unit))
           })
         .app(PS.Data.Either.Module.Left
                .app(PS.Data.Bounded.Module.bottom.app(dictBounded)))
         .app(PS.Data.Either.Module.Right
                .app(PS.Data.Bounded.Module.top.app(dictBounded1)))
    }
  };
  @JvmField
  val bifunctorEither = PS.Data.Bifunctor.Module.Bifunctor
                          .app({ v : Any ->
       { v1 : Any ->
         { v2 : Any ->
           when {
            (v2 is PS.Data.Either.Module._Type_Either.Left) -> {
              val f = v;
              val l = v2.value0;
              PS.Data.Either.Module.Left.app(f.app(l));
            }
            (v2 is PS.Data.Either.Module._Type_Either.Right) -> {
              val g = v1;
              val r = v2.value0;
              PS.Data.Either.Module.Right.app(g.app(r));
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      }
    });
  @JvmField
  val bifoldableEither = PS.Data.Bifoldable.Module.Bifoldable
                           .app({ dictMonoid : Any ->
                                { v : Any ->
                                  { v1 : Any ->
                                    { v2 : Any ->
                                      when {
                                       (v2 is PS.Data.Either.Module._Type_Either
                                                .Left) -> {
                                         val f = v;
                                         val a = v2.value0;
                                         f.app(a);
                                       }
                                       (v2 is PS.Data.Either.Module._Type_Either
                                                .Right) -> {
                                         val g = v1;
                                         val b = v2.value0;
                                         g.app(b);
                                       }
                                       else -> (error("Error in Pattern Match"
                                       ) as Any)
                                     }
                                   }
                                 }
                               }
                             })
                           .app({ v : Any ->
                                { v1 : Any ->
                                  { z : Any ->
                                    { v2 : Any ->
                                      when {
                                       (v2 is PS.Data.Either.Module._Type_Either
                                                .Left) -> {
                                         val f = v;
                                         val z1 = z;
                                         val a = v2.value0;
                                         f.app(z1).app(a);
                                       }
                                       (v2 is PS.Data.Either.Module._Type_Either
                                                .Right) -> {
                                         val g = v1;
                                         val z1 = z;
                                         val b = v2.value0;
                                         g.app(z1).app(b);
                                       }
                                       else -> (error("Error in Pattern Match"
                                       ) as Any)
                                     }
                                   }
                                 }
                               }
                             })
                           .app({ v : Any ->
       { v1 : Any ->
         { z : Any ->
           { v2 : Any ->
             when {
              (v2 is PS.Data.Either.Module._Type_Either.Left) -> {
                val f = v;
                val z1 = z;
                val a = v2.value0;
                f.app(a).app(z1);
              }
              (v2 is PS.Data.Either.Module._Type_Either.Right) -> {
                val g = v1;
                val z1 = z;
                val b = v2.value0;
                g.app(b).app(z1);
              }
              else -> (error("Error in Pattern Match") as Any)
            }
          }
        }
      }
    });
  @JvmField
  val bitraversableEither = PS.Data.Bitraversable.Module.Bitraversable
                              .app({ _ : Any ->
                                   PS.Data.Either.Module.bifoldableEither
                                })
                              .app({ _ : Any ->
                                   PS.Data.Either.Module.bifunctorEither
                                })
                              .app({ dictApplicative : Any ->
                                   { v : Any ->
                                     when {
                                      (v is PS.Data.Either.Module._Type_Either
                                              .Left) -> {
                                        val a = v.value0;
                                        PS.Data.Functor.Module.map
                                          .app(
                                            ((dictApplicative as Map<String, Any>)["Apply0"]!!
                                               .app(Unit
                                              ) as Map<String, Any>)["Functor0"]!!
                                              .app(Unit))
                                          .app(PS.Data.Either.Module.Left)
                                          .app(a);
                                      }
                                      (v is PS.Data.Either.Module._Type_Either
                                              .Right) -> {
                                        val b = v.value0;
                                        PS.Data.Functor.Module.map
                                          .app(
                                            ((dictApplicative as Map<String, Any>)["Apply0"]!!
                                               .app(Unit
                                              ) as Map<String, Any>)["Functor0"]!!
                                              .app(Unit))
                                          .app(PS.Data.Either.Module.Right)
                                          .app(b);
                                      }
                                      else -> (error("Error in Pattern Match"
                                      ) as Any)
                                    }
                                  }
                                })
                              .app({ dictApplicative : Any ->
       { v : Any ->
         { v1 : Any ->
           { v2 : Any ->
             when {
              (v2 is PS.Data.Either.Module._Type_Either.Left) -> {
                val f = v;
                val a = v2.value0;
                PS.Data.Functor.Module.map
                  .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                          .app(Unit) as Map<String, Any>)["Functor0"]!!
                         .app(Unit))
                  .app(PS.Data.Either.Module.Left)
                  .app(f.app(a));
              }
              (v2 is PS.Data.Either.Module._Type_Either.Right) -> {
                val g = v1;
                val b = v2.value0;
                PS.Data.Functor.Module.map
                  .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                          .app(Unit) as Map<String, Any>)["Functor0"]!!
                         .app(Unit))
                  .app(PS.Data.Either.Module.Right)
                  .app(g.app(b));
              }
              else -> (error("Error in Pattern Match") as Any)
            }
          }
        }
      }
    });
  @JvmField
  val applyEither = PS.Control.Apply.Module.Apply
                      .app({ _ : Any ->
                           PS.Data.Either.Module.functorEither
                        })
                      .app({ v : Any ->
       { v1 : Any ->
         when {
          (v is PS.Data.Either.Module._Type_Either.Left) -> {
            val e = v.value0;
            PS.Data.Either.Module.Left.app(e);
          }
          (v is PS.Data.Either.Module._Type_Either.Right) -> {
            val f = v.value0;
            val r = v1;
            PS.Data.Functor.Module.map.app(PS.Data.Either.Module.functorEither)
              .app(f)
              .app(r);
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val bindEither = PS.Control.Bind.Module.Bind
                     .app({ _ : Any ->
                          PS.Data.Either.Module.applyEither
                       })
                     .app(PS.Data.Either.Module.either
                            .app({ e : Any ->
                                 { v : Any ->
                                   PS.Data.Either.Module.Left.app(e)
                                }
                              })
                            .app({ a : Any ->
         { f : Any ->
           f.app(a)
        }
      }));
  @JvmField
  val semigroupEither = { dictSemigroup : Any ->
     PS.Data.Semigroup.Module.Semigroup
       .app({ x : Any ->
         { y : Any ->
           PS.Control.Apply.Module.apply.app(PS.Data.Either.Module.applyEither)
             .app(PS.Data.Functor.Module.map
                    .app(PS.Data.Either.Module.functorEither)
                    .app(PS.Data.Semigroup.Module.append.app(dictSemigroup))
                    .app(x))
             .app(y)
        }
      })
  };
  @JvmField
  val applicativeEither = PS.Control.Applicative.Module.Applicative
                            .app({ _ : Any ->
                                 PS.Data.Either.Module.applyEither
                              })
                            .app(PS.Data.Either.Module.Right);
  @JvmField
  val monadEither = PS.Control.Monad.Module.Monad
                      .app({ _ : Any ->
                           PS.Data.Either.Module.applicativeEither
                        })
                      .app({ _ : Any ->
       PS.Data.Either.Module.bindEither
    });
  @JvmField
  val altEither = PS.Control.Alt.Module.Alt
                    .app({ _ : Any ->
                         PS.Data.Either.Module.functorEither
                      })
                    .app({ v : Any ->
       { v1 : Any ->
         when {
          (v is PS.Data.Either.Module._Type_Either.Left) -> {
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
}