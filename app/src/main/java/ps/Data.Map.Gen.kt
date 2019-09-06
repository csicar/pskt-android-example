@file:Suppress("UNCHECKED_CAST")
package PS.Data.Map.Gen
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val genMap = { dictMonadRec : Any ->
     { dictMonadGen : Any ->
       { dictOrd : Any ->
         { genKey : Any ->
           { genValue : Any ->
             PS.Control.Monad.Gen.Class.Module.sized.app(dictMonadGen)
               .app({ size : Any ->
                 PS.Control.Bind.Module.bind
                   .app(((dictMonadGen as Map<String, Any>)["Monad0"]!!
                           .app(Unit) as Map<String, Any>)["Bind1"]!!
                          .app(Unit))
                   .app(PS.Control.Monad.Gen.Class.Module.chooseInt
                          .app(dictMonadGen)
                          .app(0)
                          .app(size))
                   .app({ v : Any ->
                     when {
                      else -> {
                        val newSize = v;
                        PS.Data.Function.Module.apply
                          .app(PS.Control.Monad.Gen.Class.Module.resize
                                 .app(dictMonadGen)
                                 .app(PS.Data.Function.Module._const
                                        .app(newSize)))
                          .app(PS.Data.Functor.Module.map
                                 .app(
                                   ((((dictMonadGen as Map<String, Any>)["Monad0"]!!
                                        .app(Unit
                                       ) as Map<String, Any>)["Bind1"]!!
                                       .app(Unit
                                      ) as Map<String, Any>)["Apply0"]!!
                                      .app(Unit
                                     ) as Map<String, Any>)["Functor0"]!!
                                     .app(Unit))
                                 .app(PS.Data.Map.Internal.Module.fromFoldable
                                        .app(dictOrd)
                                        .app(
                                     PS.Data.List.Types.Module.foldableList))
                                 .app(PS.Control.Monad.Gen.Module.unfoldable
                                        .app(dictMonadRec)
                                        .app(dictMonadGen)
                                        .app(
                                          PS.Data.List.Types.Module.unfoldableList
                                        )
                                        .app(PS.Control.Apply.Module.apply
                                               .app(
                                                 (((dictMonadGen as Map<String, Any>)["Monad0"]!!
                                                     .app(Unit
                                                    ) as Map<String, Any>)["Bind1"]!!
                                                    .app(Unit
                                                   ) as Map<String, Any>)["Apply0"]!!
                                                   .app(Unit))
                                               .app(PS.Data.Functor.Module.map
                                                      .app(
                                                        ((((dictMonadGen as Map<String, Any>)["Monad0"]!!
                                                             .app(Unit
                                                            ) as Map<String, Any>)["Bind1"]!!
                                                            .app(Unit
                                                           ) as Map<String, Any>)["Apply0"]!!
                                                           .app(Unit
                                                          ) as Map<String, Any>)["Functor0"]!!
                                                          .app(Unit))
                                                      .app(
                                                        PS.Data.Tuple.Module.Tuple
                                                      )
                                                      .app(genKey))
                                               .app(genValue))));
                      }
                    }
                  })
              })
          }
        }
      }
    }
  };
}