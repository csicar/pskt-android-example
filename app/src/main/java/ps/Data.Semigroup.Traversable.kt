@file:Suppress("UNCHECKED_CAST")
package PS.Data.Semigroup.Traversable
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val Traversable1 = { Foldable10 : Any ->
     { Traversable1 : Any ->
       { sequence1 : Any ->
         { traverse1 : Any ->
           mapOf(("Foldable10" to Foldable10),  
            ("Traversable1" to Traversable1),  ("sequence1" to sequence1),  
            ("traverse1" to traverse1))
        }
      }
    }
  };
  @JvmField
  val traverse1 = { dict : Any ->
     (dict as Map<String, Any>)["traverse1"]!!
  };
  @JvmField
  val sequence1Default = { dictTraversable1 : Any ->
     { dictApply : Any ->
       PS.Data.Semigroup.Traversable.Module.traverse1.app(dictTraversable1)
         .app(dictApply)
         .app(PS.Control.Category.Module.identity
                .app(PS.Control.Category.Module.categoryFn))
    }
  };
  @JvmField val traversableDual = (::__rec_traversableDual)();
  fun __rec_traversableDual(): Any = PS.Data.Semigroup.Traversable.Module.Traversable1
                                       .app({ _ : Any ->
                                            PS.Data.Semigroup.Foldable.Module.foldableDual
                                         })
                                       .app({ _ : Any ->
                                            PS.Data.Traversable.Module.traversableDual
                                         })
                                       .app({ dictApply : Any ->
                                            PS.Data.Semigroup.Traversable.Module.sequence1Default
                                              .app(
                                                PS.Data.Semigroup.Traversable.Module.traversableDual
                                              )
                                              .app(dictApply)
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
                .app(PS.Data.Monoid.Dual.Module.Dual)
                .app(f1.app(x));
            }
          }
        }
      }
    });
  @JvmField
  val traversableMultiplicative = (::__rec_traversableMultiplicative)();
  fun __rec_traversableMultiplicative(): Any = PS.Data.Semigroup.Traversable.Module.Traversable1
                                                 .app({ _ : Any ->
                                                      PS.Data.Semigroup.Foldable.Module.foldableMultiplicative
                                                   })
                                                 .app({ _ : Any ->
                                                      PS.Data.Traversable.Module.traversableMultiplicative
                                                   })
                                                 .app({ dictApply : Any ->
                                                      PS.Data.Semigroup.Traversable.Module.sequence1Default
                                                        .app(
                                                          PS.Data.Semigroup.Traversable.Module.traversableMultiplicative
                                                        )
                                                        .app(dictApply)
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
                .app(PS.Data.Monoid.Multiplicative.Module.Multiplicative)
                .app(f1.app(x));
            }
          }
        }
      }
    });
  @JvmField
  val sequence1 = { dict : Any ->
     (dict as Map<String, Any>)["sequence1"]!!
  };
  @JvmField
  val traverse1Default = { dictTraversable1 : Any ->
     { dictApply : Any ->
       { f : Any ->
         { ta : Any ->
           PS.Data.Semigroup.Traversable.Module.sequence1.app(dictTraversable1)
             .app(dictApply)
             .app(PS.Data.Functor.Module.map
                    .app(
                      ((dictTraversable1 as Map<String, Any>)["Traversable1"]!!
                         .app(Unit) as Map<String, Any>)["Functor0"]!!
                        .app(Unit))
                    .app(f)
                    .app(ta))
        }
      }
    }
  };
}