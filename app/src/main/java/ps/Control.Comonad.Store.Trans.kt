@file:Suppress("UNCHECKED_CAST")

package PS.Control.Comonad.Store.Trans
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val StoreT = { x : Any -> x};
  @JvmField val runStoreT = { v : Any ->val s = v; s;};
  @JvmField
  val newtypeStoreT = PS.Data.Newtype.Module.Newtype
                        .app({ n : Any ->
                            val a = n;
                              a;})
                        .app(PS.Control.Comonad.Store.Trans.Module.StoreT);
  @JvmField
  val functorStoreT = { dictFunctor : Any ->
     PS.Data.Functor.Module.Functor
       .app({ f : Any ->
         { v : Any ->
           when {
            (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
              val f1 = f;
              val w = v.value0;
              val s = v.value1;
              PS.Data.Function.Module.apply
                .app(PS.Control.Comonad.Store.Trans.Module.StoreT)
                .app(PS.Data.Tuple.Module.Tuple
                       .app(PS.Data.Functor.Module.map.app(dictFunctor)
                              .app({ h : Any ->
                                   PS.Control.Semigroupoid.Module.composeFlipped
                                     .app(
                                       PS.Control.Semigroupoid.Module.semigroupoidFn
                                     )
                                     .app(h)
                                     .app(f1)
                                })
                              .app(w))
                       .app(s));
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      })
  };
  @JvmField
  val extendStoreT = { dictExtend : Any ->
     PS.Control.Extend.Module.Extend
       .app({ _ : Any ->
            PS.Control.Comonad.Store.Trans.Module.functorStoreT
              .app((dictExtend as Map<String, Any>)["Functor0"]!!.app(Unit))
         })
       .app({ f : Any ->
         { v : Any ->
           when {
            (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
              val f1 = f;
              val w = v.value0;
              val s = v.value1;
              PS.Data.Function.Module.apply
                .app(PS.Control.Comonad.Store.Trans.Module.StoreT)
                .app(PS.Data.Tuple.Module.Tuple
                       .app(PS.Control.Extend.Module.extend.app(dictExtend)
                              .app({ w_tick : Any ->
                                   { s_tick : Any ->
                                     PS.Data.Function.Module.apply.app(f1)
                                       .app(PS.Data.Function.Module.apply
                                              .app(
                                                PS.Control.Comonad.Store.Trans.Module.StoreT
                                              )
                                              .app(PS.Data.Tuple.Module.Tuple
                                                     .app(w_tick)
                                                     .app(s_tick)))
                                  }
                                })
                              .app(w))
                       .app(s));
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      })
  };
  @JvmField
  val comonadTransStoreT = PS.Control.Comonad.Trans.Class.Module.ComonadTrans
                             .app({ dictComonad : Any ->
       { v : Any ->
         when {
          (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
            val w = v.value0;
            val s = v.value1;
            PS.Data.Functor.Module.map
              .app(((dictComonad as Map<String, Any>)["Extend0"]!!
                      .app(Unit) as Map<String, Any>)["Functor0"]!!
                     .app(Unit))
              .app({ v1 : Any ->
                   PS.Data.Function.Module.apply.app(v1).app(s)
                })
              .app(w);
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val comonadStoreT = { dictComonad : Any ->
     PS.Control.Comonad.Module.Comonad
       .app({ _ : Any ->
            PS.Control.Comonad.Store.Trans.Module.extendStoreT
              .app((dictComonad as Map<String, Any>)["Extend0"]!!.app(Unit))
         })
       .app({ v : Any ->
         when {
          (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
            val w = v.value0;
            val s = v.value1;
            PS.Control.Comonad.Module.extract.app(dictComonad).app(w).app(s);
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      })
  };
}