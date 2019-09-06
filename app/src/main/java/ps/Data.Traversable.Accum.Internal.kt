@file:Suppress("UNCHECKED_CAST")
package PS.Data.Traversable.Accum.Internal
import Foreign.PsRuntime.app
object Module  {
  @JvmField val StateR = { x : Any -> x};
  @JvmField val StateL = { x : Any -> x};
  @JvmField val stateR = { v : Any -> when { else -> { val k = v; k; } }};
  @JvmField val stateL = { v : Any -> when { else -> { val k = v; k; } }};
  @JvmField
  val functorStateR = PS.Data.Functor.Module.Functor
                        .app({ f : Any ->
       { k : Any ->
         PS.Data.Traversable.Accum.Internal.Module.StateR
           .app({ s : Any ->
             object   {
                 val v = PS.Data.Traversable.Accum.Internal.Module.stateR.app(k)
                           .app(s);
               }
               .run({
                val v = this.v;
                when {
                  ((v as Map<String, Any>).size == 2) -> {
                    val s1 = v["accum"]!!;
                    val a = v["value"]!!;
                    mapOf(("accum" to s1),  ("value" to f.app(a)));
                  }
                  else -> (error("Error in Pattern Match") as Any)
                };
              })
          })
      }
    });
  @JvmField
  val functorStateL = PS.Data.Functor.Module.Functor
                        .app({ f : Any ->
       { k : Any ->
         PS.Data.Traversable.Accum.Internal.Module.StateL
           .app({ s : Any ->
             object   {
                 val v = PS.Data.Traversable.Accum.Internal.Module.stateL.app(k)
                           .app(s);
               }
               .run({
                val v = this.v;
                when {
                  ((v as Map<String, Any>).size == 2) -> {
                    val s1 = v["accum"]!!;
                    val a = v["value"]!!;
                    mapOf(("accum" to s1),  ("value" to f.app(a)));
                  }
                  else -> (error("Error in Pattern Match") as Any)
                };
              })
          })
      }
    });
  @JvmField
  val applyStateR = PS.Control.Apply.Module.Apply
                      .app({ _ : Any ->
                           PS.Data.Traversable.Accum.Internal.Module.functorStateR
                        })
                      .app({ f : Any ->
       { x : Any ->
         PS.Data.Traversable.Accum.Internal.Module.StateR
           .app({ s : Any ->
             object   {
                 val v = PS.Data.Traversable.Accum.Internal.Module.stateR.app(x)
                           .app(s);
               }
               .run({
                val v = this.v;
                when {
                  ((v as Map<String, Any>).size == 2) -> {
                    val s1 = v["accum"]!!;
                    val x_tick = v["value"]!!;
                    object   {
                        val v1 = PS.Data.Traversable.Accum.Internal.Module.stateR
                                   .app(f)
                                   .app(s1);
                      }
                      .run({
                        val v1 = this.v1;
                        when {
                          ((v1 as Map<String, Any>).size == 2) -> {
                            val s2 = v1["accum"]!!;
                            val f_tick = v1["value"]!!;
                            mapOf(("accum" to s2),  ("value" to f_tick
                                                                  .app(x_tick))
                            );
                          }
                          else -> (error("Error in Pattern Match") as Any)
                        };
                      });
                  }
                  else -> (error("Error in Pattern Match") as Any)
                };
              })
          })
      }
    });
  @JvmField
  val applyStateL = PS.Control.Apply.Module.Apply
                      .app({ _ : Any ->
                           PS.Data.Traversable.Accum.Internal.Module.functorStateL
                        })
                      .app({ f : Any ->
       { x : Any ->
         PS.Data.Traversable.Accum.Internal.Module.StateL
           .app({ s : Any ->
             object   {
                 val v = PS.Data.Traversable.Accum.Internal.Module.stateL.app(f)
                           .app(s);
               }
               .run({
                val v = this.v;
                when {
                  ((v as Map<String, Any>).size == 2) -> {
                    val s1 = v["accum"]!!;
                    val f_tick = v["value"]!!;
                    object   {
                        val v1 = PS.Data.Traversable.Accum.Internal.Module.stateL
                                   .app(x)
                                   .app(s1);
                      }
                      .run({
                        val v1 = this.v1;
                        when {
                          ((v1 as Map<String, Any>).size == 2) -> {
                            val s2 = v1["accum"]!!;
                            val x_tick = v1["value"]!!;
                            mapOf(("accum" to s2),  ("value" to f_tick
                                                                  .app(x_tick))
                            );
                          }
                          else -> (error("Error in Pattern Match") as Any)
                        };
                      });
                  }
                  else -> (error("Error in Pattern Match") as Any)
                };
              })
          })
      }
    });
  @JvmField
  val applicativeStateR = PS.Control.Applicative.Module.Applicative
                            .app({ _ : Any ->
                                 PS.Data.Traversable.Accum.Internal.Module.applyStateR
                              })
                            .app({ a : Any ->
       PS.Data.Traversable.Accum.Internal.Module.StateR
         .app({ s : Any ->
           mapOf(("accum" to s),  ("value" to a))
        })
    });
  @JvmField
  val applicativeStateL = PS.Control.Applicative.Module.Applicative
                            .app({ _ : Any ->
                                 PS.Data.Traversable.Accum.Internal.Module.applyStateL
                              })
                            .app({ a : Any ->
       PS.Data.Traversable.Accum.Internal.Module.StateL
         .app({ s : Any ->
           mapOf(("accum" to s),  ("value" to a))
        })
    });
}