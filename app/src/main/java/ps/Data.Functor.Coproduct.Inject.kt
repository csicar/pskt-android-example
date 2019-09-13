@file:Suppress("UNCHECKED_CAST")

package PS.Data.Functor.Coproduct.Inject
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val Inject = { inj : Any ->
     { prj : Any ->
       mapOf(("inj" to inj),  ("prj" to prj))
    }
  };
  @JvmField val prj = { dict : Any -> (dict as Map<String, Any>)["prj"]!!};
  @JvmField
  val injectReflexive = PS.Data.Functor.Coproduct.Inject.Module.Inject
                          .app(PS.Control.Category.Module.identity
                                 .app(PS.Control.Category.Module.categoryFn))
                          .app(PS.Data.Maybe.Module.Just);
  @JvmField
  val injectLeft = PS.Data.Functor.Coproduct.Inject.Module.Inject
                     .app(PS.Control.Semigroupoid.Module.compose
                            .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                            .app(PS.Data.Functor.Coproduct.Module.Coproduct)
                            .app(PS.Data.Either.Module.Left))
                     .app(PS.Data.Functor.Coproduct.Module.coproduct
                            .app(PS.Data.Maybe.Module.Just)
                            .app(PS.Data.Function.Module._const
                                   .app(PS.Data.Maybe.Module.Nothing)));
  @JvmField val inj = { dict : Any -> (dict as Map<String, Any>)["inj"]!!};
  @JvmField
  val injectRight = { dictInject : Any ->
     PS.Data.Functor.Coproduct.Inject.Module.Inject
       .app(PS.Control.Semigroupoid.Module.compose
              .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
              .app(PS.Data.Functor.Coproduct.Module.Coproduct)
              .app(PS.Control.Semigroupoid.Module.compose
                     .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                     .app(PS.Data.Either.Module.Right)
                     .app(PS.Data.Functor.Coproduct.Inject.Module.inj
                            .app(dictInject))))
       .app(PS.Data.Functor.Coproduct.Module.coproduct
              .app(PS.Data.Function.Module._const
                     .app(PS.Data.Maybe.Module.Nothing))
              .app(PS.Data.Functor.Coproduct.Inject.Module.prj.app(dictInject)))
  };
}