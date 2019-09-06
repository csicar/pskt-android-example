@file:Suppress("UNCHECKED_CAST")
package PS.Data.Function
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val on = { f : Any ->
     { g : Any ->
       { x : Any ->
         { y : Any ->
           f.app(g.app(x)).app(g.app(y))
        }
      }
    }
  };
  @JvmField
  val flip = { f : Any ->
     { b : Any ->
       { a : Any ->
         f.app(a).app(b)
      }
    }
  };
  @JvmField val _const = { a : Any -> { v : Any -> a}};
  @JvmField
  val applyN = { f : Any ->
     object   {
         val go = (::__rec_go)();
         fun __rec_go(): Any = { n : Any ->
            { acc : Any ->
              when {
               (PS.Data.Ord.Module.lessThanOrEq.app(PS.Data.Ord.Module.ordInt)
                  .app(n)
                  .app(0) as Boolean) -> {
                 val n1 = n;
                 val acc1 = acc;
                 acc1;
               }
               (PS.Data.Boolean.Module.otherwise as Boolean) -> {
                 val n1 = n;
                 val acc1 = acc;
                 __rec_go()
                   .app(PS.Data.Ring.Module.sub.app(PS.Data.Ring.Module.ringInt)
                          .app(n1)
                          .app(1))
                   .app(f.app(acc1));
               }
               else -> (error("Error in Pattern Match") as Any)
             }
           }
         };
       }
       .run({
        val go = this.go;
        go;
      })
  };
  @JvmField val applyFlipped = { x : Any -> { f : Any -> f.app(x)}};
  @JvmField val apply = { f : Any -> { x : Any -> f.app(x)}};
}