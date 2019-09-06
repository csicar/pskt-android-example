@file:Suppress("UNCHECKED_CAST")
package PS.Data.Op
import Foreign.PsRuntime.app
object Module  {
  @JvmField val Op = { x : Any -> x};
  @JvmField
  val semigroupoidOp = PS.Control.Semigroupoid.Module.Semigroupoid
                         .app({ v : Any ->
       { v1 : Any ->
         when {
          else -> {
            val f = v;
            val g = v1;
            PS.Data.Op.Module.Op
              .app(PS.Control.Semigroupoid.Module.compose
                     .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                     .app(g)
                     .app(f));
          }
        }
      }
    });
  @JvmField
  val semigroupOp = { dictSemigroup : Any ->
     PS.Data.Semigroup.Module.semigroupFn.app(dictSemigroup)
  };
  @JvmField
  val newtypeOp = PS.Data.Newtype.Module.Newtype
                    .app({ n : Any ->
                         when {
                          else -> {
                            val a = n;
                            a;
                          }
                        }
                      })
                    .app(PS.Data.Op.Module.Op);
  @JvmField
  val monoidOp = { dictMonoid : Any ->
     PS.Data.Monoid.Module.monoidFn.app(dictMonoid)
  };
  @JvmField
  val contravariantOp = PS.Data.Functor.Contravariant.Module.Contravariant
                          .app({ f : Any ->
       { v : Any ->
         when {
          else -> {
            val f1 = f;
            val g = v;
            PS.Data.Op.Module.Op
              .app(PS.Control.Semigroupoid.Module.compose
                     .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                     .app(g)
                     .app(f1));
          }
        }
      }
    });
  @JvmField
  val categoryOp = PS.Control.Category.Module.Category
                     .app({ _ : Any ->
                          PS.Data.Op.Module.semigroupoidOp
                       })
                     .app(PS.Data.Op.Module.Op
                            .app(PS.Control.Category.Module.identity
                                   .app(PS.Control.Category.Module.categoryFn))
  );
}