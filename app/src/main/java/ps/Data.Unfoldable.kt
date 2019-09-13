@file:Suppress("UNCHECKED_CAST")

package PS.Data.Unfoldable
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  val unfoldrArrayImpl = Foreign.Data.Unfoldable.unfoldrArrayImpl;
  @JvmField
  val Unfoldable = { Unfoldable10 : Any ->
     { unfoldr : Any ->
       mapOf(("Unfoldable10" to Unfoldable10),  ("unfoldr" to unfoldr))
    }
  };
  @JvmField
  val unfoldr = { dict : Any ->
     (dict as Map<String, Any>)["unfoldr"]!!
  };
  @JvmField
  val unfoldableArray = PS.Data.Unfoldable.Module.Unfoldable
                          .app({ _ : Any ->
                               PS.Data.Unfoldable1.Module.unfoldable1Array
                            })
                          .app(PS.Data.Unfoldable.Module.unfoldrArrayImpl
                                 .app(PS.Data.Maybe.Module.isNothing)
                                 .app(PS.Partial.Unsafe.Module.unsafePartial
                                        .app({ dictPartial : Any ->
                                        PS.Data.Maybe.Module.fromJust.app(Unit)
                                     }))
                                 .app(PS.Data.Tuple.Module.fst)
                                 .app(PS.Data.Tuple.Module.snd));
  @JvmField
  val replicate = { dictUnfoldable : Any ->
     { n : Any ->
       { v : Any ->
         object   {
             val step = { i : Any ->
                when {
                 (PS.Data.Ord.Module.lessThanOrEq.app(PS.Data.Ord.Module.ordInt)
                    .app(i)
                    .app(0) == true) -> {
                   PS.Data.Maybe.Module.Nothing;
                 }
                 else -> {
                   PS.Data.Maybe.Module.Just
                     .app(PS.Data.Tuple.Module.Tuple.app(v)
                            .app(PS.Data.Ring.Module.sub
                                   .app(PS.Data.Ring.Module.ringInt)
                                   .app(i)
                                   .app(1)));
                 }
               }
             };
           }
           .run({
            val step = this.step;
            PS.Data.Unfoldable.Module.unfoldr.app(dictUnfoldable).app(step)
              .app(n);
          })
      }
    }
  };
  @JvmField
  val replicateA = { dictApplicative : Any ->
     { dictUnfoldable : Any ->
       { dictTraversable : Any ->
         { n : Any ->
           { m : Any ->
             PS.Data.Traversable.Module.sequence.app(dictTraversable)
               .app(dictApplicative)
               .app(PS.Data.Unfoldable.Module.replicate.app(dictUnfoldable)
                      .app(n)
                      .app(m))
          }
        }
      }
    }
  };
  @JvmField
  val none = { dictUnfoldable : Any ->
     PS.Data.Unfoldable.Module.unfoldr.app(dictUnfoldable)
       .app(PS.Data.Function.Module._const.app(PS.Data.Maybe.Module.Nothing))
       .app(PS.Data.Unit.Module.unit)
  };
  @JvmField
  val fromMaybe = { dictUnfoldable : Any ->
     PS.Data.Unfoldable.Module.unfoldr.app(dictUnfoldable)
       .app({ b : Any ->
         PS.Data.Functor.Module.map.app(PS.Data.Maybe.Module.functorMaybe)
           .app(PS.Data.Function.Module.flip.app(PS.Data.Tuple.Module.Tuple)
                  .app(PS.Data.Maybe.Module.Nothing))
           .app(b)
      })
  };
}