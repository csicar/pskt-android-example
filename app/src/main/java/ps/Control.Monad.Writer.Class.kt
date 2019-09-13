@file:Suppress("UNCHECKED_CAST")

package PS.Control.Monad.Writer.Class
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val MonadTell = { Monad0 : Any ->
     { tell : Any ->
       mapOf(("Monad0" to Monad0),  ("tell" to tell))
    }
  };
  @JvmField
  val MonadWriter = { MonadTell0 : Any ->
     { listen : Any ->
       { pass : Any ->
         mapOf(("MonadTell0" to MonadTell0),  ("listen" to listen),  
          ("pass" to pass))
      }
    }
  };
  @JvmField val tell = { dict : Any -> (dict as Map<String, Any>)["tell"]!!};
  @JvmField val pass = { dict : Any -> (dict as Map<String, Any>)["pass"]!!};
  @JvmField
  val listen = { dict : Any ->
     (dict as Map<String, Any>)["listen"]!!
  };
  @JvmField
  val listens = { dictMonadWriter : Any ->
     { f : Any ->
       { m : Any ->
         PS.Control.Bind.Module.bind
           .app((((dictMonadWriter as Map<String, Any>)["MonadTell0"]!!
                    .app(Unit) as Map<String, Any>)["Monad0"]!!
                   .app(Unit) as Map<String, Any>)["Bind1"]!!
                  .app(Unit))
           .app(PS.Control.Monad.Writer.Class.Module.listen.app(dictMonadWriter)
                  .app(m))
           .app({ v : Any ->
             when {
              (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                val a = v.value0;
                val w = v.value1;
                PS.Data.Function.Module.apply
                  .app(PS.Control.Applicative.Module.pure
                         .app(
                      (((dictMonadWriter as Map<String, Any>)["MonadTell0"]!!
                          .app(Unit) as Map<String, Any>)["Monad0"]!!
                         .app(Unit) as Map<String, Any>)["Applicative0"]!!
                        .app(Unit)))
                  .app(PS.Data.Tuple.Module.Tuple.app(a).app(f.app(w)));
              }
              else -> (error("Error in Pattern Match") as Any)
            }
          })
      }
    }
  };
  @JvmField
  val censor = { dictMonadWriter : Any ->
     { f : Any ->
       { m : Any ->
         PS.Control.Monad.Writer.Class.Module.pass.app(dictMonadWriter)
           .app(PS.Control.Bind.Module.bind
                  .app((((dictMonadWriter as Map<String, Any>)["MonadTell0"]!!
                           .app(Unit) as Map<String, Any>)["Monad0"]!!
                          .app(Unit) as Map<String, Any>)["Bind1"]!!
                         .app(Unit))
                  .app(m)
                  .app({ v : Any ->
              val a = v;
                PS.Data.Function.Module.apply
                  .app(PS.Control.Applicative.Module.pure
                         .app(
                      (((dictMonadWriter as Map<String, Any>)["MonadTell0"]!!
                          .app(Unit) as Map<String, Any>)["Monad0"]!!
                         .app(Unit) as Map<String, Any>)["Applicative0"]!!
                        .app(Unit)))
                  .app(PS.Data.Tuple.Module.Tuple.app(a).app(f));}))
      }
    }
  };
}