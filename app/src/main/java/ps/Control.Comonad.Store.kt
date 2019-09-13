@file:Suppress("UNCHECKED_CAST")

package PS.Control.Comonad.Store
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val store = { f : Any ->
     { x : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Control.Comonad.Store.Trans.Module.StoreT)
         .app(PS.Data.Tuple.Module.Tuple
                .app(PS.Data.Identity.Module.Identity.app(f))
                .app(x))
    }
  };
  @JvmField
  val runStore = { v : Any ->
    val s = v;
      PS.Data.Tuple.Module.swap
        .app(PS.Data.Functor.Module.map.app(PS.Data.Tuple.Module.functorTuple)
               .app(PS.Data.Newtype.Module.unwrap
                      .app(PS.Data.Identity.Module.newtypeIdentity))
               .app(PS.Data.Tuple.Module.swap.app(s)));};
}