@file:Suppress("UNCHECKED_CAST")
package PS.Effect.Ref
import Foreign.PsRuntime.app
object Module  {
  val new = Foreign.Effect.Ref.new;
  val read = Foreign.Effect.Ref.read;
  val modify_tick = Foreign.Effect.Ref.modify_tick;
  val write = Foreign.Effect.Ref.write;
  @JvmField
  val modify = { f : Any ->
     PS.Effect.Ref.Module.modify_tick
       .app({ s : Any ->
         object   {
             val s_tick = f.app(s);
           }
           .run({
            val s_tick = this.s_tick;
            mapOf(("state" to s_tick),  ("value" to s_tick));
          })
      })
  };
  @JvmField
  val modify_ = { f : Any ->
     { s : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Functor.Module.void.app(PS.Effect.Module.functorEffect))
         .app(PS.Effect.Ref.Module.modify.app(f).app(s))
    }
  };
}