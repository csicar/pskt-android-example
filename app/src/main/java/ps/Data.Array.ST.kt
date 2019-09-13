@file:Suppress("UNCHECKED_CAST")

package PS.Data.Array.ST
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  val empty = Foreign.Data.Array.ST.empty;
  val shiftImpl = Foreign.Data.Array.ST.shiftImpl;
  val sortByImpl = Foreign.Data.Array.ST.sortByImpl;
  val copyImpl = Foreign.Data.Array.ST.copyImpl;
  val peekImpl = Foreign.Data.Array.ST.peekImpl;
  val poke = Foreign.Data.Array.ST.poke;
  val popImpl = Foreign.Data.Array.ST.popImpl;
  val pushAll = Foreign.Data.Array.ST.pushAll;
  val unshiftAll = Foreign.Data.Array.ST.unshiftAll;
  val splice = Foreign.Data.Array.ST.splice;
  val toAssocArray = Foreign.Data.Array.ST.toAssocArray;
  @JvmField
  val unshift = { a : Any ->
     PS.Data.Array.ST.Module.unshiftAll.app(listOf(a))
  };
  @JvmField
  val unsafeThaw = PS.Control.Semigroupoid.Module.compose
                     .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                     .app(PS.Control.Applicative.Module.pure
                            .app(
                         PS.Control.Monad.ST.Internal.Module.applicativeST))
                     .app(PS.Unsafe.Coerce.Module.unsafeCoerce);
  @JvmField
  val unsafeFreeze = PS.Control.Semigroupoid.Module.compose
                       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                       .app(PS.Control.Applicative.Module.pure
                              .app(
                           PS.Control.Monad.ST.Internal.Module.applicativeST))
                       .app(PS.Unsafe.Coerce.Module.unsafeCoerce);
  @JvmField val thaw = PS.Data.Array.ST.Module.copyImpl;
  @JvmField
  val withArray = { f : Any ->
     { xs : Any ->
       /* defer **/{
        val v = PS.Data.Array.ST.Module.thaw.app(xs).appRun();
        val result = v;
        val v1 = f.app(result).appRun();
        PS.Data.Array.ST.Module.unsafeFreeze.app(result).appRun();
      }
    }
  };
  @JvmField
  val sortBy = { comp : Any ->
     object   {
         val comp_tick = { x : Any ->
            { y : Any ->
              object   {
                  val v = comp.app(x).app(y);
                }
                .run({
                 val v = this.v;
                 when {
                   (v is PS.Data.Ordering.Module._Type_Ordering.GT) -> {
                     1;
                   }
                   (v is PS.Data.Ordering.Module._Type_Ordering.EQ) -> {
                     0;
                   }
                   (v is PS.Data.Ordering.Module._Type_Ordering.LT) -> {
                     PS.Data.Ring.Module.negate.app(PS.Data.Ring.Module.ringInt)
                       .app(1);
                   }
                   else -> (error("Error in Pattern Match") as Any)
                 };
               })
           }
         };
       }
       .run({
        val comp_tick = this.comp_tick;
        PS.Data.Array.ST.Module.sortByImpl.app(comp_tick);
      })
  };
  @JvmField
  val sortWith = { dictOrd : Any ->
     { f : Any ->
       PS.Data.Array.ST.Module.sortBy
         .app(PS.Data.Ord.Module.comparing.app(dictOrd).app(f))
    }
  };
  @JvmField
  val sort = { dictOrd : Any ->
     PS.Data.Array.ST.Module.sortBy.app(PS.Data.Ord.Module.compare.app(dictOrd))
  };
  @JvmField
  val shift = PS.Data.Array.ST.Module.shiftImpl.app(PS.Data.Maybe.Module.Just)
                .app(PS.Data.Maybe.Module.Nothing);
  @JvmField
  val run = { st : Any ->
     PS.Control.Monad.ST.Internal.Module.run
       .app(PS.Control.Bind.Module.bind
              .app(PS.Control.Monad.ST.Internal.Module.bindST)
              .app(st)
              .app(PS.Data.Array.ST.Module.unsafeFreeze))
  };
  @JvmField
  val push = { a : Any ->
     PS.Data.Array.ST.Module.pushAll.app(listOf(a))
  };
  @JvmField
  val pop = PS.Data.Array.ST.Module.popImpl.app(PS.Data.Maybe.Module.Just)
              .app(PS.Data.Maybe.Module.Nothing);
  @JvmField
  val peek = PS.Data.Array.ST.Module.peekImpl.app(PS.Data.Maybe.Module.Just)
               .app(PS.Data.Maybe.Module.Nothing);
  @JvmField
  val modify = { i : Any ->
     { f : Any ->
       { xs : Any ->
         /* defer **/{
          val v = PS.Data.Array.ST.Module.peek.app(i).app(xs).appRun();
          val entry = v;
          when {
              (entry is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
                val x = entry.value0;
                PS.Data.Array.ST.Module.poke.app(i).app(f.app(x)).app(xs);
              }
              (entry is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                PS.Control.Applicative.Module.pure
                  .app(PS.Control.Monad.ST.Internal.Module.applicativeST)
                  .app(false);
              }
              else -> (error("Error in Pattern Match") as Any)
            }
            .appRun();
        }
      }
    }
  };
  @JvmField val freeze = PS.Data.Array.ST.Module.copyImpl;
}