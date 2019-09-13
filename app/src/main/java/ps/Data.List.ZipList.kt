@file:Suppress("UNCHECKED_CAST")

package PS.Data.List.ZipList
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val ZipList = { x : Any -> x};
  @JvmField
  val traversableZipList = PS.Data.List.Lazy.Types.Module.traversableList;
  @JvmField
  val showZipList = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ v : Any ->
        val xs = v;
          (("(ZipList " as String) + (((PS.Data.Show.Module.show
                                          .app(
                                            PS.Data.List.Lazy.Types.Module.showList
                                              .app(dictShow))
                                          .app(xs
          ) as String) + (")" as String)) as String));})
  };
  @JvmField val semigroupZipList = PS.Data.List.Lazy.Types.Module.semigroupList;
  @JvmField
  val ordZipList = { dictOrd : Any ->
     PS.Data.List.Lazy.Types.Module.ordList.app(dictOrd)
  };
  @JvmField
  val newtypeZipList = PS.Data.Newtype.Module.Newtype
                         .app({ n : Any ->
                             val a = n;
                               a;})
                         .app(PS.Data.List.ZipList.Module.ZipList);
  @JvmField val monoidZipList = PS.Data.List.Lazy.Types.Module.monoidList;
  @JvmField val functorZipList = PS.Data.List.Lazy.Types.Module.functorList;
  @JvmField val foldableZipList = PS.Data.List.Lazy.Types.Module.foldableList;
  @JvmField
  val eqZipList = { dictEq : Any ->
     PS.Data.List.Lazy.Types.Module.eqList.app(dictEq)
  };
  @JvmField
  val applyZipList = PS.Control.Apply.Module.Apply
                       .app({ _ : Any ->
                            PS.Data.List.ZipList.Module.functorZipList
                         })
                       .app({ v : Any ->
       { v1 : Any ->
        val fs = v;
          val xs = v1;
          PS.Data.List.ZipList.Module.ZipList
            .app(PS.Data.List.Lazy.Module.zipWith
                   .app(PS.Data.Function.Module.apply)
                   .app(fs)
                   .app(xs));}
    });
  @JvmField
  val zipListIsNotBind = { dictFail : Any ->
     PS.Control.Bind.Module.Bind
       .app({ _ : Any ->
            PS.Data.List.ZipList.Module.applyZipList
         })
       .app(PS.Partial.Unsafe.Module.unsafeCrashWith.app("bind: unreachable"))
  };
  @JvmField
  val applicativeZipList = PS.Control.Applicative.Module.Applicative
                             .app({ _ : Any ->
                                  PS.Data.List.ZipList.Module.applyZipList
                               })
                             .app(PS.Control.Semigroupoid.Module.compose
                                    .app(
                                      PS.Control.Semigroupoid.Module.semigroupoidFn
                                    )
                                    .app(PS.Data.List.ZipList.Module.ZipList)
                                    .app(PS.Data.List.Lazy.Module.repeat));
  @JvmField
  val altZipList = PS.Control.Alt.Module.Alt
                     .app({ _ : Any ->
                          PS.Data.List.ZipList.Module.functorZipList
                       })
                     .app(PS.Data.Semigroup.Module.append
                            .app(PS.Data.List.ZipList.Module.semigroupZipList));
  @JvmField
  val plusZipList = PS.Control.Plus.Module.Plus
                      .app({ _ : Any ->
                           PS.Data.List.ZipList.Module.altZipList
                        })
                      .app(PS.Data.Monoid.Module.mempty
                             .app(PS.Data.List.ZipList.Module.monoidZipList));
  @JvmField
  val alternativeZipList = PS.Control.Alternative.Module.Alternative
                             .app({ _ : Any ->
                                  PS.Data.List.ZipList.Module.applicativeZipList
                               })
                             .app({ _ : Any ->
       PS.Data.List.ZipList.Module.plusZipList
    });
}