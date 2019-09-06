@file:Suppress("UNCHECKED_CAST")
package PS.Data.Bifunctor.Flip
import Foreign.PsRuntime.app
object Module  {
  @JvmField val Flip = { x : Any -> x};
  @JvmField
  val showFlip = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ v : Any ->
         when {
          else -> {
            val x = v;
            (("(Flip " as String) + (((PS.Data.Show.Module.show.app(dictShow)
                                         .app(x
            ) as String) + (")" as String)) as String));
          }
        }
      })
  };
  @JvmField val ordFlip = { dictOrd : Any -> dictOrd};
  @JvmField
  val newtypeFlip = PS.Data.Newtype.Module.Newtype
                      .app({ n : Any ->
                           when {
                            else -> {
                              val a = n;
                              a;
                            }
                          }
                        })
                      .app(PS.Data.Bifunctor.Flip.Module.Flip);
  @JvmField
  val functorFlip = { dictBifunctor : Any ->
     PS.Data.Functor.Module.Functor
       .app({ f : Any ->
         { v : Any ->
           when {
            else -> {
              val f1 = f;
              val a = v;
              PS.Data.Bifunctor.Flip.Module.Flip
                .app(PS.Data.Bifunctor.Module.lmap.app(dictBifunctor).app(f1)
                       .app(a));
            }
          }
        }
      })
  };
  @JvmField val eqFlip = { dictEq : Any -> dictEq};
  @JvmField
  val bifunctorFlip = { dictBifunctor : Any ->
     PS.Data.Bifunctor.Module.Bifunctor
       .app({ f : Any ->
         { g : Any ->
           { v : Any ->
             when {
              else -> {
                val f1 = f;
                val g1 = g;
                val a = v;
                PS.Data.Bifunctor.Flip.Module.Flip
                  .app(PS.Data.Bifunctor.Module.bimap.app(dictBifunctor).app(g1)
                         .app(f1)
                         .app(a));
              }
            }
          }
        }
      })
  };
  @JvmField
  val biapplyFlip = { dictBiapply : Any ->
     PS.Control.Biapply.Module.Biapply
       .app({ _ : Any ->
            PS.Data.Bifunctor.Flip.Module.bifunctorFlip
              .app((dictBiapply as Map<String, Any>)["Bifunctor0"]!!.app(Unit))
         })
       .app({ v : Any ->
         { v1 : Any ->
           when {
            else -> {
              val fg = v;
              val xy = v1;
              PS.Data.Bifunctor.Flip.Module.Flip
                .app(PS.Control.Biapply.Module.biapply.app(dictBiapply).app(fg)
                       .app(xy));
            }
          }
        }
      })
  };
  @JvmField
  val biapplicativeFlip = { dictBiapplicative : Any ->
     PS.Control.Biapplicative.Module.Biapplicative
       .app({ _ : Any ->
            PS.Data.Bifunctor.Flip.Module.biapplyFlip
              .app((dictBiapplicative as Map<String, Any>)["Biapply0"]!!
                     .app(Unit))
         })
       .app({ a : Any ->
         { b : Any ->
           PS.Data.Bifunctor.Flip.Module.Flip
             .app(PS.Control.Biapplicative.Module.bipure.app(dictBiapplicative)
                    .app(b)
                    .app(a))
        }
      })
  };
}