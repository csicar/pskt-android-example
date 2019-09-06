@file:Suppress("UNCHECKED_CAST")
package PS.Control.Comonad.Env.Trans
import Foreign.PsRuntime.app
object Module  {
  @JvmField val EnvT = { x : Any -> x};
  @JvmField
  val withEnvT = { f : Any ->
     { v : Any ->
       when {
        (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
          val f1 = f;
          val e = v.value0;
          val x = v.value1;
          PS.Data.Function.Module.apply
            .app(PS.Control.Comonad.Env.Trans.Module.EnvT)
            .app(PS.Data.Tuple.Module.Tuple.app(f1.app(e)).app(x));
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField val runEnvT = { v : Any -> when { else -> { val x = v; x; } }};
  @JvmField
  val newtypeEnvT = PS.Data.Newtype.Module.Newtype
                      .app({ n : Any ->
                           when {
                            else -> {
                              val a = n;
                              a;
                            }
                          }
                        })
                      .app(PS.Control.Comonad.Env.Trans.Module.EnvT);
  @JvmField
  val mapEnvT = { f : Any ->
     { v : Any ->
       when {
        (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
          val f1 = f;
          val e = v.value0;
          val x = v.value1;
          PS.Data.Function.Module.apply
            .app(PS.Control.Comonad.Env.Trans.Module.EnvT)
            .app(PS.Data.Tuple.Module.Tuple.app(e).app(f1.app(x)));
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val functorEnvT = { dictFunctor : Any ->
     PS.Data.Functor.Module.Functor
       .app({ f : Any ->
         { v : Any ->
           when {
            (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
              val f1 = f;
              val e = v.value0;
              val x = v.value1;
              PS.Data.Function.Module.apply
                .app(PS.Control.Comonad.Env.Trans.Module.EnvT)
                .app(PS.Data.Tuple.Module.Tuple.app(e)
                       .app(PS.Data.Functor.Module.map.app(dictFunctor).app(f1)
                              .app(x)));
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      })
  };
  @JvmField
  val foldableEnvT = { dictFoldable : Any ->
     PS.Data.Foldable.Module.Foldable
       .app({ dictMonoid : Any ->
            { fn : Any ->
              { v : Any ->
                when {
                 (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                   val fn1 = fn;
                   val x = v.value1;
                   PS.Data.Foldable.Module.foldMap.app(dictFoldable)
                     .app(dictMonoid)
                     .app(fn1)
                     .app(x);
                 }
                 else -> (error("Error in Pattern Match") as Any)
               }
             }
           }
         })
       .app({ fn : Any ->
            { a : Any ->
              { v : Any ->
                when {
                 (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                   val fn1 = fn;
                   val a1 = a;
                   val x = v.value1;
                   PS.Data.Foldable.Module.foldl.app(dictFoldable).app(fn1)
                     .app(a1)
                     .app(x);
                 }
                 else -> (error("Error in Pattern Match") as Any)
               }
             }
           }
         })
       .app({ fn : Any ->
         { a : Any ->
           { v : Any ->
             when {
              (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                val fn1 = fn;
                val a1 = a;
                val x = v.value1;
                PS.Data.Foldable.Module.foldr.app(dictFoldable).app(fn1).app(a1)
                  .app(x);
              }
              else -> (error("Error in Pattern Match") as Any)
            }
          }
        }
      })
  };
  @JvmField
  val traversableEnvT = { dictTraversable : Any ->
     PS.Data.Traversable.Module.Traversable
       .app({ _ : Any ->
            PS.Control.Comonad.Env.Trans.Module.foldableEnvT
              .app((dictTraversable as Map<String, Any>)["Foldable1"]!!
                     .app(Unit))
         })
       .app({ _ : Any ->
            PS.Control.Comonad.Env.Trans.Module.functorEnvT
              .app((dictTraversable as Map<String, Any>)["Functor0"]!!.app(Unit)
           )
         })
       .app({ dictApplicative : Any ->
            { v : Any ->
              when {
               (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                 val a = v.value0;
                 val x = v.value1;
                 PS.Data.Functor.Module.map
                   .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                           .app(Unit) as Map<String, Any>)["Functor0"]!!
                          .app(Unit))
                   .app(PS.Data.Functor.Module.map
                          .app(PS.Data.Functor.Module.functorFn)
                          .app(PS.Control.Comonad.Env.Trans.Module.EnvT)
                          .app(PS.Data.Tuple.Module.Tuple.app(a)))
                   .app(PS.Data.Traversable.Module.sequence.app(dictTraversable)
                          .app(dictApplicative)
                          .app(x));
               }
               else -> (error("Error in Pattern Match") as Any)
             }
           }
         })
       .app({ dictApplicative : Any ->
         { f : Any ->
           { v : Any ->
             when {
              (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                val f1 = f;
                val a = v.value0;
                val x = v.value1;
                PS.Data.Functor.Module.map
                  .app(((dictApplicative as Map<String, Any>)["Apply0"]!!
                          .app(Unit) as Map<String, Any>)["Functor0"]!!
                         .app(Unit))
                  .app(PS.Data.Functor.Module.map
                         .app(PS.Data.Functor.Module.functorFn)
                         .app(PS.Control.Comonad.Env.Trans.Module.EnvT)
                         .app(PS.Data.Tuple.Module.Tuple.app(a)))
                  .app(PS.Data.Traversable.Module.traverse.app(dictTraversable)
                         .app(dictApplicative)
                         .app(f1)
                         .app(x));
              }
              else -> (error("Error in Pattern Match") as Any)
            }
          }
        }
      })
  };
  @JvmField
  val extendEnvT = { dictExtend : Any ->
     PS.Control.Extend.Module.Extend
       .app({ _ : Any ->
            PS.Control.Comonad.Env.Trans.Module.functorEnvT
              .app((dictExtend as Map<String, Any>)["Functor0"]!!.app(Unit))
         })
       .app({ f : Any ->
         { v : Any ->
           when {
            (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
              val f1 = f;
              val e = v.value0;
              val x = v.value1;
              PS.Data.Function.Module.apply
                .app(PS.Control.Comonad.Env.Trans.Module.EnvT)
                .app(PS.Data.Tuple.Module.Tuple.app(e)
                       .app(PS.Data.Functor.Module.map
                              .app(
                                (dictExtend as Map<String, Any>)["Functor0"]!!
                                  .app(Unit))
                              .app(f1)
                              .app(PS.Control.Extend.Module.extend
                                     .app(dictExtend)
                                     .app(
                                       PS.Control.Semigroupoid.Module.composeFlipped
                                         .app(
                                           PS.Control.Semigroupoid.Module.semigroupoidFn
                                         )
                                         .app(PS.Data.Tuple.Module.Tuple.app(e))
                                         .app(
                                         PS.Control.Comonad.Env.Trans.Module.EnvT
                                       ))
                                     .app(x))));
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      })
  };
  @JvmField
  val comonadTransEnvT = PS.Control.Comonad.Trans.Class.Module.ComonadTrans
                           .app({ dictComonad : Any ->
       { v : Any ->
         when {
          (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
            val e = v.value0;
            val x = v.value1;
            x;
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val comonadEnvT = { dictComonad : Any ->
     PS.Control.Comonad.Module.Comonad
       .app({ _ : Any ->
            PS.Control.Comonad.Env.Trans.Module.extendEnvT
              .app((dictComonad as Map<String, Any>)["Extend0"]!!.app(Unit))
         })
       .app({ v : Any ->
         when {
          (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
            val e = v.value0;
            val x = v.value1;
            PS.Control.Comonad.Module.extract.app(dictComonad).app(x);
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      })
  };
}