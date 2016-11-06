#!/bin/bash
  while(true)
  do
  curl -s http://catfacts-api.appspot.com/api/facts | jq -r '.facts' > kitty-kat.txt;
  git add kitty-kat.txt;
  echo "#MakeCodeGreatAgain" > message.txt
  cat kitty-kat.txt >> message.txt
  git commit -F  message.txt;
  git push origin master;
  sleep 5;
  done
