@file:Suppress("UNCHECKED_CAST")

package PS.Test.Main
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val main = /* defer **/{
    PS.Effect.Class.Console.Module.log
      .app(PS.Effect.Class.Module.monadEffectEffect)
      .app("asdjkj")
      .appRun();
    PS.Effect.Class.Console.Module.log
      .app(PS.Effect.Class.Module.monadEffectEffect)
      .app("You should add some tests.")
      .appRun();
  };
}