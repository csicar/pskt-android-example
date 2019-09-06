@file:Suppress("UNCHECKED_CAST")
package PS.Data.Predicate
import Foreign.PsRuntime.app
object Module  {
  @JvmField val Predicate = { x : Any -> x};
  @JvmField
  val newtypePredicate = PS.Data.Newtype.Module.Newtype
                           .app({ n : Any ->
                                when {
                                 else -> {
                                   val a = n;
                                   a;
                                 }
                               }
                             })
                           .app(PS.Data.Predicate.Module.Predicate);
  @JvmField
  val heytingAlgebraPredicate = PS.Data.HeytingAlgebra.Module.heytingAlgebraFunction
                                  .app(
    PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean);
  @JvmField
  val contravariantPredicate = PS.Data.Functor.Contravariant.Module.Contravariant
                                 .app({ f : Any ->
       { v : Any ->
         when {
          else -> {
            val f1 = f;
            val g = v;
            PS.Data.Predicate.Module.Predicate
              .app(PS.Control.Semigroupoid.Module.compose
                     .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                     .app(g)
                     .app(f1));
          }
        }
      }
    });
  @JvmField
  val booleanAlgebraPredicate = PS.Data.BooleanAlgebra.Module.booleanAlgebraFn
                                  .app(
    PS.Data.BooleanAlgebra.Module.booleanAlgebraBoolean);
}