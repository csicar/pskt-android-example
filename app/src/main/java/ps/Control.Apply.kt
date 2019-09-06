@file:Suppress("UNCHECKED_CAST")
package PS.Control.Apply
import Foreign.PsRuntime.app
object Module  {
  val arrayApply = Foreign.Control.Apply.arrayApply;
  @JvmField
  val Apply = { Functor0 : Any ->
     { apply : Any ->
       mapOf(("Functor0" to Functor0),  ("apply" to apply))
    }
  };
  @JvmField
  val applyFn = PS.Control.Apply.Module.Apply
                  .app({ _ : Any ->
                       PS.Data.Functor.Module.functorFn
                    })
                  .app({ f : Any ->
       { g : Any ->
         { x : Any ->
           f.app(x).app(g.app(x))
        }
      }
    });
  @JvmField
  val applyArray = PS.Control.Apply.Module.Apply
                     .app({ _ : Any ->
                          PS.Data.Functor.Module.functorArray
                       })
                     .app(PS.Control.Apply.Module.arrayApply);
  @JvmField val apply = { dict : Any -> (dict as Map<String, Any>)["apply"]!!};
  @JvmField
  val applyFirst = { dictApply : Any ->
     { a : Any ->
       { b : Any ->
         PS.Control.Apply.Module.apply.app(dictApply)
           .app(PS.Data.Functor.Module.map
                  .app((dictApply as Map<String, Any>)["Functor0"]!!.app(Unit))
                  .app(PS.Data.Function.Module._const)
                  .app(a))
           .app(b)
      }
    }
  };
  @JvmField
  val applySecond = { dictApply : Any ->
     { a : Any ->
       { b : Any ->
         PS.Control.Apply.Module.apply.app(dictApply)
           .app(PS.Data.Functor.Module.map
                  .app((dictApply as Map<String, Any>)["Functor0"]!!.app(Unit))
                  .app(PS.Data.Function.Module._const
                         .app(PS.Control.Category.Module.identity
                                .app(PS.Control.Category.Module.categoryFn)))
                  .app(a))
           .app(b)
      }
    }
  };
  @JvmField
  val lift2 = { dictApply : Any ->
     { f : Any ->
       { a : Any ->
         { b : Any ->
           PS.Control.Apply.Module.apply.app(dictApply)
             .app(PS.Data.Functor.Module.map
                    .app((dictApply as Map<String, Any>)["Functor0"]!!.app(Unit)
                    )
                    .app(f)
                    .app(a))
             .app(b)
        }
      }
    }
  };
  @JvmField
  val lift3 = { dictApply : Any ->
     { f : Any ->
       { a : Any ->
         { b : Any ->
           { c : Any ->
             PS.Control.Apply.Module.apply.app(dictApply)
               .app(PS.Control.Apply.Module.apply.app(dictApply)
                      .app(PS.Data.Functor.Module.map
                             .app((dictApply as Map<String, Any>)["Functor0"]!!
                                    .app(Unit))
                             .app(f)
                             .app(a))
                      .app(b))
               .app(c)
          }
        }
      }
    }
  };
  @JvmField
  val lift4 = { dictApply : Any ->
     { f : Any ->
       { a : Any ->
         { b : Any ->
           { c : Any ->
             { d : Any ->
               PS.Control.Apply.Module.apply.app(dictApply)
                 .app(PS.Control.Apply.Module.apply.app(dictApply)
                        .app(PS.Control.Apply.Module.apply.app(dictApply)
                               .app(PS.Data.Functor.Module.map
                                      .app(
                                        (dictApply as Map<String, Any>)["Functor0"]!!
                                          .app(Unit))
                                      .app(f)
                                      .app(a))
                               .app(b))
                        .app(c))
                 .app(d)
            }
          }
        }
      }
    }
  };
  @JvmField
  val lift5 = { dictApply : Any ->
     { f : Any ->
       { a : Any ->
         { b : Any ->
           { c : Any ->
             { d : Any ->
               { e : Any ->
                 PS.Control.Apply.Module.apply.app(dictApply)
                   .app(PS.Control.Apply.Module.apply.app(dictApply)
                          .app(PS.Control.Apply.Module.apply.app(dictApply)
                                 .app(PS.Control.Apply.Module.apply
                                        .app(dictApply)
                                        .app(PS.Data.Functor.Module.map
                                               .app(
                                                 (dictApply as Map<String, Any>)["Functor0"]!!
                                                   .app(Unit))
                                               .app(f)
                                               .app(a))
                                        .app(b))
                                 .app(c))
                          .app(d))
                   .app(e)
              }
            }
          }
        }
      }
    }
  };
}