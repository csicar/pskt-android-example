@file:Suppress("UNCHECKED_CAST")
package PS.Data.Const
import Foreign.PsRuntime.app
object Module  {
  @JvmField val Const = { x : Any -> x};
  @JvmField
  val showConst = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ v : Any ->
         when {
          else -> {
            val x = v;
            (("(Const " as String) + (((PS.Data.Show.Module.show.app(dictShow)
                                          .app(x
            ) as String) + (")" as String)) as String));
          }
        }
      })
  };
  @JvmField val semiringConst = { dictSemiring : Any -> dictSemiring};
  @JvmField
  val semigroupoidConst = PS.Control.Semigroupoid.Module.Semigroupoid
                            .app({ v : Any ->
       { v1 : Any ->
         when {
          else -> {
            val x = v1;
            PS.Data.Const.Module.Const.app(x);
          }
        }
      }
    });
  @JvmField val semigroupConst = { dictSemigroup : Any -> dictSemigroup};
  @JvmField val ringConst = { dictRing : Any -> dictRing};
  @JvmField val ordConst = { dictOrd : Any -> dictOrd};
  @JvmField
  val newtypeConst = PS.Data.Newtype.Module.Newtype
                       .app({ n : Any ->
                            when {
                             else -> {
                               val a = n;
                               a;
                             }
                           }
                         })
                       .app(PS.Data.Const.Module.Const);
  @JvmField val monoidConst = { dictMonoid : Any -> dictMonoid};
  @JvmField
  val heytingAlgebraConst = { dictHeytingAlgebra : Any ->
     dictHeytingAlgebra
  };
  @JvmField
  val functorConst = PS.Data.Functor.Module.Functor
                       .app({ f : Any ->
       { m : Any ->
         when {
          else -> {
            val v = m;
            PS.Data.Const.Module.Const.app(v);
          }
        }
      }
    });
  @JvmField
  val functorWithIndexConst = PS.Data.FunctorWithIndex.Module.FunctorWithIndex
                                .app({ _ : Any ->
                                     PS.Data.Const.Module.functorConst
                                  })
                                .app({ v : Any ->
       { v1 : Any ->
         when {
          else -> {
            val x = v1;
            PS.Data.Const.Module.Const.app(x);
          }
        }
      }
    });
  @JvmField
  val invariantConst = PS.Data.Functor.Invariant.Module.Invariant
                         .app(PS.Data.Functor.Invariant.Module.imapF
                                .app(PS.Data.Const.Module.functorConst));
  @JvmField
  val foldableConst = PS.Data.Foldable.Module.Foldable
                        .app({ dictMonoid : Any ->
                             { v : Any ->
                               { v1 : Any ->
                                 PS.Data.Monoid.Module.mempty.app(dictMonoid)
                              }
                            }
                          })
                        .app({ v : Any ->
                             { z : Any ->
                               { v1 : Any ->
                                 z
                              }
                            }
                          })
                        .app({ v : Any ->
       { z : Any ->
         { v1 : Any ->
           z
        }
      }
    });
  @JvmField
  val foldableWithIndexConst = PS.Data.FoldableWithIndex.Module.FoldableWithIndex
                                 .app({ _ : Any ->
                                      PS.Data.Const.Module.foldableConst
                                   })
                                 .app({ dictMonoid : Any ->
                                      { v : Any ->
                                        { v1 : Any ->
                                          PS.Data.Monoid.Module.mempty
                                            .app(dictMonoid)
                                       }
                                     }
                                   })
                                 .app({ v : Any ->
                                      { z : Any ->
                                        { v1 : Any ->
                                          z
                                       }
                                     }
                                   })
                                 .app({ v : Any ->
       { z : Any ->
         { v1 : Any ->
           z
        }
      }
    });
  @JvmField
  val traversableConst = PS.Data.Traversable.Module.Traversable
                           .app({ _ : Any ->
                                PS.Data.Const.Module.foldableConst
                             })
                           .app({ _ : Any ->
                                PS.Data.Const.Module.functorConst
                             })
                           .app({ dictApplicative : Any ->
                                { v : Any ->
                                  when {
                                   else -> {
                                     val x = v;
                                     PS.Control.Applicative.Module.pure
                                       .app(dictApplicative)
                                       .app(PS.Data.Const.Module.Const.app(x));
                                   }
                                 }
                               }
                             })
                           .app({ dictApplicative : Any ->
       { v : Any ->
         { v1 : Any ->
           when {
            else -> {
              val x = v1;
              PS.Control.Applicative.Module.pure.app(dictApplicative)
                .app(PS.Data.Const.Module.Const.app(x));
            }
          }
        }
      }
    });
  @JvmField
  val traversableWithIndexConst = PS.Data.TraversableWithIndex.Module.TraversableWithIndex
                                    .app({ _ : Any ->
                                         PS.Data.Const.Module.foldableWithIndexConst
                                      })
                                    .app({ _ : Any ->
                                         PS.Data.Const.Module.functorWithIndexConst
                                      })
                                    .app({ _ : Any ->
                                         PS.Data.Const.Module.traversableConst
                                      })
                                    .app({ dictApplicative : Any ->
       { v : Any ->
         { v1 : Any ->
           when {
            else -> {
              val x = v1;
              PS.Control.Applicative.Module.pure.app(dictApplicative)
                .app(PS.Data.Const.Module.Const.app(x));
            }
          }
        }
      }
    });
  @JvmField
  val euclideanRingConst = { dictEuclideanRing : Any ->
     dictEuclideanRing
  };
  @JvmField val eqConst = { dictEq : Any -> dictEq};
  @JvmField
  val eq1Const = { dictEq : Any ->
     PS.Data.Eq.Module.Eq1
       .app({ dictEq1 : Any ->
         PS.Data.Eq.Module.eq.app(PS.Data.Const.Module.eqConst.app(dictEq))
      })
  };
  @JvmField
  val ord1Const = { dictOrd : Any ->
     PS.Data.Ord.Module.Ord1
       .app({ _ : Any ->
            PS.Data.Const.Module.eq1Const
              .app((dictOrd as Map<String, Any>)["Eq0"]!!.app(Unit))
         })
       .app({ dictOrd1 : Any ->
         PS.Data.Ord.Module.compare
           .app(PS.Data.Const.Module.ordConst.app(dictOrd))
      })
  };
  @JvmField
  val contravariantConst = PS.Data.Functor.Contravariant.Module.Contravariant
                             .app({ v : Any ->
       { v1 : Any ->
         when {
          else -> {
            val x = v1;
            PS.Data.Const.Module.Const.app(x);
          }
        }
      }
    });
  @JvmField
  val commutativeRingConst = { dictCommutativeRing : Any ->
     dictCommutativeRing
  };
  @JvmField val boundedConst = { dictBounded : Any -> dictBounded};
  @JvmField
  val booleanAlgebraConst = { dictBooleanAlgebra : Any ->
     dictBooleanAlgebra
  };
  @JvmField
  val bifunctorConst = PS.Data.Bifunctor.Module.Bifunctor
                         .app({ f : Any ->
       { v : Any ->
         { v1 : Any ->
           when {
            else -> {
              val f1 = f;
              val a = v1;
              PS.Data.Const.Module.Const.app(f1.app(a));
            }
          }
        }
      }
    });
  @JvmField
  val bifoldableConst = PS.Data.Bifoldable.Module.Bifoldable
                          .app({ dictMonoid : Any ->
                               { f : Any ->
                                 { v : Any ->
                                   { v1 : Any ->
                                     when {
                                      else -> {
                                        val f1 = f;
                                        val a = v1;
                                        f1.app(a);
                                      }
                                    }
                                  }
                                }
                              }
                            })
                          .app({ f : Any ->
                               { v : Any ->
                                 { z : Any ->
                                   { v1 : Any ->
                                     when {
                                      else -> {
                                        val f1 = f;
                                        val z1 = z;
                                        val a = v1;
                                        f1.app(z1).app(a);
                                      }
                                    }
                                  }
                                }
                              }
                            })
                          .app({ f : Any ->
       { v : Any ->
         { z : Any ->
           { v1 : Any ->
             when {
              else -> {
                val f1 = f;
                val z1 = z;
                val a = v1;
                f1.app(a).app(z1);
              }
            }
          }
        }
      }
    });
  @JvmField
  val bitraversableConst = PS.Data.Bitraversable.Module.Bitraversable
                             .app({ _ : Any ->
                                  PS.Data.Const.Module.bifoldableConst
                               })
                             .app({ _ : Any ->
                                  PS.Data.Const.Module.bifunctorConst
                               })
                             .app({ dictApplicative : Any ->
                                  { v : Any ->
                                    when {
                                     else -> {
                                       val a = v;
                                       PS.Data.Functor.Module.map
                                         .app(
                                           ((dictApplicative as Map<String, Any>)["Apply0"]!!
                                              .app(Unit
                                             ) as Map<String, Any>)["Functor0"]!!
                                             .app(Unit))
                                         .app(PS.Data.Const.Module.Const)
                                         .app(a);
                                     }
                                   }
                                 }
                               })
                             .app({ dictApplicative : Any ->
       { f : Any ->
         { v : Any ->
           { v1 : Any ->
             when {
              else -> {
                val f1 = f;
                val a = v1;
                PS.Data.Functor.Module.map
                  .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                          .app(Unit) as Map<String, Any>)["Functor0"]!!
                         .app(Unit))
                  .app(PS.Data.Const.Module.Const)
                  .app(f1.app(a));
              }
            }
          }
        }
      }
    });
  @JvmField
  val applyConst = { dictSemigroup : Any ->
     PS.Control.Apply.Module.Apply
       .app({ _ : Any ->
            PS.Data.Const.Module.functorConst
         })
       .app({ v : Any ->
         { v1 : Any ->
           when {
            else -> {
              val x = v;
              val y = v1;
              PS.Data.Const.Module.Const
                .app(PS.Data.Semigroup.Module.append.app(dictSemigroup).app(x)
                       .app(y));
            }
          }
        }
      })
  };
  @JvmField
  val applicativeConst = { dictMonoid : Any ->
     PS.Control.Applicative.Module.Applicative
       .app({ _ : Any ->
            PS.Data.Const.Module.applyConst
              .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!.app(Unit))
         })
       .app({ v : Any ->
         PS.Data.Const.Module.Const
           .app(PS.Data.Monoid.Module.mempty.app(dictMonoid))
      })
  };
}