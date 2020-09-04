#!/bin/bash

echo -e "a\n*\nq\n" | git add -i
git commit -a -u -m "$MSG"
git push origin master
