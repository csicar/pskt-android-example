@file:Suppress("UNCHECKED_CAST")
package PS.Test.Main
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val main = { _ : Any ->
    PS.Effect.Class.Console.Module.log
      .app(PS.Effect.Class.Module.monadEffectEffect)
      .app("asdjkj")()
      PS.Effect.Class.Console.Module.log
        .app(PS.Effect.Class.Module.monadEffectEffect)
        .app("You should add some tests.")};
}