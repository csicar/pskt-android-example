@file:Suppress("UNCHECKED_CAST")
package PS.Data.Array.ST.Iterator
import Foreign.PsRuntime.app
object Module  {
  sealed class _Type_Iterator ()  {
    data class Iterator (val value0 : Any,  val value1 : Any) : _Type_Iterator(
    ) {};
  };
  val Iterator = { value0 : Any ->
     { value1 : Any ->
       _Type_Iterator.Iterator(value0,  value1)
    }
  };
  @JvmField
  val peek = { v : Any ->
     when {
      (v is PS.Data.Array.ST.Iterator.Module._Type_Iterator.Iterator) -> {
        val f = v.value0;
        val currentIndex = v.value1;
        PS.Control.Bind.Module.bind
          .app(PS.Control.Monad.ST.Internal.Module.bindST)
          .app(PS.Control.Monad.ST.Internal.Module.read.app(currentIndex))
          .app({ v1 : Any ->
             when {
              else -> {
                val i = v1;
                PS.Control.Applicative.Module.pure
                  .app(PS.Control.Monad.ST.Internal.Module.applicativeST)
                  .app(f.app(i));
              }
            }
          });
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val next = { v : Any ->
     when {
      (v is PS.Data.Array.ST.Iterator.Module._Type_Iterator.Iterator) -> {
        val f = v.value0;
        val currentIndex = v.value1;
        PS.Control.Bind.Module.bind
          .app(PS.Control.Monad.ST.Internal.Module.bindST)
          .app(PS.Control.Monad.ST.Internal.Module.read.app(currentIndex))
          .app({ v1 : Any ->
             when {
              else -> {
                val i = v1;
                PS.Control.Bind.Module.bind
                  .app(PS.Control.Monad.ST.Internal.Module.bindST)
                  .app(PS.Control.Monad.ST.Internal.Module.modify
                         .app({ v2 : Any ->
                              PS.Data.Semiring.Module.add
                                .app(PS.Data.Semiring.Module.semiringInt)
                                .app(v2)
                                .app(1)
                           })
                         .app(currentIndex))
                  .app({ v2 : Any ->
                     PS.Control.Applicative.Module.pure
                       .app(PS.Control.Monad.ST.Internal.Module.applicativeST)
                       .app(f.app(i))
                  });
              }
            }
          });
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val pushWhile = { p : Any ->
     { iter : Any ->
       { array : Any ->
         PS.Control.Bind.Module.bind
           .app(PS.Control.Monad.ST.Internal.Module.bindST)
           .app(PS.Control.Monad.ST.Internal.Module.new.app(false))
           .app({ v : Any ->
             when {
              else -> {
                val _break = v;
                PS.Control.Monad.ST.Internal.Module._while
                  .app(PS.Data.Functor.Module.map
                         .app(PS.Control.Monad.ST.Internal.Module.functorST)
                         .app(PS.Data.HeytingAlgebra.Module.not
                                .app(
                             PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean
                           ))
                         .app(PS.Control.Monad.ST.Internal.Module.read
                                .app(_break)))
                  .app(PS.Control.Bind.Module.bind
                         .app(PS.Control.Monad.ST.Internal.Module.bindST)
                         .app(PS.Data.Array.ST.Iterator.Module.peek.app(iter))
                         .app({ v1 : Any ->
                       when {
                        else -> {
                          val mx = v1;
                          when {
                            (mx is PS.Data.Maybe.Module._Type_Maybe
                                     .Just)&& (p.app(mx.value0) as Boolean) -> {
                              val x = mx.value0;
                              PS.Control.Bind.Module.bind
                                .app(PS.Control.Monad.ST.Internal.Module.bindST)
                                .app(PS.Data.Array.ST.Module.push.app(x)
                                       .app(array))
                                .app({ v2 : Any ->
                                   PS.Data.Function.Module.apply
                                     .app(PS.Data.Functor.Module.void
                                            .app(
                                         PS.Control.Monad.ST.Internal.Module.functorST
                                       ))
                                     .app(PS.Data.Array.ST.Iterator.Module.next
                                            .app(iter))
                                });
                            }
                            else -> {
                              PS.Data.Function.Module.apply
                                .app(PS.Data.Functor.Module.void
                                       .app(
                                    PS.Control.Monad.ST.Internal.Module.functorST
                                  ))
                                .app(PS.Control.Monad.ST.Internal.Module.write
                                       .app(true)
                                       .app(_break));
                            }
                          };
                        }
                      }
                    }));
              }
            }
          })
      }
    }
  };
  @JvmField
  val pushAll = PS.Data.Array.ST.Iterator.Module.pushWhile
                  .app(PS.Data.Function.Module._const.app(true));
  @JvmField
  val iterator = { f : Any ->
     PS.Data.Functor.Module.map
       .app(PS.Control.Monad.ST.Internal.Module.functorST)
       .app(PS.Data.Array.ST.Iterator.Module.Iterator.app(f))
       .app(PS.Control.Monad.ST.Internal.Module.new.app(0))
  };
  @JvmField
  val iterate = { iter : Any ->
     { f : Any ->
       PS.Control.Bind.Module.bind
         .app(PS.Control.Monad.ST.Internal.Module.bindST)
         .app(PS.Control.Monad.ST.Internal.Module.new.app(false))
         .app({ v : Any ->
           when {
            else -> {
              val _break = v;
              PS.Control.Monad.ST.Internal.Module._while
                .app(PS.Data.Functor.Module.map
                       .app(PS.Control.Monad.ST.Internal.Module.functorST)
                       .app(PS.Data.HeytingAlgebra.Module.not
                              .app(
                           PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean))
                       .app(PS.Control.Monad.ST.Internal.Module.read.app(_break)
                  ))
                .app(PS.Control.Bind.Module.bind
                       .app(PS.Control.Monad.ST.Internal.Module.bindST)
                       .app(PS.Data.Array.ST.Iterator.Module.next.app(iter))
                       .app({ v1 : Any ->
                     when {
                      else -> {
                        val mx = v1;
                        when {
                          (mx is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
                            val x = mx.value0;
                            f.app(x);
                          }
                          (mx is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                            PS.Data.Function.Module.apply
                              .app(PS.Data.Functor.Module.void
                                     .app(
                                  PS.Control.Monad.ST.Internal.Module.functorST)
                              )
                              .app(PS.Control.Monad.ST.Internal.Module.write
                                     .app(true)
                                     .app(_break));
                          }
                          else -> (error("Error in Pattern Match") as Any)
                        };
                      }
                    }
                  }));
            }
          }
        })
    }
  };
  @JvmField
  val exhausted = PS.Control.Semigroupoid.Module.compose
                    .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                    .app(PS.Data.Functor.Module.map
                           .app(PS.Control.Monad.ST.Internal.Module.functorST)
                           .app(PS.Data.Maybe.Module.isNothing))
                    .app(PS.Data.Array.ST.Iterator.Module.peek);
}