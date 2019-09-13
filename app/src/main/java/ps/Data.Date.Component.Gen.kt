@file:Suppress("UNCHECKED_CAST")

package PS.Data.Date.Component.Gen
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val genYear = { dictMonadGen : Any ->
     PS.Data.Functor.Module.map
       .app(((((dictMonadGen as Map<String, Any>)["Monad0"]!!
                 .app(Unit) as Map<String, Any>)["Bind1"]!!
                .app(Unit) as Map<String, Any>)["Apply0"]!!
               .app(Unit) as Map<String, Any>)["Functor0"]!!
              .app(Unit))
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Partial.Unsafe.Module.unsafePartial
                     .app({ dictPartial : Any ->
                     PS.Data.Maybe.Module.fromJust.app(Unit)
                  }))
              .app(PS.Data.Enum.Module.toEnum
                     .app(PS.Data.Date.Component.Module.boundedEnumYear)))
       .app(PS.Control.Monad.Gen.Class.Module.chooseInt.app(dictMonadGen)
              .app(1900)
              .app(2100))
  };
  @JvmField
  val genWeekday = { dictMonadGen : Any ->
     PS.Data.Enum.Gen.Module.genBoundedEnum.app(dictMonadGen)
       .app(PS.Data.Date.Component.Module.boundedEnumWeekday)
  };
  @JvmField
  val genMonth = { dictMonadGen : Any ->
     PS.Data.Enum.Gen.Module.genBoundedEnum.app(dictMonadGen)
       .app(PS.Data.Date.Component.Module.boundedEnumMonth)
  };
  @JvmField
  val genDay = { dictMonadGen : Any ->
     PS.Data.Enum.Gen.Module.genBoundedEnum.app(dictMonadGen)
       .app(PS.Data.Date.Component.Module.boundedEnumDay)
  };
}