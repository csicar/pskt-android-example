@file:Suppress("UNCHECKED_CAST")

package PS.Effect.Exception
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  val showErrorImpl = Foreign.Effect.Exception.showErrorImpl;
  val error = Foreign.Effect.Exception.error;
  val message = Foreign.Effect.Exception.message;
  val name = Foreign.Effect.Exception.name;
  val stackImpl = Foreign.Effect.Exception.stackImpl;
  val throwException = Foreign.Effect.Exception.throwException;
  val catchException = Foreign.Effect.Exception.catchException;
  @JvmField
  val _try = { action : Any ->
     PS.Effect.Exception.Module.catchException
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Control.Applicative.Module.pure
                     .app(PS.Effect.Module.applicativeEffect))
              .app(PS.Data.Either.Module.Left))
       .app(PS.Data.Functor.Module.map.app(PS.Effect.Module.functorEffect)
              .app(PS.Data.Either.Module.Right)
              .app(action))
  };
  @JvmField
  val _throw = PS.Control.Semigroupoid.Module.compose
                 .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                 .app(PS.Effect.Exception.Module.throwException)
                 .app(PS.Effect.Exception.Module.error);
  @JvmField
  val stack = PS.Effect.Exception.Module.stackImpl
                .app(PS.Data.Maybe.Module.Just)
                .app(PS.Data.Maybe.Module.Nothing);
  @JvmField
  val showError = PS.Data.Show.Module.Show
                    .app(PS.Effect.Exception.Module.showErrorImpl);
}