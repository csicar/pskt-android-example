@file:Suppress("UNCHECKED_CAST")

package PS.Data.Ord.Down
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val Down = { x : Any -> x};
  @JvmField
  val showDown = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ v : Any ->
        val a = v;
          (("(Down " as String) + (((PS.Data.Show.Module.show.app(dictShow)
                                       .app(a
          ) as String) + (")" as String)) as String));})
  };
  @JvmField
  val newtypeDown = PS.Data.Newtype.Module.Newtype
                      .app({ n : Any ->
                          val a = n;
                            a;})
                      .app(PS.Data.Ord.Down.Module.Down);
  @JvmField val eqDown = { dictEq : Any -> dictEq};
  @JvmField
  val ordDown = { dictOrd : Any ->
     PS.Data.Ord.Module.Ord
       .app({ _ : Any ->
            PS.Data.Ord.Down.Module.eqDown
              .app((dictOrd as Map<String, Any>)["Eq0"]!!.app(Unit))
         })
       .app({ v : Any ->
         { v1 : Any ->
          val x = v;
            val y = v1;
            PS.Data.Ordering.Module.invert
              .app(PS.Data.Ord.Module.compare.app(dictOrd).app(x).app(y));}
      })
  };
  @JvmField
  val boundedDown = { dictBounded : Any ->
     PS.Data.Bounded.Module.Bounded
       .app({ _ : Any ->
            PS.Data.Ord.Down.Module.ordDown
              .app((dictBounded as Map<String, Any>)["Ord0"]!!.app(Unit))
         })
       .app(PS.Data.Ord.Down.Module.Down
              .app(PS.Data.Bounded.Module.top.app(dictBounded)))
       .app(PS.Data.Ord.Down.Module.Down
              .app(PS.Data.Bounded.Module.bottom.app(dictBounded)))
  };
}