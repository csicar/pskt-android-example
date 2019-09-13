@file:Suppress("UNCHECKED_CAST")

package PS.Data.Bifunctor.Join
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val Join = { x : Any -> x};
  @JvmField
  val showJoin = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ v : Any ->
        val x = v;
          (("(Join " as String) + (((PS.Data.Show.Module.show.app(dictShow)
                                       .app(x
          ) as String) + (")" as String)) as String));})
  };
  @JvmField val ordJoin = { dictOrd : Any -> dictOrd};
  @JvmField
  val newtypeJoin = PS.Data.Newtype.Module.Newtype
                      .app({ n : Any ->
                          val a = n;
                            a;})
                      .app(PS.Data.Bifunctor.Join.Module.Join);
  @JvmField val eqJoin = { dictEq : Any -> dictEq};
  @JvmField
  val bifunctorJoin = { dictBifunctor : Any ->
     PS.Data.Functor.Module.Functor
       .app({ f : Any ->
         { v : Any ->
          val f1 = f;
            val a = v;
            PS.Data.Bifunctor.Join.Module.Join
              .app(PS.Data.Bifunctor.Module.bimap.app(dictBifunctor).app(f1)
                     .app(f1)
                     .app(a));}
      })
  };
  @JvmField
  val biapplyJoin = { dictBiapply : Any ->
     PS.Control.Apply.Module.Apply
       .app({ _ : Any ->
            PS.Data.Bifunctor.Join.Module.bifunctorJoin
              .app((dictBiapply as Map<String, Any>)["Bifunctor0"]!!.app(Unit))
         })
       .app({ v : Any ->
         { v1 : Any ->
          val f = v;
            val a = v1;
            PS.Data.Bifunctor.Join.Module.Join
              .app(PS.Control.Biapply.Module.biapply.app(dictBiapply).app(f)
                     .app(a));}
      })
  };
  @JvmField
  val biapplicativeJoin = { dictBiapplicative : Any ->
     PS.Control.Applicative.Module.Applicative
       .app({ _ : Any ->
            PS.Data.Bifunctor.Join.Module.biapplyJoin
              .app((dictBiapplicative as Map<String, Any>)["Biapply0"]!!
                     .app(Unit))
         })
       .app({ a : Any ->
         PS.Data.Bifunctor.Join.Module.Join
           .app(PS.Control.Biapplicative.Module.bipure.app(dictBiapplicative)
                  .app(a)
                  .app(a))
      })
  };
}