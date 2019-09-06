@file:Suppress("UNCHECKED_CAST")
package PS.Data.Bifunctor.Wrap
import Foreign.PsRuntime.app
object Module  {
  @JvmField val Wrap = { x : Any -> x};
  @JvmField
  val showWrap = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ v : Any ->
         when {
          else -> {
            val x = v;
            (("(Wrap " as String) + (((PS.Data.Show.Module.show.app(dictShow)
                                         .app(x
            ) as String) + (")" as String)) as String));
          }
        }
      })
  };
  @JvmField val ordWrap = { dictOrd : Any -> dictOrd};
  @JvmField
  val newtypeWrap = PS.Data.Newtype.Module.Newtype
                      .app({ n : Any ->
                           when {
                            else -> {
                              val a = n;
                              a;
                            }
                          }
                        })
                      .app(PS.Data.Bifunctor.Wrap.Module.Wrap);
  @JvmField
  val functorWrap = { dictBifunctor : Any ->
     PS.Data.Functor.Module.Functor
       .app({ f : Any ->
         { v : Any ->
           when {
            else -> {
              val f1 = f;
              val a = v;
              PS.Data.Bifunctor.Wrap.Module.Wrap
                .app(PS.Data.Bifunctor.Module.rmap.app(dictBifunctor).app(f1)
                       .app(a));
            }
          }
        }
      })
  };
  @JvmField val eqWrap = { dictEq : Any -> dictEq};
  @JvmField
  val bifunctorWrap = { dictBifunctor : Any ->
     PS.Data.Bifunctor.Module.Bifunctor
       .app({ f : Any ->
         { g : Any ->
           { v : Any ->
             when {
              else -> {
                val f1 = f;
                val g1 = g;
                val a = v;
                PS.Data.Bifunctor.Wrap.Module.Wrap
                  .app(PS.Data.Bifunctor.Module.bimap.app(dictBifunctor).app(f1)
                         .app(g1)
                         .app(a));
              }
            }
          }
        }
      })
  };
  @JvmField
  val biapplyWrap = { dictBiapply : Any ->
     PS.Control.Biapply.Module.Biapply
       .app({ _ : Any ->
            PS.Data.Bifunctor.Wrap.Module.bifunctorWrap
              .app((dictBiapply as Map<String, Any>)["Bifunctor0"]!!.app(Unit))
         })
       .app({ v : Any ->
         { v1 : Any ->
           when {
            else -> {
              val fg = v;
              val xy = v1;
              PS.Data.Bifunctor.Wrap.Module.Wrap
                .app(PS.Control.Biapply.Module.biapply.app(dictBiapply).app(fg)
                       .app(xy));
            }
          }
        }
      })
  };
  @JvmField
  val biapplicativeWrap = { dictBiapplicative : Any ->
     PS.Control.Biapplicative.Module.Biapplicative
       .app({ _ : Any ->
            PS.Data.Bifunctor.Wrap.Module.biapplyWrap
              .app((dictBiapplicative as Map<String, Any>)["Biapply0"]!!
                     .app(Unit))
         })
       .app({ a : Any ->
         { b : Any ->
           PS.Data.Bifunctor.Wrap.Module.Wrap
             .app(PS.Control.Biapplicative.Module.bipure.app(dictBiapplicative)
                    .app(a)
                    .app(b))
        }
      })
  };
}