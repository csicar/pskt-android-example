@file:Suppress("UNCHECKED_CAST")

package PS.Data.Bifoldable
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val Bifoldable = { bifoldMap : Any ->
     { bifoldl : Any ->
       { bifoldr : Any ->
         mapOf(("bifoldMap" to bifoldMap),  ("bifoldl" to bifoldl),  
          ("bifoldr" to bifoldr))
      }
    }
  };
  @JvmField
  val bifoldr = { dict : Any ->
     (dict as Map<String, Any>)["bifoldr"]!!
  };
  @JvmField
  val bitraverse_ = { dictBifoldable : Any ->
     { dictApplicative : Any ->
       { f : Any ->
         { g : Any ->
           PS.Data.Bifoldable.Module.bifoldr.app(dictBifoldable)
             .app(PS.Control.Semigroupoid.Module.compose
                    .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                    .app(PS.Control.Apply.Module.applySecond
                           .app(
                        (dictApplicative as Map<String, Any>)["Apply0"]!!
                          .app(Unit)))
                    .app(f))
             .app(PS.Control.Semigroupoid.Module.compose
                    .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                    .app(PS.Control.Apply.Module.applySecond
                           .app(
                        (dictApplicative as Map<String, Any>)["Apply0"]!!
                          .app(Unit)))
                    .app(g))
             .app(PS.Control.Applicative.Module.pure.app(dictApplicative)
                    .app(PS.Data.Unit.Module.unit))
        }
      }
    }
  };
  @JvmField
  val bifor_ = { dictBifoldable : Any ->
     { dictApplicative : Any ->
       { t : Any ->
         { f : Any ->
           { g : Any ->
             PS.Data.Bifoldable.Module.bitraverse_.app(dictBifoldable)
               .app(dictApplicative)
               .app(f)
               .app(g)
               .app(t)
          }
        }
      }
    }
  };
  @JvmField
  val bisequence_ = { dictBifoldable : Any ->
     { dictApplicative : Any ->
       PS.Data.Bifoldable.Module.bitraverse_.app(dictBifoldable)
         .app(dictApplicative)
         .app(PS.Control.Category.Module.identity
                .app(PS.Control.Category.Module.categoryFn))
         .app(PS.Control.Category.Module.identity
                .app(PS.Control.Category.Module.categoryFn))
    }
  };
  @JvmField
  val bifoldl = { dict : Any ->
     (dict as Map<String, Any>)["bifoldl"]!!
  };
  @JvmField
  val bifoldableJoker = { dictFoldable : Any ->
     PS.Data.Bifoldable.Module.Bifoldable
       .app({ dictMonoid : Any ->
            { v : Any ->
              { r : Any ->
                { v1 : Any ->
                 val r1 = r;
                   val f = v1;
                   PS.Data.Foldable.Module.foldMap.app(dictFoldable)
                     .app(dictMonoid)
                     .app(r1)
                     .app(f);}
             }
           }
         })
       .app({ v : Any ->
            { r : Any ->
              { u : Any ->
                { v1 : Any ->
                 val r1 = r;
                   val u1 = u;
                   val f = v1;
                   PS.Data.Foldable.Module.foldl.app(dictFoldable).app(r1)
                     .app(u1)
                     .app(f);}
             }
           }
         })
       .app({ v : Any ->
         { r : Any ->
           { u : Any ->
             { v1 : Any ->
              val r1 = r;
                val u1 = u;
                val f = v1;
                PS.Data.Foldable.Module.foldr.app(dictFoldable).app(r1).app(u1)
                  .app(f);}
          }
        }
      })
  };
  @JvmField
  val bifoldableClown = { dictFoldable : Any ->
     PS.Data.Bifoldable.Module.Bifoldable
       .app({ dictMonoid : Any ->
            { l : Any ->
              { v : Any ->
                { v1 : Any ->
                 val l1 = l;
                   val f = v1;
                   PS.Data.Foldable.Module.foldMap.app(dictFoldable)
                     .app(dictMonoid)
                     .app(l1)
                     .app(f);}
             }
           }
         })
       .app({ l : Any ->
            { v : Any ->
              { u : Any ->
                { v1 : Any ->
                 val l1 = l;
                   val u1 = u;
                   val f = v1;
                   PS.Data.Foldable.Module.foldl.app(dictFoldable).app(l1)
                     .app(u1)
                     .app(f);}
             }
           }
         })
       .app({ l : Any ->
         { v : Any ->
           { u : Any ->
             { v1 : Any ->
              val l1 = l;
                val u1 = u;
                val f = v1;
                PS.Data.Foldable.Module.foldr.app(dictFoldable).app(l1).app(u1)
                  .app(f);}
          }
        }
      })
  };
  @JvmField
  val bifoldMapDefaultR = { dictBifoldable : Any ->
     { dictMonoid : Any ->
       { f : Any ->
         { g : Any ->
           PS.Data.Bifoldable.Module.bifoldr.app(dictBifoldable)
             .app(PS.Control.Semigroupoid.Module.compose
                    .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                    .app(PS.Data.Semigroup.Module.append
                           .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!
                                  .app(Unit)))
                    .app(f))
             .app(PS.Control.Semigroupoid.Module.compose
                    .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                    .app(PS.Data.Semigroup.Module.append
                           .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!
                                  .app(Unit)))
                    .app(g))
             .app(PS.Data.Monoid.Module.mempty.app(dictMonoid))
        }
      }
    }
  };
  @JvmField
  val bifoldMapDefaultL = { dictBifoldable : Any ->
     { dictMonoid : Any ->
       { f : Any ->
         { g : Any ->
           PS.Data.Bifoldable.Module.bifoldl.app(dictBifoldable)
             .app({ m : Any ->
                  { a : Any ->
                    PS.Data.Semigroup.Module.append
                      .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!
                             .app(Unit))
                      .app(m)
                      .app(f.app(a))
                 }
               })
             .app({ m : Any ->
                  { b : Any ->
                    PS.Data.Semigroup.Module.append
                      .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!
                             .app(Unit))
                      .app(m)
                      .app(g.app(b))
                 }
               })
             .app(PS.Data.Monoid.Module.mempty.app(dictMonoid))
        }
      }
    }
  };
  @JvmField
  val bifoldMap = { dict : Any ->
     (dict as Map<String, Any>)["bifoldMap"]!!
  };
  @JvmField
  val bifoldableFlip = { dictBifoldable : Any ->
     PS.Data.Bifoldable.Module.Bifoldable
       .app({ dictMonoid : Any ->
            { r : Any ->
              { l : Any ->
                { v : Any ->
                 val r1 = r;
                   val l1 = l;
                   val p = v;
                   PS.Data.Bifoldable.Module.bifoldMap.app(dictBifoldable)
                     .app(dictMonoid)
                     .app(l1)
                     .app(r1)
                     .app(p);}
             }
           }
         })
       .app({ r : Any ->
            { l : Any ->
              { u : Any ->
                { v : Any ->
                 val r1 = r;
                   val l1 = l;
                   val u1 = u;
                   val p = v;
                   PS.Data.Bifoldable.Module.bifoldl.app(dictBifoldable).app(l1)
                     .app(r1)
                     .app(u1)
                     .app(p);}
             }
           }
         })
       .app({ r : Any ->
         { l : Any ->
           { u : Any ->
             { v : Any ->
              val r1 = r;
                val l1 = l;
                val u1 = u;
                val p = v;
                PS.Data.Bifoldable.Module.bifoldr.app(dictBifoldable).app(l1)
                  .app(r1)
                  .app(u1)
                  .app(p);}
          }
        }
      })
  };
  @JvmField
  val bifoldableWrap = { dictBifoldable : Any ->
     PS.Data.Bifoldable.Module.Bifoldable
       .app({ dictMonoid : Any ->
            { l : Any ->
              { r : Any ->
                { v : Any ->
                 val l1 = l;
                   val r1 = r;
                   val p = v;
                   PS.Data.Bifoldable.Module.bifoldMap.app(dictBifoldable)
                     .app(dictMonoid)
                     .app(l1)
                     .app(r1)
                     .app(p);}
             }
           }
         })
       .app({ l : Any ->
            { r : Any ->
              { u : Any ->
                { v : Any ->
                 val l1 = l;
                   val r1 = r;
                   val u1 = u;
                   val p = v;
                   PS.Data.Bifoldable.Module.bifoldl.app(dictBifoldable).app(l1)
                     .app(r1)
                     .app(u1)
                     .app(p);}
             }
           }
         })
       .app({ l : Any ->
         { r : Any ->
           { u : Any ->
             { v : Any ->
              val l1 = l;
                val r1 = r;
                val u1 = u;
                val p = v;
                PS.Data.Bifoldable.Module.bifoldr.app(dictBifoldable).app(l1)
                  .app(r1)
                  .app(u1)
                  .app(p);}
          }
        }
      })
  };
  @JvmField
  val bifoldlDefault = { dictBifoldable : Any ->
     { f : Any ->
       { g : Any ->
         { z : Any ->
           { p : Any ->
             PS.Data.Newtype.Module.unwrap
               .app(PS.Data.Newtype.Module.newtypeEndo)
               .app(PS.Data.Newtype.Module.unwrap
                      .app(PS.Data.Newtype.Module.newtypeDual)
                      .app(PS.Data.Bifoldable.Module.bifoldMap
                             .app(dictBifoldable)
                             .app(PS.Data.Monoid.Dual.Module.monoidDual
                                    .app(PS.Data.Monoid.Endo.Module.monoidEndo
                                           .app(
                                   PS.Control.Category.Module.categoryFn)))
                             .app(PS.Control.Semigroupoid.Module.compose
                                    .app(
                                      PS.Control.Semigroupoid.Module.semigroupoidFn
                                    )
                                    .app(PS.Data.Monoid.Dual.Module.Dual)
                                    .app(PS.Control.Semigroupoid.Module.compose
                                           .app(
                                             PS.Control.Semigroupoid.Module.semigroupoidFn
                                           )
                                           .app(PS.Data.Monoid.Endo.Module.Endo)
                                           .app(PS.Data.Function.Module.flip
                                                  .app(f))))
                             .app(PS.Control.Semigroupoid.Module.compose
                                    .app(
                                      PS.Control.Semigroupoid.Module.semigroupoidFn
                                    )
                                    .app(PS.Data.Monoid.Dual.Module.Dual)
                                    .app(PS.Control.Semigroupoid.Module.compose
                                           .app(
                                             PS.Control.Semigroupoid.Module.semigroupoidFn
                                           )
                                           .app(PS.Data.Monoid.Endo.Module.Endo)
                                           .app(PS.Data.Function.Module.flip
                                                  .app(g))))
                             .app(p)))
               .app(z)
          }
        }
      }
    }
  };
  @JvmField
  val bifoldrDefault = { dictBifoldable : Any ->
     { f : Any ->
       { g : Any ->
         { z : Any ->
           { p : Any ->
             PS.Data.Newtype.Module.unwrap
               .app(PS.Data.Newtype.Module.newtypeEndo)
               .app(PS.Data.Bifoldable.Module.bifoldMap.app(dictBifoldable)
                      .app(PS.Data.Monoid.Endo.Module.monoidEndo
                             .app(PS.Control.Category.Module.categoryFn))
                      .app(PS.Control.Semigroupoid.Module.compose
                             .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                             .app(PS.Data.Monoid.Endo.Module.Endo)
                             .app(f))
                      .app(PS.Control.Semigroupoid.Module.compose
                             .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                             .app(PS.Data.Monoid.Endo.Module.Endo)
                             .app(g))
                      .app(p))
               .app(z)
          }
        }
      }
    }
  };
  @JvmField val bifoldableProduct = (::__rec_bifoldableProduct)();
  fun __rec_bifoldableProduct(): Any = { dictBifoldable : Any ->
     { dictBifoldable1 : Any ->
       PS.Data.Bifoldable.Module.Bifoldable
         .app({ dictMonoid : Any ->
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
                       PS.Data.Semigroup.Module.append
                         .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!
                                .app(Unit))
                         .app(PS.Data.Bifoldable.Module.bifoldMap
                                .app(dictBifoldable)
                                .app(dictMonoid)
                                .app(l1)
                                .app(r1)
                                .app(f))
                         .app(PS.Data.Bifoldable.Module.bifoldMap
                                .app(dictBifoldable1)
                                .app(dictMonoid)
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
         .app({ l : Any ->
              { r : Any ->
                { u : Any ->
                  { m : Any ->
                    PS.Data.Bifoldable.Module.bifoldlDefault
                      .app(PS.Data.Bifoldable.Module.bifoldableProduct
                             .app(dictBifoldable)
                             .app(dictBifoldable1))
                      .app(l)
                      .app(r)
                      .app(u)
                      .app(m)
                 }
               }
             }
           })
         .app({ l : Any ->
           { r : Any ->
             { u : Any ->
               { m : Any ->
                 PS.Data.Bifoldable.Module.bifoldrDefault
                   .app(PS.Data.Bifoldable.Module.bifoldableProduct
                          .app(dictBifoldable)
                          .app(dictBifoldable1))
                   .app(l)
                   .app(r)
                   .app(u)
                   .app(m)
              }
            }
          }
        })
    }
  };
  @JvmField
  val bifold = { dictBifoldable : Any ->
     { dictMonoid : Any ->
       PS.Data.Bifoldable.Module.bifoldMap.app(dictBifoldable).app(dictMonoid)
         .app(PS.Control.Category.Module.identity
                .app(PS.Control.Category.Module.categoryFn))
         .app(PS.Control.Category.Module.identity
                .app(PS.Control.Category.Module.categoryFn))
    }
  };
  @JvmField
  val biany = { dictBifoldable : Any ->
     { dictBooleanAlgebra : Any ->
       { p : Any ->
         { q : Any ->
           PS.Control.Semigroupoid.Module.compose
             .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
             .app(PS.Data.Newtype.Module.unwrap
                    .app(PS.Data.Newtype.Module.newtypeDisj))
             .app(PS.Data.Bifoldable.Module.bifoldMap.app(dictBifoldable)
                    .app(PS.Data.Monoid.Disj.Module.monoidDisj
                           .app(
                        (dictBooleanAlgebra as Map<String, Any>)["HeytingAlgebra0"]!!
                          .app(Unit)))
                    .app(PS.Control.Semigroupoid.Module.compose
                           .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                           .app(PS.Data.Monoid.Disj.Module.Disj)
                           .app(p))
                    .app(PS.Control.Semigroupoid.Module.compose
                           .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                           .app(PS.Data.Monoid.Disj.Module.Disj)
                           .app(q)))
        }
      }
    }
  };
  @JvmField
  val biall = { dictBifoldable : Any ->
     { dictBooleanAlgebra : Any ->
       { p : Any ->
         { q : Any ->
           PS.Control.Semigroupoid.Module.compose
             .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
             .app(PS.Data.Newtype.Module.unwrap
                    .app(PS.Data.Newtype.Module.newtypeConj))
             .app(PS.Data.Bifoldable.Module.bifoldMap.app(dictBifoldable)
                    .app(PS.Data.Monoid.Conj.Module.monoidConj
                           .app(
                        (dictBooleanAlgebra as Map<String, Any>)["HeytingAlgebra0"]!!
                          .app(Unit)))
                    .app(PS.Control.Semigroupoid.Module.compose
                           .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                           .app(PS.Data.Monoid.Conj.Module.Conj)
                           .app(p))
                    .app(PS.Control.Semigroupoid.Module.compose
                           .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                           .app(PS.Data.Monoid.Conj.Module.Conj)
                           .app(q)))
        }
      }
    }
  };
}