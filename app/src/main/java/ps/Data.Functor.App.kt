@file:Suppress("UNCHECKED_CAST")

package PS.Data.Functor.App
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val App = { x : Any -> x};
  @JvmField
  val traversableWithIndexApp = { dictTraversableWithIndex : Any ->
     dictTraversableWithIndex
  };
  @JvmField val traversableApp = { dictTraversable : Any -> dictTraversable};
  @JvmField
  val showApp = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ v : Any ->
        val fa = v;
          (("(App " as String) + (((PS.Data.Show.Module.show.app(dictShow)
                                      .app(fa
          ) as String) + (")" as String)) as String));})
  };
  @JvmField
  val semigroupApp = { dictApply : Any ->
     { dictSemigroup : Any ->
       PS.Data.Semigroup.Module.Semigroup
         .app({ v : Any ->
           { v1 : Any ->
            val fa1 = v;
              val fa2 = v1;
              PS.Data.Functor.App.Module.App
                .app(PS.Control.Apply.Module.lift2.app(dictApply)
                       .app(PS.Data.Semigroup.Module.append.app(dictSemigroup))
                       .app(fa1)
                       .app(fa2));}
        })
    }
  };
  @JvmField val plusApp = { dictPlus : Any -> dictPlus};
  @JvmField
  val newtypeApp = PS.Data.Newtype.Module.Newtype
                     .app({ n : Any ->
                         val a = n;
                           a;})
                     .app(PS.Data.Functor.App.Module.App);
  @JvmField
  val monoidApp = { dictApplicative : Any ->
     { dictMonoid : Any ->
       PS.Data.Monoid.Module.Monoid
         .app({ _ : Any ->
              PS.Data.Functor.App.Module.semigroupApp
                .app((dictApplicative as Map<String, Any>)["Apply0"]!!.app(Unit)
                )
                .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!.app(Unit))
           })
         .app(PS.Data.Functor.App.Module.App
                .app(PS.Control.Applicative.Module.pure.app(dictApplicative)
                       .app(PS.Data.Monoid.Module.mempty.app(dictMonoid))))
    }
  };
  @JvmField val monadZeroApp = { dictMonadZero : Any -> dictMonadZero};
  @JvmField val monadPlusApp = { dictMonadPlus : Any -> dictMonadPlus};
  @JvmField val monadApp = { dictMonad : Any -> dictMonad};
  @JvmField val lazyApp = { dictLazy : Any -> dictLazy};
  @JvmField val hoistLowerApp = PS.Unsafe.Coerce.Module.unsafeCoerce;
  @JvmField val hoistLiftApp = PS.Unsafe.Coerce.Module.unsafeCoerce;
  @JvmField
  val hoistApp = { f : Any ->
     { v : Any ->
      val f1 = f;
        val fa = v;
        PS.Data.Functor.App.Module.App.app(f1.app(fa));}
  };
  @JvmField
  val functorWithIndexApp = { dictFunctorWithIndex : Any ->
     dictFunctorWithIndex
  };
  @JvmField val functorApp = { dictFunctor : Any -> dictFunctor};
  @JvmField
  val foldableWithIndexApp = { dictFoldableWithIndex : Any ->
     dictFoldableWithIndex
  };
  @JvmField val foldableApp = { dictFoldable : Any -> dictFoldable};
  @JvmField val extendApp = { dictExtend : Any -> dictExtend};
  @JvmField
  val eqApp = { dictEq1 : Any ->
     { dictEq : Any ->
       PS.Data.Eq.Module.Eq
         .app({ x : Any ->
           { y : Any ->
            val l = x;
              val r = y;
              PS.Data.Eq.Module.eq1.app(dictEq1).app(dictEq).app(l).app(r);}
        })
    }
  };
  @JvmField
  val ordApp = { dictOrd1 : Any ->
     { dictOrd : Any ->
       PS.Data.Ord.Module.Ord
         .app({ _ : Any ->
              PS.Data.Functor.App.Module.eqApp
                .app((dictOrd1 as Map<String, Any>)["Eq10"]!!.app(Unit))
                .app((dictOrd as Map<String, Any>)["Eq0"]!!.app(Unit))
           })
         .app({ x : Any ->
           { y : Any ->
            val l = x;
              val r = y;
              PS.Data.Ord.Module.compare1.app(dictOrd1).app(dictOrd).app(l)
                .app(r);}
        })
    }
  };
  @JvmField
  val eq1App = { dictEq1 : Any ->
     PS.Data.Eq.Module.Eq1
       .app({ dictEq : Any ->
         PS.Data.Eq.Module.eq
           .app(PS.Data.Functor.App.Module.eqApp.app(dictEq1).app(dictEq))
      })
  };
  @JvmField
  val ord1App = { dictOrd1 : Any ->
     PS.Data.Ord.Module.Ord1
       .app({ _ : Any ->
            PS.Data.Functor.App.Module.eq1App
              .app((dictOrd1 as Map<String, Any>)["Eq10"]!!.app(Unit))
         })
       .app({ dictOrd : Any ->
         PS.Data.Ord.Module.compare
           .app(PS.Data.Functor.App.Module.ordApp.app(dictOrd1).app(dictOrd))
      })
  };
  @JvmField val comonadApp = { dictComonad : Any -> dictComonad};
  @JvmField val bindApp = { dictBind : Any -> dictBind};
  @JvmField val applyApp = { dictApply : Any -> dictApply};
  @JvmField val applicativeApp = { dictApplicative : Any -> dictApplicative};
  @JvmField val alternativeApp = { dictAlternative : Any -> dictAlternative};
  @JvmField val altApp = { dictAlt : Any -> dictAlt};
}