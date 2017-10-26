#!/bin/bash

# recursively count words in .tex files

CNT=0

my_ls() {
  # save current directory then cd to "$1"
  pushd "$1" >/dev/null

  for file in * ; do
    if [[ -d "$file" ]]; then
      # recursively look for more tex files
      my_ls "$file"
    elif [[ "${file:${#file}-4}" == ".tex" ]]; then
      # add word count of tex files
      ((CNT=CNT+$(texcount "$file" | grep 'Words in text: ' | cut -d ' ' -f 4)
))
    fi
  done

  # restore directory
  popd >/dev/null
}

my_ls "$1"

echo "Word count: $CNT"