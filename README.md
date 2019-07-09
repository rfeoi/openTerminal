# OpenTerminal [WIP]
#### An opensource API implementation of most used storage system minecraft mods
## What?
OpenTerminal is an implementation of the most used storage system mods. OpenTerminal aims to provide an easy to use API for other mods and an Web API for automating even outside minecraft.
## How?
Every of your system gets an unique ID and by entering this id in the (open) API or by authenticating to the Web API you can perform basic things, like see Items and start Autocrafting.
## Why?
We wanted to create an App to see your ME. (yes, pretty nerdy)
## Technical
### Which storage Mods are currently supported?
 - Applied Energistics 2 (WIP)
### What Mods do you plan to support?
 - Refined Storage
 - Logistic Pipes
### How can I use the API?
#### Inside code:
`IPluginStorage storage = de.rfeoi.openterminal.api.API.API.getStorage(your id here)`<br>
Now you have an instance of IPluginStorage (see src/main/de/rfeoi/openterminal/api/IPluginStorage for functions and documentation)
#### From the Web:
For further Infos look [in the README of the Web API](https://github.com/rfeoi/openterminal/src/de/rfeoi/openterminal/webApi/README.md).
### Can I contribute?
We are happy to accept pull requests.<br>
If you want to fix a bug: Fix it.<br>
If you want to implement a new Storage System create a Class implementing IPluginStorage
