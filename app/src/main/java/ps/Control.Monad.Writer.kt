@file:Suppress("UNCHECKED_CAST")

package PS.Control.Monad.Writer
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val writer = PS.Control.Semigroupoid.Module.compose
                 .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                 .app(PS.Control.Monad.Writer.Trans.Module.WriterT)
                 .app(PS.Control.Applicative.Module.pure
                        .app(PS.Data.Identity.Module.applicativeIdentity));
  @JvmField
  val runWriter = PS.Control.Semigroupoid.Module.compose
                    .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                    .app(PS.Data.Newtype.Module.unwrap
                           .app(PS.Data.Identity.Module.newtypeIdentity))
                    .app(PS.Control.Monad.Writer.Trans.Module.runWriterT);
  @JvmField
  val mapWriter = { f : Any ->
     PS.Control.Monad.Writer.Trans.Module.mapWriterT
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Data.Identity.Module.Identity)
              .app(PS.Control.Semigroupoid.Module.compose
                     .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                     .app(f)
                     .app(PS.Data.Newtype.Module.unwrap
                            .app(PS.Data.Identity.Module.newtypeIdentity))))
  };
  @JvmField
  val execWriter = { m : Any ->
     PS.Data.Tuple.Module.snd
       .app(PS.Control.Monad.Writer.Module.runWriter.app(m))
  };
}