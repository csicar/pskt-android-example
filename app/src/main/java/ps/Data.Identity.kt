@file:Suppress("UNCHECKED_CAST")
package PS.Data.Identity
import Foreign.PsRuntime.app
object Module  {
  @JvmField val Identity = { x : Any -> x};
  @JvmField
  val showIdentity = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ v : Any ->
         when {
          else -> {
            val x = v;
            (("(Identity " as String) + (((PS.Data.Show.Module.show
                                             .app(dictShow)
                                             .app(x
            ) as String) + (")" as String)) as String));
          }
        }
      })
  };
  @JvmField val semiringIdentity = { dictSemiring : Any -> dictSemiring};
  @JvmField val semigroupIdenity = { dictSemigroup : Any -> dictSemigroup};
  @JvmField val ringIdentity = { dictRing : Any -> dictRing};
  @JvmField val ordIdentity = { dictOrd : Any -> dictOrd};
  @JvmField
  val newtypeIdentity = PS.Data.Newtype.Module.Newtype
                          .app({ n : Any ->
                               when {
                                else -> {
                                  val a = n;
                                  a;
                                }
                              }
                            })
                          .app(PS.Data.Identity.Module.Identity);
  @JvmField val monoidIdentity = { dictMonoid : Any -> dictMonoid};
  @JvmField val lazyIdentity = { dictLazy : Any -> dictLazy};
  @JvmField
  val heytingAlgebraIdentity = { dictHeytingAlgebra : Any ->
     dictHeytingAlgebra
  };
  @JvmField
  val functorIdentity = PS.Data.Functor.Module.Functor
                          .app({ f : Any ->
       { m : Any ->
         when {
          else -> {
            val v = m;
            PS.Data.Identity.Module.Identity.app(f.app(v));
          }
        }
      }
    });
  @JvmField
  val functorWithIndexIdentity = PS.Data.FunctorWithIndex.Module.FunctorWithIndex
                                   .app({ _ : Any ->
                                        PS.Data.Identity.Module.functorIdentity
                                     })
                                   .app({ f : Any ->
       { v : Any ->
         when {
          else -> {
            val f1 = f;
            val a = v;
            PS.Data.Identity.Module.Identity
              .app(f1.app(PS.Data.Unit.Module.unit).app(a));
          }
        }
      }
    });
  @JvmField
  val invariantIdentity = PS.Data.Functor.Invariant.Module.Invariant
                            .app(PS.Data.Functor.Invariant.Module.imapF
                                   .app(PS.Data.Identity.Module.functorIdentity)
  );
  @JvmField
  val foldableIdentity = PS.Data.Foldable.Module.Foldable
                           .app({ dictMonoid : Any ->
                                { f : Any ->
                                  { v : Any ->
                                    when {
                                     else -> {
                                       val f1 = f;
                                       val x = v;
                                       f1.app(x);
                                     }
                                   }
                                 }
                               }
                             })
                           .app({ f : Any ->
                                { z : Any ->
                                  { v : Any ->
                                    when {
                                     else -> {
                                       val f1 = f;
                                       val z1 = z;
                                       val x = v;
                                       f1.app(z1).app(x);
                                     }
                                   }
                                 }
                               }
                             })
                           .app({ f : Any ->
       { z : Any ->
         { v : Any ->
           when {
            else -> {
              val f1 = f;
              val z1 = z;
              val x = v;
              f1.app(x).app(z1);
            }
          }
        }
      }
    });
  @JvmField
  val foldableWithIndexIdentity = PS.Data.FoldableWithIndex.Module.FoldableWithIndex
                                    .app({ _ : Any ->
                                         PS.Data.Identity.Module.foldableIdentity
                                      })
                                    .app({ dictMonoid : Any ->
                                         { f : Any ->
                                           { v : Any ->
                                             when {
                                              else -> {
                                                val f1 = f;
                                                val x = v;
                                                f1.app(PS.Data.Unit.Module.unit)
                                                  .app(x);
                                              }
                                            }
                                          }
                                        }
                                      })
                                    .app({ f : Any ->
                                         { z : Any ->
                                           { v : Any ->
                                             when {
                                              else -> {
                                                val f1 = f;
                                                val z1 = z;
                                                val x = v;
                                                f1.app(PS.Data.Unit.Module.unit)
                                                  .app(z1)
                                                  .app(x);
                                              }
                                            }
                                          }
                                        }
                                      })
                                    .app({ f : Any ->
       { z : Any ->
         { v : Any ->
           when {
            else -> {
              val f1 = f;
              val z1 = z;
              val x = v;
              f1.app(PS.Data.Unit.Module.unit).app(x).app(z1);
            }
          }
        }
      }
    });
  @JvmField
  val traversableIdentity = PS.Data.Traversable.Module.Traversable
                              .app({ _ : Any ->
                                   PS.Data.Identity.Module.foldableIdentity
                                })
                              .app({ _ : Any ->
                                   PS.Data.Identity.Module.functorIdentity
                                })
                              .app({ dictApplicative : Any ->
                                   { v : Any ->
                                     when {
                                      else -> {
                                        val x = v;
                                        PS.Data.Functor.Module.map
                                          .app(
                                            ((dictApplicative as Map<String, Any>)["Apply0"]!!
                                               .app(Unit
                                              ) as Map<String, Any>)["Functor0"]!!
                                              .app(Unit))
                                          .app(PS.Data.Identity.Module.Identity)
                                          .app(x);
                                      }
                                    }
                                  }
                                })
                              .app({ dictApplicative : Any ->
       { f : Any ->
         { v : Any ->
           when {
            else -> {
              val f1 = f;
              val x = v;
              PS.Data.Functor.Module.map
                .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                        .app(Unit) as Map<String, Any>)["Functor0"]!!
                       .app(Unit))
                .app(PS.Data.Identity.Module.Identity)
                .app(f1.app(x));
            }
          }
        }
      }
    });
  @JvmField
  val traversableWithIndexIdentity = PS.Data.TraversableWithIndex.Module.TraversableWithIndex
                                       .app({ _ : Any ->
                                            PS.Data.Identity.Module.foldableWithIndexIdentity
                                         })
                                       .app({ _ : Any ->
                                            PS.Data.Identity.Module.functorWithIndexIdentity
                                         })
                                       .app({ _ : Any ->
                                            PS.Data.Identity.Module.traversableIdentity
                                         })
                                       .app({ dictApplicative : Any ->
       { f : Any ->
         { v : Any ->
           when {
            else -> {
              val f1 = f;
              val x = v;
              PS.Data.Functor.Module.map
                .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                        .app(Unit) as Map<String, Any>)["Functor0"]!!
                       .app(Unit))
                .app(PS.Data.Identity.Module.Identity)
                .app(f1.app(PS.Data.Unit.Module.unit).app(x));
            }
          }
        }
      }
    });
  @JvmField
  val foldable1Identity = PS.Data.Semigroup.Foldable.Module.Foldable1
                            .app({ _ : Any ->
                                 PS.Data.Identity.Module.foldableIdentity
                              })
                            .app({ dictSemigroup : Any ->
                                 { v : Any ->
                                   when {
                                    else -> {
                                      val x = v;
                                      x;
                                    }
                                  }
                                }
                              })
                            .app({ dictSemigroup : Any ->
       { f : Any ->
         { v : Any ->
           when {
            else -> {
              val f1 = f;
              val x = v;
              f1.app(x);
            }
          }
        }
      }
    });
  @JvmField
  val traversable1Identity = PS.Data.Semigroup.Traversable.Module.Traversable1
                               .app({ _ : Any ->
                                    PS.Data.Identity.Module.foldable1Identity
                                 })
                               .app({ _ : Any ->
                                    PS.Data.Identity.Module.traversableIdentity
                                 })
                               .app({ dictApply : Any ->
                                    { v : Any ->
                                      when {
                                       else -> {
                                         val x = v;
                                         PS.Data.Functor.Module.map
                                           .app(
                                             (dictApply as Map<String, Any>)["Functor0"]!!
                                               .app(Unit))
                                           .app(PS.Data.Identity.Module.Identity
                                           )
                                           .app(x);
                                       }
                                     }
                                   }
                                 })
                               .app({ dictApply : Any ->
       { f : Any ->
         { v : Any ->
           when {
            else -> {
              val f1 = f;
              val x = v;
              PS.Data.Functor.Module.map
                .app((dictApply as Map<String, Any>)["Functor0"]!!.app(Unit))
                .app(PS.Data.Identity.Module.Identity)
                .app(f1.app(x));
            }
          }
        }
      }
    });
  @JvmField
  val extendIdentity = PS.Control.Extend.Module.Extend
                         .app({ _ : Any ->
                              PS.Data.Identity.Module.functorIdentity
                           })
                         .app({ f : Any ->
       { m : Any ->
         PS.Data.Identity.Module.Identity.app(f.app(m))
      }
    });
  @JvmField
  val euclideanRingIdentity = { dictEuclideanRing : Any ->
     dictEuclideanRing
  };
  @JvmField val eqIdentity = { dictEq : Any -> dictEq};
  @JvmField
  val eq1Identity = PS.Data.Eq.Module.Eq1
                      .app({ dictEq : Any ->
       PS.Data.Eq.Module.eq.app(PS.Data.Identity.Module.eqIdentity.app(dictEq))
    });
  @JvmField
  val ord1Identity = PS.Data.Ord.Module.Ord1
                       .app({ _ : Any ->
                            PS.Data.Identity.Module.eq1Identity
                         })
                       .app({ dictOrd : Any ->
       PS.Data.Ord.Module.compare
         .app(PS.Data.Identity.Module.ordIdentity.app(dictOrd))
    });
  @JvmField
  val comonadIdentity = PS.Control.Comonad.Module.Comonad
                          .app({ _ : Any ->
                               PS.Data.Identity.Module.extendIdentity
                            })
                          .app({ v : Any ->
       when {
        else -> {
          val x = v;
          x;
        }
      }
    });
  @JvmField
  val commutativeRingIdentity = { dictCommutativeRing : Any ->
     dictCommutativeRing
  };
  @JvmField val boundedIdentity = { dictBounded : Any -> dictBounded};
  @JvmField
  val booleanAlgebraIdentity = { dictBooleanAlgebra : Any ->
     dictBooleanAlgebra
  };
  @JvmField
  val applyIdentity = PS.Control.Apply.Module.Apply
                        .app({ _ : Any ->
                             PS.Data.Identity.Module.functorIdentity
                          })
                        .app({ v : Any ->
       { v1 : Any ->
         when {
          else -> {
            val f = v;
            val x = v1;
            PS.Data.Identity.Module.Identity.app(f.app(x));
          }
        }
      }
    });
  @JvmField
  val bindIdentity = PS.Control.Bind.Module.Bind
                       .app({ _ : Any ->
                            PS.Data.Identity.Module.applyIdentity
                         })
                       .app({ v : Any ->
       { f : Any ->
         when {
          else -> {
            val m = v;
            val f1 = f;
            f1.app(m);
          }
        }
      }
    });
  @JvmField
  val applicativeIdentity = PS.Control.Applicative.Module.Applicative
                              .app({ _ : Any ->
                                   PS.Data.Identity.Module.applyIdentity
                                })
                              .app(PS.Data.Identity.Module.Identity);
  @JvmField
  val monadIdentity = PS.Control.Monad.Module.Monad
                        .app({ _ : Any ->
                             PS.Data.Identity.Module.applicativeIdentity
                          })
                        .app({ _ : Any ->
       PS.Data.Identity.Module.bindIdentity
    });
  @JvmField
  val altIdentity = PS.Control.Alt.Module.Alt
                      .app({ _ : Any ->
                           PS.Data.Identity.Module.functorIdentity
                        })
                      .app({ x : Any ->
       { v : Any ->
         x
      }
    });
}