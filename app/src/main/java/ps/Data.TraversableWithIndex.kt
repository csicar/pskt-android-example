@file:Suppress("UNCHECKED_CAST")

package PS.Data.TraversableWithIndex
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val TraversableWithIndex = { FoldableWithIndex1 : Any ->
     { FunctorWithIndex0 : Any ->
       { Traversable2 : Any ->
         { traverseWithIndex : Any ->
           mapOf(("FoldableWithIndex1" to FoldableWithIndex1),  
            ("FunctorWithIndex0" to FunctorWithIndex0),  
            ("Traversable2" to Traversable2),  
            ("traverseWithIndex" to traverseWithIndex))
        }
      }
    }
  };
  @JvmField
  val traverseWithIndexDefault = { dictTraversableWithIndex : Any ->
     { dictApplicative : Any ->
       { f : Any ->
         PS.Control.Semigroupoid.Module.compose
           .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
           .app(PS.Data.Traversable.Module.sequence
                  .app(
                    (dictTraversableWithIndex as Map<String, Any>)["Traversable2"]!!
                      .app(Unit))
                  .app(dictApplicative))
           .app(PS.Data.FunctorWithIndex.Module.mapWithIndex
                  .app(
                    (dictTraversableWithIndex as Map<String, Any>)["FunctorWithIndex0"]!!
                      .app(Unit))
                  .app(f))
      }
    }
  };
  @JvmField
  val traverseWithIndex = { dict : Any ->
     (dict as Map<String, Any>)["traverseWithIndex"]!!
  };
  @JvmField
  val traverseDefault = { dictTraversableWithIndex : Any ->
     { dictApplicative : Any ->
       { f : Any ->
         PS.Data.TraversableWithIndex.Module.traverseWithIndex
           .app(dictTraversableWithIndex)
           .app(dictApplicative)
           .app(PS.Data.Function.Module._const.app(f))
      }
    }
  };
  @JvmField
  val traversableWithIndexMultiplicative = PS.Data.TraversableWithIndex.Module.TraversableWithIndex
                                             .app({ _ : Any ->
                                                  PS.Data.FoldableWithIndex.Module.foldableWithIndexMultiplicative
                                               })
                                             .app({ _ : Any ->
                                                  PS.Data.FunctorWithIndex.Module.functorWithIndexMultiplicative
                                               })
                                             .app({ _ : Any ->
                                                  PS.Data.Traversable.Module.traversableMultiplicative
                                               })
                                             .app({ dictApplicative : Any ->
       { f : Any ->
         PS.Data.Function.Module.apply
           .app(PS.Data.Traversable.Module.traverse
                  .app(PS.Data.Traversable.Module.traversableMultiplicative)
                  .app(dictApplicative))
           .app(f.app(PS.Data.Unit.Module.unit))
      }
    });
  @JvmField
  val traversableWithIndexMaybe = PS.Data.TraversableWithIndex.Module.TraversableWithIndex
                                    .app({ _ : Any ->
                                         PS.Data.FoldableWithIndex.Module.foldableWithIndexMaybe
                                      })
                                    .app({ _ : Any ->
                                         PS.Data.FunctorWithIndex.Module.functorWithIndexMaybe
                                      })
                                    .app({ _ : Any ->
                                         PS.Data.Traversable.Module.traversableMaybe
                                      })
                                    .app({ dictApplicative : Any ->
       { f : Any ->
         PS.Data.Function.Module.apply
           .app(PS.Data.Traversable.Module.traverse
                  .app(PS.Data.Traversable.Module.traversableMaybe)
                  .app(dictApplicative))
           .app(f.app(PS.Data.Unit.Module.unit))
      }
    });
  @JvmField
  val traversableWithIndexLast = PS.Data.TraversableWithIndex.Module.TraversableWithIndex
                                   .app({ _ : Any ->
                                        PS.Data.FoldableWithIndex.Module.foldableWithIndexLast
                                     })
                                   .app({ _ : Any ->
                                        PS.Data.FunctorWithIndex.Module.functorWithIndexLast
                                     })
                                   .app({ _ : Any ->
                                        PS.Data.Traversable.Module.traversableLast
                                     })
                                   .app({ dictApplicative : Any ->
       { f : Any ->
         PS.Data.Function.Module.apply
           .app(PS.Data.Traversable.Module.traverse
                  .app(PS.Data.Traversable.Module.traversableLast)
                  .app(dictApplicative))
           .app(f.app(PS.Data.Unit.Module.unit))
      }
    });
  @JvmField
  val traversableWithIndexFirst = PS.Data.TraversableWithIndex.Module.TraversableWithIndex
                                    .app({ _ : Any ->
                                         PS.Data.FoldableWithIndex.Module.foldableWithIndexFirst
                                      })
                                    .app({ _ : Any ->
                                         PS.Data.FunctorWithIndex.Module.functorWithIndexFirst
                                      })
                                    .app({ _ : Any ->
                                         PS.Data.Traversable.Module.traversableFirst
                                      })
                                    .app({ dictApplicative : Any ->
       { f : Any ->
         PS.Data.Function.Module.apply
           .app(PS.Data.Traversable.Module.traverse
                  .app(PS.Data.Traversable.Module.traversableFirst)
                  .app(dictApplicative))
           .app(f.app(PS.Data.Unit.Module.unit))
      }
    });
  @JvmField
  val traversableWithIndexDual = PS.Data.TraversableWithIndex.Module.TraversableWithIndex
                                   .app({ _ : Any ->
                                        PS.Data.FoldableWithIndex.Module.foldableWithIndexDual
                                     })
                                   .app({ _ : Any ->
                                        PS.Data.FunctorWithIndex.Module.functorWithIndexDual
                                     })
                                   .app({ _ : Any ->
                                        PS.Data.Traversable.Module.traversableDual
                                     })
                                   .app({ dictApplicative : Any ->
       { f : Any ->
         PS.Data.Function.Module.apply
           .app(PS.Data.Traversable.Module.traverse
                  .app(PS.Data.Traversable.Module.traversableDual)
                  .app(dictApplicative))
           .app(f.app(PS.Data.Unit.Module.unit))
      }
    });
  @JvmField
  val traversableWithIndexDisj = PS.Data.TraversableWithIndex.Module.TraversableWithIndex
                                   .app({ _ : Any ->
                                        PS.Data.FoldableWithIndex.Module.foldableWithIndexDisj
                                     })
                                   .app({ _ : Any ->
                                        PS.Data.FunctorWithIndex.Module.functorWithIndexDisj
                                     })
                                   .app({ _ : Any ->
                                        PS.Data.Traversable.Module.traversableDisj
                                     })
                                   .app({ dictApplicative : Any ->
       { f : Any ->
         PS.Data.Function.Module.apply
           .app(PS.Data.Traversable.Module.traverse
                  .app(PS.Data.Traversable.Module.traversableDisj)
                  .app(dictApplicative))
           .app(f.app(PS.Data.Unit.Module.unit))
      }
    });
  @JvmField
  val traversableWithIndexConj = PS.Data.TraversableWithIndex.Module.TraversableWithIndex
                                   .app({ _ : Any ->
                                        PS.Data.FoldableWithIndex.Module.foldableWithIndexConj
                                     })
                                   .app({ _ : Any ->
                                        PS.Data.FunctorWithIndex.Module.functorWithIndexConj
                                     })
                                   .app({ _ : Any ->
                                        PS.Data.Traversable.Module.traversableConj
                                     })
                                   .app({ dictApplicative : Any ->
       { f : Any ->
         PS.Data.Function.Module.apply
           .app(PS.Data.Traversable.Module.traverse
                  .app(PS.Data.Traversable.Module.traversableConj)
                  .app(dictApplicative))
           .app(f.app(PS.Data.Unit.Module.unit))
      }
    });
  @JvmField
  val traversableWithIndexArray = (::__rec_traversableWithIndexArray)();
  fun __rec_traversableWithIndexArray(): Any = PS.Data.TraversableWithIndex.Module.TraversableWithIndex
                                                 .app({ _ : Any ->
                                                      PS.Data.FoldableWithIndex.Module.foldableWithIndexArray
                                                   })
                                                 .app({ _ : Any ->
                                                      PS.Data.FunctorWithIndex.Module.functorWithIndexArray
                                                   })
                                                 .app({ _ : Any ->
                                                      PS.Data.Traversable.Module.traversableArray
                                                   })
                                                 .app({ dictApplicative : Any ->
       PS.Data.TraversableWithIndex.Module.traverseWithIndexDefault
         .app(PS.Data.TraversableWithIndex.Module.traversableWithIndexArray)
         .app(dictApplicative)
    });
  @JvmField
  val traversableWithIndexAdditive = PS.Data.TraversableWithIndex.Module.TraversableWithIndex
                                       .app({ _ : Any ->
                                            PS.Data.FoldableWithIndex.Module.foldableWithIndexAdditive
                                         })
                                       .app({ _ : Any ->
                                            PS.Data.FunctorWithIndex.Module.functorWithIndexAdditive
                                         })
                                       .app({ _ : Any ->
                                            PS.Data.Traversable.Module.traversableAdditive
                                         })
                                       .app({ dictApplicative : Any ->
       { f : Any ->
         PS.Data.Function.Module.apply
           .app(PS.Data.Traversable.Module.traverse
                  .app(PS.Data.Traversable.Module.traversableAdditive)
                  .app(dictApplicative))
           .app(f.app(PS.Data.Unit.Module.unit))
      }
    });
  @JvmField
  val mapAccumRWithIndex = { dictTraversableWithIndex : Any ->
     { f : Any ->
       { s0 : Any ->
         { xs : Any ->
           PS.Data.Traversable.Accum.Internal.Module.stateR
             .app(PS.Data.TraversableWithIndex.Module.traverseWithIndex
                    .app(dictTraversableWithIndex)
                    .app(
                      PS.Data.Traversable.Accum.Internal.Module.applicativeStateR
                    )
                    .app({ i : Any ->
                         { a : Any ->
                           PS.Data.Traversable.Accum.Internal.Module.StateR
                             .app({ s : Any ->
                               f.app(i).app(s).app(a)
                            })
                        }
                      })
                    .app(xs))
             .app(s0)
        }
      }
    }
  };
  @JvmField
  val scanrWithIndex = { dictTraversableWithIndex : Any ->
     { f : Any ->
       { b0 : Any ->
         { xs : Any ->
           (PS.Data.TraversableWithIndex.Module.mapAccumRWithIndex
              .app(dictTraversableWithIndex)
              .app({ i : Any ->
                   { b : Any ->
                     { a : Any ->
                       object   {
                           val b_tick = f.app(i).app(a).app(b);
                         }
                         .run({
                          val b_tick = this.b_tick;
                          mapOf(("accum" to b_tick),  ("value" to b_tick));
                        })
                    }
                  }
                })
              .app(b0)
              .app(xs) as Map<String, Any>)["value"]!!
        }
      }
    }
  };
  @JvmField
  val mapAccumLWithIndex = { dictTraversableWithIndex : Any ->
     { f : Any ->
       { s0 : Any ->
         { xs : Any ->
           PS.Data.Traversable.Accum.Internal.Module.stateL
             .app(PS.Data.TraversableWithIndex.Module.traverseWithIndex
                    .app(dictTraversableWithIndex)
                    .app(
                      PS.Data.Traversable.Accum.Internal.Module.applicativeStateL
                    )
                    .app({ i : Any ->
                         { a : Any ->
                           PS.Data.Traversable.Accum.Internal.Module.StateL
                             .app({ s : Any ->
                               f.app(i).app(s).app(a)
                            })
                        }
                      })
                    .app(xs))
             .app(s0)
        }
      }
    }
  };
  @JvmField
  val scanlWithIndex = { dictTraversableWithIndex : Any ->
     { f : Any ->
       { b0 : Any ->
         { xs : Any ->
           (PS.Data.TraversableWithIndex.Module.mapAccumLWithIndex
              .app(dictTraversableWithIndex)
              .app({ i : Any ->
                   { b : Any ->
                     { a : Any ->
                       object   {
                           val b_tick = f.app(i).app(b).app(a);
                         }
                         .run({
                          val b_tick = this.b_tick;
                          mapOf(("accum" to b_tick),  ("value" to b_tick));
                        })
                    }
                  }
                })
              .app(b0)
              .app(xs) as Map<String, Any>)["value"]!!
        }
      }
    }
  };
  @JvmField
  val forWithIndex = { dictApplicative : Any ->
     { dictTraversableWithIndex : Any ->
       PS.Data.Function.Module.flip
         .app(PS.Data.TraversableWithIndex.Module.traverseWithIndex
                .app(dictTraversableWithIndex)
                .app(dictApplicative))
    }
  };
}