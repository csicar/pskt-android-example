@file:Suppress("UNCHECKED_CAST")
package PS.Data.Lazy
import Foreign.PsRuntime.app
object Module  {
  val defer = Foreign.Data.Lazy.defer;
  val force = Foreign.Data.Lazy.force;
  @JvmField
  val showLazy = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ x : Any ->
         (("(defer \\_ -> " as String) + (((PS.Data.Show.Module.show
                                              .app(dictShow)
                                              .app(PS.Data.Lazy.Module.force
                                                     .app(x)
        ) as String) + (")" as String)) as String))
      })
  };
  @JvmField
  val semiringLazy = { dictSemiring : Any ->
     PS.Data.Semiring.Module.Semiring
       .app({ a : Any ->
            { b : Any ->
              PS.Data.Lazy.Module.defer
                .app({ v : Any ->
                  PS.Data.Semiring.Module.add.app(dictSemiring)
                    .app(PS.Data.Lazy.Module.force.app(a))
                    .app(PS.Data.Lazy.Module.force.app(b))
               })
           }
         })
       .app({ a : Any ->
            { b : Any ->
              PS.Data.Lazy.Module.defer
                .app({ v : Any ->
                  PS.Data.Semiring.Module.mul.app(dictSemiring)
                    .app(PS.Data.Lazy.Module.force.app(a))
                    .app(PS.Data.Lazy.Module.force.app(b))
               })
           }
         })
       .app(PS.Data.Lazy.Module.defer
              .app({ v : Any ->
              PS.Data.Semiring.Module.one.app(dictSemiring)
           }))
       .app(PS.Data.Lazy.Module.defer
              .app({ v : Any ->
           PS.Data.Semiring.Module.zero.app(dictSemiring)
        }))
  };
  @JvmField
  val semigroupLazy = { dictSemigroup : Any ->
     PS.Data.Semigroup.Module.Semigroup
       .app({ a : Any ->
         { b : Any ->
           PS.Data.Lazy.Module.defer
             .app({ v : Any ->
               PS.Data.Semigroup.Module.append.app(dictSemigroup)
                 .app(PS.Data.Lazy.Module.force.app(a))
                 .app(PS.Data.Lazy.Module.force.app(b))
            })
        }
      })
  };
  @JvmField
  val ringLazy = { dictRing : Any ->
     PS.Data.Ring.Module.Ring
       .app({ _ : Any ->
            PS.Data.Lazy.Module.semiringLazy
              .app((dictRing as Map<String, Any>)["Semiring0"]!!.app(Unit))
         })
       .app({ a : Any ->
         { b : Any ->
           PS.Data.Lazy.Module.defer
             .app({ v : Any ->
               PS.Data.Ring.Module.sub.app(dictRing)
                 .app(PS.Data.Lazy.Module.force.app(a))
                 .app(PS.Data.Lazy.Module.force.app(b))
            })
        }
      })
  };
  @JvmField
  val monoidLazy = { dictMonoid : Any ->
     PS.Data.Monoid.Module.Monoid
       .app({ _ : Any ->
            PS.Data.Lazy.Module.semigroupLazy
              .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!.app(Unit))
         })
       .app(PS.Data.Lazy.Module.defer
              .app({ v : Any ->
           PS.Data.Monoid.Module.mempty.app(dictMonoid)
        }))
  };
  @JvmField
  val lazyLazy = PS.Control.Lazy.Module.Lazy
                   .app({ f : Any ->
       PS.Data.Lazy.Module.defer
         .app({ v : Any ->
           PS.Data.Lazy.Module.force.app(f.app(PS.Data.Unit.Module.unit))
        })
    });
  @JvmField
  val functorLazy = PS.Data.Functor.Module.Functor
                      .app({ f : Any ->
       { l : Any ->
         PS.Data.Lazy.Module.defer
           .app({ v : Any ->
             f.app(PS.Data.Lazy.Module.force.app(l))
          })
      }
    });
  @JvmField
  val functorWithIndexLazy = PS.Data.FunctorWithIndex.Module.FunctorWithIndex
                               .app({ _ : Any ->
                                    PS.Data.Lazy.Module.functorLazy
                                 })
                               .app({ f : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Functor.Module.map.app(PS.Data.Lazy.Module.functorLazy))
         .app(f.app(PS.Data.Unit.Module.unit))
    });
  @JvmField
  val invariantLazy = PS.Data.Functor.Invariant.Module.Invariant
                        .app(PS.Data.Functor.Invariant.Module.imapF
                               .app(PS.Data.Lazy.Module.functorLazy));
  @JvmField
  val foldableLazy = PS.Data.Foldable.Module.Foldable
                       .app({ dictMonoid : Any ->
                            { f : Any ->
                              { l : Any ->
                                f.app(PS.Data.Lazy.Module.force.app(l))
                             }
                           }
                         })
                       .app({ f : Any ->
                            { z : Any ->
                              { l : Any ->
                                f.app(z).app(PS.Data.Lazy.Module.force.app(l))
                             }
                           }
                         })
                       .app({ f : Any ->
       { z : Any ->
         { l : Any ->
           f.app(PS.Data.Lazy.Module.force.app(l)).app(z)
        }
      }
    });
  @JvmField
  val foldableWithIndexLazy = PS.Data.FoldableWithIndex.Module.FoldableWithIndex
                                .app({ _ : Any ->
                                     PS.Data.Lazy.Module.foldableLazy
                                  })
                                .app({ dictMonoid : Any ->
                                     { f : Any ->
                                       PS.Data.Function.Module.apply
                                         .app(PS.Data.Foldable.Module.foldMap
                                                .app(
                                                  PS.Data.Lazy.Module.foldableLazy
                                                )
                                                .app(dictMonoid))
                                         .app(f.app(PS.Data.Unit.Module.unit))
                                    }
                                  })
                                .app({ f : Any ->
                                     PS.Data.Function.Module.apply
                                       .app(PS.Data.Foldable.Module.foldl
                                              .app(
                                           PS.Data.Lazy.Module.foldableLazy))
                                       .app(f.app(PS.Data.Unit.Module.unit))
                                  })
                                .app({ f : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Foldable.Module.foldr
                .app(PS.Data.Lazy.Module.foldableLazy))
         .app(f.app(PS.Data.Unit.Module.unit))
    });
  @JvmField
  val traversableLazy = PS.Data.Traversable.Module.Traversable
                          .app({ _ : Any ->
                               PS.Data.Lazy.Module.foldableLazy
                            })
                          .app({ _ : Any ->
                               PS.Data.Lazy.Module.functorLazy
                            })
                          .app({ dictApplicative : Any ->
                               { l : Any ->
                                 PS.Data.Functor.Module.map
                                   .app(
                                     ((dictApplicative as Map<String, Any>)["Apply0"]!!
                                        .app(Unit
                                       ) as Map<String, Any>)["Functor0"]!!
                                       .app(Unit))
                                   .app(PS.Control.Semigroupoid.Module.compose
                                          .app(
                                            PS.Control.Semigroupoid.Module.semigroupoidFn
                                          )
                                          .app(PS.Data.Lazy.Module.defer)
                                          .app(PS.Data.Function.Module._const))
                                   .app(PS.Data.Lazy.Module.force.app(l))
                              }
                            })
                          .app({ dictApplicative : Any ->
       { f : Any ->
         { l : Any ->
           PS.Data.Functor.Module.map
             .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                     .app(Unit) as Map<String, Any>)["Functor0"]!!
                    .app(Unit))
             .app(PS.Control.Semigroupoid.Module.compose
                    .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                    .app(PS.Data.Lazy.Module.defer)
                    .app(PS.Data.Function.Module._const))
             .app(f.app(PS.Data.Lazy.Module.force.app(l)))
        }
      }
    });
  @JvmField
  val traversableWithIndexLazy = PS.Data.TraversableWithIndex.Module.TraversableWithIndex
                                   .app({ _ : Any ->
                                        PS.Data.Lazy.Module.foldableWithIndexLazy
                                     })
                                   .app({ _ : Any ->
                                        PS.Data.Lazy.Module.functorWithIndexLazy
                                     })
                                   .app({ _ : Any ->
                                        PS.Data.Lazy.Module.traversableLazy
                                     })
                                   .app({ dictApplicative : Any ->
       { f : Any ->
         PS.Data.Function.Module.apply
           .app(PS.Data.Traversable.Module.traverse
                  .app(PS.Data.Lazy.Module.traversableLazy)
                  .app(dictApplicative))
           .app(f.app(PS.Data.Unit.Module.unit))
      }
    });
  @JvmField val foldable1Lazy = (::__rec_foldable1Lazy)();
  fun __rec_foldable1Lazy(): Any = PS.Data.Semigroup.Foldable.Module.Foldable1
                                     .app({ _ : Any ->
                                          PS.Data.Lazy.Module.foldableLazy
                                       })
                                     .app({ dictSemigroup : Any ->
                                          PS.Data.Semigroup.Foldable.Module.fold1Default
                                            .app(
                                              PS.Data.Lazy.Module.foldable1Lazy)
                                            .app(dictSemigroup)
                                       })
                                     .app({ dictSemigroup : Any ->
       { f : Any ->
         { l : Any ->
           f.app(PS.Data.Lazy.Module.force.app(l))
        }
      }
    });
  @JvmField
  val traversable1Lazy = PS.Data.Semigroup.Traversable.Module.Traversable1
                           .app({ _ : Any ->
                                PS.Data.Lazy.Module.foldable1Lazy
                             })
                           .app({ _ : Any ->
                                PS.Data.Lazy.Module.traversableLazy
                             })
                           .app({ dictApply : Any ->
                                { l : Any ->
                                  PS.Data.Functor.Module.map
                                    .app(
                                      (dictApply as Map<String, Any>)["Functor0"]!!
                                        .app(Unit))
                                    .app(PS.Control.Semigroupoid.Module.compose
                                           .app(
                                             PS.Control.Semigroupoid.Module.semigroupoidFn
                                           )
                                           .app(PS.Data.Lazy.Module.defer)
                                           .app(PS.Data.Function.Module._const))
                                    .app(PS.Data.Lazy.Module.force.app(l))
                               }
                             })
                           .app({ dictApply : Any ->
       { f : Any ->
         { l : Any ->
           PS.Data.Functor.Module.map
             .app((dictApply as Map<String, Any>)["Functor0"]!!.app(Unit))
             .app(PS.Control.Semigroupoid.Module.compose
                    .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                    .app(PS.Data.Lazy.Module.defer)
                    .app(PS.Data.Function.Module._const))
             .app(f.app(PS.Data.Lazy.Module.force.app(l)))
        }
      }
    });
  @JvmField
  val extendLazy = PS.Control.Extend.Module.Extend
                     .app({ _ : Any ->
                          PS.Data.Lazy.Module.functorLazy
                       })
                     .app({ f : Any ->
       { x : Any ->
         PS.Data.Lazy.Module.defer.app({ v : Any -> f.app(x)})
      }
    });
  @JvmField
  val eqLazy = { dictEq : Any ->
     PS.Data.Eq.Module.Eq
       .app({ x : Any ->
         { y : Any ->
           PS.Data.Eq.Module.eq.app(dictEq)
             .app(PS.Data.Lazy.Module.force.app(x))
             .app(PS.Data.Lazy.Module.force.app(y))
        }
      })
  };
  @JvmField
  val ordLazy = { dictOrd : Any ->
     PS.Data.Ord.Module.Ord
       .app({ _ : Any ->
            PS.Data.Lazy.Module.eqLazy
              .app((dictOrd as Map<String, Any>)["Eq0"]!!.app(Unit))
         })
       .app({ x : Any ->
         { y : Any ->
           PS.Data.Ord.Module.compare.app(dictOrd)
             .app(PS.Data.Lazy.Module.force.app(x))
             .app(PS.Data.Lazy.Module.force.app(y))
        }
      })
  };
  @JvmField
  val eq1Lazy = PS.Data.Eq.Module.Eq1
                  .app({ dictEq : Any ->
       PS.Data.Eq.Module.eq.app(PS.Data.Lazy.Module.eqLazy.app(dictEq))
    });
  @JvmField
  val ord1Lazy = PS.Data.Ord.Module.Ord1
                   .app({ _ : Any ->
                        PS.Data.Lazy.Module.eq1Lazy
                     })
                   .app({ dictOrd : Any ->
       PS.Data.Ord.Module.compare.app(PS.Data.Lazy.Module.ordLazy.app(dictOrd))
    });
  @JvmField
  val comonadLazy = PS.Control.Comonad.Module.Comonad
                      .app({ _ : Any ->
                           PS.Data.Lazy.Module.extendLazy
                        })
                      .app(PS.Data.Lazy.Module.force);
  @JvmField
  val commutativeRingLazy = { dictCommutativeRing : Any ->
     PS.Data.CommutativeRing.Module.CommutativeRing
       .app({ _ : Any ->
         PS.Data.Lazy.Module.ringLazy
           .app((dictCommutativeRing as Map<String, Any>)["Ring0"]!!.app(Unit))
      })
  };
  @JvmField
  val euclideanRingLazy = { dictEuclideanRing : Any ->
     PS.Data.EuclideanRing.Module.EuclideanRing
       .app({ _ : Any ->
            PS.Data.Lazy.Module.commutativeRingLazy
              .app((dictEuclideanRing as Map<String, Any>)["CommutativeRing0"]!!
                     .app(Unit))
         })
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Data.EuclideanRing.Module.degree.app(dictEuclideanRing))
              .app(PS.Data.Lazy.Module.force))
       .app({ a : Any ->
            { b : Any ->
              PS.Data.Lazy.Module.defer
                .app({ v : Any ->
                  PS.Data.EuclideanRing.Module.div.app(dictEuclideanRing)
                    .app(PS.Data.Lazy.Module.force.app(a))
                    .app(PS.Data.Lazy.Module.force.app(b))
               })
           }
         })
       .app({ a : Any ->
         { b : Any ->
           PS.Data.Lazy.Module.defer
             .app({ v : Any ->
               PS.Data.EuclideanRing.Module.mod.app(dictEuclideanRing)
                 .app(PS.Data.Lazy.Module.force.app(a))
                 .app(PS.Data.Lazy.Module.force.app(b))
            })
        }
      })
  };
  @JvmField
  val boundedLazy = { dictBounded : Any ->
     PS.Data.Bounded.Module.Bounded
       .app({ _ : Any ->
            PS.Data.Lazy.Module.ordLazy
              .app((dictBounded as Map<String, Any>)["Ord0"]!!.app(Unit))
         })
       .app(PS.Data.Lazy.Module.defer
              .app({ v : Any ->
              PS.Data.Bounded.Module.bottom.app(dictBounded)
           }))
       .app(PS.Data.Lazy.Module.defer
              .app({ v : Any ->
           PS.Data.Bounded.Module.top.app(dictBounded)
        }))
  };
  @JvmField
  val applyLazy = PS.Control.Apply.Module.Apply
                    .app({ _ : Any ->
                         PS.Data.Lazy.Module.functorLazy
                      })
                    .app({ f : Any ->
       { x : Any ->
         PS.Data.Lazy.Module.defer
           .app({ v : Any ->
             PS.Data.Lazy.Module.force.app(f)
               .app(PS.Data.Lazy.Module.force.app(x))
          })
      }
    });
  @JvmField
  val bindLazy = PS.Control.Bind.Module.Bind
                   .app({ _ : Any ->
                        PS.Data.Lazy.Module.applyLazy
                     })
                   .app({ l : Any ->
       { f : Any ->
         PS.Data.Lazy.Module.defer
           .app({ v : Any ->
             PS.Data.Function.Module.apply.app(PS.Data.Lazy.Module.force)
               .app(f.app(PS.Data.Lazy.Module.force.app(l)))
          })
      }
    });
  @JvmField
  val heytingAlgebraLazy = { dictHeytingAlgebra : Any ->
     PS.Data.HeytingAlgebra.Module.HeytingAlgebra
       .app({ a : Any ->
            { b : Any ->
              PS.Control.Apply.Module.apply.app(PS.Data.Lazy.Module.applyLazy)
                .app(PS.Data.Functor.Module.map
                       .app(PS.Data.Lazy.Module.functorLazy)
                       .app(PS.Data.HeytingAlgebra.Module.conj
                              .app(dictHeytingAlgebra))
                       .app(a))
                .app(b)
           }
         })
       .app({ a : Any ->
            { b : Any ->
              PS.Control.Apply.Module.apply.app(PS.Data.Lazy.Module.applyLazy)
                .app(PS.Data.Functor.Module.map
                       .app(PS.Data.Lazy.Module.functorLazy)
                       .app(PS.Data.HeytingAlgebra.Module.disj
                              .app(dictHeytingAlgebra))
                       .app(a))
                .app(b)
           }
         })
       .app(PS.Data.Lazy.Module.defer
              .app({ v : Any ->
              PS.Data.HeytingAlgebra.Module.ff.app(dictHeytingAlgebra)
           }))
       .app({ a : Any ->
            { b : Any ->
              PS.Control.Apply.Module.apply.app(PS.Data.Lazy.Module.applyLazy)
                .app(PS.Data.Functor.Module.map
                       .app(PS.Data.Lazy.Module.functorLazy)
                       .app(PS.Data.HeytingAlgebra.Module.implies
                              .app(dictHeytingAlgebra))
                       .app(a))
                .app(b)
           }
         })
       .app({ a : Any ->
            PS.Data.Functor.Module.map.app(PS.Data.Lazy.Module.functorLazy)
              .app(PS.Data.HeytingAlgebra.Module.not.app(dictHeytingAlgebra))
              .app(a)
         })
       .app(PS.Data.Lazy.Module.defer
              .app({ v : Any ->
           PS.Data.HeytingAlgebra.Module.tt.app(dictHeytingAlgebra)
        }))
  };
  @JvmField
  val booleanAlgebraLazy = { dictBooleanAlgebra : Any ->
     PS.Data.BooleanAlgebra.Module.BooleanAlgebra
       .app({ _ : Any ->
         PS.Data.Lazy.Module.heytingAlgebraLazy
           .app((dictBooleanAlgebra as Map<String, Any>)["HeytingAlgebra0"]!!
                  .app(Unit))
      })
  };
  @JvmField
  val applicativeLazy = PS.Control.Applicative.Module.Applicative
                          .app({ _ : Any ->
                               PS.Data.Lazy.Module.applyLazy
                            })
                          .app({ a : Any ->
       PS.Data.Lazy.Module.defer.app({ v : Any -> a})
    });
  @JvmField
  val monadLazy = PS.Control.Monad.Module.Monad
                    .app({ _ : Any ->
                         PS.Data.Lazy.Module.applicativeLazy
                      })
                    .app({ _ : Any ->
       PS.Data.Lazy.Module.bindLazy
    });
}