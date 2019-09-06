@file:Suppress("UNCHECKED_CAST")
package PS.Data.Newtype
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val Newtype = { unwrap : Any ->
     { wrap : Any ->
       mapOf(("unwrap" to unwrap),  ("wrap" to wrap))
    }
  };
  @JvmField val wrap = { dict : Any -> (dict as Map<String, Any>)["wrap"]!!};
  @JvmField
  val unwrap = { dict : Any ->
     (dict as Map<String, Any>)["unwrap"]!!
  };
  @JvmField
  val underF2 = { dictFunctor : Any ->
     { dictFunctor1 : Any ->
       { dictNewtype : Any ->
         { dictNewtype1 : Any ->
           { v : Any ->
             { f : Any ->
               PS.Control.Semigroupoid.Module.compose
                 .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                 .app(PS.Control.Semigroupoid.Module.compose
                        .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                        .app(PS.Data.Functor.Module.map.app(dictFunctor1)
                               .app(PS.Data.Newtype.Module.unwrap
                                      .app(dictNewtype1))))
                 .app(PS.Data.Function.Module.on.app(f)
                        .app(PS.Data.Functor.Module.map.app(dictFunctor)
                               .app(PS.Data.Newtype.Module.wrap.app(dictNewtype)
                  )))
            }
          }
        }
      }
    }
  };
  @JvmField
  val underF = { dictFunctor : Any ->
     { dictFunctor1 : Any ->
       { dictNewtype : Any ->
         { dictNewtype1 : Any ->
           { v : Any ->
             { f : Any ->
               PS.Control.Semigroupoid.Module.compose
                 .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                 .app(PS.Data.Functor.Module.map.app(dictFunctor1)
                        .app(PS.Data.Newtype.Module.unwrap.app(dictNewtype1)))
                 .app(PS.Control.Semigroupoid.Module.compose
                        .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                        .app(f)
                        .app(PS.Data.Functor.Module.map.app(dictFunctor)
                               .app(PS.Data.Newtype.Module.wrap.app(dictNewtype)
                  )))
            }
          }
        }
      }
    }
  };
  @JvmField
  val under2 = { dictNewtype : Any ->
     { dictNewtype1 : Any ->
       { v : Any ->
         { f : Any ->
           PS.Control.Semigroupoid.Module.compose
             .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
             .app(PS.Control.Semigroupoid.Module.compose
                    .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                    .app(PS.Data.Newtype.Module.unwrap.app(dictNewtype1)))
             .app(PS.Data.Function.Module.on.app(f)
                    .app(PS.Data.Newtype.Module.wrap.app(dictNewtype)))
        }
      }
    }
  };
  @JvmField
  val under = { dictNewtype : Any ->
     { dictNewtype1 : Any ->
       { v : Any ->
         { f : Any ->
           PS.Control.Semigroupoid.Module.compose
             .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
             .app(PS.Data.Newtype.Module.unwrap.app(dictNewtype1))
             .app(PS.Control.Semigroupoid.Module.compose
                    .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                    .app(f)
                    .app(PS.Data.Newtype.Module.wrap.app(dictNewtype)))
        }
      }
    }
  };
  @JvmField
  val un = { dictNewtype : Any ->
     { v : Any ->
       PS.Data.Newtype.Module.unwrap.app(dictNewtype)
    }
  };
  @JvmField
  val traverse = { dictFunctor : Any ->
     { dictNewtype : Any ->
       { v : Any ->
         { f : Any ->
           PS.Control.Semigroupoid.Module.compose
             .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
             .app(PS.Data.Functor.Module.map.app(dictFunctor)
                    .app(PS.Data.Newtype.Module.wrap.app(dictNewtype)))
             .app(PS.Control.Semigroupoid.Module.compose
                    .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                    .app(f)
                    .app(PS.Data.Newtype.Module.unwrap.app(dictNewtype)))
        }
      }
    }
  };
  @JvmField
  val overF2 = { dictFunctor : Any ->
     { dictFunctor1 : Any ->
       { dictNewtype : Any ->
         { dictNewtype1 : Any ->
           { v : Any ->
             { f : Any ->
               PS.Control.Semigroupoid.Module.compose
                 .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                 .app(PS.Control.Semigroupoid.Module.compose
                        .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                        .app(PS.Data.Functor.Module.map.app(dictFunctor1)
                               .app(PS.Data.Newtype.Module.wrap
                                      .app(dictNewtype1))))
                 .app(PS.Data.Function.Module.on.app(f)
                        .app(PS.Data.Functor.Module.map.app(dictFunctor)
                               .app(PS.Data.Newtype.Module.unwrap
                                      .app(dictNewtype))))
            }
          }
        }
      }
    }
  };
  @JvmField
  val overF = { dictFunctor : Any ->
     { dictFunctor1 : Any ->
       { dictNewtype : Any ->
         { dictNewtype1 : Any ->
           { v : Any ->
             { f : Any ->
               PS.Control.Semigroupoid.Module.compose
                 .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                 .app(PS.Data.Functor.Module.map.app(dictFunctor1)
                        .app(PS.Data.Newtype.Module.wrap.app(dictNewtype1)))
                 .app(PS.Control.Semigroupoid.Module.compose
                        .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                        .app(f)
                        .app(PS.Data.Functor.Module.map.app(dictFunctor)
                               .app(PS.Data.Newtype.Module.unwrap
                                      .app(dictNewtype))))
            }
          }
        }
      }
    }
  };
  @JvmField
  val over2 = { dictNewtype : Any ->
     { dictNewtype1 : Any ->
       { v : Any ->
         { f : Any ->
           PS.Control.Semigroupoid.Module.compose
             .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
             .app(PS.Control.Semigroupoid.Module.compose
                    .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                    .app(PS.Data.Newtype.Module.wrap.app(dictNewtype1)))
             .app(PS.Data.Function.Module.on.app(f)
                    .app(PS.Data.Newtype.Module.unwrap.app(dictNewtype)))
        }
      }
    }
  };
  @JvmField
  val over = { dictNewtype : Any ->
     { dictNewtype1 : Any ->
       { v : Any ->
         { f : Any ->
           PS.Control.Semigroupoid.Module.compose
             .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
             .app(PS.Data.Newtype.Module.wrap.app(dictNewtype1))
             .app(PS.Control.Semigroupoid.Module.compose
                    .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                    .app(f)
                    .app(PS.Data.Newtype.Module.unwrap.app(dictNewtype)))
        }
      }
    }
  };
  @JvmField
  val op = { dictNewtype : Any ->
     PS.Data.Newtype.Module.un.app(dictNewtype)
  };
  @JvmField
  val newtypeMultiplicative = PS.Data.Newtype.Module.Newtype
                                .app({ v : Any ->
                                     when {
                                      else -> {
                                        val a = v;
                                        a;
                                      }
                                    }
                                  })
                                .app(
    PS.Data.Monoid.Multiplicative.Module.Multiplicative);
  @JvmField
  val newtypeLast = PS.Data.Newtype.Module.Newtype
                      .app({ v : Any ->
                           when {
                            else -> {
                              val a = v;
                              a;
                            }
                          }
                        })
                      .app(PS.Data.Semigroup.Last.Module.Last);
  @JvmField
  val newtypeFirst = PS.Data.Newtype.Module.Newtype
                       .app({ v : Any ->
                            when {
                             else -> {
                               val a = v;
                               a;
                             }
                           }
                         })
                       .app(PS.Data.Semigroup.First.Module.First);
  @JvmField
  val newtypeEndo = PS.Data.Newtype.Module.Newtype
                      .app({ v : Any ->
                           when {
                            else -> {
                              val a = v;
                              a;
                            }
                          }
                        })
                      .app(PS.Data.Monoid.Endo.Module.Endo);
  @JvmField
  val newtypeDual = PS.Data.Newtype.Module.Newtype
                      .app({ v : Any ->
                           when {
                            else -> {
                              val a = v;
                              a;
                            }
                          }
                        })
                      .app(PS.Data.Monoid.Dual.Module.Dual);
  @JvmField
  val newtypeDisj = PS.Data.Newtype.Module.Newtype
                      .app({ v : Any ->
                           when {
                            else -> {
                              val a = v;
                              a;
                            }
                          }
                        })
                      .app(PS.Data.Monoid.Disj.Module.Disj);
  @JvmField
  val newtypeConj = PS.Data.Newtype.Module.Newtype
                      .app({ v : Any ->
                           when {
                            else -> {
                              val a = v;
                              a;
                            }
                          }
                        })
                      .app(PS.Data.Monoid.Conj.Module.Conj);
  @JvmField
  val newtypeAdditive = PS.Data.Newtype.Module.Newtype
                          .app({ v : Any ->
                               when {
                                else -> {
                                  val a = v;
                                  a;
                                }
                              }
                            })
                          .app(PS.Data.Monoid.Additive.Module.Additive);
  @JvmField
  val collect = { dictFunctor : Any ->
     { dictNewtype : Any ->
       { v : Any ->
         { f : Any ->
           PS.Control.Semigroupoid.Module.compose
             .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
             .app(PS.Data.Newtype.Module.wrap.app(dictNewtype))
             .app(PS.Control.Semigroupoid.Module.compose
                    .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                    .app(f)
                    .app(PS.Data.Functor.Module.map.app(dictFunctor)
                           .app(PS.Data.Newtype.Module.unwrap.app(dictNewtype)))
          )
        }
      }
    }
  };
  @JvmField
  val alaF = { dictFunctor : Any ->
     { dictFunctor1 : Any ->
       { dictNewtype : Any ->
         { dictNewtype1 : Any ->
           { v : Any ->
             { f : Any ->
               PS.Control.Semigroupoid.Module.compose
                 .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                 .app(PS.Data.Functor.Module.map.app(dictFunctor1)
                        .app(PS.Data.Newtype.Module.unwrap.app(dictNewtype1)))
                 .app(PS.Control.Semigroupoid.Module.compose
                        .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                        .app(f)
                        .app(PS.Data.Functor.Module.map.app(dictFunctor)
                               .app(PS.Data.Newtype.Module.wrap.app(dictNewtype)
                  )))
            }
          }
        }
      }
    }
  };
  @JvmField
  val ala = { dictFunctor : Any ->
     { dictNewtype : Any ->
       { dictNewtype1 : Any ->
         { v : Any ->
           { f : Any ->
             PS.Data.Functor.Module.map.app(dictFunctor)
               .app(PS.Data.Newtype.Module.unwrap.app(dictNewtype))
               .app(f.app(PS.Data.Newtype.Module.wrap.app(dictNewtype1)))
          }
        }
      }
    }
  };
}