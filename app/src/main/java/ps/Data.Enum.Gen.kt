@file:Suppress("UNCHECKED_CAST")
package PS.Data.Enum.Gen
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val genBoundedEnum = { dictMonadGen : Any ->
     { dictBoundedEnum : Any ->
       object   {
           val v = PS.Data.Enum.Module.succ
                     .app((dictBoundedEnum as Map<String, Any>)["Enum1"]!!
                            .app(Unit))
                     .app(PS.Data.Bounded.Module.bottom
                            .app(
               (dictBoundedEnum as Map<String, Any>)["Bounded0"]!!.app(Unit)));
         }
         .run({
          val v = this.v;
          when {
            (v is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
              val a = v.value0;
              object   {
                  val possibilities = PS.Data.Enum.Module.enumFromTo
                                        .app(
                                          (dictBoundedEnum as Map<String, Any>)["Enum1"]!!
                                            .app(Unit))
                                        .app(
                                          PS.Data.Unfoldable1.Module.unfoldable1Array
                                        )
                                        .app(a)
                                        .app(PS.Data.Bounded.Module.top
                                               .app(
                      (dictBoundedEnum as Map<String, Any>)["Bounded0"]!!
                        .app(Unit)));
                }
                .run({
                  val possibilities = this.possibilities;
                  PS.Control.Monad.Gen.Module.elements.app(dictMonadGen)
                    .app(PS.Data.NonEmpty.Module.foldable1NonEmpty
                           .app(PS.Data.Foldable.Module.foldableArray))
                    .app(PS.Data.NonEmpty.Module.NonEmpty
                           .app(PS.Data.Bounded.Module.bottom
                                  .app(
                               (dictBoundedEnum as Map<String, Any>)["Bounded0"]!!
                                 .app(Unit)))
                           .app(possibilities));
                });
            }
            (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
              PS.Control.Applicative.Module.pure
                .app(((dictMonadGen as Map<String, Any>)["Monad0"]!!
                        .app(Unit) as Map<String, Any>)["Applicative0"]!!
                       .app(Unit))
                .app(PS.Data.Bounded.Module.bottom
                       .app((dictBoundedEnum as Map<String, Any>)["Bounded0"]!!
                              .app(Unit)));
            }
            else -> (error("Error in Pattern Match") as Any)
          };
        })
    }
  };
}