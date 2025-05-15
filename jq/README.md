# jq

## Overview

Command line json processor

## Usage

Beautify json:

    cat json_file | jq

Show only the key of a json file

    cat json_file | jq 'map_values(keys)'