@file:Suppress("UNCHECKED_CAST")

package PS.Data.Bifunctor.Clown
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val Clown = { x : Any -> x};
  @JvmField
  val showClown = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ v : Any ->
        val x = v;
          (("(Clown " as String) + (((PS.Data.Show.Module.show.app(dictShow)
                                        .app(x
          ) as String) + (")" as String)) as String));})
  };
  @JvmField val ordClown = { dictOrd : Any -> dictOrd};
  @JvmField
  val newtypeClown = PS.Data.Newtype.Module.Newtype
                       .app({ n : Any ->
                           val a = n;
                             a;})
                       .app(PS.Data.Bifunctor.Clown.Module.Clown);
  @JvmField
  val functorClown = PS.Data.Functor.Module.Functor
                       .app({ v : Any ->
       { v1 : Any ->
        val a = v1;
          PS.Data.Bifunctor.Clown.Module.Clown.app(a);}
    });
  @JvmField val eqClown = { dictEq : Any -> dictEq};
  @JvmField
  val bifunctorClown = { dictFunctor : Any ->
     PS.Data.Bifunctor.Module.Bifunctor
       .app({ f : Any ->
         { v : Any ->
           { v1 : Any ->
            val f1 = f;
              val a = v1;
              PS.Data.Bifunctor.Clown.Module.Clown
                .app(PS.Data.Functor.Module.map.app(dictFunctor).app(f1).app(a)
              );}
        }
      })
  };
  @JvmField
  val biapplyClown = { dictApply : Any ->
     PS.Control.Biapply.Module.Biapply
       .app({ _ : Any ->
            PS.Data.Bifunctor.Clown.Module.bifunctorClown
              .app((dictApply as Map<String, Any>)["Functor0"]!!.app(Unit))
         })
       .app({ v : Any ->
         { v1 : Any ->
          val fg = v;
            val xy = v1;
            PS.Data.Bifunctor.Clown.Module.Clown
              .app(PS.Control.Apply.Module.apply.app(dictApply).app(fg).app(xy)
            );}
      })
  };
  @JvmField
  val biapplicativeClown = { dictApplicative : Any ->
     PS.Control.Biapplicative.Module.Biapplicative
       .app({ _ : Any ->
            PS.Data.Bifunctor.Clown.Module.biapplyClown
              .app((dictApplicative as Map<String, Any>)["Apply0"]!!.app(Unit))
         })
       .app({ a : Any ->
         { v : Any ->
           PS.Data.Bifunctor.Clown.Module.Clown
             .app(PS.Control.Applicative.Module.pure.app(dictApplicative).app(a)
          )
        }
      })
  };
}