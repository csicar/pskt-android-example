@file:Suppress("UNCHECKED_CAST")

package PS.PSCI.Support
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val Eval = { eval : Any -> mapOf(("eval" to eval))};
  @JvmField
  val evalShow = { dictShow : Any ->
     PS.PSCI.Support.Module.Eval
       .app(PS.Effect.Console.Module.logShow.app(dictShow))
  };
  @JvmField val eval = { dict : Any -> (dict as Map<String, Any>)["eval"]!!};
  @JvmField
  val evalEffect = { dictEval : Any ->
     PS.PSCI.Support.Module.Eval
       .app({ x : Any ->
         PS.Control.Bind.Module.bind.app(PS.Effect.Module.bindEffect).app(x)
           .app(PS.PSCI.Support.Module.eval.app(dictEval))
      })
  };
}