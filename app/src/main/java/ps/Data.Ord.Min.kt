@file:Suppress("UNCHECKED_CAST")
package PS.Data.Ord.Min
import Foreign.PsRuntime.app
object Module  {
  @JvmField val Min = { x : Any -> x};
  @JvmField
  val showMin = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ v : Any ->
         when {
          else -> {
            val a = v;
            (("(Min " as String) + (((PS.Data.Show.Module.show.app(dictShow)
                                        .app(a
            ) as String) + (")" as String)) as String));
          }
        }
      })
  };
  @JvmField
  val semigroupMin = { dictOrd : Any ->
     PS.Data.Semigroup.Module.Semigroup
       .app({ v : Any ->
         { v1 : Any ->
           when {
            else -> {
              val x = v;
              val y = v1;
              PS.Data.Ord.Min.Module.Min
                .app(PS.Data.Ord.Module.min.app(dictOrd).app(x).app(y));
            }
          }
        }
      })
  };
  @JvmField
  val newtypeMin = PS.Data.Newtype.Module.Newtype
                     .app({ n : Any ->
                          when {
                           else -> {
                             val a = n;
                             a;
                           }
                         }
                       })
                     .app(PS.Data.Ord.Min.Module.Min);
  @JvmField
  val monoidMin = { dictBounded : Any ->
     PS.Data.Monoid.Module.Monoid
       .app({ _ : Any ->
            PS.Data.Ord.Min.Module.semigroupMin
              .app((dictBounded as Map<String, Any>)["Ord0"]!!.app(Unit))
         })
       .app(PS.Data.Ord.Min.Module.Min
              .app(PS.Data.Bounded.Module.top.app(dictBounded)))
  };
  @JvmField val eqMin = { dictEq : Any -> dictEq};
  @JvmField
  val ordMin = { dictOrd : Any ->
     PS.Data.Ord.Module.Ord
       .app({ _ : Any ->
            PS.Data.Ord.Min.Module.eqMin
              .app((dictOrd as Map<String, Any>)["Eq0"]!!.app(Unit))
         })
       .app({ v : Any ->
         { v1 : Any ->
           when {
            else -> {
              val x = v;
              val y = v1;
              PS.Data.Ord.Module.compare.app(dictOrd).app(x).app(y);
            }
          }
        }
      })
  };
}