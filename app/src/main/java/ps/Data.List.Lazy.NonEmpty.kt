@file:Suppress("UNCHECKED_CAST")
package PS.Data.List.Lazy.NonEmpty
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val uncons = { v : Any ->
     when {
      else -> {
        val nel = v;
        object   {
            val v1 = PS.Data.Lazy.Module.force.app(nel);
          }
          .run({
            val v1 = this.v1;
            when {
              (v1 is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
                val x = v1.value0;
                val xs = v1.value1;
                mapOf(("head" to x),  ("tail" to xs));
              }
              else -> (error("Error in Pattern Match") as Any)
            };
          });
      }
    }
  };
  @JvmField
  val toList = { v : Any ->
     when {
      else -> {
        val nel = v;
        object   {
            val v1 = PS.Data.Lazy.Module.force.app(nel);
          }
          .run({
            val v1 = this.v1;
            when {
              (v1 is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
                val x = v1.value0;
                val xs = v1.value1;
                PS.Data.List.Lazy.Types.Module.cons.app(x).app(xs);
              }
              else -> (error("Error in Pattern Match") as Any)
            };
          });
      }
    }
  };
  @JvmField
  val toUnfoldable = { dictUnfoldable : Any ->
     PS.Control.Semigroupoid.Module.compose
       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
       .app(PS.Data.Unfoldable.Module.unfoldr.app(dictUnfoldable)
              .app({ xs : Any ->
              PS.Data.Functor.Module.map.app(PS.Data.Maybe.Module.functorMaybe)
                .app({ rec : Any ->
                     PS.Data.Tuple.Module.Tuple
                       .app((rec as Map<String, Any>)["head"]!!)
                       .app((rec as Map<String, Any>)["tail"]!!)
                  })
                .app(PS.Data.List.Lazy.Module.uncons.app(xs))
           }))
       .app(PS.Data.List.Lazy.NonEmpty.Module.toList)
  };
  @JvmField
  val tail = { v : Any ->
     when {
      else -> {
        val nel = v;
        object   {
            val v1 = PS.Data.Lazy.Module.force.app(nel);
          }
          .run({
            val v1 = this.v1;
            when {
              (v1 is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
                val xs = v1.value1;
                xs;
              }
              else -> (error("Error in Pattern Match") as Any)
            };
          });
      }
    }
  };
  @JvmField
  val singleton = PS.Control.Applicative.Module.pure
                    .app(PS.Data.List.Lazy.Types.Module.applicativeNonEmptyList
  );
  @JvmField
  val repeat = { x : Any ->
     PS.Data.Function.Module.apply
       .app(PS.Data.List.Lazy.Types.Module.NonEmptyList)
       .app(PS.Data.Lazy.Module.defer
              .app({ v : Any ->
           PS.Data.NonEmpty.Module.NonEmpty.app(x)
             .app(PS.Data.List.Lazy.Module.repeat.app(x))
        }))
  };
  @JvmField
  val length = { v : Any ->
     when {
      else -> {
        val nel = v;
        object   {
            val v1 = PS.Data.Lazy.Module.force.app(nel);
          }
          .run({
            val v1 = this.v1;
            when {
              (v1 is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
                val x = v1.value0;
                val xs = v1.value1;
                PS.Data.Semiring.Module.add
                  .app(PS.Data.Semiring.Module.semiringInt)
                  .app(1)
                  .app(PS.Data.List.Lazy.Module.length.app(xs));
              }
              else -> (error("Error in Pattern Match") as Any)
            };
          });
      }
    }
  };
  @JvmField
  val last = { v : Any ->
     when {
      else -> {
        val nel = v;
        object   {
            val v1 = PS.Data.Lazy.Module.force.app(nel);
          }
          .run({
            val v1 = this.v1;
            when {
              (v1 is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
                val x = v1.value0;
                val xs = v1.value1;
                PS.Data.Maybe.Module.fromMaybe.app(x)
                  .app(PS.Data.List.Lazy.Module.last.app(xs));
              }
              else -> (error("Error in Pattern Match") as Any)
            };
          });
      }
    }
  };
  @JvmField
  val iterate = { f : Any ->
     { x : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.List.Lazy.Types.Module.NonEmptyList)
         .app(PS.Data.Lazy.Module.defer
                .app({ v : Any ->
             PS.Data.NonEmpty.Module.NonEmpty.app(x)
               .app(PS.Data.List.Lazy.Module.iterate.app(f).app(f.app(x)))
          }))
    }
  };
  @JvmField
  val _init = { v : Any ->
     when {
      else -> {
        val nel = v;
        object   {
            val v1 = PS.Data.Lazy.Module.force.app(nel);
          }
          .run({
            val v1 = this.v1;
            when {
              (v1 is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
                val x = v1.value0;
                val xs = v1.value1;
                PS.Data.Maybe.Module.maybe
                  .app(PS.Data.List.Lazy.Types.Module.nil)
                  .app({ v2 : Any ->
                       PS.Data.List.Lazy.Types.Module.cons.app(x).app(v2)
                    })
                  .app(PS.Data.List.Lazy.Module._init.app(xs));
              }
              else -> (error("Error in Pattern Match") as Any)
            };
          });
      }
    }
  };
  @JvmField
  val head = { v : Any ->
     when {
      else -> {
        val nel = v;
        object   {
            val v1 = PS.Data.Lazy.Module.force.app(nel);
          }
          .run({
            val v1 = this.v1;
            when {
              (v1 is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
                val x = v1.value0;
                x;
              }
              else -> (error("Error in Pattern Match") as Any)
            };
          });
      }
    }
  };
  @JvmField
  val fromList = { l : Any ->
     object   {
         val v = PS.Data.List.Lazy.Types.Module.step.app(l);
       }
       .run({
        val v = this.v;
        when {
          (v is PS.Data.List.Lazy.Types.Module._Type_Step.Nil) -> {
            PS.Data.Maybe.Module.Nothing;
          }
          (v is PS.Data.List.Lazy.Types.Module._Type_Step.Cons) -> {
            val x = v.value0;
            val xs = v.value1;
            PS.Data.Maybe.Module.Just
              .app(PS.Data.List.Lazy.Types.Module.NonEmptyList
                     .app(PS.Data.Lazy.Module.defer
                            .app({ v1 : Any ->
                     PS.Data.NonEmpty.Module.NonEmpty.app(x).app(xs)
                  })));
          }
          else -> (error("Error in Pattern Match") as Any)
        };
      })
  };
  @JvmField
  val fromFoldable = { dictFoldable : Any ->
     PS.Control.Semigroupoid.Module.compose
       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
       .app(PS.Data.List.Lazy.NonEmpty.Module.fromList)
       .app(PS.Data.List.Lazy.Module.fromFoldable.app(dictFoldable))
  };
  @JvmField
  val concatMap = PS.Data.Function.Module.flip
                    .app(PS.Control.Bind.Module.bind
                           .app(PS.Data.List.Lazy.Types.Module.bindNonEmptyList)
  );
  @JvmField
  val appendFoldable = { dictFoldable : Any ->
     { nel : Any ->
       { ys : Any ->
         PS.Data.List.Lazy.Types.Module.NonEmptyList
           .app(PS.Data.Lazy.Module.defer
                  .app({ v : Any ->
               PS.Data.NonEmpty.Module.NonEmpty
                 .app(PS.Data.List.Lazy.NonEmpty.Module.head.app(nel))
                 .app(PS.Data.Semigroup.Module.append
                        .app(PS.Data.List.Lazy.Types.Module.semigroupList)
                        .app(PS.Data.List.Lazy.NonEmpty.Module.tail.app(nel))
                        .app(PS.Data.List.Lazy.Module.fromFoldable
                               .app(dictFoldable)
                               .app(ys)))
            }))
      }
    }
  };
}