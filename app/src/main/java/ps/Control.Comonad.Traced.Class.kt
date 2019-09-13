@file:Suppress("UNCHECKED_CAST")

package PS.Control.Comonad.Traced.Class
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val ComonadTraced = { Comonad0 : Any ->
     { track : Any ->
       mapOf(("Comonad0" to Comonad0),  ("track" to track))
    }
  };
  @JvmField val track = { dict : Any -> (dict as Map<String, Any>)["track"]!!};
  @JvmField
  val tracks = { dictComonadTraced : Any ->
     { f : Any ->
       { w : Any ->
         PS.Control.Comonad.Traced.Class.Module.track.app(dictComonadTraced)
           .app(PS.Data.Function.Module.apply.app(f)
                  .app(PS.Control.Comonad.Module.extract
                         .app(
                           (dictComonadTraced as Map<String, Any>)["Comonad0"]!!
                             .app(Unit))
                         .app(w)))
           .app(w)
      }
    }
  };
  @JvmField
  val listens = { dictFunctor : Any ->
     { f : Any ->
       { v : Any ->
        val f1 = f;
          val tr = v;
          PS.Control.Comonad.Traced.Trans.Module.TracedT
            .app(PS.Data.Functor.Module.map.app(dictFunctor)
                   .app({ g : Any ->
                        { t : Any ->
                          PS.Data.Tuple.Module.Tuple.app(g.app(t))
                            .app(f1.app(t))
                       }
                     })
                   .app(tr));}
    }
  };
  @JvmField
  val listen = { dictFunctor : Any ->
     { v : Any ->
      val tr = v;
        PS.Control.Comonad.Traced.Trans.Module.TracedT
          .app(PS.Data.Functor.Module.map.app(dictFunctor)
                 .app({ f : Any ->
                      { t : Any ->
                        PS.Data.Tuple.Module.Tuple.app(f.app(t)).app(t)
                     }
                   })
                 .app(tr));}
  };
  @JvmField
  val comonadTracedTracedT = { dictComonad : Any ->
     { dictMonoid : Any ->
       PS.Control.Comonad.Traced.Class.Module.ComonadTraced
         .app({ _ : Any ->
              PS.Control.Comonad.Traced.Trans.Module.comonadTracedT
                .app(dictComonad)
                .app(dictMonoid)
           })
         .app({ t : Any ->
           { v : Any ->
            val t1 = t;
              val tr = v;
              PS.Control.Comonad.Module.extract.app(dictComonad).app(tr)
                .app(t1);}
        })
    }
  };
  @JvmField
  val censor = { dictFunctor : Any ->
     { f : Any ->
       { v : Any ->
        val f1 = f;
          val tr = v;
          PS.Control.Comonad.Traced.Trans.Module.TracedT
            .app(PS.Data.Functor.Module.map.app(dictFunctor)
                   .app({ v1 : Any ->
                        PS.Control.Semigroupoid.Module.composeFlipped
                          .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                          .app(f1)
                          .app(v1)
                     })
                   .app(tr));}
    }
  };
}