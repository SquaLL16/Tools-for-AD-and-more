# foundry

## Overview

Foundry consists of:

	Forge: Ethereum testing framework (like Truffle, Hardhat and DappTools).
	Cast: Swiss army knife for interacting with EVM smart: contracts, sending transactions and getting chain data.
	Anvil: Local Ethereum node, akin to Ganache, Hardhat Network.
	Chisel: Fast, utilitarian, and verbose solidity REPL.

## Installation

Install foundryup:

	curl -L https://foundry.paradigm.xyz | bash

Follow instructions on screen and then do:

	foundryup


https://book.getfoundry.sh/getting-started/installation


## Usage

Use forge init to start a project and put the code of the contracts in the /src dir.

You can also add your own contracts by doing:

	forge create src/Solve.sol:Solve --rpc-url "http://83.136.252.57:55282/rpc" --private-key "0x4e62854c5c2a9c9b7cfc18d9f8f4500bbfd40ed4973bb0c440cd73201233cd52" --constructor-args "0xBe622bA5010AF4ce7aCc67dfB42c2556826c4D59"

After the contract is deployed you can call methods from the contract like:

	cast send 0x8F27BC9B5EfbfC230960709A147Cc6a75b29d599 "attack(uint256)" 1000 --rpc-url "http://94.237.49.212:42164/rpc" --private-key "0x1703b62ef3cf035f9e062601006f7a1aa3187a6f2e7d06a346ac8041db63910c"

## More Info

https://github.com/Andre92Marcos/blockchain/blob/main/solidity.md