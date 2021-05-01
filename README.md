# VaultX

Example Implementation Project: [Click to open](https://github.com/Mooon1/sh99-example-vaultx)

## Installing

Just drop the VaultX.jar file into your plugins-directoy on your server and reload. Done.

## What is Vault without X?

Vault is an abstraction library for bukkit which provides some interfaces for 
developers and plugins to unit the way of handling Chat, Permission and Economy. 
The original developer of [Vault](https://github.com/MilkBowl/Vault) and [VaultAPI](https://github.com/MilkBowl/VaultAPI) 
set a significant milestone in bukkit development history so without his basic idea of this abstraction
this repository would not exist.

## What makes VaultX so special?

So even you want to create a plugin based on vault its probably impossible to register it to vault without sending a message to the original author of it. 
This means you build a class which implements an interface and store it directly in the plugin itself so the plugin grows for each new registered 
vault-plugin on the market.

So VaultX give you the ability to hook your plugin right into or get the expected service from it without knowing exacly which plugin you use. 
It just will give you an instance and the VaultX interface so you can simply work on it.

## Does VaultX care about compatibility to Vault as old plugins do not use VaultX?

Currently it is not supported and not compatible any way. When you want to increase your flexibility by adding plugins for Economy, Chat or Permission you should use VaultX.

## Create your own Economy, Chat or Permission Plugin? [Click to open](https://github.com/Mooon1/sh99-example-vaultx/tree/master/CUSTOM_ECONOMY/src/de/sh99/custom_economy)

Just add VaultX as a dependency to your plugin and provide it will be on the server. You implement the Chat, Economy or Permission interface which is an 
Environment interface also to your JavaPlugin class and register it to VaultX. After that you just create your provider classes and attach it to 
your JavaPlugin‘s method declaredProvider() which comes from the interface you attach

## Want to create a plugin which needs basic functions provided by another plugin depending on VaultX? [Click to open](https://github.com/Mooon1/sh99-example-vaultx/tree/master/NEEDS_EXISTING_ECONOMY/src/de/sh99/need_existing_economy)

So just implement VaultX as dependency again also as provided on server and just call VaultX.getRuntimeInstance(); than you can just access 
VaultX.getEnvironmental(Economy.class) in example, so you would get the current acivated Economy envrionment where you can get the Provider 
and Balance-/BankManager.


## License

License
Copyright (C) 2020-2020 Sh99 Development Team contact@sh99.de.

VaultX is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

VaultX is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public License along with Vault. If not, see http://www.gnu.org/licenses/.