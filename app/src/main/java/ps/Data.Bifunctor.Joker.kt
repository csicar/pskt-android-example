@file:Suppress("UNCHECKED_CAST")

package PS.Data.Bifunctor.Joker
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val Joker = { x : Any -> x};
  @JvmField
  val showJoker = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ v : Any ->
        val x = v;
          (("(Joker " as String) + (((PS.Data.Show.Module.show.app(dictShow)
                                        .app(x
          ) as String) + (")" as String)) as String));})
  };
  @JvmField val ordJoker = { dictOrd : Any -> dictOrd};
  @JvmField
  val newtypeJoker = PS.Data.Newtype.Module.Newtype
                       .app({ n : Any ->
                           val a = n;
                             a;})
                       .app(PS.Data.Bifunctor.Joker.Module.Joker);
  @JvmField
  val functorJoker = { dictFunctor : Any ->
     PS.Data.Functor.Module.Functor
       .app({ g : Any ->
         { v : Any ->
          val g1 = g;
            val a = v;
            PS.Data.Bifunctor.Joker.Module.Joker
              .app(PS.Data.Functor.Module.map.app(dictFunctor).app(g1).app(a));}
      })
  };
  @JvmField val eqJoker = { dictEq : Any -> dictEq};
  @JvmField
  val bifunctorJoker = { dictFunctor : Any ->
     PS.Data.Bifunctor.Module.Bifunctor
       .app({ v : Any ->
         { g : Any ->
           { v1 : Any ->
            val g1 = g;
              val a = v1;
              PS.Data.Bifunctor.Joker.Module.Joker
                .app(PS.Data.Functor.Module.map.app(dictFunctor).app(g1).app(a)
              );}
        }
      })
  };
  @JvmField
  val biapplyJoker = { dictApply : Any ->
     PS.Control.Biapply.Module.Biapply
       .app({ _ : Any ->
            PS.Data.Bifunctor.Joker.Module.bifunctorJoker
              .app((dictApply as Map<String, Any>)["Functor0"]!!.app(Unit))
         })
       .app({ v : Any ->
         { v1 : Any ->
          val fg = v;
            val xy = v1;
            PS.Data.Bifunctor.Joker.Module.Joker
              .app(PS.Control.Apply.Module.apply.app(dictApply).app(fg).app(xy)
            );}
      })
  };
  @JvmField
  val biapplicativeJoker = { dictApplicative : Any ->
     PS.Control.Biapplicative.Module.Biapplicative
       .app({ _ : Any ->
            PS.Data.Bifunctor.Joker.Module.biapplyJoker
              .app((dictApplicative as Map<String, Any>)["Apply0"]!!.app(Unit))
         })
       .app({ v : Any ->
         { b : Any ->
           PS.Data.Bifunctor.Joker.Module.Joker
             .app(PS.Control.Applicative.Module.pure.app(dictApplicative).app(b)
          )
        }
      })
  };
}