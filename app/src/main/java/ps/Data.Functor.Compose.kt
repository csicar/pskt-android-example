@file:Suppress("UNCHECKED_CAST")

package PS.Data.Functor.Compose
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val Compose = { x : Any -> x};
  @JvmField
  val showCompose = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ v : Any ->
        val fga = v;
          (("(Compose " as String) + (((PS.Data.Show.Module.show.app(dictShow)
                                          .app(fga
          ) as String) + (")" as String)) as String));})
  };
  @JvmField
  val newtypeCompose = PS.Data.Newtype.Module.Newtype
                         .app({ n : Any ->
                             val a = n;
                               a;})
                         .app(PS.Data.Functor.Compose.Module.Compose);
  @JvmField
  val functorCompose = { dictFunctor : Any ->
     { dictFunctor1 : Any ->
       PS.Data.Functor.Module.Functor
         .app({ f : Any ->
           { v : Any ->
            val f1 = f;
              val fga = v;
              PS.Data.Function.Module.apply
                .app(PS.Data.Functor.Compose.Module.Compose)
                .app(PS.Data.Functor.Module.map.app(dictFunctor)
                       .app(PS.Data.Functor.Module.map.app(dictFunctor1).app(f1)
                       )
                       .app(fga));}
        })
    }
  };
  @JvmField
  val functorWithIndexCompose = { dictFunctorWithIndex : Any ->
     { dictFunctorWithIndex1 : Any ->
       PS.Data.FunctorWithIndex.Module.FunctorWithIndex
         .app({ _ : Any ->
              PS.Data.Functor.Compose.Module.functorCompose
                .app((dictFunctorWithIndex as Map<String, Any>)["Functor0"]!!
                       .app(Unit))
                .app((dictFunctorWithIndex1 as Map<String, Any>)["Functor0"]!!
                       .app(Unit))
           })
         .app({ f : Any ->
           { v : Any ->
            val f1 = f;
              val fga = v;
              PS.Data.Function.Module.apply
                .app(PS.Data.Functor.Compose.Module.Compose)
                .app(PS.Data.FunctorWithIndex.Module.mapWithIndex
                       .app(dictFunctorWithIndex)
                       .app(PS.Control.Semigroupoid.Module.compose
                              .app(PS.Control.Semigroupoid.Module.semigroupoidFn
                              )
                              .app(PS.Data.FunctorWithIndex.Module.mapWithIndex
                                     .app(dictFunctorWithIndex1))
                              .app(PS.Data.Tuple.Module.curry.app(f1)))
                       .app(fga));}
        })
    }
  };
  @JvmField
  val foldableCompose = { dictFoldable : Any ->
     { dictFoldable1 : Any ->
       PS.Data.Foldable.Module.Foldable
         .app({ dictMonoid : Any ->
              { f : Any ->
                { v : Any ->
                 val f1 = f;
                   val fga = v;
                   PS.Data.Foldable.Module.foldMap.app(dictFoldable)
                     .app(dictMonoid)
                     .app(PS.Data.Foldable.Module.foldMap.app(dictFoldable1)
                            .app(dictMonoid)
                            .app(f1))
                     .app(fga);}
             }
           })
         .app({ f : Any ->
              { i : Any ->
                { v : Any ->
                 val f1 = f;
                   val i1 = i;
                   val fga = v;
                   PS.Data.Foldable.Module.foldl.app(dictFoldable)
                     .app(PS.Data.Foldable.Module.foldl.app(dictFoldable1)
                            .app(f1))
                     .app(i1)
                     .app(fga);}
             }
           })
         .app({ f : Any ->
           { i : Any ->
             { v : Any ->
              val f1 = f;
                val i1 = i;
                val fga = v;
                PS.Data.Foldable.Module.foldr.app(dictFoldable)
                  .app(PS.Data.Function.Module.flip
                         .app(PS.Data.Foldable.Module.foldr.app(dictFoldable1)
                                .app(f1)))
                  .app(i1)
                  .app(fga);}
          }
        })
    }
  };
  @JvmField
  val foldableWithIndexCompose = { dictFoldableWithIndex : Any ->
     { dictFoldableWithIndex1 : Any ->
       PS.Data.FoldableWithIndex.Module.FoldableWithIndex
         .app({ _ : Any ->
              PS.Data.Functor.Compose.Module.foldableCompose
                .app((dictFoldableWithIndex as Map<String, Any>)["Foldable0"]!!
                       .app(Unit))
                .app((dictFoldableWithIndex1 as Map<String, Any>)["Foldable0"]!!
                       .app(Unit))
           })
         .app({ dictMonoid : Any ->
              { f : Any ->
                { v : Any ->
                 val f1 = f;
                   val fga = v;
                   PS.Data.FoldableWithIndex.Module.foldMapWithIndex
                     .app(dictFoldableWithIndex)
                     .app(dictMonoid)
                     .app(PS.Control.Semigroupoid.Module.compose
                            .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                            .app(
                              PS.Data.FoldableWithIndex.Module.foldMapWithIndex
                                .app(dictFoldableWithIndex1)
                                .app(dictMonoid))
                            .app(PS.Data.Tuple.Module.curry.app(f1)))
                     .app(fga);}
             }
           })
         .app({ f : Any ->
              { i : Any ->
                { v : Any ->
                 val f1 = f;
                   val i1 = i;
                   val fga = v;
                   PS.Data.FoldableWithIndex.Module.foldlWithIndex
                     .app(dictFoldableWithIndex)
                     .app(PS.Control.Semigroupoid.Module.compose
                            .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                            .app(PS.Data.FoldableWithIndex.Module.foldlWithIndex
                                   .app(dictFoldableWithIndex1))
                            .app(PS.Data.Tuple.Module.curry.app(f1)))
                     .app(i1)
                     .app(fga);}
             }
           })
         .app({ f : Any ->
           { i : Any ->
             { v : Any ->
              val f1 = f;
                val i1 = i;
                val fga = v;
                PS.Data.FoldableWithIndex.Module.foldrWithIndex
                  .app(dictFoldableWithIndex)
                  .app({ a : Any ->
                       PS.Data.Function.Module.flip
                         .app(PS.Data.FoldableWithIndex.Module.foldrWithIndex
                                .app(dictFoldableWithIndex1)
                                .app(PS.Data.Tuple.Module.curry.app(f1).app(a)))
                    })
                  .app(i1)
                  .app(fga);}
          }
        })
    }
  };
  @JvmField val traversableCompose = (::__rec_traversableCompose)();
  fun __rec_traversableCompose(): Any = { dictTraversable : Any ->
     { dictTraversable1 : Any ->
       PS.Data.Traversable.Module.Traversable
         .app({ _ : Any ->
              PS.Data.Functor.Compose.Module.foldableCompose
                .app((dictTraversable as Map<String, Any>)["Foldable1"]!!
                       .app(Unit))
                .app((dictTraversable1 as Map<String, Any>)["Foldable1"]!!
                       .app(Unit))
           })
         .app({ _ : Any ->
              PS.Data.Functor.Compose.Module.functorCompose
                .app((dictTraversable as Map<String, Any>)["Functor0"]!!
                       .app(Unit))
                .app((dictTraversable1 as Map<String, Any>)["Functor0"]!!
                       .app(Unit))
           })
         .app({ dictApplicative : Any ->
              PS.Data.Traversable.Module.traverse
                .app(PS.Data.Functor.Compose.Module.traversableCompose
                       .app(dictTraversable)
                       .app(dictTraversable1))
                .app(dictApplicative)
                .app(PS.Control.Category.Module.identity
                       .app(PS.Control.Category.Module.categoryFn))
           })
         .app({ dictApplicative : Any ->
           { f : Any ->
             { v : Any ->
              val f1 = f;
                val fga = v;
                PS.Data.Function.Module.apply
                  .app(PS.Data.Functor.Module.map
                         .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                                 .app(Unit) as Map<String, Any>)["Functor0"]!!
                                .app(Unit))
                         .app(PS.Data.Functor.Compose.Module.Compose))
                  .app(PS.Data.Traversable.Module.traverse.app(dictTraversable)
                         .app(dictApplicative)
                         .app(PS.Data.Traversable.Module.traverse
                                .app(dictTraversable1)
                                .app(dictApplicative)
                                .app(f1))
                         .app(fga));}
          }
        })
    }
  };
  @JvmField
  val traversableWithIndexCompose = { dictTraversableWithIndex : Any ->
     { dictTraversableWithIndex1 : Any ->
       PS.Data.TraversableWithIndex.Module.TraversableWithIndex
         .app({ _ : Any ->
              PS.Data.Functor.Compose.Module.foldableWithIndexCompose
                .app(
                  (dictTraversableWithIndex as Map<String, Any>)["FoldableWithIndex1"]!!
                    .app(Unit))
                .app(
               (dictTraversableWithIndex1 as Map<String, Any>)["FoldableWithIndex1"]!!
                 .app(Unit))
           })
         .app({ _ : Any ->
              PS.Data.Functor.Compose.Module.functorWithIndexCompose
                .app(
                  (dictTraversableWithIndex as Map<String, Any>)["FunctorWithIndex0"]!!
                    .app(Unit))
                .app(
               (dictTraversableWithIndex1 as Map<String, Any>)["FunctorWithIndex0"]!!
                 .app(Unit))
           })
         .app({ _ : Any ->
              PS.Data.Functor.Compose.Module.traversableCompose
                .app(
                  (dictTraversableWithIndex as Map<String, Any>)["Traversable2"]!!
                    .app(Unit))
                .app(
               (dictTraversableWithIndex1 as Map<String, Any>)["Traversable2"]!!
                 .app(Unit))
           })
         .app({ dictApplicative : Any ->
           { f : Any ->
             { v : Any ->
              val f1 = f;
                val fga = v;
                PS.Data.Function.Module.apply
                  .app(PS.Data.Functor.Module.map
                         .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                                 .app(Unit) as Map<String, Any>)["Functor0"]!!
                                .app(Unit))
                         .app(PS.Data.Functor.Compose.Module.Compose))
                  .app(PS.Data.TraversableWithIndex.Module.traverseWithIndex
                         .app(dictTraversableWithIndex)
                         .app(dictApplicative)
                         .app(PS.Control.Semigroupoid.Module.compose
                                .app(
                                  PS.Control.Semigroupoid.Module.semigroupoidFn)
                                .app(
                                  PS.Data.TraversableWithIndex.Module.traverseWithIndex
                                    .app(dictTraversableWithIndex1)
                                    .app(dictApplicative))
                                .app(PS.Data.Tuple.Module.curry.app(f1)))
                         .app(fga));}
          }
        })
    }
  };
  @JvmField
  val eqCompose = { dictEq1 : Any ->
     { dictEq11 : Any ->
       { dictEq : Any ->
         PS.Data.Eq.Module.Eq
           .app({ v : Any ->
             { v1 : Any ->
              val fga1 = v;
                val fga2 = v1;
                PS.Data.Eq.Module.eq1.app(dictEq1)
                  .app(PS.Data.Functor.App.Module.eqApp.app(dictEq11)
                         .app(dictEq))
                  .app(PS.Data.Functor.App.Module.hoistLiftApp.app(fga1))
                  .app(PS.Data.Functor.App.Module.hoistLiftApp.app(fga2));}
          })
      }
    }
  };
  @JvmField
  val ordCompose = { dictOrd1 : Any ->
     { dictOrd11 : Any ->
       { dictOrd : Any ->
         PS.Data.Ord.Module.Ord
           .app({ _ : Any ->
                PS.Data.Functor.Compose.Module.eqCompose
                  .app((dictOrd1 as Map<String, Any>)["Eq10"]!!.app(Unit))
                  .app((dictOrd11 as Map<String, Any>)["Eq10"]!!.app(Unit))
                  .app((dictOrd as Map<String, Any>)["Eq0"]!!.app(Unit))
             })
           .app({ v : Any ->
             { v1 : Any ->
              val fga1 = v;
                val fga2 = v1;
                PS.Data.Ord.Module.compare1.app(dictOrd1)
                  .app(PS.Data.Functor.App.Module.ordApp.app(dictOrd11)
                         .app(dictOrd))
                  .app(PS.Data.Functor.App.Module.hoistLiftApp.app(fga1))
                  .app(PS.Data.Functor.App.Module.hoistLiftApp.app(fga2));}
          })
      }
    }
  };
  @JvmField
  val eq1Compose = { dictEq1 : Any ->
     { dictEq11 : Any ->
       PS.Data.Eq.Module.Eq1
         .app({ dictEq : Any ->
           PS.Data.Eq.Module.eq
             .app(PS.Data.Functor.Compose.Module.eqCompose.app(dictEq1)
                    .app(dictEq11)
                    .app(dictEq))
        })
    }
  };
  @JvmField
  val ord1Compose = { dictOrd1 : Any ->
     { dictOrd11 : Any ->
       PS.Data.Ord.Module.Ord1
         .app({ _ : Any ->
              PS.Data.Functor.Compose.Module.eq1Compose
                .app((dictOrd1 as Map<String, Any>)["Eq10"]!!.app(Unit))
                .app((dictOrd11 as Map<String, Any>)["Eq10"]!!.app(Unit))
           })
         .app({ dictOrd : Any ->
           PS.Data.Ord.Module.compare
             .app(PS.Data.Functor.Compose.Module.ordCompose.app(dictOrd1)
                    .app(dictOrd11)
                    .app(dictOrd))
        })
    }
  };
  @JvmField
  val bihoistCompose = { dictFunctor : Any ->
     { natF : Any ->
       { natG : Any ->
         { v : Any ->
          val natF1 = natF;
            val natG1 = natG;
            val fga = v;
            PS.Data.Functor.Compose.Module.Compose
              .app(natF1
                     .app(PS.Data.Functor.Module.map.app(dictFunctor).app(natG1)
                            .app(fga)));}
      }
    }
  };
  @JvmField
  val applyCompose = { dictApply : Any ->
     { dictApply1 : Any ->
       PS.Control.Apply.Module.Apply
         .app({ _ : Any ->
              PS.Data.Functor.Compose.Module.functorCompose
                .app((dictApply as Map<String, Any>)["Functor0"]!!.app(Unit))
                .app((dictApply1 as Map<String, Any>)["Functor0"]!!.app(Unit))
           })
         .app({ v : Any ->
           { v1 : Any ->
            val f = v;
              val x = v1;
              PS.Data.Function.Module.apply
                .app(PS.Data.Functor.Compose.Module.Compose)
                .app(PS.Control.Apply.Module.apply.app(dictApply)
                       .app(PS.Data.Functor.Module.map
                              .app((dictApply as Map<String, Any>)["Functor0"]!!
                                     .app(Unit))
                              .app(PS.Control.Apply.Module.apply.app(dictApply1)
                              )
                              .app(f))
                       .app(x));}
        })
    }
  };
  @JvmField
  val applicativeCompose = { dictApplicative : Any ->
     { dictApplicative1 : Any ->
       PS.Control.Applicative.Module.Applicative
         .app({ _ : Any ->
              PS.Data.Functor.Compose.Module.applyCompose
                .app((dictApplicative as Map<String, Any>)["Apply0"]!!.app(Unit)
                )
                .app((dictApplicative1 as Map<String, Any>)["Apply0"]!!
                       .app(Unit))
           })
         .app(PS.Control.Semigroupoid.Module.compose
                .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                .app(PS.Data.Functor.Compose.Module.Compose)
                .app(PS.Control.Semigroupoid.Module.compose
                       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                       .app(PS.Control.Applicative.Module.pure
                              .app(dictApplicative))
                       .app(PS.Control.Applicative.Module.pure
                              .app(dictApplicative1))))
    }
  };
  @JvmField
  val altCompose = { dictAlt : Any ->
     { dictFunctor : Any ->
       PS.Control.Alt.Module.Alt
         .app({ _ : Any ->
              PS.Data.Functor.Compose.Module.functorCompose
                .app((dictAlt as Map<String, Any>)["Functor0"]!!.app(Unit))
                .app(dictFunctor)
           })
         .app({ v : Any ->
           { v1 : Any ->
            val a = v;
              val b = v1;
              PS.Data.Function.Module.apply
                .app(PS.Data.Functor.Compose.Module.Compose)
                .app(PS.Control.Alt.Module.alt.app(dictAlt).app(a).app(b));}
        })
    }
  };
  @JvmField
  val plusCompose = { dictPlus : Any ->
     { dictFunctor : Any ->
       PS.Control.Plus.Module.Plus
         .app({ _ : Any ->
              PS.Data.Functor.Compose.Module.altCompose
                .app((dictPlus as Map<String, Any>)["Alt0"]!!.app(Unit))
                .app(dictFunctor)
           })
         .app(PS.Data.Functor.Compose.Module.Compose
                .app(PS.Control.Plus.Module.empty.app(dictPlus)))
    }
  };
  @JvmField
  val alternativeCompose = { dictAlternative : Any ->
     { dictApplicative : Any ->
       PS.Control.Alternative.Module.Alternative
         .app({ _ : Any ->
              PS.Data.Functor.Compose.Module.applicativeCompose
                .app((dictAlternative as Map<String, Any>)["Applicative0"]!!
                       .app(Unit))
                .app(dictApplicative)
           })
         .app({ _ : Any ->
           PS.Data.Functor.Compose.Module.plusCompose
             .app((dictAlternative as Map<String, Any>)["Plus1"]!!.app(Unit))
             .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                     .app(Unit) as Map<String, Any>)["Functor0"]!!
                    .app(Unit))
        })
    }
  };
}