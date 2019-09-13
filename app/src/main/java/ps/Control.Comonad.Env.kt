@file:Suppress("UNCHECKED_CAST")

package PS.Control.Comonad.Env
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val withEnv = PS.Control.Comonad.Env.Trans.Module.withEnvT;
  @JvmField
  val runEnv = { v : Any ->
    val x = v;
      PS.Data.Functor.Module.map.app(PS.Data.Tuple.Module.functorTuple)
        .app(PS.Data.Newtype.Module.unwrap
               .app(PS.Data.Identity.Module.newtypeIdentity))
        .app(x);};
  @JvmField
  val mapEnv = PS.Data.Functor.Module.map
                 .app(PS.Control.Comonad.Env.Trans.Module.functorEnvT
                        .app(PS.Data.Identity.Module.functorIdentity));
  @JvmField
  val env = { e : Any ->
     { a : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Control.Comonad.Env.Trans.Module.EnvT)
         .app(PS.Data.Function.Module.apply
                .app(PS.Data.Tuple.Module.Tuple.app(e))
                .app(PS.Data.Identity.Module.Identity.app(a)))
    }
  };
}