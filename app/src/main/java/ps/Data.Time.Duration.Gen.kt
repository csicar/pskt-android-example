@file:Suppress("UNCHECKED_CAST")
package PS.Data.Time.Duration.Gen
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val genSeconds = { dictMonadGen : Any ->
     PS.Data.Functor.Module.map
       .app(((((dictMonadGen as Map<String, Any>)["Monad0"]!!
                 .app(Unit) as Map<String, Any>)["Bind1"]!!
                .app(Unit) as Map<String, Any>)["Apply0"]!!
               .app(Unit) as Map<String, Any>)["Functor0"]!!
              .app(Unit))
       .app(PS.Data.Time.Duration.Module.Seconds)
       .app(PS.Control.Monad.Gen.Class.Module.chooseFloat.app(dictMonadGen)
              .app(0.0)
              .app(600.0))
  };
  @JvmField
  val genMinutes = { dictMonadGen : Any ->
     PS.Data.Functor.Module.map
       .app(((((dictMonadGen as Map<String, Any>)["Monad0"]!!
                 .app(Unit) as Map<String, Any>)["Bind1"]!!
                .app(Unit) as Map<String, Any>)["Apply0"]!!
               .app(Unit) as Map<String, Any>)["Functor0"]!!
              .app(Unit))
       .app(PS.Data.Time.Duration.Module.Minutes)
       .app(PS.Control.Monad.Gen.Class.Module.chooseFloat.app(dictMonadGen)
              .app(0.0)
              .app(600.0))
  };
  @JvmField
  val genMilliseconds = { dictMonadGen : Any ->
     PS.Data.Functor.Module.map
       .app(((((dictMonadGen as Map<String, Any>)["Monad0"]!!
                 .app(Unit) as Map<String, Any>)["Bind1"]!!
                .app(Unit) as Map<String, Any>)["Apply0"]!!
               .app(Unit) as Map<String, Any>)["Functor0"]!!
              .app(Unit))
       .app(PS.Data.Time.Duration.Module.Milliseconds)
       .app(PS.Control.Monad.Gen.Class.Module.chooseFloat.app(dictMonadGen)
              .app(0.0)
              .app(600000.0))
  };
  @JvmField
  val genHours = { dictMonadGen : Any ->
     PS.Data.Functor.Module.map
       .app(((((dictMonadGen as Map<String, Any>)["Monad0"]!!
                 .app(Unit) as Map<String, Any>)["Bind1"]!!
                .app(Unit) as Map<String, Any>)["Apply0"]!!
               .app(Unit) as Map<String, Any>)["Functor0"]!!
              .app(Unit))
       .app(PS.Data.Time.Duration.Module.Hours)
       .app(PS.Control.Monad.Gen.Class.Module.chooseFloat.app(dictMonadGen)
              .app(0.0)
              .app(240.0))
  };
  @JvmField
  val genDays = { dictMonadGen : Any ->
     PS.Data.Functor.Module.map
       .app(((((dictMonadGen as Map<String, Any>)["Monad0"]!!
                 .app(Unit) as Map<String, Any>)["Bind1"]!!
                .app(Unit) as Map<String, Any>)["Apply0"]!!
               .app(Unit) as Map<String, Any>)["Functor0"]!!
              .app(Unit))
       .app(PS.Data.Time.Duration.Module.Days)
       .app(PS.Control.Monad.Gen.Class.Module.chooseFloat.app(dictMonadGen)
              .app(0.0)
              .app(42.0))
  };
}