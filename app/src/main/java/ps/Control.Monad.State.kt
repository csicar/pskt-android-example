@file:Suppress("UNCHECKED_CAST")

package PS.Control.Monad.State
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val withState = PS.Control.Monad.State.Trans.Module.withStateT;
  @JvmField
  val runState = { v : Any ->
    val s = v;
      PS.Control.Semigroupoid.Module.compose
        .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
        .app(PS.Data.Newtype.Module.unwrap
               .app(PS.Data.Identity.Module.newtypeIdentity))
        .app(s);};
  @JvmField
  val mapState = { f : Any ->
     PS.Control.Monad.State.Trans.Module.mapStateT
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Data.Identity.Module.Identity)
              .app(PS.Control.Semigroupoid.Module.compose
                     .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                     .app(f)
                     .app(PS.Data.Newtype.Module.unwrap
                            .app(PS.Data.Identity.Module.newtypeIdentity))))
  };
  @JvmField
  val execState = { v : Any ->
     { s : Any ->
      val m = v;
        val s1 = s;
        object   {
            val v1 = m.app(s1);
          }
          .run({
            val v1 = this.v1;
            when {
              (v1 is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                val s_tick = v1.value1;
                s_tick;
              }
              else -> (error("Error in Pattern Match") as Any)
            };
          });}
  };
  @JvmField
  val evalState = { v : Any ->
     { s : Any ->
      val m = v;
        val s1 = s;
        object   {
            val v1 = m.app(s1);
          }
          .run({
            val v1 = this.v1;
            when {
              (v1 is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                val a = v1.value0;
                a;
              }
              else -> (error("Error in Pattern Match") as Any)
            };
          });}
  };
}