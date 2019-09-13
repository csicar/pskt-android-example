@file:Suppress("UNCHECKED_CAST")

package PS.Android.Widget
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  val __addContentView = Foreign.Android.Widget.__addContentView;
  val __textView = Foreign.Android.Widget.__textView;
  val __button = Foreign.Android.Widget.__button;
  val __editText = Foreign.Android.Widget.__editText;
  val __onClick = Foreign.Android.Widget.__onClick;
  val __addView = Foreign.Android.Widget.__addView;
  val __verticalLayout = Foreign.Android.Widget.__verticalLayout;
  val __scrollView = Foreign.Android.Widget.__scrollView;
  val __tabLayout = Foreign.Android.Widget.__tabLayout;
  val __addTab = Foreign.Android.Widget.__addTab;
  val __getText = Foreign.Android.Widget.__getText;
  val __setTextTextView = Foreign.Android.Widget.__setTextTextView;
  @JvmField
  val IsViewGroup = { toViewGroup : Any ->
     mapOf(("toViewGroup" to toViewGroup))
  };
  @JvmField val IsView = { toView : Any -> mapOf(("toView" to toView))};
  @JvmField
  val IsTextView = { toTextView : Any ->
     mapOf(("toTextView" to toTextView))
  };
  @JvmField val IsSetText = { setText : Any -> mapOf(("setText" to setText))};
  @JvmField
  val viewScrollView = PS.Android.Widget.Module.IsView
                         .app(PS.Unsafe.Coerce.Module.unsafeCoerce);
  @JvmField
  val viewGroupVerticalLayout = PS.Android.Widget.Module.IsViewGroup
                                  .app(PS.Unsafe.Coerce.Module.unsafeCoerce);
  @JvmField
  val viewGroupScrollView = PS.Android.Widget.Module.IsViewGroup
                              .app(PS.Unsafe.Coerce.Module.unsafeCoerce);
  @JvmField
  val verticalLayout = PS.Effect.Uncurried.Module.runEffectFn1
                         .app(PS.Android.Widget.Module.__verticalLayout);
  @JvmField
  val toViewGroup = { dict : Any ->
     (dict as Map<String, Any>)["toViewGroup"]!!
  };
  @JvmField
  val toView = { dict : Any ->
     (dict as Map<String, Any>)["toView"]!!
  };
  @JvmField
  val toTextView = { dict : Any ->
     (dict as Map<String, Any>)["toTextView"]!!
  };
  @JvmField
  val textViewView = PS.Android.Widget.Module.IsView
                       .app(PS.Unsafe.Coerce.Module.unsafeCoerce);
  @JvmField
  val textView = PS.Effect.Uncurried.Module.runEffectFn2
                   .app(PS.Android.Widget.Module.__textView);
  @JvmField
  val tabLayoutView = PS.Android.Widget.Module.IsView
                        .app(PS.Unsafe.Coerce.Module.unsafeCoerce);
  @JvmField
  val tabLayout = PS.Effect.Uncurried.Module.runEffectFn1
                    .app(PS.Android.Widget.Module.__tabLayout);
  @JvmField
  val setText = { dict : Any ->
     (dict as Map<String, Any>)["setText"]!!
  };
  @JvmField
  val scrollView = PS.Effect.Uncurried.Module.runEffectFn1
                     .app(PS.Android.Widget.Module.__scrollView);
  @JvmField
  val onClick = { dictIsView : Any ->
     { a : Any ->
       PS.Effect.Uncurried.Module.runEffectFn2
         .app(PS.Android.Widget.Module.__onClick)
         .app(PS.Android.Widget.Module.toView.app(dictIsView).app(a))
    }
  };
  @JvmField
  val layoutView = PS.Android.Widget.Module.IsView
                     .app(PS.Unsafe.Coerce.Module.unsafeCoerce);
  @JvmField
  val isViewEditText = PS.Android.Widget.Module.IsView
                         .app(PS.Unsafe.Coerce.Module.unsafeCoerce);
  @JvmField
  val isTextViewTextView = PS.Android.Widget.Module.IsTextView
                             .app(PS.Control.Category.Module.identity
                                    .app(PS.Control.Category.Module.categoryFn)
  );
  @JvmField
  val isTextViewEditText = PS.Android.Widget.Module.IsTextView
                             .app(PS.Unsafe.Coerce.Module.unsafeCoerce);
  @JvmField
  val isTextViewButton = PS.Android.Widget.Module.IsTextView
                           .app(PS.Unsafe.Coerce.Module.unsafeCoerce);
  @JvmField
  val isSetTextTextView = { dictIsTextView : Any ->
     PS.Android.Widget.Module.IsSetText
       .app({ a : Any ->
         PS.Effect.Uncurried.Module.runEffectFn2
           .app(PS.Android.Widget.Module.__setTextTextView)
           .app(PS.Android.Widget.Module.toTextView.app(dictIsTextView).app(a))
      })
  };
  @JvmField
  val getText = { dictIsTextView : Any ->
     { tv : Any ->
       PS.Effect.Uncurried.Module.runEffectFn1
         .app(PS.Android.Widget.Module.__getText)
         .app(PS.Android.Widget.Module.toTextView.app(dictIsTextView).app(tv))
    }
  };
  @JvmField
  val editText = PS.Effect.Uncurried.Module.runEffectFn2
                   .app(PS.Android.Widget.Module.__editText);
  @JvmField
  val buttonView = PS.Android.Widget.Module.IsView
                     .app(PS.Unsafe.Coerce.Module.unsafeCoerce);
  @JvmField
  val button = PS.Effect.Uncurried.Module.runEffectFn2
                 .app(PS.Android.Widget.Module.__button);
  @JvmField
  val addView = { dictIsViewGroup : Any ->
     { dictIsView : Any ->
       { vg : Any ->
         { v : Any ->
           PS.Effect.Uncurried.Module.runEffectFn2
             .app(PS.Android.Widget.Module.__addView)
             .app(PS.Android.Widget.Module.toViewGroup.app(dictIsViewGroup)
                    .app(vg))
             .app(PS.Android.Widget.Module.toView.app(dictIsView).app(v))
        }
      }
    }
  };
  @JvmField
  val addTab = PS.Effect.Uncurried.Module.runEffectFn2
                 .app(PS.Android.Widget.Module.__addTab);
  @JvmField
  val addContentView = { dictIsView : Any ->
     { a : Any ->
       { b : Any ->
         PS.Effect.Uncurried.Module.runEffectFn2
           .app(PS.Android.Widget.Module.__addContentView)
           .app(a)
           .app(PS.Android.Widget.Module.toView.app(dictIsView).app(b))
      }
    }
  };
}