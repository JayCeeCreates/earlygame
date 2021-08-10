(+) = Added | (*) = Improved | (-) = Removed

***

## 1.17.x-1.1.1
- (*) Fixed cobbled deepslate unable to be crafted (#30)

## 1.17.x-1.1.0
- (+) Added cobblestone and rock variants for the new stone blocks (deepslate, calcite, tuff)
- (*) Adjusted the height of stick block to prevent possible Z-fighting
- (*) Fixed a bug where you cannot mine modded blocks due to the changes in mining in 1.17 (#25)
- (*) Renamed all cobblestone variants to match the official naming convention (e.g. Cobbled Diorite)

## 1.17.x-1.0.3
EarlyGame has successfully been ported to 1.17!
- (+) All features from [1.16.x](https://github.com/JayCeeCreates/earlygame/blob/1.16/CHANGELOG.md) versions
- (*) Moved to Java 16
- (*) Recolored copper tools and armor to match vanilla textures
- (*) You can now mine regular copper ores at mining level 0 (i.e. wooden level)
- (-) Removed the modded copper ore generation to make way for the vanilla one
- (-) Yeeted the old AutoConfig and replaced with the new Cloth Config (with new embedded AutoConfig)
    - **NOTE**: Cloth Config is now a required dependency.