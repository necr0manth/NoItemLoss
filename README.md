# NoItemLoss

NoItemLoss preserves item entities dropped when a player dies, keeping them available for recovery instead of letting them disappear normally.

## How it works

- Marks player death-drop `ItemEntity` instances as invulnerable.
- Resets their age to prevent normal item despawning.
- Rescues protected drops that fall below the world's minimum Y level.
- Works automatically, with no configuration or commands.

The mod preserves dropped item entities in the world; it does not restore items directly to a player's inventory.

## Requirements

- Minecraft 26.2. The mod metadata accepts 26.2 versions up to, but not including, 26.3.
- Java 25.
- Architectury API 21.0.6 or newer.

| Platform | Loader | Kotlin runtime |
| --- | --- | --- |
| Fabric | Fabric Loader 0.19.3 or newer | Fabric Language Kotlin 1.13.9+kotlin.2.3.10 or newer |
| NeoForge | NeoForge 26.2.0.35-beta or newer | Kotlin for Forge 6.2 or newer |

## Installation

1. Install the required loader, Kotlin runtime, and Architectury API for your platform.
2. Build the project as described below.
3. Copy the platform-specific JAR from `fabric/build/libs/` or `neoforge/build/libs/` into your Minecraft instance's `mods` directory.

## Building

On Windows:

```powershell
.\gradlew.bat build
```

On Linux or macOS:

```sh
./gradlew build
```

The platform JARs are written to:

- `fabric/build/libs/noitemloss-fabric-1.0.jar`
- `neoforge/build/libs/noitemloss-neoforge-1.0.jar`

## License

All Rights Reserved.
