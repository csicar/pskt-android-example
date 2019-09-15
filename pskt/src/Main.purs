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

  urlBar <- editText ctx "Applicative"
  vl `addView` urlBar

  log "1"
  btn <- button ctx "fetch"

  
  log "2"
  addView vl btn
  contentScroll <- scrollView ctx
  vl `addView` contentScroll

  rv <- recyclerView ctx ([]) $ \ctx' -> do
    tv <- textView ctx' ""
    pure $ Tuple (toView tv) (\pos (Result name modName url) -> setText tv (show name <> "link: " <> show url))
  contentScroll `addView` rv
  log "3"
  addContentView ctx vl
  log "4"
  onClick btn ( do
    setText btn "loading..."
    url <- getText urlBar
    _ <- httpGet ctx (searchUrlFor url) (\str -> do
        setText btn "fetch"
        updateRecyclerView rv $ parseHtml str Result
        log str)
    log "clicked!")
  log "5"

searchUrlFor :: String -> String
searchUrlFor query = "https://pursuit.purescript.org/search?q=" <> query

data Result = Result String String String

foreign import parseHtml :: String -> (String -> String -> String -> Result) -> Array Result