@file:Suppress("UNCHECKED_CAST")

package PS.Main
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  val lines = Foreign.Main.lines;
  @JvmField
  val main = { ctx : Any ->
     /* defer **/{
      PS.Effect.Console.Module.log.app("in main").appRun();
      val v = PS.Android.Widget.Module.verticalLayout.app(ctx).appRun();
      val vl = v;
      val v1 = PS.Android.Widget.Module.tabLayout.app(ctx).appRun();
      val tabView = v1;
      PS.Android.Widget.Module.addTab.app(tabView).app("Fetch HTML 1").appRun();
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
      val v4 = PS.Data.Function.Module.apply
                 .app(PS.Android.Widget.Module.recyclerView.app(ctx)
                        .app(listOf("none yet")))
                 .app({ ctx_tick : Any ->
                      /* defer **/{
                       val v4 = PS.Android.Widget.Module.button.app(ctx_tick)
                                  .app("test")
                                  .appRun();
                       val tv = v4;
                       PS.Data.Function.Module.apply
                         .app(PS.Control.Applicative.Module.pure
                                .app(PS.Effect.Module.applicativeEffect))
                         .app(PS.Data.Tuple.Module.Tuple
                                .app(PS.Android.Widget.Module.toView
                                       .app(PS.Android.Widget.Module.buttonView)
                                       .app(tv))
                                .app({ pos : Any ->
                                { _val : Any ->
                                  PS.Android.Widget.Module.setText
                                    .app(
                                      PS.Android.Widget.Module.isSetTextTextView
                                        .app(
                                        PS.Android.Widget.Module.isTextViewButton
                                      ))
                                    .app(tv)
                                    .app(
                                   (("from ps" as String) + (((PS.Data.Show.Module.show
                                                                 .app(
                                                                   PS.Data.Show.Module.showInt
                                                                 )
                                                                 .app(pos
                                   ) as String) + ((("has val " as String) + (PS.Data.Show.Module.show
                                                                                .app(
                                                                                  PS.Data.Show.Module.showString
                                                                                )
                                                                                .app(
                                     _val) as String)) as String)) as String)))
                               }
                             }))
                         .appRun();
                     }
                   })
                 .appRun();
      val rv = v4;
      PS.Android.Widget.Module.addView
        .app(PS.Android.Widget.Module.viewGroupVerticalLayout)
        .app(PS.Android.Widget.Module.isViewRecyclerView)
        .app(vl)
        .app(rv)
        .appRun();
      PS.Effect.Console.Module.log.app("2").appRun();
      PS.Android.Widget.Module.addView
        .app(PS.Android.Widget.Module.viewGroupVerticalLayout)
        .app(PS.Android.Widget.Module.buttonView)
        .app(vl)
        .app(btn)
        .appRun();
      val v5 = PS.Android.Widget.Module.scrollView.app(ctx).appRun();
      val contentScroll = v5;
      PS.Android.Widget.Module.addView
        .app(PS.Android.Widget.Module.viewGroupVerticalLayout)
        .app(PS.Android.Widget.Module.viewScrollView)
        .app(vl)
        .app(contentScroll)
        .appRun();
      val v6 = PS.Android.Widget.Module.textView.app(ctx).app("-").appRun();
      val tv = v6;
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
            val v7 = PS.Android.Widget.Module.getText
                       .app(PS.Android.Widget.Module.isTextViewEditText)
                       .app(urlBar)
                       .appRun();
            val url = v7;
            val v8 = PS.Android.IO.Module.httpGet.app(ctx).app(url)
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
                             PS.Data.Function.Module.apply
                               .app(PS.Android.Widget.Module.updateRecyclerView
                                      .app(rv))
                               .app(PS.Main.Module.lines.app(str))
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