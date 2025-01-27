#!/bin/bash
jq --argjson sample "$(cat sample.json)" '.outerKey.innerKey |= (. + $sample)' base.json > output.json
