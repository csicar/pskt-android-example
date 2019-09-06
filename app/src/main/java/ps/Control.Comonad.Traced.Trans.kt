@file:Suppress("UNCHECKED_CAST")
package PS.Control.Comonad.Traced.Trans
import Foreign.PsRuntime.app
object Module  {
  @JvmField val TracedT = { x : Any -> x};
  @JvmField val runTracedT = { v : Any -> when { else -> { val w = v; w; } }};
  @JvmField
  val newtypeTracedT = PS.Data.Newtype.Module.Newtype
                         .app({ n : Any ->
                              when {
                               else -> {
                                 val a = n;
                                 a;
                               }
                             }
                           })
                         .app(PS.Control.Comonad.Traced.Trans.Module.TracedT);
  @JvmField
  val functorTracedT = { dictFunctor : Any ->
     PS.Data.Functor.Module.Functor
       .app({ f : Any ->
         { v : Any ->
           when {
            else -> {
              val f1 = f;
              val w = v;
              PS.Control.Comonad.Traced.Trans.Module.TracedT
                .app(PS.Data.Functor.Module.map.app(dictFunctor)
                       .app({ g : Any ->
                            { t : Any ->
                              PS.Data.Function.Module.apply.app(f1)
                                .app(g.app(t))
                           }
                         })
                       .app(w));
            }
          }
        }
      })
  };
  @JvmField
  val extendTracedT = { dictExtend : Any ->
     { dictSemigroup : Any ->
       PS.Control.Extend.Module.Extend
         .app({ _ : Any ->
              PS.Control.Comonad.Traced.Trans.Module.functorTracedT
                .app((dictExtend as Map<String, Any>)["Functor0"]!!.app(Unit))
           })
         .app({ f : Any ->
           { v : Any ->
             when {
              else -> {
                val f1 = f;
                val w = v;
                PS.Control.Comonad.Traced.Trans.Module.TracedT
                  .app(PS.Control.Extend.Module.extend.app(dictExtend)
                         .app({ w_tick : Any ->
                              { t : Any ->
                                PS.Data.Function.Module.apply.app(f1)
                                  .app(
                                 PS.Control.Comonad.Traced.Trans.Module.TracedT
                                   .app(PS.Data.Functor.Module.map
                                          .app(
                                            (dictExtend as Map<String, Any>)["Functor0"]!!
                                              .app(Unit))
                                          .app({ h : Any ->
                                               { t_tick : Any ->
                                                 PS.Data.Function.Module.apply
                                                   .app(h)
                                                   .app(
                                                  PS.Data.Semigroup.Module.append
                                                    .app(dictSemigroup)
                                                    .app(t)
                                                    .app(t_tick))
                                              }
                                            })
                                          .app(w_tick)))
                             }
                           })
                         .app(w));
              }
            }
          }
        })
    }
  };
  @JvmField
  val comonadTransTracedT = { dictMonoid : Any ->
     PS.Control.Comonad.Trans.Class.Module.ComonadTrans
       .app({ dictComonad : Any ->
         { v : Any ->
           when {
            else -> {
              val w = v;
              PS.Data.Functor.Module.map
                .app(((dictComonad as Map<String, Any>)["Extend0"]!!
                        .app(Unit) as Map<String, Any>)["Functor0"]!!
                       .app(Unit))
                .app({ f : Any ->
                     f.app(PS.Data.Monoid.Module.mempty.app(dictMonoid))
                  })
                .app(w);
            }
          }
        }
      })
  };
  @JvmField
  val comonadTracedT = { dictComonad : Any ->
     { dictMonoid : Any ->
       PS.Control.Comonad.Module.Comonad
         .app({ _ : Any ->
              PS.Control.Comonad.Traced.Trans.Module.extendTracedT
                .app((dictComonad as Map<String, Any>)["Extend0"]!!.app(Unit))
                .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!.app(Unit))
           })
         .app({ v : Any ->
           when {
            else -> {
              val w = v;
              PS.Control.Comonad.Module.extract.app(dictComonad).app(w)
                .app(PS.Data.Monoid.Module.mempty.app(dictMonoid));
            }
          }
        })
    }
  };
}