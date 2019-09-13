@file:Suppress("UNCHECKED_CAST")

package PS.Data.Semigroup.Foldable
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val JoinWith = { x : Any -> x};
  @JvmField val Act = { x : Any -> x};
  @JvmField
  val Foldable1 = { Foldable0 : Any ->
     { fold1 : Any ->
       { foldMap1 : Any ->
         mapOf(("Foldable0" to Foldable0),  ("fold1" to fold1),  
          ("foldMap1" to foldMap1))
      }
    }
  };
  @JvmField
  val semigroupJoinWith = { dictSemigroup : Any ->
     PS.Data.Semigroup.Module.Semigroup
       .app({ v : Any ->
         { v1 : Any ->
          val a = v;
            val b = v1;
            PS.Data.Function.Module.apply
              .app(PS.Data.Semigroup.Foldable.Module.JoinWith)
              .app({ j : Any ->
                 PS.Data.Semigroup.Module.append.app(dictSemigroup)
                   .app(a.app(j))
                   .app(PS.Data.Semigroup.Module.append.app(dictSemigroup)
                          .app(j)
                          .app(b.app(j)))
              });}
      })
  };
  @JvmField
  val semigroupAct = { dictApply : Any ->
     PS.Data.Semigroup.Module.Semigroup
       .app({ v : Any ->
         { v1 : Any ->
          val a = v;
            val b = v1;
            PS.Data.Semigroup.Foldable.Module.Act
              .app(PS.Control.Apply.Module.applySecond.app(dictApply).app(a)
                     .app(b));}
      })
  };
  @JvmField val joinee = { v : Any ->val x = v; x;};
  @JvmField val getAct = { v : Any ->val f = v; f;};
  @JvmField
  val foldMap1 = { dict : Any ->
     (dict as Map<String, Any>)["foldMap1"]!!
  };
  @JvmField
  val intercalateMap = { dictFoldable1 : Any ->
     { dictSemigroup : Any ->
       { j : Any ->
         { f : Any ->
           { foldable : Any ->
             PS.Data.Semigroup.Foldable.Module.joinee
               .app(PS.Data.Semigroup.Foldable.Module.foldMap1
                      .app(dictFoldable1)
                      .app(PS.Data.Semigroup.Foldable.Module.semigroupJoinWith
                             .app(dictSemigroup))
                      .app(PS.Control.Semigroupoid.Module.compose
                             .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                             .app(PS.Data.Semigroup.Foldable.Module.JoinWith)
                             .app(PS.Control.Semigroupoid.Module.compose
                                    .app(
                                      PS.Control.Semigroupoid.Module.semigroupoidFn
                                    )
                                    .app(PS.Data.Function.Module._const)
                                    .app(f)))
                      .app(foldable))
               .app(j)
          }
        }
      }
    }
  };
  @JvmField
  val intercalate = { dictFoldable1 : Any ->
     { dictSemigroup : Any ->
       PS.Data.Function.Module.flip
         .app(PS.Data.Semigroup.Foldable.Module.intercalateMap
                .app(dictFoldable1)
                .app(dictSemigroup))
         .app(PS.Control.Category.Module.identity
                .app(PS.Control.Category.Module.categoryFn))
    }
  };
  @JvmField
  val maximum = { dictOrd : Any ->
     { dictFoldable1 : Any ->
       PS.Data.Newtype.Module.ala.app(PS.Data.Functor.Module.functorFn)
         .app(PS.Data.Ord.Max.Module.newtypeMax)
         .app(PS.Data.Ord.Max.Module.newtypeMax)
         .app(PS.Data.Ord.Max.Module.Max)
         .app(PS.Data.Semigroup.Foldable.Module.foldMap1.app(dictFoldable1)
                .app(PS.Data.Ord.Max.Module.semigroupMax.app(dictOrd)))
    }
  };
  @JvmField
  val minimum = { dictOrd : Any ->
     { dictFoldable1 : Any ->
       PS.Data.Newtype.Module.ala.app(PS.Data.Functor.Module.functorFn)
         .app(PS.Data.Ord.Min.Module.newtypeMin)
         .app(PS.Data.Ord.Min.Module.newtypeMin)
         .app(PS.Data.Ord.Min.Module.Min)
         .app(PS.Data.Semigroup.Foldable.Module.foldMap1.app(dictFoldable1)
                .app(PS.Data.Ord.Min.Module.semigroupMin.app(dictOrd)))
    }
  };
  @JvmField
  val traverse1_ = { dictFoldable1 : Any ->
     { dictApply : Any ->
       { f : Any ->
         { t : Any ->
           PS.Data.Functor.Module.voidRight
             .app((dictApply as Map<String, Any>)["Functor0"]!!.app(Unit))
             .app(PS.Data.Unit.Module.unit)
             .app(PS.Data.Semigroup.Foldable.Module.getAct
                    .app(PS.Data.Semigroup.Foldable.Module.foldMap1
                           .app(dictFoldable1)
                           .app(PS.Data.Semigroup.Foldable.Module.semigroupAct
                                  .app(dictApply))
                           .app(PS.Control.Semigroupoid.Module.compose
                                  .app(
                                    PS.Control.Semigroupoid.Module.semigroupoidFn
                                  )
                                  .app(PS.Data.Semigroup.Foldable.Module.Act)
                                  .app(f))
                           .app(t)))
        }
      }
    }
  };
  @JvmField
  val for1_ = { dictFoldable1 : Any ->
     { dictApply : Any ->
       PS.Data.Function.Module.flip
         .app(PS.Data.Semigroup.Foldable.Module.traverse1_.app(dictFoldable1)
                .app(dictApply))
    }
  };
  @JvmField
  val sequence1_ = { dictFoldable1 : Any ->
     { dictApply : Any ->
       PS.Data.Semigroup.Foldable.Module.traverse1_.app(dictFoldable1)
         .app(dictApply)
         .app(PS.Control.Category.Module.identity
                .app(PS.Control.Category.Module.categoryFn))
    }
  };
  @JvmField
  val fold1Default = { dictFoldable1 : Any ->
     { dictSemigroup : Any ->
       PS.Data.Semigroup.Foldable.Module.foldMap1.app(dictFoldable1)
         .app(dictSemigroup)
         .app(PS.Control.Category.Module.identity
                .app(PS.Control.Category.Module.categoryFn))
    }
  };
  @JvmField val foldableDual = (::__rec_foldableDual)();
  fun __rec_foldableDual(): Any = PS.Data.Semigroup.Foldable.Module.Foldable1
                                    .app({ _ : Any ->
                                         PS.Data.Foldable.Module.foldableDual
                                      })
                                    .app({ dictSemigroup : Any ->
                                         PS.Data.Semigroup.Foldable.Module.fold1Default
                                           .app(
                                             PS.Data.Semigroup.Foldable.Module.foldableDual
                                           )
                                           .app(dictSemigroup)
                                      })
                                    .app({ dictSemigroup : Any ->
       { f : Any ->
         { v : Any ->
          val f1 = f;
            val x = v;
            f1.app(x);}
      }
    });
  @JvmField val foldableMultiplicative = (::__rec_foldableMultiplicative)();
  fun __rec_foldableMultiplicative(): Any = PS.Data.Semigroup.Foldable.Module.Foldable1
                                              .app({ _ : Any ->
                                                   PS.Data.Foldable.Module.foldableMultiplicative
                                                })
                                              .app({ dictSemigroup : Any ->
                                                   PS.Data.Semigroup.Foldable.Module.fold1Default
                                                     .app(
                                                       PS.Data.Semigroup.Foldable.Module.foldableMultiplicative
                                                     )
                                                     .app(dictSemigroup)
                                                })
                                              .app({ dictSemigroup : Any ->
       { f : Any ->
         { v : Any ->
          val f1 = f;
            val x = v;
            f1.app(x);}
      }
    });
  @JvmField val fold1 = { dict : Any -> (dict as Map<String, Any>)["fold1"]!!};
  @JvmField
  val foldMap1Default = { dictFoldable1 : Any ->
     { dictFunctor : Any ->
       { dictSemigroup : Any ->
         { f : Any ->
           PS.Control.Semigroupoid.Module.composeFlipped
             .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
             .app(PS.Data.Functor.Module.map.app(dictFunctor).app(f))
             .app(PS.Data.Semigroup.Foldable.Module.fold1.app(dictFoldable1)
                    .app(dictSemigroup))
        }
      }
    }
  };
}