@file:Suppress("UNCHECKED_CAST")

package PS.Data.Monoid.Alternate
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val Alternate = { x : Any -> x};
  @JvmField
  val showAlternate = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ v : Any ->
        val a = v;
          (("(Alternate " as String) + (((PS.Data.Show.Module.show.app(dictShow)
                                            .app(a
          ) as String) + (")" as String)) as String));})
  };
  @JvmField
  val semigroupAlternate = { dictAlt : Any ->
     PS.Data.Semigroup.Module.Semigroup
       .app({ v : Any ->
         { v1 : Any ->
          val a = v;
            val b = v1;
            PS.Data.Monoid.Alternate.Module.Alternate
              .app(PS.Control.Alt.Module.alt.app(dictAlt).app(a).app(b));}
      })
  };
  @JvmField val plusAlternate = { dictPlus : Any -> dictPlus};
  @JvmField val ordAlternate = { dictOrd : Any -> dictOrd};
  @JvmField val ord1Alternate = { dictOrd1 : Any -> dictOrd1};
  @JvmField
  val monoidAlternate = { dictPlus : Any ->
     PS.Data.Monoid.Module.Monoid
       .app({ _ : Any ->
            PS.Data.Monoid.Alternate.Module.semigroupAlternate
              .app((dictPlus as Map<String, Any>)["Alt0"]!!.app(Unit))
         })
       .app(PS.Data.Monoid.Alternate.Module.Alternate
              .app(PS.Control.Plus.Module.empty.app(dictPlus)))
  };
  @JvmField val monadAlternate = { dictMonad : Any -> dictMonad};
  @JvmField val functorAlternate = { dictFunctor : Any -> dictFunctor};
  @JvmField val extendAlternate = { dictExtend : Any -> dictExtend};
  @JvmField val eqAlternate = { dictEq : Any -> dictEq};
  @JvmField val eq1Alternate = { dictEq1 : Any -> dictEq1};
  @JvmField val comonadAlternate = { dictComonad : Any -> dictComonad};
  @JvmField val boundedAlternate = { dictBounded : Any -> dictBounded};
  @JvmField val bindAlternate = { dictBind : Any -> dictBind};
  @JvmField val applyAlternate = { dictApply : Any -> dictApply};
  @JvmField
  val applicativeAlternate = { dictApplicative : Any ->
     dictApplicative
  };
  @JvmField
  val alternativeAlternate = { dictAlternative : Any ->
     dictAlternative
  };
  @JvmField val altAlternate = { dictAlt : Any -> dictAlt};
}