@file:Suppress("UNCHECKED_CAST")
package PS.Data.Monoid.Endo
import Foreign.PsRuntime.app
object Module  {
  @JvmField val Endo = { x : Any -> x};
  @JvmField
  val showEndo = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ v : Any ->
         when {
          else -> {
            val x = v;
            (("(Endo " as String) + (((PS.Data.Show.Module.show.app(dictShow)
                                         .app(x
            ) as String) + (")" as String)) as String));
          }
        }
      })
  };
  @JvmField
  val semigroupEndo = { dictSemigroupoid : Any ->
     PS.Data.Semigroup.Module.Semigroup
       .app({ v : Any ->
         { v1 : Any ->
           when {
            else -> {
              val a = v;
              val b = v1;
              PS.Data.Monoid.Endo.Module.Endo
                .app(PS.Control.Semigroupoid.Module.compose
                       .app(dictSemigroupoid)
                       .app(a)
                       .app(b));
            }
          }
        }
      })
  };
  @JvmField val ordEndo = { dictOrd : Any -> dictOrd};
  @JvmField
  val monoidEndo = { dictCategory : Any ->
     PS.Data.Monoid.Module.Monoid
       .app({ _ : Any ->
            PS.Data.Monoid.Endo.Module.semigroupEndo
              .app((dictCategory as Map<String, Any>)["Semigroupoid0"]!!
                     .app(Unit))
         })
       .app(PS.Data.Monoid.Endo.Module.Endo
              .app(PS.Control.Category.Module.identity.app(dictCategory)))
  };
  @JvmField val eqEndo = { dictEq : Any -> dictEq};
  @JvmField val boundedEndo = { dictBounded : Any -> dictBounded};
}