@file:Suppress("UNCHECKED_CAST")
package PS.Main
import Foreign.PsRuntime.app
object Module  {
  val __textView = Foreign.Main.__textView;
  val __button = Foreign.Main.__button;
  val __editText = Foreign.Main.__editText;
  val __verticalLayout = Foreign.Main.__verticalLayout;
  val __onClick = Foreign.Main.__onClick;
  val __setTextViewText = Foreign.Main.__setTextViewText;
  val __getTextEditText = Foreign.Main.__getTextEditText;
  @JvmField val SetText = { setText : Any -> mapOf(("setText" to setText))};
  @JvmField val IsView = { toView : Any -> mapOf(("toView" to toView))};
  @JvmField val GetText = { getText : Any -> mapOf(("getText" to getText))};
  @JvmField
  val verticalLayout = PS.Effect.Uncurried.Module.runEffectFn2
                         .app(PS.Main.Module.__verticalLayout);
  @JvmField
  val toView = { dict : Any ->
     (dict as Map<String, Any>)["toView"]!!
  };
  @JvmField
  val textViewView = PS.Main.Module.IsView
                       .app(PS.Unsafe.Coerce.Module.unsafeCoerce);
  @JvmField
  val textView = PS.Effect.Uncurried.Module.runEffectFn2
                   .app(PS.Main.Module.__textView);
  @JvmField
  val setTextTextView = PS.Main.Module.SetText
                          .app(PS.Effect.Uncurried.Module.runEffectFn2
                                 .app(PS.Main.Module.__setTextViewText));
  @JvmField
  val setText = { dict : Any ->
     (dict as Map<String, Any>)["setText"]!!
  };
  @JvmField
  val onClick = { dictIsView : Any ->
     { v : Any ->
       PS.Effect.Uncurried.Module.runEffectFn2.app(PS.Main.Module.__onClick)
         .app(PS.Main.Module.toView.app(dictIsView).app(v))
    }
  };
  @JvmField
  val getTextEditText = PS.Main.Module.GetText
                          .app(PS.Effect.Uncurried.Module.runEffectFn1
                                 .app(PS.Main.Module.__getTextEditText));
  @JvmField
  val getText = { dict : Any ->
     (dict as Map<String, Any>)["getText"]!!
  };
  @JvmField
  val editText = PS.Effect.Uncurried.Module.runEffectFn2
                   .app(PS.Main.Module.__editText);
  @JvmField
  val buttonView = PS.Main.Module.IsView
                     .app(PS.Unsafe.Coerce.Module.unsafeCoerce);
  @JvmField
  val button = PS.Effect.Uncurried.Module.runEffectFn2
                 .app(PS.Main.Module.__button);
  @JvmField
  val main = { ctx : Any ->
     { _ : Any ->
      PS.Effect.Console.Module.log.app("in main")()
        PS.Data.Function.Module.apply
          .app(PS.Data.Functor.Module.void.app(PS.Effect.Module.functorEffect))
          .app(PS.Data.Function.Module.apply
                 .app(PS.Main.Module.verticalLayout.app(ctx))
                 .app({ vm : Any ->
               { _ : Any ->
                PS.Effect.Console.Module.log.app("in vertical layout")()
                  PS.Control.Bind.Module.bind.app(PS.Effect.Module.bindEffect)
                    .app(PS.Main.Module.editText.app(vm).app("1st Field"))
                    .app({ v : Any ->
                       when {
                        else -> {
                          val a = v;
                          PS.Control.Bind.Module.bind
                            .app(PS.Effect.Module.bindEffect)
                            .app(PS.Main.Module.editText.app(vm)
                                   .app("2nd Field"))
                            .app({ v1 : Any ->
                               when {
                                else -> {
                                  val b = v1;
                                  PS.Control.Bind.Module.bind
                                    .app(PS.Effect.Module.bindEffect)
                                    .app(PS.Main.Module.textView.app(vm)
                                           .app("result ="))
                                    .app({ v2 : Any ->
                                       when {
                                        else -> {
                                          val res = v2;
                                          PS.Control.Bind.Module.bind
                                            .app(PS.Effect.Module.bindEffect)
                                            .app(PS.Main.Module.button.app(vm)
                                                   .app("click"))
                                            .app({ v3 : Any ->
                                               when {
                                                else -> {
                                                  val btn = v3;
                                                  PS.Data.Function.Module.apply
                                                    .app(PS.Main.Module.onClick
                                                           .app(
                                                             PS.Main.Module.buttonView
                                                           )
                                                           .app(btn))
                                                    .app({ v4 : Any ->
                                                       PS.Control.Bind.Module.bind
                                                         .app(
                                                           PS.Effect.Module.bindEffect
                                                         )
                                                         .app(
                                                           PS.Main.Module.getText
                                                             .app(
                                                               PS.Main.Module.getTextEditText
                                                             )
                                                             .app(a))
                                                         .app({ v5 : Any ->
                                                           when {
                                                            else -> {
                                                              val aVal = v5;
                                                              PS.Control.Bind.Module.bind
                                                                .app(
                                                                  PS.Effect.Module.bindEffect
                                                                )
                                                                .app(
                                                                  PS.Main.Module.getText
                                                                    .app(
                                                                      PS.Main.Module.getTextEditText
                                                                    )
                                                                    .app(b))
                                                                .app(
                                                                { v6 : Any ->
                                                                   when {
                                                                    else -> {
                                                                      val bVal = v6;
                                                                      { _ : Any ->
                                                                        PS.Data.Function.Module.apply
                                                                          .app(
                                                                            PS.Main.Module.setText
                                                                              .app(
                                                                                PS.Main.Module.setTextTextView
                                                                              )
                                                                              .app(
                                                                              res
                                                                            ))
                                                                          .app(
                                                                              (("result = " as String) + (((aVal as String) + (bVal as String)) as String))
                                                                            )()
                                                                          PS.Effect.Console.Module.log
                                                                            .app(
                                                                            "btn clicked!"
                                                                          )};
                                                                    }
                                                                  }
                                                                });
                                                            }
                                                          }
                                                        })
                                                    });
                                                }
                                              }
                                            });
                                        }
                                      }
                                    });
                                }
                              }
                            });
                        }
                      }
                    })}
            }))}
  };
}