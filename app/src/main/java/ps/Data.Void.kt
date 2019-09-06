@file:Suppress("UNCHECKED_CAST")
package PS.Data.Void
import Foreign.PsRuntime.app
object Module  {
  @JvmField val Void = { x : Any -> x};
  @JvmField
  val absurd = { a : Any ->
     object   {
         val spin = (::__rec_spin)();
         fun __rec_spin(): Any = { v : Any ->
            when {
             else -> {
               val b = v;
               __rec_spin().app(b);
             }
           }
         };
       }
       .run({
        val spin = this.spin;
        spin.app(a);
      })
  };
  @JvmField
  val showVoid = PS.Data.Show.Module.Show.app(PS.Data.Void.Module.absurd);
}