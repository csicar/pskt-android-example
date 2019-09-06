@file:Suppress("UNCHECKED_CAST")
package PS.Data.Time.Gen
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val genTime = { dictMonadGen : Any ->
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
              .app(PS.Control.Apply.Module.apply
                     .app((((dictMonadGen as Map<String, Any>)["Monad0"]!!
                              .app(Unit) as Map<String, Any>)["Bind1"]!!
                             .app(Unit) as Map<String, Any>)["Apply0"]!!
                            .app(Unit))
                     .app(PS.Data.Functor.Module.map
                            .app(
                              ((((dictMonadGen as Map<String, Any>)["Monad0"]!!
                                   .app(Unit) as Map<String, Any>)["Bind1"]!!
                                  .app(Unit) as Map<String, Any>)["Apply0"]!!
                                 .app(Unit) as Map<String, Any>)["Functor0"]!!
                                .app(Unit))
                            .app(PS.Data.Time.Module.Time)
                            .app(PS.Data.Time.Component.Gen.Module.genHour
                                   .app(dictMonadGen)))
                     .app(PS.Data.Time.Component.Gen.Module.genMinute
                            .app(dictMonadGen)))
              .app(PS.Data.Time.Component.Gen.Module.genSecond.app(dictMonadGen)
         ))
       .app(PS.Data.Time.Component.Gen.Module.genMillisecond.app(dictMonadGen))
  };
}