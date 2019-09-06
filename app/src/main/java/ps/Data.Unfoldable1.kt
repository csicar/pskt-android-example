@file:Suppress("UNCHECKED_CAST")
package PS.Data.Unfoldable1
import Foreign.PsRuntime.app
object Module  {
  val unfoldr1ArrayImpl = Foreign.Data.Unfoldable1.unfoldr1ArrayImpl;
  @JvmField
  val Unfoldable1 = { unfoldr1 : Any ->
     mapOf(("unfoldr1" to unfoldr1))
  };
  @JvmField
  val unfoldr1 = { dict : Any ->
     (dict as Map<String, Any>)["unfoldr1"]!!
  };
  @JvmField
  val unfoldable1Array = PS.Data.Unfoldable1.Module.Unfoldable1
                           .app(PS.Data.Unfoldable1.Module.unfoldr1ArrayImpl
                                  .app(PS.Data.Maybe.Module.isNothing)
                                  .app(PS.Partial.Unsafe.Module.unsafePartial
                                         .app({ dictPartial : Any ->
                                         PS.Data.Maybe.Module.fromJust.app(Unit)
                                      }))
                                  .app(PS.Data.Tuple.Module.fst)
                                  .app(PS.Data.Tuple.Module.snd));
  @JvmField
  val replicate1 = { dictUnfoldable1 : Any ->
     { n : Any ->
       { v : Any ->
         object   {
             val step = { i : Any ->
                when {
                 (PS.Data.Ord.Module.lessThanOrEq.app(PS.Data.Ord.Module.ordInt)
                    .app(i)
                    .app(0) as Boolean) -> {
                   val i1 = i;
                   PS.Data.Tuple.Module.Tuple.app(v)
                     .app(PS.Data.Maybe.Module.Nothing);
                 }
                 (PS.Data.Boolean.Module.otherwise as Boolean) -> {
                   val i1 = i;
                   PS.Data.Tuple.Module.Tuple.app(v)
                     .app(PS.Data.Maybe.Module.Just
                            .app(PS.Data.Ring.Module.sub
                                   .app(PS.Data.Ring.Module.ringInt)
                                   .app(i1)
                                   .app(1)));
                 }
                 else -> (error("Error in Pattern Match") as Any)
               }
             };
           }
           .run({
            val step = this.step;
            PS.Data.Unfoldable1.Module.unfoldr1.app(dictUnfoldable1).app(step)
              .app(PS.Data.Ring.Module.sub.app(PS.Data.Ring.Module.ringInt)
                     .app(n)
                     .app(1));
          })
      }
    }
  };
  @JvmField
  val replicate1A = { dictApply : Any ->
     { dictUnfoldable1 : Any ->
       { dictTraversable1 : Any ->
         { n : Any ->
           { m : Any ->
             PS.Data.Semigroup.Traversable.Module.sequence1
               .app(dictTraversable1)
               .app(dictApply)
               .app(PS.Data.Unfoldable1.Module.replicate1.app(dictUnfoldable1)
                      .app(n)
                      .app(m))
          }
        }
      }
    }
  };
  @JvmField
  val singleton = { dictUnfoldable1 : Any ->
     PS.Data.Unfoldable1.Module.replicate1.app(dictUnfoldable1).app(1)
  };
  @JvmField
  val range = { dictUnfoldable1 : Any ->
     { start : Any ->
       { end : Any ->
         object   {
             val go = { delta : Any ->
                { i : Any ->
                  object   {
                      val i_tick = PS.Data.Semiring.Module.add
                                     .app(PS.Data.Semiring.Module.semiringInt)
                                     .app(i)
                                     .app(delta);
                    }
                    .run({
                     val i_tick = this.i_tick;
                     PS.Data.Tuple.Module.Tuple.app(i)
                       .app(when {
                         (PS.Data.Eq.Module.eq.app(PS.Data.Eq.Module.eqInt)
                            .app(i)
                            .app(end) == true) -> {
                           PS.Data.Maybe.Module.Nothing;
                         }
                         else -> {
                           PS.Data.Maybe.Module.Just.app(i_tick);
                         }
                       });
                   })
               }
             };
           }
           .run({
            val go = this.go;
            object   {
                val delta = when {
                  (PS.Data.Ord.Module.greaterThanOrEq
                     .app(PS.Data.Ord.Module.ordInt)
                     .app(end)
                     .app(start) == true) -> {
                    1;
                  }
                  else -> {
                    PS.Data.Ring.Module.negate.app(PS.Data.Ring.Module.ringInt)
                      .app(1);
                  }
                };
              }
              .run({
                val delta = this.delta;
                PS.Data.Unfoldable1.Module.unfoldr1.app(dictUnfoldable1)
                  .app(go.app(delta))
                  .app(start);
              });
          })
      }
    }
  };
}