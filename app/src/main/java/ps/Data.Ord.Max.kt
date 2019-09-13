@file:Suppress("UNCHECKED_CAST")

package PS.Data.Ord.Max
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val Max = { x : Any -> x};
  @JvmField
  val showMax = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ v : Any ->
        val a = v;
          (("(Max " as String) + (((PS.Data.Show.Module.show.app(dictShow)
                                      .app(a
          ) as String) + (")" as String)) as String));})
  };
  @JvmField
  val semigroupMax = { dictOrd : Any ->
     PS.Data.Semigroup.Module.Semigroup
       .app({ v : Any ->
         { v1 : Any ->
          val x = v;
            val y = v1;
            PS.Data.Ord.Max.Module.Max
              .app(PS.Data.Ord.Module.max.app(dictOrd).app(x).app(y));}
      })
  };
  @JvmField
  val newtypeMax = PS.Data.Newtype.Module.Newtype
                     .app({ n : Any ->
                         val a = n;
                           a;})
                     .app(PS.Data.Ord.Max.Module.Max);
  @JvmField
  val monoidMax = { dictBounded : Any ->
     PS.Data.Monoid.Module.Monoid
       .app({ _ : Any ->
            PS.Data.Ord.Max.Module.semigroupMax
              .app((dictBounded as Map<String, Any>)["Ord0"]!!.app(Unit))
         })
       .app(PS.Data.Ord.Max.Module.Max
              .app(PS.Data.Bounded.Module.bottom.app(dictBounded)))
  };
  @JvmField val eqMax = { dictEq : Any -> dictEq};
  @JvmField
  val ordMax = { dictOrd : Any ->
     PS.Data.Ord.Module.Ord
       .app({ _ : Any ->
            PS.Data.Ord.Max.Module.eqMax
              .app((dictOrd as Map<String, Any>)["Eq0"]!!.app(Unit))
         })
       .app({ v : Any ->
         { v1 : Any ->
          val x = v;
            val y = v1;
            PS.Data.Ord.Module.compare.app(dictOrd).app(x).app(y);}
      })
  };
}