@file:Suppress("UNCHECKED_CAST")

package PS.Main
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val main = { ctx : Any ->
     /* defer **/{
      PS.Effect.Console.Module.log.app("in main").appRun();
      val v = PS.Android.Widget.Module.verticalLayout.app(ctx).appRun();
      val vl = v;
      val v1 = PS.Android.Widget.Module.tabLayout.app(ctx).appRun();
      val tabView = v1;
      PS.Android.Widget.Module.addTab.app(tabView).app("Test 1").appRun();
      PS.Android.Widget.Module.addTab.app(tabView).app("Test 2").appRun();
      PS.Android.Widget.Module.addView
        .app(PS.Android.Widget.Module.viewGroupVerticalLayout)
        .app(PS.Android.Widget.Module.tabLayoutView)
        .app(vl)
        .app(tabView)
        .appRun();
      val v2 = PS.Android.Widget.Module.editText.app(ctx)
                 .app("https://pursuit.purescript.org")
                 .appRun();
      val urlBar = v2;
      PS.Android.Widget.Module.addView
        .app(PS.Android.Widget.Module.viewGroupVerticalLayout)
        .app(PS.Android.Widget.Module.isViewEditText)
        .app(vl)
        .app(urlBar)
        .appRun();
      PS.Effect.Console.Module.log.app("1").appRun();
      val v3 = PS.Android.Widget.Module.button.app(ctx).app("fetch").appRun();
      val btn = v3;
      PS.Effect.Console.Module.log.app("2").appRun();
      PS.Android.Widget.Module.addView
        .app(PS.Android.Widget.Module.viewGroupVerticalLayout)
        .app(PS.Android.Widget.Module.buttonView)
        .app(vl)
        .app(btn)
        .appRun();
      val v4 = PS.Android.Widget.Module.scrollView.app(ctx).appRun();
      val contentScroll = v4;
      PS.Android.Widget.Module.addView
        .app(PS.Android.Widget.Module.viewGroupVerticalLayout)
        .app(PS.Android.Widget.Module.viewScrollView)
        .app(vl)
        .app(contentScroll)
        .appRun();
      val v5 = PS.Android.Widget.Module.textView.app(ctx).app("-").appRun();
      val tv = v5;
      PS.Android.Widget.Module.addView
        .app(PS.Android.Widget.Module.viewGroupScrollView)
        .app(PS.Android.Widget.Module.textViewView)
        .app(contentScroll)
        .app(tv)
        .appRun();
      PS.Effect.Console.Module.log.app("3").appRun();
      PS.Android.Widget.Module.addContentView
        .app(PS.Android.Widget.Module.layoutView)
        .app(ctx)
        .app(vl)
        .appRun();
      PS.Effect.Console.Module.log.app("4").appRun();
      PS.Android.Widget.Module.onClick.app(PS.Android.Widget.Module.buttonView)
        .app(btn)
        .app(/* defer **/{
            PS.Android.Widget.Module.setText
              .app(PS.Android.Widget.Module.isSetTextTextView
                     .app(PS.Android.Widget.Module.isTextViewButton))
              .app(btn)
              .app("loading...")
              .appRun();
            val v6 = PS.Android.Widget.Module.getText
                       .app(PS.Android.Widget.Module.isTextViewEditText)
                       .app(urlBar)
                       .appRun();
            val url = v6;
            val v7 = PS.Android.IO.Module.httpGet.app(ctx).app(url)
                       .app({ str : Any ->
                            /* defer **/{
                             PS.Android.Widget.Module.setText
                               .app(PS.Android.Widget.Module.isSetTextTextView
                                      .app(
                                   PS.Android.Widget.Module.isTextViewTextView))
                               .app(tv)
                               .app(str)
                               .appRun();
                             PS.Android.Widget.Module.setText
                               .app(PS.Android.Widget.Module.isSetTextTextView
                                      .app(
                                   PS.Android.Widget.Module.isTextViewButton))
                               .app(btn)
                               .app("fetch")
                               .appRun();
                             PS.Effect.Console.Module.log.app(str).appRun();
                           }
                         })
                       .appRun();
            PS.Effect.Console.Module.log.app("clicked!").appRun();
          })
        .appRun();
      PS.Effect.Console.Module.log.app("5").appRun();
    }
  };
}