@file:Suppress("UNCHECKED_CAST")
package PS.Control.Monad.ST.Internal
import Foreign.PsRuntime.app
object Module  {
  val map_ = Foreign.Control.Monad.ST.Internal.map_;
  val pure_ = Foreign.Control.Monad.ST.Internal.pure_;
  val bind_ = Foreign.Control.Monad.ST.Internal.bind_;
  val run = Foreign.Control.Monad.ST.Internal.run;
  val _while = Foreign.Control.Monad.ST.Internal._while;
  val _for = Foreign.Control.Monad.ST.Internal._for;
  val foreach = Foreign.Control.Monad.ST.Internal.foreach;
  val new = Foreign.Control.Monad.ST.Internal.new;
  val read = Foreign.Control.Monad.ST.Internal.read;
  val modify_tick = Foreign.Control.Monad.ST.Internal.modify_tick;
  val write = Foreign.Control.Monad.ST.Internal.write;
  @JvmField
  val modify = { f : Any ->
     PS.Control.Monad.ST.Internal.Module.modify_tick
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
  val functorST = PS.Data.Functor.Module.Functor
                    .app(PS.Control.Monad.ST.Internal.Module.map_);
  @JvmField val monadST = (::__rec_monadST)();
  @JvmField val bindST = (::__rec_bindST)();
  @JvmField val applyST = (::__rec_applyST)();
  @JvmField val applicativeST = (::__rec_applicativeST)();
  fun __rec_monadST(): Any = PS.Control.Monad.Module.Monad
                               .app({ _ : Any ->
                                    PS.Control.Monad.ST.Internal.Module.applicativeST
                                 })
                               .app({ _ : Any ->
       PS.Control.Monad.ST.Internal.Module.bindST
    });
  fun __rec_bindST(): Any = PS.Control.Bind.Module.Bind
                              .app({ _ : Any ->
                                   PS.Control.Monad.ST.Internal.Module.applyST
                                })
                              .app(PS.Control.Monad.ST.Internal.Module.bind_);
  fun __rec_applyST(): Any = PS.Control.Apply.Module.Apply
                               .app({ _ : Any ->
                                    PS.Control.Monad.ST.Internal.Module.functorST
                                 })
                               .app(PS.Control.Monad.Module.ap
                                      .app(
      PS.Control.Monad.ST.Internal.Module.monadST));
  fun __rec_applicativeST(): Any = PS.Control.Applicative.Module.Applicative
                                     .app({ _ : Any ->
                                          PS.Control.Monad.ST.Internal.Module.applyST
                                       })
                                     .app(
    PS.Control.Monad.ST.Internal.Module.pure_);
  @JvmField
  val monadRecST = PS.Control.Monad.Rec.Class.Module.MonadRec
                     .app({ _ : Any ->
                          PS.Control.Monad.ST.Internal.Module.monadST
                       })
                     .app({ f : Any ->
       { a : Any ->
         object   {
             val isLooping = { v : Any ->
                when {
                 (v is PS.Control.Monad.Rec.Class.Module._Type_Step.Loop) -> {
                   true;
                 }
                 else -> {
                   false;
                 }
               }
             };
             val fromDone = PS.Partial.Unsafe.Module.unsafePartial
                              .app({ dictPartial : Any ->
                  { v : Any ->
                    when {
                     (v is PS.Control.Monad.Rec.Class.Module._Type_Step
                             .Done) -> {
                       val b = v.value0;
                       b;
                     }
                     else -> (error("Error in Pattern Match") as Any)
                   }
                 }
               });
           }
           .run({
            val isLooping = this.isLooping;
            val fromDone = this.fromDone;
            PS.Control.Bind.Module.bind
              .app(PS.Control.Monad.ST.Internal.Module.bindST)
              .app(PS.Control.Bind.Module.bindFlipped
                     .app(PS.Control.Monad.ST.Internal.Module.bindST)
                     .app(PS.Control.Monad.ST.Internal.Module.new)
                     .app(f.app(a)))
              .app({ v : Any ->
                 when {
                  else -> {
                    val r = v;
                    PS.Control.Bind.Module.discard
                      .app(PS.Control.Bind.Module.discardUnit)
                      .app(PS.Control.Monad.ST.Internal.Module.bindST)
                      .app(PS.Control.Monad.ST.Internal.Module._while
                             .app(PS.Data.Functor.Module.map
                                    .app(
                                      PS.Control.Monad.ST.Internal.Module.functorST
                                    )
                                    .app(isLooping)
                                    .app(
                                 PS.Control.Monad.ST.Internal.Module.read.app(r)
                               ))
                             .app(PS.Control.Bind.Module.bind
                                    .app(
                                      PS.Control.Monad.ST.Internal.Module.bindST
                                    )
                                    .app(
                                      PS.Control.Monad.ST.Internal.Module.read
                                        .app(r))
                                    .app({ v1 : Any ->
                               when {
                                (v1 is PS.Control.Monad.Rec.Class.Module._Type_Step
                                         .Loop) -> {
                                  val a_tick = v1.value0;
                                  PS.Control.Bind.Module.bind
                                    .app(
                                      PS.Control.Monad.ST.Internal.Module.bindST
                                    )
                                    .app(f.app(a_tick))
                                    .app({ v2 : Any ->
                                       when {
                                        else -> {
                                          val e = v2;
                                          PS.Data.Functor.Module.void
                                            .app(
                                              PS.Control.Monad.ST.Internal.Module.functorST
                                            )
                                            .app(
                                            PS.Control.Monad.ST.Internal.Module.write
                                              .app(e)
                                              .app(r));
                                        }
                                      }
                                    });
                                }
                                (v1 is PS.Control.Monad.Rec.Class.Module._Type_Step
                                         .Done) -> {
                                  val b = v1.value0;
                                  PS.Control.Applicative.Module.pure
                                    .app(
                                      PS.Control.Monad.ST.Internal.Module.applicativeST
                                    )
                                    .app(PS.Data.Unit.Module.unit);
                                }
                                else -> (error("Error in Pattern Match") as Any)
                              }
                            })))
                      .app({ _ : Any ->
                         PS.Data.Functor.Module.map
                           .app(PS.Control.Monad.ST.Internal.Module.functorST)
                           .app(fromDone)
                           .app(PS.Control.Monad.ST.Internal.Module.read.app(r))
                      });
                  }
                }
              });
          })
      }
    });
}