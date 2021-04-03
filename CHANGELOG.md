(+) = Added | (*) = Improved | (-) = Removed

***

## 1.16.x-1.0.2
- (+) You can now get plant fiber from ferns
- (*) Compatibility with sticks from ATBYW (#17)
- (*) Fixed server crash when removing plank recipes (#19)
- (*) Compatibility with Smithee (#20)

## 1.16.x-1.0.1
- (*) Fixed sandstone rock blocks not dropping upon break (woops)

## 1.16.x-1.0.0
EarlyGame is now a stable release!
- (+) Added fire starter, success chance is configurable
- (+) Slingshots are added, lesser range than bow
- (+) You can get a flint shard by using a knife (#8)
- (+) Tall grass can now drop two plant fibers with same chance (#10)
- (*) Relicensed to MIT (hooray!)
- (*) Fixed recipes not unlocking
- (*) Revamped recipe remover to only remove plank recipes if an ingredient is a log
- (*) Fixed Bits and Chisels incompatibility (#7)
- (*) Fixed wood chopping event incompatibility with modded tools (#9)
- (*) Configuration is now defined in common side (#11, #12)
- (*) Copper ore generation can now be disabled (#14)

## 1.16.x-1.1.1b
- (*) Retextured copper ore and reverted copper textures per request (Discord)
- (*) Along with that, flint shard is also slightly retextured

## 1.16.x-1.1.0b
- (+) You can now craft a furnace with other cobblestone variants
- (+) Added flint saw to Fabric tooltag database (#6)
- (+) Implemented modified and configurable recipe remover (by [Choonster@github](https://bit.ly/2BLB9t3))
    - **NOTE**: This may present incompatibility with some datapacks and mods.
- (+) Added flint to dirt loot table (#6)
- (*) Adjusted probability of getting plant fiber to better balance the span of flint knife (CF, #6)
- (*) Adjusted the mining speed of slow digging blocks (#6)
- (*) Changed wood chopping event to ensure compatibility with other mods that add more wood
- (*) Treatment of Charm incompatibility with "temporary" fix (#5)
- (-) Removed WoodTypes.java

## 1.16.x-1.0.1b
- (+) Added four-sided wood variants on wood chopping event (I forgot soz)
- (*) You can now only chop wood by clicking the top of the block (I found out that it was too OP)
- (*) Fixed the knapping event so that you cannot knap on rocks

## 1.16.x-1.0.0b
Initial beta release
- (+) Implemented wood chopping
- (+) Damage mechanic is implemented on wood and stone punching
- (+) Added configuration
- (+) Multiplayer compatibility (thanks, Bonono63!)
- (*) Fixed flint knapping event
- (*) Fixed the mining mechanics for sticks and rocks
- (*) Changed copper textures to match the official ones
- (*) Changed copper armor durability
- (*) Moved copper blocks and minerals to common tag for intercompatibility (thanks, Shnupbups!)
- (-) Removed planks and sticks crafting recipe

## 1.16.3-1.0.0a (09.29.2020)
Initial alpha release