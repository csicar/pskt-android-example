@file:Suppress("UNCHECKED_CAST")

package PS.Data.DateTime.Gen
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val genDateTime = { dictMonadGen : Any ->
     PS.Control.Apply.Module.apply
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
              .app(PS.Data.DateTime.Module.DateTime)
              .app(PS.Data.Date.Gen.Module.genDate.app(dictMonadGen)))
       .app(PS.Data.Time.Gen.Module.genTime.app(dictMonadGen))
  };
}