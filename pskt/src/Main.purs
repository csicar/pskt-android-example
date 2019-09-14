module Main where

import Prelude

import Effect (Effect)
import Effect.Uncurried
import Effect.Console (log, logShow)
import Global (readFloat)
import Data.Int (floor)
import Unsafe.Coerce (unsafeCoerce)
import Android.Widget
import Android.IO
import Data.Tuple (Tuple(..))

main :: Context -> Effect Unit
main ctx = do
  log "in main"
  vl <- verticalLayout ctx

  tabView <- tabLayout ctx
  addTab tabView "Fetch HTML 1"
  addTab tabView "Test 2"
  vl `addView` tabView

  urlBar <- editText ctx "https://pursuit.purescript.org"
  vl `addView` urlBar

  log "1"
  btn <- button ctx "fetch"

  rv <- recyclerView ctx (["none yet"]) $ \ctx' -> do
    tv <- button ctx' "test"
    pure $ Tuple (toView tv) (\pos val -> setText tv ("from ps" <> show pos <> "has val " <> show val))
  vl `addView` rv
  log "2"
  addView vl btn
  contentScroll <- scrollView ctx
  vl `addView` contentScroll
  tv <- textView ctx "-"
  contentScroll `addView` tv
  log "3"
  addContentView ctx vl
  log "4"
  onClick btn ( do
    setText btn "loading..."
    url <- getText urlBar
    _ <- httpGet ctx url (\str -> do
        setText tv str
        setText btn "fetch"
        updateRecyclerView rv $ lines str
        log str)
    log "clicked!")
  log "5"

foreign import lines :: String -> Array String

