@file:Suppress("UNCHECKED_CAST")
package PS.Data.Date.Gen
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val genDate = { dictMonadGen : Any ->
     PS.Control.Apply.Module.apply
       .app((((dictMonadGen as Map<String, Any>)["Monad0"]!!
                .app(Unit) as Map<String, Any>)["Bind1"]!!
               .app(Unit) as Map<String, Any>)["Apply0"]!!
              .app(Unit))
       .app(PS.Control.Apply.Module.apply
              .app((((dictMonadGen as Map<String, Any>)["Monad0"]!!
                       .app(Unit) as Map<String, Any>)["Bind1"]!!
                      .app(Unit) as Map<String, Any>)["Apply0"]!!
                     .app(Unit))
              .app(PS.Data.Functor.Module.map
                     .app(((((dictMonadGen as Map<String, Any>)["Monad0"]!!
                               .app(Unit) as Map<String, Any>)["Bind1"]!!
                              .app(Unit) as Map<String, Any>)["Apply0"]!!
                             .app(Unit) as Map<String, Any>)["Functor0"]!!
                            .app(Unit))
                     .app(PS.Data.Date.Module.canonicalDate)
                     .app(PS.Data.Date.Component.Gen.Module.genYear
                            .app(dictMonadGen)))
              .app(PS.Data.Date.Component.Gen.Module.genMonth.app(dictMonadGen))
       )
       .app(PS.Data.Date.Component.Gen.Module.genDay.app(dictMonadGen))
  };
}