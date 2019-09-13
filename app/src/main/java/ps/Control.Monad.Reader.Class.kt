@file:Suppress("UNCHECKED_CAST")

package PS.Control.Monad.Reader.Class
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val MonadAsk = { Monad0 : Any ->
     { ask : Any ->
       mapOf(("Monad0" to Monad0),  ("ask" to ask))
    }
  };
  @JvmField
  val MonadReader = { MonadAsk0 : Any ->
     { local : Any ->
       mapOf(("MonadAsk0" to MonadAsk0),  ("local" to local))
    }
  };
  @JvmField
  val monadAskFun = PS.Control.Monad.Reader.Class.Module.MonadAsk
                      .app({ _ : Any ->
                           PS.Control.Monad.Module.monadFn
                        })
                      .app(PS.Control.Category.Module.identity
                             .app(PS.Control.Category.Module.categoryFn));
  @JvmField
  val monadReaderFun = PS.Control.Monad.Reader.Class.Module.MonadReader
                         .app({ _ : Any ->
                              PS.Control.Monad.Reader.Class.Module.monadAskFun
                           })
                         .app(PS.Control.Semigroupoid.Module.composeFlipped
                                .app(
      PS.Control.Semigroupoid.Module.semigroupoidFn));
  @JvmField val local = { dict : Any -> (dict as Map<String, Any>)["local"]!!};
  @JvmField val ask = { dict : Any -> (dict as Map<String, Any>)["ask"]!!};
  @JvmField
  val asks = { dictMonadAsk : Any ->
     { f : Any ->
       PS.Data.Functor.Module.map
         .app(((((dictMonadAsk as Map<String, Any>)["Monad0"]!!
                   .app(Unit) as Map<String, Any>)["Bind1"]!!
                  .app(Unit) as Map<String, Any>)["Apply0"]!!
                 .app(Unit) as Map<String, Any>)["Functor0"]!!
                .app(Unit))
         .app(f)
         .app(PS.Control.Monad.Reader.Class.Module.ask.app(dictMonadAsk))
    }
  };
}