@file:Suppress("UNCHECKED_CAST")

package PS.Data.Bitraversable
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val Bitraversable = { Bifoldable1 : Any ->
     { Bifunctor0 : Any ->
       { bisequence : Any ->
         { bitraverse : Any ->
           mapOf(("Bifoldable1" to Bifoldable1),  ("Bifunctor0" to Bifunctor0), 
            ("bisequence" to bisequence),  ("bitraverse" to bitraverse))
        }
      }
    }
  };
  @JvmField
  val bitraverse = { dict : Any ->
     (dict as Map<String, Any>)["bitraverse"]!!
  };
  @JvmField
  val lfor = { dictBitraversable : Any ->
     { dictApplicative : Any ->
       { t : Any ->
         { f : Any ->
           PS.Data.Bitraversable.Module.bitraverse.app(dictBitraversable)
             .app(dictApplicative)
             .app(f)
             .app(PS.Control.Applicative.Module.pure.app(dictApplicative))
             .app(t)
        }
      }
    }
  };
  @JvmField
  val ltraverse = { dictBitraversable : Any ->
     { dictApplicative : Any ->
       { f : Any ->
         PS.Data.Bitraversable.Module.bitraverse.app(dictBitraversable)
           .app(dictApplicative)
           .app(f)
           .app(PS.Control.Applicative.Module.pure.app(dictApplicative))
      }
    }
  };
  @JvmField
  val rfor = { dictBitraversable : Any ->
     { dictApplicative : Any ->
       { t : Any ->
         { f : Any ->
           PS.Data.Bitraversable.Module.bitraverse.app(dictBitraversable)
             .app(dictApplicative)
             .app(PS.Control.Applicative.Module.pure.app(dictApplicative))
             .app(f)
             .app(t)
        }
      }
    }
  };
  @JvmField
  val rtraverse = { dictBitraversable : Any ->
     { dictApplicative : Any ->
       PS.Data.Bitraversable.Module.bitraverse.app(dictBitraversable)
         .app(dictApplicative)
         .app(PS.Control.Applicative.Module.pure.app(dictApplicative))
    }
  };
  @JvmField
  val bitraversableJoker = { dictTraversable : Any ->
     PS.Data.Bitraversable.Module.Bitraversable
       .app({ _ : Any ->
            PS.Data.Bifoldable.Module.bifoldableJoker
              .app((dictTraversable as Map<String, Any>)["Foldable1"]!!
                     .app(Unit))
         })
       .app({ _ : Any ->
            PS.Data.Bifunctor.Joker.Module.bifunctorJoker
              .app((dictTraversable as Map<String, Any>)["Functor0"]!!.app(Unit)
           )
         })
       .app({ dictApplicative : Any ->
            { v : Any ->
             val f = v;
               PS.Data.Functor.Module.map
                 .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                         .app(Unit) as Map<String, Any>)["Functor0"]!!
                        .app(Unit))
                 .app(PS.Data.Bifunctor.Joker.Module.Joker)
                 .app(PS.Data.Traversable.Module.sequence.app(dictTraversable)
                        .app(dictApplicative)
                        .app(f));}
         })
       .app({ dictApplicative : Any ->
         { v : Any ->
           { r : Any ->
             { v1 : Any ->
              val r1 = r;
                val f = v1;
                PS.Data.Functor.Module.map
                  .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                          .app(Unit) as Map<String, Any>)["Functor0"]!!
                         .app(Unit))
                  .app(PS.Data.Bifunctor.Joker.Module.Joker)
                  .app(PS.Data.Traversable.Module.traverse.app(dictTraversable)
                         .app(dictApplicative)
                         .app(r1)
                         .app(f));}
          }
        }
      })
  };
  @JvmField
  val bitraversableClown = { dictTraversable : Any ->
     PS.Data.Bitraversable.Module.Bitraversable
       .app({ _ : Any ->
            PS.Data.Bifoldable.Module.bifoldableClown
              .app((dictTraversable as Map<String, Any>)["Foldable1"]!!
                     .app(Unit))
         })
       .app({ _ : Any ->
            PS.Data.Bifunctor.Clown.Module.bifunctorClown
              .app((dictTraversable as Map<String, Any>)["Functor0"]!!.app(Unit)
           )
         })
       .app({ dictApplicative : Any ->
            { v : Any ->
             val f = v;
               PS.Data.Functor.Module.map
                 .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                         .app(Unit) as Map<String, Any>)["Functor0"]!!
                        .app(Unit))
                 .app(PS.Data.Bifunctor.Clown.Module.Clown)
                 .app(PS.Data.Traversable.Module.sequence.app(dictTraversable)
                        .app(dictApplicative)
                        .app(f));}
         })
       .app({ dictApplicative : Any ->
         { l : Any ->
           { v : Any ->
             { v1 : Any ->
              val l1 = l;
                val f = v1;
                PS.Data.Functor.Module.map
                  .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                          .app(Unit) as Map<String, Any>)["Functor0"]!!
                         .app(Unit))
                  .app(PS.Data.Bifunctor.Clown.Module.Clown)
                  .app(PS.Data.Traversable.Module.traverse.app(dictTraversable)
                         .app(dictApplicative)
                         .app(l1)
                         .app(f));}
          }
        }
      })
  };
  @JvmField
  val bisequenceDefault = { dictBitraversable : Any ->
     { dictApplicative : Any ->
       PS.Data.Bitraversable.Module.bitraverse.app(dictBitraversable)
         .app(dictApplicative)
         .app(PS.Control.Category.Module.identity
                .app(PS.Control.Category.Module.categoryFn))
         .app(PS.Control.Category.Module.identity
                .app(PS.Control.Category.Module.categoryFn))
    }
  };
  @JvmField
  val bisequence = { dict : Any ->
     (dict as Map<String, Any>)["bisequence"]!!
  };
  @JvmField
  val bitraversableFlip = { dictBitraversable : Any ->
     PS.Data.Bitraversable.Module.Bitraversable
       .app({ _ : Any ->
            PS.Data.Bifoldable.Module.bifoldableFlip
              .app((dictBitraversable as Map<String, Any>)["Bifoldable1"]!!
                     .app(Unit))
         })
       .app({ _ : Any ->
            PS.Data.Bifunctor.Flip.Module.bifunctorFlip
              .app((dictBitraversable as Map<String, Any>)["Bifunctor0"]!!
                     .app(Unit))
         })
       .app({ dictApplicative : Any ->
            { v : Any ->
             val p = v;
               PS.Data.Functor.Module.map
                 .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                         .app(Unit) as Map<String, Any>)["Functor0"]!!
                        .app(Unit))
                 .app(PS.Data.Bifunctor.Flip.Module.Flip)
                 .app(PS.Data.Bitraversable.Module.bisequence
                        .app(dictBitraversable)
                        .app(dictApplicative)
                        .app(p));}
         })
       .app({ dictApplicative : Any ->
         { r : Any ->
           { l : Any ->
             { v : Any ->
              val r1 = r;
                val l1 = l;
                val p = v;
                PS.Data.Functor.Module.map
                  .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                          .app(Unit) as Map<String, Any>)["Functor0"]!!
                         .app(Unit))
                  .app(PS.Data.Bifunctor.Flip.Module.Flip)
                  .app(PS.Data.Bitraversable.Module.bitraverse
                         .app(dictBitraversable)
                         .app(dictApplicative)
                         .app(l1)
                         .app(r1)
                         .app(p));}
          }
        }
      })
  };
  @JvmField
  val bitraversableProduct = { dictBitraversable : Any ->
     { dictBitraversable1 : Any ->
       PS.Data.Bitraversable.Module.Bitraversable
         .app({ _ : Any ->
              PS.Data.Bifoldable.Module.bifoldableProduct
                .app((dictBitraversable as Map<String, Any>)["Bifoldable1"]!!
                       .app(Unit))
                .app((dictBitraversable1 as Map<String, Any>)["Bifoldable1"]!!
                       .app(Unit))
           })
         .app({ _ : Any ->
              PS.Data.Bifunctor.Product.Module.bifunctorProduct
                .app((dictBitraversable as Map<String, Any>)["Bifunctor0"]!!
                       .app(Unit))
                .app((dictBitraversable1 as Map<String, Any>)["Bifunctor0"]!!
                       .app(Unit))
           })
         .app({ dictApplicative : Any ->
              { v : Any ->
                when {
                 (v is PS.Data.Bifunctor.Product.Module._Type_Product
                         .Product) -> {
                   val f = v.value0;
                   val g = v.value1;
                   PS.Control.Apply.Module.apply
                     .app((dictApplicative as Map<String, Any>)["Apply0"]!!
                            .app(Unit))
                     .app(PS.Data.Functor.Module.map
                            .app(
                              ((dictApplicative as Map<String, Any>)["Apply0"]!!
                                 .app(Unit) as Map<String, Any>)["Functor0"]!!
                                .app(Unit))
                            .app(PS.Data.Bifunctor.Product.Module.Product)
                            .app(PS.Data.Bitraversable.Module.bisequence
                                   .app(dictBitraversable)
                                   .app(dictApplicative)
                                   .app(f)))
                     .app(PS.Data.Bitraversable.Module.bisequence
                            .app(dictBitraversable1)
                            .app(dictApplicative)
                            .app(g));
                 }
                 else -> (error("Error in Pattern Match") as Any)
               }
             }
           })
         .app({ dictApplicative : Any ->
           { l : Any ->
             { r : Any ->
               { v : Any ->
                 when {
                  (v is PS.Data.Bifunctor.Product.Module._Type_Product
                          .Product) -> {
                    val l1 = l;
                    val r1 = r;
                    val f = v.value0;
                    val g = v.value1;
                    PS.Control.Apply.Module.apply
                      .app((dictApplicative as Map<String, Any>)["Apply0"]!!
                             .app(Unit))
                      .app(PS.Data.Functor.Module.map
                             .app(
                               ((dictApplicative as Map<String, Any>)["Apply0"]!!
                                  .app(Unit) as Map<String, Any>)["Functor0"]!!
                                 .app(Unit))
                             .app(PS.Data.Bifunctor.Product.Module.Product)
                             .app(PS.Data.Bitraversable.Module.bitraverse
                                    .app(dictBitraversable)
                                    .app(dictApplicative)
                                    .app(l1)
                                    .app(r1)
                                    .app(f)))
                      .app(PS.Data.Bitraversable.Module.bitraverse
                             .app(dictBitraversable1)
                             .app(dictApplicative)
                             .app(l1)
                             .app(r1)
                             .app(g));
                  }
                  else -> (error("Error in Pattern Match") as Any)
                }
              }
            }
          }
        })
    }
  };
  @JvmField
  val bitraversableWrap = { dictBitraversable : Any ->
     PS.Data.Bitraversable.Module.Bitraversable
       .app({ _ : Any ->
            PS.Data.Bifoldable.Module.bifoldableWrap
              .app((dictBitraversable as Map<String, Any>)["Bifoldable1"]!!
                     .app(Unit))
         })
       .app({ _ : Any ->
            PS.Data.Bifunctor.Wrap.Module.bifunctorWrap
              .app((dictBitraversable as Map<String, Any>)["Bifunctor0"]!!
                     .app(Unit))
         })
       .app({ dictApplicative : Any ->
            { v : Any ->
             val p = v;
               PS.Data.Functor.Module.map
                 .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                         .app(Unit) as Map<String, Any>)["Functor0"]!!
                        .app(Unit))
                 .app(PS.Data.Bifunctor.Wrap.Module.Wrap)
                 .app(PS.Data.Bitraversable.Module.bisequence
                        .app(dictBitraversable)
                        .app(dictApplicative)
                        .app(p));}
         })
       .app({ dictApplicative : Any ->
         { l : Any ->
           { r : Any ->
             { v : Any ->
              val l1 = l;
                val r1 = r;
                val p = v;
                PS.Data.Functor.Module.map
                  .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                          .app(Unit) as Map<String, Any>)["Functor0"]!!
                         .app(Unit))
                  .app(PS.Data.Bifunctor.Wrap.Module.Wrap)
                  .app(PS.Data.Bitraversable.Module.bitraverse
                         .app(dictBitraversable)
                         .app(dictApplicative)
                         .app(l1)
                         .app(r1)
                         .app(p));}
          }
        }
      })
  };
  @JvmField
  val bitraverseDefault = { dictBitraversable : Any ->
     { dictApplicative : Any ->
       { f : Any ->
         { g : Any ->
           { t : Any ->
             PS.Data.Bitraversable.Module.bisequence.app(dictBitraversable)
               .app(dictApplicative)
               .app(PS.Data.Bifunctor.Module.bimap
                      .app(
                        (dictBitraversable as Map<String, Any>)["Bifunctor0"]!!
                          .app(Unit))
                      .app(f)
                      .app(g)
                      .app(t))
          }
        }
      }
    }
  };
  @JvmField
  val bifor = { dictBitraversable : Any ->
     { dictApplicative : Any ->
       { t : Any ->
         { f : Any ->
           { g : Any ->
             PS.Data.Bitraversable.Module.bitraverse.app(dictBitraversable)
               .app(dictApplicative)
               .app(f)
               .app(g)
               .app(t)
          }
        }
      }
    }
  };
}