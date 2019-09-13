@file:Suppress("UNCHECKED_CAST")

package PS.Data.Time.Component.Gen
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val genSecond = { dictMonadGen : Any ->
     PS.Data.Enum.Gen.Module.genBoundedEnum.app(dictMonadGen)
       .app(PS.Data.Time.Component.Module.boundedEnumSecond)
  };
  @JvmField
  val genMinute = { dictMonadGen : Any ->
     PS.Data.Enum.Gen.Module.genBoundedEnum.app(dictMonadGen)
       .app(PS.Data.Time.Component.Module.boundedEnumMinute)
  };
  @JvmField
  val genMillisecond = { dictMonadGen : Any ->
     PS.Data.Enum.Gen.Module.genBoundedEnum.app(dictMonadGen)
       .app(PS.Data.Time.Component.Module.boundedEnumMillisecond)
  };
  @JvmField
  val genHour = { dictMonadGen : Any ->
     PS.Data.Enum.Gen.Module.genBoundedEnum.app(dictMonadGen)
       .app(PS.Data.Time.Component.Module.boundedEnumHour)
  };
}