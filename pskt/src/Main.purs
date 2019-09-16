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
import Android.Content
import Data.Function.Uncurried
import Data.Maybe
import Data.Array
import Data.Tuple (Tuple(..))

main :: Context -> Effect Unit
main ctx = do
  log "in main"
  vl <- verticalLayout ctx

  tabView <- tabLayout ctx
  addTab tabView "Pursuit Search"
  addTab tabView "Tab Test"
  vl `addView` tabView

  urlBar <- editText ctx "map"
  vl `addView` urlBar

  log "1"
  btn <- button ctx "fetch"

  
  log "2"
  addView vl btn
  contentScroll <- scrollView ctx
  vl `addView` contentScroll

  rv <- recyclerView ctx [] $ \ctx' -> do
    nameView <- textView ctx' ""
    setTextSize nameView 24.0
    tyView <- textView ctx' ""
    packageIcon <- imageView ctx' 0
    row <- verticalLayout ctx'
    row `addView` nameView
    row `addView` tyView
    bottomColumn <- horizonalLayout ctx'
    row `addView` bottomColumn
    modNameView <- textView ctx' ""
    bottomColumn `addView` packageIcon
    bottomColumn `addView` modNameView


    pure $ Tuple (toView row) $ \pos (Result {name, modName, descr, url}) -> do
        setText nameView (show name)
        setText tyView (show descr)
        setText modNameView (show modName)
        onClick nameView $ do
            intent <- intentUrl url
            startIntent ctx intent


  contentScroll `addView` rv
  log "3"
  addContentView ctx vl
  log "4"
  onClick btn ( do
    setText btn "loading..."
    url <- getText urlBar
    _ <- httpGet ctx (searchUrlFor url) (\str -> do
        setText btn "fetch"
        updateRecyclerView rv $ resultsFromPage str
        log str)
    log "clicked!")
  log "5"

searchUrlFor :: String -> String
searchUrlFor query = "https://pursuit.purescript.org/search?q=" <> query

resultsFromPage :: String -> Array Result
resultsFromPage txt = resultFromPage  <$> (html `select` ".result" ) `zip` ((html `select` ".result__body") `zip` (html `select` ".result__actions"))
  where
    html = parseHtml txt

resultFromPage :: Tuple Element (Tuple Element Element) -> Result
resultFromPage (Tuple title (Tuple body actions)) = Result 
  { name: (textContent title)
  , descr: (textContent body)
  , url : (fromMaybe "" $ head $ attr "href" <$> title `select` ".result__link")
  , modName : textContent actions
  }

data Result = Result {name :: String, url :: String, descr :: String, modName :: String}

foreign import data Element :: Type
foreign import parseHtml :: String -> Element

foreign import _htmlSelect :: Fn2 Element String (Array Element)
select = runFn2 _htmlSelect

foreign import textContent :: Element -> String

foreign import _nextSibling :: Fn3 Element (Element -> Maybe Element) (Maybe Element) (Maybe Element)
nextSibling el = runFn3 _nextSibling el Just Nothing

foreign import _attr :: Fn2 String Element String
attr = runFn2 _attr